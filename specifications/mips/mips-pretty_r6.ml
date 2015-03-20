val revision/show/immediate imm =
   case imm of
      IMM21 x: show-int (zx x)
    | BP x: show-int (zx x)
   end

val revision/show/format format = "ERROR"
