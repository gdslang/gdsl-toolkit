
all: cmusl-cli

cmusl-cli:
	/usr/musl/bin/musl-gcc -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors cli.c ../../../dis.c -DRELAXEDFATAL -o musl-cli

clang-cli:
	clang -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors cli.c ../../../dis.o -DRELAXEDFATAL -o clang-cli

gcc-cli:
	gcc -std=gnu99 -pipe -O0 -g3 -Wall -I. -I../../../include -Wfatal-errors cli.c -L../../../lib -lgdsl-x86 -lavcall -DRELAXEDFATAL -o cli

cli-gdrr:
	gcc -Wall -I. -I../../.. -I../../../include -Wfatal-errors cli-gdrr.c -DRELAXEDFATAL -o cli-gdrr -lgdrr -L../../../gdrr/Debug -lgdsl-x86 -L../../../lib -lavcall

clang-tester:
	clang -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors tester.c ../../../dis.o -DRELAXEDFATAL -o tester

liveness-sweep:
	gcc -std=gnu99 -pipe -O0 -g3 -Wall -I. -I../../../include -Wfatal-errors liveness-sweep.c -L../../../lib -lgdsl-x86 -lelf -lrt -lavcall -DRELAXEDFATAL -o liveness-sweep

gcc-sweep:
	gcc -std=gnu99 -pipe -O0 -g3 -Wall -I. -I../../../include -Wfatal-errors sweep.c -L../../../lib -lgdsl-x86 -lavcall -DRELAXEDFATAL -o sweep

cmusl-liveness:
	/usr/musl/bin/musl-gcc -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors liveness.c ../../../dis.c -DRELAXEDFATAL -o musl-live

cliveness:
	gcc -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors liveness.c ../../../dis.c -DRELAXEDFATAL -o live

liveness-test:
	gcc -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors liveness-test.c ../../../dis.o -DRELAXEDFATAL -o liveness-test

liveness-example:
	gcc -m32 -std=c99 liveness-example.c -o liveness-example
