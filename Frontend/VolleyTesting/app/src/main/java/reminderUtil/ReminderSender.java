package reminderUtil;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import app.AppController;

public class ReminderSender {
    /**
     * RequestQueue to send
     */
    RequestQueue queue;
    /**
     * Object request.
     */
    JsonObjectRequest request;
    /**
     * Reminder to send
     */
    private Reminder reminder;
    /**
     * Url to send Reminder to
     */
    private String url;

    /**
     *
     * @param reminder
     *      Reminder to be sent
     * @param url
     *      Url to use.
     */
    public ReminderSender(Reminder reminder, String url){
        this.reminder = reminder;
        this.url = url;
    }

    /**
     *
     * @param context
     *      Application context to use.
     */
    public void sendReminder(final Context context){
        JSONObject params = new JSONObject();
        try {
            params.put("title",reminder.getTitle());
            params.put("time", reminder.getDateTime());
            params.put("location", reminder.getLocation());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        queue = AppController.getInstance().getRequestQueue();
        request = new JsonObjectRequest(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show();
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
