/*
 * util.h
 *
 *  Created on: Mar 26, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include <jni.h>

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

extern char handle_frontend_getter_error(JNIEnv *env, char error);
