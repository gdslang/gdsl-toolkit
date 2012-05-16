
(**
 * ## Inlining of decode patterns.
 *
 *   - Inlining in presence of guarded decode declarations
 *     might lead to code size explosion. We might tackle this
 *     when the need arises.
 *)
structure InlineDecodePatterns : sig
   val run: DesugarGuards.o -> DesugarGuards.o CompilationMonad.t
end = struct

   structure T = SpecAbstractTree
   structure Map = SymMap

   fun bind (map, n, d) =
      Map.unionWith op@ (map, Map.singleton (n, d))

   fun flattenDecodePatterns (err, ds) = let
      open T
      val map = ref ds
      val varmap = !SymbolTables.varTable

      fun inline (x, exp) =
         case Map.find (!map, x) of
            NONE =>
               (Error.errorAt
                  (err,
                   VarInfo.getSpan (varmap, x),
                   ["Unbound or recursive pattern detected"])
               ;raise CompilationMonad.CompilationError)
          | SOME ds =>
               let
                  (* remove `x` from available patterns, if it coccurs twice,
                   * we have found recursion (remember that all `x` are unique)
                   *)
                  val (map', _) = Map.remove (!map, x)
                  val () = map := map'
                  val ps =
                     List.concat (List.map
                        (fn (pats, exp') =>
                           flattenDecodePats
                              (pats,
                               SEQexp
                                 [ACTIONseqexp exp',
                                  ACTIONseqexp exp]))
                         ds)
               in
                  map := Map.insert (!map, x, ds)
                 ;ps
               end

      and flattenTokPat (tokpat, exp) =
         case tokpat of
            MARKtokpat t' => flattenTokPat (#tree t', exp)
          | NAMEDtokpat x => inline (x, exp)
          | _ => [([TOKENdecodepat tokpat], exp)]

      and flattenBitPat (bitpat, exp) =
         case bitpat of
            MARKbitpat t' => flattenBitPat (#tree t', exp)
          | NAMEDbitpat x => inline (x, exp)
          | _ => [([BITdecodepat [bitpat]], exp)]

      and flattenDecodePat (decodepat, exp) =
         case decodepat of
            MARKdecodepat t' => flattenDecodePat (#tree t', exp)
          | TOKENdecodepat tokpat => flattenTokPat (tokpat, exp)
          | BITdecodepat bitpats =>
               let
                  fun lp (bitpats, exp, acc) =
                     case bitpats of
                        [] => [(List.concat acc, exp)]
                      | b::bs =>
                           let
                              val ds = flattenBitPat (b, exp)
                           in
                              List.concat (List.map
                                 (fn (ps, exp) =>
                                    lp (bs, exp, ps::acc))
                                 ds)
                           end
               in
                  lp (rev bitpats, exp, [])
               end

      and flattenDecodePats (pats, exp) = let
         fun lp (pats, exp, acc) =
            case pats of
               [] => [(List.concat acc, exp)]
             | p::ps =>
                  let
                     val ds = flattenDecodePat (p, exp)
                  in
                     List.concat
                        (List.map
                           (fn (inlinedPats, exp) =>
                              lp (ps, exp, inlinedPats::acc))
                           ds)
                  end
      in
         lp (rev pats, exp, [])
      end

      and flattenDecodeDecl (n, ds, map) = let
         fun flatten (pats, map) = bind (map, n, flattenDecodePats pats)
      in
         foldl flatten map ds
      end
   in
      Map.foldli flattenDecodeDecl Map.empty ds
   end

   fun dumpPre (os, (_, spec)) = Pretty.prettyTo (os, DesugarGuards.layout spec)
   fun dumpPost (os, spec) = Pretty.prettyTo (os, DesugarGuards.layout spec)

   val inline =
      BasicControl.mkKeepPass
         {passName="inlineDecodePatterns",
          registry=DesugarControl.registry,
          pass=flattenDecodePatterns,
          preExt="ast",
          preOutput=dumpPre,
          postExt="ast",
          postOutput=dumpPost}

   fun run spec = let
      open CompilationMonad
      infix >>=
   in
      getErrorStream >>= (fn errs =>
      return (Spec.upd (fn (vs, ds) => (vs, inline (errs, ds))) spec))
   end
end
