
structure Detokenize : sig
   val run:
      DesugarGuards.o ->
         DesugaredTree.spec CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   structure DT = DesugaredTree
   structure AT = SpecAbstractTree

   open AT DT 

   val maxGranularity = 32 : int (* a token can be at most 32 bits *)
   fun gcd (a,b) =
      if a<=0 orelse b<=0 then 0 else
      if a=b then a else
      if a>b then gcd (a-b,b) else gcd (a,b-a)
      
   fun lubSizes (x,y) = gcd (x,y) div 8 * 8

   fun detokenize (n, ds) =
       let
          val sizeRef = ref maxGranularity
          val decls = map (detok sizeRef) ds
       in
          map (fn (pats, e) => (pats, !sizeRef, e)) decls
       end

   and detok sizeRef (pats, e) = (detokPats sizeRef pats, FromAST.exp e)

   and detokPats sizeRef pats =
       let
          val decodePats = map (detokPat SymbolTable.noSpan) pats
          val ruleSize = foldl (fn ((size,_),s) => s+size) 0 decodePats
          val _ = if ruleSize>0 then sizeRef := lubSizes (!sizeRef,ruleSize)
                  else ()
       in
          map #2 decodePats
       end

   and detokPat sp pat =
      case pat of
         MARKdecodepat t => detokPat (#span t) (#tree t)
       | TOKENdecodepat pat => detokTokPat sp pat
       | BITdecodepat pats =>
         let
            val dtPats = map (detokBitPat sp) pats
            val size = foldl (fn (p,s) => s+DT.size p) 0 dtPats
         in
            (size, dtPats)
         end

   and detokTokPat sp pat =
      case pat of
         MARKtokpat t => detokTokPat (#span t) (#tree t)
       | TOKtokpat (size,pat) =>
            let
               val bitstr = IntInf.fmt StringCvt.BIN pat
               fun addZeros bitstr =
						if String.size bitstr>=size then bitstr else
                  addZeros ("0" ^ bitstr)
               val bitstr = addZeros bitstr
            in
               (size,[Pat.VEC (sp, bitstr)])
            end
       | _ => raise CM.CompilationError (* Inlining must have failed! *)

   and detokBitPat sp pat =
      case pat of
         MARKbitpat t => detokBitPat (#span t) (#tree t)
       | BITSTRbitpat pat => Pat.VEC (sp, pat)
       | BITVECbitpat (n, str) => Pat.BND (sp, n, str)
       | _ => raise CM.CompilationError

   fun dumpPre (os, ds) = Pretty.prettyTo (os, Layout.str "<..>")
   fun dumpPost (os, ds) =
      Pretty.prettyTo (os, DesugaredTree.PP.declarations ds)

   fun pass (vs, ds) =
      (map FromAST.recdecl vs : DesugaredTree.value list,
       SymMap.mapi detokenize ds : DesugaredTree.decode list SymMap.map)

   val pass =
      BasicControl.mkKeepPass
         {passName="detokenize",
          registry=DesugarControl.registry,
          pass=pass,
          preExt="ast",
          preOutput=dumpPre,
          postExt="ast",
          postOutput=dumpPost}

   fun run spec = let
      open CompilationMonad
      infix >>=
   in
      return (Spec.upd pass spec)
   end
end
