/*
 * gdrr.c
 *
 *  Created on: Feb 22, 2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <dis.h>

void test(__obj semantics) {
	printf(":-)\n");

  while (__CASETAGCON(semantics)==__SEM_CONS) {
    __obj rec = __DECON(semantics);
    __obj instr = __RECORD_SELECT(rec, ___hd);

    switch (__CASETAGCON(instr)) {
        case __SEM_ASSIGN: {
        	printf("assign\n");
        	break;
        }
        case __SEM_XOR: {
        	printf("xor\n");
        	break;
        }
        case __SEM_ITE: {
        	printf("ite\n");
        	break;
        }
        default: {
        	printf("%d\n", __CASETAGCON(instr));
        	break;
        }
    }

    semantics = __RECORD_SELECT(rec, ___tl);
  };
}
