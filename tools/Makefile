CC=gcc
#CC=clang
LIBDS=-L../lib
LIBS=-lgdrr -lgdsl-x86 -lavcall -lelf -lrt
LIBFLAGS=$(LIBDS) $(LIBS)
LDFLAGS=
INCDS=-I../include
CFLAGS=-c -std=gnu99 -Wall -Wfatal-errors -DRELAXEDFATAL $(INCDS)

EXECUTABLES=cli liveness-sweep sweep cli-gdrr

all: $(EXECUTABLES)

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

clean:
	rm -f $(EXECUTABLES) *.o
