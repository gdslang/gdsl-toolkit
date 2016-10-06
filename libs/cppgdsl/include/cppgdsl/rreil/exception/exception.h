/*
 * This file contains the base class for all RReil
 * exception AST nodes. Exceptions can be thrown as
 * part of the semantics of an instruction, e.g. in case
 * of invalid memory access. These exceptions are defined
 * in the respective processor manuals. It may depend
 * on configuration and the execution mode whether exceptions
 * are thrown or not.
 */

#pragma once
#include <iostream>
#include <memory>
#include <string>

#include "cppgdsl/rreil/exception/exception_visitor.h"

namespace gdsl {
namespace rreil {

class exception {
 private:
  virtual void put(std::ostream& out) const = 0;

 protected:
  exception(exception const&) = default;
  exception& operator=(exception const&) = default;

 public:
  exception() = default;
  virtual ~exception() = default;

  std::string to_string() const;
  friend std::ostream& operator<<(std::ostream& out, exception const& _this);

  virtual std::unique_ptr<exception> copy() const = 0;
  virtual void accept(exception_visitor& v) const = 0;
  /*
   * This operator recursively compares for syntactic equality.
   */
  virtual bool operator==(exception const& o) const = 0;
  bool operator!=(exception const& o) const { return !(*this == o); }
};

std::ostream& operator<<(std::ostream& out, exception const& _this);

}  // namespace rreil
}  // namespace gdsl
