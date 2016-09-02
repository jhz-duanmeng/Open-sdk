package com.efrobot.library;

import android.content.Context;

/**
 * Created by 鑫宇 on 2016/9/2.
 */
public class RobotManager {
    /**
     * 获取机器人管理实例 单例对象
     */
    private volatile static RobotManager mInstance;





    private RobotManager(Context mContext) {}
    /**
     * 获取机器人管理实例
     *
     * @return 机器人管理实例
     */
    public static synchronized RobotManager getInstance(Context mContext) {
        if (mInstance == null) {
            synchronized (RobotManager.class) {
                if (mInstance == null) {
                    mInstance = new RobotManager(mContext);
                }
            }
        }
        return mInstance;
    }


}
