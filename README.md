# What is it?

This is a simplified Python wrapper for [GDSL](http://code.google.com/p/gdsl-toolkit/).

# Prerequisites

* Linux. Only Ubuntu-like systems are tested right now.
* A recent version of GCC that supports the C11 standard (`-std=c11`). The oldest I tried was 4.7.3.
* [GDSL](http://code.google.com/p/gdsl-toolkit/). Clone the repository, read the installation instructions for
  prerequisites (Standard ML, libelf, and whatever else it says), then follow this process to install:

        cd $GDSL_DIR
        autoreconf -i
        ./configure --enable-install-auxbins --enable-build-auxbins --enable-install-auxlibs --enable-build-auxlibs
        make
        sudo make install
        sudo ldconfig

* Python dev package (for headers).
* Python distutils.
* SWIG.

#Installation

Extract the source folder within the `gdsl-toolkit` repository folder.

If everything works, just running `make` in the `pygdsl` folder will build the library wrappers. You
can test with `make test` to run all the tests (you might want to pipe that output to a file or pager,
it's much too fast to read).

To install on the system globally, run `make install` or `python setup.py install` as root.

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

