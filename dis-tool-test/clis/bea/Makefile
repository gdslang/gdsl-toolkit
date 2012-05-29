CC     = gcc
CFLAGS = -I$(BEA_PATH)/include -I../readhex/include -g

LDFLAGS = -L$(BEA_PATH)/lib/Linux.gnu.Debug -L../readhex
LIBS = -lBeaEngine_s_d -lreadhex

all: bea-cli

bea-cli: bea-cli.o
	$(CC) $(LDFLAGS) -o $@ $^ $(LIBS) 

bea-cli.o: bea-cli.c
	$(CC) $(CFLAGS) -c -o $@ $<

clean: FRC
	rm -f bea-cli bea-cli.o

# This pseudo target causes all targets that depend on FRC
# to be remade even in case a file with the name of the target exists.
# This works with any make implementation under the assumption that
# there is no file FRC in the current directory.
FRC:
