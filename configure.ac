dnl configure file for the GDSL compiler and the decoders shipped with it
AC_INIT([gdsl], [0.9.0], [http://code.google.com/p/gdsl-toolkit/], [gdsl-toolkit])

AM_INIT_AUTOMAKE([no-dependencies -Wall foreign no-define])

AC_CONFIG_MACRO_DIR([m4])
AC_CONFIG_SRCDIR([LICENSE])

AM_PROG_CC_C_O()
AM_PROG_AR()
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

dnl check if the GDSL compiler should be installed
AC_ARG_ENABLE([install-gdslc],
  [AS_HELP_STRING(
    [--enable-install-gdslc],
    [install the GDSL compiler])],
  [], [enable_install_gdslc=no])
AM_CONDITIONAL([INSTALL_GDSLC],[test x$enable_install_gdslc = xyes])

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

has_anon_members=yes
AC_COMPILE_IFELSE([AC_LANG_PROGRAM(
    [[;]],
    [[struct inge { union { int a; int b }; }; struct inge i; i.a = 42;]])],
    has_anon_members=no)

AM_CONDITIONAL([X86_RREIL],[test x$with_frontend = xx86-rreil])
AM_CONDITIONAL([X86],[test x$with_frontend = xx86])
AM_CONDITIONAL([AVR_RREIL],[test x$with_frontend = xavr-rreil])
AM_CONDITIONAL([AVR],[test x$with_frontend = xavr])
AM_CONDITIONAL([HAVE_RREIL],[test x$has_rreil = xyes])
AM_CONDITIONAL([HAVE_X86], [test x$has_x86 = xyes])
#AM_CONDITIONAL([HAVE_GNU_C11], [echo "int main(void) { return 0; }" | gcc -std=gnu11 -xc - -o /dev/null])
#AM_CONDITIONAL([HAVE_POSIX200809], [test `getconf _POSIX_VERSION` -ge 200809 >/dev/null 2>&1])
AM_CONDITIONAL([HAVE_ANON_MEMBERS], [test x$has_anon_members = xyes])

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
  front-end to build:          	$with_frontend
  install compiler:             $enable_install_gdslc
  build auxiliary libraries:    $enable_build_auxlibs
  install auxiliary libraries:  $enable_install_auxlibs
  build auxiliary programs:     $enable_build_auxbins
  install auxiliary programs:   $enable_install_auxbins
  version:                      $VERSION
EOF
