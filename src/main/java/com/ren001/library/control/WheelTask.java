package com.ren001.library.control;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class WheelTask extends Task {


    private final int defaultSpeed = 200;
    private static WheelTask mInstance;

    protected WheelTask(Context context) {
        super(context);
    }

    public static WheelTask getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new WheelTask(context);
        }
        return mInstance;
    }

    public void moveFront() {
        executeTask("front", null);
    }

    public void moveFront(int speed) {
        executeTask("front", String.valueOf(speed));
    }

    public void moveBack() {
        executeTask("back", null);
    }

    public void moveBack(int speed) {
        executeTask("back",  String.valueOf(speed));
    }

    public void moveLeft() {
        executeTask("left", null);
    }

    public void moveLeft(int speed) {
        executeTask("left",  String.valueOf(speed));
    }

    public void moveRight() {
        executeTask("right", null);
    }

    public void moveRight(int speed) {
        executeTask("right", String.valueOf(speed));
    }

    public void stop() {
        executeTask("stop", null);
    }


    public void moveToLeftByAngle(int angle) {
        executeAngleTask("left_angle", null, angle);
    }
    public void moveToLeftByAngle(int speed, int angle) {
        executeAngleTask("left_angle", String.valueOf(speed), angle);
    }
    public void moveToRightByAngle(int angle) {
        executeAngleTask("right_angle", null, angle);
    }
    public void moveToRightByAngle(int speed, int angle) {
        executeAngleTask("right_angle", String.valueOf(speed), angle);
    }

    public void moveToFrontByDistance(int distance) {
        executeDistanceTask("front_distance", null, distance);
    }

    public void moveToFrontByDistance(int distance, int speed) {
        executeDistanceTask("front_distance", null, distance);
    }

    public void moveToBackByDistance(int distance) {
        executeDistanceTask("back_distance", null, distance);
    }

    public void moveToBackByDistance(int distance, int speed) {
        executeDistanceTask("back_distance", String.valueOf(speed), distance);
    }


    private void executeDistanceTask(String direction, String speed, int distance) {
        try {
            JSONObject wheelJson = new JSONObject();
            wheelJson.put("direction", direction);
            wheelJson.put("distance", distance);
            if (speed != null)
                wheelJson.put("speed", speed);
            JSONObject mJSONObject = new JSONObject();
            mJSONObject.put("wheel", wheelJson);

            Intent intent = createIntent(RobotReceiverAction.ROBOT_CONTROL_ACTION);
            intent.putExtra(RobotReceiverAction.NAME_ROBOT_CONTROL, mJSONObject.toString());
            sendTask(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void executeAngleTask(String direction, String speed, int angle) {
        try {
            JSONObject wheelJson = new JSONObject();
            wheelJson.put("angle", angle);
            wheelJson.put("direction", direction);
            if (speed != null)
                wheelJson.put("speed", speed);
            JSONObject mJSONObject = new JSONObject();
            mJSONObject.put("wheel", wheelJson);
            Intent intent = createIntent(RobotReceiverAction.ROBOT_CONTROL_ACTION);
            intent.putExtra(RobotReceiverAction.NAME_ROBOT_CONTROL, mJSONObject.toString());
            sendTask(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void executeTask(String direction, String speed) {
        try {
            JSONObject wheelJson = new JSONObject();
            wheelJson.put("direction", direction);
            if (speed != null)
                wheelJson.put("speed", speed);
            JSONObject mJSONObject = new JSONObject();
            mJSONObject.put("wheel", wheelJson);
            Intent intent = createIntent(RobotReceiverAction.ROBOT_CONTROL_ACTION);
            intent.putExtra(RobotReceiverAction.NAME_ROBOT_CONTROL, mJSONObject.toString());
            sendTask(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
