/*
 * gdsl_BareFrontend.h
 *
 *  Created on: Mar 26, 2014
 *      Author: Julian Kranz
 */

#pragma once

/*
 * Class:     gdsl_BareFrontend
 * Method:    getFrontendPtrByLibName
 * Signature: (Lgdsl/Frontend;)J
 */
JNIEXPORT jlong JNICALL Java_gdsl_BareFrontend_getFrontendPtrByLibName
  (JNIEnv *, jobject, jstring);
