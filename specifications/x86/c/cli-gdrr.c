
/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdio.h>
#include <stdlib.h>
#include <dis.h>
#include <gdrr.h>

static gdrr_sem_stmts_t *list_next(gdrr_sem_stmt_t *next, gdrr_sem_stmts_t *list) {
  printf("next statement\n");

  return NULL;
}
static gdrr_sem_stmts_t *list_init() {
  printf("init\n");

  return NULL;
}

static gdrr_sem_stmt_t *sem_assign(gdrr_sem_var_t *lhs, gdrr_sem_op_t *rhs) {
  printf("assign\n");

  return NULL;
}
static gdrr_sem_stmt_t *sem_load(gdrr_sem_var_t *lhs, __word size, gdrr_sem_address_t *address) {
  printf("load\n");

  return NULL;
}
static gdrr_sem_stmt_t *sem_store(gdrr_sem_var_t *lhs, gdrr_sem_op_t *rhs) {
  printf("store\n");

  return NULL;
}
static gdrr_sem_stmt_t *sem_ite(gdrr_sem_linear_t *cond, gdrr_sem_stmts_t *then_branch, gdrr_sem_stmts_t *else_branch) {
  printf("ite\n");

  return NULL;
}
static gdrr_sem_stmt_t *sem_while(gdrr_sem_linear_t *cond, gdrr_sem_stmts_t *body) {
  printf("while\n");

  return NULL;
}
static gdrr_sem_stmt_t *sem_cbranch(gdrr_sem_linear_t *cond,
		gdrr_sem_address_t *target_true, gdrr_sem_address_t *target_false) {
  printf("cbranch\n");

  return NULL;
}
static gdrr_sem_stmt_t *sem_branch(gdrr_branch_hint *branch_hint,
			gdrr_sem_address_t *target) {
  printf("branch\n");

  return NULL;
}

static gdrr_sem_op_t *sem_lin(__word size, gdrr_sem_linear_t *opnd1) {
  printf("=> lin {size=%lu}\n", size);

  return NULL;
}
static gdrr_sem_op_t *sem_mul(__word size, gdrr_sem_linear_t *opnd1,
	       gdrr_sem_linear_t *opnd2) {
  printf("=> mul {size=%lu}\n", size);

  return NULL;
}
static gdrr_sem_op_t *sem_div(__word size, gdrr_sem_linear_t *opnd1,
	       gdrr_sem_linear_t *opnd2) {
  printf("=> div {size=%lu}\n", size);

  return NULL;
}
static gdrr_sem_op_t *sem_divs(__word size, gdrr_sem_linear_t *opnd1,
	       gdrr_sem_linear_t *opnd2) {
  printf("=> divs {size=%lu}\n", size);

  return NULL;
}
static gdrr_sem_op_t *sem_mod(__word size, gdrr_sem_linear_t *opnd1,
	       gdrr_sem_linear_t *opnd2) {
  printf("=> mod {size=%lu}\n", size);

  return NULL;
}
static gdrr_sem_op_t *sem_shl(__word size, gdrr_sem_linear_t *opnd1,
	       gdrr_sem_linear_t *opnd2) {
  printf("=> shl {size=%lu}\n", size);

  return NULL;
}
static gdrr_sem_op_t *sem_shr(__word size, gdrr_sem_linear_t *opnd1,
	       gdrr_sem_linear_t *opnd2) {
  printf("=> shr {size=%lu}\n", size);

  return NULL;
}
static gdrr_sem_op_t *sem_shrs(__word size, gdrr_sem_linear_t *opnd1,
	       gdrr_sem_linear_t *opnd2) {
  printf("=> shrs {size=%lu}\n", size);

  return NULL;
}
static gdrr_sem_op_t *sem_and(__word size, gdrr_sem_linear_t *opnd1,
	       gdrr_sem_linear_t *opnd2) {
  printf("=> and {size=%lu}\n", size);

  return NULL;
}
static gdrr_sem_op_t *sem_or(__word size, gdrr_sem_linear_t *opnd1,
	       gdrr_sem_linear_t *opnd2) {
  printf("=> or {size=%lu}\n", size);

  return NULL;
}
static gdrr_sem_op_t *sem_xor(__word size, gdrr_sem_linear_t *opnd1,
	       gdrr_sem_linear_t *opnd2) {
  printf("=> xor {size=%lu}\n", size);

  return NULL;
}
static gdrr_sem_op_t *sem_sx(__word size, __word fromsize,
	       gdrr_sem_linear_t *opnd1) {
  printf("=> sx {size=%lu, fromsize=%lu}\n", size, fromsize);

  return NULL;
}
static gdrr_sem_op_t *sem_zx(__word size, __word fromsize,
	       gdrr_sem_linear_t *opnd1) {
  printf("=> zx {size=%lu, fromsize=%lu}\n", size, fromsize);

  return NULL;
}
static gdrr_sem_op_t *sem_cmpeq(__word size, gdrr_sem_linear_t *opnd1,
	       gdrr_sem_linear_t *opnd2) {
  printf("=> cmpeq {size=%lu}\n", size);

  return NULL;
}
static gdrr_sem_op_t *sem_cmpneq(__word size, gdrr_sem_linear_t *opnd1,
	       gdrr_sem_linear_t *opnd2) {
  printf("=> cmpneq {size=%lu}\n", size);

  return NULL;
}
static gdrr_sem_op_t *sem_cmples(__word size, gdrr_sem_linear_t *opnd1,
	       gdrr_sem_linear_t *opnd2) {
  printf("=> cmples {size=%lu}\n", size);

  return NULL;
}
static gdrr_sem_op_t *sem_cmpleu(__word size, gdrr_sem_linear_t *opnd1,
	       gdrr_sem_linear_t *opnd2) {
  printf("=> cmpleu {size=%lu}\n", size);

  return NULL;
}
static gdrr_sem_op_t *sem_cmplts(__word size, gdrr_sem_linear_t *opnd1,
	       gdrr_sem_linear_t *opnd2) {
  printf("=> cmplts {size=%lu}\n", size);

  return NULL;
}
static gdrr_sem_op_t *sem_cmpltu(__word size, gdrr_sem_linear_t *opnd1,
	       gdrr_sem_linear_t *opnd2) {
  printf("=> cmpltu {size=%lu}\n", size);

  return NULL;
}
static gdrr_sem_op_t *sem_arb(__word size) {
  printf("=> arb {size=%lu}\n", size);

  return NULL;
}

