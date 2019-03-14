package reminderUtil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;


public class ReminderBroadcastReceiver extends BroadcastReceiver {

    Reminder reminder;
    public ReminderBroadcastReceiver(Reminder reminder){
       super();
       this.reminder = reminder;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ReminderNotification reminderNotification = new ReminderNotification(context);
        NotificationCompat.Builder notificationCB = reminderNotification.getChannelNotification(reminder);
        reminderNotification.getManager().notify(1, notificationCB.build());

    }
}
