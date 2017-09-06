package com.example.lorrynwinsh.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lorrynwinsh.Gui.RegisterActivity;
import com.example.lorrynwinsh.R;

/**
 * Created by Shehroz on 20-Aug-17.
 */

public class PaymentTypeFragment extends Fragment implements View.OnClickListener{

    Button visa_btn, cash_btn, other_btn;

    public static PaymentTypeFragment newInstance(){
        PaymentTypeFragment f = new PaymentTypeFragment();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.payment_type, container, false);
        ((RegisterActivity)getActivity()).toolBarTitleTextView.setText("Payments");

        visa_btn =(Button) v.findViewById(R.id.visa_btn);
        cash_btn =(Button) v.findViewById(R.id.cash_btn);
        other_btn =(Button) v.findViewById(R.id.other_btn);

        visa_btn.setOnClickListener(this);
        cash_btn.setOnClickListener(this);
        other_btn.setOnClickListener(this);

        return v;

    }

    @Override
    public void onClick(View v) {

        if(v == visa_btn){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout, PaymentCredentialFragment.newInstance(), "PaymentCredentialFragment").addToBackStack(null).commit();

        }
        if(v == cash_btn){


        }
        if(v == other_btn){


        }


        // implements your things
    }
}

