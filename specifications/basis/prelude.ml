# Standard definitions.

export = rope-length rope-print rope-to-string

type rope = RopeLeaf of { rope-size : int, rope-string: string }
          | RopeInner of { rope-size : int, rope-left : rope, rope-right : rope }

val rope-length r =
   case r of
      RopeLeaf n : n.rope-size
    | RopeInner n : n.rope-size
   end

val rope-print r = do
   case r of
      RopeLeaf n : puts n.rope-string
    | RopeInner n : do
         rope-print n.rope-left;
         rope-print n.rope-right
      end
   end
end

val rope-to-string r buf = do
   let
      val add-to-string r ptr =
         case r of
            RopeLeaf n : return (strcat ptr n.rope-string n.rope-size)
          | RopeInner n : do
               ptr <- add-to-string n.rope-left ptr;
               add-to-string n.rope-right ptr
            end
         end
   in
      add-to-string r buf
   end
end

# this function is applied to each string literal during parsing
val from-string-lit s = RopeLeaf { rope-size = strlen s, rope-string = s }

val show-int s = from-string-lit (showint s)

val +++ r1 r2 =
   RopeInner {
      rope-size = rope-length r1 + rope-length r2,
      rope-left = r1,
      rope-right = r2
   }

val println r = rope-print (r +++ "\n")