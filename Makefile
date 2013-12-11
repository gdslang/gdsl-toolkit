all: _pygdsl.so

GDSL_INCLUDES=-I ../
PY_INCLUDES=-I/usr/include/python2.7
GDSL_LIBDIR=/usr/local/lib

semantics-str.o: semantics-str.c
	gcc -DHAVE_CONFIG_H -DGDSL_X86 -fPIC $(GDSL_INCLUDES) -std=gnu99 -g -O2 -c -o semantics-str.o ./semantics-str.c
pygdsl_wrap.c: pygdsl.i
	swig -python pygdsl.i #also generates pygdsl.py
pygdsl_wrap.o: pygdsl_wrap.c
	gcc -fPIC -c pygdsl_wrap.c $(PY_INCLUDES)
_pygdsl.so: pygdsl_wrap.o semantics-str.o
	gcc -shared pygdsl_wrap.o semantics-str.o -o _pygdsl.so -L$(GDSL_LIBDIR) -lgdsl-x86-rreil
clean:
	rm -f *.o *.pyc pygdsl.py _pygdsl.so pygdsl_wrap.c 