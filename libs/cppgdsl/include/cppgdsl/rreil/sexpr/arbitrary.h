/*
 * The file contains all definitions for an RReil AST node that
 * represents an arbitrary (undefined) value. Undefined values
 * are used for memory that is described to be undefined after
 * a certain operation. This way, an analysis is able to track that
 * the respective memory might have been overwritten and that
 * one should not rely on its value any longer.
 */

#pragma once

#include "cppgdsl/rreil/sexpr/sexpr.h"

namespace gdsl {
namespace rreil {

class arbitrary final : public sexpr {
 private:
  void put(std::ostream& out) const override;

 public:
  arbitrary() = default;
  arbitrary(arbitrary const&) = default;
  arbitrary& operator=(arbitrary const&) = delete;

  std::unique_ptr<sexpr> copy() const override;
  void accept(sexpr_visitor& v) const override;
  bool operator==(sexpr const& o) const override;
};

inline std::unique_ptr<sexpr> make_arbitrary() {
  return std::unique_ptr<sexpr>(new arbitrary());
}

}  // namespace rreil
}  // namespace gdsl
