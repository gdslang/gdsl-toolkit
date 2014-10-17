MLTK=../..
JDK=/usr/lib/jvm/java-7-openjdk
CC=gcc
#CC=clang
LIBDS=-L$(MLTK)/lib
LIBS=-lgdsl-multiplex
LIBFLAGS=$(LIBDS) $(LIBS)
INCDS=-Iinclude -I$(MLTK)/include -I$(JDK)/include -I$(JDK)/include/linux

DEFINES=-DRELAXEDFATAL

CFLAGS=-std=c11 -g3 -fPIC -shared -pedantic -Wall -Wfatal-errors $(DEFINES) $(INCDS)

LIBRARY=libjgdsl.so
JAR_SRC=jgdsl-src.jar
JAR=jgdsl.jar

C_SOURCES=src/gdsl_rreil_BuilderBackend.c src/gdsl_Gdsl.c src/gdsl_decoder_NativeInstruction.c src/gdsl_Frontend.c src/gdsl_BareFrontend.c src/gdsl_ListFrontend.c src/util.c src/gdsl_asm_GeneralizerBackend.c

all: pre-build $(LIBRARY) $(JAR_SRC) $(JAR)

SPRE=src
BPRE=build

BDIRS=$(BPRE)
pre-build:
	mkdir -p $(BDIRS)

$(LIBRARY): $(C_SOURCES)
	$(CC) $(CFLAGS) $(C_SOURCES) $(LIBFLAGS) -o $@
#	$(CC) $(CFLAGS) -Wl,-soname,$(LIBRARY) $< $(LIBFLAGS) -o $@

JSOURCES=$(shell find src/ -type f -name '*.java')
#JSOURCES=$(wildcard src/**/*.java)

$(JAR_SRC): $(JSOURCES)
	jar -cf $@ $(JSOURCES:$(SPRE)/%.java=-C $(SPRE) %.java)

$(JAR): $(JSOURCES)
	javac -cp /usr/share/java/junit.jar:. $(JSOURCES) -d $(BPRE)/
	jar -cf $@ $(JSOURCES:$(SPRE)/%.java=-C $(BPRE) %.class)

clean:
	rm -rf $(BDIRS)/ $(LIBRARY) $(JAR)
