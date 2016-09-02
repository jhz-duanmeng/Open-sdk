package com.efrobot.library.sdk;

import android.content.Context;

/**
 * Created by 鑫宇 on 2016/9/2.
 */
public class RobotManager {
    private Context mContext;
    /**
     * 获取机器人管理实例 单例对象
     */
    private volatile static RobotManager mInstance;
    /**
     * 机器人状态对象
     */
    private RobotStatus mRobotState;

    /**
     *  init 结果
     */
    public enum ResultCode {

    }



    private RobotManager(Context mContext) {
        this.mContext = mContext.getApplicationContext();
        mRobotState = RobotStatus.getInstance(this.mContext);
    }
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
    /**
     * 		初始化SDK
     * 	    @param accessKey
     * 		@param accessSecret 初始化完成回调
     * 	    @param appKey
     * 		@param onInitCompleteListener 初始化完成回调
     */
    public void init(String accessKey, String accessSecret,String appKey, OnInitCompleteListener onInitCompleteListener){}


    /**
     *		初始化完成回调
     */
    public interface OnInitCompleteListener {
        void onInitComplete(ResultCode resultCode);
    }
    public RobotStatus.ProjectStatus getProjectorStatus() {
        return RobotStatus.ProjectStatus.CLOSE;
    }


    /**
     * 	    注册投影仪状态变化监听
     *      @param listener 投影仪状态变化监听
     */
    public void registerProjectorStatusChangedListener(OnProjectStatusChangedListener listener) {}


    /**
     * 		取消注册投影仪状态变化监听
     * 		@param listener 投影仪状态变化监听
     */
    public void unRegisterProjectorStatusChangedListener(OnProjectStatusChangedListener listener) {}


    /**
     *	投影仪状态回调
     */
    public interface OnProjectStatusChangedListener {
        void onProjectStatusChanged(RobotStatus.ProjectStatus projectStatus);
    }

    /**
     * 	注册机器人电量变化监听
     * 	@param listener 电池电量变化监听
     */
    public void registerBatteryLevelChangedListener(OnBatteryLevelChangedListener listener){}

    /**
     * 	取消注册机器人电量变化监听
     * 	@param listener 电池电量变化监听
     */
    public void unRegisterBatteryLevelChangedListener(OnBatteryLevelChangedListener listener) {}

    /**
     *	电量状态变化监听
     */
    public interface OnBatteryLevelChangedListener {
        void onBatteryLevelChanged(int batteryLevel);
    }
    /**
     * 获取电池状态
     * @return BatteryStatus 电池状态
     */
    public RobotStatus.BatteryStatus getBatteryStatus() {
        return RobotStatus.BatteryStatus.CHARGINGING;
    }

    /**
     *	电池状态变化监听
     */
    public interface OnBatteryStatusChangedListener {
        void onBatteryStatusChanged(RobotStatus.BatteryStatus batteryStatus);
    }


    /**
     * 		注册机器人电池状态变化监听
     * 		@param listener 电池状态变化监听
     */
    public void registerBatteryStatusChangeListener(OnBatteryStatusChangedListener listener) {}
    /**
     * 		取消注册机器人电池状态变化监听
     * 		@param listener 电池状态变化监听
     */
    public void unRegisterBatteryStatusChangeListener(OnBatteryStatusChangedListener listener) {}

    /**
     * 		获取头顶触摸状态
     *
     * 		@return HeadTouchStatus 头顶触摸状态
     */
    public RobotStatus.HeadTouchStatus getHeadTouchStatus() {
        return RobotStatus.HeadTouchStatus.UNKNOWN;
    }
    /**
     * 		注册头顶触摸状态变化监听
     * 		@param listener 头顶触摸状态变化监听
     */
    public void registerOnHeadTouchStatusChangedListener(OnHeadTouchStatusChangedListener listener) {}
    /**
     * 		取消注册头顶触摸状态变化监听
     * 		@param listener 头顶触摸状态变化监听
     */
    public void unOnHeadTouchStatusChangedListener(OnHeadTouchStatusChangedListener listener) {}


    /**
     *	头顶触摸状态变化监听
     */
    public interface OnHeadTouchStatusChangedListener {
        void onHeadTouchStatusChanged(RobotStatus.HeadTouchStatus headTouchStatus);
    }
    /**
     *	净化器状态变化监听
     */
    public interface OnPurifierStatusChangedListener {
        void onPurifierStatusChanged(RobotStatus.PurifierStatus purifierStatus);
    }


    /**
     * 		获取机器人净化器状态
     * 		@return 净化器状态，未获取到返回- 10000
     */
    public RobotStatus.PurifierStatus getPurifierStatus() {
        return RobotStatus.PurifierStatus.UNKNOWN;
    }
    /**
     * 		注册净化器状态变化监听
     * 		@param listener 净化器状态变化监听
     */
    public void registerPurifierStatusChangedListener(OnPurifierStatusChangedListener listener) {}


    /**
     * 		取消注册净化器状态变化监听
     * 		@param listener 净化器状态变化监听
     */
    public void unRegisterPurifierStatusChangedListener(OnPurifierStatusChangedListener listener) {}
    /**
     * 		获取机器人面罩的开关状态
     * 		@return MaskStatus 面罩状态
     */
    public RobotStatus.MaskStatus getMaskStatus() {
        return RobotStatus.MaskStatus.UNKNOWN;
    }



    /**
     *	面罩状态变化监听
     */
    public interface OnMaskStatusChangedListener {
        void onMaskStatusChanged(RobotStatus.MaskStatus maskStatus);
    }

    /**
     * 		注册面罩状态变化监听
     * 		@param listener 面罩状态变化监听
     */
    public void registerMaskStatusChangedListener(OnMaskStatusChangedListener listener) {}

    /**
     * 		取消注册面罩状态变化监听
     * 		@param listener 面罩状态变化监听
     */
    public void unRegisterMaskStatusChangedListener(OnMaskStatusChangedListener listener) {}
    /**
     *	托盘状态变化监听
     */
    public interface OnSalverStatusChangedListener {
        void onSalverStatusChanged(RobotStatus.SalverStatus salverStatus);
    }

    /**
     * 		获取机器人托盘的状态
     * 		@return SalverStatus 托盘状态
     */
    public RobotStatus.SalverStatus getSalverStatus() {
        return RobotStatus.SalverStatus.UNKNOWN;
    }
    /**
     * 		注册托盘状态变化监听
     * 		@param listener 托盘状态变化监听
     */
    public void registerSalverStatusChangedListener(OnSalverStatusChangedListener listener) {}
    /**
     * 		取消注册托盘状态变化监听
     * 		@param listener 托盘状态变化监听
     */
    public void unRegisterSalverStatusChangedListener(OnSalverStatusChangedListener listener) {}






}
