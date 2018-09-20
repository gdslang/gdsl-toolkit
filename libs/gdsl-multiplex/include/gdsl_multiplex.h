/*
 * This file contains all definitions needed to generically load GDSL
 * front-ends and interface with them. In specific, it contains
 * data structures that store a callback for each exported function of GDSL.
 */

#ifndef GDSL_MULTIPLEX_H_
#define GDSL_MULTIPLEX_H_

#include <setjmp.h>
#include <stdint.h>
#include <stdlib.h>

#include <gdsl_generic.h>

/*
 * This structure contains everything required to
 * identify a front-end.
 */
struct frontend_desc {
  /*
   * The name of the front-end
   */
  const char* name;
  /*
   * The file extension of the front-end library
   */
  const char* ext;
};

/*
 * This structure represents a loaded front-end. It stores
 * a callback for each API function. The structure is broken
 * up into parts that are generic, regard the decoder, or belong
 * to the translator.
 *
 * The frontend also stores a pointer to the loaded shared object.
 * This way, the front-end can be closed after finishing with it.
 *
 * Documentation for the callbacks can be found here:
 * https://github.com/gdslang/gdsl-toolkit/wiki/InterfacingC
 * https://github.com/gdslang/gdsl-toolkit/wiki/DecoderTranslatorAPI
 */
struct frontend {
  struct {
    state_t (*init)();
    void (*set_code)(state_t state, const unsigned char* buffer, size_t size,
                     uint64_t base);
    char (*seek)(state_t state, uint64_t ip);
    jmp_buf* (*err_tgt)(state_t s);
    string_t (*merge_rope)(state_t s, obj_t rope);
    char* (*get_error_message)(state_t s);
    uint64_t (*get_ip)(state_t s);
    void (*reset_heap)(state_t state);
    void (*destroy)(state_t state);
  } generic;

  struct {
    int_t (*config_default)(state_t state);
    obj_t (*decoder_config)(state_t state);
    int_t (*has_conf)(state_t state, obj_t config);
    obj_t (*conf_next)(state_t state, obj_t config);
    string_t (*conf_short)(state_t state, obj_t config);
    string_t (*conf_long)(state_t state, obj_t config);
    int_t (*conf_data)(state_t state, obj_t config);
    obj_t (*decode)(state_t state, int_t config);
    obj_t (*generalize)(state_t state, obj_t insn);
    obj_t (*asm_convert_insn)(state_t s, asm_callbacks_t cbs, asm_insn_t insn);
    obj_t (*pretty)(state_t state, obj_t insn);
  } decoder;

  struct {
    obj_t (*translate)(state_t state, obj_t insn);
    obj_t (*pretty)(state_t state, obj_t rreil);
    obj_t (*pretty_arch_id)(state_t state, obj_t id);
    obj_t (*pretty_arch_exception)(state_t state, obj_t id);
    obj_t (*rreil_convert_sem_stmt_list)(state_t s, callbacks_t cbs,
                                         obj_t stmts);
    obj_t (*optimization_config)(state_t state);
    opt_result_t (*decode_translate_block_optimized)(state_t state,
                                                     int_t config, int_t limit,
                                                     int_t pres);
    obj_t (*traverse_insn_list)(state_t state, obj_t insn_list,
                                obj_t insns_init,
                                obj_t (*insn_cb)(state_t, obj_t, obj_t));
  } translator;

  void* dl;
};

/*
 * The following lines define error codes used by the functions
 * below.
 */
#define GDSL_MULTIPLEX_ERROR_NONE 0
#define GDSL_MULTIPLEX_ERROR_FRONTENDS_PATH_NOT_SET 1
#define GDSL_MULTIPLEX_ERROR_UNABLE_TO_OPEN 2
#define GDSL_MULTIPLEX_ERROR_SYMBOL_NOT_FOUND 3

/*
 * This function lists available front-ends. The number of front-ends
 * is returned while the front-ends descriptors are returned via the
 * first argument.
 *
 * Important: This is a stub only. This function returns a fixed front-end.
 */
extern size_t gdsl_multiplex_frontends_list(struct frontend_desc** descs);

/*
 * This function lists front-ends (see above) given a search path
 * to look them up.
 *
 * Important: This is a stub only. This function returns a fixed front-end.
 */
extern size_t gdsl_multiplex_frontends_list_with_base(
    struct frontend_desc** descs, char const* base);

/*
 * This function opens a front-end and returns whether opening was
 * successful.
 *
 * Important: This is a stub only. This function always returns a front-end
 * where all callbacks point to linked functions. There is no opening
 * going on.
 */
extern int gdsl_multiplex_frontend_get_by_desc(struct frontend* frontend,
                                               struct frontend_desc desc);

/*
 * This function opens a front-end specified by its library name found in
 * the folder pointed to by 'base' and returns whether opening was successful.
 *
 * Important: This is a stub only. This function always returns a front-end
 * where all callbacks point to linked functions. There is no opening
 * going on.
 */
extern int gdsl_multiplex_frontend_get_by_path_name_with_base(
    struct frontend *frontend, char const *base, char const *name);

/*
 * This function opens a front-end specified by its library name and returns
 * whether opening was successful.
 *
 * Important: This is a stub only. This function always returns a front-end
 * where all callbacks point to linked functions. There is no opening
 * going on.
 */
extern int gdsl_multiplex_frontend_get_by_lib_name(struct frontend* frontend,
                                                   char const* name);

/*
 * This function frees all resources associated with a list of
 * front-end descriptors. It must only be used to free memory
 * allocated by one of the list* functions from above.
 */
extern void gdsl_multiplex_descs_free(struct frontend_desc* descs,
                                      size_t descs_length);

/*
 * This function closes a front-end.
 *
 * Important: This is a stub only and does nothing.
 */
extern void gdsl_multiplex_frontend_close(struct frontend* frontend);

#endif /* GDSL_MULTIPLEX_H_ */
