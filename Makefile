MLTK=.
#CC=clang
MLTON=mlton
CFLAGS=-g3 -fPIC
LFLAGS=-shared

GDSL_X86_LIB=libgdsl-x86.so

.PHONY: libs tools

all: gdsl $(GDSL_X86_LIB) libs tools

gdsl: gdsl.mlb $(shell find detail/ -type f -name '*')
	mlton gdsl.mlb

GDSL_X86_SOURCES=$(shell find specifications/basis specifications/rreil specifications/x86 -type f -name '*.ml')

$(GDSL_X86_LIB): gdsl-x86.c
	clang $(CFLAGS) -c gdsl-x86.c -o gdsl-x86.o
	gcc $(LFLAGS) -Wl,-soname,$(GDSL_X86_LIB) -o $(GDSL_X86_LIB) gdsl-x86.o

gdsl-x86.c: gdsl $(GDSL_X86_SOURCES)
	./gdsl @MLton fixed-heap 6g -- $(GDSL_X86_SOURCES:%="%")

tools: $(GDSL_X86_LIB) libs
	make -C tools/

libs: $(GDSL_X86_LIB)
	make -C libs/

clean:
	make -C libs/	clean
	make -C tools/ clean
	rm -f gdsl gdsl-x86.* $(GDSL_X86_LIB)
