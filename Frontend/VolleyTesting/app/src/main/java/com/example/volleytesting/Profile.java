package com.example.volleytesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profile extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        b1 = (Button) findViewById(R.id.Back);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            };

         });


    }
}
