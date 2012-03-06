
structure Retokenize : sig
   val run:
      DesugaredTree.IRSpec.t ->
         DesugaredTree.IRSpec.t CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   structure DT = DesugaredTree
   open DT DT.Decode

   val granularity = 8 

   fun retokenize pat =
      case pat of
         NAMED (n, pats, e) => NAMED (n, retokenizePats pats, e)
       | TOP (pats, e) => TOP (retokenizePats pats, e)

   and retokenizePats pats = let
      fun lp (p, len, tok, pats) =
         case p of
            [] =>
               if len <> 0 orelse List.length tok <> 0
                  then raise CM.CompilationError 
               else rev pats
          | p::ps =>
               (case p of
                  [p] =>
                     let
                        val sz = DT.size p
                     in
                        if (sz + len) mod granularity = 0
                           then lp (ps, 0, [], (rev (p::tok))::pats)
                        else lp (ps, sz + len, p::tok, pats)
                     end
                | _ => raise CM.CompilationError)
   in
      lp (pats, 0, [], [])
   end

   fun dumpPre (os, spec) = DT.PP.prettyTo (os, spec)
   fun dumpPost (os, spec) = DT.PP.prettyTo (os, spec)
   fun pass t =
      Spec.upd
         (fn (vs, ds) => (vs, map retokenize ds)) t

   val pass =
      BasicControl.mkKeepPass
         {passName="retokenizeDecodePatterns",
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
