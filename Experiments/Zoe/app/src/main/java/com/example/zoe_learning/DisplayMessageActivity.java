package com.example.zoe_learning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the String
        Intent intent1 = getIntent();
        String message = intent1.getStringExtra(EXTRA_MESSAGE);
        //Capture the layout's TextView and set the string as its text.
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

    }

}
