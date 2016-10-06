/*
 * The file contains all definitions for an RReil assignment statement.
 */

#pragma once

#include "cppgdsl/rreil/expr/expr.h"
#include "cppgdsl/rreil/statement/statement.h"
#include "cppgdsl/rreil/variable.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class assign final : public statement {
 private:
  int_t size;
  std::unique_ptr<variable> lhs;
  std::unique_ptr<expr> rhs;

  void put(std::ostream& out) const override;

 public:
  assign(int_t size, std::unique_ptr<variable> lhs, std::unique_ptr<expr> rhs);
  assign(assign const& a)
      : statement(a), size(a.size), lhs(a.lhs->copy()), rhs(a.rhs->copy()) {}
  assign& operator=(assign const&) = default;

  int_t get_size() const { return size; }

  variable const& get_lhs() const { return *lhs; }

  expr const& get_rhs() const { return *rhs; }

  std::unique_ptr<statement> copy() const override;
  void accept(statement_visitor& v) const override;
  bool operator==(statement const& o) const override;
};

inline std::unique_ptr<statement> make_assign(int_t size,
                                              std::unique_ptr<variable> lhs,
                                              std::unique_ptr<expr> rhs) {
  return std::unique_ptr<statement>(
      new rreil::assign(size, std::move(lhs), std::move(rhs)));
}

class variable;
std::unique_ptr<linear> make_linear(std::unique_ptr<variable> linear_arg);
std::unique_ptr<linear> make_linear(int_t linear_arg);

template <typename T>
std::unique_ptr<statement> make_assign(int_t size,
                                       std::unique_ptr<variable> lhs, T arg) {
  return make_assign(size, std::move(lhs),
                     make_expr(make_linear(std::move(arg))));
}

std::unique_ptr<statement> make_assign(int_t size, std::unique_ptr<id> lhs,
                                       std::unique_ptr<expr> rhs);

std::unique_ptr<statement> make_assign(int_t size, std::unique_ptr<id> lhs,
                                       std::unique_ptr<id> id_arg);

std::unique_ptr<statement> make_assign(int_t size, std::unique_ptr<id> lhs,
                                       int_t const_arg);

}  // namespace rreil
}  // namespace gdsl
