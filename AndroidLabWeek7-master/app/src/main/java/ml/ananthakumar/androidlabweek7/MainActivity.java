package ml.ananthakumar.androidlabweek7;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import ml.ananthakumar.androidlabweek7.fragments.StorageFragment;
import ml.ananthakumar.androidlabweek7.fragments.WebServerFragment;

public class MainActivity extends AppCompatActivity implements StorageFragment.OnFragmentInteractionListener, WebServerFragment.OnFragmentInteractionListener {

    private BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_storage:
                    selectedFragment = StorageFragment.newInstance("Read/Write Storage");
                    break;
                case R.id.navigation_sqlite:
                    Intent in=new Intent(getBaseContext(),SqliteActivity.class);
                    startActivity(in);
                    return true;
                case R.id.navigation_webserver:
                    selectedFragment = WebServerFragment.newInstance("Load from Server");
                    break;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content, selectedFragment);
            transaction.commit();
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //load first fragment in view
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, StorageFragment.newInstance("Read/Write Storage"));
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
