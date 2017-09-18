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
    b='0', p='0', w='0', s='0', d='0',
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
    ADC of dp
  | ADD of dp
  | ADR of dp
  | AND of dp
  | BIC of dp
  | CMN of dp
  | CMP of dp
  | EOR of dp
  | MOV of dp
  | MVN of dp
  | ORR of dp
  | RSB of dp
  | RSC of dp
  | SBC of dp
  | SUB of dp
  | TEQ of dp
  | TST of dp
  | MLA of mul
  | MLS of mul
  | MUL of mul
  | SMLABB of mul
  | SMLABT of mul
  | SMLATB of mul
  | SMLATT of mul
  | SMLAD of mul
  | SMLADX of mul
  | SMLAL of mull
  | SMLALBB of mull
  | SMLALBT of mull
  | SMLALTB of mull
  | SMLALTT of mull
  | SMLALD of mull
  | SMLALDX of mull
  | SMLAWB of mul
  | SMLAWT of mul
  | SMLSD of mul
  | SMLSDX of mul
  | SMLSLD of mull
  | SMLSLDX of mull
  | SMMLA of mul
  | SMMLAR of mul
  | SMMLS of mul
  | SMMLSR of mul
  | SMMUL of mul
  | SMMULR of mul
  | SMUAD of mul
  | SMUADX of mul
  | SMULBB of mul
  | SMULBT of mul
  | SMULTB of mul
  | SMULTT of mul
  | SMULL of mull
  | SMULWB of mul
  | SMULWT of mul
  | SMUSD of mul
  | SMUSDX of mul
  | UMAAL of mull
  | UMLAL of mull
  | UMULL of mull
  | SSAT of sat
  | SSAT16 of sat
  | USAT of sat
  | USAT16 of sat
  | QADD of satop
  | QSUB of satop
  | QDADD of satop
  | QDSUB of satop
  | PKH of pup
  | SXTAB of pup
  | SXTAB16 of pup
  | SXTAH of pup
  | SXTB of pup
  | SXTB16 of pup
  | SXTH of pup
  | UXTAB of pup
  | UXTAB16 of pup
  | UXTAH of pup
  | UXTB of pup
  | UXTB16 of pup
  | UXTH of pup
  | SADD16 of pas
  | QADD16 of pas
  | SHADD16 of pas
  | UADD16 of pas
  | UQADD16 of pas
  | UHADD16 of pas
  | SASX of pas
  | QASX of pas
  | SHASX of pas
  | UASX of pas
  | UQASX of pas
  | UHASX of pas
  | SSAX of pas
  | QSAX of pas
  | SHSAX of pas
  | USAX of pas
  | UQSAX of pas
  | UHSAX of pas
  | SSUB16 of pas
  | QSUB16 of pas
  | SHSUB16 of pas
  | USUB16 of pas
  | UQSUB16 of pas
  | UHSUB16 of pas
  | SADD8 of pas
  | QADD8 of pas
  | SHADD8 of pas
  | UADD8 of pas
  | UQADD8 of pas
  | UHADD8 of pas
  | SSUB8 of pas
  | QSUB8 of pas
  | SHSUB8 of pas
  | USUB8 of pas
  | UQSUB8 of pas
  | UHSUB8 of pas
  | SDIV of divi
  | UDIV of divi
  | BFC of bf
  | BFI of bf
  | CLZ of binop
  | MOVT of binop
  | RBIT of binop
  | REV of binop
  | REV16 of binop
  | REVSH of binop
  | SBFX of bf
  | SEL of mdp
  | UBFX of bf
  | USAD8 of madp
  | USADA8 of madp
  | MRS of brdr
  | MSR of brnr
  | CPS of binop
  | LDR of ls
  | LDRT of ls
  | LDRB of ls
  | LDRBT of ls
  | LDRH of ls
  | LDRHT of ls
  | LDRSB of ls
  | LDRSBT of ls
  | LDRSH of ls
  | LDRSHT of ls
  | LDRD of ls
  | LDREX of binop
  | LDREXB of binop
  | LDREXD of binop
  | LDREXH of binop
  | STR of ls
  | STRT of ls
  | STRB of ls
  | STRBT of ls
  | STRD of ls
  | STRH of ls
  | STRHT of ls
  | STREX of lstr
  | STREXB of lstr
  | STREXD of lstr
  | STREXH of lstr
  | LDM of lsm
  | LDMDA of lsm
  | LDMDB of lsm
  | LDMIB of lsm
  | POP of lsm
  | STM of lsm
  | STMDA of lsm
  | STMDB of lsm
  | STMIB of lsm
  | PUSH of lsm
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
  | PLD of pre
  | PLDW of pre
  | PLI of pre
  | SETEND of unopbit
  | SEV of nullop
  | SWP of swap
  | SWPB of swap
  | WFE of nullop
  | WFI of nullop
  | YIELD of nullop
  | SVC of unop
  | BKPT of unop
  | SMC of unop
  | RFE of exc
  | SUBS of subs
  | HVC of unop
  | ERET of nullop
  | LDMerur of ldm
  | SRS of srs
  | CDP of cdp
  | CDP2 of cdp
  | MCR of mcr
  | MCR2 of mcr
  | MCRR of mcrr
  | MCRR2 of mcrr
  | MRC of mrc
  | MRC2 of mrc
  | MRRC of mrrc
  | MRRC2 of mrrc
  | LDC of cop
  | LDC2 of cop
  | STC of cop
  | STC2 of cop
  | VLDMIA of vlsm
  | VLDMDB of vlsm
  | VLDR of vlsr
  | VSTMIA of vlsm
  | VSTMDB of vlsm
  | VSTR of vlsr
  | VLD1 of vls
  | VLD1a of vlsbit
  | VLD2 of vls
  | VLD2a of vlsbit
  | VLD3 of vls
  | VLD3a of vlsbit
  | VLD4 of vls
  | VLD4a of vlsbit
  | VST1 of vls
  | VST2 of vls
  | VST3 of vls
  | VST4 of vls
  | VDUP of vc
  | VMOVacs of vc
  | VMOVsac of vcrev
  | VMOVacsp of vcns
  | VMOVspac of vcrevns
  | VMOVacsp2 of vcns2
  | VMOVspac2 of vcrevns2
  | VMOVacdwe of vcns2half
  | VMOVdweac of vcrevns2half
  | VMRS of unop
  | VMSR of unop
  | VADDiasimd of vc3
  | VADDfpasimd of vc3bit
  | VADDHN of vc3
  | VADDL of vc3sig
  | VADDW of vc3sig
  | VHADD of vc3sig
  | VHSUB of vc3sig
  | VPADAL of vc2sig
  | VPADDi of vc3
  | VPADDfp of vc3bit
  | VPADDL of vc2sig
  | VRADDHN of vc3
  | VRHADD of vc3sig
  | VRSUBHN of vc3
  | VQADD of vc3sig
  | VQSUB of vc3sig
  | VSUBiasimd of vc3
  | VSUBfpasimd of vc3bit
  | VSUBHN of vc3
  | VSUBL of vc3sig
  | VSUBW of vc3sig
  | VAND of vc3ns
  | VBICimm of vcimm
  | VBICreg of vc3ns
  | VEOR of vc3ns
  | VBIF of vc3ns
  | VBIT of vc3ns
  | VBSL of vc3ns
  | VMOVimmasimd of vcimm
  | VMOVregasimd of vc2ns
  | VMVNimm of vcimm
  | VMVNreg of vc2
  | VORRimm of vcimm
  | VORRreg of vc3ns
  | VORN of vc3ns
  | VACGE of vc3bit
  | VACGT of vc3bit
  | VCEQrega of vc3
  | VCEQregb of vc3bit
  | VCEQimm of vc2sig
  | VCGErega of vc3sig
  | VCGEregb of vc3bit
  | VCGEimm of vc2sig
  | VCGTrega of vc3sig
  | VCGTregb of vc3bit
  | VCGTimm of vc2sig
  | VCLE of vc2sig
  | VCLT of vc2sig
  | VTST of vc3
  | VQRSHL of vc3sig
  | VQRSHRN of vc2sigimm
  | VQRSHRUN of vc2sigimm
  | VQSHLreg of vc3sig
  | VQSHLimm of vc2sigimm
  | VQSHLU of vc2sigimm
  | VQSHRN of vc2sigimm
  | VQSHRUN of vc2sigimm
  | VRSHL of vc3sig
  | VRSHR of vc2sigimm
  | VRSRA of vc2sigimm
  | VRSHRN of vc2imm
  | VSHLimm of vc2imm
  | VSHLreg of vc3sig
  | VSHLL of vc2sigimm
  | VSHR of vc2sigimm
  | VSHRN of vc2imm
  | VSLI of vc2imm
  | VSRA of vc2sigimm
  | VSRI of vc2imm
  | VMLAiasimd of vc3
  | VMLAfpasimd of vc3bit
  | VMLAsasimd of vc3sig
  | VMLAL of vc3sig
  | VMLSiasimd of vc3
  | VMLSfpasimd of vc3bit
  | VMLSsasimd of vc3sig
  | VMLSL of vc3sig
  | VMULipasimd of vc3sig
  | VMULfpasimd of vc3bit
  | VMULsasimd of vc3sig
  | VMULLipasimd of vc3sig2
  | VMULLsasimd of vc3sig
  | VFMA of vc3bit
  | VFMS of vc3bit
  | VQDMLAL of vc3
  | VQDMLSL of vc3
  | VQDMULH of vc3
  | VQRDMULH of vc3
  | VQDMULL of vc3
  | VABA of vc3sig
  | VABAL of vc3sig
  | VABDi of vc3sig
  | VABDfp of vc3bit
  | VABDL of vc3sig
  | VABSasimd of vc2sig
  | VCVTfpiasimd of vc2
  | VCVTfpfpasimd of vc2sigbitimm
  | VCVThpspasimd of vc2
  | VCLS of vc2
  | VCLZ of vc2
  | VCNT of vc2
  | VDUP2 of vc2
  | VEXT of vc3nsimm
  | VMOVN of vc2
  | VMOVL of vc2
  | VMAXi of vc3sig
  | VMAXfp of vc3bit
  | VMINi of vc3sig
  | VMINfp of vc3bit
  | VNEGasimd of vc2sig
  | VPMAXi of vc3sig
  | VPMAXfp of vc3bit
  | VPMINi of vc3sig
  | VPMINfp of vc3bit
  | VRECPE of vc2sig
  | VRECPS of vc3bit
  | VRSQRTE of vc2sig
  | VRSQRTS of vc3bit
  | VREV16 of vc2
  | VREV32 of vc2
  | VREV64 of vc2
  | VQABS of vc2
  | VQMOVN of vc2sig
  | VQMOVUN of vc2
  | VQNEG of vc2
  | VSWP of vc2
  | VTBL of vc3nslist
  | VTBX of vc3nslist
  | VTRN of vc2
  | VUZP of vc2
  | VZIP of vc2
  | VABSfp of vc2bit
  | VADDfpfp of vc3bit
  | VCMP of vc2bit
  | VCMPE of vc2bit
  | VCVTfpifp of vc2bit2
  | VCVTfpfpfp of vcbit4imm
  | VCVTdpspfp of vc2ns
  | VCVTR of vc2opbit
  | VCVTB of vc2bit
  | VCVTT of vc2bit
  | VDIV of vc2bit
  | VMLAfpfp of vc3bit
  | VMLSfpfp of vc3bit
  | VMOVimmfp of vcimm
  | VMOVregfp of vc2bit
  | VMULfpfp of vc3bit
  | VNEGfp of vc2bit
  | VNMLA of vc2bit
  | VNMLS of vc2bit
  | VNMUL of vc2bit
  | VFNMA of vc2bit
  | VFNMS of vc2bit
  | VSQRT of vc2bit
  | VSUBfpfp of vc3bit 

# Standard data-processing instruction
type dp = {
  cond:condition, # condition code
  setflags:1,     # whether the APSR status flags should be set
  rn:operand,     # first operand register
  rd:operand,     # destination register
  opnd2:operand   # second operand (immediate or register)
}

# Standard multiplication instructions
type mul = {
  cond:condition,
  setflags:1,
  rd:operand,
  ra:operand,
  rm:operand,
  rn:operand
}

# Long mulitplication instructions
type mull = {
  cond:condition,
  setflags:1,
  rdhi:operand,
  rdlo:operand,
  rn:operand,
  rm:operand
}

# Saturating instructions
type sat = {
  cond:condition,
  sat_imm:operand,
  rd:operand,
  rn:operand
}

# Saturating addition and Subtraction instructions
type satop = {
  cond:condition,
  rn:operand,
  rd:operand,
  rm:operand
}

# Packing and unpacking instructions
type pup = {
  cond:condition,
  rn:operand,
  rd:operand,
  rm:operand
}

# Parallel addition and Subtraction instructions
type pas = {
  cond:condition,
  rn:operand,
  rd:operand,
  rm:operand
}

# Divide instructions
type divi = {
  cond:condition,
  rn:operand,
  rd:operand,
  rm:operand
}

# Bit field instructions
type bf = {
  cond:condition,
  wsrc:operand,
  rd:operand,
  lsbit:operand,
  rn:operand
}

# Miscellaneous three register data-processing instructions
type mdp = {
  cond:condition,
  rn:operand,
  rd:operand,
  rm:operand
}

# Miscellaneous four register data-processing instructions
type madp = {
  cond:condition,
  rn:operand,
  rd:operand,
  rm:operand,
  ra:operand
}

# Banked register and destination register instructions
type brdr = {
  cond:condition,
  r:1,
  m1:operand,
  rd:operand,
  m:1
}

# Banked register and arm core register instructions
type brnr = {
  cond:condition,
  r:1,
  m1:operand,
  m:1,
  rn:operand
}

# Load/store instructions
type ls = {
  cond:condition,
  p:1,
  u:1,
  w:1,
  rn:operand,
  rt:operand,
  offset:operand
}

# Load/store multiple instructions
type lsm = {
  cond:condition,
  w:1,
  rn:operand,
  registers:operand
}

# Load/store three registers instructions
type lstr = {
  cond:condition,
  rn:operand,
  rd:operand,
  rt:operand
}

# Preload instructions
type pre = {
  cond:condition,
  rn:operand,
  u:1,
  op:operand
}

# Swap instructions
type swap = {
  cond:condition,
  rn:operand,
  rt:operand,
  rt2:operand
}

# Exception related instructions
type exc = {
  cond:condition,
  p:1,
  u:1,
  w:1,
  rn:operand
}

# SUBS instruction
type subs = {
  cond:condition,
  opcode:operand,
  rn:operand,
  rm:operand
}

# LDM instruction
type ldm = {
  cond:condition,
  p:1,
  u:1,
  w:1,
  rn:operand,
  reglst:operand
}

# SRS instruction
type srs = {
  cond:condition,
  p:1,
  u:1,
  w:1,
  mode:operand
}

# CDP/CDP2 instructions
type cdp = {
  cond:condition,
  coproc:operand,
  opc1:operand,
  crd:operand,
  crn:operand,
  crm:operand,
  opc2:operand
}

# MCR/MCR2 instructions
type mcr = {
  cond:condition,
  coproc:operand,
  opc1:operand,
  rt:operand,
  crn:operand,
  crm:operand,
  opc2:operand
}

# MCRR/MCRR2 instructions
type mcrr = {
  cond:condition,
  coproc:operand,
  opc1:operand,
  rt:operand,
  rt2:operand,
  crm:operand
}

# MRC/MRC2 instructions
type mrc = {
  cond:condition,
  coproc:operand,
  opc1:operand,
  rt:operand,
  crn:operand,
  crm:operand,
  opc2:operand
}

# MRRC/MRRC2 instructions
type mrrc = {
  cond:condition,
  opc:operand,
  rt:operand,
  rt2:operand,
  crm:operand
}

# LDC/LDC2/STC/STC2 instructions
type cop = {
  cond:condition,
  coproc:operand,
  crd:operand,
  rn:operand,
  pudw:operand,
  option:operand
}

# Vector Load/Store Multiple instructions
type vlsm = {
  cond:condition,
  rn:operand,
  w:1,
  q:1,
  d:1,
  vd:operand,
  op:operand
}

# Vector Load/Store Register instructions
type vlsr = {
  cond:condition,
  q:1,
  d:1,
  vd:operand,
  rn:operand,
  u:1,
  op:operand
}

# Vector Load/Store instructions
type vls = {
  cond:condition,
  size:operand,
  q:1,
  d:1,
  vd:operand,
  rn:operand,
  align:operand,
  rm:operand
}

# Vector Load/Store align as bit instructions
type vlsbit = {
  cond:condition,
  size:operand,
  q:1,
  d:1,
  vd:operand,
  rn:operand,
  a:1,
  rm:operand
}

# Vector instructions
type vc = {
  cond:condition,
  size:operand,
  q:1,
  d:1,
  vd:operand,
  op2:operand
}

type vcrev = {
  cond:condition,
  size:operand,
  op:operand,
  q:1,
  n:1,
  vn:operand
}

type vcimm = {
  cond:condition,
  dt:operand,
  q:1,
  d:1,
  vd:operand,
  imm:operand
}

type vcbit4imm = {
  cond:condition,
  op:1,
  sz2:1,
  u:1,
  sz1:1,
  qd:1,
  d:1,
  vd:operand,
  imm:operand
}

type vcns = {
  cond:condition,
  d:1,
  vd:operand,
  op2:operand
}

type vcrevns = {
  cond:condition,
  op:operand,
  q:1,
  n:1,
  vn:operand
}

type vcns2 = {
  cond:condition,
  q:1,
  d:1,
  vd:operand,
  q2:1,
  d2:1,
  vd2:operand,
  op3:operand,
  op4:operand
}

type vcrevns2 = {
  cond:condition,
  op:operand,
  op2:operand,
  q3:1,
  d3:1,
  vd3:operand,
  q4:1,
  d4:1,
  vd4:operand
}

type vcns2half = {
  cond:condition,
  q:1,
  d:1,
  vd:operand,
  op2:operand,
  op3:operand
}

type vcrevns2half = {
  cond:condition,
  op:operand,
  op2:operand,
  q3:1,
  d3:1,
  vd3:operand
}

type vc2 = {
  cond:condition,
  size:operand,
  d:1,
  vd:operand,
  m:1,
  vm:operand
}

type vc2imm = {
  cond:condition,
  size:operand,
  qd:1,
  d:1,
  vd:operand,
  qm:1,
  m:1,
  vm:operand,
  imm:operand
}

type vc2bit = {
  cond:condition,
  sz:1,
  qd:1,
  d:1,
  vd:operand,
  qm:1,
  m:1,
  vm:operand
}

type vc2bit2 = {
  cond:condition,
  sz1:1,
  sz2:1,
  qd:1,
  d:1,
  vd:operand,
  qm:1,
  m:1,
  vm:operand
}

type vc2opbit = {
  cond:condition,
  op:operand,
  sz:1,
  qd:1,
  d:1,
  vd:operand,
  qm:1,
  m:1,
  vm:operand
}

type vc2sig = {
  cond:condition,
  u:1,
  size:operand,
  qd:1,
  d:1,
  vd:operand,
  qm:1,
  m:1,
  vm:operand
}

type vc2sigimm = {
  cond:condition,
  u:1,
  size:operand,
  qd:1,
  d:1,
  vd:operand,
  qm:1,
  m:1,
  vm:operand,
  imm:operand
}

type vc2sigbitimm = {
  cond:condition,
  u:1,
  op:1,
  qd:1,
  d:1,
  vd:operand,
  qm:1,
  m:1,
  vm:operand,
  imm:operand
}

type vc2ns = {
  cond:condition,
  qd:1,
  d:1,
  vd:operand,
  qm:1,
  m:1,
  vm:operand
}

type vc3 = {
  cond:condition,
  size:operand,
  qd:1,
  d:1,
  vd:operand,
  qn:1,
  n:1,
  vn:operand,
  qm:1,
  m:1,
  vm:operand
}

type vc3bit = {
  cond:condition,
  sz:1,
  qd:1,
  d:1,
  vd:operand,
  qn:1,
  n:1,
  vn:operand,
  qm:1,
  m:1,
  vm:operand
}

type vc3sig = {
  cond:condition,
  u:1,
  size:operand,
  qd:1,
  d:1,
  vd:operand,
  qn:1,
  n:1,
  vn:operand,
  qm:1,
  m:1,
  vm:operand
}

type vc3sig2 = {
  cond:condition,
  op:1,
  u:1,
  size:operand,
  qd:1,
  d:1,
  vd:operand,
  qn:1,
  n:1,
  vn:operand,
  qm:1,
  m:1,
  vm:operand
}

type vc3ns = {
  cond:condition,
  qd:1,
  d:1,
  vd:operand,
  qn:1,
  n:1,
  vn:operand,
  qm:1,
  m:1,
  vm:operand
}

type vc3nslist = {
  cond:condition,
  qd:1,
  d:1,
  vd:operand,
  len:operand,
  qn:1,
  n:1,
  vn:operand,
  qm:1,
  m:1,
  vm:operand
}

type vc3nsimm = {
  cond:condition,
  qd:1,
  d:1,
  vd:operand,
  qn:1,
  n:1,
  vn:operand,
  qm:1,
  m:1,
  vm:operand,
  imm:operand
}

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
type unopbit = {
  cond:condition,
  o:1
}


# Generic instruction with two operands
type binop = {
  cond:condition,
  opnd1:operand,
  opnd2:operand
}

type operand =
    IMMEDIATE of immediate
  | REGISTER of register
  | SHIFTED_OPERAND of shiftedoperand
  | OPERAND_LIST of operandlist (* TODO: Replace with operand tuple, maybe? *)

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
  | MODIMM of {byte:8, rot:4} # 8 bit immediate with 4 bit rotation

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

val dp cons cond s rn rd opnd2 = do
  cond <- cond;
  s <- s;
  rn <- rn;
  rd <- rd;
  opnd2 <- opnd2;
  return (cons {cond=cond, setflags=s, rn=rn, rd=rd, opnd2=opnd2})
end

val ml cons cond s rd ra rm rn = do
  cond <- cond;
  s <- s;
  rd <- rd;
  ra <- ra;
  rm <- rm;
  rn <- rn;
  return (cons {cond=cond, setflags=s, rd=rd, ra=ra, rm=rm, rn=rn})
end

val mull cons cond s rdhi rdlo rm rn = do
  cond <- cond;
  s <- s;
  rdhi <- rdhi;
  rdlo <- rdlo;
  rm <- rm;
  rn <- rn;
  return (cons {cond=cond, setflags=s, rdhi=rdhi, rdlo=rdlo, rn=rn, rm=rm})
end

val sat cons cond sat_imm rd rn = do
  cond <- cond;
  sat_imm <- sat_imm;
  rd <- rd;
  rn <- rn;
  return (cons {cond=cond, sat_imm=sat_imm, rd=rd, rn=rn})
end

val satop cons cond rn rd rm = do
  cond <- cond;
  rn <- rn;
  rd <- rd;
  rm <- rm;
  return (cons {cond=cond, rn=rn, rd=rd, rm=rm})
end

val pup cons cond rn rd rm = do
  cond <- cond;
  rn <- rn;
  rd <- rd;
  rm <- rm;
  return (cons {cond=cond, rn=rn, rd=rd, rm=rm})
end

val pas cons cond rn rd rm = do
  cond <- cond;
  rn <- rn;
  rd <- rd;
  rm <- rm;
  return (cons {cond=cond, rn=rn, rd=rd, rm=rm})
end

val divi cons cond rn rd rm = do
  cond <- cond;
  rn <- rn;
  rd <- rd;
  rm <- rm;
  return (cons {cond=cond, rn=rn, rd=rd, rm=rm})
end

val bf cons cond wsrc rd lsbit rn = do
  cond <- cond;
  wsrc <- wsrc;
  rd <- rd;
  lsbit <- lsbit;
  rn <- rn;
  return (cons {cond=cond, wsrc=wsrc, rd=rd, lsbit=lsbit, rn=rn})
end

val mdp cons cond rn rd rm = do
  cond <- cond;
  rn <- rn;
  rd <- rd;
  rm <- rm;
  return (cons {cond=cond, rn=rn, rd=rd, rm=rm})
end

val madp cons cond rn rd rm ra = do
  cond <- cond;
  rn <- rn;
  rd <- rd;
  rm <- rm;
  ra <- ra;
  return (cons {cond=cond, rn=rn, rd=rd, rm=rm, ra=ra})
end

val brdr cons cond r m1 rd m = do
  cond <- cond;
  r <- r;
  m1 <- m1;
  rd <- rd;
  m <- m;
  return (cons {cond=cond, r=r, m1=m1, rd=rd, m=m})
end

val brnr cons cond r m1 m rn = do
  cond <- cond;
  r <- r;
  m1 <- m1;
  m <- m;
  rn <- rn;
  return (cons {cond=cond, r=r, m1=m1, m=m, rn=rn})
end

val ls cons cond p u w rn rd offset = do
  cond <- cond;
  p <- p;
  u <- u;
  w <- w;
  rn <- rn;
  rt <- rt;
  offset <- offset;
  return (cons {cond=cond, p=p, u=u, w=w, rn=rn, rt=rt, offset=offset})
end

val lsm cons cond w rn registers = do
  cond <- cond;
  w <- w;
  rn <- rn;
  registers <- registers;
  return (cons {cond=cond, w=w, rn=rn, registers=registers})
end

val lstr cons cond rn rd rt = do
  cond <- cond;
  rn <- rn;
  rd <- rd;
  rt <- rt;
  return (cons {cond=cond, rn=rn, rd=rd, rt=rt})
end

val pre cons cond rn u op = do
  cond <- cond;
  rn <- rn;
  u <- u;
  op <- op;
  return (cons {cond=cond, rn=rn, u=u, op=op})
end

val swap cons cond rn rt rt2 = do
  cond <- cond;
  rn <- rn;
  rt <- rt;
  rt2 <- rt2;
  return (cons {cond=cond, rn=rn, rt=rt, rt2=rt2})
end

val exc cons cond p u w rn = do
  cond <- cond;
  p <- p;
  u <- u;
  w <- w;
  rn <- rn;
  return (cons {cond=cond, p=p, u=u, w=w, rn=rn})  
end

val subs cons cond opcode rn rm = do
  cond <- cond;
  opcode <- opcode;
  rn <- rn;
  rm <- rm;
  return (cons {cond=cond, opcode=opcode, rn=rn, rm=rm})
end

val ldm cons cond p u w rn reglst = do
  cond <- cond;
  p <- p;
  u <- u;
  w <- w;
  rn <- rn;
  reglst <- reglst;
  return (cons {cond=cond, p=p, u=u, w=w, rn=rn, reglst=reglst})
end

val srs cons cond p u w mode = do
  cond <- cond;
  p <- p;
  u <- u;
  w <- w;
  mode <- mode;
  return (cons {cond=cond, p=p, u=u, w=w, mode=mode})
end

val cdp cons cond coproc opc1 crd crn crm opc2 = do
  cond <- cond;
  coproc <- coproc;
  opc1 <- opc1;
  crd <- crd;
  crn <- crn;
  crm <- crm;
  opc2 <- opc2;
  return (cons {cond=cond, coproc=coproc, opc1=opc1, crd=crd, crn=crn, crm=crm, opc2=opc2})
end

val mcr cons cond coproc opc1 rt crn crm opc2 = do
  cond <- cond;
  coproc <- coproc;
  opc1 <- opc1;
  rt <- rt;
  crn <- crn;
  crm <- crm;
  opc2 <- opc2;
  return (cons {cond=cond, coproc=coproc, opc1=opc1, rt=rt, crn=crn, crm=crm, opc2=opc2})
end

val mcrr cons cond coproc opc1 rt rt2 crm = do
  cond <- cond;
  coproc <- coproc;
  opc1 <- opc1;
  rt <- rt;
  rt2 <- rt2;
  crm <- crm;
  return (cons {cond=cond, coproc=coproc, opc1=opc1, rt=rt, rt2=rt2, crm=crm})
end

val mrc cons cond coproc opc1 rt crn crm opc2 = do
  cond <- cond;
  coproc <- coproc;
  opc1 <- opc1;
  rt <- rt;
  crn <- crn;
  crm <- crm;
  opc2 <- opc2;
  return (cons {cond=cond, coproc=coproc, opc1=opc1, rt=rt, crn=crn, crm=crm, opc2=opc2})
end

val mrrc cons cond coproc opc rt rt2 crm = do
  cond <- cond;
  coproc <- coproc;
  opc <- opc;
  rt <- rt;
  rt2 <- rt2;
  crm <- crm;
  return (cons {cond=cond, coproc=coproc, opc=opc, rt=rt, rt2=rt2, crm=crm})
end

val cop cons cond coproc crd rn pudw option = do
  cond <- cond;
  coproc <- coproc;
  crd <- crd;
  rn <- rn;
  pudw <- pudw;
  option <- option;
  return (cons {cond=cond, coproc=coproc, crd=crd, rn=rn, pudw=pudw, option=option})
end

val vlsm cons cond rn w q d vd op = do
  cond <- cond;
  rn <- rn;
  w <- w;
  q <- q;
  d <- d;
  vd <- vd;
  op <- op;
  return (cons {cond=cond, rn=rn, w=w, q=q, d=d, vd=vd, op=op})
end

val vlsr cons cond q d vd rn u op = do
  cond <- cond;
  q <- q;
  d <- d;
  vd <- vd;
  rn <- rn;
  u <- u;
  op <- op;
  return (cons {cond=cond, q=q, d=d, vd=vd, rn=rn, u=u, op=op})
end

val vls cons cond size q d vd rn align rm = do
  cond <- cond;
  size <- size;
  q <- q;
  d <- d;
  vd <- vd;
  rn <- rn;
  align <- align;
  rm <- rm;
  return (cons {cond=cond, size=size, q=q, d=d, vd=vd, rn=rn, align=align, rm=rm})
end

val vlsbit cons cond size q d vd rn a rm = do
  cond <- cond;
  size <- size;
  q <- q;
  d <- d;
  vd <- vd;
  rn <- rn;
  a <- a;
  rm <- rm;
  return (cons {cond=cond, size=size, q=q, d=d, vd=vd, rn=rn, a=a, rm=rm})
end

val vc cons cond size q d vd op2 = do
  cond <- cond;
  size <- size;
  q <- q;
  d <- d;
  vd <- vd;
  op2 <- op2;
  return (cons {cond=cond, size=size, q=q, d=d, vd=vd, op2=op2})
end

val vcrev cons cond size op q n vn = do
  cond <- cond;
  size <- size;
  op <- op;
  q <- q;
  n <- n;
  vn <- vn;
  return (cons {cond=cond, size=size, op=op, q=q, n=n, vn=vn})
end

val vcimm cons cond dt q d vd imm = do
  cond <- cond;
  dt <- dt;
  q <- q;
  d <- d;
  vd <- vd;
  imm <- imm;
  return (cons {cond=cond, dt=dt, q=q, d=d, vd=vd, imm=imm})
end

val vcbit4imm cons cond op sz2 u sz1 qd d vd qm m vm imm = do
  cond <- cond;
  op <- op;
  sz2 <- sz2;
  u <- u;
  sz1 <- sz1;
  qd <- qd;
  d <- d;
  vd <- vd;
  qm <- qm;
  m <- m;
  vm <- vm;
  imm <- imm;
  return (cons {cond=cond, op=op, sz2=sz2, u=u, sz1=sz1, qd=qd, d=d, vd=vd, qm=qm, m=m, vm=vm, imm=imm})
end

val vcns cons cond q d vd op2 = do
  cond <- cond;
  q <- q;
  d <- d;
  vd <- vd;
  op2 <- op2;
  return (cons {cond=cond, q=q, d=d, vd=vd, op2=op2})
end

val vcrevns cons cond op q n vn = do
  cond <- cond;
  op <- op;
  q <- q;
  n <- n;
  vn <- vn;
  return (cons {cond=cond, op=op, q=q, n=n, vn=vn})
end

val vcns2 cons cond q d vd q2 d2 vd2 op3 op4 = do
  cond <- cond;
  q <- q;
  d <- d;
  vd <- vd;
  q2 <- q2;
  d2 <- d2;
  vd2 <- vd2;
  op3 <- op3;
  op4 <- op4;
  return (cons {cond=cond, q=q, d=d, vd=vd, q2=q2, d2=d2, vd2=vd2, op3=op3, op4=op4})
end

val vcrevns2 cons cond op op2 q3 d3 vd3 q4 d4 vd4 = do
  cond <- cond;
  op <- op;
  op2 <- op2;
  q3 <- q3;
  d3 <- d3;
  vd3 <- vd3;
  q4 <- q4;
  d4 <- d4;
  vd4 <- vd4;
  return (cons {cond=cond, op=op, op2=op2, q3=q3, d3=d3, vd3=vd3, q4=q4, d4=d4, vd4=vd4})
end

val vcns2half cons cond q d vd op2 op3 = do
  cond <- cond;
  q <- q;
  d <- d;
  vd <- vd;
  op2 <- op2;
  op3 <- op3;
  return (cons {cond=cond, q=q, d=d, vd=vd, op2=op2, op3=op3})
end

val vcrevns2half cons cond op op2 q3 d3 vd3 = do
  cond <- cond;
  op <- op;
  op2 <- op2;
  q3 <- q3;
  d3 <- d3;
  vd3 <- vd3;
  return (cons {cond=cond, op=op, op2=op2, q3=q3, d3=d3, vd3=vd3})
end

val vc2 cons cond size qd d vd qm m vm = do
  cond <- cond;
  size <- size;
  qd <- qd;
  d <- d;
  vd <- vd;
  qm <- qm;
  m <- m;
  vm <- vm;
  return (cons {cond=cond, size=size, qd=qd, d=d, vd=vd, qm=qm, m=m, vm=vm})
end

val vc2imm cons cond size qd d vd qm m vm imm = do
  cond <- cond;
  size <- size;
  qd <- qd;
  d <- d;
  vd <- vd;
  qm <- qm;
  m <- m;
  vm <- vm;
  imm <- imm;
  return (cons {cond=cond, size=size, qd=qd, d=d, vd=vd, qm=qm, m=m, vm=vm, imm=imm})
end

val vc2bit cons cond sz qd d vd qm m vm = do
  cond <- cond;
  sz <- sz;
  qd <- qd;
  d <- d;
  vd <- vd;
  qm <- qm;
  m <- m;
  vm <- vm;
  return (cons {cond=cond, sz=sz, qd=qd, d=d, vd=vd, qm=qm, m=m, vm=vm})
end

val vc2bit2 cons cond sz1 sz2 qd d vd qm m vm = do
  cond <- cond;
  sz1 <- sz1;
  sz2 <- sz2;
  qd <- qd;
  d <- d;
  vd <- vd;
  qm <- qm;
  m <- m;
  vm <- vm;
  return (cons {cond=cond, sz1=sz1, sz2=sz2, qd=qd, d=d, vd=vd, qm=qm, m=m, vm=vm})
end

val vc2opbit cons cond op sz qd d vd qm m vm = do
  cond <- cond;
  op <- op;
  sz <- sz;
  qd <- qd;
  d <- d;
  vd <- vd;
  qm <- qm;
  m <- m;
  vm <- vm;
  return (cons {cond=cond, op=op, sz=sz, qd=qd, d=d, vd=vd, qm=qm, m=m, vm=vm})
end

val vc2sig cons cond u size qd d vd qm m vm = do
  cond <- cond;
  u <- u;
  size <- size;
  qd <- qd;
  d <- d;
  vd <- vd;
  qm <- qm;
  m <- m;
  vm <- vm;
  return (cons {cond=cond, u=u, size=size, qd=qd, d=d, vd=vd, qm=qm, m=m, vm=vm})
end

val vc2sigimm cons cond u size qd d vd qm m vm imm = do
  cond <- cond;
  u <- u;
  size <- size;
  qd <- qd;
  d <- d;
  vd <- vd;
  qm <- qm;
  m <- m;
  vm <- vm;
  imm <- imm;
  return (cons {cond=cond, u=u, size=size, qd=qd, d=d, vd=vd, qm=qm, m=m, vm=vm, imm=imm})
end

val vc2sigbitimm cons cond u op qd d vd qm m vm imm = do
  cond <- cond;
  u <- u;
  op <- op;
  qd <- qd;
  d <- d;
  vd <- vd;
  qm <- qm;
  m <- m;
  vm <- vm;
  imm <- imm;
  return (cons {cond=cond, u=u, op=op, qd=qd, d=d, vd=vd, qm=qm, m=m, vm=vm, imm=imm})
end

val vc2ns cons cond qd d vd qm m vm = do
  cond <- cond;
  qd <- qd;
  d <- d;
  vd <- vd;
  qm <- qm;
  m <- m;
  vm <- vm;
  return (cons {cond=cond, qd=qd, d=d, vd=vd, qm=qm, m=m, vm=vm})
