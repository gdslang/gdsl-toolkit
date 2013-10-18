# vim: noexpandtab

AUTOMAKE_OPTIONS = -Wno-override

CLEANFILES = STATS
noinst_PROGRAMS =
bin_PROGRAMS =
EXTRA_PROGRAMS =
noinst_LTLIBRARIES =
lib_LTLIBRARIES =
EXTRA_LTLIBRARIES =
include_HEADERS =

#if X86
#HAVE_X86 = 1
#endif
#if X86_RREIL
#HAVE_X86 = 1
#endif

EXEEXT=

# we need to add a dependency to the actual backend to this variable
libjrreil_la_LIBADD = 
decoder_cli_LDADD = 
semantics_cli_LDADD = 
semantics_cli_dynamic_LDADD = 
semantics_cif_cli_LDADD = 
sweep_LDADD = 
liveness_sweep_LDADD = 
x86_test_runner_LDADD = libx86-tester.la libgdwrap.la
x86_test_stats_runner_LDADD = libx86-tester.la libgdwrap.la

private_headers =

# options for the C compiler
AM_CFLAGS = -Wall

# the gdsl compiler

SMLNJ = @SMLNJ@
MLULEX = @MLULEX@
MLANTLR = @MLANTLR@

GDSLC_SML_FILES = \
         $(srcdir)/detail/export.sml \
         $(srcdir)/detail/common/basic-control.sml \
         $(srcdir)/detail/common/stats.sml \
         $(srcdir)/detail/common/expand-file.sml \
         $(srcdir)/detail/common/error.sml \
         $(srcdir)/detail/common/sum-sig.sml \
         $(srcdir)/detail/common/sum.sml \
         $(srcdir)/detail/common/float-lit.sml \
         $(srcdir)/detail/common/integer-lit.sml \
         $(srcdir)/detail/common/literal.sml \
         $(srcdir)/detail/common/stamp.sml \
         $(srcdir)/detail/common/basis.sml \
         $(srcdir)/detail/common/layout-sig.sml \
         $(srcdir)/detail/common/layout.sml \
         $(srcdir)/detail/common/compilation-monad.sml \
         $(srcdir)/detail/semantic/symbol-table-type.sml \
         $(srcdir)/detail/common/pp.sml \
         $(srcdir)/detail/parser/mk-ast.sml \
	       $(srcdir)/detail/parser/spec.g.sml \
	       $(srcdir)/detail/parser/spec.l.sml \
         $(srcdir)/detail/parser/spec-parse-tree.sml \
         $(srcdir)/detail/parser/parser.sml \
         $(srcdir)/detail/semantic/spec-abstract-tree.sml \
         $(srcdir)/detail/semantic/typing/boolean-domain.sml \
         $(srcdir)/detail/semantic/typing/tvar.sml \
         $(srcdir)/detail/semantic/typing/lang-types.sml \
         $(srcdir)/detail/semantic/typing/size-constraint.sml \
         $(srcdir)/detail/semantic/typing/substitutions.sml \
         $(srcdir)/detail/semantic/typing/environment.sml \
         \
         $(srcdir)/detail/spec/spec.sml \
         $(srcdir)/detail/spec/core.sml \
         \
         $(srcdir)/detail/imp/imp.sml \
         \
         $(srcdir)/detail/semantic/primitives.sml \
         $(srcdir)/detail/semantic/resolve-symbols.sml \
         $(srcdir)/detail/semantic/resolve-type-info.sml \
         $(srcdir)/detail/semantic/inference.sml \
         \
         $(srcdir)/detail/desugar/desugar-control.sml \
         $(srcdir)/detail/desugar/desugared-tree.sml \
         $(srcdir)/detail/desugar/split-declarations.sml \
         $(srcdir)/detail/desugar/desugar-guards.sml \
         $(srcdir)/detail/desugar/inline-decode-patterns.sml \
         $(srcdir)/detail/desugar/detokenize.sml \
         $(srcdir)/detail/desugar/retokenize.sml \
         $(srcdir)/detail/desugar/desugar-decode-syntax.sml \
         $(srcdir)/detail/desugar/desugar-monadic-sequences.sml \
         $(srcdir)/detail/desugar/desugar.sml \
         \
         $(srcdir)/detail/cps/cps.sml \
         $(srcdir)/detail/cps/cps-control.sml \
         $(srcdir)/detail/cps/from-core.sml \
         $(srcdir)/detail/cps/cps-opt.sml \
         $(srcdir)/detail/cps/mk-cps-pass.sml \
         $(srcdir)/detail/cps/cps-passes.sml \
         \
         $(srcdir)/detail/imp/imp-control.sml \
         $(srcdir)/detail/imp/imp-from-core.sml \
         $(srcdir)/detail/imp/mk-imp-pass.sml \
         $(srcdir)/detail/imp/imp-opt.sml \
         $(srcdir)/detail/imp/imp-passes.sml \
         \
         $(srcdir)/detail/closure/closure.sml \
         $(srcdir)/detail/closure/closure-control.sml \
         $(srcdir)/detail/closure/from-cps.sml \
         $(srcdir)/detail/closure/closure-passes.sml \
         \
         $(srcdir)/detail/codegen/codegen-control.sml \
         $(srcdir)/detail/codegen/codegen-mangle.sml \
         $(srcdir)/detail/codegen/c0/c0.sml \
         $(srcdir)/detail/codegen/c1/c1.sml \
         $(srcdir)/detail/codegen/js0/javascript-sig.sml \
         $(srcdir)/detail/codegen/js0/javascript.sml \
         $(srcdir)/detail/codegen/js0/js0.sml \
         $(srcdir)/detail/codegen/codegen-passes.sml \
         \
         $(srcdir)/detail/driver/main.sml \
         $(srcdir)/detail/ml/mlton/main.sml

