/*
 * The file contains all definitions for an RReil AST node that is
 * a linear expression representing an immediate value.
 */

#pragma once
#include <string>

#include "cppgdsl/rreil/linear/linear.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class lin_imm final : public linear {
 private:
  /*
   * The immediate value is of the GDSL integer type. It
   * is defined in the generated GDSL header.
   */
  int_t const_;

  void put(std::ostream& out) const override;

 public:
  lin_imm(int_t const_arg);
  lin_imm(lin_imm const&) = default;
  lin_imm& operator=(lin_imm const&) = delete;

  int_t get_imm() const { return const_; }

  std::unique_ptr<linear> copy() const override;
  void accept(linear_visitor& v) const override;
  bool operator==(linear const& o) const override;
};

inline std::unique_ptr<linear> make_linear(int_t const_arg) {
  return std::unique_ptr<linear>(new lin_imm(const_arg));
}

}  // namespace rreil
}  // namespace gdsl
