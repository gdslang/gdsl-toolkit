MLTK=.
CC=gcc
MLTON=mlton
CFLAGS=-g3 -fPIC -Wall -Wno-unused-but-set-variable -Iinclude
LFLAGS=-shared

GDSL=gdsl
GPREFIX=
GDSLFLAGS=@MLton fixed-heap 6g --

#GDSL_SOURCES=$(shell find specifications/basis specifications/rreil specifications/x86 -type f -name '*.ml')
GDSL_BASIS_HL=specifications/basis/bbtree.ml specifications/basis/selectors.ml
GDSL_RREIL_EMIT_HL=specifications/rreil/rreil-emit.ml specifications/rreil/rreil-examples.ml specifications/rreil/rreil-cif.ml specifications/rreil/rreil-cleanup.ml specifications/rreil/rreil-pretty.ml specifications/rreil/fmap.ml
GDSL_RREIL_DECL_HL=specifications/rreil/rreil-decl.ml
GDSL_X86_HL=specifications/x86/x86.ml specifications/x86/x86-pretty.ml specifications/x86/x86-pretty-simple.ml
GDSL_X86_TRANS_HL=specifications/x86/x86-rreil-translator.ml specifications/x86/x86-rreil-translator-a-l.ml specifications/x86/x86-rreil-translator-m-z.ml specifications/x86/x86-rreil-registermapping.ml
GDSL_OPT_HL=specifications/rreil/rreil-liveness.ml specifications/x86/x86-liveness.ml

GDSL_ALL_SOURCES=$(GDSL_BASIS_HL) $(GDSL_RREIL_DECL_HL) $(GDSL_RREIL_EMIT_HL) $(GDSL_X86_HL) $(GDSL_X86_TRANS_HL) $(GDSL_OPT_HL)
GDSL_X86_SOURCES=$(GDSL_BASIS_HL) $(GDSL_X86_HL)
GDSL_X86_RREIL_SOURCES=$(GDSL_BASIS_HL) $(GDSL_RREIL_DECL_HL) $(GDSL_X86_HL) $(GDSL_RREIL_EMIT_HL) $(GDSL_X86_TRANS_HL)
GDSL_OPT_SOURCES=$(GDSL_BASIS_HL) $(GDSL_RREIL_DECL_HL) $(GDSL_RREIL_EMIT_HL) $(GDSL_OPT_HL)

GDSL_SOURCES=$(GDSL_ALL_SOURCES)

.PHONY: libs tools

all: $(GDSL) lib$(GDSL).so libs tools

$(GDSL): $(GDSL).mlb $(shell find detail/ -type f -name '*')
	$(MLTON) $<

lib$(GDSL).so: $(GDSL).c
	$(CC) $(CFLAGS) -c $< -o $(<:.c=.o)
	$(CC) $(LFLAGS) -Wl,-soname,lib$(<:.c=.so) -o lib$(<:.c=.so) $(<:.c=.o)

$(GDSL).c: $(GDSL) $(GDSL_SOURCES)
	./$< $(GDSLFLAGS) $(GDSL_SOURCES:%="%")

tools: lib$(GDSL).so libs
	$(MAKE) -C $@/

libs: lib$(GDSL).so
	$(MAKE) -C $@/

clean:
	$(MAKE) -C libs/	clean
	$(MAKE) -C tools/ clean
	rm -f $(GDSL) $(GDSL).o $(GDSL).c $(GDSL).h lib$(GDSL).so
