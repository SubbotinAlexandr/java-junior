package com.acme.edu;

import java.io.IOException;

public class BooleanMessage implements MetaMessage {
    public boolean content;

    public BooleanMessage(boolean message) {
        this.content = message;
    }

    @Override
    public void filter(MetaMessage message) throws PrintException {
        if(!(message instanceof BooleanMessage)) {
            try {
                this.flushBuffer();
            } catch (IOException e) {
                e.printStackTrace();
            }
            message.filter(message);
        } else if (message != this) {
            try {
                this.flushBuffer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void flushBuffer() throws PrintException, IOException {
        printer.print(Formatter.getFormatMessage(this));
    }
}
