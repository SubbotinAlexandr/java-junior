package com.acme.edu;

public class CharMessage implements MetaMessage {
    char content;
    public String getContent() {
        return "";
    }
    public void filter(MetaMessage message) {
        if(!(message instanceof CharMessage)) {
            this.flushBuffer();
            System.out.println(Formatter.getFormatMessage(message));
            return;
        }
        System.out.println(Formatter.getFormatMessage(message));
    }
    public void flushBuffer() {
        return;
    }
    public CharMessage (char message) {
        this.content = message;

    }
}
