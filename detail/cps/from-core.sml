
structure FromCore : sig
   val run:
      Core.Spec.t ->
         CPS.Spec.t CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   structure Exp = CPS.Exp
   structure CCTab = SymbolTable

   val ccs = ref CCTab.empty
   val kont = Atom.atom "k"
   val variable = Atom.atom "x"

   fun freshC () = let
      val (tab, sym) =
         CCTab.fresh (!ccs, kont)
   in
      sym before ccs := tab
   end

   fun freshV () = let
      val (tab, sym) =
            VarInfo.fresh (!SymbolTables.varTable, variable)
   in
      sym before SymbolTables.varTable := tab
   end

   fun bind map v t = SymMap.insert (map, v, t) 

   local open Core.Exp in

   fun translate spec =
      Spec.upd
         (fn cs =>
            let
               val main = freshV ()
               val kont = freshC ()
            in
               trans0 
                  (LETREC (cs, RECORD []))
                  (fn z => Exp.APP (main, kont, z))
            end) spec

   and trans0 e kappa = 
      case e of
         LETVAL (v, e, body) =>
            let
               val j = freshC ()
               val body = trans0 body kappa
            in
               Exp.LETCC ([(j, v, body)], trans1 e j)
            end
       | LETREC (ds, body) => raise CM.CompilationError
       | IF (iff, thenn, elsee) =>raise CM.CompilationError
       | CASE (e, ps) => raise CM.CompilationError
       | APP (e1, e2) =>
            let
               val k = freshC ()
               val x = freshV ()
            in
               trans0 e1 (fn x1 =>
                  trans0 e2 (fn x2 =>
                     Exp.LETCC ([(k, x, kappa x)], Exp.APP (x1, k, x2))))
            end
       | FN (x, e) =>
            let
               val f = freshV ()
               val k = freshC ()
            in
               Exp.LETREC ([(f, k, [x], trans1 e k)], kappa f) 
            end
       | RECORD fs =>
            let
               fun trans fs fvs =
                  case fs of
                     [] =>
                        let
                           val x = freshV ()
                        in
                           Exp.LETVAL (x, Exp.REC fvs, kappa x)
                        end
                   | (f, e)::fs =>
                        trans0 e (fn z =>
                           trans fs ((f, z)::fvs))
            in
               trans fs []
            end
       | UPDATE fs => raise CM.CompilationError
       | SELECT fld =>
            let
               val f = freshV ()
               val k = freshC ()
               val x = freshV ()
               val z = freshV ()
            in
               Exp.LETREC
                  ([(f, k, [x],
                     Exp.LETPRJ (z, fld, x, Exp.CC (k, z)))],
                   kappa f)
            end
       | CON c =>
            let
               val f = freshV ()
               val k = freshC ()
               val x = freshV ()
               val y = freshV ()
            in
               Exp.LETREC
                  ([(f, k, [x],
                    Exp.LETVAL (y, Exp.INJ (c, x), Exp.CC (k, y)))],
                   kappa f)
            end
       | LIT l =>
            let
               val x = freshV ()
            in
               Exp.LETVAL (x, transLit l, kappa x)
            end
       | ID v => kappa v
       | _ => raise CM.CompilationError
   
   and trans1 e kont =
      case e of
         LETVAL (v, e, body) => raise CM.CompilationError
       | LETREC (ds, body) => raise CM.CompilationError
       | IF (iff, thenn, elsee) => raise CM.CompilationError
       | CASE (e, ps) => raise CM.CompilationError
       | APP (e1, e2) => raise CM.CompilationError
       | FN (n, e) => raise CM.CompilationError
       | RECORD fs => raise CM.CompilationError
       | UPDATE fs => raise CM.CompilationError
       | SEQ _ => raise CM.CompilationError
       | ID x => Exp.CC (kont, x)
       | _ => raise CM.CompilationError

   and transLit l =
      case l of
         Core.Lit.INTlit i => Exp.INT i
       | Core.Lit.FLTlit f => Exp.FLT f
       | Core.Lit.VEClit v => Exp.VEC v 
       | Core.Lit.STRlit s => Exp.STR s

   end (* end local *)

   fun dumpPre (os, spec) = Pretty.prettyTo (os, Core.PP.spec spec)
   fun dumpPost (os, spec) = Pretty.prettyTo (os, CPS.PP.spec spec)

   val translate =
      BasicControl.mkKeepPass
         {passName="translateCoreToCPS",
          registry=CPSControl.registry,
          pass=translate,
          preExt="ast",
          preOutput=dumpPre,
          postExt="ast",
          postOutput=dumpPost}

   fun run spec = CM.return (translate spec)
end
