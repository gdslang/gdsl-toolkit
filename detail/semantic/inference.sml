(**
 * ## Perform Type Inference
 *
 * Returns tables with types of each identifier.
 *)
structure TypeInference : sig

   type symbol_types = (SymbolTable.symid * Environment.symbol_type) list
       
   val getBitpatLitLength : SpecAbstractTree.bitpat_lit -> int

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
   structure PP = SpecAbstractTree.PP
   
   type symbol_types = (SymbolTable.symid * E.symbol_type) list

   open Types

   exception TypeError

   infix >>= >>
   
   type rhsInfo = (SymbolTable.symid *
                   (*pattern and guard for decode function*)
                   (AST.decodepat list * AST.exp option) option *
                   AST.var_bind list *       (*arguments*)
                   AST.exp)

   fun showProg (max,pp,p) =
      let
         val str = Layout.tostring (pp p)
         val str = String.translate
                     (fn c => case c of #"\n" => " " | _ => Char.toString c)
                     str
         val len = String.size str
         fun rep n = if n>0 then " " ^ rep (n-1) else ""
      in
         if len<=max then str ^ rep (max-len) else
         String.substring (str,0,max-3) ^ "..."
      end

   fun refineError (str, msg, env1, str1, env2, str2) =
      let
         val (eStr1, si) = E.kappaToStringSI (env1, TVar.emptyShowInfo)
         val (eStr2, si) = E.kappaToStringSI (env2, si)
      in
         raise S.UnificationFailure
          (str ^ msg ^
           "\n\t" ^ str1 ^ ": " ^ eStr1 ^
           "\n\t" ^ str2 ^ ": " ^ eStr2)
      end

   fun getBitpatLitLength bp =
      let
         val fields = String.fields (fn c => c= #"|") bp
         fun checkWidth (f,width) =
            if String.size f <> width then
                  raise S.UnificationFailure "bit literals have different lengths"
            else width
      in
         case fields of
            [] => 0
          | (f::fs) => List.foldl checkWidth (String.size f) fs
      end
         
fun typeInferencePass (errStrm, ti : TI.type_info, ast) = let
   val sm = ref ([] : symbol_types)
   val { tsynDefs, typeDefs, conParents} = ti
   val caseExpSymId = SymbolTable.lookup(!SymbolTables.varTable,
                                         Atom.atom Primitives.caseExpression)
   (*val stateSymId = SymbolTable.lookup(!SymbolTables.varTable,
                                       Atom.atom Primitives.globalState)*)
   val granularitySymId = SymbolTable.lookup(!SymbolTables.varTable,
                                             Atom.atom Primitives.granularity)
   
   val bindSymId = SymbolTable.lookup(!SymbolTables.varTable, Atom.atom ">>")
   val bindASymId = SymbolTable.lookup(!SymbolTables.varTable, Atom.atom ">>=")

   fun reportError conv ({span = _}, env) {span=s as (p,_), tree=t} =
      conv ({span = s},env) t
      handle (S.UnificationFailure str) =>
         (Error.errorAt (errStrm, s, [str]); raise TypeError)
   val reportBadSizes = List.app (fn (s,str) => Error.errorAt (errStrm, s, [str]))
   fun getSpan {span = s} = s

   (* define a first traversal that creates a group of all top-level decls *)
   fun topDecl (AST.MARKdecl {span, tree=t}) = topDecl t
     | topDecl (AST.DECODEdecl dd) = topDecodeDecl dd
     | topDecl (AST.LETRECdecl vd) = topLetrecDecl vd
     | topDecl _ = []

   and topDecodeDecl (v, _, _, _) = [(v, true)]

   and topLetrecDecl (v, _, _) = [(v,false)]
   
   (* define a second traversal that is a full inference of the tree *)
   
   (*local helper function to infer types for a binding group*)
   val maxIter = 1
   fun checkUsages printWarn (sym, env) =
      let
         (*val _ = TextIO.print ("***** usages of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")*)
         fun checkUsage (s, (unstable, env)) =
            let
               val fs = E.getContextOfUsage (sym, s, env)
               val env = List.foldl E.pushFunction env fs
               
               val envFun = E.pushSymbol (sym, s, env)
               (*val _ = TextIO.print ("pushed instance " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " symbol:\n" ^ E.topToString envFun)*)
               val envCall = E.pushUsage (sym, s, !sm, env)
               (*val _ = TextIO.print ("pushed usage:\n" ^ E.topToString envCall)*)
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
                     "\n\tcall provides type  " ^ sCall,
                     "\n\tdefinition has type " ^ sFun]))
                  end
               (*warn about refinement of definition due to a call site*)
               fun raiseWarning (substs, syms) =
                  if E.SymbolSet.isEmpty syms orelse not printWarn then ()
                  else
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
                     "\n\tfor " ^ symsStr]))
                  end
               val (substs, env) = (E.subseteq (envCall, envFun),
                                         E.meetFlow (envCall, envFun))
                  handle (S.UnificationFailure str) =>
                     (raiseError str; (S.emptySubsts, envCall))
               val (changed, env) = E.popToUsage (sym, s, env)
               val _ = sm := List.foldl
                     (fn (sym,sm) => (sym, E.getFunctionInfo (sym, env)) ::
                        List.filter (fn (s,_) =>
                           not (SymbolTable.eq_symid(s,sym))) sm)
                     (!sm) changed
               val affectedSyms = E.affectedFunctions (substs,env)
               val _ = raiseWarning (substs, affectedSyms)
            in
               (E.SymbolSet.union (unstable, affectedSyms), env)
            end
      in
         List.foldl checkUsage (E.SymbolSet.empty, env) (E.getUsages (sym, env))
      end

   fun checkCallSites printWarn (syms, env) =
      List.foldl (fn (sym, (unstable, env)) =>
                  case checkUsages printWarn (sym, env) of
                     (newUnstable, env) =>
                        (E.SymbolSet.union (unstable,newUnstable), env)
                  ) (E.SymbolSet.empty, env) (E.SymbolSet.listItems syms)

   fun calcFixpoint curIter (syms, env) =
         if E.SymbolSet.isEmpty syms then env else
         if curIter<maxIter then
            calcFixpoint (curIter+1)
               (checkCallSites (curIter=maxIter) (syms, env))
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
            "\n\tpass --inference-iterations=",
            Int.toString (maxIter+1),
            " to try a little harder"]); env)
         end
   val calcFixpoint = calcFixpoint 0
   
   fun infRhs (st,env) (sym, dec, guard, args, rhs) =
      let
         (*val _ = TextIO.print ("checking binding " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")*)
         fun checkGuard (g,env) =
            let
               val stateVar = VAR (freshTVar (), BD.freshBVar ())
               val monadType = MONAD (VEC (CONST 1), stateVar, stateVar)
               val envRef = E.pushType (false, monadType, env)
               val envGua = infExp (st, env) g
               val env = E.meet (envRef, envGua)
            handle S.UnificationFailure str =>
               refineError (str,
                            " when checking guards",
                            envRef, "required guard type        ",
                            envGua, "guard " ^ showProg (20, PP.exp, g))
            in
               E.popKappa env
            end
         val env = case guard of SOME g => checkGuard (g,env)
                               | NONE => env
         fun pushDecoderBindings(d,(n, env)) =
            case infDecodepat sym (st,env) d of (nArgs, env) => (n+nArgs, env)
         val (n,env) = List.foldl pushDecoderBindings (0,env) dec
         val env = List.foldl E.pushLambdaVar env args
         val env = infExp (st,env) rhs
         val env = List.foldr (fn (_,env) => E.reduceToFunction env) env args
         val env = E.return (n,env)
         (*val _ = TextIO.print ("after popping args:\n" ^ E.topToString env)*)
      in
         env
      end
   and infBinding (st,env) (sym, dec, guard, args, rhs) =
      let
         val env = E.pushFunction (sym,env)
         val env = infRhs (st,env) (sym, dec, guard, args, rhs)
         val env = E.popToFunction (sym, env)
         val fInfo = E.getFunctionInfo (sym, env)
         val _ = sm := (sym, fInfo) :: !sm
         val env = checkUsages false (sym, env)
      in
         env
      end

   and infDecl stenv (AST.MARKdecl m) = reportError infDecl stenv m
     | infDecl (st,env) (AST.GRANULARITYdecl w) =
      let
         val envGra = E.pushWidth (granularitySymId, env)
         val envInt = E.pushType (false, CONST (IntInf.toInt w), env)
         val env = E.meet (envGra, envInt)
         val env = E.popKappa env
      in
         (E.SymbolSet.empty, env)
      end
     (*| infDecl (st,env) (AST.STATEdecl l) =
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
         val env = E.meet (envState, env)
         val env = E.clearFunction (stateSymId, env)
         val env = E.popToFunction (stateSymId, env)
      in
         checkUsages false (stateSymId, env)
      end*)
     | infDecl stenv (AST.DECODEdecl dd) = infDecodedecl stenv dd
     | infDecl (st,env) (AST.LETRECdecl (v,l,e)) =
         infBinding (st,env) (v, [], NONE, l, e)
     | infDecl (st,env) _ = (E.SymbolSet.empty, env)

   and infDecodedecl (st,env) (v, l, _, Sum.INL e) =
      let
         val env = E.pushFunctionOrTop (v,env)
         val envRhs = E.popKappa env
         val envRhs = infRhs (st,envRhs) (v, l, NONE, [], e)
         (*val _ = TextIO.print ("**** decoder type:\n" ^ E.topToString env)
         val _ = TextIO.print ("**** decoder rhs:\n" ^ E.topToString envRhs)*)
         val env = E.meet (env, envRhs)
         val env = E.popToFunction (v, env)
         val fInfo = E.getFunctionInfo (v, env)
         val _ = sm := (v, fInfo) :: List.filter (fn (s,_) =>
                                       not (SymbolTable.eq_symid(s,v))) (!sm)
      in
         checkUsages false (v,env)
      end
     | infDecodedecl (st,env) (v, l, _, Sum.INR el) =
      let
         val env = E.pushFunctionOrTop (v,env)
         val env = List.foldl
            (fn ((guard, rhs), env) => let
               val envRhs = E.popKappa env
               val envRhs = infRhs (st,envRhs) (v, l, SOME guard, [], rhs)
               val env = E.meet (env, envRhs)
            in
               env
            end) env el
         val env = E.popToFunction (v, env)
         val fInfo = E.getFunctionInfo (v, env)
         val _ = sm := (v, fInfo) :: List.filter (fn (s,_) =>
                                       not (SymbolTable.eq_symid(s,v))) (!sm)
      in
         checkUsages false (v,env)
      end

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
         val (badSizes, env) = E.popGroup (env, true)
         val _ = reportBadSizes badSizes
      in
         env
      end
     | infExp (st,env) (AST.IFexp (e1,e2,e3)) =
      let
         val envWant = E.pushType (false, VEC (CONST 1), env)
         val envHave = infExp (st,env) e1
         val env = E.meet (envWant, envHave)
         val env = E.popKappa env
         val envT = infExp (st,env) e2
         (*val _ = TextIO.print ("**** after if-then:\n" ^ E.topToString envT)*)
         val envE = infExp (st,env) e3
         (*val _ = TextIO.print ("**** after if-else:\n" ^ E.topToString envE)*)
         val env = E.meet (envE,envT)
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
         val env = E.meetFlow (envVar, envExp)
         val env = E.popKappa env
         val envNeutral = E.pushTop env
         fun genFlow ((p,exp), nEnv) =
            let
               val expEnv = infMatch (st,E.popKappa nEnv) (p,exp)
               val env = E.meetFlow (nEnv, expEnv)
                  handle S.UnificationFailure str =>
                     refineError (str,
                                  " while checking right-hand-side of branches",
                                  nEnv, "branches so far               ",
                                  expEnv, showProg (30, PP.exp, exp))
            in
               env
            end
         val env = List.foldl genFlow envNeutral l
         (*val _ = TextIO.print ("**** all envs:\n" ^ E.toString env)*)
      in
         E.return (1,env)
      end
     | infExp stenv (AST.BINARYexp (e1, binop, e2)) =
      let
         fun infixToExp (AST.MARKinfixop {tree = t, span = s}) =
               AST.MARKexp ({tree = infixToExp t, span = s})
           | infixToExp (AST.OPinfixop opid) = AST.IDexp opid
      in
         infExp stenv (AST.APPLYexp (AST.APPLYexp (infixToExp binop, e1), e2))
      end
     | infExp (st,env) (AST.APPLYexp (e1,e2)) =
      let                                      
         val envFun = infExp (st,env) e1
         val envArg = infExp (st,env) e2
         (*val _ = TextIO.print ("**** app func:\n" ^ E.topToString envFun)*)
         (*val _ = TextIO.print ("**** app arg:\n" ^ E.topToString envArg)*)
         val envArgRes = E.pushTop envArg
         val envArgRes = E.reduceToFunction envArgRes
         (*val _ = TextIO.print ("**** app turning arg:\n" ^ E.topToString envArgRes)*)
         (* make the result of the call-site depend on the result of the
         function; the flow expressing that formal parameters depend on actual
         parameters follows from contra-variance*)
         val env = E.meetFlow (envArgRes, envFun)
            handle S.UnificationFailure str =>
               refineError (str,
                            " while passing",
                            envArg, "argument    " ^ showProg (20, PP.exp, e2),
                            envFun, "to function " ^ showProg (20, PP.exp, e1))
         (*val _ = TextIO.print ("**** app fun,res unified:\n" ^ E.topToString env)*)
         val env = E.reduceToResult env
      in
         env                                                         
      end
        
     | infExp (st,env) (AST.RECORDexp l) =
      let
         val t = freshVar ()
         val env = E.meetBoolean (BD.meetVarZero (bvar t), env)
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
         (*val _ = TextIO.print ("**** rec exp, single fields:\n" ^ E.toString env ^ "\n")*)
         val env = E.reduceToRecord (nts, env)
         (*val _ = TextIO.print ("**** rec exp, combined:\n" ^ E.toString env ^ "\n")*)
      in
         env
      end
         
     | infExp (st,env) (AST.SELECTexp f) =
      let
         val env = E.pushTop env
         val tf = freshVar ()
         val tf' = newFlow tf
         val env = E.pushType (false, tf, env)
         val exists = BD.freshBVar ()
         (*val _ = TextIO.print ("**** before rec reduce:\n" ^ E.toString env ^ "\n")*)
         val env = E.reduceToRecord ([(exists, f)], env)
         val env = E.meetBoolean (BD.meetVarImpliesVar (bvar tf', bvar tf) o
                                  BD.meetVarOne exists, env)
         (*val _ = TextIO.print ("**** after rec reduce:\n" ^ E.toString env ^ "\n")*)
         val env = E.pushType (false, tf', env)
         val env = E.reduceToFunction env
         val _ = TextIO.print ("**** rec selector:\n" ^ E.topToString env ^ "\n")
      in
         env
      end
     | infExp (st,env) (AST.UPDATEexp fs) =
      let
         val fieldsVar = freshVar ()
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

         val fieldsVar' = newFlow fieldsVar
         val env = E.meetBoolean (BD.meetVarImpliesVar (bvar fieldsVar', bvar fieldsVar), env)
         val env = E.pushType (false, fieldsVar', env)
         fun pushOutField ((fid,e), (nts, env)) =
            let
               (*val _ = TextIO.print ("**** rec update: pushing field " ^ SymbolTable.getString(!SymbolTables.fieldTable, fid) ^ ".\n")*)
               val env = infExp (st,env) e
               val bVar = BD.freshBVar ()
               val env = E.meetBoolean (BD.meetVarOne bVar, env)
            in
               ((bVar, fid) :: nts, env)
            end
         val (nts, env) = List.foldl pushOutField ([], env) fs
         val env = E.reduceToRecord (nts, env)
         val env = E.reduceToFunction env
         (*val _ = TextIO.print ("**** rec update: function is:\n" ^ E.topToString env ^ "\n")*)
      in
         env
      end
     | infExp stenv (AST.LITexp lit) = infLit stenv lit
     | infExp stenv (AST.SEQexp l) = infSeqexp stenv l
     | infExp (st,env) (AST.IDexp v) =
      let
         val env = E.pushSymbol (v, getSpan st, env)
         (*val _ = TextIO.print ("**** after pushing symbol " ^ SymbolTable.getString(!SymbolTables.varTable, v) ^ ":\n" ^ E.topToString env)*)
      in
         env
      end
     | infExp (st,env) (AST.CONexp c) =
      let
         val dcon = SymMap.lookup (conParents, c)
         val { tdVars = vs, tdCons = cs } = SymMap.lookup (typeDefs, dcon)
         val tArgOpt = SymMap.lookup (cs, c)
         val env =
            case tArgOpt of
                 NONE => E.pushType (true, ALG (dcon, List.map VAR vs), env)
               | SOME t =>
            let
               val (posFlags, negFlags) =
                  fieldBVarsets (t,(BD.emptySet, BD.emptySet))
               val env = E.meetBoolean (BD.meetVarSetOne posFlags o
                                        BD.meetVarSetZero negFlags, env)
               val env = E.pushType (true, FUN (t,ALG (dcon, List.map VAR vs)), env)
            in
               env
            end
         (*val _ = TextIO.print ("**** looking for " ^ SymbolTable.getString(!SymbolTables.conTable, c) ^ ":\n" ^ E.topToString env)*)
      in
         env
      end
     | infExp (st,env) (AST.FNexp (v, e)) =
         E.reduceToFunction (infExp (st, E.pushLambdaVar (v,env)) e)
         
   and infSeqexp stenv [] = raise
         (S.UnificationFailure "last statement in a sequence may not bind a variable")
     | infSeqexp stenv (AST.MARKseqexp m :: l) =
         reportError (fn stenv => fn e => infSeqexp stenv (e :: l)) stenv m
     | infSeqexp (st,env) [AST.ACTIONseqexp e] = infExp (st,env) e
     | infSeqexp (st,env) (s :: l) =
      let
         val (bind, vOpt,e) = case s of
               AST.ACTIONseqexp e => (bindSymId, NONE, e)
             | AST.BINDseqexp (v,e) => (bindASymId, SOME v, e)
             | _ => raise TypeError
         val envFun = E.pushSymbol (bind, getSpan st, env)
         val envArg = infExp (st,env) e
         val envArgRes = E.pushTop envArg
         val envArgRes = E.reduceToFunction envArgRes
         (*val _ = TextIO.print ("function to unify with bind: " ^ E.topToString envArgRes ^ "\n")*)
         val env = E.meetFlow (envArgRes, envFun)
            handle S.UnificationFailure str =>
               raise S.UnificationFailure (str ^ " in statement\n\t" ^
                   showProg (20, PP.exp, e) ^ " : " ^
                   #1 (E.kappaToStringSI (envArg, TVar.emptyShowInfo)))
         val envFun = E.reduceToResult env
         val env = E.popKappa envFun
         val envArg = case vOpt of
                 SOME v => E.reduceToFunction (infSeqexp (st, E.pushLambdaVar (v,env)) l)
               | NONE => infSeqexp (st, env) l
         val envArgRes = E.pushTop envArg
         val envArgRes = E.reduceToFunction envArgRes
         val env = E.meetFlow (envArgRes, envFun)
            handle S.UnificationFailure str =>
               refineError (str,
                            " passing on the result of",
                            envFun, "statement " ^ showProg (20, PP.exp, e),
                            envArg, "to the following statments    ")
         val env = E.reduceToResult env
      in
         env
      end
   and infDecodepat sym stenv (AST.MARKdecodepat m) =
               reportError (infDecodepat sym) stenv m
      | infDecodepat sym (st, env) (AST.TOKENdecodepat t) =
         let
            val envGra = E.pushWidth (granularitySymId, env)
            val envDec = E.pushWidth (sym, env)
            val env = E.meet (envGra, envDec)
            handle S.UnificationFailure str =>
               refineError (str,
                            " when checking decoder",
                            envGra, "granularity                     ",
                            envDec, "token " ^ showProg (20, PP.tokpat, t))
            val env = E.popKappa env
         in
            infTokpat (st, env) t
         end
     | infDecodepat sym (st,env) (AST.BITdecodepat l) =
      let
         val envGra = E.pushWidth (sym, env)
         (*val _ = TextIO.print ("**** decpat pushing granularity:\n" ^ E.topToString envGra)*)
         val envPat = List.foldl (fn (b,env) => infBitpatSize (st,env) b)
                                 env l
         (*val _ = TextIO.print ("**** decpat pushing " ^ Int.toString(List.length l) ^ " sizes:\n" ^ E.topToString envPat)*)
         val envPat = E.reduceToSum (List.length l,envPat)
         (*val _ = TextIO.print ("**** decpat sum:\n" ^ E.topToString envPat)*)
         val env = E.meet (envGra, envPat)
            handle S.UnificationFailure str =>
               refineError (str,
                            " when checking bits in token",
                            envGra, "granularity                     ",
                            envPat, "pattern " ^ showProg (20, PP.decodepat, (AST.BITdecodepat l)))
         val env = E.popKappa env
      in
         List.foldl (fn (b,(n,env)) => case infBitpat (st,env) b of
                        (nArgs, env) => (n+nArgs, env)) (0, env) l
      end
   and infBitpatSize stenv (AST.MARKbitpat m) =
         reportError infBitpatSize stenv m
     | infBitpatSize (st,env) (AST.BITSTRbitpat str) =
         E.pushType (false, CONST (getBitpatLitLength str), env)
     | infBitpatSize (st,env) (AST.NAMEDbitpat v) = E.pushWidth (v,env)
     | infBitpatSize (st,env) (AST.BITVECbitpat (v,s)) =
         E.pushType (false, CONST (IntInf.toInt s), env)
   and infBitpat stenv (AST.MARKbitpat m) = reportError infBitpat stenv m
     | infBitpat (st,env) (AST.BITSTRbitpat str) = (0,env)
     | infBitpat (st,env) (AST.NAMEDbitpat v) =
         (1, E.pushSymbol (v, getSpan st, env))
     | infBitpat (st,env) (AST.BITVECbitpat (v,s)) =
      let
         val env = E.pushLambdaVar (v,env)
         val envVar = E.pushSymbol (v, getSpan st, env)
         val envWidth = E.pushType (false, VEC (CONST (IntInf.toInt s)), env)
         val env = E.meet (envVar, envWidth)
         val env = E.popKappa env
      in
         (1, env)
      end
   and infTokpat stenv (AST.MARKtokpat m) = reportError infTokpat stenv m
     | infTokpat (st,env) (AST.TOKtokpat i) = (0, env)
     | infTokpat (st,env) (AST.NAMEDtokpat (v,_)) = (1, E.pushLambdaVar (v,env))
   and infMatch (st,env) (p,e) =
      let
         val (n,env) = infPat (st,env) p
         (*val _ = TextIO.print ("**** after pat:\n" ^ E.toString env)*)
         val envScru = E.popKappa env
         val envScru = E.pushSymbol (caseExpSymId, SymbolTable.noSpan, envScru)
         (*val _ = TextIO.print ("**** after case dup:\n" ^ E.toString envScru)*)
         val env = E.meetFlow (env, envScru)
            handle S.UnificationFailure str =>
               refineError (str,
                            " when checking case scrutinee",
                            envScru, "scrutinee and patterns so far ",
                            env,     "pattern " ^ showProg (22, PP.pat, p))
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
         val envPat = E.reduceToFunction envPat
         val envCon = E.popKappa envPat
         val envCon = infExp (st,envCon) (AST.CONexp c)
         val env = E.meetFlow (envCon,envPat)
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
         E.pushType (false, VEC (CONST (String.size str)), env)

   (*enforce the size constraints of the primitives*)
   val primEnv = E.primitiveEnvironment (Primitives.getSymbolTypes (),
                  SizeConstraint.fromList Primitives.primitiveSizeConstraints)

   val toplevelEnv = E.pushGroup
      (List.concat
         (List.map topDecl (#tree (ast : SpecAbstractTree.specification)))
      , primEnv)
   (*val _ = TextIO.print ("toplevel environment:\n" ^ E.toString toplevelEnv)*)
   val (unstable, toplevelEnv) = List.foldl (fn (d,(unstable, env)) =>
            (case infDecl ({span = SymbolTable.noSpan},env) d of
               (newUnstable, env) =>
                  (E.SymbolSet.union (newUnstable, unstable), env))
               handle TypeError => (unstable, env)
         ) (E.SymbolSet.empty, toplevelEnv)
         (#tree (ast : SpecAbstractTree.specification))
   val toplevelEnv = calcFixpoint (unstable, toplevelEnv)
                        handle TypeError => toplevelEnv
   (*val _ = TextIO.print ("toplevel environment:\n" ^ E.toString toplevelEnv)*)
   val (badSizes, primEnv) = E.popGroup (toplevelEnv, false)
   val _ = reportBadSizes badSizes
   val (badSizes, _) = E.popGroup (primEnv, false)
   val _ = reportBadSizes badSizes
   in
      !sm
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
                 E.VALUE {symType = t, symFlow = bFun} =>
                  let
                     val (tStr, si) = showTypeSI (t,si)
                  in
                     (sStr ^ " : " ^ tStr ^ ";" ^ BD.showBFun bFun ^ "\n" ^ str, si)
                  end
               | E.DECODE {symType = t, symFlow = bFun, width = w} =>
                  let
                     val (tStr, si) = showTypeSI (t,si)
                     val (wStr, si) = showTypeSI (w,si)
                  in
                     (sStr ^ " : " ^ tStr ^ ";" ^ BD.showBFun bFun ^ ", width = " ^
                      wStr ^ "\n" ^ str, si)
                  end
         end
      ) ("",TVar.emptyShowInfo)

end
