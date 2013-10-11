/* vim:set ts=2:set sw=2:set expandtab: */
/* Auto-generated file. DO NOT EDIT. */
#ifndef __GDSL_RUNTIME_H
#define __GDSL_RUNTIME_H

#include <stdlib.h>
#include <stdint.h>
#include <setjmp.h>

/* data types used in decoder programs */
typedef void* obj_t;
typedef struct state* state_t;
typedef int64_t int_t;
typedef char* string_t;
typedef uint64_t vec_data_t;

struct vec {
  unsigned int size;
  vec_data_t data;
};

typedef struct vec vec_t;
typedef int_t con_tag_t;

#endif /* __GDSL_RUNTIME_H */

/* The following declarations are individual for each decoder. */
#ifndef __GDSL_MANUAL_H
#define __GDSL_MANUAL_H

/* Create a new decoder state. Should be destroyed by 
gdsl_destroy(). */
state_t 
gdsl_init(void);

/* Set the code buffer. The parameter base denotes the address that ip_get
   in GDSL returns when no bytes have been consumed. */
void 
gdsl_set_code(state_t s, char* buf, size_t buf_len, size_t base);

/* Query the offset of the current IP relative to base. */
size_t 
gdsl_get_ip_offset(state_t s);

/* Set the current code position to this address. */
int_t
gdsl_seek(state_t s, size_t i);

/* Adjust the current code position by this offset.
int_t
(state_t s, int_t i);
*/

/* An exception handler must be installed by calling setjmp with the argument
 * returned by this function.
 * If an exception occurs, control will return from setjmp with
 * value 1 if there are no more bytes in the input buffer or with
 * value 2 if there has been an error (e.g. pattern match failure). In
 * both cases, an error message can be retrieved using get_error_message().
 */
jmp_buf* 
gdsl_err_tgt(state_t s);

/* Retrieve the error message after an exception has been raised. */
char* 
gdsl_get_error_message(state_t s);

/* Reset the heap. Objects returned by exported function are no longer valid
   after a call to this funciton. This function does not necessarily
   deallocate all of the heap. */
void 
gdsl_reset_heap(state_t s);

/* Query the no of bytes currently allocated on the heap. */
size_t 
gdsl_heap_residency(state_t s);

/* Allocate a buffer on the heap and emit the given rope into it.
   Returns a pointer to the buffer on the heap. */
string_t
gdsl_merge_rope(state_t s, obj_t rope);

/* Frees the heap and the decoder state. */
void 
gdsl_destroy(state_t s);

/* Records that are represented as C structs. */
typedef struct {
  vec_t features;
} unboxed_struct6_t;
typedef unboxed_struct6_t* struct6_t;
/* Exported functions. */
obj_t gdsl_pretty(state_t s,obj_t i);
int_t gdsl_features_get(state_t s,struct6_t insn);
obj_t gdsl_decode(state_t s,int_t config);
int_t gdsl_config_default_opnd_sz_32(state_t s);
int_t gdsl_config_mode64(state_t s);
int_t gdsl_config_default(state_t s);
int_t gdsl_int_max(state_t s);
string_t gdsl_rope_to_string(state_t s,obj_t r,string_t buf);
void gdsl_rope_print(state_t s,obj_t r);
int_t gdsl_rope_length(state_t s,obj_t r);
#ifdef GDSL_NO_PREFIX
#define gdsl_init \
gdsl_init
#define gdsl_set_code \
gdsl_set_code
#define gdsl_get_ip_offset \
gdsl_get_ip_offset
#define gdsl_seek \
gdsl_seek
#define gdsl_err_tgt \
gdsl_err_tgt
#define gdsl_get_error_message \
gdsl_get_error_message
#define gdsl_reset_heap \
gdsl_reset_heap
#define gdsl_heap_residency \
gdsl_heap_residency
#define gdsl_merge_rope \
gdsl_merge_rope
#define gdsl_destroy \
gdsl_destroy
#define gdsl_pretty gdsl_pretty
#define gdsl_features_get gdsl_features_get
#define gdsl_decode gdsl_decode
#define gdsl_config_default_opnd_sz_32 gdsl_config_default_opnd_sz_32
#define gdsl_config_mode64 gdsl_config_mode64
#define gdsl_config_default gdsl_config_default
#define gdsl_int_max gdsl_int_max
#define gdsl_rope_to_string gdsl_rope_to_string
#define gdsl_rope_print gdsl_rope_print
#define gdsl_rope_length gdsl_rope_length
#endif

