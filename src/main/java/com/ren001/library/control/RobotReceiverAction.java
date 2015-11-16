package com.ren001.library.control;

/**
 * 机器人端广播汇总
 */
public class RobotReceiverAction {


    public final static String NAME_PACK_NAME = "packName";


    /**
     * 机器人号码注册广播
     */
    public final static String ROBOT_REGISTER_ACTION = "com.ren001.action.REGISTER";
    public final static String NAME_ROBOT_NUMBER = "robotNumber";


    /**
     *  1001
     * 手机端发来的绑定
     */
    public final static String ROBOT_BINDING_ACTION = "com.ren001.action.BINDING";
    public final static String NAME_BINDING = "bindingJson";

    /**
     * 1002
     * 手机端发来的解绑
     */
    public final static String ROBOT_UNBINDING_ACTION = "com.ren001.action.UNBINDING";
    public final static String NAME_UNBINDING = "bindingJson";

    /**
     * 1003
     * 手机端发来的设为默认（激活）
     */
    public final static String ROBOT_BINDING_SET_DEFAULT_ACTION = "com.ren001.action.BINDING_SET_DEFAULT";
    public final static String NAME_SET_DEFAULT = "bindingJson";


    /**
     * 1101
     * 机器人文件下载广播
     */
    public final static String ROBOT_FILE_ACTION = "com.ren001.action.FILE_DOWNLOAD";
    public final static String NAME_FILE = "filesJson";


    //    2001：获取事件列表
    public final static String ROBOT_GET_EVENT__ACTION = "com.ren001.action.GET_EVENT";
    public final static String NAME_EVENT = "eventJson";


    //1301 红外
    public final static String ROBOT_HOUSEHOLD_CONTROL_ACTION = "com.ren001.action.HOUSEHOLD_CONTROL__ACTION";
    // 1302 增加智能家居
    public final static String ROBOT_HOUSEHOLD_ADD_ACTION = "com.ren001.action.HOUSEHOLD_ADD__ACTION";
    // 1303 删除智能家居
    public final static String ROBOT_HOUSEHOLD_DELETE_ACTION = "com.ren001.action.HOUSEHOLD_DELETE__ACTION";
    // 1304 净化器设置
    public final static String ROBOT_HOUSEHOLD_PURIFIER_ACTION = "com.ren001.action.EDIT__ACTION";
    // 1305 获取已选家居列表
    public final static String ROBOT_HOUSEHOLD_GET_ACTION = "com.ren001.action.HOUSEHOLD_GET__ACTION";

    public final static String NAME_HOUSEHOLD = "householdJson";


    //智能家居
    public final static String APPLIANCE_CONTROL_ACTION = "com.ren001.action.APPLIANCE_CONTROL";
    public final static String NAME_APPLIANCE_CONTROL = "appliance_control";


    /**
     * 机器人局域网接收广播
     */                                                    //com.jiqiren001.filetransfer
    public final static String ROBOT_FILE_TRANSFER_ACTION = "com.ren001.filetransfer";
    public final static String KEY_EXTRA_FILE_TRANSFER = "file";


    /**
     * 机器人发送数据广播
     */
    public final static String ROBOT_TASK_SEND = "com.ren001.action.TASK_SEND";
    public final static String NAME_SEND_INFO = "send_info";
    public final static String NAME_SEND_DATA = "send_data";


    /**
     * 机器人接受数据广播
     */
    public final static String ROBOT_TASK_RECEIVE = "com.ren001.action.TASK_RECEIVE";
    public final static String NAME_RECEIVE_INFO = "receive_info";
    public final static String NAME_RECEIVE_DATA = "receive_data";



    /**
     * 机器人控制广播
     */
    public final static String ROBOT_CONTROL_ACTION = "com.ren001.action.CONTROL";
    public final static String NAME_ROBOT_CONTROL = "robotControl";

    /**
     * 机器人控制停止广播
     */
    public final static String ROBOT_CONTROL_STOP_ACTION = "com.ren001.control.STOP";

    /**
     * 机器人语音控制广播
     */
    public final static String ROBOT_CONTROL_SPEECH_ACTION_ = "com.ren001.robot.speech.control";
    public final static String NAME_CONTROL_SPEECH_TYPE = "type";
    public final static String NAME_SPEECH_CONTROL = "speech";


    /**
     * 机器人锁定广播
     */
    public final static String ROBOT_LOCK_ACTION = "com.ren001.robot.action.LOCK";

    /**
     * 机器人视频聊天广播
     */
    public final static String VIDEO_CHAT_ACTION = "com.ren001.robot.VIDEO_CHAT";
    public final static String NAME_VIDEO_CHAT = "isDoing";

    /**
     * 机器人视频聊天广播
     */
    public final static String VIDEO_CONTROL_ACTION = "com.ren001.robot.VIDEO_CONTROL";
    public final static String NAME_VIDEO_CONTROL = "isDoing";



    /**
     * 机器跳舞广播
     */
    public final static String DANCE_ACTION = "com.ren001.robot.action.DANCE";
    public final static String NAME_DANCE = "data";
    /* 命令广播 值为int类型 为 0 时执行跳舞  为 -1 时停止 */
    public final static String NAME_DANCE_ORDER = "order";

    /**
     * 机器动作组
     */
    public final static String DANCE_GROUP_TASK = "com.ren001.robot.action.GROUP_TASK";
    public final static String NAME_GROUP_TASK = "data";
    /* 命令广播 值为int类型 为 0 时执行、  为 -1 时停止 */
    public final static String NAME_GROUP_TASK_ORDER = "order";


    /**
     * 机器人头顶按钮
     */
    public final static String HEAD_KEY_ACTION = "com.ren001.robot.action.HEAD_KEY";
    public final static String KEY_HEAD_KEY = "key_code";


    /**
     * 机器人头顶按钮
     */
    public final static String SOS_ACTION = "com.ren001.robot.action.SOS";

    /**
     * 机器人头部角度
     */
    public final static String HEAD_ANGLE_ACTION = "com.ren001.robot.action.HEAD_ANGLE";
    public final static String KEY_HEAD_ANGLE = "angle";

    /**
     * 机器人面罩
     */
    public final static String ROBOT_MASK_ACTION = "com.ren001.robot.action.MASK";
    public final static String KEY_MASK_STATE = "mask_state";


    /**
     * 机器人托盘
     */
    public final static String ROBOT_TRAY_ACTION = "com.ren001.robot.action.TRAY";
    public final static String KEY_TRAY_STATE = "tray_state";

    /**
     * 机器人翅膀角度
     */
    public final static String WING_ANGLE_ACTION = "com.ren001.robot.action.WING_ANGLE";
    public final static String KEY_LEFT_WING_ANGLE= "left_angle";
    public final static String KEY_RIGHT_WING_ANGLE= "right_angle";



    /**
     * 机器人投影仪
     */
    public final static String PROJECTOR_MASK_ACTION = "com.ren001.robot.action.PROJECTOR";
    public final static String KEY_PROJECTOR_ORDER = "projector_order";
    public final static String KEY_PROJECTOR_STATE = "projector_state";



    /**
     * 机器超声波距离
     */
    public final static String DISTANCE_CHANGE_ACTION = "com.ren001.robot.action.WHEEL_DISTANCE";
    public final static String KEY_DISTANCE_CHANGE = "data";


    /**
     * 灯带
     */
    public final static String LIGHT_BELT_ACTION = "com.ren001.robot.action.LIGHT_BELT";
    public final static String NAME_LIGHT_BELT_ORDER = "isOpen";
    public final static String NAME_LIGHT_BELT = "light_belt_time";

}
