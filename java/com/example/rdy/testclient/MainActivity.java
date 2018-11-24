package com.example.rdy.testclient;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidhive.R;



public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    private static final String TAG = "MyActivity";


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button start_service = (Button) findViewById(R.id.bStartService);
        Button stop_service = (Button) findViewById(R.id.bStopService);

        final TextView status = (TextView) findViewById(R.id.tvStatus);


        start_service.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "start Button Clicked", Toast.LENGTH_SHORT).show();
                // defining the context
                startService(new Intent(MainActivity.this, TestService.class));

                status.setText("service started");

            }
        });

        stop_service.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.i(TAG, "stopping service " );
                Toast.makeText(MainActivity.this, "stop Button Clicked", Toast.LENGTH_SHORT).show();

                stopService(new Intent(MainActivity.this, TestService.class));

                status.setText("service stopped");

            }
        });

    }


}