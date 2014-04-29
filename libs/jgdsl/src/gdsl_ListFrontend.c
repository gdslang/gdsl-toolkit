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
#include "util.h"

JNIEXPORT jlong JNICALL Java_gdsl_ListFrontend_getFrontendPtrByDesc(JNIEnv *env, jobject this) {
	jclass Gdsl_ListFrontend = (*env)->FindClass(env, "gdsl/ListFrontend");

	jmethodID getName = (*env)->GetMethodID(env, Gdsl_ListFrontend, "getName", "()Ljava/lang/String;");
	jmethodID getExt = (*env)->GetMethodID(env, Gdsl_ListFrontend, "getExt", "()Ljava/lang/String;");

	jstring jname = (*env)->CallObjectMethod(env, this, getName);
	jstring jext = (*env)->CallObjectMethod(env, this, getExt);

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
