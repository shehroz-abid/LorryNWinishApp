package com.example.lorrynwinsh.Gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lorrynwinsh.Fragments.UserRegisterFragment;
import com.example.lorrynwinsh.R;

/**
 * Created by macbookpro on 06/09/2017.
 */

public class RegisterActivity extends AppCompatActivity {
    ImageView homeBackButton;
    public TextView toolBarTitleTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolBarTitleTextView = (TextView) toolbar.findViewById(R.id.toolbar_title_tv);
        toolBarTitleTextView.setText("Register - Basic Info");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        homeBackButton = (ImageView) toolbar.findViewById(R.id.btnBackMenu);
        homeBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout, UserRegisterFragment.newInstance(), "UserRegisterFragment").commit();
        }
    }

    @Override
    public void onBackPressed() {
//        Fragment f = getSupportFragmentManager().findFragmentById(R.id.main_frameLayout);
//        if (f != null && f instanceof UserRegisterFragment){
//            this.finishAffinity();
//        }
        if(getSupportFragmentManager().getBackStackEntryCount() == 0) {
            Intent i = new Intent(RegisterActivity.this,RegisterOptionsActivity.class);
            startActivity(i);
            finish();
        }
        else {
            getSupportFragmentManager().popBackStack();
        }
    }
}
