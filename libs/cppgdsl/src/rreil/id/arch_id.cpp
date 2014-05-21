/*
 * arch.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/id/arch_id.h>
#include <string>

using namespace gdsl::rreil;
using namespace std;

arch_id::arch_id(string name) {
  this->name = name;
}

string arch_id::get_name() {
  return this->name;
}
