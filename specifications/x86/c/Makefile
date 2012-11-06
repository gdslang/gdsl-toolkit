
all: cmusl-cli

cmusl-cli:
	/usr/musl/bin/musl-gcc -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors cli.c ../../../dis.c -DRELAXEDFATAL -o musl-cli

clang-cli:
	clang -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors cli.c ../../../dis.o -DRELAXEDFATAL -o clang-cli

clang-sweep:
	clang -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors sweep.c ../../../dis.o -DRELAXEDFATAL -o clang-sweep

cmusl-liveness:
	/usr/musl/bin/musl-gcc -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors liveness.c ../../../dis.c -DRELAXEDFATAL -o musl-live

cliveness:
	gcc -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors liveness.c ../../../dis.c -DRELAXEDFATAL -o live
