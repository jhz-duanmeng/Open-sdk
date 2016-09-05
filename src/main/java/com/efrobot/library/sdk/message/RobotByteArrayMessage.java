package com.efrobot.library.sdk.message;


import org.jboss.netty.buffer.ChannelBuffer;
import org.ros.internal.message.Message;

public interface RobotByteArrayMessage extends Message {

    int TASK_TYPE_TASK = 0;
    int TASK_TYPE_TASK_GROUP = 1;
    int TASK_TYPE_TASK_GROUP_DANCE = 2;
    int TASK_ROBOT_CONTROL = 3;
    int TASK_TYPE_PROJECTOR = 4;
    int TASK_TYPE_NAVIGATION = 5;
    int TASK_TYPE_CHARGING_PILE = 6;
    int TASK_TYPE_CONTROL_DWA = 7;
    int TASK_TYPE_CUSTOM = 100;
    int TASK_TYPE_NOTIFY_ROBOT_STATE = 101;

    int TASK_TYPE_INFRARED = 102;//红外任务
    int TASK_TYPE_SPEECH = 103;//语音指令

    String _TYPE = "com/efrobot/library/message/RobotByteArrayMessage";
    String _DEFINITION = "int32 type\nbyte[] data\nstring from\n";


    int getType();

    void setType(int type);

    ChannelBuffer getData();

    void setData(ChannelBuffer data);

    String getFrom();

    void setFrom(String from);

}
