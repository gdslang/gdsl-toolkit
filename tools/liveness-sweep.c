/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <getopt.h>
#include <unistd.h>
#include <gdsl.h>
#include <sys/resource.h>

#include <err.h>
#include <fcntl.h>
#include <gelf.h>
#include <string.h>
#include <sysexits.h>

#include <time.h>

char elf_section_boundary_get(char *path, size_t *offset, size_t *size) {
	char retval = 0;

	int fd = open(path, O_RDONLY);
	if(!fd) {
		retval = 8;
		goto end_0;
	}

	if(elf_version(EV_CURRENT) == EV_NONE) {
		retval = 2;
		goto end_0;
	}

	Elf *e = elf_begin(fd, ELF_C_READ, NULL);
	if(!e) {
		retval = 3;
		goto end_0;
	}

	if(elf_kind(e) != ELF_K_ELF) {
		retval = 4;
		goto end_1;
	}

	size_t shstrndx;
	if(elf_getshdrstrndx(e, &shstrndx) != 0) {
		retval = 5;
		goto end_1;
	}

	Elf_Scn *scn = NULL;

	char found = 0;
	while((scn = elf_nextscn(e, scn)) != NULL) {
		GElf_Shdr shdr;
		if(gelf_getshdr(scn, &shdr) != &shdr) {
			retval = 6;
			goto end_1;
		}

		char *name = elf_strptr(e, shstrndx, shdr.sh_name);
		if(!name) {
			retval = 7;
			goto end_1;
		}
		if(!strcmp(name, ".text")) {
			*offset = shdr.sh_offset;
			*size = shdr.sh_size;
			found = 1;
			break;
		}
//		printf("%s - %zu:%zu\n", name, shdr.sh_offset, shdr.sh_size);
	}

	if(!found)
		retval = 1;

	end_1: elf_end(e);

	end_0: close(fd);

	return retval;
}

enum p_option {
	OPTION_ELF, OPTION_OFFSET, OPTION_SINGLE, OPTION_CHILDREN, OPTION_FILE, OPTION_CLEANUP, OPTION_LATEX
};

enum mode {
	MODE_SINGLE, MODE_DEFAULT, MODE_CHILDREN
};

struct options {
	char elf;
	size_t offset;
	enum mode mode;
	char **files;
	size_t files_size;
	size_t files_length;
	char cleanup;
	char latex;
};

static char args_parse(int argc, char **argv, struct options *options) {
	options->elf = 0;
	options->offset = 0;
	options->mode = MODE_DEFAULT;
	options->files_size = 8;
	options->files = (char**)malloc(sizeof(char*) * options->files_size);
	options->files_length = 0;
	options->cleanup = 0;
	options->latex = 0;

	struct option long_options[] = { { "elf", no_argument, NULL, OPTION_ELF }, { "offset", required_argument, NULL,
			OPTION_OFFSET }, { "children",
	no_argument, NULL, OPTION_CHILDREN }, { "single", no_argument, NULL, OPTION_SINGLE }, { "file", required_argument,
	NULL, OPTION_FILE }, { "cleanup", no_argument, NULL, OPTION_CLEANUP }, { "latex", no_argument,
	NULL, OPTION_LATEX }, { 0, 0, 0, 0 }, };

	while(1) {
		int result = getopt_long(argc, argv, "", long_options, NULL);
		if(result < 0)
			break;
		switch(result) {
			case OPTION_ELF: {
				options->elf = 1;
				break;
			}
			case OPTION_OFFSET: {
				sscanf(optarg, "%lu", &options->offset);
				break;
			}
			case OPTION_CHILDREN: {
				options->mode = MODE_CHILDREN;
				break;
			}
			case OPTION_SINGLE: {
				options->mode = MODE_SINGLE;
				break;
			}
			case OPTION_LATEX: {
				options->latex = 1;
				break;
			}
			case OPTION_FILE: {
				if(options->files_length == options->files_size) {
					options->files_size <<= 1;
					options->files = (char**)realloc(options->files, sizeof(char*) * options->files_size);
				}
				options->files[options->files_length++] = optarg;
				break;
			}
			case OPTION_CLEANUP: {
				options->cleanup = 1;
				break;
			}
			case '?':
				return 2;
		}
	}

	if(!options->files_length)
		return 1;

	return 0;
}

