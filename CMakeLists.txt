cmake_minimum_required (VERSION 2.8)
project (gdsl)

set(GDSL_MAJOR_VERSION 1)
set(GDSL_MINOR_VERSION 1)
set(GDSL_PATCH_VERSION 0)
set(GDSL_VERSION
  ${GDSL_MAJOR_VERSION}.${GDSL_MINOR_VERSION}.${GSDL_PATCH_VERSION})

# Offer the user the choice of overriding the installation directories
set(INSTALL_LIB_DIR lib CACHE PATH "Installation directory for libraries")
set(INSTALL_BIN_DIR bin CACHE PATH "Installation directory for executables")
set(INSTALL_INCLUDE_DIR include CACHE PATH
  "Installation directory for header files")
if(WIN32 AND NOT CYGWIN)
  set(DEF_INSTALL_CMAKE_DIR CMake)
else()
  set(DEF_INSTALL_CMAKE_DIR lib/CMake/gdsl)
endif()
set(INSTALL_CMAKE_DIR ${DEF_INSTALL_CMAKE_DIR} CACHE PATH
  "Installation directory for CMake files")

# Make relative paths absolute (needed later on)
foreach(p LIB BIN INCLUDE CMAKE)
  set(var INSTALL_${p}_DIR)
  if(NOT IS_ABSOLUTE "${${var}}")
    set(${var} "${CMAKE_INSTALL_PREFIX}/${${var}}")
  endif()
endforeach()

file(GLOB_RECURSE MLTON_SOURCES
  "detail/**.ml"
)

add_custom_command(COMMAND mlton -output ${CMAKE_BINARY_DIR}/gdslc ${CMAKE_SOURCE_DIR}/gdslc.mlb
  OUTPUT ${CMAKE_BINARY_DIR}/gdslc
  DEPENDS gdslc.mlb ${MLTON_SOURCES}
)

macro(frontend fend sources)
  set(sources_merged ${sources} ${ARGN})
  list(APPEND FRONTENDS ${fend})
  add_custom_command(COMMAND ${CMAKE_BINARY_DIR}/gdslc --maxIter=42
    --runtime=${CMAKE_CURRENT_SOURCE_DIR}/detail/codegen
    --outname=gdsl-${fend}-rreil
    ${sources_merged}
    OUTPUT gdsl-${fend}-rreil.c gdsl-${fend}-rreil.h
    DEPENDS ${CMAKE_BINARY_DIR}/gdslc ${sources_merged}
  )
  add_library(gdsl_${fend}_rreil SHARED gdsl-${fend}-rreil.c)
  set_target_properties(gdsl_${fend}_rreil PROPERTIES C_STANDARD 11)
  target_include_directories(gdsl_${fend}_rreil PUBLIC
    $<BUILD_INTERFACE: ${CMAKE_BINARY_DIR}/ arch/${fend}/>
    $<INSTALL_INTERFACE:arch/${fend}/> $<INSTALL_INTERFACE:${INSTALL_BIN_DIR}>  # <prefix>/include/
  )
  string(TOUPPER ${fend} FEND)
  target_compile_definitions(gdsl_${fend}_rreil PUBLIC "USE_${FEND}_RREIL")

  list(APPEND EXPORT_LIBRARIES gdsl_${fend}_rreil)
  install(TARGETS gdsl_${fend}_rreil
    # IMPORTANT: Add the library to the "export-set"
    EXPORT gdslTargets
    RUNTIME DESTINATION "${INSTALL_BIN_DIR}" COMPONENT bin
    LIBRARY DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
    ARCHIVE DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
    PUBLIC_HEADER DESTINATION "${INSTALL_INCLUDE_DIR}/"
      COMPONENT dev)
endmacro(frontend)

set(GDSL_DIR ${CMAKE_CURRENT_SOURCE_DIR}/specifications)

set(FRONTEND_SRCS_COMMON
  ${GDSL_DIR}/basis/prelude.ml
  ${GDSL_DIR}/basis/bbtree.ml
  ${GDSL_DIR}/basis/tree-set.ml
  ${GDSL_DIR}/rreil/rreil.ml
  ${GDSL_DIR}/rreil/rreil-examples.ml
  ${GDSL_DIR}/rreil/rreil-cif.ml
  ${GDSL_DIR}/rreil/rreil-pretty.ml
  ${GDSL_DIR}/rreil/fmap.ml
  ${GDSL_DIR}/rreil/rreil-opt.ml
  ${GDSL_DIR}/rreil/rreil-translator.ml
  ${GDSL_DIR}/rreil/rreil-liveness.ml
  ${GDSL_DIR}/rreil/rreil-forward-subst.ml
  ${GDSL_DIR}/rreil/forward-subst/delayed-forward-subst/inline.ml
  ${GDSL_DIR}/rreil/forward-subst/delayed-forward-subst/substitute.ml
  ${GDSL_DIR}/rreil/forward-subst/delayed-forward-subst/substmap.ml
  ${GDSL_DIR}/rreil/forward-subst/forward-subst/inline.ml
  ${GDSL_DIR}/rreil/forward-subst/forward-subst/substitute.ml
  ${GDSL_DIR}/rreil/forward-subst/forward-subst/substmap.ml
  ${GDSL_DIR}/rreil/forward-subst/forward-subst/simplify-expressions.ml
  ${GDSL_DIR}/rreil/rreil-cleanup.ml
  ${GDSL_DIR}/asm/asm.ml
  ${GDSL_DIR}/asm/asm-pretty.ml
  ${GDSL_DIR}/asm/asm-cif.ml
)

