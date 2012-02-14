(* symbol information for variables *)
structure VarInfoType : SYMINFO_CORE = struct
  type info = { typeVar : int }
  val empty = { typeVar = 0 }
end

(*  instantiation of the symbol info functor *)
structure VarInfo = MkSymbolInfo (VarInfoType)
