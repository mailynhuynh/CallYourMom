package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.net.Socket;


public class SignIn extends AppCompatActivity {

    private Button butt;
    private TextView clientMessages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        butt = findViewById(R.id.sign_in_btn);
        clientMessages = findViewById(R.id.clientMessages);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connect();
            }
        });





    }
    public void Connect()
    {
        try {
            clientMessages.setText("Connecting to server.");
            Socket clientSocket = new Socket("localhost", 8080);
        }
        catch(Exception e)
        {
            clientMessages.setText("Failed to connect to Server");
        }
        while(true)
        {
            clientMessages.setText("Connected to Server");
        }

    }
}
