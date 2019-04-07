package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //sign in button
    private Button signIn;
    //For accepting sign-up input
    private EditText email;
    private EditText password;
    //Sign up button
    private Button signUp;
    //For displaying email & password
    private TextView emailTV;
    private TextView passwordTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Sign In init
        signIn = findViewById(R.id.sign_in_page);
        //Sign up content init
        signUp = findViewById(R.id.sign_up);
        email =  findViewById(R.id.email);
        password = findViewById(R.id.password);
        //Sign up test view init
        emailTV = findViewById(R.id.test_for_email);
        passwordTV = findViewById(R.id.test_for_password);

        /**
         * Creating new OnClickListener to open Main Menu
         */
        signIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openMainMenu();
            }
        });

        /**
         * Creating new OnClickListener to store email and password
         */
        signUp.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                String em = email.getText().toString();
                String pass = password.getText().toString();
                emailTV.setText(em);
                passwordTV.setText(pass);


            }
        });

    }

    public void openMainMenu()
    {
        //Opens new activity
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }
}

