/*
 * util.c
 *
 *  Created on: Mar 26, 2014
 *      Author: Julian Kranz
 */

#include "util.h"
#include <jni.h>
#include <gdsl_multiplex.h>

char handle_frontend_getter_error(JNIEnv *env, char error) {
	switch(error) {
		case GDSL_MULTIPLEX_ERROR_FRONTENDS_PATH_NOT_SET:
			THROW_RUNTIME_RET(error, "Unable to open frontend: Path to frontends not set")
		case GDSL_MULTIPLEX_ERROR_UNABLE_TO_OPEN:
			THROW_RUNTIME_RET(error, "Unable to open frontend: Unable to open frontend library")
		case GDSL_MULTIPLEX_ERROR_SYMBOL_NOT_FOUND:
			THROW_RUNTIME_RET(error, "Unable to open frontend: Symbol not found")
		case GDSL_MULTIPLEX_ERROR_NONE:
			break;
	}
	return 0;
}

jobject java_method_call(state_t state, char *name, int numargs, ...) {
  if(numargs > 4) return NULL; //Todo: Handle error

  struct userdata *ud = (struct userdata*)state->userdata;

  jclass class = (*ud->env)->GetObjectClass(ud->env, ud->obj);

  char *signature;
  switch(numargs) {
    case 0: {
      signature = "()Ljava/lang/Object;";
      break;
    }
    case 1: {
      signature = "(Ljava/lang/Object;)Ljava/lang/Object;";
      break;
    }
    case 2: {
      signature = "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;";
      break;
    }
    case 3: {
      signature = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;";
      break;
    }
    case 4: {
      signature = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;";
      break;
    }
  }
  jmethodID mid = (*ud->env)->GetMethodID(ud->env, class, name, signature);

  jobject args[numargs];

  va_list list;
  va_start(list, numargs);
  for(int i = 0; i < numargs; ++i)
    args[i] = va_arg(list, jobject);
  va_end(list);

  jobject ret;
  switch(numargs) {
    case 0: {
      ret = (*ud->env)->CallObjectMethod(ud->env, ud->obj, mid);
      break;
    }
    case 1: {
      ret = (*ud->env)->CallObjectMethod(ud->env, ud->obj, mid, args[0]);
      break;
    }
    case 2: {
      ret = (*ud->env)->CallObjectMethod(ud->env, ud->obj, mid, args[0], args[1]);
      break;
    }
    case 3: {
      ret = (*ud->env)->CallObjectMethod(ud->env, ud->obj, mid, args[0], args[1], args[2]);
      break;
    }
    case 4: {
      ret = (*ud->env)->CallObjectMethod(ud->env, ud->obj, mid, args[0], args[1], args[2], args[3]);
      break;
    }
  }

  return ret;
}

jobject java_long_create(state_t state, long int x) {
  struct userdata *ud = (struct userdata*)state->userdata;

  jclass class = (*ud->env)->FindClass(ud->env, "java/lang/Long");
  jmethodID method_id = (*ud->env)->GetMethodID(ud->env, class, "<init>", "(J)V");
  jobject a = (*ud->env)->NewObject(ud->env, class, method_id, x);

  return a;
}

jstring java_string_create(state_t state, char *x) {
  struct userdata *ud = (struct userdata*)state->userdata;
  jstring str = (*ud->env)->NewStringUTF(ud->env, x);
  return str;
}
