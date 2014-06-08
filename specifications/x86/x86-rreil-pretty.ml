export = pretty-arch-id pretty-arch-exception

val arch-show-id r = case r of
     Sem_IP : "IP"
   | Sem_FLAGS : "FLAGS"
   | Sem_MXCSR : "MXCSR"
   | Sem_A : "A"
   | Sem_B : "B"
   | Sem_C : "C"
   | Sem_D : "D"
   | Sem_SI : "SI"
   | Sem_DI : "DI"
   | Sem_SP : "SP"
   | Sem_BP : "BP"
   | Sem_R8 : "R8"
   | Sem_R9 : "R9"
   | Sem_R10 : "R10"
   | Sem_R11 : "R11"
   | Sem_R12 : "R12"
   | Sem_R13 : "R13"
   | Sem_R14 : "R14"
   | Sem_R15 : "R15"
   | Sem_CS : "CS"
   | Sem_DS : "DS"
   | Sem_SS : "SS"
   | Sem_ES : "ES"
   | Sem_FS : "FS"
   | Sem_GS : "GS"
   | Sem_CS_Base : "CS_Base"
   | Sem_DS_Base : "DS_Base"
   | Sem_SS_Base : "SS_Base"
   | Sem_ES_Base : "ES_Base"
   | Sem_FS_Base : "FS_Base"
   | Sem_GS_Base : "GS_Base"
   | Sem_ST0 : "ST0"
   | Sem_ST1 : "ST1"
   | Sem_ST2 : "ST2"
   | Sem_ST3 : "ST3"
   | Sem_ST4 : "ST4"
   | Sem_ST5 : "ST5"
   | Sem_ST6 : "ST6"
   | Sem_ST7 : "ST7"
   | Sem_MM0 : "MM0"
   | Sem_MM1 : "MM1"
   | Sem_MM2 : "MM2"
   | Sem_MM3 : "MM3"
   | Sem_MM4 : "MM4"
   | Sem_MM5 : "MM5"
   | Sem_MM6 : "MM6"
   | Sem_MM7 : "MM7"
   | Sem_XMM0 : "XMM0"
   | Sem_XMM1 : "XMM1"
   | Sem_XMM2 : "XMM2"
   | Sem_XMM3 : "XMM3"
   | Sem_XMM4 : "XMM4"
   | Sem_XMM5 : "XMM5"
   | Sem_XMM6 : "XMM6"
   | Sem_XMM7 : "XMM7"
   | Sem_XMM8 : "XMM8"
   | Sem_XMM9 : "XMM9"
   | Sem_XMM10 : "XMM10"
   | Sem_XMM11 : "XMM11"
   | Sem_XMM12 : "XMM12"
   | Sem_XMM13 : "XMM13"
   | Sem_XMM14 : "XMM14"
   | Sem_XMM15 : "XMM15"
#    | VIRT_EQ: "EQ"
#    | VIRT_NEQ: "NEQ"
    | VIRT_LES: "LES"
    | VIRT_LEU: "LEU"
    | VIRT_LTS: "LTS"
#    | VIRT_LTU: "LTU"
end

val pretty-arch-id r = arch-show-id r

val arch-show-exception exception =
   case exception of
      SEM_DIVISION_OVERFLOW: "{Exception: Division overflow}"
   end

val pretty-arch-exception exception = case exception of
   FIX_INTERFACE i: case 0 of 1: "" end
 | _: arch-show-exception exception
end
