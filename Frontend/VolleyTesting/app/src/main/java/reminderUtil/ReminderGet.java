package reminderUtil;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import app.AppController;

public class ReminderGet {
    /**
     * Url for request
     */
    private String url;
    /**
     * Request queue for JSON objects.
     */
    private RequestQueue rq;

    /**
     * @param url Url of server
     */
    public ReminderGet(String url) {
        this.url = url;
        rq = AppController.getInstance().getRequestQueue();
    }

    public ArrayList<String> listReminders() {
        final ArrayList<String> reminders = new ArrayList<>();
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++){
                    try {
                        JSONObject rem = response.getJSONObject(i);
                        reminders.add(JSONtoReminder(rem).toString());

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



        return reminders;
    }

    public Reminder JSONtoReminder(JSONObject obj){
        Reminder reminder = new Reminder();
        try {
            reminder.setTitle(obj.getString("title"));
            reminder.setLocation(obj.getString("location"));
            dateTimeSet(reminder, obj.getString("time"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return reminder;

    }

    private void dateTimeSet(Reminder reminder, String dateTime){
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

