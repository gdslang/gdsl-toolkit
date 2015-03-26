val revision/show/immediate imm =
   case imm of
      IMM21 x: show-int (zx x)
    | IMM32 x: show-int (zx x)
    | BP x: show-int (zx x)
    | OFFSET23 x: show-int (zx x)
    | OFFSET28 x: show-int (zx x)
    | C2CONDITION x: show-int (zx x)
   end

val revision/show/format format = "ERROR"
