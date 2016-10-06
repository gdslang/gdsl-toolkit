/*
 * The file contains all definitions for the RReil builder. It
 * can be used to convert the internal format stored on the GDSL heap
 * consisting of a list of RReil statements into its C++ representation.
 */

#pragma once
#include <memory>
#include <vector>

#include "cppgdsl/frontend/frontend.h"
#include "cppgdsl/gdsl.h"
#include "cppgdsl/rreil/statement/statement.h"

namespace gdsl {

class rreil_builder {
 private:
  gdsl* g;

 public:
  rreil_builder(gdsl* g);

  rreil::statements_t convert(obj_t rreil);
};

}  // namespace gdsl
