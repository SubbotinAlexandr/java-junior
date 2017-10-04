package com.acme.edu;

public class IntArrayMessage implements MetaMessage {
    int [] content;
    public IntArrayMessage(int[] message) {
            content = message;
    }
    @Override
    public void filter(MetaMessage message) {
        if(!(message instanceof IntArrayMessage)) {
            this.flushBuffer();
            message.filter(message);
            return;
        } else if (message != this) {
            this.flushBuffer();
        }
    }
    @Override
    public void flushBuffer() {
        printer.print(Formatter.getFormatMessage(this));
    }
}
