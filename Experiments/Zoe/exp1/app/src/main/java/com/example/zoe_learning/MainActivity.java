package com.example.zoe_learning;

import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view)
    {
        Intent intent1 = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.enter_something);
        String message = editText.getText().toString();
        intent1.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent1);

    }
}
