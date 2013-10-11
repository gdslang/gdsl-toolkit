#!/bin/bash

if [ "$1" -eq 12 ]; then
  export XED=/home/jucs/Downloads/pin-2.12-58423-gcc.4.4.7-linux/extras/xed2-intel64
fi

if [ "$1" -eq 11 ]; then
  export XED=/home/jucs/Downloads/pin-2.11-49306-gcc.3.4.6-ia32_intel64-linux/extras/xed2-intel64
fi

make -B
./xed-cmp /usr/bin/clang >/dev/null
./xed-cmp /usr/bin/clang >/dev/null
