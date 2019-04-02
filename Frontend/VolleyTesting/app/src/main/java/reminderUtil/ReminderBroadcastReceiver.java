package reminderUtil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;


public class ReminderBroadcastReceiver extends BroadcastReceiver {

    static String title;
    static String location;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        //String title = intent.getStringExtra("title");
        //String location = intent.getStringExtra("location");


        ReminderNotification reminderNotification = new ReminderNotification(context);
        NotificationCompat.Builder notificationCB = reminderNotification.getChannelNotification
                (this.title, this.location);

        reminderNotification.getManager().notify(1, notificationCB.build());

    }


}
