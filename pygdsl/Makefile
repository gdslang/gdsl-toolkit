# vim: noexpandtab

all: _pygdsl.so

prepare:
	ln -f -s ../build/gdsl-x86-rreil.h ../build/gdsl.h

_pygdsl.so: pygdsl_impl.c pygdsl_error.h pygdsl_funcs.h pygdsl.i
	python setup.py build_ext --inplace
test: _pygdsl.so
	export PYTHONPATH=.
	python tests/single_instrs.py
	python tests/multiple_instrs.py
install: _pygdsl.so
	python setup.py install
clean:
	rm -rf *.o *.pyc pygdsl.py _pygdsl.so pygdsl_wrap.c build
