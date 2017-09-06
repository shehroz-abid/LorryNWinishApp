package com.example.lorrynwinsh.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lorrynwinsh.Gui.RegisterActivity;
import com.example.lorrynwinsh.R;

/**
 * Created by Shehroz on 16-Aug-17.
 */

public class CompanyRegisterFragment extends Fragment implements View.OnClickListener{

    EditText companyName_editText, industryName_editText, companyEmail_editText, companyAddress_editText, companyCityName_editText,
    companyPhoneNumber_editText,companyLandlineNumber_editText ;

    public static CompanyRegisterFragment newInstance(){
        CompanyRegisterFragment f = new CompanyRegisterFragment();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.company_register, container, false);
        ((RegisterActivity)getActivity()).toolBarTitleTextView.setText("Register - Company Details");
        companyName_editText = (EditText)v.findViewById(R.id.companyName_editText);
        industryName_editText = (EditText)v.findViewById(R.id.industryName_editText);
        companyEmail_editText = (EditText)v.findViewById(R.id.companyEmail_editText);
        companyAddress_editText = (EditText)v.findViewById(R.id.companyAddress_editText);
        companyCityName_editText = (EditText)v.findViewById(R.id.companyCityName_editText);
        companyPhoneNumber_editText = (EditText)v.findViewById(R.id.companyPhoneNumber_editText);
        companyLandlineNumber_editText = (EditText)v.findViewById(R.id.companyLandlineNumber_editText);

        return v;

    }
    @Override
    public void onClick(View v) {
        // implements your things
       /* if(v == verify_btn){

        }*/
    }
}
