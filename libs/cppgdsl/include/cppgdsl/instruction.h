/*
 * instruction.h
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <cppgdsl/gdsl.h>
#include <cppgdsl/rreil/statement/statement.h>
#include <vector>
extern "C" {
#include <gdsl_generic.h>
}

namespace gdsl {

class instruction {
private:
  gdsl *g;
  obj_t native;
public:
  instruction(gdsl::gdsl *g, obj_t native);
  ~instruction();

  std::string to_string();
  int_t length();
  std::vector<rreil::statement*> *translate();

  obj_t get_native() const {
    return native;
  }
};

}
