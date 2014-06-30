val registers-live-map = let #Todo: Segment base addresses
  val ++- map reg-sem = 
    fmap-add-range map reg-sem.id reg-sem.size reg-sem.offset
  val ++ map r = map ++- semantic-register-of r
in
  fmap-empty 
  ++ RAX
  ++ RBX
  ++ RCX
  ++ RDX
  ++ R8
  ++ R9
  ++ R10
  ++ R11
  ++ R12
  ++ R13
  ++ R14
  ++ R15
  ++ RSP
  ++ RBP
  ++ RSI
  ++ RDI
  ++ YMM0
  ++ YMM1
  ++ YMM2
  ++ YMM3
  ++ YMM4
  ++ YMM5
  ++ YMM6
  ++ YMM7
  ++ YMM8
  ++ YMM9
  ++ YMM10
  ++ YMM11
  ++ YMM12
  ++ YMM13
  ++ YMM14
  ++ YMM15
  ++ MM0
  ++ MM1
  ++ MM2
  ++ MM3
  ++ MM4
  ++ MM5
  ++ MM6
  ++ MM7
  ++ ES
  ++ SS
  ++ DS
  ++ FS
  ++ GS
  ++ CS
  ++ ST0
  ++ ST1
  ++ ST2
  ++ ST3
  ++ ST4
  ++ ST5
  ++ ST6
  ++ ST7
  ++ RIP

  ++ FLAGS
  ++- {id=VIRT_LES,offset=0,size=1}
  ++- {id=VIRT_LEU,offset=0,size=1}
  ++- {id=VIRT_LTS,offset=0,size=1}
end
