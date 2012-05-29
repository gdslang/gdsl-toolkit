CC     = gcc
CFLAGS = -I$(OPDIS_PATH) -I../readhex/include -g

LDFLAGS = -L../readhex -L$(OPDIS_PATH)/dist/.libs
LIBS = -lopcodes -lopdis -lreadhex

all: opdis-cli

opdis-cli: opdis-cli.o
	$(CC) $(LDFLAGS) -o $@ $^ $(LIBS) 

opdis-cli.o: opdis-cli.c
	$(CC) $(CFLAGS) -c -o $@ $<

clean: FRC
	rm -f opdis-cli opdis-cli.o

# This pseudo target causes all targets that depend on FRC
# to be remade even in case a file with the name of the target exists.
# This works with any make implementation under the assumption that
# there is no file FRC in the current directory.
FRC:
