package com.ren001.library.control;


import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class WingTask extends Task {


    public final static int MOVE_WING = 0;
    public final static int MOVE_LEFT_WING = 1;
    public final static int MOVE_RIGHT_WING = 2;

    private static WingTask mInstance;

    protected WingTask(Context context) {
        super(context);
    }

    public static WingTask getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new WingTask(context);
        }
        return mInstance;
    }

    public void moveUp(int movePart) {
        executeTask(movePart, "move",180, null);
    }

    public void moveUp(int movePart, int speed) {
        executeTask(movePart, "move",180, String.valueOf(speed));
    }

    public void moveDown(int movePart) {
        executeTask(movePart, "move", 0, null);
    }

    public void moveDown(int movePart, int speed) {
        executeTask(movePart, "move", 0, String.valueOf(speed));
    }

    public void moveToByAngle(int movePart, int angle) {
        executeTask(movePart, "move", angle, null);
    }
    public void moveToByAngle(int movePart, int angle, int speed) {
        executeTask(movePart, "move", angle, String.valueOf(speed));
    }

    public void stop(int movePart) {
        executeTask(movePart, "stop",0,  null);
    }

    public void query() {
        executeTask(MOVE_WING, "query",0,  null);
    }

    private void executeTask(int movePart, String direction, int angle,  String speed) {
        try {
            String moveStr = getMoveStr(movePart);
            if (moveStr == null) {
                Log.e("WingTask", "movePart 参数非法");
            }
            JSONObject wingJson = new JSONObject();
            wingJson.put("direction", direction);
            if(!"stop".equals(direction) || !"query".equals(direction)) {
                if(speed != null)
                    wingJson.put("speed", speed);
                wingJson.put("angle", angle);
            }

            JSONObject mJSONObject = new JSONObject();
            mJSONObject.put(moveStr, wingJson);
            Intent intent = createIntent(RobotReceiverAction.ROBOT_CONTROL_ACTION);
            intent.putExtra(RobotReceiverAction.NAME_ROBOT_CONTROL, mJSONObject.toString());
            sendTask(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String getMoveStr(int movePart) {
        switch (movePart) {
            case MOVE_WING:
                return "wing";
            case MOVE_LEFT_WING:
                return "left_wing";
            case MOVE_RIGHT_WING:
                return "right_wing";
        }
        return null;
    }
}
