package com.example.layout;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {
    private Button btnAbout;
    private TextView txtUser;
    private static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtUser = (TextView) findViewById((R.id.txtUser));
        btnAbout = (Button) findViewById(R.id.btnAbout);




        if (getIntent().getExtras() != null) {
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            txtUser.setText(bundle.getString("dataUsername"));
        } else {
            /**
             * Apabila Bundle tidak ada, ambil dari Intent
             */
            txtUser.setText(getIntent().getStringExtra("dataUsername"));
        }


    }






    public void loadFragmentOne(View v) {

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment1 = fragmentManager.findFragmentByTag("fragOne");

        if (fragment1 == null) {
            fragment1 = new FragmentOne();
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.mainFrag, fragment1, "fragOne");
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void loadFragmentTwo(View v) {

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment2 = fragmentManager.findFragmentByTag("fragTwo");

        if (fragment2 == null) {
            fragment2 = new FragmentTwo();
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.mainFrag, fragment2, "fragTwo");
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}