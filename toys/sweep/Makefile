
all: udis86 libopcode distorm xed dcc

udis86:
	gcc -O2 -Wall -static -Wfatal-errors sweep-udis86.c -lbfd -liberty -ldl -lz -ludis86 -o sweep-udis86

libopcode:
	gcc -O2 -Wall -static -Wfatal-errors sweep-libopcode.c -lbfd -liberty -ldl -lz -lopcodes -o sweep-libopcode

distorm:
	gcc -O2 -Wall -static -I../../resources/distorm/include -L../../resources/distorm -Wfatal-errors sweep-distorm.c ../../resources/distorm/distorm3.a -lbfd -liberty -ldl -lz -o sweep-distorm

xed:
	gcc -O2 -Wall -static -I../../resources/xed/xed2-intel64/include -L../../resources/xed/xed2-intel64/lib -Wfatal-errors sweep-xed.c -lbfd -liberty -ldl -lz -lxed -o sweep-xed

dcc:
	gcc -O2 -Wall -static -I. -I../.. -I../../examples/x86 -Wfatal-errors sweep-dcc.c ../../dis.c ../../examples/x86/pretty.c -DRELAXEDFATAL -lbfd -liberty -ldl -lz -o sweep-dcc
