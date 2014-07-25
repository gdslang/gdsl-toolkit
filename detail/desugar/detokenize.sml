
structure Detokenize : sig
   val run:
      DesugarGuards.o ->
         DesugaredTree.spec CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   structure DT = DesugaredTree
   structure AT = SpecAbstractTree

   open AT DT 

   fun detokenize (n, ds) =
       let
          val sizeRef = ref (8 : int) (* a token has to be at least size 8 *)
          val decls = map (detok sizeRef) ds
       in
          map (fn (pats, e) => (pats, !sizeRef, e)) decls
       end

   and detok sizeRef (pats, e) = (detokPats sizeRef pats, FromAST.exp e)

   and detokPats sizeRef pats =
       let
          val decodePats = map detokPat pats
          fun lubSize x = if x>16 then 32 else if x>8 then 16 else 8
          fun lubSizes (x,y) = lubSize (Int.max (x,y))
          val _ = sizeRef := foldl lubSizes (!sizeRef) (map #1 decodePats)
       in
          map #2 decodePats
       end

   and detokPat pat =
      case pat of
         MARKdecodepat t => detokPat (#tree t)
       | TOKENdecodepat pat => detokTokPat pat
       | BITdecodepat pats =>
         let
            val dtPats = map detokBitPat pats
            val size = case dtPats of
                 [] => 0
               | (pat :: _) => DT.size pat
         in
            (size, dtPats)
         end

   and detokTokPat pat =
      case pat of
         MARKtokpat t => detokTokPat (#tree t)
       | TOKtokpat (size,pat) =>
            let
               val bitstr = IntInf.fmt StringCvt.BIN pat
               fun addZeros bitstr =
						if String.size bitstr>=size then bitstr else
                  addZeros ("0" ^ bitstr)
               val bitstr = addZeros bitstr
            in
               (size,[Pat.VEC bitstr])
            end
       | _ => raise CM.CompilationError (* Inlining must have failed! *)

   and detokBitPat pat =
      case pat of
         MARKbitpat t => detokBitPat (#tree t)
       | BITSTRbitpat pat => Pat.VEC pat
       | BITVECbitpat (n, str) => Pat.BND (n, str)
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
