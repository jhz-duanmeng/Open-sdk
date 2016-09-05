package com.efrobot.library.sdk;


import android.content.Context;

public class RobotStatus {
 /* ====================================== 各状态通知索引 ======================================*/
    /**
     * 头顶按钮
     */
    public final static int ROBOT_STATE_INDEX_HEAD_KEY = 0;

    /**
     * 头部面罩
     */
    public final static int ROBOT_STATE_INDEX_MASK = 1;

    /**
     * 托盘
     */
    public final static int ROBOT_STATE_INDEX_TRAY = 2;


    /**
     * 整机电流
     */

    public final static int ROBOT_STATE_INDEX_BATTERY_STATUS_ELECTRIC = 3;

    /**
     * 电池电量
     */
    public final static int ROBOT_STATE_INDEX_BATTERY_STATUS_LEVEL = 4;

    /**
     * 电池充放电
     */
    public final static int ROBOT_STATE_INDEX_BATTERY_STATUS_CHARGING = 5;


    /**
     * 传感器温度
     */
    public final static int ROBOT_STATE_INDEX_AIR_QUALITY_TEMPERATURE = 6;


    /**
     * 传感器湿度
     */
    public final static int ROBOT_STATE_INDEX_AIR_QUALITY_HUMIDITY = 7;


    /**
     * 传感器PM2.5
     */
    public final static int ROBOT_STATE_INDEX_AIR_QUALITY_PM2_5 = 8;


    /**
     * 传感器异味
     */
    public final static int ROBOT_STATE_INDEX_AIR_QUALITY_SMELL = 9;

    /**
     * 头部角度
     */
    public final static int ROBOT_STATE_INDEX_HEAD_ANGLE = 10;

    /**
     * 投影仪状态
     */
    public final static int ROBOT_STATE_INDEX_PROJECTOR_STATE = 11;


    /**
     * 净化器状态
     */
    public final static int ROBOT_STATE_INDEX_PURIFIER_STATE = 12;

    /**
     * 左翅膀角度
     */
    public final static int ROBOT_STATE_INDEX_LEFT_WING_ANGLE = 13;

    /**
     * 右翅膀角度
     */
    public final static int ROBOT_STATE_INDEX_RIGHT_WING_ANGLE = 14;

    /**
     * 头部状态（停止/运动）
     */
    public final static int ROBOT_STATE_INDEX_HEAD = 15;

    /**
     * 左翅膀状态（停止/运动）
     */
    public final static int ROBOT_STATE_INDEX_LEFT_WING = 16;

    /**
     * 右翅膀状态（停止/运动）
     */
    public final static int ROBOT_STATE_INDEX_RIGHT_WING = 17;

    /**
     * 左轮（停止/运动）
     */
    public final static int ROBOT_STATE_INDEX_LEFT_WHEEL = 18;

    /**
     * 右轮（停止/运动）
     */
    public final static int ROBOT_STATE_INDEX_RIGHT_WHEEL = 19;

    /**
     * 自检
     */
    public final static int ROBOT_STATE_AUTO_CHECK = 20;

    /**
     * 投影仪电压
     */
    public final static int ROBOT_STATE_PROJECTOR_POWER = 21;

    /**
     * PAD电压
     */
    public final static int ROBOT_STATE_PAD_POWER = 22;

    /**
     * 头部、翅膀、风机电压
     */
    public final static int ROBOT_STATE_MOTOR_POWER = 23;

    /**
     * 主板电压
     */
    public final static int ROBOT_STATE_MAIN_BOARD_POWER = 24;

    /**
     * 电池电压
     */
    public final static int ROBOT_STATE_BATTERY_VOLTAGE = 25;

    /**
     * SOS按钮
     */
    public final static int ROBOT_STATE_INDEX_ROBOT_SOS = 100;

    /**
     * 净化器工作时长
     */
    public final static int ROBOT_STATE_INDEX_PURIFIER_WORK_TIME = 101;

    /**
     * 动作组合状态监听
     */
    public final static int ROBOT_STATE_INDEX_GROUP_LISTENER = 102;


