# ======================================================================
# ARMv7 Instruction Set Decoder
# ----------------------------------------------------------------------
# * Currently, only 32bit ARM instructions are supported.
# * Refernces to the ARMv7 manual are marked like this: [[AX.Y.Z]]
#   Note: The ARMv7-A and ARMv7-R Manual (Issue C.c) was used.
# ======================================================================

# ----------------------------------------------------------------------
# Configuration
# ----------------------------------------------------------------------

export config-default: decoder-configuration
export decode: (decoder-configuration) -> S insndata <{} => {}>
export decoder-config : configuration[vec=decoder-configuration]

type insndata = {ip:int, length:int, insn:instruction}

type decoder-configuration = |1|

val decoder-config =
  conf '0' "little-endian" "assume input is little-endian (default)" &*
  conf '1' "big-endian" "assume input is big-endian"

val config-default = '0'

# ----------------------------------------------------------------------
# Entry Point
# ----------------------------------------------------------------------

val decode config = do
  if config == '0' then
    endianness endian-little/instr32-little/access32
  else
    endianness endian-big/instr32-big/access32
  ;

  reset;

  idx-before <- get-ip;
  insn <- /;
  idx-after <- get-ip;

  return {ip=idx-before, length=(idx-after - idx-before), insn=insn}
end

# ----------------------------------------------------------------------

val reset = do
  update@{
    cond='0000',
    b='0', p='0', w='0', s='0', d='0', q='0',
    iflags='000',
    e='0',
    m='0', n='0', f='0', u='0', r='0',
    a='0',
    sz='0', sz1='0', op='0',
    i='0',
    size='00', aligna='00',
    opc12='00', opc22='00',
    opc13='000', opc23='000',
    opc14='0000', opc24='0000',
    crd='0000', crn='0000', crm='0000', coproc='0000',
    vd='0000', vn='0000', vm='0000',
    cmode='0000',
    index_align='0000', vdl_type='0000',
    imm3='000',
    imm4='0000', imm4H='0000', imm4L='0000',
    imm5='00000',
    msbit='00000', lsbit='00000', widthm1='00000',
    imm8='00000000',
    imm12='000000000000',
    imm24='000000000000000000000000',
    byte='00000000', rot='0000',
    operands=OPNDL_NIL
  }
end

# ----------------------------------------------------------------------
# Type Definitions
# ----------------------------------------------------------------------

type instruction =
    ADC of unbitTernop
  | ADD of unbitTernop
  | ADR of unbitTernop
  | AND of unbitTernop
  | BIC of unbitTernop
  | CMN of unbitTernop
  | CMP of unbitTernop
  | EOR of unbitTernop
  | MOV of unbitTernop
  | MVN of unbitTernop
  | ORR of unbitTernop
  | RSB of unbitTernop
  | RSC of unbitTernop
  | SBC of unbitTernop
  | SUB of unbitTernop
  | TEQ of unbitTernop
  | TST of unbitTernop
  | MLA of unbitQuaternop
  | MLS of unbitQuaternop
  | MUL of unbitQuaternop
  | SMLABB of unbitQuaternop
  | SMLABT of unbitQuaternop
  | SMLATB of unbitQuaternop
  | SMLATT of unbitQuaternop
  | SMLAD of unbitQuaternop
  | SMLADX of unbitQuaternop
  | SMLAL of unbitQuaternop
  | SMLALBB of unbitQuaternop
  | SMLALBT of unbitQuaternop
  | SMLALTB of unbitQuaternop
  | SMLALTT of unbitQuaternop
  | SMLALD of unbitQuaternop
  | SMLALDX of unbitQuaternop
  | SMLAWB of unbitQuaternop
  | SMLAWT of unbitQuaternop
  | SMLSD of unbitQuaternop
  | SMLSDX of unbitQuaternop
  | SMLSLD of unbitQuaternop
  | SMLSLDX of unbitQuaternop
  | SMMLA of unbitQuaternop
  | SMMLAR of unbitQuaternop
  | SMMLS of unbitQuaternop
  | SMMLSR of unbitQuaternop
  | SMMUL of unbitQuaternop
  | SMMULR of unbitQuaternop
  | SMUAD of unbitQuaternop
  | SMUADX of unbitQuaternop
  | SMULBB of unbitQuaternop
  | SMULBT of unbitQuaternop
  | SMULTB of unbitQuaternop
  | SMULTT of unbitQuaternop
  | SMULL of unbitQuaternop
  | SMULWB of unbitQuaternop
  | SMULWT of unbitQuaternop
  | SMUSD of unbitQuaternop
  | SMUSDX of unbitQuaternop
  | UMAAL of unbitQuaternop
  | UMLAL of unbitQuaternop
  | UMULL of unbitQuaternop
  | SSAT of ternop
  | SSAT16 of ternop
  | USAT of ternop
  | USAT16 of ternop
  | QADD of ternop
  | QSUB of ternop
  | QDADD of ternop
  | QDSUB of ternop
  | PKH of ternop
  | SXTAB of ternop
  | SXTAB16 of ternop
  | SXTAH of ternop
  | SXTB of ternop
  | SXTB16 of ternop
  | SXTH of ternop
  | UXTAB of ternop
  | UXTAB16 of ternop
  | UXTAH of ternop
  | UXTB of ternop
  | UXTB16 of ternop
  | UXTH of ternop
  | SADD16 of ternop
  | QADD16 of ternop
  | SHADD16 of ternop
  | UADD16 of ternop
  | UQADD16 of ternop
  | UHADD16 of ternop
  | SASX of ternop
  | QASX of ternop
  | SHASX of ternop
  | UASX of ternop
  | UQASX of ternop
  | UHASX of ternop
  | SSAX of ternop
  | QSAX of ternop
  | SHSAX of ternop
  | USAX of ternop
  | UQSAX of ternop
  | UHSAX of ternop
  | SSUB16 of ternop
  | QSUB16 of ternop
  | SHSUB16 of ternop
  | USUB16 of ternop
  | UQSUB16 of ternop
  | UHSUB16 of ternop
  | SADD8 of ternop
  | QADD8 of ternop
  | SHADD8 of ternop
  | UADD8 of ternop
  | UQADD8 of ternop
  | UHADD8 of ternop
  | SSUB8 of ternop
  | QSUB8 of ternop
  | SHSUB8 of ternop
  | USUB8 of ternop
  | UQSUB8 of ternop
  | UHSUB8 of ternop
  | SDIV of ternop
  | UDIV of ternop
  | BFC of quaternop
  | BFI of quaternop
  | CLZ of binop
  | MOVT of binop
  | RBIT of binop
  | REV of binop
  | REV16 of binop
  | REVSH of binop
  | SBFX of quaternop
  | SEL of ternop
  | UBFX of quaternop
  | USAD8 of quaternop
  | USADA8 of quaternop
  | MRS of unbitBinopUnbit
  | MSR of unbitUnopUnbitUnop
  | CPS of binop
  | LDR of ternbitTernop
  | LDRT of ternbitTernop
  | LDRB of ternbitTernop
  | LDRBT of ternbitTernop
  | LDRH of ternbitTernop
  | LDRHT of ternbitTernop
  | LDRSB of ternbitTernop
  | LDRSBT of ternbitTernop
  | LDRSH of ternbitTernop
  | LDRSHT of ternbitTernop
  | LDRD of ternbitTernop
  | LDREX of binop
  | LDREXB of binop
  | LDREXD of binop
  | LDREXH of binop
  | STR of ternbitTernop
  | STRT of ternbitTernop
  | STRB of ternbitTernop
  | STRBT of ternbitTernop
  | STRD of ternbitTernop
  | STRH of ternbitTernop
  | STRHT of ternbitTernop
  | STREX of ternop
  | STREXB of ternop
  | STREXD of ternop
  | STREXH of ternop
  | LDM of unbitBinop
  | LDMDA of unbitBinop
  | LDMDB of unbitBinop
  | LDMIB of unbitBinop
  | POP of unbitBinop
  | STM of unbitBinop
  | STMDA of unbitBinop
  | STMDB of unbitBinop
  | STMIB of unbitBinop
  | PUSH of unbitBinop
  | B of unop
  | BL of unop
  | BLX of unop
  | BX of unop
  | BXJ of unop
  | CLREX of nullop
  | DBG of unop
  | DMB of unop
  | DSB of unop
  | ISB of unop
  | NOP of nullop
  | PLD of unopUnbitUnop
  | PLDW of unopUnbitUnop
  | PLI of unopUnbitUnop
  | SETEND of unbit
  | SEV of nullop
  | SWP of ternop
  | SWPB of ternop
  | WFE of nullop
  | WFI of nullop
  | YIELD of nullop
  | SVC of unop
  | BKPT of unop
  | SMC of unop
  | RFE of ternbitUnop
  | SUBS of binop
  | HVC of unop
  | ERET of nullop
  | LDMerur of ternbitBinop
  | SRS of ternbitUnop
  | CDP of senop
  | CDP2 of senop
  | MCR of senop
  | MCR2 of senop
  | MCRR of quinop
  | MCRR2 of quinop
  | MRC of senop
  | MRC2 of senop
  | MRRC of quinop
  | MRRC2 of quinop
  | LDC of quinop
  | LDC2 of quinop
  | STC of quinop
  | STC2 of quinop
  | VLDMIA of unopUnbitBinop
  | VLDMDB of unopUnbitBinop
  | VLDR of binopUnbitUnop
  | VSTMIA of unopUnbitBinop
  | VSTMDB of unopUnbitBinop
  | VSTR of binopUnbitUnop
  | VLD1 of quinop
  | VLD1a of ternopUnbitUnop
  | VLD2 of quinop
  | VLD2a of ternopUnbitUnop
  | VLD3 of quinop
  | VLD3a of ternopUnbitUnop
  | VLD4 of quinop
  | VLD4a of ternopUnbitUnop
  | VST1 of quinop
  | VST2 of quinop
  | VST3 of quinop
  | VST4 of quinop
  | VDUP of ternop
  | VMOVacs of ternop
  | VMOVsac of ternop
  | VMOVacsp of binop
  | VMOVspac of binop
  | VMOVacsp2 of ternop
  | VMOVspac2 of ternop
  | VMOVacdwe of ternop
  | VMOVdweac of ternop
  | VMRS of unop
  | VMSR of unop
  | VADDiasimd of quaternop
  | VADDfpasimd of unbitTernop
  | VADDHN of quaternop
  | VADDL of unbitQuaternop
  | VADDW of unbitQuaternop
  | VHADD of unbitQuaternop
  | VHSUB of unbitQuaternop
  | VPADAL of unbitTernop
  | VPADDi of quaternop
  | VPADDfp of unbitTernop
  | VPADDL of unbitTernop
  | VRADDHN of quaternop
  | VRHADD of unbitQuaternop
  | VRSUBHN of quaternop
  | VQADD of unbitQuaternop
  | VQSUB of unbitQuaternop
  | VSUBiasimd of quaternop
  | VSUBfpasimd of unbitTernop
  | VSUBHN of quaternop
  | VSUBL of unbitQuaternop
  | VSUBW of unbitQuaternop
  | VAND of ternop
  | VBIC of ternop
  | VEOR of ternop
  | VBIF of ternop
  | VBIT of ternop
  | VBSL of ternop
  | VMOVimmasimd of binop
  | VMOVregasimd of binop
  | VMVN of ternop
  | VORR of ternop
  | VORN of ternop
  | VACGE of unbitTernop
  | VACGT of unbitTernop
  | VCEQrega of quaternop
  | VCEQregb of unbitTernop
  | VCEQimm of unbitTernop
  | VCGErega of unbitQuaternop
  | VCGEregb of unbitTernop
  | VCGEimm of unbitTernop
  | VCGTrega of unbitQuaternop
  | VCGTregb of unbitTernop
  | VCGTimm of unbitTernop
  | VCLE of unbitTernop
  | VCLT of unbitTernop
  | VTST of quaternop
  | VQRSHL of unbitQuaternop
  | VQRSHRN of unbitQuaternop
  | VQRSHRUN of unbitQuaternop
  | VQSHL of unbitQuaternop
  | VQSHLU of unbitQuaternop
  | VQSHRN of unbitQuaternop
  | VQSHRUN of unbitQuaternop
  | VRSHL of unbitQuaternop
  | VRSHR of unbitQuaternop
  | VRSRA of unbitQuaternop
  | VRSHRN of quaternop
  | VSHLimm of quaternop
  | VSHLreg of unbitQuaternop
  | VSHLL of unbitQuaternop
  | VSHR of unbitQuaternop
  | VSHRN of quaternop
  | VSLI of quaternop
  | VSRA of unbitQuaternop
  | VSRI of quaternop
  | VMLAiasimd of quaternop
  | VMLAfpasimd of unbitTernop
  | VMLAsasimd of unbitQuaternop
  | VMLAL of unbitQuaternop
  | VMLSiasimd of quaternop
  | VMLSfpasimd of unbitTernop
  | VMLSsasimd of unbitQuaternop
  | VMLSL of unbitQuaternop
  | VMULipasimd of unbitQuaternop
  | VMULfpasimd of unbitTernop
  | VMULsasimd of unbitQuaternop
  | VMULLipasimd of binbitQuaternop
  | VMULLsasimd of unbitQuaternop
  | VFMA of unbitTernop
  | VFMS of unbitTernop
  | VQDMLAL of quaternop
  | VQDMLSL of quaternop
  | VQDMULH of quaternop
  | VQRDMULH of quaternop
  | VQDMULL of quaternop
  | VABA of unbitQuaternop
  | VABAL of unbitQuaternop
  | VABDi of unbitQuaternop
  | VABDfp of unbitTernop
  | VABDL of unbitQuaternop
  | VABSasimd of unbitTernop
  | VCVTfpiasimd of ternop
  | VCVTfpfpasimd of binbitTernop
  | VCVThpspasimd of ternop
  | VCLS of ternop
  | VCLZ of ternop
  | VCNT of ternop
  | VDUP2 of ternop
  | VEXT of quaternop
  | VMOVN of ternop
  | VMOVL of ternop
  | VMAXi of unbitQuaternop
  | VMAXfp of unbitTernop
  | VMINi of unbitQuaternop
  | VMINfp of unbitTernop
  | VNEGasimd of unbitTernop
  | VPMAXi of unbitQuaternop
  | VPMAXfp of unbitTernop
  | VPMINi of unbitQuaternop
  | VPMINfp of unbitTernop
  | VRECPE of unbitTernop
  | VRECPS of unbitTernop
  | VRSQRTE of unbitTernop
  | VRSQRTS of unbitTernop
  | VREV16 of ternop
  | VREV32 of ternop
  | VREV64 of ternop
  | VQABS of ternop
  | VQMOVN of unbitTernop
  | VQMOVUN of ternop
  | VQNEG of ternop
  | VSWP of ternop
  | VTBL of quaternop
  | VTBX of quaternop
  | VTRN of ternop
  | VUZP of ternop
  | VZIP of ternop
  | VABSfp of unbitBinop
  | VADDfpfp of unbitTernop
  | VCMP of unbitBinop
  | VCMPE of unbitBinop
  | VCVTfpifp of binbitBinop
  | VCVTfpfpfp of quaternbitTernop
  | VCVTdpspfp of binop
  | VCVTR of unopUnbitBinop
  | VCVTB of unbitBinop
  | VCVTT of unbitBinop
  | VDIV of unbitBinop
  | VMLAfpfp of unbitTernop
  | VMLSfpfp of unbitTernop
  | VMOVimmfp of binop
  | VMOVregfp of unbitBinop
  | VMULfpfp of unbitTernop
  | VNEGfp of unbitBinop
  | VNMLA of unbitBinop
  | VNMLS of unbitBinop
  | VNMUL of unbitBinop
  | VFNMA of unbitBinop
  | VFNMS of unbitBinop
  | VSQRT of unbitBinop
  | VSUBfpfp of unbitTernop

# Generic instruction without any operands
type nullop = {
  cond:condition
}

# Generic instruction with one operand
type unop = {
  cond:condition,
  opnd:operand
}

# Generic instruction with one bit
type unbit = {
  cond:condition,
  o:1
}

# Generic instruction with two operands
type binop = {
  cond:condition,
  opnd1:operand,
  opnd2:operand
}

# Generic instruction with three operands
type ternop = {
  cond:condition,
  opnd1:operand,
  opnd2:operand,
  opnd3:operand
}

# Generic instruction with four operands
type quaternop = {
  cond:condition,
  opnd1:operand,
  opnd2:operand,
  opnd3:operand,
  opnd4:operand
}

# Generic instruction with five operands
type quinop = {
  cond:condition,
  opnd1:operand,
  opnd2:operand,
  opnd3:operand,
  opnd4:operand,
  opnd5:operand
}

# Generic instruction with four operands
type senop = {
  cond:condition,
  opnd1:operand,
  opnd2:operand,
  opnd3:operand,
  opnd4:operand,
  opnd5:operand,
  opnd6:operand
}

# Generic instruction with one bit followed by two operands
type unbitBinop = {
  cond:condition,
  o:1,
  opnd1:operand,
  opnd2:operand
}

# Generic instruction with one bit followed by three operands
type unbitTernop = {
  cond:condition,
  o:1,
  opnd1:operand,
  opnd2:operand,
  opnd3:operand
}

# Generic instruction with one bit followed by four operands
type unbitQuaternop = {
  cond:condition,
  o:1,
  opnd1:operand,
  opnd2:operand,
  opnd3:operand,
  opnd4:operand
}

# Generic instruction with two bits followed by two operands
type binbitBinop = {
  cond:condition,
  o1:1,
  o2:1,
  opnd1:operand,
  opnd2:operand
}

# Generic instruction with two bits followed by three operands
type binbitTernop = {
  cond:condition,
  o1:1,
  o2:1,
  opnd1:operand,
  opnd2:operand,
  opnd3:operand
}

# Generic instruction with two bits followed by four operands
type binbitQuaternop = {
  cond:condition,
  o1:1,
  o2:1,
  opnd1:operand,
  opnd2:operand,
  opnd3:operand,
  opnd4:operand
}

# Generic instruction with three bits followed by one operand
type ternbitUnop = {
  cond:condition,
  o1:1,
  o2:1,
  o3:1,
  opnd:operand
}

# Generic instruction with three bits followed by two operands
type ternbitBinop = {
  cond:condition,
  o1:1,
  o2:1,
  o3:1,
  opnd1:operand,
  opnd2:operand
}

# Generic instruction with three bits followed by three operands
type ternbitTernop = {
  cond:condition,
  o1:1,
  o2:1,
  o3:1,
  opnd1:operand,
  opnd2:operand,
  opnd3:operand
}

# Generic instruction with four bits followed by two operands
type quaternbitBinop = {
  cond:condition,
  o1:1,
  o2:1,
  o3:1,
  o4:1,
  opnd1:operand,
  opnd2:operand
}

# Generic instruction with four bits followed by three operands
type quaternbitTernop = {
  cond:condition,
  o1:1,
  o2:1,
  o3:1,
  o4:1,
  opnd1:operand,
  opnd2:operand,
  opnd3:operand
}

# Generic instruction with one operand followed by a bit and another operand
type unopUnbitUnop = {
  cond:condition,
  opnd1:operand,
  o:1,
  opnd2:operand
}

# Generic instruction with one operand followed by a bit and another two operands
type unopUnbitBinop = {
  cond:condition,
  opnd1:operand,
  o:1,
  opnd2:operand,
  opnd3:operand
}

# Generic instruction with one bit followed by two operands and another bit
type unbitBinopUnbit = {
  cond:condition,
  o1:1,
  opnd1:operand,
  opnd2:operand,
  o2:1
}

# Generic instruction with two operands followed by a bit and another operand
type binopUnbitUnop = {
  cond:condition,
  opnd1:operand,
  opnd2:operand,
  o:1,
  opnd3:operand
}

# Generic instruction with three operands followed by a bit and another operand
type ternopUnbitUnop = {
  cond:condition,
  opnd1:operand,
  opnd2:operand,
  opnd3:operand,
  o:1,
  opnd4:operand
}

# Generic instruction with one bit followed by an operand another bit and another operand
type unbitUnopUnbitUnop = {
  o1:1,
  opnd1:operand,
  o2:1,
  opnd2:operand
}

type operand =
    IMMEDIATE of immediate
  | REGISTER of register
  | SHIFTED_OPERAND of shiftedoperand
  | OPERAND_LIST of operandlist (* TODO: Replace with operand tuple, maybe? *)
  | VECTOR of vector

type immediate =
    IMMi of int
  | IMM2 of 2
  | IMM3 of 3
  | IMM4 of 4
  | IMM5 of 5
  | IMM6 of 6
  | IMM8 of 8
  | IMM12 of 12
  | IMM16 of 16
  | IMM24 of 24
  | IMM32 of 32
  | IMM64 of 64
  | MODIMM of {byte:8, rot:4} # 8 bit immediate with 4 bit rotation

