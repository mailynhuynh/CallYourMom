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
    //TODO - fix format notation to allow for spaces in Strings.
    /**
     * Format goes
     *  %{title}-{location}-{month}-{day}-{year}-{hour}-{minute}
     * @return
     */
    public static String reminderToDataString(Reminder reminder){
        String reminderFormatted = "%"+reminder.getTitle()+"-"+reminder.getLocation()
                +"-"+reminder.getMonth()+"-"+reminder.getDay()+"-"+reminder.getYear()
                +"-"+reminder.getHour()+"-"+reminder.getMinute();

        return reminderFormatted;
    }

    /**
     * Takes a string of the format above and converts it into a reminder object.
     * @param str
     * @return
     */
    public static Reminder stringToReminder(String str)
    {
        Reminder reminder = new Reminder();
        str = str.split("%")[1];

        String[] stringArr = str.split("-");

        reminder.setTitle(stringArr[0]);
        reminder.setLocation(stringArr[1]);
        reminder.setMonth(Integer.parseInt(stringArr[2]));
        reminder.setDay(Integer.parseInt(stringArr[3]));
        reminder.setYear(Integer.parseInt(stringArr[4]));
        reminder.setHour(Integer.parseInt(stringArr[5]));
        reminder.setMinute(Integer.parseInt(stringArr[6]));

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
