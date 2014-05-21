/*
 * variable.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <cppgdsl/rreil/id/id.h>
#include <gdsl_generic.h>

namespace gdsl {
namespace rreil {

class variable {
private:
  id *_id;
  int_t offset;

public:
  variable(id *_id, int_t offset);
  ~variable();

  id *get_id() const {
    return _id;
  }

  int_t get_offset() const {
    return offset;
  }
};

}
}
