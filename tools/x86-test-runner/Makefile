MLTK=../..
CC=gcc
#CC=clang
LIBDS=-L$(MLTK)/lib
LIBS=-lx86-tester -lgdrr -lgdsl -lrreil -lx86-generator -lx86-generator -lutil -lx86 -lgdsl-x86 -lavcall
LIBFLAGS=$(LIBDS) $(LIBS)
LDFLAGS=
INCDS=-Iinclude -I$(MLTK)/include
CFLAGS=-c -std=gnu99 -Wall -Wfatal-errors -DRELAXEDFATAL $(INCDS)

EXECUTABLE=x86-test-runner
SOURCES=main.c

all: pre-build $(EXECUTABLE)

BDIRS=build
pre-build:
	mkdir -p $(BDIRS)

OBJECTS=$(SOURCES:.c=.o)

$(EXECUTABLE): $(OBJECTS)
	$(CC) $(LDFLAGS) $(addprefix build/, $(OBJECTS)) $(LIBFLAGS) -o $@

$(OBJECTS): src/$(@:.o=.c)
	$(CC) $(CFLAGS) src/$(@:.o=.c) -o build/$@

clean:
	rm -rf $(BDIRS) $(EXECUTABLE)
