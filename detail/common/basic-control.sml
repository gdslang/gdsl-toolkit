(* basic-control.sml
 *
 * COPYRIGHT (c) 2007 The Manticore Project (http://manticore.cs.uchicago.edu/)
 * All rights reserved.
 *
 * Basic controls for the pmlc compiler.
 *)

structure BasicControl :  sig

  (* the top-level registery of the compiler *)
    val topRegistry : ControlRegistry.registry

  (* nest a tier-2 registery within the top-level registery *)
    val nest : string * ControlRegistry.registry * Controls.priority -> unit

  (* base name for pass output files; set based on compilation unit. *)
    val keepPassBaseName : string option Controls.control

  (* verbosity of diagnostics. *)
    val verbose : int Controls.control

  (* link with debug version of runtime mode *)
    val debug : bool Controls.control

  (* enable collection of GC and memory statistics *)
    val gcStats : bool Controls.control

  (* the name for the generated file *)
    val outputName : string option Controls.control

  (* the name for the generated file *)
    val runtimePath : string Controls.control

  (* the prefix for exported functions *)
    val exportPrefix : string Controls.control

  (* on demand, skip type inference *)
    val skipTypeCheck : bool Controls.control

  (* maximum number of iterations in the type checker before giving up *)
    val maxIter : int Controls.control

  (* wheather to infer principal typings *)
    val principalTypings : bool Controls.control

  (* the number of fields in a fixed record after which it is allocated
      on the heap rather than passed by value *)
    val boxThreshold : int Controls.control

  datatype target_lang
      = C99
      | C89

  (* language of the emitted code *)
    val targetLanguage : target_lang Controls.control
    
  (* wrap a 'pre -> 'post pass with a tracing diagnostic, controled by the
   * "verbose" control.
   *)
    val mkTracePass : {
            passName: string,
            pass: 'pre -> 'post,
            verbose: int
	  } -> 'pre -> 'post
    val mkTracePassSimple : {
            passName: string,
            pass: 'pre -> 'post
	  } -> 'pre -> 'post

  (* wrap a 'pre -> 'post pass with debug output controled by a new
   * "keep" control.  The pass is also traced (as with mkTracePass).
   *)
    val mkKeepPass : {
	    preOutput: TextIO.outstream * 'pre -> unit,
            preExt: string,
            postOutput: TextIO.outstream * 'post -> unit,
            postExt: string,
            passName: string,
            pass: 'pre -> 'post,
            registry: ControlRegistry.registry
	  } -> 'pre -> 'post

    val mkKeepPassSimple : {
	    output: TextIO.outstream * 'a -> unit,
            ext: string,
            passName: string,
            pass: 'a -> 'a,
            registry: ControlRegistry.registry
	  } -> 'a -> 'a

   val debugObscurity : int

  (* *)
    val showAll : (string -> unit) ->
                  (({ctl: string Controls.control,
                     info: ControlRegistry.control_info} -> string) *
                   ({ctl: string Controls.control,
                     info: ControlRegistry.control_info} -> string)) ->
                  int option -> unit

    val newRegistryWithDebug : {name : string, help : string, pri : int}
	  -> (ControlRegistry.registry * bool Controls.control)

  end = struct

    val topRegistry = ControlRegistry.new {help = "SPEC Controls"}

    fun nest (prefix, reg, pri) = ControlRegistry.nest topRegistry {
	    prefix = SOME prefix,
	    pri = pri,
	    obscurity = 0,
	    reg = reg
	  }

    val debugObscurity = 2

    val keepPassBaseName : string option Controls.control = Controls.genControl {
	    name = "keepPassBaseName",
	    pri = [5, 0],
	    obscurity = debugObscurity + 1,
	    help = "",
	    default = NONE
	  }

    val verbose : int Controls.control = Controls.genControl {
	    name = "verbose",
	    pri = [0, 0],
	    obscurity = 0,
	    help = "controls verbosity of debugging messages",
	    default = 0
	  }

  (* link with debug version of runtime mode *)
    val debug : bool Controls.control = Controls.genControl {
	    name = "debug",
	    pri = [0, 1, 2],
	    obscurity = 0,
	    help = "include debugging support",
	    default = false
	  }

  (* enable collection of GC and memory statistics *)
    val gcStats : bool Controls.control = Controls.genControl {
	    name = "gcstats",
	    pri = [0, 1, 3],
	    obscurity = 0,
	    help = "enable collection of GC statistics",
	    default = false
	  }

  (* the name for the generated file *)
    val outputName : string option Controls.control = Controls.genControl {
	    name = "output",
	    pri = [0],
	    obscurity = 0,
	    help = "name of the output file",
	    default = NONE
	  }

  (* the path to the files *)
    val runtimePath : string Controls.control = Controls.genControl {
	    name = "runtime",
	    pri = [0],
	    obscurity = 0,
	    help = "path to the runtime files",
	    default = "./detail/codegen/"
	  }

  (*  the prefix for exported functions*)
    val exportPrefix : string Controls.control = Controls.genControl {
	    name = "prefix",
	    pri = [0],
	    obscurity = 0,
	    help = "specify a prefix for all exported functions",
	    default = "gdsl"
	  }

  (* on demand, skip type inference *)
    val skipTypeCheck : bool Controls.control = Controls.genControl {
	    name = "t",
	    pri = [0],
	    obscurity = 0,
	    help = "do not run the type checker",
	    default = false
    }

  (* maximum number of iterations in the type checker before giving up *)
    val maxIter : int Controls.control = Controls.genControl {
	    name = "maxIter",
	    pri = [0],
	    obscurity = 0,
	    help = "maximum number of fixpoint iterations in type checker",
	    default = 3
    }

  (* wheather to infer principal typings *)
    val principalTypings : bool Controls.control = Controls.genControl {
	    name = "m",
	    pri = [0],
	    obscurity = 0,
	    help = "infer Hindley-Milner rather than exact types",
	    default = false
    }


  (* the number of fields in a fixed record after which it is allocated
      on the heap rather than passed by value *)
    val boxThreshold : int Controls.control = Controls.genControl {
	    name = "boxThreshold",
	    pri = [0],
	    obscurity = 0,
	    help = "no of fields in a record before it is boxed",
	    default = 100
    }

  datatype target_lang
      = C99
      | C89

  (* language of the emitted code *)
    val targetLanguage : target_lang Controls.control = Controls.genControl {
	    name = "target",
	    pri = [0],
	    obscurity = 0,
	    help = "language of the emitted code (C89,C99)",
	    default = C99
    }

    
    val () = (
	  ControlRegistry.register topRegistry {
	      ctl = Controls.stringControl ControlUtil.Cvt.int verbose,
	      envName = NONE
	    };
	  ControlRegistry.register topRegistry {
	      ctl = Controls.stringControl ControlUtil.Cvt.bool debug,
	      envName = NONE
	    })

    local
      val indent = ref 0
      val verboseCtl = verbose
    in
    val push = fn () => indent := !indent + 4
    val pop = fn () => indent := !indent - 4
    val say = fn s => (
	  print (CharVector.tabulate (!indent, fn _ => #" "));
	  print s;
	  print "\n")

    fun ('pre, 'post) mkTracePass {
	  passName : string,
	  pass : 'pre -> 'post,
	  verbose : int
	} = let
	  fun trace pre = let
		val msg = Controls.get verboseCtl >= verbose
                val inclusiveStart = Timer.startCPUTimer()
		in
		  if msg
		    then (push (); say (concat [passName, " starting"]))
		    else ();
(***** NOTE: intercepting the exception here breaks the backtrace monitor.
		  (pass pre handle exn => (
		    say (concat [passName, " raised exception ", exnName exn]);
		    if msg then pop () else ();
		    raise exn)
		  ) before
*)
		  (pass pre) before
		    (if msg
		      then (let
                                val gc = Timer.checkGCTime inclusiveStart
                                val {usr,sys} = Timer.checkCPUTimer inclusiveStart
                                val inclusive = Time.+(usr, sys)
                            in
                                say
                                 (concat
                                    [passName,
                                     " finished in: ",
                                     (Time.toString inclusive), "s (",
                                     (Time.toString gc), "s gc)"]);
                                pop ()
                            end)
		      else ())
		end
	  in
	    trace
	  end
    fun mkTracePassSimple {passName: string, pass: 'pre -> 'post} =
	  mkTracePass {passName = passName, pass = pass, verbose = 1}
    end (* local *)

  (* open an output file while reporting it on stdout *)
    fun openOut filename = let
	  val outS = TextIO.openOut filename
	  in
	    say(concat["dumping info to ", filename]);
	    outS
	  end

    fun ('pre, 'post) mkKeepPass {
	  preOutput : TextIO.outstream * 'pre -> unit,
	  preExt : string,
	  postOutput : TextIO.outstream * 'post -> unit,
	  postExt : string,
	  passName : string,
	  pass : 'pre -> 'post,
	  registry : ControlRegistry.registry
	} : 'pre -> 'post = let
          val keepPassCtl = Controls.genControl {
		name = "keep-" ^ passName,
		pri = [5, 0],
		obscurity = 1,
		help = concat["keep ",  passName, " passes"],
		default = false
	      }
          val _ = ControlRegistry.register registry {
		ctl = Controls.stringControl ControlUtil.Cvt.bool keepPassCtl,
                envName = NONE
	      }
          val countRef = ref 0
	  fun wrap pre = let
      fun cntToString s = StringCvt.padLeft #"0" 3 (Int.toString s)
		val count = !countRef
		val () = countRef := count + 1
		val pass = mkTracePassSimple {passName = passName, pass = pass}
		val post = if Controls.get keepPassCtl
		      then let
			val fileName = (case Controls.get keepPassBaseName
			       of NONE => concat [passName, ".", cntToString count]
				| SOME baseName => concat [
				      baseName, ".", passName, ".", cntToString count
				    ]
			      (* end case *))
			val outPre = openOut (concat [fileName, ".pre.", preExt])
			val () = preOutput (outPre, pre)
			val () = TextIO.closeOut outPre
			val post = pass pre
			val outPost = openOut (concat [fileName, ".post.", postExt])
			val () = postOutput (outPost, post)
			val () = TextIO.closeOut outPost
			in
			  post
			end
		      else pass pre
		in
		  post
		end
	  in
	    wrap
	  end

    fun mkKeepPassSimple {
	  output: TextIO.outstream * 'a -> unit,
	  ext: string,
	  passName: string,
	  pass: 'a -> 'a,
	  registry: ControlRegistry.registry
	} = mkKeepPass {
	      preOutput = output,
	      preExt = ext,
	      postOutput = output,
	      postExt = ext,
	      passName = passName,
	      pass = pass,
	      registry = registry
	    }

    fun showAll output (getarg, getvalue) level = let
          fun walk indent (ControlRegistry.RTree rt) = let
        	val sp = CharVector.tabulate (indent, fn _ => #" ")
        	val sp' = CharVector.tabulate (indent + 1, fn _ => #" ")
        	val {help, ctls, subregs, path} = rt
        	fun one ci =
                   let
                      val arg = concat (foldr (fn (s, r) => s :: "." :: r)
                                              [getarg ci]
                                              path)
                      val value = getvalue ci
                   in
                      output (concat [sp',arg," : ",value,"\n"])
                   end
             in
        	(output (concat [sp, help, ":\n"])
                 ; app one ctls
                 ; app (walk (indent + 2)) subregs)
             end
       in
          walk 2 (ControlRegistry.controls (topRegistry, level))
       end

    fun newRegistryWithDebug {name, help, pri} = let
	  val newReg = ControlRegistry.new {help = help}
	  val priority = [pri]
	  val _ = nest (name, newReg, priority)
	  val debugCtl = Controls.genControl {
		  name = "debug",
		  pri = priority,
		  obscurity = debugObscurity,
		  help = "debug",
		  default = false
		}
	  in
	    ControlRegistry.register newReg {
	        ctl = Controls.stringControl ControlUtil.Cvt.bool debugCtl,
		envName = NONE
	      };
            (newReg, debugCtl)
	  end

   end
