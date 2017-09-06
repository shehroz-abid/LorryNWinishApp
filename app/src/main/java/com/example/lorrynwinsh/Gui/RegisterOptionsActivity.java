package com.example.lorrynwinsh.Gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.lorrynwinsh.R;

/**
 * Created by macbookpro on 05/09/2017.
 */

public class RegisterOptionsActivity extends AppCompatActivity implements View.OnClickListener{

    private RelativeLayout createAccountRl, emailLoginRl, fbLoginRl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register_options_layout);

        createAccountRl = (RelativeLayout) findViewById(R.id.layout_reg);
        emailLoginRl = (RelativeLayout) findViewById(R.id.layout_login);
        fbLoginRl = (RelativeLayout) findViewById(R.id.layout_fbLogin);

        createAccountRl.setOnClickListener(this);
        emailLoginRl.setOnClickListener(this);
        fbLoginRl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == createAccountRl){
            startRegisterActivity();
        }
        else if (v == emailLoginRl){
            startLoginActivity();
        }
        else if (v == fbLoginRl){

        }
    }

    private void startLoginActivity(){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    private void startRegisterActivity(){
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
        finish();
    }
}
