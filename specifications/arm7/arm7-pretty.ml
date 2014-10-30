# vim:ts=3:sw=3:expandtab

export pretty : (insndata) -> rope

val pretty insndata = show-hex insndata.ip +++ ":\\t" -++ show/instruction insndata.insn insndata.ip

val -++ a b = a +++ " " +++ b

val show-hex i = let
  val hex nibble = case nibble of
      10: "A"
    | 11: "B"
    | 12: "C"
    | 13: "D"
    | 14: "E"
    | 15: "F"
    | _: show-int (nibble)
  end
in
  if (/z i 16) === 0 then
    hex (/mod i 16)
  else
    show-hex (/z i 16) +++ hex (/mod i 16)
end

# The instruction types for pretty printing
type instruction_class =
    NONE
  | BR of br      # branch
  | DP of dp      # data processing
  | LSS of ls     # load/store single
  | LSM of lsm    # load/store multiple
  | ML of mul     # multiply
  | MLL of mull   # mulitply long
  | NULLOP of nullop
  | UNOP of unop
  | BINOP of binop

val show/instruction insn ip = let
  val show/insn mnemonic i = case i of
      BR c: mnemonic +++ show/br c ip
    | DP c: mnemonic +++ show/dp c insn
    | LSS c: mnemonic +++ show/lss c
    | LSM c: mnemonic +++ show/lsm c insn
    | ML c: mnemonic +++ show/ml c
    | MLL c: mnemonic +++ show/mll c
    | NONE: mnemonic
    | NULLOP c: mnemonic +++ show/condition c.cond
    | UNOP c: mnemonic +++ show/condition c.cond +++ "\\t" +++ show/operand c.opnd
    | BINOP c: mnemonic +++ show/condition c.cond +++ "\\t" +++ show/operand c.opnd1 +++ ", " +++ show/operand c.opnd2
  end
in
  traverse show/insn insn
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
    | LDRT b: f "LDRT" (LSS b)
    | LDRB b: f "LDRB" (LSS b)
    | LDRBT b: f "LDRBT" (LSS b)
    | LDRD b: f "LDRD" (LSS b)
    | LDRH b: f "LDRH" (LSS b)
    | LDRHT b: f "LDRHT" (LSS b)
    | LDRSB b: f "LDRSB" (LSS b)
    | LDRSBT b: f "LDRSBT" (LSS b)
    | LDRSH b: f "LDRSH" (LSS b)
    | LDRSHT b: f "LDRSHT" (LSS b)
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
    | B d: f "B" (BR d)
    | BL d: f "BL" (BR d)
    | BLX d: f "BLX" (BR d)
    | BX d: f "BX" (BR d)
    | BXJ d: f "BXJ" (BR d)
    | MLA e: f "MLA" (ML e)
    | MLS e: f "MLS" (ML e)
    | MUL e: f "MUL" (ML e)
    | SMLAL g: f "SMLAL" (MLL g)
    | SMULL g: f "SMULL" (MLL g)
    | UMLAL g: f "UMLAL" (MLL g)
    | UMULL g: f "UMULL" (MLL g)
    | DBG h: f "DBG" (UNOP h)
    | SVC h: f "SVC" (UNOP h)
    | CLZ i: f "CLZ" (BINOP i)
    | _: f "???" NONE
  end

# Show branch instructions
val show/br insn ip = show/condition insn.cond +++ "\\t" +++ show/target insn.label ip

val show/target label ip =
  case label of
      IMMEDIATE imm: (
        case imm of
            IMMi i: show-hex (ip + 8 + i)
          | _: "???"
        end)
    | REGISTER reg: show/register reg
    | _: "???"
  end

# Show data-processing instructions
val show/dp insn insn_type = case insn_type of
    CMN i: show/condition insn.cond +++ "\\t" +++ show/operand insn.rn +++ "," -++ show/operand insn.op2
  | CMP i: show/condition insn.cond +++ "\\t" +++ show/operand insn.rn +++ "," -++ show/operand insn.op2
  | MOV i: show/s insn +++ show/condition insn.cond +++ "\\t" +++ show/register insn.rd +++ "," -++ show/operand insn.op2
  | MVN i: show/s insn +++ show/condition insn.cond +++ "\\t" +++ show/register insn.rd +++ "," -++ show/operand insn.op2
  | TEQ i: show/condition insn.cond +++ "\\t" +++ show/operand insn.rn +++ "," -++ show/operand insn.op2
  | TST i: show/condition insn.cond +++ "\\t" +++ show/operand insn.rn +++ "," -++ show/operand insn.op2
  | _: show/s insn +++ show/condition insn.cond +++ "\\t" +++ show/register insn.rd +++ "," -++ show/operand insn.rn +++ "," -++ show/operand insn.op2
end

val show/s insn = if insn.s then "S" else ""

# Show load/store (single) instructions
val show/lss insn = show/condition insn.cond +++ "\\t" +++ show/register insn.rt +++ ", [" +++ show/register insn.rn +++ ", #" +++ show/sign insn +++ show/operand insn.offset +++ "]"

val show/sign insn = if insn.u then "" else "-"
val show/wback insn = if insn.w then "!" else ""

# Show load/store (multiple) instructions
val show/lsm insn insn_type = show/condition insn.cond +++ "\\t" +++
  (case insn_type of
      POP i: show/operand insn.register_list
    | PUSH i: show/operand insn.register_list
    | _: show/register insn.rn +++ "," -++ show/operand insn.register_list
end)

# Show multiplication instructions
val show/ml insn = show/s insn +++ show/condition insn.cond -++ show/register insn.rd +++ "," -++ show/register insn.rn +++ "," -++ show/register insn.rm +++ "," -++ show/register insn.ra

# Show long multiplication instructions
val show/mll insn = show/s insn +++ show/condition insn.cond -++ show/register insn.rdlo +++ "," -++ show/register insn.rdhi +++ "," -++ show/register insn.rn +++ "." -++ show/register insn.rm

val show/condition cond = case cond of
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

val show/register reg = case reg of
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

val show/shift s = case s of
    IMMSHIFT s: show/shifttype s.shifttype -++ "#" +++ show/immediate s.immediate
  | REGSHIFT s: show/shifttype s.shifttype -++ show/register s.register
end

val show/shifttype t = case t of
    LSL: "LSL"
  | LSR: "LSR"
  | ASR: "ASR"
  | ROR: "ROR"
end

val show/immediate imm = case imm of
    IMMi i: show-int i
  | IMM4 i: show-int (zx i)
  | IMM5 i: show-int (zx i)
  | IMM8 i: show-int (zx i)
  | IMM12 i: show-int (zx i)
  | IMM16 i: "0x" +++ show-hex (zx i)
  | IMM24 i: "0x" +++ show-hex (zx i)
  | MODIMM i: "#" +++ show-int(zx i.byte) +++ "," -++ "#" +++ show-int(zx i.rot) +++ "\\t ; = " +++ show-int(armexpandimm i) +++ " (0x" +++ show-hex(armexpandimm i) +++ ")"
  | _: "???"
end

val show/operand op = case op of
    IMMEDIATE o: show/immediate o
  | REGISTER o: show/register o
  | REGISTER_LIST o: "{" +++ show/reglist o +++ "}"
  | SHIFTED_REGISTER o: show/register o.register +++ "," -++ show/shift o.shift
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
