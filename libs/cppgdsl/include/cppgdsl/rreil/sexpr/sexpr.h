/*
 * This file contains the base class for all RReil
 * exception AST nodes. A simple expression is an expression that
 * can be used in conditionals.
 */

#pragma once
#include <iostream>
#include <memory>
#include <string>

#include "cppgdsl/rreil/sexpr/sexpr_visitor.h"

namespace gdsl {
namespace rreil {

class sexpr {
 private:
  virtual void put(std::ostream& out) const = 0;

 protected:
  sexpr(sexpr const&) = default;
  sexpr& operator=(sexpr const&) = delete;

 public:
  sexpr() = default;
  virtual ~sexpr() = default;

  std::string to_string() const;
  friend std::ostream& operator<<(std::ostream& out, sexpr const& _this);

  virtual std::unique_ptr<sexpr> copy() const = 0;
  virtual void accept(sexpr_visitor& v) const = 0;
  /*
   * This operator recursively compares for syntactic equality.
   */
  virtual bool operator==(sexpr const& o) const = 0;
  bool operator!=(sexpr const& o) const { return !(*this == o); }
};

std::ostream& operator<<(std::ostream& out, sexpr const& _this);

}  // namespace rreil
}  // namespace gdsl

/*
 * Include all known subclasses in order to reduce the amount of required
 * includes directives. Clients may include everything related to a
 * simple expression using this header file.
 */
#include "arbitrary.h"
#include "sexpr_cmp.h"
#include "sexpr_lin.h"
#include "sexpr_visitor.h"
