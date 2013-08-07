MLTK=../../..
CC=gcc
#CC=clang
LIBDS=-L$(MLTK)/lib
LIBS=
LIBFLAGS=$(LIBDS) $(LIBS)
LDFLAGS=
INCDS=-Iinclude -I$(MLTK)/include
CFLAGS=-c -O0 -g3 -std=gnu99 -Wall -Wfatal-errors -DRELAXEDFATAL $(INCDS)

SPRE=.
BPRE=build

SOURCES=$(shell find $(SPRE)/ -type f -name '*.c')
EXECUTABLES=$(notdir $(SOURCES:.c=))

all: pre-build $(EXECUTABLES)

BDIRS=$(BPRE)
pre-build:
	mkdir -p $(BDIRS)

OBJECTS=$(SOURCES:$(SPRE)/%.c=$(BPRE)/%.o)

$(EXECUTABLES): % : $(BPRE)/%.o
	$(CC) $(LDFLAGS) $(OBJECTS) $(LIBFLAGS) -o $@

$(OBJECTS): $(BPRE)/%.o : $(SPRE)/%.c
	$(CC) $(CFLAGS) $< -o $@

clean:
	rm -rf $(BDIRS) $(EXECUTABLES)
