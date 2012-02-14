signature SYMINFO_CORE = sig
   type info
   val empty : info
end;

functor MkSymbolInfo (Core : SYMINFO_CORE) : sig

  type SymId
  
  type Table
  
  val badSymId : SymId
  val empty : Table
  val lookup : (Table * Atom.atom) -> SymId option
  val create : (Table * Atom.atom * Error.span) -> (Table * SymId)
  (*val info : Table -> SymId -> Core.info ref
  val atom : Table -> SymId -> Atom.atom*)

end = struct

  datatype SymId = SymId of int

  val badSymId = SymId (0-1)
  
  datatype SymbolInfo =
    SymbolInfo of Atom.atom * Error.span * SymId * Core.info

  fun emptySymInfo (atom,span,id) =
      SymbolInfo (atom, span, id, Core.empty)
  
  structure SymbolTable = IntRedBlackMap
  structure Reverse = AtomRedBlackMap
  
  type Table = SymbolInfo SymbolTable.map * SymId Reverse.map

  val empty = (SymbolTable.empty, Reverse.empty)

  fun lookup ((st,rev), atom) = Reverse.find (rev, atom)

  exception SymbolAlreadyDefined

  fun create ((st,rev), atom, span) =
    case lookup ((st,rev), atom)
      of (SOME id) => raise SymbolAlreadyDefined
      |  (NONE) =>
      let
        val no = SymbolTable.numItems st+1
        val id = SymId no
        val st = SymbolTable.insert (st, no, emptySymInfo (atom,span,id))
        val rev = Reverse.insert (rev, atom, id)
      in ((st,rev), id)
    end

end;