/*
 * The file contains all definitions for an RReil AST node that
 * represents an address.
 */

#pragma once
#include <string>

#include "cppgdsl/rreil/linear/linear.h"
#include "cppgdsl/rreil/visitor.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class address {
 private:
  int_t size;
  std::unique_ptr<linear> lin;

 public:
  address(int_t size, std::unique_ptr<linear> lin);
  address(address const& a) : size(a.size), lin(a.lin->copy()) {}
  address& operator=(address const&) = default;

  linear const& get_lin() const { return *lin; }

  int_t get_size() const { return size; }

  std::string to_string() const;
  friend std::ostream& operator<<(std::ostream& out, address const& _this);

  std::unique_ptr<address> copy() const;
  void accept(visitor& v) const;

  /*
   * This operator recursively compares for syntactic equality.
   */
  bool operator==(address const& other) const {
    return this->size == other.size && *this->lin == *other.lin;
  }
  bool operator!=(address const& o) const { return !(*this == o); }
};

std::ostream& operator<<(std::ostream& out, address const& _this);

class variable;
std::unique_ptr<linear> make_linear(std::unique_ptr<variable> linear_arg);
std::unique_ptr<linear> make_linear(int_t linear_arg);

template <typename T>
std::unique_ptr<address> make_address(int size, T&& p) {
  return std::unique_ptr<address>(new address(size, std::move(p)));
}

}  // namespace rreil
}  // namespace gdsl
