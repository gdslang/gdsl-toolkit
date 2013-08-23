MLTK=../..
CC=gcc
#CC=clang
INCDS=-Iinclude -I$(MLTK)/include

DEFINES=-DRELAXEDFATAL
ifdef GDSL_X86
DEFINES+=-DGDSL_X86
endif

CFLAGS=-c -g3 -fPIC -std=gnu99 -Wall -Wfatal-errors $(DEFINES) $(INCDS)

LIBRARIES=libgdrr.a

all: $(LIBRARIES)

OBJECTS=gdrr.o

libgdrr.a: $(OBJECTS)
	ar -r  $@  $(OBJECTS)

gdrr.o: src/gdrr.c
	$(CC) $(CFLAGS) src/gdrr.c -o $@

clean:
	rm -f $(LIBRARIES) $(OBJECTS)
