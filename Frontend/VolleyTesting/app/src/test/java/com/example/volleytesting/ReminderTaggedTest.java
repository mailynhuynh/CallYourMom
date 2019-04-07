package com.example.volleytesting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import reminderUtil.Reminder;
import users.Friend;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ReminderTaggedTest {

    @Test
    public void tagOneTest(){
        Friend f = mock(Friend.class);
        Reminder r = new Reminder();

        when(f.getName()).thenReturn("Harry");
        when(f.getID()).thenReturn(33);
        r.tag(f);

        assertEquals(r.nameTaggedByID(33), "Harry");
    }
    @Test
    public void untagTestReturnFalse()
    {
        Friend f1 = mock(Friend.class);
        Reminder r1 = new Reminder();
        assertEquals(r1.untag(f1), new Boolean(false));
    }
    @Test
    public void untagTestReturnTrue()
    {
        Friend f2 = mock(Friend.class);
        Reminder r2 = new Reminder();
        when(f2.getName()).thenReturn("Hermione");
        when(f2.getID()).thenReturn(38);

        r2.tag(f2);
        assertEquals(r2.untag(f2), new Boolean(true));
    }
    @Test
    public void untagTestReturnNull(){
        Friend f3 = mock(Friend.class);
        Reminder r3 = new Reminder();
        when(f3.getName()).thenReturn("Neville");
        when(f3.getID()).thenReturn(43);

        r3.tag(f3);
        r3.untag(f3);
        assertEquals(r3.nameTaggedByID(43), null);
    }
    @Test
    public void getTaggedNamesTest(){
        Friend f4 = mock(Friend.class);
        Friend f5 = mock(Friend.class);
        Friend f6 = mock(Friend.class);

        when(f4.getName()).thenReturn("Hagrid");
        when(f5.getName()).thenReturn("Dumbledore");
        when(f6.getName()).thenReturn("Snape");

        Reminder r4 = new Reminder();
        r4.tag(f4);
        r4.tag(f5);
        r4.tag(f6);

        List<String> expected = new ArrayList<>();
        expected.add("Hagrid");
        expected.add("Dumbledore");
        expected.add("Snape");
        List<String> list = r4.getTaggedNames();
        for(int i = 0; i < list.size(); i++){
            assertTrue(list.get(i).equals(expected.get(i)));
        }



    }

}
