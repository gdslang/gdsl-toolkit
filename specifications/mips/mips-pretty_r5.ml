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

val revision/show/immediate imm = "ERROR"

val revision/show/format format = 
   case format of
      PS : "PS"
   end
