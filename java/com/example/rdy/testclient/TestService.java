package com.example.rdy.testclient;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.example.androidhive.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.util.Calendar;
import java.util.Date;

public class TestService extends Service {
    private static final String TAG = "TestService";


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
        // throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //CallAPI runner = new CallAPI();
        PostData runner  = new PostData();
        String url ="http://192.168.0.27/android/post_data.php";
        String data ="hello";
        runner.execute(url,data);
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }


    }
