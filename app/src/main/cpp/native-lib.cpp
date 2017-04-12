#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_azrhei_net_noiseatlas_StartSplashActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
