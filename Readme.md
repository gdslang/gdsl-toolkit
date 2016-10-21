# GDSL Toolkit

This section describes how the GDSL toolkit is built and which dependencies are
required.

## Dependencies

The GDSL compiler and core libraries require the following software to be on the
current search PATH:

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

# Using the Gdsl Java Library

*This section is not up-to-date as CMake integration for the Java library is
currently missing*

In order to use the Gdsl Java library, one has to instruct Automake to install
auxiliary libraries. This is done by passing the "--enable-install-auxlibs"
option to "./configure". Additionally, one has to make sure that the JNI header
file ("jni.h") can be found. For example, if the JNI header can be found in the
"/usr/lib/jvm/java-7-openjdk-amd64/include/" directory, then one would need to
run "./configure" in the following way:

C_INCLUDE_PATH="/usr/lib/jvm/java-7-openjdk-amd64/include/" ./configure --enable-install-auxlibs
