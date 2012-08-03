
structure PrettyC = struct
   open Layout Pretty
   val var = str o Mangle.apply
   fun args xs = seq [lp, seq (separate (map var xs, ",")), rp]
   fun prototype (f, xs) =
      seq
         [str "__obj", space, var f, space, lp,
          seq (separate (map (fn _ => str "__obj") xs, ",")), rp,
          str ";"]
   fun staticPrototype (f, xs) = seq [str "static", space, prototype (f, xs)]
   fun function (f, xs, body) =
      align
         [seq
            [str "__obj", space, var f, space, lp,
             seq
               (separate
                  (map
                     (fn x =>
                        seq [str "__obj", space, var x]) xs, ",")),
             rp, space, lb],
          indent 2 body, rb]
   fun cseq stmts = align (separateRight (stmts, ";"))
   fun stmt s = seq [s, str ";"]
   fun local0 x = seq [str "__LOCAL0", lp, var x, rp]
   fun local1 (x, body) = seq [str "__LOCAL", lp, var x, comma, body, rp]
   fun call' (f, xs) = seq [str f, xs]
   fun call (f, xs) = seq [var f, args xs]
   fun comment t = seq [str "/*", t, str "*/"]
   fun define (x, v) = seq [str "#define", space, x, space, v]
   fun caseTag ty x =
      let
         val casetag = 
            case ty of
               CPS.Exp.CASETYCON => "__CASETAGCON"
             | CPS.Exp.CASETYVEC => "__CASETAGVEC"
             | CPS.Exp.CASETYINT => "__CASETAGINT"
      in
         seq [str casetag, args [x]]
      end
   fun return x = seq [str "return", space, lp, x, rp, str ";"]
   fun switch (x, cases, dflt) =
      align
         [seq [str "switch", lp, x, rp, space, lb],
          indent 2 (align cases),
          indent 2 (align [str "default: {", indent 2 dflt, rb]),
          rb]
   fun casee (cs, body) =
      align
         [seq
            [align
               (map
                  (fn c =>
                     seq
                        [str "case", space, CPS.PP.caseTag c, colon]) cs),
          space, lb],
          indent 2 body, rb]
   fun invoke (f, xs) =
      let
         val n = List.length xs
         val i = str o Int.toString
      in
         seq [str "__INVOKE", i n, args (f::xs)]
      end
   fun fastinvoke (f, xs) = seq [str "__FCALL", args (f::xs)]
end

structure C0Templates = struct
   val header = ExpandFile.mkTemplateFromFile "detail/codegen/c0/runtime.h"
   val runtime = ExpandFile.mkTemplateFromFile "detail/codegen/c0/runtime.c"

   fun expandHeader hooks =
      ExpandFile.expandTemplate
         {src=header,
          dst="dis.h",
          hooks=hooks}

   fun expandRuntime hooks =
      ExpandFile.expandTemplate
         {src=runtime,
          dst="dis.c",
          hooks=hooks}

   fun mkPrint f os = Pretty.prettyTo(os, f())
   fun mkPrototypesHook d = ("prototypes", mkPrint (fn () => d))
   fun mkFunctionsHook d = ("functions", mkPrint (fn () => d))
   fun mkConstrutorsHook d = ("constructors", mkPrint (fn () => d))
   fun mkFieldsHook d = ("fields", mkPrint (fn () => d))
   fun mkExportsHook d = ("exports", mkPrint (fn () => d))
   fun mkFieldNamesHook d = ("tagnames", mkPrint (fn () => d))
   fun mkTagNamesHook d = ("fieldnames", mkPrint (fn () => d))
end

