package com.acme.edu;

public class ByteMessage implements MetaMessage{
    int content;
    int prevContent;
    int coefficient;
    int countBorderVal;
    int numBorder;
    ByteMessage newContent;

    public ByteMessage (byte message) {
        this.prevContent = this.content;
        this.content = message;

        //System.out.println("prev.content" + this.prevContent);
    }
    public void setContent(int message) {
        this.content = message;
    }
    @Override
    public String getContent() {
        return "" + this.content;
    }

    public void filter(MetaMessage message) {
        if(!(message instanceof ByteMessage)) {
            this.flushBuffer();
            System.out.println(Formatter.getFormatMessage(message));
            return;
        }
        if(message == this) {
            System.out.println(Formatter.getFormatMessage(message));
            return;
        }
        System.out.println(Formatter.getFormatMessage(message));
        //System.out.print("PrevMSG:" + this.content + " MSG:" + ((ByteMessage)message).content + " ");
        this.numBorder = this.content < 0 ? Byte.MIN_VALUE : Byte.MAX_VALUE;
        this.coefficient = this.content < 0 ? -1 : 1;
        summOverflow(((ByteMessage)message).content, this.numBorder);
        ((ByteMessage) message).content = this.content;
        ((ByteMessage) message).countBorderVal = this.countBorderVal;

        //System.out.println("summ = " + ((ByteMessage) message).content + System.lineSeparator() + "numBorder: " + this.countBorderVal);
    }

    public void flushBuffer() {
        this.coefficient = this.countBorderVal < 0 ?  1 : -1;
        this.numBorder = this.countBorderVal < 0 ? Byte.MIN_VALUE : Byte.MAX_VALUE;
        while (this.countBorderVal!=0) {
            System.out.println(this.numBorder);
            this.countBorderVal += this.coefficient;
        }
        System.out.println(this.content);
    }

    private void summOverflow (int message, int BORDER_VALUE) {
        this.coefficient = message < 0 ? -1 : 1;
        if(checkOverflow((long)message, (long)BORDER_VALUE, coefficient)) {
            this.content = this.content * coefficient < message * coefficient ? message - BORDER_VALUE + this.content  : this.content - BORDER_VALUE + message ;
        }
        else {
            if ((this.content + message > 0) && countBorderVal < 0) {
                this.content = this.content + BORDER_VALUE - message;
                countBorderVal++;
            } else if ((this.content + message < 0) && countBorderVal > 0) {
                this.content = this.content + BORDER_VALUE - message;
                countBorderVal--;
            }
            else  this.content = this.content + message;
        }
    }

    private boolean checkOverflow (long message, long BORDER_VALUE, int coefficient) {
        long numBorder = BORDER_VALUE * coefficient;
        message = coefficient * message;
        if ( this.content * coefficient > 0 && message > 0 && ( numBorder - message < this.content * coefficient) ) {
            this.countBorderVal += coefficient;
            return true;
        }
        else {
            return false;
        }
    }
}
