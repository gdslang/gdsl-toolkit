/*
 * gdsl_decoder_Instruction.c
 *
 *  Created on: Feb 14, 2014
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <jni.h>
#include <gdsl_generic.h>
#include <gdsl_multiplex.h>
#include "gdsl_decoder_NativeInstruction.h"
#include "util.h"

JNIEXPORT jlong JNICALL Java_gdsl_decoder_NativeInstruction_size(JNIEnv *env, jobject this, jlong frontendPtr,
    jlong gdslStatePtr, jlong insnPtr) {
  struct frontend *frontend = (struct frontend*)frontendPtr;
  state_t state = (state_t)gdslStatePtr;
  obj_t insn = (obj_t)insnPtr;

  if(setjmp(*frontend->generic.err_tgt(state)))
  THROW_GDSL_EXCEPTION_RET(0)

  //int_t s = frontend->decoder.insn_length(state, insn);
  int_t s = 0;

  return (jlong)s;
}

JNIEXPORT jstring JNICALL Java_gdsl_decoder_NativeInstruction_pretty(JNIEnv *env, jobject this, jlong frontendPtr,
    jlong gdslStatePtr, jlong insnPtr) {
  struct frontend *frontend = (struct frontend*)frontendPtr;
  state_t state = (state_t)gdslStatePtr;
  obj_t insn = (obj_t)insnPtr;

  if(setjmp(*frontend->generic.err_tgt(state)))
  THROW_GDSL_EXCEPTION_RET(NULL)

  string_t str = frontend->generic.merge_rope(state, frontend->decoder.pretty(state, insn));

  return (*env)->NewStringUTF(env, str);
}

JNIEXPORT jint JNICALL Java_gdsl_decoder_NativeInstruction_operands(JNIEnv *env, jobject this, jlong frontendPtr,
    jlong gdslStatePtr, jlong insnPtr) {
  struct frontend *frontend = (struct frontend*)frontendPtr;
  state_t state = (state_t)gdslStatePtr;
  obj_t insn = (obj_t)insnPtr;

  if(setjmp(*frontend->generic.err_tgt(state)))
  THROW_GDSL_EXCEPTION_RET(0)

  //return (jint)frontend->decoder.operands(state, insn);
  return 0;
}

JNIEXPORT jstring JNICALL Java_gdsl_decoder_NativeInstruction_prettyOperand(JNIEnv *env, jobject this, jlong frontendPtr,
    jlong gdslStatePtr, jlong insnPtr, jint operand) {
  struct frontend *frontend = (struct frontend*)frontendPtr;
  state_t state = (state_t)gdslStatePtr;
  obj_t insn = (obj_t)insnPtr;

  if(setjmp(*frontend->generic.err_tgt(state)))
  THROW_GDSL_EXCEPTION_RET(NULL)

  //string_t str = frontend->generic.merge_rope(state, frontend->decoder.pretty_operand(state, insn, (int_t)operand));
  string_t str = ":-(";

  return (*env)->NewStringUTF(env, str);
}

JNIEXPORT jint JNICALL Java_gdsl_decoder_NativeInstruction_operandType(JNIEnv *env, jobject this, jlong frontendPtr,
    jlong gdslStatePtr, jlong insnPtr, jint operand) {
  struct frontend *frontend = (struct frontend*)frontendPtr;
  state_t state = (state_t)gdslStatePtr;
  obj_t insn = (obj_t)insnPtr;

  if(setjmp(*frontend->generic.err_tgt(state)))
  THROW_GDSL_EXCEPTION_RET(0)

  //int_t type = frontend->decoder.typeof_opnd(state, insn, (int_t)operand);
  int_t type = 0;

  return type;
}

JNIEXPORT jstring JNICALL Java_gdsl_decoder_NativeInstruction_mnemonic(JNIEnv *env, jobject this, jlong frontendPtr,
    jlong gdslStatePtr, jlong insnPtr) {
  struct frontend *frontend = (struct frontend*)frontendPtr;
  state_t state = (state_t)gdslStatePtr;
  obj_t insn = (obj_t)insnPtr;

  if(setjmp(*frontend->generic.err_tgt(state)))
    THROW_GDSL_EXCEPTION_RET(NULL)

  //string_t str = frontend->generic.merge_rope(state, frontend->decoder.pretty_mnemonic(state, insn));
  string_t str = "";

  return (*env)->NewStringUTF(env, str);
}
