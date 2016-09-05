package com.efrobot.library.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;

import com.efrobot.library.sdk.message.RobotByteArrayMessage;
import com.efrobot.library.sdk.message.RobotStateMessage;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.HeapChannelBufferFactory;
import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.DefaultNodeMainExecutor;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMainExecutor;
import org.ros.node.topic.Publisher;
import org.ros.node.topic.Subscriber;

import java.lang.ref.WeakReference;
import java.net.URI;
import java.nio.ByteOrder;

/**
 * Created by 鑫宇 on 2016/9/2.
 */
public class RobotManager {

    public final static String TAG = "RobotManager";
    private final static String ACTION_NAME_ROS_MASTER_START = "com.efrobot.service.START_ROS_MASTER";
    // 节点注册状态 0 未注册， 1 正在注册， 2 已注册
    private int nodeRegisterState = 0;
    private Context mContext;
    /**
     * 获取机器人管理实例 单例对象
     */
    private volatile static RobotManager mInstance;
    private String packageName;

    private String noteListenerName;
    /**
     * 默认Host地址
     */
    private final static String defaultHostAddress = "127.0.0.1";
    /**
     * 机器人状态对象
     */
    private RobotStatus mRobotStatus;
    private Handler mHandler;
    private RosMasterBroadcast mBroadcastReceiver;

    /**
     * 负责发布和订阅控制机器人的任务
     * {@link com.efrobot.library.sdk.RobotManager.RobotControlNode}
     */
    private RobotControlNode mRobotControlNode;

    /**
     * 负责任务的分发
     */
    private NodeMainExecutor nodeMainExecutor;


    private RobotManager(Context mContext) {
        this.mContext = mContext.getApplicationContext();
        mRobotStatus = RobotStatus.getInstance(this.mContext);
        mHandler = new BaseHandler(this);

        //注册Master开启广播

        mBroadcastReceiver = new RosMasterBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_NAME_ROS_MASTER_START);
        this.mContext.registerReceiver(mBroadcastReceiver, intentFilter);
        nodeRegisterState = 0;//未注册状态

        registerRosNote();
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
     * 初始化SDK
     *
     * @param accessKey
     * @param accessSecret           初始化完成回调
     * @param appKey
     * @param onInitCompleteListener 初始化完成回调
     */
    public void init(String accessKey, String accessSecret, String appKey, OnInitCompleteListener onInitCompleteListener) {

    }


    /**
     * 初始化完成回调
     */
    private OnInitCompleteListener mOnInitCompleteListener;

    public void registerOnInitCompleteListener(OnInitCompleteListener mOnInitCompleteListener) {
        this.mOnInitCompleteListener = mOnInitCompleteListener;
    }

    public interface OnInitCompleteListener {
        void onInitComplete(ResultCode resultCode);
    }

    /**
     * 获取机器人ID
     *
     * @return 机器人ID，无号码返回null
     */

    public String getRobotId() {
        return null;
    }

    ;

    /**
     * 获取机器人的版本
     *
     * @return 机器人的版本
     */
    public RobotStatus.RobotVersion getRobotVersion() {
        return RobotStatus.RobotVersion.Family;
    }


    /**
     * init 结果
     */
    public enum ResultCode {
        fail,
        success,
    }

    /**
     * 获取投影仪状态
     *
     * @return ProjectStatus 投影仪状态
     */
    public RobotStatus.ProjectStatus getProjectorStatus() {
        return RobotStatus.ProjectStatus.CLOSE;
    }

    /**
     * 注册投影仪状态变化监听
     *
     * @param listener 投影仪状态变化监听
     */
    public void registerProjectorStatusChangedListener(OnProjectStatusChangedListener listener) {
    }


    /**
     * 取消注册投影仪状态变化监听
     *
     * @param listener 投影仪状态变化监听
     */
    public void unRegisterProjectorStatusChangedListener(OnProjectStatusChangedListener listener) {
    }


