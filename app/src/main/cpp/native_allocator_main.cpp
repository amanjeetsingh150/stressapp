#include "include/jni_interface.h"


class MyClass {
public:
    long *first;
};

extern "C"
JNIEXPORT void JNICALL
Java_me_amanjeet_stressapp_NativeAllocationReceiver_allocateMemory(
        JNIEnv *env,
        jobject thiz,
        jint number_of_objects
) {
    if (number_of_objects > 0) {
        for (int i = 0; i < number_of_objects; i++) {
            auto *myClass = new MyClass;
            myClass->first = new long[100000000];
        }
    }
}