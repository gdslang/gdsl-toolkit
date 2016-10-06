/*
 * This file contains architecture-specific definitions for x86.
 * It can be used for testing where architecture-specific
 * comparison objects need to be built.
 */

#pragma once

#include <string>

namespace gdsl {

/*
 * This enumeration contains all x86 RReil register, including
 * the RReil-specific additions.
 */
enum class x86_rreil_register {
  IP,
  FLAGS,
  MXCSR,
  A,
  B,
  C,
  D,
  SI,
  DI,
  SP,
  BP,
  R8,
  R9,
  R10,
  R11,
  R12,
  R13,
  R14,
  R15,
  CS,
  DS,
  SS,
  ES,
  FS,
  GS,
  CS_Base,
  DS_Base,
  SS_Base,
  ES_Base,
  FS_Base,
  GS_Base,
  ST0,
  ST1,
  ST2,
  ST3,
  ST4,
  ST5,
  ST6,
  ST7,
  MM0,
  MM1,
  MM2,
  MM3,
  MM4,
  MM5,
  MM6,
  MM7,
  XMM0,
  XMM1,
  XMM2,
  XMM3,
  XMM4,
  XMM5,
  XMM6,
  XMM7,
  XMM8,
  XMM9,
  XMM10,
  XMM11,
  XMM12,
  XMM13,
  XMM14,
  XMM15,
  VIRT_LES,
  VIRT_LEU,
  VIRT_LTS
};

char const* to_string(x86_rreil_register reg);

/*
 * This enumeration contains x86 registers in the form that store
 * their size and offset in the name.
 */
enum class x86_register {
  IP,
  EIP,
  RIP,
  FLAGS,
  EFLAGS,
  RFLAGS,
  AL,
  AH,
  AX,
  EAX,
  RAX,
  BL,
  BH,
  BX,
  EBX,
  RBX,
  CL,
  CH,
  CX,
  ECX,
  RCX,
  DL,
  DH,
  DX,
  EDX,
  RDX,
  SIL,
  SI,
  ESI,
  RSI,
  DIL,
  DI,
  EDI,
  RDI,
  BPL,
  BP,
  EBP,
  RBP,
  SPL,
  SP,
  ESP,
  RSP,
  R8L,
  R8W,
  R8D,
  R8,
  R9L,
  R9W,
  R9D,
  R9,
  R10L,
  R10W,
  R10D,
  R10,
  R11L,
  R11W,
  R11D,
  R11,
  R12L,
  R12W,
  R12D,
  R12,
  R13L,
  R13W,
  R13D,
  R13,
  R14L,
  R14W,
  R14D,
  R14,
  R15L,
  R15W,
  R15D,
  R15,
  MM0,
  MM1,
  MM2,
  MM3,
  MM4,
  MM5,
  MM6,
  MM7,
  XMM0,
  XMM1,
  XMM2,
  XMM3,
  XMM4,
  XMM5,
  XMM6,
  XMM7,
  XMM8,
  XMM9,
  XMM10,
  XMM11,
  XMM12,
  XMM13,
  XMM14,
  XMM15,
  YMM0,
  YMM1,
  YMM2,
  YMM3,
  YMM4,
  YMM5,
  YMM6,
  YMM7,
  YMM8,
  YMM9,
  YMM10,
  YMM11,
  YMM12,
  YMM13,
  YMM14,
  YMM15,
  ST0,
  ST1,
  ST2,
  ST3,
  ST4,
  ST5,
  ST6,
  ST7,
};

/*
 * The x86_reg_desc describes an x86 register of the
 * well-known form containing its size and offset in the
 * name using the corresponding RReil register, its size
 * in bits and its offset in bits.
 *
 * For example, the x86 register AH is a fragment of
 * the register A starting at offset 8 bits with a size
 * of 8 bits.
 */
struct x86_reg_desc {
  /*
   * The corresponding RReil register.
   */
  const x86_rreil_register register_;
  /*
   * The size of register fragment in bits.
   */
  const int bit_size;
  /*
   * The offset of the register fragment in
   * bits.
   */
  const int bit_offset;

  x86_reg_desc(x86_rreil_register register_, int bit_size, int bit_offset)
      : register_(register_), bit_size(bit_size), bit_offset(bit_offset) {}
};

/*
 * Returns the string representation of the register
 */
char const* to_string(x86_register reg);
/*
 * Converts the x86 register to the corresponding
 * x86_reg_desc structure.
 */
x86_reg_desc desc_of(x86_register reg);

}  // namespace gdsl
