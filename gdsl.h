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
typedef long long int int_t;
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
#ifndef __GDSL_H
#define __GDSL_H

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
  int_t repne;
  int_t rep;
  int_t lock;
  int_t opnd_sz;
  int_t addr_sz;
  obj_t insn;
} unboxed_insndata_t;
typedef unboxed_insndata_t* insndata_t;
/* Exported functions. */
obj_t gdsl_pretty_simple(state_t s,insndata_t i);
obj_t gdsl_pretty(state_t s,insndata_t i);
int_t gdsl_features_get(state_t s,insndata_t insndata);
insndata_t gdsl_decode(state_t s,int_t config);
int_t gdsl_config_default_opnd_sz_32(state_t s);
int_t gdsl_config_mode64(state_t s);
int_t gdsl_config_default(state_t s);
obj_t gdsl_select_live(state_t s);
obj_t gdsl_select_ins_count(state_t s);
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
#define gdsl_pretty_simple gdsl_pretty_simple
#define gdsl_pretty gdsl_pretty
#define gdsl_features_get gdsl_features_get
#define gdsl_decode gdsl_decode
#define gdsl_config_default_opnd_sz_32 gdsl_config_default_opnd_sz_32
#define gdsl_config_mode64 gdsl_config_mode64
#define gdsl_config_default gdsl_config_default
#define gdsl_select_live gdsl_select_live
#define gdsl_select_ins_count gdsl_select_ins_count
#define gdsl_int_max gdsl_int_max
#define gdsl_rope_to_string gdsl_rope_to_string
#define gdsl_rope_print gdsl_rope_print
#define gdsl_rope_length gdsl_rope_length
#endif

#endif /* __GDSL_H */

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
#ifdef CON_VA0
  #if (CON_VA0!=147)
    #error "merging GDSL libraries with incompatible definition for CON_VA0."
  #endif
#else
  #define CON_VA0 147
#endif
#ifdef CON_AAA
  #if (CON_AAA!=152)
    #error "merging GDSL libraries with incompatible definition for CON_AAA."
  #endif
#else
  #define CON_AAA 152
#endif
#ifdef CON_AAS
  #if (CON_AAS!=155)
    #error "merging GDSL libraries with incompatible definition for CON_AAS."
  #endif
#else
  #define CON_AAS 155
#endif
#ifdef CON_CBW
  #if (CON_CBW!=189)
    #error "merging GDSL libraries with incompatible definition for CON_CBW."
  #endif
#else
  #define CON_CBW 189
#endif
#ifdef CON_CDQ
  #if (CON_CDQ!=190)
    #error "merging GDSL libraries with incompatible definition for CON_CDQ."
  #endif
#else
  #define CON_CDQ 190
#endif
#ifdef CON_CDQE
  #if (CON_CDQE!=191)
    #error "merging GDSL libraries with incompatible definition for CON_CDQE."
  #endif
#else
  #define CON_CDQE 191
#endif
#ifdef CON_CLC
  #if (CON_CLC!=192)
    #error "merging GDSL libraries with incompatible definition for CON_CLC."
  #endif
#else
  #define CON_CLC 192
#endif
#ifdef CON_CLD
  #if (CON_CLD!=193)
    #error "merging GDSL libraries with incompatible definition for CON_CLD."
  #endif
#else
  #define CON_CLD 193
#endif
#ifdef CON_CLI
  #if (CON_CLI!=195)
    #error "merging GDSL libraries with incompatible definition for CON_CLI."
  #endif
#else
  #define CON_CLI 195
#endif
#ifdef CON_CLTS
  #if (CON_CLTS!=196)
    #error "merging GDSL libraries with incompatible definition for CON_CLTS."
  #endif
#else
  #define CON_CLTS 196
#endif
#ifdef CON_CMC
  #if (CON_CMC!=197)
    #error "merging GDSL libraries with incompatible definition for CON_CMC."
  #endif
#else
  #define CON_CMC 197
#endif
#ifdef CON_CPUID
  #if (CON_CPUID!=239)
    #error "merging GDSL libraries with incompatible definition for CON_CPUID."
  #endif
#else
  #define CON_CPUID 239
#endif
#ifdef CON_CQO
  #if (CON_CQO!=240)
    #error "merging GDSL libraries with incompatible definition for CON_CQO."
  #endif
#else
  #define CON_CQO 240
