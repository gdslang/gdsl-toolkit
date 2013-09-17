AUTOMAKE_OPTIONS = -Wno-override

CLEANFILES =
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

MLTON = @MLTON@
MLULEX = @MLULEX@
MLANTLR = @MLANTLR@

GDSLC_SML_FILES = \
         detail/export.sml \
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

JAR=jrreil.jar

gdslc$(EXEEXT) : gdslc.mlb $(GDSLC_SML_FILES)
	$(MLTON) $(MLFLAGS) -output $@ gdslc.mlb

if INSTALL_GDSLC
bin_PROGRAMS += gdslc
else
noinst_PROGRAMS += gdslc
endif

gdslc_MAIN = $(gdslc_SOURCES)
gdslc_SOURCES = gdslc.mlb $(GDSLC_SML_FILES)

%.l.sml	: %.l
	$(MLULEX) $<

%.g.sml	: %.g
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
	specifications/x86/x86-rreil-pretty.ml \
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

gdsl-x86-rreil.c : $(GDSLC_DEP) $(GDSL_BASIS) $(GDSL_X86) $(GDSL_RREIL) $(GDSL_X86SEM)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(filter-out $(GDSLC_DEP),$^)

if X86
lib_LTLIBRARIES += libgdsl-x86.la
decoder_cli_LDADD += libgdsl-x86.la
endif
libgdsl_x86_la_SOURCES =
nodist_libgdsl_x86_la_SOURCES = gdsl-x86.c
libgdsl_x86_la_DEPENDENCIES = $(GDSLC_DEP)
CLEANFILES += gdsl-x86.c

gdsl-x86.c : $(GDSLC_DEP) $(GDSL_BASIS) $(GDSL_X86)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(filter-out $(GDSLC_DEP),$^)

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

gdsl-avr-rreil.c : $(GDSLC_DEP) $(GDSL_BASIS) $(GDSL_AVR) $(GDSL_RREIL) $(GDSL_AVRSEM)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(filter-out $(GDSLC_DEP),$^)

if AVR
lib_LTLIBRARIES += libgdsl-avr.la
decoder_cli_LDADD += libgdsl-avr.la
endif
libgdsl_avr_la_SOURCES =
nodist_libgdsl_avr_la_SOURCES = gdsl-avr.c
libgdsl_avr_la_DEPENDENCIES = $(GDSLC_DEP)
CLEANFILES += gdsl-avr.c

gdsl-avr.c : $(GDSLC_DEP) $(GDSL_BASIS) $(GDSL_AVR)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(filter-out $(GDSLC_DEP),$^)

if HAVE_RREIL
JSOURCES = src/rreil/IAddress.java \
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
           src/rreil/statement/LoadStatement.java \
           src/rreil/statement/StoreStatement.java \
           src/rreil/statement/Statement.java \
           src/rreil/statement/BranchStatement.java \
           src/rreil/statement/IStatement.java \
           src/rreil/statement/IfThenElseStatement.java \
           src/rreil/statement/PrimitiveStatement.java \
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
           src/rreil/Variable.java \
           src/rreil/DefaultRReilBuilder.java \
           src/rreil/Address.java \
           src/rreil/IVariable.java \
           src/rreil/IRReilCollection.java \
           src/rreil/DefaultStatementCollection.java \
           src/rreil/DefaultLimitedVariableCollection.java \
           src/rreil/IBranchHint.java \
           src/rreil/ILimitedVariable.java \
           src/rreil/LimitedVariable.java \
           src/rreil/Flop.java \
           src/rreil/IFlop.java \
           src/rreil/operation/SignExtendOperation.java \
           src/rreil/operation/CompareLessOrEqualSignedOperation.java \
           src/rreil/operation/ZeroExtendOperation.java \
           src/rreil/operation/AndOperation.java \
           src/rreil/operation/DivisionOperation.java \
           src/rreil/operation/Operation.java \
           src/rreil/operation/BinaryOperation.java \
           src/rreil/operation/ShiftLeftOperation.java \
           src/rreil/operation/CompareLessUnsignedOperation.java \
           src/rreil/operation/OrOperation.java \
           src/rreil/operation/ExtendOperation.java \
           src/rreil/operation/CompareNotEqualOperation.java \
           src/rreil/operation/ModuloOperation.java \
           src/rreil/operation/ICompareOperation.java \
           src/rreil/operation/ArbitraryOperation.java \
           src/rreil/operation/UnaryOperation.java \
           src/rreil/operation/CompareEqualOperation.java \
           src/rreil/operation/CompareOperation.java \
           src/rreil/operation/LinearOperation.java \
           src/rreil/operation/MultiplicationOperation.java \
           src/rreil/operation/ShiftRightSignedOperation.java \
           src/rreil/operation/SignedDivisionOperation.java \
           src/rreil/operation/CompareLessOrEqualUnsignedOperation.java \
           src/rreil/operation/CompareLessSignedOperation.java \
           src/rreil/operation/IOperation.java \
           src/rreil/operation/ShiftRightOperation.java \
           src/rreil/operation/XorOperation.java \
           src/rreil/prim/IPrim.java \
           src/rreil/prim/GenericPrimitive.java \
           src/rreil/prim/FlopPrimitive.java \
           src/rnati/RReilTranslateException.java \
           src/rnati/GdslDecodeException.java \
           src/rnati/NativeInterface.java \
           src/Program.java

