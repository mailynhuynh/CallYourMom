package reminderUtil;

import java.util.Scanner;

public class ReminderReceiver {

    public  ReminderReceiver(){

    }
    /**
     * Format goes
     *  {title} {location} {month} {day} {year} {hour} {minute}
     * @return
     */
    private static String reminderToDataString(Reminder reminder){
        String reminderFormatted = reminder.getTitle()+" "+reminder.getLocation()
                +" "+reminder.getMonth()+" "+reminder.getDay()+" "+reminder.getYear()
                +" "+reminder.getHour()+" "+reminder.getMinute();

        return reminderFormatted;
    }
    public static Reminder stringToReminder(String str)
    {
        Scanner scan = new Scanner(str);
        Reminder reminder = new Reminder();

        reminder.setTitle(scan.next());
        reminder.setLocation(scan.next());
        reminder.setMonth(scan.nextInt());
        reminder.setDay(scan.nextInt());
        reminder.setYear(scan.nextInt());
        reminder.setHour(scan.nextInt());
        reminder.setMinute(scan.nextInt());

        return reminder;
    }
    public static String reminderToUser(String user, Reminder rem){
        return "@"+user+" "+reminderToDataString(rem);
    }
}
