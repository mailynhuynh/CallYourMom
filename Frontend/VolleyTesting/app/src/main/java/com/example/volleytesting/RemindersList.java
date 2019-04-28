package com.example.volleytesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import app.AppController;
import reminderUtil.Reminder;
import reminderUtil.ReminderGet;

public class RemindersList extends AppCompatActivity {

    private RequestQueue rq;
    private String url = "http://cs309-bs-3.misc.iastate.edu:8080/reminders";
    private TextView reminderText;
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders_list);
        reminderText = findViewById(R.id.reminderTxt);
        b = findViewById(R.id.mostRecent);
        rq = AppController.getInstance().getRequestQueue();
        listReminders();
        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                getClosestReminder();


            }
        });




    }
    public void listReminders() {
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                JSONObject rem;
                for(int i = 0; i < response.length(); i++){
                    try {
                        rem = response.getJSONObject(i);
                        Reminder reminder = new Reminder();
                        reminder.setTitle(rem.getString("title"));
                        reminder.setLocation(rem.getString("location"));
                        dateTimeSet(reminder, rem.getString("time"));
                        reminderText.append(reminder.toString()+"\n\n");

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
    public void getClosestReminder(){
        JsonObjectRequest jOR = new JsonObjectRequest(Request.Method.GET, url+"/mostRecent", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Reminder r = new Reminder();
                    r.setTitle(response.getString("title"));
                    r.setLocation(response.getString("location"));
                    dateTimeSet(r, response.getString("time"));
                    reminderText.setText(r.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        rq.add(jOR);
    }

    public void dateTimeSet(Reminder reminder, String dateTime){
        String[] timeAndDate = dateTime.split(" ");
        String[] date = timeAndDate[0].split("/");
        reminder.setMonth(Integer.parseInt(date[0]));
        reminder.setDay(Integer.parseInt(date[1]));
        reminder.setYear(Integer.parseInt(date[2]));
        String[] time = timeAndDate[1].split(":");
        reminder.setHour(Integer.parseInt(time[0]));
        reminder.setMinute(Integer.parseInt(time[1]));

    }

}
