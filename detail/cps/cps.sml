(**
 * ## CPS style intermediate representation
 *
 * see:
 *   - Compiling with Continuations, Continued
 *       Andrew Kennedy
 *)
structure CPS = struct

   type tag = Word.word
   type con = Core.sym
   type field = Core.sym

   structure Var = struct
      type v = SymbolTable.symid
      type c = SymbolTable.symid
   end

   structure Exp = struct
      datatype term =
         LETVAL of Var.v * cval * term
       | LETREC of recdecl list * term
       | LETCONT of contdecl list * term
       | LETPRJ of Var.v * field * Var.v * term
       | LETDECON of Var.v * Var.v * term
       | LETUPD of Var.v * Var.v * (field * Var.v) list * term
       | APP of Var.v * Var.c * Var.v list
       | CC of Var.c * Var.v list
       | CASE of Var.v * (tag list * branch) list

      and cval =
         FN of Var.c * Var.v list * term
       | PRI of Var.v * Var.v list
       | INJ of con * Var.v
       | REC of (field * Var.v) list
       | INT of IntInf.int
       | FLT of FloatLit.float
       | STR of string
       | VEC of string
       | UNT
      
      withtype recdecl = Var.v * Var.c * Var.v list * term
      and contdecl = Var.c * Var.v list * term
      and branch = Var.c * Var.v list
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
             | LETDECON (_, _, t) => lpTerm (t, visitterm (t, seed))
             | LETCONT (ds, t) => lpTerm (t, visitterm (t, lpCC (ds, seed)))
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
      val cvar = var
      val is = seq [space, str "=", space]
      val inn = seq [space, str "in"]
      fun isLetvalLike body =
         case body of
            LETVAL _ => true
          | LETPRJ _ => true
          | LETDECON _ => true
          | LETUPD _ => true
          | _ => false
      fun term t = 
         case t of
            LETVAL (n, FN (k, xs, K), body) =>
               align
                  [seq [str "letval", space, var n, is],
                   indent 3
                     (align [seq [str "\\", vars (k::xs), str "."],
                             indent 3 (term K)]),
                   inn,
                   indent 3 (term body)]
          | LETVAL (n, cv, body) =>
               align
                  [seq [str "letval", space, var n, is, cval cv, inn],
                   if isLetvalLike body
                      then term body
                   else indent 3 (term body)]
          | LETREC (ds, body) =>
               align 
                  [align [str "letrec", indent 3 (recdecls ds)],
                   align [str "in", indent 3 (term body)]]
          | LETPRJ (x, f, v, body) =>
               align
                  [seq
                     [str "letval", space, var x, is,
                      str "$", fld f, space, var v, inn],
                   if isLetvalLike body
                      then term body
                   else indent 3 (term body)]
          | LETDECON (x, v, body) =>
               align
                  [seq
                     [str "letval", space, var x, is,
                      str "$$", var v, inn],
                   if isLetvalLike body
                      then term body
                   else indent 3 (term body)]
          | LETUPD (x, y, fvs, body) =>
               align
                  [seq
                     [str "letval", space, var x, is, var y,
                      str "@", listex "{" "}" "," (map updFld fvs) , inn],
                   if isLetvalLike body
                      then term body
                   else indent 3 (term body)]
          | LETCONT (cs, body) =>
               align 
                  [align [str "letcont", indent 3 (contdecls cs)],
                   align [str "in", indent 3 (term body)]]
          | CASE (v, ks) =>
               align
                  [seq [str "case", space, var v, space, str "of"],
                   cases ks]
          | APP (f, c, xs) => seq [var f, vars (c::xs)]
          | CC (c, vs) => seq [cvar c, vars vs]
      and vars xs = seq [lp, seq (separate (map var xs, ",")), rp]
      and cval v =
         case v of
            FN (c, xs, body) =>
               align
                  [seq [str "\\", vars (c::xs), str "."],
                   indent 3 (term body)]
          | PRI (f, xs) => seq [var f, vars xs]
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
          | UNT => str "()"
      and updFld (f, v) = seq [fld f, is, var v]
      and cases cs = indent 3 (alignPrefix (map casee cs, "| "))
      and casee (tags, branch) =
         seq [list (map caseTag tags), str ":", space, caseBranch branch]
      and caseTag tag = word tag
      and caseBranch (k, []) = seq [cvar k]
        | caseBranch (k, xs) = seq [cvar k, space, vars xs]
      and contdecls cs = align (map contdecl cs)
      and contdecl (c, vs, body) = 
         align
            [seq [str "val",
                  space, seq (separate ([cvar c]@map var vs, " ")), is],
             indent 3 (term body)]
      and recdecls ds = align (map recdecl ds)
      and recdecl (v, c, vs, body) =
         def (seq [str "val", space, var v, vars (c::vs)],
              term body)
      and def (intro, body) =
         align [seq [intro, space, str "="], indent 3 body]
      val spec = Spec.PP.spec term
   end
end
