MLTK=.
#CC=clang
MLTON=mlton
CFLAGS=-g3 -fPIC
LFLAGS=-shared

.PHONY: libs tools

all: gdsl libgdsl-x86.so libs tools

gdsl: gdsl.mlb $(shell find detail/ -type f -name '*.sml')
	mlton gdsl.mlb

GDSL_X86_SOURCES=$(shell find specifications/basis specifications/rreil specifications/x86 -type f -name '*.ml')

libgdsl-x86.so: gdsl-x86.c
	clang $(CFLAGS) -c gdsl-x86.c -o gdsl-x86.o
	gcc $(LFLAGS) -Wl,-soname,libgdsl-x86.so -o libgdsl-x86.so gdsl-x86.o

gdsl-x86.c: $(GDSL_X86_SOURCES)
	./gdsl @MLton fixed-heap 6g -- $(GDSL_X86_SOURCES:%="%")

tools: libs
	make -C tools/

libs:
	make -C libs/

clean:
	make -C libs/	clean
	make -C tools/ clean
	rm -f gdsl gdsl-x86.* libgdsl-x86.so
