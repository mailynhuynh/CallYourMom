package com.example.volleytesting;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import reminderUtil.ReminderGet;

public class ReminderJSONTest {

    @Test
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
}
