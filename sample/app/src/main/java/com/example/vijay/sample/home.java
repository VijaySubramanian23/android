package com.example.vijay.sample;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class home extends AppCompatActivity {

    private TextView email,pass;
    private Button view;
    private String s;
    private SQLiteDatabase db;
    private Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        openDB();
        Intent i=getIntent();
        s=i.getStringExtra("mess");
        TextView t= (TextView)findViewById(R.id.textView7);
        t.setText(s);

    }
    public void openDB(){
        db=openOrCreateDatabase("user_details", Context.MODE_PRIVATE,null);
    }
    public void showdata(View view){
        String query="SELECT * FROM register WHERE email='"+s+"'";
        c=db.rawQuery(query,null);
        c.moveToFirst();
        email=(TextView)findViewById(R.id.textView4);
        pass=(TextView)findViewById(R.id.textView6);
        String s1=c.getString(0);
        String s2=c.getString(1);
        email.setText(s1);
        pass.setText(s2);
    }
}
