package com.example.volleytesting;

import java.util.Calendar;

public class Reminder {
    /**
     * Title of reminder
     */
    private String title;
    /**
     * Description of reminder
     */
    private String description;
    /**
     * Minute to set reminder to
     */
    private int minute;
    /**
     * Hour to set reminder to
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
    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
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
    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
