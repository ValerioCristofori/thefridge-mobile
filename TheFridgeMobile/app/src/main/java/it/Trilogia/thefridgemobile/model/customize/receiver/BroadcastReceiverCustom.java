package it.Trilogia.thefridgemobile.model.customize.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.activity.sign.MainActivity;
import it.Trilogia.thefridgemobile.controller.NotificationController;
import it.Trilogia.thefridgemobile.implementation.instance.Instance;
import it.Trilogia.thefridgemobile.model.entity.Food;
import it.Trilogia.thefridgemobile.model.entity.Fridge;

public class BroadcastReceiverCustom extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            Fridge fridge = Instance.getSingletonInstance().getCurrentUser().getFridge();
            Date c = Calendar.getInstance().getTime();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = df.format(c);
            for(Food food : fridge.getListFood() ) {
                String yourDate = food.getExpirationDate();

                if (formattedDate.equals(yourDate)) {
                    Intent it = new Intent(context, MainActivity.class);
                    //add the notification
                    NotificationController notificationController = new NotificationController();
                    String expirationMessage = String.format("Oh no! Your %s is expired!!!", food.getName());
                    Log.e("date",expirationMessage);
                    notificationController.createNotification(context, it, "Expiration Message", expirationMessage);
                }
            }
        }catch (Exception e){
            Log.i("date","error == "+e.getMessage());
        }


    }

}
