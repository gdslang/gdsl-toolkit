structure Types = struct
  datatype BitIdx = BitIdx of int
  
  val badBitIdx = BitIdx (~1)
  
  datatype TVar = TVar of int
  
  val tVarGenerator = 0 ref
  
  fun freshTVar = (let val v = !tVarGenerator in tVarGenerator := v+1 end;
                   TVar v)
    
  datatype Type =
      (* a type synoym with its expanded type *)
      TypeSyn of (TSynInfo.SymId * Type)
      (* an whole number *)
    | TypeZeno
      (* a bit vector of a fixed size *)
    | TypeVec of Type
      (* a Herbrand constant, can only occur as the argument of TypeVec *)
    | TypeConst of int
      (* an algebraic data type with a list of type arguments *)
    | TypeAlg of TVar list
      (* a record *)
    | TypeRec of Field list
      (* a type variable *)
    | TypeVar of TVar
    
  and Field = Field of {
    fieldName : Atom.atom,
    fieldType : Type,
    fieldPresent : BitIdx
  }
  
end