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

import java.net.URI;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        numAvailable = 3;
    }

    public void goBack (View v){
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //we will also do nothing
        }
        if(keyCode == KeyEvent.KEYCODE_HOME)
        {
            //DO NOTHING
            return true;
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
        if (numAvailable <= 0) {
            text.setText ("Number of tries exceeded.. Please try again later..");
        }
        else if(passwordField.getText().toString().equals(adminPassword)) {
            //Intent intent = new Intent(getApplicationContext(), VideoSelect.class);
            //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //intent.putExtra("EXIT", true);
            //startActivity(intent);
            //finish();
            //startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            //        URI.fromParts("package", getPackageName(), null)));
        } else {
            passwordField.setText("");
            text.setText("Incorrect password please try again: Number of tries Available " + numAvailable);
            text.setTextColor(0xFFFC0101);
        }
    }

    private String adminPassword = "PPMexit";
    private int numAvailable;
}
