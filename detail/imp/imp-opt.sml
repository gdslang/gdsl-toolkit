structure Simplify = struct
   val name = "simplify"

   open Imp
      
   fun visitStmt s (ASSIGNstmt (res,exp)) = ASSIGNstmt (res, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, map (visitStmt s) t, map (visitStmt s) e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)

   and visitCase s (p,stmts) = (p, map (visitStmt s) stmts)
   
   and visitExp s (PRIexp (m,f,t,es)) = PRIexp (m,f,t,map (visitExp s) es)
     | visitExp s (IDexp sym) = IDexp sym
     | visitExp s (CALLexp (m, sym,es)) = 
      let
         val { prim_map = prim_map } = s
         (*val _ = TextIO.print ("checking call " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")*)
      in
         case SymMap.find (prim_map, sym) of
            SOME (_,gen) => visitExp s (gen es)
          | NONE => CALLexp (m, sym, map (visitExp s) es)
      end
     | visitExp s (INVOKEexp (m, t, e, es)) = (case visitExp s e of
         CLOSUREexp (t,sym,ess) => visitExp s (CALLexp (m, sym, ess @ es))
       | e => INVOKEexp (m, t, e, map (visitExp s) es)
     )
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
     | visitExp s (STATEexp e) = STATEexp (visitExp s e)
     | visitExp s (EXECexp e) = (case visitExp s e of
            STATEexp e => e
          | CLOSUREexp (t,sym,es) => visitExp s (EXECexp (CALLexp (INOUTmonkind, sym, es)))
          | e => EXECexp e
        )

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

   fun run ({ decls = ds, fdecls = fs } : imp) =
      let
         fun get s = VarInfo.lookup (!SymbolTables.varTable, Atom.atom s)
         val prim_map =
            foldl (fn ((k,v),m) => SymMap.insert (m,get k,v))
               SymMap.empty ImpFromCore.prim_table
         val state = { prim_map = prim_map }
         val ds = map (visitDecl state) ds
      in
         { decls = ds, fdecls = fs } : imp
      end
   
end

(*structure Simplify = struct
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
     | visitExp s (STATEexp e) = STATEexp (visitExp s e)
     | visitExp s (EXECexp e) = (case visitExp s e of
            STATEexp e => e
          | e => EXECexp e
        )
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

   fun run { decls = ds, fdecls = fs } =
      let
         val state = {}
         val ds = map (visitDecl state) ds
      in
         { decls = ds, fdecls = fs }
      end
   
end*)

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
     origDecls : decl SymMap.map,
     origLocals : (vtype SymMap.map) ref,
     origFields : vtype SymMap.map
   }
   
   fun showSType (VARstype idx) = "#" ^ Int.toString idx
     | showSType (BOXstype t) = "box(" ^ showSType t ^ ")"
     | showSType (FUNstype (res,cl,args)) = (if cl then "(..." else "(") ^ #1 (
         foldl (fn (t,(str,sep)) => (str ^ sep ^ showSType t,","))
            ("", "") args
         ) ^ ") -> (" ^ showSType res ^ ")"
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
         (*val _ = app showSymBinding (SymMap.listItemsi (!st))*)
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
         val vars = ref ([] : stype list)
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
               (*if List.exists (fn x => x=ecr) (!vars) then
                  (TextIO.print ("occurs check via " ^ showSType ecr ^ " when unifying " ^ showSType xTy ^ " and " ^ showSType yTy ^ "\n"); raise TypeOptBug)
               else (vars := ecr :: (!vars); ecr)*)
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
               (*if List.exists (fn x => x=ecr) (!vars) then
                  (TextIO.print "occurs check!\n"; raise TypeOptBug)
               else (vars := ecr :: (!vars); ecr)*)
            end
           | lub (t, VARstype idx) = lub (VARstype idx, t)
           | lub (VOIDstype, t) = t
           | lub (t, VOIDstype) = t
           | lub (FUNstype (r1, clos1, args1), FUNstype (r2, clos2, args2)) =
            (case lubArgs [] (args1,args2) of
                 (args,([],[])) => FUNstype (lub (r1,r2), clos1 orelse clos2, args)
               | (args,(xs,[])) =>
                  FUNstype (lub (FUNstype (r1,clos1,xs), r2), true, args)
               | (args,(_,ys)) =>
                  FUNstype (lub (r1, FUNstype (r2,clos2,ys)), true, args)
            )
           | lub (BITstype s1, BITstype s2) = BITstype (lub (s1,s2))
           | lub (CONSTstype s1, CONSTstype s2) =
               if s1=s2 then CONSTstype s1 else OBJstype
           | lub (INTstype, INTstype) = INTstype
           | lub (STRINGstype, STRINGstype) = STRINGstype
           | lub (BOXstype t1, BOXstype t2) = BOXstype (lub (t1,t2))
           | lub (OBJstype, OBJstype) = OBJstype
           | lub (t1, t2) = (TextIO.print ("lub top for " ^ showSType t1 ^ "," ^ showSType t2 ^ "\n"); OBJstype)

         and lubArgs acc (x::xs, y::ys) = lubArgs (acc @ [lub (x,y)]) (xs, ys)
           | lubArgs acc rem = (acc,rem)
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
     | visitExp s (INVOKEexp (m,t,e,es)) = visitCall s (visitExp s e, es)
     | visitExp s (RECORDexp fs) = (map (fn (f,e) => lub (s,fieldType s f,visitExp s e)) fs; BOXstype OBJstype)
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
            fun getDecTy (FUNCdecl { funcName = name,
                                     funcClosure = clArgs,
                                     funcArgs = args,
                                     funcRes = res, ... }) =
                  (map (symType s o #2) clArgs,map (symType s o #2) args,visitExp s res)
              | getDecTy (SELECTdecl { selectName = name,
                                       selectField = f, ... }) =
                  ([],[OBJstype],fieldType s f)
              | getDecTy (UPDATEdecl { updateName = name,
                                       updateFields = fs, ... }) =
                  (map (fieldType s) fs,[OBJstype],OBJstype)
              | getDecTy (CONdecl { conName = name, conArg = arg, ... }) =
                  ([],[symType s arg],OBJstype)

            val (clArgTys, argTys, resTy) = getDecTy (SymMap.lookup (#origDecls (s : state), sym))
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
         (*val _ = TextIO.print ("visitDecl " ^ SymbolTable.getString(!SymbolTables.varTable, name) ^ "\n")*)
         val _ = app (visitStmt s) stmts
         val t = visitExp s res
         fun argTypes args = map (fn (_,sym) => symType s sym) args
         val ty = FUNstype (t, not (null clArgs), argTypes clArgs @ argTypes args)
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
         updateFields = fs,
         updateType = _
      }) = lub (s, symType s name, FUNstype (freshTVar s, true, map (fieldType s) fs @ [freshTVar s]))
     | visitDecl s (CONdecl {
         conName = name,
         conArg = arg,
         conType = _
     }) = lub (s, symType s name, FUNstype (OBJstype, false, [symType s arg]))

   (* Perform a type transformation for every symbol, based on the least
   required type inferred in the previous traversal. In the inital tree, every
   varable was of type OBJvtype. If it is now known to have type INT, every
   use is wrapped with BOX (INTvtype,.) and every assignment to it is wrapped
   by UNBOX (INTvtype,.). *)
   
   fun origFType (s : state) sym = SymMap.lookup (#origFields s, sym)

   fun origType (s : state) sym = case SymMap.find (!(#origLocals s), sym) of
      SOME t => t
    | NONE => (case SymMap.find (#origDecls s, sym) of
          (SOME (FUNCdecl { funcType = ty, ... })) => ty
        | (SOME (SELECTdecl { selectType = ty, ... })) => ty
        | (SOME (UPDATEdecl { updateType = ty, ... })) => ty
        | (SOME (CONdecl { conType = ty, ... })) => ty
        | NONE => (TextIO.print ("origType: no type of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n"); raise TypeOptBug)
      )
 
   fun getArgTypes s sym = case SymMap.lookup (#origDecls s, sym) of
          (FUNCdecl { funcArgs = args, ... }) =>
            map (fn (t,sym) => (t,symType s sym)) args
        | (SELECTdecl { selectField = f, ... }) =>
            [(origFType s f, fieldType s f)]
        | (UPDATEdecl { updateName = sym, updateType = t, ... }) =>
            (case (t,inlineSType s (symType s sym)) of
                (FUNvtype (_,_,vArgs), FUNstype (_,_,sArgs)) => ListPair.zipEq (vArgs,sArgs)
              | (v,s) => (TextIO.print ("update function " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " has unequal no of args: " ^ Layout.tostring (Imp.PP.vtype v) ^ " and " ^ showSType s ^ "\n"); raise TypeOptBug)
            )
        | (CONdecl { conName = name, conArg = arg, ... }) =>
            [(origType s arg, symType s arg)]

   fun readWrap s (OBJvtype,t,e) = (case inlineSType s t of
          (BOXstype INTstype) => BOXexp (INTvtype,e)
        | (BOXstype (BITstype (CONSTstype s))) => BOXexp (BITvtype, INT2VECexp (s,e))
        | (BOXstype (BITstype _)) => BOXexp (BITvtype, e)
        | (BITstype (CONSTstype s)) => INT2VECexp (s,e)
        | (BITstype _) => e
        | (VOIDstype) => RECORDexp []
        | _ => e
       )
     (*| readWrap s (FUNvtype (rOrig,_,_),t,e) = (case inlineSType s t of
          (FUNstype (rNew,_,_)) => writeWrap s (rOrig,rNew,e)
        |  t => e
       )*)
     | readWrap s (_,_,e) = e

   and writeWrap s (OBJvtype,t,e) = (case inlineSType s t of
          (BOXstype INTstype) => UNBOXexp (INTvtype,e)
        | (BOXstype (BITstype (CONSTstype s))) => VEC2INTexp (SOME s,UNBOXexp (BITvtype, e))
        | (BOXstype (BITstype _)) => UNBOXexp (BITvtype, e)
        | (BITstype (CONSTstype s)) => VEC2INTexp (SOME s,e)
        | (BITstype _) => e
        | (VOIDstype) => RECORDexp []
        | _ => e
       )
     (*| writeWrap s (FUNvtype (rOrig,_,_),t,e) = (case inlineSType s t of
          (FUNstype (rNew,_,_)) => readWrap s (rOrig,rNew,e)
        | t => e
       )*)
     | writeWrap s (_,_,e) = e
   
   fun adjustType s (OBJvtype,t) = (case inlineSType s t of
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
          (FUNstype (r,cl,args)) =>
            if List.length argsOrig = List.length args then
            FUNvtype (adjustType s (rOrig,r), cl, map (adjustType s) (ListPair.zip (argsOrig, args)))
            else
            (TextIO.print ("adjustType of " ^ Layout.tostring (Imp.PP.vtype (FUNvtype (rOrig,clOrig,argsOrig))) ^ " and " ^ showSType (FUNstype (r,cl,args)) ^ "\n"); raise TypeOptBug)
        | t => OBJvtype
      )
     | adjustType s (t,_) = t

   fun patchDecl s (FUNCdecl {
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
         val clArgs' = map (fn (t,sym) => (adjustType s (t,symType s sym),sym)) clArgs
         val args' = map (fn (t,sym) => (adjustType s (t,symType s sym),sym)) args
         val vtype' = adjustType s (vtype, symType s name)
         val locals' = map (fn (t,sym) => (adjustType s (t,symType s sym),sym)) locals
         val _ = (#origLocals s) :=
            foldl (fn ((ty,sym),m) => SymMap.insert (m,sym,ty)) SymMap.empty (locals @ clArgs @ args)
         val res' = writeWrap s (origType s name,symType s name,res)
         val stmts' = map (patchStmt s) stmts
      in
         FUNCdecl {
            funcMonadic = monkind,
            funcClosure = clArgs',
            funcType = vtype',
            funcName = name,
            funcArgs = args',
            funcLocals = locals',
            funcBody = stmts',
            funcRes = res'
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
         updateFields = fs,
         updateType = vtype
      }) = UPDATEdecl {
         updateName = name,
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

   and patchStmt s (ASSIGNstmt (NONE,exp)) = ASSIGNstmt (NONE, patchExp s exp)
     | patchStmt s (ASSIGNstmt (SOME sym,exp)) =
         ASSIGNstmt (SOME sym, writeWrap s (origType s sym,symType s sym,patchExp s exp))
     | patchStmt s (IFstmt (c,t,e)) = IFstmt (patchExp s c, map (patchStmt s) t, map (patchStmt s) e)
     | patchStmt s (CASEstmt (e,ps)) = CASEstmt (patchExp s e, map (patchCase s) ps)

   and patchCase s (p,stmts) = (p, map (patchStmt s) stmts)
   
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
         val (wrap, tyNew, esNew) = patchArgs s (ty, symType s sym, map (patchExp s) es)
      in
         wrap (CLOSUREexp (tyNew,sym,esNew))
      end
     | patchExp s (STATEexp e) = STATEexp (patchExp s e)
     | patchExp s (EXECexp e) = EXECexp (patchExp s e)
   
   and patchArgs s (orig,new,es) =
      let
         fun genNewArgs acc (vType :: vs, sType :: ss, e :: es) =
               genNewArgs (acc @ [readWrap s (vType,sType,e)]) (vs, ss, es)
           | genNewArgs acc (vs, ss, []) = (acc, ss)
           | genNewArgs acc ([], ss, es) = genNewArgs acc ([OBJvtype], ss, es)
           | genNewArgs acc _ = raise TypeOptBug
         val (vRes, vCl, vArgs) = case orig of
               FUNvtype (vRes, vCl, vArgs) => (vRes, vCl, vArgs)
             | OBJvtype => (OBJvtype, false, [])
             | _ => raise TypeOptBug
         val (sRes, sCl, sArgs) = case inlineSType s new of
               FUNstype (sRes, sCl, sArgs) => (sRes, sCl, sArgs)
             | _ => raise TypeOptBug
      in
        case genNewArgs [] (vArgs, sArgs, es) of
           (es, []) => (fn e => readWrap s (vRes, sRes, e), adjustType s (vRes, sRes), es)
         | (es, ss) => (fn e => readWrap s (vRes, sRes, e), FUNvtype (
            adjustType s (vRes, sRes), vCl orelse sCl,
            map (fn sType => adjustType s (OBJvtype, sType)) ss),
            es)
     end
   fun run { decls = ds, fdecls = fs } =
      let
         fun getDeclName (FUNCdecl { funcName = name, ... }) = name
           | getDeclName (SELECTdecl { selectName = name, ... }) = name
           | getDeclName (UPDATEdecl { updateName = name, ... }) = name
           | getDeclName (CONdecl { conName = name, ... }) = name

         val declMap = foldl (fn (decl,m) => SymMap.insert (m,getDeclName decl, decl)) SymMap.empty ds
         val state : state = {
            symType = ref SymMap.empty,
            fieldType = ref SymMap.empty,
            typeTable = DynamicArray.array (4000, VOIDstype),
            origDecls = declMap,
            origLocals = ref SymMap.empty,
            origFields = fs
         }
         val _ = map (visitDecl state) ds
         val _ = showState state
         val ds = map (patchDecl state) ds
         val fs = SymMap.mapi (fn (sym,ty) => adjustType state (ty, symType state sym)) fs
      in
         { decls = ds, fdecls = fs }
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
     | visitExp s (CALLexp (m,sym,es)) = (raiseCurrent (s,m); CALLexp (genLub (s,m,sym), sym, map (visitExp s) es))
     | visitExp s (INVOKEexp (m,t,e,es)) = (raiseCurrent (s,m); INVOKEexp (m,t,visitExp s e, map (visitExp s) es))
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

   fun run { decls = ds, fdecls = fs } =
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
         { decls = ds, fdecls = fs }
      end
   
end

