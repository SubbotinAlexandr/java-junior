package com.acme.edu;

public class StringMessage implements MetaMessage {
    String content;
    String prevContent;
    String coefficient;
    int countRepeat;

    public StringMessage(String message) {
        this.countRepeat++;
        this.content = message;
    }

    //    public void setContent() {
//
//    }
    public String getContent() {
        return "123";
    }
    public void filter(MetaMessage message) {
        if(!(message instanceof StringMessage)) {
            //this.countRepeat = -1;
            this.flushBuffer();
            message.filter(message);
            this.countRepeat++;
            //System.out.println(Formatter.getFormatMessage(message));
            return;
        }
        if(message == this) {
            //this.flushBuffer();
            return;
            //System.out.println(Formatter.getFormatMessage(message));
            //((StringMessage) message).countRepeat++;
        } else if (this.content.equals(((StringMessage) message).content) && this != message) {
            ((StringMessage) message).countRepeat = this.countRepeat+1;
        } else this.flushBuffer();
    }

    public void flushBuffer() {
        System.out.println(Formatter.getFormatMessage(this));
        //System.out.println(Formatter.getFormatMessage(message));
    }
}
