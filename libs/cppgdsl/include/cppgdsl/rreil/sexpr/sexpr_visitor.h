/*
 * sexpr_visitor.h
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <functional>

namespace gdsl {
namespace rreil {

class sexpr;
class arbitrary;
class sexpr_cmp;
class sexpr_lin;

class sexpr_visitor {
private:
  std::function<void(arbitrary*)> arbitrary_callback = NULL;
  std::function<void(sexpr_cmp*)> sexpr_cmp_callback = NULL;
  std::function<void(sexpr_lin*)> sexpr_lin_callback = NULL;
  std::function<void(sexpr*)> default_callback = NULL;

public:
  virtual ~sexpr_visitor() {
  }

  virtual void visit(arbitrary *a);
  virtual void visit(sexpr_cmp *a);
  virtual void visit(sexpr_lin *a);
  virtual void _default(sexpr *s);

  void _(std::function<void(arbitrary*)> c) {
    this->arbitrary_callback = c;
  }
  void _(std::function<void(sexpr_cmp*)> c) {
    this->sexpr_cmp_callback = c;
  }
  void _(std::function<void(sexpr_lin*)> c) {
    this->sexpr_lin_callback = c;
  }
  void _default(std::function<void(sexpr*)> c) {
    this->default_callback = c;
  }
};

}
}