JAR=jrreil.jar

$(builddir)/gdslc-image: $(srcdir)/gdsl.cm $(GDSLC_SML_FILES)
	echo 'CM.make("'$(srcdir)/gdsl.cm'"); SMLofNJ.exportFn ("'$@'",Main.njMain);' | $(SMLNJ)
	cd $(builddir) && $(LN_S) $@.* gdslc-image

CLEANFILES += $(builddir)/gdslc-image

GDSLC = $(SMLNJ) @SMLload=$(builddir)/gdslc-image


RUNTIME =  $(srcdir)/detail/codegen/c0/runtime.h \
  $(srcdir)/detail/codegen/c0/runtime.c \
  $(srcdir)/detail/codegen/c1/runtime.h \
  $(srcdir)/detail/codegen/c1/runtime.c \
  $(srcdir)/detail/codegen/js0/runtime.js

%.l.sml	: %.l
	$(MLULEX) $<

%.g.sml	: %.g
	$(MLANTLR) $<

GDSLC_DEP = $(builddir)/gdslc-image detail/codegen/c1/runtime.c detail/codegen/c1/runtime.h
GDSLFLAGS = --runtime=$(srcdir)/detail/codegen

# the decoders

GDSL_BASIS = \
	$(srcdir)/specifications/basis/prelude.ml

GDSL_X86 = \
	$(srcdir)/specifications/x86/x86.ml \
	$(srcdir)/specifications/x86/x86-pretty.ml \
	$(srcdir)/specifications/x86/x86-pretty-simple.ml

GDSL_X86SEM = \
	$(srcdir)/specifications/x86/x86-rreil-pretty.ml \
	$(srcdir)/specifications/x86/x86-rreil-translator.ml \
	$(srcdir)/specifications/x86/x86-rreil-translator-a-l.ml \
	$(srcdir)/specifications/x86/x86-rreil-translator-m-z.ml \
	$(srcdir)/specifications/x86/x86-rreil-registermapping.ml \
	$(srcdir)/specifications/x86/x86-liveness.ml

GDSL_AVR = \
	$(srcdir)/specifications/avr/avr.ml \
	$(srcdir)/specifications/avr/avr-pretty.ml

