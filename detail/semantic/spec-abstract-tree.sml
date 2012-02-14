
(* Types used in the AST variant for parsing *)
structure AbstractTreeTypes : AST_CORE = struct
   (* qualified names *)
   type 'a path = (Atom.atom list * 'a) Error.mark
   
   type qid = VarInfo.SymId path
   type ty_bind = VarInfo.SymId
   type ty_use = qid
   type con_bind = VarInfo.SymId
   type con_use = qid
   type var_bind = VarInfo.SymId
   type var_use = qid
   type op_id = VarInfo.SymId
end

(*  abstract tree representation of decoder specifications. *)
structure SpecAbstractTree = MkAst (AbstractTreeTypes)
