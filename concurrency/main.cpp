#include <iostream>
#include <thread>

void SayHello() {
    std::cout << "Hello, World!\n";
}

int main() {
    std::thread helloThread(SayHello);
    helloThread.join();
    return 0;
}