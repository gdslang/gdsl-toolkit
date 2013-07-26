export = main

val main =  (
  if '1' then
   let val renamed = test in renamed 8 7 end
   else
   test 7 8
)

val f i =
  if i < 10 then
    f (i + 1)
  else
    return 42

val test a b = 
#  let
#    val f i = do
#      return 43 + i;
#
#      let
#        val g j = do
#          return j + i + 12;
#
#          if (j < i) then
#            g (j + 1)
#          else
#            return void
#        end
#      in
#        g 0
#      end;
#
#      if (i < 63) then
#        f (i + 1)
#      else
#        return void
#    end
#  in
#    f 0
#  end
   (f 0)


