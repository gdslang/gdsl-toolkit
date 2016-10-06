/*
 * The file contains all definitions for an RReil conditional statement.
 */

#pragma once
#include <vector>

#include "cppgdsl/iterator.h"
#include "cppgdsl/rreil/sexpr/sexpr.h"
#include "cppgdsl/rreil/statement/statement.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class ite final : public statement {
 private:
  std::unique_ptr<sexpr> cond;
  statements_t then_branch;
  statements_t else_branch;

  void put(std::ostream& out) const override;

 public:
  ite(std::unique_ptr<sexpr> cond, statements_t then_branch,
      statements_t else_branch);
  ite(ite const&);
  ite& operator=(ite const&) = default;

  sexpr const& get_cond() const { return *cond; }

  iterable<statement> get_then_branch() const {
    return iterable<statement>(then_branch);
  }

  iterable<statement> get_else_branch() const {
    return iterable<statement>(else_branch);
  }

  std::unique_ptr<statement> copy() const override;
  void accept(statement_visitor& v) const override;
  bool operator==(statement const& o) const override;
};

inline std::unique_ptr<statement> make_ite(std::unique_ptr<sexpr> cond,
                                           statements_t then_branch,
                                           statements_t else_branch) {
  return std::unique_ptr<statement>(
      new ite(std::move(cond), std::move(then_branch), std::move(else_branch)));
}

}  // namespace rreil
}  // namespace gdsl
