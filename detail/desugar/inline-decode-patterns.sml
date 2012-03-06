
(**
 * ## Inlining of decode patterns.
 *)
structure InlineDecodePatterns : sig
   val run: SplitDeclarations.o -> SplitDeclarations.o CompilationMonad.t
end = struct

   structure Map = SymMap
   structure T = SpecAbstractTree

   datatype t =
      IN of {namedpatterns: (T.decodepat list * T.exp) Map.map}

   val empty = IN {namedpatterns=Map.empty}
   fun get s (IN t) = s t
   fun insert t k v =
      IN {namedpatterns= Map.insert (get#namedpatterns t, k, v)}

   (* traverse the specification and collect all "named" patterns *)
   fun grabNamedPatterns spec = let
      open T
      fun grab (decl, t) =
         case decl of
            MARKdecodedecl decl' => grab (#tree decl', t)
          | NAMEDdecodedecl (name, pats, exp) => insert t name (pats, exp)
          | _ => t
   in
      foldl grab empty spec
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
                   * we have found recursion (remember that all `x` are unique)
                   *)
                  val (map', _) = Map.remove (!map, x)
                  val () = map := map'
                  val ps =
                     flattenDecodePats
                        (pats,
                         SEQexp [ACTIONseqexp exp', ACTIONseqexp exp])
               in
                  map := Map.insert (!map, x, (pats, exp'))
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
   in
      List.map flattenDecodeDecl spec
   end

   fun inlineDecodePatterns (err, spec) = let
      open Spec
      val (_, ds) = get#declarations spec
      val t = grabNamedPatterns ds
      val inlined = flattenDecodePatterns err t ds
   in
      upd (fn (vs, _) => (vs, inlined)) spec
   end

   val pp = Spec.PP.prettyTo Spec.PP.prettyDecls
   fun dumpPre (os, (_, spec)) = pp (os, spec)
   fun dumpPost (os, spec) = pp (os, spec)

   val inline =
      BasicControl.mkKeepPass
         {passName="inlineDecodePatterns",
          registry=DesugarControl.registry,
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
