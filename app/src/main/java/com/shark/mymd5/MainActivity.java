package com.shark.mymd5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.shark.mymd5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'mymd5' library on application startup.
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
        TextView tv = binding.sampleText;
        tv.setText(getJniString("123456"));
    }

    public native String getJniString(String json);

    /**
     * A native method that is implemented by the 'mymd5' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();
}