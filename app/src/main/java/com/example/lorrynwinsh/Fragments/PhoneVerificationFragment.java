package com.example.lorrynwinsh.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lorrynwinsh.R;

/**
 * Created by Shehroz on 16-Aug-17.
 */

public class PhoneVerificationFragment extends Fragment implements View.OnClickListener{

    EditText pin_first_edittext, pin_second_edittext, pin_third_edittext, pin_forth_edittext, pin_fifth_edittext, pin_sixth_edittext;
    Button changeNumber_btn, resendCode_btn, verify_btn;
    TextView phoneNumber_txt, welcomeUser_text ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.phone_verification, container, false);
        //((MainActivity)getActivity()).setTopBarTitle("Add Education");
        //((MainActivity) getActivity()).hideActionBarSearchEditButton();

        pin_first_edittext = (EditText)v.findViewById(R.id.pin_first_edittext);
        pin_second_edittext = (EditText)v.findViewById(R.id.pin_second_edittext);
        pin_third_edittext = (EditText)v.findViewById(R.id.pin_third_edittext);
        pin_forth_edittext = (EditText)v.findViewById(R.id.pin_forth_edittext);
        pin_fifth_edittext = (EditText)v.findViewById(R.id.pin_fifth_edittext);
        pin_sixth_edittext = (EditText)v.findViewById(R.id.pin_sixth_edittext);

        welcomeUser_text = (TextView) v.findViewById(R.id.welcomeUser_text);
        phoneNumber_txt = (TextView) v.findViewById(R.id.phoneNumber_txt);


        changeNumber_btn =(Button)v.findViewById(R.id.changeNumber_btn);
        resendCode_btn =(Button)v.findViewById(R.id.resendCode_btn);
        verify_btn =(Button)v.findViewById(R.id.verify_btn);
        verify_btn.setOnClickListener(this);

        //Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/MindBlue_regular_demo.otf");
        //login_btn.setTypeface(typeface);


        return v;

    }

    @Override
    public void onClick(View v) {
        // implements your things
        if(v == verify_btn){

        }
    }


}
