export translate: (insndata) -> S sem_stmt_list <{} => {}>

val translate insn = do
  update@{stack=SEM_NIL, tmp=0};

  translate-arm7 insn;

  stack <- query $stack;
  return (rreil-stmts-rev stack)
end

val translate-block-single insn = do
  ic <- query $ins_count;
  update@{tmp=0, ins_count=ic+1};

  translate-arm7 insn
end

val translate-arm7 insn = semantics insn

val relative-next stmts = let
  val is_sem_ip x = case x of
      Sem_PC: '1'
    | _: '0'
  end
in
  relative-next-generic is_sem_ip stmts
end

type instructionset =
    InstrSet_ARM
  | InstrSet_Thumb
  | InstrSet_Jazelle
  | InstrSet_ThumbEE

type signedness =
    Signed
  | Unsigned

val lval x =
  case x of
      REGISTER r: return (semantic-register-of r)
  end

val rvals-c sign x setcarry = let
  val from-vec sn vector =
    case sn of
        Signed: imm (sx vector)
      | Unsigned: imm (zx vector)
    end
  val from-imm sn immediate setcarry =
    case immediate of
        IMMi i: return (imm i)
      | IMM2 i: return (from-vec sn i)
      | IMM3 i: return (from-vec sn i)
      | IMM4 i: return (from-vec sn i)
      | IMM5 i: return (from-vec sn i)
      | IMM6 i: return (from-vec sn i)
      | IMM8 i: return (from-vec sn i)
      | IMM12 i: return (from-vec sn i)
      | IMM16 i: return (from-vec sn i)
      | IMM24 i: return (from-vec sn i)
      | MODIMM i: do
          expanded <- return (armexpandimm-c i 0);
          if setcarry then
            mov 1 fCF (imm expanded.carry_out)
          else
            return void
          ;
          return (imm expanded.result)
        end
    end
in
  case x of
      IMMEDIATE i: from-imm sign i setcarry
    | REGISTER r: return (var (semantic-register-of r))
    | SHIFTED_OPERAND r: do
        shift-operand 32 r.opnd r.shift setcarry;
        rvals sign r.opnd
      end
  end
end

val rvals sign x = rvals-c sign x '0'

val rval-c x setcarry = rvals-c Unsigned x setcarry
val rval x = rvals Unsigned x

val shift-operand sz opnd shift setcarry = let
  val sem-shift samount stype = do
    amount <- case samount of
        REGISTER r: return (var (varl 8 (semantic-register-of r)))
      | _: rval-c samount setcarry
    end;
    sem_opnd <- lval opnd;
    case stype of
        LSL: sem-lsl sz sem_opnd amount setcarry
      | LSR: sem-lsr-asr sz sem_opnd amount shr setcarry
      | ASR: sem-lsr-asr sz sem_opnd amount shrs setcarry
      | ROR: sem-ror sz sem_opnd amount setcarry
      | RRX: sem-rrx sz sem_opnd (var fCF) setcarry
    end
  end
in
  case shift.amount of
      IMMEDIATE i:
        if is-zero? i then
          case shift.shifttype of
              ROR: sem-shift shift.amount RRX
            | LSR: sem-shift (opnd-from-int 32) LSR
            | ASR: sem-shift (opnd-from-int 32) ASR
            | _: return void
          end  # See [[A8.4.3]] DecodeImmShift()
        else
          sem-shift shift.amount shift.shifttype
    | _: sem-shift shift.amount shift.shifttype
  end
end

val semantics insn = let
  val conditional translator x =
    _if (condition-passed? x.cond) _then
      translator x
