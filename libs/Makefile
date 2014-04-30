LIBS=gdutil gdsl-multiplex gdwrap readhex rreil jgdsl

#ifndef MANAGED
#GDSL_AVR:=1
#GDSL_X86:=1
#endif

ifdef GDSL_X86
LIBS+=x86 rreil-sim x86-tester x86-generator 
endif

.PHONY all: $(LIBS)

$(LIBS):
	$(MAKE) -C $@

.PHONY clean: $(LIBS:=-clean)

$(LIBS:=-clean):
	$(MAKE) -C $(@:-clean=) clean
