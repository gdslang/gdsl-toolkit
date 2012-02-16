
structure Pretty = struct
   structure L = Layout
   val comma = L.str ","
   val lp = L.str "("
   val rp = L.str ")"
   val lb = L.str "{"
   val rb = L.str "}"
   val int = L.str o IntInf.toString
   fun pretty layout = Layout.print (layout, print)
end