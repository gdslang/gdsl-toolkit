CC=gcc
#CC=clang
MAKE=make
LIBDS=-L../lib

ifndef MANAGED
GDSL_X86:=1
endif

ifdef GDSL_X86
LIBS+=-lgdrr
endif
LIBS+=-lgdsl -lelf -lrt -lreadhex

LIBFLAGS=$(LIBDS) $(LIBS)
LDFLAGS=
INCDS=-I../include
CFLAGS=-c -g3 -std=gnu99 -Wall -Wfatal-errors -DRELAXEDFATAL $(INCDS)

PROJECTS=
ifdef GDSL_X86
PROJECTS+=x86-test-runner x86-test-stats-runner
endif

EXECUTABLES=cli sweep
ifdef GDSL_X86
EXECUTABLES+=liveness-sweep cli-gdrr
endif

.PHONY: $(PROJECTS) clean-projects

all: $(EXECUTABLES) $(PROJECTS)

### cli
cli: cli.o
	$(CC) $(LDFLAGS) cli.o $(LIBFLAGS) -o $@

cli.o: cli.c
	$(CC) $(CFLAGS) cli.c -o $@

### sweep
sweep: sweep.o
	$(CC) $(LDFLAGS) sweep.o $(LIBFLAGS) -o $@

sweep.o: sweep.c
	$(CC) $(CFLAGS) sweep.c -o $@

ifdef GDSL_X86
### liveness-sweep
liveness-sweep: liveness-sweep.o
	$(CC) $(LDFLAGS) liveness-sweep.o $(LIBFLAGS) -o $@

liveness-sweep.o: liveness-sweep.c
	$(CC) $(CFLAGS) liveness-sweep.c -o $@

### cli-gdrr
cli-gdrr: cli-gdrr.o
	$(CC) $(LDFLAGS) cli-gdrr.o $(LIBFLAGS) -o $@

cli-gdrr.o: cli-gdrr.c
	$(CC) $(CFLAGS) cli-gdrr.c -o $@

### x86-test-runner
x86-test-runner:
	$(MAKE) -C $@

### x86-test-stats-runner
x86-test-stats-runner:
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
