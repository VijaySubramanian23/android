package com.example.vijay.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void findcolor(View view)
    {
        TextView t=(TextView)findViewById(R.id.textView);
        Spinner s=(Spinner)findViewById(R.id.spinner);
        String a= String.valueOf(s.getSelectedItem());
        t.setText(a);
    }
    public void nextpage(View view)
    {
         Intent i=new Intent(this,Main2Activity.class);
        EditText e=(EditText)findViewById(R.id.editText);
        String a=e.getText().toString();
         i.putExtra("mess",a);
          startActivity(i);

    }


}
