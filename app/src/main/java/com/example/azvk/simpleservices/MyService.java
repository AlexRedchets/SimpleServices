package com.example.azvk.simpleservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {

    private final IBinder binder = new LocalBinder();
    private static final String TAG = MyService.class.getSimpleName();

    public MyService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public String getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss a", Locale.getDefault());
        return (df.format(new Date()));
    }

    //create class to get a reference to the MyService class usinf Binder
    public class LocalBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }
}