#endif /* __GDSL_MANUAL_H */

/* The following defines are accumulative. */

/* Exported tags of constructors. */
#ifdef CON_IO_NONE
  #if (CON_IO_NONE!=4)
    #error "merging GDSL libraries with incompatible definition for CON_IO_NONE."
  #endif
#else
  #define CON_IO_NONE 4
#endif
#ifdef CON_SEG_NONE
  #if (CON_SEG_NONE!=5)
    #error "merging GDSL libraries with incompatible definition for CON_SEG_NONE."
  #endif
#else
  #define CON_SEG_NONE 5
#endif
#ifdef CON_AL
  #if (CON_AL!=7)
    #error "merging GDSL libraries with incompatible definition for CON_AL."
  #endif
#else
  #define CON_AL 7
#endif
#ifdef CON_AH
  #if (CON_AH!=8)
    #error "merging GDSL libraries with incompatible definition for CON_AH."
  #endif
#else
  #define CON_AH 8
#endif
#ifdef CON_AX
  #if (CON_AX!=9)
    #error "merging GDSL libraries with incompatible definition for CON_AX."
  #endif
#else
  #define CON_AX 9
#endif
#ifdef CON_EAX
  #if (CON_EAX!=10)
    #error "merging GDSL libraries with incompatible definition for CON_EAX."
  #endif
#else
  #define CON_EAX 10
#endif
#ifdef CON_RAX
  #if (CON_RAX!=11)
    #error "merging GDSL libraries with incompatible definition for CON_RAX."
  #endif
#else
  #define CON_RAX 11
#endif
#ifdef CON_BL
  #if (CON_BL!=12)
    #error "merging GDSL libraries with incompatible definition for CON_BL."
  #endif
#else
  #define CON_BL 12
#endif
#ifdef CON_BH
  #if (CON_BH!=13)
    #error "merging GDSL libraries with incompatible definition for CON_BH."
  #endif
#else
  #define CON_BH 13
#endif
#ifdef CON_BX
  #if (CON_BX!=14)
    #error "merging GDSL libraries with incompatible definition for CON_BX."
  #endif
#else
  #define CON_BX 14
#endif
#ifdef CON_EBX
  #if (CON_EBX!=15)
    #error "merging GDSL libraries with incompatible definition for CON_EBX."
  #endif
#else
  #define CON_EBX 15
#endif
#ifdef CON_RBX
  #if (CON_RBX!=16)
    #error "merging GDSL libraries with incompatible definition for CON_RBX."
  #endif
#else
  #define CON_RBX 16
#endif
#ifdef CON_CL
  #if (CON_CL!=17)
    #error "merging GDSL libraries with incompatible definition for CON_CL."
  #endif
#else
  #define CON_CL 17
#endif
#ifdef CON_CH
  #if (CON_CH!=18)
    #error "merging GDSL libraries with incompatible definition for CON_CH."
  #endif
#else
  #define CON_CH 18
#endif
#ifdef CON_CX
  #if (CON_CX!=19)
    #error "merging GDSL libraries with incompatible definition for CON_CX."
  #endif
#else
  #define CON_CX 19
#endif
#ifdef CON_ECX
  #if (CON_ECX!=20)
    #error "merging GDSL libraries with incompatible definition for CON_ECX."
  #endif
#else
  #define CON_ECX 20
#endif
#ifdef CON_RCX
  #if (CON_RCX!=21)
    #error "merging GDSL libraries with incompatible definition for CON_RCX."
  #endif
#else
  #define CON_RCX 21
#endif
#ifdef CON_DL
  #if (CON_DL!=22)
    #error "merging GDSL libraries with incompatible definition for CON_DL."
  #endif
#else
  #define CON_DL 22
#endif
#ifdef CON_DH
  #if (CON_DH!=23)
    #error "merging GDSL libraries with incompatible definition for CON_DH."
  #endif
#else
  #define CON_DH 23
#endif
#ifdef CON_DX
  #if (CON_DX!=24)
    #error "merging GDSL libraries with incompatible definition for CON_DX."
  #endif
#else
  #define CON_DX 24