obj_t translate_single(state_t state) {
	if(setjmp(*gdsl_err_tgt(state)))
		return NULL;
	obj_t rreil_insns = gdsl_translateSingle(state);
	return rreil_insns;
}

obj_t translate(state_t state) {
	if(setjmp(*gdsl_err_tgt(state)))
		return NULL;
	obj_t rreil_insns = gdsl_translateBlock(state);
	return rreil_insns;
}

obj_t translate_super(state_t state, obj_t *rreil_insns) {
	if(setjmp(*gdsl_err_tgt(state)))
		return NULL;
	obj_t rreil_insns_succs = gdsl_translateSuperBlock(state);
	*rreil_insns = gdsl_select_insns(state, rreil_insns_succs);
	return rreil_insns_succs;
}

void print_succs(state_t state, obj_t translated, size_t size) {
	obj_t succ_a = gdsl_select_succ_a(state, translated);
	obj_t succ_b = gdsl_select_succ_b(state, translated);

//	void print_succ(obj_t succ, char const *name) {
//		switch(x86_con_index(state, succ)) {
//			case __SO_SOME: {
//				obj_t succ_insns = __DECON(succ);
//				printf("Succ %s:\n", name);
//				string_t fmt = gdsl_rreil_pretty(state, succ_insns);
//				puts(fmt);
//				break;
//			}
//			case __SO_NONE: {
//				printf("Succ %s: __SO_NONE :-(\n", name);
//				break;
//			}
//		}
//	}

	string_t r = gdsl_merge_rope(state, gdsl_succ_pretty(state, succ_a, "a"));
	printf("%s", r);

	r = gdsl_merge_rope(state, gdsl_succ_pretty(state, succ_b, "b"));
	printf("%s", r);

//	print_succ(succ_a, "a");
//	print_succ(succ_b, "b");
}

struct context {
	size_t native_instructions;
	size_t lines;
	size_t lines_opt;
	long time_non_opt;
	long time_opt;
};

void print_results(struct context *context) {
	printf("Statistics:\n");
	printf("Number of native instructions: %zu\n", context->native_instructions);
	printf("Number of lines without LV analysis: %zu\n", context->lines);
	printf("Number of lines with LV analysis: %zu\n", context->lines_opt);

	double reduction = 1 - (context->lines_opt / (double)context->lines);

	printf("Reduction: %lf%%\n", 100 * reduction);

	printf("Time needed for the decoding and the translation to RREIL: %lf seconds\n",
			context->time_non_opt / (double)(1000000000));
	printf("Time needed for the lv analysis: %lf seconds\n", context->time_opt / (double)(1000000000));
}

static char *symbol_sz(size_t value) {
	if(value < 10 * 1000)
		return "k";
	if(value < 10 * 1000 * 1000)
		return "k";
	return "M";
}

static size_t fit_sz(size_t value) {
	if(value < 10 * 1000)
		return (value + 500) / 1000;
	if(value < 10 * 1000 * 1000)
		return (value + 500) / 1000;
	return (value + 500 * 1000) / (1000 * 1000);
}

static char *symbol_t(double value) {
	if(value < 2 * 60)
		return "s";
	if(value < 2 * 60 * 60)
		return "m";
	return "h";
}

static double fit_t(double value) {
	if(value < 2 * 60)
		return value;
	if(value < 2 * 60 * 60)
		return value / 60;
	return value / (60 * 60);
}

