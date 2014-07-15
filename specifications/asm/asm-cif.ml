export asm-convert-insn: (asm_callbacks, asm-insn) -> insn_obj

type asm_opnd_list_callbacks = {
  opnd_list_next: (opnd_obj, opnd_list_obj) -> opnd_list_obj,
  init: (()) -> opnd_list_obj
}
type asm_opnd_callbacks = {
  opnd_register: (string) -> opnd_obj,
  memory: (opnd_obj) -> opnd_obj,
  imm: (int) -> opnd_obj,
  post_op: (opnd_obj, opnd_obj) -> opnd_obj,
  pre_op: (opnd_obj, opnd_obj) -> opnd_obj,
  rel: (opnd_obj) -> opnd_obj,
  annotated: (annotation_obj, opnd_obj) -> opnd_obj,
  sum: (opnd_obj, opnd_obj) -> opnd_obj,
  scale: (int, opnd_obj) -> opnd_obj,
  bounded: (boundary_obj, opnd_obj) -> opnd_obj,
  sign: (signedness_obj, opnd_obj) -> opnd_obj,
  composite: (opnd_list_obj) -> opnd_obj
}
type asm_signedness_callbacks = {
  asm_signed: (()) -> signedness_obj,
  asm_unsigned: (()) -> signedness_obj
}
type asm_boundary_callbacks = {
  sz: (int) -> boundary_obj,
  sz_o: (int, int) -> boundary_obj
}
type asm_annotation_list_callbacks = {
  annotation_list_next: (annotation_obj, annotation_list_obj) -> annotation_list_obj,
  init: (()) -> annotation_list_obj
}
type asm_annotation_callbacks = {
  ann_string: (string) -> annotation_obj,
  function: (string, opnd_list_obj) -> annotation_obj,
  opnd: (string, opnd_obj) -> annotation_obj
}

type asm_callbacks = {
  insn: (int, string, annotation_list_obj, opnd_list_obj) -> insn_obj,
  opnd_list:asm_opnd_list_callbacks,
  opnd:asm_opnd_callbacks,
  signedness:asm_signedness_callbacks,
  boundary:asm_boundary_callbacks,
  annotation_list:asm_annotation_list_callbacks,
  annotation:asm_annotation_callbacks
}

type insn_obj = INSN_OBJ
type opnd_list_obj = OPND_LIST_OBJ
type opnd_obj = OPND_OBJ
type signedness_obj = SIGNEDNESS_OBJ
type boundary_obj = BOUNDARY_OBJ
type annotation_list_obj = ANNOTATION_LIST_OBJ
type annotation_obj = ANNOTATION_OBJ

val asm-convert-insn cbs insn = cbs.insn insn.length insn.mnemonic (asm-convert-annotations cbs insn.annotations) (asm-convert-opnds cbs insn.opnds)

val asm-convert-opnds cbs opnds = let
  val convert-inner list opnds = case opnds of
     ASM_OPNDS_NIL: list
   | ASM_OPNDS_CONS next: convert-inner (cbs.opnd_list.opnd_list_next (asm-convert-opnd cbs next.hd) list) next.tl
  end
in
  convert-inner (cbs.opnd_list.init void) opnds
end

val asm-convert-opnd cbs opnd = case opnd of
   ASM_REGISTER r: cbs.opnd.opnd_register r
 | ASM_MEMORY m: cbs.opnd.memory (asm-convert-opnd cbs m)
 | ASM_IMM i: cbs.opnd.imm i
 | ASM_POST_OP po: cbs.opnd.post_op (asm-convert-opnd cbs po.expr) (asm-convert-opnd cbs po.opnd)
 | ASM_PRE_OP pr: cbs.opnd.pre_op (asm-convert-opnd cbs pr.expr) (asm-convert-opnd cbs pr.opnd)
 | ASM_REL r: cbs.opnd.rel (asm-convert-opnd cbs r)
 | ASM_ANNOTATED a: cbs.opnd.annotated (asm-convert-annotation cbs a.ann) (asm-convert-opnd cbs a.opnd)
 | ASM_SUM s: cbs.opnd.sum (asm-convert-opnd cbs s.lhs) (asm-convert-opnd cbs s.rhs)
 | ASM_SCALE s: cbs.opnd.scale s.factor (asm-convert-opnd cbs s.rhs)
 | ASM_BOUNDED b: cbs.opnd.bounded (asm-convert-boundary cbs b.boundary) (asm-convert-opnd cbs b.opnd)
 | ASM_SIGN s: cbs.opnd.sign (asm-convert-signedness cbs s.signedness) (asm-convert-opnd cbs s.opnd)
 | ASM_COMPOSITE c: cbs.opnd.composite (asm-convert-opnds cbs c)
end

val asm-convert-signedness cbs signedness = case signedness of
   ASM_SIGNED: cbs.signedness.asm_signed void
 | ASM_UNSIGNED: cbs.signedness.asm_unsigned void
end

val asm-convert-boundary cbs b = case b of
   ASM_BOUNDARY_SZ sz: cbs.boundary.sz sz
 | ASM_BOUNDARY_SZ_O szo: cbs.boundary.sz_o szo.size szo.offset
end

val asm-convert-annotations cbs anns = let
  val convert-inner list anns = case anns of
     ASM_ANNS_NIL: list
   | ASM_ANNS_CONS next: convert-inner (cbs.annotation_list.annotation_list_next (asm-convert-annotation cbs next.hd) list) next.tl
  end
in
  convert-inner (cbs.annotation_list.init void) anns
end

val asm-convert-annotation cbs ann = case ann of
   ASM_ANN_STRING s: cbs.annotation.ann_string s
 | ASM_ANN_FUNCTION f: cbs.annotation.function f.name (asm-convert-opnds cbs f.args)
 | ASM_ANN_OPND o: cbs.annotation.opnd o.name (asm-convert-opnd cbs o.opnd)
end
