/*
 * simulator_regacc.h
 *
 *  Created on: 08.05.2013
 *      Author: jucs
 */

#ifndef SIMULATOR_REGACC_H_
#define SIMULATOR_REGACC_H_

#include <stdlib.h>
#include <stdint.h>
#include <simulator/simulator.h>

extern void simulator_register_read(struct context *context,
		struct rreil_id *id, struct data data, size_t bit_offset);
//extern void simulator_register_read_8(struct context *context,
//		struct rreil_id *id, uint8_t *buffer, size_t bit_offset);
//extern void simulator_register_read_16(struct context *context,
//		struct rreil_id *id, uint8_t *buffer, size_t bit_offset);
//extern void simulator_register_read_32(struct context *context,
//		struct rreil_id *id, uint8_t *buffer, size_t bit_offset);
//extern void simulator_register_read_64(struct context *context,
//		struct rreil_id *id, uint8_t *buffer, size_t bit_offset);

extern void simulator_register_generic_write(struct register_ *reg,
		struct data data, size_t bit_offset);
extern void simulator_register_write(struct context *context,
		struct rreil_id *id, struct data data, size_t bit_offset);
//extern void simulator_register_write_8(struct context *context,
//		struct rreil_id *id, uint8_t data, size_t bit_offset);
//extern void simulator_register_write_16(struct context *context,
//		struct rreil_id *id, uint16_t data, size_t bit_offset);
//extern void simulator_register_write_32(struct context *context,
//		struct rreil_id *id, uint32_t data, size_t bit_offset);
//extern void simulator_register_write_64(struct context *context,
//		struct rreil_id *id, uint64_t data, size_t bit_offset);

#endif /* SIMULATOR_REGACC_H_ */
