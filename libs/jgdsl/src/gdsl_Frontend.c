/*
 * gdsl_Frontend.c
 *
 *  Created on: 13.04.2014
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <jni.h>
#include <gdsl.h>
#include <gdsl_multiplex.h>
#include "gdsl_Frontend.h"
#include "util.h"

JNIEXPORT void JNICALL Java_gdsl_Frontend_destroy
  (JNIEnv *env, jobject this, jlong frontendPtr) {
	struct frontend *frontend = (struct frontend*)frontendPtr;

	gdsl_multiplex_frontend_close(frontend);
	free(frontend);
}
