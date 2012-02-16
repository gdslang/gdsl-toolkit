structure Types = struct
  
  datatype bitIdx = BitIdx of int
  
  val badBitIdx = BitIdx (~1)
  
  datatype tVar = TVar of int
  
  val tVarGenerator = ref 0
  
  val freshTVar = let val v = !tVarGenerator in 
                    (tVarGenerator := v+1; TVar v)
                  end

  datatype tExp =
      (* a type synoym with its expanded type *)
      tExpSyn of (TSynInfo.symid * tExp)
      (* an whole number *)
    | tExpZeno
      (* a floating point number *)
    | tExpFloat
      (* a bit vector of a fixed size *)
    | tExpVec of tExp
      (* a Herbrand constant, can only occur as the argument of tExpVec *)
    | tExpConst of int
      (* an algebraic data type with a list of type arguments *)
    | tExpAlg of tVar list
      (* a record *)
    | tExpRec of rField list
      (* a type variable *)
    | tExpVar of tVar
    
  and rField = rField of {
    fieldName : FieldInfo.symid,
    fieldtExp : tExp,
    fieldPresent : bitIdx
  }
  
  val tDummy = tExpVar (TVar ~1)
  
  datatype Subst = Subst of tVar * tExp
  
  datatype Substs = Substs of Subst list
  
end