cmake_minimum_required (VERSION 2.8)
project (memstream)

file(GLOB_RECURSE SOURCES
  "src/**.c"
)

add_library(memstream SHARED ${SOURCES})
target_include_directories(memstream PUBLIC
  $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/include/>
  $<INSTALL_INTERFACE:include/>  # <prefix>/include/
)
set_target_properties(memstream PROPERTIES C_STANDARD 11)

list(APPEND EXPORT_LIBRARIES memstream)
install(TARGETS memstream
  # IMPORTANT: Add the library to the "export-set"
  EXPORT gdslTargets
  RUNTIME DESTINATION "${INSTALL_BIN_DIR}" COMPONENT bin
  LIBRARY DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
  ARCHIVE DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
  PUBLIC_HEADER DESTINATION "${INSTALL_INCLUDE_DIR}/"
    COMPONENT dev)

set (EXPORT_LIBRARIES ${EXPORT_LIBRARIES} PARENT_SCOPE)
