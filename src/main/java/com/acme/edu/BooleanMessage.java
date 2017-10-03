package com.acme.edu;

public class BooleanMessage implements MetaMessage {
    public boolean content;
    public BooleanMessage(boolean message) {
        this.content = message;
    }

    public String getContent() {
        return "";
    }
    public void filter(MetaMessage message) {
        if(!(message instanceof BooleanMessage)) {
            //this.countRepeat = -1;
            this.flushBuffer();
            message.filter(message);
            //System.out.println(Formatter.getFormatMessage(message));
            return;
        } else if (message != this) {
            this.flushBuffer();
        }
    }
    public void flushBuffer() {
        System.out.println(Formatter.getFormatMessage(this));
    }
}
