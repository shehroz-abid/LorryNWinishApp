package com.example.lorrynwinsh.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.lorrynwinsh.R;

/**
 * Created by Shehroz on 23-Aug-17.
 */

public class VehicleSubTypeFragment extends Fragment implements View.OnClickListener{

    LinearLayout visa_layout_btn, cash_layout_btn, paypal_layout_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.vehicle_subtype, container, false);
        //((MainActivity)getActivity()).setTopBarTitle("Add Education");
        //((MainActivity) getActivity()).hideActionBarSearchEditButton();


        visa_layout_btn =(LinearLayout) v.findViewById(R.id.visa_layout_btn);
        cash_layout_btn =(LinearLayout) v.findViewById(R.id.cash_layout_btn);
        paypal_layout_btn =(LinearLayout) v.findViewById(R.id.paypal_layout_btn);

        visa_layout_btn.setOnClickListener(this);
        cash_layout_btn.setOnClickListener(this);
        paypal_layout_btn.setOnClickListener(this);
        //Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/MindBlue_regular_demo.otf");
        //login_btn.setTypeface(typeface);

        return v;

    }

    @Override
    public void onClick(View v) {

        if(v == visa_layout_btn){


        }
        if(v == cash_layout_btn){


        }
        if(v == paypal_layout_btn){


        }


        // implements your things
    }
}

