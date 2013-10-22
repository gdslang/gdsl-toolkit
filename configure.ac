dnl configure file for the GDSL compiler and the decoders shipped with it
AC_INIT([gdsl], [0.9.0], [http://code.google.com/p/gdsl-toolkit/], [gdsl-toolkit])

AM_INIT_AUTOMAKE([no-dependencies -Wall foreign no-define])

AC_CONFIG_MACRO_DIR([m4])
AC_CONFIG_SRCDIR([LICENSE])

AM_PROG_CC_C_O()
AM_PROG_AR()
AC_PROG_LN_S()
AC_PROG_LIBTOOL()
AC_PROG_INSTALL()

AC_ARG_VAR(SMLNJ)
AC_PATH_PROG(SMLNJ, sml, ["not-found"])

if test [$SMLNJ == "not-found"]; then
    echo "You must install SML/NJ."
    exit 1
fi

AC_ARG_VAR(MLULEX)
AC_PATH_PROG(MLULEX, ml-ulex, ["not-found"])

if test [$MLULEX == "not-found"]; then
    echo "You must install SML/NJ (to get ml-ulex)."
    exit 1
fi

AC_ARG_VAR(MLANTLR)
AC_PATH_PROG(MLANTLR, ml-antlr, ["not-found"])

if test [$MLANTLR == "not-found"]; then
    echo "You must install SML/NJ (to get ml-antlr)."
    exit 1
fi

dnl define a variable that helps us to only build Linux-specific stuff on Linux
case "$host_os" in
  *linux* )
    LINUX=yes;;
  *)
    LINUX=no;;
esac
AM_CONDITIONAL(LINUX, test "$LINUX" = "yes")

#AC_CHECK_HEADERS_ONCE(jni.h)
#AM_CONDITIONAL(HAVE_JNI_H, test "$HAVE_JNI_H" != "")
dnl conditionals for the various decoders, either with or without semantics

FRONTENDS="x86 x86-rreil avr avr-rreil";

AC_ARG_WITH([frontend],
  [AS_HELP_STRING(
    [--with-frontend=frontend],
    [one of: ]$FRONTENDS)],
  [], [with_frontend=x86-rreil])

case $with_frontend in
	x86)
		AC_DEFINE([USE_X86],[1],[build x86 bare decoder])
	 	with_frontend=x86;;
	x86-rreil)
		AC_DEFINE([USE_X86_RREIL],[1],[build x86 decoder and RReil semantics])
		with_frontend=x86-rreil;;
	avr)
		AC_DEFINE([USE_AVR],[1],[build AVR bare decoder])
		with_frontend=avr;;
	avr-rreil)
		AC_DEFINE([USE_AVR_RREIL],[1],[build AVR decoder and RReil semantics])
		with_frontend=avr-rreil;;
	*) AC_MSG_FAILURE([invalid frontend, choose one of ]$FRONTENDS);;
esac
case $with_frontend in
	*-rreil) has_rreil=yes;;
	*) has_rreil=no;;
esac
case $with_frontend in
	x86*) has_x86=yes;;
	*) has_x86=no;;
esac

AC_MSG_CHECKING([whether C structs may contain anonymous members])
AC_COMPILE_IFELSE([AC_LANG_PROGRAM(
    [[;]],
    [[struct inge { union { int a; int b }; }; struct inge i; i.a = 42;]])], [has_anon_members=yes],
    has_anon_members=no)
AC_MSG_RESULT($has_anon_members)