static gdrr_sem_var_t *sem_var(gdrr_sem_id *id, __word offset) {
  printf("=> var {offset=%lu}\n", offset);

  return NULL;
}

int main (int argc, char** argv) {
  __char blob[15];
  char fmt[1024];
  __word sz = 15;
  __obj insn;
  int i,c;
  for (i=0;i<sz;i++) {
     int x = fscanf(stdin,"%x",&c);
     switch (x) {
        case EOF:
           goto done;
        case 0:
           __fatal("invalid input; should be in hex form: '0f 0b ..'");
     }
     blob[i] = c & 0xff;
  }
done:
  __decode(__decode__,blob,i,&insn);
  if (___isNil(insn))
    __fatal("decode failed");
  else {
    __pretty(__pretty__,insn,fmt,1024);
    puts(fmt);

    printf("---------------------------\n");
   
    __obj r = __translate(__translate__,insn);
    if(___isNil(r))
      __fatal("translate failed");
    else {
      __pretty(__rreil_pretty__,r,fmt,1024);
      puts(fmt);

      struct gdrr_callbacks callbacks;
      callbacks.sem_stmts_list.list_init = &list_init;
      callbacks.sem_stmts_list.list_next = &list_next;

      callbacks.sem_stmt.sem_assign = &sem_assign;
      callbacks.sem_stmt.sem_load = &sem_load;
      callbacks.sem_stmt.sem_store = &sem_store;
      callbacks.sem_stmt.sem_ite = &sem_ite;
      callbacks.sem_stmt.sem_while = &sem_while;
      callbacks.sem_stmt.sem_cbranch = &sem_cbranch;
      callbacks.sem_stmt.sem_branch = &sem_branch;

      callbacks.sem_op.sem_lin = &sem_lin;
      callbacks.sem_op.sem_mul = &sem_mul;
      callbacks.sem_op.sem_div = &sem_div;
      callbacks.sem_op.sem_divs = &sem_divs;
      callbacks.sem_op.sem_mod = &sem_mod;
      callbacks.sem_op.sem_shl = &sem_shl;
      callbacks.sem_op.sem_shr = &sem_shr;
      callbacks.sem_op.sem_shrs = &sem_shrs;
      callbacks.sem_op.sem_and = &sem_and;
      callbacks.sem_op.sem_or = &sem_or;
      callbacks.sem_op.sem_xor = &sem_xor;
      callbacks.sem_op.sem_sx = &sem_sx;
      callbacks.sem_op.sem_zx = &sem_zx;
      callbacks.sem_op.sem_cmpeq = &sem_cmpeq;
      callbacks.sem_op.sem_cmpneq = &sem_cmpneq;
      callbacks.sem_op.sem_cmples = &sem_cmples;
      callbacks.sem_op.sem_cmpleu = &sem_cmpleu;
      callbacks.sem_op.sem_cmplts = &sem_cmplts;
      callbacks.sem_op.sem_cmpltu = &sem_cmpltu;
      callbacks.sem_op.sem_arb = &sem_arb;

      callbacks.sem_var.sem_var = &sem_var;

      gdrr_convert_list(r, &callbacks);
    }
  }

  
  return (1);
}

