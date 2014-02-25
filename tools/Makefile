# vim: noexpandtab

CC=gcc
#CC=clang
MAKE=make
LIBDS=-L../lib

#ifndef MANAGED
#GDSL_AVR:=1
#GDSL_X86:=1
#endif

DEFINES=-DRELAXEDFATAL
ifdef GDSL_X86
DEFINES+=-DGDSL_X86
endif

ifdef GDSL_X86
endif
LIBS+=-lgdsl -lelf -lrt -lreadhex -lgdsl-multiplex -ldl -lutil

LIBFLAGS=$(LIBDS) $(LIBS)
LDFLAGS=
INCDS=-I../include
CFLAGS=-c -g3 -std=gnu11 -pedantic -Wall -Wfatal-errors -DRELAXEDFATAL $(DEFINES) $(INCDS)

PROJECTS=
EXECUTABLES=semantics-cli decoder-cli semantics-cli-dynamic semantics-cif-cli sweep semantics-opt liveness-sweep
ifdef GDSL_X86
PROJECTS+=x86-test-runner x86-test-stats-runner xed-cmp
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

### liveness-sweep
liveness-sweep: liveness-sweep.o
	$(CC) $(LDFLAGS) liveness-sweep.o $(LIBFLAGS) -o $@

liveness-sweep.o: liveness-sweep.c
	$(CC) $(CFLAGS) liveness-sweep.c -o $@

ifdef GDSL_X86
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
