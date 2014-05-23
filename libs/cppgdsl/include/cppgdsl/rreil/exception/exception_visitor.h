/*
 * exception_visitor.h
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#pragma once

namespace gdsl {
namespace rreil {

class arch_exception;
class shared_exception;

class exception_visitor {
public:
  virtual void visit(arch_exception *a) {
    _default();
  }
  virtual void visit(shared_exception *a) {
    _default();
  }

  virtual void _default() {
  }
};

}
}