#endif
#ifdef CON_CWD
  #if (CON_CWD!=264)
    #error "merging GDSL libraries with incompatible definition for CON_CWD."
  #endif
#else
  #define CON_CWD 264
#endif
#ifdef CON_CWDE
  #if (CON_CWDE!=265)
    #error "merging GDSL libraries with incompatible definition for CON_CWDE."
  #endif
#else
  #define CON_CWDE 265
#endif
#ifdef CON_DAA
  #if (CON_DAA!=266)
    #error "merging GDSL libraries with incompatible definition for CON_DAA."
  #endif
#else
  #define CON_DAA 266
#endif
#ifdef CON_DAS
  #if (CON_DAS!=267)
    #error "merging GDSL libraries with incompatible definition for CON_DAS."
  #endif
#else
  #define CON_DAS 267
#endif
#ifdef CON_EMMS
  #if (CON_EMMS!=276)
    #error "merging GDSL libraries with incompatible definition for CON_EMMS."
  #endif
#else
  #define CON_EMMS 276
#endif
#ifdef CON_F2XM1
  #if (CON_F2XM1!=279)
    #error "merging GDSL libraries with incompatible definition for CON_F2XM1."
  #endif
#else
  #define CON_F2XM1 279
#endif
#ifdef CON_FABS
  #if (CON_FABS!=280)
    #error "merging GDSL libraries with incompatible definition for CON_FABS."
  #endif
#else
  #define CON_FABS 280
#endif
#ifdef CON_FCHS
  #if (CON_FCHS!=285)
    #error "merging GDSL libraries with incompatible definition for CON_FCHS."
  #endif
#else
  #define CON_FCHS 285
#endif
#ifdef CON_FCLEX
  #if (CON_FCLEX!=286)
    #error "merging GDSL libraries with incompatible definition for CON_FCLEX."
  #endif
#else
  #define CON_FCLEX 286
#endif
#ifdef CON_FCOMPP
  #if (CON_FCOMPP!=299)
    #error "merging GDSL libraries with incompatible definition for CON_FCOMPP."
  #endif
#else
  #define CON_FCOMPP 299
#endif
#ifdef CON_FCOS
  #if (CON_FCOS!=300)
    #error "merging GDSL libraries with incompatible definition for CON_FCOS."
  #endif
#else
  #define CON_FCOS 300
#endif
#ifdef CON_FDECSTP
  #if (CON_FDECSTP!=301)
    #error "merging GDSL libraries with incompatible definition for CON_FDECSTP."
  #endif
#else
  #define CON_FDECSTP 301
#endif
#ifdef CON_FINCSTP
  #if (CON_FINCSTP!=314)
    #error "merging GDSL libraries with incompatible definition for CON_FINCSTP."
  #endif
#else
  #define CON_FINCSTP 314
#endif
#ifdef CON_FINIT
  #if (CON_FINIT!=315)
    #error "merging GDSL libraries with incompatible definition for CON_FINIT."
  #endif
#else
  #define CON_FINIT 315
#endif
#ifdef CON_FLD1
  #if (CON_FLD1!=322)
    #error "merging GDSL libraries with incompatible definition for CON_FLD1."
  #endif
#else
  #define CON_FLD1 322
#endif
#ifdef CON_FLDL2E
  #if (CON_FLDL2E!=325)
    #error "merging GDSL libraries with incompatible definition for CON_FLDL2E."
  #endif
#else
  #define CON_FLDL2E 325
#endif
#ifdef CON_FLDL2T
  #if (CON_FLDL2T!=326)
    #error "merging GDSL libraries with incompatible definition for CON_FLDL2T."
  #endif
#else
  #define CON_FLDL2T 326
#endif
#ifdef CON_FLDLG2
  #if (CON_FLDLG2!=327)
    #error "merging GDSL libraries with incompatible definition for CON_FLDLG2."
  #endif
#else
  #define CON_FLDLG2 327
#endif
#ifdef CON_FLDLN2
  #if (CON_FLDLN2!=328)
    #error "merging GDSL libraries with incompatible definition for CON_FLDLN2."
  #endif
#else
  #define CON_FLDLN2 328
#endif
#ifdef CON_FLDPI
  #if (CON_FLDPI!=329)
    #error "merging GDSL libraries with incompatible definition for CON_FLDPI."
  #endif
#else
  #define CON_FLDPI 329
