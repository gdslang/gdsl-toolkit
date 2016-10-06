/*
 * The file contains all definitions for an RReil branch statement.
 */

#pragma once

#include "cppgdsl/rreil/address.h"
#include "cppgdsl/rreil/branch_hint.h"
#include "cppgdsl/rreil/statement/statement.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class branch final : public statement {
 private:
  std::unique_ptr<address> target;
  branch_hint hint;

  void put(std::ostream& out) const override;

 public:
  branch(std::unique_ptr<address> target, branch_hint hint);
  branch(branch const& b)
      : statement(b), target(b.target->copy()), hint(b.hint) {}
  branch& operator=(branch const&) = default;

  address const& get_target() const { return *target; }

  branch_hint get_hint() const { return hint; }

  std::unique_ptr<statement> copy() const override;
  void accept(statement_visitor& v) const override;
  bool operator==(statement const& o) const override;
};

inline std::unique_ptr<statement> make_branch(std::unique_ptr<address> target,
                                              branch_hint hint) {
  return std::unique_ptr<statement>(new branch(std::move(target), hint));
}

}  // namespace rreil
}  // namespace gdsl
