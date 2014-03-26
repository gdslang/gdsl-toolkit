/*
 * gdsl_BareFrontend.c
 *
 *  Created on: Mar 26, 2014
 *      Author: Julian Kranz
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <jni.h>
#include <gdsl.h>
#include <gdsl_multiplex.h>
#include "gdsl_BareFrontend.h"
#include "util.h"

JNIEXPORT jlong JNICALL Java_gdsl_BareFrontend_getFrontendPtrByLibName(JNIEnv *env, jobject this, jstring jfrontendName) {
	const char *frontendName = (*env)->GetStringUTFChars(env, jfrontendName, 0);

	struct frontend *frontend = (struct frontend*)malloc(sizeof(struct frontend));
	char error = gdsl_multiplex_frontend_get_by_lib_name(frontend, frontendName);

	if(error != GDSL_MULTIPLEX_ERROR_NONE) {
		free(frontend);
		handle_frontend_getter_error(env, error);
		return 0;
	}

	(*env)->ReleaseStringUTFChars(env, jfrontendName, frontendName);

	return (jlong)frontend;
}
