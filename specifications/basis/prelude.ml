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

val divb x y =
  case x of
     8:
       case y of
          1: 8
        | 2: 4
        | 4: 2
        | 8: 1
       end
   | 16:
       case y of
          1: 16
        | 2: 8
        | 4: 4
        | 8: 2
        | 16: 1
       end
	 | 24:
       case y of
          1: 24
        | 2: 12
        | 4: 6
        | 8: 3
       end
   | 32:
       case y of
          1: 32
        | 2: 16
        | 4: 8
        | 8: 4
        | 16: 2
        | 32: 1
       end
   | 64:
       case y of
          1: 64
        | 2: 32
        | 4: 16
        | 8: 8
        | 16: 4
        | 32: 2
        | 64: 1
       end
   | 128:
       case y of
          1: 128
        | 2: 64
        | 4: 32
        | 8: 16
        | 16: 8
        | 32: 4
        | 64: 2
        | 128: 1
       end
   | 256:
       case y of
          1: 256
        | 2: 128
        | 4: 64
        | 8: 32
        | 16: 16
        | 32: 8
        | 64: 4
        | 128: 2
        | 256: 1
       end
    | k:
       case y of
          1: k
#	      | k: 1
       end
  end
;

val divb-up x y =
  case x of
     8:
       case y of
          1: 8
        | 2: 4
        | 3: 3
        | 4: 2
        | 5: 2
        | 6: 2
        | 7: 2
        | 8: 1
       end
   | 16:
       case y of
          1: 16
        | 2: 8
        | 3: 6
        | 4: 4
        | 5: 4
        | 6: 3
        | 7: 3
        | 8: 2
        | 9: 2
        | 10: 2
        | 11: 2
        | 12: 2
        | 13: 2
        | 14: 2
        | 15: 2
        | 16: 1
       end
	 | 22:
       case y of
          1: 22
        | 2: 12
        | 3: 8
        | 4: 6
        | 5: 5
        | 6: 4
        | 7: 4
        | 8: 3
        | 9: 1
       end
	 | 24:
       case y of
          1: 24
        | 2: 12
        | 4: 6
        | 8: 3
       end
  end
;

val logb x =
  case x of
     256: 8
   | 128: 7
   | 64: 6
   | 32: 5
   | 16: 4
   | 8: 3
   | 4: 2
   | 2: 1
   | 1: 0
  end
