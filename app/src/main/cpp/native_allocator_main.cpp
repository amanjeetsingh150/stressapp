#include <malloc.h>
#include "include/jni_interface.h"
#include <android/log.h>

#define MODULE_NAME "STRESSAPP"

class MyClass {
public:
    long *first;
};

extern "C"
JNIEXPORT jint JNICALL
Java_me_amanjeet_stressapp_NativeAllocationReceiver_allocateMemory(
        JNIEnv *env,
        jobject thiz,
        jint number_of_objects
) {
    struct mallinfo before{}, after{};
    before = mallinfo();
    unsigned int mused;
    if (number_of_objects > 0) {
        for (int i = 0; i < number_of_objects; i++) {
            auto *myClass = new MyClass;
            myClass->first = new long[10000000];
        }
    }
    after = mallinfo();
    mused = after.uordblks - before.uordblks;
    __android_log_print(ANDROID_LOG_DEBUG, MODULE_NAME, "%d bytes allocated", mused);
    return mused;
}