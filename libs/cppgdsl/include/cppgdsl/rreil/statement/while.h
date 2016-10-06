/*
 * The file contains all definitions for an RReil while statement.
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

class _while final : public statement {
 private:
  std::unique_ptr<sexpr> cond;
  statements_t body;

  void put(std::ostream& out) const override;

 public:
  _while(std::unique_ptr<sexpr> cond, statements_t body);
  _while(_while const& w);
  _while& operator=(_while const&) = default;

  sexpr const& get_cond() const { return *cond; }

  iterable<statement> get_body() const { return iterable<statement>(body); }

  std::unique_ptr<statement> copy() const override;
  void accept(statement_visitor& v) const override;
  bool operator==(statement const& o) const override;
};

inline std::unique_ptr<statement> make_while(std::unique_ptr<sexpr> cond,
                                             statements_t body) {
  return std::unique_ptr<statement>(
      new _while(std::move(cond), std::move(body)));
}

}  // namespace rreil
}  // namespace gdsl
