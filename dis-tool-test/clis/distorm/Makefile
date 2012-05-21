CC     = gcc
CFLAGS = -I$(DISTORM_PATH)/include -g
LIBS = -L$(DISTORM_PATH) -ldistorm3

all: distorm-cli

distorm-cli: distorm-cli.o
	$(CC) $(LDFLAGS) -o $@ $^ $(LIBS)

distorm-cli.o: distorm-cli.c
	$(CC) $(CFLAGS) -c -o $@ $<

clean: FRC
	rm -f distorm-cli distorm-cli.o

# This pseudo target causes all targets that depend on FRC
# to be remade even in case a file with the name of the target exists.
# This works with any make implementation under the assumption that
# there is no file FRC in the current directory.
FRC:
