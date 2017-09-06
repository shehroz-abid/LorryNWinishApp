package com.example.lorrynwinsh.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.lorrynwinsh.Gui.MainActivity;
import com.example.lorrynwinsh.Gui.RegisterActivity;
import com.example.lorrynwinsh.R;

/**
 * Created by Shehroz on 16-Aug-17.
 */

public class PaymentCredentialFragment extends Fragment implements View.OnClickListener{

    EditText cardType_editText, cardNumber_editText, cardExpireDate_editText, ccv_editText;
    Button proccesed_btn;
    CheckBox saveCard_checkbox;

    public static PaymentCredentialFragment newInstance(){
        PaymentCredentialFragment f = new PaymentCredentialFragment();

        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.payment_credentials_form, container, false);
        ((RegisterActivity)getActivity()).toolBarTitleTextView.setText("New Cards");

        cardType_editText = (EditText)v.findViewById(R.id.cardType_editText);
        cardNumber_editText = (EditText)v.findViewById(R.id.cardNumber_editText);
        cardExpireDate_editText = (EditText)v.findViewById(R.id.cardExpireDate_editText);
        ccv_editText = (EditText)v.findViewById(R.id.ccv_editText);


        saveCard_checkbox = (CheckBox)v.findViewById(R.id.saveCard_checkbox);

        proccesed_btn =(Button)v.findViewById(R.id.proccesed_btn);
        proccesed_btn.setOnClickListener(this);
        return v;

    }
    @Override
    public void onClick(View v) {
        if(v == proccesed_btn){
            startMainActivity();
        }
    }

    private void startMainActivity(){
        Intent i = new Intent(getActivity(), MainActivity.class);
        startActivity(i);
        getActivity().finish();
    }
}
