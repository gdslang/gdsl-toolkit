AUTOMAKE_OPTIONS = -Wno-override
MLTON = @MLTON@
MLULEX = @MLULEX@
MLANTLR = @MLANTLR@

GDSL_SML_FILES = \
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


SUFFIXES = .mlb

GDSLC = $(abspath $(CURDIR)/gdsl$(EXEEXT))

%.mlb : $(GDSL_SML_FILES)

gdsl$(EXEEXT) : gdsl.mlb
	$(MLTON) $(MLFLAGS) -output $@ $<

bin_PROGRAMS = gdsl
gdsl_MAIN = $(gdsl_SOURCES)
gdsl_SOURCES = gdsl.mlb $(GDSL_SML_FILES)

*.l.sml	: *.l
	$(MLULEX) $<

*.g.sml	: *.g
	$(MLANTLR) $<

GDSL_BASIS = \
	specifications/basis/prelude.ml

GDSL_X86 = \
	specifications/x86/x86.ml \
	specifications/x86/x86-pretty.ml \
	specifications/x86/x86-pretty-simple.ml

GDSL_RREIL = \
	specifications/rreil/fmap.ml \
	specifications/basis/bbtree.ml \
	specifications/rreil/rreil-decl.ml \
	specifications/rreil/rreil-emit.ml \
	specifications/rreil/rreil-examples.ml \
	specifications/rreil/rreil-cif.ml \
	specifications/rreil/rreil-pretty.ml \
	specifications/rreil/rreil-liveness.ml \
	specifications/rreil/rreil-cleanup.ml \
	specifications/basis/selectors.ml 

GDSL_X86SEM = \
	specifications/x86/x86-rreil-translator.ml \
	specifications/x86/x86-rreil-translator-a-l.ml \
	specifications/x86/x86-rreil-translator-m-z.ml \
	specifications/x86/x86-rreil-registermapping.ml \
	specifications/x86/x86-liveness.ml

lib_LTLIBRARIES =

if X86_RREIL
lib_LTLIBRARIES += libgdsl-x86rreil.la
libgdsl_x86rreil_la_SOURCES =
nodist_libgdsl_x86rreil_la_SOURCES = gdsl-x86rreil.c
EXTRA_libgdsl_x86rreil_la_DEPENDENCIES = gdsl
CLEANFILES = gdsl-x86rreil.c

gdsl-x86rreil.c : gdsl$(EXEEXT) $(GDSL_BASIS) $(GDSL_X86) $(GDSL_RREIL) $(GDSL_X86SEM)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(filter-out gdsl$(EXEEXT),$^)
endif

