
all: udis86 libopcode distorm xed beaengine dcc

udis86:
	gcc -O2 -Wall -static -Wfatal-errors sweep-udis86.c -lbfd -liberty -ldl -lz -ludis86 -o sweep-udis86

libopcode:
	gcc -O2 -Wall -static -Wfatal-errors sweep-libopcode.c -lbfd -liberty -ldl -lz -lopcodes -o sweep-libopcode

distorm:
	gcc -O2 -Wall -static -I../../resources/distorm/include -L../../resources/distorm -Wfatal-errors sweep-distorm.c ../../resources/distorm/distorm3.a -lbfd -liberty -ldl -lz -o sweep-distorm

xed:
	gcc -O2 -Wall -static -I../../resources/xed/xed2-intel64/include -L../../resources/xed/xed2-intel64/lib -Wfatal-errors sweep-xed.c -lbfd -liberty -ldl -lz -lxed -o sweep-xed

dcc:
	gcc -m64 -O2 -ftree-vectorize -ftree-slp-vectorize -mfpmath=sse -msse4 -Wall -static -I. -I../.. -I../../examples/x86 -Wfatal-errors sweep-dcc.c ../../dis.c -DRELAXEDFATAL -lbfd -liberty -ldl -lz -o sweep-dcc

musl-dcc:
	/usr/musl/bin/musl-gcc\
		-m64\
		-O2\
		-ftree-vectorize\
		-ftree-slp-vectorize\
		-mfpmath=sse\
		-msse4\
		-Wall\
		-static\
		-I.\
		-I../..\
		-I../../examples/x86\
		-Wfatal-errors\
		sweep-dcc.c ../../examples/x86/pretty.c ../../dis.c\
		-DRELAXEDFATAL -lbfd -liberty -ldl -lz -o musl-sweep-dcc

beaengine:
	gcc -O2 -Wall -static -I../../resources/beaengine/include -L../../resources/beaengine/lib/Linux.gnu.release.64 -Wfatal-errors sweep-beaengine.c -lbfd -liberty -ldl -lz -lBeaEngine_s_64 -o sweep-beaengine