#endif
#ifdef CON_EDX
  #if (CON_EDX!=25)
    #error "merging GDSL libraries with incompatible definition for CON_EDX."
  #endif
#else
  #define CON_EDX 25
#endif
#ifdef CON_RDX
  #if (CON_RDX!=26)
    #error "merging GDSL libraries with incompatible definition for CON_RDX."
  #endif
#else
  #define CON_RDX 26
#endif
#ifdef CON_R8L
  #if (CON_R8L!=27)
    #error "merging GDSL libraries with incompatible definition for CON_R8L."
  #endif
#else
  #define CON_R8L 27
#endif
#ifdef CON_R8W
  #if (CON_R8W!=28)
    #error "merging GDSL libraries with incompatible definition for CON_R8W."
  #endif
#else
  #define CON_R8W 28
#endif
#ifdef CON_R8D
  #if (CON_R8D!=29)
    #error "merging GDSL libraries with incompatible definition for CON_R8D."
  #endif
#else
  #define CON_R8D 29
#endif
#ifdef CON_R8
  #if (CON_R8!=30)
    #error "merging GDSL libraries with incompatible definition for CON_R8."
  #endif
#else
  #define CON_R8 30
#endif
#ifdef CON_R9L
  #if (CON_R9L!=31)
    #error "merging GDSL libraries with incompatible definition for CON_R9L."
  #endif
#else
  #define CON_R9L 31
#endif
#ifdef CON_R9W
  #if (CON_R9W!=32)
    #error "merging GDSL libraries with incompatible definition for CON_R9W."
  #endif
#else
  #define CON_R9W 32
#endif
#ifdef CON_R9D
  #if (CON_R9D!=33)
    #error "merging GDSL libraries with incompatible definition for CON_R9D."
  #endif
#else
  #define CON_R9D 33
#endif
#ifdef CON_R9
  #if (CON_R9!=34)
    #error "merging GDSL libraries with incompatible definition for CON_R9."
  #endif
#else
  #define CON_R9 34
#endif
#ifdef CON_R10L
  #if (CON_R10L!=35)
    #error "merging GDSL libraries with incompatible definition for CON_R10L."
  #endif
#else
  #define CON_R10L 35
#endif
#ifdef CON_R10W
  #if (CON_R10W!=36)
    #error "merging GDSL libraries with incompatible definition for CON_R10W."
  #endif
#else
  #define CON_R10W 36
#endif
#ifdef CON_R10D
  #if (CON_R10D!=37)
    #error "merging GDSL libraries with incompatible definition for CON_R10D."
  #endif
#else
  #define CON_R10D 37
#endif
#ifdef CON_R10
  #if (CON_R10!=38)
    #error "merging GDSL libraries with incompatible definition for CON_R10."
  #endif
#else
  #define CON_R10 38
#endif
#ifdef CON_R11L
  #if (CON_R11L!=39)
    #error "merging GDSL libraries with incompatible definition for CON_R11L."
  #endif
#else
  #define CON_R11L 39
#endif
#ifdef CON_R11W
  #if (CON_R11W!=40)
    #error "merging GDSL libraries with incompatible definition for CON_R11W."
  #endif
#else
  #define CON_R11W 40
#endif
#ifdef CON_R11D
  #if (CON_R11D!=41)
    #error "merging GDSL libraries with incompatible definition for CON_R11D."
  #endif
#else
  #define CON_R11D 41
#endif
#ifdef CON_R11
  #if (CON_R11!=42)
    #error "merging GDSL libraries with incompatible definition for CON_R11."
  #endif
#else
  #define CON_R11 42
#endif
#ifdef CON_R12L
  #if (CON_R12L!=43)
    #error "merging GDSL libraries with incompatible definition for CON_R12L."
  #endif
#else
  #define CON_R12L 43
#endif
#ifdef CON_R12W
  #if (CON_R12W!=44)
    #error "merging GDSL libraries with incompatible definition for CON_R12W."
  #endif
#else
  #define CON_R12W 44
#endif
#ifdef CON_R12D
  #if (CON_R12D!=45)
    #error "merging GDSL libraries with incompatible definition for CON_R12D."
  #endif
#else
  #define CON_R12D 45
#endif
#ifdef CON_R12
  #if (CON_R12!=46)
    #error "merging GDSL libraries with incompatible definition for CON_R12."
  #endif
