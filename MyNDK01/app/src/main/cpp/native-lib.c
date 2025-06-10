#include <jni.h>
#include <string.h>

// 传递和返回整数
JNIEXPORT jint JNICALL
Java_com_example_ndkdemo_MainActivity_intFromJNI(JNIEnv* env, jobject thiz, jint input) {
    return input * 2; // 简单地乘2返回
}

// 传递和返回字符串
JNIEXPORT jstring JNICALL
Java_com_example_ndkdemo_MainActivity_stringFromJNI(JNIEnv* env, jobject thiz, jstring input) {
    const char *inC = (*env)->GetStringUTFChars(env, input, 0);
    char outC[100] = "Echo from C: ";
    strncat(outC, inC, 80);
    (*env)->ReleaseStringUTFChars(env, input, inC);
    return (*env)->NewStringUTF(env, outC);
}


