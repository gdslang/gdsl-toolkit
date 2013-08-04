MLTK=../..
CC=gcc
#CC=clang
INCDS=-Iinclude -I$(MLTK)/include
CFLAGS=-c -std=gnu99 -Wall -Wfatal-errors -DRELAXEDFATAL $(INCDS)

LIBRARIES=librreil.a

all: pre-build $(LIBRARIES)

BDIRS=build build/rreil build/simulator
pre-build:
	mkdir -p $(BDIRS)

OBJECTS=memory.o context.o rreil/free.o rreil/print.o rreil/rreil_id.o rreil/gdrr_builder.o simulator/tools.o simulator/ops.o simulator/regacc.o simulator/simulator.o simulator/tracking.o

librreil.a: $(OBJECTS)
	ar -r  $@  $(addprefix build/, $(OBJECTS))

$(OBJECTS): src/$(@:.o=.c)
	$(CC) $(CFLAGS) src/$(@:.o=.c) -o build/$@

clean:
	rm -rf $(BDIRS) $(LIBRARIES)
