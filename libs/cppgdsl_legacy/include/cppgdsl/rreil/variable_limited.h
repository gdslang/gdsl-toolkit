/*
 * variable_limited.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <cppgdsl/rreil/variable.h>
#include <cppgdsl/rreil/visitor.h>
extern "C" {
#include <gdsl_generic.h>
}

namespace gdsl {
namespace rreil {

class variable_limited : public variable {
private:
  int_t size;
protected:
  void put(std::ostream &out);
public:
  variable_limited(id *_id, int_t offset, int_t size);

  int_t get_size() {
    return size;
  }

  void accept(visitor &v);
};

}
}