    /**
     * 遇到障碍物
     */
    public final static int ROBOT_STATE_INDEX_HAS_OBSTACLE = 104;

    /**
     * 净化器风机速度
     */
    public final static int ROBOT_STATE_INDEX_PURIFIER_FAN_SPEED = 105;

    /**
     * 左轮是否悬空状态
     */
    public final static int ROBOT_STATE_INDEX_LEFT_WHEEL_SUSPEND = 106;

    /**
     * 右轮是否悬空状态
     */
    public final static int ROBOT_STATE_INDEX_RIGHT_WHEEL_SUSPEND = 107;

    /**
     * 从下位机获取摄像头数据
     */
    public final static int ROBOT_DATA_INDEX_GET_CAMERA_PARAMS = 108;


    /**
     * 超声波
     */
    public final static int ROBOT_DATA_INDEX_GET_ULTRASONIC = 109;


    /**
     * 是否执行过接驳充电桩
     */
    public final static int ROBOT_STATE_INDEX_HAD_CONNECTED_PILE = 111;

    /**
     * 获取双轮参数
     */
    public final static int ROBOT_STATE_INDEX_GET_WHEEL_PARAMS = 112;

    /**
     * 获取双目参数
     */
    public final static int ROBOT_STATE_INDEX_GET_CAMERA_PARAMS = 113;

    /**
     * 获取红外参数
     */
    public final static int ROBOT_STATE_INDEX_GET_INFRARED_PARAMS = 114;

    /**
     * 获取机器人Id
     */
    public final static int ROBOT_STATE_INDEX_GET_ROBOT_ID = 150;

    public final static int ROBOT_STATE_INDEX_LEFT_WHEEL_MOTOR_ELECTRICITY = 115;
    public final static int ROBOT_STATE_INDEX_RIGHT_WHEEL_MOTOR_ELECTRICITY = 116;
    public final static int ROBOT_STATE_INDEX_HEAD_MOTOR_ELECTRICITY = 117;
    public final static int ROBOT_STATE_INDEX_WING_MOTOR_ELECTRICITY = 118;
    public final static int ROBOT_STATE_INDEX_WHEEL_FEED_BACK = 138;//双轮里程数的反馈
    /**
     * 获取绑定的充电桩
     */
    public final static int ROBOT_STATE_INDEX_GET_BIND_CHARGING_PILE = 119;

    /**
     * 电源按钮
     */
    public final static int ROBOT_STATE_INDEX_ROBOT_POWER_KEY = 120;


    public final static int ROBOT_STATE_INDEX_PURIFIER_SHUT_DOWN = 121;

    public final static int PURIFIER_SHUT_DOWN_TYPE_HEAD_KEY = 0;//摸头
    public final static int PURIFIER_SHUT_DOWN_TYPE_SOS_KEY = 1;//SOS按钮
    public final static int PURIFIER_SHUT_DOWN_TYPE_POWER_KEY = 2;//电源按钮
    public final static int PURIFIER_SHUT_DOWN_TYPE_CHARGING = 3;//充电

    /**
     * 投影仪高温
     */
    public final static int PROJECTOR_HOT_STATE_INDEX_KEY = 122;


    public final static int PROJECTOR_STATE_TEMP_HOT = 1;//过温报警
    public final static int PROJECTOR_STATE_TEMP_NORMAL = 0;//常温状态
    public final static String PROJECTOR_HOT_CLOSE_PREFERENCES_KEY = "projector_hot_close_preferences_key";//投影仪过热关闭preferences_key
    public final static String PROJECTOR_CLOSE_PREFERENCES_KEY = "projector_close_preferences_key";//投影仪关闭preferences_key

    public final static int ROBOT_STATE_SPEECH_INDEX = 130;//语音普通模式状态


