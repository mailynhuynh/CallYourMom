package reminderUtil;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

public class ReminderNotification extends ContextWrapper {
    private final String channelID = "reminderID";
    private final  String channelName = "ReminderChannel";
    private NotificationManager reminderNotifManager;


    public ReminderNotification(Context base) {
        super(base);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannel()
    {
        NotificationChannel channel = new NotificationChannel(channelID, channelName,
                NotificationManager.IMPORTANCE_HIGH);
    }

    /**
     * Returns this classes notification manager.
     *
     * @return
     *
     *      Notification manager for this class.
     */
    public NotificationManager getManager(){
        if(reminderNotifManager == null){
            reminderNotifManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return reminderNotifManager;
    }

    /**
     * Returns the NotificationCompat.Builder
     *
     * @param reminder
     *      Reminder to use.
     *
     * @return
     *      NotificationCompat.Builder we need.
     */
    public NotificationCompat.Builder getChannelNotification(Reminder reminder)
    {
        NotificationCompat.Builder notificationCB = new
                NotificationCompat.Builder(getApplicationContext(), channelID);
        notificationCB.setContentTitle(reminder.getTitle());
        notificationCB.setContentText(reminder.getLocation());
        //TODO add more details to reminders.

        return notificationCB;
    }

}
