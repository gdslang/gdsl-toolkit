(* symbol information for constructors *)
structure ConInfoType : SYMINFO_CORE = struct
  type info = { typeVar : int }
  val empty = { typeVar = 0 }
end

(*  instantiation of the symbol info functor *)
structure ConInfo = MkSymbolInfo (ConInfoType)