GDSL_AVRSEM = \
	$(srcdir)/specifications/avr/avr-rreil-translator.ml \
	$(srcdir)/specifications/avr/avr-rreil-registermapping.ml \
	$(srcdir)/specifications/avr/avr-rreil-pretty.ml

GDSL_RREIL = \
	$(srcdir)/specifications/rreil/fmap.ml \
	$(srcdir)/specifications/basis/bbtree.ml \
	$(srcdir)/specifications/rreil/rreil.ml \
	$(srcdir)/specifications/rreil/rreil-examples.ml \
	$(srcdir)/specifications/rreil/rreil-cif.ml \
	$(srcdir)/specifications/rreil/rreil-pretty.ml \
	$(srcdir)/specifications/rreil/rreil-liveness.ml \
	$(srcdir)/specifications/rreil/rreil-cleanup.ml \
	$(srcdir)/specifications/basis/selectors.ml 

if X86_RREIL
lib_LTLIBRARIES += libgdsl-x86-rreil.la
include_HEADERS += gdsl-x86-rreil.h
libjrreil_la_LIBADD += libgdsl-x86-rreil.la
decoder_cli_LDADD += libgdsl-x86-rreil.la
semantics_cli_LDADD += libgdsl-x86-rreil.la
semantics_cli_dynamic_LDADD += libgdsl-x86-rreil.la
semantics_cif_cli_LDADD += libgdsl-x86-rreil.la
sweep_LDADD += libgdsl-x86-rreil.la
liveness_sweep_LDADD += libgdsl-x86-rreil.la
x86_test_runner_LDADD += libgdsl-x86-rreil.la
x86_test_stats_runner_LDADD += libgdsl-x86-rreil.la
endif
libgdsl_x86_rreil_la_SOURCES =
nodist_libgdsl_x86_rreil_la_SOURCES = gdsl-x86-rreil.c
libgdsl_x86_rreil_la_DEPENDENCIES = $(GDSLC_DEP)
CLEANFILES += gdsl-x86-rreil.c

GS_X86_RREIL := $(GDSL_BASIS) $(GDSL_X86) $(GDSL_RREIL) $(GDSL_X86SEM)
gdsl-x86-rreil.c: $(GDSLC_DEP) $(GS_X86_RREIL)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(GS_X86_RREIL)

CLEANFILES += gdsl-x86-rreil.c gdsl-x86-rreil.h

if X86
lib_LTLIBRARIES += libgdsl-x86.la
decoder_cli_LDADD += libgdsl-x86.la
endif
libgdsl_x86_la_SOURCES =
nodist_libgdsl_x86_la_SOURCES = gdsl-x86.c
libgdsl_x86_la_DEPENDENCIES = $(GDSLC_DEP)
CLEANFILES += gdsl-x86.c

GS_X86 := $(GDSL_BASIS) $(GDSL_X86)
gdsl-x86.c: $(GDSLC_DEP) $(GS_X86)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(GS_X86)

if AVR_RREIL
lib_LTLIBRARIES += libgdsl-avr-rreil.la
libjrreil_la_LIBADD += libgdsl-avr-rreil.la
decoder_cli_LDADD += libgdsl-avr-rreil.la
semantics_cli_LDADD += libgdsl-avr-rreil.la
semantics_cli_dynamic_LDADD += libgdsl-avr-rreil.la
semantics_cif_cli_LDADD += libgdsl-avr-rreil.la
sweep_LDADD += libgdsl-avr-rreil.la
liveness_sweep_LDADD += libgdsl-avr-rreil.la
x86_test_runner_LDADD += libgdsl-avr-rreil.la
x86_test_stats_runner_LDADD += libgdsl-avr-rreil.la
endif
libgdsl_avr_rreil_la_SOURCES =
nodist_libgdsl_avr_rreil_la_SOURCES = gdsl-avr-rreil.c
libgdsl_avr_rreil_la_DEPENDENCIES = $(GDSLC_DEP)
CLEANFILES += gdsl-avr-rreil.c

GS_AVR_RREIL :=  $(GDSL_BASIS) $(GDSL_AVR) $(GDSL_RREIL) $(GDSL_AVRSEM)
gdsl-avr-rreil.c: $(GDSLC_DEP) $(GS_AVR_RREIL)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(GS_AVR_RREIL)

