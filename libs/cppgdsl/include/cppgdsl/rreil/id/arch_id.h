/*
 * The file contains all definitions for an architecture
 * ID (e.g. a register) RReil AST node.
 */

#pragma once
#include <string>

#include "cppgdsl/rreil/id/id.h"

namespace gdsl {
namespace rreil {

class arch_id final : public id {
 private:
  std::string name;

  void put(std::ostream& out) const override;

  static size_t subclass_counter;

 public:
  arch_id(std::string name);
  arch_id(arch_id const&) = default;
  arch_id& operator=(arch_id const&) = delete;

  size_t get_subclass_counter() const override;

  const std::string& get_name() const { return name; }

  bool operator==(id const& other) const override;
  bool operator<(id const& other) const override;
  std::unique_ptr<id> copy() const override;
  void accept(id_visitor& v) const override;
};

inline std::unique_ptr<id> make_id(std::string name) {
  return std::unique_ptr<id>(new arch_id(std::move(name)));
}

}  // namespace rreil
}  // namespace gdsl
