package reminderUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import users.Friend;
import users.User;


/**
 * Reminder class.
 */
public class Reminder {
    private User creator;
    private List<Friend> tagged = new ArrayList<Friend>();
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
    public void tag(Friend friend){
        tagged.add(friend);
    }
    public boolean untag(Friend friend)
    {
        for(int i = 0; i < tagged.size(); i++)
        {
            if(friend.getID() == tagged.get(i).getID()){
                tagged.remove(friend);
                return true;
            }

        }
        return false;
    }
    public String nameTaggedByID(int id)
    {
        for(int i = 0; i < tagged.size(); i++)
        {
            if(tagged.get(i).getID() == id) { return tagged.get(i).getName(); }
        }
        return null;
    }
    public List<String> getTaggedNames(){
        ArrayList<String> list = new ArrayList<>();
        for(Friend f : tagged){
            list.add(f.getName());
        }
        return list;
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
        ReminderBroadcastReceiver.title = this.getTitle();
        ReminderBroadcastReceiver.location = this.getLocation();
        Intent intent = new Intent(context, ReminderBroadcastReceiver.class)
                .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);



        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
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
        String dateStr = getYear()+"/"+getMonth()+"/"+getDay()+
                " "+getHour()+":"+getMinute()+":00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long millis = date.getTime();
        return millis;

    }

}
