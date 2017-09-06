package com.example.lorrynwinsh.Gui;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lorrynwinsh.R;


/**
 * Created by macbookpro on 13/06/2017.
 */

public class EnableGPSActivity extends AppCompatActivity {

    Button btnEnableGPS;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.gps_settings_layout);

        btnEnableGPS = (Button) findViewById(R.id.btnEnableGPS);

        btnEnableGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        });
    }
}
