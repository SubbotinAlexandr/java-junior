package com.acme.edu;

public class BooleanMessage implements MetaMessage {
    public boolean content;
    public BooleanMessage(boolean message) {
        this.content = message;
    }

    public void filter(MetaMessage message) {
        if(!(message instanceof BooleanMessage)) {
            this.flushBuffer();
            message.filter(message);
            return;
        } else if (message != this) {
            this.flushBuffer();
        }
    }
    public void flushBuffer() {
        System.out.println(Formatter.getFormatMessage(this));
    }
}
