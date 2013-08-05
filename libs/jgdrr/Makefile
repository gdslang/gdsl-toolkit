MLTK=../..
CC=gcc
#CC=clang
LIBDS=-L$(MLTK)/lib
LIBS=-lgdrr -lgdsl-x86 -lavcall
LIBFLAGS=$(LIBDS) $(LIBS)
INCDS=-Iinclude -I$(MLTK)/include -I/usr/lib/jvm/java-7-openjdk-amd64/include
CFLAGS=-std=gnu99 -fPIC -shared -Wall -Wfatal-errors -DRELAXEDFATAL $(INCDS)

LIBRARY=libjgdrr.so
JAR=jgdrr.jar

all: pre-build $(LIBRARY) $(JAR)

SPRE=src
BPRE=build

BDIRS=$(BPRE)
pre-build:
	mkdir -p $(BDIRS)

$(LIBRARY): src/rnati_NativeInterface.c
	$(CC) $(CFLAGS) -Wl,-soname,$(LIBRARY) $< $(LIBFLAGS) -o $@

JSOURCES=$(shell find src/ -type f -name '*.java')
#JSOURCES=$(wildcard src/**/*.java)

$(JAR): $(JSOURCES)
	javac $(JSOURCES) -d $(BPRE)/
	jar -cf $@ $(JSOURCES:$(SPRE)/%.java=-C $(BPRE) %.class)

clean:
	rm -rf $(BDIRS)/ $(LIBRARY) $(JAR)
