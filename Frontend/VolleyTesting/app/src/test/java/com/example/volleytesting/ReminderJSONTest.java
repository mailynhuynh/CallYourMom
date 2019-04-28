package com.example.volleytesting;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import reminderUtil.Reminder;
import reminderUtil.ReminderGet;

import static junit.framework.TestCase.assertTrue;

public class ReminderJSONTest {

    //@Test
    public void JSONtoReminderTest(){


        ReminderGet rGet = new ReminderGet("hola");
        JSONObject obj = new JSONObject();
        try {
            obj.put("title","HelloTest1");
            obj.put("location","ParksLib");
            obj.put("time","04/28/2019 13:06");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void dateTimeSetTestDay(){
        Reminder r = new  Reminder();
        r.setTitle("hello");
        r.setLocation("here");
        String dateTm = "04/28/2019 15:02";
        ReminderGet rG = new ReminderGet("bleh");
        rG.dateTimeSet(r, dateTm);

        assertTrue(r.getDay()==28);
    }
    @Test
    public void dateTimeSetTestMonth(){
        Reminder r = new  Reminder();
        r.setTitle("hello");
        r.setLocation("here");
        String dateTm = "04/28/2019 15:02";
        ReminderGet rG = new ReminderGet("bleh");
        rG.dateTimeSet(r, dateTm);

        assertTrue(r.getMonth()==4);
    }
    @Test
    public void dateTimeSetTestYear(){
        Reminder r = new  Reminder();
        r.setTitle("hello");
        r.setLocation("here");
        String dateTm = "04/28/2019 15:02";
        ReminderGet rG = new ReminderGet("bleh");
        rG.dateTimeSet(r, dateTm);

        assertTrue(r.getYear()==2019);
    }
    @Test
    public void dateTimeSetTestHour(){
        Reminder r = new  Reminder();
        r.setTitle("hello");
        r.setLocation("here");
        String dateTm = "04/28/2019 15:02";
        ReminderGet rG = new ReminderGet("bleh");
        rG.dateTimeSet(r, dateTm);

        assertTrue(r.getHour()==15);
    }
    @Test
    public void dateTimeSetTestMinute(){
        Reminder r = new  Reminder();
        r.setTitle("hello");
        r.setLocation("here");
        String dateTm = "04/28/2019 15:02";
        ReminderGet rG = new ReminderGet("bleh");
        rG.dateTimeSet(r, dateTm);

        assertTrue(r.getMinute()==2);
    }
}
