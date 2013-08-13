/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <gdsl-x86.h>
#include <sys/resource.h>

int main(int argc, char** argv) {
	const rlim_t kStackSize = 64L * 1024L * 1024L; // min stack size = 64 Mb
	struct rlimit rl;
	int result;

	result = getrlimit(RLIMIT_STACK, &rl);
	if(result == 0) {
		if(rl.rlim_cur < kStackSize) {
			rl.rlim_cur = kStackSize;
			result = setrlimit(RLIMIT_STACK, &rl);
			if(result != 0) {
				fprintf(stderr, "setrlimit returned result = %d\n", result);
			}
		}
	}

	state_t state = gdsl_init();
	gdsl_set_code(state, 0, 0, 0);

	obj_t rreil = x86_tinsng(state);
	obj_t insns = x86_select_live(state);

	size_t size = 256 * 1024;

	string_t fmt = x86_lv_pretty(state, rreil);
	string_t rreil_fmt = x86_rreil_pretty(state, insns);
	puts(fmt);
	puts(rreil_fmt);

	return 0;
}