    /**
     * 投影仪状态回调
     */
    public interface OnProjectStatusChangedListener {
        void onProjectStatusChanged(RobotStatus.ProjectStatus projectStatus);
    }

    /**
     * 注册机器人电量变化监听
     *
     * @param listener 电池电量变化监听
     */
    public void registerBatteryLevelChangedListener(OnBatteryLevelChangedListener listener) {
    }

    /**
     * 取消注册机器人电量变化监听
     *
     * @param listener 电池电量变化监听
     */
    public void unRegisterBatteryLevelChangedListener(OnBatteryLevelChangedListener listener) {
    }

    /**
     * 电量状态变化监听
     */
    public interface OnBatteryLevelChangedListener {
        void onBatteryLevelChanged(int batteryLevel);
    }

    /**
     * 获取电池状态
     *
     * @return BatteryStatus 电池状态
     */
    public RobotStatus.BatteryStatus getBatteryStatus() {
        return RobotStatus.BatteryStatus.CHARGINGING;
    }

    /**
     * 电池状态变化监听
     */
    public interface OnBatteryStatusChangedListener {
        void onBatteryStatusChanged(RobotStatus.BatteryStatus batteryStatus);
    }


    /**
     * 注册机器人电池状态变化监听
     *
     * @param listener 电池状态变化监听
     */
    public void registerBatteryStatusChangeListener(OnBatteryStatusChangedListener listener) {
    }

    /**
     * 取消注册机器人电池状态变化监听
     *
     * @param listener 电池状态变化监听
     */
    public void unRegisterBatteryStatusChangeListener(OnBatteryStatusChangedListener listener) {
    }

    /**
     * 获取头顶触摸状态
     *
     * @return HeadTouchStatus 头顶触摸状态
     */
    public RobotStatus.HeadTouchStatus getHeadTouchStatus() {
        return RobotStatus.HeadTouchStatus.UNKNOWN;
    }

    /**
     * 注册头顶触摸状态变化监听
     *
     * @param listener 头顶触摸状态变化监听
     */
    public void registerOnHeadTouchStatusChangedListener(OnHeadTouchStatusChangedListener listener) {
    }

    /**
     * 取消注册头顶触摸状态变化监听
     *
     * @param listener 头顶触摸状态变化监听
     */
    public void unOnHeadTouchStatusChangedListener(OnHeadTouchStatusChangedListener listener) {
    }


    /**
     * 头顶触摸状态变化监听
     */
    public interface OnHeadTouchStatusChangedListener {
        void onHeadTouchStatusChanged(RobotStatus.HeadTouchStatus headTouchStatus);
    }

    /**
     * 净化器状态变化监听
     */
    public interface OnPurifierStatusChangedListener {
        void onPurifierStatusChanged(RobotStatus.PurifierStatus purifierStatus);
    }


    /**
     * 获取机器人净化器状态
     *
     * @return 净化器状态，未获取到返回- 10000
     */
    public RobotStatus.PurifierStatus getPurifierStatus() {
        return RobotStatus.PurifierStatus.UNKNOWN;
    }

    /**
     * 注册净化器状态变化监听
     *
     * @param listener 净化器状态变化监听
     */
    public void registerPurifierStatusChangedListener(OnPurifierStatusChangedListener listener) {
    }


    /**
     * 取消注册净化器状态变化监听
     *
     * @param listener 净化器状态变化监听
     */
    public void unRegisterPurifierStatusChangedListener(OnPurifierStatusChangedListener listener) {
    }

    /**
     * 获取机器人面罩的开关状态
     *
     * @return MaskStatus 面罩状态
     */
    public RobotStatus.MaskStatus getMaskStatus() {
        return RobotStatus.MaskStatus.UNKNOWN;
    }


    /**
     * 面罩状态变化监听
     */
    public interface OnMaskStatusChangedListener {
        void onMaskStatusChanged(RobotStatus.MaskStatus maskStatus);
    }

