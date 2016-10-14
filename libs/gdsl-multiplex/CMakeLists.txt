cmake_minimum_required (VERSION 2.8)
project (multiplex)

file(GLOB_RECURSE SOURCES
  "src/**.c"
)

macro(multiplex fend)
  add_library(multiplex_${fend} ${SOURCES})
  target_include_directories(multiplex_${fend} PUBLIC
    $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/include/>
    $<INSTALL_INTERFACE:include/>  # <prefix>/include/
  )
  set_target_properties(multiplex_${fend} PROPERTIES C_STANDARD 11)
  target_link_libraries(multiplex_${fend} dl)

  list(APPEND EXPORT_LIBRARIES multiplex_${fend})
  install(TARGETS multiplex_${fend}
    # IMPORTANT: Add the library to the "export-set"
    EXPORT gdslTargets
    RUNTIME DESTINATION "${INSTALL_BIN_DIR}" COMPONENT bin
    LIBRARY DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
    ARCHIVE DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
    PUBLIC_HEADER DESTINATION "${INSTALL_INCLUDE_DIR}/"
      COMPONENT dev)
endmacro(multiplex)

foreach(fend ${FRONTENDS})
  multiplex(${fend})
endforeach(fend)

set (EXPORT_LIBRARIES ${EXPORT_LIBRARIES} PARENT_SCOPE)
