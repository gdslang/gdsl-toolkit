# vim:ts=3:sw=3:expandtab

export pretty : (insndata) -> rope

val pretty insdata = show/instruction insdata.insn

val show/instruction insn = show/mnemonic insn

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
    | LDR m: "LDR"
    | STR m: "STR"
    | LDRH m: "LDRH"
    | STRH m: "STRH"
    | LDRSB m: "LDRSB"
    | LDRSRH m: "LDRSRH"
    | B m: "B"
    | BL m: "BL"
    | MRS m: "MRS"
    | MSR m: "MSR"
    | CLREX: "CLREX"
    | _: "UNKNOWN_MNEMONIC"
   end

