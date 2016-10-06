/*
 * The file contains all definitions for an RReil load statement.
 */

#pragma once

#include "cppgdsl/rreil/address.h"
#include "cppgdsl/rreil/statement/statement.h"
#include "cppgdsl/rreil/variable.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class load final : public statement {
 private:
  int_t size;
  std::unique_ptr<variable> lhs;
  std::unique_ptr<address> address_;

  void put(std::ostream& out) const override;

 public:
  load(int_t size, std::unique_ptr<variable> lhs,
       std::unique_ptr<address> address_arg);
  load(load const& l)
      : statement(l),
        size(l.size),
        lhs(l.lhs->copy()),
        address_(l.address_->copy()) {}
  load& operator=(load const&) = default;

  int_t get_size() const { return size; }

  variable const& get_lhs() const { return *lhs; }

  address const& get_address() const { return *address_; }

  std::unique_ptr<statement> copy() const override;
  void accept(statement_visitor& v) const override;
  bool operator==(statement const& o) const override;
};

inline std::unique_ptr<statement> make_load(int_t size,
                                            std::unique_ptr<variable> lhs,
                                            std::unique_ptr<address> _address) {
  return std::unique_ptr<statement>(
      new rreil::load(size, std::move(lhs), std::move(_address)));
}

}  // namespace rreil
}  // namespace gdsl