type vector = {change:1, first:1, remainder:4}

type operandlist =
    OPNDL_NIL
  | OPNDL_CONS of {hd:operand, tl:operandlist}

val opndl-none = OPNDL_NIL
val opndl-one op = OPNDL_CONS {hd=op, tl=OPNDL_NIL}
val opndl-more op tl = OPNDL_CONS {hd=op, tl=tl}

val opndl-length opndl =
  case opndl of
      OPNDL_NIL: 0
    | OPNDL_CONS l: 1 + (opndl-length l.tl)
  end

val num-opnds opnd =
  case opnd of
      OPERAND_LIST l: opndl-length l
    | _: 1
  end

type shiftedoperand = {opnd:operand, shift:shift}
type shift = {amount:operand, shifttype:shifttype}

type shifttype =
    LSL  # Logical Shift Left
  | LSR  # Logical Shift Right
  | ASR  # Arithmetic Shift Right
  | ROR  # Rotate Right
  | RRX  # Rotate Right with Extend

type register =
    R0   # Argument1, Return Value: Temporory register
  | R1   # Argument2, Second 32-bits if double/int Return Value: Temporary register
  | R2   # Argument: Temporary register
  | R3   # Argument: Temporary register
  | R4   # permanent register
  | R5   # permanent register
  | R6   # permanent register
  | R7   # permanent register (THUMB frame pointer)
  | R8   # permanent register
  | R9   # permanent register
  | R10  # permanent register
  | R11  # ARM frame pointer: permanent register
  | R12  # Temporary register
  | R13  # Stack pointer: permanent register
  | R14  # Link register: permanent register
  | R15  # Program Counter

val is-pc? r =
  case r of
      R15: '1'
    | _: '0'
  end

val is-sp? r =
  case r of
      R13: '1'
    | _: '0'
  end

# ARM condition codes [[A8.3]]
type condition =
    EQ   # Equal
  | NE   # Not equal
  | CS   # Carry set
  | CC   # Carry clear
  | MI   # Minus, negative
  | PL   # Plus, positive or zero
  | VS   # Overflow
  | VC   # No overflow
  | HI   # Unsigned higher
  | LS   # Unsigned lower or same
  | GE   # Signed greater than or equal
  | LT   # Signed less than
  | GT   # Signed greater than
  | LE   # Signed less than or equal
  | AL   # Always (unconditional)
  | NV   # Never: Dummy condition (NV is not an actual ARM condition)

# ----------------------------------------------------------------------
# Utility Functions
# ----------------------------------------------------------------------

val nullop cons cond = do
  cond <- cond;
  return (cons {cond=cond})
end

val unop cons cond opnd = do
  cond <- cond;
  opnd <- opnd;
  return (cons {cond=cond, opnd=opnd})
end

val unbit cons cond o = do
  cond <- cond;
  o <- o;
  return (cons {cond=cond, o=o})
end

val binop cons cond opnd1 opnd2 = do
  cond <- cond;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  return (cons {cond=cond, opnd1=opnd1, opnd2=opnd2})
end

val ternop cons cond opnd1 opnd2 opnd3 = do
  cond <- cond;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  opnd3 <- opnd3;
  return (cons {cond=cond, opnd1=opnd1, opnd2=opnd2, opnd3=opnd3})
end

val quaternop cons cond opnd1 opnd2 opnd3 opnd4 = do
  cond <- cond;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  opnd3 <- opnd3;
  opnd4 <- opnd4;
  return (cons {cond=cond, opnd1=opnd1, opnd2=opnd2, opnd3=opnd3, opnd4=opnd4})
end

val quinop cons cond opnd1 opnd2 opnd3 opnd4 opnd5 = do
  cond <- cond;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  opnd3 <- opnd3;
  opnd4 <- opnd4;
  opnd5 <- opnd5;
  return (cons {cond=cond, opnd1=opnd1, opnd2=opnd2, opnd3=opnd3, opnd4=opnd4, opnd5=opnd5})
end

val senop cons cond opnd1 opnd2 opnd3 opnd4 opnd5 opnd6 = do
  cond <- cond;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  opnd3 <- opnd3;
  opnd4 <- opnd4;
  opnd5 <- opnd5;
  opnd6 <- opnd6;
  return (cons {cond=cond, opnd1=opnd1, opnd2=opnd2, opnd3=opnd3, opnd4=opnd4, opnd5=opnd5, opnd6=opnd6})
end

val unbitBinop cons cond o opnd1 opnd2 = do
  cond <- cond;
  o <- o;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  return (cons {cond=cond, o=o, opnd1=opnd1, opnd2=opnd2})
end

val unbitTernop cons cond o opnd1 opnd2 opnd3 = do
  cond <- cond;
  o <- o;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  opnd3 <- opnd3;
  return (cons {cond=cond, o=o, opnd1=opnd1, opnd2=opnd2, opnd3=opnd3})
end

val unbitQuaternop cons cond o opnd1 opnd2 opnd3 opnd4 = do
  cond <- cond;
  o <- o;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  opnd3 <- opnd3;
  opnd4 <- opnd4;
  return (cons {cond=cond, o=o, opnd1=opnd1, opnd2=opnd2, opnd3=opnd3, opnd4=opnd4})
end

val binbitBinop cons cond o1 o2 opnd1 opnd2 = do
  cond <- cond;
  o1 <- o1;
  o2 <- o2;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  return (cons {cond=cond, o1=o1, o2=o2, opnd1=opnd1, opnd2=opnd2})
end

val binbitTernop cons cond o1 o2 opnd1 opnd2 opnd3 = do
  cond <- cond;
  o1 <- o1;
  o2 <- o2;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  opnd3 <- opnd3;
  return (cons {cond=cond, o1=o1, o2=o2, opnd1=opnd1, opnd2=opnd2, opnd3=opnd3})
end

val binbitQuaternop cons cond o1 o2 opnd1 opnd2 opnd3 opnd4 = do
  cond <- cond;
  o1 <- o1;
  o2 <- o2;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  opnd3 <- opnd3;
  opnd4 <- opnd4;
  return (cons {cond=cond, o1=o1, o2=o2, opnd1=opnd1, opnd2=opnd2, opnd3=opnd3, opnd4=opnd4})
end

val ternbitUnop cons cond o1 o2 o3 opnd = do
  cond <- cond;
  o1 <- o1;
  o2 <- o2;
  o3 <- o3;
  opnd <- opnd;
  return (cons {cond=cond, o1=o1, o2=o2, o3=o3, opnd=opnd})
end

val ternbitBinop cons cond o1 o2 o3 opnd1 opnd2 = do
  cond <- cond;
  o1 <- o1;
  o2 <- o2;
  o3 <- o3;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  return (cons {cond=cond, o1=o1, o2=o2, o3=o3, opnd1=opnd1, opnd2=opnd2})
end

val ternbitTernop cons cond o1 o2 o3 opnd1 opnd2 opnd3 = do
  cond <- cond;
  o1 <- o1;
  o2 <- o2;
  o3 <- o3;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  opnd3 <- opnd3;
  return (cons {cond=cond, o1=o1, o2=o2, o3=o3, opnd1=opnd1, opnd2=opnd2, opnd3=opnd3})
end

val quaternbitBinop cons cond o1 o2 o3 o4 opnd1 opnd2 = do
  cond <- cond;
  o1 <- o1;
  o2 <- o2;
  o3 <- o3;
  o4 <- o4;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  return (cons {cond=cond, o1=o1, o2=o2, o3=o3, o4=o4, opnd1=opnd1, opnd2=opnd2})
end

val quaternbitTernop cons cond o1 o2 o3 o4 opnd1 opnd2 opnd3 = do
  cond <- cond;
  o1 <- o1;
  o2 <- o2;
  o3 <- o3;
  o4 <- o4;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  opnd3 <- opnd3;
  return (cons {cond=cond, o1=o1, o2=o2, o3=o3, o4=o4, opnd1=opnd1, opnd2=opnd2, opnd3=opnd3})
end

val unopUnbitUnop cons cond opnd1 o opnd2 = do
  cond <- cond;
  opnd1 <- opnd1;
  o <- o;
  opnd2 <- opnd2;
  return (cons {cond=cond, opnd1=opnd1, o=o, opnd2=opnd2})
end

val unopUnbitBinop cons cond opnd1 o opnd2 opnd3 = do
  cond <- cond;
  opnd1 <- opnd1;
  o <- o;
  opnd2 <- opnd2;
  opnd3 <- opnd3;
  return (cons {cond=cond, opnd1=opnd1, o=o, opnd2=opnd2, opnd3=opnd3})
end

val unbitBinopUnbit cons cond o1 opnd1 opnd2 o2 = do
  cond <- cond;
  o1 <- o1;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  o2 <- o2;
  return (cons {cond=cond, o1=o1, opnd1=opnd1, opnd2=opnd2, o2=o2})
end

val binopUnbitUnop cons cond opnd1 opnd2 o opnd3 = do
  cond <- cond;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  o <- o;
  opnd3 <- opnd3;
  return (cons {cond=cond, opnd1=opnd1, opnd2=opnd2, o=o, opnd3=opnd3})
end

val ternopUnbitUnop cons cond opnd1 opnd2 opnd3 o opnd4 = do
  cond <- cond;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  opnd3 <- opnd3;
  o <- o;
  opnd4 <- opnd4;
  return (cons {cond=cond, opnd1=opnd1, opnd2=opnd2, opnd3=opnd3, o=o, opnd4=opnd4})
end

val unbitUnopUnbitUnop cons cond o1 opnd1 o2 opnd2 = do
  cond <- cond;
  o1 <- o1;
  opnd1 <- opnd1;
  o2 <- o2;
  opnd2 <- opnd2;
  return (cons {cond=cond, o1=o1, opnd1=opnd1, o2=o2, opnd2=opnd2})
end

val register cons = REGISTER cons
val immediate cons = IMMEDIATE cons
val shiftedoperand cons = SHIFTED_OPERAND cons
val operandlist cons = OPERAND_LIST cons
val vector cons = VECTOR cons

val opnd-from-int i = IMMEDIATE (IMMi i)

val imm-to-int imm =
  case imm of
      IMMi i: i
    | IMM2 i: zx i
	  | IMM3 i: zx i
    | IMM4 i: zx i
    | IMM5 i: zx i
	  | IMM6 i: zx i
    | IMM8 i: zx i
    | IMM12 i: zx i
    | IMM24 i: zx i
    | IMM64 i: zx i
    | MODIMM i: armexpandimm i
  end

val is-zero? imm = (imm-to-int imm) === 0

# Modulo. I didn't see this operator anywhere else...
val /mod a b = a - (/z a b) * b

# Creates a operand list from a (16 bit) bit vector.
# If bit i is set, then the register Ri is added to the list.
val decode-registerlist bitvec = let
  val from-int i index =
    if i > 0 then
      if /mod i 2 === 1 then
        opndl-more (register (register-from-int index)) (from-int (/z i 2) (index + 1))
      else
        from-int (/z i 2) (index + 1)
    else
      opndl-none
in
  from-int (zx bitvec) 0
end

val register-from-int i =
  case i of
      0: R0
    | 1: R1
    | 2: R2
    | 3: R3
    | 4: R4
    | 5: R5
    | 6: R6
    | 7: R7
    | 8: R8
    | 9: R9
    | 10: R10
    | 11: R11
    | 12: R12
    | 13: R13
    | 14: R14
    | 15: R15
  end

val decode-register bitvec = register-from-int (zx bitvec)

val decode-shifttype bitvec =
  case bitvec of
      '00' : LSL
    | '01' : LSR
    | '10' : ASR
    | '11' : ROR
  end

val decode-condition bitvec =
  case bitvec of
     '0000': EQ
   | '0001': NE
   | '0010': CS
   | '0011': CC
   | '0100': MI
   | '0101': PL
   | '0110': VS
   | '0111': VC
   | '1000': HI
   | '1001': LS
   | '1010': GE
   | '1011': LT
   | '1100': GT
   | '1101': LE
   | '1110': AL
  end

# ----------------------------------------------------------------------
# Bit Shifts and Rotations
# ----------------------------------------------------------------------

### Most significant bit
val msb x = /z (/mod x 0x100000000) 0x80000000
### Least significant bit
val lsb x = /mod x 2

### LSL_C
###  - Logical Shift Left (w/ carry out)
val lsl-c x shift = let
  val lsl-shift value amount carry_in =
    if amount === 0 then
      {result=value, carry_out=carry_in}
    else
      lsl-shift (value * 2) (amount - 1) (msb value)
in
  lsl-shift (/mod x 0x100000000) shift 0
end

### LSL
###  - Logical Shift Left
val lsl x shift = (lsl-c x shift).result

### LSR_C
###  - Logical Shift Right (w/ carry out)
val lsr-c x shift = let
  val lsr-shift value amount carry_in =
    if amount === 0 then
      {result=value, carry_out=carry_in}
    else
      lsr-shift (/z value 2) (amount - 1) (lsb value)
in
  lsr-shift (/mod x 0x100000000) shift 0
end

### LSR
###  - Logical Shift Right
val lsr x shift = (lsr-c x shift).result

### ASR_C
###  - Arithmetic Shift Right (w/ carry out)
val asr-c x shift = let
  val asr-shift value amount carry_in =
    if amount === 0 then
      {result=value, carry_out=carry_in}
    else
      asr-shift ((/z value 2) + (0x80000000 * (msb value))) (amount - 1) (lsb value)
in
  asr-shift (/mod x 0x100000000) shift 0
end

### ASR
###  - Arithmetic Shift Right
val asr x shift = (asr-c x shift).result

### ROR_C
###  - Rotate Right (w/ carry out)
val ror-c x shift = let
  val rotate-r value amount carry_in =
    if amount === 0 then
      {result=value, carry_out=carry_in}
    else
      rotate-r ((/z value 2) + (0x80000000 * (lsb value))) (amount - 1) (lsb value)
in
  rotate-r (/mod x 0x100000000) shift 0
end

### ROR
###  - Rotate Right
val ror x shift = (ror-c x shift).result

### RRX_C
###  - Rotate Right with Extend (w/ carry out)
val rrx-c x carry_in = {
  result=((/z (/mod x 0x100000000) 2) + (0x80000000 * carry_in)),
  carry_out=(lsb x)
}

### RRX
###  - Rotate Right with Extend
val rrx x carry_in = (rrx-c x carry_in).result

### Shift_C [[A8.4.3]]
val shift-c value stype amount carry_in =
  if amount === 0 then
    {result=value, carry_out=carry_in}
  else
    case stype of
        LSL: lsl-c value amount
      | LSR: lsr-c value amount
      | ASR: asr-c value amount
      | ROR: ror-c value amount
      | RRX: rrx-c value carry_in
    end

### Shift [[A8.4.3]]
val shift value stype amount carry_in =
  (shift-c value stype amount carry_in).result

### ARMExpandImm_C [[A5.2.4]]
val armexpandimm-c modimm carry_in =
  shift-c (zx modimm.byte) ROR (2 * (zx modimm.rot)) carry_in

### ARMExpandImm [[A5.2.4]]
val armexpandimm modimm = (armexpandimm-c modimm 0).result

### AdvSIMDExpandImm [[A7.4.6]]
(* TODO: adjust so that unpredictable parameters are recognized parameters are recognized *)
val advsimdexpandimm op cmode imm8 = case cmode of
      '000.': immediate (IMM64 ('000000000000000000000000'^imm8^'000000000000000000000000'^imm8))
    | '001.': immediate (IMM64 ('0000000000000000'^imm8^'000000000000000000000000'^imm8^'00000000'))
    | '010.': immediate (IMM64 ('00000000'^imm8^'000000000000000000000000'^imm8^'0000000000000000'))
    | '011.': immediate (IMM64 (imm8^'000000000000000000000000'^imm8^'000000000000000000000000'))
    | '100.': immediate (IMM64 ('00000000'^imm8^'00000000'^imm8^'00000000'^imm8^'00000000'^imm8))
    | '101.': immediate (IMM64 (imm8^'00000000'^imm8^'00000000'^imm8^'00000000'^imm8^'00000000'))
    | '1100': immediate (IMM64 ('0000000000000000'^imm8^'11111111'^'0000000000000000'^imm8^'11111111'))
    | '1101': immediate (IMM64 ('00000000'^imm8^'1111111111111111'^'00000000'^imm8^'1111111111111111'))
    | '1110': case op of
        '0': immediate (IMM64 (imm8^imm8^imm8^imm8^imm8^imm8^imm8^imm8))
      | '1': case imm8 of
        'a:1 b:1 c:1 d:1 e:1 f:1 g:1 h:1': immediate (IMM64 (a^a^a^a^a^a^a^a^b^b^b^b^b^b^b^b^c^c^c^c^c^c^c^c^d^d^d^d^d^d^d^d^e^e^e^e^e^e^e^e^f^f^f^f^f^f^f^f^g^g^g^g^g^g^g^g^h^h^h^h^h^h^h^h))
      end
    end
    | '1111': case op of
        '0': case imm8 of
          'a:1 b:1 c:6': immediate (IMM64 (a^(not b)^b^b^b^b^b^c^'0000000000000000000'^a^(not b)^b^b^b^b^b^c^'0000000000000000000'))
        end
    end
end

### VFPExpandImm [[A7.5.1]]
val vfpexpandimm imm8 n = case imm8 of
    IMMEDIATE i: case i of
      IMM8 j: case j of
        'i7:1 i6:1 i50:6': case n of
            32: return (immediate (IMM32 (i7^(not i6)^i6^i6^i6^i6^i6^i50^'0000000000000000000')))
          | 64: return (immediate (IMM64 (i7^(not i6)^i6^i6^i6^i6^i6^i6^i6^i6^i50^'000000000000000000000000000000000000000000000000')))
        end
      end
    end
end
# ----------------------------------------------------------------------
# Subdecoder
# ----------------------------------------------------------------------

# --- condition subdecoders --------------------------------------------

# 4 bit condition code; cannot be '1111'
val /cond ['cond@0...'] = update@{cond=cond}
val /cond ['cond@10..'] = update@{cond=cond}
val /cond ['cond@110.'] = update@{cond=cond}
val /cond ['cond@1110'] = update@{cond=cond}

val cond = do
  cond <- query $cond;
  return (decode-condition cond)
end

val none = return NV

# --- helper subdecoders -----------------------------------------------

# 2 bit size, cannot be 11 (undefined/related instruction)
val /size ['size@10'] = update@{size=size}
val /size ['size@0.'] = update@{size=size}

val /size2 ['size:2'] = update@{size=size}

val size = do
  size <- query $size;
  return (immediate (IMM2 (size)))
end

# 3 bit VCVTR opc2, can only be 100 or 101
val /opc2-vcvtr ['opc23@100'] = update@{opc23=opc23}
val /opc2-vcvtr ['opc23@101'] = update@{opc23=opc23}

# 4 bit PUDW, cannot be 0000 (undefined) or 0010 (mrrc(2))
val /PUDW ['imm4@1...'] = update@{imm4=imm4}
val /PUDW ['imm4@01..'] = update@{imm4=imm4}
val /PUDW ['imm4@0011'] = update@{imm4=imm4}
val /PUDW ['imm4@0001'] = update@{imm4=imm4}

val pudw = do
  imm4 <- query $imm4;
  return (immediate (IMM4 (imm4)))
end

# 4 bit vld1/vst1 type, can only be 0111 (1 register), 1010 (2 registers), 0110 (3 registers), or 0010 (4 registers)
val /vls1_type ['imm4@1010'] = update@{imm4=imm4}
val /vls1_type ['imm4@011.'] = update@{imm4=imm4}
val /vls1_type ['imm4@0010'] = update@{imm4=imm4}

# 4 bit vld2/vst2 type, can only be 1000/1001 (1 register), or 0011 (2 registers)
val /vls2_type ['imm4@100.'] = update@{imm4=imm4}
val /vls2_type ['imm4@0011'] = update@{imm4=imm4}

# 4 bit vld3/vst3 type, can only be 0100 (inc=1), or 0101 (inc=2)
val /vls3_type ['imm4@010.'] = update@{imm4=imm4}

# 4 bit vld4/vst4 type, can only be 0000 (inc=1), or 0001 (inc=2)
val /vls4_type ['imm4@000.'] = update@{imm4=imm4}

# --- data type subdecoders --------------------------------------------

# cmode for VBIC instruction, can only be 0001, 0011, 0101, 0111, 1001, or 1011 
val /cmode-bic ['cmode@0001'] = update@{cmode=cmode}
val /cmode-bic ['cmode@0011'] = update@{cmode=cmode}
val /cmode-bic ['cmode@0101'] = update@{cmode=cmode}
val /cmode-bic ['cmode@0111'] = update@{cmode=cmode}
val /cmode-bic ['cmode@1001'] = update@{cmode=cmode}
val /cmode-bic ['cmode@1011'] = update@{cmode=cmode}

