package it.Trilogia.thefridgemobile.model.customize.receiver;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.view.activity.sign.MainActivity;
import it.Trilogia.thefridgemobile.controller.NotificationController;
import it.Trilogia.thefridgemobile.model.implementation.instance.Instance;
import it.Trilogia.thefridgemobile.model.entity.Food;
import it.Trilogia.thefridgemobile.model.entity.Fridge;

public class BroadcastService extends Service {

    private Context context;
    private boolean isRunning;
    private Thread backgroundThread;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate()
    {
        this.context = this;
        this.isRunning = false;
        this.backgroundThread = new Thread(try_send_notification);
    }

    private Runnable try_send_notification = new Runnable() {
        @Override
        public void run() {
            Log.e("date","start service");
            try {
                Fridge fridge = Instance.getSingletonInstance().getCurrentUser().getFridge();
                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = df.format(c);
                for(Food food : fridge.getListFood() ) {
                    String yourDate = food.getExpirationDate();

                    if (formattedDate.equals(yourDate)) {
                        Intent it = new Intent(getBaseContext(), MainActivity.class);
                        //add the notification
                        NotificationController notificationController = new NotificationController();
                        String expirationMessage = String.format("%s %s %s", getString(R.string.notification1), food.getName(), getString(R.string.notification2));
                        Log.e("date",expirationMessage);
                        notificationController.createNotification(getBaseContext(), it, getString(R.string.titleNotification), expirationMessage);
                    }
                }
            }catch (Exception e){
                Log.i("date","error == "+e.getMessage());
            }
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!this.isRunning){
            this.isRunning = true;
            this.backgroundThread.start();
        }

        return START_STICKY ;
    }

    @Override
    public void onDestroy()
    {
        super .onDestroy() ;
    }

}
