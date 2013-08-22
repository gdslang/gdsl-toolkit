LIBS=util gdwrap readhex

ifndef MANAGED
GDSL_X86:=1
endif

ifdef GDSL_X86
LIBS+=gdrr jrreil rreil x86 x86-tester x86-generator 
endif

.PHONY all: $(LIBS)

$(LIBS):
	$(MAKE) -C $@

.PHONY clean: $(LIBS:=-clean)

$(LIBS:=-clean):
	$(MAKE) -C $(@:-clean=) clean
