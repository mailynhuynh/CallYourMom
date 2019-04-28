package validation;

import java.util.Calendar;

public class ValidateReminder {
    /**
     * Validates the date field.
     * @param regex
     *      regex used to seperate date values "/" or "-"
     * @return
     *      true if date is valid, false otherwise.
     */
    public static boolean validateDate(String regex, String date) {
        String[] strArray = date.split(regex);
        if(strArray.length == 3)
        {
            int month, day, year;
            try {
                month = Integer.parseInt(strArray[0]);
                day = Integer.parseInt(strArray[1]);
                year = Integer.parseInt(strArray[2]);
            }
            catch (Exception e) {
                return false;
            }
            if(((month > 12 || month < 1)) ||
                    !validateDay(day,month,year) ||
                    !validateYear(year))  {
                return false;
            }


        }
        else { return false; }
        return true;
    }
    /**
     * Method to validate the time being passed in.
     *
     * Time is valid if hour is within range [1-12] inclusive and minute is within the range [0, 59]
     * inclusive.
     *
     * @return
     *      True if time is valid, false otherwise.
     *
     */
    public static boolean validateTime(String time) {
        String[] strArr = time.toString().split(":");
        if( strArr.length == 2 ) {
            int hour, minute;

            try{
                hour = Integer.parseInt(strArr[0]);
                minute = Integer.parseInt(strArr[1]);
            }
            catch (Exception e)
            {
                return false;
            }
            if((hour > 12 || hour < 1) || (minute > 59 || minute < 0 )) { return false; }
        }
        else { return false; }

        return true;

    }
    /**
     * Validates that the day is valid given the month and year.
     *
     * @param day
     *      - Day to check
     * @param month
     *      -Month of the year
     * @param year
     *      -Year
     *
     * @return
     *      True if valid day, false otherwise.
     */
    private static boolean validateDay(int day, int month, int year)
    {
        if(month == 2){
            if(isLeapYear(year)){
                return day < 30;
            }
            else{
                return day < 29;
            }
        }
        if(month == 4 || month == 6 || month == 9 || month == 11){
            return day < 31;
        }
        return day < 32;
    }

    /**
     * Determines if given year is a leap year.
     *
     * @param year
     *      Year to check
     * @return
     *      True if year is a leap year, false otherwise.
     */
    private static boolean isLeapYear(int year){
        return ((( year % 4 == 0 ) && ( year % 100 != 0 )) || (year % 400 == 0));

    }
    /**
     *  Validates that the given year is valid for our program.
     *
     * @param year
     *      -Year to check
     * @return
     *      -True if valid, false otherwise
     */
    private static boolean validateYear(int year)
    {
        int maxYear = Calendar.getInstance().get(Calendar.YEAR) + 100;
        int minYear = Calendar.getInstance().get(Calendar.YEAR);
        return ( year >= minYear && year <= maxYear );
    }

}
