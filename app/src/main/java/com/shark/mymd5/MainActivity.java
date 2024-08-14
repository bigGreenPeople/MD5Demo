package com.shark.mymd5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.shark.mymd5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'mymd5' library on application startup.
    // frida -U -f com.shark.mymd5 -l hook_art.js
    static {
        System.loadLibrary("mymd5");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
    }

    public void test(View view) {
        TextView tv = binding.sampleText;

        tv.setText(getJniString(binding.etTest.getText().toString()));
    }

    public native String getJniString(String json);

    /**
     * A native method that is implemented by the 'mymd5' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();
}