CLEANFILES += gdsl-avr-rreil.c gdsl-avr-rreil.h

if AVR
lib_LTLIBRARIES += libgdsl-avr.la
decoder_cli_LDADD += libgdsl-avr.la
endif
libgdsl_avr_la_SOURCES =
nodist_libgdsl_avr_la_SOURCES = gdsl-avr.c
libgdsl_avr_la_DEPENDENCIES = $(GDSLC_DEP)
CLEANFILES += gdsl-avr.c

GS_AVR := $(GDSL_BASIS) $(GDSL_AVR)
gdsl-avr.c: $(GDSLC_DEP) $(GS_AVR)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(GS_AVR)

CLEANFILES += gdsl-avr.c gdsl-avr.h

if HAVE_RREIL
JSOURCES = src/rreil/DefaultLimitedVariableCollection.java \
           src/rreil/IAddress.java \
           src/rreil/LimitedVariable.java \
           src/rreil/BranchHint.java \
           src/rreil/id/FloatingFlags.java \
           src/rreil/id/VirtualLessOrEqualSignedId.java \
           src/rreil/id/VirtualLessSignedId.java \
           src/rreil/id/GenericArchRegister.java \
           src/rreil/id/VirtualLessUnsignedId.java \
           src/rreil/id/Id.java \
           src/rreil/id/IId.java \
           src/rreil/id/VirtualEqualsNotId.java \
           src/rreil/id/VirtualTemporaryId.java \
           src/rreil/id/x86/X86RegisterId.java \
           src/rreil/id/x86/X86Register.java \
           src/rreil/id/VirtualLessOrEqualUnsignedId.java \
           src/rreil/id/VirtualEqualsId.java \
           src/rreil/statement/ConditionalBranchStatement.java \
           src/rreil/statement/AssignStatement.java \
           src/rreil/statement/WhileStatement.java \
           src/rreil/statement/PrimitiveStatement.java \
           src/rreil/statement/LoadStatement.java \
           src/rreil/statement/StoreStatement.java \
           src/rreil/statement/Statement.java \
           src/rreil/statement/FlopStatement.java \
           src/rreil/statement/BranchStatement.java \
           src/rreil/statement/IStatement.java \
           src/rreil/statement/IfThenElseStatement.java \
           src/rreil/statement/ThrowStatement.java \
           src/rreil/DefaultStatementCollection.java \
           src/rreil/Flop.java \
           src/rreil/IRReilBuilder.java \
           src/rreil/linear/LinearImmediateExpression.java \
           src/rreil/linear/ILinearExpression.java \
           src/rreil/linear/LinearVariableExpression.java \
           src/rreil/linear/LinearBinaryExpression.java \
           src/rreil/linear/LinearScaleExpression.java \
           src/rreil/linear/LinearExpression.java \
           src/rreil/linear/LinearAdditionExpression.java \
           src/rreil/linear/LinearSubtractionExpression.java \
           src/rreil/sexpression/SimpleLinearExpression.java \
           src/rreil/sexpression/SimpleCompareExpression.java \
           src/rreil/sexpression/SimpleExpression.java \
           src/rreil/sexpression/ISimpleExpression.java \
           src/rreil/sexpression/Arbitrary.java \
           src/rreil/Variable.java \
           src/rreil/DefaultRReilBuilder.java \
           src/rreil/Address.java \
           src/rreil/IVariable.java \
           src/rreil/ILimitedVariable.java \
           src/rreil/IRReilCollection.java \
           src/rreil/IFlop.java \
           src/rreil/expression/CompareLessSigned.java \
           src/rreil/expression/SignExtend.java \
           src/rreil/expression/And.java \
           src/rreil/expression/Unary.java \
           src/rreil/expression/CompareNotEqual.java \
           src/rreil/expression/Simple.java \
           src/rreil/expression/ShiftRight.java \
           src/rreil/expression/ZeroExtend.java \
           src/rreil/expression/ICompare.java \
           src/rreil/expression/Modulo.java \
           src/rreil/expression/SignedModulo.java \
           src/rreil/expression/CompareEqual.java \
           src/rreil/expression/CompareLessOrEqualUnsigned.java \
           src/rreil/expression/ShiftLeft.java \
           src/rreil/expression/Multiplication.java \
           src/rreil/expression/Binary.java \
           src/rreil/expression/Division.java \
           src/rreil/expression/Or.java \
           src/rreil/expression/CompareLessOrEqualSigned.java \
           src/rreil/expression/Expression.java \
           src/rreil/expression/ShiftRightSigned.java \
           src/rreil/expression/IExpression.java \
           src/rreil/expression/Compare.java \
           src/rreil/expression/CompareLessUnsigned.java \
           src/rreil/expression/SignedDivision.java \
           src/rreil/expression/Extend.java \
           src/rreil/expression/Xor.java \
           src/rreil/exception/IException.java \
           src/rreil/exception/Exception.java \
           src/rreil/exception/x86/X86Exception.java \
           src/rreil/exception/GenericArchException.java \
           src/rreil/IBranchHint.java \
           src/rnati/RReilTranslateException.java \
           src/rnati/GdslDecodeException.java \
           src/rnati/NativeInterface.java \
           src/Program.java

