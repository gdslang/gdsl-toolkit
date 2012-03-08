
structure Detokenize : sig
   val run:
      DesugarGuards.o ->
         DesugaredTree.spec CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   structure DT = DesugaredTree
   structure AT = SpecAbstractTree

   open AT DT 

   val granularity = 8 

   fun detokenize (n, ds) = map detok ds

   and detok (pats, e) = (detokPats pats, FromAST.exp e)

   and detokPats pats = map detokPat pats

   and detokPat pat =
      case pat of
         MARKdecodepat t => detokPat (#tree t)
       | TOKENdecodepat pat => detokTokPat pat
       | BITdecodepat pats => map detokBitPat pats

   and detokTokPat pat =
      case pat of
         MARKtokpat t => detokTokPat (#tree t)
       | TOKtokpat pat =>
            let
               (* XXX: this should be `granularity` dependend *)
               val bitstr =
                  IntInf.fmt
                     StringCvt.BIN
                     (IntInf.andb
                        (IntInf.orb (pat, 0x100),
                      0x1ff))
            in
               [Pat.VEC (String.substring (bitstr, 0, 8))]
            end
       | _ => raise CM.CompilationError (* Inlining must have failed! *)

   and detokBitPat pat =
      case pat of
         MARKbitpat t => detokBitPat (#tree t)
       | BITSTRbitpat pat => Pat.VEC pat
       | BITVECbitpat (n, i) => Pat.BND (n, IntInf.toInt i)
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
