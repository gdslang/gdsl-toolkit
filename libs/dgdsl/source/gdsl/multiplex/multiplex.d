module gdsl.multiplex.multiplex;

import core.sys.posix.setjmp;
public import gdsl.multiplex.gdsl_generic;

extern (C):

struct frontend_desc {
  const(char)* name;
  const(char)* ext;
}

struct _generic {
  state_t function () init;
  void function (state_t, ubyte*, ulong, ulong) set_code;
  char function (state_t, int_t) seek;
  jmp_buf* function (state_t) err_tgt;
  string_t function (state_t, obj_t) merge_rope;
  char* function (state_t) get_error_message;
  ulong function (state_t) get_ip_offset;
  void function (state_t) reset_heap;
  void function (state_t) destroy;
};
struct _decoder {
  int_t function (state_t) config_default;
  obj_t function (state_t) decoder_config;
  int_t function (state_t, obj_t) has_conf;
  obj_t function (state_t, obj_t) conf_next;
  string_t function (state_t, obj_t) conf_short;
  string_t function (state_t, obj_t) conf_long;
  int_t function (state_t, obj_t) conf_data;
  obj_t function (state_t, int_t) decode;
  obj_t function (state_t, obj_t) generalize;
  obj_t function (state_t, obj_t) asm_convert_insn;
  obj_t* function (state_t, obj_t) pretty;
 }
struct _translator {
  obj_t function (state_t, obj_t) translate;
  obj_t* function (state_t, obj_t) pretty;
  obj_t* function (state_t, obj_t) pretty_arch_id;
  obj_t* function (state_t, obj_t) pretty_arch_exception;
  obj_t function (state_t, callbacks_t, obj_t) rreil_convert_sem_stmt_list;
  opt_result_t function (state_t, int_t, int_t, int_t, obj_t, 
    obj_t function (state_t, obj_t, obj_t)) decode_translate_block_optimized_insncb;
}

struct frontend {
  _generic generic;
  _decoder decoder;
  _translator translator;
  void *dl;
}

enum MultiplexError {
  none = 0,
  frontendsPathNotSet = 1,
  unableToOpen = 2,
  symbolNotFound = 3
}

size_t gdsl_multiplex_frontends_list (frontend_desc** descs);
size_t gdsl_multiplex_frontends_list_with_base (frontend_desc** descs, const(char)* base);
char gdsl_multiplex_frontend_get_by_desc (frontend* frontend, frontend_desc desc);
char gdsl_multiplex_frontend_get_by_lib_name (frontend* frontend, const(char)* name);
void gdsl_multiplex_descs_free (frontend_desc* descs, size_t descs_length);
void gdsl_multiplex_frontend_close (frontend* frontend);

unittest {
  import std.stdio;
  frontend f;
//  writeln(f.sizeof);
}