    /*============================红外参数=========================================*/
    public final static int ROBOT_DATA_INDEX_GET_INFRARED = 110;//获取红外初始化
    public final static int ROBOT_STATE_INDEX_INFRARED_GET_INFRAREDTHRESHOLD = 300;//获取红外阈值
    public final static int ROBOT_STATE_INDEX_INFRARED_GET_LABEL = 301;//获取红外初始化数据
    public final static int ROBOT_STATE_INDEX_INFRARED_INIT_DATA = 302;//红外初始化数据获取
    public final static int ROBOT_INFRARED_GET_BARRIER_FEEDBACK_PARAMS = 303;//获取红外壁障数据反馈

    public final static int ROBOT_STATE_INIT_INDEX_START = 500;
    public final static int ROBOT_STATE_INIT_INDEX_END = 501;


    /* ======================================安全监测索引 ======================================*/
    public final static int ROBOT_STATE_CHECK_SAFE_BATTERY = 600;//电池电量
    public final static int ROBOT_STATE_CHECK_SAFE_WHOLEMOTOR = 601;//整机电流
    public final static int ROBOT_STATE_CHECK_SAFE_PROJECTOR = 602;//投影仪
    public final static int ROBOT_STATE_CHECK_SAFE_PAD = 603;//PAD
    public final static int ROBOT_STATE_CHECK_SAFE_HEED_WHEEL_SYSTEM = 604;//头 翅膀 风机
    public final static int ROBOT_STATE_CHECK_SAFE_MAINBOARD = 605;//主板
    public final static int ROBOT_STATE_CHECK_SAFE_BATTERY_PERFORMANCE = 606;//电池性能
    public final static int ROBOT_STATE_CHECK_SAFE_DOUBLE_WHEEL_MOTOR = 607;//双轮电机

      /*   ===========================超声波板 电机驱动板===================================*/
    /**
     * 超声波 电机驱动板
     */

    public final static String ROBOT_STRING_UNKNOWN = "UNKNOWN";//获取为0则再重新获取
    public final static int ROBOT_STATE_INDEX_ARM_ID = 120;//ARM板Id
    public final static int ROBOT_STATE_INDEX_ARM_SN = 121;//ARM板SN
    public final static int ROBOT_STATE_INDEX_ULTRASONIC_VERSION = 122;//超声波板硬件版本号
    public final static int ROBOT_STATE_INDEX_ULTRASONIC_SN = 123;//超声波板SN号
    public final static int ROBOT_STATE_INDEX_MOTOR_DRIVER_VERSION = 124;//电机驱动板版本号
    public final static int ROBOT_STATE_INDEX_MOTOR_DRIVER_SN = 125;//电机驱动板SN号

    /* ====================================== 导航部分索引 ======================================*/

    /**
     * 导航模块数据
     */
    public final static int ROBOT_DATA_INDEX_NAVIGATION = 200;

    /**
     * 充电桩模块数据
     */
    public final static int ROBOT_DATA_INDEX_CHARGE_PILE = 201;

    /**
     * 导航状态(NAVIGATION_STATE_IDLE, NAVIGATION_STATE_NORMAL, NAVIGATION_STATE_CHARGING)
     */
    public final static int ROBOT_NAVIGATION_STATE_INDEX = 202;

    /**
     * 导航过程
     */
    public final static int ROBOT_NAVIGATION_CHANGE_INDEX = 203;


    /**
     * 地图状态索引
     */
    public final static int ROBOT_MAP_STATE_INDEX = 204;

    /**
     * 导航失败
     */
    public final static int ROBOT_NAVIGATION_FAIL_INDEX = 205;

    /**
     * 机器人定位（目前只用来判断是否在充电桩）
     */
    public final static int ROBOT_STATE_INDEX_LOCATION = 206;

    /* ====================================== 导航部分索引 ======================================*/

    /**
     * 在充电桩上
     */
    public final static int ROBOT_LOCATION_CHARGING_PILE = 0;

    /**
     * 正在出充电桩
     */
    public final static int ROBOT_LOCATION_OUT_CHARGING_PILE_DOING = 1;

    /**
     * 完成出充电桩
     */
    public final static int ROBOT_LOCATION_OUT_CHARGING_PILE_DONE = 2;

    /* ===================================充电桩==================================== */

