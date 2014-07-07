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
#include <util.h>

static obj_t asm_insn(state_t state, int_t length, string_t mnemonic, obj_t annotations, obj_t opnds) {
  obj_t indent = indent_binary(annotations, opnds);
  printf("> insn {length=%lld, mnemonic=%s}\n\n", length, mnemonic);
  return indent;
}

// operand list

static obj_t asm_opnds_next(state_t state, obj_t next, obj_t list) {
  obj_t indent = indent_unary(next);
  printf("> next operand\n");
  return indent;
}

static obj_t asm_opnds_init(state_t state, obj_t next) {
  printf("> init operands\n");
  return (state_t)0;
}

// operand

static obj_t asm_register(state_t state, string_t mnemonic) {
  printf("> register {mnemonic=%s}\n", mnemonic);
  return (state_t)0;
}

static obj_t asm_memory(state_t state, obj_t _this) {
  obj_t indent = indent_unary(_this);
  printf("> memory\n");
  return indent;
}

static obj_t asm_imm(state_t state, int_t _this) {
  printf("> immediate {value=%lld}\n", _this);
  return (obj_t)0;
}

static obj_t asm_post_op(state_t state, obj_t expr, obj_t opnd) {
  obj_t indent = indent_binary(expr, opnd);
  printf("> post_op\n");
  return indent;
}

static obj_t asm_pre_op(state_t state, obj_t expr, obj_t opnd) {
  obj_t indent = indent_binary(expr, opnd);
  printf("> pre_op\n");
  return indent;
}

static obj_t asm_rel(state_t state, obj_t _this) {
  obj_t indent = indent_unary(_this);
  printf("> rel\n");
  return indent;
}

static obj_t asm_annotation(state_t state, obj_t ann, obj_t opnd) {
  obj_t indent = indent_binary(ann, opnd);
  printf("> annotation\n");
  return indent;
}

static obj_t asm_sum(state_t state, obj_t lhs, obj_t rhs) {
  obj_t indent = indent_binary(lhs, rhs);
  printf("> sum\n");
  return indent;
}

static obj_t asm_scale(state_t state, int_t factor, obj_t rhs) {
  obj_t indent = indent_unary(rhs);
  printf("> scale {factor=%lld}\n", factor);
  return indent;
}

static obj_t asm_bounded(state_t state, obj_t ann, obj_t opnd) {
  obj_t indent = indent_binary(ann, opnd);
  printf("> bounded\n");
  return indent;
}

static obj_t asm_sign(state_t state, obj_t signedness, obj_t opnd) {
  obj_t indent = indent_binary(signedness, opnd);
  printf("> signedness\n");
  return indent;
}

// signedness

static obj_t asm_signed(state_t state, obj_t foo) {
  printf("> signed\n");
  return (state_t)0;
}

static obj_t asm_unsigned(state_t state, obj_t foo) {
  printf("> unsigned\n");
  return (state_t)0;
}

// boundary

static obj_t asm_sz(state_t state, int_t sz) {
  printf("> boundary {size=%lld}\n", sz);
  return (state_t)0;
}

static obj_t asm_sz_o(state_t state, int_t sz, int_t o) {
  printf("> boundary {size=%lld, offset=%lld}\n", sz, o);
  return (state_t)0;
}

// annotation list

static obj_t asm_annotations_next(state_t state, obj_t next, obj_t list) {
  obj_t indent = indent_unary(next);
  printf("> next annotation\n");
  return indent;
}

static obj_t asm_annotations_init(state_t state, obj_t next) {
  printf("> init annotations\n");
  return (state_t)0;
}

// annotation

static obj_t asm_annotation_string(state_t state, string_t _this) {
  printf("> annotation {%s}\n", _this);
  return (state_t)0;
}

static obj_t asm_annotation_function(state_t state, string_t name, obj_t args) {
  obj_t indent = indent_unary(args);
  printf("> annotation {name=%s}\n", name);
  return indent;
}

static obj_t asm_annotation_opnd(state_t state, string_t name, obj_t opnd) {
  obj_t indent = indent_unary(opnd);
  printf("> annotation {name=%s}\n", name);
  return indent;
}

JNIEXPORT jobject JNICALL Java_gdsl_asm_GeneralizerBackend_generalize
  (JNIEnv *env, jobject this, jobject backend) {
  return NULL;
}
