/*
 * linear_visitor.h
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#pragma once

namespace gdsl {
namespace rreil {

class lin_binop;
class lin_imm;
class lin_scale;
class lin_var;

class linear_visitor {
public:
  virtual void visit(lin_binop *a) {
    _default();
  }
  virtual void visit(lin_imm *a) {
    _default();
  }
  virtual void visit(lin_scale *a) {
    _default();
  }
  virtual void visit(lin_var *a) {
    _default();
  }

  virtual void _default() {
  }
};

}
}
