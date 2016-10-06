/*
 * The file contains all definitions for an RReil AST node that is
 * a linear expression representing a variable.
 */

#pragma once
#include <memory>
#include <string>

#include "cppgdsl/rreil/linear/linear.h"
#include "cppgdsl/rreil/variable.h"

namespace gdsl {
namespace rreil {

class lin_var final : public linear {
 private:
  std::unique_ptr<variable> var;

  void put(std::ostream& out) const override;

 public:
  lin_var(std::unique_ptr<variable> var);
  lin_var(lin_var const& lv) : linear(lv), var(lv.var->copy()) {}
  lin_var& operator=(lin_var const&) = delete;

  variable const& get_var() const { return *var; }

  std::unique_ptr<linear> copy() const override;
  void accept(linear_visitor& v) const override;
  bool operator==(linear const& o) const override;
};

inline std::unique_ptr<linear> make_linear(std::unique_ptr<variable> var) {
  return std::unique_ptr<linear>(new lin_var(std::move(var)));
}

}  // namespace rreil
}  // namespace gdsl
