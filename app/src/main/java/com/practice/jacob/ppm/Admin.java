package com.practice.jacob.ppm;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

import java.lang.reflect.Method;


public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        correctPass = false;
    }

    /**
     * Lock down recent apps button
     */
    @Override
    protected void onPause() {
        super.onPause();

        if (correctPass == false) {
            ActivityManager activityManager = (ActivityManager) getApplicationContext()
                    .getSystemService(Context.ACTIVITY_SERVICE);

            activityManager.moveTaskToFront(getTaskId(), 0);
        }
    }

    /**
     * initializes password, text view, and edit text. We will keep track of number of times
     * password was entered. If number of times is exceeded admin will lock. otherwise it will
     * launch settings menu.
     * @param v
     */
    public void onClick(View v) {
        EditText passwordField = (EditText) (findViewById(R.id.password));
        TextView text = (TextView) (findViewById(R.id.textView));
        numAvailable--;
        String adminPassword = "PPMexit";

        //If they have failed 3 times do nothing
        if (numAvailable < 0) {
            text.setText ("Number of tries exceeded please try again later..");
        }
        //Password logic which currently takes us back to videoSelect
        else if(passwordField.getText().toString().equals(adminPassword)) {
            startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
            correctPass = true;
            numAvailable = 3;
        } else {
            //wrong password, change text to red
            passwordField.setText("");
            text.setText("Incorrect password please try again: ");
            if(numAvailable == 1)
                Toast.makeText(getApplicationContext(), numAvailable + " try available."
                        , Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), numAvailable + " tries available."
                        , Toast.LENGTH_LONG).show();
            text.setTextColor(0xFFFC0101);
        }
    }

    private int numAvailable = 4;
    private boolean correctPass;

}
