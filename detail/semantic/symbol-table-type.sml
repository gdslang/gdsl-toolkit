signature SymbolTableSig  = sig

   type symid
   type table

   val noSpan : Error.span
   val compare_span : Error.span * Error.span -> order
   
   val compare_symid : symid * symid -> order
   val eq_symid : symid * symid -> bool

   val empty : table

   exception InvalidSymbol of Atom.atom
   val lookup : (table * Atom.atom) -> symid

   val find : (table * Atom.atom) -> symid option

   exception SymbolAlreadyDefined
   val create : (table * Atom.atom * Error.span) -> (table * symid)
   val fresh: table * Atom.atom -> table * symid

   val push : table -> table
   val pop : table -> table

   (*allow creating scopes whose definitions can later be reconstructed*)
   type references
   
   val pushWithReferences : table * references -> table
   val popWithReferences : table -> table * references

   val listItems: table -> symid list

   val getAtom : (table * symid) -> Atom.atom
   val getString : (table * symid) -> string
   val getSpan : (table * symid) -> Error.span

   val toString : table -> string
   val toInt: symid -> int
end

structure SymbolTable :> SymbolTableSig = struct

   val concisePrint : bool = false

   structure SymbolTable = IntRedBlackMap
   structure Reverse = AtomRedBlackMap

   datatype symid = SymId of int

   fun toInt (SymId i) = i
   val noSpan = (Position.fromInt ~1, Position.fromInt ~1)

   fun compare_span ((p1s,p1e), (p2s,p2e)) =
      (case Int.compare (Position.toInt p1s,
                         Position.toInt p2s) of
           EQUAL => Int.compare (Position.toInt p1e,
                                 Position.toInt p2e)
         | res => res)

   fun compare_symid (SymId i1, SymId i2) = Int.compare (i1,i2)
   fun eq_symid  (SymId i1, SymId i2) = i1=i2
   
   exception SymbolAlreadyDefined

   type SymbolInfo = Atom.atom * Error.span * symid

   type table = (SymbolInfo SymbolTable.map * symid Reverse.map list)

   fun emptySymInfo (atom,span,id) = (atom, span, id)

   val empty = (SymbolTable.empty, [Reverse.empty])

   fun listItems ((map, _):table) = List.map #3 (SymbolTable.listItems map)

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

   fun fresh ((st, revs), atom) = let
      val no = SymbolTable.numItems st + 1
      val id = SymId no
      val st = SymbolTable.insert (st, no, emptySymInfo (atom, noSpan, id))
   in
      ((st, revs), id)
   end

   exception NoMoreScopes
   
   fun push (st, r) = (st, Reverse.empty :: r)
   fun pop (st, _ :: r) = (st, r)
     | pop _ = raise NoMoreScopes

   type references = symid Reverse.map
   
   fun pushWithReferences ((st, r), refs) = (st, refs :: r)
   fun popWithReferences (st, refs :: r) = ((st, r), refs)
     | popWithReferences _ = raise NoMoreScopes

   exception InvalidSymbolId

   fun getSymbolInfo ((st, _), SymId idx) =
        case SymbolTable.find (st, idx) of
            (SOME c) => c
          | (NONE) => raise InvalidSymbolId

   fun getAtom ti = let val (atom,_,_) = getSymbolInfo ti in atom end
   fun getString (ti as (_, SymId i)) =
      Atom.toString (getAtom ti) ^ 
         (if concisePrint then "" else "#" ^ Int.toString i)
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
structure SymSet = RedBlackSetFn(ord_symid)

structure SpanMap = RedBlackMapFn(struct
   type ord_key = Error.span
   val compare = SymbolTable.compare_span
end)           
