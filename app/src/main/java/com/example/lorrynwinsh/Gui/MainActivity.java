package com.example.lorrynwinsh.Gui;



import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lorrynwinsh.Fragments.UserRegisterFragment;
import com.example.lorrynwinsh.Fragments.VehicleTypeFragment;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import com.example.lorrynwinsh.Fragments.SignInFragment;
import com.example.lorrynwinsh.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MainActivity extends AppCompatActivity {

    ImageView homeBackButton;
    public TextView toolBarTitleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        toolBarTitleTextView = (TextView) toolbar.findViewById(R.id.toolbar1_title_tv);
        toolBarTitleTextView.setText("Vehicle Type");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        homeBackButton = (ImageView) toolbar.findViewById(R.id.btnBackMenu1);
        homeBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, VehicleTypeFragment.newInstance(), "VehicleTypeFragment").commit();
        }

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "your.package",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() == 0) {
            Intent i = new Intent(MainActivity.this,RegisterOptionsActivity.class);
            startActivity(i);
            finish();
        }
        else {
            getSupportFragmentManager().popBackStack();
        }
    }
}
