structure Primitives = struct
  open Types
  
  (* result type of the decoder function *)
  val r : tVar = freshTVar ()
  
  val s1 : tVar = freshTVar ()
  val s2 : tVar = freshTVar ()
  val s3 : tVar = freshTVar ()
  val s4 : tVar = freshTVar ()
  
  (*create a type from two vectors to one vector, all of size s*)
  fun vvv s = TExpFun (TExpVec (TExpVar s),
                       TExpFun (TExpVec (TExpVar s), TExpVec (TExpVar s)))
  
  val primitiveValues = [
    { pName = "continue", pType = TExpMonad (TExpVar r) },
    { pName = "#anon_decode_function", pType = TExpMonad (TExpVar r) },
    { pName = "+", pType = vvv s1 },
    { pName = "*", pType = vvv s2 },
    { pName = "signed", pType = TExpFun (TExpVec (TExpVar s3), TExpZeno) },
    { pName = "unsigned", pType = TExpFun (TExpVec (TExpVar s4), TExpZeno) },
    { pName = "bits8", pType = TExpFun (TExpZeno, TExpVec (TExpConst 8)) }
  ]

end                                                       