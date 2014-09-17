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
nodist_include_HEADERS =

#if X86
#HAVE_X86 = 1
#endif
#if X86_RREIL
#HAVE_X86 = 1
#endif

# we need to add a dependency to the actual backend to this variable
libjgdsl_la_LIBADD = 
libgdsl_multiplex_la_LIBADD = 

#semantics_opt_LDADD = 

private_headers =

# options for the C compiler
AM_CFLAGS = -Wall
#if HAVE_X86
#AM_CFLAGS += -DGDSL_X86
#endif
#if HAVE_AVR
#AM_CFLAGS += -DGDSL_AVR
#endif

# the gdsl compiler

SMLNJ = @SMLNJ@
MLTON = @MLTON@
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
				 $(srcdir)/detail/semantic/typing/type-table.sml \
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

JAR=jgdsl.jar

GDSLC_DEP = detail/codegen/c1/runtime.c detail/codegen/c1/runtime.h
GDSLFLAGS = --runtime=$(srcdir)/detail/codegen @EXTRA_GDSL_FLAGS@

if HAVE_MLTON

$(builddir)/gdslc$(EXEEXT): $(srcdir)/gdslc.mlb $(GDSLC_SML_FILES)
	$(MLTON) -output $(builddir)/gdslc$(EXEEXT) $(srcdir)/gdslc.mlb

GDSLC_DEP += $(builddir)/gdslc$(EXEEXT)
GDSLC = $(builddir)/gdslc$(EXEEXT)

else

$(builddir)/gdslc-image: $(srcdir)/gdsl.cm $(GDSLC_SML_FILES)
	echo 'CM.make("'$(srcdir)/gdsl.cm'"); SMLofNJ.exportFn ("'$@'",Main.njMain);' | $(SMLNJ)
	cd $(builddir) && rm -f gdslc-image && $(LN_S) $@.* gdslc-image

CLEANFILES += $(builddir)/gdslc-image
GDSLC_DEP += $(builddir)/gdslc-image

GDSLC = $(SMLNJ) @SMLload=$(builddir)/gdslc-image

endif


RUNTIME =  $(srcdir)/detail/codegen/c0/runtime.h \
  $(srcdir)/detail/codegen/c0/runtime.c \
  $(srcdir)/detail/codegen/c1/runtime.h \
  $(srcdir)/detail/codegen/c1/runtime.c \
  $(srcdir)/detail/codegen/js0/runtime.js

%.l.sml	: %.l
	$(MLULEX) $<

%.g.sml	: %.g
	$(MLANTLR) $<

# the decoders

GDSL_BASIS = \
	$(srcdir)/specifications/basis/prelude.ml \
	$(srcdir)/specifications/basis/tree-set.ml \
	$(srcdir)/specifications/basis/bbtree.ml

GDSL_ASM = \
	$(srcdir)/specifications/asm/asm-cif.ml \
	$(srcdir)/specifications/asm/asm.ml \
	$(srcdir)/specifications/asm/asm-pretty.ml

GDSL_X86 = \
	$(srcdir)/specifications/x86/x86.ml \
	$(srcdir)/specifications/x86/x86-traverse.ml \
	$(srcdir)/specifications/x86/x86-pretty.ml \
	$(srcdir)/specifications/x86/x86-asm.ml \
	$(srcdir)/specifications/x86/x86-semantics-mapping.ml \
	$(srcdir)/specifications/x86/x86-semantics-mapping-pretty.ml

GDSL_X86SEM = \
	$(srcdir)/specifications/x86/x86-rreil-translator.ml \
	$(srcdir)/specifications/x86/x86-rreil-translator-a-l.ml \
	$(srcdir)/specifications/x86/x86-rreil-translator-m-z.ml \
	$(srcdir)/specifications/x86/x86-liveness.ml

GDSL_AVR = \
	$(srcdir)/specifications/avr/avr.ml \
	$(srcdir)/specifications/avr/avr-asm.ml \
	$(srcdir)/specifications/avr/avr-traverse.ml \
	$(srcdir)/specifications/avr/avr-pretty.ml

