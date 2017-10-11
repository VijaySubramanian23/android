package com.example.vijay.sample;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    private SQLiteDatabase db;
    private EditText email,pass;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        createDB();
        email=(EditText)findViewById(R.id.editText2);
        pass=(EditText)findViewById(R.id.editText3);
        register=(Button)findViewById(R.id.button);

    }
    protected void createDB(){
        db=openOrCreateDatabase("user_details", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS register(email VARCHAR,pass VARCHAR);");
    }
    public void loginpage(View view){
        String s1=email.getText().toString().trim();
        String s2=pass.getText().toString().trim();
        if (s1.equals("")|| s2.equals("")) {
            t_m("Fill all details");
        }
        else {
            if(!Patterns.EMAIL_ADDRESS.matcher(s1).matches()){
                t_m("Incorrect email");
            }
            else if(s2.length() < 8){
                t_m("pass length should be more than 8 char");
            }
            else {
                String query="INSERT INTO register (email,pass) VALUES ('"+s1+"','"+s2+"');";
                db.execSQL(query);
                t_m("Registration successful");
                Intent i= new Intent(this,login.class);
                startActivity(i);
            }
        }

    }

    private void t_m(String mess){
        Toast.makeText(getApplicationContext(),mess,Toast.LENGTH_LONG).show();
    }
}
