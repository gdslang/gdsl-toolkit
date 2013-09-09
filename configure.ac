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

dnl check if the GDSL compiler should be installed
AC_ARG_ENABLE([install-gdslc],
  [AS_HELP_STRING(
    [--enable-install-gdslc],
    [install the GDSL compiler])],
  [], [enable_install_gdslc=no])
AM_CONDITIONAL([INSTALL_GDSLC],[test x$enable_install_gdslc = xyes])

dnl conditionals for the various decoders, either with or without semantics

AC_ARG_ENABLE([x86-rreil],
  [AS_HELP_STRING(
    [--enable-x86-rreil],
    [generate decoder and RReil semantics for x86])],
  [], [enable_x86_rreil=yes])
AM_CONDITIONAL([X86_RREIL],[test x$enable_x86_rreil = xyes])

AC_ARG_ENABLE([x86],
  [AS_HELP_STRING(
    [--enable-x86],
    [generate bare decoder for x86])],
  [], [enable_x86=no])
AM_CONDITIONAL([X86],[test x$enable_x86 = xyes])

AC_ARG_ENABLE([avr-rreil],
  [AS_HELP_STRING(
    [--enable-avr-rreil],
    [generate decoder and RReil semantics for avr])],
  [], [enable_avr_rreil=yes])
AM_CONDITIONAL([AVR_RREIL],[test x$enable_avr_rreil = xyes])

AC_ARG_ENABLE([avr],
  [AS_HELP_STRING(
    [--enable-avr],
    [generate bare decoder for avr])],
  [], [enable_avr=no])
AM_CONDITIONAL([AVR],[test x$enable_avr = xyes])

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
  x86 decoder + RREIL:          $enable_x86_rreil
  x86 decoder (bare):           $enable_x86
  AVR decoder + RREIL:          $enable_avr_rreil
  AVR decoder (bare):           $enable_avr
  install compiler:             $enable_install_gdslc
  build auxiliary libraries:    $enable_build_auxlibs
  install auxiliary libraries:  $enable_install_auxlibs
  build auxiliary programs:     $enable_build_auxbins
  install auxiliary programs:   $enable_install_auxbins
  version:                      $VERSION
EOF
