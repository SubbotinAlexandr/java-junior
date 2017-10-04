package com.acme.edu;

/**
 *      Класс IntMessage - это реализация сообщения для сообщений типов int.
 *
 */

public class IntMessage implements MetaMessage {
    int content;
    private int sum;
    private int coefficient;
    private int countBorderVal;
    private int numBorder;

    public IntMessage(int message) {
        this.content = message;
    }
    @Override
    public void filter(MetaMessage message) {
        if (!(message instanceof IntMessage)) {
            this.flushBuffer();
            message.filter(message);
            return;
        }
        if (message == this) {
            printer.print(Formatter.getFormatMessage(message));
            ((IntMessage) message).sum = this.content;
            return;
        }
        printer.print(Formatter.getFormatMessage(message));
        this.numBorder = this.content < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        this.coefficient = this.sum < 0 ? -1 : 1;
        summOverflow(((IntMessage)message).content, this.numBorder);
        ((IntMessage) message).sum = this.sum;
        ((IntMessage) message).countBorderVal = this.countBorderVal;
    }
    @Override
    public void flushBuffer() {
        this.coefficient = this.countBorderVal < 0 ?  1 : -1;
        this.numBorder = this.countBorderVal < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        while (this.countBorderVal!=0) {
            printer.print("" + this.numBorder);
            this.countBorderVal += this.coefficient;
        }
        printer.print("" + this.sum);
    }

    private void summOverflow(int message, int BORDER_VALUE) {
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

    private boolean checkOverflow(long message, long BORDER_VALUE, int coefficient) {
        long numBorder = BORDER_VALUE * coefficient;
        message = coefficient * message;
        if (this.content * coefficient > 0 && message > 0 && (numBorder - message < this.content * coefficient)) {
            this.countBorderVal += coefficient;
            return true;
        }
        else {
            return false;
        }
    }

    private static int getCoefficientBySign(int number) {
        return number < 0 ? -1 : 1;
    }

}
