package com.example.volleytesting;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

import reminderUtil.Reminder;

public class ReminderCreator extends AppCompatActivity {

    private Reminder reminder;

    private static String[] SPINNER_LIST = {"AM","PM"};

    private EditText title, date, time, location;
    private Button create;
    private Spinner amOrPm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_creator);

        initFields();
        createPress();




    }
    private void createPress()
    {
        create.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if(!validateDate("/")){
                    easyToast("Please enter a valid date");
                    date.setText("");
                    return;
                }
                String enteredDate = date.getText().toString();
                if(!validateTime()) {
                    easyToast("Please enter a valid time.");
                    time.setText("");
                    return;
                }
                String enteredTime = time.getText().toString();

                String enteredTitle = title.getText().toString();
                String enteredLocation = location.getText().toString();
                boolean isAM = amOrPm.getSelectedItem().toString().equals("AM");

                createReminder(enteredDate, enteredTime, enteredTitle, enteredLocation, isAM);

            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void createReminder(String date, String time, String title, String location, boolean isAM)
    {
        int[] dateInts = stringParseInt(date, "/");
        int[] timeInts = stringParseInt(time,":");

        reminder = new Reminder();
        reminder.setMonth(dateInts[0]);
        reminder.setDay(dateInts[1]);
        reminder.setYear(dateInts[2]);
        int theHour = hourTo24(timeInts[0], isAM);

        reminder.setHour(theHour);
        reminder.setMinute(timeInts[1]);

        reminder.setTitle(title);
        reminder.setLocation(location);

        reminder.setReminder(this);
        easyToast("Alarm created");

    }

    /**
     * Converts from 12-hour time to 24 hour
     *
     * @param hour
     * @param isAM
     *
     * @return
     *      Hour in 24hour form.
     */
    private int hourTo24(int hour, boolean isAM){
        if(hour == 12 && isAM) {
            return 0;
        }
        if(!isAM && hour != 12) {
            return hour + 12;
        }
        return hour;

    }
    /**
     * Helper method to parse a string into an array of ints based off of a regex.
     *
     * @param s
     *      String to use
     * @param regex
     *      Regex to use
     * @return
     *      Integer array.
     */
    private int[] stringParseInt(String s, String regex)
    {
        String[] sArr = s.split(regex);
        int[] intArray = new int[sArr.length];
        for(int i = 0; i < sArr.length; i++)
        {
            try {
                intArray[i] = Integer.parseInt(sArr[i]);
            }
            catch (Exception e)
            {
                return null;
            }
        }
        return intArray;

    }

    /**
     * Custom and faster call to makeToast.
     *
     * @param s
     *      Message to be displayed in toast.
     */
    private void easyToast(String s){
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }

    /**
     * Initializes the AM-PM dropdown menu
     */
    private void initDropDown()
    {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNER_LIST);

        amOrPm = findViewById(R.id.AmOrPm);
        amOrPm.setAdapter(arrayAdapter);
    }

    /**
     * Initializes the layout components
     */
    private void initFields() {
        title = findViewById(R.id.rTitle);
        date = findViewById(R.id.rDate);
        time = findViewById(R.id.rTime);
        location = findViewById(R.id.rLocation);
        create = findViewById(R.id.createReminder);

        initDropDown();
    }

    /**
     * Validates the date field.
     * @param regex
     *      regex used to seperate date values "/" or "-"
     * @return
     *      true if date is valid, false otherwise.
     */
    private boolean validateDate(String regex) {
        String timeEntered = date.getText().toString();
        String[] strArray = timeEntered.split(regex);
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
    private boolean validateTime() {
        String[] strArr = time.getText().toString().split(":");
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
    private boolean validateDay(int day, int month, int year)
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
     *  Validates that the given year is valid for our program.
     *
     * @param year
     *      -Year to check
     * @return
     *      -True if valid, false otherwise
     */
    private boolean validateYear(int year)
    {
        int maxYear = Calendar.getInstance().get(Calendar.YEAR) + 100;
        int minYear = Calendar.getInstance().get(Calendar.YEAR);
        return ( year >= minYear && year <= maxYear );
    }

    /**
     * Determines if given year is a leap year.
     *
     * @param year
     *      Year to check
     * @return
     *      True if year is a leap year, false otherwise.
     */
    private boolean isLeapYear(int year){
       return ((( year % 4 == 0 ) && ( year % 100 != 0 )) || (year % 400 == 0));

    }
}
