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
#include <vector>

namespace gdsl {
namespace rreil {

class ite : public statement {
private:
  sexpr *cond;
  std::vector<statement*> *then_branch;
  std::vector<statement*> *else_branch;

  void put(std::ostream &out) const override;
public:
  ite(sexpr *cond, std::vector<statement*> *then_branch, std::vector<statement*> *else_branch);
  ~ite();

  sexpr *get_cond() const {
    return cond;
  }

  const std::vector<statement*> *get_then_branch() const {
    return then_branch;
  }

  const std::vector<statement*> *get_else_branch() const {
    return else_branch;
  }

  void accept(statement_visitor &v) override;
};

}  // namespace rreil
}  // namespace gdsl