end

val vc3 cons cond size qd d vd qn n vn qm m vm = do
  cond <- cond;
  size <- size;
  qd <- qd;
  d <- d;
  vd <- vd;
  qn <- qn;
  n <- n;
  vn <- vn;
  qm <- qm;
  m <- m;
  vm <- vm;
  return (cons {cond=cond, size=size, qd=qd, d=d, vd=vd, qn=qn, n=n, vn=vn, qm=qm, m=m, vm=vm})
end

val vc3bit cons cond sz qd d vd qn n vn qm m vm = do
  cond <- cond;
  sz <- sz;
  qd <- qd;
  d <- d;
  vd <- vd;
  qn <- qn;
  n <- n;
  vn <- vn;
  qm <- qm;
  m <- m;
  vm <- vm;
  return (cons {cond=cond, sz=sz, qd=qd, d=d, vd=vd, qn=qn, n=n, vn=vn, qm=qm, m=m, vm=vm})
end

val vc3sig cons cond u size qd d vd qn n vn qm m vm = do
  cond <- cond;
  u <- u;
  size <- size;
  qd <- qd;
  d <- d;
  vd <- vd;
  qn <- qn;
  n <- n;
  vn <- vn;
  qm <- qm;
  m <- m;
  vm <- vm;
  return (cons {cond=cond, u=u, size=size, qd=qd, d=d, vd=vd, qn=qn, n=n, vn=vn, qm=qm, m=m, vm=vm})
end

val vc3sig2 cons cond op u size qd d vd qn n vn qm m vm = do
  cond <- cond;
  op <- op;
  u <- u;
  size <- size;
  qd <- qd;
  d <- d;
  vd <- vd;
  qn <- qn;
  n <- n;
  vn <- vn;
  qm <- qm;
  m <- m;
  vm <- vm;
  return (cons {cond=cond, op=op, u=u, size=size, qd=qd, d=d, vd=vd, qn=qn, n=n, vn=vn, qm=qm, m=m, vm=vm})
end

val vc3ns cons cond qd d vd qn n vn qm m vm = do
  cond <- cond;
  qd <- qd;
  d <- d;
  vd <- vd;
  qn <- qn;
  n <- n;
  vn <- vn;
  qm <- qm;
  m <- m;
  vm <- vm;
  return (cons {cond=cond, qd=qd, d=d, vd=vd, qn=qn, n=n, vn=vn, qm=qm, m=m, vm=vm})
end


val vc3nslist cons cond qd d vd len qn n vn qm m vm = do
  cond <- cond;
  qd <- qd;
  d <- d;
  vd <- vd;
  len <- len;
  qn <- qn;
  n <- n;
  vn <- vn;
  qm <- qm;
  m <- m;
  vm <- vm;
  return (cons {cond=cond, qd=qd, d=d, vd=vd, len=len, qn=qn, n=n, vn=vn, qm=qm, m=m, vm=vm})
end

val vc3nsimm cons cond qd d vd qn n vn qm m vm imm = do
  cond <- cond;
  qd <- qd;
  d <- d;
  vd <- vd;
  qn <- qn;
  n <- n;
  vn <- vn;
  qm <- qm;
  m <- m;
  vm <- vm;
  imm <- imm;
  return (cons {cond=cond, qd=qd, d=d, vd=vd, qn=qn, n=n, vn=vn, qm=qm, m=m, vm=vm, imm=imm})
end

val nullop cons cond = do
  cond <- cond;
  return (cons {cond=cond})
end

val unop cons cond opnd = do
  cond <- cond;
  opnd <- opnd;
  return (cons {cond=cond, opnd=opnd})
end

val unopbit cons cond o = do
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

val register cons = REGISTER cons
val immediate cons = IMMEDIATE cons
val shiftedoperand cons = SHIFTED_OPERAND cons
val operandlist cons = OPERAND_LIST cons

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

# cmode for VMOV instruction with op=01, can only be 1110
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

val /imm6-not000 ['imm6@001...'] = update@{imm6=imm6}
val /imm6-not000 ['imm6@01....'] = update@{imm6=imm6}
val /imm6-not000 ['imm6@1.....'] = update@{imm6=imm6}

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
  return (immediate (IMM12 (imm12)))
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

val imm3 = do
  imm3 <- query $imm3;
  return (immediate (IMM3 (imm3)))
end

val /imm4 ['imm4:4'] = update@{imm4=imm4}

val imm4 = do
  imm4 <- query $imm4;
  return (immediate (IMM4 (imm4)))
end

val /imm5 ['imm5:5'] = update@{imm5=imm5}

val imm5 = do
  imm5 <- query $imm5;
  return (immediate (IMM5 (imm5)))
end

val /imm8 ['imm8:8'] = update@{imm8=imm8}

val imm8 = do
  imm8 <- query $imm8;
  return (immediate (IMM8 (imm8)))
end

# concats the 4 bit and 12 bit immediates that were decoded most recently
val combine-imm16 = do
  imm4 <- query $imm4;
  imm12 <- query $imm12;
  return (opnd-from-int (zx (imm4^imm12)))
end

# concats the 12 bit and 4 bit immediates that were decoded most recently
val combine-imm16-rev = do
  imm12 <- query $imm12;
  imm4 <- query $imm4;
  return (opnd-from-int (zx (imm12^imm4)))
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
  return (opnd-from-int (zx (imm4^i)))
end

val combine-imm8-2 = do
  i <- query $i;
  imm3 <- query $imm3;
  imm4 <- query $imm4;
  return (opnd-from-int (zx (imm4^i)))
end

# length
val /len ['len:2'] = update@{len=len}

val len = do
  len <- query $len;
  return (immediate (IMM2 (len)))
end

# align
val /aligna ['aligna:2'] = update@{aligna=aligna}

val aligna = do
  aligna <- query $aligna;
  return (immediate (IMM2 (aligna)))
end

# opc12
val /opc12 ['opc12:2'] = update@{opc12=opc12}

val opc12 = do
  opc12 <- query $opc12;
  return (immediate (IMM2 (opc12)))
end

# opc22
val /opc22 ['opc22:2'] = update@{opc22=opc22}

val opc22 = do
  opc22 <- query $opc22;
  return (immediate (IMM2 (opc22)))
end

# combine-opc2
val combine-opc2 = do
  opc12 <- query $opc12;
  opc22 <- query $opc22;
  return (opnd-from-int (zx (opc12^opc22)))
end

# combine-u-opc2
val combine-u-opc2 = do
  u <- query $u;
  opc12 <- query $opc12;
  opc22 <- query $opc22;
  return (opnd-from-int (zx (u^opc12^opc22)))
end

# opc13
val /opc13 ['opc13:3'] = update@{opc13=opc13}

val opc13 = do
  opc13 <- query $opc13;
  return (immediate (IMM3 (opc13)))
end

# opc23
val /opc23 ['opc23:3'] = update@{opc23=opc23}

val opc23 = do
  opc23 <- query $opc23;
  return (immediate (IMM3 (opc23)))
end

# opc14
val /opc14 ['opc14:4'] = update@{opc14=opc14}

val opc14 = do
  opc14 <- query $opc14;
  return (immediate (IMM4 (opc14)))
end

# opc24
val /opc24 ['opc24:4'] = update@{opc24=opc24}

val opc24 = do
  opc24 <- query $opc24;
  return (immediate (IMM4 (opc24)))
end

# crd
val /crd ['crd:4'] = update@{crd=crd}

val crd = do
  crd <- query $crd;
  return (immediate (IMM4 (crd)))
end

# crn
val /crn ['crn:4'] = update@{crn=crn}

val crn = do
  crn <- query $crn;
  return (immediate (IMM4 (crn)))
end

# crm
val /crm ['crm:4'] = update@{crm=crm}

val crm = do
  crm <- query $crm;
  return (immediate (IMM4 (crm)))
end

# coproc
val /coproc ['coproc:4'] = update@{coproc=coproc}

val coproc = do
  coproc <- query $coproc;
  return (immediate (IMM4 (coproc)))
end

# vd
val /vd ['vd:4'] = update@{vd=vd}

val vd = do
  vd <- query $vd;
  return (immediate (IMM4 (vd)))
end

# vn
val /vn ['vn:4'] = update@{vn=vn}

val vn = do
  vn <- query $vn;
  return (immediate (IMM4 (vn)))
end

# vm
val /vm ['vm:4'] = update@{vm=vm}

val vm = do
  vm <- query $vm;
  return (immediate (IMM4 (vm)))
end

# index_align
val /index_align ['index_align:4'] = update@{index_align=index_align}

val index_align = do
  index_align <- query $index_align;
  return (immediate (IMM4 (index_align)))
end

# most significant bit
val /msbit ['msbit:5'] = update@{msbit=msbit}

val msbit = do
  msbit <- query $msbit;
  return (immediate (IMM5 (msbit)))
end

# least significant bit
val /lsbit ['lsbit:5'] = update@{lsbit=lsbit}

val lsbit = do
  lsbit <- query $lsbit;
  return (immediate (IMM5 (lsbit)))
end

# imm5 representing width
val /widthm1 ['widthm1:5'] = update@{widthm1=widthm1}

val widthm1 = do
  widthm1 <- query $widthm1;
  return (immediate (IMM5 (widthm1)))
end

# --- shifted operand decoders -----------------------------------------

val /shfreg ['/immshift /rm'] = (return 0)
val /shfreg ['/immshiftshtp /rm'] = (return 0)
val /shfreg ['/regshift /rm'] = (return 0)
val /rotreg ['/immrotate /rm'] = (return 0)

# operand subdecoder: register + immediate shift
val /immshift ['imm5:5 stype:2 0'] = do
  imm <- return (immediate (IMM5 imm5));
  update@{shift={amount=imm, shifttype=(decode-shifttype stype)}}
end

val /immshiftshtp ['imm5:5 shtp:1 01'] = do
  imm <- return (immediate (IMM5 imm5));
  update@{shift={amount=imm, shifttype=(decode-shifttype (shtp^'0'))}}
end

# operand subdecoder: register + register controlled shift
val /regshift ['rs:4 0 stype:2 1'] = do
  reg <- return (register (decode-register rs));
  update@{shift={amount=reg, shifttype=(decode-shifttype stype)}}
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
val / ['/cond 001 0 1 0 1 /S /rn /rd /modimm'] = dp ADC cond s rn rd modimm
###  - Add with Carry (shifted register)
val / ['/cond 000 0 1 0 1 /S /rn /rd /shfreg'] = dp ADC cond s rn rd shfreg

### ADD
###  - Add (immediate)
val / ['/cond 001 0 1 0 0 /S /rn /rd /modimm'] = dp ADD cond s rn rd modimm
###  - Add (shifted register)
val / ['/cond 000 0 1 0 0 /S /rn /rd /shfreg'] = dp ADD cond s rn rd shfreg

### ADR
###  - ADR (Encoding A1)
val / ['/cond 001 0 1 0 0 0 1111 /rd /modimm'] = dp ADR cond set0 r15 rd modimm
###  - ADR (Encoding A2)
val / ['/cond 001 0 0 1 0 0 1111 /rd /modimm'] = dp ADR cond set0 r15 rd modimm

### AND
###  - And (immediate)
val / ['/cond 001 0 0 0 0 /S /rn /rd /modimm'] = dp AND cond s rn rd modimm
###  - And (shifted register)
val / ['/cond 000 0 0 0 0 /S /rn /rd /shfreg'] = dp AND cond s rn rd shfreg

### BIC
###  - Bitwise Bit Clear (immediate)
val / ['/cond 001 1 1 1 0 /S /rn /rd /modimm'] = dp BIC cond s rn rd modimm
###  - Bitwise Bit Clear (shifted register)
val / ['/cond 000 1 1 1 0 /S /rn /rd /shfreg'] = dp BIC cond s rn rd shfreg

### CMN
###  - Compare Negative (immediate)
val / ['/cond 001 1 0 1 1 1 /rn 0000 /modimm'] = dp CMN cond set1 rn r0 modimm
###  - Compare Negative (shifted register)
val / ['/cond 000 1 0 1 1 1 /rn 0000 /shfreg'] = dp CMN cond s rn r0 shfreg

### CMP
###  - Compare (immediate)
val / ['/cond 001 1 0 1 0 1 /rn 0000 /modimm'] = dp CMP cond set1 rn r0 modimm
###  - Compare (shifted register)
val / ['/cond 000 1 0 1 0 1 /rn 0000 /shfreg'] = dp CMP cond set1 rn r0 shfreg

### EOR
###  - Bitwise Exclusive OR (immediate)
val / ['/cond 001 0 0 0 1 /S /rn /rd /modimm'] = dp EOR cond s rn rd modimm
###  - Bitwise Exclusive OR (shifted register)
val / ['/cond 000 0 0 0 1 /S /rn /rd /shfreg'] = dp EOR cond s rn rd shfreg

### MOV
###  - Move (immediate) (Encoding A1)
val / ['/cond 001 1 1 0 1 /S 0000 /rd /modimm'] = dp MOV cond s r0 rd modimm
###  - Move (immediate) (Encoding A2)
val / ['/cond 001 1 0 0 0 0 /imm4 /rd /imm12'] = dp MOV cond set0 r0 rd combine-imm16
###  - Move (shifted register)
val / ['/cond 000 1 1 0 1 /S 0000 /rd /shfreg'] = dp MOV cond s r0 rd shfreg

### MVN
###  - Bitwise NOT (immediate)
val / ['/cond 001 1 1 1 1 /S 0000 /rd /modimm'] = dp MVN cond s r0 rd modimm
###  - Bitwise NOT (shifted register)
val / ['/cond 000 1 1 1 1 /S 0000 /rd /shfreg'] = dp MVN cond s r0 rd shfreg

### ORR
###  - Bitwise OR (immediate)
val / ['/cond 001 1 1 0 0 /S /rn /rd /modimm'] = dp ORR cond s rn rd modimm
###  - Bitwise OR (shifted register)
val / ['/cond 000 1 1 0 0 /S /rn /rd /shfreg'] = dp ORR cond s rn rd shfreg

### RSB
###  - Reverse Subtract (immediate)
val / ['/cond 001 0 0 1 1 /S /rn /rd /modimm'] = dp RSB cond s rn rd modimm
###  - Reverse Subtract (shifted-register)
val / ['/cond 000 0 0 1 1 /S /rn /rd /shfreg'] = dp RSB cond s rn rd shfreg

### RSC
###  - Reverse Subtract with Carry (immediate)
val / ['/cond 001 0 1 1 1 /S /rn /rd /modimm'] = dp RSC cond s rn rd modimm
###  - Reverse Subtract with Carry (shifted register)
val / ['/cond 000 0 1 1 1 /S /rn /rd /shfreg'] = dp RSC cond s rn rd shfreg

### SBC
###  - Subtract with Carry (immediate)
val / ['/cond 001 0 1 1 0 /S /rn /rd /modimm'] = dp SBC cond s rn rd modimm
###  - Subtract with Carry (shifted register)
val / ['/cond 000 0 1 1 0 /S /rn /rd /shfreg'] = dp SBC cond s rn rd shfreg

### SUB
###  - Subtract (immediate)
val / ['/cond 001 0 0 1 0 /S /rn /rd /modimm'] = dp SUB cond s rn rd modimm
###  - Subtract (shifted register)
val / ['/cond 000 0 0 1 0 /S /rn /rd /shfreg'] = dp SUB cond s rn rd shfreg

### TEQ
###  - Test Equivalence (immediate)
val / ['/cond 001 1 0 0 1 1 /rn 0000 /modimm'] = dp TEQ cond set1 rn r0 modimm
###  - Test Equivalence (shifted register)
val / ['/cond 000 1 0 0 1 1 /rn 0000 /shfreg'] = dp TEQ cond set1 rn r0 shfreg

### TST
###  - Test (immediate)
val / ['/cond 001 1 0 0 0 1 /rn 0000 /modimm'] = dp TST cond set1 rn r0 modimm
###  - Test (shifted register)
val / ['/cond 000 1 0 0 0 1 /rn 0000 /shfreg'] = dp TST cond s rn r0 shfreg

# --- Shift instructions -----------------------------------------------

(* NOTE: These instructions are implemented by MOV (shifted register) *)

# --- Multiply instructions --------------------------------------------

### MLA
###  - Multiply Accumulate
val / ['/cond 000 0 0 0 1 /S /rd /ra /rm 1001 /rn'] = ml MLA cond s rd ra rm rn

### MLS
###  - Multiply and Subtract
val / ['/cond 000 0 0 1 1 0 /rd /ra /rm 1001 /rn'] = ml MLS cond set0 rd ra rm rn

### MUL
###  - Multiply
val / ['/cond 000 0 0 0 0 /S /rd 0000 /rm 1001 /rn'] = ml MUL cond s rd r0 rm rn

### SMLABB
###  - Signed Multiply Accumulate Bottom Bottom
val / ['/cond 000 1 0 0 0 0 /rd /ra /rm 1000 /rn'] = ml SMLABB cond set0 rd ra rm rn

### SMLABT
###  - Signed Multiply Accumulate Bottom Top
val / ['/cond 000 1 0 0 0 0 /rd /ra /rm 1100 /rn'] = ml SMLABT cond set0 rd ra rm rn

### SMLATB
###  - Signed Multiply Accumulate Top Bottom
val / ['/cond 000 1 0 0 0 0 /rd /ra /rm 1010 /rn'] = ml SMLATB cond set0 rd ra rm rn

### SMLATT
###  - Signed Multiply Accumulate Top Top
val / ['/cond 000 1 0 0 0 0 /rd /ra /rm 1110 /rn'] = ml SMLATT cond set0 rd ra rm rn

### SMLAD
###  - Signed Multiply Accumulate Dual
val / ['/cond 011 1 0 0 0 0 /rd /ra /rm 0001 /rn'] = ml SMLAD cond set0 rd ra rm rn

### SMLADX
###  - Signed Multiply Accumulate Dual Exchange
val / ['/cond 011 1 0 0 0 0 /rd /ra /rm 0011 /rn'] = ml SMLAD cond set0 rd ra rm rn

### SMLAL
###  - Signed Multiply Accumulate Long
val / ['/cond 000 0 1 1 1 /S /rdhi /rdlo /rm 1001 /rn'] = mull SMLAL cond s rdhi rdlo rm rn

