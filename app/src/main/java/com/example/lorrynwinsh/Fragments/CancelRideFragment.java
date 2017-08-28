package com.example.lorrynwinsh.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.lorrynwinsh.R;

/**
 * Created by Shehroz on 16-Aug-17.
 */

public class CancelRideFragment extends Fragment implements View.OnClickListener{


    Button cancelRide_btn;
    RadioButton noComunication_radio, highCharge_radio, cancelPackage_radio, other_radio;
    TextView cancelRideNotification_txt;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.cancel_ride, container, false);
        //((MainActivity)getActivity()).setTopBarTitle("Add Education");
        //((MainActivity) getActivity()).hideActionBarSearchEditButton();

        cancelRideNotification_txt = (TextView) v.findViewById(R.id.cancelRideNotification_txt);

        noComunication_radio = (RadioButton) v.findViewById(R.id.noComunication_radio);
        highCharge_radio = (RadioButton)v.findViewById(R.id.highCharge_radio);
        cancelPackage_radio = (RadioButton)v.findViewById(R.id.cancelPackage_radio);
        other_radio = (RadioButton)v.findViewById(R.id.other_radio);

        cancelRide_btn =(Button)v.findViewById(R.id.cancelRide_btn);


        //Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/MindBlue_regular_demo.otf");
        //login_btn.setTypeface(typeface);


        return v;

    }
    @Override
    public void onClick(View v) {
        // implements your things
        if(v == cancelRide_btn){

        }
    }
}