#else
  #define CON_R12 46
#endif
#ifdef CON_R13L
  #if (CON_R13L!=47)
    #error "merging GDSL libraries with incompatible definition for CON_R13L."
  #endif
#else
  #define CON_R13L 47
#endif
#ifdef CON_R13W
  #if (CON_R13W!=48)
    #error "merging GDSL libraries with incompatible definition for CON_R13W."
  #endif
#else
  #define CON_R13W 48
#endif
#ifdef CON_R13D
  #if (CON_R13D!=49)
    #error "merging GDSL libraries with incompatible definition for CON_R13D."
  #endif
#else
  #define CON_R13D 49
#endif
#ifdef CON_R13
  #if (CON_R13!=50)
    #error "merging GDSL libraries with incompatible definition for CON_R13."
  #endif
#else
  #define CON_R13 50
#endif
#ifdef CON_R14L
  #if (CON_R14L!=51)
    #error "merging GDSL libraries with incompatible definition for CON_R14L."
  #endif
#else
  #define CON_R14L 51
#endif
#ifdef CON_R14W
  #if (CON_R14W!=52)
    #error "merging GDSL libraries with incompatible definition for CON_R14W."
  #endif
#else
  #define CON_R14W 52
#endif
#ifdef CON_R14D
  #if (CON_R14D!=53)
    #error "merging GDSL libraries with incompatible definition for CON_R14D."
  #endif
#else
  #define CON_R14D 53
#endif
#ifdef CON_R14
  #if (CON_R14!=54)
    #error "merging GDSL libraries with incompatible definition for CON_R14."
  #endif
#else
  #define CON_R14 54
#endif
#ifdef CON_R15L
  #if (CON_R15L!=55)
    #error "merging GDSL libraries with incompatible definition for CON_R15L."
  #endif
#else
  #define CON_R15L 55
#endif
#ifdef CON_R15W
  #if (CON_R15W!=56)
    #error "merging GDSL libraries with incompatible definition for CON_R15W."
  #endif
#else
  #define CON_R15W 56
#endif
#ifdef CON_R15D
  #if (CON_R15D!=57)
    #error "merging GDSL libraries with incompatible definition for CON_R15D."
  #endif
#else
  #define CON_R15D 57
#endif
#ifdef CON_R15
  #if (CON_R15!=58)
    #error "merging GDSL libraries with incompatible definition for CON_R15."
  #endif
#else
  #define CON_R15 58
#endif
#ifdef CON_SPL
  #if (CON_SPL!=59)
    #error "merging GDSL libraries with incompatible definition for CON_SPL."
  #endif
#else
  #define CON_SPL 59
#endif
#ifdef CON_SP
  #if (CON_SP!=60)
    #error "merging GDSL libraries with incompatible definition for CON_SP."
  #endif
#else
  #define CON_SP 60
#endif
#ifdef CON_ESP
  #if (CON_ESP!=61)
    #error "merging GDSL libraries with incompatible definition for CON_ESP."
  #endif
#else
  #define CON_ESP 61
#endif
#ifdef CON_RSP
  #if (CON_RSP!=62)
    #error "merging GDSL libraries with incompatible definition for CON_RSP."
  #endif
#else
  #define CON_RSP 62
#endif
#ifdef CON_BPL
  #if (CON_BPL!=63)
    #error "merging GDSL libraries with incompatible definition for CON_BPL."
  #endif
#else
  #define CON_BPL 63
#endif
#ifdef CON_BP
  #if (CON_BP!=64)
    #error "merging GDSL libraries with incompatible definition for CON_BP."
  #endif
#else
  #define CON_BP 64
#endif
#ifdef CON_EBP
  #if (CON_EBP!=65)
    #error "merging GDSL libraries with incompatible definition for CON_EBP."
  #endif
#else
  #define CON_EBP 65
#endif
#ifdef CON_RBP
  #if (CON_RBP!=66)
    #error "merging GDSL libraries with incompatible definition for CON_RBP."
  #endif
#else
  #define CON_RBP 66
#endif
#ifdef CON_SIL
  #if (CON_SIL!=67)
    #error "merging GDSL libraries with incompatible definition for CON_SIL."
  #endif
#else
  #define CON_SIL 67