#endif
#ifdef CON_FLDZ
  #if (CON_FLDZ!=330)
    #error "merging GDSL libraries with incompatible definition for CON_FLDZ."
  #endif
#else
  #define CON_FLDZ 330
#endif
#ifdef CON_FNCLEX
  #if (CON_FNCLEX!=333)
    #error "merging GDSL libraries with incompatible definition for CON_FNCLEX."
  #endif
#else
  #define CON_FNCLEX 333
#endif
#ifdef CON_FNINIT
  #if (CON_FNINIT!=334)
    #error "merging GDSL libraries with incompatible definition for CON_FNINIT."
  #endif
#else
  #define CON_FNINIT 334
#endif
#ifdef CON_FNOP
  #if (CON_FNOP!=335)
    #error "merging GDSL libraries with incompatible definition for CON_FNOP."
  #endif
#else
  #define CON_FNOP 335
#endif
#ifdef CON_FPATAN
  #if (CON_FPATAN!=340)
    #error "merging GDSL libraries with incompatible definition for CON_FPATAN."
  #endif
#else
  #define CON_FPATAN 340
#endif
#ifdef CON_FPREM
  #if (CON_FPREM!=341)
    #error "merging GDSL libraries with incompatible definition for CON_FPREM."
  #endif
#else
  #define CON_FPREM 341
#endif
#ifdef CON_FPREM1
  #if (CON_FPREM1!=342)
    #error "merging GDSL libraries with incompatible definition for CON_FPREM1."
  #endif
#else
  #define CON_FPREM1 342
#endif
#ifdef CON_FPTAN
  #if (CON_FPTAN!=343)
    #error "merging GDSL libraries with incompatible definition for CON_FPTAN."
  #endif
#else
  #define CON_FPTAN 343
#endif
#ifdef CON_FRNDINT
  #if (CON_FRNDINT!=344)
    #error "merging GDSL libraries with incompatible definition for CON_FRNDINT."
  #endif
#else
  #define CON_FRNDINT 344
#endif
#ifdef CON_FSCALE
  #if (CON_FSCALE!=347)
    #error "merging GDSL libraries with incompatible definition for CON_FSCALE."
  #endif
#else
  #define CON_FSCALE 347
#endif
#ifdef CON_FSIN
  #if (CON_FSIN!=348)
    #error "merging GDSL libraries with incompatible definition for CON_FSIN."
  #endif
#else
  #define CON_FSIN 348
#endif
#ifdef CON_FSINCOS
  #if (CON_FSINCOS!=349)
    #error "merging GDSL libraries with incompatible definition for CON_FSINCOS."
  #endif
#else
  #define CON_FSINCOS 349
#endif
#ifdef CON_FSQRT
  #if (CON_FSQRT!=350)
    #error "merging GDSL libraries with incompatible definition for CON_FSQRT."
  #endif
#else
  #define CON_FSQRT 350
#endif
#ifdef CON_FTST
  #if (CON_FTST!=360)
    #error "merging GDSL libraries with incompatible definition for CON_FTST."
  #endif
#else
  #define CON_FTST 360
#endif
#ifdef CON_FUCOMPP
  #if (CON_FUCOMPP!=365)
    #error "merging GDSL libraries with incompatible definition for CON_FUCOMPP."
  #endif
#else
  #define CON_FUCOMPP 365
#endif
#ifdef CON_FXAM
  #if (CON_FXAM!=366)
    #error "merging GDSL libraries with incompatible definition for CON_FXAM."
  #endif
#else
  #define CON_FXAM 366
#endif
#ifdef CON_FXTRACT
  #if (CON_FXTRACT!=372)
    #error "merging GDSL libraries with incompatible definition for CON_FXTRACT."
  #endif
#else
  #define CON_FXTRACT 372
#endif
#ifdef CON_FYL2X
  #if (CON_FYL2X!=373)
    #error "merging GDSL libraries with incompatible definition for CON_FYL2X."
  #endif
#else
  #define CON_FYL2X 373
#endif
#ifdef CON_FYL2XP1
  #if (CON_FYL2XP1!=374)
    #error "merging GDSL libraries with incompatible definition for CON_FYL2XP1."
  #endif
#else
  #define CON_FYL2XP1 374
#endif
#ifdef CON_HLT
  #if (CON_HLT!=377)
    #error "merging GDSL libraries with incompatible definition for CON_HLT."
  #endif
