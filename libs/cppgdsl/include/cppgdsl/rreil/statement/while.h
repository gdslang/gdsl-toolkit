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

namespace gdsl {
namespace rreil {

class _while : public statement {
private:
  sexpr *cond;
  statement *body;

  void put(std::ostream &out);
public:
  _while(sexpr *cond, statement *body);
  ~_while();

  sexpr const *get_cond() const {
    return cond;
  }

  statement const *get_body() const {
    return body;
  }

  void accept(statement_visitor &v);
};

}}
