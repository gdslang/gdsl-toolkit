cmake_minimum_required (VERSION 2.8)
project (jgdsl)

find_package (JNI)
find_package (Java)
include(UseJava)
find_file(JUnit_PATH junit4.jar HINTS /usr/share/java)
string(COMPARE EQUAL ${JUnit_PATH} "JUnit_PATH-NOTFOUND" NO_JUNIT)

if(JNI_FOUND AND Java_FOUND AND NOT ${NO_JUNIT})
  file(GLOB_RECURSE C_SOURCES
    "src/**.c"
  )
  add_library(jgdsl SHARED ${C_SOURCES})
  set_target_properties(jgdsl PROPERTIES C_STANDARD 11)
  target_include_directories(jgdsl PRIVATE ${JNI_INCLUDE_DIRS})
  target_link_libraries(jgdsl multiplex ${JNI_LIBRARIES})
  
  file(GLOB_RECURSE JAVA_SOURCES
    "src/**.java"
  )
  
  add_jar(jgdsl-jar
    SOURCES ${JAVA_SOURCES}
    INCLUDE_JARS ${JUnit_PATH}
  # [ENTRY_POINT entry]
  # [VERSION version]
    OUTPUT_NAME jgdsl
  # [OUTPUT_DIR dir]
  )
  
  list(APPEND EXPORT_LIBRARIES jgdsl)
  install(TARGETS jgdsl
    # IMPORTANT: Add the library to the "export-set"
    EXPORT gdslTargets
    RUNTIME DESTINATION "${INSTALL_BIN_DIR}" COMPONENT bin
    LIBRARY DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
    ARCHIVE DESTINATION "${INSTALL_LIB_DIR}" COMPONENT lib
    PUBLIC_HEADER DESTINATION "${INSTALL_INCLUDE_DIR}/"
      COMPONENT dev)
  
  set (EXPORT_LIBRARIES ${EXPORT_LIBRARIES} PARENT_SCOPE)
else()
  message("-- --> Java, JNI, or JUnit not found - excluding Java bindings...")
endif()
