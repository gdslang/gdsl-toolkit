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
extern uint8_t *simulator_op_div(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length);
extern uint8_t *simulator_op_divs(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length);
extern uint8_t *simulator_op_mod(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length);
extern uint8_t *simulator_op_and(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length);
extern uint8_t *simulator_op_or(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length);
extern uint8_t *simulator_op_xor(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length);
extern uint8_t *simulator_op_not(uint8_t *opnd, size_t bit_length);
extern uint8_t *simulator_op_zx(size_t from, size_t to, uint8_t *opnd1);
extern uint8_t *simulator_op_sx(size_t from, size_t to, uint8_t *opnd1);
extern uint8_t simulator_op_cmp_eq(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length);
extern uint8_t simulator_op_cmp_neq(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length);
extern uint8_t simulator_op_cmp_les(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length);
extern uint8_t simulator_op_cmp_leu(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length);
extern uint8_t simulator_op_cmp_lts(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length);
extern uint8_t simulator_op_cmp_ltu(uint8_t *opnd1, uint8_t *opnd2, size_t bit_length);

#endif /* SIMULATOR_OPS_H_ */
