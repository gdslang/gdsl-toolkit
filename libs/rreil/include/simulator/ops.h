/*
 * simulator_ops.h
 *
 *  Created on: 08.05.2013
 *      Author: jucs
 */

#ifndef SIMULATOR_OPS_H_
#define SIMULATOR_OPS_H_

extern struct data simulator_op_add(struct data opnd1, struct data opnd2);
extern struct data simulator_op_sub(struct data opnd1, struct data opnd2);
extern struct data simulator_op_mul(struct data opnd1, struct data opnd2);
extern struct data simulator_op_div(struct data opnd1, struct data opnd2);
extern struct data simulator_op_divs(struct data opnd1, struct data opnd2);
extern struct data simulator_op_mod(struct data opnd1, struct data opnd2);
extern struct data simulator_op_shl(struct data opnd1, struct data opnd2);
extern struct data simulator_op_shr(struct data opnd1, struct data opnd2);
extern struct data simulator_op_shrs(struct data opnd1, struct data opnd2);
extern struct data simulator_op_and(struct data opnd1, struct data opnd2);
extern struct data simulator_op_or(struct data opnd1, struct data opnd2);
extern struct data simulator_op_xor(struct data opnd1, struct data opnd2);
extern struct data simulator_op_not(struct data opnd);
extern struct data simulator_op_zx(size_t to, struct data opnd1);
extern struct data simulator_op_sx(size_t to, struct data opnd1);
extern struct data simulator_op_cmp_eq(struct data opnd1, struct data opnd2);
extern struct data simulator_op_cmp_neq(struct data opnd1, struct data opnd2);
extern struct data simulator_op_cmp_les(struct data opnd1, struct data opnd2);
extern struct data simulator_op_cmp_leu(struct data opnd1, struct data opnd2);
extern struct data simulator_op_cmp_lts(struct data opnd1, struct data opnd2);
extern struct data simulator_op_cmp_ltu(struct data opnd1, struct data opnd2);

#endif /* SIMULATOR_OPS_H_ */
