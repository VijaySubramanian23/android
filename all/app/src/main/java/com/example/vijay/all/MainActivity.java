package com.example.vijay.all;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void mus(View view){
        Intent i=new Intent(getApplicationContext(),music.class);
        startActivity(i);
    }
    public void bat(View view){
        Intent i=new Intent(getApplicationContext(),battery.class);
        startActivity(i);
    }
    public void cam(View view){
        Intent i=new Intent(getApplicationContext(),camera.class);
        startActivity(i);
    }
    public void dic(View view){
        Intent i=new Intent(getApplicationContext(),dictionary.class);
        startActivity(i);
    }
    public void img(View view){
        Intent i=new Intent(getApplicationContext(),image.class);
        startActivity(i);
    }
    public void gps(View view){
        Intent i=new Intent(getApplicationContext(),location.class);
        startActivity(i);
    }
}