### SMLALBB
###  - signed Multiply Accumulate Long Bottom Bottom
val / ['/cond 000 1 0 1 0 0 /rdhi /rdlo /rm 1000 /rn'] = mull SMLALBB cond set0 rdhi rdlo rm rn

### SMLALBT
###  - signed Multiply Accumulate Long Bottom Top
val / ['/cond 000 1 0 1 0 0 /rdhi /rdlo /rm 1100 /rn'] = mull SMLALBT cond set0 rdhi rdlo rm rn

### SMLALTB
###  - signed Multiply Accumulate Long Top Bottom
val / ['/cond 000 1 0 1 0 0 /rdhi /rdlo /rm 1010 /rn'] = mull SMLALTB cond set0 rdhi rdlo rm rn

### SMLALTT
###  - signed Multiply Accumulate Long Top Top
val / ['/cond 000 1 0 1 0 0 /rdhi /rdlo /rm 1110 /rn'] = mull SMLALTT cond set0 rdhi rdlo rm rn

### SMLALD
###  - Signed Multiply Accumulate Long Dual
val / ['/cond 011 1 0 1 0 0 /rdhi /rdlo /rm 0001 /rn'] = mull SMLALD cond set0 rdhi rdlo rm rn

### SMLALDX
###  - Signed Multiply Accumulate Long Dual Exchange
val / ['/cond 011 1 0 1 0 0 /rdhi /rdlo /rm 0011 /rn'] = mull SMLALDX cond set0 rdhi rdlo rm rn

### SMLAWB
###  - Signed Multiply Accumulate Word Bottom
val / ['/cond 000 1 0 0 1 0 /rd /ra /rm 1000 /rn'] = ml SMLAWB cond set0 rd ra rm rn

### SMLAWT
###  - Signed Multiply Accumulate Word Top
val / ['/cond 000 1 0 0 1 0 /rd /ra /rm 1100 /rn'] = ml SMLAWT cond set0 rd ra rm rn

### SMLSD
###  - Signed Multiply Subtract Dual
val / ['/cond 011 1 0 0 0 0 /rd /ra /rm 0101 /rn'] = ml SMLSD cond set0 rd ra rm rn

### SMLSDX
###  - Signed Multiply Subtract Dual Exchange
val / ['/cond 011 1 0 0 0 0 /rd /ra /rm 0111 /rn'] = ml SMLSDX cond set0 rd ra rm rn

### SMLSLD
###  - Signed Multiply Subtract Long Dual
val / ['/cond 011 1 0 1 0 0 /rdhi /rdlo /rm 0101 /rn'] = mull SMLSLD cond set0 rdhi rdlo rm rn

### SMLSLDX
###  - Signed Multiply Subtract Long Dual Exchange
val / ['/cond 011 1 0 1 0 0 /rdhi /rdlo /rm 0111 /rn'] = mull SMLSLDX cond set0 rdhi rdlo rm rn

### SMMLA
###  - Signed Most Significant Word Multiply Accumulate
val / ['/cond 011 1 0 1 0 1 /rd /ra /rm 0001 /rn'] = ml SMMLA cond set1 rd ra rm rn

### SMMLAR
###  - Signed Most Significant Word Multiply Accumulate Round
val / ['/cond 011 1 0 1 0 1 /rd /ra /rm 0011 /rn'] = ml SMMLAR cond set1 rd ra rm rn

### SMMLS
###  - Signed Most Significant Word Multiply Subtract
val / ['/cond 011 1 0 1 0 1 /rd /ra /rm 1101 /rn'] = ml SMMLS cond set1 rd ra rm rn

### SMMLSR
###  - Signed Most Significant Word Multiply Subtract Round
val / ['/cond 011 1 0 1 0 1 /rd /ra /rm 1111 /rn'] = ml SMMLSR cond set1 rd ra rm rn

### SMMUL
###  - Signed Most Significant Word Multiply
val / ['/cond 011 1 0 1 0 1 /rd 1111 /rm 0001 /rn'] = ml SMMUL cond set1 rd r15 rm rn

### SMMULR
###  - Signed Most Significant Word Multiply Round
val / ['/cond 011 1 0 1 0 1 /rd 1111 /rm 0011 /rn'] = ml SMMULR cond set1 rd r15 rm rn

### SMUAD
###  - Signed Dual Multiply Add
val / ['/cond 011 1 0 0 0 0 /rd 1111 /rm 0001 /rn'] = ml SMUAD cond set0 rd r15 rm rn

### SMUADX
###  - Signed Dual Multiply Add
val / ['/cond 011 1 0 0 0 0 /rd 1111 /rm 0011 /rn'] = ml SMUADX cond set0 rd r15 rm rn

### SMULBB
###  - Signed Multiply Bottom Bottom
val / ['/cond 000 1 0 1 1 0 /rd 0000 /rm 1000 /rn'] = ml SMULBB cond set0 rd r0 rm rn

### SMULBT
###  - Signed Multiply Bottom Top
val / ['/cond 000 1 0 1 1 0 /rd 0000 /rm 1100 /rn'] = ml SMULBT cond set0 rd r0 rm rn

### SMULTB
###  - Signed Multiply Top Bottom
val / ['/cond 000 1 0 1 1 0 /rd 0000 /rm 1010 /rn'] = ml SMULTB cond set0 rd r0 rm rn

### SMULTT
###  - Signed Multiply Top Top
val / ['/cond 000 1 0 1 1 0 /rd 0000 /rm 1110 /rn'] = ml SMULTT cond set0 rd r0 rm rn

### SMULL
###  - Signed Multiply Long
val / ['/cond 000 0 1 1 0 /S /rdhi /rdlo /rm 1001 /rn'] = mull SMULL cond s rdhi rdlo rm rn

### SMULWB
###  - Signed Multiply Word Bottom
val / ['/cond 000 1 0 0 1 0 /rd 0000 /rm 1010 /rn'] = ml SMULWB cond set0 rd r0 rm rn

### SMULWT
###  - Signed Multiply Word Top
val / ['/cond 000 1 0 0 1 0 /rd 0000 /rm 1110 /rn'] = ml SMULWT cond set0 rd r0 rm rn

### SMUSD
###  - Signed Multiply Subtract Dual
val / ['/cond 011 1 0 0 0 0 /rd 1111 /rm 0101 /rn'] = ml SMUSD cond set0 rd r0 rm rn

### SMUSDX
###  - Signed Multiply Subtract Dual Exchange
val / ['/cond 011 1 0 0 0 0 /rd 1111 /rm 0111 /rn'] = ml SMUSDX cond set0 rd r0 rm rn

### UMAAL
###  - Unsigned Multiply Accumulate Accumulate Long
val / ['/cond 000 0 0 1 0 0 /rdhi /rdlo /rm 1001 /rn'] = mull UMAAL cond set0 rdhi rdlo rm rn

### UMLAL
###  - Unsigned Multiply Accumulate Long
val / ['/cond 000 0 1 0 1 /S /rdhi /rdlo /rm 1001 /rn'] = mull UMLAL cond s rdhi rdlo rm rn

### UMULL
###  - Unsigned Multiply Long
val / ['/cond 000 0 1 0 0 /S /rdhi /rdlo /rm 1001 /rn'] = mull UMULL cond s rdhi rdlo rm rn

# --- Saturating instructions ------------------------------------------

### SSAT
###  - Signed Saturate (* TODO: Maybe replace imm5 with correct #<imm5> representation. *)
val / ['/cond 011 0 1 0 1 /imm5 /rd /shfreg'] = sat SSAT cond imm5 rd shfreg

### SSAT16
###  - Signed Saturate 16 (* TODO: Maybe replace imm4 with correct #<imm4> representation. *)
val / ['/cond 011 0 1 0 1 0 /imm4 /rd 1111 0011 /rn'] = sat SSAT16 cond imm4 rd rn

### USAT
### - Unsigned Saturate
val / ['/cond 011 0 1 1 1 /imm5 /rd /shfreg'] = sat USAT cond imm5 rd shfreg

### USAT16
### - Unsigned Saturate 16
val / ['/cond 011 0 1 1 1 0 /imm4 /rd 1111 0011 /rn'] = sat USAT16 cond imm4 rd rn

# --- Saturating addition and Subtraction instructions ----------------

### QADD
###  - Saturating Add
val / ['/cond 000 1 0 0 0 0 /rn /rd 0000 0101 /rm'] = satop QADD cond rn rd rm

### QSUB
###  - Saturating Subtract
val / ['/cond 000 1 0 0 1 0 /rn /rd 0000 0101 /rm'] = satop QSUB cond rn rd rm

### QDADD
###  - Saturating Double and Add
val / ['/cond 000 1 0 1 0 0 /rn /rd 0000 0101 /rm'] = satop QDADD cond rn rd rm

### QDSUB
###  - Saturating Double and Subtract
val / ['/cond 000 1 0 1 1 0 /rn /rd 0000 0101 /rm'] = satop QDSUB cond rn rd rm

# --- Packing and unpacking instructions -------------------------------

### PKH (*Todo: Update immshiftsthtb to support case differentiation.*)
###  - Pack Halfword
val / ['/cond 011 0 1 0 0 0 /rn /rd /shfreg'] = pup PKH cond rn rd shfreg

### SXTAB
###  - Signed Extend and Add Byte
val / ['/cond 011 0 1 0 1 0 /rn /rd /rotreg'] = pup SXTAB cond rn rd rotreg

### SXTAB16
###  - Signed Extend and Add Byte 16
val / ['/cond 011 0 1 0 0 0 /rn /rd /rotreg'] = pup SXTAB16 cond rn rd rotreg

### SXTAH
###  - Signed Extend and Add Halfword
val / ['/cond 011 0 1 0 1 1 /rn /rd /rotreg'] = pup SXTAH cond rn rd rotreg

### SXTB
###  - Signed Extend Byte
val / ['/cond 011 0 1 0 1 0 1111 /rd /rotreg'] = pup SXTB cond r15 rd rotreg

### SXTB16
###  - Signed Extend Byte 16
val / ['/cond 011 0 1 0 0 0 1111 /rd /rotreg'] = pup SXTB16 cond r15 rd rotreg

### SXTH
###  - Signed Extend Halfword
val / ['/cond 011 0 1 0 1 1 1111 /rd /rotreg'] = pup SXTH cond r15 rd rotreg

### UXTAB
###  - Unsigned Extend and Add Byte
val / ['/cond 011 0 1 1 1 0 /rn /rd /rotreg'] = pup UXTAB cond rn rd rotreg

### UXTAB16
###  - Unsigned Extend and Add Byte 16
val / ['/cond 011 0 1 1 0 0 /rn /rd /rotreg'] = pup UXTAB16 cond rn rd rotreg

### UXTAH
###  - Unsigned Extend and Add Halfword
val / ['/cond 011 0 1 1 1 1 /rn /rd /rotreg'] = pup UXTAH cond rn rd rotreg

### UXTB
###  - Unsigned Extend Byte
val / ['/cond 011 0 1 1 1 0 1111 /rd /rotreg'] = pup UXTB cond r15 rd rotreg

### UXTB16
###  - Unsigned Extend Byte 16
val / ['/cond 011 0 1 1 0 0 1111 /rd /rotreg'] = pup UXTB16 cond r15 rd rotreg  

### UXTH
###  - Unsigned Extend Halfword
val / ['/cond 011 0 1 1 1 1 1111 /rd /rotreg'] = pup UXTH cond r15 rd rotreg

# --- Parallel addition and Subtraction instructions ------------------

### SADD16
###  - Signed Add 16
val / ['/cond 011 0 0 0 0 1 /rn /rd 1111 0001 /rm'] = pas SADD16 cond rn rd rm

### SASX
###  - Signed Add and Subtract with Extend
val / ['/cond 011 0 0 0 0 1 /rn /rd 1111 0011 /rm'] = pas SASX cond rn rd rm

### SSAX
###  - Signed Subtract and Add with Exchange
val / ['/cond 011 0 0 0 0 1 /rn /rd 1111 0101 /rm'] = pas SSAX cond rn rd rm

### SSUB16
###  - Signed Subtract 16
val / ['/cond 011 0 0 0 0 1 /rn /rd 1111 0111 /rm'] = pas SSUB16 cond rn rd rm

### SADD8
###  - Signed Add 8
val / ['/cond 011 0 0 0 0 1 /rn /rd 1111 1001 /rm'] = pas SADD8 cond rn rd rm

### SSUB8
###  - Signed Subtract 8
val / ['/cond 011 0 0 0 0 1 /rn /rd 1111 1111 /rm'] = pas SSUB8 cond rn rd rm

### QADD16
###  - Saturating Add 16
val / ['/cond 011 0 0 0 1 0 /rn /rd 1111 0001 /rm'] = pas QADD16 cond rn rd rm

### QASX
###  - Saturating Add and Subtract with Exchange
val / ['/cond 011 0 0 0 1 0 /rn /rd 1111 0011 /rm'] = pas QASX cond rn rd rm

### QSAX
###  - Saturating Subtract and Add with Exchange
val / ['/cond 011 0 0 0 1 0 /rn /rd 1111 0101 /rm'] = pas QSAX cond rn rd rm

### QSUB16
###  - Saturating Subtract 16
val / ['/cond 011 0 0 0 1 0 /rn /rd 1111 0111 /rm'] = pas QSUB16 cond rn rd rm

### QADD8
###  - Saturating Add 8
val / ['/cond 011 0 0 0 1 0 /rn /rd 1111 1001 /rm'] = pas QADD8 cond rn rd rm

### QSUB8
###  - Saturating Subtract 8
val / ['/cond 011 0 0 0 1 0 /rn /rd 1111 1111 /rm'] = pas QSUB8 cond rn rd rm

### SHADD16
###  - Signed Halbing Add 16
val / ['/cond 011 0 0 0 1 1 /rn /rd 1111 0001 /rm'] = pas SHADD16 cond rn rd rm

### SHASX
###  - Signed Halving Add and Subtract with Exchange
val / ['/cond 011 0 0 0 1 1 /rn /rd 1111 0011 /rm'] = pas SHASX cond rn rd rm

### SHSAX
###  - Signed Halving Subtract and Add with Exchange
val / ['/cond 011 0 0 0 1 1 /rn /rd 1111 0101 /rm'] = pas SHSAX cond rn rd rm

### SHSUB16
###  - Signed Halving Subtract 16
val / ['/cond 011 0 0 0 1 1 /rn /rd 1111 0111 /rm'] = pas SHSUB16 cond rn rd rm

### SHADD8
###  - Signed Halving Add 8
val / ['/cond 011 0 0 0 1 1 /rn /rd 1111 1001 /rm'] = pas SHADD8 cond rn rd rm

### SHSUB8
###  - Signed Halving Subtract 8
val / ['/cond 011 0 0 0 1 1 /rn /rd 1111 1111 /rm'] = pas SHSUB8 cond rn rd rm

### UADD16
###  - Unsigned Add 16
val / ['/cond 011 0 0 1 0 1 /rn /rd 1111 0001 /rm'] = pas UADD16 cond rn rd rm

### UASX
###  - Unsigned Add and Subtract with Exchange
val / ['/cond 011 0 0 1 0 1 /rn /rd 1111 0011 /rm'] = pas UASX cond rn rd rm

### USAX
###  - Unsigned Subtract and Add with Exchange
val / ['/cond 011 0 0 1 0 1 /rn /rd 1111 0101 /rm'] = pas USAX cond rn rd rm

### USUB16
###  - Unsigned Subtract 16
val / ['/cond 011 0 0 1 0 1 /rn /rd 1111 0111 /rm'] = pas USUB16 cond rn rd rm

### UADD8
###  - Unsigned Add 8
val / ['/cond 011 0 0 1 0 1 /rn /rd 1111 1001 /rm'] = pas UADD8 cond rn rd rm

### USUB8
###  - Unsigned Subtract 8
val / ['/cond 011 0 0 1 0 1 /rn /rd 1111 1111 /rm'] = pas USUB8 cond rn rd rm

### UQADD16
###  - Unsigned Saturating Add 16
val / ['/cond 011 0 0 1 1 0 /rn /rd 1111 0001 /rm'] = pas UQADD16 cond rn rd rm

### UQASX
###  - Unsigned Saturating Add and Subtract with Exchange
val / ['/cond 011 0 0 1 1 0 /rn /rd 1111 0011 /rm'] = pas UQASX cond rn rd rm

### UQSAX
###  - Unsigned Saturating Subtract and Add with Exchange
val / ['/cond 011 0 0 1 1 0 /rn /rd 1111 0101 /rm'] = pas UQSAX cond rn rd rm 

### UQSUB16
###  - Unsigned Saturating Subtract 16
val / ['/cond 011 0 0 1 1 0 /rn /rd 1111 0111 /rm'] = pas UQSUB16 cond rn rd rm

### UQADD8
###  - Unsigned Saturating Add 8
val / ['/cond 011 0 0 1 1 0 /rn /rd 1111 1001 /rm'] = pas UQADD8 cond rn rd rm

### UQSUB8
###  - Unsigned Saturating Sub 8
val / ['/cond 011 0 0 1 1 0 /rn /rd 1111 1111 /rm'] = pas UQSUB8 cond rn rd rm

### UHADD16
###  - Unsigned Halving Add 16
val / ['/cond 011 0 0 1 1 1 /rn /rd 1111 0001 /rm'] = pas UHADD16 cond rn rd rm

### UHASX
###  - Unsigned Halving Add and Subtract with Exchange
val / ['/cond 011 0 0 1 1 1 /rn /rd 1111 0011 /rm'] = pas UHASX cond rn rd rm

### UHSAX
###  - Unsigned Halving Subtract and Add with Exchange
val / ['/cond 011 0 0 1 1 1 /rn /rd 1111 0101 /rm'] = pas UHSAX cond rn rd rm

### UHSUB16
###  - Unsigned Halving Subtract 16
val / ['/cond 011 0 0 1 1 1 /rn /rd 1111 0111 /rm'] = pas UHSUB16 cond rn rd rm

### UHADD8
###  - Unsigned Halving Add 8
val / ['/cond 011 0 0 1 1 1 /rn /rd 1111 1001 /rm'] = pas UHADD8 cond rn rd rm

### UHSUB8
###  - Unsigned Halving Subtract 8
val / ['/cond 011 0 0 1 1 1 /rn /rd 1111 1111 /rm'] = pas UHSUB8 cond rn rd rm

# --- Divide instructions ----------------------------------------------

### SDIV
###  - Signed Divide
val / ['/cond 011 1 0 0 0 1 /rd 1111 /rm 0001 /rn'] = divi SDIV cond rn rd rm

