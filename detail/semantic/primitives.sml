structure Primitives = struct
  open Types
  
  (* result type of the decoder function *)
  val r : tVar = freshTVar ()
  
  val s1 : tVar = freshTVar ()
  val s2 : tVar = freshTVar ()
  val s3 : tVar = freshTVar ()
  val s4 : tVar = freshTVar ()
  
  (*create a type from two vectors to one vector, all of size s*)
  fun vvv s = tExpFun (tExpVec (tExpVar s))
              (tExpFun (tExpVec (tExpVar s)) (tExpVec (tExpVar s)))
  
  val primitiveValues = [
    { pName = "continue", pType = tExpMonad (tExpVar r) },
    { pName = "#anon_decode_function", pType = tExpMonad (tExpVar r) },
    { pName = "+", pType = vvv s1 },
    { pName = "*", pType = vvv s2 },
    { pName = "signed", pType = tExpFun (tExpVec (tExpVar s3)) tExpZeno },
    { pName = "unsigned", pType = tExpFun (tExpVec (tExpVar s4)) tExpZeno },
    { pName = "bits8", pType = tExpFun tExpZeno (tExpVec (tExpConst 8)) }
  ]

end