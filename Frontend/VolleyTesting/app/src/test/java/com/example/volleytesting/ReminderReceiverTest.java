package com.example.volleytesting;

import org.junit.Test;

import reminderUtil.Reminder;
import reminderUtil.ReminderReceiver;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ReminderReceiverTest {

    @Test
    public void reminderToStringTest()
    {
        Reminder r1 = new Reminder();
        r1.setTitle("Hi");
        r1.setHour(12);
        r1.setMinute(33);
        r1.setMonth(4);
        r1.setDay(8);
        r1.setYear(2019);
        r1.setLocation("here");

        String expected = "%Hi-here-4-8-2019-12-33";
        String out = ReminderReceiver.reminderToDataString(r1);

        assertEquals(out,expected);

    }
    @Test
    public void stringToReminderTest()
    {
        String input = "%Hi-here-4-8-2019-12-33";

        Reminder output = ReminderReceiver.stringToReminder(input);

        Reminder expected = new Reminder();
        expected.setTitle("Hi");
        expected.setLocation("here");
        expected.setMonth(4);
        expected.setDay(8);
        expected.setYear(2019);
        expected.setHour(12);
        expected.setMinute(33);

        assertTrue(output.equals(expected));

    }


}
