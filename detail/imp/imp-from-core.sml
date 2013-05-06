
structure ImpFromCore : sig
   val run:
      Core.Spec.t ->
         Imp.Spec.t CompilationMonad.t

   val prim_table : (string * (Imp.exp list -> Imp.exp)) list

end = struct

   structure CM = CompilationMonad

   exception ImpTranslationBug

   open Core
   open Imp

   val prim_table =
      let
         fun pr (prim,ty,args) = PRIexp (PUREmonkind, prim, ty, args)
         fun unboxI args = map (fn arg => UNBOXexp (INTvtype, arg)) args
         fun boxI arg = BOXexp (INTvtype, arg)
         fun boxB arg = BOXexp (BITvtype 1, arg)
         fun boxV arg = BOXexp (VOIDvtype, arg)
         fun ftype args res = FUNvtype { result = res, closure = [], args = args }
         val iii = ftype [INTvtype, INTvtype] INTvtype
         val sv =  ftype [STRINGvtype] VOIDvtype
         val ooo = ftype [OBJvtype, OBJvtype] OBJvtype
         val oob = ftype [OBJvtype, OBJvtype] (BITvtype 1)
         val oi = ftype [OBJvtype] INTvtype
         val iib = ftype [INTvtype, INTvtype] (BITvtype 1)
         val oo = ftype [OBJvtype] OBJvtype
         val is =  ftype [INTvtype] STRINGvtype
         val os =  ftype [OBJvtype] STRINGvtype
         val oiio = ftype [OBJvtype, INTvtype, INTvtype] OBJvtype
         val ov =  ftype [OBJvtype] VOIDvtype
         val i = ftype [] INTvtype
         val v = ftype [] VOIDvtype
      in [
         ("raise", fn args => pr (RAISEprim,sv,args)),
         ((Atom.toString Op.andAlso), fn args => pr (ANDprim,ooo,args)),
         ((Atom.toString Op.orElse), fn args => pr (ORprim,ooo,args)),
         ("sx", fn args => pr (SIGNEDprim,oi,args)),
         ("zx", fn args => pr (UNSIGNEDprim,oi,args)),
         ("+", fn args => boxI (pr (ADDprim,iii,unboxI args))),
         ("-", fn args => boxI (pr (SUBprim,iii,unboxI args))),
         ("===", fn args => boxB (pr (EQprim,iib,unboxI args))),
         ("*", fn args => boxI (pr (MULprim,iii,unboxI args))),
         ("<", fn args => boxB (pr (LTprim,iib,unboxI args))),
         (">", fn args => boxB (pr (LTprim,iib,unboxI (rev args)))),
         ("<=", fn args => boxB (pr (LEprim,iib,unboxI args))),
         (">=", fn args => boxB (pr (LEprim,iib,unboxI (rev args)))),
         ("not", fn args => pr (NOT_VECprim,oo,args)),
         ("==", fn args => boxB (pr (EQ_VECprim,oob,args))),
         ("^", fn args => pr (CONCAT_VECprim,ooo,args)),
         ("showint", fn args => pr (INT_TO_STRINGprim,is,unboxI args)),
         ("showbitvec", fn args => pr (BITVEC_TO_STRINGprim,os,args)),
         ("+++", fn args => pr (CONCAT_STRINGprim,ooo,args)),
         ("slice", fn args => (case args of
             [vec,ofs,sz] => pr (SLICEprim,oiio,[vec] @ unboxI [ofs,sz])
           | _ => raise ImpTranslationBug)),
         ("index", fn args => pr (INDEXprim,oi,args)),
         ("ipget", fn args => boxI (PRIexp (INmonkind,IPGETprim,i,args))),
         ("consume8", fn args => boxI (PRIexp (INOUTmonkind,CONSUME8prim,i,args))),
         ("consume16", fn args => boxI (PRIexp (INOUTmonkind,CONSUME16prim,i,args))),
         ("consume32", fn args => boxI (PRIexp (INOUTmonkind,CONSUME32prim,i,args))),
         ("unconsume8", fn args => boxV (PRIexp (INOUTmonkind,UNCONSUME8prim,v,args))),
         ("unconsume16", fn args => boxV (PRIexp (INOUTmonkind,UNCONSUME16prim,v,args))),
         ("unconsume32", fn args => boxV (PRIexp (INOUTmonkind,UNCONSUME32prim,v,args))),
         ("println", fn args => boxV (PRIexp (INmonkind,PRINTLNprim,ov,args)))
         ]
      end
   
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


   fun addLocalVar { globalVars = gv, localVars = lv, declVars = ds, constants = cs } sym =
      let
         val _ = ds := SymSet.add (!ds, sym)
      in
         { globalVars = gv, localVars = SymSet.add (lv,sym), declVars = ds, constants = cs }
      end
   fun genTmpVar { globalVars = gv, localVars = lv, declVars = ds, constants = cs } =
      let
         val tab = !SymbolTables.varTable
         val (tab, sym) = SymbolTable.fresh (tab, Atom.atom "tmp")
         val _ = SymbolTables.varTable := tab
         val _ = ds := SymSet.add (!ds, sym)
       in
         sym
      end
   fun withNewDeclVars { globalVars = gv, localVars = lv, declVars = ds, constants = cs } f =
      let
         val localDs = ref SymSet.empty
         val res = f { globalVars = gv, localVars = lv, declVars = localDs, constants = cs }
      in
         (res, !localDs)
      end
   fun addGlobal { globalVars = gv, localVars = lv, declVars = ds, constants = cs } v =
      { globalVars = SymSet.add (gv,v), localVars = lv, declVars = ds, constants = cs }
   
   (* functions operating on the mutable variables *)
   fun addFunction { globalVars = gv, localVars = lv, declVars = ds, constants = cs } decl =
      let
         val { functions = fs, updates, queries, records, prim_map } = cs
      in
         fs := decl :: !fs
      end
   fun addUpdate s fields =
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
                  val _ = SymbolTables.varTable := tab
               in
                  sym
               end
          | SOME sym => sym
      end
   fun addSelect s field =
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
               in
                  sym
               end
          | SOME sym => sym
      end
   fun addConFun s con =
      let
         val ctab = !SymbolTables.conTable
         val name = Atom.atom ("constructor_" ^ 
                               SymbolTable.getInternalString (ctab,con))
         val tab = !SymbolTables.varTable
      in
         case SymbolTable.find (tab, name) of
            NONE =>
               let
                  val (tab, sym) = SymbolTable.fresh (tab, name)
                  val _ = SymbolTables.varTable := tab                        
               in
                  sym
               end
          | SOME sym => sym
      end
   
   fun trExpr s (Exp.LETVAL (x,b,e)) =
      let
         val (bStmts, bExp) = trExpr (addLocalVar s x) b
         val (eStmts, eExp) = trExpr s e
      in
         (bStmts @ ASSIGNstmt (SOME x,bExp) :: eStmts, eExp)
      end
     | trExpr s (Exp.LETREC (ds, e)) =
      let
         val s = foldl (fn ((f,_,_),s) => addGlobal s f) s ds
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
         (cStmts @ [IFstmt (cExp, tStmts, eStmts)], IDexp res)
      end
     | trExpr s (Exp.CASE (e, cs)) =
      let
         val (stmts, exp) = trExpr s e
         val res = genTmpVar s
         fun trCase (pat,e) =
            let
               val (stmts, exp) = trExpr s e
            in
               (pat, stmts @ [ASSIGNstmt (SOME res,exp)])
            end
         val cases = map trCase cs
      in
         (stmts @ [CASEstmt (exp, cases)], IDexp res)
      end
     | trExpr s (Exp.APP (func, args)) =
      let
         val (stmts, funcExp) = trExpr s func
         val (stmtss, argExps) = foldl (fn (arg, (stmtss, args)) =>
            case trExpr s arg of (stmts, argExp) =>
            (stmtss @ stmts, args @ [argExp])) ([],[]) args
      in
         (stmtss, STATEexp (INVOKEexp (funcExp, argExps)))
      end
     | trExpr s (Exp.PRI (name, args)) =
         (case SymMap.find (#prim_map (#constants s), name) of
            SOME gen => ([], gen (map IDexp args))
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
         val updateFun = addUpdate s (map (fn (f,_) => f) updates)
         val fType = FUNvtype { result = OBJvtype,
                                closure = map (fn _ => OBJvtype) updates,
                                args = [OBJvtype] }
      in
         (stmts, CLOSUREexp (fType, updateFun, map (fn (_,e) => e) updates))
      end
     | trExpr s (Exp.SELECT f) =
      let
         val selectFun = addSelect s f
      in
         ([], (IDexp selectFun))
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
                  transSeq s stmtss seq
               end
           | transSeq s acc _ = raise ImpTranslationBug
      in
         transSeq s [] seq
      end
     | trExpr s (Exp.LIT lit) =
      let
         val vtype = case lit of
            (SpecAbstractTree.INTlit i) => INTvtype
          | (SpecAbstractTree.FLTlit i) => VOIDvtype
          | (SpecAbstractTree.STRlit i) => STRINGvtype
          | (SpecAbstractTree.VEClit v) => BITvtype (String.size v)
      in
         ([], BOXexp (vtype, LITexp (vtype,lit)))
      end
     | trExpr s (Exp.CON sym) =
      (case SymMap.find (!constructors, sym) of
         NONE => ([], BOXexp (INTvtype, CONexp sym))
       | SOME _ =>  ([], CLOSUREexp (OBJvtype, addConFun s sym, []))
       )
     | trExpr s (Exp.ID sym) = ([], IDexp sym)
   and trDecl s (sym, args, body) =
      let
         val ((stmts, exp), declVars) =
            withNewDeclVars s (fn s => trExpr s body)
         val availInClosure = SymSet.union (#globalVars s,
               SymSet.addList (SymSet.singleton sym, args))
         val inClosure = SymSet.difference (freeVars body, availInClosure)
         fun setToArgs ss = map (fn s => (OBJvtype, s)) (SymSet.listItems ss)
         val clArgs = setToArgs inClosure
         val stdArgs = map (fn s => (OBJvtype, s)) args
         val fType = FUNvtype { result = OBJvtype,
                                closure = map (fn (t,_) => t) clArgs,
                                args = map (fn (t,_) => t) stdArgs }
         val _ =
            addFunction s (FUNCdecl {
              funcMonadic = INOUTmonkind,
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
               val us = ref ([] : decl list)
               val qs = ref ([] : decl list)
               val rs = ref ([] : decl list)

               fun get s = VarInfo.lookup (!SymbolTables.varTable, Atom.atom s)
               val prim_map =
                  foldl (fn ((k,v),m) => SymMap.insert (m,get k,v))
                     SymMap.empty prim_table

               val cs = { functions = fs,
                          updates = us,
                          queries = qs,
                          records = rs,
                          prim_map = prim_map }
               val initialState = { globalVars = SymSet.empty,
                                    localVars = SymSet.empty,
                                    declVars = ref SymSet.empty,
                                    constants = cs
                                   }
               val bogusExp = Exp.LIT (SpecAbstractTree.INTlit 42)
               val _ = trExpr initialState (Exp.LETREC (clauses, bogusExp))
            in
               { decls = !(#functions cs) }
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
