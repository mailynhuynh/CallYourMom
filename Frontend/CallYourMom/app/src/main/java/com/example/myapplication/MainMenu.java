package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainMenu extends AppCompatActivity
    Button b1, b2;

    @Override
    protectected void onCreate(Bundle savedInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.MainMenu);

        b1 = (Button) findViewById(R.id.buttonMessage);
        b2 = (Button) findViewById(R.id.buttonNext);

        b1.setOnClickListener(new View.onClickListerer()){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Hello ComS309", Toast.LENGTH_LONG).show();



            }



    }
}
