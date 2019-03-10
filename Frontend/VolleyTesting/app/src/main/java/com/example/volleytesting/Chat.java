package com.example.volleytesting;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Chat extends AppCompatActivity {
    Button back_button, friend_profile, message_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Init the buttons
        BackButtonInit();
        FriendProfileInit();
        MessageButtonInit();

    }


    private void BackButtonInit() {
        back_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplication(), "BackButton", Toast.LENGTH_LONG).show();

            }
        });
    }
    private void FriendProfileInit() {
        friend_profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplication(), "BackButton", Toast.LENGTH_LONG).show();

            }
        });
    }
    private void MessageButtonInit() {
        message_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplication(), "BackButton", Toast.LENGTH_LONG).show();

            }
        });
    }






    }


