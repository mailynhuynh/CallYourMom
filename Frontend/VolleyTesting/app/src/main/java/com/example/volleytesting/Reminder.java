package com.example.volleytesting;

import java.util.Calendar;

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
}
