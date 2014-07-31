/*
 * linear_visitor.h
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <functional>

namespace gdsl {
namespace rreil {

class lin_binop;
class lin_imm;
class lin_scale;
class lin_var;

class linear_visitor {
private:
  std::function<void(lin_binop*)> lin_binop_callback = NULL;
  std::function<void(lin_imm*)> lin_imm_callback = NULL;
  std::function<void(lin_scale*)> lin_scale_callback = NULL;
  std::function<void(lin_var*)> lin_var_callback = NULL;
public:
  virtual ~linear_visitor() {
  }

  virtual void visit(lin_binop *a) {
    if(lin_binop_callback != NULL)
      lin_binop_callback(a);
    _default();
  }
  virtual void visit(lin_imm *a) {
    if(lin_imm_callback != NULL)
      lin_imm_callback(a);
    _default();
  }
  virtual void visit(lin_scale *a) {
    if(lin_scale_callback != NULL)
      lin_scale_callback(a);
    _default();
  }
  virtual void visit(lin_var *a) {
    if(lin_var_callback != NULL)
      lin_var_callback(a);
    _default();
  }

  virtual void _default() {
  }

  void _(std::function<void(lin_binop*)> c) {
    this->lin_binop_callback = c;
  }
  void _(std::function<void(lin_imm*)> c) {
    this->lin_imm_callback = c;
  }
  void _(std::function<void(lin_scale*)> c) {
    this->lin_scale_callback = c;
  }
  void _(std::function<void(lin_var*)> c) {
    this->lin_var_callback = c;
  }
};

}
}
