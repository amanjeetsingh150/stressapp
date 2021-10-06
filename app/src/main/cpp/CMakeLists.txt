cmake_minimum_required(VERSION 3.4.1)

add_library(stress SHARED native_allocator_main.cpp)

include_directories(include)

target_link_libraries(stress android log)