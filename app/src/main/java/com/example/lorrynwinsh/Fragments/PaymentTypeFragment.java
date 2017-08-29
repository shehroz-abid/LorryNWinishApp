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
import com.example.lorrynwinsh.R;

/**
 * Created by Shehroz on 20-Aug-17.
 */

public class PaymentTypeFragment extends Fragment implements View.OnClickListener{

    Button visa_btn, cash_btn, other_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.payment_type, container, false);
        //((MainActivity)getActivity()).setTopBarTitle("Add Education");
        //((MainActivity) getActivity()).hideActionBarSearchEditButton();


        visa_btn =(Button) v.findViewById(R.id.visa_btn);
        cash_btn =(Button) v.findViewById(R.id.cash_btn);
        other_btn =(Button) v.findViewById(R.id.other_btn);

        visa_btn.setOnClickListener(this);
        cash_btn.setOnClickListener(this);
        other_btn.setOnClickListener(this);
        //Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/MindBlue_regular_demo.otf");
        //login_btn.setTypeface(typeface);

        return v;

    }

    @Override
    public void onClick(View v) {

        if(v == visa_btn){


        }
        if(v == cash_btn){


        }
        if(v == other_btn){


        }


        // implements your things
    }
}