    public final static int ROBOT_INDEX_CHARGING_PILE_VERSION = 131;//充电桩硬件版本号
    public final static int ROBOT_INDEX_OLD_CHARGING_PILE_VERSION = 139;//旧充电桩硬件版本号
    public final static int ROBOT_INDEX_CHARGING_PILE_SN = 132;//充电桩SN号
    public final static int ROBOT_INDEX_CHARGING_PILE_MONTH = 132;//充电桩月份
    public final static int ROBOT_INDEX_CHARGING_PILE_DATE = 133;//充电桩日期
    public final static int ROBOT_INDEX_CHARGING_PILE_NUMBER = 134;//充电桩编号
    public final static int ROBOT_INDEX_CHARGING_PILE_ID = 135;//充电桩Id号

    public final static int ROBOT_INDEX_CHARGING_PILE_LIMIT = 136;//限位开关状态
    public final static int ROBOT_INDEX_CHARGING_PILE_VOLTAGE = 137;//电压
    public final static int ROBOT_INDEX_CHARGING_PILE_ELECTRIC = 138;//电流


    /* ============================ 是否接触过充电桩 ============================ */

    public final static int ROBOT_STATE_HAD_NOT_CONNECTED_PILE = 0;
    public final static int ROBOT_STATE_HAD_CONNECTED_PILE = 1;

    /* ============================ 是否接触过充电桩 ============================ */


    /* ============================ APP视频部分索引 ============================ */


    /* ============================ APP视频部分索引 ============================ */

    /**
     * 视频服务（0 空闲，1 远程遥控，2 语音聊天，3 视频聊天）
     */
    public final static int ROBOT_STATE_INDEX_VIDEO_SERVICE = 300;


    public final static int VIDEO_SERVICE_STATE_IDLE = 0;
    public final static int VIDEO_SERVICE_STATE_REMOTE_CONTROL = 1;
    public final static int VIDEO_SERVICE_STATE_AUDIO = 2;
    public final static int VIDEO_SERVICE_STATE_VIDEO = 3;
    public final static int VIDEO_SERVICE_STATE_REMOTE_CONTROL_SOS = 4;


    /* ============================ APP视频部分索引 ============================ */


    /* ============================ APP语音模式部分索引 ============================ */

