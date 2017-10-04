package com.acme.edu;

public class LoggerController {
    private MetaMessage message;
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

    public void flushBuffer () {
        this.message.flushBuffer();
    }
}
