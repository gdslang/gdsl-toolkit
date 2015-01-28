
structure DesugaredTree = struct

   exception DesugarTreeException of (Error.span * string)
   
   structure Exp = Core.Exp
   type sym = Core.sym

   structure Pat = struct
      datatype t =
         VEC of Error.span * string
       | BND of Error.span * sym * string
   end

   type value = Exp.decl
   type toksize = int
   type decode = Pat.t list list * toksize * Exp.t
   type spec = (value list * decode list SymMap.map) Spec.t

   val slice = Atom.atom "slice"
   val scrutinee = Atom.atom "scrutinee"

   (** Returns the size in bits of the given pattern `pat` *)
   fun size pat =
      case pat of
         Pat.VEC (_, str) => String.size str
       | Pat.BND (_, _, str) =>
         case String.fields (fn c => c = #"|") str of
            p::_ => String.size p
          | _ => raise Fail "DesugaredTree.size.bug"

   fun toWildcardPattern tokpat = let
      fun lp (pats, acc) =
         case pats of
            [] => String.concatWith "|" acc
          | p::ps =>
               case p of
                  Pat.VEC (_, str) => lp (ps, map (fn a => a^str) acc)
                | Pat.BND (_, _, str) =>
                     case String.tokens (fn c => c = #"|") str of
                        bs =>
                           lp (ps,
                               List.concat
                                 (map (fn a => map (fn b => a^b) bs) acc))
   in
      lp (tokpat, [""])
   end

   fun toVec xs = VectorSlice.full (Vector.fromList xs)

   fun sliceExp (tok, offs, sz) = let
      open Exp
      fun INT i = LIT (SpecAbstractTree.INTlit (IntInf.fromInt i))
      val slice =
         ID
            (VarInfo.lookup
               (!SymbolTables.varTable, slice))
   in
      APP (slice, [ID tok, INT offs, INT sz])
   end

   structure FromAST = struct
      structure CM = CompilationMonad
      structure Pat = Core.Pat
      open SpecAbstractTree

      fun recdecl (n, ns, e) = (n, ns, exp e)

      and exp e = 
         case e of
            MARKexp t => exp (#tree t)
          | LETRECexp (vs, e) => Exp.LETREC (map recdecl vs, exp e)
          | IFexp (iff, thenn, elsee) => Exp.IF (exp iff, exp thenn, exp elsee)
          | CASEexp (e, cases) =>
            let
               val (trans,scrut) = tovar (exp e)
            in
               trans (Exp.CASE (Exp.ID scrut, map (match scrut) cases))
            end
          | BINARYexp (l, i, r) => Exp.APP (infixop i, [exp l, exp r])
          | APPLYexp (e1, es) => Exp.APP (exp e1, map exp es)
          | RECORDexp fs => Exp.RECORD (fields fs)
          | SELECTexp f => Exp.SELECT f
          | UPDATEexp fs => Exp.UPDATE (fieldsOpt fs)
          | LITexp l => Exp.LIT l
          | CONexp c => Exp.CON c
          | SEQexp seq => Exp.SEQ (map seqexp seq)
          | IDexp id => Exp.ID id
          | FNexp _ => raise CM.CompilationError
      
      and tovar (Exp.ID id) = (fn e => e, id)
        | tovar e =
         let
            val (st,scrutVar) = VarInfo.fresh (!SymbolTables.varTable, scrutinee)
            val _ = SymbolTables.varTable := st
         in
            (fn eWrap => Exp.LETVAL (scrutVar, e, eWrap), scrutVar)
         end

      and infixop e =
         case e of
            MARKinfixop t => infixop (#tree t)
          | OPinfixop binop => Exp.ID binop

      and fields fs = map (fn (f, e) => (f, exp e)) fs
      
      and fieldsOpt fs =
         let
            fun mapUpdates ((f, SOME e) :: fes) = (f, exp e) :: mapUpdates fes
              | mapUpdates ((f, NONE) :: fes) = mapUpdates fes
              | mapUpdates [] = []
         in
            mapUpdates fs
         end

      and match scrut (p, e) = (pat (SymbolTable.noSpan,scrut) p (exp e))

      and stripMarkPat sp p =
         case p of
            MARKpat t => stripMarkPat (#span t) (#tree t)
          | p => (sp,p)

      and pat (sp,scrut) p e =
         case p of
            MARKpat t => pat (#span t,scrut) (#tree t) e
          | CONpat (s, SOME p) =>
               let
                  val (sp,p) = stripMarkPat sp p
               in
                  case p of
                     IDpat x => (sp, Pat.CON (s, SOME x), e)
                   | _ => raise DesugarTreeException
                     (sp, "expect variable as argument in constructor pattern")
               end
          | CONpat (s, NONE) => (sp, Pat.CON (s, NONE), e)
          | INTpat i => (sp, Pat.INT i, e)
          | BITpat bp => 
            let
               val (pats,pos,e) = foldr (bitpat (sp,scrut)) ([""],0,e) bp
               fun conc [s] = s
                 | conc (s :: ss) = s ^ "|" ^ conc ss
                 | conc [] = ""
            in
               (sp, Pat.BIT (conc pats), e)
            end
          | IDpat id => (sp, Pat.ID id,e)
          | WILDpat => (sp, Pat.WILD,e)

      and bitpat (sp,scrut) (MARKbitpat t,info) = bitpat (#span t,scrut) (#tree t,info)
        | bitpat (sp,scrut) (BITSTRbitpat lit,(pats,pos,e)) =
         let
            val fields = String.fields (fn c => c= #"|") lit
            val size = case fields of [] => 0 | (f::_) => String.size f
            val pats' = List.concat (map (fn p => map (fn f => f ^ p) fields) pats)
         in
            (pats', pos+size, e)
         end 
        | bitpat (sp,scrut) (NAMEDbitpat _,(pats,pos,e)) = raise DesugarTreeException
           (sp, "cannot use a sub-decoder in pattern match")
        | bitpat (sp,scrut) (BITVECbitpat (var,lit),(pats,pos,e)) =
         let
            val (pats',pos',e') = bitpat (sp,scrut) (BITSTRbitpat lit,(pats,pos,e))
         in
            (pats',pos',Exp.LETVAL (var,sliceExp (scrut,pos,pos'-pos),e'))
         end

      and seqexp s = 
         case s of
            MARKseqexp t => seqexp (#tree t)
          | ACTIONseqexp e => Exp.ACTION (exp e)
          | BINDseqexp (n, e) => Exp.BIND (n, exp e)

   end

   structure PP = struct
      open Layout Pretty Sum

      val var = Core.PP.var
      val exp = Core.PP.layout

      fun declarations (vs, ds) =
         align
            [align (map Core.PP.recdecl vs),
             align (decs ds)]

      and decs ds =
         List.map
            (fn (n, ds) => align (map (fn d => dec (n, d)) ds))
            (SymMap.listItemsi ds)

      and dec (n, (ps, size, e)) =
         align
            [seq
               [str "val", space, var n,
                list (map tokpat ps), str (Int.toString size), space, str "="],
             indent 3 (exp e)]

      and tokpat pats = listex "'" "'" " " (map pat pats)
      and pat t =
         case t of
            Pat.VEC (_, bits) => str bits
          | Pat.BND (_, n, pat) => seq [var n, str ":", str pat]

      val spec = Spec.PP.spec declarations
   end
end