in
  case insn.insn of
      ADC x: conditional sem-adc x
    | ADD x: conditional sem-add x
    | ADR x: conditional sem-adr x
    | AND x: conditional sem-and x
    | BIC x: conditional sem-bic x
    | CMN x: conditional sem-cmn x
    | CMP x: conditional sem-cmp x
    | EOR x: conditional sem-eor x
    | MOV x: conditional sem-mov x
    | MVN x: conditional sem-mvn x
    | ORR x: conditional sem-orr x
    | RSB x: conditional sem-rsb x
    | RSC x: conditional sem-rsc x
    | SBC x: conditional sem-sbc x
    | SUB x: conditional sem-sub x
    | TEQ x: conditional sem-teq x
    | TST x: conditional sem-tst x
    | MLA x: conditional sem-mla x
    | MLS x: conditional sem-mls x
    | MUL x: conditional sem-mul x
    # | SMLABB x: conditional sem-smlabb x
    # | SMLABT x: conditional sem-smlabt x
    # | SMLATB x: conditional sem-smlatb x
    # | SMLATT x: conditional sem-smlatt x
    # | SMLAD x: conditional sem-smlad x
    # | SMLADX x: conditional sem-smladx x
    | SMLAL x: conditional sem-smlal x
    # | SMLALBB x: conditional sem-smlalbb x
    # | SMLALBT x: conditional sem-smlalbt x
    # | SMLALTB x: conditional sem-smlaltb x
    # | SMLALTT x: conditional sem-smlaltt x
    # | SMLALD x: conditional sem-smlald x
    # | SMLALDX x: conditional sem-smlaldx x
    # | SMLAWB x: conditional sem-smlawb x
    # | SMLAWT x: conditional sem-smlawt x
    # | SMLSD x: conditional sem-smlsd x
    # | SMLSDX x: conditional sem-smlsdx x
    # | SMLSLD x: conditional sem-smlsld x
    # | SMLSLDX x: conditional sem-smlsldx x
    # | SMMLA x: conditional sem-smmla x
    # | SMMLAR x: conditional sem-smmlar x
    # | SMMLS x: conditional sem-smmls x
    # | SMMLSR x: conditional sem-smmlsr x
    # | SMMUL x: conditional sem-smmul x
    # | SMMULR x: conditional sem-smmulr x
    # | SMUAD x: conditional sem-smuad x
    # | SMUADX x: conditional sem-smuadx x
    # | SMULBB x: conditional sem-smulbb x
    # | SMULBT x: conditional sem-smulbt x
    # | SMULTB x: conditional sem-smultb x
    # | SMULTT x: conditional sem-smultt x
    | SMULL x: conditional sem-smull x
    # | SMULWB x: conditional sem-smulwb x
    # | SMULWT x: conditional sem-smulwt x
    # | SMUSD x: conditional sem-smusd x
    # | SMUSDX x: conditional sem-smusdx x
    # | UMAAL x: conditional sem-umaal x
    # | UMLAL x: conditional sem-umlal x
    # | UMULL x: conditional sem-umull x
    # | SSAT x: conditional sem-ssat x
    # | SSAT16 x: conditional sem-ssat16 x
    # | USAT x: conditional sem-usat x
    # | USAT16 x: conditional sem-usat16 x
    # | QADD x: conditional sem-qadd x
    # | QSUB x: conditional sem-qsub x
    # | QDADD x: conditional sem-qdadd x
    # | QDSUB x: conditional sem-qdsub  x
    # | PKH x: conditional sem-pkh
    # | SXTAB x: condtional sem-sxtab x
    # | SXTAB16 x: conditional sem-sxtab16 x
    # | SXTAH x: conditional sem-sxtah x
    # | SXTB x: conditional sem-sxtb x
    # | SXTB16 x: conditional sem-sxtb16 x
    # | SXTH x: conditional sem-sxth x
    # | UXTAB x: condtional sem-uxtab x
    # | UXTAB16 x: conditional sem-uxtab16 x
    # | UXTAH x: conditional sem-uxtah x
    # | UXTB x: conditional sem-uxtb x
    # | UXTB16 x: conditional sem-uxtb16 x
    # | UXTH x: conditional sem-uxth x
    # | SADD16 x: conditional sem-sadd16 x
    # | QADD16 x: conditional sem-qadd16 x
    # | SHADD16 x: conditional sem-shadd16 x
    # | UADD16 x: conditional sem-uadd16 x
    # | UQADD16 x: conditional sem-uqadd16 x
    # | UHADD16 x: conditional sem-uhadd16 x
    # | SASX x: conditional sem-sasx x
    # | QASX x: conditional sem-qasx x
    # | SHASX x: conditional sem-shasx x
    # | UASX x: conditional sem-uasx x
    # | UQASX x: conditional sem-uqasx x
    # | UHASX x: conditional sem-uhasx x
    # | SSAX x: conditional sem-ssax x
    # | QSAX x: conditional sem-qsax x
    # | SHSAX x: conditioal sem-shsax x
    # | USAX x: conditional sem-usax x
    # | UQSAX x: conditional sem-uqsax x
    # | UHSAX x: conditional sem-uhsax x
    # | SSUB16 x: conditional sem-ssub16 x
    # | QSUB16 x: conditional sem-qsub16 x
    # | SHSUB16 x: conditional sem-shsub16 x
    # | USUB16 x: conditional sem-usub16 x
    # | UQSUB16 x: conditional sem-uqsub16 x
    # | UHSUB16 x: conditional sem-uhsub16 x
    # | SADD8 x: conditional sem-sadd8 x
    # | QADD8 x: conditional sem-qadd8 x
    # | SHADD8 x: conditional sem-shadd8 x
    # | UADD8 x: conditional sem-uadd8 x
    # | UQADD8 x: conditional sem-uqadd8 x
    # | UHADD8 x: conditional sem-uhadd8 x
    # | SSUB8 x: conditional sem-ssub8 x
    # | QSUB8 x: conditional sem-qsub8 x
    # | SHSUB8 x: conditional sem-shsub8 x
    # | USUB8 x: conditional sem-usub8 x
    # | UQSUB8 x: conditional sem-uqsub8 x
    # | UHSUB8 x: conditional sem-uhsub8 x
    # | SDIV x: conditional sem-sdiv x
    # | UDIV x: conditional sem-udiv x
    # | BFC x: conditional sem-bfc x
    # | BFI x: conditional sem-bfi x 
    # | CLZ x: conditional sem-clz x
    # | MOVT x: conditional sem-movt x
    # | RBIT x: conditional sem-rbit x
    # | REV x: conditional sem-rev x
    # | REV16 x: conditional sem-rev16 x
    # | REVSH x: conditional sem-revsh x
    # | SBFX x: conditional sem-sbfx x
    # | SEL x: conditional sem-sel x
    # | UBFX x: conditional sem-ubfx x
    # | USAD8 x: conditional sem-usad8 x
    # | USADA8 x: conditional sem-usada8 x
    # | MRS x: conditional sem-mrs x
    # | MSR x: conditional sem-msr x
    # | CPS x: conditional sem-cps x
    | LDR x: conditional sem-ldr x
    | LDRT x: conditional sem-ldrt x
    | LDRB x: conditional sem-ldrb x
    | LDRBT x: conditional sem-ldrbt x
    | LDRH x: conditional sem-ldrh x
    | LDRHT x: conditional sem-ldrht x
    | LDRSB x: conditional sem-ldrsb x
    | LDRSBT x: conditional sem-ldrsbt x
    | LDRSH x: conditional sem-ldrsh x
    | LDRSHT x: conditional sem-ldrsht x
    # | LDRD x: conditional sem-ldrd x
    # | LDREX x: conditional sem-ldrex x
    # | LDREXB x: conditional sem-ldrexb x
    # | LDREXD x: conditional sem-ldrexd x
    # | LDREXH x: conditional sem-ldrexh x
    | STR x: conditional sem-str x
    | STRT x: conditional sem-strt x
    | STRB x: conditional sem-strb x
    | STRBT x: conditional sem-strbt x
    | STRH x: conditional sem-strh x
    | STRHT x: conditional sem-strht x
    # | STRD x: conditional sem-strd x
    # | STREX x: conditional sem-strex x
    # | STREXB x: conditional sem-strexb x
    # | STREXD x: conditional sem-strexd x
    | LDM x: conditional sem-ldm x
    | LDMDA x: conditional sem-ldmda x
    | LDMDB x: conditional sem-ldmdb x
    | LDMIB x: conditional sem-ldmib x
    | POP x: conditional sem-ldm x
    | STM x: conditional sem-stm x
    | STMDA x: conditional sem-stmda x
    | STMDB x: conditional sem-stmdb x
    | STMIB x: conditional sem-stmib x
    | PUSH x: conditional sem-stm x
    | B x: conditional sem-b x
    | BL x: conditional sem-bl x
    | BLX x: conditional sem-blx x
    | BX x: conditional sem-bx x
    # | BXJ x: conditional sem-bxj x
    # | CLREX x: conditional sem-clrex x
    # | DBG x: conditional sem-dbg x
    # | DMB x: conditonal sem-dwb x
    # | DSB x: conditional sem-dsb x
    # | ISB x: conditional sem-isb x
    # | NOP x: conditional sem-nop x
    # | PLD x: conditional sem-pld x
    # | PLDW x: conditional sem-pldw x
    # | PLI x: conditional sem-pli x
    # | SETEND x: conditional sem-setend x
    # | SEV x: conditional sem-sev x
    # | SWP x: conditional sem-swp x
    # | SWPB x: conditonal sem-swpb x
    # | WFE x: conditional sem-wfe x
    # | WFI x: conditional sem-wfi x
    # | YIELD x: conditional sem-yield x
    | SVC x: conditional sem-svc x
    | BKPT x: conditional sem-bkpt x
    # | SMC x: conditional sem-smc x
    # | RFE x: conditional sem-rfe x
    # | SUBS x: conditional sem-subs x
    # | HVC x: conditional sem-hvc x
    # | ERET x: conditional sem-eret x
    # | LDMerur x: conditional sem-ldmerur x
    # | SRS x: conditional sem-srs x
    # | CDP x: conditional sem-cdp x
    # | CDP2 x: conditional sem-cdp2 x
    # | MCR x: conditional sem-mcr x
    # | MCR2 x: conditional sem-mcr2 x
    # | MCRR x: conditional sem-mcrr x
    # | MCRR2 x: conditional sem-mcrr2 x
    # | MRC x: conditional sem-mrc x
    # | MRC2 x: conditional sem-mrc2 x
    # | MRRC x: conditional sem-mrrc x
    # | MRRC2 x: conditional sem-mrrc2 x
    # | LDC x: conditional sem-ldc x
    # | LDC2 x: conditional sem-ldc2 x
    # | STC x: conditional sem-stc x
    # | STC2 x: conditional sem-stc2 x
    # | VLDMIA x: conditional sem-vldmia x
    # | VLDMDB x: conditional sem-vldmdb x
    # | VLDR x: conditional sem-vldr x
    # | VSTMIA x: conditional sem-vstmia x
    # | VSTMDB x: conditional sem-vstmdb x
    # | VSTR x: conditional sem-vstr x
    # | VLD1 x: conditional sem-vld1 x
    # | VLD1a x: conditional sem-vld1a x
    # | VLD2 x: conditional sem-vld2 x
    # | VLD2a x: conditional sem-vld2a x
    # | VLD3 x: conditional sem-vld3 x
    # | VLD3a x: conditional sem-vld3a x
    # | VLD4 x: conditonal sem-vld4 x
    # | VLD4a x: conditional sem-vld4a x
    # | VST1 x: conditional sem-vst1 x
    # | VST2 x: conditional sem-vst2 x
    # | VST3 x: conditional sem-vst3 x
    # | VST4 x: conditional sem-vst4 x
    # | VDUP x: consitional sem-vdup x
    # | VMOVacs x: conditional sem-vmovacs x
    # | VMOVsac x: conditional sem-vmovsac x
    # | VMOVacsp x: conditional sem-vmovacsp x
    # | VMOVspac x: conditional sem-vmovspac x
    # | VMOVacsp2 x: conditional sem-vmovacsp2 x
    # | VMOVspac2 x: conditional sem-vmovspac2 x
    # | VMOVacdwe x: conditional sem-vmovacdwe x
    # | VMOVdweac x: conditional sem-vmovdweac x
    # | VMRS x: conditional sem-vmrs x
    # | VMSR x: conditional sem-vmsr x
    # | VADDiasimd x: conditional sem-vaddiasimd x
    # | VADDfpasimd x: conditional sem-vaddfpasimd x
    # | VADDHN x: conditional sem-vaddhn x
    # | VADDL x: conditional sem-vaddl x
    # | VADDW x: conditional sem-vaddw x
    # | VHADD x: conditional sem-vhadd x
    # | VHSUB x: conditional sem-vhsub x
    # | VPADAL x: conditional sem-vpadal x
    # | VPADDi x: conditional sem-vpaddi x
    # | VPADDfp x: conditional sem-vpaddfp x
    # | VPADDL x: conditional sem-vpaddl x
    # | VRADDHN x: conditional sem-vraddhn x
    # | VRHADD x: conditional sem-vrhadd x
    # | VRSUBHN x: conditional sem-vrsubhn x
    # | VQADD x: conditonal sem-vqadd x
    # | VQSUB x: conditional sem-vqsub x
    # | VSUBiasimd x: conditional sem-vsubiasimd x
    # | VSUBfpasimd x: conditional sem-vsubfpasimd x
    # | VSUBHN x: conditional sem-vsubhn x
    # | VSUBL x: conditional sem-vsubl x
    # | VSUBW x: conditional sem-vsubw x
    # | VAND x: conditional sem-vand x
    # | VBIC x: conditional sem-vbic x
    # | VEOR x: conditional sem-veor x
    # | VBIF x: conditional sem-vbif x
    # | VBIT x: conditional sem-vbit x
    # | VBSL x: conditional sem-vbsl x
    # | VMOVimmasimd x: conditional sem-vmovimmasimd x
    # | VMOVregasimd x: conditional sem-vmovregasimd x
    # | VMVN x: conditional sem-vmvn x
    # | VORR x: conditional sem-vorr x
    # | VORN x: conditional sem-vorn x
    # | VACGE x: conditional sem-vacge x
    # | VACGT x: conditional sem-vacgt x
    # | VCEQrega x: conditional sem-vceqrega x
    # | VCEQregb x: conditional sem-vceqregb x
    # | VCEQimm x: conditional sem-vceqimm x
    # | VCGTrega x: conditional sem-vcgtrega x
    # | VCGTregb x: conditional sem-vcgtregb x
    # | VCGTimm x: conditional sem-vcgtimm x
    # | VCLE x: conditional sem-vcle x
    # | VCLT x: conditional sem-vclt x
    # | VTST x: conditional sem-vtst x
    # | VQRSHL x: conditional sem-vqrshl x
    # | VQRSHRN x: conditional sem-vqshrn x
    # | YQRSHRUN x: conditional sem-vqrshrun x
    # | VRSHL x: conditional sem-vrshl x
    # | VRSHR x: conditional sem-vrshr x
    # | VRSRA x: conditional sem-vrsra x
    # | VRSHRN x: conditional sem-vrshrn x
    # | VSHLimm x: conditional sem-vshlimm x
    # | VSHLreg x: conditional sem-vshlreg x
    # | VSHLL x: conditional sem-vshll x
    # | VSHR x: conditional sem-vshr x
    # | VSHRN x: conditional sem-vshrn x
    # | VSLI x: conditional sem-vsli x
    # | VSRA x: conditional sem-vsra x
    # | VSRI x: conditional sem-vsri x
    # | VMLAiasimd x: conditional sem-vmlaiasimd x
    # | VMLAfpasimd x: conditional sem-vmlafpasimd x
    # | VMLAsasimd x: conditional sem-vmlasasimd x
    # | VMLAL x: conditional sem-vmlal x
    # | VMLSiasimd x: conditional sem-vmlsiasimd x
    # | VMLSfpasimd x: conditional sem-vmlsfpasimd x
    # | VMLSsasimd x: conditional sem-vmlssasimd x
    # | VMLSL x: conditional sem-vmlsl x
    # | VMULipasimd x: conditional sem-vmulipasimd x
    # | VMULfpasimd x: conditional sem-vmulfpasimd x
    # | VMULsasimd x: conditional sem-vmulsasimd x
    # | VMULLipasimd x: conditional sem-vmullipasimd x
    # | VMULLsasimd x: conditional sem-vmullsasimd x
    # | VFMA x: conditional sem-vfma x
    # | VFMS x: conditional sem-vfms x
    # | VQDMLAL x: conditional sem-vqdmlal x
    # | VQDMLSL x: conditional sem-vqmdlsl x
    # | VQDMULH x: conditionla sem-vqdmulh x
    # | VQRDMULH x: conditional sem-vqrdmulh x
    # | VQDMULL x: conditional sem-vqdmull x
    # | VABA x: conditional sem-vaba x
    # | VABAL x: conditional sem-vabal x
    # | VABDi x: conditional sem-vabdi x
    # | VABDfp x: conditional sem-vabdfp x
    # | VABDL x: conditional sem-vabdl x
    # | VABSasimd x: conditional sem-vabsasimd x
    # | VCVTfpiasimd x: conditional sem-vcvtfpiasimd x
    # | VCVTfpfpasimd x: conditional sem-vcvtfpfpasimd x
    # | VCVThpspasimd x: conditional sem-vcvthpspasimd x
    # | VCLS x: conditional sem-vcls x 
    # | VCLZ x: conditional sem-vclz x
    # | VCNT x: conditional sem-vcnt x
    # | VDUP2 x: conditional sem-vdup2 x
    # | VEXT x: conditional sem-vext x
    # | VMOVN x: conditional sem-vmovn x
    # | VMOVL x: conditional sem-vmovl x
    # | VMAXi x: conditional sem-vmaxi x
    # | VMAXfp x: conditional sem-vmaxfp x
    # | VMINi x: conditional sem-vmini x
    # | VMINfp x: conditional sem-vminfp x
    # | VNEGasimd x: conditional sem-vnegasimd x
    # | VPMAXi x: conditional sem-vpmaxi x
    # | VPMAXfp x: conditional sem-vpmaxfp x
    # | VPMINi x: conditional sem-vpmini x
    # | VPMINfp x: conditional sem-vpminfp x
    # | VRECPE x: conditional sem-vrecpe x
    # | VRECPS x: conditional sem-vrecps x
    # | VRSQRTE x: conditional sem-vrsqrte x
    # | VRSQRTS x: conditional sem-vrsqrts x
    # | VREV16 x: conditional sem-vrev16 x
    # | VREV32 x: conditional sem-vrev32 x
    # | VREV64 x: conditional sem-vrev64 x
    # | VQABS x: conditional sem-vqabs x
    # | VQMOVN x: conditional sem-vqmovn x
    # | VQMOVUN x: conditional sem-vqmovun x
    # | VQNEG x: conditional sem-vqneg x
    # | VSWP x: conditional sem-vswp x
    # | VTBL x: conditional sem-vtbl x
    # | VTBX x: conditional sem-vtbx x
    # | VTRN x: conditional sem-vtrn x
    # | VUZP x: conditional sem-vuzp x
    # | VZIP x: conditional sem-vzip x
    # | VABSfp x: conditional sem-vabsfp x
    # | VADDfpfp x: conditional sem-vaddfpfp x
    # | VCMP x: conditional sem-vcmp x
    # | VCMPE x: conditional sem-vcmpe x
    # | VCVTfpifp x: conditional sem-vvtfpifp x
    # | VCVTfpfpfp x: conditional sem-vcvtfpfpfp x
    # | VCVTdpspfp x: conditional sem-vcvtdpspfp x
    # | VCVTR x: conditional sem-vcvtr x
    # | VCVTB x: conditional sem-vcvtb x
    # | VCVTT x: conditional sem-vcvtt x
    # | VDIV x: conditional sem-vdiv x
    # | VMLAfpfp x: conditional sem-vmlafpfp x
    # | VMLSfpfp x: conditional sem-vmlsfpfp x
    # | VMOVimmfp x: conditional sem-vmovimmfp x
    # | VMOVregfp x: conditional sem-vmovregfp x
    # | VMULfpfp x: conditional sem-vmulfpfp x
    # | VNEGfp x: conditional sem-vnegfp x
    # | VNMLA x: conditional sem-vnmla x
    # | VNMLS x: conditional sem-vnmls x
    # | VNMUL x: conditional sem-vnmul x
    # | VFNMA x: conditional sem-vfnma x
    # | VFNMS x: conditional sem-vfnms x
    # | VSQRT x: conditional sem-vsqrt x
    # | VSUBfpfp x: conditional sem-vsubfpfp x
    | _: sem-default insn.insn insn.ip
  end
