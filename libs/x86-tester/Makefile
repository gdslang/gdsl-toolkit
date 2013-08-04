MLTK=../..
CC=gcc
#CC=clang
INCDS=-Iinclude -I$(MLTK)/include
CFLAGS=-c -std=gnu99 -Wall -Wfatal-errors -DRELAXEDFATAL $(INCDS)

LIBRARY=libx86-tester.a
SOURCES=tbgen.c tbgen_alloc.c executor.c tester.c

all: pre-build $(LIBRARY)

BDIRS=build
pre-build:
	mkdir -p $(BDIRS)

OBJECTS=$(SOURCES:.c=.o)

$(LIBRARY): $(OBJECTS)
	ar -r  $@  $(addprefix build/, $(OBJECTS))

$(OBJECTS): src/$(@:.o=.c)
	$(CC) $(CFLAGS) src/$(@:.o=.c) -o build/$@

clean:
	rm -rf $(BDIRS) $(LIBRARY)
