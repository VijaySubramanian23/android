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
import android.widget.Toast;

public class login extends AppCompatActivity {

    private EditText email,pass;
    private Button login;
    private SQLiteDatabase db;
    private Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        t_m("Login to Continue");
        openDB();
        email=(EditText)findViewById(R.id.editText);
        pass=(EditText)findViewById(R.id.editText4);
        login=(Button)findViewById(R.id.button4);

    }
    public void openDB(){
        db=openOrCreateDatabase("user_details",Context.MODE_PRIVATE,null);
    }
    public void homepage(View view){
        String s1=email.getText().toString().trim();
        String s2=pass.getText().toString().trim();
        String query="SELECT pass FROM register WHERE email='"+s1+"'";
        c=db.rawQuery(query,null);
        if(c.getCount()==0){
            t_m("User not registered");
        }
        else {
            c.moveToFirst();
            String db_pass = c.getString(0);
            //TextView t = (TextView) findViewById(R.id.textView4);
            //t.setText(db_pass);
            if(s2.equals(db_pass)){
                Intent i= new Intent(getApplicationContext(),home.class);
                i.putExtra("mess",s1);
                startActivity(i);
            }
            else{
                t_m("invalid email or password");
            }
        }
    }
    public void t_m(String mess){
        Toast.makeText(getApplicationContext(),mess,Toast.LENGTH_LONG).show();
    }
}
