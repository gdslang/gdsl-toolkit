/*
 * The file contains all definitions for an architecture-specific
 * exception RReil AST node. Architecture-specific exceptions are
 * exceptions that are specific to the architecture of the processor
 * whose instructions are decoded.
 */

#pragma once
#include <string>

#include "cppgdsl/rreil/exception/exception.h"

namespace gdsl {
namespace rreil {

class arch_exception final : public exception {
 private:
  std::string name;

  void put(std::ostream& out) const override;

 public:
  arch_exception(std::string name);
  arch_exception(arch_exception const&) = default;
  arch_exception& operator=(arch_exception const&) = default;

  const std::string& get_name() const { return name; }

  std::unique_ptr<exception> copy() const override;
  void accept(exception_visitor& v) const override;
  bool operator==(exception const& o) const override;
};

inline std::unique_ptr<exception> make_exception(std::string name) {
  return std::unique_ptr<exception>(new arch_exception(name));
}

}  // namespace rreil
}  // namespace gdsl
