# What is it?

This is a simplified Python wrapper for [GDSL](http://code.google.com/p/gdsl-toolkit/).

# Prerequisites

* Linux. Only Ubuntu-like systems are tested right now.
* A recent version of GCC that supports the C11 standard (`-std=c11`). The oldest I tried was 4.7.3. Since GDSL
  requires C11 I think that effectively rules out any Microsoft compiler.
* Python 2.7.4 is the only Python version tested. Nothing version-specific is in there as far as I can tell though.
* Python dev package (for headers that go with your version of Python).
* Python distutils.
* SWIG.
* [GDSL](http://code.google.com/p/gdsl-toolkit/). Clone the repository, read the installation instructions for
  prerequisites (Standard ML, libelf, and whatever else it says), then follow this process to install:

        cd $GDSL_DIR
        autoreconf -i
        ./configure --enable-install-auxbins --enable-build-auxbins --enable-install-auxlibs --enable-build-auxlibs
        make
        sudo make install
        sudo ldconfig

#Installation

Extract the source folder within the `gdsl-toolkit` repository folder.

If everything works, just running `make` in the `pygdsl` folder will build the library wrappers. You
can test with `make test` to run all the tests (you might want to pipe that output to a file or pager,
it's much too fast to read).

To install on the system globally, run `make install` or `python setup.py install` as root.

#Potential Pitfalls

1. If you manually compile and install a library on your system, the build system should run `ldconfig` automatically.
   If you find libraries you apparently installed coming up missing, that's a good clue.
2. These functions can't work on arbitrary binary files. Although the original GDSL library has linkage to use
   libelf to seek within ELF binaries, we don't use that functionality. Someone with more disassembly experience
   probably knows how to get binary blocks without symbols in them. I don't remember how I produced the test set of
   instructions in `a.bin`, but it involved a compiler, an assembler, and `objcopy` from GNU binutils.
3. Don't try to compile without distutils. After a lot of concerted effort debugging a nasty segfault,
   it turned out that switching the build to distutils fixed it. I have no idea which options were incompatible,
   I just found that someone suggested solving that error this way on Stack Overflow. As it turns out distutils is
   also recommended in the SWIG manual and I glanced over that section because I thought it would be simpler to
   do it manually for such a small wrapper file. I was mistaken....
4. The maximum error message size is defined in `pygdsl_error.h`. If you require a longer buffer to hold your
   error messages, you'll have to change that file and reinstall because the buffer is a static char array.

#Usage

If you are not installing system-wide, you must set the Python path appropriately. Example:

    export PYTHONPATH=$PYTHONPATH:/home/user/pygdsl

Check the installation by running this command: `python tests/single_instrs.py`. You should get
this output:

    export PYTHONPATH=.
    python tests/single_instrs.py
    ; b8 05 00 00 00      mov eax, 0x5
    FLAGS.9 =:1 1
    A =:32 5
    A.32 =:32 0

    ; 81 c3 04 00 00 00   add ebx, 0x4
    FLAGS.9 =:1 1
    T0 =:32 (B + 4)
    T1 =:32 T0 ^ B
    T2 =:32 T0 ^ 4
    T3 =:32 T1 & T2
    FLAGS.11 =:1 T3 <s:32 0
    FLAGS.7 =:1 T0 <s:32 0
    FLAGS.6 =:1 T0 ==:32 0
    FLAGS =:1 T0 <u:32 B
    T4 =:8 T0
    FLAGS.2 =:1 T4.7 ==:1 T4.6
    FLAGS.2 =:1 FLAGS.2 ==:1 T4.5
    FLAGS.2 =:1 FLAGS.2 ==:1 T4.4
    FLAGS.2 =:1 FLAGS.2 ==:1 T4.3
    FLAGS.2 =:1 FLAGS.2 ==:1 T4.2
    FLAGS.2 =:1 FLAGS.2 ==:1 T4.1
    FLAGS.2 =:1 FLAGS.2 ==:1 T4
    T5 =:32 T0 ^ B
    T5 =:32 T5 ^ 4
    T5 =:32 T5 & 16
    FLAGS.4 =:1 T5 !=:32 0
    LEU =:1 FLAGS | FLAGS.6
    LTS =:1 FLAGS.7 !=:1 FLAGS.11
    LES =:1 LTS | FLAGS.6
    B =:32 T0
    B.32 =:32 0

    ; 0f af c3            imul eax, ebx
    FLAGS.9 =:1 1
    T0 =:64 sx[32->64]A
    T1 =:64 sx[32->64]B
    T2 =:64 T0 * T1
    T3 =:33 sx[1->33]T2.63
    FLAGS.11 =:1 T2.31 !=:33 T3
    FLAGS =:1 FLAGS.11
    FLAGS.7 =:1 arbitrary
    FLAGS.6 =:1 arbitrary
    FLAGS.4 =:1 arbitrary
    FLAGS.2 =:1 arbitrary
    LEU =:1 FLAGS | FLAGS.6
    LTS =:1 FLAGS.7 !=:1 FLAGS.11
    LES =:1 LTS | FLAGS.6
    A =:32 T2
    A.32 =:32 0

    Successfully generated exception:
    Exception message: decode failed: UnsatisfiableGuardCombination

#Authorship Attribution

Pygdsl has been developed by Jessie Castille.