#else
  #define CON_HLT 377
#endif
#ifdef CON_INSB
  #if (CON_INSB!=384)
    #error "merging GDSL libraries with incompatible definition for CON_INSB."
  #endif
#else
  #define CON_INSB 384
#endif
#ifdef CON_INSD
  #if (CON_INSD!=385)
    #error "merging GDSL libraries with incompatible definition for CON_INSD."
  #endif
#else
  #define CON_INSD 385
#endif
#ifdef CON_INSW
  #if (CON_INSW!=387)
    #error "merging GDSL libraries with incompatible definition for CON_INSW."
  #endif
#else
  #define CON_INSW 387
#endif
#ifdef CON_INT0
  #if (CON_INT0!=389)
    #error "merging GDSL libraries with incompatible definition for CON_INT0."
  #endif
#else
  #define CON_INT0 389
#endif
#ifdef CON_INT3
  #if (CON_INT3!=390)
    #error "merging GDSL libraries with incompatible definition for CON_INT3."
  #endif
#else
  #define CON_INT3 390
#endif
#ifdef CON_INVD
  #if (CON_INVD!=391)
    #error "merging GDSL libraries with incompatible definition for CON_INVD."
  #endif
#else
  #define CON_INVD 391
#endif
#ifdef CON_IRET
  #if (CON_IRET!=394)
    #error "merging GDSL libraries with incompatible definition for CON_IRET."
  #endif
#else
  #define CON_IRET 394
#endif
#ifdef CON_IRETD
  #if (CON_IRETD!=395)
    #error "merging GDSL libraries with incompatible definition for CON_IRETD."
  #endif
#else
  #define CON_IRETD 395
#endif
#ifdef CON_IRETQ
  #if (CON_IRETQ!=396)
    #error "merging GDSL libraries with incompatible definition for CON_IRETQ."
  #endif
#else
  #define CON_IRETQ 396
#endif
#ifdef CON_LAHF
  #if (CON_LAHF!=431)
    #error "merging GDSL libraries with incompatible definition for CON_LAHF."
  #endif
#else
  #define CON_LAHF 431
#endif
#ifdef CON_LEAVE
  #if (CON_LEAVE!=437)
    #error "merging GDSL libraries with incompatible definition for CON_LEAVE."
  #endif
#else
  #define CON_LEAVE 437
#endif
#ifdef CON_LFENCE
  #if (CON_LFENCE!=439)
    #error "merging GDSL libraries with incompatible definition for CON_LFENCE."
  #endif
#else
  #define CON_LFENCE 439
#endif
#ifdef CON_MFENCE
  #if (CON_MFENCE!=459)
    #error "merging GDSL libraries with incompatible definition for CON_MFENCE."
  #endif
#else
  #define CON_MFENCE 459
#endif
#ifdef CON_MONITOR
  #if (CON_MONITOR!=464)
    #error "merging GDSL libraries with incompatible definition for CON_MONITOR."
  #endif
#else
  #define CON_MONITOR 464
#endif
#ifdef CON_MWAIT
  #if (CON_MWAIT!=507)
    #error "merging GDSL libraries with incompatible definition for CON_MWAIT."
  #endif
#else
  #define CON_MWAIT 507
#endif
#ifdef CON_OUTS
  #if (CON_OUTS!=515)
    #error "merging GDSL libraries with incompatible definition for CON_OUTS."
  #endif
#else
  #define CON_OUTS 515
#endif
#ifdef CON_OUTSB
  #if (CON_OUTSB!=516)
    #error "merging GDSL libraries with incompatible definition for CON_OUTSB."
  #endif
#else
  #define CON_OUTSB 516
#endif
#ifdef CON_OUTSD
  #if (CON_OUTSD!=517)
    #error "merging GDSL libraries with incompatible definition for CON_OUTSD."
  #endif
#else
  #define CON_OUTSD 517
#endif
#ifdef CON_OUTSW
  #if (CON_OUTSW!=518)
    #error "merging GDSL libraries with incompatible definition for CON_OUTSW."
  #endif
#else
  #define CON_OUTSW 518
#endif
#ifdef CON_PAUSE
  #if (CON_PAUSE!=537)
    #error "merging GDSL libraries with incompatible definition for CON_PAUSE."
  #endif
#else
  #define CON_PAUSE 537
