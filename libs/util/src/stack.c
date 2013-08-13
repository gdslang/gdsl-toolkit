/*
 * stack.c
 *
 *  Created on: 25.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stack.h>

struct stack *stack_init() {
	struct stack *stack = (struct stack*)malloc(sizeof(struct stack));

	stack->data = NULL;
	stack->data_length = 0;
	stack->data_size = 0;

	return stack;
}

void stack_free(struct stack *stack) {
	if(stack) {
		free(stack->data);
		free(stack);
	}
}

void stack_push(struct stack *stack, void *data) {
	if(stack->data_length + 1 > stack->data_size) {
		stack->data_size = stack->data_size ? stack->data_size << 1 : 1;
		stack->data = (void**)realloc(stack->data, stack->data_size*sizeof(void*));
	}
	stack->data[stack->data_length++] = data;
}

void *stack_pop(struct stack *stack) {
	if(!stack->data_length)
		return NULL;

	void *data = stack->data[--stack->data_length];

	if(stack->data_length < stack->data_size / 4) {
		stack->data_size >>= 1;
		stack->data = (void**)realloc(stack->data, stack->data_size*sizeof(void*));
	}

	return data;
}

void *stack_peek(struct stack *stack) {
	if(!stack->data_length)
		return NULL;

	return stack->data[stack->data_length - 1];
}

char stack_empty(struct stack *stack) {
	return !stack->data_length;
}

size_t stack_data_get(void ***loops, struct stack *stack) {
	*loops = stack->data;
	return stack->data_length;
}
