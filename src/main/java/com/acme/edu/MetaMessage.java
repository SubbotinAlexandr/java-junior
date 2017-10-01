package com.acme.edu;

public class MetaMessage {
    public Object messageContent;
    public LoggerState typeMessage;
    MetaMessage newMsg;
    public MetaMessage(byte message) {
        messageContent = message;
        typeMessage = LoggerState.byteState;
    }
    public MetaMessage(int message) {
        messageContent = message;
        typeMessage = LoggerState.intState;
    }
    public MetaMessage(boolean message) {
        messageContent = message;
        typeMessage = LoggerState.booleanState;
    }
    public MetaMessage(char message) {
        messageContent = message;
        typeMessage = LoggerState.charState;
    }
    public MetaMessage(String message) {
        messageContent = message;
        typeMessage = LoggerState.stringState;
    }
    public MetaMessage(int [] message) {
        messageContent = message;
        typeMessage = LoggerState.arrayIntState;
    }
    public MetaMessage(Object message) {                  //Также несбывшаяся мечта!
        messageContent = message.toString();
        System.out.println("msg: " + message.getClass());
        typeMessage = LoggerState.arrayIntState;
    }
    public Object getMessage (MetaMessage message) {
        return message.messageContent;
    }
    public LoggerState getTypeMessage (MetaMessage message) {
        return message.typeMessage;
    }
}
