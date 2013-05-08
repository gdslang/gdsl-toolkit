structure TransCalls = struct
   val name = "transCalls"

   open Imp
      
   fun visitStmt s (ASSIGNstmt (res,exp)) = ASSIGNstmt (res, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, map (visitStmt s) t, map (visitStmt s) e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)

   and visitCase s (p,stmts) = (p, map (visitStmt s) stmts)
   
   and visitExp s (PRIexp (m,f,t,es)) = PRIexp (m,f,t,map (visitExp s) es)
     | visitExp s (CALLexp (m, sym,es)) = CALLexp (m, sym, map (visitExp s) es)
     | visitExp s (INVOKEexp (m, IDexp sym, es)) =
      let
         val { prim_map = prim_map, globals = globals } = s
         (*val _ = TextIO.print ("checking " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")*)
      in
         case SymMap.find (prim_map, sym) of
            SOME gen => visitExp s (gen es)
          | NONE => if SymSet.member(globals, sym)
            then CALLexp (m, sym, map (visitExp s) es)
            else INVOKEexp (m, IDexp sym, map (visitExp s) es)
      end
     | visitExp s (INVOKEexp (m,e,es)) = INVOKEexp (m,visitExp s e, map (visitExp s) es)
     | visitExp s (RECORDexp fs) = RECORDexp (map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (BOXexp (t,e)) = BOXexp (t, visitExp s e)
     | visitExp s (UNBOXexp (t,e)) = UNBOXexp (t, visitExp s e)
     | visitExp s (CLOSUREexp (t,sym,es)) = CLOSUREexp (t,sym,map (visitExp s) es)
     | visitExp s (EXECexp e) = EXECexp (visitExp s e)
     | visitExp s e = e
   
   fun visitDecl s (FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcLocals = locals,
        funcBody = stmts,
        funcRes = res
      }) = FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcLocals = locals,
        funcBody = map (visitStmt s) stmts,
        funcRes = visitExp s res
      }
     | visitDecl s d = d

   fun run { decls = ds } =
      let
         fun get s = VarInfo.lookup (!SymbolTables.varTable, Atom.atom s)
         val prim_map =
            foldl (fn ((k,v),m) => SymMap.insert (m,get k,v))
               SymMap.empty ImpFromCore.prim_table
         fun getSymbol (FUNCdecl { funcName = name, ... }) = name
           | getSymbol (SELECTdecl { selectName = name, ... }) = name
           | getSymbol (UPDATEdecl { updateName = name, ... }) = name
           | getSymbol (CONdecl { conName = name, ... }) = name
         val globals = foldl (fn (d,s) => SymSet.add (s,getSymbol d))
                        SymSet.empty ds
         val state = { prim_map = prim_map, globals = globals }
         val ds = map (visitDecl state) ds
      in
         { decls = ds }
      end
   
end

structure Simplify = struct
   val name = "simplify"

   open Imp
      
   fun visitStmt s (ASSIGNstmt (res,exp)) = ASSIGNstmt (res, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, map (visitStmt s) t, map (visitStmt s) e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)

   and visitCase s (p,stmts) = (p, map (visitStmt s) stmts)
   
   and visitExp s (PRIexp (m,f,t,es)) = PRIexp (m,f,t,map (visitExp s) es)
     | visitExp s (CALLexp (m, sym,es)) = CALLexp (m, sym, map (visitExp s) es)
     | visitExp s (INVOKEexp (m, CLOSUREexp (t,sym,es),ess)) = CALLexp (m, sym, map (visitExp s) (es @ ess))
     | visitExp s (INVOKEexp (m, e,es)) = INVOKEexp (m, visitExp s e, map (visitExp s) es)
     | visitExp s (RECORDexp fs) = RECORDexp (map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (BOXexp (t1,UNBOXexp (t2,e))) = visitExp s e
     | visitExp s (BOXexp (t,e)) = BOXexp (t, visitExp s e)
     | visitExp s (UNBOXexp (t1,BOXexp (t2,e))) = visitExp s e
     | visitExp s (UNBOXexp (t,e)) = UNBOXexp (t, visitExp s e)
     | visitExp s (CLOSUREexp (t,sym,es)) = CLOSUREexp (t,sym,map (visitExp s) es)
     | visitExp s (STATEexp e) = STATEexp (visitExp s e)
     | visitExp s (EXECexp (STATEexp e)) = visitExp s e
     | visitExp s (EXECexp e) = EXECexp (visitExp s e)
     | visitExp s e = e
   
   fun visitDecl s (FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcLocals = locals,
        funcBody = stmts,
        funcRes = res
      }) = FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcLocals = locals,
        funcBody = map (visitStmt s) stmts,
        funcRes = visitExp s res
      }
     | visitDecl s d = d

   fun run { decls = ds } =
      let
         val state = {}
         val ds = map (visitDecl state) ds
      in
         { decls = ds }
      end
   