### UDIV
###  - Unsigned Divide
val / ['/cond 011 1 0 0 1 1 /rd 1111 /rm 0001 /rn'] = divi UDIV cond rn rd rm

# --- Miscellaneous data-processing instructions -----------------------

### BFC
###  - Bit Field Clear
val / ['/cond 011 1 1 1 0 /msbit /rd /lsbit 0 0 1 1111'] = bf BFC cond msbit rd lsbit r15

### BFI
###  - Bit Field Insert
val / ['/cond 011 1 1 1 0 /msbit /rd /lsbit 0 0 1 /rn'] = bf BFI cond msbit rd lsbit rn

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
val / ['/cond 011 1 1 0 1 /widthm1 /rd /lsbit 1 0 1 /rn'] = bf SBFX cond widthm1 rd lsbit rn

### SEL
###  - Select Bytes
val / ['/cond 011 0 1 0 0 0 /rn /rd 1111 1011 /rm'] = mdp SEL cond rn rd rm

### UBFX
###  - Unsigned Bit Field Extract
val / ['/cond 011 1 1 1 1 /widthm1 /rd /lsbit 1 0 1 /rn'] = bf UBFX cond widthm1 rd lsbit rn

### USAD8
###  - Unsigned Sum of Absolute Difference
val / ['/cond 011 1 1 0 0 0 /rd 1111 /rm 0001 /rn'] = madp USAD8 cond rn rd rm r15

### USADA8
###  - Unsigned Sum of Absolute Difference and Accumulate
val / ['/cond 011 1 1 0 0 0 /rd /ra /rm 0001 /rn'] = madp USADA8 cond rn rd rm ra

# --- Status register & banked register access instructions ------------

### MRS
###  - Move to Register form Banked or Special register
val / ['/cond 000 10 /r 00 /imm4 /rd 001 /M 0000 0000'] = brdr MRS cond r imm4 rd m

### MSR (immediate) //add later on
### MSR (banked register)
###  - Move to Banked or Special register from ARM core register
val / ['/cond 000 10 /r 10 /imm4 1111 001 /M 0000 /rn'] = brnr MSR cond r imm4 m rn

### CPS
###  - Change processor state
val / ['1111 000 1 0 0 0 0 imod:2 M:1 0 0000000 /IFLAGS 0 /imm5'] = binop CPS none iflags imm5

# --- Load/store instructions ------------------------------------------

val ldr_is_pop? s = (is-sp? s.rn) and (not s.p) and s.u and (not s.w) and (s.imm12 == '000000000100')
val unprivileged? s = (not s.p) and s.w

### LDR/LDRT/POP
val / ['/cond 010 /P /U 0 /W 1 /rn /rt /imm12']
###  - Pop Multiple Registers (Encoding A2)
  | ldr_is_pop? = lsm POP cond w rn (reglst-one rt)
###  - Load Register Unprivileged (Encoding A1)
  | unprivileged? = ls LDRT cond set0 u set0 rn rt imm12
###  - Load Register (immediate/literal)
  | otherwise = ls LDR cond p u w rn rt imm12
val / ['/cond 011 /P /U 0 /W 1 /rn /rt /immshift /rm']
###  - Load Register Unprivileged (Encoding A2)
  | unprivileged? = ls LDRT cond set0 u set0 rn rt shfreg
###  - Load Register (register)
  | otherwise = ls LDR cond p u w rn rt shfreg

### LDRB/LDRBT
val / ['/cond 010 /P /U 1 /W 1 /rn /rt /imm12']
###  - Load Register Byte Unprivileged (Encoding A1)
  | unprivileged? = ls LDRBT cond set0 u set0 rn rt imm12
###  - Load Register Byte (immediate/literal)
  | otherwise = ls LDRB cond p u w rn rt imm12
val / ['/cond 011 /P /U 1 /W 1 /rn /rt /immshift /rm']
###  - Load Register Byte Unprivileged (Encoding A2)
  | unprivileged? = ls LDRBT cond set0 u set0 rn rt shfreg
###  - Load Register Byte (register)
  | otherwise = ls LDRB cond p u w rn rt shfreg

### LDRD
val / ['/cond 000 /P /U 1 /W 0 /rn /rt /imm4H 1101 /imm4L'] =
###  - Load Register Dual (immediate/literal)
  ls LDRD cond p u w rn rt combine-imm8
###  - Load Register Dual (register)
val / ['/cond 000 /P /U 0 /W 0 /rn /rt 0000 1101 /rm'] =
  ls LDRD cond p u w rn rt rm

### LDRH/LDRHT
val / ['/cond 000 /P /U 1 /W 1 /rn /rt /imm4H 1011 /imm4L']
###  - Load Register Halfword Unprivileged (Encoding A1)
  | unprivileged? = ls LDRHT cond set0 u set0 rn rt combine-imm8
###  - Load Register Halfword (immediat/literal)
  | otherwise = ls LDRH cond p u w rn rt combine-imm8
val / ['/cond 000 /P /U 0 /W 1 /rn /rt 0000 1011 /rm']
###  - Load Register Halfword Unprivileged (Encoding A2)
  | unprivileged? = ls LDRHT cond set0 u set0 rn rt rm
###  - Load Register Halfword (register)
  | otherwise = ls LDRH cond p u w rn rt rm

### LDRSB/LDRSBT
val / ['/cond 000 /P /U 1 /W 1 /rn /rt /imm4H 1101 /imm4L']
###  - Load Register Signed Byte (Encoding A1)
  | unprivileged? = ls LDRSBT cond set0 u set0 rn rt combine-imm8
###  - Load Register Signed Byte (immediate/literal)
  | otherwise = ls LDRSB cond p u w rn rt combine-imm8
val / ['/cond 000 /P /U 0 /W 1 /rn /rt 0000 1101 /rm']
###  - Load Register Signed Byte (Encoding A2)
  | unprivileged? = ls LDRSBT cond set0 u set0 rn rt rm
###  - Load Register Signed Byte (register)
  | otherwise = ls LDRSB cond p u w rn rt rm

### LDRSH/LDRSHT
val / ['/cond 000 /P /U 1 /W 1 /rn /rt /imm4H 1111 /imm4L']
###  - Load Register Signed Halfword Unprivileged (Encoding A1)
  | unprivileged? = ls LDRSHT cond set0 u set0 rn rt combine-imm8
###  - Load Register Signed Halfword (immediate/literal)
  | otherwise = ls LDRSH cond p u w rn rt combine-imm8
val / ['/cond 000 /P /U 0 /W 1 /rn /rt 0000 1111 /rm']
###  - Load Register Signed Halfword Unprivileged (Encoding A2)
  | unprivileged? = ls LDRSHT cond set0 u set0 rn rt rm
###  - Load Register Signed Halfword (register)
  | otherwise = ls LDRSH cond p u w rn rt rm

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
  | unprivileged? = ls STRT cond set0 u set1 rn rt imm12
###  - Push Multiple Registers (Encoding A2)
  | str-is-push? = lsm PUSH cond w rn (reglst-one rt)
###  - Store Register (immediate)
  | otherwise = ls STR cond p u w rn rt imm12
val / ['/cond 011 /P /U 0 /W 0 /rn /rt /immshift /rm']
###  - Store Register Unprivileged (encoding A2)
  | unprivileged? = ls STRT cond set0 u set1 rn rt shfreg 
###  - Store Register (register)
  | otherwise = ls STR cond p u w rn rt shfreg

### STRB/STRBT
val / ['/cond 010 /P /U 1 /W 0 /rn /rt /imm12']
###  - Store Register Byte Unprivileged (Encoding A1)
  | unprivileged? = ls STRBT cond set0 u set1 rn rt imm12
###  - Store Register Byte (immediate)
  | otherwise = ls STRB cond p u w rn rt imm12
val / ['/cond 011 /P /U 1 /W 0 /rn /rt /immshift /rm']
###  - Store Register Byte Unprivileged (Encoding A2)
  | unprivileged? = ls STRBT cond set0 u set1 rn rt shfreg
###  - Store Register Byte (register)
  | otherwise = ls STRB cond p u w rn rt shfreg

### STRD
###  - Store Register Dual (immediate)
val / ['/cond 000 /P /U 1 /W 0 /rn /rt /imm4H 1111 /imm4L'] = ls STRD cond p u w rn rt combine-imm8
###  - Store Register Dual (register)
val / ['/cond 000 /P /U 0 /W 0 /rn /rt 0000 1111 /rm'] = ls STRD cond p u w rn rt rm

### STRH/STRHT
val / ['/cond 000 /P /U 1 /W 0 /rn /rt /imm4H 1011 /imm4L']
###  - Store Register Halfword Unprivileged (Encoding A1)
  | unprivileged? = ls STRHT cond set0 u set1 rn rt combine-imm8
###  - Store Register Halfword (immediate)
  | otherwise = ls STRH cond p u w rn rt combine-imm8
val / ['/cond 000 /P /U 0 /W 0 /rn /rt 0000 1011 /rm']
###  - Store Register Halfword Unprivileged (Encoding A2)
  | unprivileged? = ls STRHT cond set0 u set1 rn rt rm
###  - Store Register Halfword (register)
  | otherwise = ls STRH cond p u w rn rt rm

### STREX
###  - Store Register Exclusive
val / ['/cond 000 1 1 0 0 0 /rn /rd 1111 1001 /rt'] = lstr STREX cond rn rd rt

### STREXB
###  - Store Register Exclusive Byte
val / ['/cond 000 1 1 1 0 0 /rn /rd 1111 1001 /rt'] = lstr STREXB cond rn rd rt

### STREXD
###  - Store Register Exclusive DWORD
val / ['/cond 000 1 1 0 1 0 /rn /rd 1111 1001 /rt'] = lstr STREXD cond rn rd rt

### STREXH
###  - Store Register Exclusive Halfword
val / ['/cond 000 1 1 1 1 0 /rn /rd 1111 1001 /rt'] = lstr STREXH cond rn rd rt

# --- Load/store multiple instructions ---------------------------------

val ldm-is-pop? s = (is-sp? s.rn) and s.w and (opndl-length s.operands) > 1

### LDM/POP
val / ['/cond 100 0 1 0 /W 1 /rn /reglst']
###  - Pop Multiple Registers (Encoding A1)
  | ldm-is-pop? = lsm POP cond set1 rn reglst
###  - Load Multiple
  | otherwise = lsm LDM cond (return '1') rn reglst

(*Included in LDM*)
(*TODO: adapt LDM to return included subversions correctly*)
### LDMIA
### LDMFD

### LDMDA
###  - Load Multiple Decrement After
val / ['/cond 100 0 0 0 /W 1 /rn /reglst'] = lsm LDMDA cond w rn reglst

(*Included in LDMDA*)
(*TODO: adapt LDMDA to return included subversion correctly*)
### LDMFA

### LDMDB
###  - Load Multiple Decrement Before
val / ['/cond 100 1 0 0 /W 1 /rn /reglst'] = lsm LDMDB cond w rn reglst

(*Included in LDMDB*)
(*TODO: adapt LDMDB to return included subversion correctly*)
### LDMEA

### LDMIB
###  - Load Multiple Increment Before
val / ['/cond 100 1 1 0 /W 1 /rn /reglst'] = lsm LDMIB cond w rn reglst

(*Included in LDMIB*)
(*TODO: adapt LDMIB to return included subversion correctly*)
### LDMED

### STM
###  - Store Multiple
val / ['/cond 100 0 1 0 /W 0 /rn /reglst'] = lsm STM cond w rn reglst

(*Included in STM*)
(*TODO: adapt STM to return included subversions correctly*)
### STMIA
### STMEA

val stmdb-is-push? s = (is-sp? s.rn) and s.w and (opndl-length s.operands) > 1

### STMDB/PUSH
val / ['/cond 100 1 0 0 /W 0 /rn /reglst']
###  - Push Multiple Registers (Encoding A1)
  | stmdb-is-push? = lsm PUSH cond w rn reglst
###  - Store Multiple Decrement Before
  | otherwise = lsm STMDB cond w rn reglst

(*Included in STMDB*)
(*TODO: adapt STMDB to return included subversion correctly*)
### STMFD

### STMDA
###  - Store Multiple Decrement After
val / ['/cond 100 0 0 0 /W 0 /rn /reglst'] = lsm STMDA cond w rn reglst

(*Included in STMDA*)
(*TODO: adapt STMDA to return included subversion correctly*)
### STMED

### STMIB
###  - Store Multiple Increment Before
val / ['/cond 100 1 1 0 /W 0 /rn /reglst'] = lsm STMIB cond w rn reglst

(*Included in STMIB*)
(*TODO: adapt STMIB to return included subversion correctly*)
### STMFA

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
val / ['1111 010 1 /U 1 0 1 /rn 1111 /imm12'] = pre PLD none rn u imm12
###  - Preload Data Read (register)
val / ['1111 011 1 /U 1 0 1 /rn 1111 /immshift /rm'] = pre PLD none rn u shfreg

### PLDW
###  - Preload Data Write (immediate)
val / ['1111 010 1 /U 0 0 1 /rn 1111 /imm12'] = pre PLDW none rn u imm12
###  - Preload Data Write (register)
val / ['1111 011 1 /U 0 0 1 /rn 1111 /immshift /rm'] = pre PLDW none rn u shfreg

### PLI
###  - Preload Instruction (immediate/literal)
val / ['1111 010 0 /U 1 0 1 /rn 1111 /imm12'] = pre PLI none rn u imm12
###  - Preload Instruction (register)
val / ['1111 011 0 /U 1 0 1 /rn 1111 /immshift /rm'] = pre PLI none rn u shfreg

### SETEND
###  - Set Endianess
val / ['1111 000 1 0 0 0 0 000 1 000000 /E 0 0000 0000'] = unopbit SETEND none e

### SEV
###  - Send Event
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 0000 0100'] = nullop SEV cond

### SWP
###  - Swap
val / ['/cond 000 1 0 0 0 0 /rn /rt 0000 1001 /rt2'] = swap SWP cond rn rt rt2

### SWPB
###  - Swap Byte
val / ['/cond 000 1 0 1 0 0 /rn /rt 0000 1001 /rt2'] = swap SWPB cond rn rt rt2

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
val / ['1111 100 /P /U 0 /W 1 /rn 0000 1010 00000000'] = exc RFE cond p u w rn

### SUBS
###  - Subtract (Exception Return) (Encoding A1)
val / ['/cond 001 /imm4 1 /rn 1111 /imm12'] = subs SUBS cond imm4 rn imm12
###  - Subtract (Exception Return) (Encoding A2)
val / ['/cond 000 /imm4 1 /rn 1111 /immshift /rm'] = subs SUBS cond imm4 rn shfreg

### HVC
###  - Hypervisor Call
val / ['/cond 000 1 0 1 0 0 /imm12 0111 /imm4'] = unop HVC cond combine-imm16-rev

### ERET
###  - Exception Return
val / ['/cond 000 1 0 1 1 0 000000000000 0110 1110'] = nullop ERET cond

(*TODO: adjust to represent subversions as fullversions*)
### LDM
###  - Load Multiple (Exception Return)
val / ['/cond 100 /P /U 1 /W 1 /rn 1 /reglst15'] = ldm LDMerur cond p u w rn reglst
###  - Load Multiple (User registers)
val / ['/cond 100 /P /U 1 0 1 /rn 1 /reglst15'] = ldm LDMerur cond p u set0 rn reglst

### SRS
###  - Store Return State
val / ['1111 100 /P /U 1 /W 0 1101 0000 0101 000 /imm5'] = srs SRS none p u w imm5

# --- Coprocessor instructions -----------------------------------------

### CDP
###  - Coprocessor Data Processing (Encoding A1)
val / ['/cond 1110 /opc14 /crn /crd /coproc /opc23 0 /crm'] = cdp CDP cond coproc opc14 crd crn crm opc23

### CDP2
###  - Coprocessor Data Processing (Encoding A2)
val / ['1111 1110 /opc14 /crn /crd /coproc /opc23 0 /crm'] = cdp CDP2 none coproc opc14 crd crn crm opc23

### MCR
###  - Move to Coprocessor (Encoding A1)
val / ['/cond 111 0 /opc13 0 /crn /rt /coproc /opc23 1 /crm'] = mcr MCR cond coproc opc13 rt crn crm opc23

### MCR2
###  - Move to Coprocessor (Encoding A2)
val / ['1111 111 0 /opc13 0 /crn /rt /coproc /opc23 1 /crm'] = mcr MCR2 none coproc opc13 rt crn crm opc23

### MCRR
###  - Move to Coprocessor from two (Encoding A1)
val / ['/cond 110 0 0 1 0 0 /rt2 /rt /coproc /opc14 /crm'] = mcrr MCRR cond coproc opc14 rt rt2 crm

### MCRR2
###  - Move to Coprocessor from two (Encoding A2)
val / ['1111 110 0 0 1 0 0 /rt2 /rt /coproc /opc14 /crm'] = mcrr MCRR2 none coproc opc14 rt rt2 crm

### MRC
###  - Move from Coprocessor (Encoding A1)
val / ['/cond 111 0 /opc13 1 /crn /rt /coproc /opc23 1 /crm'] = mrc MRC cond coproc opc13 rt crn crm opc23

### MRC2
###  - Move from Coprocessor (Encoding A2)
val / ['1111 111 0 /opc13 1 /crn /rt /coproc /opc23 1 /crm'] = mrc MRC2 none coproc opc13 rt crn crm opc23

### MRRC
###  - Move to two from Coprocessor (Encoding A1)
val / ['/cond 110 0 0 1 0 1 /rt2 /rt /coproc /opc14 /crm'] = mrrc MRRC cond coproc opc14 rt rt2 crm

### MRRC2
###  - Move to two from Coprocessor (Encoding A2)
val / ['1111 110 0 0 1 0 1 /rt2 /rt /coproc /opc14 /crm'] = mrrc MRRC2 none coproc opc14 rt rt2 crm

### LDC (immediate/literal)
###  - Load Coprocessor (Encoding A1)
val / ['/cond 110 /PUDW 1 /rn /crd /coproc /imm8'] = cop LDC cond coproc crd rn pudw imm8

### LDC2 (immediate/literal)
###  - Load Coprocessor (Encoding A2)
val / ['1111 110 /PUDW 1 /rn /crd /coproc /imm8'] = cop LDC2 none coproc crd rn pudw imm8

### STC
###  - Store Coprocessor (Encoding A1)
val / ['/cond 110 /PUDW 0 /rn /crd /coproc /imm8'] = cop STC cond coproc crd rn pudw imm8

