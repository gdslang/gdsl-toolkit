/*
 * id_visitor.h
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#pragma once

namespace gdsl {
namespace rreil {

class arch_id;
class shared_id;
class _virtual;

class id_visitor {
public:
  virtual void visit(arch_id *a) {
    _default();
  }
  virtual void visit(shared_id *a) {
    _default();
  }
  virtual void visit(_virtual *a) {
    _default();
  }

  virtual void _default() {
  }
};

}
}
