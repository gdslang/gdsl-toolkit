AUTOMAKE_OPTIONS = -Wno-override

CLEANFILES =
noinst_PROGRAMS =
bin_PROGRAMS =
EXTRA_PROGRAMS =
noinst_LTLIBRARIES =
lib_LTLIBRARIES =
EXTRA_LTLIBRARIES =
include_HEADERS =

# we need to add a dependency to the actual backend to this variable
cli_LDADD =

# options for the C compiler
AM_CFLAGS = -Wall

# the gdsl compiler

MLTON = @MLTON@
MLULEX = @MLULEX@
MLANTLR = @MLANTLR@

GDSLC_SML_FILES = \
         detail/common/basic-control.sml \
         detail/common/stats.sml \
         detail/common/expand-file.sml \
         detail/common/error.sml \
         detail/common/sum-sig.sml \
         detail/common/sum.sml \
         detail/common/float-lit.sml \
         detail/common/integer-lit.sml \
         detail/common/literal.sml \
         detail/common/stamp.sml \
         detail/common/basis.sml \
         detail/common/layout-sig.sml \
         detail/common/layout.sml \
         detail/common/compilation-monad.sml \
         detail/semantic/symbol-table-type.sml \
         detail/common/pp.sml \
         detail/parser/mk-ast.sml \
	 detail/parser/spec.g.sml \
	 detail/parser/spec.l.sml \
         detail/parser/spec-parse-tree.sml \
         detail/parser/parser.sml \
         detail/semantic/spec-abstract-tree.sml \
         detail/semantic/typing/boolean-domain.sml \
         detail/semantic/typing/tvar.sml \
         detail/semantic/typing/lang-types.sml \
         detail/semantic/typing/size-constraint.sml \
         detail/semantic/typing/substitutions.sml \
         detail/semantic/typing/environment.sml \
         \
         detail/spec/spec.sml \
         detail/spec/core.sml \
         \
         detail/imp/imp.sml \
         \
         detail/semantic/primitives.sml \
         detail/semantic/resolve-symbols.sml \
         detail/semantic/resolve-type-info.sml \
         detail/semantic/inference.sml \
         \
         detail/desugar/desugar-control.sml \
         detail/desugar/desugared-tree.sml \
         detail/desugar/split-declarations.sml \
         detail/desugar/desugar-guards.sml \
         detail/desugar/inline-decode-patterns.sml \
         detail/desugar/detokenize.sml \
         detail/desugar/retokenize.sml \
         detail/desugar/desugar-decode-syntax.sml \
         detail/desugar/desugar-monadic-sequences.sml \
         detail/desugar/desugar.sml \
         \
         detail/cps/cps.sml \
         detail/cps/cps-control.sml \
         detail/cps/from-core.sml \
         detail/cps/cps-opt.sml \
         detail/cps/mk-cps-pass.sml \
         detail/cps/cps-passes.sml \
         \
         detail/imp/imp-control.sml \
         detail/imp/imp-from-core.sml \
         detail/imp/mk-imp-pass.sml \
         detail/imp/imp-opt.sml \
         detail/imp/imp-passes.sml \
         \
         detail/closure/closure.sml \
         detail/closure/closure-control.sml \
         detail/closure/from-cps.sml \
         detail/closure/closure-passes.sml \
         \
         detail/codegen/codegen-control.sml \
         detail/codegen/codegen-mangle.sml \
         detail/codegen/c0/c0.sml \
         detail/codegen/c1/c1.sml \
         detail/codegen/js0/javascript-sig.sml \
         detail/codegen/js0/javascript.sml \
         detail/codegen/js0/js0.sml \
         detail/codegen/codegen-passes.sml \
         \
         detail/driver/main.sml \
         detail/ml/mlton/main.sml


gdslc$(EXEEXT) : gdslc.mlb $(GDSLC_SML_FILES)
	$(MLTON) $(MLFLAGS) -output $@ gdslc.mlb

if INSTALL_GDSLC
bin_PROGRAMS += gdslc
else
noinst_PROGRAMS += gdslc
endif

gdslc_MAIN = $(gdslc_SOURCES)
gdslc_SOURCES = gdslc.mlb $(GDSLC_SML_FILES)

*.l.sml	: *.l
	$(MLULEX) $<

*.g.sml	: *.g
	$(MLANTLR) $<

GDSLC = $(abspath $(CURDIR)/gdslc$(EXEEXT))
GDSLC_DEP = gdslc$(EXEEXT)

# the decoders

GDSL_BASIS = \
	specifications/basis/prelude.ml

GDSL_X86 = \
	specifications/x86/x86.ml \
	specifications/x86/x86-pretty.ml \
	specifications/x86/x86-pretty-simple.ml

GDSL_X86SEM = \
	specifications/x86/x86-rreil-translator.ml \
	specifications/x86/x86-rreil-translator-a-l.ml \
	specifications/x86/x86-rreil-translator-m-z.ml \
	specifications/x86/x86-rreil-registermapping.ml \
	specifications/x86/x86-liveness.ml

GDSL_AVR = \
	specifications/avr/avr.ml \
	specifications/avr/avr-pretty.ml

GDSL_AVRSEM = \
	specifications/avr/avr-rreil-translator.ml \
	specifications/avr/avr-rreil-registermapping.ml

