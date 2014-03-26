/*
 * gdsl_ListFrontend.c
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
#include "gdsl_ListFrontend.h"

#define THROW_RUNTIME(RET, MSG) {\
		jclass exp = (*env)->FindClass(env, "java/lang/RuntimeException");\
		(*env)->ThrowNew(env, exp, MSG);\
		return RET;\
}

#define THROW_GDSL_ERROR(RET) {\
		jclass exp = (*env)->FindClass(env, "gdsl/GdslException");\
		(*env)->ThrowNew(env, exp, frontend->generic.get_error_message(state));\
		return RET;\
}

/*
 * Todo: Merge with gdslBarefront.c->
 */
static char handle_frontend_getter_error(JNIEnv *env, char error) {
	switch(error) {
		case GDSL_MULTIPLEX_ERROR_FRONTENDS_PATH_NOT_SET:
			THROW_RUNTIME(error, "Unable to open frontend: Path to frontends not set")
		case GDSL_MULTIPLEX_ERROR_UNABLE_TO_OPEN:
			THROW_RUNTIME(error, "Unable to open frontend: Unable to open frontend library")
		case GDSL_MULTIPLEX_ERROR_SYMBOL_NOT_FOUND:
			THROW_RUNTIME(error, "Unable to open frontend: Symbol not found")
		case GDSL_MULTIPLEX_ERROR_NONE:
			break;
	}
	return 0;
}

JNIEXPORT jlong JNICALL Java_gdsl_ListFrontend_getFrontendPtrByDesc(JNIEnv *env, jobject this, jobject jfrontend) {
	jclass Gdsl_ListFrontend = (*env)->FindClass(env, "gdsl/ListFrontend");

	jmethodID getName = (*env)->GetMethodID(env, Gdsl_ListFrontend, "getName", "()Ljava/lang/String;");
	jmethodID getExt = (*env)->GetMethodID(env, Gdsl_ListFrontend, "getExt", "()Ljava/lang/String;");

	jstring jname = (*env)->CallObjectMethod(env, jfrontend, getName);
	jstring jext = (*env)->CallObjectMethod(env, jfrontend, getExt);

	const char *name = (*env)->GetStringUTFChars(env, jname, 0);
	const char *ext = (*env)->GetStringUTFChars(env, jext, 0);

	struct frontend_desc desc;
	desc.name = name;
	desc.ext = ext;

	struct frontend *frontend = (struct frontend*)malloc(sizeof(struct frontend));
	char error = gdsl_multiplex_frontend_get_by_desc(frontend, desc);

	if(error != GDSL_MULTIPLEX_ERROR_NONE) {
		free(frontend);
		handle_frontend_getter_error(env, error);
		return 0;
	}

	(*env)->ReleaseStringUTFChars(env, jname, name);
	(*env)->ReleaseStringUTFChars(env, jext, ext);

	return (jlong)frontend;
}
