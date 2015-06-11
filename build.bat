@ECHO OFF
setlocal ENABLEEXTENSIONS
rem This file is to be run on the Windows command line and generates the specified decoders.
rem

set ARGS=

rem remove bogus quotes from the PATH variable, that every path is in quotes
set LOCALPATH=%PATH:"=%
set LOCALPATH="%LOCALPATH:;=" "%"

rem let the user specify an output directory
set OUTDIR=
if NOT "%1"=="/odir" goto NoDir
set ARGS=%ARGS% %1
shift
set OUTDIR=%1
set ARGS=%ARGS% %1
shift
:NoDir

rem check if we find the Visual Studio compiler
set MSVC=
for %%p in (%LOCALPATH%) do if exist "%%~p\cl.exe" set MSVC="%%~p\cl.exe"

rem let the user specify the path to the C compiler
if NOT "%1"=="/cl" goto NoComp
set ARGS=%ARGS% %1
shift
set CL=%1
set ARGS=%ARGS% %1
shift
if exist %CL% goto NoComp
echo The compiler %CL% does not exist!
goto Error
:NoComp


rem let the user specify the Windows SDK lib directory
set SDKLIBPATH=
if NOT "%1"=="/sdklib" goto NoSDKLIB
set ARGS=%ARGS% %1
shift
set SDKLIBPATH=%1
set ARGS=%ARGS% %1
shift
:NoSDKLIB


SET DECODERS=x86 x86-rreil avr avr-rreil mips5 mips5-rreil mips6 mips6-rreil arm7

if "%1"=="" for %%d in (%DECODERS%) do build.bat %ARGS% %%d

for %%d IN (%DECODERS%) DO if "%1"=="%%d" set DECODER=%%d& goto Build

:Usage
echo Usage: build.bat [/odir "output-directory"] [/cl "cl-path"]
echo                  [/sdklib "sdklib-path"] ["decoder"]
echo where "cl-path" is the path to the Visual C compiler (ending in cl.exe)
echo and"sdklib-path" is the path to the \lib directory of the Windows SDK
echo and "decoder" may be omitted to build all or is one of the following:

for %%a in (%DECODERS%) do for /f "tokens=1,2 delims=-" %%d in ("%%a") do (
if "%%e"=="" (
echo	%%d		the %%d decoder and pretty printer
) ELSE (
echo	%%d-%%e	the %%d decoder, pretty printer and translation to %%e
)
)

goto End

:Build
echo off

rem keep these lists in sync with Makefile.am
set GDSL_BASIS=
set GDSL_BASIS=%GDSL_BASIS% specifications/basis/prelude.ml
set GDSL_BASIS=%GDSL_BASIS% specifications/basis/tree-set.ml
set GDSL_BASIS=%GDSL_BASIS% specifications/basis/bbtree.ml

set GDSL_ASM=
set GDSL_ASM=%GDSL_ASM%	specifications/asm/asm-cif.ml
set GDSL_ASM=%GDSL_ASM%	specifications/asm/asm.ml
set GDSL_ASM=%GDSL_ASM%	specifications/asm/asm-pretty.ml

set GDSL_X86= 
set GDSL_X86=%GDSL_X86% specifications/x86/x86.ml
set GDSL_X86=%GDSL_X86% specifications/x86/x86-equals.ml
set GDSL_X86=%GDSL_X86% specifications/x86/x86-traverse.ml
set GDSL_X86=%GDSL_X86% specifications/x86/x86-pretty.ml
set GDSL_X86=%GDSL_X86% specifications/x86/x86-asm.ml
set GDSL_X86=%GDSL_X86% specifications/x86/x86-semantics-mapping.ml
set GDSL_X86=%GDSL_X86% specifications/x86/x86-semantics-mapping-pretty.ml

set GDSL_X86SEM=
set GDSL_X86SEM=%GDSL_X86SEM% specifications/x86/x86-rreil-translator.ml
set GDSL_X86SEM=%GDSL_X86SEM% specifications/x86/x86-rreil-translator-a-l.ml
set GDSL_X86SEM=%GDSL_X86SEM% specifications/x86/x86-rreil-translator-m-z.ml
set GDSL_X86SEM=%GDSL_X86SEM% specifications/x86/x86-liveness.ml

set GDSL_AVR=
set GDSL_AVR=%GDSL_AVR% specifications/avr/avr.ml
set GDSL_AVR=%GDSL_AVR% specifications/avr/avr-asm.ml
set GDSL_AVR=%GDSL_AVR% specifications/avr/avr-traverse.ml
set GDSL_AVR=%GDSL_AVR% specifications/avr/avr-pretty.ml

