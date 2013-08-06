MLTK=../..
CC=gcc
#CC=clang
INCDS=-Iinclude -I$(MLTK)/include
CFLAGS=-c -std=gnu99 -Wall -Wfatal-errors -DRELAXEDFATAL $(INCDS)

LIBRARY=librreil.a
SOURCES=memory.c context.c rreil/free.c rreil/print.c rreil/rreil_id.c rreil/gdrr_builder.c simulator/ops.c simulator/regacc.c simulator/simulator.c simulator/tracking.o

all: pre-build $(LIBRARY)

SPRE=src
BPRE=build

BDIRS=$(BPRE) $(BPRE)/rreil $(BPRE)/simulator
pre-build:
	mkdir -p $(BDIRS)

OBJECTS=$(addprefix $(BPRE)/, $(SOURCES:.c=.o))

$(LIBRARY): $(OBJECTS)
	ar -r  $@  $(OBJECTS)

$(OBJECTS): $(BPRE)/%.o : $(SPRE)/%.c
	$(CC) $(CFLAGS) $< -o $@

clean:
	rm -rf $(BDIRS) $(LIBRARY)
