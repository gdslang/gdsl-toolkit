/*
 * shared_id.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include "id.h"

namespace gdsl {
namespace rreil {

enum shared_id_type {
  TYPE_FLOATING_FLAGS
};

class shared_id : public id {
private:
  shared_id_type _id;

public:
  shared_id(shared_id_type _id);

  shared_id_type get_id() const {
    return _id;
  }
};

}
}
