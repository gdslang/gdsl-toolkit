/*
 * x86_generator.c
 *
 *  Created on: 30.04.2013
 *      Author: jucs
 */

#include <x86_generator.h>

struct generator_tree_node *x86_generator_tree_get() {
	struct generator_tree_node *imm = generator_tree_generator_build(generator_init(GENERATOR_TYPE_IMMEDIATE), NULL);
	struct generator_tree_node *rm_imm = generator_tree_generator_build(generator_init(GENERATOR_TYPE_MODRM), imm);
	struct generator_tree_node *op_rm_imm = generator_tree_generator_build(generator_init(GENERATOR_TYPE_OPCODE), rm_imm);
	struct generator_tree_node *rex_op_rm_imm = generator_tree_generator_build(generator_init(GENERATOR_TYPE_REX), op_rm_imm);
	struct generator_tree_node *pref_rex_op_rm_imm = generator_tree_generator_build(generator_init(GENERATOR_TYPE_PREFIXES), rex_op_rm_imm);

	struct generator_tree_node *vex_op_rm_imm = generator_tree_generator_build(generator_init(GENERATOR_TYPE_VEX), op_rm_imm);

	struct generator_tree_node *root = generator_tree_branch(2, pref_rex_op_rm_imm, 3, vex_op_rm_imm, 2);

	return root;
}
