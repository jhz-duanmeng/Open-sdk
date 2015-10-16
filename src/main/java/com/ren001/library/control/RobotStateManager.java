package com.ren001.library.control;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;


public class RobotStateManager {

    private static final String TAG = "RobotStateManager";

    private final boolean isDebug = true;

    private RobotStateReceiver mReceiver = new RobotStateReceiver();

    private Context mContext;
    private boolean isInit = false;

    private OnRobotStateChangeListener mListener;

    private static RobotStateManager mInstance = new RobotStateManager();
    private RobotStateManager(){}
    public static RobotStateManager getInstance(){
       return mInstance;
    }

    public void init(Context mContext) {
        if(isInit) {
            log("init is called");
        }else {
            isInit = true;
            this.mContext = mContext;
            IntentFilter filter = new IntentFilter();
            mContext.registerReceiver(mReceiver, filter);
        }
    }

    public void unInit() {
        mContext.unregisterReceiver(mReceiver);
    }

    public void registerOnRobotStateChangeListener(OnRobotStateChangeListener mListener) {
        this.mListener = mListener;
    }

    public void unRegisterOnRobotStateChangeListener(OnRobotStateChangeListener mListener) {
        this.mListener = null;
    }

    private void log(String message) {
        if(isDebug)
            Log.d(TAG, message);
    }
    private class RobotStateReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }

    public class OnRobotStateChangeListener {
        public void onHeadPostionChange(boolean isMove, int position){}
    }
}