SPRE=src
BPRE=build

BDIRS=$(BPRE)
pre-build:
	mkdir -p $(BDIRS)

$(JAR): pre-build $(JSOURCES:%=libs/jrreil/%)
	cd libs/jrreil && javac $(JSOURCES) -d ../../$(BPRE)/
	jar -cf $@ $(JSOURCES:$(SPRE)/%.java=-C $(BPRE) %.class)
endif


if INSTALL_AUXLIBS
lib_LTLIBRARIES += libreadhex.la libutil.la
else
if BUILD_AUXLIBS
noinst_LTLIBRARIES += libreadhex.la libutil.la
endif
endif

if HAVE_X86
if INSTALL_AUXLIBS
lib_LTLIBRARIES += libx86.la libx86-generator.la
else
if BUILD_AUXLIBS
noinst_LTLIBRARIES += libx86.la libx86-generator.la
endif
endif
endif

if X86_RREIL
if INSTALL_AUXLIBS
lib_LTLIBRARIES += libx86-tester.la libgdwrap.la
else
if BUILD_AUXLIBS
noinst_LTLIBRARIES += libx86-tester.la libgdwrap.la
endif
endif
endif

if HAVE_RREIL
if INSTALL_AUXLIBS
lib_LTLIBRARIES += librreil.la
lib_LTLIBRARIES += librreil-sim.la
lib_LTLIBRARIES += libjrreil.la
lib_LTLIBRARIES += libgdsl-multiplex.la
else
if BUILD_AUXLIBS
noinst_LTLIBRARIES += librreil.la
noinst_LTLIBRARIES += librreil-sim.la
noinst_LTLIBRARIES += libjrreil.la
noinst_LTLIBRARIES += libgdsl-multiplex.la
endif
endif
endif

libreadhex_la_SOURCES = libs/readhex/src/readhex.c
libreadhex_la_CFLAGS = -I./libs/readhex/include
include_HEADERS += libs/readhex/include/readhex.h

libutil_la_SOURCES = libs/util/src/util.c libs/util/src/stack.c
libutil_la_CFLAGS = -std=c99 -I./libs/util/include
include_HEADERS += libs/util/include/util.h libs/util/include/stack.h

if HAVE_X86
libx86_la_SOURCES = libs/x86/src/x86.c libs/x86/src/x86_features.c
libx86_la_CFLAGS = -std=c99 -I./libs/x86/include
include_HEADERS += libs/x86/include/x86.h libs/x86/include/x86_features.h
endif

if HAVE_RREIL
librreil_la_SOURCES = libs/rreil/src/rreil/copy.c \
                      libs/rreil/src/rreil/print.c \
                      libs/rreil/src/rreil/gdrr_builder.c \
                      libs/rreil/src/rreil/free.c \
                      libs/rreil/src/rreil/rreil_id.c
