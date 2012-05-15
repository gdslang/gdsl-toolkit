(*A pass that specializes decodes by instantiating the specialization
variables in duplications of the decoder functions.

- replacing specialized pattern variables with constants doesn't work yet
*)
structure Specialize : sig
   val run:
      SpecAbstractTree.specification ->
         SpecAbstractTree.specification CompilationMonad.t
end = struct

   open SpecAbstractTree

   type symid = SymbolTable.symid
   type bitpat_set = AtomSet.set
      
   structure SymSpansMap = RedBlackMapFn(struct
      type ord_key = (symid * Error.span) list
      val compare =
         let
            fun cmp ([]:(symid * Error.span) list,
                     []:(symid * Error.span) list) = EQUAL
              | cmp ([], _) = LESS
              | cmp (_, []) = GREATER
              | cmp ((_,s1)::ss1, (_,s2)::ss2) =
               (case SymbolTable.compare_span(s1, s2)
                of EQUAL => cmp (ss1,ss2)
                 | order => order)
         in
            cmp
         end
   end)           

   
   type uses = {bindings : bitpat_set SymMap.map, forwards : SymSet.set}
   type bindinfo = (uses SymSpansMap.map) SymMap.map

   fun showAtomSet bps =
      #1 (List.foldl (fn (p,(str,sep)) => (Atom.toString p ^ sep ^ str, "|"))
         (", ","") (AtomSet.listItems bps))

   fun showBindinfo bs =
      let
         fun showBindings ((var, bps), str) =
            SymbolTable.getString(!SymbolTables.varTable, var) ^
            "=" ^  showAtomSet bps ^ str
         fun showForwards (var, str) =
            str ^
            SymbolTable.getString(!SymbolTables.varTable, var) ^
            ", "
         fun showSymSpans ((decId,(p1,p2)),(str,sep)) =
            (str ^ sep ^
            SymbolTable.getString(!SymbolTables.varTable, decId) ^
            ":" ^ Int.toString(Position.toInt p1) ^
            "-" ^ Int.toString(Position.toInt p2), ",")
         fun showParent ((ss, {bindings = vs, forwards = fs}), str) =
            "    at " ^ 
            #1 (List.foldl showSymSpans ("","") ss) ^
            " with bindings " ^
            List.foldl showBindings "" (SymMap.listItemsi vs) ^
            " forwards " ^
            List.foldl showForwards "" (SymSet.listItems fs) ^
            "\n" ^ str
         fun showCall ((decId, pm), str) =
            SymbolTable.getString(!SymbolTables.varTable, decId) ^
            " called in\n" ^ List.foldl showParent "" (SymSpansMap.listItemsi pm) ^
            str
      in
         List.foldl showCall "" (SymMap.listItemsi bs)
      end

   fun bpatToSet bp =
      AtomSet.addList (AtomSet.empty,
                       List.map Atom.atom (String.fields (fn c => c= #"|") bp))

   fun bpatIsContained (s,(var,str),bPats,errs) =
      case String.fields (fn c => c = #"|") str of
         [bPat] => if AtomSet.member(bPats,Atom.atom(bPat)) then true else
            if String.size bPat=(case AtomSet.find (fn _ => true) bPats of
                  SOME a => String.size(Atom.toString(a))
                | NONE => ~1) then false else
            (Error.errorAt (errs, s, ["filter clause ",
                     SymbolTable.getString(!SymbolTables.varTable, var),
                     "='", bPat, "' and refinement '", showAtomSet bPats,
                     "' have different lengths"]); false)
       | _ => (Error.errorAt (errs, s, ["filter clause ",
                     SymbolTable.getString(!SymbolTables.varTable, var),
                     "='", str, "' must be a single constant"]); false)

   fun mergeUses ({bindings = bs1, forwards = fs1},
                  {bindings = bs2, forwards = fs2}) = {bindings = bs2, forwards = fs2}
                  
   fun gatherBindings (_,errs) (MARKdecl {tree = t, span = s},bs) =
         gatherBindings (s,errs) (t,bs)
     | gatherBindings (s,errs) (DECODEdecl (v,ps,wc,guards),bs) =
      let 
         fun decodepatGB s (MARKdecodepat m,bs) =
               decodepatGB (#span m) (#tree m,bs)
           | decodepatGB s (TOKENdecodepat t,bs) = tokpatGB s (t,bs)
           | decodepatGB s (BITdecodepat t,bs) = List.foldl (bitpatGB s) bs t
         and tokpatGB s (MARKtokpat m,bs) = tokpatGB (#span m) (#tree m,bs)
           | tokpatGB s (NAMEDtokpat (callVar,sps),bs) =
            let
               val vs = List.foldl (specialVS s) SymMap.empty sps
               val fs = List.foldl (specialFS s) SymSet.empty sps
               val site = SymSpansMap.singleton ([(v,s)],{bindings = vs, forwards = fs})
               val newBs = SymMap.singleton (callVar, site)
            in
               SymMap.unionWith (SymSpansMap.unionWith mergeUses) (newBs, bs)
            end
           | tokpatGB s (_,bs) = bs
         and bitpatGB s (MARKbitpat m,bs) = bitpatGB (#span m) (#tree m,bs)
           | bitpatGB s (_,bs) = bs
         and specialVS s (MARKspecial m,vs) = specialVS (#span m) (#tree m,vs)
           | specialVS s (BINDspecial (var,bpat),vs) =
               SymMap.insert (vs,var,bpatToSet bpat)
           | specialVS s (FORWARDspecial _,vs) = vs
         and specialFS s (MARKspecial m,fs) = specialFS (#span m) (#tree m,fs)
           | specialFS s (FORWARDspecial var,fs) =
               SymSet.add (fs,var)
           | specialFS s (BINDspecial _,fs) = fs
      in
         List.foldl (decodepatGB s) bs ps
      end
     | gatherBindings _ (_,bs) = bs
   
   fun propagateBinding (k, bi) =
      let
         fun genUse ([],_,ssMap) = ssMap
           | genUse (ss,uses as {bindings=bs, forwards=fs},ssMap) =
            let
               val filter =
                  SymSet.union (fs,(SymSet.fromList (SymMap.listKeys bs)))
            in
               addFiltered (SymMap.empty,filter,[]) ((ss,uses),ssMap)
            end
         and addFiltered (acc,filter,prefix) (([],_),ssMap) = ssMap
           | addFiltered (acc,filter,prefix)
               ((postfix as ((caller,_)::_),{bindings=bs, forwards=fs}),ssMap) =
            let
               val bs = SymMap.filteri (fn (k,_) => SymSet.member (filter,k)) bs
               val bs = SymMap.unionWith (fn (_,bs) => bs) (acc,bs)
               val fs = SymSet.intersection (filter,fs)
            in
               if SymMap.inDomain (bi,caller) then 
                  List.foldl (addFiltered (bs,fs,postfix @ prefix)) ssMap
                     (SymSpansMap.listItemsi (SymMap.lookup (bi,caller)))
               else
                  SymSpansMap.insert (ssMap,postfix @ prefix,{bindings=bs, forwards=fs})
            end
         val parents = SymMap.lookup (bi, k)
         val parents = SymSpansMap.foldli genUse SymSpansMap.empty parents
      in
         SymMap.insert (bi, k, parents)
      end
   
   fun getSymbolVariant (decId, bs) =
      let
         val decStr = SymbolTable.getString(!SymbolTables.varTable,decId)
         val decSpan = SymbolTable.getSpan(!SymbolTables.varTable,decId)
         fun genList ((var,bitstr),(str,sep)) =
            (str ^ sep ^ SymbolTable.getString(!SymbolTables.varTable,var) ^
            "='" ^ #1 (List.foldl (fn (atm,(str,sep)) =>
                           (Atom.toString(atm) ^ sep, "|"))
                        ("","") (AtomSet.listItems bitstr)) ^ "'", ",")
         val varStr = decStr ^ "<" ^
                      #1 (List.foldl genList ("","") (SymMap.listItemsi bs))
                      ^ ">"
         val varAtm = Atom.atom(varStr)
      in
        case SymbolTable.find(!SymbolTables.varTable,varAtm) of
               SOME varId => varId
             | NONE => case SymbolTable.create(!SymbolTables.varTable,varAtm,decSpan) of
                (table, varId) => (SymbolTables.varTable := table; varId)
      end

   fun instantiate (_,errs,bi) (MARKdecl {tree=t, span=s}::ds) =
      List.map (fn t => MARKdecl {tree=t, span=s}) (instantiate (s,errs,bi) [t]) @
      instantiate (s,errs,bi) ds
     | instantiate (s,errs,bi) ((d as DECODEdecl (v,ps,wc,guards))::ds) =
      (case SymMap.find (bi,v) of
         NONE => d::instantiate (s,errs,bi) ds
       | SOME ssMap =>
         let
            fun filterMatch (_,bs) (MARKwithclause {tree=t,span=s}) =
               filterMatch (s,bs) t
              | filterMatch (s,bs) (WITHwithclause (var,str)) =
               case SymMap.find (bs,var) of
                     NONE => false
                   | SOME bPats => bpatIsContained (s,(var,str),bPats,errs)
            fun patchPatterns (pre,bs) (MARKdecodepat {tree=t, span=s}) =
               MARKdecodepat {tree=patchPatterns (pre,bs) t, span=s}
              | patchPatterns (pre,bs) (TOKENdecodepat tp) =
               TOKENdecodepat (patchTokpat (pre,bs) tp)
              | patchPatterns (pre,bs) (BITdecodepat bps) = BITdecodepat bps
            and patchTokpat (pre,bs) (MARKtokpat {tree=t,span=s}) =
                MARKtokpat {tree=patchTokpat (pre,bs) t,span=s}
              | patchTokpat (pre,bs) (TOKtokpat i) = TOKtokpat i
              | patchTokpat (pre,bs) (NAMEDtokpat (decId,spec)) =
               case SymMap.find (bi,decId) of
                  NONE => NAMEDtokpat (decId,spec)
                | SOME localMap =>
               let
                  val bindingOpt = List.find
                     (fn (ssList,_) => List.all
                        (fn ((sy1,sp1),(sy2,sp2)) =>
                           SymbolTable.eq_symid(sy1,sy2) andalso
                           SymbolTable.eq_span(sp1,sp2))
                        (ListPair.zip (pre,ssList)))
                     (SymSpansMap.listItemsi localMap)
               in
                  case bindingOpt of
                     NONE => NAMEDtokpat (decId,spec)
                   | SOME (_,{bindings=bs, forwards}) =>
                     NAMEDtokpat (getSymbolVariant (decId,bs),[])
               end
            fun gatherInstances ((prefix,{bindings=bs, forwards}),(done,out)) =
               case getSymbolVariant (v,bs) of varId =>
               if SymSet.member (done,varId) then (done,out) else
               (SymSet.add (done,varId),
                  if List.exists (filterMatch (s,bs)) wc then out else
                     DECODEdecl (varId,
                        List.map (patchPatterns (prefix,bs)) ps,
                        wc, guards) :: out)
            val (_,newInsts) = List.foldl gatherInstances (SymSet.empty,[])
                  (SymSpansMap.listItemsi ssMap)
         in
            d :: newInsts @ instantiate (s,errs,bi) ds
         end)
     | instantiate sErrbi (d::ds) = d :: instantiate sErrbi ds
     | instantiate sErrbi [] = []
                  
   fun specializePass (errs,{tree = decls, span = s}) =
      let
         val bi = List.foldl
                     (gatherBindings (s,errs))
                     (SymMap.empty : bindinfo)
                     decls
         (*val _ = TextIO.print ("bindings before:\n" ^ showBindinfo bi)*)
         val bi = List.foldl propagateBinding bi (SymMap.listKeys bi)
         (*val _ = TextIO.print ("bindungs after:\n" ^ showBindinfo bi)*)
      in
         {tree = instantiate (s,errs,bi) decls, span = s}
      end

   val specializePass =
      BasicControl.mkKeepPass
         {passName="specialize",
          registry=BasicControl.topRegistry,
          pass=specializePass,
          preExt="ast",
          preOutput=fn (os,(err,t)) => PP.prettyTo (os,t),
          postExt="ast",
          postOutput=PP.prettyTo}

   infix >>= >>

   fun run spec =
      let
         open CompilationMonad
      in
         getErrorStream >>= (fn errs =>
         return (specializePass (errs,spec)))
      end
end