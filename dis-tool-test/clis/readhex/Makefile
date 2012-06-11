CC     = gcc
AR     = ar
CFLAGS = -I./include -g

all: libreadhex.a

libreadhex.a: readhex.o
	$(AR) -r $@ $^

readhex.o: readhex.c
	$(CC) $(CFLAGS) -c -o $@ $<

clean: FRC
	rm -f libreadhex.a readhex.o

# This pseudo target causes all targets that depend on FRC
# to be remade even in case a file with the name of the target exists.
# This works with any make implementation under the assumption that
# there is no file FRC in the current directory.
FRC:
