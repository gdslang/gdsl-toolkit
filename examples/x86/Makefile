
all: ccmp ccli

ccmp:
	gcc -O2 -Wall -static -I. -I../.. -I../../resources/xed/xed2-intel64/include -L../../resources/xed/xed2-intel64/lib -Wfatal-errors cmp.c ../../dis.c pretty.c -lbfd -liberty -ldl -lz -lxed -DRELAXEDFATAL -o cmp

ccli:
	gcc -O2 -Wall -static -I. -I../.. -Wfatal-errors cli.c ../../dis.c pretty.c -DRELAXEDFATAL -o cli

ccli-println:
	gcc -O2 -Wall -static -I. -I../.. -Wfatal-errors cli-println.c ../../dis.c -DRELAXEDFATAL -o cli-println
