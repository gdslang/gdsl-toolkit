/*
 * executor.c
 *
 *  Created on: 27.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <sys/mman.h>
#include <signal.h>
#include <unistd.h>
#include <setjmp.h>
#include <context.h>
#include <tbgen.h>
#include <stack.h>
#include <util.h>
#include <simulator/regacc.h>
#include <executor.h>

#include <asm/prctl.h>
#include <sys/prctl.h>
extern int arch_prctl(int code, unsigned long *addr);

#define DRYRUN

/*
 * Clean up RFLAGS
 */
void executor_rflags_clean(struct context *context) {
	uint64_t rflags_mask = 0x0000000000244cd5;
	uint8_t *rflags_mask_ptr = (uint8_t*)&rflags_mask;

	for(size_t i = 0; i < context->x86_registers[X86_ID_FLAGS].bit_length / 8; ++i) {
		context->x86_registers[X86_ID_FLAGS].data[i] &= rflags_mask_ptr[i];
		context->x86_registers[X86_ID_FLAGS].defined[i] &= rflags_mask_ptr[i];
	}
}

static uint8_t read_flag(struct context *context, uint8_t flag) {
	uint64_t *fp = (uint64_t*)context->x86_registers[X86_ID_FLAGS].data;
	return ((*fp) >> flag) & 1;
}

void executor_virt_calc(struct context *context) {
	struct data data;
	data.bit_length = 1;
	uint8_t flag;
	data.data = &flag;
	uint8_t one = 1;
	data.defined = &one;

	if(context->x86_registers[X86_ID_FLAGS].bit_length > X86_FLAGS_CARRY
			&& context->x86_registers[X86_ID_FLAGS].bit_length > X86_FLAGS_ZERO) {
		flag = read_flag(context, X86_FLAGS_CARRY) | read_flag(context, X86_FLAGS_ZERO);
		simulator_register_generic_write(&context->x86_registers[X86_ID_VIRT_LEU], data, 0);
	}

	if(context->x86_registers[X86_ID_FLAGS].bit_length > X86_FLAGS_SIGN
			&& context->x86_registers[X86_ID_FLAGS].bit_length > X86_FLAGS_OVERFLOW) {
		flag = read_flag(context, X86_FLAGS_SIGN) != read_flag(context, X86_FLAGS_OVERFLOW);
		simulator_register_generic_write(&context->x86_registers[X86_ID_VIRT_LTS], data, 0);
	}

	if(context->x86_registers[X86_ID_FLAGS].bit_length > X86_FLAGS_ZERO) {
		flag = context->x86_registers[X86_ID_VIRT_LTS].data[0] | read_flag(context, X86_FLAGS_ZERO);
		simulator_register_generic_write(&context->x86_registers[X86_ID_VIRT_LES], data, 0);
	}
}

void *executor_segment_base_get(enum x86_id reg) {
	void *base;

	int code;
	switch(reg) {
		case X86_ID_GS_Base: {
			code = ARCH_GET_GS;
			break;
		}
		case X86_ID_FS_Base: {
			code = ARCH_GET_FS;
			break;
		}
		default: {
			code = -1;
			break;
		}
	}

	if(arch_prctl(code, (unsigned long*)&base))
		return NULL;
	return base;
}

struct tbgen_result executor_instruction_mapped_generate(uint8_t *instruction, size_t instruction_length,
		struct tracking_trace *trace, struct context *context, void **memory, void **next_instruction_address,
		char test_unused) {
	struct tbgen_result tbgen_result = tbgen_code_generate(instruction, instruction_length, trace, context, test_unused);
	if(tbgen_result.result == TBGEN_RTYPE_ERROR)
		return tbgen_result;
	*memory = mmap(NULL, tbgen_result.buffer_length,
	PROT_READ | PROT_WRITE | PROT_EXEC, MAP_PRIVATE | MAP_ANON, 0, 0);
	memcpy(*memory, tbgen_result.buffer, tbgen_result.buffer_length);
	*next_instruction_address = *memory + tbgen_result.instruction_offset + instruction_length;
	return tbgen_result;
}

