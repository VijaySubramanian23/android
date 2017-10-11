package com.example.venugopal.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    private static final int PI=100;
    ImageView imageView;
    Uri img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView=(ImageView)findViewById(R.id.imageView);
    }
    public void FUNC(View view)
    {
        Intent in=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(in,PI);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data)    {
        super.onActivityResult(requestCode,resultCode,data);
            if(requestCode==PI && resultCode==RESULT_OK) {
                img = data.getData();
                imageView.setImageURI(img);
            }
    }

}
