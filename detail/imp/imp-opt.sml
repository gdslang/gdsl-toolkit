
structure PatchFunctionCalls = struct
   val name = "patch-function-calls"

   open Imp
   
   exception PatchFunctionBug
   
   type state = {
      no_arg_funs : SymSet.set,
      decls : decl SymMap.map
   }
   
   fun visitStmt (s : state) (ASSIGNstmt (res,exp)) = ASSIGNstmt (res, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, visitBlock s t, visitBlock s e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)
   
   and visitCase (s : state) (p,stmts) = (p, visitBlock s stmts)
   
   and visitBlock (s : state) (BASICblock (decls, stmts)) = BASICblock (decls, map (visitStmt s) stmts)
   
   and visitExp (s : state) (PRIexp (m,f,t,es)) = PRIexp (m,f,t,map (visitExp s) es)
     | visitExp s (IDexp sym) = IDexp sym
     | visitExp s (CALLexp (m, sym,es)) = CALLexp (m, sym, map (visitExp s) es)
     | visitExp s (INVOKEexp (m, t, e, es)) = (case visitExp s e of
         IDexp sym => (case SymMap.find (!Primitives.prim_map, sym) of
            SOME (_,gen) => visitExp s (gen es)
          | NONE => visitExp s (CALLexp (m, sym, es))
         )
       | CLOSUREexp (tCl,sym,esCl) => (case SymMap.find (#decls s,sym) of
            SOME (CLOSUREdecl { closureDelegate = delSym, ... }) =>
               visitExp s (CALLexp (m, delSym, esCl @ es))
          | _ => (TextIO.print ("INVOKE of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " is bad idea.\n"); raise PatchFunctionBug)
         ) 
       | e => INVOKEexp (m, t, e, map (visitExp s) es)
      )
     | visitExp s (RECORDexp fs) = RECORDexp (map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (LITexp l) = LITexp l
     | visitExp s (BOXexp (t,e)) = BOXexp (t, visitExp s e)
     | visitExp s (UNBOXexp (t,e)) = UNBOXexp (t, visitExp s e)
     | visitExp s (VEC2INTexp (sz,e)) = VEC2INTexp (sz, visitExp s e)
     | visitExp s (INT2VECexp (sz,e)) = INT2VECexp (sz, visitExp s e)
     | visitExp s (CLOSUREexp (t,sym,es)) = CLOSUREexp (t,sym,map (visitExp s) es)
     | visitExp s (STATEexp (b,e)) = STATEexp (visitBlock s b,visitExp s e)
     | visitExp s (EXECexp e) = EXECexp (case visitExp s e of
         IDexp sym => (case SymMap.find (!Primitives.prim_map, sym) of
            SOME (_,gen) => visitExp s (gen [])
          | NONE => IDexp sym
         )
       | CLOSUREexp (tCl,sym,[]) => (case SymMap.find (#decls s,sym) of
            SOME (CLOSUREdecl { closureDelegate = delSym, ... }) => IDexp delSym
          | _ => (TextIO.print ("EXEC of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " is bad idea.\n"); raise PatchFunctionBug)
         ) 
       | e => e
      )
         

   fun visitDecl (s : state) (FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = stmts,
        funcRes = res
      }) = FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = visitBlock s stmts,
        funcRes = res
      }
     | visitDecl s d = d

   fun gatherNoArgFuns (FUNCdecl {
        funcName = name,
        funcArgs = [],
        funcClosure = [],
        ...
      },ss) = SymSet.add (ss,name)
     | gatherNoArgFuns (_, ss) = ss

   fun run ({ decls = ds, fdecls = fs } : imp) =
      let
         fun get s = VarInfo.lookup (!SymbolTables.varTable, Atom.atom s)
         val prim_map = !Primitives.prim_map
         val noArgFuns = foldl gatherNoArgFuns SymSet.empty ds
         val declMap = foldl (fn (decl,m) => SymMap.insert (m,getDeclName decl, decl)) SymMap.empty ds
         val state = { decls = declMap , no_arg_funs = noArgFuns } : state
         val ds = map (visitDecl state) ds
      in
         { decls = ds, fdecls = fs } : imp
      end
   
end

structure ActionClosures = struct
   val name = "action-closures"

   open Imp

   type state = { monFuns : SymSet.set,
                  declsRef : arg list ref,
                  stmtsRef : stmt list ref }
   fun addMonSym ({ monFuns = monFuns,
                    declsRef = declsRef,
                    stmtsRef = stmtsRef },sym) =
      { monFuns = SymSet.add(monFuns,sym),
        declsRef = declsRef,
        stmtsRef = stmtsRef } : state
      
   fun isMonadic (BASICblock (_, [ASSIGNstmt (_,STATEexp _)])) = true
     | isMonadic _ = false

   fun visitBlock s (BASICblock (decls,stmts)) =
      let
         val s' = { monFuns = #monFuns s,
                    declsRef = ref [],
                    stmtsRef = ref [] } : state
         fun trStmts [] = []
           | trStmts (stmt :: stmts) =
            let
               val stmt' = visitStmt s' stmt
               val stmts' = !(#stmtsRef s')
               val _ = (#stmtsRef s') := []
            in
               stmts' @ stmt' :: trStmts stmts
            end
            val stmts' = trStmts stmts
            val decls' = decls @ !(#declsRef s')
      in
         BASICblock (decls', stmts')
      end

   and visitStmt s (ASSIGNstmt (NONE,exp)) = ASSIGNstmt (NONE, visitExp s exp)
     | visitStmt s (ASSIGNstmt (SOME sym,exp)) =
         if SymSet.member(#monFuns s, sym) then
            ASSIGNstmt (SOME sym, visitExp s (EXECexp exp))
         else
            ASSIGNstmt (SOME sym, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, visitBlock s t, visitBlock s e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)

   and visitCase s (p,stmts) = (p, visitBlock s stmts)
   
   and visitExp s (IDexp sym) =
      if SymSet.member (#monFuns (s : state),sym) then
         STATEexp (BASICblock ([],[]), IDexp sym)
      else
         IDexp sym
     | visitExp s (PRIexp (m,f,t,es)) = PRIexp (m,f,t,map (visitExp s) es)
     | visitExp s (CALLexp (m,sym,es)) =
      if SymSet.member (#monFuns (s : state),sym) then
         STATEexp (BASICblock ([],[]), CALLexp (m, sym, map (visitExp s) es))
      else
         CALLexp (m, sym, map (visitExp s) es)
     | visitExp s (INVOKEexp (m,t,e,es)) = INVOKEexp (m,t,visitExp s e, map (visitExp s) es)
     | visitExp s (RECORDexp fs) = RECORDexp (map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (BOXexp (t,e)) = BOXexp (t, visitExp s e)
     | visitExp s (UNBOXexp (t,e)) = UNBOXexp (t, visitExp s e)
     | visitExp s (VEC2INTexp (sz,e)) = VEC2INTexp (sz, visitExp s e)
     | visitExp s (INT2VECexp (sz,e)) = INT2VECexp (sz, visitExp s e)
     | visitExp s (CLOSUREexp (t,sym,es)) =
      if SymSet.member (#monFuns (s : state),sym) then
         STATEexp (BASICblock ([],[]), CLOSUREexp (t,sym,map (visitExp s) es))
      else
         CLOSUREexp (t,sym,map (visitExp s) es)
     | visitExp s (STATEexp (body,e)) =
         (case visitExp s e of
            (EXECexp (IDexp sym)) => STATEexp (visitBlock (addMonSym (s,sym)) body, IDexp sym)
          | e => STATEexp (visitBlock s body, e)
         )
     | visitExp s (EXECexp e) = (case (visitExp s e) of
            STATEexp (BASICblock (decls, stmts),e) => 
            let
               val _ = (#declsRef s) := decls @ (!(#declsRef s))
               val _ = (#stmtsRef s) := stmts @ (!(#stmtsRef s))
            in
               e
            end
          (*| IDexp sym =>
            if SymSet.member (#monFuns (s : state),sym) then
               CALLexp (ACTmonkind,sym,[])
            else
               EXECexp (IDexp sym)
          | CALLexp (m,sym,args) =>
            if SymSet.member (#monFuns (s : state),sym) then
               CALLexp (ACTmonkind,sym,args)
            else
               EXECexp (CALLexp (m,sym,args))*)
          | e => EXECexp e
        )                                           
     | visitExp s e = e

   fun visitDecl (s : state) (FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = body,
        funcRes = res
      }) =
      let
         val (monkind',body') = case visitBlock s body of
            (BASICblock (decls, [ASSIGNstmt (lhs,STATEexp (BASICblock (decls',stmts'),e))])) =>
               (ACTmonkind, BASICblock (decls @ decls', stmts' @ [ASSIGNstmt (lhs,e)]))
          | body => (monkind, body)
      in
         FUNCdecl {
           funcMonadic = monkind',
           funcClosure = clArgs,
           funcType = vtype,
           funcName = name,
           funcArgs = args,
           funcBody = body',
           funcRes = res
         }
      end
     | visitDecl s d = d

   (* gather a set of obviously monadic functions; we can call these without
      generating a closure *)
   fun addMonadic (FUNCdecl {
        funcName = name,
        funcBody = body,
        ...
        },m) = if isMonadic body then SymSet.add (m,name) else m
     | addMonadic (_,m) = m
     
   fun run { decls = ds, fdecls = fs } =
      let
         val monFuns = foldl addMonadic SymSet.empty ds
         val s = { monFuns = monFuns,
                   declsRef = ref ([] : arg list),
                   stmtsRef = ref ([] : stmt list)
                 } : state
         val ds = map (visitDecl s) ds
         (*val ds = map (patchDecl s) ds*)
      in
         { decls = ds, fdecls = fs }
      end
   
end

structure Simplify = struct
   val name = "simplify"

   open Imp
      
   fun visitStmt s (ASSIGNstmt (res,exp)) = ASSIGNstmt (res, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, visitBlock s t, visitBlock s e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)
   
   and visitCase s (p,stmts) = (p, visitBlock s stmts)
   
   and visitBlock s (BASICblock (decls, stmts)) = BASICblock (decls, map (visitStmt s) stmts)
   
   and visitExp s (PRIexp (m,f,t,es)) = PRIexp (m,f,t,map (visitExp s) es)
     | visitExp s (IDexp sym) = IDexp sym
     | visitExp s (CALLexp (m, sym,es)) = CALLexp (m, sym, map (visitExp s) es)
     | visitExp s (INVOKEexp (m, t, e, es)) = INVOKEexp (m, t, e, map (visitExp s) es)
     | visitExp s (RECORDexp fs) = RECORDexp (map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (LITexp l) = LITexp l
     | visitExp s (BOXexp (t,e)) = (case visitExp s e of
            UNBOXexp (t2,e) => e
          | e => BOXexp (t, e)
        )
     | visitExp s (UNBOXexp (t,e)) =  (case visitExp s e of
            BOXexp (t2,e) => e
          | e => UNBOXexp (t, e)
        )
     | visitExp s (VEC2INTexp (sz,e)) = (case visitExp s e of
            INT2VECexp (sz,e) => e
          | e => VEC2INTexp (sz, e)
        )
     | visitExp s (INT2VECexp (sz,e)) = INT2VECexp (sz, visitExp s e)
     | visitExp s (CLOSUREexp (t,sym,es)) = CLOSUREexp (t,sym,map (visitExp s) es)
     | visitExp s (STATEexp (b,e)) = STATEexp (visitBlock s b,visitExp s e)
     | visitExp s (EXECexp e) = EXECexp (visitExp s e)

   fun visitDecl s (FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = stmts,
        funcRes = res
      }) = FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = visitBlock s stmts,
        funcRes = res
      }
     | visitDecl s d = d

   fun run ({ decls = ds, fdecls = fs } : imp) =
      let
         val ds = map (visitDecl {}) ds
      in
         { decls = ds, fdecls = fs } : imp
      end
   
end

structure TypeRefinement = struct
   val name = "typeRefinement"

   open Imp
   
   val debugOn = ref false
   fun msg str = if !debugOn then TextIO.print str else ()

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
     origDecls : decl SymMap.map,
     origLocals : (vtype SymMap.map) ref,
     origFields : vtype SymMap.map
   }
   
   fun showSType (VOIDstype) = "void"
     | showSType (VARstype idx) = "#" ^ Int.toString idx
     | showSType (BOXstype t) = "box(" ^ showSType t ^ ")"
     | showSType (FUNstype (res,cl,args)) = (if cl then "(..." else "(") ^ #1 (
         foldl (fn (t,(str,sep)) => (str ^ sep ^ showSType t,","))
            ("", "") args
         ) ^ ") -> " ^ showSType res
     | showSType (CONSTstype s) = Int.toString s
     | showSType (BITstype t) = "|" ^ showSType t ^ "|"
     | showSType (STRINGstype) = "string"
     | showSType (INTstype) = "int"
     | showSType (OBJstype) = "obj"

   fun inlineSType s (VARstype idx) =
      let
         val { typeTable = tt, ...} = s : state
         fun find idx = case DynamicArray.sub (tt,idx) of
            VARstype idx' => if idx=idx' then idx' else find idx'
          | t => idx
      in
         DynamicArray.sub (tt,find idx)
      end
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
         val _ = app showFieldBinding (SymMap.listItemsi (!ft))
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
         (*val _ = TextIO.print ("lub of " ^ showSType t1 ^ " and " ^ showSType t2 ^ ", that is, of " ^showSType (inlineSType s t1) ^ " and " ^ showSType (inlineSType s t2) ^ "\n")*)
         
         (*val iter = ref 0*)
         fun lub (VARstype x, VARstype y) =
            if x=y then VARstype x else
            let
               val xRoot = find (tt,x)
               val yRoot = find (tt,y)
               (*val _ = iter := (!iter) + 1*)
               val xTy = DynamicArray.sub (tt,xRoot)
               val yTy = DynamicArray.sub (tt,yRoot)
               (*val _ = if !iter>20 then
                        raise TypeOptBug
                     else if !iter>10 then
                        TextIO.print ("non-termination for lub of " ^ showSType t1 ^ " and " ^ showSType t2 ^ ", that is, of " ^showSType (inlineSType s t1) ^ " and " ^ showSType (inlineSType s t2) ^ ", xTy = " ^ showSType xTy ^ ", yTy = " ^ showSType yTy ^"\n")
                     else ()*)
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
           | lub (FUNstype (r1, clos1, args1), FUNstype (r2, clos2, args2)) = (
               FUNstype (lub (r1,r2), clos1 orelse clos2, map lub (ListPair.zip (args1,args2)))
               handle ListPair.UnequalLengths =>
                  (TextIO.print ("lub on bad func args: " ^ showSType (FUNstype (r1, clos1, args1)) ^ "," ^ showSType (FUNstype (r2, clos2, args2)) ^ "\n"); raise TypeOptBug)
             )
           | lub (BITstype s1, BITstype s2) = BITstype (lub (s1,s2))
           | lub (CONSTstype s1, CONSTstype s2) =
               if s1=s2 then CONSTstype s1 else OBJstype
           | lub (INTstype, INTstype) = INTstype
           | lub (STRINGstype, STRINGstype) = STRINGstype
           | lub (BOXstype t1, BOXstype t2) = BOXstype (lub (t1,t2))
           | lub (OBJstype, OBJstype) = OBJstype
           | lub (CONSTstype _, OBJstype) = OBJstype
           | lub (OBJstype, CONSTstype _) = OBJstype
           | lub (t1, t2) = (TextIO.print ("lub top for " ^ showSType t1 ^ "," ^ showSType t2 ^ "\n"); OBJstype)

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
            (*val _ = TextIO.print ("fieldType(" ^ SymbolTable.getString(!SymbolTables.fieldTable, sym) ^ ")= " ^ Int.toString idx ^ "\n")*)
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


   fun visitBlock s (BASICblock (decls,stmts)) = app (visitStmt s) stmts

   and visitStmt s (ASSIGNstmt (NONE, exp)) = ignore (visitExp s exp)
     | visitStmt s (ASSIGNstmt (SOME sym, exp)) = ignore (lub (s, symType s sym, visitExp s exp))
     | visitStmt s (IFstmt (c,t,e)) = (lub (s,INTstype, visitExp s c);
                                       visitBlock s t; visitBlock s e)
     | visitStmt s (CASEstmt (e,cs)) = (lub (s, visitExp s e, INTstype);
      (*TextIO.print ("unified scurtinee " ^ showSType (inlineSType s (visitExp s e)) ^ "\n");*)
                                       app ((visitBlock s) o #2) cs)

   and visitExp s (IDexp sym) = symType s sym
     | visitExp s (PRIexp (PUREmonkind,SLICEprim,t,es as [vec,ofs,LITexp (INTvtype, INTlit sz)])) =
         visitCall s (FUNstype (BITstype (CONSTstype (IntInf.toInt sz)), false, [INTstype, INTstype, INTstype]), es)
     | visitExp s (PRIexp (m,f,t,es)) = visitCall s (vtypeToStype s t, es)
     | visitExp s (CALLexp (m,sym,es)) = visitCall s (symType s sym, es)
     | visitExp s (INVOKEexp (m,t,e,es)) = visitCall s (visitExp s e, es)
     | visitExp s (RECORDexp fs) = (map (fn (f,e) => lub (s,fieldType s f,visitExp s e)) fs; BOXstype OBJstype)
     | visitExp s (LITexp (ty,lit)) = vtypeToStype s ty
     | visitExp s (BOXexp (t,e)) = BOXstype (visitExp s e)
     | visitExp s (UNBOXexp (t,e)) =
      let
         val tVar = freshTVar s
         val res = lub (s, BOXstype tVar, visitExp s e)
      in
         tVar
      end
     | visitExp s (VEC2INTexp (NONE, e)) = (lub (s, BITstype (freshTVar s), visitExp s e); INTstype)
     | visitExp s (VEC2INTexp (SOME sz, e)) = (lub (s, BITstype (CONSTstype sz), visitExp s e); INTstype)
     | visitExp s (INT2VECexp (sz,e)) = (lub (s, INTstype, visitExp s e); BITstype (CONSTstype sz))
     | visitExp s (CLOSUREexp (t,sym,es)) =
         let
            val (SOME decl) = SymMap.find (#origDecls (s : state), sym)
            val (CLOSUREdecl {
                    closureName = name,
                    closureArgs = tsCl,
                    closureDelegate = del,
                    closureDelArgs = ts
                 }) = decl
            val isCl = not (List.null es)
            val stypesCl = map (visitExp s) es
            val stypes = map (fn (_,arg) => symType s arg) ts
            val resVar = freshTVar s
            val _ = lub (s,symType s del,  FUNstype (resVar, isCl, stypesCl @ stypes))
            val _ = lub (s,symType s name, FUNstype (resVar, isCl, stypes))
            val _ = msg ("CLOSURE: looking for symbol " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ ": " ^ showSType (inlineSType s (symType s name)) ^ "\n")
         in
           FUNstype (resVar, isCl, stypes)
         end
     | visitExp s (STATEexp (b,e)) = (visitBlock s b; FUNstype (visitExp s e,false,[]))
     | visitExp s (EXECexp e) =
      let
         val resVar = freshTVar s
         val _ = lub (s,visitExp s e, FUNstype (resVar, false, []))
      in
         resVar
      end
   
   and visitCall s (fTy,args) =
      let
         val resTy = freshTVar s
         val _ = lub (s,FUNstype (resTy,false,map (visitExp s) args),fTy)
      in
         resTy
      end

   fun visitDecl s (f as FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = block,
        funcRes = res
      }) =
      let
         (*val _ = if SymbolTable.toInt name = 423 then debugOn := true else ()*)
         val _ = msg ("visitDecl start " ^ SymbolTable.getString(!SymbolTables.varTable, name) ^ "\n" ^ Layout.tostring (Imp.PP.decl f) ^ "\n")
         val _ = visitBlock s block
         fun argTypes args = map (fn (_,sym) => symType s sym) args
         val ty = FUNstype (symType s res, not (null clArgs), argTypes clArgs @ argTypes args)
         val _ = msg ("visitDecl basic type " ^ SymbolTable.getString(!SymbolTables.varTable, name) ^ " : " ^ showSType (ty) ^ "\n")
         val _ = msg ("visitDecl end   " ^ SymbolTable.getString(!SymbolTables.varTable, name) ^ " : " ^ showSType (inlineSType s ty) ^ "\n")
      in
         lub (s, symType s name, ty)
      end
     | visitDecl s (SELECTdecl {
         selectName = name,
         selectField = f,
         selectType = _
      }) = lub (s, symType s name, FUNstype (fieldType s f, false, [freshTVar s]))
     | visitDecl s (UPDATEdecl {
         updateName = name,
         updateArg = arg,
         updateFields = fs,
         updateType = _
      }) = lub (s, symType s name, FUNstype (symType s arg,true, map (fieldType s) fs @ [symType s arg]))
     | visitDecl s (CONdecl {
         conName = name,
         conArg = arg,
         conType = _
     }) = lub (s, symType s name, FUNstype (BOXstype OBJstype, false, [symType s arg]))
     | visitDecl s (CLOSUREdecl {
        closureName = name,
        closureArgs = clTys,
        closureDelegate = _,
        closureDelArgs = args
     })= lub (s, symType s name, FUNstype (freshTVar s, not (List.null clTys), map (symType s o #2) args))

   (* Perform a type transformation for every symbol, based on the least
   required type inferred in the previous traversal. In the inital tree, every
   varable was of type OBJvtype. If it is now known to have type INT, every
   use is wrapped with BOX (INTvtype,.) and every assignment to it is wrapped
   by UNBOX (INTvtype,.). *)
   
   fun origFType (s : state) sym = case SymMap.find (#origFields s, sym) of
      SOME t => t
    | NONE => (TextIO.print ("origFType: no type of " ^ SymbolTable.getString(!SymbolTables.fieldTable, sym) ^ "\n"); raise TypeOptBug)

   fun origType (s : state) sym = case SymMap.find (!(#origLocals s), sym) of
      SOME t => t
    | NONE => (case SymMap.find (#origDecls s, sym) of
          (SOME (FUNCdecl { funcType = ty, ... })) => ty
        | (SOME (SELECTdecl { selectType = ty, ... })) => ty
        | (SOME (UPDATEdecl { updateType = ty, ... })) => ty
        | (SOME (CONdecl { conType = ty, ... })) => ty
        | (SOME (CLOSUREdecl { closureArgs = ts, ... })) => FUNvtype (OBJvtype,true,ts)
        | NONE => (TextIO.print ("origType: no type of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n"); raise TypeOptBug)
      )
 
   fun getArgTypes s sym = case SymMap.find (#origDecls s, sym) of
          SOME (FUNCdecl { funcArgs = args, ... }) =>
            map (fn (t,sym) => (t,symType s sym)) args
        | SOME (SELECTdecl { selectField = f, ... }) =>
            [(origFType s f, fieldType s f)]
        | SOME (UPDATEdecl { updateName = sym, updateType = t, ... }) =>
            (case (t,inlineSType s (symType s sym)) of
                (FUNvtype (_,_,vArgs), FUNstype (_,_,sArgs)) => ListPair.zip (vArgs,sArgs)
              | (v,s) => (TextIO.print ("getArgTypes: update function " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " has unequal no of args: " ^ Layout.tostring (Imp.PP.vtype v) ^ " and " ^ showSType s ^ "\n"); raise TypeOptBug)
            )
        | SOME (CONdecl { conName = name, conArg = arg, ... }) =>
            [(origType s arg, symType s arg)]
        | SOME (CLOSUREdecl { closureName = name, closureArgs = ts, ... }) =>
            (case inlineSType s (symType s name) of
               (FUNstype (_,_,args)) => ListPair.zip (ts,args)
             | t => (TextIO.print ("getArgTypes: closure not function but " ^ SymbolTable.getString(!SymbolTables.varTable, name) ^ " has type " ^ showSType t ^ "\n"); raise TypeOptBug)
            )
        | NONE =>  (TextIO.print ("getArgTypes, symbol " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " not found\n"); raise TypeOptBug)

   fun readWrap s (OBJvtype,t,e) = (case inlineSType s t of
          (BOXstype INTstype) => BOXexp (INTvtype,e)
        | (BOXstype (BITstype (CONSTstype s))) => BOXexp (BITvtype, INT2VECexp (s,e))
        | (BOXstype (BITstype _)) => BOXexp (BITvtype, e)
        | _ => e
       )
     | readWrap s (FUNvtype (rOrig,_,_),t,e) = (case inlineSType s t of
          (FUNstype (rNew,_,_)) => readWrap s (rOrig,rNew,e)
        |  t => e
       )
     | readWrap s (_,_,e) = e

   and writeWrap s (OBJvtype,t,e) = (case inlineSType s t of
          (BOXstype INTstype) => UNBOXexp (INTvtype,e)
        | (BOXstype (BITstype (CONSTstype s))) => VEC2INTexp (SOME s,UNBOXexp (BITvtype, e))
        | (BOXstype (BITstype _)) => UNBOXexp (BITvtype, e)
        | _ => e
       )
     | writeWrap s (FUNvtype (rOrig,_,_),t,e) = (case inlineSType s t of
          (FUNstype (rNew,_,_)) => writeWrap s (rOrig,rNew,e)
        | t => e
       )
     | writeWrap s (_,_,e) = e
   
   and adjustType s (OBJvtype,t) = (case inlineSType s t of
          (BOXstype INTstype) => INTvtype
        | (BOXstype (BITstype (CONSTstype _))) => INTvtype
        | (BOXstype (BITstype _)) => BITvtype
        | (BOXstype _) => OBJvtype
        | (BITstype (CONSTstype _)) => INTvtype
        | (BITstype _) => BITvtype
        | (VOIDstype) => VOIDvtype
        | (STRINGstype) => STRINGvtype
        | (OBJstype) => OBJvtype
        | (FUNstype (r,cl,args)) =>
            FUNvtype (adjustType s (OBJvtype,r), cl, map (fn arg => adjustType s (OBJvtype, arg)) args)
        | t => (TextIO.print ("adjustType of " ^ showSType t ^ "\n"); raise TypeOptBug)
      )
     | adjustType s (FUNvtype (rOrig,clOrig,argsOrig),t) = (case inlineSType s t of
          (FUNstype (r,cl,args)) => (
            FUNvtype (adjustType s (rOrig,r), cl, map (adjustType s) (ListPair.zipEq (argsOrig, args)))
               handle ListPair.UnequalLengths =>
                  (TextIO.print ("adjustType of " ^ Layout.tostring (Imp.PP.vtype (FUNvtype (rOrig,clOrig,argsOrig))) ^ " and " ^ showSType (FUNstype (r,cl,args)) ^ "\n"); raise TypeOptBug)
          )
        | t => OBJvtype
      )
     | adjustType s (t,_) = t

   fun patchDecl s (FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = body,
        funcRes = res
      }) =
      let
         (*val _ = if SymbolTable.toInt name = 423 then debugOn := true else ()*)
         (*val _ = TextIO.print ("patchDecl of function " ^ SymbolTable.getString(!SymbolTables.varTable, name) ^ "\n")*)
         val clArgs' = map (fn (t,sym) => (adjustType s (t,symType s sym),sym)) clArgs
         val args' = map (fn (t,sym) => (adjustType s (t,symType s sym),sym)) args
         val vtype' = adjustType s (vtype, symType s name)
         val resTy = case vtype of
               FUNvtype (resTy,_,_) => resTy
             | _ => OBJvtype
         val _ = (#origLocals s) :=
            foldl (fn ((ty,sym),m) => SymMap.insert (m,sym,ty)) SymMap.empty
               ((resTy,res) :: clArgs @ args)
         val body' = patchBlock s body
      in
         FUNCdecl {
            funcMonadic = monkind,
            funcClosure = clArgs',
            funcType = vtype',
            funcName = name,
            funcArgs = args',
            funcBody = body',
            funcRes = res
         }
      end
     | patchDecl s (SELECTdecl {
         selectName = name,
         selectField = f,
         selectType = vtype
      }) = SELECTdecl {
         selectName = name,
         selectField = f,
         selectType = adjustType s (vtype, symType s name)
      }
     | patchDecl s (UPDATEdecl {
         updateName = name,
         updateArg = arg,
         updateFields = fs,
         updateType = vtype
      }) = UPDATEdecl {
         updateName = name,
         updateArg = arg,
         updateFields = fs,
         updateType = adjustType s (vtype, symType s name)
      }
     | patchDecl s (CONdecl {
         conName = name,
         conArg = arg,
         conType = vtype
     }) = CONdecl {
         conName = name,
         conArg = arg,
         conType = adjustType s (vtype, symType s name)
     }
     | patchDecl s (CLOSUREdecl {
         closureName = name,
         closureArgs = tsCl,
         closureDelegate = del,
         closureDelArgs = delArgs
     }) = (case adjustType s (FUNvtype (OBJvtype,false,tsCl @ map #1 delArgs), symType s del) of
         FUNvtype (_,_,args) =>
         let
            val len = List.length tsCl
            val tsClNew = List.take (args,len)
            val argsNew = List.drop (args,len)
            val delArgsNew = map (fn ((t,a),t') => (t',a)) (ListPair.zipEq (delArgs,argsNew))
                  handle ListPair.UnequalLengths => raise TypeOptBug
         in
            CLOSUREdecl {
               closureName = name,
               closureArgs = tsClNew,
               closureDelegate = del,
               closureDelArgs = delArgsNew
            }
         end
       | _ => raise TypeOptBug
      )

   and patchBlock s (BASICblock (decls, stmts)) =
      let
         val _ = (#origLocals s) :=
            foldl (fn ((ty,sym),m) => SymMap.insert (m,sym,ty)) (!(#origLocals s)) decls
         val decls' = map (fn (t,sym) => (adjustType s (t,symType s sym),sym)) decls
         val stmts' = map (patchStmt s) stmts
      in
         BASICblock (decls',stmts')
      end

   and patchStmt s (ASSIGNstmt (NONE,exp)) = ASSIGNstmt (NONE, patchExp s exp)
     | patchStmt s (ASSIGNstmt (SOME sym,exp)) = (case inlineSType s (symType s sym) of
           VOIDstype => ASSIGNstmt (NONE, patchExp s exp)
         | _ => ASSIGNstmt (SOME sym,
                  writeWrap s (origType s sym,symType s sym,patchExp s exp))
      )
     | patchStmt s (IFstmt (c,t,e)) = IFstmt (patchExp s c, patchBlock s t, patchBlock s e)
     | patchStmt s (CASEstmt (e,ps)) = CASEstmt (patchExp s e, map (patchCase s) ps)

   and patchCase s (p,stmts) = (p, patchBlock s stmts)
   
   and patchExp s (IDexp sym) = readWrap s (origType s sym, symType s sym, IDexp sym)
     | patchExp s (PRIexp (m,f,t,es)) = PRIexp (m,f,t,map (patchExp s) es)
     | patchExp s (CALLexp (m, sym,es)) =
      let
         val (wrap, tyNew, esNew) = patchArgs s (origType s sym, symType s sym, map (patchExp s) es)
      in
         wrap (CALLexp (m, sym, esNew))
      end
     | patchExp s (INVOKEexp (m, ty, e, es)) =
      let
         val eNew = patchExp s e
         val (wrap, tyNew, esNew) = patchArgs s (ty, visitExp s e, map (patchExp s) es)
      in
         wrap (INVOKEexp (m, tyNew, eNew, esNew))
      end
     | patchExp s (RECORDexp fs) = RECORDexp (map (fn (f,e) =>
         (f, writeWrap s (origFType s f, fieldType s f, patchExp s e))) fs)
     | patchExp s (LITexp l) = LITexp l
     | patchExp s (BOXexp (t,e)) = BOXexp (t, patchExp s e)
     | patchExp s (UNBOXexp (t,e)) = UNBOXexp (t, patchExp s e)
     | patchExp s (VEC2INTexp (sz,e)) = VEC2INTexp (sz,patchExp s e)
     | patchExp s (INT2VECexp (sz,e)) = INT2VECexp (sz, patchExp s e)
     | patchExp s (CLOSUREexp (ty,sym,es)) =
      let
         val (wrap, tyNew,esNew) = patchArgs s (ty, symType s sym, map (patchExp s) es)
      in
         wrap (CLOSUREexp (tyNew,sym,esNew))
      end
     | patchExp s (STATEexp (b,e)) = STATEexp (patchBlock s b, patchExp s e)
     | patchExp s (EXECexp e) = EXECexp (patchExp s e)
   
   and patchArgs s (orig,new,es) =
      let
         fun genNewArgs acc (FUNvtype (vRes, vCl, vType :: vs),
                             FUNstype (sRes, sCl, sType :: ss), e :: es) =
               genNewArgs (acc @ [writeWrap s (vType,sType,e)])
                  (FUNvtype (vRes, vCl, vs), FUNstype (sRes, sCl, ss), es)
           | genNewArgs acc (OBJvtype, FUNstype (sRes, sCl, ss), es) =
               genNewArgs acc (FUNvtype (OBJvtype, false, map (fn _ => OBJvtype) ss),
                               FUNstype (sRes, sCl, ss), es)
           | genNewArgs acc (vs, ss, []) = (acc, vs, ss)
           | genNewArgs acc (v,s,e :: es) = (TextIO.print ("patchArgs of " ^ Layout.tostring (Imp.PP.vtype v) ^ " and " ^ showSType s ^ ", next argument is " ^ Layout.tostring (Imp.PP.exp e) ^ "\n"); raise TypeOptBug)

      in
        case genNewArgs [] (orig, inlineSType s new, es) of
           (es, FUNvtype (vRes, vCl, []), FUNstype (sRes, sCl, [])) =>
            (fn e => readWrap s (vRes, sRes, e), adjustType s (vRes, sRes), es)
         | (es, v, t) => (TextIO.print ("patchArgs of " ^ Layout.tostring (Imp.PP.vtype v) ^ " and " ^ showSType (inlineSType s t) ^ "\n"); raise TypeOptBug)
     end
   fun run { decls = ds, fdecls = fs } =
      let

         val declMap = foldl (fn (decl,m) => SymMap.insert (m,getDeclName decl, decl)) SymMap.empty ds
         val state : state = {
            symType = ref SymMap.empty,
            fieldType = ref SymMap.empty,
            typeTable = DynamicArray.array (4000, VOIDstype),
            origDecls = declMap,
            origLocals = ref SymMap.empty,
            origFields = fs
         }
         fun visitDeclPrint state d = (TextIO.print ("visiting " ^ SymbolTable.getString(!SymbolTables.varTable, getDeclName d) ^ "\n"); visitDecl state d)
         val _ = map (visitDeclPrint state) ds
         val _ = showState state
         fun patchDeclPrint state d = (TextIO.print ("patching " ^ SymbolTable.getString(!SymbolTables.varTable, getDeclName d) ^ "\n"); patchDecl state d)
         val ds = map (patchDeclPrint state) ds
         val fs = SymMap.mapi (fn (sym,ty) => adjustType state (ty, symType state sym)) fs
      in
         { decls = ds, fdecls = fs }
      end
   
end

structure StatePassing = struct
   val name = "statePassing"

   open Imp
      
   fun lub (ACTmonkind, _) = ACTmonkind
     | lub (_, ACTmonkind) = ACTmonkind
     | lub _ = PUREmonkind

   fun genLub ({ current, state = s}, m, sym) = lub (m, SymMap.lookup (!s,sym))
   fun raiseCurrent ({ current = sym, state = s},m) =
      s := SymMap.insert (!s, sym, lub (m, SymMap.lookup (!s, sym)))

   fun visitBlock s (BASICblock (decls,stmts)) = BASICblock (decls, map (visitStmt s) stmts)
   
   and visitStmt s (ASSIGNstmt (res,exp)) = ASSIGNstmt (res, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, visitBlock s t, visitBlock s e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)

   and visitCase s (p,stmts) = (p, visitBlock s stmts)
   
   and visitExp s (PRIexp (m,f,t,es)) = (raiseCurrent (s,m); PRIexp (m,f,t,map (visitExp s) es))
     | visitExp s (CALLexp (m,sym,es)) = (raiseCurrent (s,m); CALLexp (genLub (s,m,sym), sym, map (visitExp s) es))
     | visitExp s (INVOKEexp (m,t,e,es)) = (raiseCurrent (s,m); INVOKEexp (m,t,visitExp s e, map (visitExp s) es))
     | visitExp s (RECORDexp fs) = RECORDexp (map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (BOXexp (t,e)) = BOXexp (t, visitExp s e)
     | visitExp s (UNBOXexp (t,e)) = UNBOXexp (t, visitExp s e)
     | visitExp s (VEC2INTexp (sz,e)) = VEC2INTexp (sz, visitExp s e)
     | visitExp s (INT2VECexp (sz,e)) = INT2VECexp (sz, visitExp s e)
     | visitExp s (CLOSUREexp (t,sym,es)) = CLOSUREexp (t,sym,map (visitExp s) es)
     | visitExp s (STATEexp (b,e)) = STATEexp (visitBlock s b, visitExp s e)
     | visitExp s (EXECexp e) = (raiseCurrent (s,ACTmonkind); EXECexp (visitExp s e))
     | visitExp s e = e

   fun visitDecl s (FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = body,
        funcRes = res
      }) = FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = visitBlock { current = name, state = s} body,
        funcRes = res
      }
     | visitDecl s d = d

   fun run { decls = ds, fdecls = fs } =
      let
         fun insSymbol (FUNCdecl { funcName = name, funcMonadic = k, ... },m) = SymMap.insert (m,name, k)
           | insSymbol (SELECTdecl { selectName = name, ... },m) = SymMap.insert (m,name, ACTmonkind)
           | insSymbol (UPDATEdecl { updateName = name, ... },m) = SymMap.insert (m,name, ACTmonkind)
           | insSymbol (CONdecl { conName = name, ... },m) = SymMap.insert (m,name, ACTmonkind)
           | insSymbol (CLOSUREdecl { closureName = name, ... },m) = SymMap.insert (m,name, ACTmonkind)
         val stateRef = ref (foldl insSymbol SymMap.empty ds)
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
         { decls = ds, fdecls = fs }
      end
   
end

