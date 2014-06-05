# vim:ts=3:sw=3:expandtab

export = pretty

val pretty i = show/instruction i

val -++ a b = a +++ " " +++ b

val show/leftop opnd = 
   case opnd of
      GPR r: show/register r
    | FPR r: show/register r
   end

val show/rightop opnd = 
   case opnd of
      LEFTOP l: show/leftop l
    | IMM imm: show/immediate imm
   end

val show/immediate imm =
   case imm of
      IMM16 x: show-int (zx x)
    | SIZE i: show-int i
  end

val show/register r =
   case r of
      ZERO: "zero"
    | AT: "at"
    | V0: "v0"
    | V1: "v1"
    | A0: "a0"
    | A1: "a1"
    | A2: "a2"
    | A3: "a3"
    | A4: "a4"
    | A5: "a5"
    | A6: "a6"
    | A7: "a7"
    | T4: "t4"
    | T5: "t5"
    | T6: "t6"
    | T7: "t7"
    | S0: "s0"
    | S1: "s1"
    | S2: "s2"
    | S3: "s3"
    | S4: "s4"
    | S5: "s5"
    | S6: "s6"
    | S7: "s7"
    | T8: "t8"
    | T9: "t9"
    | K0: "k0"
    | K1: "k1"
    | GP: "gp"
    | SP: "sp"
    | S8: "s8"
    | RA: "ra"
    | HI: "hi"
    | LO: "lo"
    | PC: "pc"
    | F x: "f" +++ show-int x
    | FIR: "fir"
    | FCCR: "fccr"
    | FEXR: "fexr"
    | FENR: "fenr"
    | FCSR: "fcsr"
   end

val show/ternop x = show/leftop x.destination +++ ", " +++ show/rightop x.source1 +++ ", " +++ show/rightop x.source2

val show/instruction i =
   case i of
      ADD x: "ADD" -++ show/ternop x
  end
