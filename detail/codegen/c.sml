
structure PrettyC = struct
   open Layout Pretty

   val name = str o Atom.getString
   fun closure {f, env, xs, envsz, body} =
   fun locall x = 

end

structure Mangle = struct
   structure Map = AtomMap
   structure VI = VarInfo

   val variables = !SymbolTables.varTable
   val names = ref Map.empty
   val revnames = ref Map.empty
   val stamp = ref 0

   fun getAtom sym = VI.getAtom (variables, sym)

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
         val s = Atom.getString n
         val s = s ^ next()
      in
         Atom.atom s
      end

   fun mangleName s = s

   fun mangle sym = 
      let
         val atom = getAtom sym
         val mangled = mangleName mangled
      in
         case reverseFind name of
            NONE =>
               (names := insert (sym, mangled)
               ;mangled)
          | SOME _ =>
               (names := insert (sym, resolveCollision mangled)
               ;mangled)
      end

   fun apply sym =
      case Map.find (!names, getAtom sym) of
         SOME csym => csym
       | NONE => mangle sym
end
