/*
 * The file contains all definitions for an offset boundary ASM
 * AST node. An offset boundary is a boundary that allows to
 * additionally specify an offset.
 */

#pragma once
#include <memory>

#include "cppgdsl/assembly/boundary/boundary.h"

namespace gdsl {
namespace assembly {

class offset_boundary final : public boundary {
 private:
  int_t offset;

  void put(std::ostream& out) const override;

 public:
  offset_boundary(int_t size, int_t offset) : boundary(size), offset(offset) {}

  int_t get_offset() const { return offset; }

  virtual void accept(boundary_visitor& v) const override { v.visit(this); }
  bool operator==(boundary const& o) const override;
};

inline std::unique_ptr<boundary> make_boundary(int_t size, int_t offset) {
  return std::unique_ptr<boundary>(new offset_boundary(size, offset));
}

}  // namespace assembly
}  // namespace gdsl
