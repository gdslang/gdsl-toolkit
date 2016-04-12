/*
 * rreil_print.c
 *
 *  Created on: 06.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <rreil/rreil.h>

#ifdef GDSL_X86
#include <x86.h>
#endif

void rreil_address_print(FILE *stream, struct rreil_address *address) {
  fprintf(stream, "{%llu} ", address->size);
  rreil_linear_print(stream, address->address);
}

void rreil_branch_hint_print(FILE *stream, enum rreil_branch_hint *hint) {
  switch(*hint) {
    case RREIL_BRANCH_HINT_JUMP: {
      fprintf(stream, "JUMP");
      break;
    }
    case RREIL_BRANCH_HINT_CALL: {
      fprintf(stream, "CALL");
      break;
    }
    case RREIL_BRANCH_HINT_RET: {
      fprintf(stream, "RET");
      break;
    }
  }
}

void rreil_comparator_print(FILE *stream, struct rreil_comparator *comparator) {
  rreil_linear_print(stream, comparator->arity2.opnd1);
  switch(comparator->type) {
    case RREIL_COMPARATOR_TYPE_EQ: {
      fprintf(stream, " == ");
      break;
    }
    case RREIL_COMPARATOR_TYPE_NEQ: {
      fprintf(stream, " != ");
      break;
    }
    case RREIL_COMPARATOR_TYPE_LES: {
      fprintf(stream, " <=s ");
      break;
    }
    case RREIL_COMPARATOR_TYPE_LEU: {
      fprintf(stream, " <=u ");
      break;
    }
    case RREIL_COMPARATOR_TYPE_LTS: {
      fprintf(stream, " <s ");
      break;
    }
    case RREIL_COMPARATOR_TYPE_LTU: {
      fprintf(stream, " <u ");
      break;
    }
  }
  rreil_linear_print(stream, comparator->arity2.opnd2);
}

void rreil_id_print(FILE *stream, struct rreil_id *id) {
  switch(id->type) {
    case RREIL_ID_TYPE_SHARED: {
      switch(id->shared) {
        case RREIL_ID_SHARED_FLOATING_FLAGS: {
          fprintf(stream, "FLOATING_FLAGS");
          break;
        }
      }
      break;
    }
    case RREIL_ID_TYPE_TEMPORARY: {
      fprintf(stream, "%s%llu", id->opt ? "O" : "T", id->temporary);
      break;
    }
#ifdef GDSL_X86
      case RREIL_ID_TYPE_X86: {
        x86_id_print(stream, id->x86);
        break;
      }
#else
    case RREIL_ID_TYPE_ARCH: {
      fprintf(stream, "%s", id->arch);
    }
#endif
  }
}

void rreil_exception_print(FILE *stream, struct rreil_exception *exception) {
  switch(exception->type) {
    case RREIL_EXCEPTION_TYPE_SHARED: {
      switch(exception->shared) {
        case RREIL_EXCEPTION_SHARED_DIVISION_BY_ZERO: {
          fprintf(stream, "{Exception: Division by zero}");
          break;
        }
      }
      break;
    }
#ifdef GDSL_X86
      case RREIL_EXCEPTION_TYPE_X86: {
        x86_exception_print(stream, exception->x86);
        break;
      }
#else
    case RREIL_EXCEPTION_TYPE_ARCH: {
      fprintf(stream, "{Exception: %s}", exception->arch);
    }
#endif
  }
}

void rreil_linear_print(FILE *stream, struct rreil_linear *linear) {
  switch(linear->type) {
    case RREIL_LINEAR_TYPE_VARIABLE: {
      rreil_variable_print(stream, linear->variable);
      break;
    }
    case RREIL_LINEAR_TYPE_IMMEDIATE: {
      fprintf(stream, "%llu", linear->immediate);
      break;
    }
    case RREIL_LINEAR_TYPE_SUM: {
      fprintf(stream, "(");
      rreil_linear_print(stream, linear->sum.opnd1);
      fprintf(stream, " + ");
      rreil_linear_print(stream, linear->sum.opnd2);
      fprintf(stream, ")");
      break;
    }
    case RREIL_LINEAR_TYPE_DIFFERENCE: {
      fprintf(stream, "(");
      rreil_linear_print(stream, linear->difference.opnd1);
      fprintf(stream, " - ");
      rreil_linear_print(stream, linear->difference.opnd2);
      fprintf(stream, ")");
      break;
    }
    case RREIL_LINEAR_TYPE_SCALE: {
      fprintf(stream, "%llu*", linear->scale.imm);
      rreil_linear_print(stream, linear->scale.opnd);
      break;
    }
  }
}

void rreil_expr_print(FILE *stream, struct rreil_expr *expr) {
  switch(expr->type) {
    case RREIL_EXPR_TYPE_SEXPR: {
      rreil_sexpr_print(stream, expr->sexpr);
      break;
    }
    case RREIL_EXPR_TYPE_MUL: {
      rreil_linear_print(stream, expr->mul.opnd1);
      fprintf(stream, " * ");
      rreil_linear_print(stream, expr->mul.opnd2);
      break;
    }
    case RREIL_EXPR_TYPE_DIV: {
      rreil_linear_print(stream, expr->div.opnd1);
      fprintf(stream, " /u ");
      rreil_linear_print(stream, expr->div.opnd2);
      break;
    }
    case RREIL_EXPR_TYPE_DIVS: {
      rreil_linear_print(stream, expr->divs.opnd1);
      fprintf(stream, " /s ");
      rreil_linear_print(stream, expr->divs.opnd2);
      break;
    }
    case RREIL_EXPR_TYPE_MOD: {
      rreil_linear_print(stream, expr->mod.opnd1);
      fprintf(stream, " %% ");
      rreil_linear_print(stream, expr->mod.opnd2);
      break;
    }
    case RREIL_EXPR_TYPE_MODS: {
      rreil_linear_print(stream, expr->mods.opnd1);
      fprintf(stream, " %%s ");
      rreil_linear_print(stream, expr->mods.opnd2);
      break;
    }
    case RREIL_EXPR_TYPE_SHL: {
      rreil_linear_print(stream, expr->shl.opnd1);
      fprintf(stream, " << ");
      rreil_linear_print(stream, expr->shl.opnd2);
      break;
    }
    case RREIL_EXPR_TYPE_SHR: {
      rreil_linear_print(stream, expr->shr.opnd1);
      fprintf(stream, " >>u ");
      rreil_linear_print(stream, expr->shr.opnd2);
      break;
    }
    case RREIL_EXPR_TYPE_SHRS: {
      rreil_linear_print(stream, expr->shrs.opnd1);
      fprintf(stream, " >>s ");
      rreil_linear_print(stream, expr->shrs.opnd2);
      break;
    }
    case RREIL_EXPR_TYPE_AND: {
      rreil_linear_print(stream, expr->and_.opnd1);
      fprintf(stream, " & ");
      rreil_linear_print(stream, expr->and_.opnd2);
      break;
    }
    case RREIL_EXPR_TYPE_OR: {
      rreil_linear_print(stream, expr->or_.opnd1);
      fprintf(stream, " | ");
      rreil_linear_print(stream, expr->or_.opnd2);
      break;
    }
    case RREIL_EXPR_TYPE_XOR: {
      rreil_linear_print(stream, expr->xor_.opnd1);
      fprintf(stream, " ^ ");
      rreil_linear_print(stream, expr->xor_.opnd2);
      break;
    }
    case RREIL_EXPR_TYPE_SX: {
      fprintf(stream, "{%llu->s*} ", expr->sx.fromsize);
      rreil_linear_print(stream, expr->sx.opnd);
      break;
    }
    case RREIL_EXPR_TYPE_ZX: {
      fprintf(stream, "{%llu->u*} ", expr->zx.fromsize);
      rreil_linear_print(stream, expr->zx.opnd);
      break;
    }
  }
}

void rreil_sexpr_print(FILE *stream, struct rreil_sexpr *sexpr) {
  switch(sexpr->type) {
    case RREIL_SEXPR_TYPE_LIN: {
      rreil_linear_print(stream, sexpr->lin);
      break;
    }
    case RREIL_SEXPR_TYPE_CMP: {
      fprintf(stream, "[");
      rreil_comparator_print(stream, sexpr->cmp.comp);
      fprintf(stream, "]:%llu", sexpr->cmp.size);
      break;
    }
    case RREIL_SEXPR_TYPE_ARB: {
      fprintf(stream, "arbitrary");
      break;
    }
  }
}

void rreil_variable_print(FILE *stream, struct rreil_variable *variable) {
  rreil_id_print(stream, variable->id);
  if(variable->offset) fprintf(stream, "/%llu", variable->offset);
}

void rreil_varl_print(FILE *stream, struct rreil_variable_limited *varl) {
  rreil_id_print(stream, varl->id);
  if(varl->offset) fprintf(stream, "/%llu", varl->offset);
  fprintf(stream, ":%llu", varl->size);
}

void rreil_varls_print(FILE *stream, struct rreil_variable_limited_tuple *varls) {
  if(varls->variables_length > 1) fprintf(stream, "(");
  for(size_t i = 0; i < varls->variables_length; ++i) {
    if(i) fprintf(stream, ", ");
    rreil_varl_print(stream, varls->variables[i]);
  }
  if(varls->variables_length > 1) fprintf(stream, ")");
}

void rreil_flop_print(FILE *stream, enum rreil_flop *flop) {
  switch(*flop) {
    case RREIL_FLOP_SEM_FADD: {
      fprintf(stream, "FADD");
      break;
    }
    case RREIL_FLOP_SEM_FSUB: {
      fprintf(stream, "FSUB");
      break;
    }
    case RREIL_FLOP_SEM_FMUL: {
      fprintf(stream, "FMUL");
      break;
    }
  }
}

void rreil_statement_print(FILE *stream, struct rreil_statement *statement) {
  switch(statement->type) {
    case RREIL_STATEMENT_TYPE_ASSIGN: {
      rreil_variable_print(stream, statement->assign.lhs);
      fprintf(stream, " =:%llu ", statement->assign.size);
      rreil_expr_print(stream, statement->assign.rhs);
      break;
    }
    case RREIL_STATEMENT_TYPE_LOAD: {
      rreil_variable_print(stream, statement->load.lhs);
      fprintf(stream, " =:%llu *(", statement->load.size);
      rreil_address_print(stream, statement->load.address);
      fprintf(stream, ")");
      break;
    }
    case RREIL_STATEMENT_TYPE_STORE: {
      fprintf(stream, "*(");
      rreil_address_print(stream, statement->store.address);
      fprintf(stream, ") =:%llu ", statement->store.size);
      rreil_linear_print(stream, statement->store.rhs);
      break;
    }
    case RREIL_STATEMENT_TYPE_ITE: {
      fprintf(stream, "if(");
      rreil_sexpr_print(stream, statement->ite.cond);
      fprintf(stream, ") {\n");
      rreil_statements_print(stream, statement->ite.then_branch);
      fprintf(stream, "} else {\n");
      rreil_statements_print(stream, statement->ite.else_branch);
      fprintf(stream, "}");
      break;
    }
    case RREIL_STATEMENT_TYPE_WHILE: {
      fprintf(stream, "while(");
      rreil_sexpr_print(stream, statement->while_.cond);
      fprintf(stream, ") {\n");
      rreil_statements_print(stream, statement->while_.body);
      fprintf(stream, "}");
      break;
    }
    case RREIL_STATEMENT_TYPE_CBRANCH: {
      fprintf(stream, "if(");
      rreil_sexpr_print(stream, statement->cbranch.cond);
      fprintf(stream, ") { goto");
      rreil_address_print(stream, statement->cbranch.target_true);
      fprintf(stream, " } else { goto");
      rreil_address_print(stream, statement->cbranch.target_false);
      fprintf(stream, " }");
      break;
    }
    case RREIL_STATEMENT_TYPE_BRANCH: {
      fprintf(stream, "goto [");
      rreil_branch_hint_print(stream, statement->branch.hint);
      fprintf(stream, "] ");
      rreil_address_print(stream, statement->branch.target);
      break;
    }
    case RREIL_STATEMENT_TYPE_FLOP: {
      rreil_varl_print(stream, statement->flop.lhs);
      fprintf(stream, " = $");
      rreil_flop_print(stream, statement->flop.op);
      if(statement->flop.rhs->variables_length) {
        fprintf(stream, " ");
        rreil_varls_print(stream, statement->flop.rhs);
      }
      fprintf(stream, " [flags:");
      rreil_variable_print(stream, statement->flop.flags);
      fprintf(stream, "]");
      break;
    }
    case RREIL_STATEMENT_TYPE_PRIM: {
      if(statement->prim.lhs->variables_length) {
        rreil_varls_print(stream, statement->prim.lhs);
        fprintf(stream, " = ");
      }
      fprintf(stream, "$%s", statement->prim.op);
      if(statement->prim.rhs->variables_length) {
        fprintf(stream, " ");
        rreil_varls_print(stream, statement->prim.rhs);
      }
      break;
    }
    case RREIL_STATEMENT_TYPE_THROW: {
      fprintf(stream, "throw ");
      rreil_exception_print(stream, statement->throw_.exception);
      break;
    }
  }
}

void rreil_statements_print(FILE *stream, struct rreil_statements *statements) {
  for(size_t i = 0; i < statements->statements_length; ++i) {
    rreil_statement_print(stream, statements->statements[i]);
    fprintf(stream, "\n");
  }
}
