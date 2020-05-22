package com.wmj.jetpackdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.wmj.jetpackdemo.ui.main.MainFragment;
import com.wmj.lib_annotations.RandomInt;
import com.wmj.lib_annotations.RandomString;
import com.wmj.lib_api.RandomUtils;

public class MainActivity extends AppCompatActivity {
    @RandomInt(minValue = 10, maxValue = 1000)
    int mRandomInt;
    @RandomString
    String mRandomString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        RandomUtils.inject(this);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

        Log.e("RandomInt",mRandomInt+"");
        Log.e("RandomString",mRandomString+"");
    }
}
