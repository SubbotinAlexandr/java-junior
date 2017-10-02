package com.acme.edu;

public interface MetaMessage {
    void setContent(int message);
    int getContent();
    void filter(MetaMessage message);
}
