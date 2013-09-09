MLTK=../..
CC=gcc
#CC=clang
LIBDS=-L$(MLTK)/lib -L$(XED)/lib
LIBS=-lgdsl -lbfd -lxed
LIBFLAGS=$(LIBDS) $(LIBS)
LDFLAGS=
INCDS=-Iinclude -I$(MLTK)/include -I$(XED)/include
CFLAGS=-c -g3 -std=gnu11 -pedantic -Wall -Wfatal-errors -DGDSL_X86 -DRELAXEDFATAL $(INCDS)

EXECUTABLE=xed-cmp
SOURCES=xed-cmp.c

ifdef XED
all: pre-build $(EXECUTABLE)
else
all:
	$(info No XED => Skipping build of $(EXECUTABLE)...)
endif

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
