package com.example.lorrynwinsh.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import com.example.lorrynwinsh.Gui.MainActivity;
import com.example.lorrynwinsh.R;

/**
 * Created by Shehroz on 16-Aug-17.
 */

public class SignInFragment extends Fragment implements View.OnClickListener{

    EditText loginPassword_editText, loginUserName_editText;
    Button login_btn, fb_signup_btn;
    TextView forgetPasswordTxt, signUp_txt ;
    ProgressBar progressbar;
    CallbackManager callbackManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FacebookSdk.sdkInitialize(getActivity());
        View v = inflater.inflate(R.layout.signup_main, container, false);
        //((MainActivity)getActivity()).setTopBarTitle("Add Education");
        //((MainActivity) getActivity()).hideActionBarSearchEditButton();

        progressbar= new ProgressBar(getActivity());
        callbackManager = CallbackManager.Factory.create();

        loginPassword_editText = (EditText)v.findViewById(R.id.loginPassword_editText);
        loginUserName_editText = (EditText)v.findViewById(R.id.loginUserName_editText);

        forgetPasswordTxt = (TextView) v.findViewById(R.id.forgetPasswordTxt);
        signUp_txt = (TextView) v.findViewById(R.id.signUp_txt);
        signUp_txt.setOnClickListener(this);

        login_btn =(Button)v.findViewById(R.id.login_btn);
        fb_signup_btn =(Button)v.findViewById(R.id.facebook_signup_btn);


        login_btn.setOnClickListener(this);
        fb_signup_btn.setOnClickListener(this);
        //Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/MindBlue_regular_demo.otf");
        //login_btn.setTypeface(typeface);


        return v;


    }
    private void registerUser(){
        String email = loginUserName_editText.getText().toString().trim();
        String password = loginPassword_editText.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            // Email is Empty
            Toast.makeText(getActivity(), "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            // Password is Empty
            Toast.makeText(getActivity(), "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

    }
    @Override
    public void onClick(View v) {

        if(v == login_btn){
            //registerUser();
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, new CompanyRegisterFragment(), "NewFragmentTag");
            ft.commit();
        }

        if (v == signUp_txt){

        }
        // implements your things
    }
}
