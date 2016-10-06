/*
 * The file contains all definitions for an RReil throw statement.
 */

#pragma once

#include "cppgdsl/rreil/exception/exception.h"
#include "cppgdsl/rreil/statement/statement.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class _throw final : public statement {
 private:
  std::unique_ptr<exception> inner;

  void put(std::ostream& out) const override;

 public:
  explicit _throw(std::unique_ptr<exception> inner);
  _throw(_throw const& t) : statement(t), inner(t.inner->copy()) {}
  _throw& operator=(_throw const&) = default;

  exception const& get_inner() const { return *inner; }

  std::unique_ptr<statement> copy() const override;
  void accept(statement_visitor& v) const override;
  bool operator==(statement const& o) const override;
};

inline std::unique_ptr<statement> make_throw(std::unique_ptr<exception> inner) {
  return std::unique_ptr<statement>(new _throw(std::move(inner)));
}

}  // namespace rreil
}  // namespace gdsl
