package com.ren001.library.control;


import android.content.Context;
import android.content.Intent;

import org.json.JSONException;
import org.json.JSONObject;

public class LightBeltTask extends Task{

    private static LightBeltTask mInstance;
    private LightBeltTask(Context context) {
        super(context);
    }

    public static LightBeltTask getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new LightBeltTask(context);
        }
        return mInstance;
    }

    public void twinkle() {
        Intent intent = createIntent(RobotReceiverAction.LIGHT_BELT_ACTION);
        intent.putExtra(RobotReceiverAction.NAME_LIGHT_BELT_ORDER, true);
        sendTask(intent);
    }

    public void stop() {
        Intent intent = createIntent(RobotReceiverAction.LIGHT_BELT_ACTION);
        intent.putExtra(RobotReceiverAction.NAME_LIGHT_BELT_ORDER, false);
        sendTask(intent);
    }
}
