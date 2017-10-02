package com.acme.edu;

public class IntMessage implements MetaMessage {
    int content;
    int coefficient;
    int countBorderVal;
    int numBorder;
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
        this.numBorder = message.getContent() < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        this.coefficient = message.getContent() < 0 ? -1 : 1;
        if(checkOverflow(message.getContent(), this.numBorder, this.coefficient))
            System.out.println("Overload! " + message.getContent());
        else
        {
            this.setContent(this.getContent() + message.getContent());
            System.out.println("No Overload! " + message.getContent());
        }
    }

    private boolean checkOverflow (int message, int BORDER_VALUE, int coefficient) {
        BORDER_VALUE = BORDER_VALUE * coefficient;
        message = coefficient * message;
        if ( this.content * coefficient > 0 && message > 0 && ( BORDER_VALUE - message < this.content * coefficient) ) {
            this.countBorderVal += coefficient;
            return true;
        }
        return false;
    }

}
