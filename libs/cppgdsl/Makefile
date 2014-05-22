GDSL=../../
CC=gcc
#CC=clang
CPP=clang++
INCDS=-Iinclude -I$(GDSL)/include
CFLAGS=-c -MMD -ggdb3 -std=gnu99 -Wall -Wfatal-errors -DRELAXEDFATAL $(INCDS)
CPPFLAGS=-c -MMD -ggdb3 -std=c++11 -Wall -Wno-overloaded-virtual -Wno-deprecated $(INCDS)

LIBRARY=libcppgdsl.a

SPRE=src
HPRE=include
BPRE=build

CSOURCES=$(shell find $(SPRE)/ -type f -name '*.c')
CPPSOURCES=$(shell find $(SPRE)/ -type f -name '*.cpp')

all: pre-build $(LIBRARY)

SDIRS=$(shell find $(SPRE)/ -type d)
BDIRS=$(SDIRS:$(SPRE)/%=$(BPRE)/%)

pre-build:
	mkdir -p $(BDIRS)

COBJECTS=$(CSOURCES:$(SPRE)/%.c=$(BPRE)/%.o)
CPPOBJECTS=$(CPPSOURCES:$(SPRE)/%.cpp=$(BPRE)/%.o)
OBJECTS=$(COBJECTS) $(CPPOBJECTS)

$(LIBRARY): $(OBJECTS)
	ar rvs $@ $(OBJECTS)

-include ${COBJECTS:.o=.d}
$(COBJECTS): $(BPRE)/%.o : $(SPRE)/%.c
	$(CC) $(CFLAGS) $< -o $@

-include ${CPPOBJECTS:.o=.d}
$(CPPOBJECTS): $(BPRE)/%.o : $(SPRE)/%.cpp
	$(CPP) $(CPPFLAGS) $< -o $@

clean:
	rm -rf $(BDIRS) $(LIBRARY)
