package com.example.volleytesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

public class ReminderCreator extends AppCompatActivity {

    private static String[] SPINNER_LIST = {"AM","PM"};

    private EditText title, date, time, location;
    private Button create;
    private Spinner amOrPm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_creator);

        initFields();




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
    private boolean valiDATE(String regex) {
        String timeEntered = time.getText().toString();
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
