
structure Main = struct

   structure Passes = struct
      open CompilationMonad
      infix >>= >>

      fun all ins =
         Parser.run ins >>=
         ResolveSymbols.run >>=
         Desugar.run

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
\usage: spec [options] file\n\
\  options:\n\
\    -C<control>=<v>  set named control\n\
\    -h               show help message\n\
\    -verbose         verbose mode\n\
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

   and processArgs args =
      case args of
         arg :: args =>
            if String.size arg > 0 andalso String.sub (arg, 0) = #"-"
               then processOption (arg, args)
            else processFile (arg, args)
       | _ => usage ()

   and processFile (arg, args) =
      case (arg, args) of
         (file, []) => run file
       | _ => usage ()

   and processOption (arg, args) = let
      fun badopt () = bad (concat ["!* ill-formed option: '", arg, "'\n"])
      fun set ctl = (Controls.set(ctl, true); processArgs args)
   in
      if String.isPrefix "-C" arg
         then (processControl arg; processArgs args)
      else
         case arg of
            "-h" => usage ()
          | "-verbose" => (Controls.set(BasicControl.verbose, 1); processArgs args)
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
end