end

# ----------------------------------------------------------------------
# Utility functions
# ----------------------------------------------------------------------

# Program Counter register (PC/IP)
val get-sem-pc = lval (register R15)

# Stack Pointer register (SP)
val get-sem-sp = lval (register R13)

# Link register (LR)
val get-sem-lr = lval (register R14)

val is-sem-pc? sem_reg =
  case sem_reg.id of
      Sem_PC: '1'
    | _: '0'
  end

val is-sem-sp? sem_reg =
  case sem_reg.id of
      Sem_SP: '1'
    | _: '0'
  end

val instr-set-arm? = /eq 1 (var isetstate) (imm 0)
val instr-set-thumb? = /eq 1 (var isetstate) (imm 1)
val instr-set-jazelle? = /eq 1 (var isetstate) (imm 2)
val instr-set-thumbee? = /eq 1 (var isetstate) (imm 3)

val select-instr-set iset =
  case iset of
      InstrSet_ARM: mov isetstate.size isetstate (imm 0)
    | InstrSet_Thumb: mov isetstate.size isetstate (imm 1)
    | InstrSet_Jazelle: mov isetstate.size isetstate (imm 2)
    | InstrSet_ThumbEE: mov isetstate.size isetstate (imm 3)
  end

val condition-passed? cond =
  case cond of
      EQ: /eq 1 (var fZF) (imm 1)
    | NE: /eq 1 (var fZF) (imm 0)
    | CS: /eq 1 (var fCF) (imm 1)
    | CC: /eq 1 (var fCF) (imm 0)
    | MI: /eq 1 (var fNF) (imm 1)
    | PL: /eq 1 (var fNF) (imm 0)
    | VS: /eq 1 (var fVF) (imm 1)
    | VC: /eq 1 (var fVF) (imm 0)
    | HI: /and (/eq 1 (var fCF) (imm 1)) (/eq 1 (var fZF) (imm 0))
    | LS: /and (/eq 1 (var fCF) (imm 0)) (/eq 1 (var fZF) (imm 1))
    | GE: /eq 1 (var fNF) (var fVF)
    | LT: /neq 1 (var fNF) (var fVF)
    | GT: /and (/eq 1 (var fZF) (imm 0)) (/eq 1 (var fNF) (var fVF))
    | LE: /and (/eq 1 (var fZF) (imm 1)) (/neq 1 (var fNF) (var fVF))
    | AL: const 1
    | NV: const 1
  end

