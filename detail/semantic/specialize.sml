(*A pass that specializes decodes by instantiating the specialization
variables in duplications of the decoder functions.

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

   fun showBindinfo bs =
      let
         fun showBindings ((var, bps), str) =
            SymbolTable.getString(!SymbolTables.varTable, var) ^
            "=" ^ #1 (
               List.foldl (
                  fn (p,(str,sep)) => (Atom.toString p ^ sep ^ str, "|")
               ) (", ","") (AtomSet.listItems bps)) ^ str
         fun showForwards (var, str) =
            SymbolTable.getString(!SymbolTables.varTable, var) ^
            ", " ^ str
         fun showSymSpans ((decId,(p1,p2)),(str,sep)) =
            (SymbolTable.getString(!SymbolTables.varTable, decId) ^
            ":" ^ Int.toString(Position.toInt p1) ^
            "-" ^ Int.toString(Position.toInt p2) ^ sep ^ str, ",")
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
            let
               (*this can disappear if we fix the "shortcoming" at the beginnig*)
               val _ = if SymMap.inDomain (vs,var) then
                  Error.errorAt (errs, s, ["decoder ",
                     SymbolTable.getString(!SymbolTables.varTable, v),
                     " contains more than one call that specialises ",
                     SymbolTable.getString(!SymbolTables.varTable, var)])
                  else ()
            in
               SymMap.insert (vs,var,bpatToSet bpat)
            end
           | specialVS s (FORWARDspecial _,vs) = vs
         and specialFS s (MARKspecial m,fs) = specialFS (#span m) (#tree m,fs)
           | specialFS s (FORWARDspecial var,fs) =
            let
               (*this can disappear if we fix the "shortcoming" at the beginnig*)
               val _ = if SymSet.member (fs,var) then
                  Error.errorAt (errs, s, ["decoder ",
                     SymbolTable.getString(!SymbolTables.varTable, v),
                     " contains more than one call that specialises ",
                     SymbolTable.getString(!SymbolTables.varTable, var)])
                  else ()
            in
               SymSet.add (fs,var)
            end
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
                  List.foldl (addFiltered (bs,fs,prefix @ postfix)) ssMap
                     (SymSpansMap.listItemsi (SymMap.lookup (bi,caller)))
               else
                  SymSpansMap.insert (ssMap,prefix @ postfix,{bindings=bs, forwards=fs})
            end
         val parents = SymMap.lookup (bi, k)
         val parents = SymSpansMap.foldli genUse SymSpansMap.empty parents
      in
         SymMap.insert (bi, k, parents)
      end
   
   fun instantiate bs (DECODEdecl (v,ps,wc,guards)::ds) =
      let
         fun prepend xs = DECODEdecl (v,ps,wc,guards)::xs
      in
         prepend (instantiate bs ds)
      end
     | instantiate bs (d::ds) = d :: instantiate bs ds
     | instantiate bs [] = []
                  
   fun specializePass (errs,{tree = decls, span = s}) =
      let
         val bs = List.foldl
                     (gatherBindings (s,errs))
                     (SymMap.empty : bindinfo)
                     decls
         val _ = TextIO.print ("bindings before:\n" ^ showBindinfo bs)
         val bs = List.foldl propagateBinding bs (SymMap.listKeys bs)
         val _ = TextIO.print ("bindungs after:\n" ^ showBindinfo bs)
      in
         {tree = instantiate bs decls, span = s}
      end

   val specializePass =
      BasicControl.mkKeepPass
         {passName="specialize",
          registry=DesugarControl.registry,
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