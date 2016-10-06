/*
 * This file contains the base class for all RReil
 * linear AST nodes.
 */

#pragma once
#include <iostream>
#include <memory>
#include <string>

#include "cppgdsl/rreil/linear/linear_visitor.h"

namespace gdsl {
namespace rreil {

class linear {
 private:
  virtual void put(std::ostream& out) const = 0;

 protected:
  linear(linear const&) = default;
  linear& operator=(linear const&) = delete;

 public:
  linear() = default;
  virtual ~linear() = default;

  std::string to_string() const;
  friend std::ostream& operator<<(std::ostream& out, linear const& _this);

  virtual std::unique_ptr<linear> copy() const = 0;
  virtual void accept(linear_visitor& v) const = 0;
  /*
   * This operator recursively compares for syntactic equality.
   */
  virtual bool operator==(linear const& o) const = 0;
  bool operator!=(linear const& o) const { return !(*this == o); }
};

std::ostream& operator<<(std::ostream& out, linear const& _this);

inline std::unique_ptr<linear> make_linear(std::unique_ptr<linear> linear_arg) {
  return std::move(linear_arg);
}

}  // namespace rreil
}  // namespace gdsl

/*
 * Include all known subclasses in order to reduce the amount of required
 * include directives. Clients may include everything related to a
 * linear expression using this header file.
 */
#include "binop_lin_op.h"
#include "lin_binop.h"
#include "lin_imm.h"
#include "lin_scale.h"
#include "lin_var.h"
#include "linear_visitor.h"
