# test if fields flow properly in monadic results

val act = do
  y <- return {num=7};
  z <- return {add=8};
  return (@{ add = $add z} y)
end

val res = do
  r <- act;
  return ($num r + $add r)
end