### STC2
###  - Store Coprocessor (Encoding A2)
val / ['1111 110 /PUDW 0 /rn /crd /coproc /imm8'] = cop STC2 none coproc crd rn pudw imm8

# --- Advanced SIMD and floating-point load/store instructions ---------

### VLDMIA
###  - Vector Load Multiple Increment After
val / ['/cond 110 01 /D /W 1 /rn /vd 101 h:1 /imm8'] = vlsm VLDMIA cond rn w set0 d vd imm8

### VLDMDB
###  - Vector Load Multiple Decrement Before
val / ['/cond 110 10 /D 1 1 /rn /vd 101 h:1 /imm8'] = vlsm VLDMDB cond rn set1 set0 d vd imm8

### VLDR
###  - Vector Load Register
val / ['/cond 110 1 /U /D 01 /rn /vd 101 h:1 /imm8'] = vlsr VLDR cond set0 d vd rn u imm8

### VSTMIA
###  - Vector Store Multiple Increment After
val / ['/cond 110 01 /D /W 0 /rn /vd 101 h:1 /imm8'] = vlsm VSTMIA cond rn w set0 d vd imm8

### VSTMDB
###  - Vector Store Multiple Decrement Before
val / ['/cond 110 10 /D 1 0 /rn /vd 101 h:1 /imm8'] = vlsm VSTMDB cond rn set1 set0 d vd imm8

### VSTR
###  - Vector Store Register
val / ['/cond 110 1 /U /D 00 /rn /vd 101 h:1 /imm8'] = vlsr VSTR cond set0 d vd rn u imm8

# --- Element and structure load/store instructions --------------------

### VLD1 (multiple single elements)
###  - Vector Load multiple single elements
val / ['1111 0100 0 /D 10 /rn /vd /vls1_type /size /aligna /rm'] = vls VLD1 none size set0 d vd rn aligna rm

### VLD1 (one lane)
###  - Vector Load single element to one lane
val / ['1111 0100 1 /D 10 /rn /vd /size 00 /index_align /rm'] = vls VLD1 none size set0 d vd rn index_align rm

### VLD1 (all lanes)
###  - Vector Load single element to all lanes
val / ['1111 0100 1 /D 10 /rn /vd 11 00 /size T:1 /a /rm'] = vlsbit VLD1a none size set0 d vd rn a rm

### VLD2 (multiple structures)
###  - Vector Load multiple 2-element structures
val / ['1111 0100 0 /D 10 /rn /vd /vls2_type /size /aligna /rm'] = vls VLD2 none size set0 d vd rn aligna rm

### VLD2 (one lane)
###  - Vector Load 2-element structure to one lane
val / ['1111 0100 1 /D 10 /rn /vd /size 01 /index_align /rm'] = vls VLD2 none size set0 d vd rn index_align rm

### VLD2 (all lanes)
###  - Vector Load 2-element structure to all lanes
val / ['1111 0100 1 /D 10 /rn /vd 11 01 /size T:1 /a /rm'] = vlsbit VLD2a none size set0 d vd rn a rm

### VLD3 (multiple structures)
###  - Vector Load multiple 3-element structures
val / ['1111 0100 0 /D 10 /rn /vd /vls3_type /size /aligna /rm'] = vls VLD3 none size set0 d vd rn aligna rm

### VLD3 (one lane)
###  - Vector Load 3-element structure to one lane
val / ['1111 0100 1 /D 10 /rn /vd /size 10 /index_align /rm'] = vls VLD3 none size set0 d vd rn index_align rm

### VLD3 (all lanes)
###  - Vector Load 3-element structure to all lanes
val / ['1111 0100 1 /D 10 /rn /vd 11 10 /size T:1 /a /rm'] = vlsbit VLD3a none size set0 d vd rn a rm

### VLD4 (multiple structures)
###  - Vector Load multiple 4-element structures
val / ['1111 0100 0 /D 10 /rn /vd /vls4_type /size /aligna /rm'] = vls VLD4 none size set0 d vd rn aligna rm

### VLD4 (one lane)
###  - Vector Load 4-element structure to one lane
val / ['1111 0100 1 /D 10 /rn /vd /size 11 /index_align /rm'] = vls VLD4 none size set0 d vd rn index_align rm

### VLD4 (all lanes)
###  - Vector Load 4-element structure to all lanes
val / ['1111 0100 1 /D 10 /rn /vd 11 11 /size T:1 /a /rm'] = vlsbit VLD4a none size set0 d vd rn a rm

### VST1 (multiple elments)
###  - Vector Store multiple single elements
val / ['1111 0100 0 /D 00 /rn /vd /vls1_type /size /aligna /rm'] = vls VST1 none size set0 d vd rn aligna rm

### VST1 (one lane)
###  - Vector Store single element from one lane
val / ['1111 0100 1 /D 00 /rn /vd /size 00 /index_align /rm'] = vls VST1 none size set0 d vd rn index_align rm

### VST2 (multiple structures)
###  - Vector Store multiple 2-element structures
val / ['1111 0100 0 /D 00 /rn /vd /vls2_type /size /aligna /rm'] = vls VST2 none size set0 d vd rn aligna rm

### VST2 (one lane)
###  - Vector Store 2-element structure from one lane
val / ['1111 0100 1 /D 00 /rn /vd /size 01 /index_align /rm'] = vls VST2 none size set0 d vd rn index_align rm

### VST3 (multiple structures)
###  - Vector Store multiple 3-element structures
val / ['1111 0100 0 /D 00 /rn /vd /vls3_type /size /aligna /rm'] = vls VST3 none size set0 d vd rn aligna rm

### VST3 (one lane)
###  - Vector Store 3-element structure from one lane
val / ['1111 0100 1 /D 00 /rn /vd /size 10 /index_align /rm'] = vls VST3 none size set0 d vd rn index_align rm

### VST4 (multiple structures)
###  - Vector Store multiple 4-element structures
val / ['1111 0100 0 /D 00 /rn /vd /vls4_type /size /aligna /rm'] = vls VST4 none size set0 d vd rn aligna rm

### VST4 (one lane)
###  - Vector Store 4-element structure from one lane
val / ['1111 0100 1 /D 00 /rn /vd /size 11 /index_align /rm'] = vls VST4 none size set0 d vd rn index_align rm

# --- Advanced SIMD and floating-point register transfer instructions --

### VDUP
###  - Vector Duplicate Arm Core Register
val / ['/cond 1110 1 B:1 /Q 0 /vd /rt 1011 /D 0 E:1 1 0000'] = vc VDUP cond imm4 q d vd rt

### VMOV
###  - Vector Move ARM core register to scalar
val / ['/cond 1110 0 /opc12 0 /vd /rt 1011 /D /opc22 1 0000'] = vc VMOVacs cond combine-opc2 set0 d vd rt
###  - Vector Move scalar to ARM core register
val / ['/cond 1110 /U /opc12 1 /vn /rt 1011 /N /opc22 1 0000'] = vcrev VMOVsac cond combine-u-opc2 rt set0 n vn
###  - Vector Move between ARM core register and single-precision register
val / ['/cond 1110 0 00 0 /vn /rt 1010 /N 00 1 0000'] = vcns VMOVacsp cond set0 n vn rt
val / ['/cond 1110 0 00 1 /vn /rt 1010 /N 00 1 0000'] = vcrevns VMOVspac cond rt set0 n vn
(*TODO: Adjust second 'm vm' to represent next vector*)
###  - Vector Move between two ARM core and two single-precision registers
val / ['/cond 1100 0 10 0 /rt2 /rt 1010 00 /M 1 /vm'] = vcns2 VMOVacsp2 cond set0 m vm set0 m vm rt rt2
val / ['/cond 1100 0 10 1 /rt2 /rt 1010 00 /M 1 /vm'] = vcrevns2 VMOVspac2 cond rt rt2 set0 m vm set0 m vm
###  - Vector Move between two ARM core and doubleword extension register
val / ['/cond 1100 0 10 0 /rt2 /rt 1011 00 /M 1 /vm'] = vcns2half VMOVacdwe cond set0 m vm rt rt2
val / ['/cond 1100 0 10 1 /rt2 /rt 1011 00 /M 1 /vm'] = vcrevns2half VMOVdweac cond rt rt2 set0 m vm

### VMRS
val / ['/cond 1110 1111 0001 /rt 1010 000 1 0000'] = unop VMRS cond rt

### VMSR
val / ['/cond 1110 1110 0001 /rt 1010 000 1 0000'] = unop VMSR cond rt

# --- Advanced SIMD parallel addition and Subtraction instructions ----

### VADD
###  - Vector Add integer
val / ['1111 0010 0 /D /size2 /vn /vd 1000 /N /Q /M 0 /vm'] = vc3 VADDiasimd none size q d vd q n vn q m vm
###  - Vector Add floating-point (Encoding A1)
val / ['1111 0010 0 /D 0 0 /vn /vd 1101 /N /Q /M 0 /vm'] = vc3bit VADDfpasimd none set0 q d vd q n vn q m vm

### VADDHN
###  - Vector Add and Narrow returning high half
val / ['1111 0010 1 /D /size /vn /vd 0100 /N 0 /M 0 /vm'] = vc3 VADDHN none size set0 d vd set0 n vn set0 m vm

### VADDL
###  - Vector Add Long
val / ['1111 001 /U 1 /D /size /vn /vd 0000 /N 0 /M 0 /vm'] = vc3sig VADDL none u size set0 d vd set0 n vn set0 m vm

### VADDW
###  - Vector Add Wide
val / ['1111 001 /U 1 /D /size /vn /vd 0001 /N 0 /M 0 /vm'] = vc3sig VADDW none u size set0 d vd set0 n vn set0 m vm

### VHADD
###  - Vector Halving Add
val / ['1111 001 /U 0 /D /size /vn /vd 0000 /N /Q /M 0 /vm'] = vc3sig VHADD none u size q d vd q n vn q m vm

### VHSUB
###  - Vector Halving Sub
val / ['1111 001 /U 0 /D /size /vn /vd 0010 /N /Q /M 0 /vm'] = vc3sig VHSUB none u size q d vd q n vn q m vm

### VPADAL
val / ['1111 0011 1 /D 11 /size 00 /vd 0110 /op /Q /M 0 /vm'] = vc2sig VPADAL none op size q d vd q m vm

### VPADD
###  - Vector Pairwise Add integer
val / ['1111 0010 0 /D /size /vn /vd 1011 /N 0 /M 1 /vm'] = vc3 VPADDi none size set0 d vd set0 n vn set0 m vm
###  - Vector Pairwise Add floating-point
val / ['1111 0011 0 /D 0 0 /vn /vd 1101 /N 0 /M 0 /vm'] = vc3bit VPADDfp none set0 set0 d vd set0 n vn set0 m vm 

### VPADDL
###  - Vector Pairwise Add Long
val / ['1111 0011 1 /D 11 /size 00 /vd 0010 /op /Q /M 0 /vm'] = vc2sig VPADDL none op size q d vd q m vm

### VRADDHN
###  - Vector Rounding Add and Narrow high half
val / ['1111 0011 1 /D /size /vn /vd 0100 /N 0 /M 0 /vm'] = vc3 VRADDHN none size set0 d vd set1 n vn set1 m vm 

### VRHADD
###  - Vector Rounding Halving Add
val / ['1111 001 /U 0 /D /size /vn /vd 0001 /N /Q /M 0 /vm'] = vc3sig VRHADD none u size q d vd q n vn q m vm

### VRSUBHN
###  - Vector Rounding Subtract and Narrow high half
val / ['1111 0011 1 /D /size /vn /vd 0110 /N 0 /M 0 /vm'] = vc3 VRSUBHN none size set0 d vd set1 n vn set1 m vm

### VQADD
###  - Vector Saturating Add
val / ['1111 001 /U 0 /D /size /vn /vd 0000 /N /Q /M 1 /vm'] = vc3sig VQADD none u size q d vd q n vn q m vm

### VQSUB
###  - Vector Saturating Subtract
val / ['1111 001 /U 0 /D /size /vn /vd 0010 /N /Q /M 1 /vm'] = vc3sig VQSUB none u size q d vd q n vn q m vm

### VSUB
###  - Vector Subtract integer
val / ['1111 0011 0 /D /size /vn /vd 1000 /N /Q /M 0 /vm'] = vc3 VSUBiasimd none size q d vd q n vn q m vm
###  - Vector Subtract floating-point (Encoding A1)
val / ['1111 0010 0 /D 1 0 /vn /vd 1101 /N /Q /M 0 /vm'] = vc3bit VSUBfpasimd none set0 q d vd q n vn q m vm

### VSUBHN
###  - Vector Subtract and Narrow high half
val / ['1111 0010 1 /D /size /vn /vd 0110 /N 0 /M 0 /vm'] = vc3 VSUBHN none size set0 d vd set0 n vn set0 m vm

### VSUBL
###  - Vector Subtract Long
val / ['1111 001 /U 1 /D /size /vn /vd 001 0 /N 0 /M 0 /vm'] = vc3sig VSUBL none u size set0 d vd set0 n vn set0 m vm

### VSUBW
###  - Vector Subtract Wide
val / ['1111 001 /U 1 /D /size /vn /vd 001 1 /N 0 /M 0 /vm'] = vc3sig VSUBW none u size set0 d vd set0 n vn set0 m vm

# --- Bitwise Advanced SIMD data-processing instructions ---------------

### VAND
###  - Vector And register
val / ['1111 0010 0 /D 00 /vn /vd 0001 /N /Q /M 1 /vm'] = vc3ns VAND none q d vd q n vn q m vm

### VBIC
###  - Vector Bitwise Bit Clear immediate
val / ['1111 001 /i 1 /D 000 /imm3 /vd /cmode-bic 0 /Q 11 /imm4'] = vcimm VBICimm none cmode q d vd combine-imm8-2
###  - Vector Bitwise Bit Clear register
val / ['1111 0100 0 /D 01 /vn /vd 0001 /N /Q /M 1 /vm'] = vc3ns VBICreg none q d vd q n vn q m vm

### VEOR
###  - Vector Bitwise Exclusive OR
val / ['1111 0011 0 /D 00 /vn /vd 0001 /N /Q /M 1 /vm'] = vc3ns VEOR none q d vd q n vn q m vm

### VBIF
###  - Vector Bitwise Insert If False
val / ['1111 0011 0 /D 11 /vn /vd 0001 /N /Q /M 1 /vm'] = vc3ns VBIF none q d vd q n vn q m vm

### VBIT
###  - Vector Bitwise Insert If True
val / ['1111 0011 0 /D 10 /vn /vd 0001 /N /Q /M 1 /vm'] = vc3ns VBIF none q d vd q n vn q m vm

### VMOV
###  - Vector Move immediate
val / ['1111 001 /i 1 /D 000 /imm3 /vd /cmode-mov0 0 /Q 0 1 /imm4'] = vcimm VMOVimmasimd none cmode q d vd combine-imm8-2
val / ['1111 001 /i 1 /D 000 /imm3 /vd /cmode-mov1 0 /Q 1 1 /imm4'] = vcimm VMOVimmasimd none cmode q d vd combine-imm8-2
###  - Vector Move register
val / ['1111 0010 0 /D 10 /vm /vd 0001 0 /Q /M 1 /vm'] = vc2ns VMOVregasimd none q d vd q m vm

### VMVN
###  - Vector Bitwise Not immediate
val / ['1111 001 /i 1 /D 000 /imm3 /vd /cmode-mvn 0 /Q 11 /imm4'] = vcimm VMVNimm none cmode q d vd combine-imm8-2
###  - Vector Bitwise Not register
val / ['1111 0011 1 /D 11 /size 00 /vd 0 1011 /Q /M 0 /vm'] = vc2 VMVNreg none size q d vd q m vm

### VORR
###  - Vector Bitwise OR immediate
val / ['1111 001 /i 1 /D 000 /imm3 /vd /cmode-vorr 0 /Q 01 /imm4'] = vcimm VORRimm none cmode q d vd combine-imm8-2
###  - Vector Bitwise OR register
val / ['1111 0010 0 /D 10 /vn /vd 0001 /N /Q /M 1 /vm'] = vc3ns VORRreg none q d vd q n vn q m vm

### VORN
###  - Vector Bitwise OR NOT register
val / ['1111 0010 0 /D 11 /vn /vd 0001 /N /Q /M 1 /vm'] = vc3ns VORN none q d vd q n vn q m vm

### VBSL
###  - Vector Bitewise Select
val / ['1111 0011 0 /D 01 /vn /vd 0001 /N /Q /M 1 /vm'] = vc3ns VBIF none q d vd q n vn q m vm

# --- Advanced SIMD comparison instructions ----------------------------

### VACGE (LT)
###  - Vector Absolute Compare Greater Than or Equal (Vector Absolute Compare Lower Than)
val / ['1111 0011 0 /D 0 0 /vn /vd 1110 /N /Q /M 1 /vm'] = vc3bit VACGE none set0 q d vd q n vn q m vm
val / ['1111 0011 0 /D 0 1 /vn /vd 1110 /N /Q /M 1 /vm'] = vc3bit VACGE none set1 q d vd q n vn q m vm

### VACGT (LE)
###  - Vector Absolute Compare Greater Than (Vector Absolute Compare Lower Than or Equal)
val / ['1111 0011 0 /D 1 0 /vn /vd 1110 /N /Q /M 1 /vm'] = vc3bit VACGT none set0 q d vd q n vn q m vm
val / ['1111 0011 0 /D 1 1 /vn /vd 1110 /N /Q /M 1 /vm'] = vc3bit VACGT none set1 q d vd q n vn q m vm

### VCEQ
###  - Vector Compare Equal register (Encoding A1)
val / ['1111 0011 0 /D /size /vn /vd 1000 /N /Q /M 1 /vm'] = vc3 VCEQrega none size q d vd q n vn q m vm
###  - Vector Compare Equal register (Encoding A2)
val / ['1111 0010 0 /D 0 /sz /vn /vd 1110 /N /Q /M 0 /vm'] = vc3bit VCEQregb none sz q d vd q n vn q m vm
###  - Vector Compare Equal immediate
val / ['1111 0011 1 /D 11 /size 01 /vd 0 /F 010 /Q /M 0 /vm'] = vc2sig VCEQimm none f size q d vd q m vm

