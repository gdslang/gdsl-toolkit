MLTK=../..
CC=gcc
#CC=clang
INCDS=-Iinclude -I$(MLTK)/include
CFLAGS=-c -fPIC -g3 -std=gnu99 -Wall -Wfatal-errors -DRELAXEDFATAL $(INCDS)

LIBRARY_STATIC=libgdsl-multiplex.a
LIBRARY_SHARED=libgdsl-multiplex.so
SOURCES=gdsl_multiplex.c

all: pre-build $(LIBRARY_STATIC) $(LIBRARY_SHARED)

SPRE=src
BPRE=build

BDIRS=$(BPRE)
pre-build:
	mkdir -p $(BDIRS)

OBJECTS=$(addprefix $(BPRE)/, $(SOURCES:.c=.o))

$(LIBRARY_STATIC): $(OBJECTS)
	ar -r  $@  $(OBJECTS)

$(OBJECTS): $(BPRE)/%.o : $(SPRE)/%.c
	$(CC) $(CFLAGS) $< -o $@

$(LIBRARY_SHARED): $(OBJECTS)
	$(CC) -shared -o $@ $(OBJECTS)

clean:
	rm -rf $(BDIRS) $(LIBRARY_STATIC) $(LIBRARY_SHARED)