GDSL_AVRSEM = \
	$(srcdir)/specifications/avr/avr-rreil-translator.ml \
	$(srcdir)/specifications/avr/avr-rreil-registermapping.ml \
	$(srcdir)/specifications/avr/avr-rreil-pretty.ml \
	$(srcdir)/specifications/avr/avr-liveness.ml

GDSL_MIPS = \
	$(srcdir)/specifications/mips/mips.ml \
	$(srcdir)/specifications/mips/mips-asm.ml \
	$(srcdir)/specifications/mips/mips-traverse.ml \
	$(srcdir)/specifications/mips/mips-pretty.ml

GDSL_MIPSSEM = \
	$(srcdir)/specifications/mips/mips-rreil-translator.ml \
	$(srcdir)/specifications/mips/mips-rreil-registermapping.ml \
	$(srcdir)/specifications/mips/mips-rreil-pretty.ml \
	$(srcdir)/specifications/mips/mips-liveness.ml

GDSL_RREIL = \
	$(srcdir)/specifications/rreil/fmap.ml \
	$(srcdir)/specifications/rreil/rreil.ml \
	$(srcdir)/specifications/rreil/rreil-examples.ml \
	$(srcdir)/specifications/rreil/rreil-cif.ml \
	$(srcdir)/specifications/rreil/rreil-pretty.ml \
	$(srcdir)/specifications/rreil/rreil-liveness.ml \
	$(srcdir)/specifications/rreil/rreil-forward-subst.ml \
	$(srcdir)/specifications/rreil/rreil-cleanup.ml \
  $(srcdir)/specifications/rreil/rreil-opt.ml \
  $(srcdir)/specifications/rreil/rreil-translator.ml

GDSL_ARM7 = \
	$(srcdir)/specifications/arm7/arm7.ml \
	$(srcdir)/specifications/arm7/arm7-pretty.ml
#	$(srcdir)/specifications/arm7/arm7-asm.ml

if X86_RREIL
lib_LTLIBRARIES += libgdsl-x86-rreil.la
nodist_include_HEADERS += gdsl-x86-rreil.h
#libjgdsl_la_LIBADD += libgdsl-x86-rreil.la
#semantics_opt_LDADD += libgdsl-x86-rreil.la
CLEANFILES += gdsl-x86-rreil.c gdsl-x86-rreil.h
if INSTALL_AUXBINS
bin_PROGRAMS += gdsl-x86-rreil-demo
endif
if BUILD_AUXBINS
noinst_PROGRAMS += gdsl-x86-rreil-demo
endif
endif
libgdsl_x86_rreil_la_SOURCES =
nodist_libgdsl_x86_rreil_la_SOURCES = gdsl-x86-rreil.c
libgdsl_x86_rreil_la_DEPENDENCIES = $(GDSLC_DEP)
gdsl_x86_rreil_demo_SOURCES = gdsl-x86-rreil.c
gdsl_x86_rreil_demo_CFLAGS = -std=c99 -DWITHMAIN

GS_X86_RREIL = $(GDSL_BASIS) $(GDSL_ASM) $(GDSL_X86) $(GDSL_RREIL) $(GDSL_X86SEM)
gdsl-x86-rreil.c: $(GDSLC_DEP) $(GS_X86_RREIL)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(GS_X86_RREIL)

if X86
lib_LTLIBRARIES += libgdsl-x86.la
#decoder_cli_LDADD += libgdsl-x86.la
nodist_include_HEADERS += gdsl-x86.h
CLEANFILES += gdsl-x86.c gdsl-x86.h
if INSTALL_AUXBINS
bin_PROGRAMS += gdsl-x86-demo
endif
if BUILD_AUXBINS
noinst_PROGRAMS += gdsl-x86-demo
endif
endif
libgdsl_x86_la_SOURCES =
nodist_libgdsl_x86_la_SOURCES = gdsl-x86.c
libgdsl_x86_la_DEPENDENCIES = $(GDSLC_DEP)
gdsl_x86_demo_SOURCES = gdsl-x86.c
gdsl_x86_demo_CFLAGS = -std=c99 -DWITHMAIN

