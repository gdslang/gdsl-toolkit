/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class rnati_NativeInterface */

#ifndef _Included_gdsl_rnati_NativeInterface
#define _Included_gdsl_rnati_NativeInterface
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     rnati_NativeInterface
 * Method:    decodeAndTranslateNative
 * Signature: ([B)Ljava/lang/Object;
 */
JNIEXPORT jobject JNICALL Java_gdsl_rnati_NativeInterface_decodeAndTranslateNative(JNIEnv *, jobject, jbyteArray);

JNIEXPORT jobjectArray JNICALL Java_gdsl_rnati_NativeInterface_getFrontendsNative(JNIEnv *, jobject);
JNIEXPORT void JNICALL Java_gdsl_rnati_NativeInterface_useFrontendNative(JNIEnv *, jobject, jlong);
JNIEXPORT void JNICALL Java_gdsl_rnati_NativeInterface_frontendDescsFreeNative(JNIEnv *, jobject);
JNIEXPORT void JNICALL Java_gdsl_rnati_NativeInterface_closeFrontendNative(JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
