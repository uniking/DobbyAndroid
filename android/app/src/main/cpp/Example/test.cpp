#include <jni.h>
#include "../Dobby/include/dobby.h"

#define JNI_API_DEF(f) Java_test10_def_abc_dobbyandroid_MainActivity_##f

int myadd(int a, int b) {
    return a+b;
}

int new_myadd(int a, int b){
    return a+b+1;
}

void *origin_call;

extern "C"{
int JNI_API_DEF(testadd)(
        JNIEnv *env,
        jobject /* this */,
        jint a,
        jint b) {

    return myadd(a, b);
}

void JNI_API_DEF(hookadd)(
        JNIEnv *env,
        jobject /* this */) {
    DobbyHook((void*)myadd, (void*)new_myadd, (void**)&origin_call);
}

}