#endif
#ifdef CON_POPA
  #if (CON_POPA!=606)
    #error "merging GDSL libraries with incompatible definition for CON_POPA."
  #endif
#else
  #define CON_POPA 606
#endif
#ifdef CON_POPAD
  #if (CON_POPAD!=607)
    #error "merging GDSL libraries with incompatible definition for CON_POPAD."
  #endif
#else
  #define CON_POPAD 607
#endif
#ifdef CON_POPF
  #if (CON_POPF!=609)
    #error "merging GDSL libraries with incompatible definition for CON_POPF."
  #endif
#else
  #define CON_POPF 609
#endif
#ifdef CON_POPFD
  #if (CON_POPFD!=610)
    #error "merging GDSL libraries with incompatible definition for CON_POPFD."
  #endif
#else
  #define CON_POPFD 610
#endif
#ifdef CON_POPFQ
  #if (CON_POPFQ!=611)
    #error "merging GDSL libraries with incompatible definition for CON_POPFQ."
  #endif
#else
  #define CON_POPFQ 611
#endif
#ifdef CON_PUSHA
  #if (CON_PUSHA!=655)
    #error "merging GDSL libraries with incompatible definition for CON_PUSHA."
  #endif
#else
  #define CON_PUSHA 655
#endif
#ifdef CON_PUSHAD
  #if (CON_PUSHAD!=656)
    #error "merging GDSL libraries with incompatible definition for CON_PUSHAD."
  #endif
#else
  #define CON_PUSHAD 656
#endif
#ifdef CON_PUSHF
  #if (CON_PUSHF!=657)
    #error "merging GDSL libraries with incompatible definition for CON_PUSHF."
  #endif
#else
  #define CON_PUSHF 657
#endif
#ifdef CON_PUSHFD
  #if (CON_PUSHFD!=658)
    #error "merging GDSL libraries with incompatible definition for CON_PUSHFD."
  #endif
#else
  #define CON_PUSHFD 658
#endif
#ifdef CON_PUSHFQ
  #if (CON_PUSHFQ!=659)
    #error "merging GDSL libraries with incompatible definition for CON_PUSHFQ."
  #endif
#else
  #define CON_PUSHFQ 659
#endif
#ifdef CON_RDMSR
  #if (CON_RDMSR!=667)
    #error "merging GDSL libraries with incompatible definition for CON_RDMSR."
  #endif
#else
  #define CON_RDMSR 667
#endif
#ifdef CON_RDPMC
  #if (CON_RDPMC!=668)
    #error "merging GDSL libraries with incompatible definition for CON_RDPMC."
  #endif
#else
  #define CON_RDPMC 668
#endif
#ifdef CON_RDTSC
  #if (CON_RDTSC!=670)
    #error "merging GDSL libraries with incompatible definition for CON_RDTSC."
  #endif
#else
  #define CON_RDTSC 670
#endif
#ifdef CON_RDTSCP
  #if (CON_RDTSCP!=671)
    #error "merging GDSL libraries with incompatible definition for CON_RDTSCP."
  #endif
#else
  #define CON_RDTSCP 671
#endif
#ifdef CON_RSM
  #if (CON_RSM!=680)
    #error "merging GDSL libraries with incompatible definition for CON_RSM."
  #endif
#else
  #define CON_RSM 680
#endif
#ifdef CON_SAHF
  #if (CON_SAHF!=683)
    #error "merging GDSL libraries with incompatible definition for CON_SAHF."
  #endif
#else
  #define CON_SAHF 683
#endif
#ifdef CON_SCASB
  #if (CON_SCASB!=687)
    #error "merging GDSL libraries with incompatible definition for CON_SCASB."
  #endif
#else
  #define CON_SCASB 687
#endif
#ifdef CON_SCASD
  #if (CON_SCASD!=688)
    #error "merging GDSL libraries with incompatible definition for CON_SCASD."
  #endif
#else
  #define CON_SCASD 688
#endif
#ifdef CON_SCASQ
  #if (CON_SCASQ!=689)
    #error "merging GDSL libraries with incompatible definition for CON_SCASQ."
  #endif
#else
  #define CON_SCASQ 689
#endif
#ifdef CON_SCASW
  #if (CON_SCASW!=690)
    #error "merging GDSL libraries with incompatible definition for CON_SCASW."
  #endif
#else
  #define CON_SCASW 690
