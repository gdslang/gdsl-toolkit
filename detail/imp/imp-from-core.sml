
structure ImpFromCore : sig
   val run:
      Core.Spec.t ->
         Imp.Spec.t CompilationMonad.t

end = struct

   structure CM = CompilationMonad

   exception ImpTranslationBug

   open Core
   open Imp
   
   structure AST = SpecAbstractTree

   val constructors: (Spec.sym * Spec.ty option) SymMap.map ref = ref SymMap.empty
   val datatypes : (Spec.sym * (Spec.sym * Spec.ty option) list) list ref = ref []
   val typealias : (sym * AST.ty) list ref = ref []

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


   type state = { exports : (sym list * SpecAbstractTree.ty) SymMap.map,
                  globalExp : exp SymMap.map ref,
                  declVars : SymSet.set ref,
                  resVar : SymbolTable.symid,
                  functions : decl list ref,
                  fields : vtype SymMap.map ref,
                  conToArg : SymbolTable.symid SymMap.map ref,
                  closureSyms : (SymbolTable.symid * SymSet.set) SymMap.map ref }

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
               exports = #exports s,
               globalExp = #globalExp s,
               declVars = #declVars s,
               resVar = res,
               functions = #functions s,
               fields = #fields s,
               conToArg = #conToArg s,
               closureSyms = #closureSyms s }
       in
         (res,s')
      end
   fun getClosureSym (s: state, sym) =
      case SymMap.find (!(#closureSyms s), sym) of
         SOME (clSym,_) => clSym
       | NONE =>
          let
            val tab = !SymbolTables.varTable
            val atm = Atom.atom (Atom.toString (SymbolTable.getAtom (tab,sym)) ^ "_closure")
            val (tab, clSym) = SymbolTable.fresh (tab, atm)
            val _ = SymbolTables.varTable := tab
            val _ = #closureSyms s := SymMap.insert (!(#closureSyms s), sym, (clSym,SymSet.empty))
          in
             clSym
          end

   fun addClosureArgs (s : state, sym, args) =
      case SymMap.find (!(#closureSyms s), sym) of
         NONE => if SymSet.isEmpty args then true else
            (getClosureSym (s,sym); addClosureArgs (s,sym,args))
       | SOME (clSym,clArgs) =>
         let
            val newClArgs = SymSet.union (clArgs,args)
            val _ = #closureSyms s := SymMap.insert (!(#closureSyms s), sym, (clSym,newClArgs))
            (*val _ = TextIO.print ("adding to symbol " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ ": " ^
               SymSet.foldl (fn (s,str) => str ^ " " ^ SymbolTable.getString(!SymbolTables.varTable, s))
                 "" (SymSet.difference (newClArgs,clArgs)) ^ "\n")*)
         in
            SymSet.isSubset (newClArgs, clArgs)
         end

   fun getClosureArgs (s : state, sym) =
      case SymMap.find (!(#closureSyms s), sym) of
         SOME (clSym,clArgs) => clArgs
       | NONE => SymSet.empty

   fun withLocalScope (s : state) f =
      let
         val localDecls = ref SymSet.empty
         val s' = f {
               exports = #exports s,
               globalExp = #globalExp s,
               declVars = localDecls,
               resVar = #resVar s,
               functions = #functions s,
               conToArg = #conToArg s,
               fields = #fields s,
               closureSyms = #closureSyms s }
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
                  val (tab, sym) = SymbolTable.fresh (tab, name)
                  val (tab, symArg) = SymbolTable.fresh (tab, Atom.atom "recArg")
                  val (tab, symRes) = SymbolTable.fresh (tab, Atom.atom "recRes")
                  val (tab, symDummy) = SymbolTable.fresh (tab, Atom.atom "recSym")
                  val _ = SymbolTables.varTable := tab
                  fun genArgs f =
                     let
                        val _ = addField s f
                        val arg = Atom.atom (SymbolTable.getString (ftab,f) ^ "_val")
                        val tab = !SymbolTables.varTable
                        val (tab, sym) = SymbolTable.fresh (tab,arg)
                        val _ = SymbolTables.varTable := tab
                     in
                        sym
                     end
                  val args = map genArgs fields
                  val argsTy =  map (fn _ => OBJvtype) args
                  val fType = FUNvtype (OBJvtype, false, argsTy @ [OBJvtype])
                  val fTypeCl = FUNvtype (OBJvtype, false, [OBJvtype])
                  val fieldsExps = ListPair.zipEq (fields, map IDexp args)
                  val body = BASICblock ([],[ASSIGNstmt (SOME symRes,
                     UPDATEexp (symDummy, OBJvtype, fieldsExps, IDexp symArg))])
                  val fArgs = map (fn arg => (OBJvtype,arg)) (args @ [symArg])
                  val _ = addDecl s 
                           (FUNCdecl { funcIsConst = false,
                                       funcClosure = [],
                                       funcType = fType,
                                       funcName = sym,
                                       funcArgs = fArgs,
                                       funcBody = body,
                                       funcRes = symRes })

                  val clSym = getClosureSym (s,sym)
                  val _ = addDecl s (CLOSUREdecl {
                    closureName = clSym,
                    closureArgs = argsTy,
                    closureDelegate = sym,
                    closureDelArgs = [(OBJvtype,symArg)],
                    closureRetTy = OBJvtype
                  })
               in
                  clSym
               end
          | SOME sym => getClosureSym (s,sym)
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
                  val res = Atom.atom ("res_of_" ^ Atom.toString name)
                  val dum = Atom.atom ("dummy_" ^ Atom.toString name)
                  val (tab, symArg) = SymbolTable.fresh (tab, arg)
                  val (tab, symRes) = SymbolTable.fresh (tab, res)
                  val (tab, symDum) = SymbolTable.fresh (tab, dum)
                  val (tab, sym) = SymbolTable.fresh (tab, name)
                  val _ = SymbolTables.varTable := tab                        
                  val fType = FUNvtype (OBJvtype, false, [OBJvtype])
                  val _ = addField s field
                  val body = BASICblock ([], [
                        ASSIGNstmt (SOME symRes, SELECTexp (symDum, OBJvtype, field, IDexp symArg))
                     ])
                  val _ = addDecl s 
                           (FUNCdecl { funcIsConst = false,
                                       funcClosure = [],
                                       funcType = fType,
                                       funcName = sym,
                                       funcArgs = [(OBJvtype,symArg)],
                                       funcBody = body,
                                       funcRes = symRes })

                  val fTypeCl = FUNvtype (OBJvtype, false, [])
                  val clSym = getClosureSym (s,sym)
                  val _ = addDecl s (CLOSUREdecl {
                    closureName = clSym,
                    closureArgs = [],
                    closureDelegate = sym,
                    closureDelArgs = [(OBJvtype, symArg)],
                    closureRetTy = OBJvtype
                  })
               in
                  clSym
               end
          | SOME sym => getClosureSym (s,sym)
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

                  val _ = #conToArg s := SymMap.insert (!(#conToArg s),con,sym')

                  val fType = FUNvtype (OBJvtype, false, [OBJvtype])                        
                  val _ = addDecl s (CONdecl { conName = sym,
                                               conTag = con,
                                               conArg = (OBJvtype, sym'),
                                               conType = fType })

                  val clSym = getClosureSym (s,sym)
                  val _ = addDecl s (CLOSUREdecl {
                    closureName = clSym,
                    closureArgs = [],
                    closureDelegate = sym,
                    closureDelArgs = [(OBJvtype, sym')],
                    closureRetTy = OBJvtype
                  })
               in
                  sym
               end
          | SOME sym => sym
      end
   
   fun get_con_idx e = PRIexp (GET_CON_IDXprim,
      FUNvtype (INTvtype, false, [OBJvtype]), [e])

   (* a bit of a cheat: the first argument is a dummy variable that is the
   constructor function, this is used to do track to which constructor the
   payload belongs to *)
   fun get_con_arg (a,e) = PRIexp (GET_CON_ARGprim,
      FUNvtype (OBJvtype, false, [FUNvtype (OBJvtype, false, [OBJvtype]),OBJvtype]), [IDexp a,e])

   (* Given a binding group, compute the set of variables that have to be provided
      in the closure of each defined symbol. *)
   fun genClosureArgs (s : state, ds) =
      let
         val fSyms = SymSet.addList (SymSet.empty, map (fn (sym,args,body) => sym) ds)
         (* add all known declarations *)
         val availInClosure = SymSet.union(fSyms,SymSet.fromList (SymMap.listKeys (!(#globalExp s))))
         (* for each declared function, compute free and available variables *)
         val freeAndAvail = map (fn (sym,args,body) => 
            (sym, freeVars body, SymSet.addList (availInClosure, args))) ds
         (* add all variables that are free and not functions or local arguments
            to the list of closure variables *)
         val _ = app (fn (sym,free,avail) =>
            ignore (addClosureArgs (s,sym,SymSet.difference (free,avail)))) freeAndAvail
         fun fixpoint stable = if stable then () else
            fixpoint (foldl (fn ((sym,free,avail),stable) =>
               addClosureArgs (s,sym,
                  SymSet.foldl (fn (sym,extra) =>
                     SymSet.union (getClosureArgs (s,sym),extra)
                  ) SymSet.empty free)
               andalso stable
            ) true freeAndAvail)
         val _ = fixpoint false
      in
         ()
      end

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
         val _ = genClosureArgs (s,ds)

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
           | convertScrut (e, (Core.Pat.CON (sym,SOME _),_) :: _) = get_con_idx e
           | convertScrut (e, (Core.Pat.CON (sym,NONE),_) :: _) = UNBOXexp (INTvtype,e)
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
               (CONpat sym, BASICblock ((OBJvtype, arg) :: decls,
               ASSIGNstmt (SOME arg,get_con_arg (addConFun s sym,scrutRaw)) :: stmts))
           | trCase (Core.Pat.ID sym, BASICblock (decls, stmts)) =
               ((addLocalVar s sym; WILDpat),
                BASICblock (decls, ASSIGNstmt (SOME sym,scrutRaw) :: stmts))
           | trCase (Core.Pat.WILD, block) = (WILDpat, block)

         val cases = map (fn (pat,e) => trCase (pat,trBlock s e)) cs
         
         (* if a switch statement matches against all constructors of a data type,
            then turn the last case into a default one *)
         fun getDataType (CONpat sym :: _) =
            (case SymMap.find (!constructors, sym) of
               NONE => NONE
             | SOME (dt,_) => SOME dt
            )
           | getDataType _ = NONE
     
         fun addDefault ps = case getDataType ps of
            NONE => ps
          | SOME dt =>
            let
               fun dtEqual (dt',_) = SymbolTable.eq_symid (dt,dt')
               val cons = foldl
                  (fn ((_,consArgs),ss) => SymSet.addList (ss,map #1 consArgs))
                  SymSet.empty (List.filter dtEqual (!datatypes))
               fun inspectPat ((p as (CONpat sym)) :: ps) cons =
                  let
                     val cons = SymSet.delete (cons, sym)
                     val p = if SymSet.isEmpty cons then WILDpat else p
                  in
                     p :: inspectPat ps cons
                  end
                 | inspectPat (p :: ps) cons = p :: inspectPat ps cons
                 | inspectPat [] cons = []
            in
               inspectPat ps cons
            end

        val (ps,bbs) = ListPair.unzip cases
        val ps = addDefault ps
        val cases = ListPair.zipEq (ps,bbs)

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
         (stmts @ stmtss, INVOKEexp (ty, funcExp, argExps))
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
         val _ = genClosureArgs (s,[(sym, [var], body)])
         val visitFun = trDecl (addLocalVar s var) (sym, [var], body)

         val _ = visitFun body
      in
         ([], IDexp sym)
      end
     | trExpr s (Exp.RECORD fs) =
      let
         val tab = !SymbolTables.varTable
         val (tab, symDum) = SymbolTable.fresh (tab, Atom.atom "dummy_rec")
         val _ = SymbolTables.varTable := tab
         fun trans acc res [] = (acc,res)
           | trans acc res ((f,e) :: es) = (case trExpr s e of
              (stmts, e') => trans (acc @ stmts) (res @ [(f,e')]) es)
         val (stmts, unsortedFields) = trans [] [] fs
         fun fieldCmp ((f1,_),(f2,_)) = SymbolTable.compare_symid (f1,f2)
         val fields = ListMergeSort.uniqueSort fieldCmp unsortedFields
         val _ = app (fn (f,e) => addField s f) fs
      in
         (stmts, RECORDexp (symDum, OBJvtype, fields))
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
                  (acc @ stmts, EXECexp (MONADvtype OBJvtype, exp))
               end
           | transSeq s acc ((Exp.ACTION e) :: seq) =
               let
                  val (stmts, exp) = trExpr s e
                  val stmtss = acc @ stmts @ [ASSIGNstmt (NONE,(EXECexp (MONADvtype OBJvtype, exp)))]
               in
                  transSeq s stmtss seq
               end
           | transSeq s acc ((Exp.BIND (res,e)) :: seq) =
               let
                  val (stmts, exp) = trExpr s e
                  val stmtss = acc @ stmts @ [ASSIGNstmt (SOME res,(EXECexp (MONADvtype OBJvtype, exp)))]
               in
                  transSeq (addLocalVar s res) stmtss seq
               end
           | transSeq s acc _ = raise ImpTranslationBug
         val ((stmts,exp), decls) = withLocalScope s (fn s => transSeq s [] seq)
      in
         ([], STATEexp (BASICblock (map (fn d => (OBJvtype, d)) (SymSet.listItems decls), stmts), OBJvtype, exp))
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
            val symCl = getClosureSym (s, addConFun s sym)
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

   and trDecl (s : state) (sym, args, _) =
      let
         val (res,s) = freshRes (Atom.toString (SymbolTable.getAtom (!SymbolTables.varTable,sym)),s)
         val clArgs = map (fn s => (OBJvtype, s)) (SymSet.listItems (getClosureArgs (s,sym)))
         val stdArgs = map (fn s => (OBJvtype, s)) args
         val fType = FUNvtype (OBJvtype, not (null clArgs), map #1 clArgs @ map (fn (t,_) => t) stdArgs)
         val fTypeCl = FUNvtype (OBJvtype, false, map #1 clArgs)
         val symCl = getClosureSym (s,sym)
         
         val _ = addDecl s (CLOSUREdecl {
               closureName = symCl,
               closureArgs = map #1 clArgs,
               closureDelegate = sym,
               closureDelArgs = stdArgs,
               closureRetTy = OBJvtype
            })
         val _ = if null args then
               addGlobalExp s (sym, CALLexp (IDexp sym, map (IDexp o #2) clArgs))
            else
               addGlobalExp s (sym, CLOSUREexp (fTypeCl, symCl, map (IDexp o #2) clArgs))
      in
         fn body =>
            addDecl s (FUNCdecl {
              funcIsConst = null stdArgs andalso null clArgs,
              funcClosure = clArgs,
              funcType = fType,
              funcName = sym,
              funcArgs = stdArgs,
              funcBody = trBlock s body,
              funcRes = res
            })
      end

   fun translate (errs,spec) =
      Spec.upd
         (fn clauses =>
            let
               val () = constructors := Spec.get#constructors spec
               val () = datatypes := Spec.get#datatypes spec
               val () = typealias := Spec.get#typealias spec
               val exports = Spec.get#exports spec

               val decls = ref ([] : decl list)
               val fields = ref (SymMap.empty : vtype SymMap.map)
               val globs = foldl (fn (sym,m) => SymMap.insert (m,sym,IDexp sym))
                              SymMap.empty
                              (SymMap.listKeys (!Primitives.prim_map) @
                               SymMap.listKeys (!Primitives.prim_val_map))

               val initialState = { exports = exports,
                                    globalExp = ref globs,
                                    declVars = ref SymSet.empty,
                                    resVar = SymbolTable.unsafeFromInt 1,
                                    functions = decls,
                                    conToArg = ref SymMap.empty,
                                    fields = fields,
                                    closureSyms = ref SymMap.empty
                                   }
               val bogusExp = Exp.LIT (SpecAbstractTree.INTlit 42)
               val _ = trExpr initialState (Exp.LETREC (clauses, bogusExp))
            in
               { decls = !decls,
                 fdecls = !fields,
                 exports = exports,
                 monad = OBJvtype,
                 errs = errs }
            end) spec

   fun dumpPre (os, (_,spec)) = Pretty.prettyTo (os, Core.PP.spec spec)
   fun dumpPost (os, spec) = Pretty.prettyTo (os, Imp.PP.spec spec)
 
   val translate =
      BasicControl.mkKeepPass
         {passName="imp-conversion",
          registry=CPSControl.registry,
          pass=translate,
          preExt="core",
          preOutput=dumpPre,
          postExt="imp",
          postOutput=dumpPost}

   open CompilationMonad
   infix >>=
   fun run spec = getErrorStream >>= (fn errs =>
                  return (translate (errs,spec)))
end
