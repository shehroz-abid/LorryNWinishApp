package com.example.lorrynwinsh.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lorrynwinsh.R;

/**
 * Created by Shehroz on 23-Aug-17.
 */

public class PickUpMapFragment extends Fragment implements View.OnClickListener{


    Button now_btn, later_btn;
    TextView cancel_txt, next_txt;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.pickup_map, container, false);
        //((MainActivity)getActivity()).setTopBarTitle("Add Education");
        //((MainActivity) getActivity()).hideActionBarSearchEditButton();

        cancel_txt = (TextView) v.findViewById(R.id.pickup_cancel_btn);
        next_txt = (TextView) v.findViewById(R.id.pickup_next_btn);

        cancel_txt.setOnClickListener(this);
        next_txt.setOnClickListener(this);


        now_btn =(Button)v.findViewById(R.id.now_btn);
        later_btn =(Button)v.findViewById(R.id.later_btn);

        now_btn.setOnClickListener(this);
        later_btn.setOnClickListener(this);


        //Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/MindBlue_regular_demo.otf");
        //login_btn.setTypeface(typeface);


        return v;

    }
    @Override
    public void onClick(View v) {
        // implements your things
        if(v == now_btn){

            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, new PickUpMapFragment(), "NewFragmentTag");
            ft.commit();

        }
        if(v == later_btn){

            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, new SelectOrderDateTimeFragment(), "NewFragmentTag");
            ft.commit();

        }
        if(v == cancel_txt){

        }
        if(v == next_txt){

            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, new SelectOrderDateTimeFragment(), "NewFragmentTag");
            ft.commit();

        }
    }
}
