signature SymbolTableSig  = sig

   type symid
   type table

   val compare_symid : symid * symid -> order

   val empty : table

   exception InvalidSymbol of Atom.atom
   val lookup : (table * Atom.atom) -> symid

   val find : (table * Atom.atom) -> symid option

   exception SymbolAlreadyDefined
   val create : (table * Atom.atom * Error.span) -> (table * symid)

   val push : table -> table
   val pop : table -> table

   val getAtom : (table * symid) -> Atom.atom
   val getString : (table * symid) -> string
   val getSpan : (table * symid) -> Error.span
   
   val toString : table -> string
end

structure SymbolTable :> SymbolTableSig = struct

   structure SymbolTable = IntRedBlackMap
   structure Reverse = AtomRedBlackMap

   datatype symid = SymId of int

   fun compare_symid (SymId i1, SymId i2) = Int.compare (i1,i2)
   
   exception SymbolAlreadyDefined

   type SymbolInfo = Atom.atom * Error.span * symid

   type table = (SymbolInfo SymbolTable.map * symid Reverse.map list)

   fun emptySymInfo (atom,span,id) = (atom, span, id)

   val empty = (SymbolTable.empty, [Reverse.empty])

   fun find ((st, []), atom) = NONE
     | find ((st, rev::r), atom) = 
       case Reverse.find (rev, atom) of
           (SOME id) => SOME id
         | NONE => find ((st, r), atom)

   exception InvalidSymbol of Atom.atom
   fun lookup (ts, atom) =
     case find (ts, atom) of
         (SOME id) => id
       | NONE => raise InvalidSymbol atom

   fun create (ts as (st, revs), atom, span) =
      let val (rev::r) = revs in
        case Reverse.find (rev, atom) of
           SOME id => raise SymbolAlreadyDefined
         | NONE =>
           let
              val no = SymbolTable.numItems st+1
              val id = SymId no
              val st = SymbolTable.insert (st, no, emptySymInfo (atom,span,id))
              val rev = Reverse.insert (rev, atom, id)
           in
              ((st,rev::r), id)
           end
      end
    
   fun push (st, r) = (st, Reverse.empty :: r)
   fun pop ts = let val (st, _ :: r) = ts in (st, r) end 
   
   exception InvalidSymbolId

   fun getSymbolInfo ((st, _), SymId idx) =
        case SymbolTable.find (st, idx) of
            (SOME c) => c
          | (NONE) => raise InvalidSymbolId

   fun getAtom ti = let val (atom,_,_) = getSymbolInfo ti in atom end
   fun getString (ti as (_, SymId i)) = Atom.toString (getAtom ti) ^
                                      "<" ^ Int.toString i ^ ">"
   fun getSpan ti = let val (_,span,_) = getSymbolInfo ti in span end
   
   fun toString (st, revs) =
      let val (r :: rev) = revs
          fun fS a i [] = 10000
            | fS a i (r :: rev) =
              (case Reverse.find (r, a) of
                  NONE => 1+fS a i rev
                | SOME (SymId j) => if j<>i then 1+fS a i rev else 0
              )
          and findScope a i = case fS a i revs of
                0 => "" 
              | 1 => " declared 1 scope up"
              | n => if n<10000 then " declared " ^ Int.toString(n) ^ " scopes up"
                     else " out of scope"
      in
        List.foldl (op ^) (Int.toString (List.length revs) ^ " scopes\n") (
          List.map
            (fn (a,_,SymId i) => Int.toString i ^ " -> " ^ Atom.toString a ^
                                 findScope a i ^ "\n")
            (SymbolTable.listItems st)
          )
      end
      
end

structure ord_symid = struct
  type ord_key = SymbolTable.symid
  val compare = SymbolTable.compare_symid
end

structure SymMap = RedBlackMapFn(ord_symid)
