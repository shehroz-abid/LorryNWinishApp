package com.example.lorrynwinsh.Adapters;

import android.content.Context;
import android.provider.CallLog;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lorrynwinsh.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Shehroz on 29-Aug-17.
 */

public class OrderHistoryAdapter extends ArrayAdapter<HashMap<String,String>>
{
    private ArrayList<HashMap<String,String>> callLogData;
    private Context context;
    private int resource;
    private View view;
    private Holder holder;
    private HashMap<String,String> hashMap;
    public OrderHistoryAdapter(Context context, int resource,ArrayList<HashMap<String, String>> objects)
    {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.callLogData=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(resource, parent,false);

        holder=new Holder();

        holder.order_status_img=(ImageView)view.findViewById(R.id.order_status_img);
        holder.order_booking_id_txt=(TextView)view.findViewById(R.id.order_booking_id_txt);


        hashMap=callLogData.get(position);

        /*Date date=new Date(Long.parseLong(hashMap.get(CallLog.Calls.DATE)));
        java.text.DateFormat dateFormat=DateFormat.getDateFormat(context);
        java.text.DateFormat timeformat= DateFormat.getTimeFormat(context);
*/

        holder.order_booking_id_txt.setText(hashMap.get(CallLog.Calls.NUMBER));
        holder.order_status_img.setImageResource(R.drawable.good_mark);

        return view;
    }

    public class Holder
    {
        TextView order_booking_id_txt;
        ImageView order_status_img;

    }

}
