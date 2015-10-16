package com.ren001.library.control;

import android.content.Context;
import android.content.Intent;

/**
 * 跳舞任务
 */
public class DanceTask extends Task {

    protected DanceTask(Context context){
            super(context);
    }

    private static DanceTask mInstance;

    public static DanceTask getInstance(Context context) {
        if(mInstance == null) {
            mInstance = new DanceTask(context);
        }
        return mInstance;
    }

    public void dance(String danceContent){
        Intent intent = createIntent(RobotReceiverAction.DANCE_ACTION);
        intent.putExtra(RobotReceiverAction.NAME_DANCE_ORDER, 0);
        intent.putExtra(RobotReceiverAction.NAME_DANCE, danceContent);
        sendTask(intent);
    }

    public void stop() {
        Intent intent = createIntent(RobotReceiverAction.DANCE_ACTION);
        intent.putExtra(RobotReceiverAction.NAME_DANCE_ORDER, -1);
        sendTask(intent);
    }
}