AC_MSG_CHECKING([whether the open_memstream() is available])
AC_LINK_IFELSE(
    [AC_LANG_PROGRAM([[#include <stdio.h>]],
        [[char *c; size_t s; FILE *f = open_memstream(&c, &s);]])],
    [AC_MSG_RESULT([yes])
        has_open_memstream=1;],
    [AC_MSG_RESULT([no])
        LIBS=$OLD_LIBS; dnl reset to old value since XXX was not found
        has_open_memstream=0;])

AC_CHECK_HEADERS([gelf.h], [has_elf=yes], [has_elf=no])
AC_CHECK_HEADERS([jni.h], [has_jni=yes], [has_jni=no])
AC_CHECK_HEADERS([stdint-gcc.h], [has_stdint_gcc=yes], [has_stdint_gcc=no])

AM_CONDITIONAL([X86_RREIL],[test x$with_frontend = xx86-rreil])
AM_CONDITIONAL([X86],[test x$with_frontend = xx86])
AM_CONDITIONAL([AVR_RREIL],[test x$with_frontend = xavr-rreil])
AM_CONDITIONAL([AVR],[test x$with_frontend = xavr])
AM_CONDITIONAL([HAVE_RREIL],[test x$has_rreil = xyes])
AM_CONDITIONAL([HAVE_X86], [test x$has_x86 = xyes])
#AM_CONDITIONAL([HAVE_GNU_C11], [echo "int main(void) { return 0; }" | gcc -std=gnu11 -xc - -o /dev/null])
#AM_CONDITIONAL([HAVE_POSIX200809], [test `getconf _POSIX_VERSION` -ge 200809 >/dev/null 2>&1])
AM_CONDITIONAL([HAVE_ANON_MEMBERS], [test x$has_anon_members = xyes])
AM_CONDITIONAL([HAVE_OPEN_MEMSTREAM], [test x$has_open_memstream = xyes])
AM_CONDITIONAL([HAVE_POSIX200809_C11], [test x$has_anon_members = xyes && test x$has_open_memstream = xyes])
AM_CONDITIONAL([HAVE_STDINT_GCC], [test x$has_stdint_gcc = xyes])
AM_CONDITIONAL([HAVE_ELF], [test x$has_elf = xyes])

#AM_COND_IF([HAVE_RREIL], [AM_COND_IF([HAVE_POSIX200809_C11], [has_semantics_cli=yes], [has_semantics_cli=yes])])
#AM_COND_IF([HAVE_RREIL], [AM_COND_IF([HAVE_POSIX200809_C11], [AM_CONDITIONAL([HAVE_SEMANTICS_CLI], true)], [AM_CONDITIONAL([HAVE_SEMANTICS_CLI], true)])])

#Library requirements
AM_CONDITIONAL([ENV_RREIL_LIB], false)
AM_CONDITIONAL([ENV_RREIL_SIM], false)
AM_CONDITIONAL([ENV_GDWRAP], false)
AM_CONDITIONAL([ENV_GDSL_MULTIPLEX], false)
AM_CONDITIONAL([ENV_JRREIL], false)
AM_CONDITIONAL([ENV_X86_LIB], false)
AM_CONDITIONAL([ENV_READHEX], false)
AM_CONDITIONAL([ENV_UTIL], false)
AM_CONDITIONAL([ENV_X86_TESTER], false)
AM_CONDITIONAL([ENV_X86_GENERATOR], false)

AM_CONDITIONAL([ENV_UTIL], true)
AM_CONDITIONAL([ENV_GDSL_MULTIPLEX], true)
AM_CONDITIONAL([ENV_GDWRAP], true)
AM_CONDITIONAL([ENV_READHEX], true)
AM_COND_IF([HAVE_RREIL], [AM_COND_IF([HAVE_ANON_MEMBERS], [AM_COND_IF([HAVE_POSIX200809_C11], [AM_CONDITIONAL([ENV_RREIL_LIB], true)])])])
AM_CONDITIONAL([ENV_JRREIL], [test x$has_jni = xyes])
AM_COND_IF([HAVE_X86], [AM_CONDITIONAL([ENV_X86_LIB], true)])
AM_COND_IF([X86_RREIL], [AM_COND_IF([HAVE_ANON_MEMBERS], [AM_COND_IF([HAVE_POSIX200809_C11], [AM_COND_IF([HAVE_STDINT_GCC], [AM_CONDITIONAL([ENV_RREIL_SIM], true)])])])])
AM_COND_IF([X86_RREIL], [AM_COND_IF([HAVE_ANON_MEMBERS], [AM_COND_IF([HAVE_POSIX200809_C11], [AM_CONDITIONAL([ENV_X86_TESTER], true)])])])
AM_CONDITIONAL([ENV_X86_GENERATOR], true)

#Tool requirements
AM_CONDITIONAL([ENV_DECODER_CLI], false)
AM_CONDITIONAL([ENV_SEMANTICS_CLI], false)
AM_CONDITIONAL([ENV_SEMANTICS_CLI_DYNAMIC], false)
AM_CONDITIONAL([ENV_SEMANTICS_CIF_CLI], false)
AM_CONDITIONAL([ENV_SWEEP], false)
AM_CONDITIONAL([ENV_SEMANTICS_OPT], false)
AM_CONDITIONAL([ENV_LIVENESS_SWEEP], false)
AM_CONDITIONAL([ENV_X86_TEST_RUNNER], false)
AM_CONDITIONAL([ENV_X86_TEST_STATS_RUNNER], false)

AM_CONDITIONAL([ENV_DECODER_CLI], true)
AM_COND_IF([HAVE_RREIL], [AM_CONDITIONAL([ENV_SEMANTICS_CLI], true)], [AM_CONDITIONAL([ENV_SEMANTICS_CLI], false)])
AM_COND_IF([HAVE_RREIL], [AM_CONDITIONAL([ENV_SEMANTICS_CLI_DYNAMIC], true)], [AM_CONDITIONAL([ENV_SEMANTICS_CLI_DYNAMIC], false)])
AM_COND_IF([HAVE_RREIL], [AM_CONDITIONAL([ENV_SEMANTICS_CIF_CLI], true)], [AM_CONDITIONAL([ENV_SEMANTICS_CIF_CLI], false)])
AM_COND_IF([HAVE_RREIL], [AM_COND_IF([HAVE_ELF], [AM_CONDITIONAL([ENV_SWEEP], true)], [AM_CONDITIONAL([ENV_SWEEP], false)])])
AM_COND_IF([HAVE_RREIL], [AM_COND_IF([HAVE_ELF], [AM_CONDITIONAL([ENV_SEMANTICS_OPT], true)], [AM_CONDITIONAL([ENV_SEMANTICS_OPT], false)])])
AM_COND_IF([HAVE_RREIL], [AM_COND_IF([HAVE_ELF], [AM_CONDITIONAL([ENV_LIVENESS_SWEEP], true)], [AM_CONDITIONAL([ENV_LIVENESS_SWEEP], false)])])
AM_COND_IF([X86_RREIL], [AM_CONDITIONAL([ENV_X86_TEST_RUNNER], true)], [AM_CONDITIONAL([ENV_X86_TEST_RUNNER], false)])
AM_COND_IF([X86_RREIL], [AM_CONDITIONAL([ENV_X86_TEST_STATS_RUNNER], true)], [AM_CONDITIONAL([ENV_X86_TEST_STATS_RUNNER], false)])

#Library dependencies
AM_CONDITIONAL([HAVE_RREIL_LIB], false)
AM_CONDITIONAL([HAVE_RREIL_SIM], false)
AM_CONDITIONAL([HAVE_GDWRAP], false)
AM_CONDITIONAL([HAVE_GDSL_MULTIPLEX], false)
AM_CONDITIONAL([HAVE_JRREIL], false)
AM_CONDITIONAL([HAVE_X86_LIB], false)
AM_CONDITIONAL([HAVE_READHEX], false)
AM_CONDITIONAL([HAVE_UTIL], false)
AM_CONDITIONAL([HAVE_X86_TESTER], false)
AM_CONDITIONAL([HAVE_X86_GENERATOR], false)

AM_COND_IF([ENV_RREIL_LIB], [AM_CONDITIONAL([HAVE_RREIL_LIB], true)])
AM_COND_IF([ENV_RREIL_SIM], [AM_COND_IF([HAVE_RREIL_LIB], [AM_CONDITIONAL([HAVE_RREIL_SIM], true)])])
AM_COND_IF([ENV_GDWRAP], [AM_CONDITIONAL([HAVE_GDWRAP], true)])
AM_COND_IF([ENV_GDSL_MULTIPLEX], [AM_CONDITIONAL([HAVE_GDSL_MULTIPLEX], true)])
AM_COND_IF([ENV_JRREIL], [AM_COND_IF([HAVE_GDSL_MULTIPLEX], [AM_CONDITIONAL([HAVE_JRREIL], true)])])
AM_COND_IF([ENV_X86_LIB], [AM_CONDITIONAL([HAVE_X86_LIB], true)])
AM_COND_IF([ENV_READHEX], [AM_CONDITIONAL([HAVE_READHEX], true)])
AM_COND_IF([ENV_UTIL], [AM_CONDITIONAL([HAVE_UTIL], true)])
AM_COND_IF([ENV_X86_TESTER], [AM_COND_IF([HAVE_UTIL], [AM_COND_IF([HAVE_RREIL_LIB], [AM_COND_IF([HAVE_GDWRAP], [AM_COND_IF([HAVE_X86_LIB], [AM_COND_IF([HAVE_RREIL_SIM], [AM_CONDITIONAL([HAVE_X86_TESTER], true)])])])])])])
AM_COND_IF([ENV_X86_GENERATOR], [AM_CONDITIONAL([HAVE_X86_GENERATOR], true)])

#Tool dependencies
AM_CONDITIONAL([HAVE_DECODER_CLI], false)
AM_CONDITIONAL([HAVE_SEMANTICS_CLI], false)
AM_CONDITIONAL([HAVE_SEMANTICS_CLI_DYNAMIC], false)
AM_CONDITIONAL([HAVE_SEMANTICS_CIF_CLI], false)
AM_CONDITIONAL([HAVE_SWEEP], false)
AM_CONDITIONAL([HAVE_SEMANTICS_OPT], false)
AM_CONDITIONAL([HAVE_LIVENESS_SWEEP], false)
AM_CONDITIONAL([HAVE_X86_TEST_RUNNER], false)
AM_CONDITIONAL([HAVE_X86_TEST_STATS_RUNNER], false)
AM_CONDITIONAL([HAVE_MEMSTREAM], true)

AM_COND_IF([ENV_DECODER_CLI], [AM_COND_IF([HAVE_READHEX], [AM_CONDITIONAL([HAVE_DECODER_CLI], true)])])
AM_COND_IF([ENV_SEMANTICS_CLI], [AM_COND_IF([HAVE_READHEX], [AM_CONDITIONAL([HAVE_SEMANTICS_CLI], true)])])
AM_COND_IF([ENV_SEMANTICS_CLI_DYNAMIC], [AM_COND_IF([HAVE_READHEX], [AM_COND_IF([HAVE_GDSL_MULTIPLEX], [AM_CONDITIONAL([HAVE_SEMANTICS_CLI_DYNAMIC], true)])])])
AM_COND_IF([ENV_SEMANTICS_CIF_CLI], [AM_COND_IF([HAVE_READHEX], [AM_CONDITIONAL([HAVE_SEMANTICS_CIF_CLI], true)])])
AM_COND_IF([ENV_SWEEP], [AM_CONDITIONAL([HAVE_SWEEP], true)])
AM_COND_IF([ENV_SEMANTICS_OPT], [AM_CONDITIONAL([HAVE_SEMANTICS_OPT], true)])
AM_COND_IF([ENV_LIVENESS_SWEEP], [AM_CONDITIONAL([HAVE_LIVENESS_SWEEP], true)])
AM_COND_IF([ENV_X86_TEST_RUNNER], [AM_COND_IF([HAVE_READHEX], [AM_COND_IF([HAVE_X86_GENERATOR], [AM_COND_IF([HAVE_X86_TESTER], [AM_CONDITIONAL([HAVE_X86_TEST_RUNNER], true)])])])])
AM_COND_IF([ENV_X86_TEST_STATS_RUNNER], [AM_COND_IF([HAVE_X86_GENERATOR], [AM_COND_IF([HAVE_X86_TESTER], [AM_CONDITIONAL([HAVE_X86_TEST_STATS_RUNNER], true)])])])
AM_COND_IF([HAVE_OPEN_MEMSTREAM], [AM_CONDITIONAL([HAVE_MEMSTREAM], false)])

dnl check if the helper executables should be build and/or installed
AC_ARG_ENABLE([install-auxbins],
  [AS_HELP_STRING(
    [--enable-install-auxbins],
    [install auxiliary binaries])],
  [], [enable_install_auxbins=no])
AM_CONDITIONAL([INSTALL_AUXBINS],[test x$enable_install_auxbins = xyes])

AC_ARG_ENABLE([build-auxbins],
  [AS_HELP_STRING(
    [--enable-build-auxbins],
    [build auxiliary binaries])],
  [], [enable_build_auxbins=yes])
AM_CONDITIONAL([BUILD_AUXBINS],[test x$enable_build_auxbins = xyes])

dnl check if the helper libraries should be build and/or installed
AC_ARG_ENABLE([install-auxlibs],
  [AS_HELP_STRING(
    [--enable-install-auxlibs],
    [install auxiliary libraries])],
  [], [enable_install_auxlibs=no])
AM_CONDITIONAL([INSTALL_AUXLIBS],[test x$enable_install_auxlibs = xyes])

if test [x$enable_install_auxlibs = xyes] || test [x$enable_build_auxbins = xyes]; then
  default_build_auxlibs=yes;
else
  default_build_auxlibs=no;
fi

AC_ARG_ENABLE([build-auxlibs],
  [AS_HELP_STRING(
    [--enable-build-auxlibs],
    [build auxiliary libraries])],
  [], [enable_build_auxlibs=$default_build_auxlibs])
AM_CONDITIONAL([BUILD_AUXLIBS],[test x$enable_build_auxlibs = xyes])

AC_CONFIG_HEADERS([config.h])
AC_CONFIG_FILES([
  Makefile
])

AC_OUTPUT()
cat <<EOF

GDSL toolkit configuration:
  directory prefix:             $prefix
  C flags:                      $CFLAGS
  front-end to build:           $with_frontend
  build auxiliary libraries:    $enable_build_auxlibs
  install auxiliary libraries:  $enable_install_auxlibs
  build auxiliary programs:     $enable_build_auxbins
  install auxiliary programs:   $enable_install_auxbins
  version:                      $VERSION
EOF
