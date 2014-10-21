# vim: noexpandtab

CC=gcc
CPPC=clang++
#CC=clang
MAKE=make
LIBDS=-L../lib

#ifndef MANAGED
#GDSL_AVR:=1
#GDSL_X86:=1
#endif

#$(info $(MANAGED))

DEFINES=-DRELAXEDFATAL
ifdef GDSL_ARCH
UPPER_ARCH = $(shell echo $(GDSL_ARCH) | tr a-z A-Z)
DEFINES+=-DGDSL_$(UPPER_ARCH)
endif

LIBS +=-lgdsl -lrt -lreadhex -lgdsl-multiplex -ldl -lgdutil -lelf
LIBS_MULT +=-lrt -lreadhex -lgdsl-multiplex -ldl -lgdutil -lelf

LIBFLAGS=$(LIBDS) $(LIBS)
LIB_MULTFLAGS=$(LIBDS) $(LIBS_MULT)
LDFLAGS=
INCDS=-I../include
CFLAGS=-c -g3 -std=gnu11 -pedantic -Wall -Wfatal-errors -DRELAXEDFATAL $(DEFINES) $(INCDS)
CPPFLAGS=-c -std=c++11 -ggdb3 $(DEFINES) $(INCDS)

PROJECTS=
EXECUTABLES=mipseval-cli

.PHONY: $(PROJECTS) clean-projects

all: $(EXECUTABLES) $(PROJECTS)

### mipseval-cli
mipseval-cli: mipseval-cli.o
	$(CC) $(LDFLAGS) mipseval-cli.o $(LIBFLAGS) -o $@

mipseval-cli.o: mipseval-cli.c
	$(CC) $(CFLAGS) mipseval-cli.c -o $@

ifeq ($(GDSL_ARCH),x86)
### x86-test-runner
x86-test-runner:
	$(MAKE) -C $@

### x86-test-stats-runner
x86-test-stats-runner:
	$(MAKE) -C $@
	
### xed-cmp
xed-cmp:
	$(MAKE) -C $@
endif

### tardet
#tardet:
#	$(MAKE) -C $@

clean: clean-projects
	rm -f $(EXECUTABLES) *.o

clean-projects: $(PROJECTS:=-clean)

$(PROJECTS:=-clean):
	$(MAKE) -C $(@:-clean=) clean
