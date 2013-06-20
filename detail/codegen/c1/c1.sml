
structure PrettyC1 = struct
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

structure C1Templates = struct
   val header = ExpandFile.mkTemplateFromFile "detail/codegen/c1/runtime.h"
   val runtime = ExpandFile.mkTemplateFromFile "detail/codegen/c1/runtime.c"

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

structure C1 = struct
   structure CM = CompilationMonad
   structure CI = ConInfo
   structure FI = FieldInfo

   open Imp
   open Layout Pretty

   exception CodeGenBug
   
   type state = { names : AtomSet.set,
                  symbols : Atom.atom SymMap.map,
                  ret : SymbolTable.symid }

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
             | #"-" => "_"
             | #"+" => "_plus_"
             | #"^" => "_hat_"
             | #"/" => "_slash_"
             | #"?" => "_q_"
             | #"&" => "_and_"
             | #"'" => "_tick_"
             | _ => String.str c
      in
         String.translate tf s
      end

   fun registerSymbol (sym,s : state) =
      let
         val atom = SymbolTable.getAtom (!SymbolTables.varTable, sym)
         val atom = Atom.atom (mangleName (Atom.toString atom))
         fun addEntry (atom,names,symbols) = 
            if AtomSet.member(names,atom) then
               addEntry (Atom.atom (Atom.toString atom ^ "_"), names, symbols)
            else
               (AtomSet.add (names,atom), SymMap.insert (symbols,sym,atom))
         val (names,symbols) = addEntry (atom,#names s,#symbols s)
      in
         { names = names,
           symbols = symbols,
           ret = #ret s }
      end

   fun setRet (sym,s : state) =
      { names = #names s, symbols = #symbols s, ret = sym }

   fun par arg = seq [str "(", arg, str ")"]
   fun list (lp,arg,xs,rp) = [str lp, seq (separate (map arg xs, ",")), str rp]
   fun fArgs args = par (separate (str "state_t* s" :: args, ","))
   fun comment cmt = seq [str "/* ", str cmt, str " */"]

   fun emitSym s sym = case SymMap.find (#symbols (s : state), sym) of
      SOME atom => str (Atom.toString atom)
    | NONE => (TextIO.print ("emitSym: no symbol name registered for " ^ SymbolTable.getString (!SymbolTables.varTable, sym) ^ "\n"); raise CodeGenBug)

   fun getConTag con = 
      "CON_" ^ mangleName (Atom.toString (SymbolTable.getAtom (!SymbolTables.conTable, con)))

   fun getFieldTag f = 
      "FLD_" ^ mangleName (Atom.toString (SymbolTable.getAtom (!SymbolTables.fieldTable, f)))

   fun emitType s (NONE, VOIDvtype) = str "void"
     | emitType s (SOME sym, VOIDvtype) = seq [str "void", space, emitSym s sym]
     | emitType s (NONE, BITvtype) = str "vec_t"
     | emitType s (SOME sym, BITvtype) = seq [str "vec_t", space, emitSym s sym]
     | emitType s (NONE, INTvtype) = str "int"
     | emitType s (SOME sym, INTvtype) = seq [str "int", space, emitSym s sym]
     | emitType s (NONE, STRINGvtype) = str "char*"
     | emitType s (SOME sym, STRINGvtype) = seq [str "char*", space, emitSym s sym]
     | emitType s (NONE, OBJvtype) = str "obj_ptr"
     | emitType s (SOME sym, OBJvtype) = seq [str "obj_ptr", space, emitSym s sym]
     | emitType s (symOpt, FUNvtype (retTy,_,argTys)) = seq (
         (case retTy of FUNvtype _ => seq [str "(", emitType s (NONE,retTy), str ")"]
                      | _ => emitType s (NONE,retTy)
         ) :: space :: str "(*" ::
         (case symOpt of NONE => [] | SOME sym => [emitSym s sym]) @
         list (")(",emitType s, map (fn t => (NONE,t)) argTys, ")")
      )

   fun emitPat s (VECpat []) = str "default:"
     | emitPat s (VECpat [""]) = str "default:"
     | emitPat s (VECpat pats) =
      let
         fun gN acc [] = acc
           | gN acc (#"0" :: pat) = gN (map (fn n => 2*n) acc) pat
           | gN acc (#"1" :: pat) = gN (map (fn n => 2*n+1) acc) pat
           | gN acc (_ :: pat) =
               gN (List.concat (map (fn n => [2*n,2*n+1]) acc)) pat
         fun genNums pat = gN [0] (String.explode pat)
         fun genCase num = str ("case " ^ Int.toString num ^ ":")
         fun genPat pat = seq (
               align (map genCase (genNums pat)) ::
               [space, comment ("'" ^ pat ^ "'")]
            )
      in
         align (map genPat pats)
      end
     | emitPat s (CONpat con) = str ("case " ^ getConTag con ^ ":")
     | emitPat s (INTpat i) = str ("case " ^ IntInf.toString i ^ ":")
     | emitPat s (WILDpat) = str "default:"
     
   fun emitBlock s (BASICblock (decls,stmts)) =
      let
         val s = foldl registerSymbol s (map #2 decls)
         fun emitDecl (ty, sym) = seq [emitType s (SOME sym, ty), str ";"]
      in
         indent 2 (align (map emitDecl decls @ map (emitStmt s) stmts))
      end
   
   and emitStmt s (ASSIGNstmt (NONE,exp)) = seq [emitExp s exp, str ";"]
     | emitStmt s (ASSIGNstmt (SOME sym,exp)) =
      if SymbolTable.eq_symid (sym, #ret s) then
         seq [str "return", space, emitExp s exp, str ";"]
      else
         seq [emitSym s sym, space, str "=", space, emitExp s exp, str ";"]
     | emitStmt s (IFstmt (c,t,e)) = align [
         seq [str "if", space, par (emitExp s c), space, str "{"],
         emitBlock s t,
         str "} else {",
         emitBlock s e,
         str "};"
      ]
     | emitStmt s (CASEstmt (e,ps)) = align [
         seq [str "switch (", emitExp s e, str ") of {"],
         indent 2 (align (map (emitCase s) ps)),
         str "};"
      ]

   and emitCase s (p,bb) =
      align [
         seq [emitPat s p, space, str "{"],
         emitBlock s bb,
         str "}; break;"
      ]
   
   and emitExp s (IDexp sym) = emitSym s sym
     | emitExp s (PRIexp (m,f,t,es)) = emitPrim s (f,es)
     | emitExp s (CALLexp (m,sym,es)) = seq (emitSym s sym :: list ("(", emitExp s, es, ")"))
     | emitExp s (INVOKEexp (m,t,e,es)) = seq ([str "((", emitType s (NONE,t), str ") ", emitExp s e, str "->func)("] @
         separate (seq [emitExp s e, str "->args"] :: map (emitExp s) es, ",") @ [str ")"])
     | emitExp s (RECORDexp fs) =
         let
            fun genUpdate ((field,e),res) = align [ 
               seq [str "add_field(", str (getFieldTag field), str ",", emitExp s e, str ","],
               indent 2 (seq [res, str ")"])
            ]
         in
            foldl genUpdate (str "NULL") fs
         end
     | emitExp s (LITexp (t,VEClit pat)) =
      let
         fun genNum (c,acc) = 2*acc+(if c= #"1" then 1 else 0)
         val num = foldl genNum 0 (String.explode pat)
      in
         seq [str (Int.toString num), space, comment ("'" ^ pat ^ "'")]
      end
     | emitExp s (LITexp (t,STRlit string)) = seq [str "\"",str string, str "\""]
     | emitExp s (LITexp (t,INTlit i)) = str (IntInf.toString i)
     | emitExp s (LITexp (t,CONlit c)) = str (getConTag c)
     | emitExp s (BOXexp (t,e)) = 
         seq [str "alloc(sizeof(", emitType s (NONE,t), str "), ", emitExp s e, str ")"]
     | emitExp s (UNBOXexp (t,e)) =
         seq [str "(*((", emitType s (NONE,t), str "*) ", emitExp s e, str "))"]
     | emitExp s (VEC2INTexp (_,PRIexp (_,SLICEprim, _, [vec,ofs,sz]))) =
         seq [str "(", emitExp s vec, str " >> ", emitExp s ofs, str ") & ((1ul<<", emitExp s sz, str ")-1"] 
     | emitExp s (VEC2INTexp (_,UNBOXexp (_,e))) =
         seq [emitExp s e, str "->", str "vec_data"]
     | emitExp s (VEC2INTexp (_,e)) =
         seq [emitExp s e, str ".", str "vec_data"]
     | emitExp s (INT2VECexp (sz,e)) =
         seq [str "(", emitType s (NONE, BITvtype), str "){",
              str (Int.toString sz), str ", ", emitExp s e, str "}"]
     | emitExp s (CLOSUREexp (t,sym,es)) = 
         seq ([str "closure("] @ separate (emitSym s sym :: map (emitExp s) es, ",") @ [str ")"])
     | emitExp s (STATEexp (b,e)) = str ""
     | emitExp s (EXECexp e) = seq [emitExp s e, str "()"]

   and emitPrim s (GETSTATEprim, []) = str "s->state"
     | emitPrim s (SETSTATEprim, [e]) = seq [str "s->state = ", emitExp s e]
     | emitPrim s (IPGETprim, []) = str "(s->ip - s->base)"
     | emitPrim s (CONSUME8prim, []) = str "*((uint8_t*) state->ip)++"
     | emitPrim s (CONSUME16prim, []) = str "*((uint16_t*) state->ip)++"
     | emitPrim s (CONSUME32prim, []) = str "*((uint32_t*) state->ip)++"
     | emitPrim s (UNCONSUME8prim, []) = str "((uint8_t*) state->ip)--"
     | emitPrim s (UNCONSUME16prim, []) = str "((uint16_t*) state->ip)--"
     | emitPrim s (UNCONSUME32prim, []) = str "((uint32_t*) state->ip)--"
     | emitPrim s (PRINTLNprim, [e]) = seq [str "printf(\"%s\",", emitExp s e, str ")"]
     | emitPrim s (RAISEprim, [e]) = align [seq [str "s->err_str = ", emitExp s e, str ";"], str "longjmp(s->err_tgt,0)"]
     | emitPrim s (ANDprim, [e1,e2]) = seq [str "(", emitExp s e1, str "&", emitExp s e2, str ")"]
     | emitPrim s (ORprim, [e1,e2]) = seq [str "(", emitExp s e1, str "&", emitExp s e2, str ")"]
     | emitPrim s (SIGNEDprim, [e]) = seq [str "signed(", emitExp s e, str ")"]
     | emitPrim s (UNSIGNEDprim, [e]) = seq [str "unsigned(", emitExp s e, str ")"]
     | emitPrim s (ADDprim, [e1,e2]) = seq [str "(", emitExp s e1, str "+", emitExp s e2, str ")"]
     | emitPrim s (SUBprim, [e1,e2]) = seq [str "(", emitExp s e1, str "-", emitExp s e2, str ")"]
     | emitPrim s (EQprim, [e1,e2]) = seq [str "(", emitExp s e1, str "=", emitExp s e2, str ")"]
     | emitPrim s (MULprim, [e1,e2]) = seq [emitExp s e1, str "*", emitExp s e2]
     | emitPrim s (LTprim, [e1,e2]) = seq [str "(", emitExp s e1, str "<", emitExp s e2, str ")"]
     | emitPrim s (LEprim, [e1,e2]) = seq [str "(", emitExp s e1, str "<=", emitExp s e2, str ")"]
     | emitPrim s (NOT_VECprim, [e]) = seq [str "vec_not(", emitExp s e, str ")"]
     | emitPrim s (EQ_VECprim, [e1,e2]) = seq [str "vec_eq(", emitExp s e1, str ",", emitExp s e2, str ")"] 
     | emitPrim s (CONCAT_VECprim, [e1,e2]) = seq [str "vec_concat(", emitExp s e1, str ",", emitExp s e2, str ")"] 
     | emitPrim s (INT_TO_STRINGprim, [e]) = seq [str "int_to_string(", emitExp s e, str ")"]
     | emitPrim s (BITVEC_TO_STRINGprim, [e]) = seq [str "vec_to_string(", emitExp s e, str ")"]
     | emitPrim s (CONCAT_STRINGprim, [e1,e2]) = seq [str "string_concat(", emitExp s e1, str ",", emitExp s e2, str ")"]
     | emitPrim s (SLICEprim, [vec,ofs,sz]) = seq [str "(", emitType s (NONE, BITvtype), str "){ ", emitExp s sz, str ", (", emitExp s vec, str " >> ", emitExp s ofs, str ") & ((1ul<<", emitExp s sz, str ")-1 }"] 
     | emitPrim s (GET_CON_IDXprim, [e]) = seq [str "((con_t*) ", emitExp s e , str ")->tag"]
     | emitPrim s (GET_CON_ARGprim, [e]) = seq [str "((con_t*) ", emitExp s e , str ")->payload"]
     | emitPrim s _ = raise CodeGenBug
     
   fun emitDecl s (FUNCdecl {
        funcMonadic = monkind,
        funcClosure = clArgs,
        funcType = ty,
        funcName = name,
        funcArgs = args,
        funcBody = block,
        funcRes = res
      }) =
      let
         val retTy = case ty of FUNvtype (retTy,_,_) => retTy | _ => VOIDvtype
         val s = setRet (res,foldl registerSymbol s (map #2 args))
         fun emitArg (t,sym) = emitType s (SOME sym,t)
      in
         align [
            seq (
               [emitType s (NONE,retTy), space, emitSym s name] @
               list ("(", emitArg, args, ")") @
               [space, str "{"]),
            emitBlock s block,
            str "}"
         ]
      end
     | emitDecl s (SELECTdecl {
         selectName = name,
         selectField = f,
         selectType = _
      }) = str ""
     | emitDecl s (UPDATEdecl {
         updateName = name,
         updateArg = arg,
         updateFields = fs,
         updateType = _
      }) = str ""
     | emitDecl s (CONdecl {
         conName = name,
         conArg = arg,
         conType = _
     }) = str ""
     | emitDecl s (CLOSUREdecl {
        closureName = name,
        closureArgs = clTys,
        closureDelegate = _,
        closureDelArgs = fargs
     }) = str ""

   fun codegen spec =
      let
         val { decls = ds, fdecls = fs } = Spec.get#declarations spec
         
         val s = {
               names = AtomSet.empty,
               symbols = SymMap.empty,
               ret = SymbolTable.unsafeFromInt 0
            } : state

         val s = foldl registerSymbol s (map getDeclName ds)
         val c = map (emitDecl s) ds
         (*val _ =
            C1Templates.expandHeader
               [C1Templates.mkConstrutorsHook (align constructors),
                C1Templates.mkFieldsHook (align fields),
                C1Templates.mkExportsHook (align externPrototypes)]
         val _ =
            C1Templates.expandRuntime
               [C1Templates.mkPrototypesHook (align staticPrototypes),
                C1Templates.mkFunctionsHook (align funs),
                C1Templates.mkTagNamesHook constructorNames,
                C1Templates.mkFieldNamesHook fieldNames]*)
      in
         align c
      end

   fun dumpPre (os, spec) = Pretty.prettyTo (os, Imp.PP.spec spec)
   fun dumpPost (os, c) = Pretty.prettyTo (os, c)

   val pass =
      BasicControl.mkKeepPass
         {passName="c1-codegen",
          registry=CodegenControl.registry,
          pass=codegen,
          preExt="imp",
          preOutput=dumpPre,
          postExt="c",
          postOutput=dumpPost}

   fun run spec = CM.return (pass spec)
end
