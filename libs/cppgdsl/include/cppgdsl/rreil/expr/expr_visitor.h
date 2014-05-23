/*
 * expr_visitor.h
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#pragma once

namespace gdsl {
namespace rreil {

class expr_binop;
class expr_ext;
class expr_sexpr;

class expr_visitor {
public:
  virtual void visit(expr_binop *a) {
    _default();
  }
  virtual void visit(expr_ext *a) {
    _default();
  }
  virtual void visit(expr_sexpr *a) {
    _default();
  }

  virtual void _default() {
  }
};

}
}
