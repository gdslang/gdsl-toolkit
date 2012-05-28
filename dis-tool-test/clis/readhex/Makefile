CC     = g++
AR     = ar
CFLAGS = -I./include -g

all: readhex.a

readhex.a: readhex.o
	$(AR) -r $@ $^

readhex.o: readhex.c
	$(CC) $(CFLAGS) -c -o $@ $<

clean: FRC
	rm -f readhex.a readhex.o

# This pseudo target causes all targets that depend on FRC
# to be remade even in case a file with the name of the target exists.
# This works with any make implementation under the assumption that
# there is no file FRC in the current directory.
FRC:
