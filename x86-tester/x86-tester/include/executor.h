/*
 * executor.h
 *
 *  Created on: 27.05.2013
 *      Author: jucs
 */

#ifndef EXECUTOR_H_
#define EXECUTOR_H_

extern void executor_rflags_clean(struct context *context);
extern struct tbgen_result executor_instruction_mapped_generate(uint8_t *instruction,
		size_t instruction_length, struct tracking_trace *trace,
		struct context *context, void **memory, void **next_instruction_address);
extern char executor_instruction_execute(uint8_t *instruction, size_t instruction_length,
		struct tracking_trace *trace, struct context *context, void *code,
		struct tbgen_result tbgen_result);


#endif /* EXECUTOR_H_ */
