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

public class Login extends AppCompatActivity {

    /**
     * This was taken from
     * https://www.mytrendin.com/send-data-to-remote-server-in-android-using-volley-library/
     */
    EditText name, email, password, lastName, phoneNumber, userName;
    Button save, displayFriends;
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

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = name.getText().toString();
                final String useremail = email.getText().toString();
                final String userpassword = password.getText().toString();
                final String lName = lastName.getText().toString();
                final String phoneNum = phoneNumber.getText().toString();
                final String userN = userName.getText().toString();

                SendUser(username, lName, useremail, phoneNum, userN, userpassword);


            }
        });

        displayFriends.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), Friends.class);
                startActivity(nextScreen);

            }
        });
    }

    private void SendUser(String name, String lastName, String email, String
            phoneNum, String userName, String password)
    {
        //Map<String, String> params = new HashMap<>();
        JSONObject params = new JSONObject();
        try {
            params.put("firstName", name);
<<<<<<< HEAD:Frontend/VolleyTesting/app/src/main/java/com/example/volleytesting/Login.java
            params.put("lastName", lastName);
            params.put("userName", userName);
            params.put("password", password);
            params.put("address", email);
            params.put("telephone", phoneNum);
=======
            params.put("lastName", password);
            params.put("userName", email);
<<<<<<< HEAD
            params.put("password", "123456");
=======
            params.put("password", 13322);
>>>>>>> 0db396238f52408d9901d3627c6d1b5dee52efec
            params.put("address", "uwbviugbw");
            params.put("telephone", "5155050743");
>>>>>>> fc950d332a51b566957b478152b25e967a1e1cb1:Frontend/VolleyTesting/app/src/main/java/com/example/volleytesting/MainActivity.java
        }
        catch (JSONException e) { e.printStackTrace(); }

        queue = Volley.newRequestQueue(Login.this);
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