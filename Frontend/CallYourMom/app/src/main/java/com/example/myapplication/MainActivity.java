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

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private Button parse;
    private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.txt1);
        parse = findViewById(R.id.parse);
        queue = Volley.newRequestQueue(this);
        parse.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                jsonParse();
            }
        });


    }

    private void jsonParse()
    {
        /*5 arguments!
            1) Request method (GET or POST etc)
            2) URL
            3) jsonRequest??
            4) Response Listener
            5) Error response listener
        */
        String url = "https://api.myjson.com/bins/12g756";
        JsonObjectRequest request = new
                JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
/*                      THIS IS FOR ARRAYS
                        try {
                            //Parse JSON response OBJECT into JSON Array
                            JSONArray jsonArray = response.getJSONArray("name");

                            //Now Parse into JAVA array with a good ol' fashioned for loop
                            String name;
                            for(int i = 0; i < jsonArray.length(); i++)
                            {
                                JSONObject obj = jsonArray.getJSONObject(i);
                                name = obj.getString("name");
                                mTextView.setText(name);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }*/
                        //This is a single object

                        try {

                            String name = response.getString("name");
                            int age = response.getInt("age");
                            String hobby = response.getString("hobby");
                            mTextView.setText(name+" is "+age+" and likes "+hobby);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });

        queue.add(request);


    }
}
