
structure StringMap = struct
   structure Key = struct
      open String
      type ord_key = string
   end
   structure Map = RedBlackMapFn(Key)
   open Map
end

structure Op = struct
   nonfix div mod
   val times = Atom.atom "*"
   val div = Atom.atom "div"
   val mod = Atom.atom "%"
   val plus = Atom.atom "+"
   val minus = Atom.atom "-"
   val uminus = Atom.atom "~"
   val concat = Atom.atom "^"
   val select = Atom.atom "."
   val andAlso = Atom.atom "and"
   val orElse = Atom.atom "or"
end
