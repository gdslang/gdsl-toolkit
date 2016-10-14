#set(CMAKE_CXX_COMPILER "/usr/bin/clang++")

cmake_minimum_required (VERSION 2.8)
project (cppgdsl)

file(GLOB_RECURSE SOURCES
    "src/**.cpp"
)

# The following line is the correct way to switch C++ standard.
# However, this doesn't seem to work with CMake 2.8.
#set_property(TARGET cppgdsl PROPERTY CXX_STANDARD 11)

macro(cppgdsl fend)
  add_library(cppgdsl_${fend} ${SOURCES})
  set_target_properties(cppgdsl_${fend} PROPERTIES COMPILE_FLAGS "-fPIC -std=c++11")
  target_include_directories(cppgdsl_${fend} PUBLIC
    $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/include/>
    $<INSTALL_INTERFACE:include/>  # <prefix>/include/
  )
  target_link_libraries(cppgdsl_${fend} multiplex_${fend})
  
  list(APPEND EXPORT_LIBRARIES cppgdsl_${fend})
  install(TARGETS cppgdsl_${fend}
    # IMPORTANT: Add the library to the "export-set"
    EXPORT gdslTargets
    RUNTIME DESTINATION "${INSTALL_BIN_DIR}" COMPONENT bin
    LIBRARY DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
    ARCHIVE DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
    PUBLIC_HEADER DESTINATION "${INSTALL_INCLUDE_DIR}/"
      COMPONENT dev)
endmacro(cppgdsl)

foreach(fend ${FRONTENDS})
  cppgdsl(${fend})
endforeach(fend)

set (EXPORT_LIBRARIES ${EXPORT_LIBRARIES} PARENT_SCOPE)
