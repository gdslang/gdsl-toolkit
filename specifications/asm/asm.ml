type insn = {length:int, mnemonic:string, opnds:opnd_list}

type opnd_list =
   OPNDS_NIL
 | OPNDS_CONS of opnd

type opnd =
   IMM of immediate
 | REL of opnd
 | REGISTER of register
 | MEMORY of {deref-size:int, pointer:opnd}
 | LINEAR of linear

type linear =
   SUM of {lhs:linear, rhs:linear}
 | SCALE of {factor:int, rhs:linear}
 | OPND of opnd

type register = {mnemonic:string, size:int}

type immediate =
   I1
 | I8
 | I16
 | I24
 | I32
 | I40
 | I48
 | I56
 | I64
 | I128
 | I256
 | I512

val foobar = 42
