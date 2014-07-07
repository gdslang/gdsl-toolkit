/*
 * util.h
 *
 *  Created on: Mar 26, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include <jni.h>
#include <gdsl_generic.h>

#define THROW_RUNTIME_RET(RET, MSG) {\
		jclass exp = (*env)->FindClass(env, "java/lang/RuntimeException");\
		(*env)->ThrowNew(env, exp, MSG);\
		return RET;\
}

#define THROW_RUNTIME(MSG) {\
		jclass exp = (*env)->FindClass(env, "java/lang/RuntimeException");\
		(*env)->ThrowNew(env, exp, MSG);\
		return;\
}

#define THROW_GDSL_EXCEPTION_RET(RET) {\
		jclass exp = (*env)->FindClass(env, "gdsl/GdslException");\
		(*env)->ThrowNew(env, exp, frontend->generic.get_error_message(state));\
		return RET;\
}

struct userdata {
  JNIEnv *env;
  jobject obj;
  struct frontend *frontend;
};

/*
 * Todo: Horrible hack
 */
void *(*rreil_cif_userdata_get)(state_t state);

extern jobject java_method_call(state_t state, char *name, int numargs, ...);
extern jobject java_long_create(state_t state, long int x);
extern jstring java_string_create(state_t state, char *x);

extern char handle_frontend_getter_error(JNIEnv *env, char error);