set GDSL_AVRSEM=
set GDSL_AVRSEM=%GDSL_AVRSEM% specifications/avr/avr-rreil-translator.ml
set GDSL_AVRSEM=%GDSL_AVRSEM% specifications/avr/avr-rreil-registermapping.ml
set GDSL_AVRSEM=%GDSL_AVRSEM% specifications/avr/avr-rreil-pretty.ml
set GDSL_AVRSEM=%GDSL_AVRSEM% specifications/avr/avr-liveness.ml

set GDSL_MIPS5=
set GDSL_MIPS5=%GDSL_MIPS5% specifications/mips/mips.ml
set GDSL_MIPS5=%GDSL_MIPS5% specifications/mips/mips-asm.ml
set GDSL_MIPS5=%GDSL_MIPS5% specifications/mips/mips-traverse.ml
set GDSL_MIPS5=%GDSL_MIPS5% specifications/mips/mips-pretty.ml
set GDSL_MIPS5=%GDSL_MIPS5% specifications/mips/mips_r5.ml
set GDSL_MIPS5=%GDSL_MIPS5% specifications/mips/mips-asm_r5.ml
set GDSL_MIPS5=%GDSL_MIPS5% specifications/mips/mips-traverse_r5.ml
set GDSL_MIPS5=%GDSL_MIPS5% specifications/mips/mips-pretty_r5.ml

set GDSL_MIPSSEM=
set GDSL_MIPSSEM=%GDSL_MIPSSEM% specifications/mips/mips-rreil-translator.ml
set GDSL_MIPSSEM=%GDSL_MIPSSEM% specifications/mips/mips-rreil-registermapping.ml
set GDSL_MIPSSEM=%GDSL_MIPSSEM% specifications/mips/mips-rreil-pretty.ml
set GDSL_MIPSSEM=%GDSL_MIPSSEM% specifications/mips/mips-rreil-liveness.ml
set GDSL_MIPSSEM=%GDSL_MIPSSEM% specifications/mips/mips-rreil-rreil-translator_r5.ml

set GDSL_MIPS6=
set GDSL_MIPS6=%GDSL_MIPS6% specifications/mips/mips.ml
set GDSL_MIPS6=%GDSL_MIPS6% specifications/mips/mips-asm.ml
set GDSL_MIPS6=%GDSL_MIPS6% specifications/mips/mips-traverse.ml
set GDSL_MIPS6=%GDSL_MIPS6% specifications/mips/mips-pretty.ml
set GDSL_MIPS6=%GDSL_MIPS6% specifications/mips/mips_r6.ml
set GDSL_MIPS6=%GDSL_MIPS6% specifications/mips/mips-asm_r6.ml
set GDSL_MIPS6=%GDSL_MIPS6% specifications/mips/mips-traverse_r6.ml
set GDSL_MIPS6=%GDSL_MIPS6% specifications/mips/mips-pretty_r6.ml

set GDSL_MIPS6SEM=
set GDSL_MIPS6SEM=%GDSL_MIPS6SEM% specifications/mips/mips-rreil-translator.ml
set GDSL_MIPS6SEM=%GDSL_MIPS6SEM% specifications/mips/mips-rreil-registermapping.ml
set GDSL_MIPS6SEM=%GDSL_MIPS6SEM% specifications/mips/mips-rreil-pretty.ml
set GDSL_MIPS6SEM=%GDSL_MIPS6SEM% specifications/mips/mips-rreil-liveness.ml
set GDSL_MIPS6SEM=%GDSL_MIPS6SEM% specifications/mips/mips-rreil-rreil-translator_r6.ml

set GDSL_MIPSSEM=
set GDSL_MIPSSEM=%GDSL_MIPSSEM% specifications/mips/mips-rreil-translator.ml
set GDSL_MIPSSEM=%GDSL_MIPSSEM% specifications/mips/mips-rreil-registermapping.ml
set GDSL_MIPSSEM=%GDSL_MIPSSEM% specifications/mips/mips-rreil-pretty.ml
set GDSL_MIPSSEM=%GDSL_MIPSSEM% specifications/mips/mips-liveness.ml

