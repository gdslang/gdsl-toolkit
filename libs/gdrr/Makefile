MLTK=../..
CC=gcc
#CC=clang
INCDS=-Iinclude -I$(MLTK)/include
CFLAGS=-c -fPIC -std=gnu99 -Wall -Wfatal-errors -DRELAXEDFATAL $(INCDS)

LIBRARIES=libgdrr.a

all: $(LIBRARIES)

OBJECTS=x86.o gdrr.o

libgdrr.a: $(OBJECTS)
	ar -r  $@  $(OBJECTS)

x86.o: src/x86.c
	$(CC) $(CFLAGS) src/x86.c -o $@

gdrr.o: src/gdrr.c
	$(CC) $(CFLAGS) src/gdrr.c -o $@

clean:
	rm -f $(LIBRARIES) $(OBJECTS)