# cmode for VMOV instruction with op=0, cannot be 1001, 1011, 0101, 0111, 0001, or 0011
val /cmode-mov0 ['cmode@0000'] = update@{cmode=cmode}
val /cmode-mov0 ['cmode@0010'] = update@{cmode=cmode}
val /cmode-mov0 ['cmode@0100'] = update@{cmode=cmode}
val /cmode-mov0 ['cmode@0110'] = update@{cmode=cmode}
val /cmode-mov0 ['cmode@1000'] = update@{cmode=cmode}
val /cmode-mov0 ['cmode@1010'] = update@{cmode=cmode}
val /cmode-mov0 ['cmode@1100'] = update@{cmode=cmode}
val /cmode-mov0 ['cmode@1101'] = update@{cmode=cmode}
val /cmode-mov0 ['cmode@1110'] = update@{cmode=cmode}
val /cmode-mov0 ['cmode@1111'] = update@{cmode=cmode}

# cmode for VMOV instruction with op=1, can only be 1110
val /cmode-mov1 ['cmode@1110'] = update@{cmode=cmode}

# cmode for VMVN instruction, can only be 0000, 0010, 0100, 0110, 1000, 1010, 1100, or 1101
val /cmode-mvn ['cmode@0000'] = update@{cmode=cmode}
val /cmode-mvn ['cmode@0010'] = update@{cmode=cmode}
val /cmode-mvn ['cmode@0100'] = update@{cmode=cmode}
val /cmode-mvn ['cmode@0110'] = update@{cmode=cmode}
val /cmode-mvn ['cmode@1000'] = update@{cmode=cmode}
val /cmode-mvn ['cmode@1010'] = update@{cmode=cmode}
val /cmode-mvn ['cmode@1100'] = update@{cmode=cmode}
val /cmode-mvn ['cmode@1101'] = update@{cmode=cmode}

# cmode for vorr instruction, can only be 0001, 0011, 0101, 0111, 1001, or 1011
val /cmode-vorr ['cmode@0001'] = update@{cmode=cmode}
val /cmode-vorr ['cmode@0011'] = update@{cmode=cmode}
val /cmode-vorr ['cmode@0101'] = update@{cmode=cmode}
val /cmode-vorr ['cmode@0111'] = update@{cmode=cmode}
val /cmode-vorr ['cmode@1001'] = update@{cmode=cmode}
val /cmode-vorr ['cmode@1011'] = update@{cmode=cmode}

val cmode = do
  cmode <- query $cmode;
  return (immediate (IMM4 (cmode)))
end

# --- imm6 subdecoders -------------------------------------------------

val /imm6 ['imm6:6'] = update@{imm6=imm6}

val /imm6-not000 ['imm6@0011..'] = update@{imm6=imm6}
val /imm6-not000 ['imm6@00101.'] = update@{imm6=imm6}
val /imm6-not000 ['imm6@001001'] = update@{imm6=imm6}
val /imm6-not000 ['imm6@011...'] = update@{imm6=imm6}
val /imm6-not000 ['imm6@0101..'] = update@{imm6=imm6}
val /imm6-not000 ['imm6@01001.'] = update@{imm6=imm6}
val /imm6-not000 ['imm6@010001'] = update@{imm6=imm6}
val /imm6-not000 ['imm6@11....'] = update@{imm6=imm6}
val /imm6-not000 ['imm6@101...'] = update@{imm6=imm6}
val /imm6-not000 ['imm6@1001..'] = update@{imm6=imm6}
val /imm6-not000 ['imm6@10001.'] = update@{imm6=imm6}
val /imm6-not000 ['imm6@100001'] = update@{imm6=imm6}




val imm6 = do
  imm6 <- query $imm6;
  return (immediate (IMM6 (imm6)))
end

# --- flag subdecoders -------------------------------------------------

val /P ['p:1'] = update@{p=p}
val /W ['w:1'] = update@{w=w}
val /U ['u:1'] = update@{u=u}
val /S ['s:1'] = update@{s=s}
val /D ['d:1'] = update@{d=d}

val /IFLAGS ['a:1 i:1 f:1'] = update@{iflags=(a^i^f)}

val p = do
  p <- query $p;
  return p
end

val w = do
  w <- query $w;
  return w
end

val u = do
  u <- query $u;
  return u
end

val s = do
  s <- query $s;
  return s
end

val d = do
  d <- query $d;
  return d
end

val iflags = do
  iflags <- query $iflags;
  return (immediate (IMM3 (iflags)))
end

val set0 = return '0'
val set1 = return '1'

val set00 = return (immediate (IMM2 '00'))
val set01 = return (immediate (IMM2 '01'))
val set10 = return (immediate (IMM2 '10'))
val set11 = return (immediate (IMM2 '11'))

val set000 = return (immediate (IMM3 '000'))
val set001 = return (immediate (IMM3 '001'))
val set010 = return (immediate (IMM3 '010'))
val set011 = return (immediate (IMM3 '011'))
val set100 = return (immediate (IMM3 '100'))
val set101 = return (immediate (IMM3 '101'))
val set110 = return (immediate (IMM3 '110'))
val set111 = return (immediate (IMM3 '111'))

val set0000 = return (immediate (IMM4 '0000'))
val set0001 = return (immediate (IMM4 '0001'))
val set0010 = return (immediate (IMM4 '0010'))
val set0011 = return (immediate (IMM4 '0011'))
val set0100 = return (immediate (IMM4 '0100'))
val set0101 = return (immediate (IMM4 '0101'))
val set0110 = return (immediate (IMM4 '0110'))
val set0111 = return (immediate (IMM4 '0111'))
val set1000 = return (immediate (IMM4 '1000'))
val set1001 = return (immediate (IMM4 '1001'))
val set1010 = return (immediate (IMM4 '1010'))
val set1011 = return (immediate (IMM4 '1011'))
val set1100 = return (immediate (IMM4 '1100'))
val set1101 = return (immediate (IMM4 '1101'))
val set1110 = return (immediate (IMM4 '1110'))
val set1111 = return (immediate (IMM4 '1111'))

# --- immediate subdecoders --------------------------------------------

# default 12 bit immediate
val /imm12 ['imm12:12'] = update@{imm12=imm12}

val imm12 = do
  imm12 <- query $imm12;
  return (immediate (IMM12 imm12))
end

val /imm24 ['a:8 b:8 c:8'] = update@{imm24=(a^b^c)}

val imm24 = do
  imm24 <- query $imm24;
  return (immediate (IMM24 imm24))
end

val sx-imm24 bitvec = do
  imm24 <- query $imm24;
  return (opnd-from-int (sx (imm24^bitvec)))
end

val /imm4H ['imm4H:4'] = update@{imm4H=imm4H}
val /imm4L ['imm4L:4'] = update@{imm4L=imm4L}

val combine-imm8 = do
  imm4H <- query $imm4H;
  imm4L <- query $imm4L;
  return (immediate (IMM8 (imm4H^imm4L)))
end

val /imm3 ['imm3:3'] = update@{imm3=imm3}

val /imm3_124 ['imm3@001'] = update@{imm3=imm3}
val /imm3_124 ['imm3@010'] = update@{imm3=imm3}
val /imm3_124 ['imm3@100'] = update@{imm3=imm3}

val imm3 = do
  imm3 <- query $imm3;
  return (immediate (IMM3 imm3))
end

val /imm4 ['imm4:4'] = update@{imm4=imm4}

val imm4 = do
  imm4 <- query $imm4;
  return (immediate (IMM4 imm4))
end

val /imm5 ['imm5:5'] = update@{imm5=imm5}

val imm5 = do
  imm5 <- query $imm5;
  return (immediate (IMM5 imm5))
end

val /imm8 ['imm8:8'] = update@{imm8=imm8}

val imm8 = do
  imm8 <- query $imm8;
  return (immediate (IMM8 imm8))
end

# concats the 4 bit and 12 bit immediates that were decoded most recently
val combine-imm16 = do
  imm4 <- query $imm4;
  imm12 <- query $imm12;
  return (immediate (IMM16 (imm4^imm12)))
end

# concats the 12 bit and 4 bit immediates that were decoded most recently
val combine-imm16-rev = do
  imm12 <- query $imm12;
  imm4 <- query $imm4;
  return (immediate (IMM16 (imm12^imm4)))
end

# modified 12 bit immediate (8 bit immediate with rotation)
val /modimm ['rot:4 byte:8'] = update@{rot=rot, byte=byte}

val modimm = do
  rot <- query $rot;
  byte <- query $byte;
  return (immediate (MODIMM {byte=byte, rot=rot}))
end

# endianess
val /E ['e:1'] = update@{e=e}

val e = do
  e <- query $e;
  return e
end

# m-bit
val /M ['m:1'] = update@{m=m}

val m = do
  m <- query $m;
  return m
end

# n-bit
val /N ['n:1'] = update@{n=n}

val n = do
  n <- query $n;
  return n
end

# f-bit
val /F ['f:1'] = update@{f=f}

val f = do
  f <- query $f;
  return f
end

# q-bit
val /Q ['q:1'] = update@{q=q}

val q = do
  q <- query $q;
  return q
end

# r-bit
val /r ['r:1'] = update@{r=r}

val r = do
  r <- query $r;
  return r
end

# a-bit
val /a ['a:1'] = update@{a=a}

val a = do
  a <- query $a;
  return a
end

# size-bit
val /sz ['sz:1'] = update@{sz=sz}

val sz = do
  sz <- query $sz;
  return sz
end

val /sz1 ['sz1:1'] = update@{sz1=sz1}

val sz1 = do
  sz1 <- query $sz1;
  return sz1
end

# operation-bit
val /op ['op:1'] = update@{op=op}

val op = do
  op <- query $op;
  return op
end

# i-bit
val /i ['i:1'] = update@{i=i}

val i = do
  i <- query $i;
  return i
end

val combine-imm5 = do
  imm4 <- query $imm4;
  i <- query $i;
  return (immediate (IMM5 (imm4^i)))
end

val imm64-asimd op = do
  cmode <- query $cmode;
  i <- query $i;
  imm3 <- query $imm3;
  imm4 <- query $imm4;

  return (advsimdexpandimm op cmode (i^imm3^imm4))
end

val imm32-vfp = do
  imm4L <- query $imm4L;
  imm4H <- query $imm4H;

  return (vfpexpandimm (imm4H^imm4L) 32)
end

val imm64-vfp = do
  imm4L <- query $imm4L;
  imm4H <- query $imm4H;

  return (vfpexpandimm (imm4H^imm4L) 64)
end

# length
val /len ['len:2'] = update@{len=len}

val len = do
  len <- query $len;
  return (immediate (IMM2 len))
end

# align
val /aligna ['aligna:2'] = update@{aligna=aligna}

val aligna = do
  aligna <- query $aligna;
  return (immediate (IMM2 aligna))
end

# opc12
val /opc12 ['opc12:2'] = update@{opc12=opc12}

val opc12 = do
  opc12 <- query $opc12;
  return (immediate (IMM2 opc12))
end

# opc22
val /opc22 ['opc22:2'] = update@{opc22=opc22}

val opc22 = do
  opc22 <- query $opc22;
  return (immediate (IMM2 opc22))
end

# combine-opc2
val combine-opc2 = do
  opc12 <- query $opc12;
  opc22 <- query $opc22;
  return (immediate (IMM4 (opc12^opc22)))
end

# combine-u-opc2
val combine-u-opc2 = do
  u <- query $u;
  opc12 <- query $opc12;
  opc22 <- query $opc22;
  return (immediate (IMM5 (u^opc12^opc22)))
end

# opc13
val /opc13 ['opc13:3'] = update@{opc13=opc13}

val opc13 = do
  opc13 <- query $opc13;
  return (immediate (IMM3 opc13))
end

# opc23
val /opc23 ['opc23:3'] = update@{opc23=opc23}

val opc23 = do
  opc23 <- query $opc23;
  return (immediate (IMM3 opc23))
end

# opc14
val /opc14 ['opc14:4'] = update@{opc14=opc14}

val opc14 = do
  opc14 <- query $opc14;
  return (immediate (IMM4 opc14))
end

# opc24
val /opc24 ['opc24:4'] = update@{opc24=opc24}

val opc24 = do
  opc24 <- query $opc24;
  return (immediate (IMM4 opc24))
end

# crd
val /crd ['crd:4'] = update@{crd=crd}

val crd = do
  crd <- query $crd;
  return (immediate (IMM4 crd))
end

# crn
val /crn ['crn:4'] = update@{crn=crn}

val crn = do
  crn <- query $crn;
  return (immediate (IMM4 crn))
end

# crm
val /crm ['crm:4'] = update@{crm=crm}

val crm = do
  crm <- query $crm;
  return (immediate (IMM4 crm))
end

# coproc (cannot be 1010 or 1011)
val /coproc ['coproc@0...'] = update@{coproc=coproc}
val /coproc ['coproc@11..'] = update@{coproc=coproc}
val /coproc ['coproc@100.'] = update@{coproc=coproc}

val coproc = do
  coproc <- query $coproc;
  return (immediate (IMM4 coproc))
end

# index_align
val /index_align ['index_align:4'] = update@{index_align=index_align}

val index_align = do
  index_align <- query $index_align;
  return (immediate (IMM4 index_align))
end

# most significant bit
val /msbit ['msbit:5'] = update@{msbit=msbit}

val msbit = do
  msbit <- query $msbit;
  return (immediate (IMM5 msbit))
end

# least significant bit
val /lsbit ['lsbit:5'] = update@{lsbit=lsbit}

val lsbit = do
  lsbit <- query $lsbit;
  return (immediate (IMM5 lsbit))
end

# imm5 representing width
val /widthm1 ['widthm1:5'] = update@{widthm1=widthm1}

val widthm1 = do
  widthm1 <- query $widthm1;
  return (immediate (IMM5 widthm1))
end

# --- shifted operand decoders -----------------------------------------

val /shfreg ['/immshift /rm'] = (return 0)
val /shfreg ['/regshift /rm'] = (return 0)
val /shfregshtp ['/immshiftshtp /rm'] = (return 0)
val /rotreg ['/immrotate /rm'] = (return 0)

# operand subdecoder: register + immediate shift
val /immshift ['imm5:5 stype:2 0'] = do
  imm <- return (immediate (IMM5 imm5));
  update@{shift={amount=imm, shifttype=(decode-shifttype stype)}}
end

# operand subdecoder: register + register controlled shift
val /regshift ['rs:4 0 stype:2 1'] = do
  reg <- return (register (decode-register rs));
  update@{shift={amount=reg, shifttype=(decode-shifttype stype)}}
end

# operand subdecoder: register + reduced options immediate shift
val /immshiftshtp ['imm5:5 shtp:1 01'] = do
  imm <- return (immediate (IMM5 imm5));
  update@{shift={amount=imm, shifttype=(decode-shifttype (shtp^'0'))}}
end

# operand subdecoder: register + immediate rotate-r
val /immrotate ['rotate:2 00 0111'] = do
  imm <- return (immediate (IMM5 (rotate^'000')));
  update@{shift={amount=imm, shifttype=ROR}}
end

val shfreg = do
  shift <- query $shift;
  rm <- query $rm;
  return (shiftedoperand {opnd=(register rm), shift=shift})
end

val rotreg = do
  shift <- query $shift;
  rm <- query $rm;
  return (shiftedoperand {opnd=(register rm), shift=shift})
end

# --- operand list/register list subdecoders ---------------------------

val /reglst ['regs:16'] = update@{operands=(decode-registerlist regs)}
val /reglst15 ['regs:15'] = update@{operands=(decode-registerlist regs)}

val reglst = do
  operands <- query $operands;
  return (operandlist operands)
end

val reglst-one rx = do
  reg <- rx;
  return (operandlist (opndl-one reg))
end

# --- vector subdecoders -----------------------------------------------
# vd
val /vd ['vd:4'] = update@{vd=vd}

val vd = do
  q <- query $q;
  d <- query $d;
  vd <- query $vd;
  return (vector {change=q, first=d, remainder=vd})
end

val vdq0 = do
  d <- query $d;
  vd <- query $vd;
  return (vector {change='0', first=d, remainder=vd})
end

val vdq1 = do
  d <- query $d;
  vd <- query $vd;
  return (vector {change='1', first=d, remainder=vd})
end

# vn
val /vn ['vn:4'] = update@{vn=vn}

val vn = do
  q <- query $q;
  n <- query $n;
  vn <- query $vn;
  return (vector {change=q, first=n, remainder=vn})
end

val vnq0 = do
  n <- query $n;
  vn <- query $vn;
  return (vector {change='0', first=n, remainder=vn})
end

val vnq1 = do
  n <- query $n;
  vn <- query $vn;
  return (vector {change='1', first=n, remainder=vn})
end

val vnn0 = do
  q <- query $q;
  vn <- query $vn;
  return (vector {change=q, first='0', remainder=vn})
end

val vnn1 = do
  q <- query $q;
  vn <- query $vn;
  return (vector {change=q, first='1', remainder=vn})
end

# vm
val /vm ['vm:4'] = update@{vm=vm}

val vm = do
  q <- query $q;
  m <- query $m;
  vm <- query $vm;
  return (vector {change=q, first=m, remainder=vm})
end

val vmq0 = do
  m <- query $m;
  vm <- query $vm;
  return (vector {change='0', first=m, remainder=vm})
end

val vmq1 = do
  m <- query $m;
  vm <- query $vm;
  return (vector {change='1', first=m, remainder=vm})
end

val vmm0 = do
  q <- query $q;
  vm <- query $vm;
  return (vector {change=q, first='0', remainder=vm})
end

val vmm1 = do
  q <- query $q;
  vm <- query $vm;
  return (vector {change=q, first='1', remainder=vm})
end

val vm000000 = do
  return (vector {change='0', first='0', remainder='0000'})
end

val vm100000 = do
  return (vector {change='1', first='0', remainder='0000'})
end

# --- register subdecoders ---------------------------------------------

val /ra ['ra:4'] = update@{ra=(decode-register ra)}
val /rd ['rd:4'] = update@{rd=(decode-register rd)}
val /rm ['rm:4'] = update@{rm=(decode-register rm)}
val /rn ['rn:4'] = update@{rn=(decode-register rn)}
val /rt ['rt:4'] = update@{rt=(decode-register rt)}
val /rt2 ['rt2:4'] = update@{rt2=(decode-register rt2)}

val /rdhi ['rdhi:4'] = update@{rdhi=(decode-register rdhi)}
val /rdlo ['rdlo:4'] = update@{rdlo=(decode-register rdlo)}

val ra = do
  ra <- query $ra;
  return (register ra)
end

val rd = do
  rd <- query $rd;
  return (register rd)
end

val rm = do
  rm <- query $rm;
  return (register rm)
end

val rn = do
  rn <- query $rn;
  return (register rn)
end

val rt = do
  rt <- query $rt;
  return (register rt)
end

val rt2 = do
  rt2 <- query $rt2;
  return (register rt2)
end

val rdhi = do
  rdhi <- query $rdhi;
  return (register rdhi)
end

val rdlo = do
  rdlo <- query $rdlo;
  return (register rdlo)
end

val r0 = return (register R0)

val r15 = return (register R15)

# --- special cases ----------------------------------------------------

val /rn-not15 ['rn@0...'] = update@{rn=(decode-register rn)}
val /rn-not15 ['rn@10..'] = update@{rn=(decode-register rn)}
val /rn-not15 ['rn@110.'] = update@{rn=(decode-register rn)}
val /rn-not15 ['rn@1110'] = update@{rn=(decode-register rn)}

val /ra-not15 ['ra@0...'] = update@{ra=(decode-register ra)}
val /ra-not15 ['ra@10..'] = update@{ra=(decode-register ra)}
val /ra-not15 ['ra@110.'] = update@{ra=(decode-register ra)}
val /ra-not15 ['ra@1110'] = update@{ra=(decode-register ra)}

# ----------------------------------------------------------------------
# Instruction Decoding
# ----------------------------------------------------------------------

# --- Branching Instructions -------------------------------------------

### B
### - Branch
val / ['/cond 101 0 imm24:24'] = unop B cond (sx-imm24 '00')

### BL
###  - Branch with Link
val / ['/cond 101 1 imm24:24'] = unop BL cond (sx-imm24 '00')

### BLX
###  - Branch with Link and Exchange (Immediate)
val / ['1111 101 h:1 imm24:24'] = unop BLX none (sx-imm24 (h^'0'))
###  - Branch with Link and Exchange (Register)
val / ['/cond 000 1 0 0 1 0 1111 1111 1111 0011 /rm'] = unop BLX cond rm

