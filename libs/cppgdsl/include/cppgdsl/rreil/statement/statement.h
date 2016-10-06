/*
 * This file contains the base class for all RReil
 * statement AST nodes.
 */

#pragma once
#include <iostream>
#include <memory>
#include <string>
#include <vector>

#include "cppgdsl/rreil/statement/statement_visitor.h"

namespace gdsl {
namespace rreil {

// Acts as the base class for all expression and statement types in the RReil
// language.
class statement {
 private:
  virtual void put(std::ostream& out) const = 0;
  friend std::ostream& operator<<(std::ostream& out,
                                  const statement& statement);

 protected:
  statement(statement const&) = default;
  statement& operator=(statement const&) = default;

 public:
  statement() = default;
  virtual ~statement() = default;

  virtual std::unique_ptr<statement> copy() const = 0;
  virtual void accept(statement_visitor& v) const = 0;
  std::string to_string() const;
  /*
   * This operator recursively compares for syntactic equality.
   */
  virtual bool operator==(statement const& o) const = 0;
  bool operator!=(statement const& o) const { return !(*this == o); }
};

// Appends the string representation of the given statement to the output
// stream.
std::ostream& operator<<(std::ostream& out, statement const& statement);

using statements_t = std::vector<std::unique_ptr<statement>>;

statements_t copy(statements_t const& stmts);

}  // namespace rreil
}  // namespace gdsl
