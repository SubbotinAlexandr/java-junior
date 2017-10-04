package com.acme.edu;

public class CharMessage implements MetaMessage {
    char content;

    public CharMessage(char message) {
        this.content = message;
    }

    @Override
    public void filter(MetaMessage message) {
        if(!(message instanceof CharMessage)) {
            this.flushBuffer();
            printer.print(Formatter.getFormatMessage(message));
            return;
        }
        printer.print(Formatter.getFormatMessage(message));
    }

    @Override
    public void flushBuffer() {
        return;
    }

}
