/*
 * virtual.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include "id.h"
#include <string>

namespace gdsl {
namespace rreil {

class _virtual : public id {
private:
  int_t t;

  void put(std::ostream &out);
public:
  _virtual(int_t t);

  int_t get_t();

  bool operator== (id &other);
  void accept(id_visitor &v);
};

}  // namespace rreil
} // namespace gdsl
