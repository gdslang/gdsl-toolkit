
(* symbol information for variables *)
structure VarInfo (*:> SymbolTableSig *)= SymbolTable

(* symbol information for constructors *)
structure ConInfo (*:> SymbolTableSig *)= SymbolTable

(* symbol information for types *)
structure TypeInfo (*:> SymbolTableSig *)= SymbolTable

(* symbol information for record fields *)
structure FieldInfo (*:> SymbolTableSig *)= SymbolTable

structure SymbolTables : sig

    val varTable : VarInfo.table ref
    val conTable : ConInfo.table ref
    val typeTable : TypeInfo.table ref
    val fieldTable : FieldInfo.table ref
    
end = struct

  val varTable = ref VarInfo.empty
  val conTable = ref ConInfo.empty
  val typeTable = ref TypeInfo.empty
  val fieldTable = ref FieldInfo.empty

end

(* Types used in the AST variant for parsing *)
structure AbstractTreeTypes : AST_CORE = struct
   (* qualified names *)
   type 'a path = (Atom.atom list * 'a) Error.mark

   type qid = VarInfo.symid path
   type ty_bind = TypeInfo.symid
   type ty_use = TypeInfo.symid
   type syn_bind = TypeInfo.symid
   type syn_use = TypeInfo.symid
   type con_bind = ConInfo.symid
   type con_use = ConInfo.symid
   type var_bind = VarInfo.symid
   type var_use = VarInfo.symid
   type field_bind = FieldInfo.symid
   type field_use = FieldInfo.symid
   type op_id = var_use

   fun tyP id = Layout.str (TypeInfo.getString(!SymbolTables.typeTable, id))
   fun synP id = Layout.str (TypeInfo.getString(!SymbolTables.typeTable, id))
   fun conP id = Layout.str (ConInfo.getString(!SymbolTables.conTable, id))
   fun varP id = Layout.str (VarInfo.getString(!SymbolTables.varTable, id))
   fun fieldP id = Layout.str (FieldInfo.getString(!SymbolTables.fieldTable, id))

   val ty_bind = tyP
   val ty_use = tyP
   val var_bind = varP
   val var_use = varP
   val syn_bind = synP
   val syn_use = synP
   val con_bind = conP
   val con_use = conP
   val field_bind = fieldP
   val field_use = fieldP
   val op_id = varP

end

(*  abstract tree representation of decoder specifications. *)
structure SpecAbstractTree = MkAst (AbstractTreeTypes)
