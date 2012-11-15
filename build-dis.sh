#!/bin/bash

./gdsl @MLton fixed-heap 6g -- "specifications/rreil/rreil.ml" "specifications/x86/x86.ml" "specifications/x86/x86-rreil-registermapping.ml" "specifications/x86/x86-pretty.ml" "specifications/rreil/rreil-pretty.ml" "specifications/x86/x86-rreil-translator.ml" "specifications/x86/x86-rreil-translator-a-l.ml" "specifications/x86/x86-rreil-translator-m-z.ml"

[ $? -eq 0 ] && clang -c dis.c -o dis.o
