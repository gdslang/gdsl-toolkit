/*
 * exception_visitor.h
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <functional>

namespace gdsl {
namespace rreil {

class arch_exception;
class shared_exception;

class exception_visitor {
private:
  std::function<void(arch_exception*)> arch_exception_callback = NULL;
  std::function<void(shared_exception*)> shared_exception_callback = NULL;
public:
  virtual ~exception_visitor() {
  }

  virtual void visit(arch_exception *a) {
    if(arch_exception_callback != NULL)
      arch_exception_callback(a);
    _default();
  }
  virtual void visit(shared_exception *a) {
    if(shared_exception_callback != NULL)
      shared_exception_callback(a);
    _default();
  }

  virtual void _default() {
  }

  void _(std::function<void(arch_exception*)> c) {
    this->arch_exception_callback = c;
  }
  void _(std::function<void(shared_exception*)> c) {
    this->shared_exception_callback = c;
  }
};

}
}