### VCGE
###  - Vector Compare Greater Than or Equal register (Encoding A1)
val / ['1111 001 /U 0 /D /size /vn /vd 0011 /N /Q /M 1 /vm'] = vc3sig VCGErega none u size q d vd q n vn q m vm
###  - Vector Compare Greater Than or Equal register (Encoding A2
val / ['1111 0011 0 /D 0 /sz /vn /vd 1110 /N /Q /M 0 /vm'] = vc3bit VCGEregb none sz q d vd q n vn q m vm 
###  - Vector Compare Greater Than or Equal immediate
val / ['1111 0011 1 /D 11 /size 01 /vd 0 /F 001 /Q /M 0 /vm'] = vc2sig VCGEimm none f size q d vd q m vm

### VCGT
###  - Vector Compare Greater Than register (Encoding A1)
val / ['1111 001 /U 0 /D /size /vn /vd 0011 /N /Q /M 0 /vm'] = vc3sig VCGTrega none u size q d vd q n vn q m vm
###  - Vector Compare Greater Than register (Encoding A2)
val / ['1111 0011 0 /D 1 /sz /vn /vd 1110 /N /Q /M 0 /vm'] = vc3bit VCGTregb none sz q d vd q n vn q m vm
###  - Vector Compare Greater Than immediate
val / ['1111 0011 1 /D 11 /size 01 /vd 0 /F 000 /Q /M 0 /vm'] = vc2sig VCGTimm none f size q d vd q m vm

### VCLE
###  - Vector Compare Less Than or Equal immediate
val / ['1111 0011 1 /D 11 /size 01 /vd 0 /F 011 /Q /M 0 /vm'] = vc2sig VCLE none f size q d vd q m vm

### VCLT
###  - Vector Compare Less Than
val / ['1111 0011 1 /D 11 /size 01 /vd 0 /F 100 /Q /M 0 /vm'] = vc2sig VCLT none f size q d vd q m vm

### VTST
###  - Vector Test Bits
val / ['1111 0010 0 /D /size /vn /vd 1000 /N /Q /M 1 /vm'] = vc3 VTST none size q d vd q n vn q m vm

# --- Advanced SIMD shift instructions ---------------------------------

### VQRSHL
###  - Vector Saturating Rounding Shift Left
val / ['1111 001 /U 0 /D /size /vn /vd 0101 /N /Q /M 1 /vm'] = vc3sig VQRSHL none u size q d vd q m vm q n vn

### VQRSHRN
###  - Vector Saturating Rounding Shift Right Narrow
val / ['1111 001 /U 1 /D /imm6-not000 /vd 100 1 01 /M 1 /vm'] = vc2sigimm VQRSHRN none u imm6 set0 d vd set1 m vm imm6 

### VQRSHRUN
###  - Vector Saturating Rounding Shift Right UnsignedNarrow
val / ['1111 001 1 1 /D /imm6-not000 /vd 100 0 01 /M 1 /vm'] = vc2sigimm VQRSHRUN none set1 imm6 set0 d vd set1 m vm imm6

### VQSHL
###  - Vector Saturating Shift Left register
val / ['1111 001 /U 0 /D /size /vn /vd 0100 /N /Q /M 1 /vm'] = vc3sig VQSHLreg none u size q d vd q m vm q n vn
###  - Vector Saturating Shift Left immediate
val / ['1111 001 /U 1 /D /imm6-not000 /vd 011 1 0 /Q /M 1 /vm'] = vc2sigimm VQSHLimm none u imm6 q d vd q m vm imm6
val / ['1111 001 /U 1 /D /imm6 /vd 011 1 1 /Q /M 1 /vm'] = vc2sigimm VQSHLimm none u imm6 q d vd q m vm imm6

### VQSHLU
###  - Vector Saturating Shift Left Unsigned immediate
val / ['1111 001 1 1 /D /imm6-not000 /vd 011 0 0 /Q /M 1 /vm'] = vc2sigimm VQSHLU none set1 imm6 q d vd q m vm imm6
val / ['1111 001 1 1 /D /imm6 /vd 011 0 1 /Q /M 1 /vm'] = vc2sigimm VQSHLU none set1 imm6 q d vd q m vm imm6

### VQSHRN
###  - Vector Saturating Shift Right Narrow
val / ['1111 001 /U 1 /D /imm6-not000 /vd 100 1 00 /M 1 /vm'] = vc2sigimm VQSHRN none u imm6 set0 d vd set1 m vm imm6

### VQSHRUN
###  - Vector Saturating Shift Right Unsigned Narrow
val / ['1111 001 1 1 /D /imm6-not000 /vd 100 0 00 /M 1 /vm'] = vc2sigimm VQSHRUN none set1 imm6 set0 d vd set1 m vm imm6

### VRSHL
###  - Vector Rounding Shift Left
val / ['1111 001 /U 0 /D /size /vn /vd 0101 /N /Q /M 0 /vm'] = vc3sig VRSHL none u size q d vd q m vm q n vn

### VRSHR
###  - Vector Rounding Shift Right
val / ['1111 001 /U 1 /D /imm6 /vd 0010 1 /Q /M 1 /vm'] = vc2sigimm VRSHR none u imm6 q d vd q m vm imm6
val / ['1111 001 /U 1 /D /imm6-not000 /vd 0010 0 /Q /M 1 /vm'] = vc2sigimm VRSHR none u imm6 q d vd q m vm imm6

### VRSRA
###  - Vector ROunding Shift Right and Accumulate
val / ['1111 001 /U 1 /D /imm6 /vd 0011 1 /Q /M 1 /vm'] = vc2sigimm VRSHR none u imm6 q d vd q m vm imm6
val / ['1111 001 /U 1 /D /imm6-not000 /vd 0011 0 /Q /M 1 /vm'] = vc2sigimm VRSHR none u imm6 q d vd q m vm imm6

### VRSHRN
###  - Vector Rounding Shift Right and Narrow
val / ['1111 0010 1 /D /imm6-not000 /vd 1000 0 1 /M 1 /vm'] = vc2imm VRSHRN none imm6 set0 d vd set1 m vm imm6

### VSHL
###  - Vector Shift Left immediate
val / ['1111 0010 1 /D /imm6 /vd 0101 1 /Q /M 1 /vm'] = vc2imm VSHLimm none imm6 q d vd q m vm imm6
val / ['1111 0010 1 /D /imm6-not000 /vd 0101 0 /Q /M 1 /vm'] = vc2imm VSHLimm none imm6 q d vd q m vm imm6
###  - Vector Shift Left register
val / ['1111 001 /U 0 /D /size /vn /vd 0100 /N /Q /M 0 /vm'] = vc3sig VSHLreg none u size q d vd q m vm q n vn

### VSHLL
###  - Vector Shift Left Long (Encoding A1)
val / ['1111 001 /U 1 /D /imm6-not000 /vd 1010 00 /M 1 /vm'] = vc2sigimm VSHLL none u imm6 set0 d vd set1 m vm imm6
###  - Vector Shift Left Long (Encoding A2)
val / ['1111 0011 1 /D 11 /size 10 /vd 0011 00 /M 0 /vm'] = vc2sigimm VSHLL none set1 size set0 d vd set0 m vm size

### VSHR
###  - Vector Shift Right
val / ['1111 001 /U 1 /D /imm6 /vd 0000 1 /Q /M 1 /vm'] = vc2sigimm VSHR none u imm6 q d vd q m vm imm6
val / ['1111 001 /U 1 /D /imm6-not000 /vd 0000 0 /Q /M 1 /vm'] = vc2sigimm VSHR none u imm6 q d vd q m vm imm6

### VSHRN
val / ['1111 0010 1 /D /imm6-not000 /vd 1000 00 /M 1 /vm'] = vc2imm VSHRN none imm6 set0 d vd set1 m vm imm6 

### VSLI
val / ['1111 0011 1 /D /imm6 /vd 0101 1 /Q /M 1 /vm'] = vc2imm VSLI none imm6 q d vd q m vm imm6
val / ['1111 0011 1 /D /imm6-not000 /vd 0101 0 /Q /M 1 /vm'] = vc2imm VSLI none imm6 q d vd q m vm imm6

### VSRA
val / ['1111 001 /U 1 /D /imm6 /vd 0001 1 /Q /M 1 /vm'] = vc2sigimm VSRA none u imm6 q d vd q m vm imm6
val / ['1111 001 /U 1 /D /imm6-not000 /vd 0001 0 /Q /M 1 /vm'] = vc2sigimm VSRA none u imm6 q d vd q m vm imm6

### VSRI
val / ['1111 0011 1 /D /imm6 /vd 0100 1 /Q /M 1 /vm'] = vc2imm VSRI none imm6 q d vd q m vm imm6
val / ['1111 0011 1 /D /imm6-not000 /vd 0100 0 /Q /M 1 /vm'] = vc2imm VSRI none imm6 q d vd q m vm imm6

# --- Advanced SIMD multiply instructions ------------------------------

### VMLA
###  - Vector Multiply Accumulate integer
val / ['1111 001 0 0 /D /size /vn /vd 1001 /N /Q /M 0 /vm'] = vc3 VMLAiasimd none size q d vd q n vn q m vm
###  - Vector Multiply Accumulate floating-point
val / ['1111 0010 0 /D 0 /sz /vn /vd 1101 /N /Q /M 1 /vm'] = vc3bit VMLAfpasimd none sz q d vd q n vn q m vm
###  - Vector Multiply Accumulate by scalar
val / ['1111 001 /Q 1 /D /size /vn /vd 0 0 0 /F /N 1 /M 0 /vm'] = vc3sig VMLAsasimd none f size q d vd q n vn q m vm

### VMLAL
###  - Vector Multiply Accumulate Long integer
val / ['1111 001 /U 1 /D /size /vn /vd 10 0 0 /N 0 /M 0 /vm'] = vc3sig VMLAL none u size set1 d vd set0 n vn set0 m vm
###  - Vector Multiply Accumulate Long by scalar
val / ['1111 001 /U 1 /D /size /vn /vd 0 0 10 /N 1 /M 0 /vm'] = vc3sig VMLAL none u size set1 d vd set0 n vn set0 m vm

### VMLS
###  - Vector Multiply Subtract integer
val / ['1111 001 1 0 /D /size /vn /vd 1001 /N /Q /M 0 /vm'] = vc3 VMLSiasimd none size q d vd q n vn q m vm
###  - Vector Multiply Subtract floating-point
val / ['1111 0010 0 /D 1 /sz /vn /vd 1101 /N /Q /M 1 /vm'] = vc3bit VMLSfpasimd none sz q d vd q n vn q m vm
###  - Vector Multiply Subtract by scalar
val / ['1111 001 /Q 1 /D /size /vn /vd 0 1 0 /F /N 1 /M 0 /vm'] = vc3sig VMLSsasimd none f size q d vd q n vn q m vm

### VMLSL
###  - Vector Multiply Subtract Long integer
val / ['1111 001 /U 1 /D /size /vn /vd 10 1 0 /N 0 /M 0 /vm'] = vc3sig VMLSL none u size set1 d vd set0 n vn set0 m vm
###  - Vector Multiply Subtract Long by scalar
val / ['1111 001 /U 1 /D /size /vn /vd 0 1 10 /N 1 /M 0 /vm'] = vc3sig VMLSL none u size set1 d vd set0 n vn set0 m vm

### VMUL
###  - Vector Multiply integer and polynomial
val / ['1111 001 1 0 /D 00 /vn /vd 1001 /N /Q /M 1 /vm'] = vc3sig VMULipasimd none set1 set00 q d vd q n vn q m vm
val / ['1111 001 0 0 /D /size /vn /vd 1001 /N /Q /M 1 /vm'] = vc3sig VMULipasimd none set0 size q d vd q n vn q m vm
###  - Vector Multiply floating-point
val / ['1111 0011 0 /D 0 /sz /vn /vd 1101 /N /Q /M 1 /vm'] = vc3bit VMULfpasimd none sz q d vd q n vn q m vm
###  - Vector Multiply by scalar
val / ['1111 001 /Q 1 /D /size /vn /vd 100 /F /N 1 /M 0 /vm'] = vc3sig VMULsasimd none f size q d vd q n vn q m vm

### VMULL
###  - Vector Multiply Long integer and polynomial
val / ['1111 001 /U 1 /D /size /vn /vd 11 0 0 /N 0 /M 0 /vm'] = vc3sig2 VMULLipasimd none set0 u size set1 d vd set0 n vn set0 m vm
val / ['1111 001 0 1 /D 00 /vn /vd 11 1 0 /N 0 /M 0 /vm'] = vc3sig2 VMULLipasimd none set1 set0 set00 set1 d vd set0 n vn set0 m vm
###  - Vector Multiply Long by scalar
val / ['1111 001 /U 1 /D /size /vn /vd 1010 /N 1 /M 0 /vm'] = vc3sig VMULLsasimd none u size set1 d vd set0 n vn set0 m vm

### VFMA
###  - Vector Fused Multiply Accumulate
val / ['1111 00100 /D 0 /sz /vn /vd 1100 /N /Q /M 1 /vm'] = vc3bit VFMA none sz q d vd q n vn q m vm

### VFMS
###  - Vector Fused Multiply Subtract
val / ['1111 00100 /D 1 /sz /vn /vd 1100 /N /Q /M 1 /vm'] = vc3bit VFMS none sz q d vd q n vn q m vm

### VQDMLAL
###  - Vector Saturating Doubling Multiply Accumulate Long (Encoding A1)
val / ['1111 0010 1 /D /size /vn /vd 10 0 1 /N 0 /M 0 /vm'] = vc3 VQDMLAL none size set1 d vd set0 n vn set0 m vm
###  - Vector Saturating Doubling Multiply Accumulate Long (Encoding A2)
val / ['1111 0010 1 /D /size /vn /vd 0 0 11 /N 1 /M 0 /vm'] = vc3 VQDMLAL none size set1 d vd set0 n vn set0 m vm

### VQDMLSL
###  - Vector Saturating Doubling Multiply Subtract Long (Encoding A1)
val / ['1111 0010 1 /D /size /vn /vd 10 1 1 /N 0 /M 0 /vm'] = vc3 VQDMLSL none size set1 d vd set0 n vn set0 m vm
###  - Vector Saturating Doubling Multiply Subtract Long (Encoding A2)
val / ['1111 0010 1 /D /size /vn /vd 0 1 11 /N 1 /M 0 /vm'] = vc3 VQDMLSL none size set1 d vd set0 n vn set0 m vm

### VQDMULH
###  - Vector Saturating Doubling Multiply Returning High Half (Encoding A1)
val / ['1111 0010 0 /D /size /vn /vd 1011 /N /Q /M 0 /vm'] = vc3 VQDMULH none size q d vd q n vn q m vm
###  - Vector Saturating Doubling Multiply Returning High Half (Encoding A2)
val / ['1111 001 /Q 1 /D /size /vn /vd 1100 /N 1 /M 0 /vm'] = vc3 VQDMULH none size q d vd q n vn q m vm

### VQRDMULH
###  - Vector Saturating Rounding Doubling Multiply Returning High Half (Encoding A1)
val / ['1111 0011 0 /D /size /vn /vd 1011 /N /Q /M 0 /vm'] = vc3 VQRDMULH none size q d vd q n vn q m vm
###  - Vector Saturating Rounding Doubling Multiply Returning High Half (Encoding A2)
val / ['1111 001 /Q 1 /D /size /vn /vd 1101 /N 1 /M 0 /vm'] = vc3 VQRDMULH none size q d vd q n vn q m vm

### VQDMULL
###  - Vector Saturating Doubling Multiply Long (Encoding A1)
val / ['1111 0010 1 /D /size /vn /vd 1101 /N 0 /M 0 /vm'] = vc3 VQDMULL none size set1 d vd set0 n vn set0 m vm
###  - Vector Saturating Doubling Multiply Long (Encoding A2)
val / ['1111 0010 1 /D /size /vn /vd 1011 /N 1 /M 0 /vm'] = vc3 VQDMULL none size set1 d vd set0 n vn set0 m vm

# --- Miscellanous Advanced SIMD data-processing instructions ----------

### VABA
###  - Vector Absolute Difference and Accumulate
val / ['1111 001 /U 0 /D /size /vn /vd 0111 /N /Q /M 1 /vm'] = vc3sig VABA none u size q d vd q n vn q m vm

### VABAL
###  - Vector Absolute Difference and Accumulate Long
val / ['1111 001 /U 1 /D /size /vn /vd 0101 /N 0 /M 0 /vm'] = vc3sig VABAL none u size set1 d vd set0 n vn set0 m vm

### VABD
###  - Vector Absolute Difference integer
val / ['1111 001 /U 0 /D /size /vn /vd 0111 /N /Q /M 0 /vm'] = vc3sig VABDi none u size q d vd q n vn q m vm
###  - Vector Absolute Difference floating-point
val / ['1111 0011 0 /D 1 /sz /vn /vd 1101 /N /Q /M 0 /vm'] = vc3bit VABDfp none sz q d vd q n vn q m vm

### VABDL
###  - Vector Absolute Difference Long
val / ['1111 001 /U 1 /D /size /vn /vd 0111 /N 0 /M 0 /vm'] = vc3sig VABDL none u size set1 d vd set0 n vn set0 m vm

### VABS
val / ['1111 0011 1 /D 11 10 01 /vd 0 1 110 /Q /M 0 /vm'] = vc2sig VABSasimd none set1 set10 q d vd q m vm
val / ['1111 0011 1 /D 11 /size 01 /vd 0 0 110 /Q /M 0 /vm'] = vc2sig VABSasimd none set0 size q d vd q m vm

### VCVT
###  - Vector Convert between floating-point and integer
val / ['1111 0011 1 /D 11 10 11 /vd 0 11 /size2 /Q /M 0 /vm'] = vc2 VCVTfpiasimd none size q d vd q m vm
###  - Vector Convert between floating-point and fixed-point
val / ['1111 001 /U 1 /D /imm6-not000 /vd 111 /op 0 /Q /M 1 /vm'] = vc2sigbitimm VCVTfpfpasimd none u op q d vd q m vm imm6
###  - Vector Convert between half-precision and single-precision
val / ['1111 0011 1 /D 11 /size 10 /vd 011 0 00 /M 0 /vm'] = vc2 VCVThpspasimd none size set1 d vd set0 m vm
val / ['1111 0011 1 /D 11 /size 10 /vd 011 1 00 /M 0 /vm'] = vc2 VCVThpspasimd none size set0 d vd set1 m vm

### VCLS
###  - Vector Count Leading Sign Bits
val / ['1111 0011 1 /D 11 /size 00 /vd 0 1000 /Q /M 0 /vm'] = vc2 VCLS none size q d vd q m vm

