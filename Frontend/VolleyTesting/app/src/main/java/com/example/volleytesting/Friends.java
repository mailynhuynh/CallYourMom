package com.example.volleytesting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import app.AppController;

/**
 * @author ZoeS
 * This class is currently for connectivity demonstration purposes only. WILL become friends list.
 */
public class Friends extends AppCompatActivity {

    Button back;
    Button getFriends;
    Button message_button;//button to get to chat page
    TextView friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        //Initialize friends text field
        friends = findViewById(R.id.friends);
        //Back button
        back = findViewById(R.id.backb);

        message_button = findViewById(R.id.message_button);

        MessageButtonInit();//Initializes the message button

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backScreen = new Intent(getApplicationContext(), Login.class);
                startActivity(backScreen);
            }
        });

        getFriends = findViewById(R.id.getFriends);
        getFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseJSONFriends();
            }
        });


    }

    private void MessageButtonInit() {
        message_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(Friends.this, Chat.class);
                startActivity(i);

            }
        });
    }

    /**
     * Parses User JSON objects sent from Server.
     * Displays first name, last name and phone number.
     */
    private void parseJSONFriends()
    {
        String url = "http://cs309-bs-3.misc.iastate.edu:8080/users";

        RequestQueue rq = AppController.getInstance().getRequestQueue();
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                //Loop to append all JSON objects in database to Textview
                for(int i = 0; i < response.length(); i++)
                {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        String fName = obj.getString("firstName");
                        String lName = obj.getString("lastName");
                        String phoneNum = obj.getString("telephone");

                        friends.append(fName+" "+lName+": Phone Number: "+phoneNum+"\n");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }



                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();

            }
        });
        rq.add(arrayRequest);
    }
}