GS_X86 = $(GDSL_BASIS) $(GDSL_ASM) $(GDSL_X86)
gdsl-x86.c: $(GDSLC_DEP) $(GS_X86)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(GS_X86)

if AVR_RREIL
lib_LTLIBRARIES += libgdsl-avr-rreil.la
#libjgdsl_la_LIBADD += libgdsl-avr-rreil.la
#semantics_opt_LDADD += libgdsl-avr-rreil.la
nodist_include_HEADERS += gdsl-avr-rreil.h
CLEANFILES += gdsl-avr-rreil.c gdsl-avr-rreil.h
if INSTALL_AUXBINS
bin_PROGRAMS += gdsl-avr-rreil-demo
endif
if BUILD_AUXBINS
noinst_PROGRAMS += gdsl-avr-rreil-demo
endif
endif
libgdsl_avr_rreil_la_SOURCES =
nodist_libgdsl_avr_rreil_la_SOURCES = gdsl-avr-rreil.c
libgdsl_avr_rreil_la_DEPENDENCIES = $(GDSLC_DEP)
gdsl_avr_rreil_demo_SOURCES = gdsl-avr-rreil.c
gdsl_avr_rreil_demo_CFLAGS = -std=c99 -DWITHMAIN

GS_AVR_RREIL =  $(GDSL_BASIS) $(GDSL_ASM) $(GDSL_AVR) $(GDSL_RREIL) $(GDSL_AVRSEM)
gdsl-avr-rreil.c: $(GDSLC_DEP) $(GS_AVR_RREIL)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(GS_AVR_RREIL)

if AVR
lib_LTLIBRARIES += libgdsl-avr.la
#decoder_cli_LDADD += libgdsl-avr.la
nodist_include_HEADERS += gdsl-avr.h
CLEANFILES += gdsl-avr.c gdsl-avr.h
if INSTALL_AUXBINS
bin_PROGRAMS += gdsl-avr-demo
endif
if BUILD_AUXBINS
noinst_PROGRAMS += gdsl-avr-demo
endif
endif
libgdsl_avr_la_SOURCES =
nodist_libgdsl_avr_la_SOURCES = gdsl-avr.c
libgdsl_avr_la_DEPENDENCIES = $(GDSLC_DEP)
gdsl_avr_demo_SOURCES = gdsl-avr.c
gdsl_avr_demo_CFLAGS = -std=c99 -DWITHMAIN

GS_AVR = $(GDSL_BASIS) $(GDSL_ASM) $(GDSL_AVR)
gdsl-avr.c: $(GDSLC_DEP) $(GS_AVR)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(GS_AVR)

if MIPS_RREIL
lib_LTLIBRARIES += libgdsl-mips-rreil.la
#libjgdsl_la_LIBADD += libgdsl-mips-rreil.la
#semantics_opt_LDADD += libgdsl-mips-rreil.la
nodist_include_HEADERS += gdsl-mips-rreil.h
CLEANFILES += gdsl-mips-rreil.c gdsl-mips-rreil.h
if INSTALL_AUXBINS
bin_PROGRAMS += gdsl-mips-rreil-demo
endif
if BUILD_AUXBINS
noinst_PROGRAMS += gdsl-mips-rreil-demo
endif
endif
libgdsl_mips_rreil_la_SOURCES =
nodist_libgdsl_mips_rreil_la_SOURCES = gdsl-mips-rreil.c
libgdsl_mips_rreil_la_DEPENDENCIES = $(GDSLC_DEP)
gdsl_mips_rreil_demo_SOURCES = gdsl-mips-rreil.c
gdsl_mips_rreil_demo_CFLAGS = -std=c99 -DWITHMAIN

GS_MIPS_RREIL =  $(GDSL_BASIS) $(GDSL_ASM) $(GDSL_MIPS) $(GDSL_RREIL) $(GDSL_MIPSSEM)
gdsl-mips-rreil.c: $(GDSLC_DEP) $(GS_MIPS_RREIL)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(GS_MIPS_RREIL)

