package com.example.lorrynwinsh.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lorrynwinsh.R;

/**
 * Created by Shehroz on 16-Aug-17.
 */

public class CompanyRegisterFragment extends Fragment implements View.OnClickListener{

    EditText companyName_editText, industryName_editText, companyEmail_editText, companyAddress_editText, companyCityName_editText,
    companyPhoneNumber_editText,companyLandlineNumber_editText ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.company_register, container, false);
        //((MainActivity)getActivity()).setTopBarTitle("Add Education");
        //((MainActivity) getActivity()).hideActionBarSearchEditButton();

        companyName_editText = (EditText)v.findViewById(R.id.companyName_editText);
        industryName_editText = (EditText)v.findViewById(R.id.industryName_editText);
        companyEmail_editText = (EditText)v.findViewById(R.id.companyEmail_editText);
        companyAddress_editText = (EditText)v.findViewById(R.id.companyAddress_editText);
        companyCityName_editText = (EditText)v.findViewById(R.id.companyCityName_editText);
        companyPhoneNumber_editText = (EditText)v.findViewById(R.id.companyPhoneNumber_editText);
        companyLandlineNumber_editText = (EditText)v.findViewById(R.id.companyLandlineNumber_editText);

        if(TextUtils.isEmpty(companyName_editText.getText())){

            Toast.makeText(getActivity(), "Enter Company Name", Toast.LENGTH_SHORT).show();

        }
        if(TextUtils.isEmpty(industryName_editText.getText())){

            Toast.makeText(getActivity(), "Enter Industry Name", Toast.LENGTH_SHORT).show();

        }
        if(TextUtils.isEmpty(companyEmail_editText.getText())){

            Toast.makeText(getActivity(), "Enter Company Email", Toast.LENGTH_SHORT).show();


        }
        if(TextUtils.isEmpty(companyAddress_editText.getText())){

            Toast.makeText(getActivity(), "Enter Company Address", Toast.LENGTH_SHORT).show();

        }
        if(TextUtils.isEmpty(companyCityName_editText.getText())){

            Toast.makeText(getActivity(), "Enter Email", Toast.LENGTH_SHORT).show();

        }
        if(TextUtils.isEmpty(companyPhoneNumber_editText.getText())){

            Toast.makeText(getActivity(), "Enter Mobile Number", Toast.LENGTH_SHORT).show();

        }
        if(TextUtils.isEmpty(companyLandlineNumber_editText.getText())){

            Toast.makeText(getActivity(), "Enter Mobile Number", Toast.LENGTH_SHORT).show();

        }

        //create_account_btn.setOnClickListener(this);


        //Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/MindBlue_regular_demo.otf");
        //login_btn.setTypeface(typeface);


        return v;

    }
    @Override
    public void onClick(View v) {
        // implements your things
       /* if(v == verify_btn){

        }*/
    }
}