SPRE=src
BPRE=$(top_builddir)/build

BDIRS=$(BPRE)
pre-build:
	mkdir -p $(BDIRS)

$(JAR): pre-build $(JSOURCES:%=libs/jrreil/%)
	ABS_DST=$$(pwd)/$(BPRE) && cd $(srcdir)/libs/jrreil && javac $(JSOURCES) -d $$ABS_DST/
	jar -cf $@ $(JSOURCES:$(SPRE)/%.java=-C $(BPRE) %.class)

CLEANFILES += jrreil.jar

endif

clean-local:
	-rm -rf build/
	-rm -f $(builddir)/gdslc-image.*

if INSTALL_AUXLIBS
lib_LTLIBRARIES += libreadhex.la libutil.la
else
if BUILD_AUXLIBS
noinst_LTLIBRARIES += libreadhex.la libutil.la
endif
endif

if HAVE_X86
if INSTALL_AUXLIBS
if HAVE_POSIX200809_C11
lib_LTLIBRARIES += libx86-generator.la
endif
else
if BUILD_AUXLIBS
if HAVE_POSIX200809_C11
noinst_LTLIBRARIES += libx86-generator.la
endif
endif
endif
endif

if X86_RREIL
if INSTALL_AUXLIBS
if HAVE_POSIX200809_C11
if LINUX
lib_LTLIBRARIES += libx86-tester.la
endif
endif
lib_LTLIBRARIES += libx86.la libgdwrap.la
else
if BUILD_AUXLIBS
if HAVE_POSIX200809_C11
if LINUX
noinst_LTLIBRARIES += libx86-tester.la
endif
endif
noinst_LTLIBRARIES += libx86.la libgdwrap.la
endif
endif
endif

if HAVE_POSIX200809_C11
if HAVE_RREIL
if INSTALL_AUXLIBS
if LINUX
lib_LTLIBRARIES += librreil-sim.la
endif
lib_LTLIBRARIES += librreil.la
if HAVE_JNI_H
lib_LTLIBRARIES += libjrreil.la
endif
lib_LTLIBRARIES += libgdsl-multiplex.la
else
if BUILD_AUXLIBS
if LINUX
noinst_LTLIBRARIES += librreil-sim.la
endif
noinst_LTLIBRARIES += librreil.la
if HAVE_JNI_H
noinst_LTLIBRARIES += libjrreil.la
endif
noinst_LTLIBRARIES += libgdsl-multiplex.la
endif
endif
endif
endif

libreadhex_la_SOURCES = $(srcdir)/libs/readhex/src/readhex.c
libreadhex_la_CFLAGS = -I$(srcdir)/libs/readhex/include
include_HEADERS += $(srcdir)/libs/readhex/include/readhex.h

