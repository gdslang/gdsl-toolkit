/*
 * This file contains the base class for all RReil
 * expression AST nodes.
 */

#pragma once
#include <iostream>
#include <memory>
#include <string>

#include "cppgdsl/rreil/expr/expr_visitor.h"

namespace gdsl {
namespace rreil {

class expr {
 private:
  virtual void put(std::ostream& out) const = 0;

 protected:
  expr(expr const&) = default;
  expr& operator=(expr const&) = delete;

 public:
  expr() = default;
  virtual ~expr() = default;

  std::string to_string();
  friend std::ostream& operator<<(std::ostream& out, expr& _this);

  virtual std::unique_ptr<expr> copy() const = 0;
  virtual void accept(expr_visitor& v) const = 0;
  /*
   * This operator recursively compares for syntactic equality.
   */
  virtual bool operator==(expr const& o) const = 0;
  bool operator!=(expr const& o) const { return !(*this == o); }
};

std::ostream& operator<<(std::ostream& out, expr& _this);

}  // namespace rreil
}  // namespace gdsl

/*
 * Include all known subclasses in order to reduce the amount of required
 * includes directives. Clients may include everything related to an
 * expression using this header file.
 */
#include "binop_op.h"
#include "expr_binop.h"
#include "expr_ext.h"
#include "expr_sexpr.h"
#include "expr_visitor.h"
