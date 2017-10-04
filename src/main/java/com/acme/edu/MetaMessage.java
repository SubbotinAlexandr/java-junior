package com.acme.edu;

public interface MetaMessage {
    void filter(MetaMessage message);
    void flushBuffer();
}
