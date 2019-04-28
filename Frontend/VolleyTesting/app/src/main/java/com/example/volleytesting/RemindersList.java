package com.example.volleytesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import reminderUtil.ReminderGet;

public class RemindersList extends AppCompatActivity {

    private String url = "http://cs309-bs-3.misc.iastate.edu:8080/reminders";
    private TextView reminderText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders_list);
        reminderText = findViewById(R.id.reminderTxt);
        ReminderGet reminderGet = new ReminderGet(url);
        ArrayList<String> reminderStrings = reminderGet.listReminders();
        if(reminderStrings.size()>0) { reminderText.setText(""); }
        for(int i = 0; i < reminderStrings.size(); i++){
            reminderText.append(reminderStrings.get(i)+"\n");
        }

    }
}
