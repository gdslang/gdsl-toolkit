export pretty : (insndata) -> rope

val pretty i = show/instruction i

val -++ a b = a +++ " " +++ b

val show/lvalue opnd = 
   case opnd of
      GPR r: show/register r
    | FPR r: show/register r
   end

val show/rvalue opnd = 
   case opnd of
      LVALUE l: show/lvalue l
    | IMM imm: show/immediate imm
    | FCC fcc: show/fccode fcc
   end

val show/immediate imm =
   case imm of
      IMM5 x: show-int (zx x)
    | IMM16 x: show-int (zx x)
    | RTRD5 x: "$" +++ show-int (zx x)
    | OFFSET9 x: show-int ((zx x) * 4)
    | OFFSET16 x: show-int ((zx x) * 4)
    | SEL x: show-int (zx x)
    | IMPL x: "$" +++ show-int (zx x)
    | CODE10 x: show-int (zx x)
    | CODE19 x: show-int (zx x)
    | CODE20 x: show-int (zx x)
    | STYPE x: show-int (zx x)
    | POSSIZE x: show-int (zx x)
    | SIZE x: show-int (zx x)
    | POS x: show-int (zx x)
    | HINT x: show-int (zx x)
    | INSTRINDEX x: show-int ((zx x) * 4)
    | COFUN x: show-int (zx x)
    | COND x: show-int (zx x)
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

val show/register r =
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
    | HI: "$hi"
    | LO: "$lo"
    | PC: "$pc"
    | F0: "$f0"
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
    | FIR: "$fir"
    | FCCR: "$fccr"
    | FEXR: "$fexr"
    | FENR: "$fenr"
    | FCSR: "$fcsr"
   end

# -> sftl

val show/unop-src x = show/rvalue x.source
val show/unop x = show/lvalue x.destination
val show/binop-src x = show/rvalue x.source1 +++ ", " +++ show/rvalue x.source2
val show/binop-fmt x = show/lvalue x.destination +++ ", " +++ show/rvalue x.source
val show/binop x = show/lvalue x.destination +++ ", " +++ show/rvalue x.source
val show/ternop-src x = show/rvalue x.source1 +++ ", " +++ show/rvalue x.source2 +++ ", " +++ show/rvalue x.source3
val show/ternop x = show/lvalue x.destination +++ ", " +++ show/rvalue x.source1 +++ ", " +++ show/rvalue x.source2
val show/ternop-fmt x = show/lvalue x.destination +++ ", " +++ show/rvalue x.source1 +++ ", " +++ show/rvalue x.source2
val show/quadop x = show/lvalue x.destination +++ ", " +++ show/rvalue x.source1 +++ ", " +++ show/rvalue x.source2 +++ ", " +++ show/rvalue x.source3
val show/quadop-fmt x = show/lvalue x.destination +++ ", " +++ show/rvalue x.source1 +++ ", " +++ show/rvalue x.source2 +++ ", " +++ show/rvalue x.source3
val show/quadop-fmt-src x = show/rvalue x.source1 +++ ", " +++ show/rvalue x.source2 +++ ", " +++ show/rvalue x.source3 +++ ", " +++ show/rvalue x.source4


val show/instruction insn = let
   val show/ua mnemonic ua = case ua of
      NULLOP: mnemonic
    | UNOP_SRC x: mnemonic -++ show/unop-src x
    | UNOP x: mnemonic -++ show/unop x
    | BINOP_SRC x: mnemonic -++ show/binop-src x
    | BINOP_FMT x: mnemonic +++ "." +++ show/format x.fmt -++ show/binop-fmt x
    | BINOP x: mnemonic -++ show/binop x
    | TERNOP_SRC x: mnemonic -++ show/ternop-src x
    | TERNOP x: mnemonic -++ show/ternop x
    | TERNOP_FMT x: mnemonic +++ "." +++ show/format x.fmt -++ show/ternop-fmt x
    | QUADOP x: mnemonic -++ show/quadop x
    | QUADOP_FMT x: mnemonic +++ "." +++ show/format x.fmt -++ show/quadop-fmt x
    | QUADOP_FMT_SRC x: mnemonic +++ "." +++ show/format x.fmt -++ show/quadop-fmt-src x
   end
in
   traverse show/ua insn.insn
end


# <- sutl

