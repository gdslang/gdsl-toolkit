/*
 * The file contains all definitions for an architecture-independent
 * ID RReil AST node. These IDs are shared across the different front-ends.
 */

#pragma once
#include <string>

#include "cppgdsl/rreil/id/id.h"

namespace gdsl {
namespace rreil {

enum shared_id_type { TYPE_FLOATING_FLAGS };

std::string shared_id_type_to_string(shared_id_type t);

class shared_id final : public id {
 private:
  shared_id_type inner;

  void put(std::ostream& out) const override;

  static size_t subclass_counter;

 public:
  shared_id(shared_id_type _id);
  shared_id(shared_id const&) = default;
  shared_id& operator=(shared_id const&) = delete;

  size_t get_subclass_counter() const;
  shared_id_type get_inner() const { return inner; }

  bool operator==(id const& other) const override;
  bool operator<(id const& other) const override;

  std::string to_string() const;
  std::unique_ptr<id> copy() const override;
  void accept(id_visitor& v) const override;
};

inline std::unique_ptr<id> make_id(shared_id_type type) {
  return std::unique_ptr<id>(new shared_id(type));
}

}  // namespace rreil
}  // namespace gdsl
