signature SYMINFO_CORE = sig
   type info
   val empty : info
end

functor MkSymbolInfo (Core : SYMINFO_CORE) : sig

   type symid
   type table

   val badSymId : symid
   val empty : table
   val lookup : (table * Atom.atom) -> symid option
   val create : (table * Atom.atom * Error.span) -> (table * symid)
   (*val info : Table -> SymId -> Core.info ref
   val atom : Table -> SymId -> Atom.atom*)

end = struct

   structure SymbolTable = IntRedBlackMap
   structure Reverse = AtomRedBlackMap

   exception SymbolAlreadyDefined

   datatype symid = SymId of int

   datatype SymbolInfo =
      SymbolInfo of Atom.atom * Error.span * symid * Core.info

   type table = SymbolInfo SymbolTable.map * symid Reverse.map

   val badSymId = SymId (0-1)

   fun emptySymInfo (atom,span,id) =
      SymbolInfo (atom, span, id, Core.empty)

   val empty = (SymbolTable.empty, Reverse.empty)

   fun lookup ((st,rev), atom) = Reverse.find (rev, atom)

   fun create ((st,rev), atom, span) =
      case lookup ((st,rev), atom) of
         (SOME id) => raise SymbolAlreadyDefined
       | (NONE) =>
         let
            val no = SymbolTable.numItems st+1
            val id = SymId no
            val st = SymbolTable.insert (st, no, emptySymInfo (atom,span,id))
            val rev = Reverse.insert (rev, atom, id)
         in
            ((st,rev), id)
         end
end