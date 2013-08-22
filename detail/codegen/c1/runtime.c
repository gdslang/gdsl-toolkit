/* vim:ts=2:sw=2:expandtab */
@I-am-a-template-so-edit-me@

@include-prefix@

@records@

@prototypes@

#ifdef WITHMAIN

#define BUF_SIZE 8*1024*1024
static char blob[BUF_SIZE];

int main (int argc, char** argv) {
  uint64_t buf_size = BUF_SIZE;
  unsigned int i,c;
  for (i=0;i<buf_size;i++) {
     int x = fscanf(stdin,"%x",&c);
     switch (x) {
        case EOF:
           goto done;
        case 0: {
           printf("invalid input; should be in hex form: '0f 0b ..'");
           return 1;
        }
     }
     blob[i] = c & 0xff;
  }
done:
  buf_size = i;
  state_t s = gdsl_init();
  gdsl_set_code(s, blob, buf_size, 0);
  
  if (setjmp(*gdsl_err_tgt(s))==0) {
    while (gdsl_get_ip_offset(s)<buf_size) {
      uint64_t ofs = gdsl_get_ip_offset(s);
      obj_t rreil = x86_translateBlock(s);
      string_t res = x86_rreil_pretty(s,rreil);
      printf("%lx:\n%s\n", (long unsigned int) ofs, res);
      gdsl_reset_heap(s);    
    }
  } else {
    printf("exception: %s\n", gdsl_get_error_message(s));
  }
  gdsl_destroy(s);
  return 0; 
}

#endif

@functions@