### BX
### - Branch and Exchange
val / ['/cond 000 1 0 0 1 0 1111 1111 1111 0001 /rm'] = unop BX cond rm

### BXJ
###  - Branch and Exchange Jazelle
val / ['/cond 000 1 0 0 1 0 1111 1111 1111 0010 /rm'] = unop BXJ cond rm

# --- Data Processing Instructions -------------------------------------

### ADC
###  - Add with Carry (immediate)
val / ['/cond 001 0 1 0 1 /S /rn /rd /modimm'] = unbitTernop ADC cond s rn rd modimm
###  - Add with Carry (shifted register)
val / ['/cond 000 0 1 0 1 /S /rn /rd /shfreg'] = unbitTernop ADC cond s rn rd shfreg

### ADD
###  - Add (immediate)
val / ['/cond 001 0 1 0 0 /S /rn-not15 /rd /modimm'] = unbitTernop ADD cond s rn rd modimm
###  - Add (shifted register)
val / ['/cond 000 0 1 0 0 /S /rn /rd /shfreg'] = unbitTernop ADD cond s rn rd shfreg

### ADR
###  - ADR (Encoding A1)
val / ['/cond 001 0 1 0 0 0 1111 /rd /modimm'] = unbitTernop ADR cond set1 r15 rd modimm
###  - ADR (Encoding A2)
val / ['/cond 001 0 0 1 0 0 1111 /rd /modimm'] = unbitTernop ADR cond set0 r15 rd modimm

### AND
###  - And (immediate)
val / ['/cond 001 0 0 0 0 /S /rn /rd /modimm'] = unbitTernop AND cond s rn rd modimm
###  - And (shifted register)
val / ['/cond 000 0 0 0 0 /S /rn /rd /shfreg'] = unbitTernop AND cond s rn rd shfreg

### BIC
###  - Bitwise Bit Clear (immediate)
val / ['/cond 001 1 1 1 0 /S /rn /rd /modimm'] = unbitTernop BIC cond s rn rd modimm
###  - Bitwise Bit Clear (shifted register)
val / ['/cond 000 1 1 1 0 /S /rn /rd /shfreg'] = unbitTernop BIC cond s rn rd shfreg

### CMN
###  - Compare Negative (immediate)
val / ['/cond 001 1 0 1 1 1 /rn 0000 /modimm'] = unbitTernop CMN cond set1 rn r0 modimm
###  - Compare Negative (shifted register)
val / ['/cond 000 1 0 1 1 1 /rn 0000 /shfreg'] = unbitTernop CMN cond s rn r0 shfreg

### CMP
###  - Compare (immediate)
val / ['/cond 001 1 0 1 0 1 /rn 0000 /modimm'] = unbitTernop CMP cond set1 rn r0 modimm
###  - Compare (shifted register)
val / ['/cond 000 1 0 1 0 1 /rn 0000 /shfreg'] = unbitTernop CMP cond set1 rn r0 shfreg

### EOR
###  - Bitwise Exclusive OR (immediate)
val / ['/cond 001 0 0 0 1 /S /rn /rd /modimm'] = unbitTernop EOR cond s rn rd modimm
###  - Bitwise Exclusive OR (shifted register)
val / ['/cond 000 0 0 0 1 /S /rn /rd /shfreg'] = unbitTernop EOR cond s rn rd shfreg

### MOV
###  - Move (immediate) (Encoding A1)
val / ['/cond 001 1 1 0 1 /S 0000 /rd /modimm'] = unbitTernop MOV cond s r0 rd modimm
###  - Move (immediate) (Encoding A2)
val / ['/cond 001 1 0 0 0 0 /imm4 /rd /imm12'] = unbitTernop MOV cond set0 r0 rd combine-imm16
###  - Move (shifted register)
val / ['/cond 000 1 1 0 1 /S 0000 /rd /shfreg'] = unbitTernop MOV cond s r0 rd shfreg

### MVN
###  - Bitwise NOT (immediate)
val / ['/cond 001 1 1 1 1 /S 0000 /rd /modimm'] = unbitTernop MVN cond s r0 rd modimm
###  - Bitwise NOT (shifted register)
val / ['/cond 000 1 1 1 1 /S 0000 /rd /shfreg'] = unbitTernop MVN cond s r0 rd shfreg

### ORR
###  - Bitwise OR (immediate)
val / ['/cond 001 1 1 0 0 /S /rn /rd /modimm'] = unbitTernop ORR cond s rn rd modimm
###  - Bitwise OR (shifted register)
val / ['/cond 000 1 1 0 0 /S /rn /rd /shfreg'] = unbitTernop ORR cond s rn rd shfreg

### RSB
###  - Reverse Subtract (immediate)
val / ['/cond 001 0 0 1 1 /S /rn /rd /modimm'] = unbitTernop RSB cond s rn rd modimm
###  - Reverse Subtract (shifted-register)
val / ['/cond 000 0 0 1 1 /S /rn /rd /shfreg'] = unbitTernop RSB cond s rn rd shfreg

### RSC
###  - Reverse Subtract with Carry (immediate)
val / ['/cond 001 0 1 1 1 /S /rn /rd /modimm'] = unbitTernop RSC cond s rn rd modimm
###  - Reverse Subtract with Carry (shifted register)
val / ['/cond 000 0 1 1 1 /S /rn /rd /shfreg'] = unbitTernop RSC cond s rn rd shfreg

### SBC
###  - Subtract with Carry (immediate)
val / ['/cond 001 0 1 1 0 /S /rn /rd /modimm'] = unbitTernop SBC cond s rn rd modimm
###  - Subtract with Carry (shifted register)
val / ['/cond 000 0 1 1 0 /S /rn /rd /shfreg'] = unbitTernop SBC cond s rn rd shfreg

### SUB
###  - Subtract (immediate)
val / ['/cond 001 0 0 1 0 /S /rn-not15 /rd /modimm'] = unbitTernop SUB cond s rn rd modimm
###  - Subtract (shifted register)
val / ['/cond 000 0 0 1 0 /S /rn /rd /shfreg'] = unbitTernop SUB cond s rn rd shfreg

### TEQ
###  - Test Equivalence (immediate)
val / ['/cond 001 1 0 0 1 1 /rn 0000 /modimm'] = unbitTernop TEQ cond set1 rn r0 modimm
###  - Test Equivalence (shifted register)
val / ['/cond 000 1 0 0 1 1 /rn 0000 /shfreg'] = unbitTernop TEQ cond set1 rn r0 shfreg

### TST
###  - Test (immediate)
val / ['/cond 001 1 0 0 0 1 /rn 0000 /modimm'] = unbitTernop TST cond set1 rn r0 modimm
###  - Test (shifted register)
val / ['/cond 000 1 0 0 0 1 /rn 0000 /shfreg'] = unbitTernop TST cond s rn r0 shfreg

# --- Shift instructions -----------------------------------------------

(* NOTE: These instructions are implemented by MOV (shifted register) *)

# --- Multiply instructions --------------------------------------------

### MLA
###  - Multiply Accumulate
val / ['/cond 000 0 0 0 1 /S /rd /ra /rm 1001 /rn'] = unbitQuaternop MLA cond s rd ra rm rn

### MLS
###  - Multiply and Subtract
val / ['/cond 000 0 0 1 1 0 /rd /ra /rm 1001 /rn'] = unbitQuaternop MLS cond set0 rd ra rm rn

### MUL
###  - Multiply
val / ['/cond 000 0 0 0 0 /S /rd 0000 /rm 1001 /rn'] = unbitQuaternop MUL cond s rd r0 rm rn

### SMLABB
###  - Signed Multiply Accumulate Bottom Bottom
val / ['/cond 000 1 0 0 0 0 /rd /ra /rm 1000 /rn'] = unbitQuaternop SMLABB cond set0 rd ra rm rn

### SMLABT
###  - Signed Multiply Accumulate Bottom Top
val / ['/cond 000 1 0 0 0 0 /rd /ra /rm 1100 /rn'] = unbitQuaternop SMLABT cond set0 rd ra rm rn

### SMLATB
###  - Signed Multiply Accumulate Top Bottom
val / ['/cond 000 1 0 0 0 0 /rd /ra /rm 1010 /rn'] = unbitQuaternop SMLATB cond set0 rd ra rm rn

### SMLATT
###  - Signed Multiply Accumulate Top Top
val / ['/cond 000 1 0 0 0 0 /rd /ra /rm 1110 /rn'] = unbitQuaternop SMLATT cond set0 rd ra rm rn

### SMLAD
###  - Signed Multiply Accumulate Dual
val / ['/cond 011 1 0 0 0 0 /rd /ra-not15 /rm 0001 /rn'] = unbitQuaternop SMLAD cond set0 rd ra rm rn

### SMLADX
###  - Signed Multiply Accumulate Dual Exchange
val / ['/cond 011 1 0 0 0 0 /rd /ra-not15 /rm 0011 /rn'] = unbitQuaternop SMLADX cond set0 rd ra rm rn

### SMLAL
###  - Signed Multiply Accumulate Long
val / ['/cond 000 0 1 1 1 /S /rdhi /rdlo /rm 1001 /rn'] = unbitQuaternop SMLAL cond s rdhi rdlo rm rn

### SMLALBB
###  - signed Multiply Accumulate Long Bottom Bottom
val / ['/cond 000 1 0 1 0 0 /rdhi /rdlo /rm 1000 /rn'] = unbitQuaternop SMLALBB cond set0 rdhi rdlo rm rn

### SMLALBT
###  - signed Multiply Accumulate Long Bottom Top
val / ['/cond 000 1 0 1 0 0 /rdhi /rdlo /rm 1100 /rn'] = unbitQuaternop SMLALBT cond set0 rdhi rdlo rm rn

### SMLALTB
###  - signed Multiply Accumulate Long Top Bottom
val / ['/cond 000 1 0 1 0 0 /rdhi /rdlo /rm 1010 /rn'] = unbitQuaternop SMLALTB cond set0 rdhi rdlo rm rn

### SMLALTT
###  - signed Multiply Accumulate Long Top Top
val / ['/cond 000 1 0 1 0 0 /rdhi /rdlo /rm 1110 /rn'] = unbitQuaternop SMLALTT cond set0 rdhi rdlo rm rn

### SMLALD
###  - Signed Multiply Accumulate Long Dual
val / ['/cond 011 1 0 1 0 0 /rdhi /rdlo /rm 0001 /rn'] = unbitQuaternop SMLALD cond set0 rdhi rdlo rm rn

### SMLALDX
###  - Signed Multiply Accumulate Long Dual Exchange
val / ['/cond 011 1 0 1 0 0 /rdhi /rdlo /rm 0011 /rn'] = unbitQuaternop SMLALDX cond set0 rdhi rdlo rm rn

### SMLAWB
###  - Signed Multiply Accumulate Word Bottom
val / ['/cond 000 1 0 0 1 0 /rd /ra /rm 1000 /rn'] = unbitQuaternop SMLAWB cond set0 rd ra rm rn

### SMLAWT
###  - Signed Multiply Accumulate Word Top
val / ['/cond 000 1 0 0 1 0 /rd /ra /rm 1100 /rn'] = unbitQuaternop SMLAWT cond set0 rd ra rm rn

### SMLSD
###  - Signed Multiply Subtract Dual
val / ['/cond 011 1 0 0 0 0 /rd /ra-not15 /rm 0101 /rn'] = unbitQuaternop SMLSD cond set0 rd ra rm rn

### SMLSDX
###  - Signed Multiply Subtract Dual Exchange
val / ['/cond 011 1 0 0 0 0 /rd /ra-not15 /rm 0111 /rn'] = unbitQuaternop SMLSDX cond set0 rd ra rm rn

### SMLSLD
###  - Signed Multiply Subtract Long Dual
val / ['/cond 011 1 0 1 0 0 /rdhi /rdlo /rm 0101 /rn'] = unbitQuaternop SMLSLD cond set0 rdhi rdlo rm rn

### SMLSLDX
###  - Signed Multiply Subtract Long Dual Exchange
val / ['/cond 011 1 0 1 0 0 /rdhi /rdlo /rm 0111 /rn'] = unbitQuaternop SMLSLDX cond set0 rdhi rdlo rm rn

### SMMLA
###  - Signed Most Significant Word Multiply Accumulate
val / ['/cond 011 1 0 1 0 1 /rd /ra-not15 /rm 0001 /rn'] = unbitQuaternop SMMLA cond set1 rd ra rm rn

### SMMLAR
###  - Signed Most Significant Word Multiply Accumulate Round
val / ['/cond 011 1 0 1 0 1 /rd /ra-not15 /rm 0011 /rn'] = unbitQuaternop SMMLAR cond set1 rd ra rm rn

### SMMLS
###  - Signed Most Significant Word Multiply Subtract
val / ['/cond 011 1 0 1 0 1 /rd /ra /rm 1101 /rn'] = unbitQuaternop SMMLS cond set1 rd ra rm rn

### SMMLSR
###  - Signed Most Significant Word Multiply Subtract Round
val / ['/cond 011 1 0 1 0 1 /rd /ra /rm 1111 /rn'] = unbitQuaternop SMMLSR cond set1 rd ra rm rn

### SMMUL
###  - Signed Most Significant Word Multiply
val / ['/cond 011 1 0 1 0 1 /rd 1111 /rm 0001 /rn'] = unbitQuaternop SMMUL cond set1 rd r15 rm rn

### SMMULR
###  - Signed Most Significant Word Multiply Round
val / ['/cond 011 1 0 1 0 1 /rd 1111 /rm 0011 /rn'] = unbitQuaternop SMMULR cond set1 rd r15 rm rn

### SMUAD
###  - Signed Dual Multiply Add
val / ['/cond 011 1 0 0 0 0 /rd 1111 /rm 0001 /rn'] = unbitQuaternop SMUAD cond set0 rd r15 rm rn

### SMUADX
###  - Signed Dual Multiply Add
val / ['/cond 011 1 0 0 0 0 /rd 1111 /rm 0011 /rn'] = unbitQuaternop SMUADX cond set0 rd r15 rm rn

### SMULBB
###  - Signed Multiply Bottom Bottom
val / ['/cond 000 1 0 1 1 0 /rd 0000 /rm 1000 /rn'] = unbitQuaternop SMULBB cond set0 rd r0 rm rn

### SMULBT
###  - Signed Multiply Bottom Top
val / ['/cond 000 1 0 1 1 0 /rd 0000 /rm 1100 /rn'] = unbitQuaternop SMULBT cond set0 rd r0 rm rn

### SMULTB
###  - Signed Multiply Top Bottom
val / ['/cond 000 1 0 1 1 0 /rd 0000 /rm 1010 /rn'] = unbitQuaternop SMULTB cond set0 rd r0 rm rn

### SMULTT
###  - Signed Multiply Top Top
val / ['/cond 000 1 0 1 1 0 /rd 0000 /rm 1110 /rn'] = unbitQuaternop SMULTT cond set0 rd r0 rm rn

### SMULL
###  - Signed Multiply Long
val / ['/cond 000 0 1 1 0 /S /rdhi /rdlo /rm 1001 /rn'] = unbitQuaternop SMULL cond s rdhi rdlo rm rn

### SMULWB
###  - Signed Multiply Word Bottom
val / ['/cond 000 1 0 0 1 0 /rd 0000 /rm 1010 /rn'] = unbitQuaternop SMULWB cond set0 rd r0 rm rn

### SMULWT
###  - Signed Multiply Word Top
val / ['/cond 000 1 0 0 1 0 /rd 0000 /rm 1110 /rn'] = unbitQuaternop SMULWT cond set0 rd r0 rm rn

### SMUSD
###  - Signed Multiply Subtract Dual
val / ['/cond 011 1 0 0 0 0 /rd 1111 /rm 0101 /rn'] = unbitQuaternop SMUSD cond set0 rd r0 rm rn

### SMUSDX
###  - Signed Multiply Subtract Dual Exchange
val / ['/cond 011 1 0 0 0 0 /rd 1111 /rm 0111 /rn'] = unbitQuaternop SMUSDX cond set0 rd r0 rm rn

### UMAAL
###  - Unsigned Multiply Accumulate Accumulate Long
val / ['/cond 000 0 0 1 0 0 /rdhi /rdlo /rm 1001 /rn'] = unbitQuaternop UMAAL cond set0 rdhi rdlo rm rn

### UMLAL
###  - Unsigned Multiply Accumulate Long
val / ['/cond 000 0 1 0 1 /S /rdhi /rdlo /rm 1001 /rn'] = unbitQuaternop UMLAL cond s rdhi rdlo rm rn

### UMULL
###  - Unsigned Multiply Long
val / ['/cond 000 0 1 0 0 /S /rdhi /rdlo /rm 1001 /rn'] = unbitQuaternop UMULL cond s rdhi rdlo rm rn

# --- Saturating instructions ------------------------------------------

### SSAT
###  - Signed Saturate (* TODO: Maybe replace imm5 with correct #<imm5> representation. *)
val / ['/cond 011 0 1 0 1 /imm5 /rd /shfregshtp'] = ternop SSAT cond imm5 rd shfreg

### SSAT16
###  - Signed Saturate 16 (* TODO: Maybe replace imm4 with correct #<imm4> representation. *)
val / ['/cond 011 0 1 0 1 0 /imm4 /rd 1111 0011 /rn'] = ternop SSAT16 cond imm4 rd rn

### USAT
### - Unsigned Saturate
val / ['/cond 011 0 1 1 1 /imm5 /rd /shfregshtp'] = ternop USAT cond imm5 rd shfreg

### USAT16
### - Unsigned Saturate 16
val / ['/cond 011 0 1 1 1 0 /imm4 /rd 1111 0011 /rn'] = ternop USAT16 cond imm4 rd rn

# --- Saturating addition and Subtraction instructions ----------------

### QADD
###  - Saturating Add
val / ['/cond 000 1 0 0 0 0 /rn /rd 0000 0101 /rm'] = ternop QADD cond rn rd rm

### QSUB
###  - Saturating Subtract
val / ['/cond 000 1 0 0 1 0 /rn /rd 0000 0101 /rm'] = ternop QSUB cond rn rd rm

### QDADD
###  - Saturating Double and Add
val / ['/cond 000 1 0 1 0 0 /rn /rd 0000 0101 /rm'] = ternop QDADD cond rn rd rm

### QDSUB
###  - Saturating Double and Subtract
val / ['/cond 000 1 0 1 1 0 /rn /rd 0000 0101 /rm'] = ternop QDSUB cond rn rd rm

# --- Packing and unpacking instructions -------------------------------

### PKH
###  - Pack Halfword
val / ['/cond 011 0 1 0 0 0 /rn /rd /shfregshtp'] = ternop PKH cond rn rd shfreg

### SXTAB
###  - Signed Extend and Add Byte
val / ['/cond 011 0 1 0 1 0 /rn-not15 /rd /rotreg'] = ternop SXTAB cond rn rd rotreg

### SXTAB16
###  - Signed Extend and Add Byte 16
val / ['/cond 011 0 1 0 0 0 /rn-not15 /rd /rotreg'] = ternop SXTAB16 cond rn rd rotreg

### SXTAH
###  - Signed Extend and Add Halfword
val / ['/cond 011 0 1 0 1 1 /rn-not15 /rd /rotreg'] = ternop SXTAH cond rn rd rotreg

### SXTB
###  - Signed Extend Byte
val / ['/cond 011 0 1 0 1 0 1111 /rd /rotreg'] = ternop SXTB cond r15 rd rotreg

### SXTB16
###  - Signed Extend Byte 16
val / ['/cond 011 0 1 0 0 0 1111 /rd /rotreg'] = ternop SXTB16 cond r15 rd rotreg

### SXTH
###  - Signed Extend Halfword
val / ['/cond 011 0 1 0 1 1 1111 /rd /rotreg'] = ternop SXTH cond r15 rd rotreg

### UXTAB
###  - Unsigned Extend and Add Byte
val / ['/cond 011 0 1 1 1 0 /rn-not15 /rd /rotreg'] = ternop UXTAB cond rn rd rotreg

### UXTAB16
###  - Unsigned Extend and Add Byte 16
val / ['/cond 011 0 1 1 0 0 /rn-not15 /rd /rotreg'] = ternop UXTAB16 cond rn rd rotreg

### UXTAH
###  - Unsigned Extend and Add Halfword
val / ['/cond 011 0 1 1 1 1 /rn-not15 /rd /rotreg'] = ternop UXTAH cond rn rd rotreg

### UXTB
###  - Unsigned Extend Byte
val / ['/cond 011 0 1 1 1 0 1111 /rd /rotreg'] = ternop UXTB cond r15 rd rotreg

### UXTB16
###  - Unsigned Extend Byte 16
val / ['/cond 011 0 1 1 0 0 1111 /rd /rotreg'] = ternop UXTB16 cond r15 rd rotreg

