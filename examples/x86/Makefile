
all: cmp ccli

cmp:
	gcc -O2 -Wall -static -I. -I../.. -I../../resources/xed/xed2-intel64/include -L../../resources/xed/xed2-intel64/lib -Wfatal-errors sweep.c ../../dis.c pretty.c -lbfd -liberty -ldl -lz -lxed -DRELAXEDFATAL -o sweep-cmp

ccli:
	gcc -O2 -Wall -static -I. -I../.. -Wfatal-errors cli.c ../../dis.c pretty.c -lbfd -liberty -ldl -lz -DRELAXEDFATAL -o cli