if MIPS
lib_LTLIBRARIES += libgdsl-mips.la
#decoder_cli_LDADD += libgdsl-mips.la
nodist_include_HEADERS += gdsl-mips.h
CLEANFILES += gdsl-mips.c gdsl-mips.h
if INSTALL_AUXBINS
bin_PROGRAMS += gdsl-mips-demo
endif
if BUILD_AUXBINS
noinst_PROGRAMS += gdsl-mips-demo
endif
endif
libgdsl_mips_la_SOURCES =
nodist_libgdsl_mips_la_SOURCES = gdsl-mips.c
libgdsl_mips_la_DEPENDENCIES = $(GDSLC_DEP)
gdsl_mips_demo_SOURCES = gdsl-mips.c
gdsl_mips_demo_CFLAGS = -std=c99 -DWITHMAIN

GS_MIPS = $(GDSL_BASIS) $(GDSL_ASM) $(GDSL_MIPS)
gdsl-mips.c: $(GDSLC_DEP) $(GS_MIPS)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(GS_MIPS)

if ARM7 
lib_LTLIBRARIES += libgdsl-arm7.la
nodist_include_HEADERS += gdsl-arm7.h
CLEANFILES += gdsl-arm7.c gdsl-arm7.h
if INSTALL_AUXBINS
bin_PROGRAMS += gdsl-arm7-demo
endif
if BUILD_AUXBINS
noinst_PROGRAMS += gdsl-arm7-demo
endif
endif
libgdsl_arm7_la_SOURCES =
nodist_libgdsl_arm7_la_SOURCES = gdsl-arm7.c
libgdsl_arm7_la_DEPENDENCIES = $(GDSLC_DEP)
gdsl_arm7_demo_SOURCES = gdsl-arm7.c
gdsl_arm7_demo_CFLAGS = -std=c99 -DWITHMAIN

GS_ARM7 = $(GDSL_BASIS) $(GDSL_ARM7)
gdsl-arm7.c: $(GDSLC_DEP) $(GS_ARM7)
	$(GDSLC) -o $(basename $@) $(GDSLFLAGS) $(GS_ARM7)

