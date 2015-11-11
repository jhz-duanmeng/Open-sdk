package com.ren001.library.control;

import android.content.Context;
import android.content.Intent;

import org.json.JSONException;
import org.json.JSONObject;


public class ProjectorTask extends Task {

    private static ProjectorTask mInstance;

    protected ProjectorTask(Context context) {
        super(context);
    }

    public static ProjectorTask getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ProjectorTask(context);
        }
        return mInstance;
    }

    public void open() {
        try {
            JSONObject mJSONObject = new JSONObject();
            mJSONObject.put("order", "open");
            executeTask(mJSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void close() {
        try {
            JSONObject mJSONObject = new JSONObject();
            mJSONObject.put("order", "close");
            executeTask(mJSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public void changeBrightness(int brightness) {
        try {
            JSONObject mJSONObject = new JSONObject();
            mJSONObject.put("order", "changeBrightness");
            mJSONObject.put("value", brightness);
            executeTask(mJSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void horizontalLeftOverturn() {
        try {
            JSONObject mJSONObject = new JSONObject();
            mJSONObject.put("order", "HorizontalLeftOverturn");
            executeTask(mJSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void horizontalRightOverturn() {
        try {
            JSONObject mJSONObject = new JSONObject();
            mJSONObject.put("order", "HorizontalRightOverturn");
            executeTask(mJSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void verticalUpOverturn() {
        try {
            JSONObject mJSONObject = new JSONObject();
            mJSONObject.put("order", "VerticalUpOverturn");
            executeTask(mJSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void verticalDownOverturn() {
        try {
            JSONObject mJSONObject = new JSONObject();
            mJSONObject.put("order", "VerticalDownOverturn");
            executeTask(mJSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void keystoneCorrection(int angle) {
        try {
            JSONObject mJSONObject = new JSONObject();
            mJSONObject.put("order", "keystoneCorrection");
            mJSONObject.put("value", angle);
            executeTask(mJSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void executeTask(JSONObject mJsonObject) {

        Intent intent = createIntent(RobotReceiverAction.PROJECTOR_MASK_ACTION);
        intent.putExtra(RobotReceiverAction.KEY_PROJECTOR_ORDER, mJsonObject.toString());
        sendTask(intent);
    }
}
