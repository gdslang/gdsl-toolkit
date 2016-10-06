#include "cppgdsl/block.h"

namespace gdsl {

block::block(std::vector<instruction> instructions,
             rreil::statements_t statements)
    : instructions(move(instructions)), statements(move(statements)) {}

}  // namespace gdsl
