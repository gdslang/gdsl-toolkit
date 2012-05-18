CC     = gcc
CFLAGS = -I$(DISTORM3_PATH)/include -g
LIBS = -L$(DISTORM3_PATH) -ldistorm3

all: distorm3-cli

distorm3-cli: distorm3-cli.o
	$(CC) $(LDFLAGS) -o $@ $^ $(LIBS)

distorm3-cli.o: distorm3-cli.c
	$(CC) $(CFLAGS) -c -o $@ $<

clean: FRC
	rm -f distorm3-cli distorm3-cli.o

# This pseudo target causes all targets that depend on FRC
# to be remade even in case a file with the name of the target exists.
# This works with any make implementation under the assumption that
# there is no file FRC in the current directory.
FRC:
