
(* Types used in the AST variant for parsing *)
structure AbstractTreeTypes : AST_CORE = struct
   (* qualified names *)
   type 'a path = (Atom.atom list * 'a) Error.mark

   type qid = VarInfo.symid path
   type ty_bind = VarInfo.symid
   type ty_use = qid
   type con_bind = VarInfo.symid
   type con_use = qid
   type var_bind = VarInfo.symid
   type var_use = qid
   type op_id = VarInfo.symid
end

(*  abstract tree representation of decoder specifications. *)
structure SpecAbstractTree = MkAst (AbstractTreeTypes)
