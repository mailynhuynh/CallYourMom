package com.example.volleytesting;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;

import reminderUtil.Reminder;
import reminderUtil.ReminderReceiver;
import reminderUtil.ReminderSender;
import validation.ValidateReminder;

/**
 * @author ZoeS
 */
public class ReminderCreator extends AppCompatActivity {

    private String uri = "ws://cs309-bs-3.misc.iastate.edu:8080/websocket/", user;
    private String url = "http://cs309-bs-3.misc.iastate.edu:8080/reminders";
    private Reminder reminder;

    private static String[] SPINNER_LIST = {"AM","PM"};

    private EditText title, date, time, location, username;
    private Button create, sendToUser;
    private Spinner amOrPm;
    private WebSocketClient webSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_creator);
        username = findViewById(R.id.userName);
        user = getIntent().getExtras().getString("name");
        uri += user;
        /*
        try {
            webSocketConnect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        */
        initFields();
        createPress();
        /*
        sendToUser = findViewById(R.id.tag);
        sendToUser.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                pressSendToUser();
            }
        });
         **/

    }


    /**
     * Method to connect the websocket
     * @throws URISyntaxException
     */
    private void webSocketConnect() throws URISyntaxException {

        final Context context = getApplicationContext();
        Draft[] drafts = {new Draft_6455()};
        try {
            webSocket = new WebSocketClient(new URI(uri), drafts[0]) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    Log.d("OPEN", "run() returned: " + "is connecting");
                }

                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onMessage(String s) {
                    Log.d("", "run() returned: " + s);
                    Reminder reminder  = ReminderReceiver.stringToReminder(s);
                    reminder.setReminder(context);

                }

                @Override
                public void onClose(int i, String s, boolean b) {
                    Log.d("CLOSE", "onClose() returned: " + s);

                }

                @Override
                public void onError(Exception e) {
                    Log.d("Exception:", e.toString());

                }
            };
        }
        catch (URISyntaxException u){
            Log.d("Exception", u.getMessage());
            u.printStackTrace();
        }
        webSocket.connect();


    }

    /**
     * Sends reminder in form of reminder-format-string to user. Called in onClick for tag button.
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void pressSendToUser(){
            validateAndCreateReminder();
            webSocket.send(ReminderReceiver.reminderToUser(username.getText().toString(), reminder));


    }

    /**
     * Initializes the set create alarm button and sets its onClick behavior.
     */
    private void createPress()
    {
        create.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                validateAndCreateReminder();

            }
        });
    }

    /**
     * Validates the input data and calls createReminder
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void validateAndCreateReminder(){
        String enteredDate= date.getText().toString();
        String enteredTime = time.getText().toString();

        if(!ValidateReminder.validateDate("/", enteredDate)) {
            easyToast("Please enter a valid date");
            date.setText("");
            return;
        }
        if(!ValidateReminder.validateTime(enteredTime)) {
            easyToast("Please enter a valid time.");
            time.setText("");
            return;
        }

        String enteredTitle = title.getText().toString();
        String enteredLocation = location.getText().toString();
        boolean isAM = amOrPm.getSelectedItem().toString().equals("AM");

        createReminder(enteredDate, enteredTime, enteredTitle, enteredLocation, isAM);
    }

    /**
     * Creates reminder given by entered data.
     * @param date
     * @param time
     * @param title
     * @param location
     * @param isAM
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void createReminder(String date, String time, String title, String location, boolean isAM)
    {
        int[] dateInts = stringParseInt(date, "/");
        int[] timeInts = stringParseInt(time,":");

        reminder = new Reminder();
        reminder.setMonth(dateInts[0]);
        reminder.setDay(dateInts[1]);
        reminder.setYear(dateInts[2]);
        int theHour = hourTo24(timeInts[0], isAM);

        reminder.setHour(theHour);
        reminder.setMinute(timeInts[1]);

        reminder.setTitle(title);
        reminder.setLocation(location);

        reminder.setReminder(this);
        ReminderSender rSender = new ReminderSender(reminder, url);
        rSender.sendReminder(this);

        easyToast("Alarm created");

    }

    /**
     * Converts from 12-hour time to 24 hour
     *
     * @param hour
     * @param isAM
     *
     * @return
     *      Hour in 24hour form.
     */
    private int hourTo24(int hour, boolean isAM){
        if(hour == 12 && isAM) {
            return 0;
        }
        if(!isAM && hour != 12) {
            return hour + 12;
        }
        return hour;

    }
    /**
     * Helper method to parse a string into an array of ints based off of a regex.
     *
     * @param s
     *      String to use
     * @param regex
     *      Regex to use
     * @return
     *      Integer array.
     */
    private int[] stringParseInt(String s, String regex)
    {
        String[] sArr = s.split(regex);
        int[] intArray = new int[sArr.length];
        for(int i = 0; i < sArr.length; i++)
        {
            try {
                intArray[i] = Integer.parseInt(sArr[i]);
            }
            catch (Exception e)
            {
                return null;
            }
        }
        return intArray;

    }

    /**
     * Custom and faster call to makeToast.
     *
     * @param s
     *      Message to be displayed in toast.
     */
    private void easyToast(String s){
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }

    /**
     * Initializes the AM-PM dropdown menu
     */
    private void initDropDown()
    {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNER_LIST);

        amOrPm = findViewById(R.id.AmOrPm);
        amOrPm.setAdapter(arrayAdapter);
    }

    /**
     * Initializes the layout components
     */
    private void initFields() {
        title = findViewById(R.id.rTitle);
        date = findViewById(R.id.rDate);
        time = findViewById(R.id.rTime);
        location = findViewById(R.id.rLocation);
        create = findViewById(R.id.createReminder);

        initDropDown();
    }
}
