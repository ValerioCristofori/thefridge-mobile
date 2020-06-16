package it.valeriocristofori.thefridgemobile.controller;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import static androidx.core.content.ContextCompat.getSystemService;

public class NotificationController {

    public void createNotification(Context context) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "TheFridgeChannel";
            String description = "Channel for The Fridge";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyExpirationDate", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService( context, NotificationManager.class );
            assert notificationManager != null;
            notificationManager.createNotificationChannel(channel);
        }

    }
}
