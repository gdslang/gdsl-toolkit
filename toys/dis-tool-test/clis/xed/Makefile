CC     = g++
CFLAGS = -I$(XED_PATH)/include -I../readhex/include -g

LDFLAGS = -L$(XED_PATH)/lib -L../readhex
LIBS = -lxed -lreadhex

all: xed-cli

xed-cli: xed-cli.o
	$(CC) $(LDFLAGS) -o $@ $^ $(LIBS) 

xed-cli.o: xed-cli.cpp
	$(CC) $(CFLAGS) -c -o $@ $<

clean: FRC
	rm -f xed-cli xed-cli.o

# This pseudo target causes all targets that depend on FRC
# to be remade even in case a file with the name of the target exists.
# This works with any make implementation under the assumption that
# there is no file FRC in the current directory.
FRC:
