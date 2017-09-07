package com.example.lorrynwinsh.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lorrynwinsh.R;

/**
 * Created by Shehroz on 07-Sep-17.
 */

public class ActiveOrderFragment extends Fragment implements View.OnClickListener{

    EditText comment_edttxt;
    TextView active_order_from_address_txt, active_order_to_address_txt, vehicle_type_txt, active_order_id_txt,
            active_order_datetime_txt, active_order_payment_txt;
    ImageView activeOrder_vehicle_Image;
    Button active_order_procceed_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.active_order, container, false);
        //((MainActivity)getActivity()).setTopBarTitle("Add Education");
        //((MainActivity) getActivity()).hideActionBarSearchEditButton();


        active_order_from_address_txt = (TextView) v.findViewById(R.id.active_order_from_address_txt);
        active_order_to_address_txt = (TextView) v.findViewById(R.id.active_order_to_address_txt);
        vehicle_type_txt = (TextView) v.findViewById(R.id.vehicle_type_txt);
        active_order_id_txt = (TextView) v.findViewById(R.id.active_order_id_txt);
        active_order_datetime_txt = (TextView) v.findViewById(R.id.active_order_datetime_txt);
        active_order_payment_txt = (TextView) v.findViewById(R.id.active_order_payment_txt);


        activeOrder_vehicle_Image = (ImageView) v.findViewById(R.id.activeOrder_vehicle_Image);

        comment_edttxt = (EditText)v.findViewById(R.id.loginPassword_editText);

        active_order_procceed_btn =(Button)v.findViewById(R.id.active_order_procceed_btn);
        active_order_procceed_btn.setOnClickListener(this);
        //Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/MindBlue_regular_demo.otf");
        //login_btn.setTypeface(typeface);

        return v;

    }

    @Override
    public void onClick(View v) {

        if(v == active_order_procceed_btn){


        }


        // implements your things
    }
}
