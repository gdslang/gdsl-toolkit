export generalize : (insndata) -> asm-insn

val generalize insn = let
  val recordify mnemonic ua = {mnemonic=mnemonic, ua=ua}
  val traversed = traverse recordify insn.insn
in
  asm-insn insn.length (string-from-rope-lit traversed.mnemonic) (generalize-ua traversed.ua)
end

val generalize-lvalue lval = let
  val generalize-register r = asm-reg (string-from-rope-lit (show/register r))
in case lval of
   GPR r: generalize-register r
 | FPR f: generalize-register f
end end

val generalize-rvalue rval = let
  val generalize-register r = asm-reg (string-from-rope-lit (show/register r))
in case rval of
   LVALUE lval: generalize-lvalue lval
 | IMM i: generalize-immediate i
end end

val generalize-immediate i = let
   val inner i sz = asm-bounded (asm-boundary-sz sz) (asm-imm (zx i))
in case i of
   IMM5 i: inner i 5
 | IMM16 i: inner i 16
 | OFFSET9 i: inner i 9
 | OFFSET16 i: inner i 16
 | SEL i: inner i 3
 | IMPL i: inner i 16
 | CODE10 i: inner i 10
 | CODE19 i: inner i 19
 | CODE20 i: inner i 20
 | STYPE i: inner i 5
 | POSSIZE i: inner i 5
 | SIZE i: inner i 5
 | POS i: inner i 5
 | HINT i: inner i 5
 | INSTRINDEX i: inner i 26
 | COFUN i: inner i 25
 | CC i: inner i 3
 | COND i: inner i 4
 | OP i: inner i 5
end end

# -> sftl
val generalize-ua ua =
   case ua of
      NULLOP: asm-opnds-none
    | UNOP_SRC x: asm-opnds-one (generalize-rvalue x.source)
    | UNOP x: asm-opnds-one (generalize-lvalue x.destination)
    | BINOP_SRC x: asm-opnds-more (generalize-rvalue x.source1) (asm-opnds-one (generalize-rvalue x.source2))
    | BINOP_FMT x: asm-opnds-more (generalize-lvalue x.destination) (asm-opnds-one (generalize-rvalue x.source))
    | BINOP x: asm-opnds-more (generalize-lvalue x.destination) (asm-opnds-one (generalize-rvalue x.source))
    | TERNOP_SRC x: asm-opnds-more (generalize-rvalue x.source1) (asm-opnds-more (generalize-rvalue x.source2) (asm-opnds-one (generalize-rvalue x.source3)))
    | TERNOP x: asm-opnds-more (generalize-lvalue x.destination) (asm-opnds-more (generalize-rvalue x.source1) (asm-opnds-one (generalize-rvalue x.source2)))
    | TERNOP_FMT x: asm-opnds-more (generalize-lvalue x.destination) (asm-opnds-more (generalize-rvalue x.source1) (asm-opnds-one (generalize-rvalue x.source2)))
    | QUADOP x: asm-opnds-more (generalize-lvalue x.destination) (asm-opnds-more (generalize-rvalue x.source1) (asm-opnds-more (generalize-rvalue x.source2) (asm-opnds-one (generalize-rvalue x.source3))))
    | QUADOP_FMT x: asm-opnds-more (generalize-lvalue x.destination) (asm-opnds-more (generalize-rvalue x.source1) (asm-opnds-more (generalize-rvalue x.source2) (asm-opnds-one (generalize-rvalue x.source3))))
    | QUADOP_FMT_SRC x: asm-opnds-more (generalize-rvalue x.source1) (asm-opnds-more (generalize-rvalue x.source2) (asm-opnds-more (generalize-rvalue x.source3) (asm-opnds-one (generalize-rvalue x.source4))))
   end


# <- sutl
