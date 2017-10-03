package com.acme.edu;

public class LoggerController {
    public MetaMessage message;
    public static MetaMessage PrevMessage;
//    public LoggerController (MetaMessage message) {
//        if (message != null && this.message != null) {
//            //this.message = message;
//            this.message.filter(message);
//        }
//        this.message = message;
//        //System.out.println("call loggercontroller " + message.getContent());
//
//    }
//    public LoggerController() {
//
//    }

    public void setController(MetaMessage message) {
        if(this.message == null && message != null) {
            message.filter(message);
        }
        if (message != null && this.message != null) {
            //this.message = message;
            this.message.filter(message);
        }
        this.message = message;
    }

    public void getBuff () {
        //System.out.println(message.getContent());
    }
    public void flushBuffer () {
        this.message.flushBuffer();
    }
}
