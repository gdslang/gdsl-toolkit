
structure Parser : sig

   (* parse a file; return NONE if there are syntax errors *)
   val parseFile: (Error.err_stream * TextIO.instream) -> SpecParseTree.specification option
   val parse: string -> SpecParseTree.specification option
   val run: TextIO.instream -> SpecParseTree.specification CompilationMonad.t
   val trace: TextIO.outstream * SpecParseTree.specification -> SpecParseTree.specification CompilationMonad.t

end = struct

   structure SpecParser = SpecParseFn(SpecLex)

   fun lexErr errStrm (pos, msg) = Error.errorAt(errStrm, (pos, pos), msg)

   val parseErr = Error.parseError SpecTokens.toString

   fun parseFile (errStrm, file) = let
	   val lexer = SpecLex.lex (Error.sourceMap errStrm) (lexErr errStrm)
      val ins = SpecLex.streamifyInstream file
	in
	   case SpecParser.parse lexer ins of
         (SOME pt, _, []) => SOME pt
	    | (_, _, errs) =>
            (List.app (parseErr errStrm) errs
		      ;NONE)
	end

   val parseFile =
      BasicControl.mkKeepPass
         {passName="parseFile",
          registry=BasicControl.topRegistry,
          pass=parseFile,
          preExt="ast",
          preOutput=ignore,
          postExt="ast",
          postOutput=fn (os, spec) =>
            case spec of
               NONE => ()
             | SOME x => SpecParseTree.PP.prettyTo (os, x)}

   fun run ins = let
      open CompilationMonad
      infix >>=
   in
      getErrorStream >>= (fn errs =>
      case parseFile (errs, ins) of
         NONE => fail
       | SOME spec => return spec)
   end

   fun trace (os, spec) = let
      open CompilationMonad
   in
      SpecParseTree.PP.prettyTo (os, spec)
     ;return spec
   end

   fun parse fp = let
      val ins = TextIO.openIn fp
      val ers = Error.mkErrStream fp
      val () = Controls.set (BasicControl.verbose, 1)
   in
      parseFile (ers, ins)
         before
            (TextIO.closeIn ins; Error.report (TextIO.stdErr, ers))
   end
end
