MLTK=../..
CC=gcc
#CC=clang
INCDS=-Iinclude -I$(MLTK)/include
CFLAGS=-c -g3 -std=c11 -pedantic -Wall -Wfatal-errors -DRELAXEDFATAL $(INCDS)

LIBRARIES=libx86.a

all: $(LIBRARIES)

OBJECTS=x86.o x86_features.o

libx86.a: $(OBJECTS)
	ar -r  $@  $(OBJECTS)

$(OBJECTS): %.o : src/%.c
	$(CC) $(CFLAGS) src/$(@:.o=.c) -o $@

clean:
	rm -f $(LIBRARIES) $(OBJECTS)
