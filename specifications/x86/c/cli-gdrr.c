
/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdio.h>
#include <stdlib.h>
#include <dis.h>
#include <gdrr.h>

gdrr_sem_stmts_t *list_next(gdrr_sem_stmt_t *next, gdrr_sem_stmts_t *list) {
  printf("next statement\n");

  return NULL;
}

gdrr_sem_stmts_t *list_init() {
  printf("init\n");

  return NULL;
}

gdrr_sem_stmt_t *sem_assign(gdrr_sem_var_t *lhs, gdrr_sem_op_t *rhs) {
  printf("assign\n");

  return NULL;
}

gdrr_sem_stmt_t *sem_load(gdrr_sem_var_t *lhs, __word size, gdrr_sem_address_t *address) {
  printf("load\n");

  return NULL;
}

gdrr_sem_stmt_t *sem_store(gdrr_sem_var_t *lhs, gdrr_sem_op_t *rhs) {
  printf("store\n");

  return NULL;
}

gdrr_sem_stmt_t *sem_ite(gdrr_sem_linear_t *cond, gdrr_sem_stmts_t *then_branch, gdrr_sem_stmts_t *else_branch) {
  printf("ite\n");

  return NULL;
}

gdrr_sem_stmt_t *sem_while(gdrr_sem_linear_t *cond, gdrr_sem_stmts_t *body) {
  printf("while\n");

  return NULL;
}

gdrr_sem_stmt_t *sem_cbranch(gdrr_sem_linear_t *cond,
		gdrr_sem_address_t *target_true, gdrr_sem_address_t *target_false) {
  printf("cbranch\n");

  return NULL;
}

gdrr_sem_stmt_t *sem_branch(gdrr_branch_hint *branch_hint,
			gdrr_sem_address_t *target) {
  printf("branch\n");

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

      struct gddr_callbacks callbacks;
      callbacks.sem_stmts_list.list_init = &list_init;
      callbacks.sem_stmts_list.list_next = &list_next;

      callbacks.sem_stmt.sem_assign = &sem_assign;
      callbacks.sem_stmt.sem_load = &sem_load;
      callbacks.sem_stmt.sem_store = &sem_store;
      callbacks.sem_stmt.sem_ite = &sem_ite;
      callbacks.sem_stmt.sem_while = &sem_while;
      callbacks.sem_stmt.sem_cbranch = &sem_cbranch;
      callbacks.sem_stmt.sem_branch = &sem_branch;

      gdrr_convert(r, &callbacks);
    }
  }

  
  return (1);
}

