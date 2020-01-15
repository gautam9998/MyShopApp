package com.gautam.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.animation.Animation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SystemClock.sleep(1500);
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
        finish();

    }
}
