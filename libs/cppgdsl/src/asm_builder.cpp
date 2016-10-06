#include "cppgdsl/asm_builder.h"
#include "cppgdsl/gdsl_exception.h"

#include "cppgdsl/assembly/annotation/annotation.h"
#include "cppgdsl/assembly/annotation/function_annotation.h"
#include "cppgdsl/assembly/annotation/operand_annotation.h"
#include "cppgdsl/assembly/annotation/string_annotation.h"

#include "cppgdsl/assembly/boundary/boundary.h"
#include "cppgdsl/assembly/boundary/offset_boundary.h"

#include "cppgdsl/assembly/operand/annotated.h"
#include "cppgdsl/assembly/operand/bounded.h"
#include "cppgdsl/assembly/operand/composite.h"
#include "cppgdsl/assembly/operand/immediate.h"
#include "cppgdsl/assembly/operand/memory.h"
#include "cppgdsl/assembly/operand/operand.h"
#include "cppgdsl/assembly/operand/post_op.h"
#include "cppgdsl/assembly/operand/pre_op.h"
#include "cppgdsl/assembly/operand/register.h"
#include "cppgdsl/assembly/operand/rel.h"
#include "cppgdsl/assembly/operand/scale.h"
#include "cppgdsl/assembly/operand/signed.h"
#include "cppgdsl/assembly/operand/sum.h"

#include "cppgdsl/assembly/instruction.h"
#include "cppgdsl/assembly/signedness.h"

#include <memory>
#include <string>

using gdsl::assembly::annotated;
using gdsl::assembly::annotation;
using gdsl::assembly::annotations_t;
using gdsl::assembly::boundary;
using gdsl::assembly::bounded;
using gdsl::assembly::composite;
using gdsl::assembly::function_annotation;
using gdsl::assembly::immediate;
using gdsl::assembly::memory;
using gdsl::assembly::offset_boundary;
using gdsl::assembly::operand_annotation;
using gdsl::assembly::operand;
using gdsl::assembly::operands_t;
using gdsl::assembly::post_op;
using gdsl::assembly::pre_op;
using gdsl::assembly::register_;
using gdsl::assembly::rel;
using gdsl::assembly::scale;
using gdsl::assembly::signed_;
using gdsl::assembly::signedness;
using gdsl::assembly::string_annotation;
using gdsl::assembly::sum;
using std::unique_ptr;

