package com.example.volleytesting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    Button friends;
    Button eventsList;
    ImageButton profile;
    Button reminders;
    private String name;

    TextView nameOfUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");

        nameOfUser = findViewById(R.id.user_name);
        nameOfUser.setText(name);
        //Init the buttons
        friendsButtonInit();
        profileInit();
        eventsListInit();
        remindersInit();

    }

    private void friendsButtonInit()
    {
        friends = findViewById(R.id.friendsbutton);
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent friends = new Intent(getApplicationContext(), Friends.class);
                friends.putExtra("name",name);
                startActivity(friends);

            }
        });

    }
    private void profileInit()
    {
        profile = findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO create profile page.
                Intent profile = new Intent(getApplicationContext(), Friend_Profile.class);
                startActivity(profile);
            }
        });
    }
    private void eventsListInit()
    {
        eventsList = findViewById(R.id.eventsList);
        eventsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent events_list = new Intent(getApplicationContext(), EventsList.class);
                /*reminder.putExtra("name",name);*/
                startActivity(events_list);
            }
        });
    }
    private void remindersInit()
    {
        reminders = findViewById(R.id.reminders);
        reminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reminder = new Intent(getApplicationContext(), ReminderCreator.class);
                reminder.putExtra("name",name);
                startActivity(reminder);
            }
        });
    }
}
