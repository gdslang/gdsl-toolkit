# vim:ts=3:sw=3:expandtab

export pretty : (insndata) -> rope

val pretty insdata = show/instruction insdata.insn

val -++ a b = a +++ " " +++ b

type instruction_class =
    NONE
  | BR of br      # branch
  | DP of dp      # data processing
  | LSS of ls     # load/store single
  | LSM of lsm    # load/store multiple
  | ML of mul     # multiply
  | MLL of mull   # mulitply long

val show/instruction insn = let
  val show/i mnemonic i = case i of
      DP c: mnemonic +++ show/dp c
    | LSS c: mnemonic +++ show/ls c
    | LSM c: mnemonic +++ show/lsm c
    | NONE: mnemonic
  end
in
  traverse show/i insn
end

val traverse f insn =
  case insn of
      ADC a: f "ADC" (DP a)
    | ADD a: f "ADD" (DP a)
    | AND a: f "AND" (DP a)
    | BIC a: f "BIC" (DP a)
    | CMN a: f "CMN" (DP a)
    | CMP a: f "CMP" (DP a)
    | EOR a: f "EOR" (DP a)
    | MOV a: f "MOV" (DP a)
    | MVN a: f "MVN" (DP a)
    | ORR a: f "ORR" (DP a)
    | RSB a: f "RSB" (DP a)
    | RSC a: f "RSC" (DP a)
    | SBC a: f "SBC" (DP a)
    | SUB a: f "SUB" (DP a)
    | TEQ a: f "TEQ" (DP a)
    | TST a: f "TST" (DP a)
    | LDR b: f "LDR" (LSS b)
    | LDRB b: f "LDRB" (LSS b)
    | LDRD b: f "LDRD" (LSS b)
    | LDRH b: f "LDRH" (LSS b)
    | LDRSB b: f "LDRSB" (LSS b)
    | LDRSH b: f "LDRSH" (LSS b)
    | LDRSRH b: f "LDRSRH" (LSS b)
    | STR b: f "STR" (LSS b)
    | STRB b: f "STRB" (LSS b)
    | STRD b: f "STRD" (LSS b)
    | STRH b: f "STRH" (LSS b)
    | LDM c: f "LDM" (LSM c)
    | LDMDA c: f "LDMCA" (LSM c)
    | LDMDB c: f "LDMDB" (LSM c)
    | LDMIB c: f "LDMIB" (LSM c)
    | POP c: f "POP" (LSM c)
    | STM c: f "STM" (LSM c)
    | STMDA c: f "STM" (LSM c)
    | STMDB c: f "STMDB" (LSM c)
    | STMIB c: f "STMIB" (LSM c)
    | PUSH c: f "PUSH" (LSM c)
    | _: f "???" NONE
  end

val show/dp insn = show/s insn +++ show/condition insn.cond -++ show/register insn.rn +++ "," -++ show/register insn.rd +++ "," -++ show/operand insn.op2

val show/s insn = if insn.s then "S" else ""

val show/ls insn = ""
val show/lsm insn = ""

val show/condition cond =
  case cond of
      EQ: "EQ"
    | NE: "NE"
    | CS: "CS"
    | CC: "CC"
    | MI: "MI"
    | PL: "PL"
    | VS: "VS"
    | VC: "VS"
    | HI: "HI"
    | LS: "LS"
    | GE: "GE"
    | LT: "LT"
    | GT: "GT"
    | LE: "LE"
    | _: ""
  end

val show/register reg =
  case reg of
      R0: "R0"
    | R1: "R1"
    | R2: "R2"
    | R3: "R3"
    | R4: "R4"
    | R5: "R5"
    | R6: "R6"
    | R7: "R7"
    | R8: "R8"
    | R9: "R9"
    | R10: "R10"
    | R11: "R11"
    | R12: "IP"
    | R13: "SP"
    | R14: "LR"
    | R15: "PC"
    | _: "??"
  end

val show/immediate imm =
  case imm of
      INT i: show-int i
    | IMM5 i: show-int (zx i)
    | IMM8 i: show-int (zx i)
    | IMM12 i: show-int (zx i)
    | IMM24 i: show-int (zx i)
    | MODIMM i: "#" +++ show-int(zx i.byte) +++ "," -++ "#" +++ show-int(zx i.rot)
    | _: "???"
  end

val show/operand op =
  case op of
      IMMEDIATE i: show/immediate i
    | REGISTER r: show/register r
    | REGISTER_LIST l: "{" +++ show/reglist l +++ "}"
    | SHIFTED_REGISTER s: 
    | _: "???"
  end

val show/reglist reglist =
  case reglist of
      REGL_NIL: ""
    | REGL_CONS l: show/register l.head +++
      (case l.tail of
          REGL_NIL: ""
        | _: ", "
      end) +++ show/reglist l.tail
  end
