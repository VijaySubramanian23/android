package com.example.vijay.all;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class dictionary extends AppCompatActivity {
    private EditText e;
    WebView w;

    /*@Override
    public void onBackPressed() {
        super.onBackPressed();
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
    }
    public void search(View view){
        e=(EditText)findViewById(R.id.editText);
        String s=e.getText().toString();
        w=(WebView)findViewById(R.id.web);
        WebSettings settings=w.getSettings();
        settings.setJavaScriptEnabled(true);
        w.setWebViewClient(new WebViewClient());
        w.loadUrl("https://www.google.co.in/search?q="+s+"+meaning");
    }
}
