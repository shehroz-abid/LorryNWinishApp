package com.example.lorrynwinsh.Fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;

import com.example.lorrynwinsh.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Shehroz on 20-Aug-17.
 */

public class SelectOrderDateTimeFragment extends Fragment implements View.OnClickListener{

    EditText selectDate_edittxt, selectTime_edittxt;
    Calendar myCalendar;
    TimePicker order_Timepicker;

    DatePickerDialog.OnDateSetListener date;

    public static SelectOrderDateTimeFragment newInstance(){
        SelectOrderDateTimeFragment f = new SelectOrderDateTimeFragment();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.select_date_time, container, false);


        order_Timepicker = (TimePicker) v.findViewById(R.id.order_Timepicker);


        selectDate_edittxt = (EditText)v.findViewById(R.id.selectDate_edittxt);
        selectTime_edittxt = (EditText)v.findViewById(R.id.selectTime_edittxt);

        selectDate_edittxt.setOnClickListener(this);
        selectTime_edittxt.setOnClickListener(this);

        myCalendar = Calendar.getInstance();

        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        //Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/MindBlue_regular_demo.otf");
        //login_btn.setTypeface(typeface);

        return v;



    }
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        selectDate_edittxt.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public void onClick(View v) {

        if(v == selectDate_edittxt){

            new DatePickerDialog(getActivity(), date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();

        }
        if(v == selectTime_edittxt){


        }


        // implements your things
    }
}

