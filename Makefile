all: _pygdsl.so

SOURCES=$(wildcard *.i *.c *.h)

_pygdsl.so: $(SOURCES)
	python setup.py build_ext --inplace
test: _pygdsl.so
	export PYTHONPATH=.
	python tests/single_instrs.py
	python tests/multiple_instrs.py
install: _pygdsl.so
	python setup.py install
clean:
	rm -rf *.o *.pyc pygdsl.py _pygdsl.so pygdsl_wrap.c build
