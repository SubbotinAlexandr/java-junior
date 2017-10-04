package com.acme.edu;

public class BooleanMessage implements MetaMessage {
    public boolean content;
    public BooleanMessage(boolean message) {
        this.content = message;
    }
    @Override
    public void filter(MetaMessage message) {
        if(!(message instanceof BooleanMessage)) {
            this.flushBuffer();
            message.filter(message);
        } else if (message != this) {
            this.flushBuffer();
        }
    }
    @Override
    public void flushBuffer() {
        printer.print(Formatter.getFormatMessage(this));
    }
}
