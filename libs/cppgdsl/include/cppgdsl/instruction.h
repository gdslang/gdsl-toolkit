/*
 * The file contains a wrapper for GDSL instructions in their
 * native format. These instruction objects refer to the GDSL
 * instance and the GDSL heap and are thus lifetime-dependent on
 * the GDSL heap.
 */

#pragma once
#include <iostream>
#include <memory>
#include <vector>

#include "cppgdsl/gdsl.h"
extern "C" {
#include "gdsl_generic.h"
}

namespace gdsl {

class instruction {
 private:
  gdsl* g;
  obj_t native;

 public:
  instruction(gdsl* g, obj_t native);

  std::string to_string();
  friend std::ostream& operator<<(std::ostream& out, instruction& _this);

  rreil::statements_t translate();
  assembly::instruction generic_assembly();

  obj_t get_native() const { return native; }
};

std::ostream& operator<<(std::ostream& out, instruction& cPoint);

}  // namespace gdsl
