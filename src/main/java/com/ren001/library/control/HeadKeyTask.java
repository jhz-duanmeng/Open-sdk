package com.ren001.library.control;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by Administrator on 2015/9/1.
 */
public class HeadKeyTask extends Task{

    private static HeadKeyTask mInstance;
    private HeadKeyListener mHeadKeyListener;

    protected HeadKeyTask(Context context) {
        super(context);
    }
    public static HeadKeyTask getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new HeadKeyTask(context);
        }
        return mInstance;
    }

    public void registerMaskChangeListener(HeadKeyListener mHeadKeyListener) {
        this.mHeadKeyListener = mHeadKeyListener;
        IntentFilter filter = new IntentFilter();
        filter.addAction(RobotReceiverAction.ROBOT_MASK_ACTION);
        mContext.registerReceiver(mReceiver, filter);
    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    };

    public void unRegisterMaskChangeListener() {
        mContext.unregisterReceiver(mReceiver);
    }

    public interface HeadKeyListener {
        int HeadKey_OPEN = 0;
        int HeadKey_CLOSE = 1;

        void onHeadKey(int maskState);
    }

}