void print_results_latex(char *file, struct context *single, struct context *intra, struct context *inter) {
	//netstat & 15k & 86k & 1.10s & 63k & 17.43s & 26.04\% & 53k & 39.98s & 38.51\%
	double reduction_simple = 1 - (single->lines_opt / (double)single->lines);
	double reduction_inter = 1 - (inter->lines_opt / (double)inter->lines);
	double reduction_intra = 1 - (intra->lines_opt / (double)intra->lines);

	double fac_non = single->lines / (double)single->native_instructions;
	double fac_single = single->lines_opt / (double)single->native_instructions;
	double fac_inta = intra->lines_opt / (double)single->native_instructions;
	double fac_inter = inter->lines_opt / (double)single->native_instructions;

	size_t file_offset = 0;
	for(size_t i = 0; file[i]; i++) {
		if(file[i] == '/')
			file_offset = i + 1;
	}

	printf(
			"%s & %lu%s & %lu%s & %.1lf%s & %.1lf & %lu%s & %.1lf%s & %.0lf\\%% & %.1f & %lu%s & %.1lf%s & %.0lf\\%% & %.1f & %lu%s & %.1lf%s & %.0lf\\%% & %.1f \\\\\n",
			file + file_offset, fit_sz(inter->native_instructions), symbol_sz(inter->native_instructions),
			fit_sz(inter->lines), symbol_sz(inter->lines), fit_t(inter->time_non_opt / (double)(1000000000)),
			symbol_t(inter->time_non_opt / (double)(1000000000)), fac_non,

			fit_sz(single->lines_opt), symbol_sz(single->lines_opt), fit_t(single->time_opt / (double)(1000000000)),
			symbol_t(single->time_opt / (double)(1000000000)), 100 * reduction_simple, fac_single,

			fit_sz(intra->lines_opt), symbol_sz(intra->lines_opt), fit_t(intra->time_opt / (double)(1000000000)),
			symbol_t(intra->time_opt / (double)(1000000000)), 100 * reduction_intra, fac_inta,

			fit_sz(inter->lines_opt), symbol_sz(inter->lines_opt), fit_t(inter->time_opt / (double)(1000000000)),
			symbol_t(inter->time_opt / (double)(1000000000)), 100 * reduction_inter, fac_inter);
}

