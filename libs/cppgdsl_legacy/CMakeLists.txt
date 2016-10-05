cmake_minimum_required (VERSION 2.8)
project (cppgdsl)

file(GLOB_RECURSE SOURCES
    "src/**.cpp"
)

include_directories("include/")

add_library(cppgdsl ${SOURCES})
set_property(TARGET cppgdsl PROPERTY CXX_STANDARD 11)
