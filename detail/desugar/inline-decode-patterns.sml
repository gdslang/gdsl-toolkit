
(**
 * ## Inlining of decode patterns.
 *)

structure ASTSubst = struct
   val empty = SymMap.empty
   fun apply sigma x =
      case SymMap.find (sigma, x) of
         NONE => x
       | SOME y => y
   fun applyAll sigma xs = map (apply sigma) xs
   fun extend sigma x y = SymMap.insert (sigma, y, x)
   fun extendAll sigma xs ys =
      foldl
         (fn ((y, x), sigma) =>
            extend sigma y x)
         sigma (ListPair.zip (xs, ys))

   fun copy x =
      let
         val name = Aux.atomOf x
         val x' = Aux.fresh name
      in
         x'
      end

   fun singleton y x = extend empty y x

   local open SpecAbstractTree in

   fun run sigma t = visitExp sigma t

   and visitExp sigma t =
      case t of
         MARKexp t => visitExp sigma (#tree t)
       | LETRECexp (ds, e) =>
            LETRECexp (map (visitRec sigma) ds, visitExp sigma e)
       | IFexp (iff, thenn, elsee) =>
            IFexp
               (visitExp sigma iff,
                visitExp sigma thenn,
                visitExp sigma elsee)
       | CASEexp (e, cs) =>
            CASEexp (visitExp sigma e, map (visitCase sigma) cs)
       | BINARYexp (e1, binop, e2) =>
            BINARYexp (visitExp sigma e1, binop, visitExp sigma e2)
       | APPLYexp (e, es) =>
            APPLYexp (visitExp sigma e, map (visitExp sigma) es)
       | RECORDexp fs =>
            RECORDexp (map (visitField sigma) fs)
       | UPDATEexp fs =>
            UPDATEexp (map (visitFieldOpt sigma) fs)
       | SEQexp es =>
            SEQexp (map (visitSeqexp sigma) es)
       | FNexp (x, e) =>
            FNexp (x, visitExp sigma e)
       | IDexp sym =>
            IDexp (apply sigma sym)
       | otherwise => otherwise

   and visitRec sigma (f, xs, e) = (f, xs, visitExp sigma e)
   and visitCase sigma (pat, e) = (pat, visitExp sigma e)
   and visitField sigma (f, e) = (f, visitExp sigma e)
   and visitFieldOpt sigma (f, eOpt) = (f, Option.map (visitExp sigma) eOpt)
   and visitSeqexp sigma t =
      case t of
         MARKseqexp t => visitSeqexp sigma (#tree t)
       | ACTIONseqexp e => ACTIONseqexp (visitExp sigma e)
       | BINDseqexp (x, e) => BINDseqexp (x, visitExp sigma e)

   end
end
 
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

      and renamePatternBinding (pat, exp) =
         case pat of
            BITVECbitpat (x, lit) =>
               let
                  val y = ASTSubst.copy x
                  val exp = ASTSubst.run (ASTSubst.singleton y x) exp
               in
                  (BITVECbitpat (y, lit), exp)
               end
          | otherwise => (otherwise, exp)

      and flattenBitPat (bitpat, exp) =
         case bitpat of
            MARKbitpat t' => flattenBitPat (#tree t', exp)
          | NAMEDbitpat x => inline (x, exp)
          | _ =>
            let
               val (bitpat, exp) = renamePatternBinding (bitpat, exp)
            in
               [([BITdecodepat [bitpat]], exp)]
            end

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
