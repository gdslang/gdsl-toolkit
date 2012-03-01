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
   
   fun reportError conv ({span = _, error = isErr }, env) {span=s, tree=t} =
      conv ({span = s, error = isErr},env) t
      handle (UnificationFailure str) =>
         (Error.errorAt (errStrm, s, [str]); raise TypeError)
   fun getSpan {span = s, error = _} = s
   
   val anonSym = VarInfo.lookup
        (!SymbolTables.varTable, Atom.atom Primitives.anonDecodeFunction)     

   (* define a first traversal that creates a group of all top-level decls *)
   fun topDecl (AST.MARKdecl {span, tree=t}) = topDecl t
     | topDecl (AST.DECODEdecl dd) = topDecodedecl dd
     | topDecl (AST.VALUEdecl vd) = topValuedecl vd
     | topDecl _ = []
   and topDecodedecl (AST.MARKdecodedecl {span, tree=t}) = topDecodedecl t
     | topDecodedecl (AST.NAMEDdecodedecl (v,_,_)) = [(v, true)]
     | topDecodedecl (AST.DECODEdecodedecl (pats,_)) = [(anonSym, true)]
     | topDecodedecl (AST.GUARDEDdecodedecl (pats,_)) = [(anonSym, true)]
   and topValuedecl (AST.MARKvaluedecl {span, tree = t}) = topValuedecl t
     | topValuedecl (AST.LETvaluedecl (v,_,_)) = [(v,false)]
     | topValuedecl (AST.LETRECvaluedecl (v,_,_)) = [(v,false)]
   
   (* define a second traversal that is a full inference of the tree *)
   
   (*local helper function to infer types for a binding group*)
   fun calcFixpoint (st,env) (sym, dec, args, rhs) =
      let
         val _ = TextIO.print ("checking binding " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")
         val env = List.foldl E.pushLambdaVar env args
         val env = infExp (st,env) rhs
         val env = List.foldr (fn (_,env) => E.reduceToFunction env) env args
         (*val _ = TextIO.print ("after popping args:\n" ^ E.topToString env)*)
         val env = E.popToFunction (sym, env)
         (*val _ = TextIO.print ("after popping fun:\n" ^ E.topToString env)*)
         val stable = true
      in
         if stable then env else calcFixpoint (st, env) (sym, dec, args, rhs)
      end
         handle TypeError => E.popToFunction (sym, (E.pushTop env))

   and infDecl stenv (AST.MARKdecl m) = reportError infDecl stenv m
     (*| infDecl env (AST.STATEdecl l) = AST.STATEdecl
       (List.map (fn (v,t,e) => (newVar (s,v), infTy env t, infExp env e)) l)*)
     | infDecl stenv (AST.DECODEdecl dd) = infDecodedecl stenv dd
     | infDecl stenv (AST.VALUEdecl vd) = infValuedecl stenv vd
     | infDecl (st,env) _ = env
   and infDecodedecl stenv (AST.MARKdecodedecl m) =
         reportError infDecodedecl stenv m
     | infDecodedecl stenv (AST.NAMEDdecodedecl (v, l, e)) =
        calcFixpoint stenv (v, SOME (l, NONE), [], e)
     | infDecodedecl stenv (AST.DECODEdecodedecl (l,e)) =
        calcFixpoint stenv (anonSym, SOME (l, NONE), [], e)
     | infDecodedecl (st,env) (AST.GUARDEDdecodedecl (l, el)) =
         List.foldl (fn ((guard, rhs), env) =>
            calcFixpoint (st,env) (anonSym, SOME (l, SOME guard), [], rhs))
            env el
   and infValuedecl stenv (AST.MARKvaluedecl m) =
         reportError infValuedecl stenv m
     | infValuedecl stenv (AST.LETvaluedecl (v,l,e)) =
         calcFixpoint stenv (v, NONE, l, e)
     | infValuedecl stenv (AST.LETRECvaluedecl (v,l,e)) =
         calcFixpoint stenv (v, NONE, l, e)
   and infExp stenv (AST.MARKexp m) = reportError infExp stenv m
     | infExp (st,env) (AST.LETexp (l,e)) =
      let                                              
         val names = List.map topValuedecl l
         val env = E.pushGroup (List.foldl (op @) [] names, env)
         val env = List.foldl (fn (d,env) => infValuedecl (st,env) d) env l
         val (symbols, env) = E.popGroup env
      in
         (sm := List.foldl SMap.insert' (!sm) symbols
         ;infExp (st,env) e)
      end
     | infExp (st,env) (AST.IFexp (e1,e2,e3)) =
      let
         val envWant = E.pushType (false, VEC (CONST 1), env)
         val envHave = infExp (st,env) e1
         val env = E.meet (envWant, envHave)
         val env = E.popKappa env
         val envT = infExp (st,env) e2
         val envE = infExp (st,env) e3
         val env = E.meet (envT,envE)
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
         val env = E.meet (envExp, envVar)
         val env = E.popKappa env
         val envs = List.map (infMatch (st,env)) l
         val (env1::env2::_) = envs
         val envNeutral = E.pushTop env
         val env = List.foldl E.meet envNeutral envs
         (*val _ = TextIO.print ("**** all envs:\n" ^ E.toString env)*)
      in
         E.return (1,env)
      end
(*     | infExp (st,env) (AST.ANDALSOexp (e1,e2)) = AST.ANDALSOexp
         (infExp (st,env) e1, infExp (st,env) e2)
     | infExp (st,env) (AST.ORELSEexp (e1,e2)) = AST.ORELSEexp
         (infExp (st,env) e1, infExp (st,env) e2)*)
     | infExp stenv (AST.BINARYexp (e1, opid,e2)) =
         infExp stenv (AST.APPLYexp (AST.APPLYexp (AST.IDexp opid, e1), e2))
     | infExp (st,env) (AST.APPLYexp (e1,e2)) =
      let
         val envFun = infExp (st,env) e1
         (*val _ = TextIO.print ("**** app func:\n" ^ E.toString envFun)*)
         val envArg = infExp (st,env) e2
         (*val _ = TextIO.print ("**** app arg:\n" ^ E.toString envArg)*)
         val envArg = E.pushTop envArg
         val envArg = E.reduceToFunction envArg
         (*val _ = TextIO.print ("**** app turning arg:\n" ^ E.toString envArg)*)
         val env = E.meet (envFun, envArg)
         val env = E.reduceToResult env
         (*val _ = TextIO.print ("**** app result:\n" ^ E.toString env)*)
      in
         env
      end
        
     | infExp (st,env) (AST.RECORDexp l) =
      let
         val (scs,bFun) = env
         val bVar = BD.freshBVar ()
         val bFun = BD.meetVarZero (bVar, bFun)
         val t = VAR (TVar.freshTVar (), bVar)
         val env = E.pushType (false, t, (scs,bFun))
         fun pushField ((fid,e), (nts, env)) =
            let
               val (scs,bFun) = infExp (st,env) e
               val bVar = BD.freshBVar ()
               val bFun = BD.meetVarOne (bVar, bFun)
            in
               ((bVar, fid) :: nts, (scs, bFun))
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
         val _ = TextIO.print ("**** before rec reduce:\n" ^ E.toString env ^ "\n")
         val (scs, bFun) = E.reduceToRecord ([(exists, f)], env)
         val env = (scs, BD.meetVarOne (exists, bFun))
         val _ = TextIO.print ("**** after rec reduce:\n" ^ E.toString env ^ "\n")
         val env = E.pushType (false, tf, env)
         val env = E.reduceToFunction env
         val _ = TextIO.print ("**** after func reduce:\n" ^ E.toString env ^ "\n")
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
               val (scs,bFun) = infExp (st,env) e
               val bVar = BD.freshBVar ()
               val bFun = BD.meetVarOne (bVar, bFun)
            in
               ((bVar, fid) :: nts, (scs, bFun))
            end
         val (nts, env) = List.foldl pushOutField ([], env) fs
         val env = E.reduceToRecord (nts, env)
         val env = E.reduceToFunction env
      in
         env
      end
     | infExp (st,env) (AST.LITexp lit) = infLit (st,env) lit
     (*| infExp (st,env) (AST.SEQexp l) = AST.SEQexp (infSeqexp (st,env) l)*)
     | infExp (st,env) (AST.IDexp v) = E.pushSymbol (v, getSpan st, env)
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
(*   and infSeqexp stenv [] = []
     | infSeqexp _ (AST.MARKseqexp { tree = ast, span = stenv } :: l) =
        infSeqexp stenv (ast :: l)
     | infSeqexp stenv (AST.ACTIONseqexp e :: l) =
        AST.ACTIONseqexp (infExp stenv e) :: infSeqexp stenv l
     | infSeqexp stenv (AST.BINDseqexp (v,e) :: l) = let
           val rhstenv = infExp stenv e
           val _ = startScope ()
           val lhstenv = newVar (s,v)
           val rem = infSeqexp stenv l
           val _ = endScope ()
        in
           AST.BINDseqexp (lhs, rhs) :: rem
        end
   and infDecodepat stenv (AST.MARKdecodepat m) =
       AST.MARKdecodepat (reportError infDecodepat m)
     | infDecodepat stenv (AST.TOKENdecodepat t) =
       AST.TOKENdecodepat (infTokpat stenv t)
     | infDecodepat stenv (AST.BITdecodepat l) =
       AST.BITdecodepat (List.map (infBitpat s) l)
   and infBitpat stenv (AST.MARKbitpat m) =
       AST.MARKbitpat (reportError infBitpat m)
     | infBitpat stenv (AST.BITSTRbitpat str) = AST.BITSTRbitpat str
     | infBitpat stenv (AST.NAMEDbitpat v) = AST.NAMEDbitpat (useVar (s,v))
     | infBitpat stenv (AST.BITVECbitpat (var,size)) = AST.BITVECbitpat
       (newVar (s,var), size)
   and infTokpat stenv (AST.MARKtokpat m) =
       AST.MARKtokpat (reportError infTokpat m)
     | infTokpat stenv (AST.TOKtokpat i) = AST.TOKtokpat i
     | infTokpat stenv (AST.NAMEDtokpat v) = AST.NAMEDtokpat (useVar (s,v))*)
   and infMatch stenv (AST.MARKmatch m) = reportError infMatch stenv m
     | infMatch (st,env) (AST.CASEmatch (p,e)) =
      let
         val (n,env) = infPat (st,env) p
         (*val _ = TextIO.print ("**** after pat:\n" ^ E.toString env)*)
         val envScru = E.popKappa env
         val envScru = E.pushSymbol (caseExpSymId, SymbolTable.noSpan, envScru)
         (*val _ = TextIO.print ("**** after case dup:\n" ^ E.toString envScru)*)
         val env = E.meet (env, envScru)
         (*val _ = TextIO.print ("**** after mgu:\n" ^ E.toString env)*)
         val env = E.popKappa env
         val env = infExp (st,env) e
         (*val _ = TextIO.print ("**** after expr:\n" ^ E.toString env)*)
      in
         E.return (n,env)
      end
   and infPat stenv (AST.MARKpat m) = reportError infPat stenv m
     | infPat (st,env) (AST.BITpat str) =
         (0, E.pushType (false, VEC (CONST (IntInf.fromInt (String.size str))), env))
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
         val env = E.meet (envPat,envCon)
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

   val primEnv = E.primitiveEnvironment (Primitives.getSymbolTypes ())
   val toplevelEnv = E.pushGroup
      (List.foldl (op @) []
         (List.map topDecl (#tree (ast : SpecAbstractTree.specification)))
      , primEnv)
   (*val _ = TextIO.print ("toplevel environment:\n" ^ E.toString toplevelEnv)*)
   val toplevelEnv = List.foldl (fn (d,env) =>
         infDecl ({span = SymbolTable.noSpan, error = false},env) d
         ) toplevelEnv (#tree (ast : SpecAbstractTree.specification))
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
      return (typeInferencePass (errs, ti, spec)))
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
