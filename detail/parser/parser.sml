
structure Parser : sig

   (* parse a file; return NONE if there are syntax errors *)
   val parseFile: (Error.err_stream * TextIO.instream) -> SpecParseTree.specification option
   val parse: string list -> SpecParseTree.specification
   val run: string list -> SpecParseTree.specification CompilationMonad.t
   val trace: TextIO.outstream * SpecParseTree.specification -> SpecParseTree.specification CompilationMonad.t

end = struct

   structure SpecParser = SpecParseFn(SpecLex)

   fun lexErr errStrm (pos, msg) =
      Error.errorAt(errStrm, {file= !CurrentSourcemap.sourcemap, span=(pos, pos)}, msg)

   val parseErr = Error.parseError SpecTokens.toString

   fun parseFile (errStrm, file) = let
      val sm = Error.sourceMap errStrm
      val _ = CurrentSourcemap.sourcemap := sm
	   val lexer = SpecLex.lex sm (lexErr errStrm)
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

   fun parse fps = let
      fun process fp = 
         let
            val ins = TextIO.openIn fp
            val ers = Error.mkErrStream fp
         in
            parseFile (ers, ins)
               before
                  (TextIO.closeIn ins; Error.report (TextIO.stdErr, ers))
         end
   in
      List.concat (List.mapPartial process fps)
   end

   fun run fps = let
      open CompilationMonad
      infix >>=
   in
      case parse fps of
         [] => fail
       | spec => return spec
   end

   fun trace (os, spec) = let
      open CompilationMonad
   in
      SpecParseTree.PP.prettyTo (os, spec)
     ;return spec
   end

end
