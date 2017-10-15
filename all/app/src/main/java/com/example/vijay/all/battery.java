package com.example.vijay.all;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class battery extends AppCompatActivity {

    private BroadcastReceiver b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);
        b=new show();
    }

    @Override
    protected void onStart() {
        registerReceiver(b,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(b);
        super.onStop();
    }

    public class show extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            TextView t=(TextView)findViewById(R.id.textView);
            ProgressBar p=(ProgressBar)findViewById(R.id.progressBar);
            t.setText("battery level is "+level);
            p.setProgress(level);
        }
    }
}
