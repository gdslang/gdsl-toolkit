structure Primitives = struct
  open Types
  
  (* result type of the decoder function *)
  val r : tvar = freshTVar ()
  
  val s1 : tvar = freshTVar ()
  val s2 : tvar = freshTVar ()
  val s3 : tvar = freshTVar ()
  val s4 : tvar = freshTVar ()
  
  (*create a type from two vectors to one vector, all of size s*)
  fun vvv s = FUN (VEC (VAR s),
                       FUN (VEC (VAR s), VEC (VAR s)))
  
  val primitiveValues = [
    { pName = "continue", pType = MONAD (VAR r) },
    { pName = "#anon_decode_function", pType = MONAD (VAR r) },
    { pName = "+", pType = vvv s1 },
    { pName = "*", pType = vvv s2 },
    { pName = "signed", pType = FUN (VEC (VAR s3), ZENO) },
    { pName = "unsigned", pType = FUN (VEC (VAR s4), ZENO) },
    { pName = "bits8", pType = FUN (ZENO, VEC (CONST 8)) }
  ]

end                                                       