    public final static int ROBOT_STATE_INDEX_SPEECH_MODEL = 301;
    //语音空闲模式
    public final static int ROBOT_SPEECH_MODEL_DEFAULT = -1;
    //睡眠模式(自主问答)
    public final static int ROBOT_SPEECH_MODEL_SLEEP = 1;
    //音乐模式(自主问答)
    public final static int ROBOT_SPEECH_MODEL_MUSIC = 2;
    //问答(自主问答)
    public final static int ROBOT_SPEECH_MODEL_QUESTION = 3;
    //相声(自主问答)
    public final static int ROBOT_SPEECH_MODEL_CROSS = 4;
    //小游戏(自主问答)
    public final static int ROBOT_SPEECH_MODEL_TURN = 5;
    //心理测试(自主问答)
    public final static int ROBOT_SPEECH_MODEL_PSYC = 6;
    //童话故事(自主问答)
    public final static int ROBOT_SPEECH_MODEL_FAIRY = 7;
    //笑话模式(自主问答)
    public final static int ROBOT_SPEECH_MODEL_SMILE = 8;
    //新闻模式(自主问答)
    public final static int ROBOT_SPEECH_MODEL_NEWS = 9;
    //音乐模式
    public final static int ROBOT_SPEECH_MODEL_AT_MUSIC = 10;
    //	笑话模式
    public final static int ROBOT_SPEECH_MODEL_AT_JOKE = 11;
    //	视频模式
    public final static int ROBOT_SPEECH_MODEL_AT_VIDEO = 12;
    //	童话模式
    public final static int ROBOT_SPEECH_MODEL_AT_FAIRY = 13;
    //	小游戏模式
    public final static int ROBOT_SPEECH_MODEL_AT_GAME = 14;
    //	百科全书模式
    public final static int ROBOT_SPEECH_MODEL_AT_ENCYCLOPAEDIA = 15;
    //	翻译模式
    public final static int ROBOT_SPEECH_MODEL_AT_TRANSLATION = 16;
    //	跳舞模式
    public final static int ROBOT_SPEECH_MODEL_AT_DANCE = 17;
    //	新闻模式
    public final static int ROBOT_SPEECH_MODEL_AT_NEWS = 18;
    //	相声模式
    public final static int ROBOT_SPEECH_MODEL_AT_CROSSTALK = 19;
    //	照相
    public final static int ROBOT_SPEECH_MODEL_AT_TAKE_PICTURE = 20;
    //	提醒模式
    public final static int ROBOT_SPEECH_MODEL_AT_SCHEDULE = 21;
    //	猜丁壳（拍头退出）（已屏蔽）//
    public final static int ROBOT_SPEECH_MODEL_AT_GUESS_ROSHAMBO = 22;
    //	导航模式
    public final static int ROBOT_SPEECH_MODEL_AT_NAVIGATION = 23;
    //	家庭影院模式
    public final static int ROBOT_SPEECH_MODEL_AT_FAMILYCINEMA = 24;
    //	Pm值
    public final static int ROBOT_SPEECH_MODEL_AT_PM = 27;
    //	异味值
    public final static int ROBOT_SPEECH_MODEL_AT_SMELL = 28;
    //	学习单词模式（已屏蔽）
    public final static int ROBOT_SPEECH_MODEL_AT_LEARN_WORD = 29;
    //	录像模式
    public final static int ROBOT_SPEECH_MODEL_AT_TAKE_VIDEO = 30;
    //	英语学习跟读
    public final static int ROBOT_SPEECH_MODEL_AT_FOLLOW = 31;
    //	小学英语233
    public final static int ROBOT_SPEECH_ROBOT_SPEECH_MODEL_233_TEACHING = 32;
    //	智能家眷导航模式
    public final static int ROBOT_SPEECH_MODEL_AT_HOUSE_NAVIGATION = 33;
    //  帮助模式
    public final static int ROBOT_SPEECH_MODEL_AT_HELP = 37;

    /* ============================ APP语音模式部分索引 ============================ */


    /* ============================ APP语音睡眠模式 ============================ */

    //普通模式
    public final static int ROBOT_SPEECH_MODEL_NORMAL = 0;
    //浅睡眠模式
    public final static int ROBOT_SPEECH_MODEL_SHALLOW_SLEEP = 1;
    //深睡眠模式
    public final static int ROBOT_SPEECH_MODEL_DEEP_SLEEP = 2;


   /* ============================ APP语音睡眠模式 ============================ */


    /* ============================ APP定时找你模式部分索引 ============================ */

    public final static int ROBOT_STATE_INDEX_SPEECH_MODEL_TIMING = 302;
    public final static int ROBOT_STATE_MODEL_TIMING_CLOSE = 0;
    public final static int ROBOT_STATE_MODEL_TIMING_OPEN = 1;

    /* ============================ APP定时找你模式部分索引 ============================ */


    /* ============================ APP跳舞部分索引 ============================ */
    public final static int ROBOT_STATE_INDEX_DANCE = 303;

    public final static int ROBOT_STATE_DANCE_STOP = 0;
    public final static int ROBOT_STATE_DANCE_DOING = 1;



    /* ============================ APP跳舞部分索引 ============================ */


    /* ============================ APP迷路部分索引 ============================ */
    public final static int ROBOT_STATE_INDEX_NAVIGATION_LOSE_WAY = 304;

    public final static int ROBOT_STATE_UN_NAVIGATION_LOSE_WAY = 0;
    public final static int ROBOT_STATE_NAVIGATION_LOSE_WAY = 1;

    /* ============================ APP迷路部分索引 ============================ */


    /* ============================ APP构建地图部分索引 ============================ */
    public final static int ROBOT_STATE_INDEX_BUILD_MAP = 306;

    public final static int ROBOT_STATE_UN_BUILD_MAP = 0;
    public final static int ROBOT_STATE_BUILD_MAP = 1;

