package com.efrobot.library.sdk.message;


import org.ros.internal.message.Message;

public interface RobotStateMessage extends Message {

    String _TYPE = "com/efrobot/library/message/RobotStateMessage";
    String _DEFINITION = "int32 stateIndex\nint32 state\n";


    int getStateIndex();

    void setStateIndex(int stateIndex);

    int getState();

    void setState(int state);


}