JSOURCES = src/gdsl/BareFrontend.java \
src/gdsl/translator/Translator.java \
src/gdsl/translator/TranslatedBlock.java \
src/gdsl/translator/TranslatedBlockRaw.java \
src/gdsl/translator/SemPres.java \
src/gdsl/translator/RReilTranslateException.java \
src/gdsl/ReferenceManager.java \
src/gdsl/HeapExpiredException.java \
src/gdsl/rreil/IBranchHint.java \
src/gdsl/rreil/BranchHint.java \
src/gdsl/rreil/DefaultLimitedVariableCollection.java \
src/gdsl/rreil/LimitedVariable.java \
src/gdsl/rreil/exception/Exception.java \
src/gdsl/rreil/exception/GenericArchException.java \
src/gdsl/rreil/exception/x86/X86Exception.java \
src/gdsl/rreil/exception/IException.java \
src/gdsl/rreil/IVariable.java \
src/gdsl/rreil/statement/LoadStatement.java \
src/gdsl/rreil/statement/IStatement.java \
src/gdsl/rreil/statement/FlopStatement.java \
src/gdsl/rreil/statement/ConditionalBranchStatement.java \
src/gdsl/rreil/statement/StoreStatement.java \
src/gdsl/rreil/statement/BranchStatement.java \
src/gdsl/rreil/statement/AssignStatement.java \
src/gdsl/rreil/statement/Statement.java \
src/gdsl/rreil/statement/PrimitiveStatement.java \
src/gdsl/rreil/statement/IfThenElseStatement.java \
src/gdsl/rreil/statement/ThrowStatement.java \
src/gdsl/rreil/statement/WhileStatement.java \
src/gdsl/rreil/expression/CompareLessOrEqualUnsigned.java \
src/gdsl/rreil/expression/Extend.java \
src/gdsl/rreil/expression/CompareLessUnsigned.java \
src/gdsl/rreil/expression/Compare.java \
src/gdsl/rreil/expression/ShiftLeft.java \
src/gdsl/rreil/expression/Xor.java \
src/gdsl/rreil/expression/CompareLessSigned.java \
src/gdsl/rreil/expression/ICompare.java \
src/gdsl/rreil/expression/SignExtend.java \
src/gdsl/rreil/expression/Simple.java \
src/gdsl/rreil/expression/SignedModulo.java \
src/gdsl/rreil/expression/CompareEqual.java \
src/gdsl/rreil/expression/Multiplication.java \
src/gdsl/rreil/expression/ShiftRightSigned.java \
src/gdsl/rreil/expression/ZeroExtend.java \
src/gdsl/rreil/expression/CompareNotEqual.java \
src/gdsl/rreil/expression/Binary.java \
src/gdsl/rreil/expression/Or.java \
src/gdsl/rreil/expression/Modulo.java \
src/gdsl/rreil/expression/Division.java \
src/gdsl/rreil/expression/IExpression.java \
src/gdsl/rreil/expression/Unary.java \
src/gdsl/rreil/expression/And.java \
src/gdsl/rreil/expression/SignedDivision.java \
src/gdsl/rreil/expression/ShiftRight.java \
src/gdsl/rreil/expression/Expression.java \
src/gdsl/rreil/expression/CompareLessOrEqualSigned.java \
src/gdsl/rreil/IRReilCollection.java \
src/gdsl/rreil/sexpression/SimpleCompareExpression.java \
src/gdsl/rreil/sexpression/Arbitrary.java \
src/gdsl/rreil/sexpression/SimpleLinearExpression.java \
src/gdsl/rreil/sexpression/SimpleExpression.java \
src/gdsl/rreil/sexpression/ISimpleExpression.java \
src/gdsl/rreil/linear/LinearImmediateExpression.java \
src/gdsl/rreil/linear/LinearExpression.java \
src/gdsl/rreil/linear/LinearAdditionExpression.java \
src/gdsl/rreil/linear/ILinearExpression.java \
src/gdsl/rreil/linear/LinearVariableExpression.java \
src/gdsl/rreil/linear/LinearScaleExpression.java \
src/gdsl/rreil/linear/LinearBinaryExpression.java \
src/gdsl/rreil/linear/LinearSubtractionExpression.java \
src/gdsl/rreil/IFlop.java \
src/gdsl/rreil/Flop.java \
src/gdsl/rreil/ILimitedVariable.java \
src/gdsl/rreil/IAddress.java \
src/gdsl/rreil/Variable.java \
src/gdsl/rreil/IRReilBuilder.java \
src/gdsl/rreil/DefaultRReilBuilder.java \
src/gdsl/rreil/id/VirtualLessSignedId.java \
src/gdsl/rreil/id/VirtualLessUnsignedId.java \
src/gdsl/rreil/id/IId.java \
src/gdsl/rreil/id/VirtualEqualsNotId.java \
src/gdsl/rreil/id/VirtualLessOrEqualSignedId.java \
src/gdsl/rreil/id/x86/X86RegisterId.java \
src/gdsl/rreil/id/x86/X86Register.java \
src/gdsl/rreil/id/FloatingFlags.java \
src/gdsl/rreil/id/Id.java \
src/gdsl/rreil/id/VirtualLessOrEqualUnsignedId.java \
src/gdsl/rreil/id/ArchRegister.java \
src/gdsl/rreil/id/VirtualEqualsId.java \
src/gdsl/rreil/id/VirtualTemporaryId.java \
src/gdsl/rreil/Address.java \
src/gdsl/rreil/DefaultStatementCollection.java \
src/gdsl/rreil/BuilderBackend.java \
src/gdsl/decoder/OperandType.java \
src/gdsl/decoder/GdslDecodeException.java \
src/gdsl/decoder/Decoder.java \
src/gdsl/decoder/OperandTypeVisitor.java \
src/gdsl/decoder/NativeInstruction.java \
src/gdsl/IFrontendConfig.java \
src/gdsl/arch/X86ConfigFlag.java \
src/gdsl/arch/ArchId.java \
src/gdsl/arch/IConfigFlag.java \
src/gdsl/arch/AVRBinder.java \
src/gdsl/arch/MIPSBinder.java \
src/gdsl/arch/X86Binder.java \
src/gdsl/arch/ArchBinder.java \
src/gdsl/HeapUseIndicator.java \
src/gdsl/Frontend.java \
src/gdsl/Gdsl.java \
src/gdsl/IReferable.java \
src/gdsl/GdslException.java \
src/gdsl/asm/Visitor.java \
src/gdsl/asm/Signedness.java \
src/gdsl/asm/Instruction.java \
src/gdsl/asm/operand/PreOperation.java \
src/gdsl/asm/operand/Immediate.java \
src/gdsl/asm/operand/PostOperation.java \
src/gdsl/asm/operand/Register.java \
src/gdsl/asm/operand/Bounded.java \
src/gdsl/asm/operand/Relative.java \
src/gdsl/asm/operand/Scale.java \
src/gdsl/asm/operand/Sign.java \
src/gdsl/asm/operand/Sum.java \
src/gdsl/asm/operand/Annotated.java \
src/gdsl/asm/operand/Memory.java \
src/gdsl/asm/operand/Composite.java \
src/gdsl/asm/operand/Operand.java \
src/gdsl/asm/annotation/OperandAnnotation.java \
src/gdsl/asm/annotation/StringAnnotation.java \
src/gdsl/asm/annotation/Annotation.java \
src/gdsl/asm/annotation/FunctionAnnotation.java \
src/gdsl/asm/GeneralizerBackend.java \
src/gdsl/asm/boundary/SizeBoundary.java \
src/gdsl/asm/boundary/SizeOffsetBoundary.java \
src/gdsl/asm/boundary/Boundary.java \
src/gdsl/ResourceUnavailableException.java \
src/gdsl/ListFrontend.java

