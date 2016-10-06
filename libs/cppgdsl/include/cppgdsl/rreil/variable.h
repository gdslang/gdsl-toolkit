/*
 * The file contains all definitions for an RReil AST node that
 * represents a variable. A variable is an ID plus an offset.
 */

#pragma once
#include <iostream>
#include <memory>
#include <string>

#include "cppgdsl/rreil/id/id.h"
#include "cppgdsl/rreil/visitor.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class variable {
 protected:
  std::unique_ptr<id> _id;
  int_t offset;

  virtual void put(std::ostream& out) const;

  variable(variable const& v) : _id(v._id->copy()), offset(v.offset) {}
  variable& operator=(variable const&) = default;

 public:
  variable(std::unique_ptr<id> _id, int_t offset);
  virtual ~variable() = default;

  id const& get_id() const { return *_id; }

  int_t get_offset() const { return offset; }

  std::string to_string();

  virtual std::unique_ptr<variable> copy() const;
  virtual void accept(visitor& v) const;

  /*
   * This operator recursively compares for syntactic equality.
   */
  virtual bool operator==(variable const& other) const;
  bool operator!=(variable const& o) const { return !(*this == o); }

  friend std::ostream& operator<<(std::ostream& out, variable const& _this);
};

std::ostream& operator<<(std::ostream& out, variable const& _this);

inline std::unique_ptr<variable> make_variable(std::unique_ptr<id> _id,
                                               int_t offset = 0) {
  return std::unique_ptr<variable>(new variable(std::move(_id), offset));
}

}  // namespace rreil
}  // namespace gdsl
