(* symbol information for type synonyms *)
structure TypeSynInfoType : SYMINFO_CORE = struct
  type info = { tSynEquiv : int }
  val empty = { tSynEquiv = 0 }
end

(*  instantiation of the symbol info functor *)
structure TSynInfo = MkSymbolInfo (TypeSynInfoType)
