/*
 * arch.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include "id.h"
#include <string>

namespace gdsl {
namespace rreil {

class arch_id : public id {
private:
  std::string name;

  void put(std::ostream &out);

  static size_t subclass_counter;
public:
  arch_id(std::string name);

  size_t get_subclass_counter() const;

  const std::string& get_name() {
    return name;
  }

  bool operator== (id &other) const;
  bool operator<(id const& other) const;
  void accept(id_visitor &v);
};

}  // namespace rreil
}  // namespace gdsl
