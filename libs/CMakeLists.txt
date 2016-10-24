cmake_minimum_required (VERSION 2.8)
project (gdsl-libs)

add_subdirectory(gdsl-multiplex)
add_subdirectory(cppgdsl)
add_subdirectory(readhex)
add_subdirectory(gdutil)
add_subdirectory(jgdsl)

set (EXPORT_LIBRARIES ${EXPORT_LIBRARIES} PARENT_SCOPE)
