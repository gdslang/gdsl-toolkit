/*
 * variable.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <cppgdsl/rreil/id/id.h>
#include <cppgdsl/rreil/visitor.h>
#include <iosfwd>
#include <string>
extern "C" {
#include <gdsl_generic.h>
}

namespace gdsl {
namespace rreil {

class variable {
protected:
  id *_id;
  int_t offset;

  virtual void put(std::ostream &out);
public:
  variable(id *_id, int_t offset);
  virtual ~variable();

  id *get_id() {
    return _id;
  }

  int_t get_offset() {
    return offset;
  }

  std::string to_string();
  friend std::ostream &operator<< (std::ostream &out, variable &_this);
  bool operator== (variable &other);

  virtual void accept(visitor &v);
};

std::ostream &operator<<(std::ostream &out, variable &_this);

}
}
