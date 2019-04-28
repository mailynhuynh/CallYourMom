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

    /**
     * Made static so values can be passed to this class without an instance.
     */
    static String title;
    static String location;
    /**
     * Non-static versions
     */
    private String titleInstance;
    private String locationInstance;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        //String title = intent.getStringExtra("title");
        //String location = intent.getStringExtra("location");
        titleInstance = title;
        locationInstance = location;


        ReminderNotification reminderNotification = new ReminderNotification(context);
        NotificationCompat.Builder notificationCB = reminderNotification.getChannelNotification
                (this.titleInstance, this.locationInstance);

        reminderNotification.getManager().notify(1, notificationCB.build());

    }


}
