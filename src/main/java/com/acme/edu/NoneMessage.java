package com.acme.edu;

public class NoneMessage implements MetaMessage {
    public String getContent() {
        return "none";
    }
    public void filter(MetaMessage message) {
        return;
    }
    public void flushBuffer() {
        return;
    }
    public NoneMessage() {
        System.out.println("eee");
    }
}
