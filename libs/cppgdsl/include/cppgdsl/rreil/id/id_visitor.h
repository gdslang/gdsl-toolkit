/*
 * id_visitor.h
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <functional>

namespace gdsl {
namespace rreil {

class arch_id;
class shared_id;
class _virtual;
class id;

class id_visitor {
private:
  std::function<void(arch_id*)> arch_id_callback = NULL;
  std::function<void(shared_id*)> shared_id_callback = NULL;
  std::function<void(_virtual*)> _virtual_callback = NULL;
  std::function<void(id*)> default_callback = NULL;
public:
  virtual ~id_visitor() {
  }

  virtual void visit(arch_id *a);
  virtual void visit(shared_id *a);
  virtual void visit(_virtual *a);
  virtual void _default(id *s);

  void _(std::function<void(arch_id*)> c) {
    this->arch_id_callback = c;
  }
  void _(std::function<void(shared_id*)> c) {
    this->shared_id_callback = c;
  }
  void _(std::function<void(_virtual*)> c) {
    this->_virtual_callback = c;
  }
  void _default(std::function<void(id*)> default_callback) {
    this->default_callback = default_callback;
  }
};

}
}