#endif
#ifdef CON_SI
  #if (CON_SI!=68)
    #error "merging GDSL libraries with incompatible definition for CON_SI."
  #endif
#else
  #define CON_SI 68
#endif
#ifdef CON_ESI
  #if (CON_ESI!=69)
    #error "merging GDSL libraries with incompatible definition for CON_ESI."
  #endif
#else
  #define CON_ESI 69
#endif
#ifdef CON_RSI
  #if (CON_RSI!=70)
    #error "merging GDSL libraries with incompatible definition for CON_RSI."
  #endif
#else
  #define CON_RSI 70
#endif
#ifdef CON_DIL
  #if (CON_DIL!=71)
    #error "merging GDSL libraries with incompatible definition for CON_DIL."
  #endif
#else
  #define CON_DIL 71
#endif
#ifdef CON_DI
  #if (CON_DI!=72)
    #error "merging GDSL libraries with incompatible definition for CON_DI."
  #endif
#else
  #define CON_DI 72
#endif
#ifdef CON_EDI
  #if (CON_EDI!=73)
    #error "merging GDSL libraries with incompatible definition for CON_EDI."
  #endif
#else
  #define CON_EDI 73
#endif
#ifdef CON_RDI
  #if (CON_RDI!=74)
    #error "merging GDSL libraries with incompatible definition for CON_RDI."
  #endif
#else
  #define CON_RDI 74
#endif
#ifdef CON_XMM0
  #if (CON_XMM0!=75)
    #error "merging GDSL libraries with incompatible definition for CON_XMM0."
  #endif
#else
  #define CON_XMM0 75
#endif
#ifdef CON_XMM1
  #if (CON_XMM1!=76)
    #error "merging GDSL libraries with incompatible definition for CON_XMM1."
  #endif
#else
  #define CON_XMM1 76
#endif
#ifdef CON_XMM2
  #if (CON_XMM2!=77)
    #error "merging GDSL libraries with incompatible definition for CON_XMM2."
  #endif
#else
  #define CON_XMM2 77
#endif
#ifdef CON_XMM3
  #if (CON_XMM3!=78)
    #error "merging GDSL libraries with incompatible definition for CON_XMM3."
  #endif
#else
  #define CON_XMM3 78
#endif
#ifdef CON_XMM4
  #if (CON_XMM4!=79)
    #error "merging GDSL libraries with incompatible definition for CON_XMM4."
  #endif
#else
  #define CON_XMM4 79
#endif
#ifdef CON_XMM5
  #if (CON_XMM5!=80)
    #error "merging GDSL libraries with incompatible definition for CON_XMM5."
  #endif
#else
  #define CON_XMM5 80
#endif
#ifdef CON_XMM6
  #if (CON_XMM6!=81)
    #error "merging GDSL libraries with incompatible definition for CON_XMM6."
  #endif
#else
  #define CON_XMM6 81
#endif
#ifdef CON_XMM7
  #if (CON_XMM7!=82)
    #error "merging GDSL libraries with incompatible definition for CON_XMM7."
  #endif
#else
  #define CON_XMM7 82
#endif
#ifdef CON_XMM8
  #if (CON_XMM8!=83)
    #error "merging GDSL libraries with incompatible definition for CON_XMM8."
  #endif
#else
  #define CON_XMM8 83
#endif
#ifdef CON_XMM9
  #if (CON_XMM9!=84)
    #error "merging GDSL libraries with incompatible definition for CON_XMM9."
  #endif
#else
  #define CON_XMM9 84
#endif
#ifdef CON_XMM10
  #if (CON_XMM10!=85)
    #error "merging GDSL libraries with incompatible definition for CON_XMM10."
  #endif
#else
  #define CON_XMM10 85
#endif
#ifdef CON_XMM11
  #if (CON_XMM11!=86)
    #error "merging GDSL libraries with incompatible definition for CON_XMM11."
  #endif
#else
  #define CON_XMM11 86
#endif
#ifdef CON_XMM12
  #if (CON_XMM12!=87)
    #error "merging GDSL libraries with incompatible definition for CON_XMM12."
  #endif
#else
  #define CON_XMM12 87
#endif
#ifdef CON_XMM13
  #if (CON_XMM13!=88)
    #error "merging GDSL libraries with incompatible definition for CON_XMM13."
  #endif
#else
  #define CON_XMM13 88