GDSL_RREIL = \
	specifications/rreil/fmap.ml \
	specifications/basis/bbtree.ml \
	specifications/rreil/rreil.ml \
	specifications/rreil/rreil-examples.ml \
	specifications/rreil/rreil-cif.ml \
	specifications/rreil/rreil-pretty.ml \
	specifications/rreil/rreil-liveness.ml \
	specifications/rreil/rreil-cleanup.ml \
	specifications/basis/selectors.ml 

if X86_RREIL
lib_LTLIBRARIES += libgdsl-x86-rreil.la
include_HEADERS += gdsl-x86-rreil.h
libgdrr_la_LIBADD = libgdsl-x86-rreil.la
cli_LDADD += libgdsl-x86-rreil.la
endif
libgdsl_x86_rreil_la_SOURCES =
nodist_libgdsl_x86_rreil_la_SOURCES = gdsl-x86-rreil.c
libgdsl_x86_rreil_la_DEPENDENCIES = $(GDSLC_DEP)
CLEANFILES += gdsl-x86-rreil.c

gdsl-x86-rreil.c : $(GDSLC_DEP) $(GDSL_BASIS) $(GDSL_X86) $(GDSL_RREIL) $(GDSL_X86SEM)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(filter-out $(GDSLC_DEP),$^)

if X86
lib_LTLIBRARIES += libgdsl-x86.la
libgdrr_la_LIBADD = libgdsl-x86.la
cli_LDADD += libgdsl-x86.la
endif
libgdsl_x86_la_SOURCES =
nodist_libgdsl_x86_la_SOURCES = gdsl-x86.c
libgdsl_x86_la_DEPENDENCIES = $(GDSLC_DEP)
CLEANFILES += gdsl-x86.c

gdsl-x86.c : $(GDSLC_DEP) $(GDSL_BASIS) $(GDSL_X86)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(filter-out $(GDSLC_DEP),$^)

if AVR_RREIL
lib_LTLIBRARIES += libgdsl-avr-rreil.la
libgdrr_la_LIBADD = libgdsl-avr-rreil.la
cli_LDADD += libgdsl-avr-rreil.la
endif
libgdsl_avr_rreil_la_SOURCES =
nodist_libgdsl_avr_rreil_la_SOURCES = gdsl-avr-rreil.c
libgdsl_avr_rreil_la_DEPENDENCIES = $(GDSLC_DEP)
CLEANFILES += gdsl-avr-rreil.c

gdsl-avr-rreil.c : $(GDSLC_DEP) $(GDSL_BASIS) $(GDSL_AVR) $(GDSL_RREIL) $(GDSL_AVRSEM)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(filter-out $(GDSLC_DEP),$^)

if AVR
lib_LTLIBRARIES += libgdsl-avr.la
libgdrr_la_LIBADD = libgdsl-avr.la
cli_LDADD += libgdsl-avr.la
endif
libgdsl_avr_la_SOURCES =
nodist_libgdsl_avr_la_SOURCES = gdsl-avr.c
libgdsl_avr_la_DEPENDENCIES = $(GDSLC_DEP)
CLEANFILES += gdsl-avr.c

gdsl-avr.c : $(GDSLC_DEP) $(GDSL_BASIS) $(GDSL_AVR)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(filter-out $(GDSLC_DEP),$^)


if INSTALL_AUXLIBS
lib_LTLIBRARIES += libreadhex.la
else
if BUILD_AUXLIBS
noinst_LTLIBRARIES += libreadhex.la
endif
endif

if RREIL
if INSTALL_AUXLIBS
lib_LTLIBRARIES += libgdrr.la
lib_LTLIBRARIES += libgdwrap.la
else
if BUILD_AUXLIBS
noinst_LTLIBRARIES += libgdrr.la
noinst_LTLIBRARIES += libgdwrap.la
endif
endif
endif

libgdrr_la_SOURCES = libs/gdrr/src/gdrr.c
libgdrr_la_CFLAGS = -I./libs/gdrr/include
include_HEADERS += \
	libs/gdrr/include/gdrr.h \
	libs/gdrr/include/gdrr_arch.h \
	libs/gdrr/include/gdrr_arch_callbacks.h \
	libs/gdrr/include/gdrr_callbacks.h \
	libs/gdrr/include/gdrr_config.h \
	libs/gdrr/include/gdrr_types.h

libreadhex_la_SOURCES = libs/readhex/src/readhex.c
libreadhex_la_CFLAGS = -I./libs/readhex/include
include_HEADERS += libs/readhex/include/readhex.h

libgdwrap_la_SOURCES = libs/gdwrap/src/gdwrap.c
libgdwrap_la_CFLAGS = -I./libs/gdwrap/include
include_HEADERS += libs/gdwrap/include/gdwrap.h

if RREIL
if INSTALL_AUXBINS
bin_PROGRAMS += cli
bin_PROGRAMS += cli-gdrr
else
if BUILD_AUXBINS
noinst_PROGRAMS += cli
noinst_PROGRAMS += cli-gdrr
endif
endif
endif

cli_SOURCES = tools/cli.c
cli_CFLAGS = -I./libs/readhex/include -I./libs/gdwrap/include
cli_LDADD += libreadhex.la libgdwrap.la

cli_gdrr_SOURCES = tools/cli-gdrr.c
cli_gdrr_CFLAGS = -I./libs/gdrr/include -I./libs/readhex/include -I./libs/gdwrap/include
cli_gdrr_LDADD = libgdrr.la libreadhex.la libgdwrap.la
