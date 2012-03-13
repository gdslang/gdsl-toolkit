
structure DesugarMonadicSequences : sig
   val run:
      Core.Spec.t ->
         Core.Spec.t CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   structure Ts = SymbolTables
   structure Exp = Core.Exp

   structure Builtin = struct
      fun fresh v = let
         val (tab, sym) =
            VarInfo.fresh (!SymbolTables.varTable, v)
      in
         sym before SymbolTables.varTable := tab
      end

      fun field f = let
         val (tab, sym) =
            FieldInfo.fresh (!SymbolTables.fieldTable, f)
      in
         sym before SymbolTables.fieldTable := tab
      end
      
      fun get s = VarInfo.lookup (!Ts.varTable, Atom.atom s)

      fun mk () = let
         open Core.Exp
         val >>= = get ">>=" 
         val return = get "return"
         val update =  get "update"
         val query = get "query"
         val answer = field (Atom.atom "1")
         val state = field (Atom.atom "2")
         fun select (f, e) = APP (SELECT f, e)
         val fresh = fresh o Atom.atom

         (* val >>= aM a2bM s =
          *    letval a = aM s in
          *    letval m = a2bM (#1 a) in
          *       m (#2 a)
          *    end
          *)
         val >>= =
            let
               val aM = fresh "aM"
               val a2bM = fresh "a2bM"
               val s = fresh "s"
               val a = fresh "a"
               val m = fresh "m"
               val e =
                   LETVAL (a, APP (ID aM, ID s),
                   LETVAL (m, APP (ID a2bM, select (answer, ID a)),
                      APP (ID m, select (state, ID a))))
            in
               (>>=, [aM, a2bM, s], e)
            end

         (* val query f s = return (f s) *)
         val query = 
            let
               val f = fresh "f"
               val s = fresh "s"
               val e = APP (ID return, APP (ID f, ID s)) 
            in
               (query, [f, s], e)
            end

         (* val update u s = {1={}, 2=u s} *)
         val update =
            let
               val u = fresh "u"
               val s = fresh "s"
               val e =
                  RECORD
                     [(answer, RECORD []),
                      (state, APP (ID u, ID s))]
            in
               (update, [u, s], e)
            end

         (* val return a s = {1=a, 2=s} *)
         val return =
            let
               val a = fresh "a"
               val s = fresh "s"
               val e =
                  RECORD
                     [(answer, ID a),
                      (state, ID s)]
            in
               (return, [a, s], e)
            end

      in
         [>>=, return, update, query]
      end

   end

   local open Core.Exp in

   fun desugar e = 
      case e of
         LETVAL (s, e, body) => LETVAL (s, desugar e, desugar body)
       | LETREC (ds, body) => LETREC (map desugarDecl ds, desugar body)
       | IF (iff, thenn, elsee) => IF (desugar iff, desugar thenn, desugar elsee)
       | CASE (e, ps) => CASE (desugar e, map desugarCase ps)
       | APP (e1, e2) => APP (desugar e1, desugar e2)
       | FN (n, e) => FN (n, desugar e)
       | RECORD fs => RECORD (map desugarField fs)
       | UPDATE fs => UPDATE (map desugarField fs)
       | SEQ ss => desugarSeq ss
       | otherwise => otherwise
   
   and desugarDecl (n, ns, e) = (n, ns, desugar e)
   and desugarCase (p, e) = (p, desugar e)
   and desugarField (f, e) = (f, desugar e)

   and flattenSeq ss = List.concat (List.map flatten ss)
   and flatten s =
      case s of
         ACTION (SEQ ss) => flattenSeq ss
       | _ => [s]

   and desugarSeq ss = let
      val >>= = Builtin.get ">>="
      fun lp ss =
         case ss of
            [ACTION a] => desugar a
          | BIND (n, a)::ss => APP (APP (ID >>=, desugar a), FN (n, lp ss))
          | ACTION a::ss => APP (APP (ID >>=, desugar a), lp ss)
          | _ => raise CM.CompilationError
   in
      lp (flattenSeq ss)
   end
      
   end (* end local *)

   fun desugarMonadic es =
      Builtin.mk() @ map (fn (n, ns, e) => (n, ns, desugar e)) es

   fun dump (os, spec) = Pretty.prettyTo (os, Core.PP.spec spec)
   fun pass spec = Spec.upd desugarMonadic spec

   val desugar =
      BasicControl.mkKeepPass
         {passName="desugarMonadicSequences",
          registry=DesugarControl.registry,
          pass=pass,
          preExt="ast",
          preOutput=dump,
          postExt="ast",
          postOutput=dump}

   fun run spec = CM.return (desugar spec)
end
