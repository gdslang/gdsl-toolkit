/*
 * The file contains all definitions for an RReil floating point statement.
 */

#pragma once
#include <vector>

#include "cppgdsl/iterator.h"
#include "cppgdsl/rreil/flop.h"
#include "cppgdsl/rreil/statement/statement.h"
#include "cppgdsl/rreil/variable.h"
#include "cppgdsl/rreil/variable_limited.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class floating final : public statement {
 private:
  flop op;
  std::unique_ptr<variable> flags;
  std::unique_ptr<variable_limited> lhs;
  variables_limited_t rhs;

  void put(std::ostream& out) const override;

 public:
  floating(flop op, std::unique_ptr<variable> flags,
           std::unique_ptr<variable_limited> lhs, variables_limited_t rhs);
  floating(floating const&);
  floating& operator=(floating const&) = default;

  flop get_op() const { return op; }

  variable const& get_flags() const { return *flags; }

  variable_limited const& get_lhs() const { return *lhs; }

  iterable<variable_limited> get_rhs() const {
    return iterable<variable_limited>(rhs);
  }

  std::unique_ptr<statement> copy() const override;
  void accept(statement_visitor& v) const override;
  bool operator==(statement const& o) const override;
};

inline std::unique_ptr<statement> make_floating(
    flop op, std::unique_ptr<variable> flags,
    std::unique_ptr<variable_limited> lhs, variables_limited_t rhs) {
  return std::unique_ptr<statement>(
      new floating(op, std::move(flags), std::move(lhs), std::move(rhs)));
}

}  // namespace rreil
}  // namespace gdsl
