package com.example.lorrynwinsh.Fragments;

import android.annotation.SuppressLint;
import android.content.CursorLoader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lorrynwinsh.Adapters.OrderHistoryAdapter;
import com.example.lorrynwinsh.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Shehroz on 29-Aug-17.
 */

public class OrderHistoryFragment extends Fragment
{
    private View view;
    private ListView list_calllog;
    private ArrayList<HashMap<String,String>> callLog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if(view==null)
        {
            view=inflater.inflate(R.layout.history_orders, container,false);
        }
        else
        {
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }

        callLog=getCallLog();
        OrderHistoryAdapter adapter=new OrderHistoryAdapter(getActivity(),R.layout.item_history_orders,callLog);
        list_calllog=(ListView)view.findViewById(R.id.order_listview);
        list_calllog.setAdapter(adapter);
        return view;
    }

    @SuppressLint("NewApi")
    public ArrayList<HashMap<String,String>> getCallLog()
    {
        ArrayList<HashMap<String,String>> callLog=new ArrayList<HashMap<String,String>>();
        CursorLoader cursorLoader=new CursorLoader(getActivity(),CallLog.Calls.CONTENT_URI, null, null, null, null);
        Cursor cursor=cursorLoader.loadInBackground();
        if(cursor.moveToFirst())
        {
            while (cursor.moveToNext())
            {
                HashMap<String,String> hashMap=new HashMap<String, String>();
                hashMap.put(CallLog.Calls.NUMBER, cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER)));
                hashMap.put(CallLog.Calls.DATE, cursor.getString(cursor.getColumnIndex(CallLog.Calls.DATE)));
                hashMap.put(CallLog.Calls.DURATION, cursor.getString(cursor.getColumnIndex(CallLog.Calls.DURATION)));
                callLog.add(hashMap);
            }
        }
        return callLog;
    }
}