    /**
     * 注册面罩状态变化监听
     *
     * @param listener 面罩状态变化监听
     */
    public void registerMaskStatusChangedListener(OnMaskStatusChangedListener listener) {
    }

    /**
     * 取消注册面罩状态变化监听
     *
     * @param listener 面罩状态变化监听
     */
    public void unRegisterMaskStatusChangedListener(OnMaskStatusChangedListener listener) {
    }

    /**
     * 托盘状态变化监听
     */
    public interface OnSalverStatusChangedListener {
        void onSalverStatusChanged(RobotStatus.SalverStatus salverStatus);
    }

    /**
     * 获取机器人托盘的状态
     *
     * @return SalverStatus 托盘状态
     */
    public RobotStatus.SalverStatus getSalverStatus() {
        return RobotStatus.SalverStatus.UNKNOWN;
    }

    /**
     * 注册托盘状态变化监听
     *
     * @param listener 托盘状态变化监听
     */
    public void registerSalverStatusChangedListener(OnSalverStatusChangedListener listener) {
    }

    /**
     * 取消注册托盘状态变化监听
     *
     * @param listener 托盘状态变化监听
     */
    public void unRegisterSalverStatusChangedListener(OnSalverStatusChangedListener listener) {
    }

    private String getDefaultHostAddress() {
        return defaultHostAddress;
    }

    /**
     * 注册RosNote
     */
    private void registerRosNote() {
        if ((mRobotControlNode != null && mRobotControlNode.hasConnect()) || nodeRegisterState == 1 || nodeRegisterState == 2) {
            if (nodeRegisterState == 2)
                Log.d(TAG, "已经连接ROS");
            else
                Log.d(TAG, "上次节点尚未注册成功");
            return;
        }
        nodeRegisterState = 1;//正在注册


        String masterIp = getDefaultHostAddress();
        URI masterUri = URI.create("http://" + masterIp + ":11311/");
        nodeMainExecutor = DefaultNodeMainExecutor.newDefault();
        NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic(getDefaultHostAddress());
        nodeConfiguration.setMasterUri(masterUri);

        packageName = mContext.getPackageName();
        noteListenerName = packageName.replaceAll("\\.", "_");
        noteListenerName += "_robot_node_client_" + android.os.Process.myPid();
        mRobotControlNode = new RobotControlNode(noteListenerName);
        nodeMainExecutor.execute(mRobotControlNode, nodeConfiguration);

    }

    /**
     * 解析消息
     *
     * @param message           消息类型
     * @param hasNotifyListener 是否有监听事件
     */
    private void parseRobotStateMessage(RobotStateMessage message, boolean hasNotifyListener) {
    }

    private void parseRobotReceiveDataMessage(RobotByteArrayMessage message) {
        byte[] data = new byte[message.getData().capacity()];
        byte[] array = message.getData().array();
        System.arraycopy(array, message.getData().arrayOffset(), data, 0, data.length);
        notifyRobotDataListener(message.getType(), message.getFrom(), data);
    }

    private void notifyRobotDataListener(int robotStateIndex, String from, byte[] data) {
    }

    /**
     * 监听事件
     *
     * @param msg
     */
    private void handleMessage(Message msg) {
    }


    private static class BaseHandler extends Handler {
        private final WeakReference<RobotManager> mObjects;

        public BaseHandler(RobotManager mObject) {
            mObjects = new WeakReference<RobotManager>(mObject);
        }