### UXTH
###  - Unsigned Extend Halfword
val / ['/cond 011 0 1 1 1 1 1111 /rd /rotreg'] = ternop UXTH cond r15 rd rotreg

# --- Parallel addition and Subtraction instructions ------------------

### SADD16
###  - Signed Add 16
val / ['/cond 011 0 0 0 0 1 /rn /rd 1111 0001 /rm'] = ternop SADD16 cond rn rd rm

### SASX
###  - Signed Add and Subtract with Extend
val / ['/cond 011 0 0 0 0 1 /rn /rd 1111 0011 /rm'] = ternop SASX cond rn rd rm

### SSAX
###  - Signed Subtract and Add with Exchange
val / ['/cond 011 0 0 0 0 1 /rn /rd 1111 0101 /rm'] = ternop SSAX cond rn rd rm

### SSUB16
###  - Signed Subtract 16
val / ['/cond 011 0 0 0 0 1 /rn /rd 1111 0111 /rm'] = ternop SSUB16 cond rn rd rm

### SADD8
###  - Signed Add 8
val / ['/cond 011 0 0 0 0 1 /rn /rd 1111 1001 /rm'] = ternop SADD8 cond rn rd rm

### SSUB8
###  - Signed Subtract 8
val / ['/cond 011 0 0 0 0 1 /rn /rd 1111 1111 /rm'] = ternop SSUB8 cond rn rd rm

### QADD16
###  - Saturating Add 16
val / ['/cond 011 0 0 0 1 0 /rn /rd 1111 0001 /rm'] = ternop QADD16 cond rn rd rm

### QASX
###  - Saturating Add and Subtract with Exchange
val / ['/cond 011 0 0 0 1 0 /rn /rd 1111 0011 /rm'] = ternop QASX cond rn rd rm

### QSAX
###  - Saturating Subtract and Add with Exchange
val / ['/cond 011 0 0 0 1 0 /rn /rd 1111 0101 /rm'] = ternop QSAX cond rn rd rm

### QSUB16
###  - Saturating Subtract 16
val / ['/cond 011 0 0 0 1 0 /rn /rd 1111 0111 /rm'] = ternop QSUB16 cond rn rd rm

### QADD8
###  - Saturating Add 8
val / ['/cond 011 0 0 0 1 0 /rn /rd 1111 1001 /rm'] = ternop QADD8 cond rn rd rm

### QSUB8
###  - Saturating Subtract 8
val / ['/cond 011 0 0 0 1 0 /rn /rd 1111 1111 /rm'] = ternop QSUB8 cond rn rd rm

### SHADD16
###  - Signed Halbing Add 16
val / ['/cond 011 0 0 0 1 1 /rn /rd 1111 0001 /rm'] = ternop SHADD16 cond rn rd rm

### SHASX
###  - Signed Halving Add and Subtract with Exchange
val / ['/cond 011 0 0 0 1 1 /rn /rd 1111 0011 /rm'] = ternop SHASX cond rn rd rm

### SHSAX
###  - Signed Halving Subtract and Add with Exchange
val / ['/cond 011 0 0 0 1 1 /rn /rd 1111 0101 /rm'] = ternop SHSAX cond rn rd rm

### SHSUB16
###  - Signed Halving Subtract 16
val / ['/cond 011 0 0 0 1 1 /rn /rd 1111 0111 /rm'] = ternop SHSUB16 cond rn rd rm

### SHADD8
###  - Signed Halving Add 8
val / ['/cond 011 0 0 0 1 1 /rn /rd 1111 1001 /rm'] = ternop SHADD8 cond rn rd rm

### SHSUB8
###  - Signed Halving Subtract 8
val / ['/cond 011 0 0 0 1 1 /rn /rd 1111 1111 /rm'] = ternop SHSUB8 cond rn rd rm

### UADD16
###  - Unsigned Add 16
val / ['/cond 011 0 0 1 0 1 /rn /rd 1111 0001 /rm'] = ternop UADD16 cond rn rd rm

### UASX
###  - Unsigned Add and Subtract with Exchange
val / ['/cond 011 0 0 1 0 1 /rn /rd 1111 0011 /rm'] = ternop UASX cond rn rd rm

### USAX
###  - Unsigned Subtract and Add with Exchange
val / ['/cond 011 0 0 1 0 1 /rn /rd 1111 0101 /rm'] = ternop USAX cond rn rd rm

### USUB16
###  - Unsigned Subtract 16
val / ['/cond 011 0 0 1 0 1 /rn /rd 1111 0111 /rm'] = ternop USUB16 cond rn rd rm

### UADD8
###  - Unsigned Add 8
val / ['/cond 011 0 0 1 0 1 /rn /rd 1111 1001 /rm'] = ternop UADD8 cond rn rd rm

### USUB8
###  - Unsigned Subtract 8
val / ['/cond 011 0 0 1 0 1 /rn /rd 1111 1111 /rm'] = ternop USUB8 cond rn rd rm

### UQADD16
###  - Unsigned Saturating Add 16
val / ['/cond 011 0 0 1 1 0 /rn /rd 1111 0001 /rm'] = ternop UQADD16 cond rn rd rm

### UQASX
###  - Unsigned Saturating Add and Subtract with Exchange
val / ['/cond 011 0 0 1 1 0 /rn /rd 1111 0011 /rm'] = ternop UQASX cond rn rd rm

### UQSAX
###  - Unsigned Saturating Subtract and Add with Exchange
val / ['/cond 011 0 0 1 1 0 /rn /rd 1111 0101 /rm'] = ternop UQSAX cond rn rd rm 

### UQSUB16
###  - Unsigned Saturating Subtract 16
val / ['/cond 011 0 0 1 1 0 /rn /rd 1111 0111 /rm'] = ternop UQSUB16 cond rn rd rm

### UQADD8
###  - Unsigned Saturating Add 8
val / ['/cond 011 0 0 1 1 0 /rn /rd 1111 1001 /rm'] = ternop UQADD8 cond rn rd rm

### UQSUB8
###  - Unsigned Saturating Sub 8
val / ['/cond 011 0 0 1 1 0 /rn /rd 1111 1111 /rm'] = ternop UQSUB8 cond rn rd rm

### UHADD16
###  - Unsigned Halving Add 16
val / ['/cond 011 0 0 1 1 1 /rn /rd 1111 0001 /rm'] = ternop UHADD16 cond rn rd rm

### UHASX
###  - Unsigned Halving Add and Subtract with Exchange
val / ['/cond 011 0 0 1 1 1 /rn /rd 1111 0011 /rm'] = ternop UHASX cond rn rd rm

### UHSAX
###  - Unsigned Halving Subtract and Add with Exchange
val / ['/cond 011 0 0 1 1 1 /rn /rd 1111 0101 /rm'] = ternop UHSAX cond rn rd rm

### UHSUB16
###  - Unsigned Halving Subtract 16
val / ['/cond 011 0 0 1 1 1 /rn /rd 1111 0111 /rm'] = ternop UHSUB16 cond rn rd rm

### UHADD8
###  - Unsigned Halving Add 8
val / ['/cond 011 0 0 1 1 1 /rn /rd 1111 1001 /rm'] = ternop UHADD8 cond rn rd rm

### UHSUB8
###  - Unsigned Halving Subtract 8
val / ['/cond 011 0 0 1 1 1 /rn /rd 1111 1111 /rm'] = ternop UHSUB8 cond rn rd rm

# --- Divide instructions ----------------------------------------------

### SDIV
###  - Signed Divide
val / ['/cond 011 1 0 0 0 1 /rd 1111 /rm 0001 /rn'] = ternop SDIV cond rn rd rm

### UDIV
###  - Unsigned Divide
val / ['/cond 011 1 0 0 1 1 /rd 1111 /rm 0001 /rn'] = ternop UDIV cond rn rd rm

# --- Miscellaneous data-processing instructions -----------------------

### BFC
###  - Bit Field Clear
val / ['/cond 011 1 1 1 0 /msbit /rd /lsbit 0 0 1 1111'] = quaternop BFC cond msbit rd lsbit r15

### BFI
###  - Bit Field Insert
val / ['/cond 011 1 1 1 0 /msbit /rd /lsbit 0 0 1 /rn-not15'] = quaternop BFI cond msbit rd lsbit rn

### CLZ
###  - Count Leading Zeros
val / ['/cond 000 1 0 1 1 0 1111 /rd 1111 0001 /rm'] = binop CLZ cond rd rm

### MOVT
###  - Move Top
val / ['/cond 001 1 0 1 0 0 /imm4 /rd /imm12'] = binop MOVT cond rd combine-imm16

### RBIT
###  - Reverse Bits
val / ['/cond 011 0 1 1 1 1 1111 /rd 1111 0011 /rm'] = binop RBIT cond rd rm

### REV
###  - Byte-Reverse Word
val / ['/cond 011 0 1 0 1 1 1111 /rd 1111 0011 /rm'] = binop REV cond rd rm

### REV16
###  - Byte-Reverse Packed Halfword
val / ['/cond 011 0 1 0 1 1 1111 /rd 1111 1011 /rm'] = binop REV16 cond rd rm

### REVSH
###  - Byte-Reverse Signed Halfword
val / ['/cond 011 0 1 1 1 1 1111 /rd 1111 1011 /rm'] = binop REVSH cond rd rm

### SBFX
###  - Signed Bit Field Extract
val / ['/cond 011 1 1 0 1 /widthm1 /rd /lsbit 1 0 1 /rn'] = quaternop SBFX cond widthm1 rd lsbit rn

### SEL
###  - Select Bytes
val / ['/cond 011 0 1 0 0 0 /rn /rd 1111 1011 /rm'] = ternop SEL cond rn rd rm

### UBFX
###  - Unsigned Bit Field Extract
val / ['/cond 011 1 1 1 1 /widthm1 /rd /lsbit 1 0 1 /rn'] = quaternop UBFX cond widthm1 rd lsbit rn

### USAD8
###  - Unsigned Sum of Absolute Difference
val / ['/cond 011 1 1 0 0 0 /rd 1111 /rm 0001 /rn'] = quaternop USAD8 cond rn rd rm r15

### USADA8
###  - Unsigned Sum of Absolute Difference and Accumulate
val / ['/cond 011 1 1 0 0 0 /rd /ra-not15 /rm 0001 /rn'] = quaternop USADA8 cond rn rd rm ra

# --- Status register & banked register access instructions ------------

### MRS
###  - Move to Register form Banked or Special register
val / ['/cond 000 10 /r 00 /imm4 /rd 001 /M 0000 0000'] = unbitBinopUnbit MRS cond r imm4 rd m

### MSR (immediate) //add later on
### MSR (banked register)
###  - Move to Banked or Special register from ARM core register
val / ['/cond 000 10 /r 10 /imm4 1111 001 /M 0000 /rn'] = unbitUnopUnbitUnop MSR cond r imm4 m rn

### CPS
###  - Change processor state
val / ['1111 000 1 0 0 0 0 imod:2 M:1 0 0000000 /IFLAGS 0 /imm5'] = binop CPS none iflags imm5

# --- Load/store instructions ------------------------------------------

val ldr_is_pop? s = (is-sp? s.rn) and (not s.p) and s.u and (not s.w) and (s.imm12 == '000000000100')
val unprivileged? s = (not s.p) and s.w

### LDR/LDRT/POP
val / ['/cond 010 /P /U 0 /W 1 /rn /rt /imm12']
###  - Pop Multiple Registers (Encoding A2)
  | ldr_is_pop? = unbitBinop POP cond w rn (reglst-one rt)
###  - Load Register Unprivileged (Encoding A1)
  | unprivileged? = ternbitTernop LDRT cond set0 u set0 rn rt imm12
###  - Load Register (immediate/literal)
  | otherwise = ternbitTernop LDR cond p u w rn rt imm12
val / ['/cond 011 /P /U 0 /W 1 /rn /rt /immshift /rm']
###  - Load Register Unprivileged (Encoding A2)
  | unprivileged? = ternbitTernop LDRT cond set0 u set0 rn rt shfreg
###  - Load Register (register)
  | otherwise = ternbitTernop LDR cond p u w rn rt shfreg

### LDRB/LDRBT
val / ['/cond 010 /P /U 1 /W 1 /rn /rt /imm12']
###  - Load Register Byte Unprivileged (Encoding A1)
  | unprivileged? = ternbitTernop LDRBT cond set0 u set0 rn rt imm12
###  - Load Register Byte (immediate/literal)
  | otherwise = ternbitTernop LDRB cond p u w rn rt imm12
val / ['/cond 011 /P /U 1 /W 1 /rn /rt /immshift /rm']
###  - Load Register Byte Unprivileged (Encoding A2)
  | unprivileged? = ternbitTernop LDRBT cond set0 u set0 rn rt shfreg
###  - Load Register Byte (register)
  | otherwise = ternbitTernop LDRB cond p u w rn rt shfreg

### LDRD
val / ['/cond 000 /P /U 1 /W 0 /rn /rt /imm4H 1101 /imm4L'] =
###  - Load Register Dual (immediate/literal)
  ternbitTernop LDRD cond p u w rn rt combine-imm8
###  - Load Register Dual (register)
val / ['/cond 000 /P /U 0 /W 0 /rn /rt 0000 1101 /rm'] =
  ternbitTernop LDRD cond p u w rn rt rm

### LDRH/LDRHT
val / ['/cond 000 /P /U 1 /W 1 /rn /rt /imm4H 1011 /imm4L']
###  - Load Register Halfword Unprivileged (Encoding A1)
  | unprivileged? = ternbitTernop LDRHT cond set0 u set0 rn rt combine-imm8
###  - Load Register Halfword (immediat/literal)
  | otherwise = ternbitTernop LDRH cond p u w rn rt combine-imm8
val / ['/cond 000 /P /U 0 /W 1 /rn /rt 0000 1011 /rm']
###  - Load Register Halfword Unprivileged (Encoding A2)
  | unprivileged? = ternbitTernop LDRHT cond set0 u set0 rn rt rm
###  - Load Register Halfword (register)
  | otherwise = ternbitTernop LDRH cond p u w rn rt rm

### LDRSB/LDRSBT
val / ['/cond 000 /P /U 1 /W 1 /rn /rt /imm4H 1101 /imm4L']
###  - Load Register Signed Byte (Encoding A1)
  | unprivileged? = ternbitTernop LDRSBT cond set0 u set0 rn rt combine-imm8
###  - Load Register Signed Byte (immediate/literal)
  | otherwise = ternbitTernop LDRSB cond p u w rn rt combine-imm8
val / ['/cond 000 /P /U 0 /W 1 /rn /rt 0000 1101 /rm']
###  - Load Register Signed Byte (Encoding A2)
  | unprivileged? = ternbitTernop LDRSBT cond set0 u set0 rn rt rm
###  - Load Register Signed Byte (register)
  | otherwise = ternbitTernop LDRSB cond p u w rn rt rm

### LDRSH/LDRSHT
val / ['/cond 000 /P /U 1 /W 1 /rn /rt /imm4H 1111 /imm4L']
###  - Load Register Signed Halfword Unprivileged (Encoding A1)
  | unprivileged? = ternbitTernop LDRSHT cond set0 u set0 rn rt combine-imm8
###  - Load Register Signed Halfword (immediate/literal)
  | otherwise = ternbitTernop LDRSH cond p u w rn rt combine-imm8
val / ['/cond 000 /P /U 0 /W 1 /rn /rt 0000 1111 /rm']
###  - Load Register Signed Halfword Unprivileged (Encoding A2)
  | unprivileged? = ternbitTernop LDRSHT cond set0 u set0 rn rt rm
###  - Load Register Signed Halfword (register)
  | otherwise = ternbitTernop LDRSH cond p u w rn rt rm

### LDREX
###  - Load Register Exclusive
val / ['/cond 000 1 1 0 0 1 /rn /rt 1111 1001 1111'] = binop LDREX cond rt rn

### LDREXB
###  - Load Register Exclusive Byte
val / ['/cond 000 1 1 1 0 1 /rn /rt 1111 1001 1111'] = binop LDREXB cond rt rn

### LDREXD
###  - Load Register Exclusive DWORD
val / ['/cond 000 1 1 0 1 1 /rn /rt 1111 1001 1111'] = binop LDREXD cond rt rn

### LDREXH
###  - Load Register Exclusive Halfword
val / ['/cond 000 1 1 1 1 1 /rn /rt 1111 1001 1111'] = binop LDREXH cond rt rn

val str-is-push? s = (is-sp? s.rn) and (not s.u) and (s.imm12 == '000000000100')

### STR/STRT/PUSH
val / ['/cond 010 /P /U 0 /W 0 /rn /rt /imm12']
###  - Store Register Unprivileged (Encoding A1)
  | unprivileged? = ternbitTernop STRT cond set0 u set1 rn rt imm12
###  - Push Multiple Registers (Encoding A2)
  | str-is-push? = unbitBinop PUSH cond w rn (reglst-one rt)
###  - Store Register (immediate)
  | otherwise = ternbitTernop STR cond p u w rn rt imm12
val / ['/cond 011 /P /U 0 /W 0 /rn /rt /immshift /rm']
###  - Store Register Unprivileged (encoding A2)
  | unprivileged? = ternbitTernop STRT cond set0 u set1 rn rt shfreg 
###  - Store Register (register)
  | otherwise = ternbitTernop STR cond p u w rn rt shfreg

### STRB/STRBT
val / ['/cond 010 /P /U 1 /W 0 /rn /rt /imm12']
###  - Store Register Byte Unprivileged (Encoding A1)
  | unprivileged? = ternbitTernop STRBT cond set0 u set1 rn rt imm12
###  - Store Register Byte (immediate)
  | otherwise = ternbitTernop STRB cond p u w rn rt imm12
val / ['/cond 011 /P /U 1 /W 0 /rn /rt /immshift /rm']
###  - Store Register Byte Unprivileged (Encoding A2)
  | unprivileged? = ternbitTernop STRBT cond set0 u set1 rn rt shfreg
###  - Store Register Byte (register)
  | otherwise = ternbitTernop STRB cond p u w rn rt shfreg

### STRD
###  - Store Register Dual (immediate)
val / ['/cond 000 /P /U 1 /W 0 /rn /rt /imm4H 1111 /imm4L'] = ternbitTernop STRD cond p u w rn rt combine-imm8
###  - Store Register Dual (register)
val / ['/cond 000 /P /U 0 /W 0 /rn /rt 0000 1111 /rm'] = ternbitTernop STRD cond p u w rn rt rm

### STRH/STRHT
val / ['/cond 000 /P /U 1 /W 0 /rn /rt /imm4H 1011 /imm4L']
###  - Store Register Halfword Unprivileged (Encoding A1)
  | unprivileged? = ternbitTernop STRHT cond set0 u set1 rn rt combine-imm8
###  - Store Register Halfword (immediate)
  | otherwise = ternbitTernop STRH cond p u w rn rt combine-imm8
val / ['/cond 000 /P /U 0 /W 0 /rn /rt 0000 1011 /rm']
###  - Store Register Halfword Unprivileged (Encoding A2)
  | unprivileged? = ternbitTernop STRHT cond set0 u set1 rn rt rm
###  - Store Register Halfword (register)
  | otherwise = ternbitTernop STRH cond p u w rn rt rm

### STREX
###  - Store Register Exclusive
val / ['/cond 000 1 1 0 0 0 /rn /rd 1111 1001 /rt'] = ternop STREX cond rn rd rt

### STREXB
###  - Store Register Exclusive Byte
val / ['/cond 000 1 1 1 0 0 /rn /rd 1111 1001 /rt'] = ternop STREXB cond rn rd rt

### STREXD
###  - Store Register Exclusive DWORD
val / ['/cond 000 1 1 0 1 0 /rn /rd 1111 1001 /rt'] = ternop STREXD cond rn rd rt

### STREXH
###  - Store Register Exclusive Halfword
val / ['/cond 000 1 1 1 1 0 /rn /rd 1111 1001 /rt'] = ternop STREXH cond rn rd rt

# --- Load/store multiple instructions ---------------------------------

val ldm-is-pop? s = (is-sp? s.rn) and s.w and (opndl-length s.operands) > 1

### LDM/POP
val / ['/cond 100 0 1 0 /W 1 /rn /reglst']
###  - Pop Multiple Registers (Encoding A1)
  | ldm-is-pop? = unbitBinop POP cond set1 rn reglst
###  - Load Multiple
  | otherwise = unbitBinop LDM cond (return '1') rn reglst

### LDMDA
###  - Load Multiple Decrement After
val / ['/cond 100 0 0 0 /W 1 /rn /reglst'] = unbitBinop LDMDA cond w rn reglst

### LDMDB
###  - Load Multiple Decrement Before
val / ['/cond 100 1 0 0 /W 1 /rn /reglst'] = unbitBinop LDMDB cond w rn reglst

