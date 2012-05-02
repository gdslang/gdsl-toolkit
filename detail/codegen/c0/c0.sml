
structure Mangle = struct
   structure Map = StringMap
   structure VI = VarInfo

   val variables = SymbolTables.varTable
   val names = ref Map.empty : string Map.map ref
   val revnames = ref Map.empty : string Map.map ref
   val stamp = ref 0

   fun getString sym =
      let
         val s = VI.getString (!variables, sym)
      in
         if String.isPrefix "%" s
            then Atom.toString (VI.getAtom(!variables, sym))
         else s
      end

   fun insert (plain, mangled) =
      (names :=
         Map.insert
            (!names,
             plain,
             mangled)
      ;revnames :=
         Map.insert
            (!revnames,
             mangled,
             plain))

   fun reverseFind mangled = Map.find (!revnames, mangled)

   fun next () = 
      let
         val s = !stamp
      in
         s before stamp := s + 1
      end

   fun resolveCollision n =
      let
         val s = n ^ Int.toString (next())
      in
         s
      end

   fun mangleName s =
      let
         fun tf c =
            case c of
               #"%" => "__"
             | #"#" => "_"
             | #"<" => "_lt_"
             | #">" => "_gt_"
             | #"=" => "_eq_"
             | #"!" => "_ex_"
             | #"*" => "_star_"
             | #"-" => "_minus_"
             | #"^" => "_concat_"
             | #"/" => "_slash_"
             | #"?" => "_q_"
             | _ => String.str c
      in
         String.translate tf s
      end

   fun mangle sym = 
      let
         val mangled = mangleName sym
      in
         case reverseFind mangled of
            NONE =>
               (insert (sym, mangled)
               ;mangled)
          | SOME _ =>
               (insert (sym, resolveCollision mangled)
               ;mangled)
      end

   fun apply sym =
      let
         val sym = getString sym
      in
         case Map.find (!names, sym) of
            SOME csym => csym
          | NONE => mangle sym
      end

   (*
   val apply = fn sym =>
      (Pretty.prettyTo (TextIO.stdOut, CPS.PP.var sym);print"\n";apply sym)
   *)
end

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
   fun caseTag x = seq [str "__CASETAG", args [x]]
   fun return x = seq [str "return", space, x, str ";"]
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
end

structure C = struct
   structure CM = CompilationMonad
   structure Clos = Closure
   structure C0 = C0Templates
   open Clos.Fun Clos.Stmt

   fun codegen spec =
      let
         open Layout Pretty
         val clos = Spec.get#declarations spec
         val exports = Spec.get#exports spec
         fun exported f =
            List.exists
               (fn g => SymbolTable.eq_symid (f, g))
               exports

         val emitConTag = str o Int.toString o ConInfo.toInt

         fun emitField f =
            seq [str (Int.toString (VarInfo.toInt f)),
                 PrettyC.comment (CPS.PP.fld f)]
         
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
            let
               val i = StringCvt.scanString (Int.scan StringCvt.BIN) v
            in
               str (Int.toString (valOf i))
            end

         fun emitStmts stmts = PrettyC.cseq (map emitStmt stmts)
         and emitStmt stmt =
            case stmt of
               LETVAL (x, cval) => emitCVal x cval
             | LETPRJ (y, f, x) =>
                  PrettyC.local1(y, emitRecordSelect (f, x)) 
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
             | STR s => (* TODO *) PrettyC.local1(x, str "__UNIT")
             | _ => (* TODO *) raise Fail "unimplemented letval binding"

         fun emitFlow f =
            case f of
               APP {f, closure, k, xs} =>
                  PrettyC.return (PrettyC.invoke (f, closure::k::xs))
             | CC {k, closure, xs} =>
                  PrettyC.return (PrettyC.invoke (k, closure::xs))
             | CASE (x, cs) =>
                  let
                     val cs' = List.filter (fn (cs, _) => not (null cs)) cs
                     val dflt = List.find (fn (cs, _) => null cs) cs'
                     val fatalDflt = seq [str "__fatal(\"Match\");"]
                     val dflt =
                        case dflt of
                           NONE => fatalDflt
                         | SOME (_, block) => emitBlock block
                  in
                     PrettyC.switch
                        (PrettyC.caseTag x, map emitCase cs', dflt)
                  end

         and emitCase (cs, block) = PrettyC.casee (cs, emitBlock block)
                  
         and emitBlock (BLOCK {stmts, flow}) =
            PrettyC.cseq [emitStmts stmts, emitFlow flow]

         fun emitPrototype f =
            case f of
               FUN {f, closure, k, xs, body} =>
                  PrettyC.prototype (f, closure::k::xs)
             | CONT {k, closure, xs, body} =>
                  PrettyC.prototype (k, closure::xs)

         fun emitStaticPrototype f =
            case f of
               FUN {f, closure, k, xs, body} =>
                  PrettyC.staticPrototype (f, closure::k::xs)
             | CONT {k, closure, xs, body} =>
                  PrettyC.staticPrototype (k, closure::xs)
            
         fun emitFun f =
            case f of
               FUN {f, k, closure, xs, body} =>
                  PrettyC.function (f, closure::k::xs, emitBlock body)
             | CONT {k, closure, xs, body} =>
                  PrettyC.function (k, closure::xs, emitBlock body)

         fun getSym f =
            case f of
               FUN {f,...} => f
             | CONT {k,...} => k

         (* TODO: use List.partition instead of 2 calls to filter *)
         val exportedFn = List.filter (exported o getSym) clos
         val staticFn = List.filter (not o exported o getSym) clos

         val prototypes =
            map emitPrototype exportedFn @
            map emitStaticPrototype staticFn

         val funs = map emitFun clos
         val _ = C0.expandHeader []
         val _ =
            C0.expandRuntime
               [C0.mkPrototypesHook (align prototypes),
                C0.mkFunctionsHook (align funs)]
      in
         align (prototypes @ funs)
      end

   fun dumpPre (os, spec) = Pretty.prettyTo (os, Closure.PP.spec spec)
   fun dumpPost (os, c) = Pretty.prettyTo (os, c)

   val pass =
      BasicControl.mkKeepPass
         {passName="cCodegen",
          registry=CodegenControl.registry,
          pass=codegen,
          preExt="clos",
          preOutput=dumpPre,
          postExt="c",
          postOutput=dumpPost}

   fun run spec = CM.return (pass spec)
end
