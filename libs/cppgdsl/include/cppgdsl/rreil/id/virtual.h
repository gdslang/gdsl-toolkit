/*
 * This file contains all definitions for a temporary ID
 * RReil AST node. A temporary ID is an ID used by RReil
 * to express the semantics of more complex machine
 * instructions by means of simple RReil statements.
 */

#pragma once
#include <string>

#include "cppgdsl/rreil/id/id.h"

namespace gdsl {
namespace rreil {

class _virtual final : public id {
 private:
  /*
   * The ID number of this temporary variable; an RReil
   * temporary ID is identified by its ID number and
   * usage area.
   */
  int_t t;

  /*
   * Usage area of the ID; an ID can either be an ordinary
   * temporary (opt is set to 'false') or an ID introduced during
   * optimization (opt is set to 'true').
   */
  bool opt;

  void put(std::ostream& out) const override;

  static size_t subclass_counter;

 public:
  _virtual(int_t t, bool opt);
  _virtual(_virtual const&) = default;
  _virtual& operator=(_virtual const&) = delete;

  size_t get_subclass_counter() const override;
  int_t get_t() const;
  bool get_opt() const;

  bool operator==(id const& other) const override;
  bool operator<(id const& other) const override;
  std::unique_ptr<id> copy() const override;
  void accept(id_visitor& v) const override;
};

inline std::unique_ptr<id> make_id(int_t t, bool opt) {
  return std::unique_ptr<id>(new _virtual(t, opt));
}

}  // namespace rreil
}  // namespace gdsl
