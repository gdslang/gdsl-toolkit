
(**
 * ## Inlining of decode patterns.
 *
 *   - Inline named decode patterns into all use-sites.
 *   - Insert calls to the monadic action into the rhs expression of
 *     all use-sites of the pattern
 *)
structure InlineDecodePatterns : sig
   val inline: Error.err_stream * SpecAbstractTree.specification -> SpecAbstractTree.specification
   val run: SpecAbstractTree.specification -> SpecAbstractTree.specification CompilationMonad.t
end = struct

   structure Map = SymMap
   structure T = SpecAbstractTree

   datatype t =
      IN of {namedpatterns: (T.decodepat list * T.exp) Map.map,
             decodedecls: T.decodedecl list}

   val empty = IN {namedpatterns=Map.empty, decodedecls= []}
   fun get s (IN t) = s t
   fun insert t k v =
      IN
         {namedpatterns= Map.insert (get#namedpatterns t, k, v),
          decodedecls= []}

   (* traverse the specification and collect all "named" patterns *)
   fun grabNamedPatterns spec = let
      open T
      fun grabFromDecodeDecl (decl, t) =
         case decl of
            MARKdecodedecl decl' => grabFromDecodeDecl (#tree decl', t)
          | NAMEDdecodedecl (name, pats, exp) => insert t name (pats, exp)
          | _ => t
      fun grabFromDecl (decl, t) =
         case decl of
            MARKdecl decl' => grabFromDecl (#tree decl', t)
          | DECODEdecl decode => grabFromDecodeDecl (decode, t)
          | _ => t
   in
      foldl grabFromDecl empty spec
   end

   fun flattenDecodePatterns err t spec = let
      open T
      val map = ref (get#namedpatterns t)
      val varmap = !SymbolTables.varTable

      fun inline (x, exp) =
         case Map.find (!map, x) of
            NONE =>
               (Error.errorAt
                  (err,
                   VarInfo.getSpan (varmap, x),
                   ["Unbound or recursive pattern detected"])
               ;raise CompilationMonad.CompilationError)
          | SOME (pats, exp') =>
               let
                  (* remove `x` from available patterns, if it coccurs twice,
                   * we have found recursion (remember that all `x` are unique
                   *)
                  val (map', _) = Map.remove (!map, x)
                  val () = map := map'
                  val ps =
                     flattenDecodePats
                        (pats,
                         SEQexp [ACTIONseqexp exp', ACTIONseqexp exp])
               in
                  map := Map.insert (!map, x, ps)
                 ;ps
               end

      and flattenTokPat (tokpat, exp) =
         case tokpat of
            MARKtokpat t' => flattenTokPat (#tree t', exp)
          | NAMEDtokpat x => inline (x, exp)
          | _ => ([TOKENdecodepat tokpat], exp)

      and flattenBitPat (bitpat, exp) =
         case bitpat of
            MARKbitpat t' => flattenBitPat (#tree t', exp)
          | NAMEDbitpat x => inline (x, exp)
          | _ => ([BITdecodepat [bitpat]], exp)

      and flattenDecodePat (decodepat, exp) =
         case decodepat of
            MARKdecodepat t' => flattenDecodePat (#tree t', exp)
          | TOKENdecodepat tokpat => flattenTokPat (tokpat, exp)
          | BITdecodepat bitpats =>
               let
                  fun lp (bitpats, exp, acc) =
                     case bitpats of
                        [] => (List.concat acc, exp)
                      | b::bs =>
                           let
                              val (ps, exp) = flattenBitPat (b, exp)
                           in
                              lp (bs, exp, ps::acc)
                           end
               in
                  lp (rev bitpats, exp, [])
               end

      and flattenDecodePats (pats, exp) = let
         fun lp (pats, exp, acc) =
            case pats of
               [] => (List.concat acc, exp)
             | p::ps =>
                  let
                     val (inlinedPats, exp) = flattenDecodePat (p, exp)
                  in
                     lp (ps, exp, inlinedPats::acc)
                  end
      in
         lp (rev pats, exp, [])
      end

      and flattenDecodeDecl decodedecl =
         case decodedecl of
            MARKdecodedecl t' => flattenDecodeDecl (#tree t')
          | DECODEdecodedecl decl => DECODEdecodedecl (flattenDecodePats decl)
          | NAMEDdecodedecl (x, decl, exp) =>
               let
                  val (decl, exp) = flattenDecodePats (decl, exp)
               in
                  NAMEDdecodedecl (x, decl, exp)
               end
          | GUARDEDdecodedecl (pats, cases) =>
               let
                  fun lp (cases, acc) =
                     case cases of
                        [] => rev acc
                      | (guard, exp)::cs =>
                           let
                              val (_, inlined) = flattenDecodePats (pats, exp)
                           in
                              lp (cs, (guard, inlined)::acc)
                           end
                  val (pats, _) = flattenDecodePats (pats, SEQexp[])
               in
                  GUARDEDdecodedecl (pats, lp (cases, []))
               end

      and flattenDecl decl =
         case decl of
            MARKdecl t' => flattenDecl (#tree t')
          | DECODEdecl decl => DECODEdecl (flattenDecodeDecl decl)
          | otherwise => otherwise

   in
      List.map flattenDecl spec
   end

   fun inlineDecodePatterns (err, {span, tree}:SpecAbstractTree.specification) = let
      val t = grabNamedPatterns tree
      val inlined = flattenDecodePatterns err t tree
   in
      {span=span, tree=inlined}
   end

   fun dumpPre (os, (_, spec)) = SpecAbstractTree.PP.prettyTo (os, spec)
   fun dumpPost (os, spec) = SpecAbstractTree.PP.prettyTo (os, spec)

   val inline =
      BasicControl.mkKeepPass
         {passName="inlineDecodePatterns",
          registry=BasicControl.topRegistry,
          pass=inlineDecodePatterns,
          preExt="ast",
          preOutput=dumpPre,
          postExt="ast",
          postOutput=dumpPost}

   fun run spec = let
      open CompilationMonad
      infix >>=
   in
      getErrorStream >>= (fn errs =>
      return (inline (errs, spec)))
   end
end