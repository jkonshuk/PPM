package com.practice.jacob.ppm;

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
        numAvailable = 3;
    }

    public void goBack (View v){
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_HOME) {
            //We will do nothing in this case.
        }
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //we will also do nothing
        }
        return false;
    }

    public void onClick(View v) {
        EditText passwordField = (EditText) (findViewById(R.id.password));
        TextView text = (TextView) (findViewById(R.id.textView));
        numAvailable--;
        if (numAvailable <= 0) {
            text.setText ("Number of tries exceeded.. Please try again later..");
        }
        else if(passwordField.getText().toString().equals(adminPassword)) {
            Intent intent = new Intent(getApplicationContext(), VideoSelect.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);
            finish();
        } else {
            passwordField.setText("");
<<<<<<< HEAD
            text.setText("Incorrect password please try again: Number of tries available" + numAvailable);
=======
            text.setText("Incorrect password please try again: Number of tries Available " + numAvailable);
>>>>>>> a0d49554621c9e09318dfc24584fa5f53f36e75c
            text.setTextColor(0xFFFC0101);
        }
    }

    private String adminPassword = "PPMexit";
    private int numAvailable;
}