# --- Simplyfied jumps (without Thumb/ThumbEE/Jazelle handling) --------

# align lvalue to multiple of num_bytes
val align sz lhs rhs num_bytes =
  andb lhs.size lhs rhs (imm ((power 2 sz) - num_bytes))

val branch-to target = jump (address 32 (var target))

# simple branch [[A2.3.2]]
val branch-write-pc addr = do
  align 32 addr (var addr) 4;
  branch-to addr
end

# interworking branch (instruction set switch) [[A2.3.2]]
val bx-write-pc addr = branch-to addr

# architecture version specific branch [[A2.3.2]]
val load-write-pc addr = bx-write-pc addr

# instrset/arch version specific branch [[A2.3.2]]
val alu-write-pc addr = bx-write-pc addr

# --- Flag handling ----------------------------------------------------

# set the N flag, if the result is negative.
val emit-flag-n result = cmplts 32 fNF result (imm 0)

# set the Z flag, if the result is zero.
val emit-flag-z result = cmpeq 32 fZF result (imm 0)

val emit-flags-nz result setflags = do
  if setflags then do
    emit-flag-n result;
    emit-flag-z result
  end else
    return void
end

val emit-add-adc-flags sz sum x y setflags = do
  emit-flags-nz (var sum) setflags;

  if setflags then do
    t1 <- mktemp;
    t2 <- mktemp;
    t3 <- mktemp;

    # Set the C flag in case of unsigned overflow (carry).
    cmpltu sz fCF (var sum) x;

    # Set the V flag in case of signed overflow.
    xorb sz t1 (var sum) x;
    xorb sz t2 (var sum) y;
    andb sz t3 (var t1) (var t2);
    cmplts sz fVF (var t3) (imm 0)
  end else
    return void
