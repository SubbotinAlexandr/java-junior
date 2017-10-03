package com.acme.edu;

public class CharMessage implements MetaMessage {
    char content;
    public String getContent() {
        return "";
    }
    public void filter(MetaMessage message) {
        System.out.println(Formatter.getFormatMessage(this));
    }
    public void flushBuffer() {
        filter(this);
    }
    public CharMessage (char message) {
        this.content = message;

    }
}