static void page_address_size_get(void **address, size_t *size) {
	size_t page_size = 0x1000;
	size_t page_mask = 0x0fff;
	size_t first = page_size - ((size_t)*address & page_mask);
	size_t pages = 1;
	if(*size > first)
		pages += (*size - first) / page_size + 1;
	*size = page_size * pages;
	*address = (void*)((size_t)*address & (~page_mask));
}

struct mapping {
	void *address;
	size_t length;
};

static char map(struct stack *mappings, void *address, size_t size) {
	page_address_size_get(&address, &size);

	struct mapping **mappings_raw;
	size_t mappings_raw_length = stack_data_get((void***)&mappings_raw, mappings);
	for (size_t i = 0; i < mappings_raw_length; ++i) {
		size_t last = (size_t)address + (size_t)size - 1;
		size_t other_last = (size_t)mappings_raw[i]->address + (size_t)mappings_raw[i]->length - 1;
		char overlap = 0;
//		if(address <= other_last && last >= mappings_raw[i]->address) {
//			if(address < mappings_raw[i]->address)
//				address = mappings_raw[i]->address;
//			else
//				return 0;
//		} else if(address <= other_last && last >= other_last)
				if((size_t)address <= other_last && last >= (size_t)mappings_raw[i]->address)
					overlap = 1;
				if(!overlap)
					continue;
				char included = 0;
				if(address >= mappings_raw[i]->address)
					included |= 1;
				if(last <= other_last)
					included |= 2;
				switch(included) {
					case 0: {
						break;
					}
					case 1: {
						address = mappings_raw[i]->address;
						break;
					}
					case 2: {
						last = other_last;
						break;
					}
					case 3: {
						return 0;
					}
				}
				size = last - (size_t)address + 1;
	}

	uint64_t *mem_real = mmap(address, size, PROT_READ | PROT_WRITE | PROT_EXEC,
	MAP_PRIVATE | MAP_ANON | MAP_FIXED, 0, 0);

	struct mapping *mapping = (struct mapping*)malloc(sizeof(struct mapping));
	mapping->address = mem_real;
	mapping->length = size;
	stack_push(mappings, mapping);

//		printf("$$$ %lx / %lx\n", address, mem_real);

	if(mem_real != address) {
		printf("Unable to map address.\n");
		return -3;
	}
	return 0;
}

static char map_and_copy(struct stack *mappings, struct tracking_trace *trace, struct context *context,
		struct tbgen_result tbgen_result) {
	for(size_t i = 0; i < trace->mem.written.accesses_length; ++i) {
		struct memory_access *access = &trace->mem.written.accesses[i];
		if(map(mappings, access->address, access->data_size))
			return -3;
	}

	for(size_t i = 0; i < context->memory.allocations_length; ++i) {
		struct memory_allocation *allocation = &context->memory.allocations[i];

		switch(allocation->type) {
			case MEMORY_ALLOCATION_TYPE_ACCESS: {
				if(map(mappings, allocation->address, allocation->data_size))
					return -3;
				break;
			}
			case MEMORY_ALLOCATION_TYPE_JUMP: {
				if(map(mappings, allocation->address, tbgen_result.jump_marker_length))
					return -3;
				break;
			}
		}
	}

	for(size_t i = 0; i < context->memory.allocations_length; ++i) {
		struct memory_allocation *allocation = &context->memory.allocations[i];

		switch(allocation->type) {
			case MEMORY_ALLOCATION_TYPE_ACCESS: {
				memcpy(allocation->address, allocation->data, allocation->data_size);
				break;
			}
			case MEMORY_ALLOCATION_TYPE_JUMP: {
				memcpy(allocation->address, tbgen_result.jump_marker, tbgen_result.jump_marker_length);
				break;
			}
		}
	}

	return 0;
}

