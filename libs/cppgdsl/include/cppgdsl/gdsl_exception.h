/*
 * The file defines an exception type used throughout the library
 * for GDSL failures.
 */

#pragma once
#include <iostream>
#include <string>

namespace gdsl {

class gdsl_exception {
 private:
  std::string cppgdsl_message;
  std::string gdsl_message;

 public:
  gdsl_exception(std::string cppgdsl_message, std::string gdsl_message);

  const std::string& get_cppgdslmessage() const { return cppgdsl_message; }

  const std::string& get_gdslmessage() const { return gdsl_message; }

  friend std::ostream& operator<<(std::ostream& out, gdsl_exception& _this);
};

std::ostream& operator<<(std::ostream& out, gdsl_exception& _this);

}  // namespace gdsl