#endif
#ifdef CON_XMM14
  #if (CON_XMM14!=89)
    #error "merging GDSL libraries with incompatible definition for CON_XMM14."
  #endif
#else
  #define CON_XMM14 89
#endif
#ifdef CON_XMM15
  #if (CON_XMM15!=90)
    #error "merging GDSL libraries with incompatible definition for CON_XMM15."
  #endif
#else
  #define CON_XMM15 90
#endif
#ifdef CON_YMM0
  #if (CON_YMM0!=91)
    #error "merging GDSL libraries with incompatible definition for CON_YMM0."
  #endif
#else
  #define CON_YMM0 91
#endif
#ifdef CON_YMM1
  #if (CON_YMM1!=92)
    #error "merging GDSL libraries with incompatible definition for CON_YMM1."
  #endif
#else
  #define CON_YMM1 92
#endif
#ifdef CON_YMM2
  #if (CON_YMM2!=93)
    #error "merging GDSL libraries with incompatible definition for CON_YMM2."
  #endif
#else
  #define CON_YMM2 93
#endif
#ifdef CON_YMM3
  #if (CON_YMM3!=94)
    #error "merging GDSL libraries with incompatible definition for CON_YMM3."
  #endif
#else
  #define CON_YMM3 94
#endif
#ifdef CON_YMM4
  #if (CON_YMM4!=95)
    #error "merging GDSL libraries with incompatible definition for CON_YMM4."
  #endif
#else
  #define CON_YMM4 95
#endif
#ifdef CON_YMM5
  #if (CON_YMM5!=96)
    #error "merging GDSL libraries with incompatible definition for CON_YMM5."
  #endif
#else
  #define CON_YMM5 96
#endif
#ifdef CON_YMM6
  #if (CON_YMM6!=97)
    #error "merging GDSL libraries with incompatible definition for CON_YMM6."
  #endif
#else
  #define CON_YMM6 97
#endif
#ifdef CON_YMM7
  #if (CON_YMM7!=98)
    #error "merging GDSL libraries with incompatible definition for CON_YMM7."
  #endif
#else
  #define CON_YMM7 98
#endif
#ifdef CON_YMM8
  #if (CON_YMM8!=99)
    #error "merging GDSL libraries with incompatible definition for CON_YMM8."
  #endif
#else
  #define CON_YMM8 99
#endif
#ifdef CON_YMM9
  #if (CON_YMM9!=100)
    #error "merging GDSL libraries with incompatible definition for CON_YMM9."
  #endif
#else
  #define CON_YMM9 100
#endif
#ifdef CON_YMM10
  #if (CON_YMM10!=101)
    #error "merging GDSL libraries with incompatible definition for CON_YMM10."
  #endif
#else
  #define CON_YMM10 101
#endif
#ifdef CON_YMM11
  #if (CON_YMM11!=102)
    #error "merging GDSL libraries with incompatible definition for CON_YMM11."
  #endif
#else
  #define CON_YMM11 102
#endif
#ifdef CON_YMM12
  #if (CON_YMM12!=103)
    #error "merging GDSL libraries with incompatible definition for CON_YMM12."
  #endif
#else
  #define CON_YMM12 103
#endif
#ifdef CON_YMM13
  #if (CON_YMM13!=104)
    #error "merging GDSL libraries with incompatible definition for CON_YMM13."
  #endif
#else
  #define CON_YMM13 104
#endif
#ifdef CON_YMM14
  #if (CON_YMM14!=105)
    #error "merging GDSL libraries with incompatible definition for CON_YMM14."
  #endif
#else
  #define CON_YMM14 105
#endif
#ifdef CON_YMM15
  #if (CON_YMM15!=106)
    #error "merging GDSL libraries with incompatible definition for CON_YMM15."
  #endif
#else
  #define CON_YMM15 106
#endif
#ifdef CON_MM0
  #if (CON_MM0!=107)
    #error "merging GDSL libraries with incompatible definition for CON_MM0."
  #endif
#else
  #define CON_MM0 107
#endif
#ifdef CON_MM1
  #if (CON_MM1!=108)
    #error "merging GDSL libraries with incompatible definition for CON_MM1."
  #endif
#else
  #define CON_MM1 108
#endif
#ifdef CON_MM2
  #if (CON_MM2!=109)
    #error "merging GDSL libraries with incompatible definition for CON_MM2."
  #endif
