type asm-insn = {length:int, mnemonic:string, annotations:asm-annotation-list, opnds:asm-opnd-list}

type asm-opnd-list =
   ASM_OPNDS_NIL
 | ASM_OPNDS_CONS of {hd:asm-opnd, tl:asm-opnd-list}

type asm-opnd =
   ASM_REGISTER of string
 | ASM_MEMORY of asm-opnd
 | ASM_IMM of asm-immediate
 | ASM_POST_OP of {expr:asm-opnd, opnd:asm-opnd}
 | ASM_PRE_OP of {expr:asm-opnd, opnd:asm-opnd}
 | ASM_REL of asm-opnd
 | ASM_ANNOTATION of {ann:asm-annotation, opnd:asm-opnd}
 | ASM_SUM of {lhs:asm-opnd, rhs:asm-opnd}
 | ASM_SCALE of {factor:int, rhs:asm-opnd}
 | ASM_BOUNDED of {boundary: asm-boundary, opnd:asm-opnd}

type asm-boundary =
   ASM_BOUNDARY_SZ of int
 | ASM_BOUNDARY_SZ_O of {size:int, offset:int}

type asm-annotation-list =
   ASM_ANNS_NIL
 | ASM_ANNS_CONS of {hd:asm-annotation, tl:asm-annotation-list}

type asm-annotation =
   ASM_ANN_STRING of string
 | ASM_ANN_FUNCTION of {name:string, args:asm-opnd-list}
 | ASM_ANN_OPND of {name:string, opnd:asm-opnd}

type asm-immediate =
   ASM_IMMEDIATE of int
 | ASM_UNKNOWN_SIGNEDNESS of {value:int, size:int}

val asm-insn l m o = {length=l, mnemonic=m, annotations=asm-anns-none, opnds=o}
val asm-insn-flags l m a o = {length=l, mnemonic=m, annotations=a, opnds=o}

val asm-opnds-none = ASM_OPNDS_NIL
val asm-opnds-one hd = ASM_OPNDS_CONS {hd=hd, tl=ASM_OPNDS_NIL}
val asm-opnds-more hd tl = ASM_OPNDS_CONS {hd=hd, tl=tl}

val asm-reg r = ASM_REGISTER r
val asm-mem ptr = ASM_MEMORY ptr
val asm-imm simm = ASM_IMM simm
val asm-po expr opnd = ASM_POST_OP {expr=expr, opnd=opnd}
val asm-pr expr opnd = ASM_PRE_OP {expr=expr, opnd=opnd}
val asm-rel o = ASM_REL o
val asm-annotation a opnd = ASM_ANNOTATION {ann=a, opnd=opnd}
val asm-sum l r = ASM_SUM {lhs=l, rhs=r}
val asm-scale f r = ASM_SCALE {factor=f, rhs=r}
val asm-bounded b o = ASM_BOUNDED {boundary=b, opnd=o}

val asm-boundary-sz sz = ASM_BOUNDARY_SZ sz
val asm-boundary-sz-o sz o = ASM_BOUNDARY_SZ_O {size=sz, offset=o}

val asm-anns-none = ASM_ANNS_NIL
val asm-anns-one hd = ASM_ANNS_CONS {hd=hd, tl=ASM_ANNS_NIL}
val asm-anns-more hd tl = ASM_ANNS_CONS {hd=hd, tl=tl}

val asm-ann-string s = ASM_ANN_STRING s
val asm-ann-function name args = ASM_ANN_FUNCTION {name=name, args=args}
val asm-ann-function-unary name arg = ASM_ANN_FUNCTION {name=name, args=asm-opnds-one arg}
val asm-ann-opnd name opnd = ASM_ANN_OPND {name=name, opnd=opnd}

val asm-immediate i = ASM_IMMEDIATE i
val asm-immediate-unk value size = ASM_UNKNOWN_SIGNEDNESS {value=value, size=size}