namespace gdsl {

// Generic ASM

static obj_t asm_insn(state_t state, int_t length, string_t mnemonic,
                      obj_t annotations, obj_t opnds) {
  auto _annotations = unique_ptr<annotations_t>((annotations_t*)annotations);
  auto _opnds = unique_ptr<operands_t>((operands_t*)opnds);
  return new assembly::instruction(length, std::string(mnemonic),
                                   move(*_annotations), move(*_opnds));
}

// operand list

static obj_t asm_opnds_next(state_t state, obj_t next, obj_t list) {
  operands_t* operands = (operands_t*)list;
  operands->push_back(unique_ptr<operand>((operand*)next));
  return list;
}

static obj_t asm_opnds_init(state_t state) { return new operands_t(); }

// operand

static obj_t asm_register(state_t state, string_t mnemonic) {
  return new register_(std::string(mnemonic));
}

static obj_t asm_memory(state_t state, obj_t _this) {
  return new memory(unique_ptr<operand>((operand*)_this));
}

static obj_t asm_imm(state_t state, int_t _this) {
  return new immediate(_this);
}

static obj_t asm_post_op(state_t state, obj_t expr, obj_t opnd) {
  return new post_op(unique_ptr<operand>((operand*)expr),
                     unique_ptr<operand>((operand*)opnd));
}

static obj_t asm_pre_op(state_t state, obj_t expr, obj_t opnd) {
  return new pre_op(unique_ptr<operand>((operand*)expr),
                    unique_ptr<operand>((operand*)opnd));
}

static obj_t asm_rel(state_t state, obj_t _this) {
  return new rel(unique_ptr<operand>((operand*)_this));
}

static obj_t asm_annotated(state_t state, obj_t ann, obj_t opnd) {
  return new annotated(unique_ptr<annotation>((annotation*)ann),
                       unique_ptr<operand>((operand*)opnd));
}

static obj_t asm_sum(state_t state, obj_t lhs, obj_t rhs) {
  return new sum(unique_ptr<operand>((operand*)lhs),
                 unique_ptr<operand>((operand*)rhs));
}

static obj_t asm_scale(state_t state, int_t factor, obj_t opnd) {
  return new scale(factor, unique_ptr<operand>((operand*)opnd));
}

static obj_t asm_bounded(state_t state, obj_t _boundary, obj_t opnd) {
  return new bounded(unique_ptr<boundary>((boundary*)_boundary),
                     unique_ptr<operand>((operand*)opnd));
  return nullptr;
}

static obj_t asm_sign(state_t state, obj_t _signedness, obj_t opnd) {
  auto __signedness = unique_ptr<signedness>((signedness*)_signedness);
  return new signed_(std::move(*__signedness),
                     unique_ptr<operand>((operand*)opnd));
}

static obj_t asm_composite(state_t state, obj_t opnds) {
  auto _opnds = unique_ptr<operands_t>((operands_t*)opnds);
  return new composite(move(*_opnds));
}

// signedness

static obj_t asm_signed(state_t state) {
  return new signedness(signedness::SIGNED);
}

static obj_t asm_unsigned(state_t state) {
  return new signedness(signedness::UNSIGNED);
}

// boundary

static obj_t asm_sz(state_t state, int_t sz) { return new boundary(sz); }

static obj_t asm_sz_o(state_t state, int_t sz, int_t o) {
  return new offset_boundary(sz, o);
}

// annotation list

static obj_t asm_annotations_next(state_t state, obj_t next, obj_t list) {
  annotations_t* annotations = (annotations_t*)list;
  annotations->push_back(unique_ptr<annotation>((annotation*)next));
  return list;
}

static obj_t asm_annotations_init(state_t state) { return new annotations_t(); }

// annotation

static obj_t asm_annotation_string(state_t state, string_t _this) {
  return new string_annotation(std::string(_this));
}

static obj_t asm_annotation_function(state_t state, string_t name, obj_t args) {
  auto _args = unique_ptr<operands_t>((operands_t*)args);
  return new function_annotation(std::string(name), move(*_args));
}

static obj_t asm_annotation_opnd(state_t state, string_t name, obj_t opnds) {
  auto _opnds = unique_ptr<operands_t>((operands_t*)opnds);
  return new operand_annotation(std::string(name), move(*_opnds));
}

using cb_up_t =
    std::unique_ptr<unboxed_asm_callbacks_t, void (*)(asm_callbacks_t)>;

static cb_up_t asm_builder_callbacks_get(state_t state) {
  unboxed_asm_opnd_list_callbacks_t asm_opnd_list_callbacks;
  asm_opnd_list_callbacks.opnd_list_next = &asm_opnds_next;
  asm_opnd_list_callbacks.init = &asm_opnds_init;

  unboxed_asm_opnd_callbacks_t asm_opnd_callbacks;
  asm_opnd_callbacks.opnd_register = &asm_register;
  asm_opnd_callbacks.memory = &asm_memory;
  asm_opnd_callbacks.imm = &asm_imm;
  asm_opnd_callbacks.post_op = &asm_post_op;
  asm_opnd_callbacks.pre_op = &asm_pre_op;
  asm_opnd_callbacks.rel = &asm_rel;
  asm_opnd_callbacks.annotated = &asm_annotated;
  asm_opnd_callbacks.sum = &asm_sum;
  asm_opnd_callbacks.scale = &asm_scale;
  asm_opnd_callbacks.bounded = &asm_bounded;
  asm_opnd_callbacks.sign = &asm_sign;
  asm_opnd_callbacks.composite = &asm_composite;

  unboxed_asm_signedness_callbacks_t asm_signedness_callbacks;
  asm_signedness_callbacks.asm_signed = &asm_signed;
  asm_signedness_callbacks.asm_unsigned = &asm_unsigned;

  unboxed_asm_boundary_callbacks_t asm_boundary_callbacks;
  asm_boundary_callbacks.sz = &asm_sz;
  asm_boundary_callbacks.sz_o = &asm_sz_o;

  unboxed_asm_annotation_list_callbacks_t asm_annotation_list_callbacks;
  asm_annotation_list_callbacks.annotation_list_next = &asm_annotations_next;
  asm_annotation_list_callbacks.init = &asm_annotations_init;

  unboxed_asm_annotation_callbacks_t asm_annotation_callbacks;
  asm_annotation_callbacks.ann_string = &asm_annotation_string;
  asm_annotation_callbacks.function = &asm_annotation_function;
  asm_annotation_callbacks.opnd = &asm_annotation_opnd;

  struct unboxed_callbacks {
    unboxed_asm_callbacks_t callbacks;

    unboxed_asm_opnd_list_callbacks_t asm_opnd_list_callbacks;
    unboxed_asm_opnd_callbacks_t asm_opnd_callbacks;
    unboxed_asm_signedness_callbacks_t asm_signedness_callbacks;
    unboxed_asm_boundary_callbacks_t asm_boundary_callbacks;
    unboxed_asm_annotation_list_callbacks_t asm_annotation_list_callbacks;
    unboxed_asm_annotation_callbacks_t asm_annotation_callbacks;
  };

  unboxed_callbacks* callbacks_heap =
      (unboxed_callbacks*)malloc(sizeof(unboxed_callbacks));

  callbacks_heap->asm_opnd_list_callbacks = asm_opnd_list_callbacks;
  callbacks_heap->asm_opnd_callbacks = asm_opnd_callbacks;
  callbacks_heap->asm_signedness_callbacks = asm_signedness_callbacks;
  callbacks_heap->asm_boundary_callbacks = asm_boundary_callbacks;
  callbacks_heap->asm_annotation_list_callbacks = asm_annotation_list_callbacks;
  callbacks_heap->asm_annotation_callbacks = asm_annotation_callbacks;

  unboxed_asm_callbacks_t asm_callbacks;
  asm_callbacks.insn = &asm_insn;
  asm_callbacks.opnd_list = &callbacks_heap->asm_opnd_list_callbacks;
  asm_callbacks.opnd = &callbacks_heap->asm_opnd_callbacks;
  asm_callbacks.signedness = &callbacks_heap->asm_signedness_callbacks;
  asm_callbacks.boundary = &callbacks_heap->asm_boundary_callbacks;
  asm_callbacks.annotation_list =
      &callbacks_heap->asm_annotation_list_callbacks;
  asm_callbacks.annotation = &callbacks_heap->asm_annotation_callbacks;

  callbacks_heap->callbacks = asm_callbacks;

  return cb_up_t((asm_callbacks_t)&callbacks_heap->callbacks,
                 [](asm_callbacks_t c) { free(c); });
}

assembly::instruction asm_builder::convert(asm_insn_t gisn) {
  struct frontend frontend_glob = g->get_frontend()->native();
  if (setjmp(*frontend_glob.generic.err_tgt(g->get_state())))
    throw gdsl_exception(
        "convert() failed",
        std::string(frontend_glob.generic.get_error_message(g->get_state())));
  auto cbs = asm_builder_callbacks_get(g->get_state());
  auto instruction_ptr =
      (assembly::instruction*)(frontend_glob.decoder.asm_convert_insn(
          g->get_state(), cbs.get(), gisn));
  auto instruction_value = std::move(*instruction_ptr);
  delete instruction_ptr;
  return instruction_value;
}

}  // namespace gdsl
