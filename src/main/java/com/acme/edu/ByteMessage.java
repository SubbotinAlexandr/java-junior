package com.acme.edu;

public class ByteMessage implements MetaMessage{
    int content;
    int prevContent;
    int coefficient;
    int countBorderVal;
    int numBorder;
    int sum;
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
            message.filter(message);
            //System.out.println(Formatter.getFormatMessage(message));
            return;
        }
        if(message == this) {
            System.out.println(Formatter.getFormatMessage(message));
            ((ByteMessage) message).sum = this.content;
            return;
        }
        System.out.println(Formatter.getFormatMessage(message));
        //System.out.print("PrevMSG:" + this.content + " MSG:" + ((ByteMessage)message).content + " ");
        this.numBorder = this.sum < 0 ? Byte.MIN_VALUE : Byte.MAX_VALUE;
        this.coefficient = this.sum < 0 ? -1 : 1;
        summOverflow(((ByteMessage)message).content, this.numBorder);
        ((ByteMessage) message).sum = this.sum;
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
        System.out.println(this.sum);
    }

    private void summOverflow (int message, int BORDER_VALUE) {
        this.coefficient = message < 0 ? -1 : 1;
        if(checkOverflow((long)message, (long)BORDER_VALUE, coefficient)) {
            this.sum = this.sum * coefficient < message * coefficient ? message - BORDER_VALUE + this.sum  : this.sum - BORDER_VALUE + message ;
        }
        else {
            if ((this.sum + message > 0) && countBorderVal < 0) {
                this.sum = this.sum + BORDER_VALUE - message;
                countBorderVal++;
            } else if ((this.sum + message < 0) && countBorderVal > 0) {
                this.sum = this.sum + BORDER_VALUE - message;
                countBorderVal--;
            }
            else  this.sum = this.sum + message;
        }
    }

    private boolean checkOverflow (long message, long BORDER_VALUE, int coefficient) {
        long numBorder = BORDER_VALUE * coefficient;
        message = coefficient * message;
        if ( this.sum * coefficient > 0 && message > 0 && ( numBorder - message < this.sum * coefficient) ) {
            this.countBorderVal += coefficient;
            return true;
        }
        else {
            return false;
        }
    }
}
