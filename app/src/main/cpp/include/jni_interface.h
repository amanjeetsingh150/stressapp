#include <jni.h>

#ifndef STRESSAPP_JNI_INTERFACE_H
#define STRESSAPP_JNI_INTERFACE_H


extern "C"
JNIEXPORT jint JNICALL
Java_me_amanjeet_stressapp_NativeAllocationReceiver_allocateMemory(
        JNIEnv *env,
        jobject thiz,
        jint number_of_objects
);


#endif
