/*
 * simulator_regacc.c
 *
 *  Created on: 08.05.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <string.h>
#include <rreil/rreil.h>
#include <context.h>
#include <simulator/simulator.h>
#include <simulator/regacc.h>
#include <simulator/tools.h>

static void simulator_register_assign(struct context *context,
		struct rreil_id *id, struct data data, size_t bit_offset,
		void (*function)(struct register_ *, struct data data, size_t)) {
	switch(id->type) {
		case RREIL_ID_TYPE_VIRTUAL: {
			function(&context->virtual_registers[id->virtual_], data, bit_offset);
			break;
		}
		case RREIL_ID_TYPE_TEMPORARY: {
			function(&context->temporary_registers[id->temporary], data, bit_offset);
			break;
		}
		case RREIL_ID_TYPE_X86: {
			function(&context->x86_registers[id->x86], data, bit_offset);
			break;
		}
	}
}

static void simulator_register_generic_read(struct register_ *reg,
		struct data data, size_t bit_offset) {
	size_t length;
	size_t rest;

	if(bit_offset > reg->bit_length)
		length = 0;
	else if(data.bit_length + bit_offset > reg->bit_length)
		length = reg->bit_length - bit_offset;
	else
		length = data.bit_length;
	rest = data.bit_length - length;

	membit_cpy(data.data, 0, reg->data, bit_offset, length);
	membit_cpy(data.defined, 0, reg->defined, bit_offset, length);

	if(rest)
		membit_zero_fill(data.defined, length, rest);
}

void simulator_register_read(struct context *context, struct rreil_id *id,
		struct data data, size_t bit_offset) {
	simulator_register_assign(context, id, data, bit_offset,
			&simulator_register_generic_read);
}

//void simulator_register_read_8(struct context *context,
//		struct rreil_id *id, uint8_t *buffer, size_t bit_offset) {
//	simulator_register_read(context, id, buffer, 8, bit_offset);
//}
//
//void simulator_register_read_16(struct context *context,
//		struct rreil_id *id, uint8_t *buffer, size_t bit_offset) {
//	simulator_register_read(context, id, buffer, 16, bit_offset);
//}
//
//void simulator_register_read_32(struct context *context,
//		struct rreil_id *id, uint8_t *buffer, size_t bit_offset) {
//	simulator_register_read(context, id, buffer, 32, bit_offset);
//}
//
//void simulator_register_read_64(struct context *context,
//		struct rreil_id *id, uint8_t *buffer, size_t bit_offset) {
//	simulator_register_read(context, id, buffer, 64, bit_offset);
//}

void simulator_register_generic_write(struct register_ *reg, struct data data,
		size_t bit_offset) {
	if(bit_offset + data.bit_length > reg->bit_length) {
		size_t new_size = bit_offset / 8 + data.bit_length / 8
				+ (bit_offset % 8 + data.bit_length % 8) / 8
				+ ((bit_offset + data.bit_length) % 8 > 0);
		size_t reg_size = reg->bit_length / 8 + (reg->bit_length % 8 > 0);

		reg->data = (uint8_t*)realloc(reg->data, new_size);

		reg->defined = (uint8_t*)realloc(reg->defined, new_size);
		memset(reg->defined + reg_size, 0, new_size - reg_size);

		reg->bit_length = bit_offset + data.bit_length;
	}

	membit_cpy(reg->data, bit_offset, data.data, 0, data.bit_length);
	membit_cpy(reg->defined, bit_offset, data.defined, 0, data.bit_length);

//	void byte_write(uint8_t data, uint8_t length, size_t offset) {
//		if(offset % 8 || length < 8) {
//			uint8_t local = offset % 8;
//			uint8_t low = reg->data[offset / 8];
//			uint8_t high = reg->data[offset / 8 + 1];
//
//			uint8_t length_mask = (1 << length) - 1;
//			data &= length_mask;
//
////			uint8_t mask = (1 << local) - 1; => mask / ~mask
//			low &= ~(length_mask << local);
//			high &= ~(length_mask >> (8 - local));
//
//			low |= data << local;
//			high |= data >> (8 - local);
//
//			reg->data[offset / 8] = low;
//			reg->data[offset / 8 + 1] = high;
//		} else
//			reg->data[offset / 8] = data;
//	}
//
//	while(bit_length >= 8) {
//		byte_write(*(data.data++), 8, bit_offset);
//		bit_offset += 8;
//		bit_length -= 8;
//	}
//
//	if(bit_length)
//		byte_write(*data.data, bit_length, bit_offset);
}

void simulator_register_write(struct context *context, struct rreil_id *id,
		struct data data, size_t bit_offset) {
	simulator_register_assign(context, id, data, bit_offset,
			&simulator_register_generic_write);
}

//void simulator_register_write_8(struct context *context, struct rreil_id *id,
//		uint8_t data, size_t bit_offset) {
//	simulator_register_write(context, id, &data, sizeof(data) * 8, bit_offset);
//}
//
//void simulator_register_write_16(struct context *context, struct rreil_id *id,
//		uint16_t data, size_t bit_offset) {
//	simulator_register_write(context, id, (uint8_t*)&data, sizeof(data) * 8,
//			bit_offset);
//}
//
//void simulator_register_write_32(struct context *context, struct rreil_id *id,
//		uint32_t data, size_t bit_offset) {
//	simulator_register_write(context, id, (uint8_t*)&data, sizeof(data) * 8,
//			bit_offset);
//}
//
//void simulator_register_write_64(struct context *context, struct rreil_id *id,
//		uint64_t data, size_t bit_offset) {
//	simulator_register_write(context, id, (uint8_t*)&data, sizeof(data) * 8,
//			bit_offset);
//}
