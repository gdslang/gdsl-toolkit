/*
 * The file contains all definitions for an RReil AST node that
 * represents a limited variable. A variable is an ID plus an offset.
 * A limited variable is an ID plus an offset and a size.
 */

#pragma once
#include <vector>

#include "cppgdsl/rreil/variable.h"
#include "cppgdsl/rreil/visitor.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class variable_limited final : public variable {
 private:
  int_t size;

 protected:
  void put(std::ostream& out) const override;

 public:
  variable_limited(std::unique_ptr<id> _id, int_t offset, int_t size);
  variable_limited(variable_limited const& v) = default;
  variable_limited& operator=(variable_limited const&) = default;

  int_t get_size() const { return size; }

  virtual std::unique_ptr<variable> copy() const override;
  void accept(visitor& v) const override;
  bool operator==(variable const& o) const override;
};

using variables_limited_t = std::vector<std::unique_ptr<variable_limited>>;

variables_limited_t copy(variables_limited_t const& vars_limited);

inline std::unique_ptr<variable_limited> make_variable(std::unique_ptr<id> _id,
                                                       int_t offset,
                                                       int_t size) {
  return std::unique_ptr<variable_limited>(
      new rreil::variable_limited(std::move(_id), offset, size));
}

}  // namespace rreil
}  // namespace gdsl
