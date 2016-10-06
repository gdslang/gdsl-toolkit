/*
 * The file contains all definitions for an RReil store statement.
 */

#pragma once

#include "cppgdsl/rreil/address.h"
#include "cppgdsl/rreil/linear/linear.h"
#include "cppgdsl/rreil/statement/statement.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class store final : public statement {
 private:
  int_t size;
  std::unique_ptr<address> address_;
  std::unique_ptr<linear> rhs;

  void put(std::ostream& out) const override;

 public:
  store(int_t size, std::unique_ptr<address> address_arg,
        std::unique_ptr<linear> rhs);
  store(store const& s)
      : statement(s),
        size(s.size),
        address_(s.address_->copy()),
        rhs(s.rhs->copy()) {}
  store& operator=(store const&) = default;

  int_t get_size() const { return size; }

  address const& get_address() const { return *address_; }

  linear const& get_rhs() const { return *rhs; }

  std::unique_ptr<statement> copy() const override;
  void accept(statement_visitor& v) const override;
  bool operator==(statement const& o) const override;
};

inline std::unique_ptr<statement> make_store(
    int_t size, std::unique_ptr<address> address_arg,
    std::unique_ptr<linear> rhs) {
  return std::unique_ptr<statement>(
      new rreil::store(size, std::move(address_arg), std::move(rhs)));
}

}  // namespace rreil
}  // namespace gdsl
