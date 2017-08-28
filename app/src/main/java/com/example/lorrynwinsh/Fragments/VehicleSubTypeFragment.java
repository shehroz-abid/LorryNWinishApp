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

import com.example.lorrynwinsh.R;

/**
 * Created by Shehroz on 23-Aug-17.
 */

public class VehicleSubTypeFragment extends Fragment implements View.OnClickListener{


    Button vehicle_subtype_next_btn, vehicle_subtype_cancel_btn;
    RelativeLayout vehicle_subtype1_layout,vehicle_subtype2_layout,vehicle_subtype3_layout;
    ImageView check_subtype1_img, check_subtype2_img, check_subtype3_img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.vehicle_subtype, container, false);
        //((MainActivity)getActivity()).setTopBarTitle("Add Education");
        //((MainActivity) getActivity()).hideActionBarSearchEditButton();

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

        //Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/MindBlue_regular_demo.otf");
        //login_btn.setTypeface(typeface);

        return v;

    }

    @Override
    public void onClick(View v) {

        if(v == vehicle_subtype_next_btn){
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, new VehicleSubTypeFragment(), "NewFragmentTag");
            ft.commit();

        }
        if(v == vehicle_subtype_cancel_btn){


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

