/*
 * rreil_id.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include "id_visitor.h"
#include <iosfwd>
#include <string>
extern "C" {
#include <gdsl_generic.h>
}

namespace gdsl {
namespace rreil {

class id {
private:
  virtual void put(std::ostream &out) = 0;
public:
  virtual ~id() {
  }

  std::string to_string();
  friend std::ostream &operator<< (std::ostream &out, id &_this);
  virtual bool operator== (id &other) const = 0;

  virtual void accept(id_visitor &v) = 0;
};

std::ostream &operator<<(std::ostream &out, id &_this);

}
}

#include "arch_id.h"
#include "shared_id.h"
#include "virtual.h"
