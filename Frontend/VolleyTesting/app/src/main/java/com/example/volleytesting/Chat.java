package com.example.volleytesting;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class Chat extends AppCompatActivity {
    Button back_button, friend_profile, message_button;

    private String userName;
    private String uri = "ws://cs309-bs-3.misc.iastate.edu:8080/websocket";
    Button send;
    EditText messageField;
    TextView received;
    private WebSocketClient webSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        userName = getIntent().getExtras().getString("name");
        messageField = findViewById(R.id.messageTxt);
        //sent = findViewById(R.id.messagesSent);
        received = findViewById(R.id.messagesReceived);


        uri += "/" + userName;
        Draft[] drafts = {new Draft_6455()};

        try {
            Log.d("Socket:", "Trying socket");
            webSocket = new WebSocketClient(new URI(uri), drafts[0]) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    Log.d("OPEN", "run() returned: " + "is connecting");
                }

                @Override
                public void onMessage(String s) {
                    Log.d("", "run() returned: " + s);
                    received.append("\n" + s);
                }

                @Override
                public void onClose(int i, String s, boolean b) {
                    Log.d("CLOSE", "onClose() returned: " + s);
                }

                @Override
                public void onError(Exception e) {
                    Log.d("Exception:", e.toString());
                }
            };

        } catch (URISyntaxException u) {
            Log.d("Exception", u.getMessage());
            u.printStackTrace();
        }
        webSocket.connect();
        sendButtonSetup();



        //Init the buttons
        /*
         BackButtonInit();
         FriendProfileInit();
         MessageButtonInit();
         */
    }
    public void sendButtonSetup(){
        send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                webSocket.send(messageField.getText().toString());
                messageField.setText("");

            }
        });
    }
}

/**
    private void BackButtonInit() {
        back_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent j = new Intent(getApplicationContext(), Friends.class);
                startActivity(j);
            }
        });
    }
    private void FriendProfileInit() {
        friend_profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(), Friend_Profile.class);
                startActivity(i);

            }
        });
    }
    private void MessageButtonInit() {
        message_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplication(), "Message Button", Toast.LENGTH_LONG).show();

            }
        });
    }

}
*/

