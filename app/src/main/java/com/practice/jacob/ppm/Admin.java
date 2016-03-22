package com.practice.jacob.ppm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
            text.setText("Incorrect password please try again: Number of tries Available " + numAvailable);
            text.setTextColor(0xFFFC0101);
        }
    }

    private String adminPassword = "PPMexit";
    private int numAvailable;
}
