#!/usr/bin/env python

"""
setup.py file for SWIG example
"""

from distutils.core import setup, Extension

pygdsl_extension = Extension(
                        name = '_pygdsl',
                        sources = ['pygdsl.i', 'pygdsl_impl.c'],
                        include_dirs = ['../','./'],
                        library_dirs = ['/usr/local/lib/'],
                        libraries = ['gdsl-x86-rreil'],
                        define_macros = [('HAVE_CONFIG_H','1'), ('GDSL_X86','1')],
                        extra_compile_args = ['-std=c11']
                        )

setup(name = 'pygdsl',
      version = '0.1',
      author      = "Jessie Castille",
      description = """Simple SWIG wrapper for GDSL""",
      ext_modules = [pygdsl_extension],
      py_modules = ["pygdsl"],
      )
