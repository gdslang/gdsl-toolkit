
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
end