libutil_la_SOURCES = $(srcdir)/libs/util/src/util.c $(srcdir)/libs/util/src/stack.c
libutil_la_CFLAGS = -std=c99 -I$(srcdir)/libs/util/include
include_HEADERS += $(srcdir)/libs/util/include/util.h $(srcdir)/libs/util/include/stack.h

if HAVE_X86
libx86_la_SOURCES = $(srcdir)/libs/x86/src/x86.c $(srcdir)/libs/x86/src/x86_features.c
libx86_la_CFLAGS = -std=c99 -I$(srcdir)/libs/x86/include
include_HEADERS += libs/x86/include/x86.h libs/x86/include/x86_features.h
endif

if HAVE_RREIL
librreil_la_SOURCES = $(srcdir)/libs/rreil/src/rreil/copy.c \
                      $(srcdir)/libs/rreil/src/rreil/print.c \
                      $(srcdir)/libs/rreil/src/rreil/gdrr_builder.c \
                      $(srcdir)/libs/rreil/src/rreil/free.c \
                      $(srcdir)/libs/rreil/src/rreil/rreil_id.c
librreil_la_CFLAGS = -std=c11 -I$(srcdir)/libs/rreil/include -I$(srcdir)/libs/gdrr/include -I$(srcdir)/libs/util/include
if HAVE_X86
librreil_la_CFLAGS += -DGDSL_X86 -I$(srcdir)/libs/x86/include
endif
include_HEADERS += $(srcdir)/libs/rreil/include/rreil/rreil.h \
                   $(srcdir)/libs/rreil/include/rreil/rreil_copy.h \
                   $(srcdir)/libs/rreil/include/rreil/rreil_print.h \
                   $(srcdir)/libs/rreil/include/rreil/rreil_address.h \
                   $(srcdir)/libs/rreil/include/rreil/gdrr_builder.h \
                   $(srcdir)/libs/rreil/include/rreil/rreil_linear.h \
                   $(srcdir)/libs/rreil/include/rreil/rreil_id.h \
                   $(srcdir)/libs/rreil/include/rreil/rreil_free.h \
                   $(srcdir)/libs/rreil/include/rreil/rreil_variable.h \
                   $(srcdir)/libs/rreil/include/rreil/rreil_variable_limited.h \
                   $(srcdir)/libs/rreil/include/rreil/rreil_flop.h \
                   $(srcdir)/libs/rreil/include/rreil/rreil_comparator.h \
                   $(srcdir)/libs/rreil/include/rreil/rreil_expr.h \
                   $(srcdir)/libs/rreil/include/rreil/rreil_branch_hint.h \
                   $(srcdir)/libs/rreil/include/rreil/rreil_exception.h \
                   $(srcdir)/libs/rreil/include/rreil/rreil_sexpr.h \
                   $(srcdir)/libs/rreil/include/rreil/rreil_arity.h \
                   $(srcdir)/libs/rreil/include/rreil/rreil_statement.h
endif

if X86_RREIL
librreil_sim_la_SOURCES = $(srcdir)/libs/rreil-sim/src/simulator/simulator.c \
                      $(srcdir)/libs/rreil-sim/src/simulator/ops.c \
                      $(srcdir)/libs/rreil-sim/src/simulator/regacc.c \
                      $(srcdir)/libs/rreil-sim/src/simulator/tracking.c \
                      $(srcdir)/libs/rreil-sim/src/memory.c \
                      $(srcdir)/libs/rreil-sim/src/context.c
librreil_sim_la_CFLAGS = -std=c99 -DGDSL_X86 -I$(srcdir)/libs/rreil/include -I$(srcdir)/libs/rreil-sim/include -I$(srcdir)/libs/gdrr/include -I$(srcdir)/libs/util/include -I$(srcdir)/libs/x86/include
include_HEADERS += $(srcdir)/libs/rreil-sim/include/memory.h \
                   $(srcdir)/libs/rreil-sim/include/simulator/register.h \
                   $(srcdir)/libs/rreil-sim/include/simulator/tracking.h \
                   $(srcdir)/libs/rreil-sim/include/simulator/regacc.h \
                   $(srcdir)/libs/rreil-sim/include/simulator/simulator.h \
                   $(srcdir)/libs/rreil-sim/include/simulator/ops.h \
                   $(srcdir)/libs/rreil-sim/include/context.h
