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
