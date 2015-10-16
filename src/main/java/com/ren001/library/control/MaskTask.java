package com.ren001.library.control;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class MaskTask extends Task{

    private static MaskTask mInstance;

    private MaskChangeListener mMaskChangeListener;

    protected MaskTask(Context context) {
        super(context);
    }
    public static MaskTask getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MaskTask(context);
        }
        return mInstance;
    }

    public void registerMaskChangeListener(MaskChangeListener mMaskChangeListener) {
        this.mMaskChangeListener = mMaskChangeListener;
        IntentFilter filter = new IntentFilter();
        filter.addAction(RobotReceiverAction.ROBOT_MASK_ACTION);
        mContext.registerReceiver(mReceiver, filter);
    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {
//            boolean isOpen = intent.getBooleanExtra(RobotReceiverAction.NAME_MASK_STATE, false);
//            if(mMaskChangeListener != null) mMaskChangeListener.onMaskChange(isOpen ? MaskChangeListener.MASK_STATE_OPEN : MaskChangeListener.MASK_STATE_CLOSE);
        }
    };

    public void unRegisterMaskChangeListener() {
        mMaskChangeListener = null;
        mContext.unregisterReceiver(mReceiver);
    }

    public interface MaskChangeListener {
        int MASK_STATE_OPEN = 0;
        int MASK_STATE_CLOSE = 1;

        void onMaskChange(int maskState);
    }

}
