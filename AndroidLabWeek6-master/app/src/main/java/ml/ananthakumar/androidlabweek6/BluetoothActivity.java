package ml.ananthakumar.androidlabweek6;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BluetoothActivity extends AppCompatActivity {

    @BindView(R.id.set_visible)
    Button getVisible;

    @BindView(R.id.turn_on)
    Button turnOn;

    @BindView(R.id.turn_off)
    Button turnOff;

    @BindView(R.id.paired_devices)
    Button paired;

    @BindView(R.id.listView)
    ListView lv;

    @BindView(R.id.textview)
    TextView text;

    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;
    //For 6.0 & above run time permissions
    int PERMISSIONS_REQUEST_BLUETOOTH=100;
    int PERMISSIONS_REQUEST_BLUETOOTH_ADMIN=101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        ButterKnife.bind(this);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.BLUETOOTH)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.BLUETOOTH)) {

            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.BLUETOOTH},
                        PERMISSIONS_REQUEST_BLUETOOTH);

            }
        }

        BA = BluetoothAdapter.getDefaultAdapter();
    }


    public void on(View v){
        if (!BA.isEnabled()) {
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn, 0);
            Toast.makeText(getApplicationContext(), "Turned on",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Already on", Toast.LENGTH_LONG).show();
        }
    }

    public void off(View v){
        BA.disable();
        Toast.makeText(getApplicationContext(), "Turned off" ,Toast.LENGTH_LONG).show();
    }


    public  void visible(View v){
        Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(getVisible, 0);
    }


    public void list(View v){
        pairedDevices = BA.getBondedDevices();

        ArrayList list = new ArrayList();

        for(BluetoothDevice bt : pairedDevices) list.add(bt.getName());
        Toast.makeText(getApplicationContext(), "Showing Paired Devices", Toast.LENGTH_SHORT).show();

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);

        lv.setAdapter(adapter);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 100: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                } else {
                    Toast.makeText(this, "You cant use this app", Toast.LENGTH_SHORT).show();
                }

                //for saving image
                if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.BLUETOOTH_ADMIN)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.BLUETOOTH_ADMIN)) {

                    } else {

                        ActivityCompat.requestPermissions(this,
                                new String[]{Manifest.permission.BLUETOOTH_ADMIN},
                                PERMISSIONS_REQUEST_BLUETOOTH_ADMIN);

                    }
                }

                return;
            }

            case 101: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    Toast.makeText(this, "You cant use this app", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}
