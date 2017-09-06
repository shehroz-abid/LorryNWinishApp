package com.example.lorrynwinsh.Gui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lorrynwinsh.R;

/**
 * Created by Shehroz on 14-Aug-17.
 */

public class SplashScreen extends AppCompatActivity {
    Button btnGetStarted;
    TextView sloganTextView;

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        btnGetStarted = (Button) findViewById(R.id.btn_getstarted);
        sloganTextView = (TextView) findViewById(R.id.slogan_tv);


        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {


                btnGetStarted.setVisibility(View.VISIBLE);
                sloganTextView.setVisibility(View.VISIBLE);
                btnGetStarted.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startRegisterOptionsActivity();
                    }
                });
            }
        }, SPLASH_TIME_OUT);
    }

    private void startRegisterOptionsActivity(){
        Intent i = new Intent(SplashScreen.this, RegisterOptionsActivity.class);
        startActivity(i);
        finish();
    }

}
