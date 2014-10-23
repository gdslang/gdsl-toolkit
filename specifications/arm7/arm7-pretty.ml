# vim:ts=3:sw=3:expandtab

export pretty : (insndata) -> rope

val pretty insdata = show/instruction insdata.insn

val -++ a b = a +++ " " +++ b

val show/instruction insn = show/mnemonic insn -++ show/registers insn

val show/mnemonic insn =
  case insn of
      ADC m: "ADC"
    | ADD m: "ADD"
    | AND m: "AND"
    | BIC m: "BIC"
    | CMN m: "CMN"
    | CMP m: "CMP"
    | EOR m: "EOR"
    | MOV m: "MOV"
    | MVN m: "MVN"
    | ORR m: "ORR"
    | RSB m: "RSB"
    | RSC m: "RSC"
    | SBC m: "SBC"
    | SUB m: "SUB"
    | TEQ m: "TEQ"
    | TST m: "TST"
    | MLA m: "MLA"
    | MUL m: "MUL"
    | SMLAL m: "SMLAL"
    | SMULL m: "SMULL"
    | UMLAL m: "UMULL"
    | STR m: "STR"
    | LDR m: "LDR"
    | LDRH m: "LDRH"
    | STRH m: "STRH"
    | LDRSB m: "LDRSB"
    | LDRSRH m: "LDRSRH"
    | LDM m: "LDM"
    | LDMDA m: "LDMDA"
    | LDMDB m: "LDMDB"
    | LDMIB m: "LDMIB"
    | POP m: "POP"
    | STM m: "STM"
    | STMDA m: "STMDA"
    | STMDB m: "STMDB"
    | STMIB m: "STMIB"
    | PUSH m: "PUSH"
    | B m: "B"
    | BL m: "BL"
    | BLX m: "BLX"
    | BX m: "BX"
    | BXJ m: "BXJ"
    | MRS m: "MRS"
    | MSR m: "MSR"
    | NOP m: "NOP"
    | _: "???"
  end

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

val show/registers insn =
  case insn of
      PUSH i: "{" +++ show/reglist i.register_list +++ "}"
    | POP i: "{" +++ show/reglist i.register_list +++ "}"
    | _ : ""
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