        @Override
        public void handleMessage(Message msg) {
            try {
                RobotManager mObject = mObjects.get();
                if (mObject != null)
                    mObject.handleMessage(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class RosMasterBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (ACTION_NAME_ROS_MASTER_START.equals(action)) {
                if (nodeRegisterState == 2)
                    nodeRegisterState = 0;
                registerRosNote();
            }
        }
    }

    /**
     * 负责发送和订阅控制 机器人的任务
     */
    private class RobotControlNode extends AbstractNodeMain {

        private String nodeName;
        /**
         * 发布消息的类型
         * {@link RobotByteArrayMessage}要发布的任务类型
         */
        private Publisher<RobotByteArrayMessage> clientRobotControl;

        private final static String TOPIC_NAME_ROBOT_STATE = "robot_state";
        private final static String TOPIC_NAME_ROBOT_CONTROL = "robot_control";
        private final static String TOPIC_NAME_ROBOT_RECEIVE_DATA = "robot_receive_data";


        public RobotControlNode(String nodeName) {
            this.nodeName = nodeName;
        }

        @Override
        public GraphName getDefaultNodeName() {
            return GraphName.of(nodeName);
        }

        public boolean hasConnect() {
            return clientRobotControl != null && clientRobotControl.hasSubscribers();
        }

        public Publisher<RobotByteArrayMessage> getRobotControlClient() {
            return clientRobotControl;
        }


        @Override
        public void onStart(ConnectedNode connectedNode) {

            if (notifyRunnableArray != null && notifyRunnableArray.size() > 0) {
                for (int i = 0; i < notifyRunnableArray.size(); i++) {
                    NotifyRobotStateRunnable notifyRobotStateRunnable = notifyRunnableArray.get(notifyRunnableArray.keyAt(i));
                    if (notifyRobotStateRunnable != null)
                        notifyRobotStateRunnable.updateRobotControlNode(this);
                }
            }


            nodeRegisterState = 2;
            clientRobotControl = connectedNode.newPublisher(TOPIC_NAME_ROBOT_CONTROL, RobotByteArrayMessage._TYPE);
            if (nodeName.contains("com_efrobot_robot_test_robot_node_client")) {

                Subscriber<RobotStateMessage> subscriber = connectedNode.newSubscriber(TOPIC_NAME_ROBOT_STATE + "_test", RobotStateMessage._TYPE);
                subscriber.addMessageListener(new MessageListener<RobotStateMessage>() {

                    @Override
                    public void onNewMessage(RobotStateMessage message) {
                        parseRobotStateMessage(message, true);
                    }
                }, 1024);


                Subscriber<RobotByteArrayMessage> robotReceiveDataSubscriber = connectedNode.newSubscriber(TOPIC_NAME_ROBOT_RECEIVE_DATA + "_test", RobotByteArrayMessage._TYPE);
                robotReceiveDataSubscriber.addMessageListener(new MessageListener<RobotByteArrayMessage>() {

                    @Override
                    public void onNewMessage(RobotByteArrayMessage message) {
                        parseRobotReceiveDataMessage(message);
                    }
                }, 1024);

            } else {


                Subscriber<RobotStateMessage> subscriber = connectedNode.newSubscriber(TOPIC_NAME_ROBOT_STATE, RobotStateMessage._TYPE);
                subscriber.addMessageListener(new MessageListener<RobotStateMessage>() {

                    @Override
                    public void onNewMessage(RobotStateMessage message) {
                        parseRobotStateMessage(message, true);
                    }
                }, 1024);

                Subscriber<RobotByteArrayMessage> robotReceiveDataSubscriber = connectedNode.newSubscriber(TOPIC_NAME_ROBOT_RECEIVE_DATA, RobotByteArrayMessage._TYPE);
                robotReceiveDataSubscriber.addMessageListener(new MessageListener<RobotByteArrayMessage>() {

                    @Override
                    public void onNewMessage(RobotByteArrayMessage message) {
                        parseRobotReceiveDataMessage(message);
                    }
                }, 1024);

                long elapsedRealTime = SystemClock.elapsedRealtime();
                Log.e(TAG, "elapsedRealTime:" + elapsedRealTime / 1000 + " s");
            }

            final Subscriber<RobotStateMessage> robotInitState = connectedNode.newSubscriber(TOPIC_NAME_ROBOT_STATE + "_init", RobotStateMessage._TYPE);

            robotInitState.addMessageListener(new MessageListener<RobotStateMessage>() {
                boolean isShutDown;

                @Override
                public void onNewMessage(RobotStateMessage message) {
                    int stateIndex = message.getStateIndex();
                    Log.d(TAG, "stateIndex: " + stateIndex + " state: " + message.getState());

                    if (stateIndex == RobotStatus.ROBOT_STATE_INIT_INDEX_START) {
                        isShutDown = true;
                    } else if (stateIndex == RobotStatus.ROBOT_STATE_INIT_INDEX_END) {
                        if (isShutDown)
                            robotInitState.shutdown();

                        if (mOnInitCompleteListener != null)
                            mOnInitCompleteListener.onInitComplete(ResultCode.success);
                    } else {
                        parseRobotStateMessage(message, false);
                    }
                }
            }, 1024);
        }

        /**
         * 发布任务
         *
         * @param type
         * @param data
         */
        public void publish(int type, byte[] data) {
            if (clientRobotControl == null) {
                Log.d(TAG, "clientRobotControl == null");
                return;
            }
            RobotByteArrayMessage robotControlMessage = clientRobotControl.newMessage();

            ChannelBuffer buffer = HeapChannelBufferFactory.getInstance(ByteOrder.LITTLE_ENDIAN).getBuffer(data, 0, data.length);

            robotControlMessage.setType(type);
            robotControlMessage.setFrom(packageName);
            robotControlMessage.setData(buffer);
            clientRobotControl.publish(robotControlMessage);
        }
    }

    private SparseArray<NotifyRobotStateRunnable> notifyRunnableArray = new SparseArray<NotifyRobotStateRunnable>();

    public class NotifyRobotStateRunnable implements Runnable {

        private static final long NOTIFY_TIME = 500;

        private boolean isNotify = true;
        private int robotStateIndex;
        private int notifyState;
        private RobotControlNode mNotifyNode;

        public NotifyRobotStateRunnable(RobotControlNode mNotifyNode, int robotStateIndex, int notifyState) {
            this.mNotifyNode = mNotifyNode;
            this.robotStateIndex = robotStateIndex;
            this.notifyState = notifyState;
        }

        public void updateRobotControlNode(RobotControlNode mNotifyNode) {
            this.mNotifyNode = mNotifyNode;
        }

        @Override
        public void run() {
            while (true) {
                if (!isNotify) break;

                Publisher<RobotByteArrayMessage> robotControlClient = mNotifyNode.getRobotControlClient();

                if (robotControlClient == null) {
                    Log.d(TAG, "clientRobotControl == null");
                    return;
                }


                byte[] data = new byte[8];
                data[0] = ((byte) (robotStateIndex >> 24));
                data[1] = ((byte) (robotStateIndex >> 16));
                data[2] = ((byte) (robotStateIndex >> 8));
                data[3] = ((byte) (robotStateIndex));


                data[4] = ((byte) (notifyState >> 24));
                data[5] = ((byte) (notifyState >> 16));
                data[6] = ((byte) (notifyState >> 8));
                data[7] = ((byte) (notifyState));

                if (!isNotify) break;

                RobotByteArrayMessage robotControlMessage = robotControlClient.newMessage();

                ChannelBuffer buffer = HeapChannelBufferFactory.getInstance(ByteOrder.LITTLE_ENDIAN).getBuffer(data, 0, data.length);

                if (!isNotify) break;

                robotControlMessage.setType(RobotByteArrayMessage.TASK_TYPE_NOTIFY_ROBOT_STATE);
                robotControlMessage.setFrom(packageName);
                robotControlMessage.setData(buffer);


                if (!isNotify) break;


                robotControlClient.publish(robotControlMessage);

                SystemClock.sleep(NOTIFY_TIME);

            }
        }
    }
}
