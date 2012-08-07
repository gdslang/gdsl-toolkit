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

   fun refineError (str, msg, envStrs) =
      let
         fun genRow ((env,str),(acc,si)) =
            let
               val (eStr,si) = E.kappaToStringSI (env,si)
            in
               (acc ^ "\t" ^ str ^ ": " ^ eStr,si)
            end
         val (str, si) = List.foldl
                           genRow
                           (str ^ msg ^ "\n", TVar.emptyShowInfo) envStrs
      in
         raise S.UnificationFailure str
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
   
   (*convert calls in a decoder pattern into a list of monadic actions*)
   fun decsToSeq e [] = e
     | decsToSeq e ds = AST.SEQexp
         (List.concat (List.map decToSeqDecodepat ds) @ [AST.ACTIONseqexp e])
   and decToSeqDecodepat (AST.MARKdecodepat {tree=t, span=s}) =
         List.map (fn a => AST.MARKseqexp {tree=a, span=s})
            (decToSeqDecodepat t)
     | decToSeqDecodepat (AST.TOKENdecodepat tp) =
         List.map AST.ACTIONseqexp (decToSeqToken tp)
     | decToSeqDecodepat (AST.BITdecodepat bps) =
         List.map AST.ACTIONseqexp (List.concat (List.map decToSeqBitpat bps))
   and decToSeqToken (AST.MARKtokpat {tree=t, span=s}) =
         List.map (fn e => AST.MARKexp {tree=e, span=s}) (decToSeqToken t)
     | decToSeqToken (AST.NAMEDtokpat sym) = [AST.IDexp sym]
     | decToSeqToken _ = []
   and decToSeqBitpat (AST.MARKbitpat {tree=t, span=s}) =
         List.map (fn e => AST.MARKexp {tree=e, span=s}) (decToSeqBitpat t)
     | decToSeqBitpat (AST.NAMEDbitpat sym) = [AST.IDexp sym]
     | decToSeqBitpat _ = []

   (* define a traversal that returns a list of all top-level decls *)
   fun topDecl (AST.MARKdecl {span, tree=t}) = topDecl t
     | topDecl (AST.DECODEdecl dd) = topDecodeDecl dd
     | topDecl (AST.LETRECdecl vd) = topLetrecDecl vd
     | topDecl _ = []
   and topDecodeDecl (v, _, _) = [(v, true)]
   and topLetrecDecl (v, _, _) = [(v,false)]

   fun toplevelDecls ast = List.concat
         (List.map topDecl (ast : SpecAbstractTree.specification))
   
   (*calculate gather all identifiers of a binding group in order to calculate SCCs*)
   structure SCC = GraphSCCFn(ord_symid)

   fun sccsSpecification ast =
      let
         val dom = SymSet.fromList (List.map #1 (toplevelDecls ast))
         val sm = List.foldl (calleesDecl dom) SymMap.empty ast
         fun getCallees s = SymSet.listItems (SymMap.lookup (sm,s))
      in
         SCC.topOrder' {roots = SymMap.listKeys sm,
                        follow = getCallees }
      end
   and sccsLetrec l =
      let
         val dom = SymSet.fromList (List.map #1 l)
         val sm = List.foldl (calleesLetrec dom) SymMap.empty l
         fun getCallees s = SymSet.listItems (SymMap.lookup (sm,s))
      in
         SCC.topOrder' {roots = SymMap.listKeys sm,
                        follow = getCallees }
      end
   and calleesDecl dom (AST.MARKdecl {span, tree=t},sm) = calleesDecl dom (t,sm)
     | calleesDecl dom (AST.DECODEdecl dd,sm) = calleesDecodeDecl (sm,dom) dd
     | calleesDecl dom (AST.LETRECdecl vd,sm) = calleesLetrecDecl (sm,dom) vd
     | calleesDecl dom (_,sm) = sm
   and calleesDecodeDecl (sm,dom) (v, dps, Sum.INL e) =
      let
         val ids = List.foldl
                     (fn (dp, ids) => SymSet.union (calleesDecodepat dp, ids))
                     SymSet.empty dps
         val ids = SymSet.union (calleesExp e, ids)
         val ids = SymSet.intersection (ids, dom)
      in
         case SymMap.find (sm, v) of
              NONE => SymMap.insert (sm, v, ids)
            | SOME ids' => SymMap.insert (sm, v, SymSet.union (ids,ids'))
      end
     | calleesDecodeDecl (sm,dom) (v, dps, Sum.INR el) =
      let
         val ids = List.foldl
                     (fn (dp, ids) => SymSet.union (calleesDecodepat dp, ids))
                     SymSet.empty dps
         val ids = List.foldl
                     (fn ((g,e), ids) => SymSet.union (
                        SymSet.union (calleesExp g, calleesExp e), ids))
                     ids el
         val ids = SymSet.intersection (ids, dom)
      in
         case SymMap.find (sm, v) of
              NONE => SymMap.insert (sm, v, ids)
            | SOME ids' => SymMap.insert (sm, v, SymSet.union (ids,ids'))
      end
   and calleesLetrecDecl (sm,dom) (v, _, e) =
      SymMap.insert (sm,v, SymSet.intersection (calleesExp e,dom))
   and calleesLetrec dom ((v,_,e),sm) =
      SymMap.insert (sm,v, SymSet.intersection (calleesExp e,dom))
   and calleesExp (AST.MARKexp {span, tree=t}) = calleesExp t
     | calleesExp (AST.LETRECexp (bs,e)) =
      List.foldl
         (fn ((_,_,body), ids) => SymSet.union (calleesExp body, ids))
         (calleesExp e) bs
     | calleesExp (AST.IFexp (e1,e2,e3)) = SymSet.union
      (SymSet.union (calleesExp e1, calleesExp e2), calleesExp e3)
     | calleesExp (AST.CASEexp (e,cs)) =
      List.foldl
         (fn ((_,e),ids) => SymSet.union (calleesExp e,ids))
         (calleesExp e) cs
     | calleesExp (AST.BINARYexp (e1,v,e2)) = SymSet.union
         (calleesExp e1, SymSet.union (calleesExp e2,calleesInfixop v))
     | calleesExp (AST.APPLYexp (e,es)) =
      List.foldl (fn (e,ids) => SymSet.union (calleesExp e,ids))
         (calleesExp e) es
     | calleesExp (AST.RECORDexp fs) =
      List.foldl (fn ((_,e),ids) => SymSet.union (calleesExp e, ids))
         SymSet.empty fs
     | calleesExp (AST.UPDATEexp fs) =
      List.foldl (fn ((_,eOpt),ids) => case eOpt of
            SOME e => SymSet.union (calleesExp e, ids)
          | NONE => ids)
         SymSet.empty fs
     | calleesExp (AST.SEQexp ss) =
      List.foldl (fn (s,ids) => SymSet.union (calleesSeqexp s, ids))
         SymSet.empty ss
     | calleesExp (AST.IDexp v) = SymSet.singleton v
     | calleesExp (AST.FNexp (_,e)) = calleesExp e
     | calleesExp _ = SymSet.empty
   and calleesInfixop (AST.MARKinfixop {span, tree=t}) = calleesInfixop t
     | calleesInfixop (AST.OPinfixop id) = SymSet.singleton id
   and calleesSeqexp (AST.MARKseqexp {span, tree=t}) = calleesSeqexp t
     | calleesSeqexp (AST.ACTIONseqexp e) = calleesExp e
     | calleesSeqexp (AST.BINDseqexp (_,e)) = calleesExp e
   and calleesDecodepat (AST.MARKdecodepat {span, tree=t}) = calleesDecodepat t
     | calleesDecodepat (AST.TOKENdecodepat tp) = calleesTokpat tp
     | calleesDecodepat (AST.BITdecodepat bps) =
      List.foldl (fn (bp,ids) => SymSet.union (calleesBitpat bp, ids))
         SymSet.empty bps
   and calleesBitpat (AST.MARKbitpat {span, tree=t}) = calleesBitpat t
     | calleesBitpat (AST.NAMEDbitpat v) = SymSet.singleton v
     | calleesBitpat _ = SymSet.empty
   and calleesTokpat (AST.MARKtokpat {span, tree=t}) = calleesTokpat t
     | calleesTokpat (AST.NAMEDtokpat v) = SymSet.singleton v
     | calleesTokpat _ = SymSet.empty

   


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

   fun reportError conv ({span,component=comp}, env) {span=s, tree=t} =
      conv ({span=s,component=comp},env) t
      handle (S.UnificationFailure str) =>
         (Error.errorAt (errStrm, s, [str]); raise TypeError)
   val reportBadSizes = List.app (fn (s,str) => Error.errorAt (errStrm, s, [str]))
   fun getSpan {span = s,component} = s
   fun hasSymbol ({span, component = SCC.SIMPLE n},s) = SymbolTable.eq_symid (s,n)
     | hasSymbol ({span, component = SCC.RECURSIVE ns},s) =
         List.exists (fn n => SymbolTable.eq_symid (s,n)) ns
   
   (* define a traversal that is a full inference of the tree *)
   
   val maxIter = 2
   
   fun calcSubset (printWarn,sym,env) =
      let
         fun checkUsage sym s =
            let
               val fs = E.getContextOfUsage (sym, s, env)
               val oldCtxt = E.getCtxt env
               val env = List.foldl E.pushFunction env fs
               
               val envFun = E.pushSymbol (sym, s, false, env)
               (*val _ = TextIO.print ("pushed instance " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " symbol:\n" ^ E.topToString envFun)*)
               val envCall = E.pushUsage (sym, s, !sm, env)
               (*val _ = TextIO.print ("pushed usage:\n" ^ E.topToString envCall)*)

               (*warn about refinement of the definition due to a call site*)
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
                           (res ^ pre ^ sStr ^ " : " ^ sType, "\n\tand call ", si)
                        end
                     val (symsStr, _, _) =
                        List.foldl showSyms ("","\n\tfor call ", si)
                           (E.SymbolSet.listItems syms)
                  in 
                     (Error.warningAt (errStrm, s, [
                     "call to ",
                     SymbolTable.getString(!SymbolTables.varTable, sym),
                     " requires refinement ", sSubst,
                     symsStr]))
                  end
               val substs = E.subseteq (envCall, envFun)
               val affectedSyms = E.affectedFunctions (substs,env)
               
               (*val (sStr, si) = S.showSubstsSI (substs, TVar.emptyShowInfo)
               val _ = TextIO.print ("subset: subst=:" ^ sStr ^ ", unstable: " ^
                  List.foldl (fn (sym, res) => res ^ ", " ^ SymbolTable.getString
                   (!SymbolTables.varTable, sym)) "" (E.SymbolSet.listItems affectedSyms) ^ "\n")*)
               val _ = raiseWarning (substs, affectedSyms)
            in
               E.SymbolSet.isEmpty affectedSyms 
            end
         val usages = E.getUsages (sym, env)
         (*val _ = TextIO.print ("***** checking subset of " ^ Int.toString (List.length usages) ^ " usages of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")*)
      in
         List.all (checkUsage sym) usages
      end

   fun calcSubsets printWarn (syms,env) =
         List.foldl (fn (sym,unstable) =>
               (if calcSubset (printWarn,sym,env) then unstable else
                  E.SymbolSet.add (unstable, sym))
               handle (S.UnificationFailure str) =>
                  E.SymbolSet.add (unstable, sym)
            ) E.SymbolSet.empty syms

   fun calcIteration (sym, env) =
      let
         fun checkUsage (s, env) =
            let
               val fs = E.getContextOfUsage (sym, s, env)
               val oldCtxt = E.getCtxt env
               val env = List.foldl E.pushFunction env fs
               
               val envFun = E.pushSymbol (sym, s, false, env)
               (*val _ = if SymbolTable.toInt sym = 95 then TextIO.print ("pushed instance " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " symbol:\n" ^ E.kappaToString envFun)
                     else ()*)
               val envCall = E.pushUsage (sym, s, !sm, env)
               (*val _ = if SymbolTable.toInt sym = 95 then TextIO.print ("pushed usage:\n" ^ E.kappaToString envCall)
                     else ()*)
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
                     "\tdefinition has type " ^ sFun]))
                  end
               val env = E.meetFlow (envCall, envFun)
                  handle (S.UnificationFailure str) =>
                     (raiseError str; envFun)
               (*val _ = TextIO.print ("popping to usage of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ ":\n" ^ E.topToString env)*)
               val (changed, env) = E.popToUsage (sym, s, oldCtxt, env)
               val _ = sm := List.foldl
                     (fn (sym,sm) => (sym, E.getFunctionInfo (sym, env)) ::
                        List.filter (fn (s,_) =>
                           not (SymbolTable.eq_symid(s,sym))) sm)
                     (!sm) changed
            in
               env
            end
         val usages = E.getUsages (sym, env)
         (*val _ = TextIO.print ("***** re-eval of " ^ Int.toString (List.length usages) ^ " usages of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")*)
      in
         List.foldl checkUsage env usages
      end

   fun calcFixpoints curIter (syms,env) =
         case calcSubsets (curIter+1>=maxIter) (syms,env) of unstable =>
         if E.SymbolSet.isEmpty unstable then env else
         if curIter<maxIter then
            calcFixpoints (curIter+1) (syms,
               List.foldl calcIteration env (E.SymbolSet.listItems unstable)
            )
         else
         let
            val si = TVar.emptyShowInfo
            fun showSyms (sym, (res, pre, si)) =
               let
                  val sStr = SymbolTable.getString
                     (!SymbolTables.varTable, sym)
                  val env = E.pushSymbol (sym, SymbolTable.noSpan, false, env)
                  val (sType, si) = E.kappaToStringSI (env, si)
               in
                  (res ^ pre ^ sStr ^ " : " ^ sType, ", ", si)
               end
            val symIds = E.SymbolSet.listItems unstable
            val (symsStr, _, _) = List.foldl showSyms ("", "", si) symIds
            val s = case symIds of [] => raise TypeError | (sym :: _) =>
                    SymbolTable.getSpan(!SymbolTables.varTable, sym)
         in 
            (Error.errorAt (errStrm, s, [
            "no typing found for ",
            symsStr,
            "\tpass --inference-iterations=",
            Int.toString (maxIter+1),
            " to try a little harder"]); env)
         end
   val calcFixpoints = calcFixpoints 0

   (*local helper function to infer types for a binding group*)
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
                            [(envRef, "required guard type        "),
                             (envGua, "guard " ^ showProg (20, PP.exp, g))])
            in
               E.popKappa env
            end
         val env = case guard of SOME g => checkGuard (g,env)
                               | NONE => env
         fun pushDecoderBindings(d,(n, env)) =
            case infDecodepat sym (st,env) d of (nArgs, env) => (n+nArgs, env)
         val (n,env) = List.foldl pushDecoderBindings (0,env) dec
         val env = List.foldl E.pushLambdaVar env args
         val rhs = decsToSeq rhs dec
         val env = infExp (st,env) rhs
         val env = E.reduceToFunction (env, List.length args)
         val env = E.return (n,env)
         (*val _ = TextIO.print ("after popping args:\n" ^ E.topToString env)*)
      in
         env
      end
   and infBinding (st,env) (sym, args, rhs) =
      let
         val env = E.pushFunction (sym,env)
         val env = infRhs (st,env) (sym, [], NONE, args, rhs)
         val env = E.popToFunction (sym, env)
         val fInfo = E.getFunctionInfo (sym, env)
         val _ = sm := (sym, fInfo) :: !sm
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
         env
      end
     | infDecl stenv (AST.DECODEdecl dd) = infDecodedecl stenv dd
     | infDecl (st,env) (AST.LETRECdecl (v,l,e)) = 
      if hasSymbol (st,v) then infBinding (st,env) (v, l, e) else env
     | infDecl (st,env) _ = env

   and infDecodedecl (st,env) (v, l, Sum.INL e) =
      if not (hasSymbol (st,v)) then env else
      let
         (*val _ = TextIO.print ("**** prev type of decoder " ^ SymbolTable.getString(!SymbolTables.varTable, v) ^ ":\n" ^ E.topToString env)*)
         val (envOpt,env) = E.clearFunction (v,env)
         val env = infRhs (st,env) (v, l, NONE, [], e)
         (*val _ = TextIO.print ("**** new type of decoder " ^ SymbolTable.getString(!SymbolTables.varTable, v) ^ ":\n" ^ E.topToString env)*)
         val env = case envOpt of
                 NONE => env
               | SOME envPrev => E.meet (envPrev, env)
         val env = E.popToFunction (v, env)
         val fInfo = E.getFunctionInfo (v, env)
         val _ = sm := (v, fInfo) :: List.filter (fn (s,_) =>
                                       not (SymbolTable.eq_symid(s,v))) (!sm)
      in
         env
      end
     | infDecodedecl (st,env) (v, l, Sum.INR el) =
      if not (hasSymbol (st,v)) then env else
      let
         val env = List.foldl
            (fn ((guard, rhs), env) => let
               val (envOpt,env) = E.clearFunction (v,env)
               val env = infRhs (st,env) (v, l, SOME guard, [], rhs)
               val env = case envOpt of
                       NONE => env
                     | SOME envPrev => E.meet (envPrev, env)
               val env = E.popToFunction (v, env)
            in
               env
            end) env el
         val fInfo = E.getFunctionInfo (v, env)
         val _ = sm := (v, fInfo) :: List.filter (fn (s,_) =>
                                       not (SymbolTable.eq_symid(s,v))) (!sm)
      in
         env
      end

   and infExp stenv (AST.MARKexp m) = reportError infExp stenv m
     | infExp (st,env) (AST.LETRECexp (l,e)) =
      let                                              
         val names = List.map topLetrecDecl l
         val env = E.pushGroup (List.concat names, env)
         val sccs = List.rev (sccsLetrec l)
   
         val env = List.foldl (fn (comp,env) =>
            let
               (*val _ = TextIO.print ("checking component " ^ prComp comp)*)
               val env = List.foldl (fn ((v,l,e),env) =>
                              infBinding (st, env) (v, l, e)
                              handle TypeError => env) env l
               val env = case comp of
                    SCC.SIMPLE _ => env
                  | SCC.RECURSIVE syms => calcFixpoints (syms, env)
                              handle TypeError => env
               in
                  env
               end
            ) env sccs
         
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
         val envM = E.pushTop env
         val envT = infExp (st,env) e2
         (*val _ = TextIO.print ("**** after if-then:\n" ^ E.topToString envT)*)
         val envM = E.meetFlow (envM,envT)
         val envE = infExp (st,env) e3
         (*val _ = TextIO.print ("**** after if-else:\n" ^ E.topToString envE)*)
         val envM = E.meetFlow (envM,envE)
         (*val _ = TextIO.print ("**** after if-merge:\n" ^ E.topToString envM)*)
      in
         envM
      end
     | infExp (st,env) (AST.CASEexp (e,l)) =
      let
         val (t,env) = E.pushLambdaVar' (caseExpSymId, env)
         val envExp = infExp (st,env) e
         (*val _ = TextIO.print ("**** after case exp:\n" ^ E.topToString envExp)*)
         val envVar = E.pushType (false, t, env)
         (*val _ = TextIO.print ("**** after case dup:\n" ^ E.topToString envVar)*)
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
                                  [(nEnv, "branches so far               "),
                                   (expEnv, showProg (30, PP.exp, exp))])
            in
               env
            end
         val env = List.foldl genFlow envNeutral l
         (*val _ = TextIO.print ("**** all envs:\n" ^ E.topToString env)*)
      in
         E.return (1,env)
      end
     | infExp stenv (AST.BINARYexp (e1, binop, e2)) =
      let
         fun infixToExp (AST.MARKinfixop {tree = t, span = s}) =
               AST.MARKexp ({tree = infixToExp t, span = s})
           | infixToExp (AST.OPinfixop opid) = AST.IDexp opid
      in
         infExp stenv (AST.APPLYexp (infixToExp binop, [e1, e2]))
      end
     | infExp (st,env) (AST.APPLYexp (e1,es2)) =
      let                                      
         val envFun = infExp (st,env) e1
         val envArg = List.foldl (fn (e2,env) => infExp (st,env) e2) env es2
         (*val _ = TextIO.print ("**** app func:\n" ^ E.topToString envFun)
         val _ = TextIO.print ("**** app arg:\n" ^ E.topToString envArg)*)
         val envArgRes = E.pushTop envArg
         val envArgRes = E.reduceToFunction (envArgRes, List.length es2)
         (*val _ = TextIO.print ("**** app turning arg:\n" ^ E.toString envArgRes)*)
         (* make the result of the call-site depend on the result of the
         function; the flow expressing that formal parameters depend on actual
         parameters follows from contra-variance*)
         val env = E.meetFlow (envArgRes, envFun)
            handle S.UnificationFailure str =>
               refineError (str,
                            " while passing",
                            (#1 (List.foldr
                            (fn (e2,(res,env)) => 
                              ((env, "argument    " ^ showProg (20, PP.exp, e2))::res,
                               E.popKappa env)
                            ) ([], envArg) es2)) @
                            [(envFun, "to function " ^ showProg (20, PP.exp, e1))])
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
         (*val _ = TextIO.print ("**** rec exp, combined:\n" ^ E.topToString env ^ "\n")*)
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
         val env = E.reduceToFunction (env,1)
         (*val _ = TextIO.print ("**** rec selector:\n" ^ E.topToString env ^ "\n")*)
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
         fun pushOutField ((fid,eOpt), (nts, env)) =
            let
               (*val _ = TextIO.print ("**** rec update: pushing field " ^ SymbolTable.getString(!SymbolTables.fieldTable, fid) ^ ".\n")*)
               val bVar = BD.freshBVar ()
               val env = case eOpt of
                           SOME e => E.meetBoolean (BD.meetVarOne bVar, 
                                       infExp (st,env) e)
                         | NONE => E.meetBoolean (BD.meetVarZero bVar,
                                       E.pushTop env)
            in
               ((bVar, fid) :: nts, env)
            end
         val (nts, env) = List.foldl pushOutField ([], env) fs
         val env = E.reduceToRecord (nts, env)
         val env = E.reduceToFunction (env,1)
         (*val _ = TextIO.print ("**** rec update: function is:\n" ^ E.topToString env ^ "\n")*)
      in
         env
      end
     | infExp stenv (AST.LITexp lit) = infLit stenv lit
     | infExp stenv (AST.SEQexp l) = infSeqexp stenv l
     | infExp (st,env) (AST.IDexp v) =
      let
         val env = E.pushSymbol (v, getSpan st, hasSymbol (st,v), env)
         (*val _ = TextIO.print ("**** after pushing symbol " ^ SymbolTable.getString(!SymbolTables.varTable, v) ^ ":\n" ^ E.topToString env)*)
      in
         env
      end
     | infExp (st,env) (AST.CONexp c) =
      let
         val dcon = SymMap.lookup (conParents, c)
         val { tdVars = vs, tdCons = cs } = SymMap.lookup (typeDefs, dcon)
         val vs = SymMap.listItems vs
         val tArgOpt = SymMap.lookup (cs, c)
         val env =
            case tArgOpt of
                 NONE => E.pushType (true, ALG (dcon, List.map VAR vs), env)
               | SOME t =>
            let
               val env = E.pushType (true, FUN ([t],ALG (dcon, List.map VAR vs)), env)
               val env = E.genConstructorFlow (false,env)
            in
               env
            end
         (*val _ = TextIO.print ("**** looking for " ^ SymbolTable.getString(!SymbolTables.conTable, c) ^ ":\n" ^ E.topToString env)*)
      in
         env
      end
     | infExp (st,env) (AST.FNexp (vs, e)) =
      let
         val env = List.foldl E.pushLambdaVar env vs
         val env = infExp (st, env) e
      in
         E.reduceToFunction (env, List.length vs)
      end
         
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
         val envFun = E.pushSymbol (bind, getSpan st, hasSymbol (st,bind), env)
         val envArg = infExp (st,env) e
         val envArgRes = E.pushTop envArg
         val envArgRes = E.reduceToFunction (envArgRes,1)
         (*val _ = TextIO.print ("function to unify with bind: " ^ E.topToString envArgRes ^ "\n")*)
         val env = E.meetFlow (envArgRes, envFun)
            handle S.UnificationFailure str =>
               raise S.UnificationFailure (str ^ " in statement\n\t" ^
                   showProg (20, PP.exp, e) ^ " : " ^
                   #1 (E.kappaToStringSI (envArg, TVar.emptyShowInfo)))
         val envFun = E.reduceToResult env
         val env = E.popKappa envFun
         val envArg = case vOpt of
                 SOME v => E.reduceToFunction (infSeqexp (st, E.pushLambdaVar (v,env)) l,1)
               | NONE => infSeqexp (st, env) l
         val envArgRes = E.pushTop envArg
         val envArgRes = E.reduceToFunction (envArgRes,1)
         val env = E.meetFlow (envArgRes, envFun)
            handle S.UnificationFailure str =>
               refineError (str,
                            " when passing on the result of",
                            [(envFun, "statement " ^ showProg (20, PP.exp, e)),
                             (envArg, "to the following statments    ")])
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
                            [(envGra, "granularity                     "),
                             (envDec, "token " ^ showProg (20, PP.tokpat, t))])
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
                            [(envGra, "granularity                     "),
                             (envPat, "pattern " ^ showProg (20, PP.decodepat, (AST.BITdecodepat l)))])
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
         E.pushType (false, CONST (getBitpatLitLength s), env)
   and infBitpat stenv (AST.MARKbitpat m) = reportError infBitpat stenv m
     | infBitpat (st,env) (AST.BITSTRbitpat str) = (0,env)
     | infBitpat (st,env) (AST.NAMEDbitpat v) =
         (1, E.pushSymbol (v, getSpan st, hasSymbol (st,v), env))
     | infBitpat (st,env) (AST.BITVECbitpat (v,s)) =
      let
         val env = E.pushLambdaVar (v,env)
         val envVar = E.pushSymbol (v, getSpan st, hasSymbol (st,v), env)
         val envWidth = E.pushType (false, VEC (CONST (getBitpatLitLength s)), env)
         val env = E.meet (envVar, envWidth)
         val env = E.popKappa env
      in
         (1, env)
      end
   and infTokpat stenv (AST.MARKtokpat m) = reportError infTokpat stenv m
     | infTokpat (st,env) (AST.TOKtokpat i) = (0, env)
     | infTokpat (st,env) (AST.NAMEDtokpat v) = (1, E.pushLambdaVar (v,env))
   and infMatch (st,env) (p,e) =
      let
         val (n,env) = infPat (st,env) p
         (*val _ = TextIO.print ("**** after pat:\n" ^ E.topToString env)*)
         val envScru = E.popKappa env
         val envScru = E.pushSymbol (caseExpSymId, SymbolTable.noSpan, false, envScru)
         (*val _ = TextIO.print ("**** after case dup:\n" ^ E.topToString envScru)*)
         val env = E.meetFlow (env, envScru)
            handle S.UnificationFailure str =>
               refineError (str,
                            " when checking case scrutinee",
                            [(envScru, "scrutinee and patterns so far "),
                             (env,     "pattern " ^ showProg (22, PP.pat, p))])
         (*val _ = TextIO.print ("**** after mgu:\n" ^ E.topToString env)*)
         val env = E.popKappa env
         val env = infExp (st,env) e
         (*val _ = TextIO.print ("**** after expr:\n" ^ E.topToString env)*)
      in
         E.return (n,env)
      end

   and infPat stenv (AST.MARKpat m) = reportError infPat stenv m
     | infPat (st,env) (AST.LITpat lit) = (0, infLit (st,env) lit)
     | infPat (st,env) (AST.IDpat v) =
      let
         val (t, env) = E.pushLambdaVar' (v,env)
         val t' = newFlow t
         val env = E.meetBoolean (BD.meetVarImpliesVar (bvar t, bvar t'), env)
      in
         (1, E.pushType (false, t', env))
      end
     | infPat (st,env) (AST.CONpat (c, SOME p)) =
      let
         val (n,envPat) = infPat (st,env) p
         val envPat = E.pushTop envPat
         val envPat = E.reduceToFunction (envPat,1)

         val envCon = E.popKappa envPat
         val dcon = SymMap.lookup (conParents, c)
         val { tdVars = vs, tdCons = cs } = SymMap.lookup (typeDefs, dcon)
         val vs = SymMap.listItems vs
         val t =
            case SymMap.lookup (cs, c) of
                 NONE => raise S.UnificationFailure (
                  "pattern with constructor " ^
                  SymbolTable.getString(!SymbolTables.conTable, c) ^ 
                  " may not have an argument")
               | SOME t => t
         val envCon = E.pushType (true, FUN ([t],ALG (dcon, List.map VAR vs)), envCon)
         val envCon = E.genConstructorFlow (true,envCon)

         val env = E.meetFlow (envCon,envPat)

         (*val (pStr, si) = E.topToStringSI (envPat, TVar.emptyShowInfo)
         val (cStr, si) = E.topToStringSI (envCon, si)
         val (rStr, si) = E.topToStringSI (env, si)
         val _ = TextIO.print ("**** pattern: payload to type is:\n" ^ pStr)
         val _ = TextIO.print ("**** pattern: constructor type is:\n" ^ cStr)
         val _ = TextIO.print ("**** pattern: resulting type is:\n" ^ rStr)*)

         val env = E.reduceToResult env
      in
         (n, env)
      end
     | infPat (st,env) (AST.CONpat (c, NONE)) =
         (0, infExp (st,env) (AST.CONexp c))
     | infPat (st,env) (AST.WILDpat) = (0, E.pushTop env)
   and infLit (st,env) (AST.INTlit i) = E.pushType (false, ZENO, env)
     | infLit (st,env) (AST.FLTlit f) = E.pushType (false, FLOAT, env)
     | infLit (st,env) (AST.STRlit str) = E.pushType (false, STRING, env)
     | infLit (st,env) (AST.VEClit str) =
         E.pushType (false, VEC (CONST (getBitpatLitLength str)), env)

   (*enforce the size constraints of the primitives*)
   val primEnv = E.primitiveEnvironment (Primitives.getSymbolTypes (),
                  SizeConstraint.fromList Primitives.primitiveSizeConstraints)

   val toplevelEnv = E.pushGroup (toplevelDecls ast, primEnv)
   
   val sccs = List.rev (sccsSpecification ast)
   
   (*fun prComp (SCC.SIMPLE s) =
         SymbolTable.getString(!SymbolTables.varTable, s) ^ "\n"
     | prComp (SCC.RECURSIVE ss) = "(" ^ #1 (List.foldl (fn (s,(str,sep)) =>
            (str ^ sep ^
             SymbolTable.getString(!SymbolTables.varTable, s), ","))
         ("","") ss) ^ ")\n"
   val _ = TextIO.print ("SCCs:\n" ^ List.foldl (fn (c,str) => str ^ prComp c) "" sccs)*)

   
   (*val _ = TextIO.print ("toplevel environment:\n" ^ E.toString toplevelEnv)*)
   val toplevelEnv = List.foldl (fn (comp,env) =>
      let
         (*val _ = TextIO.print ("checking component " ^ prComp comp)*)
         val env = List.foldl (fn (d,env) =>
                        infDecl ({span = SymbolTable.noSpan,
                                  component = comp},env) d
                        handle TypeError => env) env ast
         val env = case comp of
              SCC.SIMPLE _ => env
            | SCC.RECURSIVE syms => calcFixpoints (syms, env)
                        handle TypeError => env
         in
            env
         end
      ) toplevelEnv sccs

   (* check if all exported functions can be run with the specified fields *)
   fun checkDecoder s sym = case E.forceNoInputs (sym,[],toplevelEnv) of
        [] => ()
      | fs =>
         let
            val decStr = SymbolTable.getString(!SymbolTables.varTable, sym)
            fun genFieldStr (f,(sep,str)) = (", ", str ^ sep ^
                  SymbolTable.getString(!SymbolTables.fieldTable, f))
            val (_,fsStr) = List.foldl genFieldStr ("", "") fs
         in
            Error.errorAt (errStrm, s,
               [decStr," is exported but requires fields: ", fsStr]
            )
         end
   fun checkExports _ (AST.MARKdecl {span=s, tree=t}) = checkExports s t
     | checkExports s (AST.EXPORTdecl vs) = List.app (checkDecoder s) vs
     | checkExports s _ = ()
   val _ = List.app (checkExports SymbolTable.noSpan) ast
   
   (*val _ = TextIO.print ("toplevel environment:\n" ^ E.topToString toplevelEnv)*)

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
