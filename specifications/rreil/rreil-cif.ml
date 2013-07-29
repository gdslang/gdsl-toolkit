export = fiep

val fiep cb = do
  x <- return (cb 42);
	print x
end
