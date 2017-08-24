package com.example.lorrynwinsh.Gui;



import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lorrynwinsh.Fragments.SignInFragment;
import com.example.lorrynwinsh.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        SignInFragment fragment = new SignInFragment();
        fm.beginTransaction().add(R.id.fragment_container,fragment).commit();

        /*
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SignInFragment hello = new SignInFragment();
        fragmentTransaction.add(R.id.fragment_container, hello, "HELLO");*/
        //fragmentTransaction.commit();
    }
}
