/*
 * This file contains the base class for all RReil
 * ID AST nodes.
 */

#pragma once
#include <iostream>
#include <memory>
#include <string>

#include "cppgdsl/rreil/id/id_visitor.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {
namespace rreil {

class id {
 private:
  virtual void put(std::ostream& out) const = 0;

 protected:
  static size_t subclass_counter;

  id(id const&) = default;
  id& operator=(id const&) = delete;

 public:
  id() = default;
  virtual ~id() = default;

  virtual size_t get_subclass_counter() const = 0;

  std::string to_string() const;

  virtual bool operator<(id const& other) const = 0;
  bool operator<=(id const& other) const {
    return *this < other || *this == other;
  }
  bool operator>(id const& other) const { return !(*this <= other); }
  bool operator>=(id const& other) const { return !(*this < other); }
  /*
   * This operator recursively compares for syntactic equality.
   */
  virtual bool operator==(id const& other) const = 0;
  bool operator!=(id const& other) const { return !(*this == other); }

  virtual std::unique_ptr<id> copy() const = 0;
  virtual void accept(id_visitor& v) const = 0;
  friend std::ostream& operator<<(std::ostream& out, id const& _this);
};

std::ostream& operator<<(std::ostream& out, id const& _this);

}  // namespace rreil
}  // namespace gdsl

/*
 * Include all known subclasses in order to reduce the amount of required
 * includes directives. Clients may include everything related to an
 * id using this header file.
 */
#include "arch_id.h"
#include "shared_id.h"
#include "virtual.h"
