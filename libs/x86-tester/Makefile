MLTK=../..
CC=gcc
#CC=clang
INCDS=-Iinclude -I$(MLTK)/include
CFLAGS=-c -g3 -std=gnu11 -pedantic -Wall -Wfatal-errors -DRELAXEDFATAL $(INCDS)

LIBRARY=libx86-tester.a
SOURCES=tbgen.c tbgen_alloc.c executor.c tester.c

all: pre-build $(LIBRARY)

SPRE=src/
BPRE=build/

BDIRS=$(BPRE)
pre-build:
	mkdir -p $(BDIRS)

OBJECTS=$(addprefix $(BPRE), $(SOURCES:.c=.o))

$(LIBRARY): $(OBJECTS)
	ar -r $@ $(OBJECTS)

$(OBJECTS): $(BPRE)%.o : $(SPRE)%.c
	$(CC) $(CFLAGS) $< -o $@

clean:
	rm -rf $(BDIRS) $(LIBRARY)
