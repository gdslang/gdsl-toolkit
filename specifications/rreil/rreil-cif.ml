export = fiep

val fiep cb = do
  return (invoke_int cb 99)
  #x <- return (cb 42);
	#print x
end
