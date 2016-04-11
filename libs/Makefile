LIBS=gdutil gdsl-multiplex gdwrap readhex cgdsl cppgdsl

#eq = $(and $(findstring $(1),$(2)),$(findstring $(2),$(1)))
#$(if $(call eq,$GDSL_ARCH,x86), \
#LIBS+=x86 x86-tester x86-generator \
#)

ifeq ($(GDSL_ARCH),x86)
LIBS+=x86 x86-tester x86-generator
endif

.PHONY all: $(LIBS)

$(LIBS):
	$(MAKE) -C $@

.PHONY clean: $(LIBS:=-clean)

$(LIBS:=-clean):
	$(MAKE) -C $(@:-clean=) clean
