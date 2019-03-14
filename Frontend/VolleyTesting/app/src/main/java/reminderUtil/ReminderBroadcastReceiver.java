package reminderUtil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;


public class ReminderBroadcastReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        String reminderTitle = intent.getExtras().getString("title");
        String reminderLocation = intent.getExtras().getString("location");
        ReminderNotification reminderNotification = new ReminderNotification(context);
        NotificationCompat.Builder notificationCB = reminderNotification.getChannelNotification
                (reminderTitle, reminderLocation);

        reminderNotification.getManager().notify(1, notificationCB.build());

    }

}