### LDMIB
###  - Load Multiple Increment Before
val / ['/cond 100 1 1 0 /W 1 /rn /reglst'] = unbitBinop LDMIB cond w rn reglst

### STM
###  - Store Multiple
val / ['/cond 100 0 1 0 /W 0 /rn /reglst'] = unbitBinop STM cond w rn reglst

val stmdb-is-push? s = (is-sp? s.rn) and s.w and (opndl-length s.operands) > 1

### STMDB/PUSH
val / ['/cond 100 1 0 0 /W 0 /rn /reglst']
###  - Push Multiple Registers (Encoding A1)
  | stmdb-is-push? = unbitBinop PUSH cond w rn reglst
###  - Store Multiple Decrement Before
  | otherwise = unbitBinop STMDB cond w rn reglst

### STMDA
###  - Store Multiple Decrement After
val / ['/cond 100 0 0 0 /W 0 /rn /reglst'] = unbitBinop STMDA cond w rn reglst

### STMIB
###  - Store Multiple Increment Before
val / ['/cond 100 1 1 0 /W 0 /rn /reglst'] = unbitBinop STMIB cond w rn reglst

# --- Miscellaneous instructions ---------------------------------------

### CLREX
###  - Clear-Exclusive
val / ['1111 010 1 0 1 1 1 1111 1111 0000 0001 1111'] = nullop CLREX none

### DBG
###  - Debug Hint
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 1111 /imm4'] = unop DBG cond imm4

### DMB
###  - Data Memory Barrier
val / ['1111 010 1 0 1 1 1 1111 1111 0000 0101 /imm4'] = unop DMB none imm4

### DSB
###  - Data Synchronization Barrier
val / ['1111 010 1 0 1 1 1 1111 1111 0000 0100 /imm4'] = unop DSB none imm4

### ISB
###  - Instruction Synchronization Barrier
val / ['1111 010 1 0 1 1 1 1111 1111 0000 0110 /imm4'] = unop ISB none imm4

### NOP
###  - No Operation
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 0000 0000'] = nullop NOP cond

val is-literal? s = (s.rn == '1111')

### PLD
###  - Preload Data Read (immediate/literal)
val / ['1111 010 1 /U 1 0 1 /rn 1111 /imm12'] = unopUnbitUnop PLD none rn u imm12
###  - Preload Data Read (register)
val / ['1111 011 1 /U 1 0 1 /rn 1111 /immshift /rm'] = unopUnbitUnop PLD none rn u shfreg

### PLDW
###  - Preload Data Write (immediate)
val / ['1111 010 1 /U 0 0 1 /rn 1111 /imm12'] = unopUnbitUnop PLDW none rn u imm12
###  - Preload Data Write (register)
val / ['1111 011 1 /U 0 0 1 /rn 1111 /immshift /rm'] = unopUnbitUnop PLDW none rn u shfreg

### PLI
###  - Preload Instruction (immediate/literal)
val / ['1111 010 0 /U 1 0 1 /rn 1111 /imm12'] = unopUnbitUnop PLI none rn u imm12
###  - Preload Instruction (register)
val / ['1111 011 0 /U 1 0 1 /rn 1111 /immshift /rm'] = unopUnbitUnop PLI none rn u shfreg

### SETEND
###  - Set Endianess
val / ['1111 000 1 0 0 0 0 000 1 000000 /E 0 0000 0000'] = unbit SETEND none e

### SEV
###  - Send Event
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 0000 0100'] = nullop SEV cond

### SWP
###  - Swap
val / ['/cond 000 1 0 0 0 0 /rn /rt 0000 1001 /rt2'] = ternop SWP cond rn rt rt2

### SWPB
###  - Swap Byte
val / ['/cond 000 1 0 1 0 0 /rn /rt 0000 1001 /rt2'] = ternop SWPB cond rn rt rt2

### YIELD
###  - Yield
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 0000 0001'] = nullop YIELD cond

### WFE
###  - Wait For Event
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 0000 0010'] = nullop WFE cond

### WFI
###  - Wait For Interrupt
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 0000 0011'] = nullop WFI cond

# --- Exception-generating and exception-handling instructions ---------

### SVC
###  - Supervisor Call
val / ['/cond 111 1 /imm24'] = unop SVC cond imm24

### BKPT
###  - Breakpoint
val / ['/cond 000 1 0 0 1 0 /imm12 0111 /imm4'] = unop BKPT cond combine-imm16-rev

### SMC
###  - Secure Monitor Call
val / ['/cond 000 1 0 1 1 0 000000000000 0111 /imm4'] = unop SMC cond imm4

### RFE
###  - Return From Exception
val / ['1111 100 /P /U 0 /W 1 /rn 0000 1010 00000000'] = ternbitUnop RFE cond p u w rn

### SUBS (*Already implemented by SUB*)

### HVC
###  - Hypervisor Call
val / ['/cond 000 1 0 1 0 0 /imm12 0111 /imm4'] = unop HVC cond combine-imm16-rev

### ERET
###  - Exception Return
val / ['/cond 000 1 0 1 1 0 000000000000 0110 1110'] = nullop ERET cond

### LDM
###  - Load Multiple (Exception Return)
val / ['/cond 100 /P /U 1 /W 1 /rn 1 /reglst15'] = ternbitBinop LDMerur cond p u w rn reglst
###  - Load Multiple (User registers)
val / ['/cond 100 /P /U 1 0 1 /rn 0 /reglst15'] = ternbitBinop LDMerur cond p u set0 rn reglst

### SRS
###  - Store Return State
val / ['1111 100 /P /U 1 /W 0 1101 0000 0101 000 /imm5'] = ternbitUnop SRS none p u w imm5

# --- Coprocessor instructions -----------------------------------------

### CDP
###  - Coprocessor Data Processing (Encoding A1)
val / ['/cond 1110 /opc14 /crn /crd /coproc /opc23 0 /crm'] = senop CDP cond coproc opc14 crd crn crm opc23

### CDP2
###  - Coprocessor Data Processing (Encoding A2)
val / ['1111 1110 /opc14 /crn /crd /coproc /opc23 0 /crm'] = senop CDP2 none coproc opc14 crd crn crm opc23

### MCR
###  - Move to Coprocessor (Encoding A1)
val / ['/cond 111 0 /opc13 0 /crn /rt /coproc /opc23 1 /crm'] = senop MCR cond coproc opc13 rt crn crm opc23

### MCR2
###  - Move to Coprocessor (Encoding A2)
val / ['1111 111 0 /opc13 0 /crn /rt /coproc /opc23 1 /crm'] = senop MCR2 none coproc opc13 rt crn crm opc23

### MCRR
###  - Move to Coprocessor from two (Encoding A1)
val / ['/cond 110 0 0 1 0 0 /rt2 /rt /coproc /opc14 /crm'] = quinop MCRR cond coproc opc14 rt rt2 crm

### MCRR2
###  - Move to Coprocessor from two (Encoding A2)
val / ['1111 110 0 0 1 0 0 /rt2 /rt /coproc /opc14 /crm'] = quinop MCRR2 none coproc opc14 rt rt2 crm

### MRC
###  - Move from Coprocessor (Encoding A1)
val / ['/cond 111 0 /opc13 1 /crn /rt /coproc /opc23 1 /crm'] = senop MRC cond coproc opc13 rt crn crm opc23

### MRC2
###  - Move from Coprocessor (Encoding A2)
val / ['1111 111 0 /opc13 1 /crn /rt /coproc /opc23 1 /crm'] = senop MRC2 none coproc opc13 rt crn crm opc23

### MRRC
###  - Move to two from Coprocessor (Encoding A1)
val / ['/cond 110 0 0 1 0 1 /rt2 /rt /coproc /opc14 /crm'] = quinop MRRC cond coproc opc14 rt rt2 crm

### MRRC2
###  - Move to two from Coprocessor (Encoding A2)
val / ['1111 110 0 0 1 0 1 /rt2 /rt /coproc /opc14 /crm'] = quinop MRRC2 none coproc opc14 rt rt2 crm

### LDC (immediate/literal)
###  - Load Coprocessor (Encoding A1)
val / ['/cond 110 /PUDW 1 /rn /crd /coproc /imm8'] = quinop LDC cond coproc crd rn pudw imm8

### LDC2 (immediate/literal)
###  - Load Coprocessor (Encoding A2)
val / ['1111 110 /PUDW 1 /rn /crd /coproc /imm8'] = quinop LDC2 none coproc crd rn pudw imm8

### STC
###  - Store Coprocessor (Encoding A1)
val / ['/cond 110 /PUDW 0 /rn /crd /coproc /imm8'] = quinop STC cond coproc crd rn pudw imm8

### STC2
###  - Store Coprocessor (Encoding A2)
val / ['1111 110 /PUDW 0 /rn /crd /coproc /imm8'] = quinop STC2 none coproc crd rn pudw imm8

# --- Advanced SIMD and floating-point load/store instructions ---------

### VLDMIA
###  - Vector Load Multiple Increment After
val / ['/cond 110 01 /D /W 1 /rn /vd 101 h:1 /imm8'] = unopUnbitBinop VLDMIA cond rn w vdq0 imm8

### VLDMDB
###  - Vector Load Multiple Decrement Before
val / ['/cond 110 10 /D 1 1 /rn /vd 101 h:1 /imm8'] = unopUnbitBinop VLDMDB cond rn set1 vdq0 imm8

### VLDR
###  - Vector Load Register
val / ['/cond 110 1 /U /D 01 /rn /vd 101 h:1 /imm8'] = binopUnbitUnop VLDR cond vdq0 rn u imm8

### VSTMIA
###  - Vector Store Multiple Increment After
val / ['/cond 110 01 /D /W 0 /rn /vd 101 h:1 /imm8'] = unopUnbitBinop VSTMIA cond rn w vdq0 imm8

### VSTMDB
###  - Vector Store Multiple Decrement Before
val / ['/cond 110 10 /D 1 0 /rn /vd 101 h:1 /imm8'] = unopUnbitBinop VSTMDB cond rn set1 vdq0 imm8

### VSTR
###  - Vector Store Register
val / ['/cond 110 1 /U /D 00 /rn /vd 101 h:1 /imm8'] = binopUnbitUnop VSTR cond vdq0 rn u imm8

# --- Element and structure load/store instructions --------------------

### VLD1 (multiple single elements)
###  - Vector Load multiple single elements
val / ['1111 0100 0 /D 10 /rn /vd /vls1_type /size /aligna /rm'] = quinop VLD1 none size vdq0 rn aligna rm

### VLD1 (one lane)
###  - Vector Load single element to one lane
val / ['1111 0100 1 /D 10 /rn /vd /size 00 /index_align /rm'] = quinop VLD1 none size vdq0 rn index_align rm

### VLD1 (all lanes)
###  - Vector Load single element to all lanes
val / ['1111 0100 1 /D 10 /rn /vd 11 00 /size T:1 /a /rm'] = ternopUnbitUnop VLD1a none size vdq0 rn a rm

### VLD2 (multiple structures)
###  - Vector Load multiple 2-element structures
val / ['1111 0100 0 /D 10 /rn /vd /vls2_type /size /aligna /rm'] = quinop VLD2 none size vdq0 rn aligna rm

### VLD2 (one lane)
###  - Vector Load 2-element structure to one lane
val / ['1111 0100 1 /D 10 /rn /vd /size 01 /index_align /rm'] = quinop VLD2 none size vdq0 rn index_align rm

### VLD2 (all lanes)
###  - Vector Load 2-element structure to all lanes
val / ['1111 0100 1 /D 10 /rn /vd 11 01 /size T:1 /a /rm'] = ternopUnbitUnop VLD2a none size vdq0 rn a rm

### VLD3 (multiple structures)
###  - Vector Load multiple 3-element structures
val / ['1111 0100 0 /D 10 /rn /vd /vls3_type /size /aligna /rm'] = quinop VLD3 none size vdq0 rn aligna rm

### VLD3 (one lane)
###  - Vector Load 3-element structure to one lane
val / ['1111 0100 1 /D 10 /rn /vd /size 10 /index_align /rm'] = quinop VLD3 none size vdq0 rn index_align rm

### VLD3 (all lanes)
###  - Vector Load 3-element structure to all lanes
val / ['1111 0100 1 /D 10 /rn /vd 11 10 /size T:1 /a /rm'] = ternopUnbitUnop VLD3a none size vdq0 rn a rm

### VLD4 (multiple structures)
###  - Vector Load multiple 4-element structures
val / ['1111 0100 0 /D 10 /rn /vd /vls4_type /size /aligna /rm'] = quinop VLD4 none size vdq0 rn aligna rm

### VLD4 (one lane)
###  - Vector Load 4-element structure to one lane
val / ['1111 0100 1 /D 10 /rn /vd /size 11 /index_align /rm'] = quinop VLD4 none size vdq0 rn index_align rm

### VLD4 (all lanes)
###  - Vector Load 4-element structure to all lanes
val / ['1111 0100 1 /D 10 /rn /vd 11 11 /size T:1 /a /rm'] = ternopUnbitUnop VLD4a none size vdq0 rn a rm

### VST1 (multiple elments)
###  - Vector Store multiple single elements
val / ['1111 0100 0 /D 00 /rn /vd /vls1_type /size /aligna /rm'] = quinop VST1 none size vdq0 rn aligna rm

### VST1 (one lane)
###  - Vector Store single element from one lane
val / ['1111 0100 1 /D 00 /rn /vd /size 00 /index_align /rm'] = quinop VST1 none size vdq0 rn index_align rm

### VST2 (multiple structures)
###  - Vector Store multiple 2-element structures
val / ['1111 0100 0 /D 00 /rn /vd /vls2_type /size /aligna /rm'] = quinop VST2 none size vdq0 rn aligna rm

### VST2 (one lane)
###  - Vector Store 2-element structure from one lane
val / ['1111 0100 1 /D 00 /rn /vd /size 01 /index_align /rm'] = quinop VST2 none size vdq0 rn index_align rm

### VST3 (multiple structures)
###  - Vector Store multiple 3-element structures
val / ['1111 0100 0 /D 00 /rn /vd /vls3_type /size /aligna /rm'] = quinop VST3 none size vdq0 rn aligna rm

### VST3 (one lane)
###  - Vector Store 3-element structure from one lane
val / ['1111 0100 1 /D 00 /rn /vd /size 10 /index_align /rm'] = quinop VST3 none size vdq0 rn index_align rm

### VST4 (multiple structures)
###  - Vector Store multiple 4-element structures
val / ['1111 0100 0 /D 00 /rn /vd /vls4_type /size /aligna /rm'] = quinop VST4 none size vdq0 rn aligna rm

### VST4 (one lane)
###  - Vector Store 4-element structure from one lane
val / ['1111 0100 1 /D 00 /rn /vd /size 11 /index_align /rm'] = quinop VST4 none size vdq0 rn index_align rm

# --- Advanced SIMD and floating-point register transfer instructions --

### VDUP
###  - Vector Duplicate Arm Core Register
val / ['/cond 1110 1 B:1 /Q 0 /vd /rt 1011 /D 0 E:1 1 0000'] = ternop VDUP cond imm4 vd rt

### VMOV
###  - Vector Move ARM core register to scalar
val / ['/cond 1110 0 /opc12 0 /vd /rt 1011 /D /opc22 1 0000'] = ternop VMOVacs cond combine-opc2 vdq0 rt
###  - Vector Move scalar to ARM core register
val / ['/cond 1110 /U /opc12 1 /vn /rt 1011 /N /opc22 1 0000'] = ternop VMOVsac cond combine-u-opc2 rt vnq0
###  - Vector Move between ARM core register and single-precision register
val / ['/cond 1110 0 00 0 /vn /rt 1010 /N 00 1 0000'] = binop VMOVacsp cond vnq0 rt
val / ['/cond 1110 0 00 1 /vn /rt 1010 /N 00 1 0000'] = binop VMOVspac cond rt vnq0
(*TODO: Adjust second 'm vm' to represent next vector*)
###  - Vector Move between two ARM core and two single-precision registers
val / ['/cond 1100 0 10 0 /rt2 /rt 1010 00 /M 1 /vm'] = ternop VMOVacsp2 cond vmq0 rt rt2
val / ['/cond 1100 0 10 1 /rt2 /rt 1010 00 /M 1 /vm'] = ternop VMOVspac2 cond rt rt2 vmq0
###  - Vector Move between two ARM core and doubleword extension register
val / ['/cond 1100 0 10 0 /rt2 /rt 1011 00 /M 1 /vm'] = ternop VMOVacdwe cond vmq0 rt rt2
val / ['/cond 1100 0 10 1 /rt2 /rt 1011 00 /M 1 /vm'] = ternop VMOVdweac cond rt rt2 vmq0

### VMRS
val / ['/cond 1110 1111 0001 /rt 1010 000 1 0000'] = unop VMRS cond rt

### VMSR
val / ['/cond 1110 1110 0001 /rt 1010 000 1 0000'] = unop VMSR cond rt

# --- Advanced SIMD parallel addition and Subtraction instructions ----

### VADD
###  - Vector Add integer
val / ['1111 0010 0 /D /size2 /vn /vd 1000 /N /Q /M 0 /vm'] = quaternop VADDiasimd none size vd vn vm
###  - Vector Add floating-point (Encoding A1)
val / ['1111 0010 0 /D 0 0 /vn /vd 1101 /N /Q /M 0 /vm'] = unbitTernop VADDfpasimd none set0 vd vn vm

### VADDHN
###  - Vector Add and Narrow returning high half
val / ['1111 0010 1 /D /size /vn /vd 0100 /N 0 /M 0 /vm'] = quaternop VADDHN none size vdq0 vnq0 vmq0

### VADDL
###  - Vector Add Long
val / ['1111 001 /U 1 /D /size /vn /vd 0000 /N 0 /M 0 /vm'] = unbitQuaternop VADDL none u size vdq0 vnq0 vmq0

### VADDW
###  - Vector Add Wide
val / ['1111 001 /U 1 /D /size /vn /vd 0001 /N 0 /M 0 /vm'] = unbitQuaternop VADDW none u size vdq0 vnq0 vmq0

### VHADD
###  - Vector Halving Add
val / ['1111 001 /U 0 /D /size /vn /vd 0000 /N /Q /M 0 /vm'] = unbitQuaternop VHADD none u size vd vn vm

### VHSUB
###  - Vector Halving Sub
val / ['1111 001 /U 0 /D /size /vn /vd 0010 /N /Q /M 0 /vm'] = unbitQuaternop VHSUB none u size vd vn vm

### VPADAL
val / ['1111 0011 1 /D 11 /size 00 /vd 0110 /op /Q /M 0 /vm'] = unbitTernop VPADAL none op size vd vm

### VPADD
###  - Vector Pairwise Add integer
val / ['1111 0010 0 /D /size /vn /vd 1011 /N 0 /M 1 /vm'] = quaternop VPADDi none size vdq0 vnq0 vmq0
###  - Vector Pairwise Add floating-point
val / ['1111 0011 0 /D 0 0 /vn /vd 1101 /N 0 /M 0 /vm'] = unbitTernop VPADDfp none set0 vdq0 vnq0 vmq0 

### VPADDL
###  - Vector Pairwise Add Long
val / ['1111 0011 1 /D 11 /size 00 /vd 0010 /op /Q /M 0 /vm'] = unbitTernop VPADDL none op size vd vm

### VRADDHN
###  - Vector Rounding Add and Narrow high half
val / ['1111 0011 1 /D /size /vn /vd 0100 /N 0 /M 0 /vm'] = quaternop VRADDHN none size vdq0 vnq1 vmq1 

### VRHADD
###  - Vector Rounding Halving Add
val / ['1111 001 /U 0 /D /size /vn /vd 0001 /N /Q /M 0 /vm'] = unbitQuaternop VRHADD none u size vd vn vm

### VRSUBHN
###  - Vector Rounding Subtract and Narrow high half
val / ['1111 0011 1 /D /size /vn /vd 0110 /N 0 /M 0 /vm'] = quaternop VRSUBHN none size vdq0 vnq1 vmq1

### VQADD
###  - Vector Saturating Add
val / ['1111 001 /U 0 /D /size /vn /vd 0000 /N /Q /M 1 /vm'] = unbitQuaternop VQADD none u size vd vn vm

### VQSUB
###  - Vector Saturating Subtract
val / ['1111 001 /U 0 /D /size /vn /vd 0010 /N /Q /M 1 /vm'] = unbitQuaternop VQSUB none u size vd vn vm

### VSUB
###  - Vector Subtract integer
val / ['1111 0011 0 /D /size /vn /vd 1000 /N /Q /M 0 /vm'] = quaternop VSUBiasimd none size vd vn vm
###  - Vector Subtract floating-point (Encoding A1)
val / ['1111 0010 0 /D 1 0 /vn /vd 1101 /N /Q /M 0 /vm'] = unbitTernop VSUBfpasimd none set0 vd vn vm