structure C = struct
   structure CM = CompilationMonad
   structure Clos = Closure
   structure C0 = C0Templates
   structure CI = ConInfo
   structure FI = FieldInfo

   open Clos.Fun Clos.Stmt

   fun codegen spec =
      let
         open Layout Pretty
         val () = Mangle.reset()
         val clos = Spec.get#declarations spec
         val exports = Spec.get#exports spec
         fun exported f =
            List.exists
               (fn g => SymbolTable.eq_symid (f, g))
               exports

         fun emitConTag tag =
            seq [str (Int.toString (ConInfo.toInt tag)),
                 PrettyC.comment (CPS.PP.con tag)]

         fun emitField f =
            seq [str (Int.toString (VarInfo.toInt f)),
                 PrettyC.comment (CPS.PP.fld f)]
        
         fun emitDecon x = seq [str "__DECON",lp,PrettyC.var x,rp]

         fun emitRecordSelect (f, x) =
            seq
               [str "__RECORD_SELECT", lp,
                PrettyC.var x, str ",", emitField f, rp]

         fun emitRecordAdd (f, x) =
            seq
               [str "__RECORD_ADD", lp,
                emitField f, str ",", PrettyC.var x, rp]

         fun emitRecordUpdate (f, x) =
            seq
               [str "__RECORD_UPDATE", lp,
                emitField f, str ",", PrettyC.var x, rp]

         fun emitEnvRef (x, i) =
            PrettyC.call'
               ("__CLOSURE_REF",
                seq [lp, PrettyC.var x, str ",", str (Int.toString i), rp])

         fun emitEnvAdd x = PrettyC.call' ("__CLOSURE_ADD", PrettyC.args [x])

         fun emitVecLit v =
            case v of
               "" => str "0"
             | _ =>
               str
                  (Int.toString
                     (valOf (StringCvt.scanString (Int.scan StringCvt.BIN) v)))

         fun emitStmts stmts = PrettyC.cseq (map emitStmt stmts)
         and emitStmt stmt =
            case stmt of
               LETVAL (x, cval) => emitCVal x cval
             | LETPRJ (y, f, x) =>
                  PrettyC.local1(y, emitRecordSelect (f, x)) 
             | LETDECON (y, x) =>
                  PrettyC.local1(y, emitDecon x) 
             | LETREF (y, x, i) =>
                  PrettyC.local1(y, emitEnvRef (x, i))
             | LETUPD (y, x, fs) =>
                  PrettyC.cseq
                     [PrettyC.local0 y,
                      indent 2
                        (PrettyC.cseq
                           [PrettyC.call'
                              ("__RECORD_BEGIN_UPDATE",
                               PrettyC.args [y, x]),
                            PrettyC.cseq (map emitRecordUpdate fs),
                            PrettyC.call'
                              ("__RECORD_END_UPDATE",
                               PrettyC.args [y])])]
             | LETENV (y, xs) =>
                  let
                     val n = str (Int.toString (List.length xs))
                     val args = seq [lp, PrettyC.var y, str ",", n, rp]
                  in
                     PrettyC.cseq
                        [PrettyC.local0 y,
                         indent 2
                           (PrettyC.cseq
                              [PrettyC.call' ("__CLOSURE_BEGIN", args),
                               PrettyC.cseq (map emitEnvAdd (rev xs)),
                               PrettyC.call' ("__CLOSURE_END", args)])]
                  end

         and emitCVal x v =
            case v of
               PRI (f, xs) => PrettyC.local1 (x, PrettyC.call (f, xs))
             | LAB f =>
                  PrettyC.cseq
                     [PrettyC.local0 x,
                      indent 2
                        (PrettyC.cseq
                           [PrettyC.call' ("__LABEL_BEGIN", PrettyC.args [x]),
                            PrettyC.call' ("__LABEL_INIT", PrettyC.args [f]),
                            PrettyC.call' ("__LABEL_END", PrettyC.args [x])])]
             | INT i =>
                  PrettyC.cseq
                     [PrettyC.local0 x,
                      indent 2
                        (PrettyC.cseq
                           [PrettyC.call' ("__INT_BEGIN", PrettyC.args [x]),
                            PrettyC.call'
                              ("__INT_INIT",
                               seq [lp, str (IntInf.toString i), rp]),
                            PrettyC.call' ("__INT_END", PrettyC.args [x])])]
             | INJ (t, y) =>
                  PrettyC.cseq
                     [PrettyC.local0 x,
                      indent 2
                        (PrettyC.cseq
                           [PrettyC.call'
                              ("__TAGGED_BEGIN", PrettyC.args [x]),
                            PrettyC.call'
                              ("__TAGGED_INIT",
                               seq
                                 [lp, emitConTag t, str ",",
                                  PrettyC.var y, rp]),
                            PrettyC.call'
                              ("__TAGGED_END", PrettyC.args [x])])]
             | VEC v =>
                  let
                     val n = str (Int.toString (String.size v))
                     val v = emitVecLit v
                     val args = seq [lp, PrettyC.var x, str ",", n, rp]
                  in
                     PrettyC.cseq
                        [PrettyC.local0 x,
                         indent 2
                           (PrettyC.cseq
                              [PrettyC.call' ("__BV_BEGIN", args),
                               PrettyC.call' ("__BV_INIT", seq [lp, v, rp]),
                               PrettyC.call' ("__BV_END", args)])]
                  end
             | REC fs =>
                  let
                     val n = str (Int.toString (List.length fs))
                     val args = seq [lp, PrettyC.var x, str ",", n, rp]
                  in
                     PrettyC.cseq
                        [PrettyC.local0 x,
                         indent 2
                           (PrettyC.cseq
                              [PrettyC.call' ("__RECORD_BEGIN", args),
                               PrettyC.cseq (map emitRecordAdd fs),
                               PrettyC.call' ("__RECORD_END", args)])]
                  end
             | UNT => PrettyC.local1(x, str "__UNIT")
             | STR s => 
                  let
                     val args = seq [lp, PrettyC.var x, rp]
                     fun escape s = 
                        String.translate
                           (fn c =>
                              case c of
                                 #"\n" => "\\n"
                               | _ => String.str c) s
                  in
                     PrettyC.cseq
                        [PrettyC.local0 x,
                         indent 2
                           (PrettyC.cseq
                              [PrettyC.call' ("__ROPE_BEGIN", args),
                               PrettyC.call'
                                 ("__ROPE_FROMCSTRING",
                                  seq [lp,str"\"",str (escape s),str"\"",rp]),
                               PrettyC.call' ("__ROPE_END", args)])]
                  end
                  
             | _ => (* TODO *) raise Fail "Unimplemented literal"

         fun emitFlow f =
            case f of
               APP {f, closure, k, xs} =>
                  PrettyC.return (PrettyC.invoke (f, closure::k::xs))
             | FASTAPP {f, k, xs} =>
                  PrettyC.return (PrettyC.fastinvoke (f, k::xs))
             | CC {k, closure, xs} =>
                  PrettyC.return (PrettyC.invoke (k, closure::xs))
             | FASTCC {k, xs} =>
                  PrettyC.return (PrettyC.fastinvoke (k, xs))
             | CASE (ty, x, cs) =>
                  let
                     val cs' = List.filter (fn (cs, _) => not (null cs)) cs
                     val dflt = List.find (fn (cs, _) => null cs) cs
                     val fatalDflt = seq [str "__FATAL(\"[MATCH]\");"]
                     val dflt =
                        case dflt of
                           NONE => fatalDflt
                         | SOME (_, block) => emitBlock block
                  in
                     PrettyC.switch
                        (PrettyC.caseTag ty x, map emitCase cs', dflt)
                  end

         and emitCase (cs, block) = PrettyC.casee (cs, emitBlock block)
                  
         and emitBlock (BLOCK {stmts, flow}) =
            case stmts of
               [] => emitFlow flow
             | stmts => PrettyC.cseq [emitStmts stmts, emitFlow flow]

         fun emitPrototype f =
            case f of
               FUN {f, closure, k, xs, body} =>
                  PrettyC.prototype (f, closure::k::xs)
             | FASTFUN {f, k, xs, body} =>
                  PrettyC.prototype (f, k::xs)
             | CONT {k, closure, xs, body} =>
                  PrettyC.prototype (k, closure::xs)
             | FASTCONT {k, xs, body} =>
                  PrettyC.prototype (k, xs)

         fun emitStaticPrototype f =
            case f of
               FUN {f, closure, k, xs, body} =>
                  PrettyC.staticPrototype (f, closure::k::xs)
             | FASTFUN {f, k, xs, body} =>
                  PrettyC.staticPrototype (f, k::xs)
             | CONT {k, closure, xs, body} =>
                  PrettyC.staticPrototype (k, closure::xs)
             | FASTCONT {k, xs, body} =>
                  PrettyC.staticPrototype (k, xs)
            
         fun emitFun f =
            case f of
               FUN {f, k, closure, xs, body} =>
                  PrettyC.function (f, closure::k::xs, emitBlock body)
             | FASTFUN {f, k, xs, body} =>
                  PrettyC.function (f, k::xs, emitBlock body)
             | CONT {k, closure, xs, body} =>
                  PrettyC.function (k, closure::xs, emitBlock body)
             | FASTCONT {k, xs, body} =>
                  PrettyC.function (k, xs, emitBlock body)

         fun getSym f =
            case f of
               FUN {f,...} => f
             | FASTFUN {f,...} => f
             | CONT {k,...} => k
             | FASTCONT {k,...} => k

         (* TODO: use `List.partition` instead of 2 calls to `filter` *)
         val exportedFn = List.filter (exported o getSym) clos
         (* register exported names *)
         val () =
            app (fn f =>
               let
                  val _ = Mangle.applyExport (getSym f)
               in
                  ()
               end) exportedFn
         val staticFn = List.filter (not o exported o getSym) clos

         val externPrototypes = map emitPrototype exportedFn
         val staticPrototypes = map emitStaticPrototype staticFn

         val constructors =
            let
               val i = str o Int.toString
               val cs = CI.listItems (!SymbolTables.conTable)
            in
               PrettyC.define (str "__NTAGS", i (length cs+1)):: 
               map (fn tag =>
                  PrettyC.define
                     (str (Mangle.applyTag tag),
                      emitConTag tag)) cs
            end

         val fields =
            let
               val i = str o Int.toString
               val fs = FI.listItems (!SymbolTables.fieldTable)
            in
               PrettyC.define (str "__NFIELDS", i (length fs+1))::
               map (fn f =>
                  PrettyC.define
                     (str (Mangle.applyField f),
                      emitField f)) fs
            end

         val constructorNames =
            let
               val cs = CI.listItems (!SymbolTables.conTable)
               val cs = 
                  map
                     (fn tag =>
                        seq [str "\"",
                             str (Mangle.getStringOfTag tag),
                             str "\""]) cs
            in
               align
                  [seq [str "static const char* __tagNames[] = "],
                   indent 2
                     (seq [listex "{" "}" "," (str "\"<reserved>\""::cs),
                           str ";"])]
            end 

         val fieldNames =
            let
               val fs = FI.listItems (!SymbolTables.fieldTable)
               val fs = 
                  map
                     (fn f =>
                        seq [str "\"",
                             str (Mangle.getStringOfField f),
                             str "\""]) fs
            in
               align
                  [seq [str "static const char* __fieldNames[] = "],
                   indent 2
                     (seq [listex "{" "}" "," (str "\"blob\""::fs),
                           str ";"])]
            end 

         val funs = map emitFun clos
         val _ =
            C0.expandHeader
               [C0.mkConstrutorsHook (align constructors),
                C0.mkFieldsHook (align fields),
                C0.mkExportsHook (align externPrototypes)]
         val _ =
            C0.expandRuntime
               [C0.mkPrototypesHook (align staticPrototypes),
                C0.mkFunctionsHook (align funs),
                C0.mkTagNamesHook constructorNames,
                C0.mkFieldNamesHook fieldNames]
      in
         align (externPrototypes @ staticPrototypes @ funs)
      end

   fun dumpPre (os, spec) = Pretty.prettyTo (os, Closure.PP.spec spec)
   fun dumpPost (os, c) = Pretty.prettyTo (os, c)

   val pass =
      BasicControl.mkKeepPass
         {passName="c0Codegen",
          registry=CodegenControl.registry,
          pass=codegen,
          preExt="clos",
          preOutput=dumpPre,
          postExt="c",
          postOutput=dumpPost}

   fun run spec = CM.return (pass spec)
end
