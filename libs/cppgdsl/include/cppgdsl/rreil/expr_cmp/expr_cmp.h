/*
 * expr_cmp.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include "cppgdsl/rreil/expr_cmp/cmp_op.h"
#include "cppgdsl/rreil/linear/linear.h"
#include "cppgdsl/rreil/visitor.h"

namespace gdsl {
namespace rreil {

class expr_cmp {
 private:
  void put(std::ostream& out) const;

 protected:
  cmp_op op;
  std::unique_ptr<linear> lhs;
  std::unique_ptr<linear> rhs;

 public:
  expr_cmp(cmp_op op, std::unique_ptr<linear> lhs, std::unique_ptr<linear> rhs);
  expr_cmp(expr_cmp const& e)
      : op(e.op), lhs(e.lhs->copy()), rhs(e.rhs->copy()) {}
  expr_cmp& operator=(expr_cmp const&) = delete;

  cmp_op get_op() const { return op; }

  linear const& get_lhs() const { return *lhs; }

  linear const& get_rhs() const { return *rhs; }

  std::string to_string() const;
  friend std::ostream& operator<<(std::ostream& out, expr_cmp const& _this);

  std::unique_ptr<expr_cmp> copy() const;
  void accept(visitor& v) const;

  /*
   * This operator recursively compares for syntactic equality.
   */
  bool operator==(expr_cmp const& o) const;
  bool operator!=(expr_cmp const& o) const { return !(*this == o); }
};

std::ostream& operator<<(std::ostream& out, expr_cmp const& _this);

inline std::unique_ptr<expr_cmp> make_expr_cmp(cmp_op op,
                                           std::unique_ptr<linear> lhs,
                                           std::unique_ptr<linear> rhs) {
  return std::unique_ptr<expr_cmp>(
      new expr_cmp(op, std::move(lhs), std::move(rhs)));
}

}  // namespace rreil
}  // namespace gdsl
