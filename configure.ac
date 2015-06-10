dnl configure file for the GDSL compiler and the decoders shipped with it
AC_INIT([gdsl], [1.1.1], [http://code.google.com/p/gdsl-toolkit/], [gdsl-toolkit])

AM_INIT_AUTOMAKE([no-dependencies -Wall foreign no-define subdir-objects])

AC_CONFIG_MACRO_DIR([m4])
AC_CONFIG_SRCDIR([LICENSE])

dnl the AM_PROG_AR macro only exists starting from 1.11.2
am_version=`automake --version | head -n 1 | sed -e 's/[[^0-9]*\([0-9][0-9.]*\)]/\1/g'`
m4_pattern_allow([AM_PROG_AR])
AS_VERSION_COMPARE([$am_version],[1.11.2],[],[AM_PROG_AR],[AM_PROG_AR])

AM_PROG_CC_C_O()
AC_PROG_LN_S()
AC_PROG_LIBTOOL()
AC_PROG_INSTALL()

dnl check if the compiler understand C99
AC_PROG_CC_C99()
AC_ARG_ENABLE(msvc,[AS_HELP_STRING([--enable-msvc], [emit code for Microsoft Visual C compiler])])
AC_ARG_VAR(EXTRA_GDSL_FLAGS)
if test [x$ac_cv_prog_cc_c99 == "xno" -o x$enable_msvc == "xyes"]; then
  EXTRA_GDSL_FLAGS="--target=C89";
fi

AC_ARG_VAR(SMLNJ)
AC_PATH_PROG(SMLNJ, sml, ["not-found"])

AC_ARG_VAR(MLTON)
AC_PATH_PROG(MLTON, mlton, ["not-found"])

if test [x$SMLNJ == "xnot-found" -a x$MLTON == "xnot-found"]; then
    echo "You must install either SML/NJ or mlton."
    exit 1
fi

AM_CONDITIONAL([HAVE_MLTON],[test x$MLTON != "xnot-found"])

AC_ARG_VAR(MLULEX)
AC_PATH_PROG(MLULEX, ml-ulex, ["ml-ulex not-found"])
AC_ARG_VAR(MLANTLR)
AC_PATH_PROG(MLANTLR, ml-antlr, ["ml-antlr not-found"])

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

FRONTENDS="x86 x86-rreil avr avr-rreil mips5 mips5-rreil mips6 mips6-rreil arm7 arm7-rreil";

AC_ARG_WITH([frontend],
  [AS_HELP_STRING(
    [--with-frontend=frontend],
    [one of: x86 x86-rreil avr avr-rreil mips5 mips5-rreil mips6 mips6-rreil arm7 arm7-rreil])],
  [], [with_frontend=all])

case $with_frontend in
	all)
	 	with_frontend=all;;
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
	mips5)
		AC_DEFINE([USE_MIPS5],[1],[build MIPS5 bare decoder])
		with_frontend=mips5;;
	mips5-rreil)
		AC_DEFINE([USE_MIPS5_RREIL],[1],[build MIPS5 decoder and RReil semantics])
		with_frontend=mips5-rreil;;
	mips6)
		AC_DEFINE([USE_MIPS6],[1],[build MIPS6 bare decoder])
		with_frontend=mips6;;
	mips6-rreil)
		AC_DEFINE([USE_MIPS6_RREIL],[1],[build MIPS6 decoder and RReil semantics])
		with_frontend=mips6-rreil;;
	arm7)
		AC_DEFINE([USE_ARM7],[1],[build ARM7 bare decoder])
		with_frontend=arm7;;
	arm7-rreil)
		AC_DEFINE([USE_ARM7_RREIL],[1],[build ARM7 decoder and RReil semantics])
		with_frontend=arm7-rreil;;
	*) AC_MSG_FAILURE([invalid frontend, choose one of ]$FRONTENDS);;
esac
case $with_frontend in
	*-rreil) has_rreil=yes;;
	*) has_rreil=no;;
esac
#case $with_frontend in
#	x86*) has_x86=yes;;
#	*) has_x86=no;;
#esac

AC_MSG_CHECKING([whether C structs may contain anonymous members])
AC_COMPILE_IFELSE([AC_LANG_PROGRAM(
    [[;]],
    [[struct inge { union { int a; int b }; }; struct inge i; i.a = 42;]])], [has_anon_members=yes],
    has_anon_members=no)
AC_MSG_RESULT($has_anon_members)

