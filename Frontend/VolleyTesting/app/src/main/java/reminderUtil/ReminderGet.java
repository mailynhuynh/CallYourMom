package reminderUtil;


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
import org.w3c.dom.Text;

import java.util.ArrayList;

import app.AppController;

public class ReminderGet {
    private TextView v;
    /**
     * Url for request
     */
    private String url;
    /**
     * Request queue for JSON objects.
     */
    private RequestQueue rq = AppController.getInstance().getRequestQueue();

    /**
     * @param url Url of server
     */
    public ReminderGet(String url) {
        this.url = url;
    }
    public void setTextView(TextView v){
        this.v = v;
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
                        v.append(reminder.toString()+"\n");

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