### VCLZ
###  - Vector Count Leading Zeros
val / ['1111 0011 1 /D 11 /size 00 /vd 0 1001 /Q /M 0 /vm'] = vc2 VCLZ none size q d vd q m vm

### VCNT
###  - Vector Count Number of Bits in Element
val / ['1111 0011 1 /D 11 /size 00 /vd 0 1010 /Q /M 0 /vm'] = vc2 VCNT none size q d vd q m vm

### VDUP
###  - Vector Duplicate Scalar
val / ['1111 0011 1 /D 11 /imm4 /vd 1100 0 /Q /M 0 /vm'] = vc2 VDUP2 none imm4 q d vd q m vm

### VEXT
###  - Vector Extract
val / ['1111 0010 1 /D 11 /vn /vd /imm4 /N /Q /M 0 /vm'] = vc3nsimm VEXT none q d vd q n vn q m vm imm4

### VMOVN
###  - Vector Move and Narrow
val / ['1111 0011 1 /D 11 /size 10 /vd 0 0100 0 /M 0 /vm'] = vc2 VMOVN none size set0 d vd set0 m vm

### VMOVL
###  - Vector Move Long
val / ['1111 001 /U 1 /D /imm3 000 /vd 1010 0 0 /M 1 /vm'] = vc2 VMOVN none imm3 set0 d vd set0 m vm

### VMAX
###  - Vector Maximum integer
val / ['1111 001 /U 0 /D /size /vn /vd 0110 /N /Q /M 0 /vm'] = vc3sig VMAXi none u size q d vd q n vn q m vm
###  - Vector Maximum floating-point
val / ['1111 0010 0 /D 0 /sz /vn /vd 1111 /N /Q /M 0 /vm'] = vc3bit VMAXfp none sz q d vd q n vn q m vm

### VMIN
###  - Vector Minimum integer
val / ['1111 001 /U 0 /D /size /vn /vd 0110 /N /Q /M 1 /vm'] = vc3sig VMINi none u size q d vd q n vn q m vm
###  - Vector Minimum floating-point
val / ['1111 0010 0 /D 1 /sz /vn /vd 1111 /N /Q /M 0 /vm'] = vc3bit VMINfp none sz q d vd q n vn q m vm

### VNEG
###  - Vector Negate
val / ['1111 0011 1 /D 11 /size 01 /vd 0 /F 111 /Q /M 0 /vm'] = vc2sig VNEGasimd none f size q d vd q m vm

### VPMAX
###  - Vector Pairwise Maximum integer
val / ['1111 001 /U 0 /D /size /vn /vd 1010 /N 0 /M 0 /vm'] = vc3sig VPMAXi none u size set0 d vd set0 n vn set0 m vm
###  - Vector Pairwise Maximum floating-point
val / ['1111 0011 0 /D 0 /sz /vn /vd 1111 /N 0 /M 0 /vm'] = vc3bit VPMAXfp none sz set0 d vd set0 n vn set0 m vm

### VPMIN
###  - Vector Pairwise Minimum integer
val / ['1111 001 /U 0 /D /size /vn /vd 1010 /N 0 /M 1 /vm'] = vc3sig VPMINi none u size set0 d vd set0 n vn set0 m vm
###  - Vector Pairwise Minimum floating-point
val / ['1111 0011 0 /D 1 /sz /vn /vd 1111 /N 0 /M 0 /vm'] = vc3bit VPMINfp none sz set0 d vd set0 n vn set0 m vm

### VRECPE
###  - Vector Reciprocal Estimate
val / ['1111 0011 1 /D 11 /size 11 /vd 010 /F 0 /Q /M 0 /vm'] = vc2sig VRECPE none f size q d vd q m vm

### VRECPS
###  - Vector Reciprocal Step
val / ['1111 0010 0 /D 0 /sz /vn /vd 1111 /N /Q /M 1 /vm'] = vc3bit VRECPS none sz q d vd q n vn q m vm

### VRSQRTE
###  - Vector Reciprocal Square Root Estimate
val / ['1111 0011 1 /D 11 /size 11 /vd 010 /F 1 /Q /M 0 /vm'] = vc2sig VRSQRTE none f size q d vd q m vm 

### VRSQRTS
###  - Vector Reciprocal Square Root Step
val / ['1111 0010 0 /D 1 /sz /vn /vd 1111 /N /Q /M 1 /vm'] = vc3bit VRSQRTS none sz q d vd q n vn q m vm 

### VREV16
###  - Vector Reverse in halfwords
val / ['1111 0011 1 /D 11 /size 00 /vd 000 10 /Q /M 0 /vm'] = vc2 VREV16 none size q d vd q m vm

### VREV32
###  - Vector Reverse in words
val / ['1111 0011 1 /D 11 /size 00 /vd 000 01 /Q /M 0 /vm'] = vc2 VREV32 none size q d vd q m vm

### VREV64
###  - Vector Reverse in doublewords
val / ['1111 0011 1 /D 11 /size 00 /vd 000 00 /Q /M 0 /vm'] = vc2 VREV64 none size q d vd q m vm

### VQABS
###  - Vector Saturating Absolute
val / ['1111 0011 1 /D 11 /size 00 /vd 0111 0 /Q /M 0 /vm'] = vc2 VQABS none size q d vd q m vm

### VQMOVN
###  - Vector Saturating Move and Narrow
val / ['1111 0011 1 /D 11 /size 10 /vd 0010 1 /U /M 0 /vm'] = vc2sig VQMOVN none u size set0 d vd set1 m vm

### VQMOVUN
###  - Vector Saturating Move Unsigned and Narrow
val / ['1111 0011 1 /D 11 /size 10 /vd 0010 0 1 /M 0 /vm'] = vc2 VQMOVUN none size set0 d vd set1 m vm

### VQNEG
###  - Vector Saturating Negate
val / ['1111 0011 1 /D 11 /size 00 /vd 0111 1 /Q /M 0 /vm'] = vc2 VQNEG none size q d vd q m vm

### VSWP
###  - Vector Swap
val / ['1111 0011 1 /D 11 /size 10 /vd 0 0000 /Q /M 0 /vm'] = vc2 VSWP none size q d vd q m vm

### VTBL
###  - Vector Table Lookup
val / ['1111 0011 1 /D 11 /vn /vd 10 /len /N 0 /M 0 /vm'] = vc3nslist VTBL none set0 d vd len set0 n vn set0 m vm

### VTBX
###  - Vector Table Extension
val / ['1111 0011 1 /D 11 /vn /vd 10 /len /N 1 /M 0 /vm'] = vc3nslist VTBX none set0 d vd len set0 n vn set0 m vm

### VTRN
###  - Vector Transpose
val / ['1111 0011 1 /D 11 /size 10 /vd 0000 1 /Q /M 0 /vm'] = vc2 VTRN none size q d vd q m vm 

### VUZP
###  -  Vector Unzip
val / ['1111 0011 1 /D 11 /size 10 /vd 0001 0 /Q /M 0 /vm'] = vc2 VUZP none size q d vd q m vm

### VZIP
###  - Vector Zip
val / ['1111 0011 1 /D 11 /size 10 /vd 0001 1 /Q /M 0 /vm'] = vc2 VZIP none size q d vd q m vm

# --- Floating-point data-processing instructions ----------------------

### VABS
###  - Vector Absolute
val / ['/cond 1110 1 /D 11 0000 /vd 101 0 11 /M 0 /vm'] = vc2bit VABSfp cond set0 set1 d vd set1 m vm
val / ['/cond 1110 1 /D 11 0000 /vd 101 1 11 /M 0 /vm'] = vc2bit VABSfp cond set1 set0 d vd set0 m vm

### VADD
###  - Vector Add floating-point
val / ['/cond 1110 0 /D 11 /vn /vd 101 0 /N 0 /M 0 /vm'] = vc3bit VADDfpfp cond set0 set1 d vd set1 n vn set1 m vm
val / ['/cond 1110 0 /D 11 /vn /vd 101 1 /N 0 /M 0 /vm'] = vc3bit VADDfpfp cond set1 set0 d vd set0 n vn set0 m vm

### VCMP
###  - Vector Compare (Encoding A1)
val / ['/cond 1110 1 /D 11 0100 /vd 101 0 0 1 /M 0 /vm'] = vc2bit VCMP cond set0 set1 d vd set1 m vm
val / ['/cond 1110 1 /D 11 0100 /vd 101 1 0 1 /M 0 /vm'] = vc2bit VCMP cond set1 set0 d vd set0 m vm
###  - Vector Compare (Encoding A2)
val / ['/cond 1110 1 /D 11 0101 /vd 101 0 0 1 0 0 0000'] = vc2bit VCMP cond set0 set1 d vd set1 set0 set0000
val / ['/cond 1110 1 /D 11 0101 /vd 101 1 0 1 0 0 0000'] = vc2bit VCMP cond set1 set0 d vd set0 set0 set0000

### VCMPE
###  - Vector Compare Exception (Encoding A1)
val / ['/cond 1110 1 /D 11 0100 /vd 101 0 1 1 /M 0 /vm'] = vc2bit VCMPE cond set0 set1 d vd set1 m vm
val / ['/cond 1110 1 /D 11 0100 /vd 101 1 1 1 /M 0 /vm'] = vc2bit VCMPE cond set1 set0 d vd set0 m vm
###  - Vector Compare Exception (Encoding A2)
val / ['/cond 1110 1 /D 11 0101 /vd 101 0 1 1 0 0 0000'] = vc2bit VCMPE cond set0 set1 d vd set1 set0 set0000
val / ['/cond 1110 1 /D 11 0101 /vd 101 1 1 1 0 0 0000'] = vc2bit VCMPE cond set1 set0 d vd set0 set0 set0000

### VCVT
###  - Vector Convert between floating-point and integer
val / ['/cond 1110 1 /D 11 1 000 /vd 101 0 /op 1 /M 0 /vm'] = vc2bit2 VCVTfpifp cond op set0 set1 d vd set1 m vm
val / ['/cond 1110 1 /D 11 1 000 /vd 101 1 /op 1 /M 0 /vm'] = vc2bit2 VCVTfpifp cond op set1 set0 d vd set1 m vm
###  - Vector Convert between floating-point and fixed-point
val / ['/cond 1110 1 /D 111 /op 1 /U /vd 101 0 /sz1 1 /i 0 /imm4'] = vcbit4imm VCVTfpfpfp cond op set0 u sz1 set1 d vd set1 d vd combine-imm5
val / ['/cond 1110 1 /D 111 /op 1 /U /vd 101 1 /sz1 1 /i 0 /imm4'] = vcbit4imm VCVTfpfpfp cond op set1 u sz1 set0 d vd set0 d vd combine-imm5
###  - Vector Convert between double-precision and single-precision
val / ['/cond 1110 1 /D 11 0111 /vd 1010 0 /Q /M 0 /vm'] = vc2ns VCVTdpspfp none q d vd q m vm

### VCVTR
###  - Vector Convert Round between floating-point and integer
val / ['/cond 1110 1 /D 11 1 /opc2-vcvtr /vd 101 0 /op 1 /M 0 /vm'] = vc2opbit VCVTR cond opc23 set0 set1 d vd set1 m vm
val / ['/cond 1110 1 /D 11 1 /opc2-vcvtr /vd 101 1 /op 1 /M 0 /vm'] = vc2opbit VCVTR cond opc23 set1 set1 d vd set0 m vm

### VCVTB
###  - Vector Convert Bottom
val / ['/cond 1110 1 /D 11 001 /op /vd 101 0 0 1 /M 0 /vm'] = vc2bit VCVTB cond op set1 d vd set1 m vm

### VCVTT
###  - Vector Convert Top
val / ['/cond 1110 1 /D 11 001 /op /vd 101 0 1 1 /M 0 /vm'] = vc2bit VCVTT cond op set1 d vd set1 m vm

### VDIV
###  - Vector Divide
val / ['/cond 1110 1 /D 00 /vn /vd 101 1 /N 0 /M 0 /vm'] = vc3bit VDIV cond set1 set0 d vd set0 n vn set0 m vm
val / ['/cond 1110 1 /D 00 /vn /vd 101 0 /N 0 /M 0 /vm'] = vc3bit VDIV cond set0 set1 d vd set1 n vn set1 m vm

### VMLA
###  - Vector Multiply Accumulate floating-point
val / ['/cond 11100 /D 00 /vn /vd 101 1 /N 0 /M 0 /vm'] = vc3bit VMLAfpfp cond set1 set0 d vd set0 n vn set0 m vm
val / ['/cond 11100 /D 00 /vn /vd 101 0 /N 0 /M 0 /vm'] = vc3bit VMLAfpfp cond set0 set1 d vd set1 n vn set1 m vm

### VMLS
###  - Vector Multiply Subtract floating-point
val / ['/cond 11100 /D 00 /vn /vd 101 1 /N 1 /M 0 /vm'] = vc3bit VMLSfpfp cond set1 set0 d vd set0 n vn set0 m vm
val / ['/cond 11100 /D 00 /vn /vd 101 0 /N 1 /M 0 /vm'] = vc3bit VMLSfpfp cond set0 set1 d vd set1 n vn set1 m vm

### VMOV
###  - Vector Move immediate floating-point
val / ['/cond 11101 /D 11 /imm4H /vd 101 0 0000 /imm4L'] = vcimm VMOVimmfp none set1010 set1 d vd combine-imm8
val / ['/cond 11101 /D 11 /imm4H /vd 101 1 0000 /imm4L'] = vcimm VMOVimmfp none set1011 set0 d vd combine-imm8
###  - Vector Move register floating-point
val / ['/cond 11101 /D 11 0000 /vd 101 0 01 /M 0 /vm'] = vc2bit VMOVregfp none set0 set1 d vd set1 m vm
val / ['/cond 11101 /D 11 0000 /vd 101 1 01 /M 0 /vm'] = vc2bit VMOVregfp none set1 set0 d vd set0 m vm

### VFMA
###  - Vector Fused Multiply Accumulate
val / ['/cond 11101 /D 10 /vn /vd 101 0 /N 0 /M 0 /vm'] = vc3bit VFMA cond set0 set1 d vd set1 n vn set1 m vm
val / ['/cond 11101 /D 10 /vn /vd 101 1 /N 0 /M 0 /vm'] = vc3bit VFMA cond set1 set0 d vd set0 n vn set0 m vm

### VFMS
###  - Vector Fused Multiply Subtract
val / ['/cond 11101 /D 10 /vn /vd 101 0 /N 1 /M 0 /vm'] = vc3bit VFMS cond set0 set1 d vd set1 n vn set1 m vm
val / ['/cond 11101 /D 10 /vn /vd 101 1 /N 1 /M 0 /vm'] = vc3bit VFMS cond set1 set0 d vd set0 n vn set0 m vm

### VMUL
###  - Vector Multiply floating-point
val / ['/cond 11100 /D 10 /vn /vd 101 0 /N 0 /M 0 /vm'] = vc3bit VMULfpfp cond set0 set1 d vd set1 n vn set1 m vm
val / ['/cond 11100 /D 10 /vn /vd 101 1 /N 0 /M 0 /vm'] = vc3bit VMULfpfp cond set1 set0 d vd set0 n vn set0 m vm 

### VNEG
###  - Vector Negate
val / ['/cond 11101 /D 11 0001 /vd 101 0 01 /M 0 /vm'] = vc2bit VNEGfp cond set0 set1 d vd set1 m vm
val / ['/cond 11101 /D 11 0001 /vd 101 1 01 /M 0 /vm'] = vc2bit VNEGfp cond set1 set0 d vd set0 m vm

### VNMLA
###  - Vector Multiply Negate Add Negation
val / ['/cond 11100 /D 01 /vn /vd 101 1 /N 1 /M 0 /vm'] = vc3bit VNMLA cond set1 set0 d vd set0 n vn set0 m vm
val / ['/cond 11100 /D 01 /vn /vd 101 0 /N 1 /M 0 /vm'] = vc3bit VNMLA cond set0 set1 d vd set1 n vn set1 m vm

### VNMLS
###  - Vector Multiply Add Negation
val / ['/cond 11100 /D 01 /vn /vd 101 1 /N 0 /M 0 /vm'] = vc3bit VNMLS cond set1 set0 d vd set0 n vn set0 m vm
val / ['/cond 11100 /D 01 /vn /vd 101 0 /N 0 /M 0 /vm'] = vc3bit VNMLS cond set0 set1 d vd set1 n vn set1 m vm

### VNMUL
###  - Vector Multiply Negate
val / ['/cond 11100 /D 10 /vn /vd 101 1 /N 1 /M 0 /vm'] = vc3bit VNMUL cond set1 set0 d vd set0 n vn set0 m vm
val / ['/cond 11100 /D 10 /vn /vd 101 0 /N 1 /M 0 /vm'] = vc3bit VNMUL cond set0 set1 d vd set1 n vn set1 m vm

### VFNMA
###  - Vector Fused Multiply Accumulate
val / ['/cond 11101 /D 01 /vn /vd 101 1 /N 1 /M 0 /vm'] = vc3bit VFNMA cond set1 set0 d vd set0 n vn set0 m vm
val / ['/cond 11101 /D 01 /vn /vd 101 0 /N 1 /M 0 /vm'] = vc3bit VFNMA cond set0 set1 d vd set1 n vn set1 m vm

### VFNMS
###  - Vector Fused Multiply Subtract
val / ['/cond 11101 /D 01 /vn /vd 101 1 /N 0 /M 0 /vm'] = vc3bit VFNMS cond set1 set0 d vd set0 n vn set0 m vm
val / ['/cond 11101 /D 01 /vn /vd 101 0 /N 0 /M 0 /vm'] = vc3bit VFNMS cond set0 set1 d vd set1 n vn set1 m vm

### VSQRT
###  - Vector Square Root
val / ['/cond 11101 /D 11 0001 /vd 101 1 11 /M 0 /vm'] = vc2bit VSQRT cond set1 set0 d vd set0 m vm
val / ['/cond 11101 /D 11 0001 /vd 101 0 11 /M 0 /vm'] = vc2bit VSQRT cond set0 set1 d vd set1 m vm

### VSUB (floating-point)
###  - Vector Subtract floating-point (Encoding A2)
val / ['/cond 1110 0 /D 11 /vn /vd 101 1 /N 1 /M 0 /vm'] = vc3bit VSUBfpfp cond set1 set0 d vd set0 n vn set0 m vm
val / ['/cond 1110 0 /D 11 /vn /vd 101 0 /N 1 /M 0 /vm'] = vc3bit VSUBfpfp cond set0 set1 d vd set1 n vn set1 m vm