AC_MSG_CHECKING([whether __uint128_t and __int128_t are available])
AC_COMPILE_IFELSE([AC_LANG_PROGRAM(
    [[#include <stdint.h>]],
    [[__uint128_t a = 42; __int128_t b = -42;]])], [has_int128=yes],
    has_int128=no)
AC_MSG_RESULT($has_int128)

AC_MSG_CHECKING([whether the open_memstream() is available])
AC_LINK_IFELSE(
    [AC_LANG_PROGRAM([[#include <stdio.h>]],
        [[char *c; size_t s; FILE *f = open_memstream(&c, &s);]])],
    [AC_MSG_RESULT([yes])
        has_open_memstream=yes;],
    [AC_MSG_RESULT([no])
 #       LIBS=$OLD_LIBS; dnl reset to old value since XXX was not found
        has_open_memstream=no;])

AC_MSG_CHECKING([whether the clock_gettime(CLOCK_REALTIME, ...) is available])
AC_LINK_IFELSE(
    [AC_LANG_PROGRAM([[#include <time.h>]],
        [[struct timespec ts; clock_gettime(CLOCK_REALTIME, &ts);]])],
    [AC_MSG_RESULT([yes])
        has_clock_gettime=yes;],
    [AC_MSG_RESULT([no])
#        LIBS=$OLD_LIBS; dnl reset to old value since XXX was not found
        has_clock_gettime=no;])
AC_SEARCH_LIBS([clock_gettime], [rt posix4])

AC_CHECK_HEADERS([gelf.h], [has_elf=yes], [has_elf=no])
AC_CHECK_HEADERS([jni.h], [has_jni=yes], [has_jni=no])
AC_CHECK_HEADERS([stdint-gcc.h], [has_stdint_gcc=yes], [has_stdint_gcc=no])

AM_CONDITIONAL([X86_RREIL],[test x$with_frontend = xx86-rreil -o x$with_frontend = xall])
AM_CONDITIONAL([X86],[test x$with_frontend = xx86 -o x$with_frontend = xall])
AM_CONDITIONAL([AVR_RREIL],[test x$with_frontend = xavr-rreil -o x$with_frontend = xall])
AM_CONDITIONAL([AVR],[test x$with_frontend = xavr -o x$with_frontend = xall])
AM_CONDITIONAL([MIPS5_RREIL],[test x$with_frontend = xmips5-rreil -o x$with_frontend = xall])
AM_CONDITIONAL([MIPS5],[test x$with_frontend = xmips5 -o x$with_frontend = xall])
AM_CONDITIONAL([MIPS6_RREIL],[test x$with_frontend = xmips6-rreil -o x$with_frontend = xall])
AM_CONDITIONAL([MIPS6],[test x$with_frontend = xmips6 -o x$with_frontend = xall])
AM_CONDITIONAL([ARM7_RREIL],[test x$with_frontend = xarm7-rreil -o x$with_frontend = xall])
AM_CONDITIONAL([ARM7],[test x$with_frontend = xarm7 -o x$with_frontend = xall])
AM_CONDITIONAL([HAVE_RREIL],[test x$has_rreil = xyes -o x$with_frontend = xall])
AM_CONDITIONAL([SINGLE],[test x$with_frontend != xall])
#AM_CONDITIONAL([HAVE_X86], [test x$has_x86 = xyes])
#AM_CONDITIONAL([HAVE_GNU_C11], [echo "int main(void) { return 0; }" | gcc -std=gnu11 -xc - -o /dev/null])
#AM_CONDITIONAL([HAVE_POSIX200809], [test `getconf _POSIX_VERSION` -ge 200809 >/dev/null 2>&1])
#AM_CONDITIONAL([HAVE_ANON_MEMBERS], [test x$has_anon_members = xyes])
AM_CONDITIONAL([HAVE_OPEN_MEMSTREAM], [test x$has_open_memstream = xyes])
#AM_CONDITIONAL([HAVE_CLOCK_GETTIME], [test x$has_clock_gettime = xyes])
#AM_CONDITIONAL([HAVE_POSIX200809_C11], [test x$has_anon_members = xyes && test x$has_open_memstream = xyes])
#AM_CONDITIONAL([HAVE_STDINT_GCC], [test x$has_stdint_gcc = xyes])
#AM_CONDITIONAL([HAVE_INT128], [test x$has_int128 = xyes])
#AM_CONDITIONAL([HAVE_ELF], [test x$has_elf = xyes])

#Library requirements
AM_CONDITIONAL([ENV_GDSL_MULTIPLEX], false)
AM_CONDITIONAL([ENV_JGDSL], false)

AM_CONDITIONAL([ENV_GDSL_MULTIPLEX], true)
AM_CONDITIONAL([ENV_JGDSL], [test x$has_jni = xyes])

#Library dependencies
AM_CONDITIONAL([HAVE_GDSL_MULTIPLEX], false)
AM_CONDITIONAL([HAVE_JGDSL], false)
AM_CONDITIONAL([HAVE_MEMSTREAM], true)

AM_COND_IF([ENV_GDSL_MULTIPLEX], [AM_CONDITIONAL([HAVE_GDSL_MULTIPLEX], true)])
AM_COND_IF([ENV_JGDSL], [AM_COND_IF([HAVE_GDSL_MULTIPLEX], [AM_CONDITIONAL([HAVE_JGDSL], true)])])
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

AM_COND_IF([HAVE_GDSL_MULTIPLEX], libjgdsl_msg=yes, libjgdsl_msg=no)
AM_COND_IF([HAVE_RREIL], libjgdsl_msg=$libjgdsl_msg, libjgdsl_msg="no; translator API missing")
AM_COND_IF([HAVE_GDSL_MULTIPLEX], libgdsl_multiplex_msg=yes, libgdsl_multiplex_msg=no)
AM_COND_IF([HAVE_RREIL], libgdsl_multiplex_msg=$libgdsl_multiplex_msg, libgdsl_multiplex_msg="no; translator API missing")

AC_OUTPUT()
cat <<EOF

GDSL toolkit configuration:
  directory prefix:             $prefix
  C flags:                      $CFLAGS
  frontend to build:            $with_frontend
  build auxiliary libraries:    $enable_build_auxlibs
  install auxiliary libraries:  $enable_install_auxlibs
  build auxiliary programs:     $enable_build_auxbins
  install auxiliary programs:   $enable_install_auxbins
  version:                      $VERSION
EOF
echo Libraries:
AS_ECHO_N "  libgdsl-multiplex:            "; echo $libjgdsl_msg
AS_ECHO_N "  libjgdsl:                     "; echo $libgdsl_multiplex_msg
AS_ECHO_N "  libmemstream:                 "; AM_COND_IF([HAVE_MEMSTREAM], echo yes, echo no)
echo

