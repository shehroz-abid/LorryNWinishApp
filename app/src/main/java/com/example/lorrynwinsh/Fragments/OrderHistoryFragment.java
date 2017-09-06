package com.example.lorrynwinsh.Fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.CursorLoader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lorrynwinsh.Adapters.OrderHistoryAdapter;
import com.example.lorrynwinsh.Gui.DisplayRoute;
import com.example.lorrynwinsh.R;
import com.example.lorrynwinsh.Utils.PermissionUtils;

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
    public static final int CALL_LOG_PERMISSION_REQUEST_CODE = 101;

    public static OrderHistoryFragment newInstance(){
        OrderHistoryFragment f = new OrderHistoryFragment();

        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        enableCallLogPermissions();
        if(view==null)
        {
            view=inflater.inflate(R.layout.history_orders, container,false);
        }
        else
        {
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }
        ((DisplayRoute)getActivity()).toolBarTitleTextView.setText("Order History");
        ((DisplayRoute)getActivity()).homeMenuButton.setVisibility(View.INVISIBLE);
        ((DisplayRoute)getActivity()).homeBackButton.setVisibility(View.VISIBLE);

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

    private void enableCallLogPermissions() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_CALL_LOG)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(getActivity(), CALL_LOG_PERMISSION_REQUEST_CODE,
                    Manifest.permission.READ_CALL_LOG, true);
        } else{
            callLog=getCallLog();
            OrderHistoryAdapter adapter=new OrderHistoryAdapter(getActivity(),R.layout.item_history_orders,callLog);
            if (view != null){
                list_calllog=(ListView)view.findViewById(R.id.order_listview);
                list_calllog.setAdapter(adapter);
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != CALL_LOG_PERMISSION_REQUEST_CODE ) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.READ_CALL_LOG)) {
            callLog=getCallLog();
            OrderHistoryAdapter adapter=new OrderHistoryAdapter(getActivity(),R.layout.item_history_orders,callLog);
            list_calllog=(ListView)view.findViewById(R.id.order_listview);
            list_calllog.setAdapter(adapter);
        }
        else {
            // Display the missing permission error dialog when the fragments resume.
            Toast.makeText(getActivity(), "Permissions denied", Toast.LENGTH_SHORT).show();
        }
    }
}
