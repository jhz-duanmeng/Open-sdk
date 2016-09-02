package com.efrobot.library;



public class RobotStatus {


    /**
     *  init 结果
     */
    public enum ResultCode {

    }

    /**
     * 		初始化SDK
     * 	    @param accessKey
     * 		@param accessSecret 初始化完成回调
     * 		@param onInitCompleteListener 初始化完成回调
     */
    public void init(String accessKey, String accessSecret, OnInitCompleteListener onInitCompleteListener){}


    /**
     *		初始化完成回调
     */
    public interface OnInitCompleteListener {
        void onInitComplete(ResultCode resultCode);
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

    public ProjectStatus getProjectorStatus() {
        return ProjectStatus.CLOSE;
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
        void onProjectStatusChanged(ProjectStatus projectStatus);
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
     * 获取电池状态
     * @return BatteryStatus 电池状态
     */
    public BatteryStatus getBatteryStatus() {
        return BatteryStatus.CHARGINGING;
    }

    /**
     *	电池状态变化监听
     */
    public interface OnBatteryStatusChangedListener {
        void onBatteryStatusChanged(BatteryStatus batteryStatus);
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
     * 		获取头顶触摸状态
     *
     * 		@return HeadTouchStatus 头顶触摸状态
     */
    public HeadTouchStatus getHeadTouchStatus() {
        return HeadTouchStatus.UNKNOWN;
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
        void onHeadTouchStatusChanged(HeadTouchStatus headTouchStatus);
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
     *	净化器状态变化监听
     */
    public interface OnPurifierStatusChangedListener {
        void onPurifierStatusChanged(PurifierStatus purifierStatus);
    }


    /**
     * 		获取机器人净化器状态
     * 		@return 净化器状态，未获取到返回- 10000
     */
    public PurifierStatus getPurifierStatus() {
        return PurifierStatus.UNKNOWN;
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
     * 		获取机器人面罩的开关状态
     * 		@return MaskStatus 面罩状态
     */
    public MaskStatus getMaskStatus() {
        return MaskStatus.UNKNOWN;
    }



    /**
     *	面罩状态变化监听
     */
    public interface OnMaskStatusChangedListener {
        void onMaskStatusChanged(MaskStatus maskStatus);
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


    /**
     *	托盘状态变化监听
     */
    public interface OnSalverStatusChangedListener {
        void onSalverStatusChanged(SalverStatus salverStatus);
    }

    /**
     * 		获取机器人托盘的状态
     * 		@return SalverStatus 托盘状态
     */
    public SalverStatus getSalverStatus() {
        return SalverStatus.UNKNOWN;
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
