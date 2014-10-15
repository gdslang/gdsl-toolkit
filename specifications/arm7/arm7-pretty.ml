# vim:ts=3:sw=3:expandtab

export pretty : (insndata) -> rope

val pretty insdata = show/instruction insdata.instruction

val show/instruction insn = show/mnemonic insn

val show/mnemonic insn =
   case insn of 
      ADD m: "ADD"
    | SUB m: "SUB"
    | _: "UNKNOWN_MNEMONIC"
   end

