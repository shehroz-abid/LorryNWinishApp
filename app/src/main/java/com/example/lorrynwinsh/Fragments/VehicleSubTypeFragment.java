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

public class VehicleSubTypeFragment extends Fragment implements View.OnClickListener{


    Button vehicle_subtype_next_btn, vehicle_subtype_cancel_btn;
    RelativeLayout vehicle_subtype1_layout,vehicle_subtype2_layout,vehicle_subtype3_layout;
    ImageView check_subtype1_img, check_subtype2_img, check_subtype3_img;

    public static VehicleSubTypeFragment newInstance(){
        VehicleSubTypeFragment f = new VehicleSubTypeFragment();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.vehicle_subtype, container, false);
        ((MainActivity)getActivity()).toolBarTitleTextView.setText("Vehicle Type");
        vehicle_subtype_next_btn = (Button) v.findViewById(R.id.vehicle_subtype_next_btn);
        vehicle_subtype_cancel_btn = (Button) v.findViewById(R.id.vehicle_subtype_cancel_btn);
        vehicle_subtype1_layout = (RelativeLayout) v.findViewById(R.id.vehicle_subtype1_layout);
        vehicle_subtype2_layout = (RelativeLayout) v.findViewById(R.id.vehicle_subtype2_layout);
        vehicle_subtype3_layout = (RelativeLayout) v.findViewById(R.id.vehicle_subtype3_layout);
        check_subtype1_img = (ImageView) v.findViewById(R.id.check_subtype1_img);
        check_subtype2_img = (ImageView) v.findViewById(R.id.check_subtype2_img);
        check_subtype3_img = (ImageView) v.findViewById(R.id.check_subtype3_img);



        vehicle_subtype_next_btn.setOnClickListener(this);
        vehicle_subtype_cancel_btn.setOnClickListener(this);
        vehicle_subtype1_layout.setOnClickListener(this);
        vehicle_subtype2_layout.setOnClickListener(this);
        vehicle_subtype3_layout.setOnClickListener(this);

        return v;

    }

    @Override
    public void onClick(View v) {

        if(v == vehicle_subtype_cancel_btn){
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, new VehicleSubTypeFragment(), "VehicleSubTypeFragment");
            ft.commit();

            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, NowOrThenFragment.newInstance(), "NowOrThenFragment").addToBackStack(null).commit();

        }
        if(v == vehicle_subtype_next_btn){


        }
        if(v == vehicle_subtype1_layout){

            check_subtype1_img.setVisibility(View.VISIBLE);
            check_subtype2_img.setVisibility(View.GONE);
            check_subtype3_img.setVisibility(View.GONE);

        }
        if(v == vehicle_subtype2_layout){
            check_subtype1_img.setVisibility(View.GONE);
            check_subtype2_img.setVisibility(View.VISIBLE);
            check_subtype3_img.setVisibility(View.GONE);

        }
        if(v == vehicle_subtype3_layout){

            check_subtype1_img.setVisibility(View.GONE);
            check_subtype2_img.setVisibility(View.GONE);
            check_subtype3_img.setVisibility(View.VISIBLE);

        }



        // implements your things
    }
}

