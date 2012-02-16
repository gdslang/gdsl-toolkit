(* symbol information for variables *)
structure VarInfoType : SYMINFO_CORE = struct
  type info = { letBound : bool, typeVar : int }
  val empty = { letBound = false, typeVar = 0 }
end

(*  instantiation of the symbol info functor *)
structure VarInfo = MkSymbolInfo (VarInfoType)

structure VarInfoUtil = struct

   type setLetBound = bool -> VarInfoType.info -> VarInfoType.info
   fun setLetBound v { letBound = _, typeVar = tVar}
         = { letBound = v, typeVar = tVar }

end