    /* ============================ APP构建地图部分索引 ============================ */


    /* ============================ APP导航失败友好提示 ============================ */
    public final static int ROBOT_STATE_INDEX_NAVIGATION_VOICE_PROMPT = 307;


    /* ============================ APP导航失败友好提示 ============================ */


    /* ====================================== 头部触摸 ======================================*/
    /**
     * 抬起
     */
    public final static int HEADKEY_STATE_UP = 0;

    /**
     * 唤醒
     */
    public final static int HEADKEY_STATE_AWAKEN = 1;

    /**
     * 急停
     */
    public final static int HEADKEY_STATE_STOP = 2;

    /* ====================================== 电源按钮状态 ======================================*/
    /**
     * 按下
     */
    public final static int POWERKEY_STATE_DOWN = 0;
    /**
     * 抬起
     */
    public final static int POWERKEY_STATE_UP = 1;

    /* ====================================== SOS按钮状态 ======================================*/
    /**
     * 按下
     */
    public final static int SOSKEY_STATE_DOWN = 0;
    /**
     * 抬起
     */
    public final static int SOSKEY_STATE_UP = 1;
    /* ====================================== 头部触摸 ======================================*/


    /* ====================================== 面罩状态 ======================================*/

    /**
     * 面罩关闭
     */
    public final static int MASK_STATE_CLOSE = 0;

    /**
     * 面罩半开
     */
    public final static int MASK_STATE_MIDDLE = 1;

    /**
     * 面罩打开
     */
    public final static int MASK_STATE_OPEN = 2;

    /* ====================================== 面罩状态 ======================================*/


    /* ====================================== 托盘状态 ======================================*/

    /**
     * 托盘关闭
     */
    public final static int TRAY_STATE_CLOSE = 0;

    /**
     * 托盘打开
     */
    public final static int TRAY_STATE_OPEN = 1;

    /* ====================================== 托盘状态 ======================================*/

    /* ====================================== 投影仪状态 ======================================*/

    /**
     * 投影仪关闭
     */
    public final static int PROJECTOR_STATE_CLOSE = 0;

    /**
     * 投影仪打开
     */
    public final static int PROJECTOR_STATE_OPEN = 1;

    /* ====================================== 双轮电流状态 ======================================*/

    public final static int ROBOT_STATE_WHEEL_INDEX_ELECTRICITY = 140;

    //未过流
    public final static int ROBOT_WHEEL_ELECTRICITY_NORMAL = 0;

    //代表过流
    public final static int ROBOT_WHEEL_ELECTRICITY_OVERCURRENT = 1;

    //清空过流状态
    public final static int ROBOT_WHEEL_ELECTRICITY_CLEAR = 2;


    /* ====================================== 托盘状态 ======================================*/

     /* ====================================== 电池状态 ======================================*/
    /**
     * 未充电
     */
    public final static int BATTERY_STATE_UN_CHARGING = 0;

    /**
     * 充电(线充)
     */
    public final static int BATTERY_STATE_CHARGING_LINE = 1;

    /**
     * 涓流充电(充电桩)
     */
    public final static int BATTERY_STATE_CHARGING_TRICKLE = 2;

    /**
     * 正常充电(充电桩)
     */
    public final static int BATTERY_STATE_CHARGING_NORMAL = 3;

    /**
     * 浮充(充电桩)
     */
    public final static int BATTERY_STATE_CHARGING_FLOATING = 4;


    /**
     * 充电完成(充电桩)
     */
    public final static int BATTERY_STATE_CHARGING_DONE = 5;

    /* ====================================== 电池状态 ======================================*/




    /* ====================================== 机器人电机状态 ======================================*/

    /**
     * 机器人电机状态（运动）
     */
    public final static int ROBOT_MOTOR_STATE_MOVING = 1;

    /**
     * 机器人电机状态（停止）
     */
    public final static int ROBOT_MOTOR_STATE_STOP = 0;



    /* ====================================== 机器人电机状态 ======================================*/





    /* ====================================== 导航状态 ======================================*/

