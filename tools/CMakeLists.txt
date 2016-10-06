cmake_minimum_required (VERSION 2.8)
project (gdsl-tools)

# The following line is the correct way to switch C++ standard.
# However, this doesn't seem to work with CMake 2.8.
#set_property(TARGET cppgdsl PROPERTY CXX_STANDARD 11)

function(semantics_cli fend)
  add_executable(semantics_cli_${fend} semantics-cli.c)
  set_target_properties(semantics_cli_${fend} PROPERTIES COMPILE_FLAGS "-std=c11 -m32")
  set_target_properties(semantics_cli_${fend} PROPERTIES LINK_FLAGS "-m32")
  target_link_libraries(semantics_cli_${fend} readhex gdutil_${fend})
endfunction(semantics_cli)

function(decoder_cli fend)
  add_executable(decoder_cli_${fend} decoder-cli.c)
  set_target_properties(decoder_cli_${fend} PROPERTIES COMPILE_FLAGS "-std=c11 -m32")
  set_target_properties(decoder_cli_${fend} PROPERTIES LINK_FLAGS "-m32")
  target_link_libraries(decoder_cli_${fend} readhex gdutil_${fend})
endfunction(decoder_cli)

function(semantics_opt fend)
  add_executable(semantics_opt_${fend} semantics-opt.c)
  set_target_properties(semantics_opt_${fend} PROPERTIES COMPILE_FLAGS "-std=c11 -m32")
  set_target_properties(semantics_opt_${fend} PROPERTIES LINK_FLAGS "-m32")
  target_link_libraries(semantics_opt_${fend} multiplex_stub_${fend} gdutil_${fend} elf)
endfunction(semantics_opt)

function(semantics_cif_cli fend)
  add_executable(semantics_cif_cli_${fend} semantics-cif-cli.c)
  set_target_properties(semantics_cif_cli_${fend} PROPERTIES COMPILE_FLAGS "-std=c11 -m32")
  set_target_properties(semantics_cif_cli_${fend} PROPERTIES LINK_FLAGS "-m32")
  target_link_libraries(semantics_cif_cli_${fend} multiplex_stub_${fend} gdutil_${fend} readhex)
endfunction(semantics_cif_cli)

function(cppgdsl_demo fend)
  add_executable(cppgdsl_demo_${fend} cppgdsl-demo.cpp)
  set_target_properties(cppgdsl_demo_${fend} PROPERTIES COMPILE_FLAGS "-std=c++11 -m32")
  set_target_properties(cppgdsl_demo_${fend} PROPERTIES LINK_FLAGS "-m32")
  target_link_libraries(cppgdsl_demo_${fend} cppgdsl_${fend})
endfunction(cppgdsl_demo)

foreach(fend ${FRONTENDS})
  semantics_cli(${fend})
  decoder_cli(${fend})
  semantics_opt(${fend})
  semantics_cif_cli(${fend})
  cppgdsl_demo(${fend})
endforeach(fend)
