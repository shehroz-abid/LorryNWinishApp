package com.example.lorrynwinsh.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.lorrynwinsh.R;

/**
 * Created by Shehroz on 16-Aug-17.
 */

public class PaymentCredentialFragment extends Fragment implements View.OnClickListener{

    EditText cardType_editText, cardNumber_editText, cardExpireDate_editText, ccv_editText;
    Button proccesed_btn;
    CheckBox saveCard_checkbox;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.payment_credentials_form, container, false);
        //((MainActivity)getActivity()).setTopBarTitle("Add Education");
        //((MainActivity) getActivity()).hideActionBarSearchEditButton();

        cardType_editText = (EditText)v.findViewById(R.id.cardType_editText);
        cardNumber_editText = (EditText)v.findViewById(R.id.cardNumber_editText);
        cardExpireDate_editText = (EditText)v.findViewById(R.id.cardExpireDate_editText);
        ccv_editText = (EditText)v.findViewById(R.id.ccv_editText);


        saveCard_checkbox = (CheckBox)v.findViewById(R.id.saveCard_checkbox);

        proccesed_btn =(Button)v.findViewById(R.id.proccesed_btn);



        //Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/MindBlue_regular_demo.otf");
        //login_btn.setTypeface(typeface);


        return v;

    }
    @Override
    public void onClick(View v) {
        // implements your things
        if(v == proccesed_btn){

        }
    }
}
