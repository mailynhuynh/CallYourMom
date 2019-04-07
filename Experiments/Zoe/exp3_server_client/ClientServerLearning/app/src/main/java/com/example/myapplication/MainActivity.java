package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;


public class MainActivity extends AppCompatActivity {

    private ServerSocket ss;
    static TextView serverMessages;
    private Button btn;
    private int port = 8080;
    static int clientCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.serverStart);
        serverMessages = findViewById(R.id.server_messages);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runServer();
            }
        });


    }
    public void runServer()
    {
        try{
            ss = new ServerSocket(port);
            serverMessages.setText("Connected to Port: "+port);

        }
        catch(Exception e)
        {
            serverMessages.setText("Failure to start server.");
        }
        Socket clientSocket = null;
        while(true) {
            try {
                clientSocket = ss.accept();
                ClientHandler ch = new ClientHandler(clientSocket);
                Thread thread = new Thread(ch);
                clientCount++;
                thread.start();

            } catch (Exception e) {
                serverMessages.setText("Failure to connect to client " + (clientCount + 1));
            }
        }

    }

}

class ClientHandler extends Thread {
    Socket socket = null;
    BufferedReader input = null;
    PrintStream output = null;

    public ClientHandler(Socket soc) throws IOException {
        socket = soc;
        input = new BufferedReader(new InputStreamReader((socket.getInputStream())));
        output = new PrintStream(socket.getOutputStream());

    }
    @Override
    public void run()
    {

    }
}