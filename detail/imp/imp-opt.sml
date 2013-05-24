structure TransCalls = struct
   val name = "transCalls"

   open Imp
      
   fun visitStmt s (ASSIGNstmt (res,exp)) = ASSIGNstmt (res, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, map (visitStmt s) t, map (visitStmt s) e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)

   and visitCase s (p,stmts) = (p, map (visitStmt s) stmts)
   
   and visitExp s (PRIexp (m,f,t,es)) = PRIexp (m,f,t,map (visitExp s) es)
     | visitExp s (IDexp sym) =
      let
         val { prim_map = prim_map, globals = globals } = s
      in
         case SymMap.find (prim_map, sym) of
            SOME (0,gen) => visitExp s (gen [])
          | _ => IDexp sym
      end
     | visitExp s (CALLexp (m, sym,es)) = 
      let
         val { prim_map = prim_map, globals = globals } = s
         (*val _ = TextIO.print ("checking " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")*)
      in
         case SymMap.find (prim_map, sym) of
            SOME (_,gen) => visitExp s (gen es)
          | NONE => CALLexp (m, sym, map (visitExp s) es)
      end
     | visitExp s (INVOKEexp (m, IDexp sym, es)) =
      let
         val { prim_map = prim_map, globals = globals } = s
         val _ = TextIO.print ("checking " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")
      in
         case SymMap.find (prim_map, sym) of
            SOME (_, gen) => visitExp s (gen es)
          | NONE => if SymSet.member(globals, sym)
            then CALLexp (m, sym, map (visitExp s) es)
            else INVOKEexp (m, IDexp sym, map (visitExp s) es)
      end
     | visitExp s (INVOKEexp (m,e,es)) = INVOKEexp (m,visitExp s e, map (visitExp s) es)
     | visitExp s (RECORDexp fs) = RECORDexp (map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (BOXexp (t,e)) = BOXexp (t, visitExp s e)
     | visitExp s (UNBOXexp (t,e)) = UNBOXexp (t, visitExp s e)
     | visitExp s (VEC2INTexp (sz,e)) = VEC2INTexp (sz,visitExp s e)
     | visitExp s (INT2VECexp (sz,e)) = INT2VECexp (sz, visitExp s e)
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
         val _ = app (fn sym => TextIO.print ("primitive " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")) (SymMap.listKeys prim_map)
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
     | visitExp s (INVOKEexp (m, e,es)) = (case visitExp s e of
        CLOSUREexp (t,sym,ess) => CALLexp (m, sym, map (visitExp s) (ess @ es))
      | e => INVOKEexp (m, e, map (visitExp s) es)
      )
     | visitExp s (RECORDexp fs) = RECORDexp (map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (BOXexp (t1,UNBOXexp (t2,e))) = visitExp s e
     | visitExp s (BOXexp (t,e)) = BOXexp (t, visitExp s e)
     | visitExp s (UNBOXexp (t1,BOXexp (t2,e))) = visitExp s e
     | visitExp s (UNBOXexp (t,e)) = UNBOXexp (t, visitExp s e)
     | visitExp s (VEC2INTexp (_,INT2VECexp (sz,e))) = visitExp s e
     | visitExp s (VEC2INTexp (sz,e)) = VEC2INTexp (sz,visitExp s e)
     | visitExp s (INT2VECexp (sz,e)) = INT2VECexp (sz, visitExp s e)
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
   
   exception TypeOptBug
   
   type index = int

   (* The universe of types form a lattice with VOID being the bottom element
      and OBJ being the top element and all other types are in-between. Types
      are only combined using a least-upper bound operation (lub). *)
   datatype stype
     = VOIDstype
     | VARstype of index
     | BOXstype of stype
     | FUNstype of (stype * bool * stype list)
     | BITstype of stype
     | CONSTstype of int
     | STRINGstype
     | INTstype
     | OBJstype
   
   type state = {
     symType : (index SymMap.map) ref,
     fieldType : (index SymMap.map) ref,
     typeTable : stype DynamicArray.array,
     origDecls : decl list
   }
   
   fun showSType (VARstype idx) = "#" ^ Int.toString idx
     | showSType (BOXstype t) = "box(" ^ showSType t ^ ")"
     | showSType (FUNstype (res,cl,args)) = (if cl then "(..." else "(") ^ #1 (
         foldl (fn (t,(str,sep)) => (str ^ sep ^ showSType t,","))
            ("", "") args
         ) ^ ") -> " ^ showSType res
     | showSType (BITstype t) = "|" ^ showSType t ^ "|"
     | showSType (CONSTstype s) = Int.toString s
     | showSType (STRINGstype) = "string"
     | showSType (INTstype) = "int"
     | showSType (VOIDstype) = "void"
     | showSType (OBJstype) = "obj"

   fun inlineSType (s as { typeTable = tt, ...} : state)
                     (VARstype idx) = (case DynamicArray.sub (tt,idx) of
                        VARstype idx' => if idx=idx' then VARstype idx' else
                        inlineSType s (VARstype idx')
                      | t => inlineSType s t)
     | inlineSType s (BOXstype t) = (BOXstype (inlineSType s t))
     | inlineSType s (FUNstype (res,clos,args)) = (FUNstype (inlineSType s res, clos, map (inlineSType s) args))
     | inlineSType s (BITstype t) = (BITstype (inlineSType s t))
     | inlineSType s t = t
         
   fun showState (s as { symType = st, fieldType = ft, typeTable = tt, ...} : state) =
      let
         fun showSymBinding (k,idx) =
            let
               val tyStr = showSType (inlineSType s (DynamicArray.sub(tt,idx)))
               val _ = TextIO.print (SymbolTable.getString(!SymbolTables.varTable, k) ^ " : " ^ tyStr ^ "\n")
            in
               ()
            end
         fun showFieldBinding (k,idx) =
            let
               val tyStr = showSType (inlineSType s (DynamicArray.sub(tt,idx)))
               val _ = TextIO.print (SymbolTable.getString(!SymbolTables.fieldTable, k) ^ " : " ^ tyStr ^ "\n")
            in
               ()
            end
         val _ = app showSymBinding (SymMap.listItemsi (!st))
         (*val _ = app showFieldBinding (SymMap.listItemsi (!ft))*)
      in
         ()
      end
   fun showTable tt = DynamicArray.appi (fn (idx,ty) => TextIO.print ("#" ^ Int.toString idx ^ " -> " ^ showSType ty ^ "\n")) tt

   fun isECR (tt,idx) =
      (case DynamicArray.sub (tt,idx) of
         VARstype idx' => idx=idx'
       | _ => false
      )

   fun find (tt,idx) =
      (case DynamicArray.sub (tt,idx) of
         VARstype idx' => (case Int.compare (idx',idx) of
            EQUAL => idx
          | LESS =>
            let
               val ecr = find (tt,idx')
               val _ = DynamicArray.update (tt,idx,VARstype ecr)
               (*val _ = TextIO.print ("find: updating " ^ Int.toString idx ^ " -> " ^ Int.toString ecr ^ "\n")*)
               (*val _ = showTable tt*)
            in
               ecr
            end
          | GREATER => (showTable tt; raise TypeOptBug)
         )
       | t => idx
      )
   
   fun findType ({ typeTable = tt, ...} : state,VARstype idx) =
         DynamicArray.sub (tt,find (tt,idx))
     | findType (_,t) = t
   
   fun lub (s as { typeTable = tt, ...} : state,t1,t2) =
      let
         fun lub (VARstype x, VARstype y) =
            let
               val xRoot = find (tt,x)
               val yRoot = find (tt,y)
               val xTy = DynamicArray.sub (tt,xRoot)
               val yTy = DynamicArray.sub (tt,yRoot)
               val ecr = VARstype (Int.min (xRoot, yRoot))
               val ty = case (xTy,yTy) of
                  (VARstype xRoot, VARstype yRoot) => ecr
                | (VARstype _, t) => t
                | (t, VARstype _) => t
                | (t1,t2) => lub (t1,t2)
               val _ = DynamicArray.update (tt,Int.max (xRoot,yRoot),ecr)
               val _ = DynamicArray.update (tt,Int.min (xRoot,yRoot),ty)
            in
               ecr
            end
           | lub (VARstype x, t) =
            let
               val xRoot = find (tt,x)
               val xTy = DynamicArray.sub (tt,xRoot)
               val ecr = VARstype xRoot
               val ty = case xTy of
                     (VARstype _) => ecr
                   | t' => lub (t,t')
               val _ = DynamicArray.update (tt,xRoot,ty)
            in
               ecr
            end
           | lub (t, VARstype idx) = lub (VARstype idx, t)
           | lub (VOIDstype, t) = t
           | lub (t, VOIDstype) = t
           | lub (FUNstype (r1, clos1, args1), FUNstype (r2, clos2, args2)) =
                FUNstype (lub (r1,r2), clos1 orelse clos2, lubArgs (args1,args2))
           | lub (BITstype s1, BITstype s2) = BITstype (lub (s1,s2))
           | lub (CONSTstype s1, CONSTstype s2) =
               if s1=s2 then CONSTstype s1 else OBJstype
           | lub (INTstype, INTstype) = INTstype
           | lub (STRINGstype, STRINGstype) = STRINGstype
           | lub (BOXstype t1, BOXstype t2) = BOXstype (lub (t1,t2))
           | lub (OBJstype, OBJstype) = OBJstype
           | lub (t1, t2) = (TextIO.print ("lub top for " ^ showSType t1 ^ "," ^ showSType t2 ^ "\n"); OBJstype)

         and lubArgs (x::xs, y::ys) = lub (x,y) :: lubArgs (xs, ys)
           | lubArgs (xs, []) = xs
           | lubArgs ([], ys) = ys
      in
         lub (t1,t2)
      end
   
   fun symType ({ symType = st, typeTable = tt, ...} : state) sym =
      (case SymMap.find (!st,sym) of
         SOME idx => VARstype idx
       | NONE =>
         let
            val idx = DynamicArray.bound tt + 1
            (*val _ = TextIO.print ("symType(" ^ (SymbolTable.getString(!SymbolTables.varTable, sym)) ^ ")= " ^ Int.toString idx ^ "\n")*)
            val _ = DynamicArray.update (tt,idx,VOIDstype)
            val _ = st := SymMap.insert (!st, sym, idx)
         in
            VARstype idx
         end
      )

   fun fieldType ({ fieldType = ft, typeTable = tt, ...} : state) sym =
      (case SymMap.find (!ft,sym) of
         SOME idx => VARstype idx
       | NONE =>
         let
            val idx = DynamicArray.bound tt + 1
            (*val _ = TextIO.print ("fieldType(" ^ (SymbolTable.getString(!SymbolTables.fieldTable, sym)) ^ ")= " ^ Int.toString idx ^ "\n")*)
            val _ = DynamicArray.update (tt,idx,VOIDstype)
            val _ = ft := SymMap.insert (!ft, sym, idx)
         in
            VARstype idx
         end
      )
   
   fun freshTVar ({ typeTable = tt, ...} : state) =
      let
         val idx = DynamicArray.bound tt + 1
         val _ = DynamicArray.update (tt,idx,VOIDstype)
      in
         VARstype idx
      end

   fun vtypeToStype s VOIDvtype = VOIDstype
     | vtypeToStype s BITvtype = BITstype (OBJstype)
     | vtypeToStype s INTvtype = INTstype
     | vtypeToStype s STRINGvtype = STRINGstype
     | vtypeToStype s OBJvtype = OBJstype
     | vtypeToStype s (FUNvtype (res, cl, args)) = FUNstype (vtypeToStype s res, cl, map (vtypeToStype s) args)


   fun visitStmt s (ASSIGNstmt (NONE, exp)) = ignore (visitExp s exp)
     | visitStmt s (ASSIGNstmt (SOME sym, exp)) = ignore (lub (s, symType s sym, visitExp s exp))
     | visitStmt s (IFstmt (c,t,e)) = (lub (s,BITstype (CONSTstype 1), visitExp s c);
                                       app (visitStmt s) t; app (visitStmt s) e)
     | visitStmt s (CASEstmt (e,cs)) = (lub (s, visitExp s e, INTstype);
      (*TextIO.print ("unified scurtinee " ^ showSType (inlineSType s (visitExp s e)) ^ "\n");*)
                                       app (app (visitStmt s) o #2) cs)

   and visitExp s (IDexp sym) = symType s sym
     | visitExp s (PRIexp (PUREmonkind,SLICEprim,t,es as [vec,ofs,LITexp (INTvtype, INTlit sz)])) =
         visitCall s (FUNstype (BITstype (CONSTstype (IntInf.toInt sz)), false, [INTstype, INTstype, INTstype]), es)
     | visitExp s (PRIexp (m,f,t,es)) = visitCall s (vtypeToStype s t, es)
     | visitExp s (CALLexp (m,sym,es)) = visitCall s (symType s sym, es)
     | visitExp s (INVOKEexp (m,e,es)) = visitCall s (visitExp s e, es)
     | visitExp s (RECORDexp fs) = BOXstype OBJstype
     | visitExp s (LITexp (ty,lit)) = vtypeToStype s ty
     | visitExp s (BOXexp (t,e)) = BOXstype (visitExp s e)
     | visitExp s (UNBOXexp (t,e)) =
      let
         val tVar = freshTVar s
         val res = lub (s, BOXstype tVar, visitExp s e)
      in
         case res of
            OBJstype => OBJstype
          | _ => tVar
      end
     | visitExp s (VEC2INTexp (NONE, e)) = (lub (s, BITstype (freshTVar s), visitExp s e); INTstype)
     | visitExp s (VEC2INTexp (SOME sz, e)) = (lub (s, BITstype (CONSTstype sz), visitExp s e); INTstype)
     | visitExp s (INT2VECexp (sz,e)) = (lub (s, INTstype, visitExp s e); BITstype (CONSTstype sz))
     | visitExp s (CLOSUREexp (t,sym,es)) =
         let
            fun findDecl (FUNCdecl { funcName = name,
                                     funcClosure = clArgs,
                                     funcArgs = args,
                                     funcRes = res, ... } :: ds, sym) =
                  if SymbolTable.eq_symid (name,sym)
                  then (map (symType s o #2) clArgs,map (symType s o #2) args,visitExp s res)
                  else findDecl (ds,sym)
              | findDecl (SELECTdecl { selectName = name,
                                       selectField = f } :: ds, sym) =
                  if SymbolTable.eq_symid (name,sym)
                  then ([fieldType s f],[],OBJstype)
                  else findDecl (ds,sym)
              | findDecl (UPDATEdecl { updateName = name,
                                       updateFields = fs } :: ds, sym) =
                  if SymbolTable.eq_symid (name,sym)
                  then (map (fieldType s) fs,[],OBJstype)
                  else findDecl (ds,sym)
              | findDecl (CONdecl { conName = name, conArg = arg } :: ds, sym) =
                  if SymbolTable.eq_symid (name,sym)
                  then ([],[symType s arg],OBJstype)
                  else findDecl (ds,sym)
              | findDecl ([], sym) = (TextIO.print ("CLOSUREexp(" ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ ") not found\n"); raise TypeOptBug)

            val (clArgTys, argTys, resTy) = findDecl (#origDecls (s : state), sym)
            val _ = map (fn (clTy,e) => lub (s,clTy,visitExp s e)) (ListPair.zipEq (clArgTys,es))
         in
           FUNstype (resTy, not (null es), argTys)
         end
     | visitExp s (STATEexp e) = visitExp s e
     | visitExp s (EXECexp e) = visitExp s e
   
   and visitCall s (fTy,args) =
      let
         val resTy = freshTVar s
         val _ = lub (s,FUNstype (resTy,false,map (visitExp s) args),fTy)
      in
         resTy
      end

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
         val _ = app (visitStmt s) stmts
         val t = visitExp s res
         fun argTypes args = map (fn (_,sym) => symType s sym) args
         val ty = FUNstype (t, not (null clArgs), argTypes args)
      in
         lub (s, symType s name, ty)
      end
     | visitDecl s (SELECTdecl {
         selectName = name,
         selectField = f
      }) = lub (s, symType s name, FUNstype (fieldType s f, false, [freshTVar s]))
     | visitDecl s (UPDATEdecl {
         updateName = name,
         updateFields = fs
      }) = lub (s, symType s name, FUNstype (freshTVar s, false, (map (fieldType s) fs)))
     | visitDecl s (CONdecl {
         conName = name,
         conArg = arg
     }) = lub (s, symType s name, FUNstype (OBJstype, false, [symType s arg]))

   fun run { decls = ds } =
      let
         val state : state = {
            symType = ref SymMap.empty,
            fieldType = ref SymMap.empty,
            typeTable = DynamicArray.array (4000, VOIDstype),
            origDecls = ds
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
     | visitExp s (VEC2INTexp (sz,e)) = VEC2INTexp (sz, visitExp s e)
     | visitExp s (INT2VECexp (sz,e)) = INT2VECexp (sz, visitExp s e)
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