#else
  #define CON_MM2 109
#endif
#ifdef CON_MM3
  #if (CON_MM3!=110)
    #error "merging GDSL libraries with incompatible definition for CON_MM3."
  #endif
#else
  #define CON_MM3 110
#endif
#ifdef CON_MM4
  #if (CON_MM4!=111)
    #error "merging GDSL libraries with incompatible definition for CON_MM4."
  #endif
#else
  #define CON_MM4 111
#endif
#ifdef CON_MM5
  #if (CON_MM5!=112)
    #error "merging GDSL libraries with incompatible definition for CON_MM5."
  #endif
#else
  #define CON_MM5 112
#endif
#ifdef CON_MM6
  #if (CON_MM6!=113)
    #error "merging GDSL libraries with incompatible definition for CON_MM6."
  #endif
#else
  #define CON_MM6 113
#endif
#ifdef CON_MM7
  #if (CON_MM7!=114)
    #error "merging GDSL libraries with incompatible definition for CON_MM7."
  #endif
#else
  #define CON_MM7 114
#endif
#ifdef CON_ES
  #if (CON_ES!=115)
    #error "merging GDSL libraries with incompatible definition for CON_ES."
  #endif
#else
  #define CON_ES 115
#endif
#ifdef CON_SS
  #if (CON_SS!=116)
    #error "merging GDSL libraries with incompatible definition for CON_SS."
  #endif
#else
  #define CON_SS 116
#endif
#ifdef CON_DS
  #if (CON_DS!=117)
    #error "merging GDSL libraries with incompatible definition for CON_DS."
  #endif
#else
  #define CON_DS 117
#endif
#ifdef CON_FS
  #if (CON_FS!=118)
    #error "merging GDSL libraries with incompatible definition for CON_FS."
  #endif
#else
  #define CON_FS 118
#endif
#ifdef CON_GS
  #if (CON_GS!=119)
    #error "merging GDSL libraries with incompatible definition for CON_GS."
  #endif
#else
  #define CON_GS 119
#endif
#ifdef CON_CS
  #if (CON_CS!=120)
    #error "merging GDSL libraries with incompatible definition for CON_CS."
  #endif
#else
  #define CON_CS 120
#endif
#ifdef CON_ST0
  #if (CON_ST0!=121)
    #error "merging GDSL libraries with incompatible definition for CON_ST0."
  #endif
#else
  #define CON_ST0 121
#endif
#ifdef CON_ST1
  #if (CON_ST1!=122)
    #error "merging GDSL libraries with incompatible definition for CON_ST1."
  #endif
#else
  #define CON_ST1 122
#endif
#ifdef CON_ST2
  #if (CON_ST2!=123)
    #error "merging GDSL libraries with incompatible definition for CON_ST2."
  #endif
#else
  #define CON_ST2 123
#endif
#ifdef CON_ST3
  #if (CON_ST3!=124)
    #error "merging GDSL libraries with incompatible definition for CON_ST3."
  #endif
#else
  #define CON_ST3 124
#endif
#ifdef CON_ST4
  #if (CON_ST4!=125)
    #error "merging GDSL libraries with incompatible definition for CON_ST4."
  #endif
#else
  #define CON_ST4 125
#endif
#ifdef CON_ST5
  #if (CON_ST5!=126)
    #error "merging GDSL libraries with incompatible definition for CON_ST5."
  #endif
#else
  #define CON_ST5 126
#endif
#ifdef CON_ST6
  #if (CON_ST6!=127)
    #error "merging GDSL libraries with incompatible definition for CON_ST6."
  #endif
#else
  #define CON_ST6 127
#endif
#ifdef CON_ST7
  #if (CON_ST7!=128)
    #error "merging GDSL libraries with incompatible definition for CON_ST7."
  #endif
#else
  #define CON_ST7 128
#endif
#ifdef CON_RIP
  #if (CON_RIP!=129)
    #error "merging GDSL libraries with incompatible definition for CON_RIP."
  #endif
#else
  #define CON_RIP 129
#endif
#ifdef CON_FLAGS
  #if (CON_FLAGS!=130)
    #error "merging GDSL libraries with incompatible definition for CON_FLAGS."
  #endif
#else
  #define CON_FLAGS 130
#endif