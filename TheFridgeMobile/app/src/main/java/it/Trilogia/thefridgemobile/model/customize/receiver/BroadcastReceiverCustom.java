package it.Trilogia.thefridgemobile.model.customize.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import it.Trilogia.thefridgemobile.R;

public class BroadcastReceiverCustom extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder( context, "notifyExpirationDate")
                .setSmallIcon(R.drawable.alert_icon)
                .setContentTitle("Notification TheFridge")
                .setContentText("Your food let's expiry!!!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from( context );

        notificationManagerCompat.notify( 200, builder.build() );
    }
}
