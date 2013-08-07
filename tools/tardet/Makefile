MLTK=../..
CC=gcc
CPP=g++
#CC=clang
LIBDS=-L$(MLTK)/lib
LIBS=-lrreil -lx86 -lgdsl -lgdrr -lreadhex -lutil -lgdsl-x86 -lavcall
LIBFLAGS=$(LIBDS) $(LIBS)
LDFLAGS=
INCDS=-Iinclude -I$(MLTK)/include
CFLAGS=-c -g3 -std=gnu99 -Wall -Wfatal-errors -DRELAXEDFATAL $(INCDS)
CPPFLAGS=-c -g3 -std=gnu++11 $(INCDS)

EXECUTABLE=tardet

SPRE=src
BPRE=build

CSOURCES=$(shell find $(SPRE)/ -type f -name '*.c')
CPPSOURCES=$(shell find $(SPRE)/ -type f -name '*.cpp')

all: pre-build $(EXECUTABLE)

SDIRS=$(shell find $(SPRE)/ -type d)
BDIRS=$(SDIRS:$(SPRE)/%=$(BPRE)/%)

pre-build:
	mkdir -p $(BDIRS)

COBJECTS=$(CSOURCES:$(SPRE)/%.c=$(BPRE)/%.o)
CPPOBJECTS=$(CPPSOURCES:$(SPRE)/%.cpp=$(BPRE)/%.o)
OBJECTS=$(COBJECTS) $(CPPOBJECTS)

$(EXECUTABLE): $(OBJECTS)
	$(CPP) $(LDFLAGS) $(OBJECTS) $(LIBFLAGS) -o $@

$(COBJECTS): $(BPRE)/%.o : $(SPRE)/%.c
	$(CC) $(CFLAGS) $< -o $@

$(CPPOBJECTS): $(BPRE)/%.o : $(SPRE)/%.cpp
	$(CPP) $(CPPFLAGS) $< -o $@

clean:
	rm -rf $(BDIRS) $(EXECUTABLE)
