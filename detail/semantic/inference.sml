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

   (*a type error has been observed an reported, analysis should continue*)
   exception TypeError

   infix >>= >>
   
   type rhsInfo = (SymbolTable.symid *
                   (*pattern and guard for decode function*)
                   (AST.decodepat list * AST.exp option) option *
                   AST.var_bind list *       (*arguments*)
                   AST.exp)


fun typeInferencePass (errStrm, ti : TI.type_info, ast) = let
   val st = ref (SMap.empty : E.symbol_type SMap.map)
   val { tsynDefs, typeDefs, conParents} = ti
   
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
         val _ = TextIO.print ("after pushing args:\n" ^ E.topToString env)
         val env = infExp (st,env) rhs
         val _ = TextIO.print ("before popping args:\n" ^ E.topToString env)
         val env = List.foldr (fn (_,env) => E.reduceToFunction env) env args
         (*val _ = TextIO.print ("after popping args:\n" ^ E.topToString env)*)
         val env = E.popToFunction (sym, env)
         (*val _ = TextIO.print ("after popping fun:\n" ^ E.topToString env)*)
         val stable = true
      in
         if stable then env else calcFixpoint (st, env) (sym, dec, args, rhs)
      end
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
(*   and infCondecl stenv (AST.MARKcondecl m) =
       AST.MARKcondecl (reportError infCondecl m)
     | infCondecl stenv (AST.CONdecl (c,to)) = AST.CONdecl
       (newCon (s,c), case to of NONE => NONE | SOME t => SOME (infTy stenv t))
   and infTy stenv (AST.MARKty m) = AST.MARKty (reportError infTy m)
     | infTy stenv (AST.BITty i) = AST.BITty i
     | infTy stenv (AST.NAMEDty n) = AST.NAMEDty (useType (s,n))
     | infTy stenv (AST.RECty l) = AST.RECty
       (List.map (fn (f,t) => (newField (s,f), infTy stenv t)) l)*)
   and infExp stenv (AST.MARKexp m) = reportError infExp stenv m
(*     | infExp (st,env) (AST.LETexp (l,e)) = AST.LETexp (let
         val _ = startScope ()
         val _ = List.map (regValuedecl s) l
         val l = List.map (infValuedecl s) l
         (*val _ = TextIO.print ("before e2:\n" ^ SymbolTable.toString(!ST.varTable) ^ "\n");*)
         val r = infExp (st,env) e
         val _ = endScope ()
         (*val _ = TextIO.print ("after e2:\n" ^ SymbolTable.toString(!ST.varTable) ^ "\n");*)
       in (l,r) end)
     | infExp (st,env) (AST.IFexp (e1,e2,e3)) = AST.IFexp
         (infExp (st,env) e1, infExp (st,env) e2, infExp (st,env) e3)
     | infExp (st,env) (AST.CASEexp (e,l)) = AST.CASEexp
         (infExp (st,env) e, List.map (infMatch s) l)
     | infExp (st,env) (AST.ANDALSOexp (e1,e2)) = AST.ANDALSOexp
         (infExp (st,env) e1, infExp (st,env) e2)
     | infExp (st,env) (AST.ORELSEexp (e1,e2)) = AST.ORELSEexp
         (infExp (st,env) e1, infExp (st,env) e2)
     | infExp (st,env) (AST.BINARYexp (e1, opid,e2)) = AST.BINARYexp
         (infExp (st,env) e1, useVar (s,{ span = s, tree = opid }), infExp (st,env) e2)*)
    | infExp (st,env) (AST.APPLYexp (e1,e2)) =
      let
         val envFun = infExp (st,env) e1
         val envArg = infExp (st,env) e2
         val envArg = E.pushTop envArg
         val envArg = E.reduceToFunction envArg
         val (env,_) = E.meet (envFun, envArg)
         (*val _ = TextIO.print ("after meet: " ^ E.toString env)*)
      in
         E.reduceToResult env
      end
        
(*     | infExp (st,env) (AST.RECORDexp l) = AST.RECORDexp
         (List.map (fn (f,e) => (newField (s,f), infExp (st,env) e)) l)
     | infExp (st,env) (AST.SELECTexp f) = AST.SELECTexp (useField (s,f))
     | infExp (st,env) (AST.UPDATEexp fs) =
        AST.UPDATEexp (List.map (fn (f,e) => (useField (s,f), infExp (st,env) e)) fs)
     | infExp (st,env) (AST.LITexp lit) = AST.LITexp (infLit (st,env) lit)
     | infExp (st,env) (AST.SEQexp l) = AST.SEQexp (infSeqexp (st,env) l)*)
     | infExp (st,env) (AST.IDexp v) = E.pushSymbol (v, getSpan st, env)
     | infExp (st,env) (AST.CONexp c) =
      let
         val dcon = SymMap.lookup (conParents, c)
         val { tdVars = vs, tdCons = cs } = SymMap.lookup (typeDefs, dcon)
         val tArgOpt = SymMap.lookup (cs, c)
      in
         case tArgOpt of
              NONE => E.pushRenamedType (ALG (dcon, List.map VAR vs), env)
            | SOME t =>
               E.pushRenamedType (FUN (t,ALG (dcon, List.map VAR vs)), env)
      end
(*     | infExp (st,env) (AST.FNexp (v, e)) = AST.FNexp (newVar (s,v), infExp (st,env) e)
   and infSeqexp stenv [] = []
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
     | infTokpat stenv (AST.NAMEDtokpat v) = AST.NAMEDtokpat (useVar (s,v))
   and infMatch stenv (AST.MARKmatch m) =
       AST.MARKmatch (reportError infMatch m)
     | infMatch stenv (AST.CASEmatch (p,e)) =
       AST.CASEmatch (infPat stenv p, infExp stenv e)
   and infPat stenv (AST.MARKpat m) =
       AST.MARKpat (reportError infPat m)
     | infPat stenv (AST.BITpat str) = AST.BITpat str
     | infPat stenv (AST.LITpat lit) = AST.LITpat (infLit stenv lit)
     | infPat stenv (AST.IDpat v) = AST.IDpat (newVar (s,v))
     | infPat stenv (AST.CONpat (c, SOME p)) = AST.CONpat (useCon (s,c), SOME (infPat stenv p))
     | infPat stenv (AST.CONpat (c, NONE)) = AST.CONpat (useCon (s,c), NONE)
     | infPat stenv (AST.WILDpat) = AST.WILDpat
   and infLit stenv (AST.INTlit i) = AST.INTlit i
     | infLit stenv (AST.FLTlit f) = AST.FLTlit f
     | infLit stenv (AST.STRlit str) = AST.STRlit str*)

   val primEnv = E.primitiveEnvironment (Primitives.getSymbolTypes ())
   val toplevelEnv = E.pushGroup
      (List.foldl (op @) []
         (List.map topDecl (#tree (ast : SpecAbstractTree.specification)))
      , primEnv)
   (*val _ = TextIO.print ("toplevel environment:\n" ^ E.toString toplevelEnv)*)
   val toplevelEnv = List.foldl (fn (d,env) =>
         infDecl ({span = SymbolTable.noSpan, error = false},env) d)
         toplevelEnv
         (#tree (ast : SpecAbstractTree.specification))
   val (toplevelSymbols, primEnv) = E.popGroup toplevelEnv
   val (primSymbols, _) = E.popGroup primEnv
   in
      ( st := List.foldl SMap.insert' (!st) (toplevelSymbols @ primSymbols)
      ; SMap.listItemsi (!st))
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
