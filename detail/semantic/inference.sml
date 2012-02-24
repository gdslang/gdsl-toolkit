(**
 * ## Perform Type Inference
 *
 * Returns tables with types of each identifier.
 *)
structure TypeInference : sig

   datatype symbol_type =
        MONO of {symType : Types.texp}
      | POLY of {symType : Types.texp, usages : Types.texp list}
   
   type symbol_types = symbol_type AtomRedBlackMap.map
       
   val typeInferencePass: (Error.err_stream * SpecAbstractTree.specification) -> symbol_types
   val run: SpecAbstractTree.specification -> symbol_types CompilationMonad.t
   
end = struct

   datatype symbol_type =
        MONO of {symType : Types.texp}
      | POLY of {symType : Types.texp, usages : Types.texp list}

   type symbol_types = symbol_type AtomRedBlackMap.map

   structure AST = SpecAbstractTree
   structure ST = AtomRedBlackMap
   structure E = Environment
   structure BD = BooleanDomain
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

   structure SIMap = RedBlackMapFn (
      struct
         type ord_key = SymbolTable.symid
         val compare = SymbolTable.compare_symid
      end)

fun typeInferencePass (errStrm, ast) = let
   val st = ref (ST.empty : symbol_types)
   
   fun reportError conv ({span = _, error = isErr }, env) {span=s, tree=t} =
      conv ({span = s, error = isErr},env) t
      handle (UnificationFailure str) =>
         (Error.errorAt (errStrm, s, [str]); raise TypeError)
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
   
   val toplevelEnv = E.primitiveEnvironment (Primitives.getSymbolTypes ())
   val toplevelEnv = E.pushGroup
      (List.foldl (op @) []
         (List.map topDecl (#tree (ast : SpecAbstractTree.specification)))
      , toplevelEnv)

   (* define a second traversal that is a full inference of the tree *)
   fun calcFixpoint stenv (sym, mDec, args, rhs) =
      let
         fun runFixpoint (st,env) = let
            val env = E.pushTop env
            val (stable, env) = E.popToFunction (sym, env)
         in
            if stable then env else runFixpoint (st,env)
         end
      in
         runFixpoint stenv
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
(*   and infCondecl env (AST.MARKcondecl m) =
       AST.MARKcondecl (reportError infCondecl m)
     | infCondecl env (AST.CONdecl (c,to)) = AST.CONdecl
       (newCon (s,c), case to of NONE => NONE | SOME t => SOME (infTy env t))
   and infTy env (AST.MARKty m) = AST.MARKty (reportError infTy m)
     | infTy env (AST.BITty i) = AST.BITty i
     | infTy env (AST.NAMEDty n) = AST.NAMEDty (useType (s,n))
     | infTy env (AST.RECty l) = AST.RECty
       (List.map (fn (f,t) => (newField (s,f), infTy env t)) l)
   and infExp env (AST.MARKexp m) = AST.MARKexp (reportError infExp m)
     | infExp env (AST.LETexp (l,e)) = AST.LETexp (let
         val _ = startScope ()
         val _ = List.map (regValuedecl s) l
         val l = List.map (infValuedecl s) l
         (*val _ = TextIO.print ("before e2:\n" ^ SymbolTable.toString(!ST.varTable) ^ "\n");*)
         val r = infExp env e
         val _ = endScope ()
         (*val _ = TextIO.print ("after e2:\n" ^ SymbolTable.toString(!ST.varTable) ^ "\n");*)
       in (l,r) end)
     | infExp env (AST.IFexp (e1,e2,e3)) = AST.IFexp
         (infExp env e1, infExp env e2, infExp env e3)
     | infExp env (AST.CASEexp (e,l)) = AST.CASEexp
         (infExp env e, List.map (infMatch s) l)
     | infExp env (AST.ANDALSOexp (e1,e2)) = AST.ANDALSOexp
         (infExp env e1, infExp env e2)
     | infExp env (AST.ORELSEexp (e1,e2)) = AST.ORELSEexp
         (infExp env e1, infExp env e2)
     | infExp env (AST.BINARYexp (e1, opid,e2)) = AST.BINARYexp
         (infExp env e1, useVar (s,{ span = s, tree = opid }), infExp env e2)
     | infExp env (AST.APPLYexp (e1,e2)) = AST.APPLYexp
         (infExp env e1, infExp env e2)
     | infExp env (AST.RECORDexp l) = AST.RECORDexp
         (List.map (fn (f,e) => (newField (s,f), infExp env e)) l)
     | infExp env (AST.SELECTexp f) = AST.SELECTexp (useField (s,f))
     | infExp env (AST.UPDATEexp fs) =
        AST.UPDATEexp (List.map (fn (f,e) => (useField (s,f), infExp env e)) fs)
     | infExp env (AST.LITexp lit) = AST.LITexp (infLit env lit)
     | infExp env (AST.SEQexp l) = AST.SEQexp (infSeqexp env l)
     | infExp env (AST.IDexp v) = AST.IDexp (useVar (s,v))
     | infExp env (AST.CONexp c) = AST.CONexp (useCon (s,c))
     | infExp env (AST.FNexp (v, e)) = AST.FNexp (newVar (s,v), infExp env e)
   and infSeqexp env [] = []
     | infSeqexp _ (AST.MARKseqexp { tree = ast, span = env } :: l) =
        infSeqexp env (ast :: l)
     | infSeqexp env (AST.ACTIONseqexp e :: l) =
        AST.ACTIONseqexp (infExp env e) :: infSeqexp env l
     | infSeqexp env (AST.BINDseqexp (v,e) :: l) = let
           val rhenv = infExp env e
           val _ = startScope ()
           val lhenv = newVar (s,v)
           val rem = infSeqexp env l
           val _ = endScope ()
        in
           AST.BINDseqexp (lhs, rhs) :: rem
        end
   and infDecodepat env (AST.MARKdecodepat m) =
       AST.MARKdecodepat (reportError infDecodepat m)
     | infDecodepat env (AST.TOKENdecodepat t) =
       AST.TOKENdecodepat (infTokpat env t)
     | infDecodepat env (AST.BITdecodepat l) =
       AST.BITdecodepat (List.map (infBitpat s) l)
   and infBitpat env (AST.MARKbitpat m) =
       AST.MARKbitpat (reportError infBitpat m)
     | infBitpat env (AST.BITSTRbitpat str) = AST.BITSTRbitpat str
     | infBitpat env (AST.NAMEDbitpat v) = AST.NAMEDbitpat (useVar (s,v))
     | infBitpat env (AST.BITVECbitpat (var,size)) = AST.BITVECbitpat
       (newVar (s,var), size)
   and infTokpat env (AST.MARKtokpat m) =
       AST.MARKtokpat (reportError infTokpat m)
     | infTokpat env (AST.TOKtokpat i) = AST.TOKtokpat i
     | infTokpat env (AST.NAMEDtokpat v) = AST.NAMEDtokpat (useVar (s,v))
   and infMatch env (AST.MARKmatch m) =
       AST.MARKmatch (reportError infMatch m)
     | infMatch env (AST.CASEmatch (p,e)) =
       AST.CASEmatch (infPat env p, infExp env e)
   and infPat env (AST.MARKpat m) =
       AST.MARKpat (reportError infPat m)
     | infPat env (AST.BITpat str) = AST.BITpat str
     | infPat env (AST.LITpat lit) = AST.LITpat (infLit env lit)
     | infPat env (AST.IDpat v) = AST.IDpat (newVar (s,v))
     | infPat env (AST.CONpat (c, SOME p)) = AST.CONpat (useCon (s,c), SOME (infPat env p))
     | infPat env (AST.CONpat (c, NONE)) = AST.CONpat (useCon (s,c), NONE)
     | infPat env (AST.WILDpat) = AST.WILDpat
   and infLit env (AST.INTlit i) = AST.INTlit i
     | infLit env (AST.FLTlit f) = AST.FLTlit f
     | infLit env (AST.STRlit str) = AST.STRlit str*)

   in
      ( List.foldl (fn (d,env) => infDecl ({span = SymbolTable.noSpan,
                                            error = false},env) d)
                   toplevelEnv
                   (#tree (ast : SpecAbstractTree.specification))
      ; !st)
   end

   val typeInferencePass =
      BasicControl.mkTracePassSimple
         {passName="typeInferencePass",
          pass=typeInferencePass}

   fun run spec = let
      open CompilationMonad
   in
      getErrorStream >>= (fn errs =>
      return (typeInferencePass (errs, spec)))
   end
end
