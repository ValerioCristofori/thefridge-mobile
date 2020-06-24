package it.Trilogia.thefridgemobile.model.customize.receiver;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import it.Trilogia.thefridgemobile.activity.sign.MainActivity;
import it.Trilogia.thefridgemobile.controller.NotificationController;
import it.Trilogia.thefridgemobile.implementation.instance.Instance;
import it.Trilogia.thefridgemobile.model.entity.Food;
import it.Trilogia.thefridgemobile.model.entity.Fridge;

public class BroadcastService extends Service {

    private static BroadcastReceiverCustom broadcastReceiverCustom;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate()
    {
        receive();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null ) {
            receive();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy()
    {

    }

    private void receive() {
        broadcastReceiverCustom = new BroadcastReceiverCustom();
    }

}
