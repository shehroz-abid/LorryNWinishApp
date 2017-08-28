package com.example.lorrynwinsh.Gui;



import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.example.lorrynwinsh.Fragments.VehicleTypeFragment;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import com.example.lorrynwinsh.Fragments.SignInFragment;
import com.example.lorrynwinsh.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        VehicleTypeFragment fragment = new VehicleTypeFragment();
        fm.beginTransaction().add(R.id.fragment_container,fragment).commit();

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
        /*
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SignInFragment hello = new SignInFragment();
        fragmentTransaction.add(R.id.fragment_container, hello, "HELLO");*/
        //fragmentTransaction.commit();
    }
}
