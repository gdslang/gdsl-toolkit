structure C1Templates = struct
   val header = ExpandFile.mkTemplateFromFile "detail/codegen/c1/runtime.h"
   val runtime = ExpandFile.mkTemplateFromFile "detail/codegen/c1/runtime.c"

   fun stdHooks basename =
      let
         fun conv c = case c of
            #"-" => #"_"
          | c => Char.toUpper c
         val BASENAME = String.implode (map conv (String.explode basename))
      in
         [
         ("I-am-a-template-so-edit-me", fn os => TextIO.output (os,
            "/* Auto-generated file. DO NOT EDIT. */\n")),
         ("if-guard-prefix", fn os => TextIO.output (os,
            "#ifndef __" ^ BASENAME ^ "_H\n#define __" ^ BASENAME ^ "_H\n")),
         ("end-guard-prefix", fn os => TextIO.output (os,
            "#endif /* __" ^ BASENAME ^ "_H */\n")),
         ("include-prefix", fn os => TextIO.output (os,
            "#include \"" ^ basename  ^ ".h\"\n"))
         ]
      end

   fun expandHeader basename hooks =
      ExpandFile.expandTemplate
         {src=header,
          dst=basename ^ ".h",
          hooks=stdHooks basename @ hooks}

   fun expandRuntime basename hooks =
      ExpandFile.expandTemplate
         {src=runtime,
          dst=basename ^ ".c",
          hooks=stdHooks basename @ hooks}

   fun mkPrint f os = Pretty.prettyTo(os, f())
   fun mkHook (name,d) = (name, mkPrint (fn () => d))
end

