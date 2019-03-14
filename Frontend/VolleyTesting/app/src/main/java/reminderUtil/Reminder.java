package reminderUtil;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;


/**
 * Reminder class.
 */
public class Reminder {
    /**
     * Title of reminder
     */
    private String title;
    /**
     * Description of reminder
     */
    private String location;
    /**
     * Minute to set reminder to (0-59)
     */
    private int minute;
    /**
     * Hour to set reminder to (0-24)
     */
    private int hour;
    /**
     * Day to set reminder to
     */
    private int day;
    /**
     * Month to set reminder to
     */
    private int month;
    /**
     * Year to set reminder to.
     */
    private int year;
    /**
     * Create a reminder object with instance variables initialized to current date and time.
     */
    public Reminder() {
        year = Calendar.YEAR;
        month = Calendar.MONTH;
        day = Calendar.DAY_OF_MONTH;
        hour = Calendar.HOUR;
        minute = Calendar.MINUTE;
    }

    /**
     * Starts reminder as notification.
     *
     * @param context
     *      Context to use. (Will be ReminderCreator)
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void setReminder(Context context){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, ReminderBroadcastReceiver.class);
        intent.putExtra(getTitle(),"title");
        intent.putExtra(getLocation(), "location");

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 1, intent, 0);

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, reminderTimeInMillis(), pendingIntent);


    }
    //TODO create cancel reminder method.

    /**
     * Setter methods
     */
    public void setTitle(String title){
        this.title = title;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void setDay(int day){
        this.day = day;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     *  Getter methods.
     */
    public String getLocation() { return location; }

    public String getTitle() { return title; }

    public int getDay() { return day; }

    public int getHour() { return hour; }

    public int getMinute() { return minute; }

    public int getMonth() { return month; }

    public int getYear() { return year; }

    /**
     * Returns the date in miliseconds. Needed for creating reminder alert.
     * @return
     */
    public long reminderTimeInMillis()
    {
        Calendar c = Calendar.getInstance();
        int year = getYear();
        c.set(Calendar.HOUR_OF_DAY, getHour());
        c.set(Calendar.MINUTE, getMinute());
        c.set(Calendar.DAY_OF_MONTH, getDay());
        c.set(Calendar.MONTH, getMonth());
        c.set(Calendar.YEAR, getYear());

        //TODO fix time bug.
        long timeInMillis = c.getTimeInMillis();
        return timeInMillis;

    }

}