char analyze(char *file, char print, enum mode mode, char cleanup, size_t file_offset, size_t size_max,
		size_t user_offset, struct context *context) {
	size_t size = 16 * 1024 * 1024;
	char *fmt = (char*)malloc(size);

	FILE *f = fopen(file, "r");
	if(!f) {
		printf("Unable to open file.\n");
		return 1;
	}

	fseek(f, file_offset, SEEK_SET);

	size_t buffer_size = 128;
	char *buffer = NULL;
	size_t buffer_length = 0;
	do {
		buffer_size *= 2;
		buffer = (char*)realloc(buffer, buffer_size);
		buffer_length += fread(buffer + buffer_length, 1, buffer_size - buffer_length, f);
	} while(!feof(f) && (!size_max || buffer_length < size_max));

	fclose(f);

	//printf("size_max: %lu, buffer_length: %lu\n", size_max, buffer_length);

	if(size_max && buffer_length > size_max)
		buffer_length = size_max;

	if(buffer_length == buffer_size) {
		buffer_size++;
		buffer = (char*)realloc(buffer, buffer_size);
	}
	buffer[buffer_length++] = 0xc3; //Last instruction should be a jump (ret) ;-).

	struct timespec start;
	struct timespec end;

//	printf("buffer_length=%zu\n", buffer_length);

	uint64_t consumed = user_offset;
//	uint64_t consumed = 228;
//	uint64_t consumed = 0;

	obj_t state = gdsl_init();

	gdsl_set_code(state, buffer, buffer_length, 0);

	while(consumed < buffer_length) {
		if(print)
			printf("### Next block (@offset %lu): ###\n\n", consumed);

//		obj_t state = __createState(buffer + consumed, buffer_length - consumed,
//				consumed, 0);
//		gdsl_set_code(state, buffer + consumed, buffer_length - consumed, 0);
		gdsl_seek(state, consumed);

		obj_t translated = NULL;
		obj_t rreil_insns = NULL;
		clock_gettime(CLOCK_MONOTONIC_RAW, &start);
		switch(mode) {
			case MODE_SINGLE: {
				translated = rreil_insns = translate_single(state);
				break;
			}
			case MODE_DEFAULT: {
				translated = rreil_insns = translate(state);
				break;
			}
			case MODE_CHILDREN: {
				translated = translate_super(state, &rreil_insns);
				break;
			}
		}
		clock_gettime(CLOCK_MONOTONIC_RAW, &end);
		long diff = end.tv_nsec - start.tv_nsec;
		context->time_non_opt += diff > 0 ? diff : 0;

		if(translated == NULL || rreil_insns == NULL) {
			printf("Translation or decoding error, aborting...");
			break;
		}

		/*
		 * Todo: Fix
		 */
//		if(!__isNil(rreil_insns)) {
//			__fatal("TranslateBlock failed");
//			goto end;
//		}
		if(print && mode == MODE_CHILDREN)
			print_succs(state, translated, size);

		int_t native_instruction_count = gdsl_select_ins_count(state);
		context->native_instructions += native_instruction_count;

		//printf("%x\n", buffer[consumed]);

		if(print)
			printf("Initial RREIL instructions:\n");
		//__pretty(__rreil_pretty__, rreil_insns, fmt, size);
		string_t fmt = gdsl_merge_rope(state, gdsl_rreil_pretty(state, rreil_insns));
		if(print) {
			puts(fmt);
			printf("\n");
		}

		for(size_t i = 0; fmt[i]; i++)
			if(fmt[i] == '\n')
				context->lines++;

		obj_t lv_result;
		clock_gettime(CLOCK_MONOTONIC_RAW, &start);

		switch(mode) {
			case MODE_CHILDREN: {
				lv_result = gdsl_liveness_super(state, translated);
				break;
			}
			default: {
				lv_result = gdsl_liveness(state, translated);
				break;
			}
		}
		obj_t rreil_instructions_greedy = gdsl_select_live(state, gdsl_state_get(state));
		/*
		 * Todo: Fix
		 */
//		if(!__isNil(rreil_instructions_greedy)) {
//			__fatal("Liveness failed (no greedy instructions)");
//			goto end;
//		}
		if(cleanup) {
			/*
			 * Move the output somewhere else (so that it does not disturb the time measurement)
			 */
//			printf("RREIL instructions after LV (greedy), before cleanup:\n");
//			__pretty(__rreil_pretty__, rreil_instructions_greedy, fmt, size);
//			puts(fmt);
//			printf("\n");
			rreil_instructions_greedy = gdsl_cleanup(state, rreil_instructions_greedy);
		}

		clock_gettime(CLOCK_MONOTONIC_RAW, &end);
		diff = end.tv_nsec - start.tv_nsec;
		context->time_opt += diff > 0 ? diff : 0;
//		if(!__isNil(greedy_state)) {
//			__fatal("Liveness failed");
//			goto end;
//		}

		if(print && mode == MODE_CHILDREN) {
			obj_t initial_state = gdsl_select_initial(state, lv_result);
			printf("Liveness initial state:\n");
			fmt = gdsl_merge_rope(state, gdsl_lv_pretty(state, initial_state));
			puts(fmt);
			printf("\n");
		}

		obj_t greedy_state;

		switch(mode) {
			case MODE_CHILDREN: {
				greedy_state = gdsl_select_after(state, lv_result);
				break;
			}
			default: {
				greedy_state = lv_result;
				break;
			}
		}
		if(print) {
			printf("Liveness greedy state:\n");
			fmt = gdsl_merge_rope(state, gdsl_lv_pretty(state, greedy_state));
			puts(fmt);
			printf("\n");
		}

		if(cleanup) {
			if(print) {
				printf("RREIL instructions after LV (greedy), before cleanup:\n");
				fmt = gdsl_merge_rope(state, gdsl_rreil_pretty(state, rreil_instructions_greedy));
				puts(fmt);
				printf("\n");
			}

			rreil_instructions_greedy = gdsl_cleanup(state, rreil_instructions_greedy);
		}

		if(print)
			printf("RREIL instructions after LV (greedy):\n");
		fmt = gdsl_merge_rope(state, gdsl_rreil_pretty(state, rreil_instructions_greedy));
		if(print) {
			puts(fmt);
			printf("\n");
		}

		for(size_t i = 0; fmt[i]; i++)
			if(fmt[i] == '\n')
				context->lines_opt++;

		//consumed += __getBlobIndex(state) - consumed;
		consumed = gdsl_get_ip_offset(state);

		gdsl_reset_heap(state);

		//printf("consumed: %lu, buffer_length: %lu\n", consumed, buffer_length);
	}

	if(context->native_instructions)
		context->native_instructions--;

	free(buffer);
	free(fmt);

	gdsl_destroy(state);

	return 0;
}