JSOURCES_FULLPATH=$(JSOURCES:%=$(srcdir)/libs/jgdsl/%)

SPRE=src
BPRE=$(top_builddir)/build

BDIRS=$(BPRE)
pre-build:
	mkdir -p $(BDIRS)

$(JAR): pre-build $(JSOURCES_FULLPATH)
	ABS_DST=$$(pwd)/$(BPRE) && cd $(srcdir)/libs/jgdsl && javac -cp . $(JSOURCES) -d $$ABS_DST/
	jar -cf $@ $(JSOURCES:$(SPRE)/%.java=-C $(BPRE) %.class)

#$(JAR): pre-build $(JSOURCES:%=libs/jgdsl/%)
#	ABS_DST=$$(pwd)/$(BPRE) && cd $(srcdir)/libs/jgdsl && javac -cp /usr/share/java/junit4.jar:. $(JSOURCES) -d $$ABS_DST/
#	jar -cf $@ $(JSOURCES:$(SPRE)/%.java=-C $(BPRE) %.class)

CLEANFILES += $(builddir)/gdslc$(EXEEXT) $(builddir)/jgdsl.jar

clean-local:
	-rm -rf build/
	-rm -f $(builddir)/gdslc-image.*

if INSTALL_AUXLIBS
if HAVE_GDSL_MULTIPLEX
if HAVE_RREIL
lib_LTLIBRARIES += libgdsl-multiplex.la
endif
endif
if HAVE_JGDSL
if HAVE_RREIL
lib_LTLIBRARIES += libjgdsl.la
endif
endif
if HAVE_MEMSTREAM
lib_LTLIBRARIES += libmemstream.la
endif
endif

if BUILD_AUXLIBS
if HAVE_GDSL_MULTIPLEX
if HAVE_RREIL
noinst_LTLIBRARIES += libgdsl-multiplex.la
endif
endif
if HAVE_JGDSL
if HAVE_RREIL
noinst_LTLIBRARIES += libjgdsl.la
endif
endif
if HAVE_MEMSTREAM
noinst_LTLIBRARIES += libmemstream.la
endif
endif

