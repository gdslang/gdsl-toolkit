/*
 * stack.h
 *
 *  Created on: 25.05.2013
 *      Author: jucs
 */

#ifndef STACK_H_
#define STACK_H_

#include <stdlib.h>

struct stack {
  void** data;
  size_t data_length;
  size_t data_size;
};

extern struct stack* stack_init();
extern void stack_free(struct stack* stack);
extern void stack_push(struct stack* stack, void* data);
extern void* stack_pop(struct stack* stack);
extern void* stack_peek(struct stack* stack);
extern char stack_empty(struct stack* stack);
extern size_t stack_data_get(void*** loops, struct stack* stack);

#endif /* STACK_H_ */