librreil_la_CFLAGS = -std=c11 -I./libs/rreil/include -I./libs/gdrr/include -I./libs/util/include
if HAVE_X86
librreil_la_CFLAGS += -DGDSL_X86 -I./libs/x86/include
endif
include_HEADERS += libs/rreil/include/rreil/rreil.h \
                   libs/rreil/include/rreil/rreil_copy.h \
                   libs/rreil/include/rreil/rreil_print.h \
                   libs/rreil/include/rreil/rreil_address.h \
                   libs/rreil/include/rreil/gdrr_builder.h \
                   libs/rreil/include/rreil/rreil_linear.h \
                   libs/rreil/include/rreil/rreil_id.h \
                   libs/rreil/include/rreil/rreil_free.h \
                   libs/rreil/include/rreil/rreil_variable.h \
                   libs/rreil/include/rreil/rreil_variable_limited.h \
                   libs/rreil/include/rreil/rreil_prim.h \
                   libs/rreil/include/rreil/rreil_flop.h \
                   libs/rreil/include/rreil/rreil_comparator.h \
                   libs/rreil/include/rreil/rreil_op.h \
                   libs/rreil/include/rreil/rreil_branch_hint.h \
                   libs/rreil/include/rreil/rreil_sexpr.h \
                   libs/rreil/include/rreil/rreil_arity.h \
                   libs/rreil/include/rreil/rreil_statement.h
endif

if X86_RREIL
librreil_sim_la_SOURCES = libs/rreil-sim/src/simulator/simulator.c \
                      libs/rreil-sim/src/simulator/ops.c \
                      libs/rreil-sim/src/simulator/regacc.c \
                      libs/rreil-sim/src/simulator/tracking.c \
                      libs/rreil-sim/src/memory.c \
                      libs/rreil-sim/src/context.c
librreil_sim_la_CFLAGS = -std=c99 -DGDSL_X86 -I./libs/rreil/include -I./libs/rreil-sim/include -I./libs/gdrr/include -I./libs/util/include -I./libs/x86/include
include_HEADERS += libs/rreil-sim/include/memory.h \
                   libs/rreil-sim/include/simulator/register.h \
                   libs/rreil-sim/include/simulator/tracking.h \
                   libs/rreil-sim/include/simulator/regacc.h \
                   libs/rreil-sim/include/simulator/simulator.h \
                   libs/rreil-sim/include/simulator/ops.h \
                   libs/rreil-sim/include/context.h
endif

if X86_RREIL
libgdwrap_la_SOURCES = libs/gdwrap/src/gdwrap.c
libgdwrap_la_CFLAGS = -I./libs/gdwrap/include
include_HEADERS += libs/gdwrap/include/gdwrap.h
endif

if HAVE_X86
libx86_generator_la_SOURCES = libs/x86-generator/src/generator_tree.c \
                             libs/x86-generator/src/x86_opcodes.c \
                             libs/x86-generator/src/generator.c
libx86_generator_la_CFLAGS = -std=c99 -I./libs/x86-generator/include -I./libs/util/include
include_HEADERS += libs/x86-generator/include/x86_opcodes.h \
                   libs/x86-generator/include/generator_tree.h \
                   libs/x86-generator/include/generator.h
endif

if X86_RREIL
libx86_tester_la_SOURCES = libs/x86-tester/src/executor.c \
                           libs/x86-tester/src/tbgen.c \
                           libs/x86-tester/src/tester.c \
                           libs/x86-tester/src/tbgen_alloc.c
libx86_tester_la_CFLAGS = -std=gnu99 -I./libs/x86-tester/include -I./libs/rreil/include -I./libs/rreil-sim/include -I./libs/x86/include -I./libs/util/include -I./libs/gdrr/include -I./libs/gdwrap/include
include_HEADERS += libs/x86-tester/include/tbgen.h \
                   libs/x86-tester/include/tbgen_alloc.h \
                   libs/x86-tester/include/executor.h \
                   libs/x86-tester/include/tester.h
endif

if HAVE_RREIL
libjrreil_la_SOURCES = libs/jrreil/src/rnati_NativeInterface.c
libjrreil_la_CFLAGS = -std=c99 -I/usr/lib/jvm/java-7-openjdk-amd64/include -I./libs/gdsl-multiplex/include
libjrreil_la_LIBADD += libgdsl-multiplex.la
private_headers += libs/jrreil/src/rnati_NativeInterface.h
endif

if HAVE_RREIL
libgdsl_multiplex_la_SOURCES = libs/gdsl-multiplex/src/gdsl_multiplex.c
libgdsl_multiplex_la_CFLAGS = -I./libs/gdsl-multiplex/include
libgdsl_multiplex_la_LDFLAGS = -ldl
include_HEADERS += libs/gdsl-multiplex/include/gdsl_multiplex.h
endif