#endif
#ifdef CON_SFENCE
  #if (CON_SFENCE!=721)
    #error "merging GDSL libraries with incompatible definition for CON_SFENCE."
  #endif
#else
  #define CON_SFENCE 721
#endif
#ifdef CON_STC
  #if (CON_STC!=736)
    #error "merging GDSL libraries with incompatible definition for CON_STC."
  #endif
#else
  #define CON_STC 736
#endif
#ifdef CON_STD
  #if (CON_STD!=737)
    #error "merging GDSL libraries with incompatible definition for CON_STD."
  #endif
#else
  #define CON_STD 737
#endif
#ifdef CON_STI
  #if (CON_STI!=738)
    #error "merging GDSL libraries with incompatible definition for CON_STI."
  #endif
#else
  #define CON_STI 738
#endif
#ifdef CON_STOSB
  #if (CON_STOSB!=740)
    #error "merging GDSL libraries with incompatible definition for CON_STOSB."
  #endif
#else
  #define CON_STOSB 740
#endif
#ifdef CON_STOSD
  #if (CON_STOSD!=741)
    #error "merging GDSL libraries with incompatible definition for CON_STOSD."
  #endif
#else
  #define CON_STOSD 741
#endif
#ifdef CON_STOSQ
  #if (CON_STOSQ!=742)
    #error "merging GDSL libraries with incompatible definition for CON_STOSQ."
  #endif
#else
  #define CON_STOSQ 742
#endif
#ifdef CON_STOSW
  #if (CON_STOSW!=743)
    #error "merging GDSL libraries with incompatible definition for CON_STOSW."
  #endif
#else
  #define CON_STOSW 743
#endif
#ifdef CON_SWAPGS
  #if (CON_SWAPGS!=750)
    #error "merging GDSL libraries with incompatible definition for CON_SWAPGS."
  #endif
#else
  #define CON_SWAPGS 750
#endif
#ifdef CON_SYSCALL
  #if (CON_SYSCALL!=751)
    #error "merging GDSL libraries with incompatible definition for CON_SYSCALL."
  #endif
#else
  #define CON_SYSCALL 751
#endif
#ifdef CON_SYSENTER
  #if (CON_SYSENTER!=752)
    #error "merging GDSL libraries with incompatible definition for CON_SYSENTER."
  #endif
#else
  #define CON_SYSENTER 752
#endif
#ifdef CON_SYSEXIT
  #if (CON_SYSEXIT!=753)
    #error "merging GDSL libraries with incompatible definition for CON_SYSEXIT."
  #endif
#else
  #define CON_SYSEXIT 753
#endif
#ifdef CON_SYSRET
  #if (CON_SYSRET!=754)
    #error "merging GDSL libraries with incompatible definition for CON_SYSRET."
  #endif
#else
  #define CON_SYSRET 754
#endif
#ifdef CON_UD2
  #if (CON_UD2!=758)
    #error "merging GDSL libraries with incompatible definition for CON_UD2."
  #endif
#else
  #define CON_UD2 758
#endif
#ifdef CON_WAIT
  #if (CON_WAIT!=1029)
    #error "merging GDSL libraries with incompatible definition for CON_WAIT."
  #endif
#else
  #define CON_WAIT 1029
#endif
#ifdef CON_WBINVD
  #if (CON_WBINVD!=1030)
    #error "merging GDSL libraries with incompatible definition for CON_WBINVD."
  #endif
#else
  #define CON_WBINVD 1030
#endif
#ifdef CON_WRMSR
  #if (CON_WRMSR!=1033)
    #error "merging GDSL libraries with incompatible definition for CON_WRMSR."
  #endif
#else
  #define CON_WRMSR 1033
#endif
#ifdef CON_XGETBV
  #if (CON_XGETBV!=1036)
    #error "merging GDSL libraries with incompatible definition for CON_XGETBV."
  #endif
#else
  #define CON_XGETBV 1036
#endif
#ifdef CON_XLATB
  #if (CON_XLATB!=1037)
    #error "merging GDSL libraries with incompatible definition for CON_XLATB."
  #endif
#else
  #define CON_XLATB 1037
#endif
#ifdef CON_XSETBV
  #if (CON_XSETBV!=1047)
    #error "merging GDSL libraries with incompatible definition for CON_XSETBV."
  #endif
#else
  #define CON_XSETBV 1047
#endif