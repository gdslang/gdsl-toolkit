
structure Parser : sig

   (* parse a file; return NONE if there are syntax errors *)
   val parseFile : (Error.err_stream * TextIO.instream) -> SpecParseTree.specification option
   val parse : string -> SpecParseTree.specification option

end = struct

   structure SpecParser = SpecParseFn(SpecLex)

   fun lexErr errStrm (pos, msg) = Error.errorAt(errStrm, (pos, pos), msg)

   val parseErr = Error.parseError SpecTokens.toString

   fun parseFile (errStrm, file) = let
	   val lexer = SpecLex.lex (Error.sourceMap errStrm) (lexErr errStrm)
      val ins = SpecLex.streamifyInstream file
	in
	   case SpecParser.parse lexer ins
	    of (SOME pt, _, []) => (TextIO.closeIn file; SOME pt)
	     | (_, _, errs) =>
            (TextIO.closeIn file
		     ; List.app (parseErr errStrm) errs
		     ; NONE)
	end

   val parseFile =
      BasicControl.mkTracePassSimple
         {passName = "parseFile",
          pass = parseFile}

   fun parse fp = let
      val ins = TextIO.openIn fp
      val ers = Error.mkErrStream fp
   in
      parseFile (ers, ins)
         before
            (TextIO.closeIn ins; Error.report (TextIO.stdErr, ers))
   end
end
