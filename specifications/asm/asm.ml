type insn = {length:int, mnemonic:string, flags:flags, opnds:opnd_list}

type opnd_list =
   OPNDS_NIL
 | OPNDS_CONS of {hd:opnd, tl:opnd_list}

type rso =
   FLO of lso
 | IMM of {signedness:signedness, immediate:immediate}
 | SUM of {lhs:rso, rhs:rso}
 | SCALE of {factor:int, rhs:rso}
 | REL of rso

#Todo: Gemeiner Typ für Ops
#Todo: Prefixe für Namen

type lso =
   REGISTER of register
 | MEMORY of {deref-size:int, pointer:opnd}
 | POST_OP of {expr:rso, lso:lso}
 | PRE_OP of {expr:rso, lso:lso}

type opnd =
   LSO of lso
 | RSO of rso
 | CATEGORY of {category:string, opnd:opnd}

type register =
   REGISTER_NAME of string
 | REGISTER_SO of {mnemonic:string, size:int, offset:int}

type signedness =
   UNSIGNED
 | SIGNED
 | UNSPEC

#Todo: int + size statt v

type immediate =
   I1 of 1
 | I8 of 8
 | I16 of 16
 | I24 of 24
 | I32 of 32
 | I40 of 40
 | I48 of 48
 | I56 of 56
 | I64 of 64
 | I128 of 128
 | I256 of 256
 | I512 of 512

type flags =
   CONDITION of opnd
 | SFLAGS of string
 | NOFLAGS

val imm-as-uint imm = case imm of
   I1 i: zx i
 | I8 i: zx i
 | I16 i: zx i
 | I24 i: zx i
 | I32 i: zx i
 | I40 i: zx i
 | I48 i: zx i
 | I56 i: zx i
 | I64 i: zx i
 | I128 i: zx i
 | I256 i: zx i
 | I512 i: zx i
end

val imm-as-int imm = case imm of
   I1 i: sx i
 | I8 i: sx i
 | I16 i: sx i
 | I24 i: sx i
 | I32 i: sx i
 | I40 i: sx i
 | I48 i: sx i
 | I56 i: sx i
 | I64 i: sx i
 | I128 i: sx i
 | I256 i: sx i
 | I512 i: sx i
end

val asm-insn l m o = {length=l, mnemonic=m, flags=NOFLAGS, opnds=o}
val asm-insn-flags l m f o = {length=l, mnemonic=m, flags=f, opnds=o}

val asm-opnds-none = OPNDS_NIL
val asm-opnds-one hd = OPNDS_CONS {hd=hd, tl=OPNDS_NIL}
val asm-opnds-more hd tl = OPNDS_CONS {hd=hd, tl=tl}

val asm-froml l = FLO l
val asm-rreg r = FLO (asm-lreg r)
val asm-rmem dsize ptr = FLO (asm-lmem dsize ptr)
val asm-rpo expr lso = FLO (asm-lpo expr lso)
val asm-rpr expr lso = FLO (asm-lpr expr lso)
val asm-rimm simm = IMM simm
val asm-rsum l r = SUM {lhs=l, rhs=r}
val asm-rscale f r = SCALE {factor=f, rhs=r}
val asm-rel o = REL o

val asm-lreg r = REGISTER r
val asm-lmem dsize ptr = MEMORY {deref-size=dsize, pointer=ptr}
val asm-lpo expr lso = POST_OP {expr=expr, lso=lso}
val asm-lpr expr lso = PRE_OP {expr=expr, lso=lso}

val asm-lopnd l = LSO l
val asm-ropnd r = RSO r
val asm-copnd c o = CATEGORY {category=c, opnd=o}

val asm-register mnemonic = REGISTER_NAME mnemonic
val asm-register-so mnemonic size offset = REGISTER_SO {mnemonic=mnemonic, size=size, offset=offset}

val asm-int imm = {signedness=SIGNED, immediate=imm}
val asm-uint imm = {signedness=UNSIGNED, immediate=imm}
val asm-imm imm = {signedness=UNSPEC, immediate=imm}

val asm-condition opnd = CONDITION opnd
val asm-flags s = SFLAGS s
