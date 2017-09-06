package com.example.lorrynwinsh.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.lorrynwinsh.Gui.MainActivity;
import com.example.lorrynwinsh.R;

/**
 * Created by Shehroz on 23-Aug-17.
 */

public class VehicleTypeFragment extends Fragment implements View.OnClickListener{


    Button vehicle_type_next_btn, vehicle_type_cancel_btn;
    RelativeLayout type1_layout,type2_layout,type3_layout;
    ImageView check_type1_img, check_type2_img, check_type3_img;

    public static VehicleTypeFragment newInstance(){
        VehicleTypeFragment f = new VehicleTypeFragment();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.vehicle_type, container, false);
        ((MainActivity)getActivity()).toolBarTitleTextView.setText("Vehicle Type");

        vehicle_type_next_btn = (Button) v.findViewById(R.id.vehicle_type_next_btn);
        vehicle_type_cancel_btn = (Button) v.findViewById(R.id.vehicle_type_cancel_btn);
        type1_layout = (RelativeLayout) v.findViewById(R.id.type1_layout);
        type2_layout = (RelativeLayout) v.findViewById(R.id.type2_layout);
        type3_layout = (RelativeLayout) v.findViewById(R.id.type3_layout);
        check_type1_img = (ImageView) v.findViewById(R.id.check_type1_img);
        check_type2_img = (ImageView) v.findViewById(R.id.check_type2_img);
        check_type3_img = (ImageView) v.findViewById(R.id.check_type3_img);



        vehicle_type_next_btn.setOnClickListener(this);
        vehicle_type_cancel_btn.setOnClickListener(this);
        type1_layout.setOnClickListener(this);
        type2_layout.setOnClickListener(this);
        type3_layout.setOnClickListener(this);

        return v;

    }

    @Override
    public void onClick(View v) {

        if(v == vehicle_type_next_btn){
//            final FragmentTransaction ft = getFragmentManager().beginTransaction();
//            ft.replace(R.id.fragment_container, new VehicleSubTypeFragment(), "NewFragmentTag");
//            ft.commit();

            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, VehicleSubTypeFragment.newInstance(), "VehicleSubTypeFragment").addToBackStack(null).commit();

        }
        if(v == vehicle_type_cancel_btn){


        }
        if(v == type1_layout){

            check_type1_img.setVisibility(View.VISIBLE);
            check_type2_img.setVisibility(View.GONE);
            check_type3_img.setVisibility(View.GONE);

        }
        if(v == type2_layout){
            check_type1_img.setVisibility(View.GONE);
            check_type2_img.setVisibility(View.VISIBLE);
            check_type3_img.setVisibility(View.GONE);

        }
        if(v == type3_layout){

            check_type1_img.setVisibility(View.GONE);
            check_type2_img.setVisibility(View.GONE);
            check_type3_img.setVisibility(View.VISIBLE);

        }



        // implements your things
    }
}

