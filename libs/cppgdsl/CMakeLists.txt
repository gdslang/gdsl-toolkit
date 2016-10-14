#set(CMAKE_CXX_COMPILER "/usr/bin/clang++")

cmake_minimum_required (VERSION 2.8)
project (cppgdsl)

file(GLOB_RECURSE SOURCES
    "src/**.cpp"
)

add_library(cppgdsl ${SOURCES})
set_target_properties(cppgdsl PROPERTIES CXX_STANDARD 11)
target_include_directories(cppgdsl PUBLIC
  $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/include/>
  $<INSTALL_INTERFACE:include/>  # <prefix>/include/
)
target_link_libraries(cppgdsl multiplex)

list(APPEND EXPORT_LIBRARIES cppgdsl)
install(TARGETS cppgdsl
  # IMPORTANT: Add the library to the "export-set"
  EXPORT gdslTargets
  RUNTIME DESTINATION "${INSTALL_BIN_DIR}" COMPONENT bin
  LIBRARY DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
  ARCHIVE DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
  PUBLIC_HEADER DESTINATION "${INSTALL_INCLUDE_DIR}/"
    COMPONENT dev)

set (EXPORT_LIBRARIES ${EXPORT_LIBRARIES} PARENT_SCOPE)
