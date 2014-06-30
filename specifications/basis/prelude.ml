# Standard definitions.

export = rope-length rope-print rope-to-string int-max

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

val string-from-rope-lit r = case r of
   RopeLeaf l: l.rope-string
end

val show-int s = from-string-lit (showint s)

val +++ r1 r2 =
   RopeInner {
      rope-size = rope-length r1 + rope-length r2,
      rope-left = r1,
      rope-right = r2
   }

val println r = rope-print (r +++ "\n")

# division with rounding towards minus infinity
val /m a b =
   if b<0 then ~ (/p a (~ b)) else
   if a>=0 then /z a b else /z (a - b + 1) b

# division with rounding towards plus infinity
val /p a b =
   if b<0 then ~ (/m a (~ b)) else
   if a<=0 then /z a b else /z (a + b - 1) b

val logb x = if x<=1 then 0 else 1+(logb (/m x 2))

val power a b = case b of
   0: 1
 | 1: a
 | _: let
     val half-exp = /m b 2
   in
     (power a half-exp)*(power a (b - half-exp))
   end
end

val addi a b = a + b
val subi a b = a - b
val muli a b = a * b

type int_option =
   IO_SOME of int
 | IO_NONE

val io-binop binop a b =
  case a of
     IO_SOME i: case b of
        IO_SOME j: IO_SOME (binop i j)
      | IO_NONE: IO_NONE
     end
   | IO_NONE: IO_NONE
  end

val int-max = 0x7fffffffffffffff

# logical and for guards: since a guard is a function that is applied to the
# internal state, stating that two guards must hold requires special functions
# that apply each of the guard to the internal state and that returns the
# logical and of the result; this is implemented using the infix function &&

val && fA fB =
   let
     val res s = fA s and fB s
   in
     res
   end

# as above for logical or
val || fA fB =
  let
    val res s = fA s or fB s
  in
    res
  end

# as above for not, note that we use // since it is a normal function name in GDSL
val // fA =
  let
    val res s = not (fA s)
  in
    res
  end

# this is a guard that is always true; it is useful to implement the catch-all case
val otherwise s = '1'

