MLTK=.
CC=gcc
MLTON=mlton
CFLAGS=-g3 -fPIC
LFLAGS=-shared

GDSL=gdsl
GDSLFLAGS=@MLton fixed-heap 6g --
GDSL_X86=gdsl-x86

.PHONY: libs tools

all: $(GDSL) lib$(GDSL_X86).so libs tools

$(GDSL): gdsl.mlb $(shell find detail/ -type f -name '*')
	$(MLTON) $<

GDSL_X86_SOURCES=$(shell find specifications/basis specifications/rreil specifications/x86 -type f -name '*.ml')

lib$(GDSL_X86).so: $(GDSL_X86).c
	$(CC) $(CFLAGS) -c $< -o $(<:.c=.o)
	$(CC) $(LFLAGS) -Wl,-soname,lib$(<:.c=.so) -o lib$(<:.c=.so) $(<:.c=.o)

$(GDSL_X86).c: $(GDSL) $(GDSL_X86_SOURCES)
	./$< $(GDSLFLAGS) $(GDSL_X86_SOURCES:%="%")

tools: lib$(GDSL_X86).so libs
	$(MAKE) -C $@/

libs: lib$(GDSL_X86).so
	$(MAKE) -C $@/

clean:
	$(MAKE) -C libs/	clean
	$(MAKE) -C tools/ clean
	rm -f gdsl gdsl-x86.* lib$(GDSL_X86).so