endif

if X86_RREIL
libgdwrap_la_SOURCES = $(srcdir)/libs/gdwrap/src/gdwrap.c
libgdwrap_la_CFLAGS = -I$(srcdir)/libs/gdwrap/include
include_HEADERS += $(srcdir)/libs/gdwrap/include/gdwrap.h
endif

if HAVE_X86
libx86_generator_la_SOURCES = $(srcdir)/libs/x86-generator/src/generator_tree.c \
                             $(srcdir)/libs/x86-generator/src/x86_opcodes.c \
                             $(srcdir)/libs/x86-generator/src/generator.c
libx86_generator_la_CFLAGS = -std=c99 -I$(srcdir)/libs/x86-generator/include -I$(srcdir)/libs/util/include
include_HEADERS += $(srcdir)/libs/x86-generator/include/x86_opcodes.h \
                   $(srcdir)/libs/x86-generator/include/generator_tree.h \
                   $(srcdir)/libs/x86-generator/include/generator.h
endif

if X86_RREIL
libx86_tester_la_SOURCES = $(srcdir)/libs/x86-tester/src/executor.c \
                           $(srcdir)/libs/x86-tester/src/tbgen.c \
                           $(srcdir)/libs/x86-tester/src/tester.c \
                           $(srcdir)/libs/x86-tester/src/tbgen_alloc.c
libx86_tester_la_CFLAGS = -std=gnu99 -I$(srcdir)/libs/x86-tester/include -I$(srcdir)/libs/rreil/include -I$(srcdir)/libs/rreil-sim/include -I$(srcdir)/libs/x86/include -I$(srcdir)/libs/util/include -I$(srcdir)/libs/gdrr/include -I$(srcdir)/libs/gdwrap/include
include_HEADERS += $(srcdir)/libs/x86-tester/include/tbgen.h \
                   $(srcdir)/libs/x86-tester/include/tbgen_alloc.h \
                   $(srcdir)/libs/x86-tester/include/executor.h \
                   $(srcdir)/libs/x86-tester/include/tester.h
endif

if HAVE_RREIL
libjrreil_la_SOURCES = $(srcdir)/libs/jrreil/src/rnati_NativeInterface.c
libjrreil_la_CFLAGS = -std=c99 -I/usr/lib/jvm/java-7-openjdk-amd64/include -I$(srcdir)/libs/gdsl-multiplex/include
libjrreil_la_LIBADD += libgdsl-multiplex.la
private_headers += $(srcdir)/libs/jrreil/src/rnati_NativeInterface.h
endif

if HAVE_RREIL
libgdsl_multiplex_la_SOURCES = $(srcdir)/libs/gdsl-multiplex/src/gdsl_multiplex.c
libgdsl_multiplex_la_CFLAGS = -I$(srcdir)/libs/gdsl-multiplex/include
libgdsl_multiplex_la_LDFLAGS = -ldl
include_HEADERS += $(srcdir)/libs/gdsl-multiplex/include/gdsl_multiplex.h
endif

if HAVE_RREIL
if INSTALL_AUXBINS
if HAVE_POSIX200809_C11
bin_PROGRAMS += semantics-cli-dynamic
endif
bin_PROGRAMS += decoder-cli
bin_PROGRAMS += semantics-cli
bin_PROGRAMS += semantics-cif-cli
if HAVE_ELF
bin_PROGRAMS += sweep
endif
else
if BUILD_AUXBINS
if HAVE_POSIX200809_C11
noinst_PROGRAMS += semantics-cli-dynamic
endif
noinst_PROGRAMS += decoder-cli
noinst_PROGRAMS += semantics-cli
noinst_PROGRAMS += semantics-cif-cli
if HAVE_ELF
noinst_PROGRAMS += sweep
endif
endif
endif
endif

