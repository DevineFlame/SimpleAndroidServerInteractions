package com.example.rdy.testclient;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;



import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;



public class PostData extends AsyncTask<String, String, String> {
    private static final String TAG = "PostData";
    public static final String REQUEST_METHOD = "POST";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;

    public PostData() {
        //set context variables if required
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {


        String stringUrl = params[0];
        String result = "something something";
        String data = "code=rdy was here";
        OutputStream out = null;
        try {
            URL url = new URL(stringUrl);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
             out = new BufferedOutputStream(urlConnection.getOutputStream());

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            writer.write(data);
            writer.flush();
            writer.close();
            out.close();

            urlConnection.connect();
            int response=urlConnection.getResponseCode();
            Log.i(TAG,"got the response"+response);

        } catch (Exception e) {
            Log.i(TAG,"got the response"+e.getMessage());
        }
        return  result;
    }

}