    /**
     * 导航状态（闲置）
     */
    public static final int NAVIGATION_STATE_IDLE = 0;

    /**
     * 导航状态（普通目的地）
     */
    public static final int NAVIGATION_STATE_NORMAL = 1;

    /**
     * 导航状态（充电桩）
     */
    public static final int NAVIGATION_STATE_CHARGING = 2;

    /**
     * 导航状态（接驳）
     */
    public static final int NAVIGATION_STATE_CONNECT_CHARGING_PILE = 3;

    /**
     * 导航状态（出充电桩）
     */
    public static final int NAVIGATION_STATE_OUT_CHARGING_PILE = 4;


    /* ====================================== 导航状态 ======================================*/




    /* ====================================== 地图模块索引及状态 ======================================*/
    /**
     * 地图状态 未构建
     */
    public final static int MAP_STATE_UN_BUILD = 0;

    /**
     * 地图状态 构建中
     */
    public final static int MAP_STATE_BUILDING = 1;

    /**
     * 地图状态 构建完成
     */
    public final static int MAP_STATE_BUILD = 2;



    /* ====================================== 地图模块索引及状态 ======================================*/

    /* ====================================== 导航流程回调 ======================================*/

    /**
     * 开始导航
     */
    public final static int NAVIGATION_RESULT_START = 0;
    /**
     * 暂停导航
     */
    public final static int NAVIGATION_RESULT_PAUSE = 1;

    /**
     * 继续导航
     */
    public final static int NAVIGATION_RESULT_CONTINUE = 2;
    /**
     * 停止导航
     */
    public final static int NAVIGATION_RESULT_STOP = 3;

    /**
     * 导航成功
     */
    public final static int NAVIGATION_RESULT_SUCCESS = 4;

    /**
     * 导航失败
     */
    public final static int NAVIGATION_RESULT_FAIL = 5;

    /* ====================================== 导航流程回调 ======================================*/



    /* ====================================== 导航失败原因 ======================================*/

    //导航规划 起点不合法
    public final static int NAVIGATION_FAIL_REASON_START_POSITION_ILLEGAL = -1;
    //终点不合法
    public final static int NAVIGATION_FAIL_REASON_DESTINATION_POINT_ILLEGAL = -2;
    //规划路径
    public final static int NAVIGATION_FAIL_REASON_PLANNING_PATH = -3;
    //全局蔽障失败
    public final static int NAVIGATION_FAIL_REASON_OBSTACLE_AVOIDANCE = -4;
    //地图不存在
    public final static int NAVIGATION_FAIL_REASON_HAS_NOT_MAP = -5;
    //充电桩电极未抬起
    public final static int NAVIGATION_FAIL_REASON_ELECTRODE_NOT_RAISED = -15;
    //托盘打开，需要过门，拒绝导航
    public final static int NAVIGATION_FAIL_REASON_CAN_NOT_THROUGH_DOOR_BY_OPEN_TRY = -18;
    //托盘打开，规划路径失败
    public final static int NAVIGATION_FAIL_REASON_CAN_NOT_PLAN_PATH_BY_OPEN_TRY = -200;
    //检测原点，获取充电桩状态失败
    public final static int NAVIGATION_FAIL_REASON_CAN_NOT_GET_CHARGING_PILE_STATE = -201;
    //超声波标定失败
    public final static int NAVIGATION_FAIL_REASON_ULTRASONIC_CALIBRATION = -202;
    //试图到达可行区域失败
    public final static int NAVIGATION_FAIL_REASON_TRY_TO_FEASIBLE_REGION = -203;
    //尚未接驳不允许依赖地图导航
    public final static int NAVIGATION_FAIL_REASON_NOT_CONNECTED = -204;
    //检测原点，设置充电桩状态失败
    public final static int NAVIGATION_FAIL_REASON_SET_CHARGING_PILE_STATE = -205;
    //距离充电桩太近，不宜导航
    public final static int NAVIGATION_FAIL_REASON_DISTANCE_CHARGING_PILE_TOO_CLOSE = -206;


