
(* Types used in the AST variant for parsing *)
structure AbstractTreeTypes : AST_CORE = struct
   (* qualified names *)
   type 'a path = (Atom.atom list * 'a) Error.mark

   type qid = VarInfo.symid path
   type ty_bind = TypeInfo.symid
   type ty_use = TypeInfo.symid
   type syn_bind = TSynInfo.symid
   type syn_use = TSynInfo.symid
   type con_bind = ConInfo.symid
   type con_use = ConInfo.symid
   type var_bind = VarInfo.symid
   type var_use = VarInfo.symid
   type field_bind = FieldInfo.symid
   type field_use = FieldInfo.symid
   type op_id = var_use

   fun bind a = Pretty.token "{-}"

   val ty_bind = bind
   val var_bind = bind
   val syn_bind = bind
   val con_bind = bind
   val field_bind = bind
   val op_id = bind

   fun use a = Pretty.token "{-}"

   val ty_use = use
   val var_use = use
   val syn_use = use
   val con_use = use
   val field_use = use
end

(*  abstract tree representation of decoder specifications. *)
structure SpecAbstractTree = MkAst (AbstractTreeTypes)
