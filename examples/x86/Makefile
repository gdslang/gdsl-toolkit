
all: cmusl-cli

ccmp:
	gcc -O2 -Wall -static -I. -I../.. -I../../resources/xed/xed2-intel64/include -L../../resources/xed/xed2-intel64/lib -Wfatal-errors cmp.c ../../dis.c pretty.c -lbfd -liberty -ldl -lz -lxed -DRELAXEDFATAL -o cmp

cxedcmp:
	gcc -O2 -Wall -Wfatal-errors -static -I. -I../.. -I../../resources/xed/xed2-intel64/include -L../../resources/xed/xed2-intel64/lib xed-cmp.c pretty.c ../../dis.c -lbfd -liberty -ldl -lz -lxed -DRELAXEDFATAL -o xed-cmp

ccli:
	gcc -pipe -O2 -Wall -static -I. -I../.. -Wfatal-errors cli.c pretty.c ../../dis.c -DRELAXEDFATAL -o cli

cmusl-cli:
	/usr/musl/bin/musl-gcc -pipe -O3 -Wall -static -I. -I../.. -Wfatal-errors cli.c pretty.c ../../dis.c -DRELAXEDFATAL -o musl-cli

cmusl-cli-println:
	/usr/musl/bin/musl-gcc -pipe -O3 -Wall -static -I. -I../.. -Wfatal-errors cli-println.c ../../dis.c -DRELAXEDFATAL -o musl-cli-println

ccli-println:
	gcc -O2 -Wall -static -I. -I../.. -Wfatal-errors cli-println.c ../../dis.c -DRELAXEDFATAL -o cli-println
