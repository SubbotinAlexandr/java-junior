package com.acme.edu;

public class MetaMessage {
    private Object messageContent;
    private LoggerState typeMessage;
    MetaMessage newMsg;
    public MetaMessage(byte message) {
        messageContent = message;
        typeMessage = LoggerState.byteState;
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
    public Object getMessage (MetaMessage message) {
        return message.messageContent;
    }
    public LoggerState getTypeMessage (MetaMessage message) {
        return message.typeMessage;
    }
}
