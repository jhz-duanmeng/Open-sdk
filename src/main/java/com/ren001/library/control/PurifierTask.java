package com.ren001.library.control;


import android.content.Context;
import android.content.Intent;

import org.json.JSONException;
import org.json.JSONObject;

public class PurifierTask extends Task{

    private static PurifierTask mInstance;
    private PurifierTask(Context context) {
        super(context);
    }

    public static PurifierTask getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new PurifierTask(context);
        }
        return mInstance;
    }

    public void open() {
        executeTask("open");
    }

    public void close() {
        executeTask("close");
    }

    public void query() {
        executeTask("query");
    }

    public void queryRunTime() {
        executeTask("run_time");
    }
   public void resetRunTime() {
        executeTask("reset_run_time");
    }

    public void setFanSpeed(int speed) {
        executeTask("fan_speed", String.valueOf(speed));
    }

    private void executeTask(String direction) {
        executeTask(direction, null);
    }

    private void executeTask(String direction, String speed) {
        try {
            JSONObject purifierJson = new JSONObject();
            purifierJson.put("direction", direction);
            if(speed != null) {
                purifierJson.put("speed", speed);
            }
            JSONObject mJSONObject = new JSONObject();
            mJSONObject.put("purifier", purifierJson);
            Intent intent = createIntent(RobotReceiverAction.ROBOT_CONTROL_ACTION);
            intent.putExtra(RobotReceiverAction.NAME_ROBOT_CONTROL, mJSONObject.toString());
            sendTask(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




}
