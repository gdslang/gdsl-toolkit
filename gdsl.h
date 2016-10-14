#include "config.h"
#define GDSL_NO_PREFIX

#ifdef USE_X86
#include "gdsl-x86.h"
#elif USE_X86_RREIL
#include "gdsl-x86-rreil.h"
#elif USE_AVR
#include "gdsl-avr.h"
#elif USE_AVR_RREIL
#include "gdsl-avr-rreil.h"
#elif USE_MIPS
#include "gdsl-mips.h"
#elif USE_MIPS_RREIL
#include "gdsl-mips-rreil.h"
#elif USE_ARM7_RREIL
#include "gdsl-arm7-rreil.h"
#endif
 

