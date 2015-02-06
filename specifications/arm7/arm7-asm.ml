export generalize : (insndata) -> asm-insn

val generalize insn = asm-insn 0 (string-from-rope "") asm-opnds-none
