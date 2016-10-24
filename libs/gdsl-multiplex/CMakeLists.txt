cmake_minimum_required (VERSION 2.8)
project (multiplex)

file(GLOB_RECURSE SOURCES
  "src/**.c"
)

add_library(multiplex SHARED ${SOURCES})
target_include_directories(multiplex PUBLIC
  $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/include/>
  $<INSTALL_INTERFACE:include/>  # <prefix>/include/
)
set_target_properties(multiplex PROPERTIES C_STANDARD 11)
target_link_libraries(multiplex dl)

list(APPEND EXPORT_LIBRARIES multiplex)
install(TARGETS multiplex
  # IMPORTANT: Add the library to the "export-set"
  EXPORT gdslTargets
  RUNTIME DESTINATION "${INSTALL_BIN_DIR}" COMPONENT bin
  LIBRARY DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
  ARCHIVE DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
  PUBLIC_HEADER DESTINATION "${INSTALL_INCLUDE_DIR}/"
    COMPONENT dev)

set (EXPORT_LIBRARIES ${EXPORT_LIBRARIES} PARENT_SCOPE)
