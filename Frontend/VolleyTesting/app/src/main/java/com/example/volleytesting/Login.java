package com.example.volleytesting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import app.AppController;

/**
 * @author ZoeS
 * @author John Wagner
 *
 * This class marks the login page activity, still very much in progress and more
 * so used to demonstrate the connectivity of Client and Server
 *
 */
public class Login extends AppCompatActivity {

    /**
     * This was taken from
     * https://www.mytrendin.com/send-data-to-remote-server-in-android-using-volley-library/
     */
    EditText name, email, password, lastName, phoneNumber, userName;
    Button save, displayFriends, login;
    String url = "http://cs309-bs-3.misc.iastate.edu:8080/users";
    RequestQueue queue;
    JsonObjectRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Edit Field initialization
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        lastName = findViewById(R.id.lastName);
        phoneNumber = findViewById(R.id.phoneNumber);
        userName = findViewById(R.id.username);
        // Button initialization
        save = (Button) findViewById(R.id.save);
        displayFriends = findViewById(R.id.friends);
        login = findViewById(R.id.login);
        //This button sends data to server
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = name.getText().toString();
                //TODO: Validate useremail is correct format (xxx__@xxx___.xxx)
                final String useremail = email.getText().toString();
                //TODO validate password is numbers only
                final String userpassword = password.getText().toString();
                final String lName = lastName.getText().toString();
                //TODO validate follows format xxx-xxx-xxxx OR xxxxxxxxxx. If former format, parse into latter.
                final String phoneNum = phoneNumber.getText().toString();
                final String userN = userName.getText().toString();

                SendUser(username, lName, useremail, phoneNum, userN, userpassword);


            }
        });

        //This button switches to "Friends" page view
        displayFriends.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), Friends.class);
                startActivity(nextScreen);

            }
        });
        //This button switches to Main Menu
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = name.getText().toString();
                Intent mainMenu = new Intent(getApplicationContext(), MainMenu.class);
                //Transfers received name to MainMenu
                mainMenu.putExtra("name", username);
                startActivity(mainMenu);
            }
        });
    }

    /**
     *
     * @param name
     *      First name of user
     * @param lastName
     *      Last name of user
     * @param email
     *      Email of user
     * @param phoneNum
     *      Phone number of user
     * @param userName
     *      Chosen username
     * @param password
     *      Chosen password (all digits)
     */
    private void SendUser(String name, String lastName, String email, String
            phoneNum, String userName, String password)
    {
        //Map<String, String> params = new HashMap<>();
        JSONObject params = new JSONObject();
        try {
            params.put("firstName", name);
            params.put("lastName", lastName);
            params.put("userName", userName);
            params.put("password", password);
            params.put("address", email);
            params.put("telephone", phoneNum);

        }
        catch (JSONException e) { e.printStackTrace(); }
        //Use singleton class to use RequestQueue
        queue = AppController.getInstance().getRequestQueue();
        request = new JsonObjectRequest(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                Log.d("JSONPost", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                VolleyLog.d("JSONPost", "Error: "+error.toString());
            }
        });
        queue.add(request);
    }
}