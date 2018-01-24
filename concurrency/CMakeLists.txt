cmake_minimum_required(VERSION 3.9)
project(concurrency)

set(CMAKE_CXX_STANDARD 17)
SET(CMAKE_CXX_FLAGS -pthread)

add_executable(concurrency main.cpp)