/*
 * The file contains all definitions for an architecture-independent
 * exception RReil AST node.
 */

#pragma once
#include "cppgdsl/rreil/exception/exception.h"

namespace gdsl {
namespace rreil {

enum shared_exception_type { TYPE_DIVISION_BY_ZERO };

std::string shared_exception_type_to_string(shared_exception_type t);

class shared_exception final : public exception {
 private:
  shared_exception_type type;

  void put(std::ostream& out) const override;

 public:
  shared_exception(shared_exception_type type);
  shared_exception(shared_exception const&) = default;
  shared_exception& operator=(shared_exception const&) = default;

  shared_exception_type get_type() const { return type; }

  std::unique_ptr<exception> copy() const override;
  void accept(exception_visitor& v) const override;
  bool operator==(exception const& o) const override;
};

inline std::unique_ptr<exception> make_exception(shared_exception_type type) {
  return std::unique_ptr<exception>(new shared_exception(type));
}

}  // namespace rreil
}  // namespace gdsl
