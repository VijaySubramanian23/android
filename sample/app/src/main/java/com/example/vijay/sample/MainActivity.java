package com.example.vijay.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] s={"REGISTER","LOGIN","SIGN UP","SIGN IN"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void loginpage(View view){
        Intent i=new Intent(this,login.class);
        startActivity(i);
    }
    public void registerpage(View view){
        Intent i=new Intent(this,register.class);
        startActivity(i);
    }

}
