
structure DesugaredTree = struct

   structure Exp = Core.Exp
   type sym = Core.sym

   structure Pat = struct
      datatype t =
         VEC of string
       | BND of sym * string
   end

   type value = Exp.decl
   type decode = Pat.t list list * Exp.t
   type spec = (value list * decode list SymMap.map) Spec.t

   (** Returns the size in bits of the given pattern `pat` *)
   fun size pat =
      case pat of
         Pat.VEC str => String.size str
       | Pat.BND (_, str) =>
         case String.fields (fn c => c = #"|") str of
            p::_ => String.size p
          | _ => raise Fail "DesugaredTree.size.bug"

   fun toWildcardPattern tokpat = let
      fun lp (pats, acc) =
         case pats of
            [] => String.concatWith "|" acc
          | p::ps =>
               case p of
                  Pat.VEC str => lp (ps, map (fn a => a^str) acc)
                | Pat.BND (_, str) =>
                     case String.tokens (fn c => c = #"|") str of
                        bs =>
                           lp (ps,
                               List.concat
                                 (map (fn a => map (fn b => a^b) bs) acc))
   in
      lp (tokpat, [""])
   end

   fun toVec xs = VectorSlice.full (Vector.fromList xs)

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
          | CASEexp (e, cases) => Exp.CASE (exp e, map match cases)
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

      and match (p, e) = (pat p, exp e)

      and stripMarkPat p =
         case p of
            MARKpat t => stripMarkPat (#tree t)
          | p => p

      and pat p =
         case p of
            MARKpat t => pat (#tree t)
          | CONpat (s, SOME p) =>
               let
                  val p = stripMarkPat p
               in
                  case p of
                     IDpat x => Pat.CON (s, SOME x)
                   | _ => raise Fail "Invalid pattern (too complex...)"
               end
          | CONpat (s, NONE) => Pat.CON (s, NONE)
          | LITpat (INTlit i) => Pat.INT i
          | LITpat (VEClit i) => Pat.BIT i
          | LITpat _ => raise CM.CompilationError
          | IDpat id => Pat.ID id
          | WILDpat => Pat.WILD

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

      and dec (n, (ps, e)) =
         align
            [seq
               [str "val", space, var n,
                list (map tokpat ps), space, str "="],
             indent 3 (exp e)]

      and tokpat pats = listex "'" "'" " " (map pat pats)
      and pat t =
         case t of
            Pat.VEC bits => str bits
          | Pat.BND (n, pat) => seq [var n, str ":", str pat]

      val spec = Spec.PP.spec declarations
   end
end
