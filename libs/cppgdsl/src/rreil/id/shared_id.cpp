/*
 * shared_id.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/id/shared_id.h>

using namespace gdsl::rreil;

std::string gdsl::rreil::shared_id_type_to_string(shared_id_type t) {
  switch(t) {
    case TYPE_FLOATING_FLAGS: {
      return "floating_flags";
    }
  }
}

gdsl::rreil::shared_id::shared_id(shared_id_type _id) {
  this->inner = _id;
}

std::string gdsl::rreil::shared_id::to_string() {
  return shared_id_type_to_string(this->inner);
}
