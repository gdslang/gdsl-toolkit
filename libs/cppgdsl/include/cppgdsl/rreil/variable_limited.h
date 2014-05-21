/*
 * variable_limited.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <cppgdsl/rreil/variable.h>
#include <gdsl_generic.h>

namespace gdsl {
namespace rreil {

class variable_limited : variable {
private:
  int_t size;

public:
  variable_limited(id *_id, int_t offset, int_t size);

  int_t get_size() const {
    return size;
  }
};

}
}
