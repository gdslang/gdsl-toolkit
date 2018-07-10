# GDSL Toolkit

The GDSL toolkit is a software framework for specifying machine language
decoders. It is meant to allow a natural specification that resembles the way
the vendor manuals describe the instruction set. The toolkit comes with a set
of decoders, semantics translators to the analysis-friendly intermediate
reprensentation RReil, IR optimizations, and bindings to other programming
languages such as C++ and Java.

## Dependencies

This section describes how the GDSL toolkit is built and which dependencies
are required. The GDSL compiler and core libraries require the following
software to be on the current search PATH:

* MLton
* CMake
* A C11 and a C++11 compiler 

Furthermore, the following software packages and features are required by some
of the optional demo applications:

* Libelf (http://www.mr511.de/software/) [>= version 0.152] 

### Building the Toolkit

The toolkit can be built using CMake:

```bash
cd gdsl-toolkit/
mkdir build
cd build/
cmake ..
make
```

This command will build the toolkit for all available architectures. To build a
specific architecture, specify the respective target:

```bash
...
make gdsl_x86_rreil
```

Here, we build the x86 frontend. Similarly, targets for specific libraries or
tools can be specified.

# Demos and Libraries

The GDSL toolkit contains a number of demo applications and libraries. The tools
and libraries are presented in wiki (http://code.google.com/p/gdsl-toolkit/).

# Roadmap

* Architectures
  * Full support for ARMv7 and ARMv8
* Testing
  * Support testing of all our architectures (reusing common parts of the tester)
  * Testing of the decoder by reacting to / expecting illegal instruction exceptions