/*
 * while.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include "statement.h"
#include <cppgdsl/rreil/sexpr/sexpr.h>
extern "C" {
#include <gdsl_generic.h>
}

#include <vector>

namespace gdsl {
namespace rreil {

class _while : public statement {
private:
  sexpr *cond;
  std::vector<statement*> *body;

  void put(std::ostream &out) const override;
public:
  _while(sexpr *cond, std::vector<statement*> *body);
  ~_while() override;

  sexpr *get_cond() const {
    return cond;
  }

  const std::vector<statement*> *get_body() const{
    return body;
  }

  void accept(statement_visitor &v) override;
};

}  // namespace rreil
}  // namespace gdsl
