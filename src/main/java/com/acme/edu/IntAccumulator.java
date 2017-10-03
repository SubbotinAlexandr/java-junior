package com.acme.edu;

public class IntAccumulator implements Accumulator {
    int message;
    int borderValue;
    public void additition (MetaMessage message, MetaMessage borderValue) {
       // LoggerController.message.setContent(LoggerController.message.getContent() + message.getContent());
        //this.borderValue = borderValue.getContent();
    }

//    private static boolean checkOverflow (int message, int BORDER_VALUE, int coefficient) {
//        int numBorder = Long.parseLong(BORDER_VALUE.toString());
//
//        numBorder = numBorder * coefficient;
//        long numMessage = coefficient * Long.parseLong(message.toString());
//        if ( sum * coefficient > 0 && numMessage > 0 && ( numBorder - numMessage < sum * coefficient) ) {
//            countBorderVal += coefficient < 0 ? -1 : 1;
//            return true;
//        }
//        return false;
//    }
}
