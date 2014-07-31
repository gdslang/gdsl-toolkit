(**
 * ## Perform Type Inference
 *
 * Returns tables with types of each identifier.
 *)
structure TypeInference : sig

   type symbol_types
       
   val getBitpatLitLength : SpecAbstractTree.bitpat_lit -> int

   val typeInferencePass: (Error.err_stream * ResolveTypeInfo.type_info * 
                           SpecAbstractTree.specification) -> symbol_types
   val run: ResolveTypeInfo.type_info * SpecAbstractTree.specification ->
            symbol_types CompilationMonad.t
   
   val showTable : symbol_types -> string
   
end = struct

   val debugSymbol = NONE (*SOME 89*)
   val verbose = false
   
   structure AST = SpecAbstractTree
   structure E = Environment(*Profiling*)
   structure BD = BooleanDomain
   structure TI = ResolveTypeInfo
   structure S = Substitutions
   structure PP = SpecAbstractTree.PP
   structure SCC = GraphSCCFn(ord_symid)
   
   type symbol_types = E.environment

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

   fun prComp (SCC.SIMPLE s) =
         SymbolTable.getString(!SymbolTables.varTable, s) ^ "\n"
     | prComp (SCC.RECURSIVE ss) = "(" ^ #1 (List.foldl (fn (s,(str,sep)) =>
            (str ^ sep ^
             SymbolTable.getString(!SymbolTables.varTable, s), ","))
         ("","") ss) ^ ")\n"
   
   fun refineError (env, (kind, str), msg, symSelStrings) =
      let
         fun genRow ((symSel,str),(acc,si)) =
            let
               val (eStr,si) = E.kappaToStringSI (symSel,env,si)
            in
               (acc ^ "\t" ^ str ^ ": " ^ eStr,si)
            end
         val (str, si) = List.foldl
                           genRow
                           (str ^ msg ^ "\n", TVar.emptyShowInfo) symSelStrings
                           
      in
         ((*TextIO.print (E.toString env);*)
          raise S.UnificationFailure (kind, str)
         )
      end

   fun getBitpatLitLength bp =
      let
         val fields = String.fields (fn c => c= #"|") bp
         fun checkWidth (f,width) =
            if String.size f <> width then
               raise S.UnificationFailure (S.Clash,
                   "bit literals have different lengths")
            else width
      in
         case fields of
            [] => 0
          | (f::fs) => List.foldl checkWidth (String.size f) fs
      end
   
   (*convert calls in a decoder pattern into a list of monadic actions*)
   fun decsToSeq e NONE ds = (case List.concat (List.map decToSeqDecodepat ds) of
        [] => e
      | es => AST.SEQexp (es @ [AST.ACTIONseqexp e])
      )
     | decsToSeq e (SOME g) ds =
     let
        val querySymId = SymbolTable.lookup(!SymbolTables.varTable, Atom.atom "query")
     in
        AST.SEQexp (List.concat (List.map decToSeqDecodepat ds) @
                   [AST.ACTIONseqexp (AST.APPLYexp (AST.IDexp querySymId, [g])),
                    AST.ACTIONseqexp e])
     end
   and decToSeqDecodepat (AST.MARKdecodepat {tree=t, span=s}) =
         List.map (fn a => AST.MARKseqexp {tree=a, span=s})
            (decToSeqDecodepat t)
     | decToSeqDecodepat (AST.TOKENdecodepat tp) = decToSeqToken tp
     | decToSeqDecodepat (AST.BITdecodepat bps) =
         List.concat (List.map decToSeqBitpat bps)
   and decToSeqToken (AST.MARKtokpat {tree=t, span=s}) =
         List.map (fn e => AST.MARKseqexp {tree=e, span=s}) (decToSeqToken t)
     | decToSeqToken (AST.NAMEDtokpat sym) = [AST.ACTIONseqexp (AST.IDexp sym)]
     | decToSeqToken _ = []
   and decToSeqBitpat (AST.MARKbitpat {tree=t, span=s}) =
         List.map (fn e => AST.MARKseqexp {tree=e, span=s}) (decToSeqBitpat t)
     | decToSeqBitpat (AST.NAMEDbitpat sym) = [AST.ACTIONseqexp (AST.IDexp sym)]
     | decToSeqBitpat _ = []

   (* define a traversal that returns a list of all top-level decls *)
   fun topDecl (AST.MARKdecl {span, tree=t}) = topDecl t
     | topDecl (AST.DECODEdecl dd) = topDecodeDecl dd
     | topDecl (AST.LETRECdecl vd) = topLetrecDecl vd
     | topDecl _ = []
   and topDecodeDecl (v, _, _) = [(v, true)]
   and topLetrecDecl (v, _, _) = [(v,false)]

   fun toplevelDecls ast =
      let
         val declSeq = List.concat
            (List.map topDecl (ast : SpecAbstractTree.specification))
         fun remDup [] = []
           | remDup ((sym as (s,d)) :: syms)  = case remDup syms of syms =>
            if List.exists (fn (s',_) => SymbolTable.eq_symid (s',s)) syms then syms else sym :: syms
      in
         remDup declSeq
      end
   
   (*calculate gather all identifiers of a binding group in order to calculate SCCs*)
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

   fun pushDecoderType (sym,span,env) =
      let
         val env = E.pushSymbol (sym,span,false,E.LetMono,env)
      in
         env
      end


fun typeInferencePass (errStrm, ti : TI.type_info, ast) = let
   val var_counter = TVar.get ()
   val { tsynDefs, typeDefs, conParents, exportTypes } = ti
   
   val bindSymId = SymbolTable.lookup(!SymbolTables.varTable, Atom.atom ">>")
   val bindASymId = SymbolTable.lookup(!SymbolTables.varTable, Atom.atom ">>=")

   val useFunctionSets = Controls.get BasicControl.principalTypings

   fun reportError conv ({span,component=comp}, env) {span=s, tree=t} =
      conv ({span=s,component=comp},env) t
      handle
         (S.UnificationFailure (kind, str)) =>
            (Error.errorAt (errStrm, s, [str]); raise TypeError)
       | ListPair.UnequalLengths =>
            (Error.warningAt (errStrm, s, ["supressed follow-up error"]); raise TypeError)

   val reportBadSizes = List.app (fn (s,str) => Error.errorAt (errStrm, s, [str]))
   fun getSpan {span = s,component} = s
   fun hasSymbol ({span, component = sccs},s) =
      let
         fun hS (SCC.SIMPLE n :: sccs) = SymbolTable.eq_symid (s,n) orelse hS sccs
           | hS (SCC.RECURSIVE ns :: sccs) = 
            List.exists (fn n => SymbolTable.eq_symid (s,n)) ns orelse hS sccs
           | hS [] = false
      in
         hS sccs
      end
   fun hasRecursiveSymbol ({span, component = sccs},s) =
      let
         fun hS (SCC.SIMPLE n :: sccs) = hS sccs
           | hS (SCC.RECURSIVE ns :: sccs) = 
            List.exists (fn n => SymbolTable.eq_symid (s,n)) ns orelse hS sccs
           | hS [] = false
      in
         hS sccs
      end
   fun addComponent (comp,{span, component = sccs}) =
         {span = span, component = comp :: sccs}

   (* define a traversal that is a full inference of the tree *)

   fun showSubstsSI (substs,si) =
      foldl (fn ((v,ty),(sStr,si)) =>
         let
            val (vStr,si) = TVar.varToString (v,si)
            val (tyStr,si) = showTypeSI (ty,si)
         in
            ("[" ^ vStr ^ " / " ^ tyStr ^ "]" ^ sStr, si)
         end
         ) ("", si) substs
   
   fun calcIteration (printWarn,sym,env) =
      let
         fun checkUsage sym s =
            let
               val _ = if not verbose then () else 
                  TextIO.print ("checkUsage (subset) of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")
               val fid = E.getContextOfUsage (sym, s, env)
               val env = E.enterFunction (fid,env)
               val (n1,env) = E.pushNested (sym, env)
               val (n2,env) = E.pushNested (fid, env)
               
               val env = E.pushUsage (sym, s, env)
               val affectedSyms = E.affectedFunctions env
               (*val _ = TextIO.print ("pushed usage (subset):\n" ^ E.topToString env)*)
               val env = E.pushSymbol (sym, s, useFunctionSets, E.Normal, env)
               (*val _ = TextIO.print ("pushed instance (subset) " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " symbol:\n" ^ E.topToString env)*)

               (*warn about refinement of the definition due to a call site*)
               fun raiseWarning (substs, syms) =
                  if List.null substs orelse not printWarn then ()
                  else
                  let
                     val si = TVar.emptyShowInfo
                     val (sSubst, si) = showSubstsSI (substs, si)
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
                           (SymSet.listItems syms)
                  in 
                     (Error.warningAt (errStrm, s, [
                     "call to ",
                     SymbolTable.getString(!SymbolTables.varTable, sym),
                     " requires refinement ", sSubst,
                     symsStr]))
                  end

               (*inform about a unification failure when checking call site
               with definition*)
               fun raiseError (str,env) =
                  let
                     val si = TVar.emptyShowInfo
                     val (sFun, si) = E.kappaToStringSI ((1,0), env, si)
                     val (sCall, si) = E.kappaToStringSI ((2,0), env, si)
                     val env = E.pushTop env
                     val env = E.popToFunction (sym,env)
                  in 
                     (Error.errorAt (errStrm, s, [str,
                     " when checking call to ",
                     SymbolTable.getString(!SymbolTables.varTable, sym),
                     "\n\tcall site has type  " ^ sCall,
                     "\tdefinition has type " ^ sFun]))
                  end

               val substs = E.subsetKappas env
                  handle (S.UnificationFailure (_,str)) => (raiseError (str,env); [])
               val _ = raiseWarning (substs, affectedSyms)

               val env = if List.null substs then (* do clean up *)
                  let
                     val env = E.popKappa env
                     val env = E.popKappa env
                  in
                     env
                  end
                  else (* do a fixpoint iteration *)
                  let
                     val env = E.equateKappasFlow env
                        handle (S.UnificationFailure (_,str)) => (raiseError (str,env); env)
                     (*val _ = TextIO.print ("popping to usage of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " in " ^ SymbolTable.getString(!SymbolTables.varTable, fid) ^ ":\n" ^ E.topToString env)*)
                     val env = E.popKappa env
                     val env = E.popToUsage (sym, s, env)

                     (* check for infinite refinement due to instantiation; we check
                     this by triggering an occurs check *)
                     val env = E.pushUsage (sym, s, env)
                     val env = E.pushSymbol (sym, s, useFunctionSets, E.LetMono, env)
                     val _ = E.subsetKappas env
                        handle (S.UnificationFailure (kind, str)) =>
                           (case kind of
                              S.Clash => [] (* ignore this, it might stabilize *) 
                            | S.OccursCheck => ((Error.errorAt (errStrm, s, [str,
                                 " when checking call to ",
                                 SymbolTable.getString(!SymbolTables.varTable, sym)]))
                                 ; raise TypeError)
                              )
                     val env = E.popKappa env
                     val env = E.popKappa env
                  in
                     env
                  end

               val env = E.popNested (n1+n2,env)
               val env = E.leaveFunction (fid,env)
               
               val _ = if not verbose then () else
                  TextIO.print ("subset: " ^ #1 (showSubstsSI (substs, TVar.emptyShowInfo)) ^ ", unstable: " ^
                     List.foldl (fn (sym, res) => res ^ ", " ^ SymbolTable.getString
                      (!SymbolTables.varTable, sym)) "" (SymSet.listItems affectedSyms) ^ "\n")

               val _ = raiseWarning (substs, affectedSyms)
            in
               List.null substs 
            end
         val usages = E.getUsages (sym, env)
         (*val _ = TextIO.print ("***** checking subset of " ^ Int.toString (List.length usages) ^ " usages of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")*)
      in
         List.all (checkUsage sym) usages
      end

   (*fun calcIteration (sym, env) =
      let
         fun checkUsage (s, env) =
            let
               val _ = if not verbose then () else
                  TextIO.print ("checkUsage (iter) of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")
               val fid = E.getContextOfUsage (sym, s, env)
               val env = E.enterFunction (fid,env)
               val (n1,env) = E.pushNested (sym, env)
               val (n2,env) = E.pushNested (fid, env)

               (*inform about a unification failure when checking call site
               with definition*)
               fun raiseError (str,env) =
                  let
                     val si = TVar.emptyShowInfo
                     val (sFun, si) = E.kappaToStringSI ((1,0), env, si)
                     val (sCall, si) = E.kappaToStringSI ((2,0), env, si)
                     val env = E.pushTop env
                     val env = E.popToFunction (sym,env)
                  in 
                     (Error.errorAt (errStrm, s, [str,
                     " when checking call to ",
                     SymbolTable.getString(!SymbolTables.varTable, sym),
                     "\n\tcall site has type  " ^ sCall,
                     "\tdefinition has type " ^ sFun]))
                  end

               val env = E.pushUsage (sym, s, env)
               (*val _ = TextIO.print ("pushed usage " ^ SymbolTable.spanToString s ^ " within " ^ SymbolTable.getString(!SymbolTables.varTable, fid) ^ ":\n" ^ E.topToString env)*)

               (* check for infinite refinement due to instantiation; we check
               this by triggering an occurs check *)
               val env = E.pushSymbol (sym, s, useFunctionSets, E.LetMono, env)
               val _ = E.subsetKappas env
                  handle (S.UnificationFailure (kind, str)) =>
                     (case kind of
                        S.Clash => [] (* ignore this, it might stabilize *) 
                      | S.OccursCheck => (raiseError (str,env); raise TypeError)
                     )
               val env = E.popKappa env

               val env = E.pushSymbol (sym, s, useFunctionSets, E.Normal, env)
               (*val _ = TextIO.print ("pushed instance of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ ":\n" ^ E.topToString env)*)

               val env = E.equateKappasFlow env
                  handle (S.UnificationFailure (_,str)) => (raiseError (str,env); env)
               (*val _ = TextIO.print ("popping to usage of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " in " ^ SymbolTable.getString(!SymbolTables.varTable, fid) ^ ":\n" ^ E.topToString env)*)
               val env = E.popKappa env
               val env = E.popToUsage (sym, s, env)
               val env = E.popNested (n1+n2,env)
               val env = E.leaveFunction (fid,env)
            in
               env
            end
         val usages = E.getUsages (sym, env)
         (*val _ = TextIO.print ("***** re-eval of " ^ Int.toString (List.length usages) ^ " usages of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " in" ^ E.topToString env ^ "\n")*)
      in
         List.foldl checkUsage env usages
      end*)

   fun calcGroup printWarn (syms,env) =
         List.foldl (fn (sym,unstable) =>
               (if calcIteration (printWarn,sym,env) then unstable else
                  SymSet.add (unstable, sym))
            ) SymSet.empty syms


   fun calcFixpoints curIter (syms,env) =
         case calcGroup (curIter=Controls.get BasicControl.maxIter) (syms,env) of unstable =>
         if SymSet.isEmpty unstable then env else
         if curIter<Controls.get BasicControl.maxIter then
            calcFixpoints (curIter+1) (syms, env)
         else
         let
            val si = TVar.emptyShowInfo
            fun showSyms (sym, (res, pre, si)) =
               let
                  val sStr = SymbolTable.getString
                     (!SymbolTables.varTable, sym)
                  val env = E.pushSymbol (sym, SymbolTable.noSpan,  useFunctionSets, E.Normal, env)
                  val (sType, si) = E.kappaToStringSI ((1,0), env, si)
                  val env = E.popKappa env
               in
                  (res ^ pre ^ sStr ^ " : " ^ sType, ", ", si)
               end
            val symIds = SymSet.listItems unstable
            val (symsStr, _, _) = List.foldl showSyms ("", "", si) symIds
            val s = case symIds of [] => raise TypeError | (sym :: _) =>
                    SymbolTable.getSpan(!SymbolTables.varTable, sym)
         in 
            (Error.errorAt (errStrm, s, [
            "no typing found for ",
            symsStr,
            "\tpass --maxIter=",
            Int.toString (Controls.get BasicControl.maxIter+1),
            " to try a little harder"]); env)
         end
   val calcFixpoints = calcFixpoints 0

   (*local helper function to infer types for a binding group*)
   fun infRhs (st,env) (sym, dec, guard, args, rhs) =
      let
         fun checkGuard (g,env) =
            let
               val stateVar = VAR (freshTVar (), BD.freshBVar ())
               val guardType = FUN ([stateVar], VEC (CONST 1))
               val env = infExp (st, env) g
               val env = E.pushType (guardType, env)
               val env = E.equateKappas env
               handle S.UnificationFailure str =>
                  refineError (env, str,
                               " when checking guard",
                               [((2,0), "required guard type        "),
                                ((1,0), "guard " ^ showProg (20, PP.exp, g))])
               val env = E.popKappa env
               val env = E.popKappa env
            in
               env
            end
         val env = case guard of SOME g => checkGuard (g,env)
                               | NONE => env

         fun pushDecoderBindings(d,(n, env)) =
            case infDecodepat sym (st,env) d of (nArgs, env) => (n+nArgs, env)
         val (n,env) = List.foldl pushDecoderBindings (0,env) dec
         val env = List.foldl E.pushLambdaVar env args
         (*val _ = if List.null dec then () else
               (TextIO.print "rhs before:\n"; Pretty.pretty (AST.PP.exp rhs); TextIO.print "\n")*)
         val rhs = decsToSeq rhs guard dec
         (*val _ = if List.null dec then () else
               (TextIO.print "rhs after:\n"; Pretty.pretty (AST.PP.exp rhs); TextIO.print "\n")*)
         val env = infExp (st,env) rhs
         val noOfArgs = List.length args
         val env = if noOfArgs=0 then env else E.reduceToFunction (env, noOfArgs)
         val env = E.return (n,env)
      in
         env
      end
   and infBinding (st,env) (sym, args, rhs) =
      let
         val env = E.enterFunction (sym,env)
         val _ = if not verbose then () else
            TextIO.print ("**** infBinding, start: " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")
         val env = infRhs (st,env) (sym, [], NONE, args, rhs)
         val _ = if not verbose then () else
            TextIO.print ("**** infBinding, done: " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")
         val env = E.popToFunction (sym,env)
         val env = E.leaveFunction (sym,env)
      in
         env
      end

   and infDecl stenv (AST.MARKdecl m) = reportError infDecl stenv m
     | infDecl stenv (AST.DECODEdecl dd) = infDecodedecl stenv dd
     | infDecl (st,env) (AST.LETRECdecl (v,l,e)) = 
      if hasSymbol (st,v) then infBinding (st,env) (v, l, e) else env
     | infDecl (st,env) _ = env

   and infDecodedecl (st,env) (v, l, Sum.INL e) =
      if not (hasSymbol (st,v)) then env else
      let
         val _ = if not verbose then () else
            TextIO.print ("**** checking decoder " ^ SymbolTable.getString(!SymbolTables.varTable, v) ^ ":\n")
         val env = E.enterFunction (v,env)
         val env = pushDecoderType (v,getSpan st,env)
         (*val _ = TextIO.print ("**** prev type of decoder " ^ SymbolTable.getString(!SymbolTables.varTable, v) ^ ":\n" ^ E.topToString envPrev)*)
         val env = infRhs (st,env) (v, l, NONE, [], e)
         (*val _ = TextIO.print ("**** new type of decoder " ^ SymbolTable.getString(!SymbolTables.varTable, v) ^ ":\n" ^ E.topToString env)*)
         val env = E.equateKappas env
            handle S.UnificationFailure str =>
               refineError (env, str,
                            " while merging decoder rule",
                            [((2,0), "rules so far "),
                             ((1,0), "next rule    ")])
         val env = E.popKappa env
         val env = E.popToFunction (v,env)
         val env = E.leaveFunction (v,env)
         val env = E.garbageCollect env   
      in
         env
      end
     | infDecodedecl (st,env) (v, l, Sum.INR el) =
      if not (hasSymbol (st,v)) then env else
      let
         val _ = if not verbose then () else
            TextIO.print ("**** checking guarded decoder " ^ SymbolTable.getString(!SymbolTables.varTable, v) ^ ":\n")
         val env = E.enterFunction (v,env)
         val env = List.foldl
            (fn ((guard, rhs), env) => let
               val env = pushDecoderType (v,getSpan st,env)
               val env = infRhs (st,env) (v, l, SOME guard, [], rhs)
               val env = E.equateKappas env
                  handle S.UnificationFailure str =>
                     refineError (env, str,
                                  " while merging guarded decoder rule",
                                  [((2,0), "rules so far "),
                                   ((1,0), "next rule    ")])
               val env = E.popKappa env
               val env = E.popToFunction (v, env)
            in
               env
            end) env el
         val env = E.leaveFunction (v,env)
         val env = E.garbageCollect env   
      in
         env
      end

   and infExp stenv (AST.MARKexp m) = reportError infExp stenv m
     | infExp (st,env) (AST.LETRECexp (l,e)) =
      let                                              
         val names = List.map topLetrecDecl l
         val env = E.pushGroup (List.concat names, env)
         val sccs = List.rev (sccsLetrec l)
         val _ = if not verbose then () else
            TextIO.print ("**** checking let-rec " ^ List.foldl (fn (c,str) => str ^ prComp c) "" sccs ^ ":\n")

         val env = List.foldl (fn (comp,env) =>
            let
               val st = addComponent (comp,st)
               val env = List.foldl (fn ((v,l,e),env) =>
                              (if not (hasSymbol (st,v)) then env else
                                 infBinding (st, env) (v, l, e))
                              handle TypeError => E.cleanEnvironment env) env l
               val _ = if not verbose then () else
                  TextIO.print ("**** after checking local components " ^ prComp comp ^ "\n")
               val env = case comp of
                    SCC.SIMPLE _ => env
                  | SCC.RECURSIVE syms => calcFixpoints (syms, env)
                              handle TypeError => E.cleanEnvironment env
               in
                  env
               end
            ) env sccs
         (*any local definition that has called a symbol in st must be added
         to st when checking the body; we are lazy and add them all*)
         val st' = List.foldl addComponent st sccs
         val env = infExp (st',env) e
         (*val _ = TextIO.print ("infExp before popGroup: " ^ E.topToString env ^ "\n")*)
         val (badSizes, env) = E.popGroup (env, true)
         (*do not report bad sizes here since we must first calculate a
         fixpoint to instantiate all variables maximally*)
      in
         env
      end
     | infExp (st,env) (AST.IFexp (e1,e2,e3)) =
      let
         val _ = if not verbose then () else
            TextIO.print ("**** if-expresssion\n")
         val env = E.pushType (VEC (CONST 1), env)
         val env = infExp (st,env) e1
         val env = E.equateKappas env
         val env = E.popKappa env
         val env = E.popKappa env
         
         val env = E.pushTop env
         val env = infExp (st,env) e2
         (*val _ = TextIO.print ("**** after if-then:\n" ^ E.topToString env)*)
         val env = E.equateKappasFlow env
         val env = E.popKappa env
         val env = infExp (st,env) e3
         (*val _ = TextIO.print ("**** after if-else:\n" ^ E.topToString env)*)
         val env = E.equateKappasFlow env
                  handle S.UnificationFailure str =>
                     refineError (env, str,
                                  " in the branches of if-statment",
                                  [((2,0), "then-branch "),
                                   ((1,0), "else-branch ")])
         val env = E.popKappa env
         (*val _ = TextIO.print ("**** after if-merge:\n" ^ E.topToString env)*)
      in
         env
      end
     | infExp (st,env) (AST.CASEexp (e,l)) =
      let
         val _ = if not verbose then () else
            TextIO.print ("**** case expression " ^ showProg (20, PP.exp, AST.CASEexp (e,l)) ^ "\n")
         val (caseExpSymId,env) = E.acquireTempSymbol env
         val (t,env) = E.pushLambdaVar' (caseExpSymId, env)
         val env = infExp (st,env) e
         val _ = if not verbose then () else
            TextIO.print ("**** after case exp:\n")
         val env = E.equateKappas env
                  val _ = if not verbose then () else
            TextIO.print ("**** after case dup:\n")
         val env = E.popKappa env
         val envNeutral = E.pushTop env
         fun genFlow ((p,exp), env) =
            let
               val env = infMatch (st,env,caseExpSymId) (p,exp)
               val env = E.equateKappasFlow env
                  handle S.UnificationFailure str =>
                     refineError (env, str,
                                  " while checking right-hand-side of branches",
                                  [((2,0), "branches so far               "),
                                   ((1,0), showProg (30, PP.exp, exp))])
               val env = E.popKappa env
               val env = E.reduceFlow env
            in
               env
            end
         val env = List.foldl genFlow envNeutral l
         val env = E.releaseTempSymbol (caseExpSymId,env) 
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
         val _ = if not verbose then () else
            TextIO.print ("**** application: " ^ showProg (20, PP.exp, AST.APPLYexp (e1,es2)) ^ "\n")
         val noOfArgs = List.length es2
         
         val env = infExp (st,env) e1

(*            if (case pm of ArgPos => false | FunPos => useSets | _ => raise InferenceBug) then
               let
                  val (k,env) = Scope.acquireKappa env
                  val (k',env) = Scope.acquireKappa env
                  val tt = Scope.getTypeTable env
                  val tVar = TVar.freshTVar ()
                  val _ = TT.addSymbol (k, VAR (tVar, BD.freshBVar ()), tt)
                  val _ = TT.addSymbol (k', SET (VAR (TVar.freshTVar (), BD.freshBVar ()), [(span, VAR (tVar, BD.freshBVar ()))]), tt)
                  (*val _ =TextIO.print ("pushSymbol: equating to set:\n" ^ #1 (TT.dumpTableSI (tt,TVar.emptyShowInfo)))*)
                  val _ = TT.equateSymbolsFlow (k',sym,tt)
                  val _ = TT.delSymbol (k', tt)
                  val env = Scope.releaseKappa (k',env)
                  val env = Scope.wrap (KAPPA {kappa = k}, env)
               in
                  env
               end
            else'
*)
         val env = List.foldl (fn (e2,env) => infExp (st,env) e2) env es2

         val ctxt = E.getCtxt env
         val _ = if List.all (fn x => SOME (SymbolTable.toInt x)<>debugSymbol) ctxt then () else
                 TextIO.print ("**** app func:\n" ^ E.topToString env)

         (* Expand each argument of the function to a set if the function type requires that. *)
         val env = E.expandArguments (env,noOfArgs)

         val env = E.pushTop env
         val env = E.reduceToFunction (env, noOfArgs)
         val _ = if List.all (fn x => SOME (SymbolTable.toInt x)<>debugSymbol) ctxt then () else
                 TextIO.print ("**** app arg:\n" ^ E.topToString env)

         (*val _ = TextIO.print ("**** app turning arg:\n" ^ E.topToString env)*)
         (* make the result of the call-site depend on the result of the
         function; the flow expressing that formal parameters depend on actual
         parameters follows from contra-variance*)
         val env = E.flipKappas env
         val env = E.equateKappas env
            handle S.UnificationFailure str =>
               refineError (env, str,
                            " while passing",
                            (#1 (List.foldr
                            (fn (e2,(res,argNo)) => 
                              (((2,argNo), "argument    " ^ showProg (20, PP.exp, e2))::res,
                               argNo-1)
                            ) ([], noOfArgs) es2)) @
                            [((1,0), "to function " ^ showProg (20, PP.exp, e1))])

         val env = E.popKappa env
         (*val _ = TextIO.print ("**** app fun,res unified:\n" ^ E.topToString env)*)
         val env = E.reduceToResult env
      in
         env                                                         
      end
        
     | infExp (st,env) (AST.RECORDexp l) =
      let
         val _ = if not verbose then () else
            TextIO.print ("**** record constant " ^ showProg (20, PP.exp, AST.RECORDexp l) ^ "\n")
         val t = freshVar ()
         val env = E.meetBoolean (BD.meetVarZero (bvar t), env)
         val env = E.pushType (t, env)
         fun pushField ((fid,e), (nts, env)) =
            let
               val env = infExp (st,env) e
               val bVar = BD.freshBVar ()
               (*val env = E.meetBoolean (BD.meetVarOne bVar, env)*)
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
         val _ = if not verbose then () else
            TextIO.print ("**** record selector " ^ showProg (20, PP.exp, AST.SELECTexp f) ^ "\n")
         val env = E.pushTop env
         val tf = freshVar ()
         val tf' = newFlow tf
         val env = E.pushType (tf, env)
         val exists = BD.freshBVar ()
         (*val _ = TextIO.print ("**** before rec reduce:\n" ^ E.toString env ^ "\n")*)
         val env = E.reduceToRecord ([(exists, f)], env)
         val env = E.meetBoolean (BD.meetVarImpliesVar (bvar tf', bvar tf) o
                                  BD.meetVarOne exists, env)
         (*val _ = TextIO.print ("**** after rec reduce:\n" ^ E.toString env ^ "\n")*)
         val env = E.pushType (tf', env)
         val env = E.reduceToFunction (env,1)
         (*val _ = TextIO.print ("**** rec selector:\n" ^ E.topToString env ^ "\n")*)
      in
         env
      end
     | infExp (st,env) (AST.UPDATEexp fs) =
      let
         val _ = if not verbose then () else
            TextIO.print ("**** record update " ^ showProg (20, PP.exp, AST.UPDATEexp fs) ^ "\n")
         val fieldsVar = freshVar ()
         val env = E.pushType (fieldsVar, env)
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
         val env = E.pushType (fieldsVar', env)
         fun pushOutField ((fid,eOpt), (nts, env)) =
            let
               (*val _ = TextIO.print ("**** rec update: pushing field " ^ SymbolTable.getString(!SymbolTables.fieldTable, fid) ^ ".\n")*)
               val bVar = BD.freshBVar ()
               val env = case eOpt of
                           SOME e => infExp (st,env) e
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
         val _ = if not verbose then () else
            TextIO.print ("**** identifier " ^ showProg (20, PP.exp, AST.IDexp v) ^ "\n")
         val env = E.pushSymbol (v, getSpan st,  useFunctionSets,
              if hasRecursiveSymbol (st,v) then E.LetForw else E.Normal, env)

         val ctxt = E.getCtxt env
         val _ = if List.all (fn x => SOME (SymbolTable.toInt x)<>debugSymbol) ctxt then () else
                 TextIO.print ("**** after pushing symbol " ^ SymbolTable.getString(!SymbolTables.varTable, v) ^ ":\n" ^ E.topToString env)
      in
         env
      end
     | infExp (st,env) (AST.CONexp c) =
      let
         val _ = if not verbose then () else
            TextIO.print ("**** constructor " ^ showProg (20, PP.exp, AST.CONexp c) ^ "\n")
         val dcon = SymMap.lookup (conParents, c)
         val { tdVars = vs, tdCons = cs } = SymMap.lookup (typeDefs, dcon)
         val vs = SymMap.listItems vs
         val tArgOpt = SymMap.lookup (cs, c)
         val env =
            case tArgOpt of
                 NONE => E.pushType (ALG (dcon, List.map (fn (v,bv) => VAR (TVar.freshTVar (),BD.freshBVar ())) vs), env)
               | SOME t =>
            let
               (*val _ = TextIO.print ("**** instantiating constructor " ^ SymbolTable.getString(!SymbolTables.conTable, c) ^ ":\n")*)
               val ty = FUN ([t],ALG (dcon, List.map VAR vs))
               val vs = texpVarset (ty,TVar.empty)
               val ty = replaceTVars (ty,map (fn v => (v,TVar.freshTVar ())) (TVar.listItems vs))
               val ty = setFlagsToTop ty
               val env = E.pushType (ty, env)
               val env = E.genConstructorFlow (false,env)
               (*val _ = TextIO.print ("**** done instantiating constructor " ^ SymbolTable.getString(!SymbolTables.conTable, c) ^ ":\n")*)
            in
               env
            end
         (*val _ = TextIO.print ("**** looking for " ^ SymbolTable.getString(!SymbolTables.conTable, c) ^ ":\n" (*^ E.topToString env*))*)
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
         (S.UnificationFailure (S.Clash, "last statement in a sequence may not bind a variable"))
     | infSeqexp stenv (AST.MARKseqexp m :: l) =
         reportError (fn stenv => fn e => infSeqexp stenv (e :: l)) stenv m
     | infSeqexp (st,env) [AST.ACTIONseqexp e] =
      let
         val _ = if not verbose then () else
            TextIO.print ("**** final monadic action " ^ showProg (20, PP.seqexp, AST.ACTIONseqexp e) ^ "\n")
         val env = infExp (st,env) e
         val resTy = freshVar ()
         val inpTy = freshVar ()
         val outTy = freshVar ()
         val env = E.pushType (MONAD (resTy,inpTy,outTy),env)
         (*val _ = TextIO.print ("monadic actions: expression matched against monad type:" ^ E.topToString env ^ "\n")*)
         val env = E.equateKappas env
      in
         E.popKappa env
      end
     | infSeqexp (st,env) (s :: l) =
      let
         val _ = if not verbose then () else
            TextIO.print ("**** inner monadic action " ^ showProg (20, PP.seqexp, s) ^ "\n")
         val (bind, vOpt,e) = case s of
               AST.ACTIONseqexp e => (bindSymId, NONE, e)
             | AST.BINDseqexp (v,e) => (bindASymId, SOME v, e)
             | _ => raise TypeError
         val env = E.pushSymbol (bind, getSpan st,  useFunctionSets, E.Normal, env)
         val env = infExp (st,env) e
         val env = E.pushTop env
         val env = E.reduceToFunction (env,1)
         val env = E.flipKappas env
         (*val _ = TextIO.print ("function to unify with bind: " ^ E.topToString env ^ "\n")*)
         val env = E.equateKappasFlow env
            handle S.UnificationFailure (kind, str) =>
               raise S.UnificationFailure (kind, str ^ " in statement\n\t" ^
                   showProg (20, PP.exp, e) ^ " : " ^
                   #1 (E.kappaToStringSI ((1,1), env, TVar.emptyShowInfo)))
         val env = E.popKappa env
         val env = E.reduceToResult env
         val env = case vOpt of
                 SOME v => E.reduceToFunction (infSeqexp (st, E.pushLambdaVar (v,env)) l,1)
               | NONE => infSeqexp (st, env) l
         val env = E.pushTop env
         val env = E.reduceToFunction (env,1)
         (*val _ = TextIO.print ("monadic actions: before flipping fun and res\n")*)
         val env = E.flipKappas env
         val env = E.equateKappasFlow env
            handle S.UnificationFailure str =>
               refineError (env, str,
                            " when merging the requirements gathered after",
                            [((1,1), "statement " ^ showProg (21, PP.exp, e)),
                             ((2,1), "with the following transformer ")])
         val env = E.popKappa env
         val env = E.reduceToResult env
         (*val _ = TextIO.print ("monadic actions: after reducing to res\n")*)
      in
         env
      end

   and infDecodepat sym stenv (AST.MARKdecodepat m) =
      reportError (infDecodepat sym) stenv m
      | infDecodepat sym (st, env) (AST.TOKENdecodepat t) = infTokpat sym (st, env) t
     | infDecodepat sym (st,env) (AST.BITdecodepat l) =
      let
         val env = E.pushWidth (sym, env)
         (*val _ = TextIO.print ("**** decpat pushing granularity:\n" ^ E.topToString env)*)
         val env = List.foldl (fn (b,env) => infBitpatSize (st,env) b)
                                 env l
         (*val _ = TextIO.print ("**** decpat pushing " ^ Int.toString(List.length l) ^ " sizes:\n" ^ E.topToString env)*)
         val env = E.reduceToSum (List.length l,env)
         (*val _ = TextIO.print ("**** decpat sum:\n" ^ E.topToString env)*)
         val env = E.equateKappas env
            handle S.UnificationFailure str =>
               refineError (env, str,
                            " when checking bits in token",
                            [((2,0), "previous patterns                     "),
                             ((1,0), "pattern " ^ showProg (30, PP.decodepat, (AST.BITdecodepat l)))])
         val env = E.popKappa env
         val env = E.popKappa env
      in
         List.foldl (fn (b,(n,env)) => case infBitpat (st,env) b of
                        (nArgs, env) => (n+nArgs, env)) (0, env) l
      end
   and infBitpatSize stenv (AST.MARKbitpat m) =
         reportError infBitpatSize stenv m
     | infBitpatSize (st,env) (AST.BITSTRbitpat str) =
         E.pushType (CONST (getBitpatLitLength str), env)
     | infBitpatSize (st,env) (AST.NAMEDbitpat v) = E.pushWidth (v,env)
     | infBitpatSize (st,env) (AST.BITVECbitpat (v,s)) =
         E.pushType (CONST (getBitpatLitLength s), env)
   and infBitpat stenv (AST.MARKbitpat m) = reportError infBitpat stenv m
     | infBitpat (st,env) (AST.BITSTRbitpat str) = (0,env)
     | infBitpat (st,env) (AST.NAMEDbitpat v) = (0,env)
     | infBitpat (st,env) (AST.BITVECbitpat (v,s)) =
      let
         val env = E.pushLambdaVar (v,env)
         val env = E.pushSymbol (v, getSpan st, useFunctionSets, if hasSymbol (st,v) then E.LetForw else E.Normal, env)
         val env = E.pushType (VEC (CONST (getBitpatLitLength s)), env)
         val env = E.equateKappas env
         val env = E.popKappa env
         val env = E.popKappa env
      in
         (1, env)
      end
   and infTokpat sym stenv (AST.MARKtokpat m) = reportError (infTokpat sym) stenv m
     | infTokpat sym (st,env) (AST.TOKtokpat (size,i)) =
      let
         val env = E.pushType (CONST size, env)
         val env = E.pushWidth (sym, env)
         val env = E.equateKappas env
            handle S.UnificationFailure str =>
              refineError (env, str,
                          " when checking decoder",
                          [((1,0), "decoder " ^ SymbolTable.getString(!SymbolTables.varTable, sym)),
                           ((2,0), "token   " ^ showProg (20, PP.tokpat, AST.TOKtokpat (size,i)))])
         val env = E.popKappa env
         val env = E.popKappa env
      in
        (0, env)
      end
     | infTokpat sym (st,env) (AST.NAMEDtokpat v) =
      let
         val env = E.pushWidth (v, env)
         val env = E.pushWidth (sym, env)
         val env = E.equateKappas env
         handle S.UnificationFailure str =>
            refineError (env, str,
                        " when checking decoder",
                        [((1,0), "decoder " ^ SymbolTable.getString(!SymbolTables.varTable, sym)),
                         ((2,0), "sub-decoder     " ^ showProg (20, PP.tokpat, (AST.NAMEDtokpat v)))])
         val env = E.popKappa env
         val env = E.popKappa env
      in
         (0, env)
      end
   and infMatch (st,env,caseExpSymId) (p,e) =
      let
         val (n,env) = infPat (st,env) p
         (*val _ = TextIO.print ("**** after pat:\n" ^ E.topToString env)*)
         val env = E.pushSymbol (caseExpSymId, SymbolTable.noSpan, useFunctionSets, E.Normal, env)
         (*val _ = TextIO.print ("**** after case dup:\n" ^ E.topToString env)*)
         val env = E.equateKappasFlow env
            handle S.UnificationFailure str =>
               refineError (env, str,
                            " when checking case scrutinee",
                            [((1,0), "scrutinee and patterns so far "),
                             ((2,0),     "pattern " ^ showProg (22, PP.pat, p))])
         (*val _ = TextIO.print ("**** after mgu:\n" ^ E.topToString env)*)
         val env = E.popKappa env
         val env = E.popKappa env
         val env = infExp (st,env) e
         (*val _ = TextIO.print ("**** after expr:\n" ^ E.topToString env)*)
      in
         E.return (n,env)
      end

   and infPat stenv (AST.MARKpat m) = reportError infPat stenv m
     | infPat (st,env) (AST.INTpat lit) = (0, E.pushType (ZENO, env))
     | infPat (st,env) (AST.IDpat v) =
      let
         val (t, env) = E.pushLambdaVar' (v,env)
         val t' = newFlow t
         val env = E.meetBoolean (BD.meetVarImpliesVar (bvar t, bvar t'), env)
      in
         (1, E.pushType (t', env))
      end
     | infPat (st,env) (AST.CONpat (c, SOME p)) =
      let
         val (n,env) = infPat (st,env) p
         val env = E.pushTop env
         val env = E.reduceToFunction (env,1)

         val dcon = SymMap.lookup (conParents, c)
         val { tdVars = vs, tdCons = cs } = SymMap.lookup (typeDefs, dcon)
         val vs = SymMap.listItems vs
         val t =
            case SymMap.lookup (cs, c) of
                 NONE => raise S.UnificationFailure (S.Clash, 
                  "pattern with constructor " ^
                  SymbolTable.getString(!SymbolTables.conTable, c) ^ 
                  " may not have an argument")
               | SOME t => t
         val ty = FUN ([t],ALG (dcon, List.map VAR vs))
         val vs = texpVarset (ty,TVar.empty)
         val ty = replaceTVars (ty,map (fn v => (v,TVar.freshTVar ())) (TVar.listItems vs))
         val ty = setFlagsToTop ty
         val env = E.pushType (ty, env)
         val env = E.genConstructorFlow (true,env)

         val env = E.flipKappas env
         val env = E.equateKappasFlow env

         (*val (pStr, si) = E.topToStringSI (envPat, TVar.emptyShowInfo)
         val (cStr, si) = E.topToStringSI (E.return (1,env), si)
         val (rStr, si) = E.topToStringSI (E.popKappa env, si)
         val _ = TextIO.print ("**** pattern: payload to type is:\n" ^ pStr)
         val _ = TextIO.print ("**** pattern: constructor type is:\n" ^ cStr)
         val _ = TextIO.print ("**** pattern: resulting type is:\n" ^ rStr)*)

         val env = E.popKappa env
         val env = E.reduceToResult env
      in
         (n, env)
      end
     | infPat (st,env) (AST.CONpat (c, NONE)) =
         (0, infExp (st,env) (AST.CONexp c))
     | infPat (st,env) (AST.BITpat l) =
      let
         val (n,env) = List.foldl (fn (b,(n,env)) => case infBitpat (st,env) b of
                        (nArgs, env) => (n+nArgs, env)) (0, env) l
         val env = List.foldl (fn (b,env) => infBitpatSize (st,env) b)
                                 env l
         val env = E.reduceToSum (List.length l,env)
         val env = E.constToVec env
      in
         (n,env)
      end
     | infPat (st,env) (AST.WILDpat) = (0, E.pushTop env)
   and infLit (st,env) (AST.INTlit i) = E.pushType (ZENO, env)
     | infLit (st,env) (AST.FLTlit f) = E.pushType (FLOAT, env)
     | infLit (st,env) (AST.STRlit str) = E.pushType (STRING, env)
     | infLit (st,env) (AST.VEClit str) =
         E.pushType (VEC (CONST (getBitpatLitLength str)), env)

   (*enforce the size constraints of the primitives*)
   val primEnv = E.primitiveEnvironment (Primitives.getSymbolTypes (),
                  SizeConstraint.fromList Primitives.primitiveSizeConstraints)
   (*val primEnv = E.primitiveEnvironment ([], SizeConstraint.fromList [])*)

   val toplevelEnv = E.pushGroup (toplevelDecls ast, primEnv)
   
   val sccs = List.rev (sccsSpecification ast)
   
   (* turn off type inference if requested *)
   val sccs = if Controls.get BasicControl.skipTypeCheck then [] else sccs
   
   val noOfSCCs = List.length sccs
   val cnt = ref 0
   
   (*val _ = TextIO.print ("SCCs:\n" ^ List.foldl (fn (c,str) => str ^ prComp c) "" sccs)*)

   val toplevelEnv = List.foldl (fn (comp,env) =>
      let
         val str = "completed " ^ Int.toString (!cnt div noOfSCCs) ^ "% (" ^ (case comp of
              SCC.SIMPLE sym => SymbolTable.getString(!SymbolTables.varTable, sym)
            | SCC.RECURSIVE (sym :: _) => SymbolTable.getString(!SymbolTables.varTable, sym)
            | SCC.RECURSIVE _ => "") ^ ")\r"
         val _ = TextIO.print str
         
         val env = E.garbageCollect env   
         val _ = if not verbose then () else
               TextIO.print ("before checking component " ^ prComp comp ^ "\n")
         val env = List.foldl (fn (d,env) =>
                        infDecl ({span = SymbolTable.noSpan,
                                  component = [comp]},env) d
                   ) env ast
         val env = case comp of
              SCC.SIMPLE sym => E.markAsStable (sym, env)
            | SCC.RECURSIVE syms => foldl E.markAsStable env syms
         (*val _ = TextIO.print ("after checking component " ^ prComp comp ^  E.topToString env)*)
         val env = (case comp of
              SCC.SIMPLE _ => env
            | SCC.RECURSIVE syms => calcFixpoints (syms, env)
            ) handle TypeError => env

         val env = case comp of
              SCC.SIMPLE sym => E.clearUses (sym, env)
            | SCC.RECURSIVE syms => foldl E.clearUses env syms
         
         val _ = TextIO.print (String.implode (List.tabulate (String.size str, fn _ => #" ") @ [#"\r"]))
         val _ = cnt := (!cnt + 100)
      in
         env
      end
      ) toplevelEnv sccs

   (* check if all exported functions can take on the declared type *)
   fun checkExport (s,sym,(params,ty),env) =
      let
         (*val _ = TextIO.print ("checking export of " ^
            SymbolTable.getString(!SymbolTables.varTable, sym) ^
            " with type " ^ #1 (showTypeSI (ty,TVar.emptyShowInfo)) ^ "\n")*)

         (* rename all type variables *)
         val tvarsMap = List.map (fn t => (t,TVar.freshTVar ()))
            (TVar.listItems (texpVarset (ty, TVar.empty)))
         val ty = replaceTVars (ty, tvarsMap)
         val params = List.map (fn (p,bVar) =>
            case List.find (fn (orig,repl) => TVar.eq (p,orig)) tvarsMap of
               SOME (orig,repl) => (repl,bVar)
             | NONE => (p,bVar)
            ) params

         val env = E.meetBoolean (fn bFun => 
            texpConstructorFlow params false ty bFun, env)

         (* check that the type structure is unifiable *)
         val env = E.pushSymbol (sym,s,false,E.LetMono,env)
         val env = E.pushType (ty,env)
         val env = E.equateKappas env
            handle S.UnificationFailure str =>
            (refineError (env, str,
                         " when checking export declaration of " ^
                         SymbolTable.getString(!SymbolTables.varTable, sym),
                         [((2,0), "inferred type      "),
                          ((1,0), "export declaration ")])
               handle S.UnificationFailure (kind, str) =>
                  Error.errorAt (errStrm, s, [str])
            ;env)

         val env = E.popKappa env
         val env = E.popKappa env
      in
         env
      end

   fun checkExports _ (AST.MARKdecl {span=s, tree=t},env) = checkExports s (t,env)
     | checkExports s (AST.EXPORTdecl (sym,_,_),env) =
        checkExport (s,sym,case SymMap.find (exportTypes,sym) of SOME ty => ty | NONE =>
           (TextIO.print ("can't find exported type of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^"\n"); raise TypeError),env)
     | checkExports s (_,env) = env
   val toplevelEnv = List.foldl (checkExports SymbolTable.noSpan) toplevelEnv ast
   
   (*val _ = TextIO.print ("toplevel environment:\n" ^ E.toString toplevelEnv)*)
   (*val _ = TextIO.print ("table:\n" ^ #1 (E.dumpTypeTableSI (toplevelEnv, TVar.emptyShowInfo)))*)

   val (badSizes, primEnv) = E.popGroup (toplevelEnv, false)
   val _ = reportBadSizes badSizes
   val (badSizes, _) = E.popGroup (primEnv, false)
   val _ = reportBadSizes badSizes
   val _ = E.finalize ()
   val _ = TVar.set var_counter
   in
      toplevelEnv
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
         handle TypeError =>
            E.pushGroup ([], E.primitiveEnvironment ([], []))
         )
      )
   end
   
   val showTable = E.topToString

end
