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

public class UserRegisterFragment extends Fragment {

    EditText firstName_editText, lastName_editText, email_editText, password_editText, cnfrmPassword_editText, mobileNo_editText;
    Button compnayReg_btn, create_account_btn;
    CheckBox acceptConditions_checkbox;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.user_register, container, false);
        //((MainActivity)getActivity()).setTopBarTitle("Add Education");
        //((MainActivity) getActivity()).hideActionBarSearchEditButton();

        firstName_editText = (EditText)v.findViewById(R.id.firstName_editText);
        lastName_editText = (EditText)v.findViewById(R.id.loginUserName_editText);
        email_editText = (EditText)v.findViewById(R.id.email_editText);
        password_editText = (EditText)v.findViewById(R.id.password_editText);
        cnfrmPassword_editText = (EditText)v.findViewById(R.id.cnfrmPassword_editText);
        mobileNo_editText = (EditText)v.findViewById(R.id.mobileNo_editText);


        acceptConditions_checkbox = (CheckBox)v.findViewById(R.id.acceptConditions_checkbox);

        compnayReg_btn =(Button)v.findViewById(R.id.compnayReg_btn);
        create_account_btn =(Button)v.findViewById(R.id.create_account_btn);


        //Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/MindBlue_regular_demo.otf");
        //login_btn.setTypeface(typeface);


        return v;

    }
}

