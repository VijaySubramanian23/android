package com.example.vijay.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private EditText e1,e2;
    private Button submit;
    private SQLiteDatabase db;
    private Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        /*Intent i=getIntent();
        String s=i.getStringExtra("mess");
        TextView t= (TextView)findViewById(R.id.editText2);
        t.setText(s);
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();*/
        e1= (EditText) findViewById(R.id.editText2);
        e2= (EditText) findViewById(R.id.editText3);
        //submit=(Button)findViewById(R.id.button3);
        SharedPreferences share=getSharedPreferences("mypref",MODE_PRIVATE);
        String s1=share.getString("login","not");
        String sa1=e1.getText().toString();
        String sa2=e2.getText().toString();
        SharedPreferences.Editor edit=getSharedPreferences("mypref",MODE_PRIVATE).edit();
        edit.putString(sa1,sa2);
        edit.commit();
        String s2=share.getString(sa1,"not");
        TextView t=(TextView)findViewById(R.id.textView3);
        t.setText(s2);
        /*db=openOrCreateDatabase("Email_DB", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE User ( Email VARCHAR,Pass VARCHAR);");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("INSERT INTO User(Email,Pass) values( '"+e1.getText().toString()+"' , '"+e2.getText().toString()+"' );");
                Toast.makeText(getApplicationContext(),"Inserted...", Toast.LENGTH_LONG).show();

            }
        });*/



    }
}