frontend(x86 ${FRONTEND_SRCS_COMMON}
  ${GDSL_DIR}/x86/x86.ml
  ${GDSL_DIR}/x86/x86-equals.ml
  ${GDSL_DIR}/x86/x86-traverse.ml
  ${GDSL_DIR}/x86/x86-pretty.ml
  ${GDSL_DIR}/x86/x86-asm.ml
  ${GDSL_DIR}/x86/x86-semantics-mapping.ml
  ${GDSL_DIR}/x86/x86-semantics-mapping-pretty.ml
  ${GDSL_DIR}/x86/x86-rreil-translator.ml
  ${GDSL_DIR}/x86/x86-rreil-translator-a-l.ml
  ${GDSL_DIR}/x86/x86-rreil-translator-m-z.ml
  ${GDSL_DIR}/x86/x86-liveness.ml
  ${GDSL_DIR}/x86-tester/x86-pretty-simple.ml
)

frontend(avr ${FRONTEND_SRCS_COMMON}
  ${GDSL_DIR}/avr/avr.ml
  ${GDSL_DIR}/avr/avr-traverse.ml
  ${GDSL_DIR}/avr/avr-pretty.ml
  ${GDSL_DIR}/avr/avr-asm.ml
  ${GDSL_DIR}/avr/avr-rreil-pretty.ml
  ${GDSL_DIR}/avr/avr-rreil-registermapping.ml
  ${GDSL_DIR}/avr/avr-rreil-translator.ml
  ${GDSL_DIR}/avr/avr-liveness.ml
)

frontend(arm7 ${FRONTEND_SRCS_COMMON}
  ${GDSL_DIR}/arm7/arm7.ml
  ${GDSL_DIR}/arm7/arm7-pretty.ml
  ${GDSL_DIR}/arm7/arm7-asm.ml
  ${GDSL_DIR}/arm7/arm7-rreil-registermapping.ml
  ${GDSL_DIR}/arm7/arm7-rreil-translator.ml
  ${GDSL_DIR}/arm7/arm7-rreil-pretty.ml
  ${GDSL_DIR}/arm7/arm7-liveness.ml
)

frontend(mips ${FRONTEND_SRCS_COMMON}
  ${GDSL_DIR}/mips/mips.ml
  ${GDSL_DIR}/mips/mips-pretty.ml
  ${GDSL_DIR}/mips/mips-rreil-pretty.ml
  ${GDSL_DIR}/mips/mips-rreil-registermapping.ml
  ${GDSL_DIR}/mips/mips-rreil-translator.ml
  ${GDSL_DIR}/mips/mips-liveness.ml
  ${GDSL_DIR}/mips/mips-asm.ml
  ${GDSL_DIR}/mips/mips-traverse.ml
  ${GDSL_DIR}/mips/mips_r6.ml
  ${GDSL_DIR}/mips/mips-pretty_r6.ml
  ${GDSL_DIR}/mips/mips-rreil-translator_r6.ml
  ${GDSL_DIR}/mips/mips-asm_r6.ml
  ${GDSL_DIR}/mips/mips-traverse_r6.ml
)

add_subdirectory(libs)
add_subdirectory(tools)

# Add all targets to the build-tree export set
export(TARGETS ${EXPORT_LIBRARIES}
  FILE "${PROJECT_BINARY_DIR}/gdslTargets.cmake")

# Export the package for use from the build-tree
# (this registers the build-tree with a global CMake-registry)
export(PACKAGE gdsl)

# Create the gdslConfig.cmake and gdslConfigVersion files
file(RELATIVE_PATH REL_INCLUDE_DIR "${INSTALL_CMAKE_DIR}"
   "${INSTALL_INCLUDE_DIR}")
# ... for the build tree
set(CONF_INCLUDE_DIRS "${PROJECT_SOURCE_DIR}" "${PROJECT_BINARY_DIR}")
configure_file(gdslConfig.cmake.in
  "${PROJECT_BINARY_DIR}/gdslConfig.cmake" @ONLY)
# ... for the install tree
set(CONF_INCLUDE_DIRS "\${FOOBAR_CMAKE_DIR}/${REL_INCLUDE_DIR}")
configure_file(gdslConfig.cmake.in
  "${PROJECT_BINARY_DIR}${CMAKE_FILES_DIRECTORY}/gdslConfig.cmake" @ONLY)
# ... for both
configure_file(gdslConfigVersion.cmake.in
  "${PROJECT_BINARY_DIR}/gdslConfigVersion.cmake" @ONLY)

# Install the gdslConfig.cmake and gdslConfigVersion.cmake
install(FILES
  "${PROJECT_BINARY_DIR}${CMAKE_FILES_DIRECTORY}/gdslConfig.cmake"
  "${PROJECT_BINARY_DIR}/gdslConfigVersion.cmake"
  DESTINATION "${INSTALL_CMAKE_DIR}" COMPONENT dev)

# Install the export set for use with the install-tree
install(EXPORT gdslTargets DESTINATION
  "${INSTALL_CMAKE_DIR}" COMPONENT dev)
