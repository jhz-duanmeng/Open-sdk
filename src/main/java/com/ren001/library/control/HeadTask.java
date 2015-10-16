package com.ren001.library.control;


import android.content.Context;
import android.content.Intent;

import org.json.JSONException;
import org.json.JSONObject;

public class HeadTask extends Task {

    private static HeadTask mInstance;

    private HeadTask(Context context) {
        super(context);
    }

    public static HeadTask getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new HeadTask(context);
        }
        return mInstance;
    }

    public void moveLeft() {
        executeTask("left", null);
    }

    public void moveLeft(int speed) {
        executeTask("left", String.valueOf(speed));
    }

    public void moveRight() {
        executeTask("right", null);
    }

    public void moveRight(int speed) {
        executeTask("right", String.valueOf(speed));
    }

    public void moveToByAngle(int angle) {
        executePositionTask(angle, null);
    }
    public void moveToByAngle(int angle, int speed) {
        executePositionTask(angle, String.valueOf(speed));
    }
    public void stop() {
        executeTask("stop", null);
    }
    public void query() {
        executeTask("query", null);
    }

    private void executeTask(String direction, String speed) {
        try {
            JSONObject headJson = new JSONObject();
            headJson.put("direction", direction);
            if (speed != null)
                headJson.put("speed", speed);
            JSONObject mJSONObject = new JSONObject();
            mJSONObject.put("head", headJson);
            Intent intent = createIntent(RobotReceiverAction.ROBOT_CONTROL_ACTION);
            intent.putExtra(RobotReceiverAction.NAME_ROBOT_CONTROL, mJSONObject.toString());
            sendTask(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void executePositionTask(int angle,  String speed) {
        try {
            JSONObject headJson = new JSONObject();
            headJson.put("direction", "move");
            headJson.put("angle", angle);
            if (speed != null)
                headJson.put("speed", speed);
            JSONObject mJSONObject = new JSONObject();
            mJSONObject.put("head", headJson);
            Intent intent = createIntent(RobotReceiverAction.ROBOT_CONTROL_ACTION);
            intent.putExtra(RobotReceiverAction.NAME_ROBOT_CONTROL, mJSONObject.toString());
            sendTask(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