end

val emit-sub-sbc-flags sz difference x y setflags = do
  minus_y <- mktemp;
  xorb 32 minus_y y (imm 0); # 2 complement
  add 32 minus_y (var minus_y) (imm 1);

  emit-add-adc-flags sz difference x y setflags
end

val emit-rsb-rsc-flags sz difference x y setflags =
  emit-sub-sbc-flags sz difference y x setflags

# --- Shift/rotate functions -------------------------------------------

# logic shift left
val sem-lsl sz opnd shiftamount setcarry = do
  shift_minus_one <- return (lin-diff shiftamount (imm 1));

  shl sz opnd (var opnd) shift_minus_one;

  if setcarry then
    mov 1 fCF (var (at-offset opnd (sz - 1)))
  else
    return void
  ;

  shl sz opnd (var opnd) (imm 1)
end

# logic or arithmetic shift right
val sem-lsr-asr sz opnd shiftamount shiftop setcarry = do
  shift_minus_one <- return (lin-diff shiftamount (imm 1));

  shiftop sz opnd (var opnd) shift_minus_one;

  if setcarry then
    mov 1 fCF (var opnd)
  else
    return void
  ;

  shiftop sz opnd (var opnd) (imm 1)
end

# rotate operand register by register or immediate [[A2.2.1]]
val sem-ror sz opnd shiftamount setcarry = do
  m <- mktemp;
  mod sz m shiftamount (imm opnd.size); # in case shift > 32

  right <- mktemp;
  left <- mktemp;

  shr sz right (var opnd) (var m);
  shl sz left (var opnd) (lin-diff (imm sz) (var m));

  orb sz opnd (var left) (var right);

  if setcarry then do
    mov 1 fCF (var (at-offset opnd (sz - 1))) # msb = carry_out
  end else
    return void
end

(* TODO: Merge sem-ror with sem-rrx *)

# rotate the opnd right by one and append carry_in as msb [[A2.2.1]]
val sem-rrx sz opnd carry_in setcarry = do
  if setcarry then
    mov 1 fCF (var opnd)
  else
    return void
  ;

  t0 <- mktemp;

  shr sz opnd (var opnd) (imm 1);
  shl sz t0 (carry_in) (imm (sz - 1));
  orb sz opnd (var opnd) (var t0)
end

# --- load/store helper functions --------------------------------------

val cwrite sz target addr cond = do
  if cond then
    mov sz target addr
  else
    return void
end

val str sz value asz postidx_addr preidx_addr indexed? = do
  if indexed? then
    store sz (address asz postidx_addr) value
  else
    store sz (address asz preidx_addr) value
end

val lin-diff x y = SEM_LIN_SUB {opnd1=x, opnd2=y}

val combine-vars x y add = return (if add then lin-sum x y else lin-diff x y)

val load-operands opndsz opndlist addrsz target_addr = let
  val load-operand opnd addr offset =
    case opnd of
        OPERAND_LIST l: load-operandlist l addr offset
      | _: do
          dst <- lval opnd;
          load opndsz dst addrsz (lin-sum (var addr) (imm offset))
        end
    end
  val load-operandlist opndl addr start_offset =
    case opndl of
        OPNDL_NIL: return void
      | OPNDL_CONS c: do
          load-operand c.hd addr start_offset;
          load-operandlist c.tl addr (start_offset + (/z addrsz 8))
        end
    end
in
  load-operand opndlist target_addr 0
end

val store-operands opndsz opndlist addrsz target_addr = let
  val store-operand opnd addr offset =
    case opnd of
        OPERAND_LIST l: store-operandlist l addr offset
      | _: do
          src <- rval opnd;
          dst <- combine-vars (var addr) (imm offset) (not (is-sem-sp? addr));
          store opndsz (address addrsz dst) src
        end
    end
  val store-operandlist opndl addr start_offset =
    case opndl of
        OPNDL_NIL: return void
      | OPNDL_CONS c: do
          store-operand c.hd addr start_offset;
          store-operandlist c.tl addr (start_offset + (/z addrsz 8))
        end
    end
in
  store-operand opndlist target_addr 0
end

# --- vector helper functions / type definitions -----------------------

### [A7.2.4]
type ext-register-width =
      Single
    | Double
    | Quad

### [A7.3]
val decode-ext-register size x = case size of
      Single : single-ext-register-of-int (zx (x.remainder^x.first))
    | Double : double-ext-register-of-int (zx (x.first^x.remainder))
    | Quad   : quad-ext-register-of-int (zx (x.first^x.remainder))
end

val single-ext-register-of-int number = case number of
      0  : S0
    | 1  : S1
    | 2  : S2
    | 3  : S3
    | 4  : S4
    | 5  : S5
    | 6  : S6
    | 7  : S7
    | 8  : S8
    | 9  : S9
    | 10 : S10
    | 11 : S11
    | 12 : S12
    | 13 : S13
    | 14 : S14
    | 15 : S15
    | 16 : S16
    | 17 : S17
    | 18 : S18
    | 19 : S19
    | 20 : S20
    | 21 : S21
    | 22 : S22
    | 23 : S23
    | 24 : S24
    | 25 : S25
    | 26 : S26
    | 27 : S27
    | 28 : S28
    | 29 : S29
    | 30 : S30
    | 31 : S31
end

val double-ext-register-of-int number = case number of
      0  : D0
    | 1  : D1
    | 2  : D2
    | 3  : D3
    | 4  : D4
    | 5  : D5
    | 6  : D6
    | 7  : D7
    | 8  : D8
    | 9  : D9
    | 10 : D10
    | 11 : D11
    | 12 : D12
    | 13 : D13
    | 14 : D14
    | 15 : D15
    | 16 : D16
    | 17 : D17
    | 18 : D18
    | 19 : D19
    | 20 : D20
    | 21 : D21
    | 22 : D22
    | 23 : D23
    | 24 : D24
    | 25 : D25
    | 26 : D26
    | 27 : D27
    | 28 : D28
    | 29 : D29
    | 30 : D30
    | 31 : D31
