package it.valeriocristofori.thefridgemobile.controller;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import java.util.Date;

import static androidx.core.content.ContextCompat.getSystemService;

public class NotificationController {

    public void createNotification(Context context, String foodName, Date date) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "TheFridgeChannel";
            String description = "Channel for The Fridge";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyExpirationDate", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService( context, NotificationManager.class );
            notificationManager.createNotificationChannel(channel);
        }

    }
}
