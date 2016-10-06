#include "cppgdsl/rreil/statement/statement.h"

#include <sstream>

namespace gdsl {
namespace rreil {

std::ostream& operator<<(std::ostream& out, const statement& statement) {
  statement.put(out);
  return out;
}

std::string statement::to_string() const {
  std::stringstream o;
  o << *this;
  return o.str();
}

statements_t copy(const statements_t& stmts) {
  statements_t copied;
  copied.reserve(stmts.size());
  for (auto const& stmt : stmts) copied.emplace_back(stmt->copy());
  return copied;
}

}  // namespace rreil
}  // namespace gdsl
