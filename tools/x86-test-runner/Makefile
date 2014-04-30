MLTK=../..
CC=gcc
#CC=clang
LIBDS=-L$(MLTK)/lib
LIBS=-lx86-tester -lgdwrap -lrreil -lrreil-sim -lx86-generator -lx86-generator -lx86 -lreadhex -lgdutil -lgdsl
LIBFLAGS=$(LIBDS) $(LIBS)
LDFLAGS=
INCDS=-Iinclude -I$(MLTK)/include
CFLAGS=-c -g3 -std=c11 -pedantic -Wall -Wfatal-errors -DGDSL_X86 -DRELAXEDFATAL $(INCDS)

EXECUTABLE=x86-test-runner
SOURCES=main.c

all: pre-build $(EXECUTABLE)

SPRE=src
BPRE=build

BDIRS=$(BPRE)
pre-build:
	mkdir -p $(BDIRS)

OBJECTS=$(addprefix $(BPRE)/, $(SOURCES:.c=.o))

$(EXECUTABLE): $(OBJECTS)
	$(CC) $(LDFLAGS) $(OBJECTS) $(LIBFLAGS) -o $@

$(OBJECTS): $(BPRE)/%.o : $(SPRE)/%.c
	$(CC) $(CFLAGS) $< -o $@

clean:
	rm -rf $(BDIRS) $(EXECUTABLE)
