export pretty : (insndata) -> rope

val pretty i = show/instruction i

val -++ a b = a +++ " " +++ b

val show/lvalue opnd = 
   case opnd of
      GPR r: show/gpr-register r
    | FPR r: show/fpr-register r
    | FCC fcc: show/fccode fcc
   end

val show/rvalue opnd = 
   case opnd of
      LVALUE l: show/lvalue l
    | IMM imm: show/immediate imm
    | OFFSET/BASE ob: show/immediate ob.offset +++ "("+++ show/gpr-register ob.base +++ ")"
    | INDEX/BASE ib: show/gpr-register ib.index +++ "("+++ show/gpr-register ib.base +++ ")"
   end

val show/immediate imm =
   case imm of
      IMM5 x: show-int (zx x)
    | IMM16 x: show-int (zx x)
    | RTRD5 x: "$" +++ show-int (zx x)
    | OFFSET9 x: show-int ((sx x) * 4)
    | OFFSET16 x: show-int ((sx x) * 4)
    | SEL x: show-int (zx x)
    | IMPL x: show-int (zx x)
    | CODE10 x: show-int (zx x)
    | CODE19 x: show-int (zx x)
    | CODE20 x: show-int (zx x)
    | STYPE x: show-int (zx x)
    | POSSIZE x: show-int (zx x)
    | SIZE x: show-int ((zx x)+1)
    | POS x: show-int (zx x)
    | HINT x: show-int (zx x)
    | INSTRINDEX x: show-int ((zx x) * 4)
    | COFUN x: show-int (zx x)
    | OP x: show-int (zx x)
  end

val show/format format = 
   case format of
      S : "S"
    | D : "D"
    | W : "W"
    | L : "L"
    | PS : "PS"
   end

val show/condop cond = 
   case cond of
      C_F: "F"
    | C_UN: "UN"
    | C_EQ: "EQ"
    | C_UEQ: "UEQ"
    | C_OLT: "OLT"
    | C_ULT: "ULT"
    | C_OLE: "OLE"
    | C_ULE: "ULE"
    | C_SF: "SF"
    | C_NGLE: "NGLE"
    | C_SEQ: "SEQ"
    | C_NGL: "NGL"
    | C_LT: "LT"
    | C_NGE: "NGE"
    | C_LE: "LE"
    | C_NGT: "NGT"
   end

val show/fccode fcc = 
   case fcc of
      FCC0: "$fcc0"
    | FCC1: "$fcc1"
    | FCC2: "$fcc2"
    | FCC3: "$fcc3"
    | FCC4: "$fcc4"
    | FCC5: "$fcc5"
    | FCC6: "$fcc6"
    | FCC7: "$fcc7"
   end

val show/gpr-register r =
   case r of
      ZERO: "$zero"
    | AT: "$at"
    | V0: "$v0"
    | V1: "$v1"
    | A0: "$a0"
    | A1: "$a1"
    | A2: "$a2"
    | A3: "$a3"
    | T0: "$t0"
    | T1: "$t1"
    | T2: "$t2"
    | T3: "$t3"
    | T4: "$t4"
    | T5: "$t5"
    | T6: "$t6"
    | T7: "$t7"
    | S0: "$s0"
    | S1: "$s1"
    | S2: "$s2"
    | S3: "$s3"
    | S4: "$s4"
    | S5: "$s5"
    | S6: "$s6"
    | S7: "$s7"
    | T8: "$t8"
    | T9: "$t9"
    | K0: "$k0"
    | K1: "$k1"
    | GP: "$gp"
    | SP: "$sp"
    | S8: "$s8"
    | RA: "$ra"
   end

val show/fpr-register r =
   case r of
      F0: "$f0"
    | F1: "$f1"
    | F2: "$f2"
    | F3: "$f3"
    | F4: "$f4"
    | F5: "$f5"
    | F6: "$f6"
    | F7: "$f7"
    | F8: "$f8"
    | F9: "$f9"
    | F10: "$f10"
    | F11: "$f11"
    | F12: "$f12"
    | F13: "$f13"
    | F14: "$f14"
    | F15: "$f15"
    | F16: "$f16"
    | F17: "$f17"
    | F18: "$f18"
    | F19: "$f19"
    | F20: "$f20"
    | F21: "$f21"
    | F22: "$f22"
    | F23: "$f23"
    | F24: "$f24"
    | F25: "$f25"
    | F26: "$f26"
    | F27: "$f27"
    | F28: "$f28"
    | F29: "$f29"
    | F30: "$f30"
    | F31: "$f31"
   end

# -> sftl

val show/unop-r x = show/rvalue x.op
val show/unop-l x = show/lvalue x.op
val show/binop-rr x = show/rvalue x.op1 +++ ", " +++ show/rvalue x.op2
val show/binop-rl x = show/rvalue x.op1 +++ ", " +++ show/lvalue x.op2
val show/binop-lr x = show/lvalue x.op1 +++ ", " +++ show/rvalue x.op2
val show/ternop-rrr x = show/rvalue x.op1 +++ ", " +++ show/rvalue x.op2 +++ ", " +++ show/rvalue x.op3
val show/ternop-lrr x = show/lvalue x.op1 +++ ", " +++ show/rvalue x.op2 +++ ", " +++ show/rvalue x.op3
val show/quadop-lrrr x = show/lvalue x.op1 +++ ", " +++ show/rvalue x.op2 +++ ", " +++ show/rvalue x.op3 +++ ", " +++ show/rvalue x.op4


val show/instruction insn = let
   val show/ua mnemonic ua = case ua of
      NULLOP: mnemonic
    | UNOP_R x: mnemonic -++ show/unop-r x
    | UNOP_L x: mnemonic -++ show/unop-l x
    | BINOP_RR x: mnemonic -++ show/binop-rr x
    | BINOP_RL x: mnemonic -++ show/binop-rl x
    | BINOP_LR x: mnemonic -++ show/binop-lr x
    | BINOP_FLR x: mnemonic +++ "." +++ show/format x.fmt -++ show/binop-lr x
    | TERNOP_RRR x: mnemonic -++ show/ternop-rrr x
    | TERNOP_LRR x: mnemonic -++ show/ternop-lrr x
    | TERNOP_FLRR x: mnemonic +++ "." +++ show/format x.fmt -++ show/ternop-lrr x
    | TERNOP_CFLRR x: mnemonic +++ "." +++ show/condop x.cond +++ "." +++ show/format x.fmt -++ show/ternop-lrr x
    | QUADOP_LRRR x: mnemonic -++ show/quadop-lrrr x
    | QUADOP_FLRRR x: mnemonic +++ "." +++ show/format x.fmt -++ show/quadop-lrrr x
   end
in
   traverse show/ua insn.insn
end


# <- sutl

