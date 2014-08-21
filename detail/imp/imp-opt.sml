
structure PatchFunctionCalls = struct
   val name = "patch-function-calls"

   open Imp
   
   fun visitStmt s (ASSIGNstmt (res,exp)) = ASSIGNstmt (res, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, visitBlock s t, visitBlock s e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)
   
   and visitCase s (sp,p,stmts) = (sp,p, visitBlock s stmts)
   
   and visitBlock s (BASICblock (decls, stmts)) = BASICblock (decls, map (visitStmt s) stmts)
   
   and visitExp s (PRIexp (f,t,es)) = PRIexp (f,t,map (visitExp s) es)
     | visitExp s (IDexp sym) = IDexp sym
     | visitExp s (CALLexp (e,es)) = CALLexp (visitExp s e, map (visitExp s) es)
     | visitExp s (INVOKEexp (t, e, es)) = (case visitExp s e of
         IDexp sym => (case SymMap.find (!Primitives.prim_map, sym) of
            SOME (_,gen) => visitExp s (gen es)
          | NONE => INVOKEexp (t, e, map (visitExp s) es)
         )
       | e => INVOKEexp (t, e, map (visitExp s) es)
      )
     | visitExp s (RECORDexp (rs,t,fs)) = RECORDexp (rs,t,map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (SELECTexp (rs,t,f,e)) = SELECTexp (rs,t,f,visitExp s e)
     | visitExp s (UPDATEexp (rs,t,fs,e)) = UPDATEexp (rs,t,map (fn (f,e) => (f,visitExp s e)) fs, visitExp s e)
     | visitExp s (LITexp l) = LITexp l
     | visitExp s (BOXexp (t,e)) = BOXexp (t, visitExp s e)
     | visitExp s (UNBOXexp (t,e)) = UNBOXexp (t, visitExp s e)
     | visitExp s (VEC2INTexp (sz,e)) = VEC2INTexp (sz, visitExp s e)
     | visitExp s (INT2VECexp (sz,e)) = INT2VECexp (sz, visitExp s e)
     | visitExp s (CLOSUREexp (t,sym,es)) = CLOSUREexp (t,sym,map (visitExp s) es)
     | visitExp s (STATEexp (b,t,e)) = STATEexp (visitBlock s b,t,visitExp s e)
     | visitExp s (EXECexp (t,e)) = EXECexp (t, case visitExp s e of
         IDexp sym => (case SymMap.find (!Primitives.prim_map, sym) of
            SOME (_,gen) => visitExp s (gen [])
          | NONE => IDexp sym
         )
       | e => e
      )
         

   fun visitDecl s (FUNCdecl {
        funcIsConst = isConst,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = stmts,
        funcRes = res
      }) = FUNCdecl {
        funcIsConst = isConst,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = visitBlock s stmts,
        funcRes = res
      }
     | visitDecl s d = d

   fun run ({ decls = ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs } : imp) =
      let
         val ds = map (visitDecl {}) ds
      in
         { decls = ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs } : imp
      end
   
end


(* Turn all monadic constructs into normal functions, possibly creating anonymous
   action functions for stand-alone STATEexp-expressions  (i.e. do ...). *)
structure ActionClosures = struct
   val name = "action-closures"

   open Imp

   type state = { funToClosure : SymbolTable.symid SymMap.map,
                  funName : SymbolTable.symid,
                  locals : vtype SymMap.map,
                  actions : decl list ref }

   fun remMonad (FUNvtype (res,cl,args)) = FUNvtype (remMonad res,cl,map remMonad args)
     | remMonad (MONADvtype t) = FUNvtype (t,false,[])
     | remMonad t = t

   fun remMonadArgs args = map (fn (ty,sym) => (remMonad ty, sym)) args
   
   fun freeBlock s (BASICblock (decls,stmts)) =
      SymSet.difference (foldl (fn (stmt,s) => freeStmt s stmt) s stmts,
                         SymSet.addList (SymSet.empty, map #2 decls))

   and freeStmt s (ASSIGNstmt (SOME sym,exp)) = SymSet.add (freeExp s exp, sym)
     | freeStmt s (ASSIGNstmt (NONE,exp)) = freeExp s exp
     | freeStmt s (IFstmt (c,t,e)) = freeExp (freeBlock (freeBlock s e) t) c
     | freeStmt s (CASEstmt (e,ps)) = foldl (fn (c,s) => freeCase s c) (freeExp s e) ps

   and freeCase s (sp,p,stmts) = freeBlock s stmts
   
   and freeExp s (IDexp sym) = SymSet.add (s, sym)
     | freeExp s (PRIexp (f,t,es)) = foldl (fn (e,s) => freeExp s e) s es
     | freeExp s (CALLexp (e,es)) = foldl (fn (e,s) => freeExp s e) (freeExp s e) es
     | freeExp s (INVOKEexp (t,e,es)) = foldl (fn (e,s) => freeExp s e) (freeExp s e) es
     | freeExp s (RECORDexp (rs,t,fs)) = foldl (fn ((f,e),s) => freeExp s e) s fs
     | freeExp s (SELECTexp (rs,t,f,e)) = freeExp s e
     | freeExp s (UPDATEexp (rs,t,fs,e)) = foldl (fn ((f,e),s) => freeExp s e) (freeExp s e) fs
     | freeExp s (LITexp (t,l)) = s
     | freeExp s (BOXexp (t,e)) = freeExp s e
     | freeExp s (UNBOXexp (t,e)) = freeExp s e
     | freeExp s (VEC2INTexp (sz,e)) = freeExp s e
     | freeExp s (INT2VECexp (sz,e)) = freeExp s e
     | freeExp s (CLOSUREexp (t,sym,es)) = foldl (fn (e,s) => freeExp s e) (SymSet.add (s, sym)) es
     | freeExp s (STATEexp (BASICblock (decls,stmts),t,e)) =
      SymSet.difference (foldl (fn (stmt,s) => freeStmt s stmt) (freeExp s e) stmts,
                         SymSet.addList (SymSet.empty, map #2 decls))
     | freeExp s (EXECexp (t, e)) = freeExp s e


   fun genAction s (decls,stmts,t,e) =
      let
         val s = { funToClosure = #funToClosure s,
                   funName = #funName s,
                   locals = foldl (fn ((ty,sym),set) => 
                                 SymMap.insert (set,sym,ty)) (#locals s) decls,
                   actions = #actions s } : state
         val stmts = map (visitStmt s) stmts
         val decls = remMonadArgs decls
         val e = visitExp s e

         val index = List.length (!(#actions s)) div 2+1
         val fStr = Atom.toString (SymbolTable.getAtom (!SymbolTables.varTable,#funName s))
         val str = fStr ^ "Action" ^ Int.toString index
         val tab = !SymbolTables.varTable
         val (tab, fSym) = SymbolTable.fresh (tab, Atom.atom (str))
         val (tab, rSym) = SymbolTable.fresh (tab, Atom.atom (str ^ "Res"))
         val (tab, cSym) = SymbolTable.fresh (tab, Atom.atom (str ^ "Closure"))
         val _ = SymbolTables.varTable := tab

         val free = freeExp SymSet.empty (STATEexp (BASICblock (decls, stmts),t,e))
         val usedSet =  SymMap.filteri (fn (sym,ty) => SymSet.member (free,sym)) (#locals s)
         val used = map (fn (s,t) => (t,s)) (SymMap.listItemsi usedSet)
         val cl = not (List.null used)
         
         val body = BASICblock (decls, stmts @ [ASSIGNstmt (SOME rSym, e)])

         val anonF = FUNCdecl {
            funcIsConst = false,
            funcClosure = used,
            funcType = FUNvtype (t,cl,map #1 used),
            funcName = fSym,
            funcArgs = [],
            funcBody = body,
            funcRes = rSym
         }
         val anonC = CLOSUREdecl {
            closureName = cSym,
            closureArgs = map #1 used,
            closureDelegate = fSym,
            closureDelArgs = [],
            closureRetTy = t
         }

         val _ = (#actions s) := (!(#actions s)) @ [anonF, anonC]
      in
         CLOSUREexp (FUNvtype (t,cl,map #1 used), cSym, map (IDexp o #2) used)
      end

   and visitBlock (s : state) (BASICblock (decls,stmts)) =
      let
         val s' = { funToClosure = #funToClosure s,
                    funName = #funName s,
                    locals = foldl (fn ((ty,sym),set) => 
                                 SymMap.insert (set,sym,ty)) (#locals s) decls,
                    actions = #actions s } : state
      in
         BASICblock (remMonadArgs decls, map (visitStmt s') stmts)
      end

   and visitStmt s (ASSIGNstmt (rhs,exp)) = ASSIGNstmt (rhs, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, visitBlock s t, visitBlock s e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)

   and visitCase s (sp,p,stmts) = (sp,p, visitBlock s stmts)
   
   and visitExp s (IDexp sym) = IDexp sym
     | visitExp s (PRIexp (f,t,es)) = PRIexp (f,remMonad t,map (visitExp s) es)
     | visitExp s (CALLexp (e,es)) = CALLexp (visitExp s e, map (visitExp s) es)
     | visitExp s (INVOKEexp (t,e,es)) = INVOKEexp (remMonad t,visitExp s e, map (visitExp s) es)
     | visitExp s (RECORDexp (rs,t,fs)) = RECORDexp (rs,t,map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (SELECTexp (rs,t,f,e)) = SELECTexp (rs,t,f,visitExp s e)
     | visitExp s (UPDATEexp (rs,t,fs,e)) = UPDATEexp (rs,t,map (fn (f,e) => (f,visitExp s e)) fs, visitExp s e)
     | visitExp s (LITexp (t,l)) = LITexp (remMonad t, l)
     | visitExp s (BOXexp (t,e)) = BOXexp (remMonad t, visitExp s e)
     | visitExp s (UNBOXexp (t,e)) = UNBOXexp (remMonad t, visitExp s e)
     | visitExp s (VEC2INTexp (sz,e)) = VEC2INTexp (sz, visitExp s e)
     | visitExp s (INT2VECexp (sz,e)) = INT2VECexp (sz, visitExp s e)
     | visitExp s (CLOSUREexp (t,sym,es)) = CLOSUREexp (remMonad t,sym,map (visitExp s) es)
     | visitExp s (STATEexp (BASICblock ([],[]),t,CALLexp (e,[]))) =
      (case e of
         IDexp sym =>
            (case SymMap.find (#funToClosure s, sym) of
               SOME clSym => CLOSUREexp (t,clSym,[])
             | NONE => genAction s ([],[],t,CALLexp (IDexp sym,[]))
            )
       | e => genAction s ([],[],t,CALLexp (e,[]))
      )
     | visitExp s (STATEexp (BASICblock (decls, stmts),t,e)) = genAction s (decls,stmts,t,e)
     | visitExp s (EXECexp (t, e)) = INVOKEexp (remMonad t, visitExp s e, [])

   fun visitDecl s (FUNCdecl {
        funcIsConst = isConst,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = body,
        funcRes = res
      } :: ds) = 
      let
         val newActions = ref []
         val s' = { funToClosure = s,
                    funName = name,
                    locals = foldl (fn ((ty,sym),set) => SymMap.insert (set,sym,ty))
                                 SymMap.empty (clArgs @ args),
                    actions = newActions } : state
         val body = visitBlock s' body
      in
         FUNCdecl {
           funcIsConst = isConst,
           funcClosure = clArgs,
           funcType = remMonad vtype,
           funcName = name,
           funcArgs = remMonadArgs args,
           funcBody = body,
           funcRes = res
         } :: (!newActions) @ visitDecl s ds
      end
     | visitDecl s (d :: ds) = d :: visitDecl s ds
     | visitDecl s [] = []

   fun genFunToClosure
      (CLOSUREdecl {
         closureName = name,
         closureDelegate = del,
         ...
      },s) = SymMap.insert (s, del, name)
     | genFunToClosure (d,s) = s 

   fun run { decls = ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs } =
      let
         val s = foldl genFunToClosure SymMap.empty ds
         val ds = visitDecl s ds
      in
         { decls = ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs }
      end
   
end

(* Remove the "\$ -> ..." from the top-level of each monadic function f and
   convert each call f(...) to "$ -> f(...)" (unless f is passed around
   as a value) *)
structure ActionReduce = struct
   val name = "action-reduce"

   open Imp

   type stateFun = { pureToMon : SymSet.set,
                     closureSyms : SymSet.set,
                     closureToFun : SymbolTable.symid SymMap.map }

   (* Gather a set of all functions that are obviously monadic in order to
      strip one layer of function invocation due to the monad. Thus, from
      a function of the form f(a,b) = \$ => exp we want to generate
      f(a,b) = exp for which we need to turn any call(f,xa,xb) into
      \$ => call(f,xa,xb). However, if f_closure is mentioned anywhere,
      we can't do this since we cannot patch the invoke statement into
      which the closure expression eventually flows. Thus, gather all
      f_closure symbols and remove the corresponding f symbols from the
      set of obviously monadic functions. *)
   fun getCloFunBlock cs (BASICblock (decls,stmts)) =
      foldl (fn (stmt,cs) => getCloFunStmt cs stmt) cs stmts

   and getCloFunStmt cs (ASSIGNstmt (res,exp)) = getCloFunExp cs exp
     | getCloFunStmt cs (IFstmt (c,t,e)) = SymSet.union (getCloFunExp cs c,
         SymSet.union (getCloFunBlock cs t, getCloFunBlock cs e))
     | getCloFunStmt cs (CASEstmt (e,ps)) =
         foldl (fn (p,cs) => getCloFunCase cs p) (getCloFunExp cs e) ps

   and getCloFunCase cs (sp,p,stmts) = getCloFunBlock cs stmts
   
   and getCloFunExp cs (IDexp sym) = cs
     | getCloFunExp cs (PRIexp (f,t,es)) = foldl (fn (e,cs) => getCloFunExp cs e) cs es
     | getCloFunExp cs (CALLexp (e,es)) = foldl (fn (e,cs) => getCloFunExp cs e) (getCloFunExp cs e) es
     | getCloFunExp cs (INVOKEexp (t,e,es)) = foldl (fn (e,cs) => getCloFunExp cs e) (getCloFunExp cs e) es
     | getCloFunExp cs (RECORDexp (rs,t,fs)) = foldl (fn ((_,e),cs) => getCloFunExp cs e) cs fs
     | getCloFunExp cs (SELECTexp (rs,t,f,e)) = getCloFunExp cs e
     | getCloFunExp cs (UPDATEexp (rs,t,fs,e)) = foldl (fn ((_,e),cs) => getCloFunExp cs e) (getCloFunExp cs e) fs
     | getCloFunExp cs (LITexp l) = cs
     | getCloFunExp cs (BOXexp (t,e)) = getCloFunExp cs e
     | getCloFunExp cs (UNBOXexp (t,e)) = getCloFunExp cs e
     | getCloFunExp cs (VEC2INTexp (sz,e)) = getCloFunExp cs e
     | getCloFunExp cs (INT2VECexp (sz,e)) = getCloFunExp cs e
     | getCloFunExp cs (CLOSUREexp (t,sym,es)) = foldl (fn (e,cs) => getCloFunExp cs e) (SymSet.add (cs,sym)) es
     | getCloFunExp cs (STATEexp (bb,t,e)) = getCloFunBlock (getCloFunExp cs e) bb
     | getCloFunExp cs (EXECexp (t, e)) = getCloFunExp cs e

   fun getCloDecl ({ pureToMon = pureToMon,
                     closureSyms = closureSyms,
                     closureToFun = closureToFun } : stateFun)
      (FUNCdecl {
        funcName = name,
        funcBody = bb as BASICblock (decls,stmts),
        funcType = ty,
        ...
      }) =
      let
         (* a function is monadic if it starts with "\$ -> ..."
            (not all monadic functions can be identified this way) *)
         val pureToMon = case stmts of
               [ASSIGNstmt (lhs,STATEexp block)] => SymSet.add (pureToMon, name)
             | _ => pureToMon
         (* a function is monadic if its return type is "M ..."
            (an accurate type is not available unless the "type-refinement" pass was run) *)
         val pureToMon = case ty of
               FUNvtype (MONADvtype _,_,_) => SymSet.add (pureToMon, name)
             | _ => pureToMon
         val closureSyms = getCloFunBlock closureSyms bb
      in
         { pureToMon = pureToMon,
           closureSyms = closureSyms,
           closureToFun = closureToFun }
      end
     | getCloDecl ({ pureToMon = pureToMon,
                     closureSyms = closureSyms,
                     closureToFun = closureToFun } : stateFun)
      (CLOSUREdecl {
         closureName = name,
         closureDelegate = del,
         ...
      }) =
      { pureToMon = pureToMon,
        closureSyms = closureSyms,
        closureToFun = SymMap.insert (closureToFun, name, del) }
     | getCloDecl s d = s 

   (* Gather all identifiers that are monadic top-level functions. *)
   type stateMon = { resVar : SymbolTable.symid,
                     pureToMon : SymSet.set }

   fun isMonBlock s (BASICblock (decls,stmts)) = isMonStmt s (List.rev stmts)

   and isMonStmt s (ASSIGNstmt (NONE,exp) :: stmts) = isMonStmt s stmts
     | isMonStmt s (ASSIGNstmt (SOME lhs,STATEexp _) :: stmts) =
         SymbolTable.eq_symid (#resVar (s : stateMon), lhs)
     | isMonStmt s (ASSIGNstmt (SOME lhs,IDexp rhs) :: stmts) =
         if SymbolTable.eq_symid (#resVar (s : stateMon), lhs) then
            isMonStmt {resVar = rhs, pureToMon = #pureToMon s} stmts
         else
            false
     | isMonStmt s (ASSIGNstmt (SOME lhs,CALLexp (IDexp sym,_)) :: stmts) =
         if SymbolTable.eq_symid (#resVar (s : stateMon), lhs) then
            SymSet.member (#pureToMon s, sym)
         else
            false
     | isMonStmt s (IFstmt (c,t,e) :: stmts) =
         isMonBlock s t orelse isMonBlock s e
     | isMonStmt s (CASEstmt (e,ps) :: stmts) =
         not (List.all (not o isMonCase s) ps)
     | isMonStmt s _ = false

   and isMonCase s (sp,p,stmts) = isMonBlock s stmts
   
   fun getPureToMon (FUNCdecl { funcName = name,
                                funcBody = bb,
                                funcRes = resVar,
                                ... }, set) =
         if isMonBlock { resVar = resVar,pureToMon = set } bb then
            SymSet.add (set, name) else set
     | getPureToMon (d,set) = set
 
   (* In the second stage, apply the actual transformation of call(f,xa,xb) to
      \$ => call(f,xa,xb). Moreover, collect all local variables v' with 
      v = exec(v') in order to wrap read accesses with \$ => v' and writes
      with exec(v'), thereby effectively collapsing nested do statements. *)
   type stateVar = { monVars : SymSet.set }
         
   fun isMonVar (s : stateVar, sym) = SymSet.member (#monVars s, sym)

   fun addMonSyms ({ monVars = monVars },syms) =
      { monVars = SymSet.union (monVars,syms) } : stateVar

   fun getMonBlock (declSyms,execSyms) (BASICblock (decls,stmts)) =
      let
         val declSyms = SymSet.union (declSyms, SymSet.fromList (map #2 decls))
         (*val _ = TextIO.print ("declared vars:" ^ foldl (fn (sym,str) => str ^ " " ^ SymbolTable.getString(!SymbolTables.varTable, sym)) "" (SymSet.listItems ds) ^ "\n")*)
      in
         foldl (fn (stmt,execSyms) => getMonStmt (declSyms,execSyms) stmt) execSyms (List.rev stmts)
      end
   
   and getMonStmt (declSyms,execSyms) (ASSIGNstmt (SOME symL,IDexp symR)) =
         if SymSet.member (execSyms,symL) then SymSet.add (execSyms, symR) else execSyms
     | getMonStmt ds (ASSIGNstmt (res,exp)) = getMonExp ds exp
     | getMonStmt ds (IFstmt (c,t,e)) = SymSet.union (getMonExp ds c,
         SymSet.union (getMonBlock ds t, getMonBlock ds e))
     | getMonStmt (declSyms,execSyms) (CASEstmt (e,ps)) =
         foldl (fn (p,execSyms) => getMonCase (declSyms,execSyms) p) (getMonExp (declSyms,execSyms) e) ps

   and getMonCase ds (sp,p,stmts) = getMonBlock ds stmts
   
   and getMonExp (declSyms,execSyms) (IDexp sym) = execSyms
     | getMonExp (declSyms,execSyms) (PRIexp (f,t,es)) = foldl (fn (e,execSyms) => getMonExp (declSyms,execSyms) e) execSyms es
     | getMonExp (declSyms,execSyms) (CALLexp (e,es)) = foldl (fn (e,execSyms) => getMonExp (declSyms,execSyms) e) (getMonExp (declSyms,execSyms) e) es
     | getMonExp (declSyms,execSyms) (INVOKEexp (t,e,es)) = foldl (fn (e,execSyms) => getMonExp (declSyms,execSyms) e) (getMonExp (declSyms,execSyms) e) es
     | getMonExp (declSyms,execSyms) (RECORDexp (rs,t,fs)) = foldl (fn ((_,e),execSyms) => getMonExp (declSyms,execSyms) e) execSyms fs
     | getMonExp (declSyms,execSyms) (UPDATEexp (rs,t,fs,e)) = foldl (fn ((_,e),execSyms) => getMonExp (declSyms,execSyms) e) (getMonExp (declSyms,execSyms) e) fs
     | getMonExp ds (SELECTexp (rs,t,f,e)) = getMonExp ds e
     | getMonExp (declSyms,execSyms) (LITexp l) = execSyms
     | getMonExp ds (BOXexp (t,e)) = getMonExp ds e
     | getMonExp ds (UNBOXexp (t,e)) = getMonExp ds e
     | getMonExp ds (VEC2INTexp (sz,e)) = getMonExp ds e
     | getMonExp ds (INT2VECexp (sz,e)) = getMonExp ds e
     | getMonExp (declSyms,execSyms) (CLOSUREexp (t,sym,es)) = foldl (fn (e,execSyms) => getMonExp (declSyms,execSyms) e) execSyms es
     | getMonExp (declSyms,execSyms) (STATEexp (BASICblock (decls,stmts),t,e)) =
      let
         val declSyms = SymSet.union (declSyms, SymSet.fromList (map #2 decls))
      in
         foldl (fn (stmt,execSyms) => getMonStmt (declSyms,execSyms) stmt) (getMonExp (declSyms,execSyms) e) (List.rev stmts)
      end
     | getMonExp (declSyms,execSyms) (EXECexp (t, IDexp sym)) =
      if SymSet.member (declSyms,sym) then SymSet.add (execSyms, sym) else execSyms
     | getMonExp ds (EXECexp (t, e)) = getMonExp ds e

   fun visitBlock s (BASICblock (decls,stmts)) = BASICblock (decls, map (visitStmt s) stmts)

   and visitStmt s (ASSIGNstmt (NONE,exp)) = ASSIGNstmt (NONE, visitExp s exp)
     | visitStmt s (ASSIGNstmt (SOME sym,exp)) =
         if isMonVar (s, sym) then
            ASSIGNstmt (SOME sym, visitExp s (EXECexp (MONADvtype OBJvtype, exp)))
         else
            ASSIGNstmt (SOME sym, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, visitBlock s t, visitBlock s e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)

   and visitCase s (sp,p,stmts) = (sp,p, visitBlock s stmts)
   
   and visitExp s (IDexp sym) =
      if isMonVar ((s : stateVar),sym) then
         STATEexp (BASICblock ([],[]), OBJvtype, IDexp sym)
      else IDexp sym
     | visitExp s (PRIexp (f,t,es)) = PRIexp (f,t,map (visitExp s) es)
     | visitExp s (CALLexp (IDexp sym,es)) =
      if isMonVar (s, sym) then
         STATEexp (BASICblock ([],[]), OBJvtype, CALLexp (IDexp sym, map (visitExp s) es))
      else CALLexp (IDexp sym, map (visitExp s) es)
     | visitExp s (CALLexp (e,es)) = CALLexp (visitExp s e, map (visitExp s) es)
     | visitExp s (INVOKEexp (t,e,es)) = INVOKEexp (t,visitExp s e, map (visitExp s) es)
     | visitExp s (RECORDexp (rs,t,fs)) = RECORDexp (rs,t,map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (SELECTexp (rs,t,f,e)) = SELECTexp (rs,t,f,visitExp s e)
     | visitExp s (BOXexp (t,e)) = BOXexp (t, visitExp s e)
     | visitExp s (UNBOXexp (t,e)) = UNBOXexp (t, visitExp s e)
     | visitExp s (VEC2INTexp (sz,e)) = VEC2INTexp (sz, visitExp s e)
     | visitExp s (INT2VECexp (sz,e)) = INT2VECexp (sz, visitExp s e)
     | visitExp s (CLOSUREexp (t,sym,es)) = CLOSUREexp (t,sym,map (visitExp s) es)
     | visitExp s (STATEexp (b,t,e)) = STATEexp (visitBlock s b,t,visitExp s e)
     | visitExp s (EXECexp (t, e)) = EXECexp (t, visitExp s e)
     | visitExp s e = e

   fun visitDecl (s : stateVar) (FUNCdecl {
        funcIsConst = isConst,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = body,
        funcRes = res
      }) =
      let
         val (execSyms, transTy, isConst) = if isMonVar (s,name) then
               let
                  val vtype =  case vtype of
                           FUNvtype (MONADvtype retTy,isCl,argsTy) => FUNvtype (retTy, isCl, argsTy)
                         | FUNvtype (_,isCl,argsTy) => FUNvtype (OBJvtype, isCl, argsTy)
                         | _ => FUNvtype (OBJvtype,false,map #1 args)
               in
                  (SymSet.singleton res, vtype, false)
               end
            else (SymSet.empty,vtype, isConst)
         val execSyms = getMonBlock (SymSet.singleton res, execSyms) body
         (*val _ = TextIO.print ("action, decl " ^ SymbolTable.getString(!SymbolTables.varTable, name) ^
            " has exec syms" ^ foldl (fn (sym,str) => str ^ " " ^ SymbolTable.getString(!SymbolTables.varTable, sym)) "" (SymSet.listItems execSyms) ^ "\n")*)
         val body = visitBlock (addMonSyms (s,execSyms)) body
      in
         FUNCdecl {
           funcIsConst = isConst,
           funcClosure = clArgs,
           funcType = transTy,
           funcName = name,
           funcArgs = args,
           funcBody = body,
           funcRes = res
         }
      end
     | visitDecl s d = d


   fun run { decls = ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs } =
      let
         fun fixpoint (size,set) =
            let
               val newSet = foldl getPureToMon set ds
               val newSize = SymSet.numItems newSet
            in
               if newSize>size then fixpoint (newSize,newSet) else set
            end
         val pureToMon = fixpoint (0,SymSet.empty)
         val sFun =  { pureToMon = pureToMon,
                       closureSyms = SymSet.empty,
                       closureToFun = SymMap.empty } : stateFun
         val sFun = foldl (fn (d,sFun) => getCloDecl sFun d) sFun ds
         val toRemove =
            SymSet.map (fn sym => SymMap.lookup (#closureToFun sFun, sym)) (#closureSyms sFun)
         val pureToMon = SymSet.difference (#pureToMon sFun, toRemove)
         (*val _ = TextIO.print (Int.toString (SymSet.numItems pureToMon) ^ " functions that are stripped of the monad:" ^
            SymSet.foldl (fn (sym,str) => str ^ "\n" ^ SymbolTable.getString(!SymbolTables.varTable, sym))
               "" pureToMon ^ "\n")*)
         val sVar = { monVars = pureToMon } : stateVar
         val ds = map (visitDecl sVar) ds
      in
         { decls = ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs }
      end
   
end

structure Simplify = struct
   val name = "simplify"

   open Imp
      
   exception SimplifierBug
   
   type state = {
      decls : decl SymMap.map,
      declsRef : arg list ref,
      stmtsRef : stmt list ref
   }

   fun canDuplicate (IDexp _) = true
     | canDuplicate (PRIexp (GETSTATEprim,_,[])) = true
     | canDuplicate (SELECTexp (_,_,_,e)) = canDuplicate e
     | canDuplicate _ = false
     
   fun visitStmt s (ASSIGNstmt (NONE, PRIexp (GET_CON_ARGprim,_,[_,e]))) = visitStmt s (ASSIGNstmt (NONE, e))
     | visitStmt s (ASSIGNstmt (res,exp)) = (case visitExp s exp of
         PRIexp (RAISEprim,t,es) => ASSIGNstmt (NONE, PRIexp (RAISEprim,t,es))
       | PRIexp (SETSTATEprim,t,es) => (#stmtsRef s := !(#stmtsRef s) @ [ASSIGNstmt (NONE, PRIexp (SETSTATEprim,t,es))];
                                       ASSIGNstmt (res,PRIexp (VOIDprim, VOIDvtype, [])))
       | exp => ASSIGNstmt (res, exp)
      )
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, visitBlock s t, visitBlock s e)
      (* inline bogus case statements *)
     | visitStmt s (CASEstmt (e,ps as [(sp,pat,bb)])) =
         if case pat of
               WILDpat => true
             | VECpat p => List.all (fn pat => List.all (fn c => c = #".") (String.explode pat)) p
             | _ => false
         then
            let
               val BASICblock (decls,stmts) = visitBlock s bb
               val _ = (#declsRef s) := decls @ (!(#declsRef s))
               val _ = (#stmtsRef s) := stmts @ (!(#stmtsRef s))
            in
               ASSIGNstmt (NONE, PRIexp (VOIDprim,VOIDvtype,[]))
            end
         else
            CASEstmt (visitExp s e, map (visitCase s) ps)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)
   
   and visitCase s (sp,p,stmts) = (sp,p, visitBlock s stmts)
   
   and visitBlock s (BASICblock (decls, stmts)) =
      let
         (* visit each statement and insert any statements that were generated due to
            simplifications *)
         val s' = { decls = #decls s,
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
         val stmts = trStmts stmts
         val decls = decls @ !(#declsRef s')
         (* filter bogus assignments *)
         fun noVoids (ASSIGNstmt (NONE,PRIexp (VOIDprim,_,_))) = false
           | noVoids _ = true
         val stmts = List.filter noVoids stmts
      in
         BASICblock (decls,stmts)
      end
   
   and visitExp s (PRIexp (SLICEprim,t,[e,LITexp (INTvtype, INTlit ofs), LITexp (INTvtype, INTlit size)])) =
      (case visitExp s e of
         VEC2INTexp (_,PRIexp (SLICEprim,_,[e,LITexp (INTvtype, INTlit ofs2), LITexp (INTvtype, INTlit size2)])) =>
            PRIexp (SLICEprim,t,[e,LITexp (INTvtype, INTlit (ofs+ofs2)), LITexp (INTvtype, INTlit size)])
       | e as VEC2INTexp (_,PRIexp (CONCAT_VECprim,_,[
            vec1 as PRIexp (SLICEprim,t1,[e1,LITexp (INTvtype, INTlit ofs1), LITexp (INTvtype, INTlit size1)]),
            vec2 as PRIexp (SLICEprim,t2,[e2,LITexp (INTvtype, INTlit ofs2), LITexp (INTvtype, INTlit size2)])
          ])) => if ofs>=size2 then visitExp s (
            PRIexp (SLICEprim,t,[
               VEC2INTexp (SOME (IntInf.toInt size1), vec1),
               LITexp (INTvtype, INTlit (ofs-size2)), LITexp (INTvtype, INTlit size)]))
         else if ofs+size<=size2 then visitExp s (
            PRIexp (SLICEprim,t,[
               VEC2INTexp (SOME (IntInf.toInt size2), vec2),
               LITexp (INTvtype, INTlit ofs), LITexp (INTvtype, INTlit size)]))
         else PRIexp (SLICEprim,t,[e,LITexp (INTvtype, INTlit ofs), LITexp (INTvtype, INTlit size)])
       | e => PRIexp (SLICEprim,t,[e,LITexp (INTvtype, INTlit ofs), LITexp (INTvtype, INTlit size)])
      )
     | visitExp s (PRIexp (SETSTATEprim,_,[PRIexp (GETSTATEprim,_,[])])) = PRIexp (VOIDprim,VOIDvtype,[])
     | visitExp s (PRIexp (f,t,es)) = PRIexp (f,t,map (visitExp s) es)
     | visitExp s (IDexp sym) = IDexp sym
     | visitExp s (CALLexp (e,es)) =
      let
         val es = map (visitExp s) es
      in
         case visitExp s e of
            IDexp sym => (case getTrivialFunctionBody (SymMap.find (#decls (s :state),sym), es) of
               SOME exp => exp
             | NONE => CALLexp (IDexp sym, es)
            )
          | e => CALLexp (e, es)
      end
     | visitExp s (INVOKEexp (t, e, es)) = (case visitExp s e of
         CLOSUREexp (tCl,sym,esCl) => (case SymMap.find (#decls (s :state),sym) of
            SOME (CLOSUREdecl { closureDelegate = delSym, ... }) =>
               visitExp s (CALLexp (IDexp delSym, map (visitExp s) (esCl @ es)))
          | _ => (TextIO.print ("INVOKE of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " is bad idea.\n"); raise SimplifierBug)
         )
       | e => INVOKEexp (t, e, map (visitExp s) es)
      )
     | visitExp s (RECORDexp (rs,t,fs)) = RECORDexp (rs,t,map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (SELECTexp (rs,t,f,e)) = (case visitExp s e of
           RECORDexp (_,t,fs) => (
            case List.find (fn (name,e) => SymbolTable.eq_symid (f,name)) fs of
                 SOME (name,e) => e 
               | NONE => raise SimplifierBug
            )
         | e => SELECTexp (rs,t,f,e)
      )
     | visitExp s (UPDATEexp (rs,t,fs,e)) =
        if List.null fs then visitExp s e else
        UPDATEexp (rs,t,map (fn (f,e) => (f,visitExp s e)) fs,visitExp s e)
     | visitExp s (LITexp l) = LITexp l
     | visitExp s (BOXexp (t,e)) = (case visitExp s e of
            UNBOXexp (t2,e) => e
          | e => BOXexp (t, e)
        )
     | visitExp s (UNBOXexp (t,e)) =  (case visitExp s e of
            BOXexp (t,e) => e
          | e => UNBOXexp (t, e)
        )
     | visitExp s (VEC2INTexp (sz,e)) = (case visitExp s e of
            INT2VECexp (sz,e) => e
          | e => VEC2INTexp (sz, e)
        )
     | visitExp s (INT2VECexp (sz,e)) = (case visitExp s e of
            VEC2INTexp (sz,e) => e
          | e => INT2VECexp (sz, e)
        )
     | visitExp s (CLOSUREexp (t,sym,es)) = CLOSUREexp (t,sym,map (visitExp s) es)
     | visitExp s (STATEexp (b,t,e)) =
         let
            val e' = visitExp s e
            val eDecls = !(#declsRef s)
            val eStmts = !(#stmtsRef s)
            val _ = (#declsRef s) := []
            val _ = (#stmtsRef s) := []
            val BASICblock (decls,stmts) = visitBlock s b
         in
            STATEexp (BASICblock (decls @ eDecls, stmts @ eStmts), t, e')
         end
     | visitExp s (EXECexp (t, e)) = (case visitExp s e of
            STATEexp (BASICblock (decls, stmts),_,e) => 
            let
               val _ = (#declsRef s) := decls @ (!(#declsRef s))
               val _ = (#stmtsRef s) := stmts @ (!(#stmtsRef s))
            in
               e
            end
          | e => EXECexp (t, e)
        )                                           

   and getTrivialFunctionBody (SOME (FUNCdecl {
         funcArgs = [(_,arg)],
         funcBody = BASICblock ([], [
            ASSIGNstmt (SOME symRes, SELECTexp (rs,t, field, IDexp symArg))
         ]),
         funcRes = res,
         ...
      }),[e]) =
      if not (SymbolTable.eq_symid (arg,symArg)) orelse
         not (SymbolTable.eq_symid (res,symRes)) then NONE else
      let
         val tab = !SymbolTables.varTable
         val (tab, symDum) = SymbolTable.fresh (tab, Atom.atom "dummy_select")
         val _ = SymbolTables.varTable := tab
      in
         SOME (SELECTexp (symDum, t, field, e))
      end
     | getTrivialFunctionBody (SOME (FUNCdecl {
         funcArgs = args,
         funcBody = BASICblock ([], [
            ASSIGNstmt (SOME symRes, UPDATEexp (rs,t,fs,recArg))
         ]),
         funcRes = res,
         ...
      }),es) =
      if not (List.all (fn ((_,arg),exp) => case exp of
            IDexp sym => SymbolTable.eq_symid (arg,sym)
          | _ => false) (ListPair.zip (args,map #2 fs @ [recArg]))) orelse
         not (List.length es=List.length args) orelse
         not (canDuplicate (List.last es)) orelse
         not (SymbolTable.eq_symid (res,symRes)) then NONE else
      let
         val tab = !SymbolTables.varTable
         val (tab, symDum) = SymbolTable.fresh (tab, Atom.atom "dummy_update")
         val _ = SymbolTables.varTable := tab
      in
         SOME (UPDATEexp (symDum, t, ListPair.zip (map #1 fs, es), List.last es))
      end
     | getTrivialFunctionBody _ = NONE

   fun visitDecl s (FUNCdecl {
        funcIsConst = isConst,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = stmts,
        funcRes = res
      }) = FUNCdecl {
        funcIsConst = isConst,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = visitBlock s stmts,
        funcRes = res
      }
     | visitDecl s d = d

   fun run ({ decls = ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs } : imp) =
      let
         val declMap = foldl (fn (decl,m) => SymMap.insert (m,getDeclName decl, decl)) SymMap.empty ds
         val state = { decls = declMap,
                       declsRef = ref ([] : arg list),
                       stmtsRef = ref ([] : stmt list) } : state
         val ds = map (visitDecl state) ds
      in
         { decls = ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs } : imp
      end
   
end

structure TypeRefinement = struct
   val name = "type-refinement"

   open Imp
   
   val debugOn = ref false
   fun msg str = if !debugOn then TextIO.print str else ()
   
   (* This flag determines if we infer that variables contain records with
      a fixed set of fields (i.e. those records where update functions never
      add but only replace fields). *)
   val genFixedRecords = ref true

   exception TypeOptBug
   
   type index = int

   (* existance of a record field: true denotes that the field
      is always in the record, false means that the field may be
      in the record; this flag is also used
      to indicate this property for all non-existing fields *)
   type existance = bool

   (* The universe of types form a lattice with VOID being the bottom element
      and OBJ being the top element and all other types are in-between. Types
      are only combined using a least-upper bound operation (lub). *)
   datatype stype
     = VOIDstype
     | VARstype of index
     | BOXstype of stype
     | FUNstype of (stype * stype * stype list) (* the middle value is VOID if no closure had any arguments and OBJstype otherwise *)
     | MONADstype of stype
     | RECORDstype of stype * (existance * SymbolTable.symid * stype) list * existance (* the first value is VOID for unboxed and OBJstype otherwise *)
     | BITstype of stype
     | CONSTstype of int
     | STRINGstype
     | INTstype
     | OBJstype
   
   fun isOBJstype (OBJstype) = true
     | isOBJstype _ = false

   type state = {
     symType : (index SymMap.map) ref,
     fieldType : (index SymMap.map) ref,
     typeTable : stype DynamicArray.array,
     origDecls : decl SymMap.map,
     origLocals : (vtype SymMap.map) ref,
     origFields : vtype SymMap.map,
     stateSym : SymbolTable.symid
   }

   fun showSType (VOIDstype) = "void"
     | showSType (VARstype idx) = "#" ^ Int.toString idx
     | showSType (BOXstype t) = "box(" ^ showSType t ^ ")"
     | showSType (FUNstype (res,cl,args)) = ("(") ^ #1 (
         foldl (fn (t,(str,sep)) => (str ^ sep ^ showSType t,","))
            ("", "") args
         ) ^ (if isOBJstype cl then ") => " else ") -> ") ^ showSType res
     | showSType (MONADstype r) = "M " ^ showSType r
     | showSType (RECORDstype (boxed,fs,b)) = 
         (if isOBJstype boxed then "*" else "") ^ "{" ^ #1 (
         foldl (fn ((b,f,t),(str,sep)) => (str ^ sep ^
            (if b then "" else "?") ^
            SymbolTable.getString(!SymbolTables.fieldTable, f) ^
            ":" ^ showSType t,","))
            ("", "") fs) ^ (if b then ",..." else ",?...") ^"}"
     | showSType (CONSTstype s) = Int.toString s
     | showSType (BITstype t) = "|" ^ showSType t ^ "|"
     | showSType (STRINGstype) = "string"
     | showSType (INTstype) = "int"
     | showSType (OBJstype) = "obj"

   structure IS = IntListSet
   fun showSTypes (s : state) tys =
      let
         val idxRef = ref ([] : int list)
         val tt = #typeTable (s : state)
         fun showSType (VOIDstype) = "void"
           | showSType (VARstype idx) = (idxRef := idx :: (!idxRef);
              "#" ^ Int.toString idx)
           | showSType (BOXstype t) = "box(" ^ showSType t ^ ")"
           | showSType (FUNstype (res,cl,args)) = ("(") ^ #1 (
               foldl (fn (t,(str,sep)) => (str ^ sep ^ showSType t,","))
                  ("", "") args
               ) ^ (if isOBJstype cl then ") => " else ") -> ") ^ showSType res
           | showSType (MONADstype r) = "M " ^ showSType r
           | showSType (RECORDstype (boxed,fs,b)) = 
               (if isOBJstype boxed then "*" else "") ^ "{" ^ #1 (
               foldl (fn ((b,f,t),(str,sep)) => (str ^ sep ^
                  (if b then "" else "?") ^
                  SymbolTable.getString(!SymbolTables.fieldTable, f) ^
                  ":" ^ showSType t,","))
                  ("", "") fs) ^ (if b then ",..." else ",?...") ^"}"
           | showSType (CONSTstype s) = Int.toString s
           | showSType (BITstype t) = "|" ^ showSType t ^ "|"
           | showSType (STRINGstype) = "string"
           | showSType (INTstype) = "int"
           | showSType (OBJstype) = "obj"
         fun fixpoint (done,[]) = ""
           | fixpoint (done,idx::idxs) =
            if IS.member (done,idx) then fixpoint (done,idxs) else
            let
               val str = Int.toString idx ^ ": " ^ showSType (DynamicArray.sub (tt,idx))
               val idxs = idxs @ (!idxRef)
               val _ = idxRef := []
            in
               str ^ "\n" ^ fixpoint (IS.add (done,idx),idxs)
            end
      in
         fixpoint (IS.empty, tys)
      end

   fun inlineSType s t =
      let
         val tt = #typeTable (s : state)
         fun inline ecrs (VARstype idx) =
            (*if IS.member (ecrs, idx) then
               (TextIO.print ("found " ^ Int.toString idx ^ " several times:\n");
               app (fn x => TextIO.print ("idx " ^ Int.toString x ^ " : " ^ showSType (DynamicArray.sub (tt,x)) ^ "\n")) (IS.listItems (ecrs));
               raise TypeOptBug)
            else*)
            let
               fun find idx = case DynamicArray.sub (tt,idx) of
                  VARstype idx' => if idx=idx' then idx' else find idx'
                | t => idx
               val ecr = find idx
               (*val _ =if idx<>ecr then msg ("inlineSType: forwarded var " ^ Int.toString idx ^ " to " ^ Int.toString ecr ^ "\n") else ()*)
               (*val ecrs = IS.add (ecrs, idx)
               val ecrs = IS.add (ecrs, ecr)*)
            in
               inline ecrs (DynamicArray.sub (tt,ecr))
            end
           | inline ecrs (BOXstype t) = BOXstype (inline ecrs t)
           | inline ecrs (FUNstype (res,clos,args)) = FUNstype (inline ecrs res, inline ecrs clos, map (inline ecrs) args)
           | inline ecrs (MONADstype res) = MONADstype (inline ecrs res)
           | inline ecrs (RECORDstype (boxed,fs,b)) = RECORDstype (inline ecrs boxed,map (fn (b,f,t) => (b,f,inline ecrs t)) fs,b)
           | inline ecrs (BITstype t) = BITstype (inline ecrs t)
           | inline ecrs t = t
      in
         inline IS.empty t
      end

   fun showState syms (s as { symType = st, fieldType = ft, typeTable = tt, ...} : state) =
      let
         fun showSymBinding sym =
            let
               val idx = SymMap.lookup (!st, sym)
               val tyStr = showSType (inlineSType s (DynamicArray.sub(tt,idx)))
               val _ = TextIO.print (SymbolTable.getString(!SymbolTables.varTable, sym) ^ " : " ^ tyStr ^ "\n")
            in
               ()
            end
         fun showFieldBinding (sym,idx) =
            let
               val tyStr = showSType (inlineSType s (DynamicArray.sub(tt,idx)))
               val _ = TextIO.print (SymbolTable.getString(!SymbolTables.fieldTable, sym) ^ " : " ^ tyStr ^ "\n")
            in
               ()
            end
         val _ = app showSymBinding syms
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
   
   fun symType ({ symType = st, typeTable = tt, ...} : state) sym =
      (case SymMap.find (!st,sym) of
         SOME idx => VARstype idx
       | NONE =>
         let
            val idx = DynamicArray.bound tt + 1
            (*val _ = if SymbolTable.toInt sym=4936 then debugOn := true else ()*)
            (*val _ = msg ("symType(" ^ (SymbolTable.getString(!SymbolTables.varTable, sym)) ^ ")= " ^ Int.toString idx ^ "\n")*)
            (*val _ = if idx=115 then TextIO.print ("symType(" ^ (SymbolTable.getString(!SymbolTables.varTable, sym)) ^ ")= " ^ Int.toString idx ^ "\n") else ()*)

            (*val _ = if idx=57656 then TextIO.print ("symType(" ^ (SymbolTable.getString(!SymbolTables.varTable, sym)) ^ ")= " ^ Int.toString idx ^ "\n") else ()
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
         (*val _ = if idx=40784 then TextIO.print ("created fresh var " ^ Int.toString idx ^ "\n") else ()*)
      in
         VARstype idx
      end
   
   fun lub (s as { typeTable = tt, ...} : state,t1,t2) =
      let
         (*val _ = if t1=VARstype 97 orelse t2=VARstype 97 then TextIO.print ("lub of " ^ showSType t1 ^ " and " ^ showSType t2 ^ ", that is, of " ^showSType (inlineSType s t1) ^ " and " ^ showSType (inlineSType s t2) ^ "\n") else ()*)
         (*val _ = if t1=VARstype 100 orelse t2=VARstype 100 then TextIO.print ("lub of " ^ showSType t1 ^ " and " ^ showSType t2 ^ ", that is, of " ^showSType (inlineSType s t1) ^ " and " ^ showSType (inlineSType s t2) ^ "\n") else ()*)
         (*val _ = msg ("lub of " ^ showSType t1 ^ " and " ^ showSType t2 ^ ", that is, of " ^showSType (inlineSType s t1) ^ " and " ^ showSType (inlineSType s t2) ^ "\n")*)
         val iter = ref 0
         fun lub (VARstype x, VARstype y) =
            let
               val xRoot = find (tt,x)
               val yRoot = find (tt,y)
            in
            if xRoot=yRoot then VARstype x else
            let
               (*val _ = if x=77091 orelse y=77091 then TextIO.print ("lub of " ^ Int.toString x ^ " and " ^ Int.toString y ^ ", where:\n" ^ showSTypes s [x,y] ^ "\n") else ()*)
               (*val _ = if x=28597 orelse y=28597 then TextIO.print ("lub of " ^ Int.toString x ^ " and " ^ Int.toString y ^ ", where:\n" ^ showSTypes s [x,y] ^ "\n") else ()*)
               (*val _ = debugOn := (x=38859 orelse y=38859)*)
               val _ = iter := (!iter) + 1
               val xTy = DynamicArray.sub (tt,xRoot)
               val yTy = DynamicArray.sub (tt,yRoot)
               (*val _ = if (xRoot=97 orelse yRoot=97) andalso (xRoot<>yRoot) then TextIO.print ("lub of " ^ showSType t1 ^ " and " ^ showSType t2 ^ ", that is, of " ^showSType (inlineSType s t1) ^ " and " ^ showSType (inlineSType s t2) ^ "\n") else ()*)
               val ecr = VARstype (Int.min (xRoot, yRoot))

               val (recurse,ty) = case (xTy,yTy) of
                  (VARstype xRoot, VARstype yRoot) => (NONE,ecr)
                | (VARstype xRoot, t) => (NONE,t)
                | (t, VARstype yRoot) => (NONE,t)
                | (t1,t2) => (SOME (t1,t2), VOIDstype)

               (*val _ = if !debugOn then TextIO.print ("lub: unify " ^ Int.toString x ^ " and " ^ Int.toString y ^ ", ty = " ^ showSType ty ^ "\n" ^ showSTypes s [x,y]) else ()*)

               val _ = DynamicArray.update (tt,Int.max (xRoot,yRoot),ecr)
               val _ = DynamicArray.update (tt,Int.min (xRoot,yRoot),ty)
               val _ = if !iter>60 then (TextIO.print ("Recursion!!!! via " ^ showSType t1 ^ " and " ^ showSType t2 ^ "\n")) else
                  case recurse of
                     NONE => ()
                   | SOME (t1,t2) => ignore (lub (ecr,lub (t1,t2)))
            in
               ecr
            end
            end
           | lub (VARstype x, t) =
            let
               (*val _ = if !debugOn then TextIO.print ("lub: replace " ^ Int.toString x ^ " by " ^ showSType t ^ "\n") else ()*)
               (*val _ = case t of
                  (MONADstype (VARstype 38859)) => TextIO.print ("subst " ^ showSType (VARstype x) ^ " / " ^ showSType t ^ "\n")
                | _ => ()*)
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
               (*val _ = if !debugOn then TextIO.print ("lub: replace " ^ Int.toString y ^ " by " ^ showSType t ^ "\n") else ()*)
               (*val _ = if y=28597 then TextIO.print ("lub of " ^ showSType t1 ^ " and " ^ showSType t2 ^ ", where:\n" ^ showSTypes s [y] ^ "\n") else ()*)
               (*val _ = case t of
                  (MONADstype (VARstype 38859)) => TextIO.print ("subst " ^ showSType (VARstype y) ^ " / " ^ showSType t ^ "\n")
                | _ => ()*)
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
           | lub (MONADstype r1, MONADstype r2) = MONADstype (lub (r1,r2))
           | lub (RECORDstype (boxed1,fs1,always1), RECORDstype (boxed2,fs2,always2)) =
            let
               fun mergeFields ((b1,f1,t1)::fs1, (b2,f2,t2)::fs2) =
                  (case SymbolTable.compare_symid (f1,f2) of
                     EQUAL   => (b1 andalso b2, f1, lub (t1,t2)) :: mergeFields (fs1,fs2)
                   | LESS    => (always2,f1,t1)::mergeFields (fs1, (b2,f2,t2)::fs2)
                   | GREATER => (always1,f2,t2)::mergeFields ((b1,f1,t1)::fs1, fs2)
                  )
                 | mergeFields ([],fs2) = map (fn (e,f,t) => (always1,f,t)) fs2
                 | mergeFields (fs1,[]) = map (fn (e,f,t) => (always2,f,t)) fs1
               val fs = mergeFields (fs1,fs2)
            in
               RECORDstype (lub (boxed1,boxed2), fs, always1 andalso always2)
            end
           | lub (RECORDstype (_,fs,b), _) =
               (map (fn (b,f,t) => lub (fieldType s f, t)) fs; OBJstype)
           | lub (_, RECORDstype (_,fs,b)) =
               (map (fn (b,f,t) => lub (fieldType s f, t)) fs; OBJstype)
           | lub (BITstype s1, BITstype s2) = BITstype (lub (s1,s2))
           | lub (CONSTstype s1, CONSTstype s2) =
               if s1=s2 then CONSTstype s1 else OBJstype
           | lub (INTstype, INTstype) = INTstype
           | lub (STRINGstype, STRINGstype) = STRINGstype
           | lub (BOXstype t1, BOXstype t2) = BOXstype (lub (t1,t2))
           | lub (OBJstype, OBJstype) = OBJstype
           | lub (t1', t2') = 
            ((*TextIO.print ("lub top for " ^ showSType t1' ^ "; " ^ showSType t2' ^ " when called for " ^ showSType t1 ^ "; " ^ showSType t2 ^ ", that is, " ^ showSType (inlineSType s t1) ^ "; " ^ showSType (inlineSType s t2) ^ "\n");*)
            OBJstype)

      in
         lub (t1,t2)
      end
   
   fun vtypeToStype s VOIDvtype = VOIDstype
     | vtypeToStype s VECvtype = BITstype VOIDstype
     | vtypeToStype s INTvtype = INTstype
     | vtypeToStype s STRINGvtype = STRINGstype
     | vtypeToStype s OBJvtype = OBJstype
     | vtypeToStype s (FUNvtype (res, cl, args)) =
         FUNstype (vtypeToStype s res, if cl then OBJstype else VOIDstype, map (vtypeToStype s) args)
     | vtypeToStype s (MONADvtype res) = MONADstype (vtypeToStype s res)
     | vtypeToStype s (RECORDvtype (boxed,fs)) =
         RECORDstype (if boxed then OBJstype else VOIDstype,map (fn (f,t) => (true,f,vtypeToStype s t)) fs, false)

   fun visitBlock s (BASICblock (decls,stmts)) = app (visitStmt s) stmts

   and visitStmt s (ASSIGNstmt (NONE, exp)) = ignore (visitExp s exp)
     | visitStmt s (ASSIGNstmt (SOME sym, exp)) = ignore (lub (s, symType s sym, visitExp s exp))
     | visitStmt s (IFstmt (c,t,e)) = (lub (s,INTstype, visitExp s c);
                                       visitBlock s t; visitBlock s e)
     | visitStmt s (CASEstmt (e,cs)) = (lub (s, visitExp s e, INTstype);
      (*TextIO.print ("unified scurtinee " ^ showSType (inlineSType s (visitExp s e)) ^ "\n");*)
                                        app (visitBlock s o #3) cs)

   and visitExp s (IDexp sym) = symType s sym
     | visitExp s (PRIexp (SLICEprim,t,es as [vec,ofs,LITexp (INTvtype, INTlit sz)])) =
         visitCall s (FUNstype (BITstype (CONSTstype (IntInf.toInt sz)), VOIDstype, [INTstype, INTstype, INTstype]), es)
     | visitExp s (PRIexp (CONCAT_VECprim,t,[vec1,vec2])) =
      let
         val tySize1 = freshTVar s
         val tySize2 = freshTVar s
         val _ = lub (s,visitExp s vec1, BITstype (tySize1))
         val _ = lub (s,visitExp s vec2, BITstype (tySize2))
      in   
         BITstype (
            case (inlineSType s tySize1, inlineSType s tySize2) of
               (CONSTstype s1, CONSTstype s2) => CONSTstype (s1+s2)
               | _ => OBJstype
            )
      end
     | visitExp s (PRIexp (ORprim,t,[vec1,vec2])) =
         lub (s,visitExp s vec1, visitExp s vec2)
     | visitExp s (PRIexp (ANDprim,t,[vec1,vec2])) =
         lub (s,visitExp s vec1, visitExp s vec2)
     | visitExp s (PRIexp (GET_CON_ARGprim,t, es)) =
         let
            val [IDexp arg,_] = es
            val (SOME decl) = SymMap.find (#origDecls (s : state), arg)
            val (CONdecl {
                    conArg = (t,sym),
                    ...
                 }) = decl
         in
            symType s sym
         end
     | visitExp s (PRIexp (SETSTATEprim,_, [UPDATEexp (rs,_,fs,PRIexp (GETSTATEprim,_,[]))])) =
         let
            val recTy = lub (s, symType s (#stateSym s), symType s rs)
            val fields = map (fn (f,e) => (true,f,visitExp s e)) fs
            val _ = lub (s, recTy, RECORDstype (freshTVar s, fields, true))
         in
            VOIDstype
         end
     | visitExp s (PRIexp (SETSTATEprim,_,[e])) = (lub (s, symType s (#stateSym s), visitExp s e); VOIDstype)
     | visitExp s (PRIexp (GETSTATEprim,_,[])) = symType s (#stateSym s)
     | visitExp s (PRIexp (f,t,es)) = visitCall s (vtypeToStype s t, es)
     | visitExp s (CALLexp (e,es)) = visitCall s (visitExp s e, es)
     | visitExp s (INVOKEexp (t,e,es)) = visitCall s (visitExp s e, es)
     | visitExp s (RECORDexp (rs,t,fs)) = 
      if !genFixedRecords then
         lub (s, symType s rs, 
            RECORDstype (
               if length fs >= Controls.get BasicControl.boxThreshold
                  then OBJstype else freshTVar s,
               map (fn (f,e) => (true, f, visitExp s e)) fs, false))
      else
         (map (fn (f,e) => lub (s,fieldType s f, visitExp s e)) fs;
         lub (s, symType s rs, OBJstype))
     | visitExp s (SELECTexp (rs,t,f,e)) =
      if !genFixedRecords then
         let
            val resTy = freshTVar s
            val _ = lub (s, symType s rs, visitExp s e)
            val _ = lub (s, symType s rs, RECORDstype (freshTVar s,[(true,f,resTy)],true))
         in
            resTy
         end
      else
         (lub (s, symType s rs, lub (s,OBJstype,visitExp s e));
         fieldType s f)
     | visitExp s (UPDATEexp (rs,t,fs,e)) =
         let
            val sFields = map (fn (f,e) => (true,f,visitExp s e)) fs
            val ty = lub (s, symType s rs, RECORDstype (freshTVar s,sFields,true))
         in
            lub (s, ty, visitExp s e)
         end
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
     | visitExp s (INT2VECexp (0, e)) = (case e of
          PRIexp (ORprim,_,[VEC2INTexp (NONE,e1),VEC2INTexp (NONE,e2)]) =>
            lub (s, visitExp s e1, visitExp s e2)
        | PRIexp (ANDprim,_,[VEC2INTexp (NONE,e1),VEC2INTexp (NONE,e2)]) =>
            lub (s, visitExp s e1, visitExp s e2)
        | e => (lub (s, INTstype, visitExp s e); BITstype VOIDstype)
      )
     | visitExp s (INT2VECexp (sz,e)) = (lub (s, INTstype, visitExp s e); BITstype (CONSTstype sz))
     | visitExp s (CLOSUREexp (t,sym,es)) =
         let
            val (SOME decl) = SymMap.find (#origDecls (s : state), sym)
            val (CLOSUREdecl {
                    closureName = name,
                    closureArgs = _,
                    closureDelegate = del,
                    closureDelArgs = delArgs,
                    closureRetTy = _
                 }) = decl
            val clTysS = map (visitExp s) es
            val delTysS = map (fn (_,arg) => symType s arg) delArgs
            val resTy = freshTVar s
            val returnTy = freshTVar s
            (*val _ = msg ("CLOSUREexp: resTy = " ^ showSType (resTy) ^ ", returnTy = "^ showSType (returnTy) ^ "\n")*)
            val isCl = if List.null es then freshTVar s else OBJstype
            val t = lub (s,returnTy, FUNstype (resTy, isCl, delTysS))
            val _ = lub (s,symType s name, FUNstype (returnTy, isCl, clTysS))
            val _ = lub (s,symType s del,  FUNstype (resTy, VOIDstype, clTysS @ delTysS))
            (*val _ = msg ("CLOSUREexp: looking for symbol " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ ": " ^ showSType (inlineSType s (symType s name)) ^ "\n")*)
         in
           returnTy
         end
     | visitExp s (STATEexp (b,t,e)) =
      let
         val _ = visitBlock s b
      in
         MONADstype (visitExp s e)
      end
     | visitExp s (EXECexp (ty,e)) =
      let
         val resVar = freshTVar s
         val _ = lub (s,visitExp s e, MONADstype resVar)
      in
         resVar
      end
   
   and visitCall s (fTy,args) =
      let
         val resTy = freshTVar s
         val _ = lub (s,FUNstype (resTy,VOIDstype,map (visitExp s) args),fTy)
      in
         resTy
      end

   fun visitDecl s (f as FUNCdecl {
        funcIsConst = isConst,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = block,
        funcRes = res
      }) =
      let
         (*val _ = msg ("visitDecl start " ^ SymbolTable.getString(!SymbolTables.varTable, name) ^ "\n")*)
         val _ = visitBlock s block
         fun argTypes args = map (fn (_,sym) => symType s sym) args
         val ty = FUNstype (symType s res, VOIDstype, argTypes clArgs @ argTypes args)
         val fType = lub (s, symType s name, ty)
         (*val _ = msg ("visitDecl end   " ^ SymbolTable.getString(!SymbolTables.varTable, name) ^ " : " ^ showSType ty ^ ", that is, " ^ showSType (inlineSType s ty) ^ "\n")*)
      in
         fType
      end
     | visitDecl s (CONdecl {
         conName = name,
         conTag = _,
         conArg = (_,arg),
         conType = _
     }) = lub (s, symType s name, FUNstype (OBJstype, VOIDstype, [symType s arg]))
     | visitDecl s (CLOSUREdecl {
        closureName = name,
        closureArgs = clTys,
        closureDelegate = del,
        closureDelArgs = delArgs,
        closureRetTy = _
     }) =
      let
         (*val _ = msg ("visitDecl CLOSURE: type before: " ^ showSType (inlineSType s (symType s name)) ^ "\n")*)
         val isCl = if null clTys then freshTVar s else OBJstype
         val resTy = freshTVar s
         val clTysS = map (fn _ => freshTVar s) clTys
         val delTysS = map (symType s o #2) delArgs
         val t = lub (s, symType s name, FUNstype (FUNstype (resTy, isCl, delTysS), isCl, clTysS))
         val _ = lub (s, symType s del, FUNstype (resTy,VOIDstype,clTysS @ delTysS))
         (*val _ = msg ("visitDecl CLOSURE: type after: " ^ showSType (inlineSType s (symType s name)) ^ "\n")*)
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
        | (SOME (CONdecl { conType = ty, ... })) => ty
        | (SOME (CLOSUREdecl { closureArgs = ts, ... })) => FUNvtype (OBJvtype,true,ts)
        | NONE => (TextIO.print ("origType: no type of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n"); raise TypeOptBug)
      )
 
   fun getArgTypes s sym = case SymMap.find (#origDecls s, sym) of
          SOME (FUNCdecl { funcArgs = args, ... }) =>
            map (fn (t,sym) => (t,symType s sym)) args
        | SOME (CONdecl { conName = name, conArg = (_,arg), ... }) =>
            [(origType s arg, symType s arg)]
        | SOME (CLOSUREdecl { closureName = name, closureArgs = ts, ... }) =>
            (case inlineSType s (symType s name) of
               (FUNstype (_,_,args)) => ListPair.zip (ts,args)
             | t => (TextIO.print ("getArgTypes: closure not function but " ^ SymbolTable.getString(!SymbolTables.varTable, name) ^ " has type " ^ showSType t ^ "\n"); raise TypeOptBug)
            )
        | NONE =>  (TextIO.print ("getArgTypes, symbol " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " not found\n"); raise TypeOptBug)

   fun readWrap s (orig,new,e) =
      let
         fun genWrap (BOXstype INTstype) = BOXexp (INTvtype,e)
           | genWrap (BOXstype (BITstype (CONSTstype s))) = BOXexp (VECvtype, INT2VECexp (s,e))
           | genWrap (BOXstype (BITstype _)) = BOXexp (VECvtype, e)
           | genWrap _ = e
      in
         case orig of
            OBJvtype => genWrap (inlineSType s new)
          | VOIDvtype => genWrap (inlineSType s new)
          |  t => e
      end

   and writeWrap s (orig,new,e) =
      let
         fun genWrap (BOXstype INTstype) = UNBOXexp (INTvtype,e)
           | genWrap (BOXstype (BITstype (CONSTstype s))) = VEC2INTexp (SOME s,UNBOXexp (VECvtype, e))
           | genWrap (BOXstype (BITstype _)) = UNBOXexp (VECvtype, e)
           | genWrap _ = e
      in
         case orig of
            OBJvtype => genWrap (inlineSType s new)
          | VOIDvtype => genWrap (inlineSType s new)
          | t => e
      end
   
   and adjustType s (orig,new) =
      let
         fun genAdj (BOXstype INTstype) = INTvtype
           | genAdj (BOXstype (BITstype (CONSTstype _))) = INTvtype
           | genAdj (BOXstype (BITstype _)) = VECvtype
           | genAdj (BOXstype _) = OBJvtype
           | genAdj (BITstype (CONSTstype _)) = INTvtype
           | genAdj (BITstype _) = VECvtype
           | genAdj (VOIDstype) = VOIDvtype
           | genAdj (INTstype) = INTvtype
           | genAdj (STRINGstype) = STRINGvtype
           | genAdj (OBJstype) = OBJvtype
           | genAdj (FUNstype (r,cl,args)) =
               FUNvtype (adjustType s (OBJvtype, r), isOBJstype cl, map (fn arg => adjustType s (OBJvtype, arg)) args)
           | genAdj (MONADstype r) = MONADvtype (genAdj r)
           | genAdj (RECORDstype (boxed,fs,b)) = RECORDvtype (isOBJstype boxed, map (fn (_,f,t) => (f, genAdj t)) fs)
           | genAdj t = (TextIO.print ("adjustType of " ^ showSType new ^ ", that is, " ^ showSType (inlineSType s new) ^ "\n"); raise TypeOptBug)
      in
         case orig of
            OBJvtype => genAdj (inlineSType s new)
          | VOIDvtype => genAdj (inlineSType s new)
          | (FUNvtype (rOrig,clOrig,argsOrig)) => (case inlineSType s new of
                (FUNstype (r,cl,args)) => (
                  FUNvtype (adjustType s (rOrig,r), isOBJstype cl, map (adjustType s) (ListPair.zipEq (argsOrig, args)))
                     handle ListPair.UnequalLengths =>
                        (TextIO.print ("adjustType of " ^ Layout.tostring (Imp.PP.vtype (FUNvtype (rOrig,clOrig,argsOrig))) ^ " and " ^ showSType (FUNstype (r,cl,args)) ^ ", unequal length\n"); raise TypeOptBug)
                )
              | t => FUNvtype (rOrig, true, argsOrig)
            )
          | (MONADvtype rOrig) => (case inlineSType s new of
                (MONADstype r) => MONADvtype (adjustType s (rOrig,r))
              | t => MONADvtype rOrig
            )
          | _ => orig
      end

   fun patchDecl s (FUNCdecl {
        funcIsConst = isConst,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = body,
        funcRes = res
      }) =
      let
         (*val _ = msg ("patchDecl of function " ^ SymbolTable.getString(!SymbolTables.varTable, name) ^ "\n")*)
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
            funcIsConst = isConst,
            funcClosure = clArgs',
            funcType = vtype',
            funcName = name,
            funcArgs = args',
            funcBody = body',
            funcRes = res
         }
      end
     | patchDecl s (CONdecl {
         conName = name,
         conTag = tag,
         conArg = (argTy, argName),
         conType = vtype
     }) = CONdecl {
         conName = name,
         conTag = tag,
         conArg = (adjustType s (argTy, symType s argName), argName),
         conType = adjustType s (vtype, symType s name)
     }
     | patchDecl s (CLOSUREdecl {
         closureName = name,
         closureArgs = tsCl,
         closureDelegate = del,
         closureDelArgs = delArgs,
         closureRetTy = retTy
     }) = ((*msg ("patchDecl CLOSURE " ^ SymbolTable.getString(!SymbolTables.varTable, name) ^ " from " ^ Layout.tostring (Imp.PP.vtype (FUNvtype (OBJvtype,false,tsCl @ map #1 delArgs))) ^ " to " ^ showSType (inlineSType s (symType s del)) ^ "\n"); *)
      case adjustType s (FUNvtype (retTy,false,tsCl @ map #1 delArgs), symType s del) of
         FUNvtype (retTy,_,args) =>
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
               closureDelArgs = delArgsNew,
               closureRetTy = retTy
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
         | _ => ((*if SymbolTable.toInt sym= ~1 then debugOn := true else ();
                        msg ("patchExp ASSIGN to " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " from " ^ Layout.tostring (Imp.PP.vtype (origType s sym)) ^ " to " ^ showSType (inlineSType s (symType s sym)) ^ "\n");*)
               ASSIGNstmt (SOME sym,
                  writeWrap s (origType s sym,symType s sym,patchExp s exp))
               )
      )
     | patchStmt s (IFstmt (c,t,e)) = IFstmt (patchExp s c, patchBlock s t, patchBlock s e)
     | patchStmt s (CASEstmt (e,ps)) = CASEstmt (patchExp s e, map (patchCase s) ps)

   and patchCase s (sp,p,stmts) = (sp,p, patchBlock s stmts)
   
   and patchExp s (IDexp sym) = (case inlineSType s (symType s sym) of
         VOIDstype => PRIexp (VOIDprim, VOIDvtype, [])
       | _ => readWrap s (origType s sym, symType s sym, IDexp sym)
      )
     | patchExp s (PRIexp (GET_CON_ARGprim,t, es as [IDexp arg,_])) =
         let
            val (SOME decl) = SymMap.find (#origDecls (s : state), arg)
            val (CONdecl {
                    conArg = (argTy,argSym),
                    ...
                 }) = decl
            val t = adjustType s (t,FUNstype (symType s argSym, VOIDstype, map (visitExp s) es))
         in
            readWrap s (argTy, symType s argSym, PRIexp (GET_CON_ARGprim,t,map (patchExp s) es))
         end
     | patchExp s (PRIexp (GETSTATEprim, t, [])) = PRIexp (GETSTATEprim, adjustType s (t,FUNstype (symType s (#stateSym s), VOIDstype, [])), [])
     | patchExp s (PRIexp (SETSTATEprim, t, [e])) = PRIexp (SETSTATEprim, adjustType s (t,FUNstype (VOIDstype, VOIDstype, [symType s (#stateSym s)])), [patchExp s e])
     | patchExp s (PRIexp (f,t,es)) = PRIexp (f,t,map (patchExp s) es)
     | patchExp s (CALLexp (e,es)) =
      let
         val eNew = patchExp s e
         val origTy = case e of
            IDexp sym => origType s sym
          | _ => FUNvtype (OBJvtype,false,map (fn _ => OBJvtype) es)
         val newTy = visitExp s e
         (*val _ = msg ("patchExp CALL " ^ Layout.tostring (Imp.PP.exp e) ^ " from " ^ Layout.tostring (Imp.PP.vtype origTy) ^ " to " ^ showSType (inlineSType s newTy) ^ "\n")*)
         val (wrap, tyNew, esNew) = patchCall s (origTy, newTy, map (patchExp s) es)
      in
         wrap (CALLexp (eNew, esNew))
      end
     | patchExp s (INVOKEexp (ty, e, es)) =
      let
         val eNew = patchExp s e
         (*val _ = msg ("patchExp INVOKE " ^ Layout.tostring (Imp.PP.exp e) ^ "\n")*)
         val (wrap, tyNew, esNew) = patchCall s (ty,visitExp s e, map (patchExp s) es)
      in
         case tyNew of
            FUNvtype (_,true,_) => wrap (INVOKEexp (tyNew, eNew, esNew))
          | FUNvtype (_,false,_) => wrap (CALLexp (eNew, esNew))
          | _ => raise TypeOptBug (* must be function type *)
      end
     | patchExp s (RECORDexp (rs,t,fs)) =
         let
            val sTy = inlineSType s (symType s rs)
            fun genWrap (f,e) =
               let
                  val (origTy,newTy) = genFieldTypes (s,t,sTy,f)
               in
                  (f, writeWrap s (origTy, newTy, patchExp s e))
               end
         in
            RECORDexp (rs, adjustType s (t, sTy), map genWrap fs)
         end
     | patchExp s (SELECTexp (rs,t,f,e)) =
         let
            val sTy = inlineSType s (symType s rs)
            val (origTy, newTy) = genFieldTypes (s,t,sTy,f)
         in
            readWrap s (origTy, newTy, SELECTexp (rs,adjustType s (t, sTy), f, patchExp s e))
         end
     | patchExp s (UPDATEexp (rs,t,fs,e)) =
         let
            val sTy = inlineSType s (symType s rs)
            fun genWrap (f,e) =
               let
                  val (origTy,newTy) = genFieldTypes (s,t,sTy,f)
               in
                  (f, writeWrap s (origTy, newTy, patchExp s e))
               end
         in
            UPDATEexp (rs, adjustType s (t, sTy), map genWrap fs, patchExp s e)
         end
     | patchExp s (LITexp l) = LITexp l
     | patchExp s (BOXexp (t,e)) = BOXexp (t, patchExp s e)
     | patchExp s (UNBOXexp (t,e)) = UNBOXexp (t, patchExp s e)
     | patchExp s (VEC2INTexp (sz,e)) = VEC2INTexp (sz,patchExp s e)
     | patchExp s (INT2VECexp (sz,e)) = INT2VECexp (sz,patchExp s e)
     | patchExp s (CLOSUREexp (ty,sym,es)) =
      let
         (*val _ = msg ("patchExp CLOSURE " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " from " ^ Layout.tostring (Imp.PP.vtype (origType s sym)) ^ " to " ^ showSType (inlineSType s (symType s sym)) ^ "\n")*)
         val (wrap, tyNew,esNew) = patchCall s (ty, symType s sym, map (patchExp s) es)
      in
         case tyNew of
            FUNvtype (_,true,_) => wrap (CLOSUREexp (tyNew,sym,esNew))
          | FUNvtype (_,false,_) =>
               let
                  val (SOME decl) = SymMap.find (#origDecls (s : state), sym)
                  val (CLOSUREdecl { closureDelegate = del, ... }) = decl
               in
                  IDexp del
               end
          | _ => raise TypeOptBug (* must be function type *)
      end
     | patchExp s (STATEexp (b,t,e)) = STATEexp (patchBlock s b, adjustType s (t,visitExp s e), writeWrap s (t,visitExp s e,patchExp s e))
     | patchExp s (EXECexp (ty, e)) =
      let
         val eNew = patchExp s e
         val sty = visitExp s e
         (*val _ = msg ("patchExp EXEC " ^ Layout.tostring (Imp.PP.exp e) ^ ", expression type now " ^ showSType (inlineSType s sty) ^ "\n")*)
         val (wrap, newTy, _) = patchCall s (ty, sty, [])
         (*val _ = msg ("patchExp result is " ^ Layout.tostring (Imp.PP.exp (wrap (EXECexp (newTy, eNew)))) ^ "\n")*)
      in
         wrap (EXECexp (newTy, eNew))
      end
   
   and patchCall s (orig,new,es) =
      let
         val new = inlineSType s new
         (*val _ = msg ("patchCall of " ^ Layout.tostring (Imp.PP.vtype orig) ^ " and " ^ showSType (inlineSType s new) ^ " with args " ^ Layout.tostring (Layout.seq (Imp.PP.args ("(", Imp.PP.exp, es, ")"))) ^ "\n")*)
         fun genNewArgs acc (FUNvtype (vRes, vCl, vType :: vs),
                             FUNstype (sRes, sCl, sType :: ss), e :: es) =
               genNewArgs (acc @ [writeWrap s (vType,sType,e)])
                  (FUNvtype (vRes, vCl, vs), FUNstype (sRes, sCl, ss), es)
           | genNewArgs acc (OBJvtype, FUNstype (sRes, sCl, ss), es) =
               genNewArgs acc (FUNvtype (OBJvtype, false, map (fn _ => OBJvtype) ss),
                               FUNstype (sRes, sCl, ss), es)
           | genNewArgs acc (FUNvtype (vRes, vCl, vs), OBJstype, es) =
               genNewArgs acc (FUNvtype (vRes, vCl, vs),
                               FUNstype (OBJstype, OBJstype, map (fn _ => OBJstype) vs), es)
           | genNewArgs acc (vs, ss, []) = (acc, vs, ss)
           | genNewArgs acc (v,s,e :: es) = (TextIO.print ("patchCall of " ^ Layout.tostring (Imp.PP.vtype v) ^ " and " ^ showSType s ^ ", next argument is " ^ Layout.tostring (Imp.PP.exp e) ^ "\n"); raise TypeOptBug)

      in
        case genNewArgs [] (orig, new, es) of
           (es, FUNvtype (vRes, vCl, []), FUNstype (sRes, sCl, [])) =>
            (fn e => readWrap s (vRes, sRes, e), adjustType s (orig, new), es)
         | (es, MONADvtype vRes, MONADstype sRes) =>
            (fn e => readWrap s (vRes, sRes, e), adjustType s (orig, new), es)
         | (es, FUNvtype (vRes, vCl, _), OBJstype) =>
            (fn e => readWrap s (vRes, OBJstype, e), adjustType s (orig, new), es)
         | (es, v, t) => (TextIO.print ("patchCall bad of " ^ Layout.tostring (Imp.PP.vtype v) ^ " and " ^ showSType (inlineSType s t) ^ ": no more args\n"); raise TypeOptBug)
      end

   and genFieldTypes (s,t,sTy,f) =
      let
         fun getVTy [] = raise TypeOptBug
           | getVTy ((fld,ty) :: fs) = if SymbolTable.eq_symid (fld,f) then ty else getVTy fs
         fun getSTy [] = raise TypeOptBug
           | getSTy ((_,fld,ty) :: fs) = if SymbolTable.eq_symid (fld,f) then ty else getSTy fs
        
         val origTy = case t of
               RECORDvtype (_,fTys) => getVTy fTys
             | _ => origFType s f
         val newTy = case sTy of
               RECORDstype (_,fTys,_) => getSTy fTys
             | _ => fieldType s f
      in
         (origTy, newTy)
      end

   structure AST = SpecAbstractTree

   (* translate AST types to check that exports have expected types *)

   fun trType s (AST.MARKty {span, tree=t}) = trType s  t
     | trType s (AST.BITty sz) = BOXstype (BITstype (CONSTstype (IntInf.toInt sz)))
     | trType (ta,dt,quantVars,conDef,boxedRec,s) (AST.NAMEDty (sym,args)) =
     let
        (*val _ = msg ("looking up type " ^
           SymbolTable.getString(!SymbolTables.typeTable, sym) ^ " with "
           ^ Int.toString (List.length args) ^ " arguments:\n")*)
        (*val _ = List.app (fn (sym,ty) => TextIO.print (SymbolTable.getString(!SymbolTables.typeTable, sym) ^ " : " ^ Layout.tostring (AST.PP.ty ty) ^ "\n")) args*)
        (*val _ = TextIO.print ("type alias contains:\n")
        val _ = List.app (fn (sym,ty) => TextIO.print (SymbolTable.getString(!SymbolTables.typeTable, sym) ^ " : " ^ Layout.tostring (AST.PP.ty ty) ^ "\n")) (SymMap.listItemsi ta)
        val _ = TextIO.print ("quantVars contains:\n")
        val _ = List.app (fn (sym,ty) => TextIO.print (SymbolTable.getString(!SymbolTables.typeTable, sym) ^ " : " ^ showSType ty ^ "\n")) (SymMap.listItemsi quantVars)
        val _ = TextIO.print ("conDef contains:\n")
        val _ = List.app (fn (sym,(_,_,ty)) => TextIO.print (SymbolTable.getString(!SymbolTables.conTable, sym) ^ " : " ^ showSType ty ^ "\n")) (SymMap.listItemsi (!conDef))*)
     in
     (case SymMap.find (ta,sym) of
          SOME ty =>
          let
             (*val _ = TextIO.print ("found synonym " ^ Layout.tostring (AST.PP.ty ty) ^ "\n");*)
             val ty = trType (List.foldl SymMap.insert' ta args,dt,quantVars,conDef,boxedRec,s) ty
             (*val _ = TextIO.print ("converted to type " ^ showSType (inlineSType s ty) ^ "\n")*)
          in
             ty
          end
        | NONE => (case SymMap.find (dt,sym) of
             SOME cons =>
               let
                  (* the stype of an ADT is always OBJstype, however, if the
                     export declaration sets a polymorphic parameter, we need
                     to propagate this parameter to the constructor that
                     mentions the parameter *)
                  val ta = List.foldl SymMap.insert' ta args
                  val dt = SymMap.insert (dt,sym,[]) (* avoid infinite recursion *)
                  fun restrictConType (cSym,NONE) = ()
                    | restrictConType (cSym,SOME ty) =
                       case SymMap.find (conDef,cSym) of
                          SOME conTy => ignore
                            (lub (s,conTy,
                               trType (ta,dt,quantVars,conDef,VOIDstype,s) ty))
                        | NONE => () (* only live constructors are in this map *)
                  val _ = List.app restrictConType cons
               in
                  OBJstype
               end
           | NONE => (
            case SymMap.find (quantVars,sym) of
               SOME tyVar => tyVar
             | NONE => raise TypeOptBug
           )
        )
     )
     end
     | trType (ta,dt,quantVars,conDef,boxedRec,s) (AST.RECORDty fs) =
      RECORDstype (boxedRec,map (fn (f,ty) =>
            (false,f,trType (ta,dt,quantVars,conDef,boxedRec,s) ty))
            (sortFields fs), false)
     | trType s (AST.FUNCTIONty (args,res)) = FUNstype (trType s res,VOIDstype,map (trType s) args)
     | trType s (AST.MONADty (res,inp,out)) = trType s res
     | trType s AST.INTty = BOXstype (INTstype)
     | trType s AST.UNITty = VOIDstype
     | trType s AST.STRINGty = STRINGstype
                        
   fun compareTypes (VOIDstype,VOIDstype) = true
     | compareTypes (BOXstype t1,BOXstype t2) = compareTypes (t1,t2)
     | compareTypes (FUNstype (res1,clos1,args1), FUNstype (res2,clos2,args2)) =
        compareTypes (res1,res2) andalso compareTypes (clos1,clos2) andalso
        List.all  (fn b => b) (List.map compareTypes (ListPair.zip (args1,args2)))
     | compareTypes (MONADstype t1, MONADstype t2) = compareTypes (t1,t2)
     | compareTypes (RECORDstype (box1,fs1,_),RECORDstype (box2,fs2,_)) =
     let
        fun genMap fs = List.foldl (fn ((_,fid,ty),sm) => SymMap.insert (sm,fid,ty)) SymMap.empty fs
        val sm1 = genMap fs1
        val sm2 = genMap fs2
        val res = compareTypes (box1,box2)
        fun inBoth (SOME f1, SOME f2) = SOME (compareTypes (f1,f2))
          | inBoth (_, _) = NONE
        val boolMap = SymMap.mergeWith inBoth (sm1,sm2)
     in
        res andalso List.all (fn b => b) (SymMap.listItems boolMap)
     end
     | compareTypes (BITstype t1,BITstype t2) = compareTypes (t1,t2)
     | compareTypes (CONSTstype i1,CONSTstype i2) = i1=i2
     | compareTypes (STRINGstype,STRINGstype) = true
     | compareTypes (INTstype,INTstype) = true
     | compareTypes (OBJstype,OBJstype) = true
     | compareTypes (t1,t2) = ((*TextIO.print ("comparing " ^ showSType t1 ^ " with " ^ showSType t2 ^ "\n");*) false)

   fun setArgsToType (errs,ta,dt,conDef,es,s) (FUNCdecl {
        funcName = f,
        funcArgs = args,
        ...
      }) = (case SymMap.find (es,f) of NONE => () | SOME (quant,ty) =>
      let
         (*val _ = msg ("setArgsToType for export " ^
            SymbolTable.getString(!SymbolTables.varTable, f) ^ "\n")*)
         val srcloc = case ty of
              (AST.MARKty {span=s, tree}) => s
            | _ => SymbolTable.noSpan
         fun addTypeVars (sym,ta) = SymMap.insert (ta,sym,freshTVar s)
         val quantVars = foldl addTypeVars SymMap.empty quant
         val targetType = trType (ta,dt,quantVars,conDef,OBJstype,s) ty
         
         (*val _ = msg ("exported type is " ^ showSType targetType ^ "\n")
         val _ = msg ("symbol type is   " ^ showSType (symType s f) ^ "\n")
         val _ = if !debugOn then showTable (#typeTable s) else ()*)

         val targetType = case targetType  of
            FUNstype a => FUNstype a
          | t => FUNstype (t,VOIDstype,[]) (* top-level constants are still functions *)

         val originalType = inlineSType s (symType s f)

         val obtainedType = inlineSType s (lub (s, symType s f, targetType))

         val targetType = inlineSType s targetType
      in
         if compareTypes (targetType,obtainedType) then () else
         Error.warningAt (errs, srcloc,  ["export declaration of " ^
            SymbolTable.getString(!SymbolTables.varTable, f) ^
            " does not fit C type\n",
            "\tC type   " ^ showSType originalType ^ "\n",
            "\texported " ^ showSType targetType ^ "\n",
            "\tcombined " ^ showSType obtainedType ^ "\n"])
      end)
     | setArgsToType _ _ = ()

   fun mergeRecords s =
      let
         val recordTypes = ref AtomMap.empty : stype AtomMap.map ref
         fun checkForRecord (ty as RECORDstype (_,fs,_),recordTypes) =
            let
               val key = case adjustType s (OBJvtype,ty) of
                  RECORDvtype (_, fs) => genRecSignature fs
                | _ => Atom.atom ""
            in
               AtomMap.insert (recordTypes, key,
                  lub (s,Option.getOpt(AtomMap.find (recordTypes,key),VOIDstype),ty))
            end
           | checkForRecord (_, recordTypes) = recordTypes
      in
         DynamicArray.foldl checkForRecord AtomMap.empty (#typeTable s)
      end

   fun run { decls = ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs } =
      let
         (* register one symbol to track the type of the global state *)
         val (tab, stateSym) = SymbolTable.fresh (!SymbolTables.varTable, Atom.atom Primitives.globalState)
         val _ = SymbolTables.varTable := tab

         val declMap = foldl (fn (decl,m) => SymMap.insert (m,getDeclName decl, decl)) SymMap.empty ds
         val state : state = {
            symType = ref SymMap.empty,
            fieldType = ref SymMap.empty,
            typeTable = DynamicArray.array (4000, VOIDstype),
            origDecls = declMap,
            origLocals = ref SymMap.empty,
            origFields = fs,
            stateSym = stateSym
         }
         fun visitDeclPrint state d = ((*TextIO.print ("visiting " ^ SymbolTable.getString(!SymbolTables.varTable, getDeclName d) ^ "\n");*) (*debugOn:=(SymbolTable.toInt(getDeclName d)=84);*) visitDecl state d)
         val _ = map (visitDeclPrint state) ds
         (* unify the types of all records that have the same set of fields and
         types, ensures that boxing is the same for records that are mapped to
         the same C struct *)
         val _ = mergeRecords state
         (* set all arguments in functions and constructors to the type declared in the export list *)

         val conDef = List.foldl (fn (d,sm) => case d of
            CONdecl { conTag = tag, conArg = (_, argName), ... } =>
               SymMap.insert (sm,tag, symType state argName)
          | _ => sm) SymMap.empty ds
         val _ = app (fn d => 
            (debugOn:= SymbolTable.toInt(getDeclName d)=83;
            setArgsToType (errs,ta,dt,conDef,es,state) d)) ds
         
         (*val _ = showState es state*)
         (*val _ = debugOn := false
         fun patchDeclPrint state d = (debugOn:=(SymbolTable.toInt(getDeclName d)= 83); msg ("patching " ^ SymbolTable.getString(!SymbolTables.varTable, getDeclName d) ^ "\n"); patchDecl state d)*)
         val ds = map (patchDecl state) ds
         val fs = SymMap.mapi (fn (sym,ty) => adjustType state (ty, fieldType state sym)) fs
         val mt = adjustType state (mt, symType state stateSym)
      in
         { decls = ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs }
      end
   
end

structure SwitchReduce = struct
   val name = "switch-reduce"

   open Imp

   type state = {
      name : SymbolTable.symid,
      errs : Error.err_stream
   }

   fun getDefault (s : state) cases = case rev cases of
         ((sp,WILDpat,bb) :: cases) => (rev cases, (sp,WILDpat,bb))
       | ((sp,VECpat [],bb) :: cases) => (rev cases, (sp,VECpat [],bb))
       | ((sp,VECpat [""],bb) :: cases) => (rev cases, (sp,VECpat [""],bb))
       | pats =>
         let
            val (sp,spStr) = case pats of
                 (sp,_,_) :: _ => (sp," at " ^ Error.spanToString sp)
               | _ => (SymbolTable.noSpan,"")
         in
           (cases, (sp,WILDpat,BASICblock ([],[
            ASSIGNstmt (NONE,
               PRIexp (RAISEprim,
                  FUNvtype (STRINGvtype,false,[STRINGvtype]),[
                     LITexp (STRINGvtype, STRlit ("pattern match failure in " ^ 
                              SymbolTable.getString(!SymbolTables.varTable, #name s) ^
                              spStr))
            ]))])))
         end

   fun showPats pats = #2 (foldl (fn (p,(sep,str)) => (",",str ^ sep ^ p)) ("","") pats)

   fun showCase (pat,bb) = showPats pat ^ " -> " ^ Layout.tostring (Imp.PP.block bb)
   fun showCases cases = String.concatWith "\n" (map showCase cases)

   fun patIntersect (pat1,pat2) =
      let
         val noOfBits = Int.min(String.size pat1, String.size pat2)
         fun checkBit idx = idx<0 orelse (
            String.sub (pat1,idx)= #"." orelse  String.sub (pat2,idx)= #"." orelse
            String.sub (pat1,idx)= #"0" andalso String.sub (pat2,idx)= #"0" orelse
            String.sub (pat1,idx)= #"1" andalso String.sub (pat2,idx)= #"1")
            andalso checkBit (idx-1)
      in
         checkBit (noOfBits-1)
      end

   fun patsIntersect (pats1, pats2) =
      List.exists (fn p1 =>
         List.exists (fn p2 => patIntersect (p1,p2)) pats2
      ) pats1

   fun patIntersection (pat1, pat2) =
      let
         exception EmptyIntersection
         fun genBits ([],[]) = []
           | genBits (#"." :: xs, #"." :: ys) = #"." :: genBits (xs,ys)
           | genBits (#"0" :: xs, #"0" :: ys) = #"0" :: genBits (xs,ys)
           | genBits (#"1" :: xs, #"1" :: ys) = #"1" :: genBits (xs,ys)
           | genBits (#"." :: xs, c :: ys) = c :: genBits (xs,ys)
           | genBits (c :: xs, #"." :: ys) = c :: genBits (xs,ys)
           | genBits (_,_) = raise EmptyIntersection
      in
         SOME (String.implode (genBits (String.explode pat1,String.explode pat2)))
            handle
               EmptyIntersection => NONE
      end

   fun patsIntersection (pats1, pats2) =
      (List.concat 
         (List.map (fn pat1 =>
            (List.mapPartial (fn pat2 => patIntersection (pat1,pat2)) pats2)
         ) pats1)
      )

   fun patSubtract (pat1,pat2) =
      let
         (* 0000 - 0000 = {}
            0000 - 0001 = {0000}
            00.0 - 0000 = {0010}
            .0.0 - 0000 = {1000, 0010}
            00.0 - 0001 = {00.0}
            0000 - 000. = {}
            .0.0 - 00.0 = {10.0}
            strategy:
            a) check if any 0 or 1 in pat1 has a 1 or 0 in the same position
               in pat2, if so, return pat1
            b) compute a set of patterns that form the difference, starting
               with {pat1}; for any positions in pat1 where pat1 has . and pat2
               has 0 or 1 duplicate the elements and set the position of these
               elements to 0 and 1; upon completion, all positions that were
               . in pat1 have been filled in with 0 or 1 and we can simply
               subtract pat2 by removing the string of pat2 from the set;
               this also covers the case where pat1 has no .
            
         *)
         
         val noOfBits = Int.min(String.size pat1, String.size pat2)
         fun patWith (idx,c) pat =
            (if idx>0 then String.substring (pat,0,idx) else "") ^
            String.str c ^
            (if idx+1<noOfBits then String.extract (pat,idx+1,NONE) else "")
         fun subtract (idx,pat2,acc) =
            if idx>=noOfBits
            then
               List.filter (fn p => String.compare (p,pat2)<>EQUAL) acc (* case c) *)
            else
            if (String.sub (pat1,idx)= #"0" andalso String.sub (pat2,idx)= #"1")
               orelse
               (String.sub (pat1,idx)= #"1" andalso String.sub (pat2,idx)= #"0")
            then
               [pat1]
            else
            if String.sub (pat1,idx)= #"." andalso String.sub (pat2,idx)<> #"."
            then (* replace the wildcard in pat1 by 0 and by 1 *)
               subtract (idx+1,pat2, map (patWith (idx,#"0")) acc @ map (patWith (idx,#"1")) acc)
            else
            if String.sub (pat1,idx)<> #"." andalso String.sub (pat2,idx)= #"."
            then (* replace all . in pat2 where pat1 is more specific so that
                    subtracting the pat2 string at the end will always work *)
               subtract (idx+1,patWith (idx,String.sub (pat1,idx)) pat2, acc)
            else
               subtract (idx+1,pat2, acc)
      in
         subtract (0,pat2,[pat1])
      end

   (* compute a pattern set that describes the models in the first
      set of patterns without those of the second set of patterns *)
   fun patsDifference (pats1, pats2) = map Atom.toString (AtomSet.listItems
      (foldl (fn (p1,res) =>
         foldl (fn (p2,res) =>
            AtomSet.union (res,
               AtomSet.fromList (map Atom.atom (patSubtract (p1,p2))))
         ) res pats2
      ) AtomSet.empty pats1))

   (* compute a distribution of set bits from all the cases*)
   fun genDist dist [] = dist
     | genDist NONE (VECpat [] :: pats) = genDist NONE pats
     | genDist NONE (pats as (VECpat (bp :: _) :: _)) =
         genDist (SOME (Array.array (String.size bp, 0))) pats
    | genDist (SOME dist) (VECpat strs :: pats) =
      let
         fun addDist dist str = (
            foldl (fn (chr,idx) => (
               if chr = #"." then () else Array.update (dist,idx,Array.sub(dist,idx)+1); idx+1))
               0 (String.explode str);
            ())
         val _ = app (addDist dist) strs
      in
         genDist (SOME dist) pats
      end
    | genDist NONE (_ :: pats) = genDist NONE pats
    | genDist (SOME dist) (_ :: pats) = genDist (SOME dist) pats

   (* from a distribution of bits, generate two sets of bit sequences,
      namely those that we should check at this level and those that
      should be deferred to the next level *)
   fun genBits pats = case genDist NONE pats of
      NONE => (0,[],[])
    | SOME dist =>
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
               val newSlack = slack*2+(max-newLast)
            in
               if newSlack>=2*max then
                  Int.min (max,last+1)
                   (* we should not allow any indices with this many bits set *)
               else
                  calcCutOff (newSlack, newLast, max, idx-1)
            end
         (* including other bits might lead to overlapping patterns later, but it seems ok now *)
         val cutOff = if bits<=1 then 0 else Array.sub (sorted, bits-1)
            (*calcCutOff (0, Array.sub (sorted, bits-1), Array.sub (sorted, bits-1), bits-2)*)
         
         (*val bitPats = List.concat (map (fn p => case p of
               VECpat bp => bp
             | _ => []) pats)
         val patStr = foldl (fn (v,str) => str ^ "\n" ^ v) "" bitPats
         val arrStr = #2 (Array.foldl (fn (v,(sep,str)) => (",", str ^ sep ^ Int.toString v)) ("[","") dist) ^ "]"
         val _ = if cutOff = 0 then () else
            TextIO.print ("case patterns:" ^ patStr ^ "\n" ^ arrStr ^ ", cutoff=" ^ Int.toString cutOff ^ "\n")*)
      in
         (bits,
          Array.foldr (fn (x,bs) => (x>=cutOff) :: bs) [] dist,
          Array.foldr (fn (x,bs) => (x>0 andalso x<cutOff) :: bs) [] dist)
      end
    
   fun optCase (s : state) (scrut,(cases,default)) =
      let
         fun genRange (low,idx,(true :: bits)) =
               genRange (if low<0 then idx else low,idx+1,bits)
           | genRange (low,idx,(false :: bits)) =
               if low<0 then genRange (low,idx+1,bits) else
                  (low, idx-1) :: genRange (~1,idx+1,bits)
           | genRange (low,idx,[]) =
               if low<0 then [] else [(low,idx-1)]
         val (bits,goodBits,badBits) = genBits (map #2 cases)
         fun genPattern (bits,VECpat strs) =
            let
               fun projectPat (true::bits) (c::cs) = c::projectPat bits cs
                 | projectPat (false::bits) (c::cs) = projectPat bits cs
                 | projectPat _ _ = []
            in
               map (String.implode o projectPat bits o String.explode) strs
            end
           | genPattern (bits,pat) = []    
         val rangeGood = List.rev (genRange (~1,0,List.rev goodBits))
         val rangeBad = List.rev (genRange (~1,0,List.rev badBits))

         (*val maskGoodStr = foldl (fn (bit,str) => str ^ (if bit then "1" else "0")) "" goodBits
         val maskBadStr = foldl (fn (bit,str) => str ^ (if bit then "1" else "0")) "" badBits
         val rangeGoodStr = #2 (foldl (fn ((low,high),(sep,str)) => (";", str ^ sep ^ "[" ^ Int.toString low ^ "," ^ Int.toString high ^ "]")) ("","") rangeGood)
         val rangeBadStr = #2 (foldl (fn ((low,high),(sep,str)) => (";", str ^ sep ^ "[" ^ Int.toString low ^ "," ^ Int.toString high ^ "]")) ("","") rangeBad)
         val _ = if List.length rangeGood=0 then () else TextIO.print ("good mask: " ^ maskGoodStr ^ "\nbad mask:  " ^ maskBadStr ^ "\ngood range: " ^ rangeGoodStr ^ "\nbad range: " ^ rangeBadStr ^ "\n")*)

         fun slice (low,high,e) =
            let
               val noOfBits = high-low+1
               val sliceType = FUNvtype (VECvtype, false, [INTvtype, INTvtype, INTvtype])
               fun lit x = LITexp (INTvtype, INTlit (IntInf.fromInt x))
            in
               (noOfBits,
                VEC2INTexp (SOME noOfBits,
                  PRIexp (SLICEprim, sliceType, [e, lit low, lit noOfBits])))
            end
         fun conc (size1,e1) (size2,e2) =
            let
               val noOfBits = size1+size2
               val concType = FUNvtype (VECvtype, false, [VECvtype, VECvtype])
            in
               (noOfBits,
                VEC2INTexp (SOME noOfBits,
                  PRIexp (CONCAT_VECprim, concType,
                     [INT2VECexp (size1,e1), INT2VECexp (size2,e2)])))
            end
         fun genSlice [] scrut = (0, LITexp (VECvtype, VEClit ""))
           | genSlice [(low,high)] scrut = slice (low,high,scrut)
           | genSlice ((low,high) :: ranges) scrut =
            conc (slice (low,high,scrut)) (genSlice ranges scrut)

         (* for each case, check if there are other cases further down
            that overlap with the patterns of this case; turn them
            into a group of cases *)
         fun group [] = []
           | group ((pat,rhs) :: cases) =
            let
               fun fetch (pat, rhs, []) = (pat, rhs, [])
                 | fetch (pat, rhs, ((patT,rhsT) :: cases)) =
                  (case patsIntersection (pat,patT) of
                     [] => 
                     let
                        val (pat, rhs, cases) = fetch (pat,rhs,cases)
                     in
                        (pat, rhs, (patT,rhsT) :: cases)
                     end
                   | commonPat =>
                     let
                        val commonRhs = rhs @ rhsT
                        val newPat = patsDifference (pat,commonPat)
                        val newPatT = patsDifference (patT,commonPat)
                        fun getSp rhs = case rhs of
                             [] => SymbolTable.noSpan
                           | ((sp,_,_)::_) => sp
                        val _ = if not (null newPat) then
                           (Error.errorAt (#errs s, getSp rhs, ["pattern '" ^ showPats pat ^
                              "' contains '" ^ showPats commonPat ^
                              "' which is also matched by later pattern '" ^ showPats patT ^
                              "'\n[" ^ Error.spanToString (getSp rhsT) ^ "] Info: later pattern is here\n"])
                           )
                           else ()
                        val _ = if not (null newPatT) then
                        (Error.errorAt (#errs s, getSp rhsT, ["pattern '" ^ showPats patT ^
                              "' contains '" ^ showPats commonPat ^
                              "' which is also matched by earlier pattern '" ^ showPats pat ^
                              "'\n[" ^ Error.spanToString (getSp rhs) ^ "] Info: earlier pattern is here\n"])
                        )
                           else ()
                     in
                        fetch (commonPat, commonRhs, cases)
                     end
                  ) 
               (*val _ = TextIO.print ("inspecting pattern " ^ showPats pat ^ ":\n")*)
               val (newPat, newRhs, newCases) = fetch (pat,rhs,cases)
            in
               (newPat, newRhs) :: group newCases
            end

         fun splitCase (sp,p,bb) =
            (genPattern (goodBits,p), [(sp, genPattern (badBits,p),bb)])
         fun remDup [] = []
           | remDup (p :: pats) =
            let
               val pats = remDup pats
            in
               if List.exists (fn p' => String.compare (p,p')=EQUAL) pats then
                  pats
               else
                  p :: pats
            end
         fun genCases ((scrutBadSize,scrutBad), splitCases) =
            map (fn (pat,subCases) => (SymbolTable.noSpan,VECpat (remDup pat),BASICblock ([],[
               optCase s (scrutBad,
                  (map (fn (sp,pat,bb) => (sp,VECpat (remDup pat),bb)) subCases,
                   default))
            ]))) splitCases
         (* add the default case unless the set of cases is trivial *)
         fun addDefault (cases as [(sp,WILDpat,bb)]) = cases
           | addDefault (cases as [(sp,VECpat strs,bb)]) =
               if List.all (List.all (fn c => c= #".") o String.explode) strs then 
                  cases
               else
                  cases @ [default]
           | addDefault cases = cases @ [default]

      in
         if bits>0 then
            CASEstmt (#2 (genSlice rangeGood scrut),
                     addDefault (
                        genCases (genSlice rangeBad scrut, 
                           group (map splitCase cases))))
         else
            CASEstmt (scrut, addDefault cases)
      end

   fun visitBlock s (BASICblock (decls,stmts)) = BASICblock (decls, map (visitStmt s) stmts)
   
   and visitStmt s (ASSIGNstmt (res,exp)) = ASSIGNstmt (res, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, visitBlock s t, visitBlock s e)
     | visitStmt s (CASEstmt (e,ps)) = optCase s (visitExp s e, getDefault s (map (visitCase s) ps))

   and visitCase s (sp,p,bb) = (sp,p, visitBlock s bb)
   
   and visitExp s (PRIexp (f,t,es)) = (PRIexp (f,t,map (visitExp s) es))
     | visitExp s (CALLexp (e,es)) = (CALLexp (visitExp s e, map (visitExp s) es))
     | visitExp s (INVOKEexp (t,e,es)) = (INVOKEexp (t,visitExp s e, map (visitExp s) es))
     | visitExp s (RECORDexp (rs,t,fs)) = RECORDexp (rs,t,map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (SELECTexp (rs,t,f,e)) = SELECTexp (rs,t,f,visitExp s e)
     | visitExp s (UPDATEexp (rs,t,fs,e)) = UPDATEexp (rs,t,map (fn (f,e) => (f,visitExp s e)) fs,visitExp s e)
     | visitExp s (BOXexp (t,e)) = BOXexp (t, visitExp s e)
     | visitExp s (UNBOXexp (t,e)) = UNBOXexp (t, visitExp s e)
     | visitExp s (VEC2INTexp (sz,e)) = VEC2INTexp (sz, visitExp s e)
     | visitExp s (INT2VECexp (sz,e)) = INT2VECexp (sz, visitExp s e)
     | visitExp s (CLOSUREexp (t,sym,es)) = CLOSUREexp (t,sym,map (visitExp s) es)
     | visitExp s (STATEexp (b,t,e)) = STATEexp (visitBlock s b, t, visitExp s e)
     | visitExp s (EXECexp (t, e)) = (EXECexp (t, visitExp s e))
     | visitExp s e = e

   fun visitDecl s (FUNCdecl {
        funcIsConst = isConst,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = body,
        funcRes = res
      }) = FUNCdecl {
        funcIsConst = isConst,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = visitBlock ({ name = name, errs = s} : state) body,
        funcRes = res
      }
     | visitDecl s d = d

   fun run { decls = ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs } =
      let
         val ds = map (visitDecl errs) ds
      in
         { decls = ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs }
      end
   
end


structure DeadFunctions = struct
   val name = "dead-functions"

   open Imp
   
   type state = { locals : SymSet.set,
                  replace : SymbolTable.symid SymMap.map ref,
                  referenced : SymSet.set ref,
                  refdTags : SymSet.set ref }

   fun refSym (s : state) sym = 
      if not (SymSet.member (#locals s,sym)) then
         (#referenced s) := SymSet.add (!(#referenced s),sym)
      else
         ()

   fun withLocals (s : state, decls : arg list) =
      { locals = SymSet.addList (#locals s, map #2 decls),
        replace = #replace s,
        referenced = #referenced s,
        refdTags = #refdTags s
      }

   fun applyReplace (s : state,sym) = case SymMap.find (!(#replace s),sym) of
      NONE => sym
    | SOME sym => sym

   fun addReplacement (s : state,symTo,symFrom) =
      if SymSet.member (#locals s,symFrom) andalso
         String.isSuffix "Res" (Atom.toString (SymbolTable.getAtom(!SymbolTables.varTable, symFrom))) then
         (#replace s) := SymMap.insert (!(#replace s), symFrom, applyReplace (s,symTo))
      else
         ()
   
   fun visitBlock s (BASICblock (decls,stmts)) =
      let
         val s = withLocals (s,decls)
         val stmts = List.rev (map (visitStmt s) (List.rev stmts))
         fun notReplacedDecl (t,sym) = not (SymMap.inDomain (!(#replace s),sym))
         fun notVoid (VOIDvtype,_) = false
           | notVoid (_,_) = true
         fun notIdentityAssign (ASSIGNstmt (SOME symTo, IDexp symFrom)) =
               not (SymbolTable.eq_symid (symTo,symFrom))
           | notIdentityAssign _ = true
         fun notVoidAssign (ASSIGNstmt (NONE, IDexp _)) = false
           | notVoidAssign _ = true
         val stmts = List.filter notIdentityAssign stmts
         val stmts = List.filter notVoidAssign stmts
         val decls = List.filter notReplacedDecl decls
         val decls = List.filter notVoid decls
      in
         BASICblock (decls, stmts)
      end
   
   and visitStmt s (ASSIGNstmt (SOME symTo,exp)) = 
      (case exp of
         IDexp symFrom => addReplacement (s,symTo,symFrom)
       | _ => ();
       ASSIGNstmt (SOME (applyReplace (s,symTo)), visitExp s exp)
      )
     | visitStmt s (ASSIGNstmt (res,exp)) = ASSIGNstmt (res, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, visitBlock s t, visitBlock s e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, foldr (visitCase s) [] ps)

   and visitCase s ((sp,CONpat sym,stmts),cs) = 
         if SymSet.member (!(#refdTags s),sym) then
            (sp,CONpat sym, visitBlock s stmts) :: cs else cs
     | visitCase s ((sp,p,stmts),cs) = (sp,p, visitBlock s stmts) :: cs
   
   and visitExp s (IDexp sym) = (refSym s sym; IDexp (applyReplace (s,sym)))
     | visitExp s (PRIexp (f,t,es)) = PRIexp (f,t,map (visitExp s) es)
     | visitExp s (CALLexp (e,es)) = CALLexp (visitExp s e, map (visitExp s) es)
     | visitExp s (INVOKEexp (t,e,es)) = INVOKEexp (t,visitExp s e, map (visitExp s) es)
     | visitExp s (RECORDexp (rs,t,fs)) = RECORDexp (rs,t,map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (SELECTexp (rs,t,f,e)) = SELECTexp (rs,t,f,visitExp s e)
     | visitExp s (UPDATEexp (rs,t,fs,e)) = UPDATEexp (rs,t,map (fn (f,e) => (f,visitExp s e)) fs,visitExp s e)
     | visitExp s (LITexp (t,CONlit tag)) = (#refdTags s := SymSet.add (!(#refdTags s),tag); LITexp (t,CONlit tag))
     | visitExp s (LITexp l) = LITexp l
     | visitExp s (BOXexp (t,e)) = BOXexp (t, visitExp s e)
     | visitExp s (UNBOXexp (t,e)) = UNBOXexp (t, visitExp s e)
     | visitExp s (VEC2INTexp (sz,e)) = VEC2INTexp (sz, visitExp s e)
     | visitExp s (INT2VECexp (sz,e)) = INT2VECexp (sz, visitExp s e)
     | visitExp s (CLOSUREexp (t,sym,es)) = (refSym s sym; CLOSUREexp (t,(applyReplace (s,sym)),map (visitExp s) es))
     | visitExp s (STATEexp (b,t,e)) = STATEexp (visitBlock s b, t, visitExp s e)
     | visitExp s (EXECexp (t, e)) = EXECexp (t, visitExp s e)

   fun visitDecl s (FUNCdecl {
        funcIsConst = isConst,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = body,
        funcRes = res
      }) = (FUNCdecl {
        funcIsConst = isConst,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = visitBlock s body,
        funcRes = res
      })
     | visitDecl s (d as CONdecl {
        conName = name,
        conTag = tag,
        ...
     }) = (if SymSet.member (!(#referenced s),name) then
         #refdTags s := SymSet.add (!(#refdTags s),tag) else ()
         ;d)
     | visitDecl s d = d

   fun visitCDecl s (CLOSUREdecl {
         closureName = name,
         closureArgs = tsCl,
         closureDelegate = del,
         closureDelArgs = delArgs,
         closureRetTy = retTy
     }) = if SymSet.member(!(#referenced s), name) then refSym (s : state) del else ()
     | visitCDecl s _ = ()

   fun run { decls = ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs } =
      let
         val s = { locals = SymSet.empty,
                   replace = ref SymMap.empty,
                   referenced = ref SymSet.empty,
                   refdTags = ref SymSet.empty } : state
         val _ = SymMap.appi (refSym s o #1) es
         fun fixpoint _ =
            let
               val reachable = List.filter (fn d => SymSet.member (!(#referenced s),getDeclName d)) ds
               val oldSize = SymSet.numItems (!(#referenced s)) + SymSet.numItems (!(#refdTags s))
               val reachable = map (visitDecl s) reachable
               val _ = app (visitCDecl s) reachable
               val newSize = SymSet.numItems (!(#referenced s)) + SymSet.numItems (!(#refdTags s))
            in
               if newSize>oldSize then fixpoint () else reachable
            end
         val ds = fixpoint ()
      in
         { decls = ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs }
      end
   
end

structure DeadVariables = struct
   val name = "dead-variables"

   open Imp

   type stateExp = {
      vars : SymSet.set,
      side : bool
   }
   
   val pureSet = ref SymSet.empty

   fun initialState live = { vars = live, side = false } : stateExp
   fun addSide (s : stateExp,value) = { vars = #vars s, side = #side s orelse value } : stateExp
   fun addVar (s : stateExp,var) = { vars = SymSet.add (#vars s, var), side = #side s } : stateExp

   fun visit f s [] = (s,[])
     | visit f s (x :: xs) =
      let
        val (s,xs) = visit f s xs
        val (s,x) = f s x
      in
         (s,x :: xs)
      end

   fun visitBlock s (BASICblock (decls,stmts)) =
      let
         val (s, stmts) = visit visitStmt s stmts
         val decls = List.filter (fn (_,sym) => SymSet.member (s, sym)) decls
         val s = foldl (fn ((_,sym),s) => SymSet.delete (s,sym)) s decls
      in
         (s, BASICblock (decls, stmts))
      end
   
   and visitStmt s (ASSIGNstmt (lhs,exp)) =
      let
         val ({vars, side},exp) = visitExp (initialState s) exp
      in
         if Option.isSome lhs andalso SymSet.member (s, Option.valOf lhs) then
            (SymSet.union (s,vars), ASSIGNstmt (lhs,exp))
         else if side then
            (SymSet.union (s,vars), ASSIGNstmt (NONE,exp))
         else
            (s, ASSIGNstmt (NONE,PRIexp (VOIDprim,VOIDvtype,[])))
      end
     | visitStmt s (IFstmt (c,t,e)) =
      let
         val ({vars, side},c) = visitExp (initialState s) c
         val (sT,t) = visitBlock s t
         val (sE,e) = visitBlock s e
         val s = SymSet.union(sT,sE)
      in
         (SymSet.union (s,vars), IFstmt (c,t,e))
      end
     | visitStmt s (CASEstmt (e,ps)) =
      let
         val ({vars, side},e) = visitExp (initialState s) e
         val (s,ps) = visit visitCase s ps
      in
         (SymSet.union (s,vars), CASEstmt (e,ps))
      end

   and visitCase s (sp,p,b) =
      let
         val (s,b) = visitBlock s b
      in
         (s, (sp, p, b))
      end
   
   and visitExp s (IDexp sym) = (addVar (s,sym), IDexp sym)
     | visitExp s (PRIexp (f,t,es)) =
         let val (s,es) = visit visitExp s es in (addSide (s,hasSidePrim f), PRIexp (f,t,es)) end
     | visitExp s (CALLexp (e,es)) =
         let
            val (s,es) = visit visitExp s es
            val (s,e) = visitExp s e
            val hasSideEffect = case e of
                  IDexp sym => not (SymSet.member (!pureSet, sym))
                | _ => true
         in
            (addSide (s,hasSideEffect), CALLexp (e, es))
         end
     | visitExp s (INVOKEexp (t,e,es)) =
         let
            val (s,es) = visit visitExp s es
            val (s,e) = visitExp s e
         in
            (addSide (s,true), INVOKEexp (t,e,es))
         end
     | visitExp s (RECORDexp (rs,t,fs)) =
         let
            fun visitField s (f,e) =
               let val (s,e) = visitExp s e in (s,(f,e)) end
            val (s,fs) = visit visitField s fs
         in
            (s, RECORDexp (rs,t,fs))
         end
     | visitExp s (SELECTexp (rs,t,f,e)) = let val (s,e) = visitExp s e in (s,SELECTexp (rs,t,f,e)) end
     | visitExp s (UPDATEexp (rs,t,fs,e)) =
         let
            val (s,e) = visitExp s e
            fun visitField s (f,e) =
               let val (s,e) = visitExp s e in (s,(f,e)) end
            val (s,fs) = visit visitField s fs
         in
            (s, UPDATEexp (rs,t,fs,e))
         end
     | visitExp s (BOXexp (t,e)) = let val (s,e) = visitExp s e in (s,BOXexp (t,e)) end
     | visitExp s (UNBOXexp (t,e)) = let val (s,e) = visitExp s e in (s,UNBOXexp (t,e)) end
     | visitExp s (VEC2INTexp (sz,e)) = let val (s,e) = visitExp s e in (s,VEC2INTexp (sz,e)) end
     | visitExp s (INT2VECexp (sz,e)) = let val (s,e) = visitExp s e in (s,INT2VECexp (sz,e)) end
     | visitExp s (CLOSUREexp (t,sym,es)) =
      let
         val (s,es) = visit visitExp s es
      in
         (addVar (s,sym), CLOSUREexp (t,sym,es))
      end
     | visitExp s (STATEexp (b,t,e)) =
      let
         val ({vars = vars, side = _},e) = visitExp s e
         val (vars,b) = visitBlock vars b
      in
         ({vars = vars, side = #side s}, STATEexp (b,t,e))
      end
     | visitExp s (EXECexp (t, e)) =
       let val (s,e) = visitExp s e in (addSide (s,true),EXECexp (t, e)) end
     | visitExp s e = (s,e)

   and hasSidePrim SETSTATEprim = true
     | hasSidePrim SEEKprim = true
     | hasSidePrim CONSUME8prim = true
     | hasSidePrim CONSUME16prim = true
     | hasSidePrim CONSUME32prim = true
     | hasSidePrim UNCONSUME8prim = true
     | hasSidePrim UNCONSUME16prim = true
     | hasSidePrim UNCONSUME32prim = true
     | hasSidePrim PRINTLNprim = true
     | hasSidePrim RAISEprim = true
     | hasSidePrim _ = false

   fun visitDecl (FUNCdecl {
        funcIsConst = isConst,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = body,
        funcRes = res
      }) = (FUNCdecl {
        funcIsConst = isConst,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = #2 (visitBlock (SymSet.singleton res) body),
        funcRes = res
      })
     | visitDecl d = d

   fun addPure (CONdecl {
         conName = sym,
         ...
      }) = (pureSet := SymSet.add(!pureSet,sym))
     | addPure _ = ()

   fun run { decls = ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs } =
      let
         val _ = app addPure ds
      in
         { decls = map visitDecl ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs }
      end
   
end

structure UnboxConstructorPayload = struct
   val name = "unbox-constructor-payload"

   open Imp
   structure AST = SpecAbstractTree
   exception ExportTypesBug
   
   type state = { newLocals : arg list ref,
                  prependStmt : stmt list ref,
                  conArgTypes : AST.ty SymMap.map,
                  dsMap : decl SymMap.map,
                  taMap : AST.ty SymMap.map,
                  rename : SymbolTable.symid -> SymbolTable.symid }

   fun declareVar (s : state) arg = (#newLocals s := arg :: !(#newLocals s))
   fun addStmt (s : state) stmt = (#prependStmt s := stmt :: !(#prependStmt s))
   fun assignToLocal s (IDexp sym) = IDexp sym
     | assignToLocal s e =
      let
         val tab = !SymbolTables.varTable
         val (tab, sym) = SymbolTable.fresh (tab, Atom.atom "con_payload")
         val _ = SymbolTables.varTable := tab
         val _ = declareVar s (OBJvtype,sym)
         val _ = addStmt s (ASSIGNstmt (SOME sym,e))
      in
         IDexp sym
      end
   fun forceType s (AST.MARKty {tree=t,span},e) = forceType s (t,e)
     | forceType s (AST.BITty i,e) =
        BOXexp (VECvtype,
           INT2VECexp (IntInf.toInt i,
              VEC2INTexp (SOME (IntInf.toInt i),
                 UNBOXexp (VECvtype,e))))
     | forceType s (AST.INTty,e) =
        BOXexp (INTvtype, UNBOXexp (INTvtype,e))
     | forceType s (AST.RECORDty fsDecl,RECORDexp (rSym,rTy,fsDef)) =
        let
           val fTypes = List.foldl SymMap.insert' SymMap.empty fsDecl
           fun filterFields ((f,e)::fs) = (case SymMap.find (fTypes,f) of
                   NONE => filterFields fs
                 | SOME ty => (f,forceType s (ty,e)) :: filterFields fs
               )
             | filterFields [] = []
        
           val fsDef = filterFields fsDef
           val rTy = case rTy of
              RECORDvtype (b,fs) =>
                 RECORDvtype (b,List.filter (fn (f,_) => SymMap.inDomain (fTypes,f)) fs)
            | _ => rTy
        in
           RECORDexp (rSym,rTy,fsDef)
        end
     | forceType s (AST.RECORDty fsDecl,e) =
        let
           val e = assignToLocal s e
           fun genFields (fid,ty) = 
              let
                 val tab = !SymbolTables.varTable
                 val (tab, symDummy) = SymbolTable.fresh (tab, Atom.atom "recSym")
                 val _ = SymbolTables.varTable := tab
              in
                 (fid,forceType s (ty,SELECTexp (symDummy,OBJvtype,fid,e)))
              end
           val fs = map genFields fsDecl
           
           val tab = !SymbolTables.varTable
           val (tab, rSym) = SymbolTable.fresh (tab, Atom.atom "recSym")
           val _ = SymbolTables.varTable := tab
        in
           RECORDexp (rSym,OBJvtype,sortFields fs)
        end
     | forceType s (AST.NAMEDty (tName,args),e) =
        (case SymMap.find (#taMap s,tName) of
                SOME ty => forceType s (ty,e)
              | NONE => e
        )
     | forceType s (ty,e) = e

   fun visitBlock (s : state) (BASICblock (decls,stmts)) =
      let
         fun processStmt (s, []) = []
           | processStmt (s, stmt :: stmts) =
            let
               val stmt = visitStmt s stmt
               val newStmts = List.rev (!(#prependStmt s))
               val _ = #prependStmt s := []
            in
               newStmts @ stmt :: processStmt (s, stmts)
            end
         val sLocal = {
            newLocals = ref [],
            prependStmt = ref [],
            conArgTypes = #conArgTypes s,
            dsMap = #dsMap s,
            taMap = #taMap s,
            rename = #rename s
         }
         val stmts = processStmt (sLocal, stmts)
         val decls = decls @ (!(#newLocals sLocal))
      in
         BASICblock (decls, stmts)
      end
   
   and visitStmt s (ASSIGNstmt (res,exp)) = ASSIGNstmt (res, visitExp s exp)
     | visitStmt s (IFstmt (c,t,e)) = IFstmt (visitExp s c, visitBlock s t, visitBlock s e)
     | visitStmt s (CASEstmt (e,ps)) = CASEstmt (visitExp s e, map (visitCase s) ps)

   and visitCase s (sp,p,stmts) = (sp, p, visitBlock s stmts)
   
   and visitExp s (IDexp sym) = (IDexp (#rename s sym))
     | visitExp s (PRIexp (f,t,es)) = PRIexp (f,t,map (visitExp s) es)
     | visitExp s (CALLexp (IDexp sym,[e])) =
        (case SymMap.find (#conArgTypes s, sym) of
           NONE => CALLexp (IDexp (#rename s sym), [visitExp s e])
         | SOME ty => CALLexp (IDexp (#rename s sym), [forceType s (ty,visitExp s e)])
        )
     | visitExp s (CALLexp (e,es)) = CALLexp (visitExp s e, map (visitExp s) es)
     | visitExp s (INVOKEexp (t,e,es)) = INVOKEexp (t,visitExp s e, map (visitExp s) es)
     | visitExp s (RECORDexp (rs,t,fs)) = RECORDexp (rs,t,map (fn (f,e) => (f,visitExp s e)) fs)
     | visitExp s (SELECTexp (rs,t,f,e)) = SELECTexp (rs,t,f,visitExp s e)
     | visitExp s (UPDATEexp (rs,t,fs,e)) = UPDATEexp (rs,t,map (fn (f,e) => (f,visitExp s e)) fs,visitExp s e)
     | visitExp s (LITexp l) = LITexp l
     | visitExp s (BOXexp (t,e)) = BOXexp (t, visitExp s e)
     | visitExp s (UNBOXexp (t,e)) = UNBOXexp (t, visitExp s e)
     | visitExp s (VEC2INTexp (sz,e)) = VEC2INTexp (sz, visitExp s e)
     | visitExp s (INT2VECexp (sz,e)) = INT2VECexp (sz, visitExp s e)
     | visitExp s (CLOSUREexp (t,sym,es)) = CLOSUREexp (t,(#rename s sym),map (visitExp s) es)
     | visitExp s (STATEexp (b,t,e)) = STATEexp (visitBlock s b, t, visitExp s e)
     | visitExp s (EXECexp (t, e)) = EXECexp (t, visitExp s e)

   fun visitDecl s (FUNCdecl {
        funcIsConst = isConst,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = body,
        funcRes = res
      }) = (FUNCdecl {
        funcIsConst = isConst,
        funcClosure = map (fn (t,sym) => (t,#rename s sym)) clArgs,
        funcType = vtype,
        funcName = #rename s name,
        funcArgs = map (fn (t,sym) => (t,#rename s sym)) args,
        funcBody = visitBlock s body,
        funcRes = res
      })
     | visitDecl s (CONdecl {
         conName = name,
         conTag = tag,
         conArg = (argTy, argName),
         conType = vtype
     }) = CONdecl {
         conName = #rename s name,
         conTag = tag,
         conArg = (argTy, argName),
         conType = vtype
     }
     | visitDecl s (CLOSUREdecl {
         closureName = name,
         closureArgs = tsCl,
         closureDelegate = del,
         closureDelArgs = delArgs,
         closureRetTy = retTy
     }) = CLOSUREdecl {
         closureName = #rename s name,
         closureArgs = tsCl,
         closureDelegate = #rename s del,
         closureDelArgs = map (fn (t,sym) => (t,#rename s sym)) delArgs,
         closureRetTy = retTy
     }

   fun visitCDecl s (CONdecl {
      conName = name,
      conTag = tag,
      ...
      },sm) = SymMap.insert (sm,name,SymMap.lookup (s,tag))
     | visitCDecl s (d,sm) = sm

   fun cloneName sym =
      let
         val tab = !SymbolTables.varTable
         val symAtm = SymbolTable.getAtom (tab,sym)
         val (tab, newSym) = SymbolTable.fresh (tab, symAtm)
         val _ = SymbolTables.varTable := tab
      in
         newSym
      end

   fun genWrap s (name,(tVars,ty)) = case SymMap.find (#dsMap s,name) of
        SOME (FUNCdecl {
        funcIsConst = isConst,
        funcClosure = clArgs,
        funcType = vtype,
        funcName = name,
        funcArgs = args,
        funcBody = body,
        funcRes = res
      }) =>
      let
         val eName = #rename s name
         val eArgs = map (fn (ty,sym) => (ty, cloneName sym)) args
         val eRes = cloneName res

         fun stripType (AST.MARKty {tree=t,span}) = stripType t
           | stripType (AST.MONADty (resTy,_,_)) = stripType resTy
           | stripType (AST.FUNCTIONty (argsTy,resTy)) = AST.FUNCTIONty (map stripType argsTy,stripType resTy)
           | stripType resTy = resTy
         fun getType (AST.MONADty (resTy,_,_)) = ([],resTy)
           | getType (AST.FUNCTIONty (argsTy,resTy)) = (argsTy,resTy)
           | getType resTy = ([],resTy)
         val (argsTy,resTy) = getType (stripType ty)
         
         fun genArg ((ty,argSym),declTy) = forceType s (declTy,IDexp argSym)
         val argExprs = List.map genArg (ListPair.zipEq (eArgs,argsTy))
                           handle _ => raise ExportTypesBug
         val e = forceType s (resTy,CALLexp (IDexp eName,argExprs))                           
         val stmt = ASSIGNstmt (SOME eRes, e)
         val varDecls = !(#newLocals s)
         val _ = #newLocals s := []
         val stmts = !(#prependStmt s) @ [stmt]
         val _ = #prependStmt s := []
         
      in
         FUNCdecl {
           funcIsConst = isConst,
           funcClosure = clArgs,
           funcType = vtype,
           funcName = name,
           funcArgs = eArgs,
           funcBody = BASICblock (varDecls,stmts),
           funcRes = eRes
         }
      end
      | _ => raise ExportTypesBug
      
   fun run { decls = ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs } =
      let
         fun addConstr ((conTag, SOME ty), sm) = SymMap.insert (sm,conTag,ty)
           | addConstr ((conTag, NONE), sm) = sm
         fun addDatatype (conList,sm) = List.foldl addConstr sm conList
         val conTagToType = SymMap.foldl addDatatype SymMap.empty dt
         val conToType = foldl (visitCDecl conTagToType) SymMap.empty ds
         val dsMap = foldl (fn (d,sm) => SymMap.insert (sm,getDeclName d,d)) SymMap.empty ds
         val renameMap = SymMap.mapi (fn (eSym,_) => cloneName eSym) es
         fun renameFun sym = case SymMap.find (renameMap,sym) of
              NONE => sym
            | SOME sym => sym
         val s = {
            newLocals = ref [],
            prependStmt = ref [],
            conArgTypes = conToType,
            dsMap = dsMap,
            taMap = ta,
            rename = renameFun
         } : state

         val ds = map (visitDecl s) ds
         
         (* generate wrappers for all exported functions *)
         val exportWrappers = map (genWrap s) (SymMap.listItemsi es)
      in
         { decls = exportWrappers @ ds, fdecls = fs, exports = es, typealias = ta, datatypes = dt, monad = mt, errs = errs }
      end
   
end
