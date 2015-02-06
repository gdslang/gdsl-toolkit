/*
 * generalize_callbacks.c
 *
 *  Created on: Jul 7, 2014
 *      Author: Julian Kranz
 */

#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <gdsl_generic.h>
#include <gdsl_multiplex.h>
#include "util.h"

static obj_t asm_insn(state_t state, int_t length, string_t mnemonic, obj_t annotations, obj_t opnds) {
  return java_method_call(state, "insn", 4, java_long_create(state, length), java_string_create(state, mnemonic),
      (jobject)annotations, (jobject)opnds);
}

// operand list

static obj_t asm_opnds_next(state_t state, obj_t next, obj_t list) {
  return java_method_call(state, "opnds_next", 2, (jobject)next, (jobject)list);
}

static obj_t asm_opnds_init(state_t state) {
  return java_method_call(state, "opnds_init", 0);
}

// operand

static obj_t asm_register(state_t state, string_t mnemonic) {
  return java_method_call(state, "register", 1, java_string_create(state, mnemonic));
}

static obj_t asm_memory(state_t state, obj_t pointer) {
  return java_method_call(state, "memory", 1, (jobject)pointer);
}

static obj_t asm_imm(state_t state, int_t imm) {
  return java_method_call(state, "immediate", 1, java_long_create(state, imm));
}

static obj_t asm_post_op(state_t state, obj_t expr, obj_t opnd) {
  return java_method_call(state, "post_op", 2, (jobject)expr, (jobject)opnd);
}

static obj_t asm_pre_op(state_t state, obj_t expr, obj_t opnd) {
  return java_method_call(state, "pre_op", 2, (jobject)expr, (jobject)opnd);
}

static obj_t asm_rel(state_t state, obj_t operand) {
  return java_method_call(state, "rel", 1, (jobject)operand);
}

static obj_t asm_annotated(state_t state, obj_t ann, obj_t operand) {
  return java_method_call(state, "annotated", 2, (jobject)ann, (jobject)operand);
}

static obj_t asm_sum(state_t state, obj_t lhs, obj_t rhs) {
  return java_method_call(state, "sum", 2, (jobject)lhs, (jobject)rhs);
}

static obj_t asm_scale(state_t state, int_t factor, obj_t rhs) {
  return java_method_call(state, "scale", 2, java_long_create(state, factor), (jobject)rhs);
}

static obj_t asm_bounded(state_t state, obj_t boundary, obj_t operand) {
  return java_method_call(state, "bounded", 2, (jobject)boundary, (jobject)operand);
}

static obj_t asm_sign(state_t state, obj_t signedness, obj_t operand) {
  return java_method_call(state, "sign", 2, (jobject)signedness, (jobject)operand);
}

static obj_t asm_composite(state_t state, obj_t opnds) {
  return java_method_call(state, "composite", 1, (jobject)opnds);
}

// signedness
static obj_t asm_signed(state_t state) {
  return java_method_call(state, "signed", 0);
}

static obj_t asm_unsigned(state_t state) {
  return java_method_call(state, "unsigned", 0);
}

// boundary

static obj_t asm_sz(state_t state, int_t size) {
  return java_method_call(state, "sz", 1, java_long_create(state, size));
}

static obj_t asm_sz_o(state_t state, int_t size, int_t offset) {
  return java_method_call(state, "sz", 1, java_long_create(state, size));
}

// annotation list

static obj_t asm_annotations_next(state_t state, obj_t next, obj_t list) {
  return java_method_call(state, "annotations_next", 2, (jobject)next, (jobject)list);
}

static obj_t asm_annotations_init(state_t state) {
  return java_method_call(state, "annotations_init", 0);
}

// annotation

static obj_t asm_annotation_string(state_t state, string_t string) {
  return java_method_call(state, "string", 1, java_string_create(state, string));
}

static obj_t asm_annotation_function(state_t state, string_t name, obj_t args) {
  return java_method_call(state, "function", 2, java_string_create(state, name), (jobject)args);
}

static obj_t asm_annotation_opnd(state_t state, string_t name, obj_t operand) {
  return java_method_call(state, "operand", 2, java_string_create(state, name), (jobject)operand);
}

JNIEXPORT jobject JNICALL Java_gdsl_asm_GeneralizerBackend_generalize(JNIEnv *env, jobject this, jlong frontendPtr,
    jlong gdslStatePtr, jlong insnPtr) {
  struct frontend *frontend = (struct frontend*)frontendPtr;
  state_t state = (state_t)gdslStatePtr;
  obj_t insn = (obj_t)insnPtr;

  struct userdata ud;
  ud.env = env;
  ud.obj = this;
  ud.frontend = frontend;

  state->userdata = &ud;

  unboxed_asm_opnd_list_callbacks_t asm_opnd_list_callbacks = {.opnd_list_next = &asm_opnds_next, .init = &asm_opnds_init};
  unboxed_asm_opnd_callbacks_t asm_opnd_callbacks = {.opnd_register = &asm_register, .memory = &asm_memory, .imm =
      &asm_imm, .post_op = &asm_post_op, .pre_op = &asm_pre_op, .rel = &asm_rel, .annotated = &asm_annotated, .sum =
      &asm_sum, .scale = &asm_scale, .bounded = &asm_bounded, .sign = &asm_sign, .composite = &asm_composite};
  unboxed_asm_signedness_callbacks_t asm_signedness_callbacks = {.asm_signed = &asm_signed, .asm_unsigned =
      &asm_unsigned};
  unboxed_asm_boundary_callbacks_t asm_boundary_callbacks = {.sz = &asm_sz, .sz_o = &asm_sz_o};
  unboxed_asm_annotation_list_callbacks_t asm_annotation_list_callbacks = {.annotation_list_next = &asm_annotations_next, .init =
      &asm_annotations_init};
  unboxed_asm_annotation_callbacks_t asm_annotation_callbacks = {.ann_string = &asm_annotation_string, .function =
      &asm_annotation_function, .opnd = &asm_annotation_opnd};

  unboxed_asm_callbacks_t asm_callbacks = {.insn = &asm_insn, .opnd_list = &asm_opnd_list_callbacks,
      .opnd = &asm_opnd_callbacks, .signedness = &asm_signedness_callbacks, .boundary = &asm_boundary_callbacks,
      .annotation_list = &asm_annotation_list_callbacks, .annotation = &asm_annotation_callbacks, };

  if(setjmp(*frontend->generic.err_tgt(state)))
    THROW_GDSL_EXCEPTION_RET(NULL);

  obj_t g_insn = frontend->decoder.generalize(state, insn);

  return (jobject)frontend->decoder.asm_convert_insn(state, &asm_callbacks, g_insn);
}
