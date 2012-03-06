
structure Detokenize : sig
   val run:
      SplitDeclarations.o ->
         DesugaredTree.IRSpec.t CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   structure DT = DesugaredTree
   structure AT = struct
      open SpecAbstractTree
      fun grabDecodeDecls spec = let 
         fun lp (spec, acc) =
            case spec of
               (MARKdecl t::ss) => lp(#tree t::ss, acc)
             | (DECODEdecl dec::ss) => lp(ss, dec::acc)
             | _::ss => lp(ss, acc)
             | [] => rev acc
      in
         lp (spec, [])
      end
   end

   open AT DT DT.Decode DT.Exp DT.DecodePattern

   val granularity = 8 

   fun detokenize dec =
      case dec of
         MARKdecodedecl t => detokenize (#tree t)
       | NAMEDdecodedecl (name, pats, e) =>
             NAMED
               (name,
                detokenizeDecodePats pats,
                Sum.INL (FromAST.exp e))
       | DECODEdecodedecl (pats, e) =>
             TOP
               (detokenizeDecodePats pats,
                Sum.INL (FromAST.exp e))
       | GUARDEDdecodedecl (pats, exps) =>
             TOP
               (detokenizeDecodePats pats,
                Sum.INR
                  (map (fn (g, e) => (FromAST.exp g, FromAST.exp e)) exps))

   and detokenizeDecodePats pats = map detokenizeDecodePat pats

   and detokenizeDecodePat pat =
      case pat of
         MARKdecodepat t => detokenizeDecodePat (#tree t)
       | TOKENdecodepat pat => detokenizeTokPat pat
       | BITdecodepat pats => map detokenizeBitPat pats

   and detokenizeTokPat pat =
      case pat of
         MARKtokpat t => detokenizeTokPat (#tree t)
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
               [BITSTR (String.substring (bitstr, 0, 8))]
            end
       | _ => raise CM.CompilationError

   and detokenizeBitPat pat =
      case pat of
         MARKbitpat t => detokenizeBitPat (#tree t)
       | BITSTRbitpat pat => BITSTR pat
       | BITVECbitpat (n, i) => BIND (n, IntInf.toInt i)
       | _ => raise CM.CompilationError

   fun dumpPre (os, spec) = Spec.PP.prettyTo Spec.PP.prettyDecls (os, spec)
   fun dumpPost (os, spec) = DT.PP.prettyTo (os, spec)

   val pass =
      Spec.upd
         (fn (vs, ds) =>
            (map FromAST.valuedecl vs, map detokenize ds))

   val pass =
      BasicControl.mkKeepPass
         {passName="detokenizeDecodePatterns",
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
      return (pass spec)
   end
end
