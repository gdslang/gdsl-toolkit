/*
 * The file contains all definitions for an RReil primitive statement.
 * Primitives implement CPU functionality that cannot be expressed using
 * RReil.
 */

#pragma once
#include <string>
#include <vector>

#include "cppgdsl/iterator.h"
#include "cppgdsl/rreil/statement/statement.h"
#include "cppgdsl/rreil/variable.h"
#include "cppgdsl/rreil/variable_limited.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class prim final : public statement {
 private:
  std::string op;
  variables_limited_t lhs;
  variables_limited_t rhs;

  void put(std::ostream& out) const override;

 public:
  prim(std::string op, variables_limited_t lhs, variables_limited_t rhs);
  prim(prim const&);
  prim& operator=(prim const&) = default;

  std::string get_op() const { return op; }

  iterable<variable_limited> get_lhs() const {
    return iterable<variable_limited>(lhs);
  }

  iterable<variable_limited> get_rhs() const {
    return iterable<variable_limited>(rhs);
  }

  std::unique_ptr<statement> copy() const override;
  void accept(statement_visitor& v) const override;
  bool operator==(statement const& o) const override;
};

inline std::unique_ptr<statement> make_prim(std::string op,
                                            variables_limited_t lhs,
                                            variables_limited_t rhs) {
  return std::unique_ptr<statement>(
      new rreil::prim(std::move(op), std::move(lhs), std::move(rhs)));
}

}  // namespace rreil
}  // namespace gdsl
