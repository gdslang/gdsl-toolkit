MAKE=make
LIBS=gdrr x86 rreil util gdsl x86-tester x86-generator

.PHONY all: $(LIBS)

$(LIBS):
	$(MAKE) -C $@

.PHONY clean: $(LIBS:=-clean)

$(LIBS:=-clean):
	$(MAKE) -C $(@:-clean=) clean
