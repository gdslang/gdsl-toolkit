/*
 * This file contains the base class for all ASM boundary AST nodes.
 * A boundary bounds the size of an object and optionally allows
 * to specify an offset (see the offset_boundary class).
 */

#pragma once
#include <iostream>
#include <memory>

#include "cppgdsl/assembly/boundary/boundary_visitor.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace assembly {

class boundary {
 private:
  int_t size;

  virtual void put(std::ostream& out) const;

 public:
  boundary(int_t size) : size(size) {}
  virtual ~boundary() = default;

  int_t get_size() const { return size; }

  virtual void accept(boundary_visitor& v) const { v.visit(this); }
  /*
   * This operator recursively compares for syntactic equality.
   */
  virtual bool operator==(boundary const& o) const;
  bool operator!=(boundary const& o) const { return !(*this == o); }

  friend std::ostream& operator<<(std::ostream& out, boundary const& _this);
};

std::ostream& operator<<(std::ostream& out, boundary const& _this);

inline std::unique_ptr<boundary> make_boundary(int_t size) {
  return std::unique_ptr<boundary>(new boundary(size));
}

}  // namespace assembly
}  // namespace gdsl
