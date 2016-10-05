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

class expr;
class expr_binop;
class expr_ext;
class expr_sexpr;

class expr_visitor {
private:
  std::function<void(expr_binop*)> expr_binop_callback = nullptr;
  std::function<void(expr_ext*)> expr_ext_callback = nullptr;
  std::function<void(expr_sexpr*)> expr_sexpr_callback = nullptr;
  std::function<void(expr*)> default_callback = nullptr;
public:
  virtual ~expr_visitor() {
  }

  virtual void visit(expr_binop *a);
  virtual void visit(expr_ext *a);
  virtual void visit(expr_sexpr *a);
  virtual void _default(expr *e);

  void _(std::function<void(expr_binop*)> c) {
    this->expr_binop_callback = c;
  }
  void _(std::function<void(expr_ext*)> c) {
    this->expr_ext_callback = c;
  }
  void _(std::function<void(expr_sexpr*)> c) {
    this->expr_sexpr_callback = c;
  }
  void _default(std::function<void(expr*)> c) {
    this->default_callback = c;
  }
};

}
}
