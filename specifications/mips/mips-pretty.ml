export pretty : (insndata) -> rope

val pretty i = show/instruction i

val -++ a b = a +++ " " +++ b

val as-prefix = if (assembler-mode) then "$" else ""


########################################
# convert instruction to string (rope)
####

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


val show/unop-r x = show/rvalue x.op
val show/unop-l x = show/lvalue x.op
val show/binop-rr x = show/rvalue x.op1 +++ ", " +++ show/rvalue x.op2
val show/binop-rl x = show/rvalue x.op1 +++ ", " +++ show/lvalue x.op2
val show/binop-lr x = show/lvalue x.op1 +++ ", " +++ show/rvalue x.op2
val show/ternop-rrr x = show/rvalue x.op1 +++ ", " +++ show/rvalue x.op2 +++ ", " +++ show/rvalue x.op3
val show/ternop-lrr x = show/lvalue x.op1 +++ ", " +++ show/rvalue x.op2 +++ ", " +++ show/rvalue x.op3
val show/quadop-lrrr x = show/lvalue x.op1 +++ ", " +++ show/rvalue x.op2 +++ ", " +++ show/rvalue x.op3 +++ ", " +++ show/rvalue x.op4


val show/lvalue opnd = 
   case opnd of
      GPR r: show/gpr-register r
    | FPR r: show/fpr-register r
    | FCC fcc: show/fccode fcc
    | C2CC c2cc: show/cop2ccode c2cc
   end

val show/rvalue opnd = let
   val get-msb-lsb x =
      case x of
         MSB i: (zx i)
       | LSB i: (zx i)
      end
in
   case opnd of
      LVALUE l: show/lvalue l
    | IMM imm: show/immediate imm
    | OFFSET/BASE ob: show/immediate ob.offset +++ "("+++ show/gpr-register ob.base +++ ")"
    | INDEX/BASE ib: show/gpr-register ib.index +++ "("+++ show/gpr-register ib.base +++ ")"
    | MSB/LSB ml: show/immediate ml.lsb +++ ", " +++ show-int (1 + (get-msb-lsb ml.msb) - (get-msb-lsb ml.lsb))
   end
end

val show/immediate imm =
   case imm of
      IMM5 x: show-int (zx x)
    | IMM16 x: show-int (zx x)
    | RTRD5 x: as-prefix +++ show-int (zx x)
    | FSCTRL5 x: as-prefix +++ show-int (zx x)
    | OFFSET9 x: show-int (sx x)
    | OFFSET16 x: show-int (sx x)
    | OFFSET18 x: show-int (sx x)
    | SEL x: show-int (zx x)
    | IMPL x: as-prefix +++ show-int (zx x)
    | CODE10 x: show-int (zx x)
    | CODE19 x: show-int (zx x)
    | CODE20 x: show-int (zx x)
    | STYPE x: show-int (zx x)
    | MSB x: show-int (zx x)
    | MSBD x: show-int ((zx x)+1)
    | LSB x: show-int (zx x)
    | HINT x: show-int (zx x)
    | INSTRINDEX28 x: show-int (zx x)
    | COFUN x: show-int (zx x)
    | OP x: show-int (zx x)
    | _ : revision/show/immediate imm
  end

val show/format format = 
   case format of
      S : "S"
    | D : "D"
    | W : "W"
    | L : "L"
    | _ : revision/show/format format
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
      FCC0: as-prefix +++ "fcc0"
    | FCC1: as-prefix +++ "fcc1"
    | FCC2: as-prefix +++ "fcc2"
    | FCC3: as-prefix +++ "fcc3"
    | FCC4: as-prefix +++ "fcc4"
    | FCC5: as-prefix +++ "fcc5"
    | FCC6: as-prefix +++ "fcc6"
    | FCC7: as-prefix +++ "fcc7"
   end

val show/cop2ccode c2cc = 
   case c2cc of
      C2CC0: as-prefix +++ "cc0"
    | C2CC1: as-prefix +++ "cc1"
    | C2CC2: as-prefix +++ "cc2"
    | C2CC3: as-prefix +++ "cc3"
    | C2CC4: as-prefix +++ "cc4"
    | C2CC5: as-prefix +++ "cc5"
    | C2CC6: as-prefix +++ "cc6"
    | C2CC7: as-prefix +++ "cc7"
   end

val show/gpr-register r =
   case r of
      ZERO: as-prefix +++ "zero"
    | AT: as-prefix +++ "at"
    | V0: as-prefix +++ "v0"
    | V1: as-prefix +++ "v1"
    | A0: as-prefix +++ "a0"
    | A1: as-prefix +++ "a1"
    | A2: as-prefix +++ "a2"
    | A3: as-prefix +++ "a3"
    | T0: as-prefix +++ "t0"
    | T1: as-prefix +++ "t1"
    | T2: as-prefix +++ "t2"
    | T3: as-prefix +++ "t3"
    | T4: as-prefix +++ "t4"
    | T5: as-prefix +++ "t5"
    | T6: as-prefix +++ "t6"
    | T7: as-prefix +++ "t7"
    | S0: as-prefix +++ "s0"
    | S1: as-prefix +++ "s1"
    | S2: as-prefix +++ "s2"
    | S3: as-prefix +++ "s3"
    | S4: as-prefix +++ "s4"
    | S5: as-prefix +++ "s5"
    | S6: as-prefix +++ "s6"
    | S7: as-prefix +++ "s7"
    | T8: as-prefix +++ "t8"
    | T9: as-prefix +++ "t9"
    | K0: as-prefix +++ "k0"
    | K1: as-prefix +++ "k1"
    | GP: as-prefix +++ "gp"
    | SP: as-prefix +++ "sp"
    | S8: as-prefix +++ "s8"
    | RA: as-prefix +++ "ra"
   end

val show/fpr-register r =
   case r of
      F0: as-prefix +++ "f0"
    | F1: as-prefix +++ "f1"
    | F2: as-prefix +++ "f2"
    | F3: as-prefix +++ "f3"
    | F4: as-prefix +++ "f4"
    | F5: as-prefix +++ "f5"
    | F6: as-prefix +++ "f6"
    | F7: as-prefix +++ "f7"
    | F8: as-prefix +++ "f8"
    | F9: as-prefix +++ "f9"
    | F10: as-prefix +++ "f10"
    | F11: as-prefix +++ "f11"
    | F12: as-prefix +++ "f12"
    | F13: as-prefix +++ "f13"
    | F14: as-prefix +++ "f14"
    | F15: as-prefix +++ "f15"
    | F16: as-prefix +++ "f16"
    | F17: as-prefix +++ "f17"
    | F18: as-prefix +++ "f18"
    | F19: as-prefix +++ "f19"
    | F20: as-prefix +++ "f20"
    | F21: as-prefix +++ "f21"
    | F22: as-prefix +++ "f22"
    | F23: as-prefix +++ "f23"
    | F24: as-prefix +++ "f24"
    | F25: as-prefix +++ "f25"
    | F26: as-prefix +++ "f26"
    | F27: as-prefix +++ "f27"
    | F28: as-prefix +++ "f28"
    | F29: as-prefix +++ "f29"
    | F30: as-prefix +++ "f30"
    | F31: as-prefix +++ "f31"
   end

