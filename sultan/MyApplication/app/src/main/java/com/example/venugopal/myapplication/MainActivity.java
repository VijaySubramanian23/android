package com.example.venugopal.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Move(View view)
    {
        Intent it=new Intent(this,Main2Activity.class);
        Toast.makeText(getApplicationContext(),"chaanging",Toast.LENGTH_SHORT).show();
        startActivity(it);

    }
}