end

structure StatePassing = struct
   val name = "statePassing"

   open Imp
      
   fun lub (INOUTmonkind, _) = INOUTmonkind
     | lub (_, INOUTmonkind) = INOUTmonkind
     | lub (INmonkind, _) = INmonkind
     | lub (_, INmonkind) = INmonkind
     | lub _ = PUREmonkind

   fun genLub ({ current, state = s}, m, sym) = lub (m, SymMap.lookup (!s,sym))
   fun raiseCurrent ({ current = sym, state = s},m) =
      s := SymMap.insert (!s, sym, lub (m, SymMap.lookup (!s, sym)))

   fun visitStmt s (ASSIGNstmt (res,exp)) = ASSIGNstmt (res, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, map (visitStmt s) t, map (visitStmt s) e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)

   and visitCase s (p,stmts) = (p, map (visitStmt s) stmts)
   
   and visitExp s (PRIexp (m,f,t,es)) = (raiseCurrent (s,m); PRIexp (m,f,t,map (visitExp s) es))
     | visitExp s (CALLexp (m, sym,es)) = (raiseCurrent (s,m); CALLexp (genLub (s,m,sym), sym, map (visitExp s) es))
     | visitExp s (INVOKEexp (m, e,es)) = (raiseCurrent (s,m); INVOKEexp (m, visitExp s e, map (visitExp s) es))
     | visitExp s (RECORDexp fs) = RECORDexp (map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (BOXexp (t,e)) = BOXexp (t, visitExp s e)
     | visitExp s (UNBOXexp (t,e)) = UNBOXexp (t, visitExp s e)
     | visitExp s (CLOSUREexp (t,sym,es)) = CLOSUREexp (t,sym,map (visitExp s) es)
     | visitExp s (STATEexp e) = STATEexp e
     | visitExp s (EXECexp e) = (raiseCurrent (s,INmonkind); EXECexp (visitExp s e))
     | visitExp s e = e

   fun visitDecl s (FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcLocals = locals,
        funcBody = stmts,
        funcRes = res
      }) = FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcLocals = locals,
        funcBody = map (visitStmt { current = name, state = s}) stmts,
        funcRes = visitExp { current = name, state = s} res
      }
     | visitDecl s d = d

   fun removeStateClosureFromDecl s (FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcLocals = locals,
        funcBody = stmts,
        funcRes = STATEexp res
      }) = (s := SymMap.insert (!s, name, lub (INmonkind, SymMap.lookup (!s, name)));
      FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcLocals = locals,
        funcBody = stmts,
        funcRes = res
      })
     | removeStateClosureFromDecl s d = d

   fun run { decls = ds } =
      let
         fun insSymbol (FUNCdecl { funcName = name, funcMonadic = k, ... },m) = SymMap.insert (m,name, k)
           | insSymbol (SELECTdecl { selectName = name, ... },m) = SymMap.insert (m,name, INmonkind)
           | insSymbol (UPDATEdecl { updateName = name, ... },m) = SymMap.insert (m,name, INOUTmonkind)
           | insSymbol (CONdecl { conName = name, ... },m) = SymMap.insert (m,name, INmonkind)
         val stateRef = ref (foldl insSymbol SymMap.empty ds)
         val ds = map (removeStateClosureFromDecl stateRef) ds
         fun calcFixpoint prevState ds =
            let
               val stateRef = ref prevState
               val ds = map (visitDecl stateRef) ds
               val newState = !stateRef
               val equal = SymMap.listItems prevState = SymMap.listItems newState
            in
               if equal then ds else calcFixpoint newState ds
            end
         val ds = calcFixpoint (!stateRef) ds
      in
         { decls = ds }
      end
   
end

