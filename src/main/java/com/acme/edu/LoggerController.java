package com.acme.edu;

public class LoggerController {
    public static LoggerState state = LoggerState.noneState;
    public static MetaMessage message;
    public LoggerController (MetaMessage message) {
        if (this.message == null)
            this.message = new IntMessage(0);
        this.message.filter(message);
        //this.message = message;
        //System.out.println("call loggercontroller " + message.getContent());

    }
    public void getBuff () {
        //System.out.println(message.getContent());
    }
}
