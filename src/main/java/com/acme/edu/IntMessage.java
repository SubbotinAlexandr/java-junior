package com.acme.edu;

public class IntMessage implements MetaMessage {
    int content;
    Accumulator accumulator;
    public IntMessage (int message) {
        this.content = message;
    }
    public void setContent(int message) {
        this.content = message;
    }
    public int getContent() {
        return this.content;
    }
    public void filter(MetaMessage message) {
        this.setContent(this.getContent() + message.getContent());
        System.out.println("func in int filter: " + message.getContent() + " this: " + this.getContent());
        //LoggerController.message.setContent(LoggerController.message.getContent() + this.content);
        //LoggerController.state = LoggerState.intState;
        //LoggerController.message = this;
    }

}
