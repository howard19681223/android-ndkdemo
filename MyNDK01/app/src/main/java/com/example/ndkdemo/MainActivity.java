package com.example.ndkdemo;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("native-lib");
    }

    // JNI 方法声明
    public native int intFromJNI(int input);
    public native String stringFromJNI(String input);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int inputInt = 42;
        String inputStr = "Hello NDK";
        int resultInt = intFromJNI(inputInt);
        String resultStr = stringFromJNI(inputStr);

        TextView tv = new TextView(this);
        tv.setText(
            "Java->C int: " + inputInt + " => " + resultInt + "\n" +
            "Java->C str: " + inputStr + " => " + resultStr
        );
        setContentView(tv);
    }
}

