(* symbol information for record fields *)
structure FieldInfoType : SYMINFO_CORE = struct
  type info = { typeVar : int }
  val empty = { typeVar = 0 }
end

(*  instantiation of the symbol info functor *)
structure FieldInfo = MkSymbolInfo (FieldInfoType)