libgdsl_multiplex_la_SOURCES = $(srcdir)/libs/gdsl-multiplex/src/gdsl_multiplex.c
libgdsl_multiplex_la_CFLAGS = -std=c99 -I$(srcdir)/libs/gdsl-multiplex/include
libgdsl_multiplex_la_LDFLAGS = -ldl
include_HEADERS += $(srcdir)/libs/gdsl-multiplex/include/gdsl_multiplex.h $(srcdir)/libs/gdsl-multiplex/include/gdsl_generic.h
if HAVE_MEMSTREAM
libgdsl_multiplex_la_CFLAGS += -include$(srcdir)/libs/memstream/include/memstream.h
libgdsl_multiplex_la_LIBADD += libmemstream.la
endif

libjgdsl_la_SOURCES = $(srcdir)/libs/jgdsl/src/gdsl_rreil_BuilderBackend.c $(srcdir)/libs/jgdsl/src/gdsl_Gdsl.c $(srcdir)/libs/jgdsl/src/gdsl_decoder_NativeInstruction.c $(srcdir)/libs/jgdsl/src/gdsl_asm_GeneralizerBackend.c $(srcdir)/libs/jgdsl/src/gdsl_Frontend.c $(srcdir)/libs/jgdsl/src/gdsl_BareFrontend.c $(srcdir)/libs/jgdsl/src/gdsl_ListFrontend.c $(srcdir)/libs/jgdsl/src/util.c
libjgdsl_la_CFLAGS = -std=c99 -I/usr/lib/jvm/java-7-openjdk-amd64/include -I$(srcdir)/libs/gdsl-multiplex/include
libjgdsl_la_LIBADD += libgdsl-multiplex.la jgdsl.jar

private_headers += $(srcdir)/libs/jgdsl/src/gdsl_asm_GeneralizerBackend.h $(srcdir)/libs/jgdsl/src/gdsl_BareFrontend.h $(srcdir)/libs/jgdsl/src/gdsl_decoder_NativeInstruction.h $(srcdir)/libs/jgdsl/src/gdsl_Frontend.h $(srcdir)/libs/jgdsl/src/gdsl_Gdsl.h $(srcdir)/libs/jgdsl/src/gdsl_ListFrontend.h $(srcdir)/libs/jgdsl/src/gdsl_rreil_BuilderBackend.h $(srcdir)/libs/jgdsl/src/util.h

if HAVE_MEMSTREAM
libmemstream_la_SOURCES = $(srcdir)/libs/memstream/src/memstream.c
libmemstream_la_CFLAGS = -I$(srcdir)/libs/memstream/include
include_HEADERS += $(srcdir)/libs/memstream/include/memstream.h
endif

if INSTALL_AUXBINS
#if HAVE_DECODER_CLI
#bin_PROGRAMS += decoder-cli
#endif
#if HAVE_SEMANTICS_CLI
#bin_PROGRAMS += semantics-cli
#endif
endif

if BUILD_AUXBINS
#if HAVE_DECODER_CLI
#noinst_PROGRAMS += decoder-cli
#endif
endif

#if X86_RREIL
private_headers += $(srcdir)/tools/x86-test-stats-runner/src/hash_array.h
#endif

MLLPT_LIB = $(srcdir)/detail/external/mllpt-lib/repair.sml $(srcdir)/detail/external/mllpt-lib/NJ-LICENSE $(srcdir)/detail/external/mllpt-lib/stream-pos.sml $(srcdir)/detail/external/mllpt-lib/ml-lpt-lib.cm $(srcdir)/detail/external/mllpt-lib/mllpt-lib.mlb $(srcdir)/detail/external/mllpt-lib/err-handler.sml $(srcdir)/detail/external/mllpt-lib/MLton-LICENSE $(srcdir)/detail/external/mllpt-lib/ulex-buffer.sml $(srcdir)/detail/external/mllpt-lib/ml-lpt-lib.mlb $(srcdir)/detail/external/mllpt-lib/wrapped-strm.sml $(srcdir)/detail/external/mllpt-lib/antlr-tokens-sig.sml $(srcdir)/detail/external/mllpt-lib/antlr-lexer-sig.sml $(srcdir)/detail/external/mllpt-lib/ebnf.sml

