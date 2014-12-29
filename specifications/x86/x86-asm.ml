export generalize : (insndata) -> asm-insn

val generalize insn = asm-insn insn.length (string-from-rope (pretty-mnemonic insn)) (generalize-ua (uarity-of insn.insn))
  
val generalize-ua ua = case ua of
   UA0: asm-opnds-none
 | UA1 u: asm-opnds-one (generalize-opnd u.opnd1)
 | UA2 u: asm-opnds-more (generalize-opnd u.opnd1) (asm-opnds-one (generalize-opnd u.opnd2))
 | UA3 u: asm-opnds-more (generalize-opnd u.opnd1) (asm-opnds-more (generalize-opnd u.opnd2) (asm-opnds-one (generalize-opnd u.opnd3)))
 | UA4 u: asm-opnds-more (generalize-opnd u.opnd1) (asm-opnds-more (generalize-opnd u.opnd2) (asm-opnds-more (generalize-opnd u.opnd3) (asm-opnds-one (generalize-opnd u.opnd4))))
 | UAF u: asm-opnds-one (asm-annotated (asm-ann-string (string-from-rope "flow")) (generalize-flow u.opnd1))
end

val generalize-flow opnd = case opnd of
   REL8 r: asm-rel (generalize-immediate 8 (sx r))
 | REL16 r: asm-rel (generalize-immediate 16 (sx r))
 | REL32 r: asm-rel (generalize-immediate 32 (sx r))
 | REL64 r: asm-rel (generalize-immediate 64 (sx r))
 | PTR16/16 p: generalize-immediate 8 (sx p)
 | PTR16/32 p: generalize-immediate 8 (sx p)
 | NEARABS o: asm-annotated (asm-ann-string (string-from-rope "nearabs")) (generalize-opnd o)
 | FARABS o: asm-annotated (asm-ann-string (string-from-rope "farabs")) (generalize-opnd o)
end

val generalize-opnd opnd = case opnd of
   IMM8 i: generalize-immediate 8 (zx i.imm)
 | IMM16 i: generalize-immediate 16 (zx i.imm)
 | IMM32 i: generalize-immediate 32 (zx i.imm)
 | IMM64 i: generalize-immediate 64 (zx i.imm)
 | REG r: generalize-register r
 | MEM m: generalize-memory m
 | X86_SUM s: asm-sum (generalize-opnd s.a) (generalize-opnd s.b)
 | X86_SCALE s: asm-scale (zx s.imm) (generalize-opnd s.opnd)
end

val generalize-immediate sz imm = asm-bounded (asm-boundary-sz sz) (asm-imm imm)

val generalize-register r = let
  val rs = semantic-register-of r
in
  asm-bounded (asm-boundary-sz-o rs.size rs.offset) (asm-reg (string-from-rope (pretty-arch-id rs.id)))
end

val generalize-memory m =
  asm-bounded (asm-boundary-sz m.sz)
    (asm-mem ((generalize-segment-override m.segment)
      (asm-bounded (asm-boundary-sz m.psz)
        (generalize-opnd m.opnd)
)))

val generalize-segment-override so = case so of
   SEG_NONE: let val f o = o in f end
# | SEG_OVERRIDE o: let
#     val f o = (asm-annotation (asm-ann-opnd "segment" generalize-register so.register) o)
#   in f end
end

