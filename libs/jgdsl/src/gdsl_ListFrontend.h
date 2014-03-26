/*
 * gdsl_ListFrontend.h
 *
 *  Created on: Mar 26, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include <jni.h>

/*
 * Class:     gdsl_ListFrontend
 * Method:    getFrontendPtrByDesc
 * Signature: (Lgdsl/Frontend;)J
 */
JNIEXPORT jlong JNICALL Java_gdsl_ListFrontend_getFrontendPtrByDesc
  (JNIEnv *, jobject, jobject);
