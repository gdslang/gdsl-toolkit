cmake_minimum_required (VERSION 2.8)
project (readhex)

file(GLOB_RECURSE SOURCES
  "src/**.c"
)

add_library(readhex ${SOURCES})
set_target_properties(readhex PROPERTIES COMPILE_FLAGS "-std=c11")
target_include_directories(readhex PUBLIC
  $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/include/>
  $<INSTALL_INTERFACE:include/>  # <prefix>/include/
)

list(APPEND EXPORT_LIBRARIES readhex)
install(TARGETS readhex
  # IMPORTANT: Add the readhex library to the "export-set"
  EXPORT gdslTargets
  RUNTIME DESTINATION "${INSTALL_BIN_DIR}" COMPONENT bin
  LIBRARY DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
  ARCHIVE DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
  PUBLIC_HEADER DESTINATION "${INSTALL_INCLUDE_DIR}/"
    COMPONENT dev)

set(EXPORT_LIBRARIES ${EXPORT_LIBRARIES} PARENT_SCOPE)
