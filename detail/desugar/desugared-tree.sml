
structure DesugaredTree = struct
   structure Exp = Core.Exp
   structure Pat = Core.Pattern
   type sym = Core.sym

   structure DecodePattern = struct
      datatype t =
         BITSTR of string
       | BIND of sym * int
   end

   structure Decode = struct
      datatype t =
         TOP of tokpat list * guarded
       | NAMED of sym * tokpat list * guarded
      withtype tokpat = DecodePattern.t list
      and guarded = (Exp.t, (Exp.t * Exp.t) list) Sum.t
   end

   structure Decl = struct
      datatype t =
         REC of Core.Exp.decl
       | VAL of Core.Exp.decl
   end

   structure IRSpec = struct
      type t = (Decl.t list * Decode.t list) Spec.t
   end

   structure P = DecodePattern
   structure D = Decode

   (** Returns the size in bits of the given pattern `pat` *)
   fun size pat =
      case pat of
         P.BITSTR str => String.size str
       | P.BIND (_, i) => i

   fun toWildcardPattern tokpat = let
      fun lp (pats, acc) =
         case pats of
            [] => acc
          | p::ps =>
               case p of
                  P.BITSTR str => lp (ps, acc^str)
                | P.BIND (_, i) =>
                     lp (ps,
                         acc^String.implode (List.tabulate (i, fn _ => #".")))
   in
      lp (tokpat, "")
   end

   fun toVec xs = VectorSlice.full (Vector.fromList xs)

   fun grabToplevel decls = let
      open D
      fun lp (decls, acc) =
         case decls of
            [] => rev acc
          | (TOP (toks, e))::ds => lp (ds, (toVec toks, e)::acc)
          | d::ds => lp (ds, acc)
   in
      toVec (lp (decls, []))
   end

   structure FromAST = struct
      structure CM = CompilationMonad
      open SpecAbstractTree

      fun valuedecl decl =
         case decl of
            MARKvaluedecl t => valuedecl (#tree t)
          | LETvaluedecl (n, ns, e) => Decl.VAL (n, ns, exp e) 
          | LETRECvaluedecl (n, ns, e) => Decl.REC (n, ns, exp e)

      and vdecl decl =
         case decl of
            MARKvaluedecl t => vdecl (#tree t)
          | LETvaluedecl (n, ns, e) => (n, ns, exp e) 
          | LETRECvaluedecl (n, ns, e) => (n, ns, exp e)

      and exp e = 
         case e of
            MARKexp t => exp (#tree t)
          | LETexp (vs, e) => Exp.LET (map vdecl vs, exp e)
          | IFexp (iff, thenn, elsee) => Exp.IF (exp iff, exp thenn, exp elsee)
          | CASEexp (e, cases) => Exp.CASE (exp e, map match cases)
          | ANDALSOexp (l, r) => raise CM.CompilationError
          | ORELSEexp (l, r) => raise CM.CompilationError
          | BINARYexp (l, binop, r) =>
               Exp.APP
                  (Exp.APP
                     (Exp.ID binop,
                      exp l),
                   exp r)
          | APPLYexp (e1, e2) => Exp.APP (exp e1, exp e2)
          | RECORDexp fs => Exp.RECORD (fields fs)
          | SELECTexp f => Exp.SELECT f
          | UPDATEexp fs => Exp.UPDATE (fields fs)
          | LITexp l => Exp.LIT l
          | CONexp c => Exp.CON c
          | SEQexp seq => Exp.SEQ (map seqexp seq)
          | IDexp id => Exp.ID id
          | FNexp _ => raise CM.CompilationError

      and fields fs = map (fn (f, e) => (f, exp e)) fs

      and match m = 
         case m of
            MARKmatch t => match (#tree t)
          | CASEmatch (p, e) => (pat p, exp e)

      and pat p =
         case p of
            MARKpat t => pat (#tree t)
          | CONpat (s, p) => Pat.CON (s, Option.map pat p)
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
      structure T = SpecAbstractTree
      open Layout Pretty Sum D P Decl
      fun dec t = 
         case t of
            TOP (pats, guarded) =>
                T.PP.def
                  (seq [str "DECODE", space, list (map tokpat pats)],
                   seq [str "[",
                        guardedexp guarded,
                        str "]"])
          | NAMED (name, pats, e) =>
               T.PP.def
                  (seq [str "DECODE", space, T.PP.var_bind name, space,
                        list (map tokpat pats)],
                   guardedexp e)
      and guardedexp e =
       case e of
          INL e => exp e
        | INR es => alignPrefix (map guard es, "|")
      and guard (g, e) = seq [exp g, space, str "=", space, exp e]
      and exp e = Core.PP.layout e
      and tokpat pats = listex "'" "'" " " (map pat pats)
      and pat t =
         case t of
            BITSTR bits => str bits
          | BIND (n, i) =>
                seq [T.PP.var_use n, str ":", str (Int.toString i)]
      and decl d =
         case d of
            REC d => Core.PP.recdecl d
          | VAL d => Core.PP.decl d
      fun prettyTo (os, t) =
         Spec.PP.prettyTo 
            (fn (vs, ds) => align (map decl vs@map dec ds))
            (os, t)
   end
end
