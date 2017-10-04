package com.acme.edu;

public class StringMessage implements MetaMessage {
    String content;
    int countRepeat;

    public StringMessage(String message) {
        this.countRepeat++;
        this.content = message;
    }

    public void filter(MetaMessage message) {
        if(!(message instanceof StringMessage)) {
            this.flushBuffer();
            message.filter(message);
            this.countRepeat++;
            return;
        }
        if (this.content.equals(((StringMessage) message).content) && this != message) {
            ((StringMessage) message).countRepeat = this.countRepeat + 1;
        } else if (message != this) {
            this.flushBuffer();
        }
    }

    public void flushBuffer() {
        printer.print(Formatter.getFormatMessage(this));
    }
}
