
structure Pretty = struct
   structure L = Layout
   val comma = L.str ","
   val colon = L.str ":"
   val lp = L.str "("
   val rp = L.str ")"
   val lb = L.str "{"
   val rb = L.str "}"
   val empty = L.str "<.>"
   val space = L.str " "
   val int = L.str o IntInf.toString
   val word = L.str o Word.toString
   val is = L.seq [L.str "=", space]
   fun symmap {key, item} t =
      L.listex "{" "}" ";"
         (List.map
            (fn (k, i) =>
               L.seq [key k, is, item i]) (SymMap.listItemsi t))
   fun symset item t =
      L.listex "{" "}" ";"
         (List.map item (SymSet.listItems t))
   fun pretty layout = Layout.print (layout, print)
   fun prettyTo (os, layout) = Layout.print (layout, fn s => TextIO.output (os, s))
end
