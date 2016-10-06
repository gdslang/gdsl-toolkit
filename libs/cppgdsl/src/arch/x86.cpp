#include "cppgdsl/arch/x86.h"

#include <assert.h>

namespace gdsl {

char const* to_string(x86_rreil_register reg) {
  switch (reg) {
    case x86_rreil_register::IP: {
      return "IP";
    }
    case x86_rreil_register::FLAGS: {
      return "FLAGS";
    }
    case x86_rreil_register::MXCSR: {
      return "MXCSR";
    }
    case x86_rreil_register::A: {
      return "A";
    }
    case x86_rreil_register::B: {
      return "B";
    }
    case x86_rreil_register::C: {
      return "C";
    }
    case x86_rreil_register::D: {
      return "D";
    }
    case x86_rreil_register::SI: {
      return "SI";
    }
    case x86_rreil_register::DI: {
      return "DI";
    }
    case x86_rreil_register::SP: {
      return "SP";
    }
    case x86_rreil_register::BP: {
      return "BP";
    }
    case x86_rreil_register::R8: {
      return "R8";
    }
    case x86_rreil_register::R9: {
      return "R9";
    }
    case x86_rreil_register::R10: {
      return "R10";
    }
    case x86_rreil_register::R11: {
      return "R11";
    }
    case x86_rreil_register::R12: {
      return "R12";
    }
    case x86_rreil_register::R13: {
      return "R13";
    }
    case x86_rreil_register::R14: {
      return "R14";
    }
    case x86_rreil_register::R15: {
      return "R15";
    }
    case x86_rreil_register::CS: {
      return "CS";
    }
    case x86_rreil_register::DS: {
      return "DS";
    }
    case x86_rreil_register::SS: {
      return "SS";
    }
    case x86_rreil_register::ES: {
      return "ES";
    }
    case x86_rreil_register::FS: {
      return "FS";
    }
    case x86_rreil_register::GS: {
      return "GS";
    }
    case x86_rreil_register::CS_Base: {
      return "CS_Base";
    }
    case x86_rreil_register::DS_Base: {
      return "DS_Base";
    }
    case x86_rreil_register::SS_Base: {
      return "SS_Base";
    }
    case x86_rreil_register::ES_Base: {
      return "ES_Base";
    }
    case x86_rreil_register::FS_Base: {
      return "FS_Base";
    }
    case x86_rreil_register::GS_Base: {
      return "GS_Base";
    }
    case x86_rreil_register::ST0: {
      return "ST0";
    }
    case x86_rreil_register::ST1: {
      return "ST1";
    }
    case x86_rreil_register::ST2: {
      return "ST2";
    }
    case x86_rreil_register::ST3: {
      return "ST3";
    }
    case x86_rreil_register::ST4: {
      return "ST4";
    }
    case x86_rreil_register::ST5: {
      return "ST5";
    }
    case x86_rreil_register::ST6: {
      return "ST6";
    }
    case x86_rreil_register::ST7: {
      return "ST7";
    }
    case x86_rreil_register::MM0: {
      return "MM0";
    }
    case x86_rreil_register::MM1: {
      return "MM1";
    }
    case x86_rreil_register::MM2: {
      return "MM2";
    }
    case x86_rreil_register::MM3: {
      return "MM3";
    }
    case x86_rreil_register::MM4: {
      return "MM4";
    }
    case x86_rreil_register::MM5: {
      return "MM5";
    }
    case x86_rreil_register::MM6: {
      return "MM6";
    }
    case x86_rreil_register::MM7: {
      return "MM7";
    }
    case x86_rreil_register::XMM0: {
      return "XMM0";
    }
    case x86_rreil_register::XMM1: {
      return "XMM1";
    }
    case x86_rreil_register::XMM2: {
      return "XMM2";
    }
    case x86_rreil_register::XMM3: {
      return "XMM3";
    }
    case x86_rreil_register::XMM4: {
      return "XMM4";
    }
    case x86_rreil_register::XMM5: {
      return "XMM5";
    }
    case x86_rreil_register::XMM6: {
      return "XMM6";
    }
    case x86_rreil_register::XMM7: {
      return "XMM7";
    }
    case x86_rreil_register::XMM8: {
      return "XMM8";
    }
    case x86_rreil_register::XMM9: {
      return "XMM9";
    }
    case x86_rreil_register::XMM10: {
      return "XMM10";
    }
    case x86_rreil_register::XMM11: {
      return "XMM11";
    }
    case x86_rreil_register::XMM12: {
      return "XMM12";
    }
    case x86_rreil_register::XMM13: {
      return "XMM13";
    }
    case x86_rreil_register::XMM14: {
      return "XMM14";
    }
    case x86_rreil_register::XMM15: {
      return "XMM15";
    }
    case x86_rreil_register::VIRT_LES: {
      return "VIRT_LES";
    }
    case x86_rreil_register::VIRT_LEU: {
      return "VIRT_LEU";
    }
    case x86_rreil_register::VIRT_LTS: {
      return "VIRT_LTS";
    }
  }
  assert(false);  // Must not ever be reached
  return nullptr;
}

char const* to_string(x86_register reg) {
  switch (reg) {
    case x86_register::IP: {
      return "IP";
    }
    case x86_register::EIP: {
      return "EIP";
    }
    case x86_register::RIP: {
      return "RIP";
    }
    case x86_register::FLAGS: {
      return "FLAGS";
    }
    case x86_register::EFLAGS: {
      return "EFLAGS";
    }
    case x86_register::RFLAGS: {
      return "RFLAGS";
    }
    case x86_register::AL: {
      return "AL";
    }
    case x86_register::AH: {
      return "AH";
    }
    case x86_register::AX: {
      return "AX";
    }
    case x86_register::EAX: {
      return "EAX";
    }
    case x86_register::RAX: {
      return "RAX";
    }
    case x86_register::BL: {
      return "BL";
    }
    case x86_register::BH: {
      return "BH";
    }
    case x86_register::BX: {
      return "BX";
    }
    case x86_register::EBX: {
      return "EBX";
    }
    case x86_register::RBX: {
      return "RBX";
    }
    case x86_register::CL: {
      return "CL";
    }
    case x86_register::CH: {
      return "CH";
    }
    case x86_register::CX: {
      return "CX";
    }
    case x86_register::ECX: {
      return "ECX";
    }
    case x86_register::RCX: {
      return "RCX";
    }
    case x86_register::DL: {
      return "DL";
    }
    case x86_register::DH: {
      return "DH";
    }
    case x86_register::DX: {
      return "DX";
    }
    case x86_register::EDX: {
      return "EDX";
    }
    case x86_register::RDX: {
      return "RDX";
    }
    case x86_register::SIL: {
      return "SIL";
    }
    case x86_register::SI: {
      return "SI";
    }
    case x86_register::ESI: {
      return "ESI";
    }
    case x86_register::RSI: {
      return "RSI";
    }
    case x86_register::DIL: {
      return "DIL";
    }
    case x86_register::DI: {
      return "DI";
    }
    case x86_register::EDI: {
      return "EDI";
    }
    case x86_register::RDI: {
      return "RDI";
    }
    case x86_register::BPL: {
      return "BPL";
    }
    case x86_register::BP: {
      return "BP";
    }
    case x86_register::EBP: {
      return "EBP";
    }
    case x86_register::RBP: {
      return "RBP";
    }
    case x86_register::SPL: {
      return "SPL";
    }
    case x86_register::SP: {
      return "SP";
    }
    case x86_register::ESP: {
      return "ESP";
    }
    case x86_register::RSP: {
      return "RSP";
    }
    case x86_register::R8L: {
      return "R8L";
    }
    case x86_register::R8W: {
      return "R8W";
    }
    case x86_register::R8D: {
      return "R8D";
    }
    case x86_register::R8: {
      return "R8";
    }
    case x86_register::R9L: {
      return "R9L";
    }
    case x86_register::R9W: {
      return "R9W";
    }
    case x86_register::R9D: {
      return "R9D";
    }
    case x86_register::R9: {
      return "R9";
    }
    case x86_register::R10L: {
      return "R10L";
    }
    case x86_register::R10W: {
      return "R10W";
    }
    case x86_register::R10D: {
      return "R10D";
    }
    case x86_register::R10: {
      return "R10";
    }
    case x86_register::R11L: {
      return "R11L";
    }
    case x86_register::R11W: {
      return "R11W";
    }
    case x86_register::R11D: {
      return "R11D";
    }
    case x86_register::R11: {
      return "R11";
    }
    case x86_register::R12L: {
      return "R12L";
    }
    case x86_register::R12W: {
      return "R12W";
    }
    case x86_register::R12D: {
      return "R12D";
    }
    case x86_register::R12: {
      return "R12";
    }
    case x86_register::R13L: {
      return "R13L";
    }
    case x86_register::R13W: {
      return "R13W";
    }
    case x86_register::R13D: {
      return "R13D";
    }
    case x86_register::R13: {
      return "R13";
    }
    case x86_register::R14L: {
      return "R14L";
    }
    case x86_register::R14W: {
      return "R14W";
    }
    case x86_register::R14D: {
      return "R14D";
    }
    case x86_register::R14: {
      return "R14";
    }
    case x86_register::R15L: {
      return "R15L";
    }
    case x86_register::R15W: {
      return "R15W";
    }
    case x86_register::R15D: {
      return "R15D";
    }
    case x86_register::R15: {
      return "R15";
    }
    case x86_register::MM0: {
      return "MM0";
    }
    case x86_register::MM1: {
      return "MM1";
    }
    case x86_register::MM2: {
      return "MM2";
    }
    case x86_register::MM3: {
      return "MM3";
    }
    case x86_register::MM4: {
      return "MM4";
    }
    case x86_register::MM5: {
      return "MM5";
    }
    case x86_register::MM6: {
      return "MM6";
    }
    case x86_register::MM7: {
      return "MM7";
    }
    case x86_register::XMM0: {
      return "XMM0";
    }
    case x86_register::XMM1: {
      return "XMM1";
    }
    case x86_register::XMM2: {
      return "XMM2";
    }
    case x86_register::XMM3: {
      return "XMM3";
    }
    case x86_register::XMM4: {
      return "XMM4";
    }
    case x86_register::XMM5: {
      return "XMM5";
    }
    case x86_register::XMM6: {
      return "XMM6";
    }
    case x86_register::XMM7: {
      return "XMM7";
    }
    case x86_register::XMM8: {
      return "XMM8";
    }
    case x86_register::XMM9: {
      return "XMM9";
    }
    case x86_register::XMM10: {
      return "XMM10";
    }
    case x86_register::XMM11: {
      return "XMM11";
    }
    case x86_register::XMM12: {
      return "XMM12";
    }
    case x86_register::XMM13: {
      return "XMM13";
    }
    case x86_register::XMM14: {
      return "XMM14";
    }
    case x86_register::XMM15: {
      return "XMM15";
    }
    case x86_register::YMM0: {
      return "YMM0";
    }
    case x86_register::YMM1: {
      return "YMM1";
    }
    case x86_register::YMM2: {
      return "YMM2";
    }
    case x86_register::YMM3: {
      return "YMM3";
    }
    case x86_register::YMM4: {
      return "YMM4";
    }
    case x86_register::YMM5: {
      return "YMM5";
    }
    case x86_register::YMM6: {
      return "YMM6";
    }
    case x86_register::YMM7: {
      return "YMM7";
    }
    case x86_register::YMM8: {
      return "YMM8";
    }
    case x86_register::YMM9: {
      return "YMM9";
    }
    case x86_register::YMM10: {
      return "YMM10";
    }
    case x86_register::YMM11: {
      return "YMM11";
    }
    case x86_register::YMM12: {
      return "YMM12";
    }
    case x86_register::YMM13: {
      return "YMM13";
    }
    case x86_register::YMM14: {
      return "YMM14";
    }
    case x86_register::YMM15: {
      return "YMM15";
    }
    case x86_register::ST0: {
      return "ST0";
    }
    case x86_register::ST1: {
      return "ST1";
    }
    case x86_register::ST2: {
      return "ST2";
    }
    case x86_register::ST3: {
      return "ST3";
    }
    case x86_register::ST4: {
      return "ST4";
    }
    case x86_register::ST5: {
      return "ST5";
    }
    case x86_register::ST6: {
      return "ST6";
    }
    case x86_register::ST7: {
      return "ST7";
    }
  }
  assert(false);  // Must not ever be reached
  return nullptr;
}

x86_reg_desc desc_of(x86_register reg) {
  /*
   * From x86-semantics-mapping.ml, using
   * %s/ | \(\S*\)\s*: {id=Sem_\(\w*\),\s*offset=\(\w*\),\s*size=\(\w*\)}/case
   * x86_register::\1: { return x86_reg_desc(x86_rreil_register::\2, \4, \3);
   * }/g
   */
  switch (reg) {
    case x86_register::IP: {
      return x86_reg_desc(x86_rreil_register::IP, 16, 0);
    }
    case x86_register::EIP: {
      return x86_reg_desc(x86_rreil_register::IP, 32, 0);
    }
    case x86_register::RIP: {
      return x86_reg_desc(x86_rreil_register::IP, 64, 0);
    }
    case x86_register::FLAGS: {
      return x86_reg_desc(x86_rreil_register::FLAGS, 16, 0);
    }
    case x86_register::EFLAGS: {
      return x86_reg_desc(x86_rreil_register::FLAGS, 32, 0);
    }
    case x86_register::RFLAGS: {
      return x86_reg_desc(x86_rreil_register::FLAGS, 64, 0);
    }
    case x86_register::AL: {
      return x86_reg_desc(x86_rreil_register::A, 8, 0);
    }
    case x86_register::AH: {
      return x86_reg_desc(x86_rreil_register::A, 8, 8);
    }
    case x86_register::AX: {
      return x86_reg_desc(x86_rreil_register::A, 16, 0);
    }
    case x86_register::EAX: {
      return x86_reg_desc(x86_rreil_register::A, 32, 0);
    }
    case x86_register::RAX: {
      return x86_reg_desc(x86_rreil_register::A, 64, 0);
    }
    case x86_register::BL: {
      return x86_reg_desc(x86_rreil_register::B, 8, 0);
    }
    case x86_register::BH: {
      return x86_reg_desc(x86_rreil_register::B, 8, 8);
    }
    case x86_register::BX: {
      return x86_reg_desc(x86_rreil_register::B, 16, 0);
    }
    case x86_register::EBX: {
      return x86_reg_desc(x86_rreil_register::B, 32, 0);
    }
    case x86_register::RBX: {
      return x86_reg_desc(x86_rreil_register::B, 64, 0);
    }
    case x86_register::CL: {
      return x86_reg_desc(x86_rreil_register::C, 8, 0);
    }
    case x86_register::CH: {
      return x86_reg_desc(x86_rreil_register::C, 8, 8);
    }
    case x86_register::CX: {
      return x86_reg_desc(x86_rreil_register::C, 16, 0);
    }
    case x86_register::ECX: {
      return x86_reg_desc(x86_rreil_register::C, 32, 0);
    }
    case x86_register::RCX: {
      return x86_reg_desc(x86_rreil_register::C, 64, 0);
    }
    case x86_register::DL: {
      return x86_reg_desc(x86_rreil_register::D, 8, 0);
    }
    case x86_register::DH: {
      return x86_reg_desc(x86_rreil_register::D, 8, 8);
    }
    case x86_register::DX: {
      return x86_reg_desc(x86_rreil_register::D, 16, 0);
    }
    case x86_register::EDX: {
      return x86_reg_desc(x86_rreil_register::D, 32, 0);
    }
    case x86_register::RDX: {
      return x86_reg_desc(x86_rreil_register::D, 64, 0);
    }
    case x86_register::R8L: {
      return x86_reg_desc(x86_rreil_register::R8, 8, 0);
    }
    case x86_register::R8W: {
      return x86_reg_desc(x86_rreil_register::R8, 16, 0);
    }
    case x86_register::R8D: {
      return x86_reg_desc(x86_rreil_register::R8, 32, 0);
    }
    case x86_register::R8: {
      return x86_reg_desc(x86_rreil_register::R8, 64, 0);
    }
    case x86_register::R9L: {
      return x86_reg_desc(x86_rreil_register::R9, 8, 0);
    }
    case x86_register::R9W: {
      return x86_reg_desc(x86_rreil_register::R9, 16, 0);
    }
    case x86_register::R9D: {
      return x86_reg_desc(x86_rreil_register::R9, 32, 0);
    }
    case x86_register::R9: {
      return x86_reg_desc(x86_rreil_register::R9, 64, 0);
    }
    case x86_register::R10L: {
      return x86_reg_desc(x86_rreil_register::R10, 8, 0);
    }
    case x86_register::R10W: {
      return x86_reg_desc(x86_rreil_register::R10, 16, 0);
    }
    case x86_register::R10D: {
      return x86_reg_desc(x86_rreil_register::R10, 32, 0);
    }
    case x86_register::R10: {
      return x86_reg_desc(x86_rreil_register::R10, 64, 0);
    }
    case x86_register::R11L: {
      return x86_reg_desc(x86_rreil_register::R11, 8, 0);
    }
    case x86_register::R11W: {
      return x86_reg_desc(x86_rreil_register::R11, 16, 0);
    }
    case x86_register::R11D: {
      return x86_reg_desc(x86_rreil_register::R11, 32, 0);
    }
    case x86_register::R11: {
      return x86_reg_desc(x86_rreil_register::R11, 64, 0);
    }
    case x86_register::R12L: {
      return x86_reg_desc(x86_rreil_register::R12, 8, 0);
    }
    case x86_register::R12W: {
      return x86_reg_desc(x86_rreil_register::R12, 16, 0);
    }
    case x86_register::R12D: {
      return x86_reg_desc(x86_rreil_register::R12, 32, 0);
    }
    case x86_register::R12: {
      return x86_reg_desc(x86_rreil_register::R12, 64, 0);
    }
    case x86_register::R13L: {
      return x86_reg_desc(x86_rreil_register::R13, 8, 0);
    }
    case x86_register::R13W: {
      return x86_reg_desc(x86_rreil_register::R13, 16, 0);
    }
    case x86_register::R13D: {
      return x86_reg_desc(x86_rreil_register::R13, 32, 0);
    }
    case x86_register::R13: {
      return x86_reg_desc(x86_rreil_register::R13, 64, 0);
    }
    case x86_register::R14L: {
      return x86_reg_desc(x86_rreil_register::R14, 8, 0);
    }
    case x86_register::R14W: {
      return x86_reg_desc(x86_rreil_register::R14, 16, 0);
    }
    case x86_register::R14D: {
      return x86_reg_desc(x86_rreil_register::R14, 32, 0);
    }
    case x86_register::R14: {
      return x86_reg_desc(x86_rreil_register::R14, 64, 0);
    }
    case x86_register::R15L: {
      return x86_reg_desc(x86_rreil_register::R15, 8, 0);
    }
    case x86_register::R15W: {
      return x86_reg_desc(x86_rreil_register::R15, 16, 0);
    }
    case x86_register::R15D: {
      return x86_reg_desc(x86_rreil_register::R15, 32, 0);
    }
    case x86_register::R15: {
      return x86_reg_desc(x86_rreil_register::R15, 64, 0);
    }
    case x86_register::SPL: {
      return x86_reg_desc(x86_rreil_register::SP, 8, 0);
    }
    case x86_register::SP: {
      return x86_reg_desc(x86_rreil_register::SP, 16, 0);
    }
    case x86_register::ESP: {
      return x86_reg_desc(x86_rreil_register::SP, 32, 0);
    }
    case x86_register::RSP: {
      return x86_reg_desc(x86_rreil_register::SP, 64, 0);
    }
    case x86_register::BPL: {
      return x86_reg_desc(x86_rreil_register::BP, 8, 0);
    }
    case x86_register::BP: {
      return x86_reg_desc(x86_rreil_register::BP, 16, 0);
    }
    case x86_register::EBP: {
      return x86_reg_desc(x86_rreil_register::BP, 32, 0);
    }
    case x86_register::RBP: {
      return x86_reg_desc(x86_rreil_register::BP, 64, 0);
    }
    case x86_register::SIL: {
      return x86_reg_desc(x86_rreil_register::SI, 8, 0);
    }
    case x86_register::SI: {
      return x86_reg_desc(x86_rreil_register::SI, 16, 0);
    }
    case x86_register::ESI: {
      return x86_reg_desc(x86_rreil_register::SI, 32, 0);
    }
    case x86_register::RSI: {
      return x86_reg_desc(x86_rreil_register::SI, 64, 0);
    }
    case x86_register::DIL: {
      return x86_reg_desc(x86_rreil_register::DI, 8, 0);
    }
    case x86_register::DI: {
      return x86_reg_desc(x86_rreil_register::DI, 16, 0);
    }
    case x86_register::EDI: {
      return x86_reg_desc(x86_rreil_register::DI, 32, 0);
    }
    case x86_register::RDI: {
      return x86_reg_desc(x86_rreil_register::DI, 64, 0);
    }
    case x86_register::XMM0: {
      return x86_reg_desc(x86_rreil_register::XMM0, 128, 0);
    }
    case x86_register::XMM1: {
      return x86_reg_desc(x86_rreil_register::XMM1, 128, 0);
    }
    case x86_register::XMM2: {
      return x86_reg_desc(x86_rreil_register::XMM2, 128, 0);
    }
    case x86_register::XMM3: {
      return x86_reg_desc(x86_rreil_register::XMM3, 128, 0);
    }
    case x86_register::XMM4: {
      return x86_reg_desc(x86_rreil_register::XMM4, 128, 0);
    }
    case x86_register::XMM5: {
      return x86_reg_desc(x86_rreil_register::XMM5, 128, 0);
    }
    case x86_register::XMM6: {
      return x86_reg_desc(x86_rreil_register::XMM6, 128, 0);
    }
    case x86_register::XMM7: {
      return x86_reg_desc(x86_rreil_register::XMM7, 128, 0);
    }
    case x86_register::XMM8: {
      return x86_reg_desc(x86_rreil_register::XMM8, 128, 0);
    }
    case x86_register::XMM9: {
      return x86_reg_desc(x86_rreil_register::XMM9, 128, 0);
    }
    case x86_register::XMM10: {
      return x86_reg_desc(x86_rreil_register::XMM10, 128, 0);
    }
    case x86_register::XMM11: {
      return x86_reg_desc(x86_rreil_register::XMM11, 128, 0);
    }
    case x86_register::XMM12: {
      return x86_reg_desc(x86_rreil_register::XMM12, 128, 0);
    }
    case x86_register::XMM13: {
      return x86_reg_desc(x86_rreil_register::XMM13, 128, 0);
    }
    case x86_register::XMM14: {
      return x86_reg_desc(x86_rreil_register::XMM14, 128, 0);
    }
    case x86_register::XMM15: {
      return x86_reg_desc(x86_rreil_register::XMM15, 128, 0);
    }
    case x86_register::YMM0: {
      return x86_reg_desc(x86_rreil_register::XMM0, 256, 0);
    }
    case x86_register::YMM1: {
      return x86_reg_desc(x86_rreil_register::XMM1, 256, 0);
    }
    case x86_register::YMM2: {
      return x86_reg_desc(x86_rreil_register::XMM2, 256, 0);
    }
    case x86_register::YMM3: {
      return x86_reg_desc(x86_rreil_register::XMM3, 256, 0);
    }
    case x86_register::YMM4: {
      return x86_reg_desc(x86_rreil_register::XMM4, 256, 0);
    }
    case x86_register::YMM5: {
      return x86_reg_desc(x86_rreil_register::XMM5, 256, 0);
    }
    case x86_register::YMM6: {
      return x86_reg_desc(x86_rreil_register::XMM6, 256, 0);
    }
    case x86_register::YMM7: {
      return x86_reg_desc(x86_rreil_register::XMM7, 256, 0);
    }
    case x86_register::YMM8: {
      return x86_reg_desc(x86_rreil_register::XMM8, 256, 0);
    }
    case x86_register::YMM9: {
      return x86_reg_desc(x86_rreil_register::XMM9, 256, 0);
    }
    case x86_register::YMM10: {
      return x86_reg_desc(x86_rreil_register::XMM10, 256, 0);
    }
    case x86_register::YMM11: {
      return x86_reg_desc(x86_rreil_register::XMM11, 256, 0);
    }
    case x86_register::YMM12: {
      return x86_reg_desc(x86_rreil_register::XMM12, 256, 0);
    }
    case x86_register::YMM13: {
      return x86_reg_desc(x86_rreil_register::XMM13, 256, 0);
    }
    case x86_register::YMM14: {
      return x86_reg_desc(x86_rreil_register::XMM14, 256, 0);
    }
    case x86_register::YMM15: {
      return x86_reg_desc(x86_rreil_register::XMM15, 256, 0);
    }
    case x86_register::MM0: {
      return x86_reg_desc(x86_rreil_register::MM0, 64, 0);
    }
    case x86_register::MM1: {
      return x86_reg_desc(x86_rreil_register::MM1, 64, 0);
    }
    case x86_register::MM2: {
      return x86_reg_desc(x86_rreil_register::MM2, 64, 0);
    }
    case x86_register::MM3: {
      return x86_reg_desc(x86_rreil_register::MM3, 64, 0);
    }
    case x86_register::MM4: {
      return x86_reg_desc(x86_rreil_register::MM4, 64, 0);
    }
    case x86_register::MM5: {
      return x86_reg_desc(x86_rreil_register::MM5, 64, 0);
    }
    case x86_register::MM6: {
      return x86_reg_desc(x86_rreil_register::MM6, 64, 0);
    }
    case x86_register::MM7: {
      return x86_reg_desc(x86_rreil_register::MM7, 64, 0);
    }
    case x86_register::ST0: {
      return x86_reg_desc(x86_rreil_register::ST0, 80, 0);
    }
    case x86_register::ST1: {
      return x86_reg_desc(x86_rreil_register::ST1, 80, 0);
    }
    case x86_register::ST2: {
      return x86_reg_desc(x86_rreil_register::ST2, 80, 0);
    }
    case x86_register::ST3: {
      return x86_reg_desc(x86_rreil_register::ST3, 80, 0);
    }
    case x86_register::ST4: {
      return x86_reg_desc(x86_rreil_register::ST4, 80, 0);
    }
    case x86_register::ST5: {
      return x86_reg_desc(x86_rreil_register::ST5, 80, 0);
    }
    case x86_register::ST6: {
      return x86_reg_desc(x86_rreil_register::ST6, 80, 0);
    }
    case x86_register::ST7: {
      return x86_reg_desc(x86_rreil_register::ST7, 80, 0);
    }
  }
  assert(false);  // Must not ever be reached
  return x86_reg_desc(x86_rreil_register::IP, 0, 0);
}

}  // namespace gdsl