    /* ====================================== 导航流程回调 ======================================*/


    private volatile static RobotStatus instance;

    private Context mContext;

    private int robotVersion;
    private String robotNumber;
    private String robotName;
    private String hostUrl;

    private int batteryLevel;
    private int batteryState;
    private int electric;
    private int projectorPower;
    private int padPower;
    private int motorPower;
    private int mainBoardPower;
    private int batteryVoltage;


    private int pm2_5;
    private int temperature;
    private int humidity;
    private int peculiarSmell;

    private int headKeyState;
    private int maskState;
    private int trayState;
    private int projectorState;
    private int purifierState;
    private int mapState = MAP_STATE_UN_BUILD;
    private int navigationState;
    private int purifierFanSpeed;
    private int leftWheelSuspendState;
    private int rightWheelSuspendState;


    private int headAngle;
    private int leftWingAngle;
    private int rightWingAngle;
    private int lightBeltBrightness;
    private int purifierWorkTime;

    private int headState = ROBOT_MOTOR_STATE_STOP;
    private int leftWingState = ROBOT_MOTOR_STATE_STOP;
    private int rightWingState = ROBOT_MOTOR_STATE_STOP;
    private int leftWheelState = ROBOT_MOTOR_STATE_STOP;
    private int rightWheelState = ROBOT_MOTOR_STATE_STOP;

    private int bindChargingPile;

    private int robotLocation;

    private int hasConnectedPile;


    private int videoService;
    private long lastVideoServiceCheck;

    private int speechModel;
    private long lastSpeechModelCheck;

    private int speechModelTiming;
    private long lastSpeechModelTimingCheck;


    private int danceState;
    private long lastDanceStateCheck;

    private int loseWayState;
    private long lastLoseWayStateCheck;

    private int buildMapState;
    private long lastBuildMapStateCheck;


    private int leftWheelMotorElectricity;
    private int rightWheelMotorElectricity;
    private int headMotorElectricity;
    private int wingMotorElectricity;

    private int speechModelState;
    private long lastSpeechModeStateCheck;


    //双轮电流保护
    private int robotStateWheelElectricity;
    //机器人ID
    private String linuxSaveNumber;

    //------------------------------超声波板 ARM  数据---------------------------------------
    private String armVersion;//ARM板Version
    private String armSN;//ARM板SN
    private String ultVersion;//超声波板硬件版本号
    private String ultSN;//超声波板SN号
    private String motorDriverVersion;//电动机驱动板版本号
    private String motorDriverSN;//电机驱动板SN号

    private String chargingPileVersion;//充电桩硬件版本号
    private int oldChargingPileVersion;//旧充电桩硬件版本号
    private String chargingPileSN;//充电桩SN号
    private int chargingPileMonth;//充电桩月份
    private int chargingPileDate;//充电桩日期
    private int chargingPileNumber;//充电桩编号
    private String chargingPileId;//充电桩id
    private int chargingPileFrequency;//充电桩频率


    private int chargingPileVoltage;//充电桩电压
    private int chargingPileElectric;//充电桩电流
    private int chargingPileLimit;//充电桩限位
    private int infraredState;//红外初始化的状态

    private int navigationVoicePrompt;

    private long lastNavigationVoicePromptCheck;


    private int sosKeyState;//sos按钮状态
    private int powerKeyState;//电源按钮状态

    private int projectorTemperatureState;//投影仪温度状态
    private long projectorHotCloseTime;//投影仪关闭时间
    private long projectorCloseTime;//保存投影仪关闭状态的变量
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
     * 机器人的版本号
     */
    public enum RobotVersion{
        /** 家庭版 */
       Family,
        /** 商务版 */
        BUSINESS,
        /** 位置状态 */
        UNKNOW,
        /** 初始化失败 */
        fail
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
        /** 初始化失败 */
        fail
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
        /** 初始化失败 */
        fail
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
        /** 初始化失败 */
        fail
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
        /** 初始化失败 */
        fail
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
        /** 初始化失败 */
        fail
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
        /** 初始化失败 */
        fail
    }

}
