package com.ren001.library.control;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 机器人动作基类
 */
public class Task {

    private final static String TAG = "Task";
    private final static boolean isDebug = true;

    protected Context mContext;
    protected String packageName;

    protected Task(Context context) {
        mContext = context;
        packageName = mContext.getPackageName();
    }

    protected void sendTask(Intent mIntent) {
        mContext.sendBroadcast(mIntent, "android.permission.RECEIVER_ROBOT");
    }

    protected Intent createIntent(String action){
        Intent intent = new Intent(action);
        return intent.putExtra(RobotReceiverAction.NAME_PACK_NAME, mContext.getPackageName());
    }
}
