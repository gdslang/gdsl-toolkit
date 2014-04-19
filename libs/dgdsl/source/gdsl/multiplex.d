module gdsl.multiplex;

import core.sys.posix.setjmp;
import gdsl.generated;

extern (C):

struct frontend_desc {
  const(char)* name;
  const(char)* ext;
}

struct _generic {
  struct {
    int x = 20;
  } blah;
  
  state_t function () init;
  void function (state_t, char*, ulong, ulong) set_code;
  jmp_buf* function (state_t) err_tgt;
  string_t function (state_t, obj_t) merge_rope;
  char* function (state_t) get_error_message;
  ulong function (state_t) get_ip_offset;
  void function (state_t) reset_heap;
  void function (state_t) destroy;
};
struct _decoder {
  int_t function (state_t) config_default;
  obj_t function (state_t, int_t) decode;
  int_t function (state_t, obj_t) operands;
  obj_t* function (state_t, obj_t) pretty;
  obj_t* function (state_t, obj_t, int_t) pretty_operand;
  obj_t* function (state_t, obj_t) pretty_mnemonic;
  int_t function (state_t, obj_t, int) typeof_opnd;
 }
struct _translator {
  obj_t function (state_t, obj_t) translate;
  obj_t* function (state_t, obj_t) pretty;
  void function (state_t, obj_t) rreil_cif_userdata_set;
  obj_t function (state_t) rreil_cif_userdata_get;
  obj_t function (state_t, callbacks_t, obj_t) rreil_convert_sem_stmts;
  obj_t function (state_t, int_t, int_t, int_t, obj_t, obj_t function (state_t, obj_t, obj_t)) decode_translate_block_optimized_int;
}

struct frontend {
  _generic generic;
  _decoder decoder;
  _translator translator;
  void *dl;
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
  writeln(f.sizeof);
  f.generic.blah.x = 99;
}