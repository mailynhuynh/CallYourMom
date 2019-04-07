package reminderUtil;

import java.util.Scanner;

/**
 * @author ZoeS
 */
public class ReminderReceiver {

    /**
     * Class for static functional methods for interpreting strings into reminders and vice versa.
     * Used in reminder creator.
     */
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

    /**
     * Takes a string of the format above and converts it into a reminder object.
     * @param str
     * @return
     */
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

    /**
     * returns message in websocket needed in user.
     * @param user
     * @param rem
     * @return
     */
    public static String reminderToUser(String user, Reminder rem){
        return "@"+user+" "+reminderToDataString(rem);
    }
}
