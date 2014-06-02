/*
 * ite.h
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

class ite : public statement {
private:
  sexpr *cond;
  statement *then_branch;
  statement *else_branch;

  void put(std::ostream &out);
public:
  ite(sexpr *cond, statement *then_branch, statement *else_branch);
  ~ite();

  sexpr *get_cond() {
    return cond;
  }

  statement *get_then_branch() {
    return then_branch;
  }

  statement *get_else_branch() {
    return else_branch;
  }

  void accept(statement_visitor &v);
};

}}
