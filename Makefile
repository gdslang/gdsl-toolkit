MLTK=.
CC=gcc
MLTON=mlton
CFLAGS=-g3 -fPIC
LFLAGS=-shared

GDSL=gdsl
GDSLFLAGS=@MLton fixed-heap 6g --
GDSL_NAME=gdsl-x86

.PHONY: libs tools

all: $(GDSL) lib$(GDSL_NAME).so libs tools

$(GDSL): $(GDSL).mlb $(shell find detail/ -type f -name '*')
	$(MLTON) $<

GDSL_NAME_SOURCES=$(shell find specifications/basis specifications/rreil specifications/x86 -type f -name '*.ml')

lib$(GDSL_NAME).so: $(GDSL_NAME).c
	$(CC) $(CFLAGS) -c $< -o $(<:.c=.o)
	$(CC) $(LFLAGS) -Wl,-soname,lib$(<:.c=.so) -o lib$(<:.c=.so) $(<:.c=.o)

$(GDSL_NAME).c: $(GDSL) $(GDSL_NAME_SOURCES)
	./$< $(GDSLFLAGS) $(GDSL_NAME_SOURCES:%="%")

tools: lib$(GDSL_NAME).so libs
	$(MAKE) -C $@/

libs: lib$(GDSL_NAME).so
	$(MAKE) -C $@/

clean:
	$(MAKE) -C libs/	clean
	$(MAKE) -C tools/ clean
	rm -f $(GDSL) $(GDSL_NAME).* lib$(GDSL_NAME).so
