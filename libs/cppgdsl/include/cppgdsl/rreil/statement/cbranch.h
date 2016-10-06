/*
 * The file contains all definitions for an RReil conditional branch
 * statement.
 */

#pragma once

#include "cppgdsl/rreil/address.h"
#include "cppgdsl/rreil/sexpr/sexpr.h"
#include "cppgdsl/rreil/statement/statement.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class cbranch final : public statement {
 private:
  std::unique_ptr<sexpr> cond;
  std::unique_ptr<address> target_true;
  std::unique_ptr<address> target_false;

  void put(std::ostream& out) const override;

 public:
  cbranch(std::unique_ptr<sexpr> cond, std::unique_ptr<address> target_true,
          std::unique_ptr<address> target_false);
  cbranch(cbranch const& c)
      : statement(c),
        cond(c.cond->copy()),
        target_true(c.target_true->copy()),
        target_false(c.target_false->copy()) {}
  cbranch& operator=(cbranch const&) = default;

  sexpr const& get_cond() const { return *cond; }

  address const& get_target_true() const { return *target_true; }

  address const& get_target_false() const { return *target_false; }

  std::unique_ptr<statement> copy() const override;
  void accept(statement_visitor& v) const override;
  bool operator==(statement const& o) const override;
};

inline std::unique_ptr<statement> make_cbranch(
    std::unique_ptr<sexpr> cond, std::unique_ptr<address> target_true,
    std::unique_ptr<address> target_false) {
  return std::unique_ptr<statement>(new cbranch(
      std::move(cond), std::move(target_true), std::move(target_false)));
}

}  // namespace rreil
}  // namespace gdsl
