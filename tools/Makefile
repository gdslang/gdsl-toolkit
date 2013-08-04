CC=gcc
#CC=clang
MAKE=make
LIBDS=-L../lib
LIBS=-lgdrr -lgdsl-x86 -lavcall -lelf -lrt
LIBFLAGS=$(LIBDS) $(LIBS)
LDFLAGS=
INCDS=-I../include
CFLAGS=-c -std=gnu99 -Wall -Wfatal-errors -DRELAXEDFATAL $(INCDS)

PROJECTS=x86-test-runner
EXECUTABLES=cli liveness-sweep sweep cli-gdrr

.PHONY: x86-test-runner clean-projects

all: $(EXECUTABLES) $(PROJECTS)

### cli
cli: cli.o
	$(CC) $(LDFLAGS) cli.o $(LIBFLAGS) -o $@

cli.o: cli.c
	$(CC) $(CFLAGS) cli.c -o $@

### liveness-sweep
liveness-sweep: liveness-sweep.o
	$(CC) $(LDFLAGS) liveness-sweep.o $(LIBFLAGS) -o $@

liveness-sweep.o: liveness-sweep.c
	$(CC) $(CFLAGS) liveness-sweep.c -o $@

### sweep
sweep: sweep.o
	$(CC) $(LDFLAGS) sweep.o $(LIBFLAGS) -o $@

sweep.o: sweep.c
	$(CC) $(CFLAGS) sweep.c -o $@

### cli-gdrr
cli-gdrr: cli-gdrr.o
	$(CC) $(LDFLAGS) cli-gdrr.o $(LIBFLAGS) -o $@

cli-gdrr.o: cli-gdrr.c
	$(CC) $(CFLAGS) cli-gdrr.c -o $@

### x86-test-runner
x86-test-runner:
	$(MAKE) -C $@

clean: clean-projects
	rm -f $(EXECUTABLES) *.o

clean-projects: $(PROJECTS:=-clean)

$(PROJECTS:=-clean):
	$(MAKE) -C $(@:-clean=) clean
