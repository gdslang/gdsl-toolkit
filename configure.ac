dnl configure file for the GDSL compiler and the decoders shipped with it
AC_INIT([gdsl], [0.9.0], [http://code.google.com/p/gdsl-toolkit/], [gdsl-toolkit])

AM_INIT_AUTOMAKE([no-dependencies -Wall -Werror foreign no-define])

AC_CONFIG_MACRO_DIR([m4])
AC_CONFIG_SRCDIR([LICENSE])

AC_PROG_CC()
AC_PROG_LIBTOOL()
AC_PROG_INSTALL()

AC_ARG_VAR(MLTON)
AC_PATH_PROG(MLTON, mlton, ["not-found"])

if test [$MLTON == "not-found"]; then
    echo "You must install MLton."
    exit 1
fi

AC_ARG_VAR(MLULEX)
AC_PATH_PROG(MLULEX, ml-ulex, ["not-found"])

if test [$MLULEX == "not-found"]; then
    echo "You must install MLton (to get ml-ulex)."
    exit 1
fi

AC_ARG_VAR(MLANTLR)
AC_PATH_PROG(MLANTLR, ml-antlr, ["not-found"])

if test [$MLANTLR == "not-found"]; then
    echo "You must install MLton (to get ml-antlr)."
    exit 1
fi

AC_ARG_ENABLE([x86-rreil],
  [AS_HELP_STRING(
    [--enable-x86-rreil],
    [generate decoder and RReil semantics for x86])],
  [], [enable_x86_rreil=yes])
AM_CONDITIONAL([X86_RREIL],[test x$enable_x86_rreil = xyes])

AC_CONFIG_FILES([
  Makefile
])

AC_OUTPUT()

