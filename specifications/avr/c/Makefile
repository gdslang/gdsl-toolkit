
all: cmusl-cli

cmusl-cli:
	/usr/musl/bin/musl-gcc -pipe -O3 -Wall -static -I. -I../../.. -Wfatal-errors cli.c ../../../dis.c -DRELAXEDFATAL -o musl-cli

