/*
 * sexpr_visitor.h
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#pragma once

namespace gdsl {
namespace rreil {

class arbitrary;
class sexpr_cmp;
class sexpr_lin;

class sexpr_visitor {
public:
  virtual ~sexpr_visitor() {
  }

  virtual void visit(arbitrary *a) {
    _default();
  }
  virtual void visit(sexpr_cmp *a) {
    _default();
  }
  virtual void visit(sexpr_lin *a) {
    _default();
  }

  virtual void _default() {
  }
};

}
}
