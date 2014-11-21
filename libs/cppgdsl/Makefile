GDSL=../../
CC=gcc
#CC=clang
CPP=clang++
INCDS=-Iinclude -I$(GDSL)/include
CFLAGS=-c -MMD -ggdb3 -std=gnu99 -Wall -Wfatal-errors -DRELAXEDFATAL $(INCDS)
CPPFLAGS=-c -MMD -ggdb3 -std=c++11 -Wall -Wno-overloaded-virtual -Wno-deprecated $(INCDS)
LDFLAGS= -L$(GDSL)/lib -lgdsl-multiplex

LIBRARY_STATIC=libcppgdsl.a
LIBRARY_SHARED=libcppgdsl.so

SPRE=src
HPRE=include
BPRE=build

CSOURCES=$(shell find $(SPRE)/ -type f -name '*.c')
CPPSOURCES=$(shell find $(SPRE)/ -type f -name '*.cpp')

all: pre-build $(LIBRARY_STATIC) $(LIBRARY_SHARED)

SDIRS=$(shell find $(SPRE)/ -type d)
BDIRS=$(SDIRS:$(SPRE)/%=$(BPRE)/%)

pre-build:
	mkdir -p $(BDIRS)

COBJECTS=$(CSOURCES:$(SPRE)/%.c=$(BPRE)/%.o)
CPPOBJECTS=$(CPPSOURCES:$(SPRE)/%.cpp=$(BPRE)/%.o)
OBJECTS=$(COBJECTS) $(CPPOBJECTS)

$(LIBRARY_STATIC): $(OBJECTS)
	ar rvs $@ $(OBJECTS)

-include ${COBJECTS:.o=.d}
$(COBJECTS): $(BPRE)/%.o : $(SPRE)/%.c
	$(CC) $(CFLAGS) $< -o $@

-include ${CPPOBJECTS:.o=.d}
$(CPPOBJECTS): $(BPRE)/%.o : $(SPRE)/%.cpp
	$(CPP) $(CPPFLAGS) $< -o $@

C_PIC_OBJECTS=$(CSOURCES:$(SPRE)/%.c=$(BPRE)/%_pic.o)
CPP_PIC_OBJECTS=$(CPPSOURCES:$(SPRE)/%.cpp=$(BPRE)/%_pic.o)
PIC_OBJECTS=$(C_PIC_OBJECTS) $(CPP_PIC_OBJECTS)

$(LIBRARY_SHARED): $(PIC_OBJECTS)
	$(CPP) -shared -o $@ $(PIC_OBJECTS) $(LDFLAGS)

$(C_PIC_OBJECTS): $(BPRE)/%_pic.o : $(SPRE)/%.c
	$(CC) $(CFLAGS) -fPIC $< -o $@

$(CPP_PIC_OBJECTS): $(BPRE)/%_pic.o : $(SPRE)/%.cpp
	$(CPP) $(CPPFLAGS) -fPIC $< -o $@

clean:
	rm -rf $(BDIRS) $(LIBRARY_STATIC) $(LIBRARY_SHARED)
