(* symbol information for types *)
structure TypeInfoType : SYMINFO_CORE = struct
  type info = { typeVar : int }
  val empty = { typeVar = 0 }
end

(*  instantiation of the symbol info functor *)
structure TypeInfo = MkSymbolInfo (TypeInfoType)
