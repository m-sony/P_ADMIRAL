package com.exemple.mysecondapplication.network;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import static android.R.attr.value;


public class MyIntentService extends IntentService {


    public static final String SERVICE_PAYLOAD = "SERVICE_PAYLOAD";
    public static final String SERVICE_MESSAGE = "SERVICE_MESSAGE";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        sendMessageToUI("dummy data");

    }

    private void sendMessageToUI(String data) {

        Intent intent = new Intent(SERVICE_MESSAGE);
        intent.putExtra(SERVICE_PAYLOAD, data);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }


}
