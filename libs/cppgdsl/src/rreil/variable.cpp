#include "cppgdsl/rreil/variable.h"

#include <sstream>

using namespace std;

namespace gdsl {
namespace rreil {

void variable::put(std::ostream& out) const {
  this->offset ? out << *_id << "." << offset : out << *_id;
}

variable::variable(std::unique_ptr<id> _id, int_t offset)
    : _id(move(_id)), offset(offset) {}

std::string gdsl::rreil::variable::to_string() {
  std::stringstream o;
  o << *this;
  return o.str();
}

std::ostream& operator<<(std::ostream& out, variable const& _this) {
  _this.put(out);
  return out;
}

std::unique_ptr<variable> variable::copy() const {
  return std::unique_ptr<variable>(new variable(*this));
}

void variable::accept(visitor& v) const { v.visit(this); }

bool variable::operator==(variable const& other) const {
  return this->offset == other.offset && *this->_id == *other._id;
}

}  // namespace rreil
}  // namespace gdsl