structure C1 = struct
   structure CM = CompilationMonad
   structure CI = ConInfo
   structure FI = FieldInfo

   open Imp
   open Layout Pretty

   exception CodeGenBug
   
   type state = { prefix : string,
                  names : AtomSet.set,
                  symbols : Atom.atom SymMap.map,
                  fieldTypes : vtype SymMap.map,
                  ret : SymbolTable.symid,
                  onlyDecls : bool,
                  exports : SymSet.set,
                  constrs : String.string SymMap.map,
                  closureToFun : SymbolTable.symid SymMap.map,
                  recordMapping : Atom.atom AtomMap.map,
                  allocFuncs : int AtomMap.map ref,
                  preDeclEmit : Layout.t list ref }

   fun isVOIDvtype VOIDvtype = true
     | isVOIDvtype _ = false

   (* define a list of identifiers that we cannot emit as C identifiers *)
   val reservedNames = AtomSet.fromList (map Atom.atom [
      "auto",
      "break",
      "case",
      "char",
      "const",
      "continue",
      "default",
      "do",
      "double",
      "else",
      "enum",
      "extern",
      "float",
      "for",
      "goto",
      "if",
      "int",
      "long",
      "register",
      "return",
      "short",
      "signed",
      "sizeof",
      "static",
      "struct",
      "switch",
      "typedef",
      "union",
      "unsigned",
      "void",
      "volatile",
      "while",
      "asm",
      "typeof",
      "inline",
      "restrict",
      "main",
      "alloc_heap",
      "gdsl_reset_heap",
      "alloc",
      "alloc_int",
      "alloc_string",
      "alloc_vec",
      "alloc_con_obj",
      "alloc_con_int",
      "alloc_con_vec",
      "alloc_con_string",
      "add_field_obj",
      "add_field_int",
      "add_field_vec",
      "add_field_string",
      "del_fields",
      "eos",
      "consume8",
      "consume16",
      "consume32",
      "vec_to_signed",
      "vec_to_unsigned",
      "vec_not",
      "vec_eq",
      "vec_concat",
      "int_to_string",
      "vec_to_string",
      "string_concat",
      "gdsl_init",
      "gdsl_set_code",
      "gdsl_destroy",
      "mktemp",
      "logb",
      "div",
      "memcpy"
      ])

   fun mangleName s =
      let
         fun tf c =
            case c of
               #"%" => ""
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

   fun mangleString s =
      let
         fun tf c =
            case c of
               #"\n" => "\\n"
             | #"\t" => "\\t"
             | #"\\" => "\\"
             | _ => String.str c
      in
         String.translate tf s
      end
               
   fun regSym (sym, table, s : state) =
      let
         val prefix = if SymSet.member(#exports s, sym) then #prefix s else ""
         val atom = SymbolTable.getAtom (table, sym)
         val atom = Atom.atom (prefix ^ mangleName (Atom.toString atom))
         fun addEntry (atom,names,symbols) = 
            if AtomSet.member(names,atom) then
               addEntry (Atom.atom (Atom.toString atom ^ "_"), names, symbols)
            else
               (AtomSet.add (names,atom), SymMap.insert (symbols,sym,atom))
         val (names,symbols) = addEntry (atom,#names s,#symbols s)
      in
         { names = names,
           prefix = #prefix s,
           symbols = symbols,
           fieldTypes = #fieldTypes s,
           ret = #ret s,
           onlyDecls = #onlyDecls s,
           exports = #exports s,
           constrs = #constrs s,
           closureToFun = #closureToFun s,
           allocFuncs = #allocFuncs s,
           recordMapping = #recordMapping s,
           preDeclEmit = #preDeclEmit s } : state
      end
   fun registerSymbol (sym,s : state) = regSym (sym, !SymbolTables.varTable, s)
   fun registerFSymbol (sym,s : state) = regSym (sym, !SymbolTables.fieldTable, s)

   fun setRet (sym,s : state) =
      { names = #names s,
        prefix = #prefix s,
        symbols = #symbols s,
        fieldTypes = #fieldTypes s,
        ret = sym,
        onlyDecls = #onlyDecls s,
        exports = #exports s,
        constrs = #constrs s,
        closureToFun = #closureToFun s,
        allocFuncs = #allocFuncs s,
        recordMapping = #recordMapping s,
        preDeclEmit = #preDeclEmit s } : state

   fun par arg = seq [str "(", arg, str ")"]
   fun list (lp,arg,xs,rp) = [str lp, seq (separate (map arg xs, ",")), str rp]
   fun fArgs args = par (seq (separate (str "s" :: args, ",")))
   fun fTArgs args = par (seq (separate (str "state_t s" :: args, ",")))
   fun comment cmt = seq [str "/* ", str cmt, str " */"]

   fun emitNum num = case Int.maxInt of
         SOME m => if IntInf.fromInt m<num then
            str ("0x" ^ IntInf.fmt StringCvt.HEX num)
         else
            str (IntInf.toString num)
       | NONE => str (IntInf.toString num)

   fun emitSym s sym = case SymMap.find (#symbols (s : state), sym) of
      SOME atom => str (Atom.toString atom)
    | NONE => (TextIO.print ("emitSym: no symbol name registered for " ^ SymbolTable.getString (!SymbolTables.varTable, sym) ^ "\n"); raise CodeGenBug)

   fun getConTag (s : state) con = case SymMap.find (#constrs s, con) of
         SOME str => str
       | NONE => 
      Int.toString (SymbolTable.toInt con) ^
      "/* " ^ Atom.toString (SymbolTable.getAtom (!SymbolTables.conTable, con)) ^ " */"

   fun getFieldTag f = 
      Int.toString (SymbolTable.toInt f) ^
      "/* " ^ Atom.toString (SymbolTable.getAtom (!SymbolTables.fieldTable, f)) ^ " */"

   fun emitFieldSym s sym =
      let
         val field = SymbolTable.getString (!SymbolTables.fieldTable, sym)
         val field = if AtomSet.member (reservedNames,Atom.atom field)
                   then field ^ "_" else field
      in
         str (mangleName field)
      end
   
   fun removeArgs (FUNvtype (retTy, isCl, args)) =
         FUNvtype (removeArgs retTy, isCl, [VOIDvtype])
     | removeArgs ty = ty

   type recordInfo = {
      riExport : bool,
      riTypeName : string,
      riFieldDecls : Layout.t list,
      riSequenceNo : int,
      riBoxed : bool
   }

   val recordTypeMap = ref (AtomMap.empty : recordInfo AtomMap.map)

   fun genRecSignature fs =
      let
         val str = foldl (fn ((f,t),str) =>
            Atom.toString (SymbolTable.getAtom (!SymbolTables.fieldTable, f)) ^ str) "" fs
      in
         Atom.atom str
      end

   fun genRecordDecl s onlyPublic =
      let
         fun showDecl (riInfo as { riBoxed = false, ... } : recordInfo) =
            align [
               str "typedef struct {",
               indent 2 (align (#riFieldDecls riInfo)),
               seq [str "}", space, str (#riTypeName riInfo), str "_t;"]]
           | showDecl (riInfo as { riBoxed = true, ... }: recordInfo) =
            align [
               str "typedef struct {",
               indent 2 (align (#riFieldDecls riInfo)),
               seq [str "}", space, str ("unboxed_" ^ #riTypeName riInfo), str "_t;"],
               seq [str "typedef ", str ("unboxed_" ^ #riTypeName riInfo), str "_t* ", str (#riTypeName riInfo), str "_t;"]]
      in
         map showDecl
            (List.filter (fn r => (#riExport r)=onlyPublic)
               (ListMergeSort.sort (fn (r1,r2) => (#riSequenceNo r1)>(#riSequenceNo r2))
                  (AtomMap.listItems (!recordTypeMap))))
      end

   fun getRecordTag (s : state) (boxed, fs) =
      let
         val rSig = genRecSignature fs
      in
         case AtomMap.find (!recordTypeMap, rSig) of
            SOME riInfo => #riTypeName riInfo
          | NONE =>
            let
               fun showField (f,t) = seq [emitTypeDecl s ([emitFieldSym s f], t), str ";"]
               val emittedFields = map showField fs
               val idx = AtomMap.numItems (!recordTypeMap)+1
               val tyName = case AtomMap.find (#recordMapping s,rSig) of
                     SOME name => Atom.toString name
                   | NONE => "struct" ^ Int.toString idx
               val riInfo = {
                  riExport = false,
                  riTypeName = tyName,
                  riFieldDecls = emittedFields,
                  riSequenceNo = idx,
                  riBoxed = boxed
               }
               val _ = recordTypeMap := AtomMap.insert (!recordTypeMap,rSig,riInfo)
            in
               tyName
            end
      end

   and emitTypeDecl s (decl, t) =
      let
         fun addSpace [] = []
           | addSpace xs = space :: xs
         fun eT (decl, VOIDvtype) = seq (str "void" :: addSpace decl)
           | eT (decl, VECvtype) = seq (str "vec_t" :: addSpace decl)
           | eT (decl, INTvtype) = seq (str "int_t" :: addSpace decl)
           | eT (decl, STRINGvtype) = seq (str "string_t" :: addSpace decl)
           | eT (decl, OBJvtype) = seq (str "obj_t" :: addSpace decl)
           | eT (decl, MONADvtype retTy) = eT (str "(*" :: decl @ [str ")()"], retTy)
           | eT (decl, RECORDvtype bfs) = seq (str (getRecordTag s bfs ^ "_t") :: addSpace decl)
           | eT (decl, FUNvtype (retTy,_,[VOIDvtype])) = (* do not emit arguments *)
               eT (str "(*" :: decl @ [str ")()"], retTy)
           | eT (decl, FUNvtype (retTy,isCl,argTys)) = 
               eT (str "(*" ::
                  decl @ [
                     str ")",
                     par (seq (separate (str "state_t" ::
                               (fn args => if isCl then str "obj_t" :: args else args)
                               (map (fn t => eT ([],t)) argTys), ",")))],
                  retTy)
      in
         eT (decl,t)
      end

   fun markTypeAsExport (s : state) ty =
      let
         fun markRecAsExport (boxed,fs) =
            let
               val _ = getRecordTag s (boxed,fs)
               val rSig = genRecSignature fs
               val { riExport = _,
                     riTypeName = tyName,
                     riFieldDecls = def,
                     riSequenceNo = idx,
                     riBoxed = isBoxed
                   } = AtomMap.lookup (!recordTypeMap, rSig)
               val riInfo = {
                  riExport = true,
                  riTypeName = tyName,
                  riFieldDecls = def,
                  riSequenceNo = idx,
                  riBoxed = isBoxed
               }
            in
               recordTypeMap := AtomMap.insert (!recordTypeMap, rSig, riInfo)
            end
         fun markTy (RECORDvtype (boxed,fs)) = (markRecAsExport (boxed,fs); app (markTy o #2) fs)
           | markTy (FUNvtype (rTy,_,aTys)) = (markTy rTy; app markTy aTys)
           | markTy (MONADvtype rTy) = markTy rTy
           | markTy _ = ()
      in
         markTy ty
      end

   fun emitSymType s (sym, t) = emitTypeDecl s ([emitSym s sym], t)

   fun emitType s (SOME symName, t) = emitTypeDecl s ([str symName], t)
     | emitType s (NONE, t) = emitTypeDecl s ([], t)

   fun emitFunType s (sym,args, FUNvtype (retTy,_,_)) =
      emitTypeDecl s ([emitSym s sym,
         par (seq (separate (
            str "state_t s" ::
            map (fn (t,sym) => emitTypeDecl s ([emitSym s sym],t)) args, ",")))],
         retTy)
     | emitFunType s (sym, args, MONADvtype retTy) =
      emitFunType s (sym, args, FUNvtype (retTy,false,[]))
     | emitFunType s (sym, args, t) =
      emitTypeDecl s ([emitSym s sym], FUNvtype (VOIDvtype,false,[]))

   fun emitStringFunType s (retTy,name,args) =
      emitTypeDecl s ([str name,
         par (seq (separate (
            str "state_t s" ::
            map (fn (t,arg) => emitTypeDecl s ([str arg],t)) args, ",")))],
         retTy)

   fun getTypeSuffix s (VOIDvtype) = "void"
     | getTypeSuffix s (VECvtype) = "vec"
     | getTypeSuffix s (INTvtype) = "int"
     | getTypeSuffix s (STRINGvtype) = "string"
     | getTypeSuffix s (OBJvtype) = "obj"
     | getTypeSuffix s (MONADvtype retTy) = getTypeSuffix s retTy ^ "_mon"
     | getTypeSuffix s (FUNvtype (retTy,_,args)) = 
      foldl (fn (ty,str) => str ^ "_" ^ getTypeSuffix s ty) "" (retTy::args) ^ "_fun"
     | getTypeSuffix s (RECORDvtype bfs) = getRecordTag s bfs

   val macrosDefinedInRuntime = AtomSet.fromList
      [Atom.atom "GEN_ALLOC(string);", (* pre-defined as no-op *)
       Atom.atom "GEN_REC_STRUCT(obj);" (* pre-defined since its used in del_fields *)
      ]

   fun emitMacro (s : state, ty, funBase, macroBase) =
      let
         fun registerMacro macro =
            if AtomMap.inDomain (!(#allocFuncs s), macro) orelse
                 AtomSet.member (macrosDefinedInRuntime, macro) then () else 
               (#allocFuncs s) := AtomMap.insert (!(#allocFuncs s), macro,
                                    AtomMap.numItems (!(#allocFuncs s))+1)
         val tyTag = getTypeSuffix s ty
         fun genTypedef ty =
            registerMacro (Atom.atom (Layout.tostring (
               seq [str "typedef ", emitTypeDecl s ([str (tyTag ^ "_t")], ty), str ";"])))
         val _ = case ty of
               FUNvtype _ => genTypedef ty
             | MONADvtype _ => genTypedef ty
             | ty => ()
         val funName = funBase ^ tyTag
         val macro = Atom.atom (macroBase ^ tyTag ^ ");")
         val _ = registerMacro macro
      in
         str funName
      end

   fun emitAlloc (s : state) ty = emitMacro (s,ty,"alloc_","GEN_ALLOC(")
   fun emitUnboxedAlloc (s : state) ty = emitMacro (s,ty,"alloc_unboxed_","GEN_ALLOC(unboxed_")
   fun emitAllocCon (s : state) ty = 
      (emitMacro (s,ty,"con_","GEN_CON_STRUCT("); emitMacro (s,ty,"alloc_con_","GEN_ALLOC(con_"))
   fun emitConType (s : state) ty = seq [emitMacro (s,ty,"con_","GEN_CON_STRUCT("),str "_t"]
   fun emitAddField (s : state) f =
      (emitMacro (s,SymMap.lookup (#fieldTypes s,f),"","GEN_REC_STRUCT(")
      ;emitMacro (s,SymMap.lookup (#fieldTypes s,f),"add_field_","GEN_ADD_FIELD("))
   fun emitSelect (s : state) f =
      (emitMacro (s,SymMap.lookup (#fieldTypes s,f),"","GEN_REC_STRUCT(")
      ;emitMacro (s,SymMap.lookup (#fieldTypes s,f),"select_","GEN_SELECT_FIELD("))


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
     | emitPat s (CONpat con) = str ("case " ^ getConTag s con ^ ":")
     | emitPat s (INTpat i) = str ("case " ^ IntInf.toString i ^ ":")
     | emitPat s (WILDpat) = str "default:"
     
   val anonActMap = ref (AtomMap.empty : int AtomMap.map)
   val closureStructs = ref AtomSet.empty
   val genClosureSet = ref AtomSet.empty
   val invokeClosureSet = ref AtomSet.empty
   
   fun emitClosureStruct (s : state) (retTy,argTys) =
      let
         val structName = "closure" ^
                           foldl (fn (t,str) => str ^ getTypeSuffix s t) "" (retTy::argTys) ^
                          "_t"
         val structNameAtom = Atom.atom structName
         fun genArgs ([],idx) = []
           | genArgs (ty::tys,idx) =
               (ty, "arg" ^ Int.toString idx) :: genArgs (tys,idx+1)
         val args = genArgs (argTys,1)
      in
        if AtomSet.member(!closureStructs, structNameAtom) then (structName, args) else
            let
               val _ = closureStructs := AtomSet.add(!closureStructs, structNameAtom)
               val st = [
                  seq [str "typedef struct {"],
                  indent 2 (align (
                     seq [emitStringFunType s (retTy,"(*func)",(OBJvtype, "closure")::args), str ";"] ::
                     map (fn (ty,name) => seq [emitType s (SOME name, ty), str ";"]) args
                     )
                  ),
                  seq [str "}", space, str structName, str ";"]
               ]
               val _ = (#preDeclEmit s) := !(#preDeclEmit s) @ st
            in
               (structName, args)
            end
      end

   fun emitGenClosure (s : state) funTy =
      let
         val (ty,argTys) = case funTy of
               (FUNvtype (ty,_,argTys)) => (ty,argTys)
             | (MONADvtype ty) => (ty,[])
             | _ => raise CodeGenBug
         val ty = removeArgs ty
         val retTy = case ty of
               FUNvtype (retTy,_,_) => retTy
             | (MONADvtype retTy) => retTy
             | _ => OBJvtype
         val closureName = "gen" ^
                           foldl (fn (t,str) => str ^ getTypeSuffix s t) "" (retTy::argTys) ^
                           "_closure"
         val closureNameAtom = Atom.atom closureName
      in
        if AtomSet.member(!genClosureSet, closureNameAtom) then str closureName else
            let
               val _ = genClosureSet := AtomSet.add(!genClosureSet, closureNameAtom)
               val (structName, args) = emitClosureStruct s (retTy,argTys)
               val clArgs = (ty,"closure_fun")::args
               val gen = [
                  seq [str "static inline ", emitStringFunType s (OBJvtype,closureName,clArgs), str " {"],
                  indent 2 (align [
                     seq [str structName, str "* closure = alloc(s, sizeof(", str structName, str "));"],
                     seq [str "*closure = (", str structName, str "){", seq (separate (map (str o #2) clArgs, ", ")), str "};"],
                     str "return (obj_t) closure;"
                  ]),
                  str "}"
               ]
               val _ = (#preDeclEmit s) := !(#preDeclEmit s) @ gen
            in
               str closureName
            end
      end

   fun emitInvokeClosure (s : state) ty =
      let
         val (retTy,argTys) = case ty of
               (FUNvtype (retTy,_,argTys)) => (retTy,argTys)
             | (MONADvtype retTy) => (retTy,[])
             | _ =>  raise CodeGenBug
         (*val retTy = removeArgs retTy*)
         val funName = "invoke" ^
                        foldl (fn (t,str) => str ^ getTypeSuffix s t) "_closure" (retTy::argTys)
         val funNameAtom = Atom.atom funName
      in
        if AtomSet.member(!invokeClosureSet, funNameAtom) then str funName else
            let
               val (structName, args) = emitClosureStruct s (retTy,argTys)
               val _ = invokeClosureSet := AtomSet.add(!invokeClosureSet, funNameAtom)
               fun genArgs ([],idx) = []
                 | genArgs (ty::tys,idx) =
                     (ty, "arg" ^ Int.toString idx) :: genArgs (tys,idx+1)
               val args = genArgs (argTys,1)
               val f = [
                  seq [str "static inline ", emitStringFunType s (retTy,funName,(OBJvtype,"closure") :: args), str " {"],
                  indent 2 (seq [
                     if isVOIDvtype retTy then seq [] else str "return ",
                     str "((", str structName, str "*) closure)->func",
                     fArgs (str "closure" :: map (str o #2) args), str ";"
                  ]),
                  str "}"
               ]
               val _ = (#preDeclEmit s) := !(#preDeclEmit s) @ f
            in
               str funName
            end
      end

   fun emitAnonymousAction s (b,t,e) =
      let
         val body = Atom.atom (Layout.tostring (align [
               emitBlock s b,
               case t of
                  VOIDvtype => (case e of
                     PRIexp (VOIDprim,_,_) => seq []
                   | e => indent 2 (seq [emitExp s e, str ";"])
                  )
                | _ =>
                  indent 2 (seq [str "return ", emitExp s e, str ";"])
            ]))
         val fName = case AtomMap.find (!anonActMap, body) of
               SOME idx => "anonymousAction" ^ Int.toString idx
             | NONE =>
               let
                  val idx = AtomMap.numItems (!anonActMap)+1
                  val _ = anonActMap := AtomMap.insert (!anonActMap,body,idx)
                  val fName = "anonymousAction" ^ Int.toString idx
                  val f = [
                        seq [str "static ", emitType s (NONE,t), space, str fName, str "(state_t s) {"],
                        str (Atom.toString body),
                        str "}"
                     ]
                  val _ = (#preDeclEmit s) := !(#preDeclEmit s) @ f
               in
                  fName
               end
      in
         seq [str fName]
      end
      
   and emitBlock s (BASICblock (decls,stmts)) =
      let
         val s = foldl registerSymbol s (map #2 decls)
         fun emitDecl (ty, sym) = seq [emitSymType s (sym, ty), str ";"]
      in
         indent 2 (align (map emitDecl decls @ map (emitStmt s) stmts))
      end
   
   and emitStmt s (ASSIGNstmt (NONE,exp)) = seq [emitExp s exp, str ";"]
     | emitStmt s (ASSIGNstmt (SOME sym,exp)) =
      if SymbolTable.eq_symid (sym, #ret s) then
         seq [str "return", space, emitExp s exp, str ";"]
      else
         seq [emitSym s sym, space, str "=", space, emitExp s exp, str ";"]
     | emitStmt s (IFstmt (c,t,BASICblock ([],[]))) = align [
         seq [str "if", space, par (emitExp s c), space, str "{"],
         emitBlock s t,
         str "};"
      ]
     | emitStmt s (IFstmt (c,BASICblock ([],[]),e)) = align [
         seq [str "if", space, par (seq [str "!", emitExp s c]), space, str "{"],
         emitBlock s e,
         str "};"
      ]
     | emitStmt s (IFstmt (c,t,e)) = align [
         seq [str "if", space, par (emitExp s c), space, str "{"],
         emitBlock s t,
         str "} else {",
         emitBlock s e,
         str "};"
      ]
     | emitStmt s (CASEstmt (e,ps)) = align [
         seq [str "switch (", emitExp s e, str ") {"],
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
     | emitExp s (PRIexp (f,t,es)) = (case t of
         FUNvtype (_,_,args) => emitPrim s (f,es,args)
       | _ => emitPrim s (f,es,[])
      )
     | emitExp s (CALLexp (e,es)) = seq [emitExp s e, fArgs (map (emitExp s) es)]
     | emitExp s (INVOKEexp (FUNvtype (_,false,_),e,es)) =
         seq [emitExp s e, fArgs (map (emitExp s) es)]
     | emitExp s (INVOKEexp (t,e,es)) =
         seq [emitInvokeClosure s t, fArgs (emitExp s e :: map (emitExp s) es)]
     | emitExp s (RECORDexp (rs,t as RECORDvtype (boxed,fsTys),fs)) =
      if boxed then
         seq [emitUnboxedAlloc s t,
            fArgs [seq (
              par (str ("unboxed_" ^ getRecordTag s (boxed,fsTys) ^ "_t")) ::  
              list ("{",emitInitializer s, fs, "}")
            )
         ]]
      else
         seq (
            par (str (getRecordTag s (boxed,fsTys) ^ "_t")) ::  
            list ("{",emitInitializer s, fs, "}")
         )
     | emitExp s (RECORDexp (rs,t,fs)) =
         let
            fun genUpdate ((f,e),res) = seq [
               emitAddField s f,
               fArgs [str (getFieldTag f), emitExp s e, res]
            ]
         in
            foldl genUpdate (str "NULL") fs
         end
     | emitExp s (SELECTexp (rs,RECORDvtype (boxed,fsTys),f,e)) =
      if boxed then
         seq [emitExp s e, str "->", emitFieldSym s f]
      else
         seq [emitExp s e, str ".", emitFieldSym s f]
     | emitExp s (SELECTexp (rs,t,f,e)) = seq [emitSelect s f, fArgs [str (getFieldTag f), emitExp s e]]
     | emitExp s (LITexp (t,VEClit pat)) =
      let
         fun genNum (c,acc) = IntInf.fromInt 2*acc+(if c= #"1" then 1 else 0)
         val num = foldl genNum 0 (String.explode pat)
      in
         seq [emitNum num, space, comment ("'" ^ pat ^ "'")]
      end
     | emitExp s (LITexp (t,STRlit string)) = seq [str "\"",str (mangleString string), str "\""]
     | emitExp s (LITexp (t,INTlit i)) = emitNum i
     | emitExp s (LITexp (t,CONlit c)) = str (getConTag s c)
     | emitExp s (BOXexp (t,e)) = seq [emitAlloc s t, fArgs [emitExp s e]]
     | emitExp s (UNBOXexp (t,e)) =
         seq [str "*((", emitType s (NONE,t), str "*) ", emitExp s e, str ")"]
     | emitExp s (VEC2INTexp (_,PRIexp (SLICEprim, _, [vec,ofs,sz]))) =
         seq [str "slice(", emitExp s vec, str ", ", emitExp s ofs, str ", ", emitExp s sz, str ")"]
     | emitExp s (VEC2INTexp (_,UNBOXexp (t,e))) =
         seq [str "((", emitType s (NONE,t), str "*) ", emitExp s e, str ")", str "->", str "data"]
     | emitExp s (VEC2INTexp (_,e)) =
         seq [emitExp s e, str ".", str "data"]
     | emitExp s (INT2VECexp (sz,e)) =
         seq [str "gen_vec(",str (Int.toString sz), str ", ", emitExp s e, str ")"]
     | emitExp s (CLOSUREexp (FUNvtype (_,false,_),sym,es)) =
         seq [str "&", emitSym s (SymMap.lookup (#closureToFun s, sym))]
     | emitExp s (CLOSUREexp (t,sym,es)) =
         seq [emitGenClosure s t, fArgs (seq [str "&", emitSym s sym] :: map (emitExp s) es)]
     | emitExp s (STATEexp (BASICblock ([],[]), _, CALLexp (e,[]))) = seq [str "&", emitExp s e]
     | emitExp s (STATEexp (b,t,e)) = emitAnonymousAction s (b,t,e)

     | emitExp s (EXECexp (FUNvtype (_,false,_),e)) = seq [emitExp s e, fArgs []]
     | emitExp s (EXECexp (MONADvtype _,e)) = seq [emitExp s e, fArgs []]
     | emitExp s (EXECexp (t,e)) = seq [emitInvokeClosure s t, fArgs [emitExp s e]]

   and emitInitializer s (sym,e) = seq [str ".", emitFieldSym s sym, str "=", emitExp s e]
     
   and emitPrim s (GETSTATEprim, [],_) = str "s->state"
     | emitPrim s (SETSTATEprim, [e],_) = seq [str "s->state = ", emitExp s e]
     | emitPrim s (SEEKprim, [e],_) = seq [str "gdsl_seek(s, ", emitExp s e, str ")"]
     | emitPrim s (RSEEKprim, [e],_) = seq [str "gdsl_rseek(s, ", emitExp s e, str ")"]
     | emitPrim s (DIVprim, [e1, e2],_) = seq [str "(", emitExp s e1, str ")/(", emitExp s e2, str ")"]
     | emitPrim s (IPGETprim, [],_) = str "gdsl_get_ip_offset(s)"
     | emitPrim s (CONSUME8prim, [],_) = str "consume8(s)"
     | emitPrim s (CONSUME16prim, [],_) = str "consume16(s)"
     | emitPrim s (CONSUME32prim, [],_) = str "consume32(s)"
     | emitPrim s (UNCONSUME8prim, [],_) = str "s->ip-=1"
     | emitPrim s (UNCONSUME16prim, [],_) = str "s->ip-=2"
     | emitPrim s (UNCONSUME32prim, [],_) = str "s->ip-=4"
     | emitPrim s (PRINTLNprim, [e],_) = seq [str "fputs(", emitExp s e, str ", s->handle)"]
     | emitPrim s (RAISEprim, [e],_) = align [seq [str "s->err_str = ", emitExp s e, str ";"], str "longjmp(s->err_tgt,0)"]
     | emitPrim s (ANDprim, [e1,e2],_) = seq [str "(", emitExp s e1, str ") & (", emitExp s e2, str ")"]
     | emitPrim s (ORprim, [e1,e2],_) = seq [str "(", emitExp s e1, str ") | (", emitExp s e2, str ")"]
     | emitPrim s (SIGNEDprim, [e],_) = seq [str "vec_to_signed", fArgs [emitExp s e]]
     | emitPrim s (UNSIGNEDprim, [e],_) = seq [str "vec_to_unsigned", fArgs [emitExp s e]]
     | emitPrim s (ADDprim, [e1,e2],_) = seq [str "(", emitExp s e1, str "+", emitExp s e2, str ")"]
     | emitPrim s (SUBprim, [e1,e2],_) = seq [str "(", emitExp s e1, str "-", emitExp s e2, str ")"]
     | emitPrim s (EQprim, [e1,e2],_) = seq [str "", emitExp s e1, str "==", emitExp s e2, str ""]
     | emitPrim s (MULprim, [e1,e2],_) = seq [emitExp s e1, str "*", emitExp s e2]
     | emitPrim s (LTprim, [e1,e2],_) = seq [str "", emitExp s e1, str "<", emitExp s e2, str ""]
     | emitPrim s (LEprim, [e1,e2],_) = seq [str "", emitExp s e1, str "<=", emitExp s e2, str ""]
     | emitPrim s (NOT_VECprim, [e],_) = seq [str "vec_not", fArgs [emitExp s e]]
     | emitPrim s (EQ_VECprim, [e1,e2],_) = seq [str "vec_eq", fArgs [emitExp s e1, emitExp s e2]] 
     | emitPrim s (CONCAT_VECprim, [e1,e2],_) = seq [str "vec_concat", fArgs [emitExp s e1, emitExp s e2]] 
     | emitPrim s (INT_TO_STRINGprim, [e],_) = seq [str "int_to_string", fArgs [emitExp s e]]
     | emitPrim s (STRLENprim, [e],_) = seq [str "strlen(", emitExp s e, str ")"]
     | emitPrim s (CONCAT_STRINGprim, [e1,e2,sz],_) = seq [str "(string_t) memcpy(", emitExp s e1, str ",", emitExp s e2, str ",", emitExp s sz, str ")+", emitExp s sz]
     | emitPrim s (SLICEprim, [vec,ofs,sz],_) = seq (str "gen_vec(" :: emitExp s sz :: str ", slice" :: list ("(", emitExp s, [vec,ofs,sz], "))"))
     | emitPrim s (GET_CON_IDXprim, [e],[t]) = seq [str "((", emitConType s t, str "*) ", emitExp s e , str ")->tag"]
     | emitPrim s (GET_CON_ARGprim, [_,e],[FUNvtype (_,_,[t]),_]) = seq [str "((", emitConType s t, str "*) ", emitExp s e , str ")->payload"]
     | emitPrim s (VOIDprim, [],_) = str "0 /* void value */"
     | emitPrim s _ = raise CodeGenBug
     
   fun emitDecl s (FUNCdecl {
        funcClosure = clArgs,
        funcType = ty,
        funcName = name,
        funcArgs = args,
        funcBody = block,
        funcRes = res
      }) =
      let
         val s = setRet (res,foldl registerSymbol s (map #2 (clArgs @ args)))
         val static = if SymSet.member(#exports s, name) then seq [] else str "static "
         val _ = if SymSet.member(#exports s, name) then markTypeAsExport s ty else ()
      in
         if #onlyDecls s then
         let
            val fTy = emitFunType s (name, (clArgs @ args), ty)
            val preDecl = !(#preDeclEmit s)
            val _ = (#preDeclEmit s) := []
         in
            align (
               preDecl @ [
               seq [static, fTy, str ";"]
            ])
         end
         else
         let
            val block = emitBlock s block
            val preDecl = !(#preDeclEmit s)
            val _ = (#preDeclEmit s) := []
         in
            align (seq [str "/* ", str (SymbolTable.getString (!SymbolTables.varTable, name)), str " */"] ::
               preDecl @ [
               seq [static, emitFunType s (name, (clArgs @ args), ty), space, str "{"],
               block,
               str "}"
            ])
         end
      end
     | emitDecl s (UPDATEdecl {
         updateName = name,
         updateArg = arg,
         updateFields = fs,
         updateType = ty
      }) =
      let
         val recVar = #ret (s : state)
         val s = registerSymbol (recVar,s)
         val s = foldl registerFSymbol s fs
         fun fieldName f = Atom.toString (SymbolTable.getAtom (!SymbolTables.fieldTable,f))
         val args = map (fn f => (SymMap.lookup (#fieldTypes s,f), f)) fs @ [(OBJvtype, recVar)]
      in
         if #onlyDecls s then
         let
            val fTy = emitFunType s (name, args, ty)
            val preDecl = !(#preDeclEmit s)
            val _ = (#preDeclEmit s) := []
         in
            align (
               preDecl @ [
               seq [str "static", space, fTy, str ";"]
            ])
         end
         else
         align [
            seq [str "static", space, emitFunType s (name, args, ty), space, str "{"],
            indent 2 (align ([
               seq (str "field_tag_t tags[] = " :: list ("{",str o getFieldTag, fs, "};")),
               seq [emitSym s recVar, str " = del_fields(s,tags,sizeof(tags)/sizeof(tags[0]),", emitSym s recVar, str ");"]
            ] @ map (fn f =>
               seq [emitSym s recVar, str " = ",
                    emitAddField s f, str "(s,", str (getFieldTag f), str ", ",
                    emitSym s f, str ", ", emitSym s recVar, str ");"]) fs
            @ [
               seq [str "return ", emitSym s recVar, str ";"]
            ])),
            str "}"
         ]
      end
     | emitDecl s (CONdecl {
         conName = name,
         conTag = tag,
         conArg = arg as (argTy, argName),
         conType = ty
     }) =
      let
         val s = registerSymbol (argName,s)
      in
         if #onlyDecls s then
         let
            val fTy = emitFunType s (name, [arg], ty)
            val preDecl = !(#preDeclEmit s)
            val _ = (#preDeclEmit s) := []
         in
            align (
               preDecl @ [
               seq [str "static inline", space, fTy, space, str "{"],
               seq [str "  return ", emitAllocCon s argTy,
                    fArgs [seq [str "(", emitConType s argTy, str "){",
                                str (getConTag s tag), str ", ", emitSym s argName, str "}"]], str ";"],
               str "}"
         ])
         end
         else seq []
      end
     | emitDecl s (CLOSUREdecl {
        closureName = name,
        closureArgs = clTys,
        closureDelegate = del,
        closureDelArgs = delArgs,
        closureRetTy = retTy
     }) =
      let
         val closureVar = #ret (s : state)
         val s = registerSymbol (closureVar,s)
         val s = foldl registerSymbol s (map #2 delArgs)
         val funArgs = (OBJvtype, closureVar) :: delArgs
      in
         if #onlyDecls s then
         let
            val fTy = emitFunType s (name, funArgs, FUNvtype (retTy, false, map #1 funArgs))
            val preDecl = !(#preDeclEmit s)
            val _ = (#preDeclEmit s) := []
         in
            align (
               preDecl @ [
               seq [str "static ", fTy, str ";"]
            ])
         end
         else
         let
            val (structName, closureArgs) = emitClosureStruct s (retTy, clTys)
            fun prependC arg = "c->" ^ arg
            fun emitC rem = if null closureArgs then rem else 
                  seq [str structName, str "* c = (", str structName, str "*)", space,
                       emitSym s closureVar, str ";"] :: rem
            val preDecl = !(#preDeclEmit s)
            val _ = (#preDeclEmit s) := []
         in
            align (preDecl @ [
               seq [str "static ", emitFunType s (name, funArgs, FUNvtype (retTy, false, map #1 funArgs)), space, str "{"],
               indent 2 (align (emitC [
                  seq [if isVOIDvtype retTy then str "" else str "return ",
                       emitSym s del, fArgs (map (str o prependC o #2) closureArgs @
                                             map (emitSym s o #2) delArgs), str ";"]
               ])),
               str "}"
            ])
         end
      end

   fun emitConDefine (con, conStr) = align [
         seq [str "#ifdef ", str conStr],
         indent 2 (align [
            seq [str "#if (", str conStr, str "!=", str (Int.toString (SymbolTable.toInt con)), str ")"],
            indent 2 (
               seq [str "#error \"merging GDSL libraries with incompatible definition for ", str conStr, str ".\""]
            ),
            str "#endif"]),
         seq [str "#else"],
         indent 2 (
            seq [str "#define ", str conStr, space, str (Int.toString (SymbolTable.toInt con))]
         ),
         seq [str "#endif"]
      ]

   fun genRecordMapping ((tySym, ty), m) =
      let
         fun fieldCmp ((f1,_),(f2,_)) = SymbolTable.compare_symid (f1,f2)
         fun addRec (SpecAbstractTree.MARKty t) = addRec (#tree t)
           | addRec (SpecAbstractTree.RECORDty fs) =
               AtomMap.insert (m, genRecSignature (ListMergeSort.uniqueSort fieldCmp fs),
                  SymbolTable.getAtom (!SymbolTables.typeTable,tySym))
           | addRec _ = m
      in
         addRec ty
      end

   fun codegen spec =
      let
         val _ = anonActMap := AtomMap.empty
         val _ = closureStructs := AtomSet.empty
         val _ = genClosureSet := AtomSet.empty
         val _ = invokeClosureSet := AtomSet.empty

         val { decls = ds, fdecls = fs, exports } = Spec.get #declarations spec

         val recordMapping = foldl genRecordMapping AtomMap.empty (Spec.get #typealias spec)
         
         val closureToFunMap = foldl (fn (d,m) => case d of
                  CLOSUREdecl {
                    closureName = clName,
                    closureDelegate = delName,
                    ...
                  } => SymMap.insert (m,clName,delName)
                | _ => m
              ) SymMap.empty ds
         (* compute a list of constructors that are to be public; since
            we currently have no data types in the export list, we just
            make any constructor without argument public *)
         fun mkConName con = "CON_" ^ mangleName (Atom.toString
            (SymbolTable.getAtom (!SymbolTables.conTable, con)))
         val conMap = SymMap.mapPartiali (fn (con,(_,argOpt)) => case argOpt of
               SOME arg => NONE
             | NONE => SOME (mkConName con)) (Spec.get #constructors spec)

         val prefix = Controls.get BasicControl.exportPrefix
         val outputName = case Controls.get BasicControl.outputName of
            NONE => prefix
          | SOME p => p
         val prefix = if String.size prefix=0 then prefix else prefix ^ "_"

         val st = !SymbolTables.varTable
         val (st, genericSym) = SymbolTable.fresh (st,Atom.atom "v")
         val (st, stateSym) = SymbolTable.fresh (st,Atom.atom "s")
         val _ = SymbolTables.varTable := st
         val exports = SymSet.fromList (Spec.get #exports spec)
         val s = {
               names = reservedNames,
               prefix = prefix,
               symbols = SymMap.empty,
               fieldTypes = fs,
               ret = genericSym,
               onlyDecls = false,
               exports = exports,
               constrs = conMap,
               closureToFun = closureToFunMap,
               allocFuncs = ref AtomMap.empty,
               recordMapping = recordMapping,
               preDeclEmit = ref []
            } : state
         val s = registerSymbol (stateSym, s)
         val s = foldl registerSymbol s (map getDeclName ds)
         val funs = map (emitDecl s) ds
         val s = {
               names = #names s,
               prefix = #prefix s,
               symbols = #symbols s,
               fieldTypes = #fieldTypes s,
               ret = #ret s,
               onlyDecls = true,
               exports = #exports s,
               constrs = #constrs s,
               closureToFun = #closureToFun s,
               allocFuncs = #allocFuncs s,
               recordMapping = #recordMapping s,
               preDeclEmit = #preDeclEmit s
            } : state
         val funDeclsPublic = map (emitDecl s) 
            (List.filter (fn d => SymSet.member(exports, getDeclName d)) ds)
         (* Generate the macros that rename functions from prefix_foo to gdsl_foo. *)
         fun genRenamingMacro d =
            let
               val prefLen = String.size prefix
               val prefSym = Layout.tostring (emitSym s (getDeclName d))
               val gdslSym = String.extract (prefSym, prefLen, NONE)
            in   
               str ("#define gdsl_" ^ gdslSym ^ " " ^ prefSym)
            end
         val renamings = map genRenamingMacro
            (List.filter (fn d => SymSet.member(exports, getDeclName d)) ds)

         val funDeclsPrivate = map (emitDecl s)
            (List.filter (fn d => not (SymSet.member(exports, getDeclName d))) ds)
         val constructors = map emitConDefine (SymMap.listItemsi conMap)
         (* generate a list of macros in the order in which they were added *)
         val recAllocFuncs =
            map (str o Atom.toString o #1) 
               (ListMergeSort.sort (fn ((_,i1),(_,i2)) => i1>i2)
                  (AtomMap.listItemsi (!(#allocFuncs s))))
         val fields = []
         val constructorNames = str ""
         val fieldNames = str ""

         val _ =
            C1Templates.expandHeader outputName [
               C1Templates.mkHook ("init", str (prefix ^ "init")),
               C1Templates.mkHook ("set_code", str (prefix ^ "set_code")),
               C1Templates.mkHook ("get_ip_offset", str (prefix ^ "get_ip_offset")),
               C1Templates.mkHook ("seek", str (prefix ^ "seek")),
               C1Templates.mkHook ("rseek", str (prefix ^ "rseek")),
               C1Templates.mkHook ("err_tgt", str (prefix ^ "err_tgt")),
               C1Templates.mkHook ("get_error_message", str (prefix ^ "get_error_message")),
               C1Templates.mkHook ("reset_heap", str (prefix ^ "reset_heap")),
               C1Templates.mkHook ("heap_residency", str (prefix ^ "heap_residency")),
               C1Templates.mkHook ("merge_rope", str (prefix ^ "merge_rope")),
               C1Templates.mkHook ("destroy", str (prefix ^ "destroy")),
               C1Templates.mkHook ("renamings", align renamings),
               C1Templates.mkHook ("records", align (genRecordDecl s true)),
               C1Templates.mkHook ("exports", align funDeclsPublic),
               C1Templates.mkHook ("tagnames", align constructors),
               C1Templates.mkHook ("fields", align fields)
            ]
         val _ =
            C1Templates.expandRuntime outputName [
               C1Templates.mkHook ("init", str (prefix ^ "init")),
               C1Templates.mkHook ("set_code", str (prefix ^ "set_code")),
               C1Templates.mkHook ("get_ip_offset", str (prefix ^ "get_ip_offset")),
               C1Templates.mkHook ("seek", str (prefix ^ "seek")),
               C1Templates.mkHook ("rseek", str (prefix ^ "rseek")),
               C1Templates.mkHook ("err_tgt", str (prefix ^ "err_tgt")),
               C1Templates.mkHook ("get_error_message", str (prefix ^ "get_error_message")),
               C1Templates.mkHook ("reset_heap", str (prefix ^ "reset_heap")),
               C1Templates.mkHook ("heap_residency", str (prefix ^ "heap_residency")),
               C1Templates.mkHook ("merge_rope", str (prefix ^ "merge_rope")),
               C1Templates.mkHook ("rope_to_string", str (prefix ^ "rope_to_string")),
               C1Templates.mkHook ("rope_length", str (prefix ^ "rope_length")),
               C1Templates.mkHook ("destroy", str (prefix ^ "destroy")),
               C1Templates.mkHook ("alloc_funcs", align recAllocFuncs),
               C1Templates.mkHook ("records", align (genRecordDecl s false)),
               C1Templates.mkHook ("fieldnames", fieldNames),
               C1Templates.mkHook ("prototypes", align funDeclsPrivate),
               C1Templates.mkHook ("functions", align funs)
            ]
      in
         align funs
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
