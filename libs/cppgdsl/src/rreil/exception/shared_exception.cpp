/*
 * shared_exception.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/exception/shared_exception.h>

gdsl::rreil::shared_exception::shared_exception(shared_exception_type type) {
  this->type = type;
}
