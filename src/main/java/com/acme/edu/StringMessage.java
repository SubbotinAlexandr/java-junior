package com.acme.edu;

public class StringMessage implements MetaMessage {
    String content;
    String prevContent;
    String coefficient;
    String countBorderVal;

    public StringMessage(String message) {

    }

    //    public void setContent() {
//
//    }
    public String getContent() {
        return "123";
    }
    public void filter(MetaMessage message) {

    }

    public void flushBuffer() {

    }
}
