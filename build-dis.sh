#!/bin/bash

#./gdsl @MLton fixed-heap 6g -- "specifications/basis/bbtree.ml" "specifications/rreil/rreil.ml" "specifications/rreil/fmap.ml" "specifications/x86/x86.ml" "specifications/x86/x86-rreil-registermapping.ml" "specifications/x86/x86-pretty.ml" "specifications/rreil/rreil-pretty.ml" "specifications/x86/x86-rreil-translator.ml" "specifications/x86/x86-rreil-translator-a-l.ml" "specifications/x86/x86-rreil-translator-m-z.ml"
#./gdsl @MLton fixed-heap 6g -- "specifications/rreil/rreil.ml" "specifications/rreil/rreil-pretty.ml" "specifications/rreil/rreil-liveness-test.ml"
#./gdsl @MLton fixed-heap 6g -- "specifications/rreil/rreil.ml" "specifications/rreil/rreil-pretty.ml" "specifications/rreil/rreil-liveness-test.ml" "specifications/rreil/rreil-liveness.ml" "specifications/basis/bbtree.ml" "specifications/rreil/fmap.ml" "specifications/x86/x86-rreil-registermapping.ml" "specifications/x86/x86.ml"
./gdsl @MLton fixed-heap 6g -- $1 "specifications/basis/bbtree.ml" "specifications/basis/print.ml" "specifications/rreil/rreil.ml" "specifications/rreil/fmap.ml" "specifications/x86/x86.ml" "specifications/x86/x86-rreil-registermapping.ml" "specifications/x86/x86-pretty.ml" "specifications/x86/x86-pretty-simple.ml" "specifications/rreil/rreil-pretty.ml" "specifications/x86/x86-rreil-translator.ml" "specifications/x86/x86-rreil-translator-a-l.ml" "specifications/x86/x86-rreil-translator-m-z.ml" "specifications/rreil/rreil-liveness.ml" "specifications/rreil/rreil-cleanup.ml" "specifications/x86/x86-liveness.ml" "specifications/rreil/rreil-cif.ml" "specifications/basis/selectors.ml" "specifications/basis/invoke.ml"

#[ $? -eq 0 ] && clang -fno-inline -O -c dis.c -o dis.o
#[ $? -eq 0 ] && clang -fPIC -c dis.c -o dis.o && ar -r  "lib/libdis.a"  dis.o
#[ $? -eq 0 ] && clang -fPIC -c dis.c -o dis.o && gcc -shared -Wl,-soname,libdis.so -o lib/libdis.so dis.o
[ $? -eq 0 ] && clang -g3 -fPIC -c gdsl-x86.c -o gdsl-x86.o && gcc -g3 -shared -Wl,-soname,libgdsl-x86.so -o lib/libgdsl-x86.so gdsl-x86.o
#[ $? -eq 0 ] && clang -fno-inline -O -S dis.c
