structure BetaReduction = struct
   val name = "betaReduction"

   open Imp
   
   val state : { } ref = ref {}
   
   fun visitStmt s (ASSIGNstmt (res,exp)) = ASSIGNstmt (res, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, map (visitStmt s) t, map (visitStmt s) e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)

   and visitCase s (p,stmts) = (p, map (visitStmt s) stmts)
   
   and visitExp s (PRIexp (m,f,t,es)) = PRIexp (m,f,t,map (visitExp s) es)
     | visitExp s (CALLexp (e,es)) = CALLexp (visitExp s e, map (visitExp s) es)
     | visitExp s (INVOKEexp (CLOSUREexp (t,sym,es),ess)) = CALLexp (IDexp sym, map (visitExp s) (es @ ess))
     | visitExp s (INVOKEexp (IDexp sym, es)) =
      let
         val { prim_map = prim_map } = s
      in
         case SymMap.find (#prim_map s, sym) of
            SOME gen => gen (map (visitExp s) es)
          | NONE => INVOKEexp (IDexp sym, map (visitExp s) es)
      end
     | visitExp s (INVOKEexp (e,es)) = INVOKEexp (visitExp s e, map (visitExp s) es)
     | visitExp s (RECORDexp fs) = RECORDexp (map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (BOXexp (t,e)) = BOXexp (t, visitExp s e)
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
        funcRes = res
      }
     | visitDecl s d = d

   fun run { decls = ds } =
      let
         fun get s = VarInfo.lookup (!SymbolTables.varTable, Atom.atom s)
         val prim_map =
            foldl (fn ((k,v),m) => SymMap.insert (m,get k,v))
               SymMap.empty ImpFromCore.prim_table
         val state = { prim_map = prim_map }
         val ds = map (visitDecl state) ds
      in
         { decls = ds }
      end
   
end