end

val quad-ext-register-of-int number = case number of
      0  : Q0
    | 1  : Q0
    | 2  : Q1
    | 3  : Q1
    | 4  : Q2
    | 5  : Q2
    | 6  : Q3
    | 7  : Q3
    | 8  : Q4
    | 9  : Q4
    | 10 : Q5
    | 11 : Q5
    | 12 : Q6
    | 13 : Q6
    | 14 : Q7
    | 15 : Q7
    | 16 : Q8
    | 17 : Q8
    | 18 : Q9
    | 19 : Q9
    | 20 : Q10
    | 21 : Q10
    | 22 : Q11
    | 23 : Q11
    | 24 : Q12
    | 25 : Q12
    | 26 : Q13
    | 27 : Q13
    | 28 : Q14
    | 29 : Q14
    | 30 : Q15
    | 31 : Q15
end

val semantic-vector size x = semantic-ext-register-of (decode-ext-register size x) 

val vval size x = return (semantic-vector size x)

# --- scalar helper functions / type definitions -----------------------

type scalar-length =
      Byte
    | Halfword
    | Word
    | Doubleword

val semantic-scalar esize index size x = let
    val base = semantic-ext-register-of (decode-ext-register size x)
in
    case esize of
          Byte       : {id=base.id, offset=(base.offset + 8 * index), size=8}
        | Halfword   : {id=base.id, offset=(base.offset + 16 * index), size=16}
        | Word       : {id=base.id, offset=(base.offset + 32 * index), size=32}
        | Doubleword : {id=base.id, offset=(base.offset + 64 * index), size=64}
    end
end

val sval esize index size x = return (semantic-scalar esize index size x)

# ----------------------------------------------------------------------
# Individual instruction translators
# ----------------------------------------------------------------------

val sem-b x = do
  offset <- rval x.opnd;
  pc <- get-sem-pc;
  jump (address 32 (lin-sum (var pc) offset))
end

val sem-bl x = do
  offset <- rval x.opnd;
  pc <- get-sem-pc;
  lr <- get-sem-lr;

  sub 32 lr (var pc) (imm 4);
  call (address 32 (lin-sum (var pc) offset))
end

val sem-blx x =
  case x.opnd of
      IMMEDIATE i: sem-bl x
    | REGISTER r: do
        target <- rval x.opnd;
        pc <- get-sem-pc;
        lr <- get-sem-lr;

        sub 32 lr (var pc) (imm 4);
        call (address 32 target)
      end
  end

val sem-bx x = do
  m <- rval x.opnd;
  jump (address 32 m)
end

val sem-adc x = do
  rn <- rval x.opnd1;
  rd <- lval x.opnd2;
  opnd2 <- rval x.opnd3;

  add 32 rd rn opnd2;
  add 32 rd (var rd) (var fCF);

  if is-sem-pc? rd then do
    alu-write-pc rd
  end else
    emit-add-adc-flags 32 rd rn opnd2 x.o
end

val sem-add x = do
  rn <- rval x.opnd1;
  rd <- lval x.opnd2;
  opnd2 <- rval x.opnd3;

  add 32 rd rn opnd2;

  if is-sem-pc? rd then do
    alu-write-pc rd
  end else
    emit-add-adc-flags 32 rd rn opnd2 x.o
end

val sem-adr x = do
    rn <- rval x.opnd1;
    rd <- lval x.opnd2;
    opnd2 <- rval x.opnd3;

    if x.o then do
        add 32 rd rn opnd2
    end else
        sub 32 rd rn opnd2;

    if is-sem-pc? rd then do
        alu-write-pc rd
    end else
        return void
end

val sem-and x = do
  rn <- rval x.opnd1;
  rd <- lval x.opnd2;
  opnd2 <- rval-c x.opnd3 x.o; # update carry!

  andb 32 rd rn opnd2;

  if is-sem-pc? rd then do
    alu-write-pc rd
  end else
    emit-flags-nz (var rd) x.o
end

val sem-bic x = do
  rd <- lval x.opnd2;
  rn <- rval x.opnd1;
  opnd2 <- rval-c x.opnd3 x.o; # update carry!
  not_opnd2 <- mktemp;

  xorb 32 not_opnd2 opnd2 (imm 0);
  andb 32 rd rn (var not_opnd2);

  if is-sem-pc? rd then
    alu-write-pc rd
  else
    emit-flags-nz (var rd) x.o
end

val sem-cmn x = do
  rn <- rval x.opnd1;
  opnd2 <- rval x.opnd3;
  cmn_result <- mktemp;

  add 32 cmn_result rn opnd2;

  emit-add-adc-flags 32 cmn_result rn opnd2 '1'
end

val sem-cmp x = do
  rn <- rval x.opnd1;
  opnd2 <- rval x.opnd3;
  cmp_result <- mktemp;

  sub 32 cmp_result rn opnd2;

  emit-sub-sbc-flags 32 cmp_result rn opnd2 '1'
end

val sem-eor x = do
  rd <- lval x.opnd2;
  rn <- rval x.opnd1;
  opnd2 <- rval-c x.opnd3 x.o; # update carry!

  xorb 32 rd rn opnd2;

  if is-sem-pc? rd then
    alu-write-pc rd
  else
    emit-flags-nz (var rd) x.o
end

val sem-mov x = do
  rd <- lval x.opnd2;
  opnd2 <- rval-c x.opnd3 x.o;

  mov 32 rd opnd2;

  if is-sem-pc? rd then
    alu-write-pc rd
  else
    emit-flags-nz (var rd) x.o
end

val sem-mvn x = do
  rd <- lval x.opnd2;
  opnd2 <- rval-c x.opnd3 x.o; # update carry!

  xorb 32 rd opnd2 (imm 0); # NOT (opnd2)

  if is-sem-pc? rd then
    alu-write-pc rd
  else
    emit-flags-nz (var rd) x.o
end

val sem-orr x = do
  rd <- lval x.opnd2;
  rn <- rval x.opnd1;
  opnd2 <- rval-c x.opnd3 x.o; # update carry!

  orb 32 rd rn opnd2;

  if is-sem-pc? rd then
    alu-write-pc rd
  else
    emit-flags-nz (var rd) x.o
end

val sem-rsb x = do
  rd <- lval x.opnd2;
  rn <- rval x.opnd1;
  opnd2 <- rval x.opnd3;

  sub 32 rd opnd2 rn;

  if is-sem-pc? rd then
    alu-write-pc rd
  else
    emit-rsb-rsc-flags 32 rd opnd2 rn x.o
end

val sem-rsc x = do
  rd <- lval x.opnd2;
  rn <- rval x.opnd1;
  opnd2 <- rval x.opnd3;

  sub 32 rd opnd2 rn;
  sub 32 rd (var rd) (var fCF);

  if is-sem-pc? rd then
    alu-write-pc rd
  else
    emit-rsb-rsc-flags 32 rd opnd2 rn x.o
end

