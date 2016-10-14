cmake_minimum_required (VERSION 2.8)
project (gdutil)

file(GLOB_RECURSE SOURCES
  "src/**.c"
)

macro(gdutil fend)
  add_library(gdutil_${fend} ${SOURCES})
  target_include_directories(gdutil_${fend} PUBLIC
    $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/include/>
    $<INSTALL_INTERFACE:include/>  # <prefix>/include/
  )
  set_target_properties(gdutil_${fend} PROPERTIES C_STANDARD 11)

  list(APPEND EXPORT_LIBRARIES gdutil_${fend})
  install(TARGETS gdutil_${fend}
    # IMPORTANT: Add the library to the "export-set"
    EXPORT gdslTargets
    RUNTIME DESTINATION "${INSTALL_BIN_DIR}" COMPONENT bin
    LIBRARY DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
    ARCHIVE DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
    PUBLIC_HEADER DESTINATION "${INSTALL_INCLUDE_DIR}/"
      COMPONENT dev)
endmacro(gdutil)

foreach(fend ${FRONTENDS})
  gdutil(${fend})
endforeach(fend)

set (EXPORT_LIBRARIES ${EXPORT_LIBRARIES} PARENT_SCOPE)
