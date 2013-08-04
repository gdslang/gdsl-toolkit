MAKE=make
LIBS=gdrr x86

.PHONY all: $(LIBS)

$(LIBS):
	$(MAKE) -C $@

.PHONY clean: $(LIBS:=-clean)

$(LIBS:=-clean):
	$(MAKE) -C $(@:-clean=) clean