if X86_RREIL
if INSTALL_AUXBINS
if HAVE_POSIX200809_C11
if LINUX
bin_PROGRAMS += x86_test_runner
bin_PROGRAMS += x86_test_stats_runner
endif
endif
if HAVE_ELF
bin_PROGRAMS += liveness_sweep
endif
else
if BUILD_AUXBINS
if HAVE_POSIX200809_C11
if LINUX
noinst_PROGRAMS += x86_test_runner
noinst_PROGRAMS += x86_test_stats_runner
endif
endif
if HAVE_ELF
noinst_PROGRAMS += liveness_sweep
endif
endif
endif
endif

decoder_cli_SOURCES = $(srcdir)/tools/decoder-cli.c
decoder_cli_CFLAGS = -std=c99 -I$(srcdir)/libs/readhex/include
if HAVE_X86
decoder_cli_CFLAGS += -DGDSL_X86
endif
decoder_cli_LDADD += libreadhex.la

semantics_cli_SOURCES = $(srcdir)/tools/semantics-cli.c
semantics_cli_CFLAGS = -std=c99 -I$(srcdir)/libs/readhex/include
if HAVE_X86
semantics_cli_CFLAGS += -DGDSL_X86
endif
semantics_cli_LDADD += libreadhex.la

semantics_cli_dynamic_SOURCES = $(srcdir)/tools/semantics-cli-dynamic.c
semantics_cli_dynamic_CFLAGS = -std=c99 -I$(srcdir)/libs/readhex/include -I$(srcdir)/libs/gdsl-multiplex/include
semantics_cli_dynamic_LDADD += libreadhex.la libgdsl-multiplex.la

semantics_cif_cli_SOURCES = $(srcdir)/tools/semantics-cif-cli.c
semantics_cif_cli_CFLAGS = -std=c99 -I$(srcdir)/libs/gdrr/include -I$(srcdir)/libs/readhex/include
semantics_cif_cli_LDADD += libreadhex.la

sweep_SOURCES = $(srcdir)/tools/sweep.c
sweep_CFLAGS = -std=gnu99
sweep_LDFLAGS = -lelf

if X86_RREIL
liveness_sweep_SOURCES = $(srcdir)/tools/liveness-sweep.c
liveness_sweep_CFLAGS = -std=gnu99
liveness_sweep_LDFLAGS = -lelf
endif

if X86_RREIL
x86_test_runner_SOURCES = $(srcdir)/tools/x86-test-runner/src/main.c
x86_test_runner_CFLAGS = -std=gnu99 -I$(srcdir)/libs/rreil/include -I$(srcdir)/libs/rreil-sim/include -I$(srcdir)/libs/x86/include -I$(srcdir)/libs/x86-generator/include -I$(srcdir)/libs/x86-tester/include -I$(srcdir)/libs/readhex/include
x86_test_runner_LDADD += librreil.la librreil-sim.la libx86-generator.la libx86.la libreadhex.la libutil.la
endif

if X86_RREIL
x86_test_stats_runner_SOURCES = $(srcdir)/tools/x86-test-stats-runner/src/main.c $(srcdir)/tools/x86-test-stats-runner/src/hash_array.c
x86_test_stats_runner_CFLAGS = -std=gnu99 -I$(srcdir)/libs/rreil/include -I$(srcdir)/libs/rreil-sim/include -I$(srcdir)/libs/x86/include -I$(srcdir)/libs/x86-generator/include -I$(srcdir)/libs/x86-tester/include -I$(srcdir)/libs/readhex/include
x86_test_stats_runner_LDADD += librreil.la librreil-sim.la libx86-generator.la libx86.la libreadhex.la libutil.la
private_headers += $(srcdir)/tools/x86-test-stats-runner/src/hash_array.h
endif

EXTRA_DIST = LICENSE $(GDSL_BASIS) $(GDSL_X86) $(GDSL_RREIL) $(GDSL_X86SEM) $(GDSL_AVR) $(GDSL_AVRSEM) $(private_headers) $(RUNTIME) $(srcdir)/gdsl.h $(srcdir)/gdslc.mlb $(srcdir)/gdsl.cm $(GDSLC_SML_FILES)
