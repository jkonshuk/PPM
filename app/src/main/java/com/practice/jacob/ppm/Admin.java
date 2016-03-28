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


public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void goBack (View v){
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //we will also do nothing
        }
        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();

        ActivityManager activityManager = (ActivityManager) getApplicationContext()
                .getSystemService(Context.ACTIVITY_SERVICE);

        activityManager.moveTaskToFront(getTaskId(), 0);
    }

    public void onClick(View v) {
        EditText passwordField = (EditText) (findViewById(R.id.password));
        TextView text = (TextView) (findViewById(R.id.textView));
        numAvailable--;
        String adminPassword = "PPMexit";

        //If they have failed 3 times do nothing
        if (numAvailable <= 0) {
            text.setText ("Number of tries exceeded.. Please try again later..");
        }
        //Password logic which currently takes us back to videoSelect
        else if(passwordField.getText().toString().equals(adminPassword)) {
            startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
        } else {
            //wrong password, change text to red
            passwordField.setText("");
            text.setText("Incorrect password please try again: Number of tries Available " + numAvailable);
            text.setTextColor(0xFFFC0101);
        }
    }

    private int numAvailable = 3;
}
