package com.practice.jacob.ppm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * StartMyServiceAtBootReciever waits for the flags from AndroidManifest
 * saying that the phone is on. Once called it will start up the app.
 */
public class StartMyServiceAtBootReceiver extends BroadcastReceiver {

    /**
     * onRecieve is called when the phone starts up. The code for that
     * is in the androidManifest.xml. It will created an Intent and
     * start the main activity VideoSelect
     * @param context New context
     * @param intent New intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent myIntent = new Intent(context, VideoSelect.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(myIntent);
    }
}
