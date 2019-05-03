package com.exemple.mysecondapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent secondIntent = new Intent(SecondActivity.this, CalendarActivity.class);
                startActivity(secondIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
