(**
 * ## Perform Type Inference
 *
 * Returns tables with types of each identifier.
 *)
structure TypeInference : sig

   type symbol_types = (SymbolTable.symid * Environment.symbol_type) list
       
   val typeInferencePass: (Error.err_stream * ResolveTypeInfo.type_info * 
                           SpecAbstractTree.specification) -> symbol_types
   val run: ResolveTypeInfo.type_info * SpecAbstractTree.specification ->
            symbol_types CompilationMonad.t
   
   val showTable : symbol_types -> string
   
end = struct

   structure AST = SpecAbstractTree
   structure E = Environment
   structure BD = BooleanDomain
   structure TI = ResolveTypeInfo
   structure S = Substitutions
   
   type symbol_types = (SymbolTable.symid * E.symbol_type) list

   structure SMap = RedBlackMapFn (
      struct
         type ord_key = SymbolTable.symid
         val compare = SymbolTable.compare_symid
      end)

   open Types

   exception NotImplemented

   exception TypeError

   infix >>= >>
   
   type rhsInfo = (SymbolTable.symid *
                   (*pattern and guard for decode function*)
                   (AST.decodepat list * AST.exp option) option *
                   AST.var_bind list *       (*arguments*)
                   AST.exp)

fun typeInferencePass (errStrm, ti : TI.type_info, ast) = let
   val sm = ref (SMap.empty : E.symbol_type SMap.map)
   val { tsynDefs, typeDefs, conParents} = ti
   val caseExpSymId = SymbolTable.lookup(!SymbolTables.varTable,
                                         Atom.atom Primitives.caseExpression)
   val stateSymId = SymbolTable.lookup(!SymbolTables.varTable,
                                       Atom.atom Primitives.globalState)
   val granularitySymId = SymbolTable.lookup(!SymbolTables.varTable,
                                             Atom.atom Primitives.granularity)
   
   fun reportError conv ({span = _, error = isErr }, env) {span=s as (p,_), tree=t} =
      conv ({span = s, error = isErr},env) t
      handle (S.UnificationFailure str) =>
         (Error.errorAt (errStrm, s, [str]); raise TypeError)
   fun getSpan {span = s, error = _} = s

   (* define a first traversal that creates a group of all top-level decls *)
   fun topDecl (AST.MARKdecl {span, tree=t}) = topDecl t
     | topDecl (AST.DECODEdecl dd) = topDecodeDecl dd
     | topDecl (AST.LETRECdecl vd) = topLetrecDecl vd
     | topDecl _ = []

   and topDecodeDecl (v, _, _) = [(v, true)]

   and topLetrecDecl (v, _, _) = [(v,false)]
   
   (* define a second traversal that is a full inference of the tree *)
   
   (*local helper function to infer types for a binding group*)
   val maxIter = 0
   fun checkUsages (sym, env) =
      let
         (*val _ = TextIO.print ("***** usages of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " in " ^ (if reportWarnings then " fixpoint\n" else " first round\n"))*)
         fun checkUsage (s, (unstable, env)) =
            let
               val envFun = E.pushSymbol (sym, s, env)
               (*val _ = TextIO.print ("pushing " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " symbol:\n" ^ E.topToString envFun)*)
               val envCall = E.pushUsage (sym, s, env)
               (*val _ = TextIO.print ("pushing usage:\n" ^ E.topToString envCall)*)
               (*inform about a unification failure when checking call site
               with definition*)
               fun raiseError str =
                  let
                     val si = TVar.emptyShowInfo
                     val (sFun, si) = E.kappaToStringSI (envFun, si)
                     val (sCall, si) = E.kappaToStringSI (envCall, si)
                  in 
                     (Error.errorAt (errStrm, s, [str,
                     " when checking call to ",
                     SymbolTable.getString(!SymbolTables.varTable, sym),
                     "\ncall requires type  " ^ sCall,
                     "\ndefinition has type " ^ sFun]))
                  end
               (*warn about refinement of definition due to a call site*)
               fun raiseWarning (substs, syms) =
                  if E.SymbolSet.isEmpty syms then () else
                  let
                     val si = TVar.emptyShowInfo
                     val (sSubst, si) = S.showSubstsSI (substs, si)
                     fun showSyms (sym, (res, pre, si)) =
                        let
                           val sStr = SymbolTable.getString
                              (!SymbolTables.varTable, sym)
                           val (sType, si) = E.funTypeToStringSI (env, sym, si)
                        in
                           (res ^ pre ^ sStr ^ " : " ^ sType, ", ", si)
                        end
                     val (symsStr, _, _) =
                        List.foldl showSyms ("", "", si)
                           (E.SymbolSet.listItems syms)
                  in 
                     (Error.warningAt (errStrm, s, [
                     "call to ",
                     SymbolTable.getString(!SymbolTables.varTable, sym),
                     " requires refinement ", sSubst,
                     "\nfor " ^ symsStr]))
                  end
               val (substs, (env, _)) = (E.subseteq (envCall, envFun),
                                         E.meet (envCall, envFun))
                  handle (S.UnificationFailure str) =>
                     (raiseError str; (S.emptySubsts, (envCall, envCall)))
               val env = E.popToUsage (sym, s, env)
               val affectedSyms = E.affectedFunctions (substs,envCall)
               (*if the currently examined symbol has been updated then we
               check if it's stable now, so we don't flag natural updates
               as critical recursion*)
               val affectedSyms =
                  if E.SymbolSet.member (affectedSyms,sym) then 
                  let
                     val envFun = E.pushSymbol (sym, s, env)
                     val envCall = E.pushUsage (sym, s, env)
                     val substs = E.subseteq (envCall, envFun)
                        handle (S.UnificationFailure str) =>
                           (raiseError str; S.emptySubsts)
                  in
                     if S.isEmpty substs then
                        E.SymbolSet.delete (affectedSyms, sym)
                     else
                        affectedSyms
                  end
                  else
                     affectedSyms
               val _ = raiseWarning (substs, affectedSyms)
            in
               (E.SymbolSet.union (unstable, affectedSyms), env)
            end
      in
         List.foldl checkUsage (E.SymbolSet.empty, env) (E.getUsages (sym, env))
      end

   fun checkCallSites (syms, env) =
      List.foldl (fn (sym, (unstable, env)) =>
                  case checkUsages (sym, env) of
                     (newUnstable, env) =>
                        (E.SymbolSet.union (unstable,newUnstable), env)
                  ) (E.SymbolSet.empty, env) (E.SymbolSet.listItems syms)

   fun calcFixpoint curIter (syms, env) =
         if E.SymbolSet.isEmpty syms then env else
         if curIter<maxIter then
            calcFixpoint (curIter+1) (checkCallSites (syms, env))
         else
         let
            val si = TVar.emptyShowInfo
            fun showSyms (sym, (res, pre, si)) =
               let
                  val sStr = SymbolTable.getString
                     (!SymbolTables.varTable, sym)
                  val env = E.pushSymbol (sym, SymbolTable.noSpan, env)
                  val (sType, si) = E.kappaToStringSI (env, si)
               in
                  (res ^ pre ^ sStr ^ " : " ^ sType, ", ", si)
               end
            val symIds = E.SymbolSet.listItems syms
            val (symsStr, _, _) = List.foldl showSyms ("", "", si) symIds
            val s = case symIds of [] => raise TypeError | (sym :: _) =>
                    SymbolTable.getSpan(!SymbolTables.varTable, sym)
         in 
            (Error.errorAt (errStrm, s, [
            "no typing found for ",
            symsStr,
            "\npass --inference-iterations=",
            Int.toString (maxIter+1),
            " to try a little harder"]); env)
         end
   val calcFixpoint = calcFixpoint 0
   
   fun infBinding (st,env) (sym, dec, guard, args, rhs) =
      let
         (*val _ = TextIO.print ("checking binding " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")*)
         fun pushDecoderBindings(d,(n, env)) =
            case infDecodepat sym (st,env) d of (nArgs, env) => (n+nArgs, env)
         val (n,env) = List.foldl pushDecoderBindings (0,env) dec
         val env = List.foldl E.pushLambdaVar env args
         val env = infExp (st,env) rhs
         val env = List.foldr (fn (_,env) => E.reduceToFunction env) env args
         val env = E.return (n,env)
         (*val _ = TextIO.print ("after popping args:\n" ^ E.topToString env)*)
         val env = E.popToFunction (sym, env)
         (*val _ = TextIO.print ("after popping fun: " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ ":\n" ^ E.topToString env)*)
      in
         checkUsages (sym, env)
      end

   and infDecl stenv (AST.MARKdecl m) = reportError infDecl stenv m
     | infDecl (st,env) (AST.GRANULARITYdecl w) =
      let
         val envGra = E.pushWidth (granularitySymId, env)
         val envInt = E.pushType (false, CONST w, env)
         val (env, _) = E.meet (envGra, envInt)
         val env = E.popKappa env
      in
         (E.SymbolSet.empty, env)
      end
     | infDecl (st,env) (AST.STATEdecl l) =
      let
         val envState = E.pushSymbol (stateSymId, SymbolTable.noSpan, env)
         val extBVar = BD.freshBVar ()
         val extVar = VAR (TVar.freshTVar (), extBVar) 
         val env = E.meetBoolean (BD.meetVarZero extBVar, env)
         val env = E.pushType (false, extVar, env)
         val fieldBVar = BD.freshBVar ()
         val env = E.meetBoolean (BD.meetVarOne fieldBVar, env)
         val env = List.foldl (fn ((_,_,e), env) => infExp (st,env) e) env l
         val fieldList = List.rev (List.map (fn (v,_,_) => (fieldBVar,v)) l)
         val env = E.reduceToRecord (fieldList, env)
         val (env,_) = E.meet (envState, env)
         val env = E.clearFunction (stateSymId, env)
         val env = E.popToFunction (stateSymId, env)
      in
         checkUsages (stateSymId, env)
      end
     | infDecl stenv (AST.DECODEdecl dd) = infDecodedecl stenv dd
     | infDecl (st,env) (AST.LETRECdecl (v,l,e)) =
         infBinding (st,env) (v, [], NONE, l, e)
     | infDecl (st,env) _ = (E.SymbolSet.empty, env)

   and infDecodedecl stenv (v, l, Sum.INL e) =
         infBinding stenv (v, l, NONE, [], e)
     | infDecodedecl (st,env) (v, l, Sum.INR el) =
         List.foldl
            (fn ((guard, rhs), (unstable, env)) =>
               case infBinding (st,env) (v, l, SOME guard, [], rhs) of
                  (newUnstable, env) =>
                     (E.SymbolSet.union (unstable, newUnstable), env)
            ) (E.SymbolSet.empty, env) el

   and infExp stenv (AST.MARKexp m) = reportError infExp stenv m
     | infExp (st,env) (AST.LETRECexp (l,e)) =
      let                                              
         val names = List.map topLetrecDecl l
         val env = E.pushGroup (List.concat names, env)
         val (unstable, env) = List.foldl (fn ((v,l,e), (unstable, env)) =>
               case infBinding (st, env) (v, [], NONE, l, e) of
                  (newUnstable, env) =>
                     (E.SymbolSet.union (newUnstable, unstable), env)
            ) (E.SymbolSet.empty, env) l
         val env = calcFixpoint (unstable, env)
         val env = infExp (st,env) e
         val (symbols, env) = E.popGroup env
      in
         (sm := List.foldl SMap.insert' (!sm) symbols; env)
      end
     | infExp (st,env) (AST.IFexp (e1,e2,e3)) =
      let
         val envWant = E.pushType (false, VEC (CONST 1), env)
         val envHave = infExp (st,env) e1
         val (env, _) = E.meet (envWant, envHave)
         val env = E.popKappa env
         val envT = infExp (st,env) e2
         val envE = infExp (st,env) e3
         val (env, _) = E.meet (envT,envE)
      in
         env
      end
     | infExp (st,env) (AST.CASEexp (e,l)) =
      let
         val (t,env) = E.pushLambdaVar' (caseExpSymId, env)
         val envExp = infExp (st,env) e
         (*val _ = TextIO.print ("**** after case exp:\n" ^ E.toString envExp)*)
         val envVar = E.pushType (false, t, env)
         (*val _ = TextIO.print ("**** after case dup:\n" ^ E.toString envVar)*)
         val (env, _) = E.meet (envExp, envVar)
         val env = E.popKappa env
         val envs = List.map (infMatch (st,env)) l
         val envNeutral = E.pushTop env
         fun genFlow (inEnv, nEnv) =
            let
               val (inEnv, nEnv) = E.meet (inEnv, nEnv)
               val _ = E.genFlow (inEnv, nEnv)
            in
               inEnv
            end
         val env = List.foldl genFlow envNeutral envs
         (*val _ = TextIO.print ("**** all envs:\n" ^ E.toString env)*)
      in
         E.return (1,env)
      end
     | infExp stenv (AST.BINARYexp (e1, opid,e2)) =
         infExp stenv (AST.APPLYexp (AST.APPLYexp (AST.IDexp opid, e1), e2))
     | infExp (st,env) (AST.APPLYexp (e1,e2)) =
      let                                      
         val envFun = infExp (st,env) e1
         (*val _ = TextIO.print ("**** app func:\n" ^ E.topToString envFun)*)
         val envArg = infExp (st,env) e2
         (*val _ = TextIO.print ("**** app arg:\n" ^ E.topToString envArg)*)
         val envArg = E.pushTop envArg
         val envArg = E.reduceToFunction envArg
         (*val _ = TextIO.print ("**** app turning arg:\n" ^ E.topToString envArg)*)
         val (envFun, envArg) = E.meet (envFun, envArg)
         val _ = E.genFlow (envArg, envFun)
         val env = E.reduceToResult envFun
         (*val _ = TextIO.print ("**** app result:\n" ^ E.topToString env)*)
      in
         env                                                         
      end
        
     | infExp (st,env) (AST.RECORDexp l) =
      let
         val bVar = BD.freshBVar ()
         val env = E.meetBoolean (BD.meetVarZero bVar, env)
         val t = VAR (TVar.freshTVar (), bVar)
         val env = E.pushType (false, t, env)
         fun pushField ((fid,e), (nts, env)) =
            let
               val env = infExp (st,env) e
               val bVar = BD.freshBVar ()
               val env = E.meetBoolean (BD.meetVarOne bVar, env)
            in
               ((bVar, fid) :: nts, env)
            end
         val (nts, env) = List.foldl pushField ([], env) l
         (*val _ = TextIO.print ("**** before rec reduce:\n" ^ E.toString env ^ "\n")*)
         val env = E.reduceToRecord (nts, env)
         (*val _ = TextIO.print ("**** after rec reduce:\n" ^ E.toString env ^ "\n")*)
      in
         env
      end
         
     | infExp (st,env) (AST.SELECTexp f) =
      let
         val env = E.pushTop env
         val tf = VAR (TVar.freshTVar (), BD.freshBVar ())
         val env = E.pushType (false, tf, env)
         val exists = BD.freshBVar ()
         (*val _ = TextIO.print ("**** before rec reduce:\n" ^ E.toString env ^ "\n")*)
         val env = E.reduceToRecord ([(exists, f)], env)
         val env = E.meetBoolean (BD.meetVarOne exists, env)
         (*val _ = TextIO.print ("**** after rec reduce:\n" ^ E.toString env ^ "\n")*)
         val env = E.pushType (false, tf, env)
         val env = E.reduceToFunction env
         (*val _ = TextIO.print ("**** after func reduce:\n" ^ E.toString env ^ "\n")*)
      in
         env
      end
     | infExp (st,env) (AST.UPDATEexp fs) =
      let
         val fieldsVar = VAR (TVar.freshTVar (), BD.freshBVar ())
         val env = E.pushType (false, fieldsVar, env)
         fun pushInpField ((fid,e), (nts, env)) =
            let
               val env = E.pushTop env
               val bVar = BD.freshBVar ()
            in
               ((bVar, fid) :: nts, env)
            end
         val (nts, env) = List.foldl pushInpField ([], env) fs
         val env = E.reduceToRecord (nts, env)

         val env = E.pushType (false, fieldsVar, env)
         fun pushOutField ((fid,e), (nts, env)) =
            let
               val env = infExp (st,env) e
               val bVar = BD.freshBVar ()
               val env = E.meetBoolean (BD.meetVarOne bVar, env)
            in
               ((bVar, fid) :: nts, env)
            end
         val (nts, env) = List.foldl pushOutField ([], env) fs
         val env = E.reduceToRecord (nts, env)
         val env = E.reduceToFunction env
      in
         env
      end
     | infExp stenv (AST.LITexp lit) = infLit stenv lit
     | infExp stenv (AST.SEQexp l) = infSeqexp stenv l
     | infExp (st,env) (AST.IDexp v) =
      let
         val env = E.pushSymbol (v, getSpan st, env)
         (*val _ = TextIO.print ("**** after pushing symbol " ^ SymbolTable.getString(!SymbolTables.varTable, v) ^ ":\n" ^ E.toString env)*)
      in
         env
      end
     | infExp (st,env) (AST.CONexp c) =
      let
         val dcon = SymMap.lookup (conParents, c)
         val { tdVars = vs, tdCons = cs } = SymMap.lookup (typeDefs, dcon)
         val tArgOpt = SymMap.lookup (cs, c)
      in
         case tArgOpt of
              NONE => E.pushType (true, ALG (dcon, List.map VAR vs), env)
            | SOME t =>
               E.pushType (true, FUN (t,ALG (dcon, List.map VAR vs)), env)
      end
     | infExp (st,env) (AST.FNexp (v, e)) =
         E.reduceToFunction (infExp (st, E.pushLambdaVar (v,env)) e)
   and infSeqexp stenv [] = raise
         (S.UnificationFailure "last statement in a sequence may not bind a variable")
     | infSeqexp stenv (AST.MARKseqexp m :: l) =
         reportError (fn stenv => fn e => infSeqexp stenv (e :: l)) stenv m
     | infSeqexp (st,env) (AST.ACTIONseqexp e :: l) =
      let
         (*val _ = TextIO.print ("****before monad:\n" ^ E.topToString env)*)
         val var = VAR (TVar.freshTVar (), BD.freshBVar ())
         val envMon = E.pushType (false, MONAD var, env)
         (*val _ = TextIO.print ("**** monad pattern:\n" ^ E.topToString envMon)*)
         val envExp = infExp (st,env) e
         (*val _ = TextIO.print ("**** monad expression:\n" ^ E.topToString envExp)*)
         val (envMon, envExp) = E.meet (envMon, envExp)
         val _ = E.genFlow (envMon, envExp)
      in
         if List.null l then envMon else infSeqexp (st, E.popKappa envMon) l
      end
     | infSeqexp (st,env) (AST.BINDseqexp (v,e) :: l) =
      let
         val (t,env) = E.pushLambdaVar' (v, env)
         val envMon = E.pushType (false, MONAD t, env)
         val envExp = infExp (st,env) e
         val (envMon, envExp) = E.meet (envMon, envExp)
         val _ = E.genFlow (envMon, envExp)
         val env = E.popKappa envMon
         val env = infSeqexp (st, env) l
         val env = E.return (1, env)
      in
         env
      end
   and infDecodepat sym stenv (AST.MARKdecodepat m) =
               reportError (infDecodepat sym) stenv m
      | infDecodepat sym (st, env) (AST.TOKENdecodepat t) =
         let
            val envGra = E.pushWidth (granularitySymId, env)
            val envDec = E.pushWidth (sym, env)
            val (env, _) = E.meet (envGra, envDec)
            val env = E.popKappa env
         in
            infTokpat (st, env) t
         end
     | infDecodepat sym (st,env) (AST.BITdecodepat l) =
      let
         val envGra = E.pushWidth (granularitySymId, env)
         (*val _ = TextIO.print ("**** decpat pushing granularity:\n" ^ E.topToString envGra)*)
         val envPat = List.foldl (fn (b,env) => infBitpatSize (st,env) b)
                                 env l
         (*val _ = TextIO.print ("**** decpat pushing sizes:\n" ^ E.topToString envPat)*)
         val envPat = E.reduceToSum (List.length l,envPat)
         (*val _ = TextIO.print ("**** decpat sum:\n" ^ E.topToString envPat)*)
         val (env, _) = E.meet (envGra, envPat)
         val env = E.popKappa env
      in
         List.foldl (fn (b,(n,env)) => case infBitpat (st,env) b of
                        (nArgs, env) => (n+nArgs, env)) (0, env) l
      end
   and infBitpatSize stenv (AST.MARKbitpat m) =
         reportError infBitpatSize stenv m
     | infBitpatSize (st,env) (AST.BITSTRbitpat str) =
         E.pushType (false, CONST (IntInf.fromInt (String.size str)), env)
     | infBitpatSize (st,env) (AST.NAMEDbitpat v) = E.pushWidth (v,env)
     | infBitpatSize (st,env) (AST.BITVECbitpat (var,size)) =
         E.pushType (false, CONST size, env)
   and infBitpat stenv (AST.MARKbitpat m) = reportError infBitpat stenv m
     | infBitpat (st,env) (AST.BITSTRbitpat str) = (0,env)
     | infBitpat (st,env) (AST.NAMEDbitpat v) =
         (1, E.pushSymbol (v, getSpan st, env))
     | infBitpat (st,env) (AST.BITVECbitpat (v,s)) = (1, E.pushLambdaVar (v,env))
   and infTokpat stenv (AST.MARKtokpat m) = reportError infTokpat stenv m
     | infTokpat (st,env) (AST.TOKtokpat i) = (0, env)
     | infTokpat (st,env) (AST.NAMEDtokpat v) = (1, E.pushLambdaVar (v,env))
   and infMatch (st,env) (p,e) =
      let
         val (n,env) = infPat (st,env) p
         (*val _ = TextIO.print ("**** after pat:\n" ^ E.toString env)*)
         val envScru = E.popKappa env
         val envScru = E.pushSymbol (caseExpSymId, SymbolTable.noSpan, envScru)
         (*val _ = TextIO.print ("**** after case dup:\n" ^ E.toString envScru)*)
         val (envScru, env) = E.meet (envScru, env)
         val _ = E.genFlow (envScru, env)
         (*val _ = TextIO.print ("**** after mgu:\n" ^ E.toString env)*)
         val env = E.popKappa env
         val env = infExp (st,env) e
         (*val _ = TextIO.print ("**** after expr:\n" ^ E.toString env)*)
      in
         E.return (n,env)
      end

   and infPat stenv (AST.MARKpat m) = reportError infPat stenv m
     | infPat (st,env) (AST.LITpat lit) = (0, infLit (st,env) lit)
     | infPat (st,env) (AST.IDpat v) =
      let
         val (t, env) = E.pushLambdaVar' (v,env)
      in
         (1, E.pushType (false, t, env))
      end
     | infPat (st,env) (AST.CONpat (c, SOME p)) =
      let
         val (n,envPat) = infPat (st,env) p
         val envPat = E.pushTop envPat
         val envCon = infExp (st,env) (AST.CONexp c)
         (*val _ = TextIO.print ("+++++ meet for constructor")*)
         val (env, _) = E.meet (envPat,envCon)
         val env = E.reduceToResult env
      in
         (n, env)
      end
     | infPat (st,env) (AST.CONpat (c, NONE)) =
         (0, infExp (st,env) (AST.CONexp c))
     | infPat (st,env) (AST.WILDpat) = (0, E.pushTop env)
   and infLit (st,env) (AST.INTlit i) = E.pushType (false, ZENO, env)
     | infLit (st,env) (AST.FLTlit f) = E.pushType (false, FLOAT, env)
     | infLit (st,env) (AST.STRlit str) = E.pushType (false, UNIT, env)
     | infLit (st,env) (AST.VEClit str) =
         E.pushType (false, VEC (CONST (IntInf.fromInt (String.size str))), env)

   val primEnv = E.primitiveEnvironment (Primitives.getSymbolTypes ())
   val toplevelEnv = E.pushGroup
      (List.concat
         (List.map topDecl (#tree (ast : SpecAbstractTree.specification)))
      , primEnv)
   (*val _ = TextIO.print ("toplevel environment:\n" ^ E.toString toplevelEnv)*)
   val (unstable, toplevelEnv) = List.foldl (fn (d,(unstable, env)) =>
            case infDecl ({span = SymbolTable.noSpan, error = false},env) d of
               (newUnstable, env) =>
                  (E.SymbolSet.union (newUnstable, unstable), env)
         ) (E.SymbolSet.empty, toplevelEnv)
         (#tree (ast : SpecAbstractTree.specification))
   val toplevelEnv = calcFixpoint (unstable, toplevelEnv)
   val (toplevelSymbols, primEnv) = E.popGroup toplevelEnv
   val (primSymbols, _) = E.popGroup primEnv
   in
      ( sm := List.foldl SMap.insert' (!sm) (toplevelSymbols @ primSymbols)
      ; SMap.listItemsi (!sm))
   end

   val typeInferencePass =
      BasicControl.mkTracePassSimple
         {passName="typeInferencePass",
          pass=typeInferencePass}

   fun run (ti,spec) = let
      open CompilationMonad
   in
      getErrorStream >>= (fn errs =>
      return (typeInferencePass (errs, ti, spec)
         handle TypeError => []
         )
      )
   end
   
   val showTable = (fn (str,_) => str) o List.foldl (fn ((sym,st), (str,si)) =>
         let
            val sStr = SymbolTable.getString(!SymbolTables.varTable, sym)
         in
            case st of
                 E.VALUE {symType = t} =>
                  let
                     val (tStr, si) = showTypeSI (t,si)
                  in
                     (sStr ^ " : " ^ tStr ^ "\n" ^ str, si)
                  end
               | E.DECODE {symType = t, width = w} =>
                  let
                     val (tStr, si) = showTypeSI (t,si)
                     val (wStr, si) = showTypeSI (w,si)
                  in
                     (sStr ^ " : " ^ tStr ^ ", width = " ^
                      wStr ^ "\n" ^ str, si)
                  end
         end
      ) ("",TVar.emptyShowInfo)

end
