(**
 * ## CPS style intermediate representation
 *
 * see:
 *   - Compiling with Continuations, Continued
 *       Andrew Kennedy
 *)
structure CPS = struct

   type tag = Core.sym
   type field = Core.sym

   structure Var = struct
      type v = SymbolTable.symid
      type c = SymbolTable.symid
   end

   structure Exp = struct
      datatype term =
         LETVAL of Var.v * cval * term
       | LETREC of recdecl list * term
       | LETPRJ of Var.v * field * Var.v * term
       | LETUPD of Var.v * Var.v * (field * Var.v) list * term
       | LETCC of ccdecl list * term
       | APP of Var.v * Var.c * Var.v
       | CC of Var.c * Var.v
       | CASE of Var.v * Var.c StringMap.map

      and cval =
         FN of Var.c * Var.v * term
       | INJ of tag * Var.v
       | REC of (field * Var.v) list
       | INT of IntInf.int
       | FLT of FloatLit.float
       | STR of string
       | VEC of string
       | UNT
      
      withtype recdecl = Var.v * Var.c * Var.v list * term
      and ccdecl = Var.c * Var.v * term
      type t = term
   end

   structure Spec = struct
      open Spec
      type t = Exp.t Spec.t
   end

   structure CCTab = struct
      structure CCTab = VarInfo
      open CCTab
      val ccs = SymbolTables.varTable
      val kont = Atom.atom "k"
      fun cvar id = Layout.str (getString (!ccs, id))
   end

   structure Fold = struct
      fun run {visitterm, visitcval} seed cps = let
         open Exp
         fun lpTerm (cps, seed) = let
            val seed = visitterm (cps, seed)
         in
            case cps of
               LETVAL (_, v, t) =>
                  lpTerm
                     (t,
                      visitterm (t, lpCVal (v, seed)))
             | LETREC (ds, t) => lpTerm (t, visitterm (t, lpRec (ds, seed)))
             | LETUPD (_, _, _, t) => lpTerm (t, visitterm (t, seed))
             | LETPRJ (_, _, _, t) => lpTerm (t, visitterm (t, seed))
             | LETCC (ds, t) => lpTerm (t, visitterm (t, lpCC (ds, seed)))
             | _ => seed
         end
         and lpRec (ds, seed) =
            foldl
               (fn ((_, _, _, t), seed) => lpTerm (t, seed))
               seed ds
         and lpCC (ds, seed) =
            foldl
               (fn ((_, _, t), seed) => lpTerm (t, seed))
               seed ds
         and lpCVal (v, seed) = let
            val seed = visitcval (v, seed)
         in
            case v of
               FN (_, _, t) => lpTerm (t, seed)
             | _ => seed
         end
      in
         lpTerm (cps, seed)
      end
   end

   structure PP = struct
      open Layout Pretty Exp Var
      val var = Core.PP.var
      val con = Core.PP.con
      val fld = Core.PP.fld
      val cvar = CCTab.cvar
      val is = seq [space, str "=", space]
      val inn = seq [space, str "in"]
      fun term t = 
         case t of
            LETVAL (n, cv, body) =>
               align
                  [seq [str "letval", space, var n, is, cval cv, inn],
                   indent 3 (term body)]
          | LETREC (ds, body) =>
               align 
                  [align [str "letrec", indent 3 (recdecls ds)],
                   align [str "in", indent 3 (term body)]]
          | LETPRJ (x, f, v, body) =>
               align
                  [seq
                     [str "letval", space, var x, is,
                      str "$", fld f, space, var v, inn],
                   indent 3 (term body)]
          | LETUPD (x, y, fvs, body) =>
               align
                  [seq
                     [str "letval", space, var x, is, var y,
                      str "@", listex "{" "}" "," (map updFld fvs) , inn],
                   indent 3 (term body)]
          | LETCC (cs, body) =>
               align 
                  [align [str "letcc", indent 3 (ccdecls cs)],
                   align [str "in", indent 3 (term body)]]
          | CASE (v, ks) =>
               align
                  [seq [str "case", space, var v, space, str "of"],
                   cases (StringMap.listItems ks)]
          | APP (f, c, v) => seq [var f, space, cvar c, space, var v]
          | CC (c, v) => seq [cvar c, space, var v]
      and cval v =
         case v of
            FN (c, v, body) =>
               align
                  [seq [str "\\", cvar c, space, var v, str "."],
                   indent 3 (term body)]
          | INJ (tag, v) => seq [con tag, space, var v]
          | INT i => int i
          | FLT f => str (FloatLit.toString f)
          | STR s => str s
          | VEC s => seq [str "'", str s, str "'"]
          | REC fs =>
                  listex "{" "}" ","
                     (map
                        (fn (f, v) =>
                           seq [fld f, is, var v]) fs)
          | UNT => str "{}"
      and updFld (f, v) = seq [fld f, is, var v]
      and cases cs = indent 3 (alignPrefix (map casee cs, "| "))
      and casee c = cvar c
      and ccdecls cs = align (map ccdecl cs)
      and ccdecl (c, v, body) = 
         align
            [seq [str "rec", space, cvar c, space, var v, is],
             indent 3 (term body)]
      and recdecls ds = align (map recdecl ds)
      and recdecl (v, c, vs, body) =
         def (seq
               [str "rec", space,
                seq (separate ([var v, cvar c]@map var vs, " "))],
              term body)
      and def (intro, body) =
         align [seq [intro, space, str "="], indent 3 body]
      val spec = Spec.PP.spec term
   end
end
