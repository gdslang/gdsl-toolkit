
all: cmusl-cli

cmusl-cli:
	/usr/musl/bin/musl-gcc -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors cli.c ../../../dis.c -DRELAXEDFATAL -o musl-cli

clang-cli:
	clang -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors cli.c ../../../dis.o -DRELAXEDFATAL -o clang-cli

cli-gdrr:
	gcc -Wall -static -I. -I../../.. -I../../../include -Wfatal-errors cli-gdrr.c ../../../dis.o -DRELAXEDFATAL -o cli-gdrr -lgdrr -L../../../gdrr/Debug

clang-tester:
	clang -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors tester.c ../../../dis.o -DRELAXEDFATAL -o tester

clang-sweep:
	clang -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors sweep.c ../../../dis.o -DRELAXEDFATAL -o clang-sweep

liveness-sweep:
	clang -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors liveness-sweep.c ../../../dis.o -DRELAXEDFATAL -o liveness-sweep

gcc-sweep:
	gcc -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors sweep.c ../../../dis.o -DRELAXEDFATAL -o gcc-sweep

cmusl-liveness:
	/usr/musl/bin/musl-gcc -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors liveness.c ../../../dis.c -DRELAXEDFATAL -o musl-live

cliveness:
	gcc -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors liveness.c ../../../dis.c -DRELAXEDFATAL -o live

liveness-test:
	gcc -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors liveness-test.c ../../../dis.o -DRELAXEDFATAL -o liveness-test

liveness-example:
	gcc -m32 -std=c99 liveness-example.c -o liveness-example
