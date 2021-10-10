package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.e("TAG", "onCreate B");

    }

    @Override
    public void onDestroy () {
        //stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
        Log.e("TAG", "Ondestroy B");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("TAG", "onStart B");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG", "onResume B");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAG", "onPause B");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG", "onStop B");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("TAG", "onRestart B");
    }
}