### VSUBHN
###  - Vector Subtract and Narrow high half
val / ['1111 0010 1 /D /size /vn /vd 0110 /N 0 /M 0 /vm'] = quaternop VSUBHN none size vdq0 vnq0 vmq0

### VSUBL
###  - Vector Subtract Long
val / ['1111 001 /U 1 /D /size /vn /vd 001 0 /N 0 /M 0 /vm'] = unbitQuaternop VSUBL none u size vdq0 vnq0 vmq0

### VSUBW
###  - Vector Subtract Wide
val / ['1111 001 /U 1 /D /size /vn /vd 001 1 /N 0 /M 0 /vm'] = unbitQuaternop VSUBW none u size vdq0 vnq0 vmq0

# --- Bitwise Advanced SIMD data-processing instructions ---------------

### VAND
###  - Vector And register
val / ['1111 001 0 0 /D 00 /vn /vd 0001 /N /Q /M 1 /vm'] = ternop VAND none vd vn vm

### VBIC
###  - Vector Bitwise Bit Clear immediate
val / ['1111 001 /i 1 /D 000 /imm3 /vd /cmode-bic 0 /Q 11 /imm4'] = ternop VBIC none cmode vd (imm64-asimd '1')
###  - Vector Bitwise Bit Clear register
val / ['1111 001 0 0 /D 01 /vn /vd 0001 /N /Q /M 1 /vm'] = ternop VBIC none vd vn vm

### VEOR
###  - Vector Bitwise Exclusive OR
val / ['1111 001 1 0 /D 00 /vn /vd 0001 /N /Q /M 1 /vm'] = ternop VEOR none vd vn vm

### VBIF
###  - Vector Bitwise Insert If False
val / ['1111 001 1 0 /D 11 /vn /vd 0001 /N /Q /M 1 /vm'] = ternop VBIF none vd vn vm

### VBIT
###  - Vector Bitwise Insert If True
val / ['1111 001 1 0 /D 10 /vn /vd 0001 /N /Q /M 1 /vm'] = ternop VBIF none vd vn vm

### VMOV
###  - Vector Move immediate
val / ['1111 001 /i 1 /D 000 /imm3 /vd /cmode-mov0 0 /Q 0 1 /imm4'] = binop VMOVimmasimd none vd (imm64-asimd '0')
val / ['1111 001 /i 1 /D 000 /imm3 /vd /cmode-mov1 0 /Q 1 1 /imm4'] = binop VMOVimmasimd none vd (imm64-asimd '1')
###  - Vector Move register
val / ['1111 001 0 0 /D 10 /vm /vd 0001 0 /Q 0 1 /vm'] = binop VMOVregasimd none vd vmm0
val / ['1111 001 0 0 /D 10 /vm /vd 0001 1 /Q 1 1 /vm'] = binop VMOVregasimd none vd vmm1

### VMVN
###  - Vector Bitwise Not immediate
val / ['1111 001 /i 1 /D 000 /imm3 /vd /cmode-mvn 0 /Q 11 /imm4'] = ternop VMVN none cmode vd (imm64-asimd '1')
###  - Vector Bitwise Not register
val / ['1111 001 1 1 /D 11 /size 00 /vd 0 1011 /Q /M 0 /vm'] = ternop VMVN none size vd vm

### VORR
###  - Vector Bitwise OR immediate
val / ['1111 001 /i 1 /D 000 /imm3 /vd /cmode-vorr 0 /Q 01 /imm4'] = ternop VORR none cmode vd (imm64-asimd '0')
###  - Vector Bitwise OR register
val / ['1111 001 0 0 /D 10 /vn /vd 0001 0 /Q 1 1 /vm'] = ternop VORR none vd vnn1 vmm1
val / ['1111 001 0 0 /D 10 /vn /vd 0001 1 /Q 0 1 /vm'] = ternop VORR none vd vnn1 vmm0

### VORN
###  - Vector Bitwise OR NOT register
val / ['1111 001 0 0 /D 11 /vn /vd 0001 /N /Q /M 1 /vm'] = ternop VORN none vd vn vm

### VBSL
###  - Vector Bitewise Select
val / ['1111 001 1 0 /D 01 /vn /vd 0001 /N /Q /M 1 /vm'] = ternop VBIF none vd vn vm

# --- Advanced SIMD comparison instructions ----------------------------

### VACGE (LT)
###  - Vector Absolute Compare Greater Than or Equal (Vector Absolute Compare Lower Than)
val / ['1111 0011 0 /D 0 0 /vn /vd 1110 /N /Q /M 1 /vm'] = unbitTernop VACGE none set0 vd vn vm
val / ['1111 0011 0 /D 0 1 /vn /vd 1110 /N /Q /M 1 /vm'] = unbitTernop VACGE none set1 vd vn vm

### VACGT (LE)
###  - Vector Absolute Compare Greater Than (Vector Absolute Compare Lower Than or Equal)
val / ['1111 0011 0 /D 1 0 /vn /vd 1110 /N /Q /M 1 /vm'] = unbitTernop VACGT none set0 vd vn vm
val / ['1111 0011 0 /D 1 1 /vn /vd 1110 /N /Q /M 1 /vm'] = unbitTernop VACGT none set1 vd vn vm

### VCEQ
###  - Vector Compare Equal register (Encoding A1)
val / ['1111 0011 0 /D /size /vn /vd 1000 /N /Q /M 1 /vm'] = quaternop VCEQrega none size vd vn vm
###  - Vector Compare Equal register (Encoding A2)
val / ['1111 0010 0 /D 0 /sz /vn /vd 1110 /N /Q /M 0 /vm'] = unbitTernop VCEQregb none sz vd vn vm
###  - Vector Compare Equal immediate
val / ['1111 0011 1 /D 11 /size 01 /vd 0 /F 010 /Q /M 0 /vm'] = unbitTernop VCEQimm none f size vd vm

### VCGE
###  - Vector Compare Greater Than or Equal register (Encoding A1)
val / ['1111 001 /U 0 /D /size /vn /vd 0011 /N /Q /M 1 /vm'] = unbitQuaternop VCGErega none u size vd vn vm
###  - Vector Compare Greater Than or Equal register (Encoding A2)
val / ['1111 0011 0 /D 0 /sz /vn /vd 1110 /N /Q /M 0 /vm'] = unbitTernop VCGEregb none sz vd vn vm 
###  - Vector Compare Greater Than or Equal immediate
val / ['1111 0011 1 /D 11 /size 01 /vd 0 /F 001 /Q /M 0 /vm'] = unbitTernop VCGEimm none f size vd vm

### VCGT
###  - Vector Compare Greater Than register (Encoding A1)
val / ['1111 001 /U 0 /D /size /vn /vd 0011 /N /Q /M 0 /vm'] = unbitQuaternop VCGTrega none u size vd vn vm
###  - Vector Compare Greater Than register (Encoding A2)
val / ['1111 0011 0 /D 1 /sz /vn /vd 1110 /N /Q /M 0 /vm'] = unbitTernop VCGTregb none sz vd vn vm
###  - Vector Compare Greater Than immediate
val / ['1111 0011 1 /D 11 /size 01 /vd 0 /F 000 /Q /M 0 /vm'] = unbitTernop VCGTimm none f size vd vm

### VCLE
###  - Vector Compare Less Than or Equal immediate
val / ['1111 0011 1 /D 11 /size 01 /vd 0 /F 011 /Q /M 0 /vm'] = unbitTernop VCLE none f size vd vm

### VCLT
###  - Vector Compare Less Than
val / ['1111 0011 1 /D 11 /size 01 /vd 0 /F 100 /Q /M 0 /vm'] = unbitTernop VCLT none f size vd vm

### VTST
###  - Vector Test Bits
val / ['1111 0010 0 /D /size /vn /vd 1000 /N /Q /M 1 /vm'] = quaternop VTST none size vd vn vm

# --- Advanced SIMD shift instructions ---------------------------------

### VQRSHL
###  - Vector Saturating Rounding Shift Left
val / ['1111 001 /U 0 /D /size /vn /vd 0101 /N /Q /M 1 /vm'] = unbitQuaternop VQRSHL none u size vd vm vn

### VQRSHRN
###  - Vector Saturating Rounding Shift Right Narrow
val / ['1111 001 /U 1 /D /imm6-not000 /vd 100 1 01 /M 1 /vm'] = unbitQuaternop VQRSHRN none u imm6 vdq0 vmq1 imm6 

### VQRSHRUN
###  - Vector Saturating Rounding Shift Right UnsignedNarrow
val / ['1111 001 1 1 /D /imm6-not000 /vd 100 0 01 /M 1 /vm'] = unbitQuaternop VQRSHRUN none set1 imm6 vdq0 vmq1 imm6

### VQSHL
###  - Vector Saturating Shift Left register
val / ['1111 001 /U 0 /D /size /vn /vd 0100 /N /Q /M 1 /vm'] = unbitQuaternop VQSHL none u size vd vm vn
###  - Vector Saturating Shift Left immediate
val / ['1111 001 /U 1 /D /imm6-not000 /vd 011 1 0 /Q /M 1 /vm'] = unbitQuaternop VQSHL none u imm6 vd vm imm6
val / ['1111 001 /U 1 /D /imm6 /vd 011 1 1 /Q /M 1 /vm'] = unbitQuaternop VQSHL none u imm6 vd vm imm6

### VQSHLU
###  - Vector Saturating Shift Left Unsigned immediate
val / ['1111 001 1 1 /D /imm6-not000 /vd 011 0 0 /Q /M 1 /vm'] = unbitQuaternop VQSHLU none set1 imm6 vd vm imm6
val / ['1111 001 1 1 /D /imm6 /vd 011 0 1 /Q /M 1 /vm'] = unbitQuaternop VQSHLU none set1 imm6 vd vm imm6

### VQSHRN
###  - Vector Saturating Shift Right Narrow
val / ['1111 001 /U 1 /D /imm6-not000 /vd 100 1 00 /M 1 /vm'] = unbitQuaternop VQSHRN none u imm6 vdq0 vmq1 imm6

### VQSHRUN
###  - Vector Saturating Shift Right Unsigned Narrow
val / ['1111 001 1 1 /D /imm6-not000 /vd 100 0 00 /M 1 /vm'] = unbitQuaternop VQSHRUN none set1 imm6 vdq0 vmq1 imm6

### VRSHL
###  - Vector Rounding Shift Left
val / ['1111 001 /U 0 /D /size /vn /vd 0101 /N /Q /M 0 /vm'] = unbitQuaternop VRSHL none u size vd vm vn

### VRSHR
###  - Vector Rounding Shift Right
val / ['1111 001 /U 1 /D /imm6 /vd 0010 1 /Q /M 1 /vm'] = unbitQuaternop VRSHR none u imm6 vd vm imm6
val / ['1111 001 /U 1 /D /imm6-not000 /vd 0010 0 /Q /M 1 /vm'] = unbitQuaternop VRSHR none u imm6 vd vm imm6

### VRSRA
###  - Vector ROunding Shift Right and Accumulate
val / ['1111 001 /U 1 /D /imm6 /vd 0011 1 /Q /M 1 /vm'] = unbitQuaternop VRSHR none u imm6 vd vm imm6
val / ['1111 001 /U 1 /D /imm6-not000 /vd 0011 0 /Q /M 1 /vm'] = unbitQuaternop VRSHR none u imm6 vd vm imm6

### VRSHRN
###  - Vector Rounding Shift Right and Narrow
val / ['1111 0010 1 /D /imm6-not000 /vd 1000 0 1 /M 1 /vm'] = quaternop VRSHRN none imm6 vdq0 vmq1 imm6

### VSHL
###  - Vector Shift Left immediate
val / ['1111 0010 1 /D /imm6 /vd 0101 1 /Q /M 1 /vm'] = quaternop VSHLimm none imm6 vd vm imm6
val / ['1111 0010 1 /D /imm6-not000 /vd 0101 0 /Q /M 1 /vm'] = quaternop VSHLimm none imm6 vd vm imm6
###  - Vector Shift Left register
val / ['1111 001 /U 0 /D /size /vn /vd 0100 /N /Q /M 0 /vm'] = unbitQuaternop VSHLreg none u size vd vm vn

### VSHLL
###  - Vector Shift Left Long (Encoding A1)
val / ['1111 001 /U 1 /D /imm6-not000 /vd 1010 00 /M 1 /vm'] = unbitQuaternop VSHLL none u imm6 vdq0 vmq1 imm6
###  - Vector Shift Left Long (Encoding A2)
val / ['1111 0011 1 /D 11 /size 10 /vd 0011 00 /M 0 /vm'] = unbitQuaternop VSHLL none set1 size vdq0 vmq0 size

### VSHR
###  - Vector Shift Right
val / ['1111 001 /U 1 /D /imm6 /vd 0000 1 /Q /M 1 /vm'] = unbitQuaternop VSHR none u imm6 vd vm imm6
val / ['1111 001 /U 1 /D /imm6-not000 /vd 0000 0 /Q /M 1 /vm'] = unbitQuaternop VSHR none u imm6 vd vm imm6

### VSHRN
val / ['1111 0010 1 /D /imm6-not000 /vd 1000 00 /M 1 /vm'] = quaternop VSHRN none imm6 vdq0 vmq1 imm6 

### VSLI
val / ['1111 0011 1 /D /imm6 /vd 0101 1 /Q /M 1 /vm'] = quaternop VSLI none imm6 vd vm imm6
val / ['1111 0011 1 /D /imm6-not000 /vd 0101 0 /Q /M 1 /vm'] = quaternop VSLI none imm6 vd vm imm6

### VSRA
val / ['1111 001 /U 1 /D /imm6 /vd 0001 1 /Q /M 1 /vm'] = unbitQuaternop VSRA none u imm6 vd vm imm6
val / ['1111 001 /U 1 /D /imm6-not000 /vd 0001 0 /Q /M 1 /vm'] = unbitQuaternop VSRA none u imm6 vd vm imm6

### VSRI
val / ['1111 0011 1 /D /imm6 /vd 0100 1 /Q /M 1 /vm'] = quaternop VSRI none imm6 vd vm imm6
val / ['1111 0011 1 /D /imm6-not000 /vd 0100 0 /Q /M 1 /vm'] = quaternop VSRI none imm6 vd vm imm6

# --- Advanced SIMD multiply instructions ------------------------------

### VMLA
###  - Vector Multiply Accumulate integer
val / ['1111 001 0 0 /D /size /vn /vd 1001 /N /Q /M 0 /vm'] = quaternop VMLAiasimd none size vd vn vm
###  - Vector Multiply Accumulate floating-point
val / ['1111 0010 0 /D 0 /sz /vn /vd 1101 /N /Q /M 1 /vm'] = unbitTernop VMLAfpasimd none sz vd vn vm
###  - Vector Multiply Accumulate by scalar
val / ['1111 001 /Q 1 /D /size /vn /vd 0 0 0 /F /N 1 /M 0 /vm'] = unbitQuaternop VMLAsasimd none f size vd vn vm

### VMLAL
###  - Vector Multiply Accumulate Long integer
val / ['1111 001 /U 1 /D /size /vn /vd 10 0 0 /N 0 /M 0 /vm'] = unbitQuaternop VMLAL none u size vdq1 vnq0 vmq0
###  - Vector Multiply Accumulate Long by scalar
val / ['1111 001 /U 1 /D /size /vn /vd 0 0 10 /N 1 /M 0 /vm'] = unbitQuaternop VMLAL none u size vdq1 vnq0 vmq0

### VMLS
###  - Vector Multiply Subtract integer
val / ['1111 001 1 0 /D /size /vn /vd 1001 /N /Q /M 0 /vm'] = quaternop VMLSiasimd none size vd vn vm
###  - Vector Multiply Subtract floating-point
val / ['1111 0010 0 /D 1 /sz /vn /vd 1101 /N /Q /M 1 /vm'] = unbitTernop VMLSfpasimd none sz vd vn vm
###  - Vector Multiply Subtract by scalar
val / ['1111 001 /Q 1 /D /size /vn /vd 0 1 0 /F /N 1 /M 0 /vm'] = unbitQuaternop VMLSsasimd none f size vd vn vm

### VMLSL
###  - Vector Multiply Subtract Long integer
val / ['1111 001 /U 1 /D /size /vn /vd 10 1 0 /N 0 /M 0 /vm'] = unbitQuaternop VMLSL none u size vdq1 vnq0 vmq0
###  - Vector Multiply Subtract Long by scalar
val / ['1111 001 /U 1 /D /size /vn /vd 0 1 10 /N 1 /M 0 /vm'] = unbitQuaternop VMLSL none u size vdq1 vnq0 vmq0

### VMUL
###  - Vector Multiply integer and polynomial
val / ['1111 001 1 0 /D 00 /vn /vd 1001 /N /Q /M 1 /vm'] = unbitQuaternop VMULipasimd none set1 set00 vd vn vm
val / ['1111 001 0 0 /D /size /vn /vd 1001 /N /Q /M 1 /vm'] = unbitQuaternop VMULipasimd none set0 size vd vn vm
###  - Vector Multiply floating-point
val / ['1111 0011 0 /D 0 /sz /vn /vd 1101 /N /Q /M 1 /vm'] = unbitTernop VMULfpasimd none sz vd vn vm
###  - Vector Multiply by scalar
val / ['1111 001 /Q 1 /D /size /vn /vd 100 /F /N 1 /M 0 /vm'] = unbitQuaternop VMULsasimd none f size vd vn vm

### VMULL
###  - Vector Multiply Long integer and polynomial
val / ['1111 001 /U 1 /D /size /vn /vd 11 0 0 /N 0 /M 0 /vm'] = binbitQuaternop VMULLipasimd none set0 u size vdq1 vnq0 vmq0
val / ['1111 001 0 1 /D 00 /vn /vd 11 1 0 /N 0 /M 0 /vm'] = binbitQuaternop VMULLipasimd none set1 set0 set00 vdq1 vnq0 vmq0
###  - Vector Multiply Long by scalar
val / ['1111 001 /U 1 /D /size /vn /vd 1010 /N 1 /M 0 /vm'] = unbitQuaternop VMULLsasimd none u size vdq1 vnq0 vmq0

### VFMA
###  - Vector Fused Multiply Accumulate
val / ['1111 00100 /D 0 /sz /vn /vd 1100 /N /Q /M 1 /vm'] = unbitTernop VFMA none sz vd vn vm

### VFMS
###  - Vector Fused Multiply Subtract
val / ['1111 00100 /D 1 /sz /vn /vd 1100 /N /Q /M 1 /vm'] = unbitTernop VFMS none sz vd vn vm

### VQDMLAL
###  - Vector Saturating Doubling Multiply Accumulate Long (Encoding A1)
val / ['1111 0010 1 /D /size /vn /vd 10 0 1 /N 0 /M 0 /vm'] = quaternop VQDMLAL none size vdq1 vnq0 vmq0
###  - Vector Saturating Doubling Multiply Accumulate Long (Encoding A2)
val / ['1111 0010 1 /D /size /vn /vd 0 0 11 /N 1 /M 0 /vm'] = quaternop VQDMLAL none size vdq1 vnq0 vmq0

### VQDMLSL
###  - Vector Saturating Doubling Multiply Subtract Long (Encoding A1)
val / ['1111 0010 1 /D /size /vn /vd 10 1 1 /N 0 /M 0 /vm'] = quaternop VQDMLSL none size vdq1 vnq0 vmq0
###  - Vector Saturating Doubling Multiply Subtract Long (Encoding A2)
val / ['1111 0010 1 /D /size /vn /vd 0 1 11 /N 1 /M 0 /vm'] = quaternop VQDMLSL none size vdq1 vnq0 vmq0

### VQDMULH
###  - Vector Saturating Doubling Multiply Returning High Half (Encoding A1)
val / ['1111 0010 0 /D /size /vn /vd 1011 /N /Q /M 0 /vm'] = quaternop VQDMULH none size vd vn vm
###  - Vector Saturating Doubling Multiply Returning High Half (Encoding A2)
val / ['1111 001 /Q 1 /D /size /vn /vd 1100 /N 1 /M 0 /vm'] = quaternop VQDMULH none size vd vn vm

### VQRDMULH
###  - Vector Saturating Rounding Doubling Multiply Returning High Half (Encoding A1)
val / ['1111 0011 0 /D /size /vn /vd 1011 /N /Q /M 0 /vm'] = quaternop VQRDMULH none size vd vn vm
###  - Vector Saturating Rounding Doubling Multiply Returning High Half (Encoding A2)
val / ['1111 001 /Q 1 /D /size /vn /vd 1101 /N 1 /M 0 /vm'] = quaternop VQRDMULH none size vd vn vm

