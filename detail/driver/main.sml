
structure Main = struct

   structure Passes = struct
      open CompilationMonad
      infix >>= >>

      fun all ins =
         Parser.run ins >>=
         InlineDecodePatterns.run

      fun run fp = let
         val ins = TextIO.openIn fp
         val ers = Error.mkErrStream fp
         val () = Controls.set (BasicControl.verbose, 1)
      in
         CompilationMonad.run ers (all ins >> return ())
            before
               TextIO.closeIn ins
      end
   end

   fun run args = Passes.run (hd args)
   fun main () = run (CommandLine.arguments())
end