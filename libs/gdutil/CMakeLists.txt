cmake_minimum_required (VERSION 2.8)
project (gdutil)

file(GLOB_RECURSE SOURCES
  "src/**.c"
)

function(gdutil fend)
  add_library(gdutil_${fend} ${SOURCES})
  target_include_directories(gdutil_${fend} PUBLIC include/)
  set_target_properties(gdutil_${fend} PROPERTIES COMPILE_FLAGS "-std=c11 -m32")
  target_link_libraries(gdutil_${fend} multiplex_stub_${fend})
endfunction(gdutil)

foreach(fend ${FRONTENDS})
  gdutil(${fend})
endforeach(fend)