EXTRA_DIST = LICENSE $(JSOURCES_FULLPATH) $(MLLPT_LIB) $(GDSL_BASIS) $(GDSL_ASM) $(GDSL_X86) $(GDSL_RREIL) $(GDSL_X86SEM) $(GDSL_AVR) $(GDSL_AVRSEM) $(GDSL_MIPS) $(GDSL_MIPSSEM) $(GDSL_ARM7) $(private_headers) $(RUNTIME) $(srcdir)/gdsl.h $(srcdir)/gdslc.mlb $(srcdir)/gdsl.cm $(GDSLC_SML_FILES) $(srcdir)/detail/ml/smlnj/unsealed.cm build.bat

WINDOWS_DISTFILES = $(GDSLC) LICENSE $(GDSL_BASIS) $(GDSL_ASM) $(GDSL_X86) $(GDSL_RREIL) $(GDSL_X86SEM) $(GDSL_AVR) $(GDSL_AVRSEM) $(GDSL_MIPS) $(GDSL_MIPSSEM) $(GDSL_ARM7) $(RUNTIME) build.bat

# distribution .tgz file for Windows
.PHONY: win-distdir win-dist

# this ugly stuff is copied from what automake generates
win-distdir: $(WINDOWS_DISTFILES)
	$(am__remove_distdir)
	test -d "$(distdir)" || mkdir "$(distdir)"
	@srcdirstrip=`echo "$(srcdir)" | sed 's/[].[^$$\\*]/\\\\&/g'`; \
	topsrcdirstrip=`echo "$(top_srcdir)" | sed 's/[].[^$$\\*]/\\\\&/g'`; \
	list='$(WINDOWS_DISTFILES)'; \
	  dist_files=`for file in $$list; do echo $$file; done | \
	  sed -e "s|^$$srcdirstrip/||;t" \
	      -e "s|^$$topsrcdirstrip/|$(top_builddir)/|;t"`; \
	case $$dist_files in \
	  */*) $(MKDIR_P) `echo "$$dist_files" | \
			   sed '/\//!d;s|^|$(distdir)/|;s,/[^/]*$$,,' | \
			   sort -u` ;; \
	esac; \
	for file in $$dist_files; do \
	  if test -f $$file || test -d $$file; then d=.; else d=$(srcdir); fi; \
	  if test -d $$d/$$file; then \
	    dir=`echo "/$$file" | sed -e 's,/[^/]*$$,,'`; \
	    if test -d "$(distdir)/$$file"; then \
	      find "$(distdir)/$$file" -type d ! -perm -700 -exec chmod u+rwx {} \;; \
	    fi; \
	    if test -d $(srcdir)/$$file && test $$d != $(srcdir); then \
	      cp -fpR $(srcdir)/$$file "$(distdir)$$dir" || exit 1; \
	      find "$(distdir)/$$file" -type d ! -perm -700 -exec chmod u+rwx {} \;; \
	    fi; \
	    cp -fpR $$d/$$file "$(distdir)$$dir" || exit 1; \
	  else \
	    test -f "$(distdir)/$$file" \
	    || cp -p $$d/$$file "$(distdir)/$$file" \
	    || exit 1; \
	  fi; \
	done
	-test -n "$(am__skip_mode_fix)" \
	|| find "$(distdir)" -type d ! -perm -755 \
		-exec chmod u+rwx,go+rx {} \; -o \
	  ! -type d ! -perm -444 -links 1 -exec chmod a+r {} \; -o \
	  ! -type d ! -perm -400 -exec chmod a+r {} \; -o \
	  ! -type d ! -perm -444 -exec $(install_sh) -c -m a+r {} {} \; \
	|| chmod -R a+r "$(distdir)"


win-dist : win-distdir
	$(STRIP) $(GDSLC)
	-rm -f win-$(distdir).zip
	zip -rq win-$(distdir).zip $(distdir)
	$(am__remove_distdir)
