package com.example.lorrynwinsh.Gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lorrynwinsh.Fragments.CompanyRegisterFragment;
import com.example.lorrynwinsh.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by Shehroz on 29-Aug-17.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText loginPassword_editText, loginUserName_editText;
    Button login_btn, fb_signup_btn;
    //LoginButton fb_signup_btn;
    TextView forgetPasswordTxt, signUp_txt ;
    ProgressBar progressbar;
    CallbackManager callbackManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());

        setContentView(R.layout.signup_main);

        progressbar= new ProgressBar(this);
        callbackManager = CallbackManager.Factory.create();

        loginPassword_editText = (EditText)findViewById(R.id.etLoginPassword);
        loginUserName_editText = (EditText)findViewById(R.id.etLoginEmail);

        forgetPasswordTxt = (TextView)findViewById(R.id.forgetPasswordTxt);
        signUp_txt = (TextView)findViewById(R.id.signUp_txt);
        signUp_txt.setOnClickListener(this);

        login_btn =(Button)findViewById(R.id.login_btn);
        fb_signup_btn =(Button)findViewById(R.id.facebook_signup_btn);

        /*fb_signup_btn.registerCallback(callbackManager, new FacebookCallback<LoginResult>()
        {
            @Override
            public void onSuccess(LoginResult loginResult)
            {
                System.out.println("onSuccess");
            }

            @Override
            public void onCancel()
            {
                System.out.println("onCancel");
            }

            @Override
            public void onError(FacebookException exception)
            {
                Log.v("LoginActivity", exception.getCause().toString());
            }
        });*/
        login_btn.setOnClickListener(this);
        fb_signup_btn.setOnClickListener(this);
    }
    private void registerUser(){
        String email = loginUserName_editText.getText().toString().trim();
        String password = loginPassword_editText.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            // Email is Empty
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            // Password is Empty
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {

        if(v == login_btn){
            //registerUser();
            Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
            LoginActivity.this.startActivity(myIntent);

        }

        if (v == signUp_txt){

        }
        // implements your things
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(LoginActivity.this,RegisterOptionsActivity.class);
        startActivity(i);
        finish();
    }
}

