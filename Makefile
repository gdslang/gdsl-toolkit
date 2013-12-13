all: _pygdsl.so

SOURCES=$(wildcard *.i *.c *.h)

_pygdsl.so: $(SOURCES)
	echo $(SOURCES)
	python setup.py build_ext --inplace
test: _pygdsl.so
	export PYTHONPATH=.
	python tests/single_instrs.py
clean:
	rm -rf *.o *.pyc pygdsl.py _pygdsl.so pygdsl_wrap.c build
