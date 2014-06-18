/*
 * expr_visitor.h
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <functional>

namespace gdsl {
namespace rreil {

class expr_binop;
class expr_ext;
class expr_sexpr;

class expr_visitor {
private:
  std::function<void(expr_binop*)> expr_binop_callback = NULL;
  std::function<void(expr_ext*)> expr_ext_callback = NULL;
  std::function<void(expr_sexpr*)> expr_sexpr_callback = NULL;
public:
  virtual ~expr_visitor() {
  }

  virtual void visit(expr_binop *a) {
    if(expr_binop_callback != NULL)
      expr_binop_callback(a);
    _default();
  }
  virtual void visit(expr_ext *a) {
    if(expr_ext_callback != NULL)
      expr_ext_callback(a);
    _default();
  }
  virtual void visit(expr_sexpr *a) {
    if(expr_sexpr_callback != NULL)
      expr_sexpr_callback(a);
    _default();
  }

  virtual void _default() {
  }

  void _(std::function<void(expr_binop*)> c) {
    this->expr_binop_callback = c;
  }
  void _(std::function<void(expr_ext*)> c) {
    this->expr_ext_callback = c;
  }
  void _(std::function<void(expr_sexpr*)> c) {
    this->expr_sexpr_callback = c;
  }
};

}
}
