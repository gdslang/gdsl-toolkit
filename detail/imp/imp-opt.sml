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

structure TypeRefinement = struct
   val name = "typeRefinement"

   open Imp
   
   type index = int

   datatype stype
     = VARstype of index
     | BOXstype of stype
     | FUNstype of (stype * stype list)
     | BITstype of stype
     | CONSTstype of int
     | STRINGstype
     | INTstype
     | VOIDstype
   
   fun vtypeToStype VOIDvtype = VOIDstype
     | vtypeToStype (BITvtype s) = BITstype (CONSTstype s)
     | vtypeToStype INTvtype = INTstype
     | vtypeToStype STRINGvtype = STRINGstype
     | vtypeToStype OBJvtype = BOXstype VOIDstype
     | vtypeToStype (FUNvtype {
         result = res,
         closure = clArgs,
         args = args
      }) = FUNstype (vtypeToStype res, map vtypeToStype (clArgs @ args))

   type state = {
     symType : (index SymMap.map) ref,
     typeTable : stype DynamicArray.array
   }
   
   fun showSType (VARstype idx) = "#" ^ Int.toString idx
     | showSType (BOXstype t) = showSType t ^ "*"
     | showSType (FUNstype (res,args)) = showSType res ^ #1 (
         foldl (fn (t,(str,sep)) => (str ^ sep ^ showSType t,","))
            ("", "(") args
         ) ^ ")"
     | showSType (BITstype t) = "|" ^ showSType t ^ "|"
     | showSType (CONSTstype s) = Int.toString s
     | showSType (STRINGstype) = "string"
     | showSType (INTstype) = "int"
     | showSType (VOIDstype) = "void"
         
   fun showState { symType = st, typeTable = tt} =
      let
         fun showBinding (k,idx) =
            let
               val tyStr = showSType (DynamicArray.sub(tt,idx))
               val _ = TextIO.print (SymbolTable.getString(!SymbolTables.varTable, k) ^ " : #" ^ Int.toString idx ^ " -> " ^ tyStr ^ "\n")
            in
               ()
            end
      in
         app showBinding (SymMap.listItemsi (!st)) 
      end

   fun isECR (tt,idx) =
      (case DynamicArray.sub (tt,idx) of
         VARstype idx' => idx=idx'
       | _ => false
      )

   fun find (tt,idx) =
      (case DynamicArray.sub (tt,idx) of
         VARstype idx' =>
            if idx=idx' then idx else
               let
                  val ecr = find (tt,idx')
                  val _ = DynamicArray.update (tt,idx,VARstype ecr)
                  val _ = TextIO.print ("find: updating " ^ Int.toString idx ^ " -> " ^ Int.toString ecr ^ "\n")
               in
                  ecr
               end
       | t => idx
      )
   
   fun findType ({ symType = s, typeTable = tt},VARstype idx) =
      DynamicArray.sub (tt,find (tt,idx))
     | findType ({ symType = s, typeTable = tt},t) = t
   
   fun lub ({ symType = s, typeTable = tt},t1,t2) =
      let
         fun union (x,y) =
            let
               val xRoot = find (tt,x)
               val yRoot = find (tt,y)
               val xTy = DynamicArray.sub (tt,xRoot)
               val yTy = DynamicArray.sub (tt,yRoot)
               val ty = case (xTy,yTy) of
                  (VARstype xRoot, VARstype yRoot) =>
                     VARstype (Int.min (xRoot, yRoot))
                | (VARstype _, t) => t
                | (t, VARstype _) => t
                | (t1,t2) => lub (t1,t2)
               val _ = DynamicArray.update (tt,Int.max (xRoot,yRoot),VARstype (Int.min (xRoot,yRoot)))
               val _ = DynamicArray.update (tt,Int.min (xRoot,yRoot),ty);
            in
               VARstype (Int.min(xRoot,yRoot))  
            end
             

         and lub (VARstype idx1, VARstype idx2) = union (idx1, idx2)
           | lub (VARstype idx, t) =
            (case DynamicArray.sub (tt,find (tt, idx)) of
               VARstype idx => (DynamicArray.update (tt,idx,t); t)
             | t' => (case lub (t',t) of t =>
                  (DynamicArray.update (tt,idx,t); t)
               )
            )
           | lub (t, VARstype idx) =
            (case DynamicArray.sub (tt,find (tt, idx)) of
               VARstype idx => (DynamicArray.update (tt,idx,t); t)
             | t' => (case lub (t',t) of t =>
                  (DynamicArray.update (tt,idx,t); t)
               )
            )
           | lub (VOIDstype, t) = t
           | lub (t, VOIDstype) = t
           | lub (FUNstype (r1, args1), FUNstype (r2, args2)) =
                FUNstype (lub (r1,r2), map lub (ListPair.zipEq (args1,args2)))
           | lub (BITstype s1, BITstype s2) =
            (case lub (s1,s2) of
               CONSTstype s => CONSTstype s
             | _ => VOIDstype
            )
           | lub (CONSTstype s1, CONSTstype s2) =
            if s1=s2 then CONSTstype s1 else VOIDstype
           | lub (INTstype, INTstype) = INTstype
           | lub (STRINGstype, STRINGstype) = STRINGstype
           | lub (BOXstype t1, BOXstype t2) = BOXstype (lub (t1,t2))
           | lub (_, _) = BOXstype VOIDstype         
      in
         lub (t1,t2)
      end
   
   fun symType { symType = s, typeTable = tt} sym =
      (case SymMap.find (!s,sym) of
         SOME idx => VARstype idx
       | NONE =>
         let
            val idx = DynamicArray.bound tt + 1
            val _ = TextIO.print ("symType: " ^ Int.toString idx ^ "\n")
            val _ = DynamicArray.update (tt,idx,VARstype idx)
            val _ = s := SymMap.insert (!s, sym, idx)
         in
            VARstype idx
         end
      )
   
   fun freshTVar { symType = s, typeTable = tt} =
      let
         val idx = DynamicArray.bound tt + 1
         val _ = DynamicArray.update (tt,idx,VARstype idx)
      in
         VARstype idx
      end

   fun extractResult (FUNstype (res,_)) = res
     | extractResult _ = BOXstype VOIDstype
   
   fun visitStmts s [] = VOIDstype
     | visitStmts s (stmt :: stmts) =
      foldl (fn (stmt,_) => visitStmt s stmt) (visitStmt s stmt) stmts

   and visitStmt s (ASSIGNstmt (NONE, exp)) = visitExp s exp
     | visitStmt s (ASSIGNstmt (SOME sym, exp)) = lub (s, symType s sym, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = (visitExp s c; lub (s, visitStmts s t, visitStmts s e))
     | visitStmt s (CASEstmt (e,[])) = VOIDstype
     | visitStmt s (CASEstmt (e,c :: cs)) =
      let
         val t = visitExp s e
      in
         foldl (fn (c,res) => lub (s,res,visitCase s t c))
            (visitCase s t c) cs
      end

   and visitCase s t (p,stmts) = visitStmts s stmts

   and visitExp s (IDexp sym) = symType s sym
     | visitExp s (CONexp sym) = symType s sym
     | visitExp s (CONFUNexp sym) = symType s sym
     | visitExp s (PRIexp (m,f,t,es)) = extractResult (vtypeToStype t)
     | visitExp s (CALLexp (m,sym,es)) = extractResult (lub (s, symType s sym, FUNstype (freshTVar s,map (fn _ => freshTVar s) es)))
     | visitExp s (INVOKEexp (m,e,es)) = extractResult (lub (s, visitExp s e, FUNstype (freshTVar s,map (fn _ => freshTVar s) es)))
     | visitExp s (RECORDexp fs) = BOXstype VOIDstype
     | visitExp s (BOXexp (t,e)) = BOXstype (visitExp s e)
     | visitExp s (UNBOXexp (t,e)) = (case lub (s,freshTVar s, BOXstype (visitExp s e)) of
        (BOXstype t) => t
      | _ => BOXstype VOIDstype)
     | visitExp s (CLOSUREexp (t,sym,es)) = BOXstype (FUNstype (freshTVar s,[]))
     | visitExp s (STATEexp e) = visitExp s e
     | visitExp s (EXECexp e) = visitExp s e
   
   fun visitDecl s (FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcLocals = locals,
        funcBody = stmts,
        funcRes = res
      }) =
      let
         val _ = visitStmts s stmts
         val t = visitExp s res
         fun argTypes args = map (fn (_,sym) => symType s sym) args
         val ty = FUNstype (t, argTypes (clArgs @ args))
      in
         lub (s, symType s name, ty)
      end
     | visitDecl s (SELECTdecl {
         selectName = name,
         selectField = f
      }) = lub (s, symType s name, FUNstype (VOIDstype, [VOIDstype]))
     | visitDecl s (UPDATEdecl {
         updateName = name,
         updateFields = fs
      }) = lub (s, symType s name, FUNstype (VOIDstype, (map (fn _ => VOIDstype) fs)))
     | visitDecl s d = VOIDstype

   fun run { decls = ds } =
      let
         val state : state = {
            symType = ref SymMap.empty,
            typeTable = DynamicArray.array (4000, VOIDstype)
         }
         val _ = map (visitDecl state) ds
         val _ = showState state
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

