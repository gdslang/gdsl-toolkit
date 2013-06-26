
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
      let
         val localVars = foldl (fn ((f, args, body), ls) =>
               SymSet.union (SymSet.addList (SymSet.singleton f, args), ls))
               SymSet.empty ds
         val allVars = foldl (fn ((f, args, body), ss) =>
               SymSet.union (freeVars body, ss))
               (freeVars e) ds
      in
         SymSet.difference (allVars, localVars)
      end
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
     | freeVars (Exp.RECORD fs) =
      foldl (fn ((f,e),ss) => SymSet.union (freeVars e,ss)) SymSet.empty fs
     | freeVars (Exp.UPDATE fs) =
      foldl (fn ((f,e),ss) => SymSet.union (freeVars e,ss)) SymSet.empty fs
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


   type state = { globalExp : exp SymMap.map ref,
                  declVars : SymSet.set ref,
                  resVar : SymbolTable.symid,
                  functions : decl list ref,
                  fields : vtype SymMap.map ref }

   fun addLocalVar (s : state) sym =
         ((#declVars s) := SymSet.add (!(#declVars s), sym); s)
   fun addGlobalExp (s : state) (sym, exp) =
         ((#globalExp s) := SymMap.insert (!(#globalExp s), sym, exp); s)
   (*returns the expression registered for the given symbol; if no expression
   is registered, an expression containing the passed-in symbol is returned*)
   fun getGlobalExp (s : state) sym = (
      case SymMap.find (!(#globalExp s), sym) of
         SOME exp => exp
       | NONE => IDexp sym
   )
   fun freshRes (str,s : state) =
      let
         val tab = !SymbolTables.varTable
         val (tab, res) = SymbolTable.fresh (tab, Atom.atom (str ^ "Res"))
         val _ = SymbolTables.varTable := tab
         val s' = {
               globalExp = #globalExp s,
               declVars = #declVars s,
               resVar = res,
               functions = #functions s,
               fields = #fields s }
       in
         (res,s')
      end
   fun getClosureSym sym =
      let
         val tab = !SymbolTables.varTable
         val atm = Atom.atom (Atom.toString (SymbolTable.getAtom (tab,sym)) ^ "_closure")
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

   fun withLocalScope (s : state) f =
      let
         val localDecls = ref SymSet.empty
         val s' = f {
               globalExp = #globalExp s,
               declVars = localDecls,
               resVar = #resVar s,
               functions = #functions s,
               fields = #fields s }
      in
         (s', !localDecls)
      end

   (* functions operating on the mutable variables *)
   fun addDecl (s : state) decl = (#functions s) := decl :: !(#functions s)
   fun addField (s : state) sym = (#fields s) := SymMap.insert (!(#fields s),sym,OBJvtype)
   fun addUpdate (s : state) fields =
      let
         val ftab = !SymbolTables.fieldTable
         val name = Atom.atom (foldl
                     (fn (sym, str) =>
                        str ^ "_" ^ Atom.toString (SymbolTable.getAtom (ftab,sym)))
                     "%update" fields)
         val tab = !SymbolTables.varTable
      in
         case SymbolTable.find (tab, name) of
            NONE =>
               let
                  val arg = Atom.atom ("arg_of_" ^ Atom.toString name) 
                  val (tab, sym) = SymbolTable.fresh (tab, name)
                  val (tab, sym') = SymbolTable.fresh (tab, arg)
                  val _ = SymbolTables.varTable := tab
                  val _ = app (addField s) fields
                     
                  val argsTy =  map (fn _ => OBJvtype) fields
                  val fType = FUNvtype (OBJvtype, false, argsTy @ [OBJvtype])
                  val fTypeCl = FUNvtype (OBJvtype, false, [OBJvtype])
                  
                  val _ = addDecl s 
                           (UPDATEdecl { updateName = sym,
                                         updateArg = sym',
                                         updateFields = fields,
                                         updateType = fType })

                  val clSym = getClosureSym sym
                  val _ = addDecl s (CLOSUREdecl {
                    closureName = clSym,
                    closureArgs = argsTy,
                    closureDelegate = sym,
                    closureDelArgs = [(OBJvtype,sym')]
                  })
               in
                  clSym
               end
          | SOME sym => getClosureSym sym
      end
   fun addSelect (s : state) field =
      let
         val ftab = !SymbolTables.fieldTable
         val name = Atom.atom ("%select_" ^ 
                               Atom.toString (SymbolTable.getAtom (ftab,field)))
         val tab = !SymbolTables.varTable
      in
         case SymbolTable.find (tab, name) of
            NONE =>
               let
                  val arg = Atom.atom ("arg_of_" ^ Atom.toString name) 
                  val (tab, sym') = SymbolTable.fresh (tab, arg)
                  val (tab, sym) = SymbolTable.fresh (tab, name)
                  val _ = SymbolTables.varTable := tab                        
                  val fType = FUNvtype (OBJvtype, false, [OBJvtype])
                  val _ = addField s field
                  val _ = addDecl s 
                           (SELECTdecl { selectName = sym,
                                         selectField = field,
                                         selectType = fType })

                  val fTypeCl = FUNvtype (OBJvtype, false, [])
                  val clSym = getClosureSym sym
                  val _ = addDecl s (CLOSUREdecl {
                    closureName = clSym,
                    closureArgs = [],
                    closureDelegate = sym,
                    closureDelArgs = [(OBJvtype, sym')]
                  })
               in
                  clSym
               end
          | SOME sym => getClosureSym sym
      end
   fun addConFun (s : state) con =
      let
         val ctab = !SymbolTables.conTable
         val conName = Atom.toString (SymbolTable.getAtom (ctab,con))
         val name = Atom.atom ("%constructor_" ^ conName)
         val tab = !SymbolTables.varTable
      in
         case SymbolTable.find (tab, name) of
            NONE =>
               let
                  val arg = Atom.atom ("arg_of_" ^ conName) 
                  val (tab, sym') = SymbolTable.fresh (tab, arg)
                  val (tab, sym) = SymbolTable.fresh (tab, name)
                  val _ = SymbolTables.varTable := tab

                  val fType = FUNvtype (OBJvtype, false, [OBJvtype])                        
                  val _ = addDecl s (CONdecl { conName = sym,
                                               conTag = con,
                                               conArg = (OBJvtype, sym'),
                                               conType = fType })

                  val clSym = getClosureSym sym
                  val _ = addDecl s (CLOSUREdecl {
                    closureName = clSym,
                    closureArgs = [],
                    closureDelegate = sym,
                    closureDelArgs = [(OBJvtype, sym')]
                  })
               in
                  clSym
               end
          | SOME sym => getClosureSym sym
      end
   
   fun get_con_idx e = PRIexp (PUREmonkind, GET_CON_IDXprim,
      FUNvtype (INTvtype, false, [OBJvtype]), [e])
   fun get_con_arg e = PRIexp (PUREmonkind, GET_CON_ARGprim,
      FUNvtype (OBJvtype, false, [OBJvtype]), [e])

   fun trBlock (s : state) e =
      let
         val res = #resVar s
         val ((stmts, exp),ds) = withLocalScope s (fn s => trExpr s e)
         val decls = map (fn s => (OBJvtype, s)) (SymSet.listItems ds)
      in
         BASICblock (decls, stmts @ [ASSIGNstmt (SOME res, exp)])
      end
   and trExpr (s : state) (Exp.LETVAL (x,b,e)) =
      let
         val (bStmts, bExp) = trExpr (addLocalVar s x) b
         val (eStmts, eExp) = trExpr s e
      in
         (bStmts @ ASSIGNstmt (SOME x,bExp) :: eStmts, eExp)
      end
     | trExpr s (Exp.LETREC (ds, e)) =
      let
         (* register a dummy expression for all symbols in this binding groups
         in order ensure that these symbols are known and not converted into
         closure arguments *)
         val _ = map (fn (sym,_,body) => addGlobalExp s (sym, IDexp sym)) ds
         (* properly infer the expression to insert for each global symbol *)
         val visitFuns = List.map (trDecl s) ds
         (* now that all expressions for global symbols are set, translate the
         bodies of each functions *)
         val _ = app (fn (visitFun, (_,_,body)) => visitFun body) (ListPair.zipEq (visitFuns, ds))
      in
         trExpr s e
      end
     | trExpr s (Exp.IF (c,t,e)) =
      let
         val (cStmts, cExp) = trExpr s c
         val (res,s) = freshRes ("%ite",s)
         val s = addLocalVar s res
         val tBlock = trBlock s t
         val eBlock = trBlock s e
      in
         (cStmts @ [IFstmt (VEC2INTexp (SOME 1,UNBOXexp (VECvtype,cExp)), tBlock, eBlock)], IDexp res)
      end
     | trExpr s (Exp.CASE (e, [(Core.Pat.BIT "........", e')])) = trExpr s e'
     | trExpr s (Exp.CASE (e, [(Core.Pat.BIT "................", e')])) = trExpr s e'
     | trExpr s (Exp.CASE (e, [(Core.Pat.BIT "................................", e')])) = trExpr s e'
     | trExpr s (Exp.CASE (e, [(Core.Pat.WILD, e')])) = trExpr s e'
     | trExpr s (Exp.CASE (e, cs)) =
      let
         (* extract the scrutinee as an int which requires different
            primitives, depending on the type that is matched *)
         fun convertScrut (e, (Core.Pat.BIT bp,_) :: cs) =
            let
               val fields = String.fields (fn c => c= #"|") bp
            in
               case fields of
                  [] => convertScrut (e, cs)
                | (f::_) => VEC2INTexp (SOME (String.size f),UNBOXexp (VECvtype,e))
            end
           | convertScrut (e, (Core.Pat.INT _,_) :: _) = UNBOXexp (INTvtype,e)
           | convertScrut (e, (Core.Pat.CON (sym,_),_) :: _) = get_con_idx e
           | convertScrut (e, _ :: cs) = convertScrut (e, cs)
           | convertScrut _ = raise ImpTranslationBug
         val (stmts, scrutRaw) = trExpr s e
         val scrut = convertScrut (scrutRaw, cs)
         
         val (res,s) = freshRes ("%case",s)
         val s = addLocalVar s res

         fun trCase (Core.Pat.BIT bp, block) = (
               case String.fields (fn c => c= #"|") bp of
                  [] => (WILDpat, block)
                | [""] => (WILDpat, block)
                | fs => (VECpat fs, block)
             )
           | trCase (Core.Pat.INT i, block) = (INTpat i, block)
           | trCase (Core.Pat.CON (sym,NONE), block) = (CONpat sym, block)
           | trCase (Core.Pat.CON (sym,SOME arg), BASICblock (decls, stmts)) =
               (CONpat sym, BASICblock ((OBJvtype, arg) :: decls, ASSIGNstmt (SOME arg,get_con_arg scrutRaw) :: stmts))
           | trCase (Core.Pat.ID sym, BASICblock (decls, stmts)) =
               (WILDpat, BASICblock (decls, ASSIGNstmt (SOME sym,scrutRaw) :: stmts))
           | trCase (Core.Pat.WILD, block) = (WILDpat, block)

         val cases = map (fn (pat,e) => trCase (pat,trBlock s e)) cs
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
         case SymMap.find (!Primitives.prim_map, name) of
            SOME (_, gen) => ([], gen (map IDexp args))
          | NONE => raise ImpTranslationBug)
     | trExpr s (Exp.FN (var, body)) =
      let
         val tab = !SymbolTables.varTable
         val (tab, sym) = SymbolTable.fresh (tab, Atom.atom "%lambda")
         val _ = SymbolTables.varTable := tab
         val visitFun = trDecl (addLocalVar s var) (sym, [var], body)
         val _ = visitFun body
      in
         ([], IDexp sym)
      end
     | trExpr s (Exp.RECORD fs) =
      let
         fun trans acc res [] = (acc,res)
           | trans acc res ((f,e) :: es) = (case trExpr s e of
              (stmts, e') => trans (acc @ stmts) (res @ [(f,e')]) es)
         val (stmts, unsortedFields) = trans [] [] fs
         fun fieldCmp ((f1,_),(f2,_)) = SymbolTable.compare_symid (f1,f2)
         val fields = ListMergeSort.uniqueSort fieldCmp unsortedFields
         val _ = app (fn (f,e) => addField s f) fs
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
         val clSym = addUpdate s (map #1 updates)
         val fTypeCl = FUNvtype (OBJvtype,false,map (fn _ => OBJvtype) updates)
      in
         (stmts, CLOSUREexp (fTypeCl, clSym, map #2 updates))
      end
     | trExpr s (Exp.SELECT f) =
      let
         val fTypeCl = FUNvtype (OBJvtype, false, [])
         val selectFunCl = addSelect s f
      in
         ([], CLOSUREexp (fTypeCl, selectFunCl, []))
      end
     | trExpr s (Exp.SEQ seq) =
      let
         fun transSeq s acc [Exp.ACTION e] =
               let
                  val (stmts, exp) = trExpr s e
               in
                  (acc @ stmts, EXECexp exp)
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
         val ((stmts,exp), decls) = withLocalScope s (fn s => transSeq s [] seq)
      in
         ([], STATEexp (BASICblock (map (fn d => (OBJvtype, d)) (SymSet.listItems decls), stmts), exp))
      end
     | trExpr s (Exp.LIT (SpecAbstractTree.INTlit i)) =
         ([], BOXexp (INTvtype, LITexp (INTvtype, INTlit i)))
     | trExpr s (Exp.LIT (SpecAbstractTree.STRlit str)) =
         ([], LITexp (STRINGvtype,STRlit str))
     | trExpr s (Exp.LIT (SpecAbstractTree.VEClit v)) =
         ([], BOXexp (VECvtype, INT2VECexp (String.size v, LITexp (INTvtype, (VEClit v)))))
     | trExpr s (Exp.LIT (SpecAbstractTree.FLTlit _)) =
         raise ImpTranslationBug
     | trExpr s (Exp.CON sym) =
      (case SymMap.lookup (!constructors, sym) of
         (_, NONE) => ([], BOXexp (INTvtype, LITexp (INTvtype, CONlit sym)))
       | (_, SOME _) =>
         let
            val fTypeCl = FUNvtype (OBJvtype, false, [])
            val symCl = addConFun s sym
         in
            ([], CLOSUREexp (fTypeCl, symCl, []))  
         end
       )
     | trExpr s (Exp.ID sym) = ( 
      case SymMap.find(!Primitives.prim_val_map, sym) of
         SOME exp => ([], exp)

         (* insert any expression that is registered for a global symbol; in
         particular, this will replace any function symbol with a closure
         expression that is registered for it; the function getGlobalExp returns
         IDexp sym if the symbol has no expression registered for it *)
       | NONE => ([], getGlobalExp s sym)
     )

   and trDecl (s : state) (sym, args, body) =
      let
         val (res,s) = freshRes (Atom.toString (SymbolTable.getAtom (!SymbolTables.varTable,sym)),s)
         val availInClosure = SymSet.singleton sym
         (* add all known declarations *)
         val availInClosure = SymSet.union(availInClosure,SymSet.fromList (SymMap.listKeys (!(#globalExp s))))
         (* add all arguments *)
         val availInClosure = SymSet.addList (availInClosure,  args)
         val inClosure = SymSet.difference (freeVars body, availInClosure)
         val clArgs = map (fn s => (OBJvtype, s)) (SymSet.listItems inClosure)
         val stdArgs = map (fn s => (OBJvtype, s)) args
         val fType = FUNvtype (OBJvtype, not (null clArgs), map #1 clArgs @ map (fn (t,_) => t) stdArgs)
         val _ = if null args
            then
               addGlobalExp s (sym, CALLexp (PUREmonkind, sym, []))
            else
            let
               val fTypeCl = FUNvtype (OBJvtype, false, map #1 clArgs)
               val symCl = getClosureSym sym
               
               val _ = addDecl s (CLOSUREdecl {
                     closureName = symCl,
                     closureArgs = map #1 clArgs,
                     closureDelegate = sym,
                     closureDelArgs = stdArgs
                  })
               val _ = addGlobalExp s (sym, CLOSUREexp (fTypeCl, symCl, map (IDexp o #2) clArgs))
            in s end
      in
         fn body =>
            addDecl s (FUNCdecl {
              funcMonadic = PUREmonkind,
              funcClosure = clArgs,
              funcType = fType,
              funcName = sym,
              funcArgs = stdArgs,
              funcBody = trBlock s body,
              funcRes = res
            })
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
               val decls = ref ([] : decl list)
               val fields = ref (SymMap.empty : vtype SymMap.map)
               val globs = foldl (fn (sym,m) => SymMap.insert (m,sym,IDexp sym))
                              SymMap.empty
                              (SymMap.listKeys (!Primitives.prim_map) @
                               SymMap.listKeys (!Primitives.prim_val_map))
               val initialState = { globalExp = ref globs,
                                    declVars = ref SymSet.empty,
                                    resVar = SymbolTable.unsafeFromInt 1,
                                    functions = decls,
                                    fields = fields
                                   }
               val bogusExp = Exp.LIT (SpecAbstractTree.INTlit 42)
               val _ = trExpr initialState (Exp.LETREC (clauses, bogusExp))
            in
               { decls = !decls,
                 fdecls = !fields }
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
