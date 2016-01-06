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
LIBS_MULT +=-lrt -lcgdsl -lreadhex -lgdsl-multiplex -ldl -lgdutil -lelf

LIBFLAGS=$(LIBDS) $(LIBS)
LIB_MULTFLAGS=$(LIBDS) $(LIBS_MULT)
LDFLAGS=
INCDS=-I../include
CFLAGS=-c -g3 -std=gnu11 -pedantic -Wall -Wfatal-errors -DRELAXEDFATAL $(DEFINES) $(INCDS)
CPPFLAGS=-c -std=c++11 -ggdb3 $(DEFINES) $(INCDS)

PROJECTS=
EXECUTABLES=semantics-cli decoder-cli semantics-cli-dynamic semantics-cif-cli sweep semantics-opt optimization-sweep cppgdsl-demo
ifeq ($(GDSL_ARCH),x86)
EXECUTABLES+=cgdsl-demo
endif

.PHONY: $(PROJECTS) clean-projects

all: $(EXECUTABLES) $(PROJECTS)

### decoder-cli
decoder-cli: decoder-cli.o
	$(CC) $(LDFLAGS) decoder-cli.o $(LIBFLAGS) -o $@

decoder-cli.o: decoder-cli.c
	$(CC) $(CFLAGS) decoder-cli.c -o $@

### semantics-cli
semantics-cli: semantics-cli.o
	$(CC) $(LDFLAGS) semantics-cli.o $(LIBFLAGS) -o $@

semantics-cli.o: semantics-cli.c
	$(CC) $(CFLAGS) semantics-cli.c -o $@
	
### semantics-cli-dynamic
semantics-cli-dynamic: semantics-cli-dynamic.o
	$(CC) $(LDFLAGS) semantics-cli-dynamic.o $(LIBFLAGS) -o $@

semantics-cli-dynamic.o: semantics-cli-dynamic.c
	$(CC) $(CFLAGS) semantics-cli-dynamic.c -o $@
	
### semantics-cif-cli
semantics-cif-cli: semantics-cif-cli.o
	$(CC) $(LDFLAGS) semantics-cif-cli.o $(LIBFLAGS) -o $@

semantics-cif-cli.o: semantics-cif-cli.c
	$(CC) $(CFLAGS) semantics-cif-cli.c -o $@
	
### cppgdsl-demo

cppgdsl-demo: cppgdsl-demo.o
	$(CPPC) $(LDFLAGS) cppgdsl-demo.o -lcppgdsl $(LIB_MULTFLAGS) -o $@

cppgdsl-demo.o: cppgdsl-demo.cpp
	$(CPPC) $(CPPFLAGS) cppgdsl-demo.cpp -o $@

### sweep
sweep: sweep.o
	$(CC) $(LDFLAGS) sweep.o $(LIBFLAGS) -o $@

sweep.o: sweep.c
	$(CC) $(CFLAGS) sweep.c -o $@
	
### semantics-opt
semantics-opt: semantics-opt.o
	$(CC) $(LDFLAGS) semantics-opt.o $(LIBFLAGS) -o $@

semantics-opt.o: semantics-opt.c
	$(CC) $(CFLAGS) semantics-opt.c -o $@

### optimization-sweep
optimization-sweep: optimization-sweep.o
	$(CC) $(LDFLAGS) optimization-sweep.o $(LIBFLAGS) -o $@

optimization-sweep.o: optimization-sweep.c
	$(CC) $(CFLAGS) optimization-sweep.c -o $@

ifeq ($(GDSL_ARCH),x86)
### cgdsl-demo
cgdsl-demo: cgdsl-demo.o
	$(CC) $(LDFLAGS) cgdsl-demo.o $(LIB_MULTFLAGS) -lx86 -o $@

cgdsl-demo.o: cgdsl-demo.c
	$(CC) $(CFLAGS) cgdsl-demo.c -o $@

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