set GDSL_RREIL=
set GDSL_RREIL=%GDSL_RREIL% specifications/rreil/fmap.ml
set GDSL_RREIL=%GDSL_RREIL% specifications/rreil/rreil.ml
set GDSL_RREIL=%GDSL_RREIL% specifications/rreil/rreil-examples.ml
set GDSL_RREIL=%GDSL_RREIL% specifications/rreil/rreil-cif.ml
set GDSL_RREIL=%GDSL_RREIL% specifications/rreil/rreil-pretty.ml
set GDSL_RREIL=%GDSL_RREIL% specifications/rreil/rreil-liveness.ml
set GDSL_RREIL=%GDSL_RREIL% specifications/rreil/rreil-forward-subst.ml
set GDSL_RREIL=%GDSL_RREIL% specifications/rreil/rreil-cleanup.ml
set GDSL_RREIL=%GDSL_RREIL% specifications/rreil/rreil-opt.ml
set GDSL_RREIL=%GDSL_RREIL% specifications/rreil/rreil-translator.ml
set GDSL_RREIL=%GDSL_RREIL% specifications/rreil/forward-subst/inline.ml
set GDSL_RREIL=%GDSL_RREIL% specifications/rreil/forward-subst/substitute.ml
set GDSL_RREIL=%GDSL_RREIL% specifications/rreil/forward-subst/substmap.ml
set GDSL_RREIL=%GDSL_RREIL% specifications/rreil/forward-subst/simplify-expressions.ml

set GDSL_ARM7=
set GDSL_ARM7=%GDSL_ARM7% specifications/arm7/arm7.ml
set GDSL_ARM7=%GDSL_ARM7% specifications/arm7/arm7-pretty.ml

if NOT "%DECODER%"=="x86" goto NOT_x86
set SPEC=%GDSL_BASIS% %GDSL_ASM% %GDSL_X86%
set OUT=gdsl-x86
:NOT_x86

if NOT "%DECODER%"=="x86-rreil" goto NOT_x86_rreil
set SPEC=%GDSL_BASIS% %GDSL_ASM% %GDSL_X86% %GDSL_RREIL% %GDSL_X86SEM%
set OUT=gdsl-x86-rreil
:NOT_X86_rreil

if NOT "%DECODER%"=="avr" goto NOT_avr
set SPEC=%GDSL_BASIS% %GDSL_ASM% %GDSL_AVR%
set OUT=gdsl-avr
:NOT_avr

if NOT "%DECODER%"=="avr-rreil" goto NOT_avr_rreil
set SPEC=%GDSL_BASIS% %GDSL_ASM% %GDSL_AVR% %GDSL_RREIL% %GDSL_AVRSEM%
set OUT=gdsl-avr-rreil
:NOT_avr_rreil

if NOT "%DECODER%"=="mips5" goto NOT_mips
set SPEC=%GDSL_BASIS% %GDSL_ASM% %GDSL_MIPS5%
set OUT=gdsl-mips
:NOT_mips

if NOT "%DECODER%"=="mips5-rreil" goto NOT_mips_rreil
set SPEC=%GDSL_BASIS% %GDSL_ASM% %GDSL_MIPS5% %GDSL_RREIL% %GDSL_MIPSSEM%
set OUT=gdsl-mips-rreil
:NOT_mips_rreil

if NOT "%DECODER%"=="mips6" goto NOT_mips
set SPEC=%GDSL_BASIS% %GDSL_ASM% %GDSL_MIPS6%
set OUT=gdsl-mips
:NOT_mips

if NOT "%DECODER%"=="mips6-rreil" goto NOT_mips_rreil
set SPEC=%GDSL_BASIS% %GDSL_ASM% %GDSL_MIPS6% %GDSL_RREIL% %GDSL_MIPS6SEM%
set OUT=gdsl-mips-rreil
:NOT_mips_rreil

if NOT "%DECODER%"=="arm7" goto NOT_arm7
set SPEC=%GDSL_BASIS% %GDSL_ARM7%
set OUT=gdsl-arm7
:NOT_arm7

echo Generating C code for %DECODER%.
gdslc.exe --maxIter=42 --target=C89 -o %OUT% %SPEC%
rem @echo off

if x%MSVC%x==xx (
echo Unable to compile the generated decoder since the compiler cannot be found.
goto End
)

rem Find out where to get kernel32.lib and friends. It's somewhere under "Windows Kits"
rem which resides in "Program Files (x86)". This will probably break occasionally, but
rem it works for my machine. I couldn't find a reliably registry key. Feedback welcome.
for /f "usebackq tokens=*" %%d in (`dir /ad /b /s "C:\Program Files (x86)\Windows Kits" ^| find "\x86" ^| find /i "lib"`) do set SDKLIBPATH=%%d

if NOT defined SDKLIBPATH (
	echo Cannot find SDK library directory. Use /sdklib switch to specify.
	goto Error
)


set MSVCBARE=%MSVC:.exe=%
set LIB=%MSVCBARE:\bin\cl=\lib%;"%SDKLIBPATH%"
set INCLUDE=%MSVCBARE:\bin\cl=\include%
set CL=

echo Compiling %OUT%.c
%MSVC% /Od /Gd /nologo /Za /D WITHMAIN /TC %OUT%.c /link /OUT:"%OUTDIR%%OUT%-demo.exe"

goto End

:Error
exit /b 1
:End
