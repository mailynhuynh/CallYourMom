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
    Button messageButton;
    Button reminders;
    private String name;
    /*    private String userName;//idk what this is doing. I took it from friends.java*/

    TextView nameOfUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");

        /*        userName = getIntent().getExtras().getString("name");//idk what this is doing. I took it from friends.java*/

        nameOfUser = findViewById(R.id.user_name);//idk what this is doing. I took it from friends.java

        nameOfUser.setText(name);
        //Init the buttons
        friendsButtonInit();
        profileInit();
        eventsListInit();
        remindersInit();
        MessageButtonInit();

    }

    private void friendsButtonInit() {
        friends = findViewById(R.id.friendsbutton);
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent friends = new Intent(getApplicationContext(), Friends.class);
                friends.putExtra("name", name);
                startActivity(friends);

            }
        });

    }

    private void profileInit() {
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

    private void eventsListInit() {
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

    private void remindersInit() {
        reminders = findViewById(R.id.reminders);
        reminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reminder = new Intent(getApplicationContext(), ReminderCreator.class);
                reminder.putExtra("name", name);
                startActivity(reminder);
            }
        });
    }
    private void MessageButtonInit() {
        messageButton = findViewById(R.id.messagebutton);
            messageButton.setOnClickListener(new View.OnClickListener()
    {
        public void onClick (View view){
        Intent Chat = new Intent(getApplicationContext(), Chat.class);
        /*                chat.putExtra("name",userName);*/
        startActivity(Chat);
    }
    });
}
/*        private void MessageButtonInit() {

        messageButton = findViewById(R.id.messagebutton);
        messageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent ChatPage = new Intent(getApplicationContext(), Chat.class);
               *//* ChatPage.putExtra("name",userName);*//*
                startActivity(ChatPage);
            }
        });
    }*/
}
