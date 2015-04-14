val show/condop cond = 
   case cond of
      C_AF: "AF"
    | C_UN: "UN"
    | C_EQ: "EQ"
    | C_UEQ: "UEQ"
    | C_LT: "LT"
    | C_ULT: "ULT"
    | C_LE: "LE"
    | C_ULE: "ULE"
    | C_SAF: "SAF"
    | C_SUN: "SUN"
    | C_SEQ: "SEQ"
    | C_SUEQ: "SUEQ"
    | C_SLT: "SLT"
    | C_SULT: "SULT"
    | C_SLE: "SLE"
    | C_SULE: "SULE"
    | C_AT: "AT"
    | C_OR: "OR"
    | C_UNE: "UNE"
    | C_NE: "NE"
    | C_UGE: "UGE"
    | C_OGE: "OGE"
    | C_UGT: "UGT"
    | C_OGT: "OGT"
    | C_SAT: "SAT"
    | C_SOR: "SOR"
    | C_SUNE: "SUNE"
    | C_SNE: "SNE"
    | C_SUGE: "SUGE"
    | C_SOGE: "SOGE"
    | C_SUGT: "SUGT"
    | C_SOGT: "SOGT"
   end

val revision/show/immediate imm =
   case imm of
      IMM21 x: show-int (zx x)
    | IMM32 x: show-int (zx x)
    | BP x: show-int (zx x)
    | SA2 x: show-int (zx x)
    | OFFSET11 x: show-int (zx x)
    | OFFSET23 x: show-int (zx x)
    | OFFSET28 x: show-int (zx x)
    | C2CONDITION x: show-int (zx x)
   end

val revision/show/format format = "ERROR"
