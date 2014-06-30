type insn = {length:int, mnemonic:string, flags:flags, opnds:opnd_list}

type opnd_list =
   OPNDS_NIL
 | OPNDS_CONS of {hd:opnd, tl:opnd_list}

type aso =
   FLO of lso
 | IMM of {signedness:signedness, immediate:immediate}
 | SUM of {lhs:aso, rhs:aso}
 | SCALE of {factor:int, rhs:aso}
 | REL of aso

type lso =
   REGISTER of register
 | MEMORY of {deref-size:int, pointer:opnd}
 | POST_OP of {expr:aso, lso:lso}
 | PRE_OP of {expr:aso, lso:lso}

type opnd =
   LSO of lso
 | ASO of aso
 | CATEGORY of {category:string, opnd:opnd}

type register = {mnemonic:string, size:int, offset:int}

type signedness =
   UNSIGNED
 | SIGNED
 | UNSPEC

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
