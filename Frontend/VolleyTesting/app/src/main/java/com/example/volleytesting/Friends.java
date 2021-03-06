package com.example.volleytesting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import app.AppController;

/**
 *
 * This class is currently for connectivity demonstration purposes only. WILL become friends list.
 */
public class Friends extends AppCompatActivity {

    private String userName;
    Button back;
    Button getFriends;
    Button friendProfile;
    TextView friends;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);
        //Initialize friends text field
        friends = findViewById(R.id.friends);
        //Back button
        back = findViewById(R.id.backb);
        //friend profile
/*        friendProfile = findViewById(R.id.friendprofile);*/



        //userName = getIntent().getExtras().getString("name");


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backScreen = new Intent(getApplicationContext(), Login.class);
                startActivity(backScreen);
            }
        });

/*        messageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent chat = new Intent(getApplicationContext(), Chat.class);
                chat.putExtra("name",userName);
                startActivity(chat);
            }
        });*/

        getFriends = findViewById(R.id.getFriends);
        getFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseJSONFriends();
            }
        });
        friendProfileInit();


    }


/*    private void MessageButtonInit() {
        messageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent ChatPage = new Intent(getApplicationContext(), Chat.class);
                startActivity(ChatPage);
            }
        });
    }*/

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

    private void friendProfileInit() {
        friendProfile = findViewById(R.id.friendprofile);
        friendProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent friend_profile = new Intent(getApplicationContext(), Friend_Profile.class);
                /*reminder.putExtra("name",name);*/
                startActivity(friend_profile);
            }
        });
    }
}
