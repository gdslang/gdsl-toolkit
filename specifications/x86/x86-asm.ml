export generalize : (insndata) -> asm-insn

val generalize insn = asm-insn insn.length (string-from-rope (pretty-mnemonic insn)) (generalize-ua (uarity-of insn.insn))
  
val generalize-ua ua = case ua of
   UA0: asm-opnds-none
 | UA1 u: asm-opnds-one (generalize-opnd '0' u.opnd1)
 | UA2 u: asm-opnds-more (generalize-opnd '0' u.opnd1) (asm-opnds-one (generalize-opnd '0' u.opnd2))
 | UA3 u: asm-opnds-more (generalize-opnd '0' u.opnd1) (asm-opnds-more (generalize-opnd '0' u.opnd2) (asm-opnds-one (generalize-opnd '0' u.opnd3)))
 | UA4 u: asm-opnds-more (generalize-opnd '0' u.opnd1) (asm-opnds-more (generalize-opnd '0' u.opnd2) (asm-opnds-more (generalize-opnd '0' u.opnd3) (asm-opnds-one (generalize-opnd '0' u.opnd4))))
 | UAF u: asm-opnds-one (asm-annotated (asm-ann-string (string-from-rope "flow")) (generalize-flow u.opnd1))
end

val generalize-flow opnd = case opnd of
   REL8 r: asm-rel (generalize-immediate 8 (sx r))
 | REL16 r: asm-rel (generalize-immediate 16 (sx r))
 | REL32 r: asm-rel (generalize-immediate 32 (sx r))
 | REL64 r: asm-rel (generalize-immediate 64 (sx r))
 | PTR16/16 p: generalize-immediate 8 (sx p)
 | PTR16/32 p: generalize-immediate 8 (sx p)
 | NEARABS o: asm-annotated (asm-ann-string (string-from-rope "nearabs")) (generalize-opnd '0' o)
 | FARABS o: asm-annotated (asm-ann-string (string-from-rope "farabs")) (generalize-opnd '0' o)
end

val generalize-opnd signed opnd = case opnd of
   IMM8 i: generalize-immediate-off 8 i.address (if signed then sx i.imm else zx i.imm)
 | IMM16 i: generalize-immediate-off 16 i.address (if signed then sx i.imm else zx i.imm)
 | IMM32 i: generalize-immediate-off 32 i.address (if signed then sx i.imm else zx i.imm)
 | IMM64 i: generalize-immediate-off 64 i.address (if signed then sx i.imm else zx i.imm)
 | REG r: generalize-register r
 | MEM m: generalize-memory m
 | X86_SUM s: asm-sum (generalize-opnd signed s.a) (generalize-opnd signed s.b)
 | X86_SCALE s: asm-scale (zx s.imm) (generalize-opnd signed s.opnd)
end

val generalize-immediate sz imm = asm-bounded (asm-boundary-sz sz) (asm-imm imm)
val generalize-immediate-off sz addr imm = asm-bounded (asm-boundary-sz-o sz addr) (asm-imm imm)
#val generalize-imm-signed sz imm = asm-signed (asm-bounded (asm-boundary-sz sz) (asm-imm imm))
#val generalize-imm-unsigned sz imm = asm-unsigned (asm-bounded (asm-boundary-sz sz) (asm-imm imm))

val generalize-register r = let
  val rs = semantic-register-of r
in
  asm-bounded (asm-boundary-sz-o rs.size rs.offset) (asm-reg (string-from-rope (pretty-arch-id rs.id)))
end

val generalize-memory m =
  asm-bounded (asm-boundary-sz m.sz)
    (asm-mem ((generalize-segment-override m.segment)
      (asm-bounded (asm-boundary-sz m.psz)
        (generalize-opnd '1' m.opnd)
)))

val generalize-segment-override so = case so of
   SEG_NONE: let val f o = o in f end
 | SEG_OVERRIDE over: let
     val f o = asm-annotated (asm-ann-opnd (string-from-rope "segment") (generalize-register
       over)) o
   in f end
end