if HAVE_RREIL
if INSTALL_AUXBINS
bin_PROGRAMS += decoder-cli
bin_PROGRAMS += semantics-cli
bin_PROGRAMS += semantics-cli-dynamic
bin_PROGRAMS += semantics-cif-cli
bin_PROGRAMS += sweep
else
if BUILD_AUXBINS
noinst_PROGRAMS += decoder-cli
noinst_PROGRAMS += semantics-cli
noinst_PROGRAMS += semantics-cli-dynamic
noinst_PROGRAMS += semantics-cif-cli
noinst_PROGRAMS += sweep
endif
endif
endif

if X86_RREIL
if INSTALL_AUXBINS
bin_PROGRAMS += liveness_sweep
bin_PROGRAMS += x86_test_runner
bin_PROGRAMS += x86_test_stats_runner
else
if BUILD_AUXBINS
noinst_PROGRAMS += liveness_sweep
noinst_PROGRAMS += x86_test_runner
noinst_PROGRAMS += x86_test_stats_runner
endif
endif
endif

decoder_cli_SOURCES = tools/decoder-cli.c
decoder_cli_CFLAGS = -std=c99 -I./libs/readhex/include
if HAVE_X86
decoder_cli_CFLAGS += -DGDSL_X86
endif
decoder_cli_LDADD += libreadhex.la

semantics_cli_SOURCES = tools/semantics-cli.c
semantics_cli_CFLAGS = -std=c99 -I./libs/readhex/include
if HAVE_X86
semantics_cli_CFLAGS += -DGDSL_X86
endif
semantics_cli_LDADD += libreadhex.la

semantics_cli_dynamic_SOURCES = tools/semantics-cli-dynamic.c
semantics_cli_dynamic_CFLAGS = -std=c99 -I./libs/readhex/include -I./libs/gdsl-multiplex/include
semantics_cli_dynamic_LDADD += libreadhex.la libgdsl-multiplex.la

semantics_cif_cli_SOURCES = tools/semantics-cif-cli.c
semantics_cif_cli_CFLAGS = -I./libs/gdrr/include -I./libs/readhex/include
semantics_cif_cli_LDADD += libreadhex.la

sweep_SOURCES = tools/sweep.c
sweep_CFLAGS = 
sweep_LDFLAGS = -lelf

if X86_RREIL
liveness_sweep_SOURCES = tools/liveness-sweep.c
liveness_sweep_CFLAGS = -std=gnu99
liveness_sweep_LDFLAGS = -lelf
endif

if X86_RREIL
x86_test_runner_SOURCES = tools/x86-test-runner/src/main.c
x86_test_runner_CFLAGS = -std=gnu99 -I./libs/rreil/include -I./libs/rreil-sim/include -I./libs/x86/include -I./libs/x86-generator/include -I./libs/x86-tester/include -I./libs/readhex/include
x86_test_runner_LDADD += librreil.la librreil-sim.la libx86-generator.la libx86.la libreadhex.la libutil.la
endif

if X86_RREIL
x86_test_stats_runner_SOURCES = tools/x86-test-stats-runner/src/main.c tools/x86-test-stats-runner/src/hash_array.c
x86_test_stats_runner_CFLAGS = -std=gnu99 -I./libs/rreil/include -I./libs/rreil-sim/include -I./libs/x86/include -I./libs/x86-generator/include -I./libs/x86-tester/include -I./libs/readhex/include
x86_test_stats_runner_LDADD += librreil.la librreil-sim.la libx86-generator.la libx86.la libreadhex.la libutil.la
private_headers += tools/x86-test-stats-runner/src/hash_array.h
endif

RUNTIME =  detail/codegen/c0/runtime.h \
  detail/codegen/c0/runtime.c \
  detail/codegen/c1/runtime.h \
  detail/codegen/c1/runtime.c \
  detail/codegen/js0/runtime.js

EXTRA_DIST = LICENSE $(GDSL_BASIS) $(GDSL_X86) $(GDSL_RREIL) $(GDSL_X86SEM) $(GDSL_AVR) $(GDSL_AVRSEM) $(RUNTIME) $(private_headers) gdsl.h