static void write_back(struct tracking_trace *trace, struct context *context) {
	for(size_t i = 0; i < context->memory.allocations_length; ++i) {
		struct memory_allocation *allocation = &context->memory.allocations[i];

		switch(allocation->type) {
			case MEMORY_ALLOCATION_TYPE_ACCESS: {
				memcpy(allocation->data, allocation->address, allocation->data_size);
				break;
			}
			case MEMORY_ALLOCATION_TYPE_JUMP: {
				break;
			}
		}
	}

	for(size_t i = 0; i < trace->mem.written.accesses_length; ++i) {
		struct memory_access *access = &trace->mem.written.accesses[i];

		struct memory_allocation allocation;
		allocation.type = MEMORY_ALLOCATION_TYPE_ACCESS;
		allocation.address = access->address;
		allocation.data_size = access->data_size;
		allocation.data = (uint8_t*)malloc(access->data_size);
		memcpy(allocation.data, access->address, access->data_size);

		util_array_generic_add((void**)&context->memory.allocations, &allocation, sizeof(allocation),
				&context->memory.allocations_length, &context->memory.allocations_size);
	}
}

static void unmap_all(struct stack *mappings) {
	while(!stack_empty(mappings)) {
		struct mapping *mapping = (struct mapping*)stack_pop(mappings);
		munmap(mapping->address, mapping->length);
		free(mapping);
	}
}

static struct execution_result result;
static jmp_buf jbuf;

static void sighandler(int signum, siginfo_t *info, void *ptr) {
	printf("Received signal ");
	switch(signum) {
		case SIGSEGV: {
			printf("SIGSEGV");
			break;
		}
		case SIGILL: {
			printf("SIGILL");
			break;
		}
		case SIGALRM: {
			printf("SIGALRM");
			break;
		}
		case SIGBUS: {
			printf("SIGBUS");
			break;
		}
		case SIGFPE: {
			printf("SIGFPE");
			break;
		}
		case SIGSYS: {
			printf("SIGSYS");
			break;
		}
		case SIGTRAP: {
			printf("SIGTRAP");
			break;
		}
		default: {
			printf("UNKNOWN");
			break;
		}
	}
	printf(" while executing code.\n");
	result.signum = signum;
	longjmp(jbuf, 1);
}

struct execution_result executor_instruction_execute(uint8_t *instruction, size_t instruction_length,
		struct tracking_trace *trace, struct context *context, void *code, struct tbgen_result tbgen_result) {

	result.type = EXECUTION_RTYPE_SUCCESS;

	struct stack *mappings = stack_init();

	char retval = map_and_copy(mappings, trace, context, tbgen_result);
	if(retval) {
		result.type = EXECUTION_RTYPE_MAPPING_ERROR;
		goto unmap_all;
	}

	struct sigaction act;
	memset(&act, 0, sizeof(act));
	act.sa_sigaction = sighandler;
	act.sa_flags = SA_SIGINFO;

	sigaction(SIGSEGV, &act, NULL);
	sigaction(SIGILL, &act, NULL);
	sigaction(SIGALRM, &act, NULL);
	sigaction(SIGBUS, &act, NULL);
	sigaction(SIGFPE, &act, NULL);
	sigaction(SIGSYS, &act, NULL);
	sigaction(SIGTRAP, &act, NULL);

//	alarm(1);

#ifndef DRYRUN
	if(!setjmp(jbuf))
		((void (*)(void))code)();
	else
		result.type = EXECUTION_RTYPE_SIGNAL;
#endif

	alarm(0);

	act.sa_sigaction = NULL;
	sigaction(SIGSEGV, &act, NULL);
	sigaction(SIGILL, &act, NULL);
	sigaction(SIGALRM, &act, NULL);
	sigaction(SIGBUS, &act, NULL);
	sigaction(SIGFPE, &act, NULL);
	sigaction(SIGSYS, &act, NULL);
	sigaction(SIGTRAP, &act, NULL);

	write_back(trace, context);

	unmap_all: unmap_all(mappings);
	stack_free(mappings);

	executor_virt_calc(context);

	return result;
}
