
(* Types used in the AST variant for parsing *)
structure ParseTreeTypes : AST_CORE = struct

   type 'a path = 'a Error.mark
   type qid = Atom.atom path

   type ty_bind = Atom.atom
   type ty_use = qid
   type syn_bind = Atom.atom
   type syn_use = qid
   type con_bind = Atom.atom
   type con_use = qid
   type var_bind = Atom.atom
   type var_use = qid
   type field_bind = Atom.atom
   type field_use = qid
   type op_id = Atom.atom

   val bind = Layout.str o Atom.toString

   val ty_bind = bind
   val var_bind = bind
   val syn_bind = bind
   val con_bind = bind
   val field_bind = bind
   val op_id = bind

   val use: qid -> Layout.layout = Layout.str o Atom.toString o #tree

   val ty_use = use
   val var_use = use
   val syn_use = use
   val con_use = use
   val field_use = use
end

(* Parse-tree representation of decoder specifications. *)
structure SpecParseTree = MkAst (ParseTreeTypes)
