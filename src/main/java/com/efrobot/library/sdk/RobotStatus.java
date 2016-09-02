package com.efrobot.library.sdk;


import android.content.Context;

public class RobotStatus {
    private volatile static RobotStatus instance;

    private RobotStatus(Context mContext) {

    }

    public static RobotStatus getInstance(Context mContext) {
        if (instance == null) {
            synchronized (RobotStatus.class) {
                if (instance == null) {
                    instance = new RobotStatus(mContext.getApplicationContext());
                }
            }
        }
        return instance;
    }
    /**
     *  投影仪状态
     */
    public enum ProjectStatus {
        /** 关闭状态 */
        CLOSE,
        /** 打开状态 */
        OPEN,
        /** 未知状态 */
        UNKNOWN,
    }



    /**
     *  电池状态
     */
    public enum BatteryStatus {
        /** 未充电 */
        NOT_CHARGING,
        /** 充电中 */
        CHARGINGING,
        /** 未知状态 */
        UNKNOWN,
    }


    /**
     *  头部触摸状态
     */
    public enum HeadTouchStatus {
        /** 触摸中 */
        TOUCH_ON,
        /** 未触摸 */
        TOUCH_OFF,
        /** 未知状态 */
        UNKNOWN,
    }



    /**
     * 净化器状态
     */
    public enum PurifierStatus {
        OPEN,
        CLOSE,
        INEXISTENCE,
        FILTER_GAUZE_INEXISTENCE,
        UNKNOWN,
    }


    /**
     *  面罩状态
     */
    public enum MaskStatus {
        /** 关闭 */
        CLOSED,
        /** 中间 */
        FLOAT,
        /** 打开 */
        OPENED,
        /** 未知状态 */
        UNKNOWN,
    }


    /**
     * 托盘状态变化监听
     */
    public enum SalverStatus {
        /** 关闭 */
        CLOSED,
        /** 打开 */
        OPENED,
        /** 未知状态 */
        UNKNOWN,
    }

}