static void file_bounds_set(struct options options, size_t *offset, size_t *size_max, char *file) {
	if(options.elf) {
		char e = elf_section_boundary_get(file, offset, size_max);
		if(e)
			exit(2);
	} else {
		*offset = 0;
		*size_max = 0;
	}
}

static void run(struct options options, size_t *offset, size_t *size_max, double *single_red_cum, double *intra_red_cum,
		double *inter_red_cum, size_t index, char print) {
	if(options.latex) {
		struct context inter;
		memset(&inter, 0, sizeof(inter));
		struct context intra;
		memset(&intra, 0, sizeof(intra));
		struct context single;
		memset(&single, 0, sizeof(single));

		file_bounds_set(options, offset, size_max, options.files[index]);

		analyze(options.files[index], print, MODE_SINGLE, options.cleanup, *offset, *size_max, options.offset, &single);
		analyze(options.files[index], print, MODE_DEFAULT, options.cleanup, *offset, *size_max, options.offset, &intra);
		analyze(options.files[index], print, MODE_CHILDREN, options.cleanup, *offset, *size_max, options.offset, &inter);

		print_results_latex(options.files[index], &single, &intra, &inter);

		*single_red_cum += 1 - (single.lines_opt / (double)single.lines);
		*intra_red_cum += 1 - (intra.lines_opt / (double)intra.lines);
		*inter_red_cum += 1 - (inter.lines_opt / (double)inter.lines);
	} else {

		struct context context;
		memset(&context, 0, sizeof(context));
		file_bounds_set(options, offset, size_max, options.files[index]);
		analyze(options.files[index], print, options.mode, options.cleanup, *offset, *size_max, options.offset, &context);

		print_results(&context);
	}
}

int main(int argc, char** argv) {
	struct options options;
	if(args_parse(argc, argv, &options)) {
		printf("Usage: liveness-sweep [--children] [--offset offset] [--elf] [--cleanup] --file file\n");
		return 42;
	}

//	printf("elf=%d, offset=%lu, children=%d, file=%s, cleanup=%d\n", options.elf,
//			options.offset, options.children_consider, options.file, options.cleanup);

	const rlim_t kStackSize = 4096L * 1024L * 1024L;
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

	size_t offset;
	size_t size_max;

//	if(argc == 3) {
//		if(strcmp(argv[1], "--elf"))
//			return 1;
//		char e = elf_section_boundary_get(argv[2], &offset, &size_max);
//		if(e)
//			return 2;
//	} else if(argc != 2) {
//		printf("Usage: liveness-sweep [--elf] file\n");
//		return 1;
//	} else {
//		offset = 0;
//		size_max = 0;
//	}

//	FILE *f = fopen(argv[1 + (argc == 3)], "r");

	size_t count = 0;
	double single_red_cum = 0.0d;
	double intra_red_cum = 0.0d;
	double inter_red_cum = 0.0d;

	if(options.files_length == 1) {
		run(options, &offset, &size_max, &single_red_cum, &intra_red_cum, &inter_red_cum, 0, 1);
		count = 1;
	} else {
		for(size_t i = 0; i < options.files_length; ++i) {
			if(!options.latex)
				printf("$$$$$$ File %s:\n", options.files[i]);
			run(options, &offset, &size_max, &single_red_cum, &intra_red_cum, &inter_red_cum, i, 0);
		}
		count = options.files_length;
	}

	free(options.files);

	if(count > 1) {
		printf("Average single reduction: %.3lf%%\n", 100 * single_red_cum / count);
		printf("Average intra reduction: %.3lf%%\n", 100 * intra_red_cum / count);
		printf("Average inter reduction: %.3lf%%\n", 100 * inter_red_cum / count);
	}

//	end:

	return (0);
}

