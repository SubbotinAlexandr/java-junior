package com.acme.edu;

public class IntArrayMessage implements MetaMessage {
    int [] content;
    public IntArrayMessage(int[] message) {
            content = message;
    }

    public String getContent() {
        return "";
    }
    public void filter(MetaMessage message) {
        if(!(message instanceof IntArrayMessage)) {
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