### VQDMULL
###  - Vector Saturating Doubling Multiply Long (Encoding A1)
val / ['1111 0010 1 /D /size /vn /vd 1101 /N 0 /M 0 /vm'] = quaternop VQDMULL none size vdq1 vnq0 vmq0
###  - Vector Saturating Doubling Multiply Long (Encoding A2)
val / ['1111 0010 1 /D /size /vn /vd 1011 /N 1 /M 0 /vm'] = quaternop VQDMULL none size vdq1 vnq0 vmq0

# --- Miscellanous Advanced SIMD data-processing instructions ----------

### VABA
###  - Vector Absolute Difference and Accumulate
val / ['1111 001 /U 0 /D /size /vn /vd 0111 /N /Q /M 1 /vm'] = unbitQuaternop VABA none u size vd vn vm

### VABAL
###  - Vector Absolute Difference and Accumulate Long
val / ['1111 001 /U 1 /D /size /vn /vd 0101 /N 0 /M 0 /vm'] = unbitQuaternop VABAL none u size vdq1 vnq0 vmq0

### VABD
###  - Vector Absolute Difference integer
val / ['1111 001 /U 0 /D /size /vn /vd 0111 /N /Q /M 0 /vm'] = unbitQuaternop VABDi none u size vd vn vm
###  - Vector Absolute Difference floating-point
val / ['1111 0011 0 /D 1 /sz /vn /vd 1101 /N /Q /M 0 /vm'] = unbitTernop VABDfp none sz vd vn vm

### VABDL
###  - Vector Absolute Difference Long
val / ['1111 001 /U 1 /D /size /vn /vd 0111 /N 0 /M 0 /vm'] = unbitQuaternop VABDL none u size vdq1 vnq0 vmq0

### VABS
val / ['1111 0011 1 /D 11 10 01 /vd 0 1 110 /Q /M 0 /vm'] = unbitTernop VABSasimd none set1 set10 vd vm
val / ['1111 0011 1 /D 11 /size 01 /vd 0 0 110 /Q /M 0 /vm'] = unbitTernop VABSasimd none set0 size vd vm

### VCVT
###  - Vector Convert between floating-point and integer
val / ['1111 0011 1 /D 11 10 11 /vd 0 11 /size2 /Q /M 0 /vm'] = ternop VCVTfpiasimd none size vd vm
###  - Vector Convert between floating-point and fixed-point
val / ['1111 001 /U 1 /D /imm6-not000 /vd 111 /op 0 /Q /M 1 /vm'] = binbitTernop VCVTfpfpasimd none u op vd vm imm6
###  - Vector Convert between half-precision and single-precision
val / ['1111 0011 1 /D 11 /size 10 /vd 011 0 00 /M 0 /vm'] = ternop VCVThpspasimd none size vdq1 vmq0
val / ['1111 0011 1 /D 11 /size 10 /vd 011 1 00 /M 0 /vm'] = ternop VCVThpspasimd none size vdq0 vmq1

### VCLS
###  - Vector Count Leading Sign Bits
val / ['1111 0011 1 /D 11 /size 00 /vd 0 1000 /Q /M 0 /vm'] = ternop VCLS none size vd vm

### VCLZ
###  - Vector Count Leading Zeros
val / ['1111 0011 1 /D 11 /size 00 /vd 0 1001 /Q /M 0 /vm'] = ternop VCLZ none size vd vm

### VCNT
###  - Vector Count Number of Bits in Element
val / ['1111 0011 1 /D 11 /size 00 /vd 0 1010 /Q /M 0 /vm'] = ternop VCNT none size vd vm

### VDUP
###  - Vector Duplicate Scalar
val / ['1111 0011 1 /D 11 /imm4 /vd 1100 0 /Q /M 0 /vm'] = ternop VDUP2 none imm4 vd vm

### VEXT
###  - Vector Extract
val / ['1111 0010 1 /D 11 /vn /vd /imm4 /N /Q /M 0 /vm'] = quaternop VEXT none vd vn vm imm4

### VMOVN
###  - Vector Move and Narrow
val / ['1111 0011 1 /D 11 /size 10 /vd 0 0100 0 /M 0 /vm'] = ternop VMOVN none size vdq0 vmq0

### VMOVL
###  - Vector Move Long
val / ['1111 001 /U 1 /D /imm3_124 000 /vd 1010 0 0 /M 1 /vm'] = ternop VMOVL none imm3 vdq0 vmq0

### VMAX
###  - Vector Maximum integer
val / ['1111 001 /U 0 /D /size /vn /vd 0110 /N /Q /M 0 /vm'] = unbitQuaternop VMAXi none u size vd vn vm
###  - Vector Maximum floating-point
val / ['1111 0010 0 /D 0 /sz /vn /vd 1111 /N /Q /M 0 /vm'] = unbitTernop VMAXfp none sz vd vn vm

### VMIN
###  - Vector Minimum integer
val / ['1111 001 /U 0 /D /size /vn /vd 0110 /N /Q /M 1 /vm'] = unbitQuaternop VMINi none u size vd vn vm
###  - Vector Minimum floating-point
val / ['1111 0010 0 /D 1 /sz /vn /vd 1111 /N /Q /M 0 /vm'] = unbitTernop VMINfp none sz vd vn vm

### VNEG
###  - Vector Negate
val / ['1111 0011 1 /D 11 /size 01 /vd 0 /F 111 /Q /M 0 /vm'] = unbitTernop VNEGasimd none f size vd vm

### VPMAX
###  - Vector Pairwise Maximum integer
val / ['1111 001 /U 0 /D /size /vn /vd 1010 /N 0 /M 0 /vm'] = unbitQuaternop VPMAXi none u size vdq0 vnq0 vmq0
###  - Vector Pairwise Maximum floating-point
val / ['1111 0011 0 /D 0 /sz /vn /vd 1111 /N 0 /M 0 /vm'] = unbitTernop VPMAXfp none sz vdq0 vnq0 vmq0

### VPMIN
###  - Vector Pairwise Minimum integer
val / ['1111 001 /U 0 /D /size /vn /vd 1010 /N 0 /M 1 /vm'] = unbitQuaternop VPMINi none u size vdq0 vnq0 vmq0
###  - Vector Pairwise Minimum floating-point
val / ['1111 0011 0 /D 1 /sz /vn /vd 1111 /N 0 /M 0 /vm'] = unbitTernop VPMINfp none sz vdq0 vnq0 vmq0

### VRECPE
###  - Vector Reciprocal Estimate
val / ['1111 0011 1 /D 11 /size 11 /vd 010 /F 0 /Q /M 0 /vm'] = unbitTernop VRECPE none f size vd vm

### VRECPS
###  - Vector Reciprocal Step
val / ['1111 0010 0 /D 0 /sz /vn /vd 1111 /N /Q /M 1 /vm'] = unbitTernop VRECPS none sz vd vn vm

### VRSQRTE
###  - Vector Reciprocal Square Root Estimate
val / ['1111 0011 1 /D 11 /size 11 /vd 010 /F 1 /Q /M 0 /vm'] = unbitTernop VRSQRTE none f size vd vm 

### VRSQRTS
###  - Vector Reciprocal Square Root Step
val / ['1111 0010 0 /D 1 /sz /vn /vd 1111 /N /Q /M 1 /vm'] = unbitTernop VRSQRTS none sz vd vn vm 

### VREV16
###  - Vector Reverse in halfwords
val / ['1111 0011 1 /D 11 /size 00 /vd 000 10 /Q /M 0 /vm'] = ternop VREV16 none size vd vm

### VREV32
###  - Vector Reverse in words
val / ['1111 0011 1 /D 11 /size 00 /vd 000 01 /Q /M 0 /vm'] = ternop VREV32 none size vd vm

### VREV64
###  - Vector Reverse in doublewords
val / ['1111 0011 1 /D 11 /size 00 /vd 000 00 /Q /M 0 /vm'] = ternop VREV64 none size vd vm

### VQABS
###  - Vector Saturating Absolute
val / ['1111 0011 1 /D 11 /size 00 /vd 0111 0 /Q /M 0 /vm'] = ternop VQABS none size vd vm

### VQMOVN
###  - Vector Saturating Move and Narrow
val / ['1111 0011 1 /D 11 /size 10 /vd 0010 1 /U /M 0 /vm'] = unbitTernop VQMOVN none u size vdq0 vmq1

### VQMOVUN
###  - Vector Saturating Move Unsigned and Narrow
val / ['1111 0011 1 /D 11 /size 10 /vd 0010 0 1 /M 0 /vm'] = ternop VQMOVUN none size vdq0 vmq1

### VQNEG
###  - Vector Saturating Negate
val / ['1111 0011 1 /D 11 /size 00 /vd 0111 1 /Q /M 0 /vm'] = ternop VQNEG none size vd vm

### VSWP
###  - Vector Swap
val / ['1111 0011 1 /D 11 /size 10 /vd 0 0000 /Q /M 0 /vm'] = ternop VSWP none size vd vm

### VTBL
###  - Vector Table Lookup
val / ['1111 0011 1 /D 11 /vn /vd 10 /len /N 0 /M 0 /vm'] = quaternop VTBL none vdq0 len vnq0 vmq0

### VTBX
###  - Vector Table Extension
val / ['1111 0011 1 /D 11 /vn /vd 10 /len /N 1 /M 0 /vm'] = quaternop VTBX none vdq0 len vnq0 vmq0

### VTRN
###  - Vector Transpose
val / ['1111 0011 1 /D 11 /size 10 /vd 0000 1 /Q /M 0 /vm'] = ternop VTRN none size vd vm 

### VUZP
###  -  Vector Unzip
val / ['1111 0011 1 /D 11 /size 10 /vd 0001 0 /Q /M 0 /vm'] = ternop VUZP none size vd vm

### VZIP
###  - Vector Zip
val / ['1111 0011 1 /D 11 /size 10 /vd 0001 1 /Q /M 0 /vm'] = ternop VZIP none size vd vm

# --- Floating-point data-processing instructions ----------------------

### VABS
###  - Vector Absolute
val / ['/cond 1110 1 /D 11 0000 /vd 101 0 11 /M 0 /vm'] = unbitBinop VABSfp cond set0 vdq1 vmq1
val / ['/cond 1110 1 /D 11 0000 /vd 101 1 11 /M 0 /vm'] = unbitBinop VABSfp cond set1 vdq0 vmq0

### VADD
###  - Vector Add floating-point
val / ['/cond 1110 0 /D 11 /vn /vd 101 0 /N 0 /M 0 /vm'] = unbitTernop VADDfpfp cond set0 vdq1 vnq1 vmq1
val / ['/cond 1110 0 /D 11 /vn /vd 101 1 /N 0 /M 0 /vm'] = unbitTernop VADDfpfp cond set1 vdq0 vnq0 vmq0

### VCMP
###  - Vector Compare (Encoding A1)
val / ['/cond 1110 1 /D 11 0100 /vd 101 0 0 1 /M 0 /vm'] = unbitBinop VCMP cond set0 vdq1 vmq1
val / ['/cond 1110 1 /D 11 0100 /vd 101 1 0 1 /M 0 /vm'] = unbitBinop VCMP cond set1 vdq0 vmq0
###  - Vector Compare (Encoding A2)
val / ['/cond 1110 1 /D 11 0101 /vd 101 0 0 1 0 0 0000'] = unbitBinop VCMP cond set0 vdq1 vm100000
val / ['/cond 1110 1 /D 11 0101 /vd 101 1 0 1 0 0 0000'] = unbitBinop VCMP cond set1 vdq0 vm000000

### VCMPE
###  - Vector Compare Exception (Encoding A1)
val / ['/cond 1110 1 /D 11 0100 /vd 101 0 1 1 /M 0 /vm'] = unbitBinop VCMPE cond set0 vdq1 vmq1
val / ['/cond 1110 1 /D 11 0100 /vd 101 1 1 1 /M 0 /vm'] = unbitBinop VCMPE cond set1 vdq0 vmq0
###  - Vector Compare Exception (Encoding A2)
val / ['/cond 1110 1 /D 11 0101 /vd 101 0 1 1 0 0 0000'] = unbitBinop VCMPE cond set0 vdq1 vm100000
val / ['/cond 1110 1 /D 11 0101 /vd 101 1 1 1 0 0 0000'] = unbitBinop VCMPE cond set1 vdq0 vm000000

### VCVT
###  - Vector Convert between floating-point and integer
val / ['/cond 1110 1 /D 11 1 000 /vd 101 0 /op 1 /M 0 /vm'] = binbitBinop VCVTfpifp cond op set0 vdq1 vmq1
val / ['/cond 1110 1 /D 11 1 000 /vd 101 1 /op 1 /M 0 /vm'] = binbitBinop VCVTfpifp cond op set1 vdq0 vmq1
###  - Vector Convert between floating-point and fixed-point
val / ['/cond 1110 1 /D 11 1 /op 1 /U /vd 101 0 /sz1 1 /i 0 /imm4'] = quaternbitTernop VCVTfpfpfp cond op set0 u sz1 vdq1 vdq1 combine-imm5
val / ['/cond 1110 1 /D 11 1 /op 1 /U /vd 101 1 /sz1 1 /i 0 /imm4'] = quaternbitTernop VCVTfpfpfp cond op set1 u sz1 vdq0 vdq0 combine-imm5
###  - Vector Convert between double-precision and single-precision
val / ['/cond 1110 1 /D 11 0 111 /vd 101 /sz1 11 /M 0 /vm'] = binop VCVTdpspfp cond vd vm

### VCVTR
###  - Vector Convert Round between floating-point and integer
val / ['/cond 1110 1 /D 11 1 /opc2-vcvtr /vd 101 0 /op 1 /M 0 /vm'] = unopUnbitBinop VCVTR cond opc23 set0 vdq1 vmq1
val / ['/cond 1110 1 /D 11 1 /opc2-vcvtr /vd 101 1 /op 1 /M 0 /vm'] = unopUnbitBinop VCVTR cond opc23 set1 vdq1 vmq0

### VCVTB
###  - Vector Convert Bottom
val / ['/cond 1110 1 /D 11 001 /op /vd 101 0 0 1 /M 0 /vm'] = unbitBinop VCVTB cond op vdq1 vmq1

### VCVTT
###  - Vector Convert Top
val / ['/cond 1110 1 /D 11 001 /op /vd 101 0 1 1 /M 0 /vm'] = unbitBinop VCVTT cond op vdq1 vmq1

### VDIV
###  - Vector Divide
val / ['/cond 1110 1 /D 00 /vn /vd 101 1 /N 0 /M 0 /vm'] = unbitTernop VDIV cond set1 vdq0 vnq0 vmq0
val / ['/cond 1110 1 /D 00 /vn /vd 101 0 /N 0 /M 0 /vm'] = unbitTernop VDIV cond set0 vdq1 vnq1 vmq1

### VMLA
###  - Vector Multiply Accumulate floating-point
val / ['/cond 11100 /D 00 /vn /vd 101 1 /N 0 /M 0 /vm'] = unbitTernop VMLAfpfp cond set1 vdq0 vnq0 vmq0
val / ['/cond 11100 /D 00 /vn /vd 101 0 /N 0 /M 0 /vm'] = unbitTernop VMLAfpfp cond set0 vdq1 vnq1 vmq1

### VMLS
###  - Vector Multiply Subtract floating-point
val / ['/cond 11100 /D 00 /vn /vd 101 1 /N 1 /M 0 /vm'] = unbitTernop VMLSfpfp cond set1 vdq0 vnq0 vmq0
val / ['/cond 11100 /D 00 /vn /vd 101 0 /N 1 /M 0 /vm'] = unbitTernop VMLSfpfp cond set0 vdq1 vnq1 vmq1

### VMOV
###  - Vector Move immediate floating-point
val / ['/cond 11101 /D 11 /imm4H /vd 101 0 0000 /imm4L'] = binop VMOVimmfp none vdq0 imm32-vfp
val / ['/cond 11101 /D 11 /imm4H /vd 101 1 0000 /imm4L'] = binop VMOVimmfp none vdq1 imm64-vfp
###  - Vector Move register floating-point
val / ['/cond 11101 /D 11 0000 /vd 101 0 01 /M 0 /vm'] = unbitBinop VMOVregfp none set0 vdq1 vmq1
val / ['/cond 11101 /D 11 0000 /vd 101 1 01 /M 0 /vm'] = unbitBinop VMOVregfp none set1 vdq0 vmq0

### VFMA
###  - Vector Fused Multiply Accumulate
val / ['/cond 11101 /D 10 /vn /vd 101 0 /N 0 /M 0 /vm'] = unbitTernop VFMA cond set0 vdq1 vnq1 vmq1
val / ['/cond 11101 /D 10 /vn /vd 101 1 /N 0 /M 0 /vm'] = unbitTernop VFMA cond set1 vdq0 vnq0 vmq0

### VFMS
###  - Vector Fused Multiply Subtract
val / ['/cond 11101 /D 10 /vn /vd 101 0 /N 1 /M 0 /vm'] = unbitTernop VFMS cond set0 vdq1 vnq1 vmq1
val / ['/cond 11101 /D 10 /vn /vd 101 1 /N 1 /M 0 /vm'] = unbitTernop VFMS cond set1 vdq0 vnq0 vmq0

### VMUL
###  - Vector Multiply floating-point
val / ['/cond 11100 /D 10 /vn /vd 101 0 /N 0 /M 0 /vm'] = unbitTernop VMULfpfp cond set0 vdq1 vnq1 vmq1
val / ['/cond 11100 /D 10 /vn /vd 101 1 /N 0 /M 0 /vm'] = unbitTernop VMULfpfp cond set1 vdq0 vnq0 vmq0 

### VNEG
###  - Vector Negate
val / ['/cond 11101 /D 11 0001 /vd 101 0 01 /M 0 /vm'] = unbitBinop VNEGfp cond set0 vdq1 vmq1
val / ['/cond 11101 /D 11 0001 /vd 101 1 01 /M 0 /vm'] = unbitBinop VNEGfp cond set1 vdq0 vmq0

### VNMLA
###  - Vector Multiply Negate Add Negation
val / ['/cond 11100 /D 01 /vn /vd 101 1 /N 1 /M 0 /vm'] = unbitTernop VNMLA cond set1 vdq0 vnq0 vmq0
val / ['/cond 11100 /D 01 /vn /vd 101 0 /N 1 /M 0 /vm'] = unbitTernop VNMLA cond set0 vdq1 vnq1 vmq1

### VNMLS
###  - Vector Multiply Add Negation
val / ['/cond 11100 /D 01 /vn /vd 101 1 /N 0 /M 0 /vm'] = unbitTernop VNMLS cond set1 vdq0 vnq0 vmq0
val / ['/cond 11100 /D 01 /vn /vd 101 0 /N 0 /M 0 /vm'] = unbitTernop VNMLS cond set0 vdq1 vnq1 vmq1

### VNMUL
###  - Vector Multiply Negate
val / ['/cond 11100 /D 10 /vn /vd 101 1 /N 1 /M 0 /vm'] = unbitTernop VNMUL cond set1 vdq0 vnq0 vmq0
val / ['/cond 11100 /D 10 /vn /vd 101 0 /N 1 /M 0 /vm'] = unbitTernop VNMUL cond set0 vdq1 vnq1 vmq1

### VFNMA
###  - Vector Fused Multiply Accumulate
val / ['/cond 11101 /D 01 /vn /vd 101 1 /N 1 /M 0 /vm'] = unbitTernop VFNMA cond set1 vdq0 vnq0 vmq0
val / ['/cond 11101 /D 01 /vn /vd 101 0 /N 1 /M 0 /vm'] = unbitTernop VFNMA cond set0 vdq1 vnq1 vmq1

### VFNMS
###  - Vector Fused Multiply Subtract
val / ['/cond 11101 /D 01 /vn /vd 101 1 /N 0 /M 0 /vm'] = unbitTernop VFNMS cond set1 vdq0 vnq0 vmq0
val / ['/cond 11101 /D 01 /vn /vd 101 0 /N 0 /M 0 /vm'] = unbitTernop VFNMS cond set0 vdq1 vnq1 vmq1

### VSQRT
###  - Vector Square Root
val / ['/cond 11101 /D 11 0001 /vd 101 1 11 /M 0 /vm'] = unbitBinop VSQRT cond set1 vdq0 vmq0
val / ['/cond 11101 /D 11 0001 /vd 101 0 11 /M 0 /vm'] = unbitBinop VSQRT cond set0 vdq1 vmq1

### VSUB (floating-point)
###  - Vector Subtract floating-point (Encoding A2)
val / ['/cond 1110 0 /D 11 /vn /vd 101 1 /N 1 /M 0 /vm'] = unbitTernop VSUBfpfp cond set1 vdq0 vnq0 vmq0
val / ['/cond 1110 0 /D 11 /vn /vd 101 0 /N 1 /M 0 /vm'] = unbitTernop VSUBfpfp cond set0 vdq1 vnq1 vmq1