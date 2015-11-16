package com.ren001.library.control;

import android.content.Context;
import android.content.Intent;

/**
 * 跳舞任务
 */
public class GroupTask extends Task {

    protected GroupTask(Context context){
            super(context);
    }

    private static GroupTask mInstance;

    public static GroupTask getInstance(Context context) {
        if(mInstance == null) {
            mInstance = new GroupTask(context);
        }
        return mInstance;
    }

    public void excute(String tasksContent){
        Intent intent = createIntent(RobotReceiverAction.DANCE_GROUP_TASK);
        intent.putExtra(RobotReceiverAction.NAME_GROUP_TASK_ORDER, 0);
        intent.putExtra(RobotReceiverAction.NAME_GROUP_TASK, tasksContent);
        sendTask(intent);
    }

    public void stop() {
        Intent intent = createIntent(RobotReceiverAction.DANCE_GROUP_TASK);
        intent.putExtra(RobotReceiverAction.NAME_GROUP_TASK_ORDER, -1);
        sendTask(intent);
    }
}
