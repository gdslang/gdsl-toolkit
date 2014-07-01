type asm-insn = {length:int, mnemonic:string, flags:asm-annotation-list, opnds:asm-opnd-list}

type asm-opnd-list =
   ASM_OPNDS_NIL
 | ASM_OPNDS_CONS of {hd:asm-opnd, tl:asm-opnd-list}

type asm-opnd =
   ASM_REGISTER of asm-register
 | ASM_MEMORY of asm-memory
 | ASM_IMM of asm-immediate
 | ASM_POST_OP of {expr:asm-opnd, opnd:asm-opnd}
 | ASM_PRE_OP of {expr:asm-opnd, opnd:asm-opnd}
 | ASM_REL of asm-opnd
 | ASM_ANNOTATION of asm-annotation
 | ASM_SUM of {lhs:asm-opnd, rhs:asm-opnd}
 | ASM_SCALE of {factor:int, rhs:asm-opnd}

type asm-register =
   ASM_REGISTER_NAME of string
 | ASM_REGISTER_SO of {mnemonic:string, size:int, offset:int}

type asm-annotation-list =
   ASM_ANNOTATIONS_NIL
 | ASM_ANNOTATIONS_CONS of {hd:asm-annotation, tl:asm-annotation-list}

type asm-annotation =
   ASM_ANN_STRING of string
 | ASM_ANN_FUNCTION of {name:string, args:asm-opnd-list}
 | ASM_ANN_OPND of {name:string, opnd:asm-opnd}

type asm-memory = {deref-size:int, pointer:asm-opnd}

type asm-immediate =
   ASM_IMMEDIATE of int
 | ASM_UNKNOWN_SIGNEDNESS of {value:int, size:int}

val asm-insn l m o = {length=l, mnemonic=m, flags=ASM_ANNOTATIONS_NIL, opnds=o}
val asm-insn-flags l m f o = {length=l, mnemonic=m, flags=f, opnds=o}

val asm-opnds-none = ASM_OPNDS_NIL
val asm-opnds-one hd = ASM_OPNDS_CONS {hd=hd, tl=ASM_OPNDS_NIL}
val asm-opnds-more hd tl = ASM_OPNDS_CONS {hd=hd, tl=tl}

val asm-reg r = ASM_REGISTER r
val asm-mem dsize ptr = ASM_MEMORY {deref-size=dsize, pointer=ptr}
val asm-imm simm = ASM_IMM simm
val asm-po expr opnd = ASM_POST_OP {expr=expr, opnd=opnd}
val asm-pr expr opnd = ASM_PRE_OP {expr=expr, opnd=opnd}
val asm-rel o = ASM_REL o
val asm-annotation a = ASM_ANNOTATION a
val asm-sum l r = ASM_SUM {lhs=l, rhs=r}
val asm-scale f r = ASM_SCALE {factor=f, rhs=r}

val asm-register mnemonic = ASM_REGISTER_NAME mnemonic
val asm-register-so mnemonic size offset = ASM_REGISTER_SO {mnemonic=mnemonic, size=size, offset=offset}

val asm-annotations-none = ASM_ANNOTATIONS_NIL
val asm-annotations-one hd = ASM_ANNOTATIONS_CONS {hd=hd, tl=ASM_ANNOTATIONS_NIL}
val asm-annotations-more hd tl = ASM_ANNOTATIONS_CONS {hd=hd, tl=tl}

val asm-ann-string s = ASM_ANN_STRING s
val asm-ann-function name args = ASM_ANN_FUNCTION {name=name, args=args}
val asm-ann-function-unary name arg = ASM_ANN_FUNCTION {name=name, args=asm-opnds-one arg}
val asm-ann-opnd name opnd = ASM_ANN_OPND {name=name, opnd=opnd}

val asm-immediate i = ASM_IMMEDIATE i
val asm-immediate-unk value size = ASM_UNKNOWN_SIGNEDNESS {value=value, size=size}
