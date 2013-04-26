
structure ImpFromCore : sig
   val run:
      Core.Spec.t ->
         Imp.Spec.t CompilationMonad.t
end = struct

   structure CM = CompilationMonad

   open Core
   open Imp

   val constructors: (Spec.sym * Spec.ty option) SymMap.map ref = ref SymMap.empty

   fun freeVars (Exp.LETVAL (s,b,e)) =
      SymSet.union (SymSet.delete (freeVars b,s), freeVars e)
     | freeVars (Exp.LETREC (ds,e)) =
      foldl (fn ((f, args, body), ss) =>
            SymSet.union (ss,
               SymSet.difference (
                  freeVars body,
                  SymSet.addList (SymSet.singleton f, args)
               )
            )) (freeVars e) ds
     | freeVars (Exp.IF (c,e,t)) =
      SymSet.union (freeVars c, SymSet.union (freeVars e, freeVars t))
     | freeVars (Exp.CASE (e, cases)) =
      let
         fun freeInCase (Pat.CON (c, SOME a), e) =
            SymSet.delete (SymSet.delete (freeVars e, a), c)
           | freeInCase (Pat.CON (c, NONE), e) =
            SymSet.delete (freeVars e, c)
           | freeInCase (Pat.ID s, e) =
            SymSet.delete (freeVars e, s)
           | freeInCase (_, e) = freeVars e
      in
         foldl (fn (c, ss) => SymSet.union (freeInCase c, ss)) (freeVars e) cases
      end
     | freeVars (Exp.APP (e,args)) =
      foldl (fn (arg,ss) => SymSet.union (freeVars arg, ss)) (freeVars e) args
     | freeVars (Exp.PRI (_,args)) = SymSet.addList (SymSet.empty, args)
     | freeVars (Exp.FN (s,e)) = SymSet.delete (freeVars e, s)
     | freeVars (Exp.SEQ seq) =
      let
         fun gather (Exp.ACTION t :: rem) =
               SymSet.union (freeVars t, gather rem)
           | gather (Exp.BIND (s,t) :: rem) =
               SymSet.union (freeVars t, SymSet.delete (gather rem, s))
           | gather [] = SymSet.empty
      in
         gather seq
      end
     | freeVars (Exp.ID s) = SymSet.singleton s
     | freeVars _ = SymSet.empty


   fun withLocalVar { globalVars = gv, localVars = lv, declVars = ds, returnSym = _, functions = fs } sym =
      let
         val _ = ds := SymSet.add (!ds, sym)
         val ret = fn exp => ASSIGNstmt (sym, exp)
      in
         { globalVars = gv, localVars = SymSet.add (lv,sym), declVars = ds, returnSym = ret, functions = fs }
      end
   fun withTmpVar { globalVars = gv, localVars = lv, declVars = ds, returnSym = ret, functions = fs } =
      let
         val tab = !SymbolTables.varTable
         val (tab, sym) = SymbolTable.fresh (tab, Atom.atom "tmp")
         val _ = SymbolTables.varTable := tab
         val _ = ds := SymSet.add (!ds, sym)
         val ret = fn exp => ASSIGNstmt (sym, exp)
      in
         (sym, { globalVars = gv, localVars = lv, declVars = ds, returnSym = ret, functions = fs })
      end
   fun withNewDeclVars { globalVars = gv, localVars = lv, declVars = ds, returnSym = ret, functions = fs } f =
      let
         val localDs = ref SymSet.empty
         val res = f { globalVars = gv, localVars = lv, declVars = localDs, returnSym = ret, functions = fs }
      in
         (res, !localDs)
      end
   fun addFunction { globalVars = gv, localVars = lv, declVars = ds, returnSym = ret, functions = fs } decl =
      fs := decl :: !fs
   fun genResult { globalVars = gv, localVars = lv, declVars = ds, returnSym = ret, functions = fs } exp =
      ret exp
   fun addGlobal { globalVars = gv, localVars = lv, declVars = ds, returnSym = ret, functions = fs } v =
      { globalVars = SymSet.add (gv,v), localVars = lv, declVars = ds, returnSym = ret, functions = fs }

   fun trExpr s (Exp.LETVAL (x,b,e)) =
      let
         val (bStmts, bExp) = trExpr (withLocalVar s x) b
         val (eStmts, eExp) = trExpr s e
      in
         (bStmts @ genResult s bExp :: eStmts, eExp)
      end
     | trExpr s (Exp.LETREC (ds, e)) =
      let
         val (eStmts, eExp) = trExpr s e
         val s = foldl (fn ((f,_,_),s) => addGlobal s f) s ds
         val ((eStmts, eExp), localDecls) =
            withNewDeclVars s (fn s => trExpr s e)
         val _ = List.app (trDecl s) ds
      in
         (eStmts, eExp)
      end
     | trExpr s (Exp.SEQ seq) =
      let
         fun transSeq s acc ((Exp.ACTION e) :: seq) =
               let
                  val (stmts, exp) = trExpr s e
               in
                  transSeq s (stmts @ acc) seq
               end
           | transSeq s acc ((Exp.BIND (sym,e)) :: seq) =
               let
                  val (stmts, exp) = trExpr s e
               in
                  transSeq s (stmts @ acc) seq
               end
           | transSeq s acc [Exp.ACTION e] = (acc, e)          
               let
                  val (stmts, exp) = trExpr s e
               in
                  (stmts @ acc, exp)
               end
      in
         transSeq s [] seq
      end
     | trExpr s (Exp.LIT lit) = ([], LITexp lit)
     | trExpr s (Exp.CON sym) =
      (case SymMap.find (!constructors, sym) of
         NONE => ([], BOXexp (INT_vtype, CONexp sym))
       | SOME _ =>  ([], CLOSUREexp (OBJ_vtype, sym, []))
       )
     | trExpr s (Exp.ID sym) = ([], IDexp sym)
   and trDecl s (sym, args, body) =
      let
         val ((stmts, exp), declVars) =
            withNewDeclVars s (fn s => trExpr s body)
         val availInClosure = SymSet.union (#globalVars s,
               SymSet.addList (SymSet.singleton sym, args))
         val inClosure = SymSet.difference (freeVars body, availInClosure)
         val stmts = stmts @ [genResult s exp]
         fun setToArgs ss = map (fn s => (OBJ_vtype, s)) (SymSet.listItems ss)
      in
         addFunction s (FUNCdecl {
           funcMonadic = INOUTmonkind,
           funcClosure = setToArgs inClosure,
           funcType = OBJ_vtype,
           funcName = sym,
           funcArgs = map (fn s => (OBJ_vtype, s)) args,
           funcLocals = setToArgs declVars,
           funcBody = stmts
         })
      end

   fun translate spec =
      Spec.upd
         (fn cs =>
            let
               val () = constructors := Spec.get#constructors spec
               fun exports cs =
                  rev (foldl
                     (fn ((f, _, _), acc) => 
                        let
                           val fld =  f
                        in
                           (fld, Exp.ID f)::acc
                        end)
                     [] cs)
               fun exports spec =
                  let 
                     val es = Spec.get#exports spec
                  in
                     map (fn e => (Exp.ID e)) es
                  end
               val funs = ref ([] : decl list)
               val initialState = { globalVars = SymSet.empty,
                                    localVars = SymSet.empty,
                                    declVars = ref SymSet.empty,
                                    returnSym = RETURNstmt,
                                    functions = funs
                                   }
               val bogusExp = Exp.LIT (SpecAbstractTree.INTlit 42)
               val _ = trExpr initialState (Exp.LETREC (cs, bogusExp))
            in
               !funs 
            end) spec

   fun dumpPre (os, spec) = Pretty.prettyTo (os, Core.PP.spec spec)
   fun dumpPost (os, spec) = Pretty.prettyTo (os, Imp.PP.spec spec)
 
   val translate =
      BasicControl.mkKeepPass
         {passName="impConversion",
          registry=CPSControl.registry,
          pass=translate,
          preExt="core",
          preOutput=dumpPre,
          postExt="imp",
          postOutput=dumpPost}

   fun run spec = CM.return (translate spec)
end
