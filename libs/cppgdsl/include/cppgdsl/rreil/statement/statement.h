/*
 * statement.h
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include "statement_visitor.h"
#include <iosfwd>
#include <string>
#include <vector>

namespace gdsl {
namespace rreil {

typedef std::vector<rreil::statement*> statements_t;

class statement {
private:
  virtual void put(std::ostream &out) const = 0;
public:
  virtual ~statement() {
  }

  std::string to_string() const;
  friend std::ostream& operator<<(std::ostream &out, const statement &_this);

  virtual void accept(statement_visitor &v) = 0;
};

std::ostream& operator<<(std::ostream &out, const statement &_this);

}  // namespace rreil
}  // namespace gdsl

#include "assign.h"
#include "branch.h"
#include "cbranch.h"
#include "floating.h"
#include "ite.h"
#include "load.h"
#include "prim.h"
#include "store.h"
#include "throw.h"
#include "while.h"