val sem-sbc x = do
  rd <- lval x.opnd1; # opnd2?
  rn <- rval x.opnd1;
  opnd2 <- rval x.opnd3;

  sub 32 rd rn opnd2;
  sub 32 rd (var rd) (var fCF);

  if is-sem-pc? rd then
    alu-write-pc rd
  else
    emit-sub-sbc-flags 32 rd rn opnd2 x.o
end

val sem-sub x = do
  rd <- lval x.opnd2;
  rn <- rval x.opnd1;
  opnd2 <- rval x.opnd3;

  sub 32 rd rn opnd2;

  if is-sem-pc? rd then
    alu-write-pc rd
  else
    emit-sub-sbc-flags 32 rd rn opnd2 x.o
end

val sem-tst x = do
  rn <- rval x.opnd1;
  opnd2 <- rval-c x.opnd3 '1'; # update carry!
  tst_result <- mktemp;

  andb 32 tst_result rn opnd2;

  emit-flags-nz (var tst_result) '1'
end

val sem-teq x = do
  rn <- rval x.opnd1;
  opnd2 <- rval-c x.opnd3 '1'; # update carry!
  teq_result <- mktemp;

  xorb 32 teq_result rn opnd2;

  emit-flags-nz (var teq_result) '1'
end

val sem-mla x = do
  result <- lval x.opnd1;
  opnd1 <- rval x.opnd4;
  opnd2 <- rval x.opnd3;
  addend <- rval x.opnd2;

  mul 32 result opnd1 opnd2;
  add 32 result (var result) addend;

  emit-flags-nz (var result) x.o
end

val sem-mls x = do
  result <- lval x.opnd1;
  opnd1 <- rval x.opnd4;
  opnd2 <- rval x.opnd3;
  addend <- rval x.opnd2;

  mul 32 result opnd1 opnd2;
  sub 32 result addend (var result)
end

val sem-mul x = do
  result <- lval x.opnd1;
  opnd1 <- rval x.opnd4;
  opnd2 <- rval x.opnd3;

  mul 32 result opnd1 opnd2;

  emit-flags-nz (var result) x.o
end

val sem-smlal x = do
  opnd1 <- rval x.opnd3;
  opnd2 <- rval x.opnd4;
  high <- lval x.opnd1;
  low <- lval x.opnd2;

  result <- mktemp;
  addend <- mktemp;

  mov 64 addend (var high);
  shl 64 addend (var addend) (imm 32);
  orb 64 addend (var addend) (var low);

  mul 64 result opnd1 opnd2;
  add 64 result (var result) (var addend);

  mov 32 high (var (at-offset result 32));
  mov 32 low (var result);

  emit-flags-nz (var result) x.o
end

val sem-smull x = do
  opnd1 <- rval x.opnd3;
  opnd2 <- rval x.opnd4;
  high <- lval x.opnd1;
  low <- lval x.opnd2;

  result <- mktemp;

  mul 64 result opnd1 opnd2;

  mov 32 high (var (at-offset result 32));
  mov 32 low (var result);

  emit-flags-nz (var result) x.o
end

val sem-ldm x = do
  rn <- lval x.opnd1;
  load-operands 32 x.opnd2 32 rn;

  if x.o then
    add 32 rn (var rn) (imm (4 * num-opnds x.opnd2))
  else
    return void
end

val sem-ldmda x = do
  rn <- lval x.opnd1;
  load-operands 32 x.opnd2 32 rn;

  if x.o then
    sub 32 rn (lin-sum (lin-dif (var rn) (imm (4 * num-opnds x.opnd2))) (imm 4)) (imm (4 * num-opnds x.opnd2))
  else
    return void
end

val sem-ldmdb x = do
  rn <- lval x.opnd1;
  load-operands 32 x.opnd2 32 rn;

  if x.o then
    sub 32 rn (lin-dif (var rn) (imm (4 * num-opnds x.opnd2))) (imm (4 * num-opnds x.opnd2))
  else
    return void
end

val sem-ldmib x = do
  rn <- lval x.opnd1;
  load-operands 32 x.opnd2 32 rn;

  if x.o then
    add 32 rn (lin-sum (var rn) (imm 4)) (imm (4 * num-opnds x.opnd2))
  else
    return void
end

val sem-ldr x = do
  rt <- lval x.opnd2;
  rn <- lval x.opnd1;
  offset <- rval x.opnd3;

  index <- return x.o1;

  offset_addr <- combine-vars (var rn) offset x.o2;

  wback <- return (x.o3 or (not x.o1));
  cwrite 32 rn offset_addr wback;

  if index then
    load 32 rt 32 offset_addr
  else
    load 32 rt 32 (var rn)
end

val sem-ldrt x = do
    rt <- lval x.opnd2;
    rn <- lval x.opnd1;
    offset <- rval x.opnd3;

    offset_addr <- combine-vars (var rn) offset x.o2;

    _if (instr-set-arm?) _then do
        cwrite 32 rn offset_addr '1';
        load 32 rt 32 (var rn)
    end _else do
        load 32 rt 32 offset_addr 
    end       
end

val sem-ldrb x = do
  rt <- lval x.opnd2;
  rn <- lval x.opnd1;
  offset <- rval x.opnd3;

  offset_addr <- combine-vars (var rn) offset x.o2;

  wback <- return (x.o3 or (not x.o1));
  cwrite 32 rn offset_addr wback;

  byte <- mktemp;

  if x.o1 then
    load 8 byte 32 offset_addr
  else
    load 8 byte 32 (var rn)
  ;

  movzx 32 rt 8 (var byte)
end

val sem-ldrbt x = do
    rt <- lval x.opnd2;
    rn <- lval x.opnd1;
    offset <- rval x.opnd3;

    offset_addr <- combine-vars (var rn) offset x.o2;

    byte <- mktemp;

    _if (instr-set-arm?) _then do
        cwrite 32 rn offset_addr '1';
        load 8 rt 32 (var rn)
    end _else do
        load 8 rt 32 offset_addr 
    end;

    movzx 32 rt 8 (var byte)
end

val sem-ldrh x = do
    rt <- lval x.opnd2;
    rn <- lval x.opnd1;
    offset <- rval x.opnd3;

    offset_addr <- combine-vars (var rn) offset x.o2;

    halfword <- mktemp;

    if x.o1 then
        load 16 halfword 32 offset_addr
    else
        load 16 halfword 32 (var rn)
    ;

    movzx 32 rt 16 (var halfword)
end

val sem-ldrht x = do
    rt <- lval x.opnd2;
    rn <- lval x.opnd1;
    offset <- rval x.opnd3;

    offset_addr <- combine-vars (var rn) offset x.o2;

    halfword <- mktemp;

    _if (instr-set-arm?) _then do
        cwrite 32 rn offset_addr '1';
        load 16 rt 32 (var rn)
    end _else do
        load 16 rt 32 offset_addr 
    end;

    movzx 32 rt 16 (var halfword)
end

