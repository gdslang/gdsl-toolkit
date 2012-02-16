signature SYMINFO_CORE = sig
   type info
   val empty : info
end

functor MkSymbolInfo (Core : SYMINFO_CORE) : sig

   type symid
   type table


   val badSymId : symid
   val empty : table

   exception InvalidSymbol of Atom.atom
   val lookup : (table * Atom.atom) -> symid

   val find : (table * Atom.atom) -> symid option

   exception SymbolAlreadyDefined
   val create : (table * Atom.atom * Error.span) -> (table * symid)

   val push : table -> table
   val pop : table -> table
   val getInfo : (table * symid) -> Core.info
   val updateInfo : (table * symid * (Core.info -> Core.info)) -> table
   val setInfo : (table * symid * Core.info) -> table
   val getAtom : (table * symid) -> Atom.atom
   val getSpan : (table * symid) -> Error.span

end = struct

   structure SymbolTable = IntRedBlackMap
   structure Reverse = AtomRedBlackMap

   datatype symid = SymId of int

   exception SymbolAlreadyDefined

   type SymbolInfo = Atom.atom * Error.span * symid * Core.info

   type table = (SymbolInfo SymbolTable.map * symid Reverse.map) list

   val badSymId = SymId (~1)

   fun emptySymInfo (atom,span,id) = (atom, span, id, Core.empty)

   val empty = [(SymbolTable.empty, Reverse.empty)]

   fun find ([], atom) = NONE
     | find ((st,rev)::r, atom) = 
       case Reverse.find (rev, atom) of
           (SOME id) => SOME id
         | NONE => find (r, atom)

   exception InvalidSymbol of Atom.atom
   fun lookup (ts, atom) = case find (ts, atom) of
         (SOME id) => id
       | NONE => raise InvalidSymbol atom

   fun create (ts, atom, span) =
      let val (st,rev)::r = ts in
      case Reverse.find (rev, atom) of
         SOME id => raise SymbolAlreadyDefined
       | NONE =>
         let
            val no = SymbolTable.numItems st+1
            val id = SymId no
            val st = SymbolTable.insert (st, no, emptySymInfo (atom,span,id))
            val rev = Reverse.insert (rev, atom, id)
         in
            ((st,rev)::r, id)
         end
      end
    
   fun push ts = (SymbolTable.empty, Reverse.empty) :: ts
   fun pop ts = let val (_ :: r) = ts in r end 
   
   exception InvalidSymbolId

   fun getSymbolInfo ([], id) = raise InvalidSymbolId
     | getSymbolInfo ((st,rev)::r, id) =
       let val (SymId idx) = id in 
          case SymbolTable.find (st, idx) of
              (SOME c) => c
            | (NONE) => getSymbolInfo (r, id)
       end
   fun getInfo ti = let val (_,_,_,info) = getSymbolInfo ti in info end
   fun updateInfo ([], id, update) = raise InvalidSymbolId
     | updateInfo ((st,rev)::r, id, update) = 
       let val (SymId idx) = id in 
          case SymbolTable.find (st, idx) of
              (SOME (a,s,_,info)) =>
                (SymbolTable.insert (st, idx, (a,s,id,update info)), rev)::r
            | (NONE) => let val ts = updateInfo (r, id, update)
                        in (st,rev)::ts end
       end
   fun setInfo (ts, id, info) = updateInfo (ts, id, fn _ => info)      
   fun getAtom ti = let val (atom,_,_,_) = getSymbolInfo ti in atom end
   fun getSpan ti = let val (_,span,_,_) = getSymbolInfo ti in span end
end