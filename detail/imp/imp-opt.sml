
structure PatchFunctionCalls = struct
   val name = "patch-function-calls"

   open Imp
   
   fun visitStmt s (ASSIGNstmt (res,exp)) = ASSIGNstmt (res, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, visitBlock s t, visitBlock s e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)
   
   and visitCase s (p,stmts) = (p, visitBlock s stmts)
   
   and visitBlock s (BASICblock (decls, stmts)) = BASICblock (decls, map (visitStmt s) stmts)
   
   and visitExp s (PRIexp (m,f,t,es)) = PRIexp (m,f,t,map (visitExp s) es)
     | visitExp s (IDexp sym) = IDexp sym
     | visitExp s (CALLexp (m, sym,es)) = CALLexp (m, sym, map (visitExp s) es)
     | visitExp s (INVOKEexp (m, t, e, es)) = (case visitExp s e of
         IDexp sym => (case SymMap.find (!Primitives.prim_map, sym) of
            SOME (_,gen) => visitExp s (gen es)
          | NONE => INVOKEexp (m, t, e, map (visitExp s) es)
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
       | e => e
      )
         

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

structure ActionClosures = struct
   val name = "action-closures"

   open Imp

   type state = { pureToMonRef : SymbolTable.symid SymMap.map ref,
                  monVars : SymSet.set,
                  declsRef : arg list ref,
                  stmtsRef : stmt list ref }
   fun addMonSym ({ pureToMonRef = pureToMonRef,
                    monVars = monVars,
                    declsRef = declsRef,
                    stmtsRef = stmtsRef },sym) =
      { pureToMonRef = pureToMonRef,
        monVars = SymSet.add(monVars,sym),
        declsRef = declsRef,
        stmtsRef = stmtsRef } : state

   fun getClosureSym sym =
      let
         val tab = !SymbolTables.varTable
         val atm = Atom.atom (SymbolTable.getString (tab,sym) ^ "Mon")
       in
         case SymbolTable.find (tab,atm) of
            SOME res => res
          | NONE =>
            let
               val (tab, res) = SymbolTable.fresh (tab, atm)
               val _ = SymbolTables.varTable := tab
            in
               res
            end
      end

   fun addMonClosures (s : state) ((d as FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = BASICblock (decls,stmts),
        funcRes = res
      }) :: ds) = (case stmts of
         [ASSIGNstmt (lhs,STATEexp block)] =>
         let
            val tab = !SymbolTables.varTable
            val atm = Atom.atom (SymbolTable.getString (tab,name) ^ "Mon")
            val (tab, mon) = SymbolTable.fresh (tab, atm)
            val _ = SymbolTables.varTable := tab
            val _ = (#pureToMonRef s) := SymMap.insert (!(#pureToMonRef s), name, mon)
         in
            FUNCdecl {
               funcMonadic = ACTmonkind,
               funcClosure = clArgs,
               funcType = vtype,
               funcName = mon,
               funcArgs = args,
               funcBody = BASICblock (decls,[ASSIGNstmt (lhs,EXECexp (STATEexp block))]),
               funcRes = res
            } :: CLOSUREdecl {
               closureName = name,
               closureArgs = map #1 (clArgs @ args),
               closureDelegate = mon,
               closureDelArgs = []
            } :: addMonClosures s ds
         end
       | _ => d :: addMonClosures s ds
      )
    | addMonClosures (s : state) (d :: ds) = d :: addMonClosures s ds
    | addMonClosures (s : state) [] = []
         
   fun isMonVar (s : state, sym) = case SymMap.find (!(#pureToMonRef s),sym) of
      SOME mon => true
    | NONE => SymSet.member (#monVars s, sym)

   fun visitBlock s (BASICblock (decls,stmts)) =
      let
         val s' = { pureToMonRef = #pureToMonRef s,
                    monVars = #monVars s,
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
         if isMonVar (s, sym) then
            ASSIGNstmt (SOME sym, visitExp s (EXECexp exp))
         else
            ASSIGNstmt (SOME sym, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, visitBlock s t, visitBlock s e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)

   and visitCase s (p,stmts) = (p, visitBlock s stmts)
   
   and visitExp s (IDexp sym) =
      if isMonVar ((s : state),sym) then
         STATEexp (BASICblock ([],[]), IDexp sym)
      else
         IDexp sym
     | visitExp s (PRIexp (m,f,t,es)) = PRIexp (m,f,t,map (visitExp s) es)
     | visitExp s (CALLexp (m,sym,es)) = CALLexp (m, sym, map (visitExp s) es)
     | visitExp s (INVOKEexp (m,t,e,es)) = INVOKEexp (m,t,visitExp s e, map (visitExp s) es)
     | visitExp s (RECORDexp fs) = RECORDexp (map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (BOXexp (t,e)) = BOXexp (t, visitExp s e)
     | visitExp s (UNBOXexp (t,e)) = UNBOXexp (t, visitExp s e)
     | visitExp s (VEC2INTexp (sz,e)) = VEC2INTexp (sz, visitExp s e)
     | visitExp s (INT2VECexp (sz,e)) = INT2VECexp (sz, visitExp s e)
     | visitExp s (CLOSUREexp (t,sym,es)) = CLOSUREexp (t,sym,map (visitExp s) es)
     | visitExp s (STATEexp (b,e)) =
         let
            val e' = visitExp s e
            val eDecls = !(#declsRef s)
            val eStmts = !(#stmtsRef s)
            val _ = (#declsRef s) := []
            val _ = (#stmtsRef s) := []
            val (e',s) = case e' of
                  EXECexp (IDexp sym) => (IDexp sym, addMonSym (s,sym))
                | e => (e,s)
            val BASICblock (decls,stmts) = visitBlock s b
         in
            STATEexp (BASICblock (decls @ eDecls, stmts @ eStmts), e')
         end
     | visitExp s (EXECexp e) = (case (visitExp s e) of
            STATEexp (BASICblock (decls, stmts),e) => 
            let
               val _ = (#declsRef s) := decls @ (!(#declsRef s))
               val _ = (#stmtsRef s) := stmts @ (!(#stmtsRef s))
            in
               e
            end
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
         FUNCdecl {
           funcMonadic = monkind,
           funcClosure = clArgs,
           funcType = vtype,
           funcName = name,
           funcArgs = args,
           funcBody = visitBlock s body,
           funcRes = res
         }
     | visitDecl s d = d

   fun run { decls = ds, fdecls = fs } =
      let
         
         val s = { pureToMonRef = ref SymMap.empty,
                   monVars = SymSet.empty,
                   declsRef = ref ([] : arg list),
                   stmtsRef = ref ([] : stmt list)
                 } : state
         val ds = addMonClosures s ds
         val ds = map (visitDecl s) ds
      in
         { decls = ds, fdecls = fs }
      end
   
end

structure Simplify = struct
   val name = "simplify"

   open Imp
      
   exception SimplifierBug
   
   type state = {
      decls : decl SymMap.map
   }

   fun visitStmt s (ASSIGNstmt (res,exp)) = ASSIGNstmt (res, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, visitBlock s t, visitBlock s e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)
   
   and visitCase s (p,stmts) = (p, visitBlock s stmts)
   
   and visitBlock s (BASICblock (decls, stmts)) = BASICblock (decls, map (visitStmt s) stmts)
   
   and visitExp (s :state) (PRIexp (m,f,t,es)) = PRIexp (m,f,t,map (visitExp s) es)
     | visitExp s (IDexp sym) = IDexp sym
     | visitExp s (CALLexp (m, sym,es)) = CALLexp (m, sym, map (visitExp s) es)
     | visitExp s (INVOKEexp (m, t, e, es)) = (case visitExp s e of
         CLOSUREexp (tCl,sym,esCl) => (case SymMap.find (#decls s,sym) of
            SOME (CLOSUREdecl { closureDelegate = delSym, ... }) =>
               CALLexp (m, delSym, map (visitExp s) (esCl @ es))
          | _ => (TextIO.print ("INVOKE of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " is bad idea.\n"); raise SimplifierBug)
         )
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
     | visitExp s (STATEexp (b,e)) = STATEexp (visitBlock s b,visitExp s e)
     | visitExp s (EXECexp e) = (case visitExp s e of
         CLOSUREexp (tCl,sym,[]) => (case SymMap.find (#decls s,sym) of
            SOME (CLOSUREdecl { closureDelegate = delSym, ... }) =>
               CALLexp (PUREmonkind, delSym, [])
          | _ => (TextIO.print ("EXEC of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " is bad idea.\n"); raise SimplifierBug)
         ) 
       | CALLexp (m,sym,es) => (case SymMap.find (#decls s,sym) of
            SOME (CLOSUREdecl { closureDelegate = delSym, ... }) =>
               CALLexp (m, delSym, map (visitExp s) es)
          | _ => EXECexp (CALLexp (m,sym,map (visitExp s) es))
         )
       | e => EXECexp e
      )

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
         val declMap = foldl (fn (decl,m) => SymMap.insert (m,getDeclName decl, decl)) SymMap.empty ds
         val state = { decls = declMap } : state
         val ds = map (visitDecl state) ds
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
     | FUNstype of (stype * stype * stype list) (* the middle value is VOID if no closure had any arguments and OBJstype otherwise *)
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
     | showSType (FUNstype (res,cl,args)) = ("(") ^ #1 (
         foldl (fn (t,(str,sep)) => (str ^ sep ^ showSType t,","))
            ("", "") args
         ) ^ (if cl=OBJstype then ") => " else ") -> ") ^ showSType res
     | showSType (CONSTstype s) = Int.toString s
     | showSType (BITstype t) = "|" ^ showSType t ^ "|"
     | showSType (STRINGstype) = "string"
     | showSType (INTstype) = "int"
     | showSType (OBJstype) = "obj"

   structure IS = IntListSet
   fun inlineSType s t =
      let
         val tt = #typeTable (s : state)
         fun inline ecrs (VARstype idx) =
            if IS.member (ecrs, idx) then
               (TextIO.print ("found " ^ Int.toString idx ^ " several times:\n");
               app (fn x => TextIO.print ("idx " ^ Int.toString x ^ " : " ^ showSType (DynamicArray.sub (tt,x)) ^ "\n")) (IS.listItems (ecrs));
               raise TypeOptBug)
            else
            let
               fun find idx = case DynamicArray.sub (tt,idx) of
                  VARstype idx' => if idx=idx' then idx' else find idx'
                | t => idx
               val ecr = find idx
               val _ =if idx<>ecr then msg ("inlineSType: forwarded var " ^ Int.toString idx ^ " to " ^ Int.toString ecr ^ "\n") else ()
               val ecrs = IS.add (ecrs, idx)
               val ecrs = IS.add (ecrs, ecr)
            in
               inline ecrs (DynamicArray.sub (tt,ecr))
            end
           | inline ecrs (BOXstype t) = (BOXstype (inline ecrs t))
           | inline ecrs (FUNstype (res,clos,args)) = (FUNstype (inline ecrs res, inline ecrs clos, map (inline ecrs) args))
           | inline ecrs (BITstype t) = (BITstype (inline ecrs t))
           | inline ecrs t = t
      in
         inline IS.empty t
      end

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
         (*val _ = if t1=VARstype 18420 orelse t2=VARstype 18420 then TextIO.print ("lub of " ^ showSType t1 ^ " and " ^ showSType t2 ^ ", that is, of " ^showSType (inlineSType s t1) ^ " and " ^ showSType (inlineSType s t2) ^ "\n") else ()*)
         
         val iter = ref 0
         fun lub (VARstype x, VARstype y) =
            if x=y then VARstype x else
            let
               val xRoot = find (tt,x)
               val yRoot = find (tt,y)
               val _ = iter := (!iter) + 1
               val xTy = DynamicArray.sub (tt,xRoot)
               val yTy = DynamicArray.sub (tt,yRoot)
               val _ = if !iter>30 then
                        raise TypeOptBug
                     else if !iter>20 then
                        TextIO.print ("non-termination for lub of " ^ showSType t1 ^ " and " ^ showSType t2 ^ ", that is, of " ^showSType (inlineSType s t1) ^ " and " ^ showSType (inlineSType s t2) ^ ", xTy = " ^ showSType xTy ^ ", yTy = " ^ showSType yTy ^"\n")
                     else ()
               (*val _ = if (xRoot=18419 orelse yRoot=18419) andalso (xRoot<>yRoot) then TextIO.print ("lub of " ^ showSType t1 ^ " and " ^ showSType t2 ^ ", that is, of " ^showSType (inlineSType s t1) ^ " and " ^ showSType (inlineSType s t2) ^ "\n") else ()*)
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
                   | t' => lub (t',t)
               val _ = DynamicArray.update (tt,xRoot,ty)
            in
               ecr
            end
           | lub (t, VARstype y) =
            let
               val yRoot = find (tt,y)
               val yTy = DynamicArray.sub (tt,yRoot)
               val ecr = VARstype yRoot
               val ty = case yTy of
                     (VARstype _) => ecr
                   | t' => lub (t,t')
               val _ = DynamicArray.update (tt,yRoot,ty)
            in
               ecr
            end
           | lub (VOIDstype, t) = t
           | lub (t, VOIDstype) = t
           | lub (FUNstype (r1, clos1, args1), FUNstype (r2, clos2, args2)) = (
               FUNstype (lub (r1,r2), lub (clos1,clos2), map lub (ListPair.zip (args1,args2)))
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
           | lub (_, OBJstype) = OBJstype
           | lub (OBJstype, _) = OBJstype
           | lub (t1', t2') = (TextIO.print ("lub top for " ^ showSType t1' ^ "; " ^ showSType t2' ^ " when called for " ^ showSType t1 ^ "; " ^ showSType t2 ^ "\n"); OBJstype)

      in
         lub (t1,t2)
      end
   
   fun symType ({ symType = st, typeTable = tt, ...} : state) sym =
      (case SymMap.find (!st,sym) of
         SOME idx => VARstype idx
       | NONE =>
         let
            val idx = DynamicArray.bound tt + 1
            val _ = msg ("symType(" ^ (SymbolTable.getString(!SymbolTables.varTable, sym)) ^ ")= " ^ Int.toString idx ^ "\n")
            (*val _ = if idx=18420 then TextIO.print ("symType(" ^ (SymbolTable.getString(!SymbolTables.varTable, sym)) ^ ")= " ^ Int.toString idx ^ "\n") else ()
            val _ = if idx=18418 then TextIO.print ("symType(" ^ (SymbolTable.getString(!SymbolTables.varTable, sym)) ^ ")= " ^ Int.toString idx ^ "\n") else ()
            val _ = if idx=17937 then TextIO.print ("symType(" ^ (SymbolTable.getString(!SymbolTables.varTable, sym)) ^ ")= " ^ Int.toString idx ^ "\n") else ()*)

            (*val _ = if idx=18418 then TextIO.print ("symType(" ^ (SymbolTable.getString(!SymbolTables.varTable, sym)) ^ ")= " ^ Int.toString idx ^ "\n") else ()
            val _ = if idx=18420 then TextIO.print ("symType(" ^ (SymbolTable.getString(!SymbolTables.varTable, sym)) ^ ")= " ^ Int.toString idx ^ "\n") else ()
            val _ = if idx=57656 then TextIO.print ("symType(" ^ (SymbolTable.getString(!SymbolTables.varTable, sym)) ^ ")= " ^ Int.toString idx ^ "\n") else ()
            val _ = if idx=57654 then TextIO.print ("symType(" ^ (SymbolTable.getString(!SymbolTables.varTable, sym)) ^ ")= " ^ Int.toString idx ^ "\n") else ()*)
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
     | vtypeToStype s (FUNvtype (res, cl, args)) =
         FUNstype (vtypeToStype s res, if cl then OBJstype else VOIDstype, map (vtypeToStype s) args)


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
         visitCall s (FUNstype (BITstype (CONSTstype (IntInf.toInt sz)), VOIDstype, [INTstype, INTstype, INTstype]), es)
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
            val stypesCl = map (visitExp s) es
            val stypes = map (fn (_,arg) => symType s arg) ts
            val resVar = freshTVar s
            val clVar = if List.null es then freshTVar s else OBJstype
            val _ = lub (s,symType s del,  FUNstype (resVar, clVar, stypesCl @ stypes))
            val _ = lub (s,symType s name, FUNstype (resVar, clVar, stypesCl))
            val _ = msg ("CLOSURE: looking for symbol " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ ": " ^ showSType (inlineSType s (symType s name)) ^ "\n")
         in
           FUNstype (resVar, clVar, stypes)
         end
     | visitExp s (STATEexp (b,e)) =
      let
         val isCl = case e of
            CALLexp (_,_,[]) => VOIDstype
          | EXECexp (IDexp _) => VOIDstype
          | _ => OBJstype
         val _ = visitBlock s b
      in
         FUNstype (visitExp s e, VOIDstype, [])
      end
     | visitExp s (EXECexp e) =
      let
         val resVar = freshTVar s
         val _ = lub (s,visitExp s e, FUNstype (resVar, VOIDstype, []))
      in
         resVar
      end
   
   and visitCall s (fTy,args) =
      let
         val resTy = freshTVar s
         val isCl = if null args then VOIDstype else OBJstype
         val _ = lub (s,FUNstype (resTy,isCl,map (visitExp s) args),fTy)
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
         val _ = msg ("visitDecl start " ^ SymbolTable.getString(!SymbolTables.varTable, name) ^ "\n")
         val _ = visitBlock s block
         fun argTypes args = map (fn (_,sym) => symType s sym) args
         val isCl = if null clArgs then VOIDstype else OBJstype
         val ty = FUNstype (symType s res, isCl, argTypes clArgs @ argTypes args)
         val _ = msg ("visitDecl basic type " ^ SymbolTable.getString(!SymbolTables.varTable, name) ^ " : " ^ showSType (ty) ^ "\n")
         val _ = msg ("visitDecl end   " ^ SymbolTable.getString(!SymbolTables.varTable, name) ^ " : " ^ showSType (inlineSType s ty) ^ "\n")
      in
         lub (s, symType s name, ty)
      end
     | visitDecl s (SELECTdecl {
         selectName = name,
         selectField = f,
         selectType = _
      }) = lub (s, symType s name, FUNstype (fieldType s f, VOIDstype, [freshTVar s]))
     | visitDecl s (UPDATEdecl {
         updateName = name,
         updateArg = arg,
         updateFields = fs,
         updateType = _
      }) = lub (s, symType s name, FUNstype (symType s arg, OBJstype, map (fieldType s) fs @ [symType s arg]))
     | visitDecl s (CONdecl {
         conName = name,
         conArg = arg,
         conType = _
     }) = lub (s, symType s name, FUNstype (BOXstype OBJstype, VOIDstype, [symType s arg]))
     | visitDecl s (CLOSUREdecl {
        closureName = name,
        closureArgs = clTys,
        closureDelegate = _,
        closureDelArgs = args
     })=
      let
         val _ = msg ("visitDecl CLOSURE: type before: " ^ showSType (inlineSType s (symType s name)) ^ "\n")
         val isCl = if null clTys then VOIDstype else OBJstype
         val t = lub (s, symType s name, FUNstype (freshTVar s, isCl, map (fn _ => VOIDstype) clTys))
         val _ = msg ("visitDecl CLOSURE: type before: " ^ showSType (inlineSType s (symType s name)) ^ "\n")
      in
         t
      end
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
        (*| (MONADstype t) => STATEexp (BASICblock ([],[]), readWrap s (OBJvtype, t, e))*)
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
        (*| (MONADstype t) => writeWrap s (OBJvtype, t, EXECexp e)*)
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
        (*| (MONADstype t) => adjustType s (OBJvtype, t)*)
        | (FUNstype (r,cl,args)) =>
            FUNvtype (adjustType s (OBJvtype, r), cl=OBJstype, map (fn arg => adjustType s (OBJvtype, arg)) args)
        | t => (TextIO.print ("adjustType of " ^ showSType t ^ "\n"); raise TypeOptBug)
      )
     | adjustType s (FUNvtype (rOrig,clOrig,argsOrig),t) = (case inlineSType s t of
          (FUNstype (r,cl,args)) => (
            FUNvtype (adjustType s (rOrig,r), cl=OBJstype, map (adjustType s) (ListPair.zipEq (argsOrig, args)))
               handle ListPair.UnequalLengths =>
                  (TextIO.print ("adjustType of " ^ Layout.tostring (Imp.PP.vtype (FUNvtype (rOrig,clOrig,argsOrig))) ^ " and " ^ showSType (FUNstype (r,cl,args)) ^ ", unequal length\n"); raise TypeOptBug)
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
     }) = (msg ("patchDecl CLOSURE " ^ SymbolTable.getString(!SymbolTables.varTable, name) ^ " from " ^ Layout.tostring (Imp.PP.vtype (FUNvtype (OBJvtype,false,tsCl @ map #1 delArgs))) ^ " to " ^ showSType (inlineSType s (symType s del)) ^ "\n");  case adjustType s (FUNvtype (OBJvtype,false,tsCl @ map #1 delArgs), symType s del) of
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
       | _ => (TextIO.print ("patchDecl CLOSURE " ^ SymbolTable.getString(!SymbolTables.varTable, name) ^ " from " ^ Layout.tostring (Imp.PP.vtype (FUNvtype (OBJvtype,false,tsCl @ map #1 delArgs))) ^ " to " ^ showSType (inlineSType s (symType s del)) ^ "\n"); raise TypeOptBug)
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
         val _ = msg ("patchExp CALL " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " from " ^ Layout.tostring (Imp.PP.vtype (origType s sym)) ^ " to " ^ showSType (inlineSType s (symType s sym)) ^ "\n")
         val (wrap, tyNew, esNew) = patchCall s (origType s sym, symType s sym, map (patchExp s) es)
      in
         wrap (CALLexp (m, sym, esNew))
      end
     | patchExp s (INVOKEexp (m, ty, e, es)) =
      let
         val eNew = patchExp s e
         val _ = msg ("patchExp INVOKE " ^ Layout.tostring (Imp.PP.exp e) ^ "\n")
         val (wrap, tyNew, esNew) = patchCall s (ty, visitExp s e, map (patchExp s) es)
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
         val _ = msg ("patchExp CLOSURE " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " from " ^ Layout.tostring (Imp.PP.vtype (origType s sym)) ^ " to " ^ showSType (inlineSType s (symType s sym)) ^ "\n")
         val (wrap, tyNew,esNew) = patchCall s (ty, symType s sym, map (patchExp s) es)
      in
         wrap (CLOSUREexp (tyNew,sym,esNew))
      end
     | patchExp s (STATEexp (b,e)) = STATEexp (patchBlock s b, patchExp s e)
     | patchExp s (EXECexp e) = EXECexp (patchExp s e)
   
   and patchCall s (orig,new,es) =
      let
         val _ = msg ("patchCall of " ^ Layout.tostring (Imp.PP.vtype orig) ^ " and " ^ showSType (inlineSType s new) ^ " with args " ^ Layout.tostring (Layout.seq (Imp.PP.args ("(", Imp.PP.exp, es, ")"))) ^ "\n")
         fun genNewArgs acc (FUNvtype (vRes, vCl, vType :: vs),
                             FUNstype (sRes, sCl, sType :: ss), e :: es) =
               genNewArgs (acc @ [writeWrap s (vType,sType,e)])
                  (FUNvtype (vRes, vCl, vs), FUNstype (sRes, sCl, ss), es)
           | genNewArgs acc (OBJvtype, FUNstype (sRes, sCl, ss), es) =
               genNewArgs acc (FUNvtype (OBJvtype, false, map (fn _ => OBJvtype) ss),
                               FUNstype (sRes, sCl, ss), es)
           | genNewArgs acc (vs, ss, []) = (acc, vs, ss)
           | genNewArgs acc (v,s,e :: es) = (TextIO.print ("patchCall of " ^ Layout.tostring (Imp.PP.vtype v) ^ " and " ^ showSType s ^ ", next argument is " ^ Layout.tostring (Imp.PP.exp e) ^ "\n"); raise TypeOptBug)

      in
        case genNewArgs [] (orig, inlineSType s new, es) of
           (es, FUNvtype (vRes, vCl, []), FUNstype (sRes, sCl, [])) =>
            (fn e => readWrap s (vRes, sRes, e), adjustType s (vRes, sRes), es)
         | (es, v, t) => (TextIO.print ("patchCall bad of " ^ Layout.tostring (Imp.PP.vtype v) ^ " and " ^ showSType (inlineSType s t) ^ ": no more args\n"); raise TypeOptBug)
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
         fun visitDeclPrint state d = (msg ("visiting " ^ SymbolTable.getString(!SymbolTables.varTable, getDeclName d) ^ "\n"); visitDecl state d)
         val _ = map (visitDeclPrint state) ds
         (*val _ = showState state*)
         val _ = debugOn := false
         fun patchDeclPrint state d = (msg ("patching " ^ SymbolTable.getString(!SymbolTables.varTable, getDeclName d) ^ "\n"); patchDecl state d)
         val ds = map (patchDeclPrint state) ds
         val fs = SymMap.mapi (fn (sym,ty) => adjustType state (ty, symType state sym)) fs
      in
         { decls = ds, fdecls = fs }
      end
   
end

structure SwitchReduce = struct
   val name = "switch-reduce"

   open Imp
   
   
   fun genDist dist [] = dist
     | genDist NONE (VECpat [] :: pats) = genDist NONE pats
     | genDist NONE (pats as (VECpat (bp :: _) :: _)) =
         genDist (SOME (0, Array.array (String.size bp, 0))) pats
    | genDist (SOME (count, dist)) (VECpat strs :: pats) =
      let
         fun addDist dist str = (
            foldl (fn (chr,idx) => (
               if chr = #"." then () else Array.update (dist,idx,Array.sub(dist,idx)+1); idx+1))
               0 (String.explode str);
            ())
         val _ = app (addDist dist) strs
      in
         genDist (SOME (count+length pats, dist)) pats
      end
    | genDist NONE (_ :: pats) = genDist NONE pats
    | genDist (SOME (count,dist)) (_ :: pats) = genDist (SOME (count+1,dist)) pats

   fun genBits pats = case genDist NONE pats of
      NONE => ([],[])
    | SOME (count,dist) =>
      let
         val bits = Array.length dist
         val sorted = Array.array (bits,0)
         val _ = Array.copy { src = dist, dst = sorted, di = 0 }
         val _ = ArrayQSort.sort Int.compare sorted
         (* compute a cut-off for the number of cases in which a bit may not
         be a wildcard; we implement a kind of exponential backup *)
         fun calcCutOff (slack, last, max, idx) =
            if idx<0 then last else
            let
               val newLast =  Array.sub (sorted, idx)
               val newSlack = (slack+(max-newLast))*2
            in
               if newSlack>=max then
                  last
               else
                  calcCutOff (newSlack, newLast, max, idx-1)
            end
         val cutOff = if bits<=1 then 0 else
            calcCutOff (0, Array.sub (sorted, bits-1), Array.sub (sorted, bits-1), bits-2)
         val bitPats = List.concat (map (fn p => case p of
               VECpat bp => bp
             | _ => []) pats)
         val patStr = foldl (fn (v,str) => "\n" ^ v ^ str) "" bitPats
         val arrStr = #2 (Array.foldl (fn (v,(sep,str)) => (",", str ^ sep ^ Int.toString v)) ("[","") dist) ^ "]"
         val _ = TextIO.print ("case patterns:" ^ patStr ^ "\n" ^ arrStr ^ ", cutoff=" ^ Int.toString cutOff ^ "\n")
      in
         ([],[])
      end
    
   fun optCase (scrut,cases) =
      let
         val (goodBits,badBits) = genBits (map #1 cases)
         fun slice [] scrut = scrut
         fun casesSlice [] cases = cases
         
      in
         CASEstmt (slice goodBits scrut, casesSlice goodBits cases)
      end
   fun visitBlock s (BASICblock (decls,stmts)) = BASICblock (decls, map (visitStmt s) stmts)
   
   and visitStmt s (ASSIGNstmt (res,exp)) = ASSIGNstmt (res, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, visitBlock s t, visitBlock s e)
     | visitStmt s (CASEstmt (e,ps)) = optCase (visitExp s e, map (visitCase s) ps)

   and visitCase s (p,stmts) = (p, visitBlock s stmts)
   
   and visitExp s (PRIexp (m,f,t,es)) = (PRIexp (m,f,t,map (visitExp s) es))
     | visitExp s (CALLexp (m,sym,es)) = (CALLexp (m, sym, map (visitExp s) es))
     | visitExp s (INVOKEexp (m,t,e,es)) = (INVOKEexp (m,t,visitExp s e, map (visitExp s) es))
     | visitExp s (RECORDexp fs) = RECORDexp (map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (BOXexp (t,e)) = BOXexp (t, visitExp s e)
     | visitExp s (UNBOXexp (t,e)) = UNBOXexp (t, visitExp s e)
     | visitExp s (VEC2INTexp (sz,e)) = VEC2INTexp (sz, visitExp s e)
     | visitExp s (INT2VECexp (sz,e)) = INT2VECexp (sz, visitExp s e)
     | visitExp s (CLOSUREexp (t,sym,es)) = CLOSUREexp (t,sym,map (visitExp s) es)
     | visitExp s (STATEexp (b,e)) = STATEexp (visitBlock s b, visitExp s e)
     | visitExp s (EXECexp e) = (EXECexp (visitExp s e))
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
        funcBody = visitBlock s body,
        funcRes = res
      }
     | visitDecl s d = d

   fun run { decls = ds, fdecls = fs } =
      let
         val ds = map (visitDecl {}) ds
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

