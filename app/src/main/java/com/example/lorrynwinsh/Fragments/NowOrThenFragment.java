package com.example.lorrynwinsh.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.lorrynwinsh.Gui.DisplayRoute;
import com.example.lorrynwinsh.Gui.MainActivity;
import com.example.lorrynwinsh.R;

/**
 * Created by Shehroz on 20-Aug-17.
 */

public class NowOrThenFragment extends Fragment implements View.OnClickListener{


    Button now_btn, later_btn;
    TextView cancel_txt, next_txt;

    public static NowOrThenFragment newInstance(){
        NowOrThenFragment f = new NowOrThenFragment();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.now_later, container, false);
        ((MainActivity)getActivity()).toolBarTitleTextView.setText("Now and Later");
        cancel_txt = (TextView) v.findViewById(R.id.cancel_txt);
        next_txt = (TextView) v.findViewById(R.id.next_txt);

        cancel_txt.setOnClickListener(this);
        next_txt.setOnClickListener(this);


        now_btn =(Button)v.findViewById(R.id.now_btn);
        later_btn =(Button)v.findViewById(R.id.later_btn);

        now_btn.setOnClickListener(this);
        later_btn.setOnClickListener(this);
        return v;

    }
    @Override
    public void onClick(View v) {
        if(v == now_btn){
            Intent i = new Intent(getActivity(), DisplayRoute.class);
            startActivity(i);
            getActivity().finish();
        }
        if(v == later_btn){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, SelectOrderDateTimeFragment.newInstance(), "SelectOrderDateTimeFragment").addToBackStack(null).commit();
        }
        if(v == cancel_txt){

        }
        if(v == next_txt){

        }
    }
}
