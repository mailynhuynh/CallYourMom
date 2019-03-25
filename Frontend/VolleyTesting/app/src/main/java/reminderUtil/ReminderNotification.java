package reminderUtil;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

import com.example.volleytesting.R;

import reminderUtil.Reminder;

public class ReminderNotification extends ContextWrapper {
    private final String channelID = "reminderID";
    private final  String channelName = "ReminderChannel";
    private NotificationManager reminderNotifManager;


    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.O)
    public ReminderNotification(Context base) {
        super(base);
        createChannel();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannel()
    {
        NotificationChannel channel = new NotificationChannel(channelID, channelName,
                NotificationManager.IMPORTANCE_HIGH);

        getManager().createNotificationChannel(channel);
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
     *
     * @param title
     * @param location
     * @return
     */
    public NotificationCompat.Builder getChannelNotification(String title, String location)
    {
        NotificationCompat.Builder notificationCB = new
                NotificationCompat.Builder(getApplicationContext(), channelID);
        notificationCB.setContentTitle(title);
        notificationCB.setContentText(location);
        notificationCB.setSmallIcon(R.drawable.ic_notifications_black_24dp);
        //TODO add more details to reminders.

        return notificationCB;
    }

}
