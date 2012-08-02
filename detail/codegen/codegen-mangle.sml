
structure Mangle = struct
   structure Map = StringMap
   structure VI = VarInfo
   structure FI = FieldInfo
   structure CI = ConInfo

   val variables = SymbolTables.varTable
   val fields = SymbolTables.fieldTable
   val constructors = SymbolTables.conTable

   val names = ref Map.empty : string Map.map ref
   val revnames = ref Map.empty : string Map.map ref
   val stamp = ref 0
   fun reset () =
      (names := Map.empty
      ;revnames := Map.empty
      ;stamp := 0)

   fun getStringOfPrim sym = Atom.toString (VI.getAtom(!variables, sym))

   fun getString sym =
      let
         val s = VI.getString (!variables, sym)
      in
         if String.isPrefix "%" s then getStringOfPrim sym
         else s
      end

   fun getStringOfField sym = Atom.toString(FI.getAtom(!fields, sym))
   fun getStringOfTag sym = Atom.toString(CI.getAtom(!constructors, sym))

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
             | #"-" => "_"
             | #"+" => "_plus_"
             | #"^" => "_hat_"
             | #"/" => "_slash_"
             | #"?" => "_q_"
             | _ => String.str c
      in
         String.translate tf s
      end

   fun mangle f sym = 
      let
         val mangled = f sym
      in
         case reverseFind mangled of
            NONE =>
               (insert (sym, mangled)
               ;mangled)
          | SOME _ =>
               (insert (sym, resolveCollision mangled)
               ;mangled)
      end

   fun mangleExport sym =
      let
         val mangled = "__" ^ mangleName sym ^ "__"
      in
         mangled
      end

   fun mangleField sym =
      let
         val mangled = "___" ^ mangleName sym 
      in
         mangled
      end

   fun mangleTag sym =
      let
         val mangled = "__" ^ mangleName sym
      in
         mangled
      end

   fun applyField sym =
      let
         val sym = getStringOfField sym
      in
         case Map.find (!names, sym) of
            SOME csym => csym
          | NONE => mangle mangleField sym
      end

   fun applyTag sym =
      let
         val sym = getStringOfTag sym
      in
         case Map.find (!names, sym) of
            SOME csym => csym
          | NONE => mangle mangleTag sym
      end

   fun apply sym =
      let
         val sym = getString sym
      in
         case Map.find (!names, sym) of
            SOME csym => csym
          | NONE => mangle mangleName sym
      end

   fun applyExport sym =
      let
         val sym' = getString sym
         val mangled = mangleExport (getStringOfPrim sym)
      in
         case Map.find (!names, sym') of
            SOME csym => csym
          | NONE =>
               (case reverseFind mangled of
                  NONE =>
                     (insert (sym', mangled)
                     ;mangled)
                | SOME _ =>
                     (insert (sym', resolveCollision mangled)
                     ;mangled))
      end

   (*
   val apply = fn sym =>
      (Pretty.prettyTo (TextIO.stdOut, CPS.PP.var sym);print"\n";apply sym)
   *)
end
