/*
 * simulator_ops.h
 *
 *  Created on: 08.05.2013
 *      Author: jucs
 */

#ifndef SIMULATOR_OPS_H_
#define SIMULATOR_OPS_H_

extern uint8_t *simulator_op_add(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length);
extern uint8_t *simulator_op_sub(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length);
extern uint8_t *simulator_op_mul(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length);
extern uint8_t *simulator_op_zx(size_t from, size_t to, uint8_t *opnd1);
extern uint8_t *simulator_op_sx(size_t from, size_t to, uint8_t *opnd1);

#endif /* SIMULATOR_OPS_H_ */
