
structure ImpFromCore : sig
   val run:
      Core.Spec.t ->
         Imp.Spec.t CompilationMonad.t

end = struct

   structure CM = CompilationMonad

   exception ImpTranslationBug

   open Core
   open Imp
   
   val constructors: (Spec.sym * Spec.ty option) SymMap.map ref = ref SymMap.empty

   fun freeVars (Exp.LETVAL (s,b,e)) =
      SymSet.union (freeVars b,
         SymSet.difference (freeVars e, SymSet.singleton s))
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
            SymSet.difference (freeVars e, SymSet.fromList [a,c])
           | freeInCase (Pat.CON (c, NONE), e) =
            SymSet.difference (freeVars e, SymSet.singleton c)
           | freeInCase (Pat.ID s, e) =
            SymSet.difference (freeVars e, SymSet.singleton s)
           | freeInCase (_, e) = freeVars e
      in
         foldl (fn (c, ss) => SymSet.union (freeInCase c, ss)) (freeVars e) cases
      end
     | freeVars (Exp.APP (e,args)) =
      foldl (fn (arg,ss) => SymSet.union (freeVars arg, ss)) (freeVars e) args
     | freeVars (Exp.PRI (_,args)) = SymSet.addList (SymSet.empty, args)
     | freeVars (Exp.FN (s,e)) =
      SymSet.difference (freeVars e, SymSet.singleton s)
     | freeVars (Exp.SEQ seq) =
      let
         fun gather (Exp.ACTION t :: rem) =
               SymSet.union (freeVars t, gather rem)
           | gather (Exp.BIND (s,t) :: rem) =
               SymSet.union (freeVars t,
                  SymSet.difference (gather rem, SymSet.singleton s))
           | gather [] = SymSet.empty
      in
         gather seq
      end
     | freeVars (Exp.ID s) = SymSet.singleton s
     | freeVars _ = SymSet.empty


   fun addLocalVar { functionSyms = funcs, localVars = lv, declVars = ds, constants = cs } sym =
      let
         val _ = ds := SymSet.add (!ds, sym)
      in
         { functionSyms = funcs, localVars = SymSet.add (lv,sym), declVars = ds, constants = cs }
      end
   fun genTmpVar { functionSyms = funcs, localVars = lv, declVars = ds, constants = cs } =
      let
         val tab = !SymbolTables.varTable
         val (tab, sym) = SymbolTable.fresh (tab, Atom.atom "tmp")
         val _ = SymbolTables.varTable := tab
         val _ = ds := SymSet.add (!ds, sym)
       in
         sym
      end
   fun withNewDeclVars { functionSyms = funcs, localVars = lv, declVars = ds, constants = cs } f =
      let
         val localDs = ref SymSet.empty
         val res = f { functionSyms = funcs, localVars = lv, declVars = localDs, constants = cs }
      in
         (res, !localDs)
      end
   fun addGlobal { functionSyms = funcs, localVars = lv, declVars = ds, constants = cs } sym =
         funcs := SymSet.add (!funcs,sym)
   fun isGlobal { functionSyms = funcs, localVars = lv, declVars = ds, constants = cs } sym =
         SymSet.member (!funcs,sym)

   (* functions operating on the mutable variables *)
   fun addDecl { functionSyms = funcs, localVars = lv, declVars = ds, constants = cs } decl =
      let
         val { functions = fs, fields, prim_map } = cs
      in
         fs := decl :: !fs
      end
   fun addField { functionSyms = funcs, localVars = lv, declVars = ds, constants = cs } sym =
      let
         val { functions, fields = fs, prim_map } = cs
      in
         fs := SymMap.insert (!fs,sym,OBJvtype)
      end
   fun addUpdate s (fields, fType) =
      let
         val ftab = !SymbolTables.fieldTable
         val name = Atom.atom (foldl
                     (fn (sym, str) =>
                        str ^ "_" ^ SymbolTable.getInternalString (ftab,sym))
                     "update" fields)
         val tab = !SymbolTables.varTable
      in
         case SymbolTable.find (tab, name) of
            NONE =>
               let
                  val (tab, sym) = SymbolTable.fresh (tab, name)
                  val _ = addDecl s 
                           (UPDATEdecl { updateName = sym, 
                                         updateFields = fields,
                                         updateType = fType })
                  val _ = app (addField s) fields
                  val _ = addGlobal s sym
                  val _ = SymbolTables.varTable := tab
               in
                  sym
               end
          | SOME sym => sym
      end
   fun addSelect s (field, fType) =
      let
         val ftab = !SymbolTables.fieldTable
         val name = Atom.atom ("select_" ^ 
                               SymbolTable.getInternalString (ftab,field))
         val tab = !SymbolTables.varTable
      in
         case SymbolTable.find (tab, name) of
            NONE =>
               let
                  val (tab, sym) = SymbolTable.fresh (tab, name)
                  val _ = SymbolTables.varTable := tab                        
                  val _ = addDecl s 
                           (SELECTdecl { selectName = sym,
                                         selectField = field,
                                         selectType = fType })
                  val _ = addField s field
                  val _ = addGlobal s sym
               in
                  sym
               end
          | SOME sym => sym
      end
   fun addConFun s (con, fType) =
      let
         val ctab = !SymbolTables.conTable
         val conName = SymbolTable.getInternalString (ctab,con)
         val name = Atom.atom ("constructor_" ^ conName)
         val tab = !SymbolTables.varTable
      in
         case SymbolTable.find (tab, name) of
            NONE =>
               let
                  val arg = Atom.atom ("arg_of_" ^ conName) 
                  val (tab, sym) = SymbolTable.fresh (tab, name)
                  val (tab, sym') = SymbolTable.fresh (tab, arg)
                  val _ = SymbolTables.varTable := tab                        
                  val _ = addDecl s (CONdecl { conName = sym,
                                               conArg = sym',
                                               conType = fType })
                  val _ = addGlobal s sym
               in
                  sym
               end
          | SOME sym => sym
      end
   
   fun get_con_idx e = PRIexp (PUREmonkind, GET_CON_IDXprim,
      FUNvtype (INTvtype, false, [OBJvtype]), [e])
   fun get_con_arg e = PRIexp (PUREmonkind, GET_CON_ARGprim,
      FUNvtype (OBJvtype, false, [OBJvtype]), [e])
      
   fun trExpr s (Exp.LETVAL (x,b,e)) =
      let
         val (bStmts, bExp) = trExpr (addLocalVar s x) b
         val (eStmts, eExp) = trExpr s e
      in
         (bStmts @ ASSIGNstmt (SOME x,bExp) :: eStmts, eExp)
      end
     | trExpr s (Exp.LETREC (ds, e)) =
      let
         val _ = app (fn (f,_,_) => addGlobal s f) ds
         val ((eStmts, eExp), localDecls) =
            withNewDeclVars s (fn s => trExpr s e)
         val _ = List.map (trDecl s) ds
      in
         (eStmts, eExp)
      end
     | trExpr s (Exp.IF (c,t,e)) =
      let
         val res = genTmpVar s
         val (cStmts, cExp) = trExpr s c
         val (tStmts, tExp) = trExpr s t
         val tStmts = tStmts @ [ASSIGNstmt (SOME res, tExp)]
         val (eStmts, eExp) = trExpr s e
         val eStmts = eStmts @ [ASSIGNstmt (SOME res, eExp)]
      in
         (cStmts @ [IFstmt (VEC2INTexp (SOME 1,UNBOXexp (BITvtype,cExp)), tStmts, eStmts)], IDexp res)
      end
     | trExpr s (Exp.CASE (e, cs)) =
      let
         (* extract the scrutinee as an int which requires different
            primitives, depending on the type that is matched *)
         fun convertScrut (e, (Core.Pat.BIT p,_) :: _) = VEC2INTexp (SOME (String.size p),UNBOXexp (BITvtype,e))
           | convertScrut (e, (Core.Pat.INT _,_) :: _) = UNBOXexp (INTvtype,e)
           | convertScrut (e, (Core.Pat.CON (sym,_),_) :: _) = get_con_idx e
           | convertScrut (e, _ :: cs) = convertScrut (e, cs)
           | convertScrut _ = raise ImpTranslationBug
         val (stmts, scrutRaw) = trExpr s e
         val scrut = convertScrut (scrutRaw, cs)
         
         val res = genTmpVar s
         fun trCase (Core.Pat.BIT bStr,(stmts, exp)) =
               (VECpat bStr, stmts @ [ASSIGNstmt (SOME res,exp)])
           | trCase (Core.Pat.INT i,(stmts, exp)) =
               (INTpat i, stmts @ [ASSIGNstmt (SOME res,exp)])
           | trCase (Core.Pat.CON (sym,NONE),(stmts, exp)) =
               (CONpat sym, stmts @ [ASSIGNstmt (SOME res,exp)])
           | trCase (Core.Pat.CON (sym,SOME arg),(stmts, exp)) =
               (CONpat sym, ASSIGNstmt (SOME sym,get_con_arg scrutRaw) :: stmts @ [ASSIGNstmt (SOME res,exp)])
           | trCase (Core.Pat.ID sym,(stmts, exp)) =
               (WILDpat, ASSIGNstmt (SOME sym,scrutRaw) :: stmts @ [ASSIGNstmt (SOME res,exp)])
           | trCase (Core.Pat.WILD,(stmts, exp)) =
               (WILDpat, stmts @ [ASSIGNstmt (SOME res,exp)])

         val cases = map (fn (pat,e) => trCase (pat,trExpr s e)) cs
      in
         (stmts @ [CASEstmt (scrut, cases)], IDexp res)
      end
     | trExpr s (Exp.APP (func, args)) =
      let
         val (stmts, funcExp) = trExpr s func
         val (stmtss, argExps) = foldl (fn (arg, (stmtss, args)) =>
            case trExpr s arg of (stmts, argExp) =>
            (stmtss @ stmts, args @ [argExp])) ([],[]) args
         val ty = FUNvtype (OBJvtype,false,map (fn _ => OBJvtype) args)
      in
         (stmtss, INVOKEexp (PUREmonkind, ty, funcExp, argExps))
      end
     | trExpr s (Exp.PRI (name, args)) = (
         (* this case is actually dead as all primitives are function calls,
            they are replaced by proper primitives during optimization *)
         case SymMap.find (#prim_map (#constants s), name) of
            SOME (_, gen) => ([], gen (map IDexp args))
          | NONE => raise ImpTranslationBug)
     | trExpr s (Exp.FN (var, e)) =
      let
         val tab = !SymbolTables.varTable
         val (tab, sym) = SymbolTable.fresh (tab, Atom.atom "lambda")
         val _ = SymbolTables.varTable := tab
         val fType = trDecl (addLocalVar s var) (sym, [var], e)
      in
         ([], CLOSUREexp (fType, sym, [IDexp var]))
      end
     | trExpr s (Exp.RECORD fs) =
      let
         fun trans acc res [] = (acc,res)
           | trans acc res ((f,e) :: es) = (case trExpr s e of
              (stmts, e') => trans (acc @ stmts) (res @ [(f,e')]) es)
         val (stmts, unsortedFields) = trans [] [] fs
         fun fieldCmp ((f1,_),(f2,_)) = SymbolTable.compare_symid (f1,f2)
         val fields = ListMergeSort.uniqueSort fieldCmp unsortedFields
      in
         (stmts, RECORDexp fields)
      end
     | trExpr s (Exp.UPDATE us) =
      let
         (* evaluate expressions in the sequence as they were specified
            by and then generate an update function with sorted arguments *)
         fun trans acc res [] = (acc,res)
           | trans acc res ((f,e) :: es) = (case trExpr s e of
              (stmts, e') => trans (acc @ stmts) (res @ [(f,e')]) es)
         val (stmts, unsortedUpdates) = trans [] [] us
         fun updateCmp ((f1,_),(f2,_)) = SymbolTable.compare_symid (f1,f2)
         val updates = ListMergeSort.uniqueSort updateCmp unsortedUpdates
         val resTy = FUNvtype (OBJvtype, true, [OBJvtype])
         val fType = FUNvtype (resTy, false, map (fn _ => OBJvtype) updates)
         val updateFun = addUpdate s (map (fn (f,_) => f) updates, fType)
      in
         (stmts, CLOSUREexp (resTy, updateFun, map (fn (_,e) => e) updates))
      end
     | trExpr s (Exp.SELECT f) =
      let
         val fType = FUNvtype (OBJvtype, false, [OBJvtype])
         val selectFun = addSelect s (f, fType)
      in
         ([], CLOSUREexp (fType, selectFun, []))
      end
     | trExpr s (Exp.SEQ seq) =
      let
         fun transSeq s acc [Exp.ACTION e] =
               let
                  val (stmts, exp) = trExpr s e
               in
                  (acc @ stmts, exp)
               end
           | transSeq s acc ((Exp.ACTION e) :: seq) =
               let
                  val (stmts, exp) = trExpr s e
                  val stmtss = acc @ stmts @ [ASSIGNstmt (NONE,(EXECexp exp))]
               in
                  transSeq s stmtss seq
               end
           | transSeq s acc ((Exp.BIND (res,e)) :: seq) =
               let
                  val (stmts, exp) = trExpr s e
                  val stmtss = acc @ stmts @ [ASSIGNstmt (SOME res,(EXECexp exp))]
               in
                  transSeq (addLocalVar s res) stmtss seq
               end
           | transSeq s acc _ = raise ImpTranslationBug
      in
         transSeq s [] seq
      end
     | trExpr s (Exp.LIT (SpecAbstractTree.INTlit i)) =
         ([], BOXexp (INTvtype, LITexp (INTvtype, INTlit i)))
     | trExpr s (Exp.LIT (SpecAbstractTree.STRlit str)) =
         ([], LITexp (STRINGvtype,STRlit str))
     | trExpr s (Exp.LIT (SpecAbstractTree.VEClit v)) =
         ([], BOXexp (BITvtype, INT2VECexp (String.size v, LITexp (INTvtype, (VEClit v)))))
     | trExpr s (Exp.LIT (SpecAbstractTree.FLTlit _)) =
         raise ImpTranslationBug
     | trExpr s (Exp.CON sym) =
      (case SymMap.lookup (!constructors, sym) of
         (_, NONE) => ([], BOXexp (INTvtype, LITexp (INTvtype, CONlit sym)))
       | (_, SOME _) =>
         let
            val fType = FUNvtype (OBJvtype,false,[OBJvtype])
         in
            ([], CLOSUREexp (fType, addConFun s (sym, fType), []))
         end
       )
     | trExpr s (Exp.ID sym) =
     ([], if isGlobal s sym then CLOSUREexp (FUNvtype (OBJvtype,false,[]), sym, []) else IDexp sym)

   and trDecl s (sym, args, body) =
      let
         val ((stmts, exp), declVars) =
            withNewDeclVars s (fn s => trExpr s body)
         val availInClosure = SymSet.union (!(#functionSyms s),
               SymSet.addList (SymSet.singleton sym, args))
         val inClosure = SymSet.difference (freeVars body, availInClosure)
         fun setToArgs ss = map (fn s => (OBJvtype, s)) (SymSet.listItems ss)
         val clArgs = setToArgs inClosure
         val stdArgs = map (fn s => (OBJvtype, s)) args
         val fType = FUNvtype (OBJvtype, not (null clArgs), map (fn (t,_) => t) stdArgs)
         val _ =
            addDecl s (FUNCdecl {
              funcMonadic = PUREmonkind,
              funcClosure = clArgs,
              funcType = fType,
              funcName = sym,
              funcArgs = map (fn s => (OBJvtype, s)) args,
              funcLocals = setToArgs declVars,
              funcBody = stmts,
              funcRes = exp
            })
      in
         fType
      end

   fun translate spec =
      Spec.upd
         (fn clauses =>
            let
               val () = constructors := Spec.get#constructors spec
               fun exports clauses =
                  rev (foldl
                     (fn ((f, _, _), acc) => 
                        let
                           val fld =  f
                        in
                           (fld, Exp.ID f)::acc
                        end)
                     [] clauses)
               fun exports spec =
                  let 
                     val es = Spec.get#exports spec
                  in
                     map (fn e => (Exp.ID e)) es
                  end
               val fs = ref ([] : decl list)
               val fields = ref (SymMap.empty : vtype SymMap.map)
               
               val globs = foldl SymSet.add' SymSet.empty
                              (SymMap.listKeys (!Primitives.prim_map))
               val cs = { functions = fs,
                          prim_map = !Primitives.prim_map,
                          fields = fields }
               val initialState = { functionSyms = ref globs,
                                    localVars = SymSet.empty,
                                    declVars = ref SymSet.empty,
                                    constants = cs
                                   }
               val bogusExp = Exp.LIT (SpecAbstractTree.INTlit 42)
               val _ = trExpr initialState (Exp.LETREC (clauses, bogusExp))
            in
               { decls = !(#functions cs),
                 fdecls = !(#fields cs) }
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
