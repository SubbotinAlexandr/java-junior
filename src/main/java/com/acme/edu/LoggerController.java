package com.acme.edu;

import sun.rmi.runtime.Log;

public class LoggerController {
    public static LoggerState state = LoggerState.noneState;
    public static MetaMessage message;
    public static MetaMessage PrevMessage;
    public LoggerController (MetaMessage message) {
        if (message != null && this.message != null) {
            //this.message = message;
            this.message.filter(message);
        }
        this.message = message;
        //System.out.println("call loggercontroller " + message.getContent());

    }
    public void setController() {

    }
    public void getBuff () {
        //System.out.println(message.getContent());
    }
}