val sem-ldrsb x = do
  rt <- lval x.opnd2;
  rn <- lval x.opnd1;
  offset <- rval x.opnd3;

  offset_addr <- combine-vars (var rn) offset x.o2;

  wback <- return (x.o3 or (not x.o1));
  cwrite 32 rn offset_addr wback;

  byte <- mktemp;

  if x.o1 then
    load 8 byte 32 offset_addr
  else
    load 8 byte 32 (var rn)
  ;

  movsx 32 rt 8 (var byte)
end

val sem-ldrsbt x = do
    rt <- lval x.opnd2;
    rn <- lval x.opnd1;
    offset <- rval x.opnd3;

    offset_addr <- combine-vars (var rn) offset x.o2;

    byte <- mktemp;

    _if (instr-set-arm?) _then do
        cwrite 32 rn offset_addr '1';
        load 8 rt 32 (var rn)
    end _else do
        load 8 rt 32 offset_addr 
    end;

    movsx 32 rt 8 (var byte)
end

val sem-ldrsh x = do
    rt <- lval x.opnd2;
    rn <- lval x.opnd1;
    offset <- rval x.opnd3;

    offset_addr <- combine-vars (var rn) offset x.o2;

    halfword <- mktemp;

    if x.o1 then
        load 16 halfword 32 offset_addr
    else
        load 16 halfword 32 (var rn)
    ;

    movsx 32 rt 16 (var halfword)
end

val sem-ldrsht x = do
    rt <- lval x.opnd2;
    rn <- lval x.opnd1;
    offset <- rval x.opnd3;

    offset_addr <- combine-vars (var rn) offset x.o2;

    halfword <- mktemp;

    _if (instr-set-arm?) _then do
        cwrite 32 rn offset_addr '1';
        load 16 rt 32 (var rn)
    end _else do
        load 16 rt 32 offset_addr 
    end;

    movsx 32 rt 16 (var halfword)
end

val sem-stm x = do
  rn <- lval x.opnd1;
  store-operands 32 x.opnd2 32 rn;

  op <- return (if is-sem-sp? rn then sub else add);

  if x.o then
    op 32 rn (var rn) (imm (4 * num-opnds x.opnd2))
  else
    return void
end

val sem-stmda x = do
  rn <- lval x.opnd1;
  store-operands 32 x.opnd2 32 rn;

  op <- return (if is-sem-sp? rn then sub else add);

  if x.o then
    op 32 rn (lin-sum (lin-dif (var rn) (imm (4 * num-opnds x.opnd2))) (imm 4))  (imm (4 * num-opnds x.opnd2))
  else
    return void
end

val sem-stmdb x = do
  rn <- lval x.opnd1;
  store-operands 32 x.opnd2 32 rn;

  op <- return (if is-sem-sp? rn then sub else add);

  if x.o then
    op 32 rn (lin-dif (var rn) (imm (4 * num-opnds x.opnd2))) (imm (4 * num-opnds x.opnd2))
  else
    return void
end

val sem-stmib x = do
  rn <- lval x.opnd1;
  store-operands 32 x.opnd2 32 rn;

  op <- return (if is-sem-sp? rn then sub else add);

  if x.o then
    op 32 rn (lin-sum (var rn) (imm 4)) (imm (4 * num-opnds x.opnd2))
  else
    return void
end

val sem-str x = do
  rt <- rval x.opnd2;
  rn <- lval x.opnd1;
  offset <- rval x.opnd3;

  offset_addr <- combine-vars (var rn) offset x.o2;

  str 32 rt 32 offset_addr (var rn) x.o1;

  wback <- return (x.o3 or (not x.o1));
  cwrite 32 rn offset_addr wback
end

val sem-strt x = do
    rt <- rval x.opnd2;
    rn <- lval x.opnd1;
    offset <- rval x.opnd3;

    offset_addr <- combine-vars (var rn) offset x.o2;

    _if (instr-set-arm?) _then do
        store 32 (address 32 (var rn)) rt;
        cwrite 32 rn offset_addr '1'
    end _else do
        store 32 (address 32 offset_addr) rt
    end
end

val sem-strb x = do
  rt <- rval x.opnd2;
  rn <- lval x.opnd1;
  offset <- rval x.opnd3;

  offset_addr <- combine-vars (var rn) offset x.o2;

  str 8 rt 32 offset_addr (var rn) x.o1;

  wback <- return (x.o3 or (not x.o1));
  cwrite 32 rn offset_addr wback
end

val sem-strbt x = do
    rt <- rval x.opnd2;
    rn <- lval x.opnd1;
    offset <- rval x.opnd3;

    offset_addr <- combine-vars (var rn) offset x.o2;

    _if (instr-set-arm?) _then do
        store 8 (address 32 (var rn)) rt;
        cwrite 32 rn offset_addr '1'
    end _else do
        store 8 (address 32 offset_addr) rt
    end
end

val sem-strh x = do
    rt <- rval x.opnd2;
    rn <- lval x.opnd1;
    offset <- rval x.opnd3;

    offset_addr <- combine-vars (var rn) offset x.o2;

    str 16 rt 32 offset_addr (var rn) x.o1;

    wback <- return (x.o3 or (not x.o1));
    cwrite 32 rn offset_addr wback
end

val sem-strht x = do
    rt <- rval x.opnd2;
    rn <- lval x.opnd1;
    offset <- rval x.opnd3;

    offset_addr <- combine-vars (var rn) offset x.o2;

    _if (instr-set-arm?) _then do
        store 16 (address 32 (var rn)) rt;
        cwrite 32 rn offset_addr '1'
    end _else do
        store 16 (address 32 offset_addr) rt
    end
end

val sem-svc x = prim-generic "SUPERVISOR CALL" varls-none varls-none

# We ignore the immediate according to [A8.8.24]
val sem-bkpt x = case x.cond of
      AL : prim-generic "BREAKPOINT" varls-none varls-none
    | _  : return void
end

val esize ['1...'] = return Byte
val esize ['0..1'] = return Halfword
val esize ['0.00'] = return Word
val esize ['0.10'] = return void

val scalar-index ['1 h:3'] = zx h
val scalar-index ['0 h:2 1'] = zx h
val scalar-index ['0 h:1 00'] = zx h

val sem-vmovacs x = do
    esz <- esize x.opnd1;
    case esz of
          Byte     : do
            scalar <- sval Byte (scalar-index x.opnd1) Double x.opnd2;
            rt <- rval x.opnd3;

            mov 8 scalar rt
          end
        | Halfword : do
            scalar <- sval Halfword (scalar-index x.opnd1) Double x.opnd2;
            rt <- rval x.opnd3;

            mov 16 scalar rt
        end
        | Word     : do
            scalar <- sval Word (scalar-index x.opnd1) Double x.opnd2;
            rt <- rval x.opnd3;

            mov 32 scalar rt
        end
        | _        : do
            return void
        end
    end
end

val sem-default insn ip =
  prim-generic ("TRANSLATOR MISSING:\\t" +++ show/instruction insn ip) varls-none varls-none