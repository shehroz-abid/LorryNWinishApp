package com.example.lorrynwinsh.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lorrynwinsh.R;

/**
 * Created by Shehroz on 20-Aug-17.
 */

public class DriverReviewFragment extends Fragment implements View.OnClickListener{

    EditText comment_edttxt;
    ImageView driver_ImageView;
    Button rateDriver_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.driver_review, container, false);
        //((MainActivity)getActivity()).setTopBarTitle("Add Education");
        //((MainActivity) getActivity()).hideActionBarSearchEditButton();


        driver_ImageView = (ImageView) v.findViewById(R.id.driver_ImageView);

        comment_edttxt = (EditText)v.findViewById(R.id.loginPassword_editText);


        rateDriver_btn =(Button)v.findViewById(R.id.rateDriver_btn);

        rateDriver_btn.setOnClickListener(this);
        //Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/MindBlue_regular_demo.otf");
        //login_btn.setTypeface(typeface);

        return v;

    }

    @Override
    public void onClick(View v) {

        if(v == rateDriver_btn){


        }


        // implements your things
    }
}
