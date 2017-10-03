package com.acme.edu;

public interface MetaMessage {
    //void setContent();
    String getContent();
    void filter(MetaMessage message);
    void flushBuffer();
}
