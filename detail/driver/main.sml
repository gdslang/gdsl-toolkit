
structure Main = struct

   structure Passes = struct
      open CompilationMonad
      infix >>= >>

      fun all ins =
         Parser.run ins >>=
         ResolveSymbols.run >>= (fn ast =>
         ResolveTypeInfo.run ast >>= (fn tInfo =>
         TypeInference.run (tInfo, ast) >>= (fn tys =>
         Desugar.run ast >>=
         ImpPasses.run >>=
         (*Desugar.run ast >>=
         CPSPasses.run >>= *)
         CodegenPasses.run
         )))
      fun run fps = let
         val ers = Error.mkErrStream'()
         val () = Controls.set (BasicControl.verbose, 1)
         val () = Stats.resetAll()
         val () = CompilationMonad.run ers (all fps >> return ())
            before
               Stats.report()
      in
         Error.report (TextIO.stdErr, ers)
      end

      fun allTc ins = 
         Parser.run ins >>=
         ResolveSymbols.run >>= (fn ast =>
         ResolveTypeInfo.run ast >>= (fn tInfo =>
         TypeInference.run (tInfo, ast) >>= (fn tys =>
         return () (*(TextIO.print (TypeInference.showTable tys))*)
         )))

      fun runTc fps = let
         val ers = Error.mkErrStream'()
         val () = Controls.set (BasicControl.verbose, 1)
         val () = Stats.resetAll()
      in
         CompilationMonad.run ers (allTc fps >> return ())
            before
               Stats.report()
      end
   end

   fun showControls () = let
      fun err msg = TextIO.output (TextIO.stdErr, msg)
   in
      BasicControl.showAll
         err
         (Controls.name o #ctl,
          fn ci =>
            concat
               [#help (Controls.info (#ctl ci)),
                " : ", Controls.get (#ctl ci)])
         NONE
   end

   val usageMsg = "\
\usage: gdslc [options] file\n\
\  options:\n\
\    -C<control>=<v>  set named control\n\
\    -h               show help message\n\
\    -p pfx\n\
\    --prefix=pfx     prefix functions with pfx\n\
\    -r path\n\
\    --runtime=path   path to the runtime files, defaults to detail/codegen/c1/\n\
\    -o name\n\
\    --outname=name   base name of output file, defaults to gdsl-pfx\n\
\    -t               do not run the type checker\n\
\    --maxIter=n      restrict fixpoint in type checker to n iterations\n\
\    --boxTheshold=n  box fixed records with more than n fields\n\
\    --target=lang    language of output, one of C99,C89\n\
\"

   fun processControl arg = let
      val spec = Substring.extract (arg, 2, NONE)
      val (name, value) = Substring.splitl (fn c => c <> #"=") spec
      val name = Substring.string name
      val names = String.fields (fn c => c = #".") name
      val value =
         if Substring.size value > 0
            then Substring.string (Substring.slice (value, 1, NONE))
         else ""
   in
      if name = "" orelse value = ""
         then bad (concat ["!* ill-formed -C option: `", arg, "'\n"])
      else
         (case ControlRegistry.control BasicControl.topRegistry names of
            NONE => bad (concat ["!* unknown control: ", name, "\n"])
          | SOME sctl =>
               (Controls.set (sctl, value)
                  handle Controls.ValueSyntax vse =>
                     bad
                        (concat
                           ["!* unable to parse value `",
                            value, "' for ", name, " : ", #tyName vse, "\n"])))
   end

   and processPrefix arg = Controls.set (BasicControl.exportPrefix, arg)

   and processLibname arg = Controls.set (BasicControl.outputName, SOME arg)

   and processRuntime arg =
      if String.size arg=0 then () else
      if String.sub (arg,String.size arg-1) = #"/" then
         Controls.set (BasicControl.runtimePath, String.substring (arg,0,String.size arg-1))
      else
         Controls.set (BasicControl.runtimePath, arg)

   and processMaxIter arg = case Int.fromString arg of
      SOME num => Controls.set (BasicControl.maxIter, num)
    | NONE => bad ("!* expected number for --maxIter\n")
    
   and processBoxThreshold arg = case Int.fromString arg of
      SOME num => Controls.set (BasicControl.boxThreshold, num)
    | NONE => bad ("!* expected number for --boxThreshold\n")
    
   and processTargetLanguage arg =
      case String.implode (List.map Char.toUpper (String.explode arg)) of
      "C99" => Controls.set (BasicControl.targetLanguage, BasicControl.C99)
    | "C89" => Controls.set (BasicControl.targetLanguage, BasicControl.C89)
    | _ => bad ("!* expected a language for --target\n")
    
   and processArgs args =
      case args of
         arg :: args =>
            if String.size arg > 0 andalso String.sub (arg, 0) = #"-"
               then processOption (arg, args)
            else processFile (arg, args)
       | _ => usage ()

   and processFile (file, files) = run (file::files)

   and processOption (arg, args) = let
      fun badopt () = bad (concat ["!* ill-formed option: '", arg, "'\n"])
      fun set ctl = (Controls.set(ctl, true); processArgs args)
   in
      if String.isPrefix "-C" arg
         then (processControl arg; processArgs args)
      else
      if String.isPrefix "--prefix=" arg
         then (processPrefix (String.extract (arg,9,NONE)); processArgs args)
      else
      if String.isPrefix "--runtime=" arg
         then (processRuntime (String.extract (arg,10,NONE)); processArgs args)
      else
      if String.isPrefix "--outname=" arg
         then (processLibname (String.extract (arg,10,NONE)); processArgs args)
      else
      if String.isPrefix "--maxIter=" arg
         then (processMaxIter (String.extract (arg,10,NONE)); processArgs args)
      else
      if String.isPrefix "--boxThreshold=" arg
         then (processBoxThreshold (String.extract (arg,15,NONE)); processArgs args)
      else
      if String.isPrefix "--target=" arg
         then (processTargetLanguage (String.extract (arg,9,NONE)); processArgs args)
      else
         case arg of
            "-h" => usage ()
          | "-m" => (Controls.set (BasicControl.principalTypings, false); processArgs args)
          | "-t" => (Controls.set (BasicControl.skipTypeCheck, true); processArgs args)
          | "-verbose" => (Controls.set(BasicControl.verbose, 1); processArgs args)
          | "-p" => (case args of
             (arg :: args) => (processPrefix arg; processArgs args)
           | [] => badopt ()
           )
          | "-o" => (case args of
             (arg :: args) => (processLibname arg; processArgs args)
           | [] => badopt ()
           )
          | "-r" => (case args of
             (arg :: args) => (processRuntime arg; processArgs args)
           | [] => badopt ()
           )
          | _ => badopt ()
   end

   and bad s =
      (TextIO.output (TextIO.stdErr, s)
      ;usage())

   and usage () =
      (showControls()
      ;TextIO.output (TextIO.stdErr, usageMsg)
      ;OS.Process.exit OS.Process.failure)

   and run fp = Passes.run fp
   fun main () =
      (processArgs (CommandLine.arguments())
      ;OS.Process.exit OS.Process.success)
   fun njMain (_,args) = (processArgs args; OS.Process.success)

end
