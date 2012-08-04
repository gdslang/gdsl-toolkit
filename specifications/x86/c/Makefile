
all: cmusl-cli

cmusl-cli:
	/usr/musl/bin/musl-gcc -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors cli.c ../../../dis.c -DRELAXEDFATAL -o musl-cli

cmusl-liveness:
	/usr/musl/bin/musl-gcc -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors liveness.c ../../../dis.c -DRELAXEDFATAL -o musl-live

cliveness:
	gcc -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors liveness.c ../../../dis.c -DRELAXEDFATAL -o live
