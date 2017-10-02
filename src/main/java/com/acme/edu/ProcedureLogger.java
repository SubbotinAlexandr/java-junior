package com.acme.edu;


public class ProcedureLogger {
    private static int sum;
    private static int countBorderVal;
    private static int countRepeatString;
    private static String prevMessage;
    private final static String primitiveType = "primitive: ";
    private final static String stringType = "string: ";
    private final static String charType = "char: ";
    private final static String arrayType = "primitives array: ";
    //private static byte state; // 0 - none, 1 - string, 2 - byte, 3 - int, 4 - array, 5 - char, 6 - boolean
    private static LoggerState state = LoggerState.noneState;
    /*
    Пишем свой логгер
     */
    public static void FlushBuffer()
    {
        CheckChangeState(LoggerState.noneState);
    }

    private static void CheckChangeState(LoggerState currentState) {
        if(currentState != state) {
            switch (state) {
                case stringState:
                    prevMessage =  stringType + prevMessage;
                    if(countRepeatString > 1)
                        prevMessage = prevMessage + " (x" + countRepeatString + ")";
                    Printer.printToConsole(prevMessage);
                    countRepeatString = 0;
                    break;
                case byteState:
                    while (countBorderVal != 0) {
                        System.out.println(countBorderVal < 0 ? Byte.MIN_VALUE : Byte.MAX_VALUE);
                        countBorderVal = countBorderVal < 0 ? countBorderVal + 1 : countBorderVal - 1;
                    }
                    Printer.printToConsole("" + sum);
                    break;
                case intState:
                    while (countBorderVal != 0) {
                        System.out.println(countBorderVal < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE);
                        countBorderVal = countBorderVal < 0 ? countBorderVal + 1 : countBorderVal - 1;
                    }
                    Printer.printToConsole("" + sum);
                    break;
            }
        }
    }



    private static boolean checkOverflow (Object message, Object BORDER_VALUE, int coefficient) {
        long numBorder = Long.parseLong(BORDER_VALUE.toString());

        numBorder = numBorder * coefficient;
        long numMessage = coefficient * Long.parseLong(message.toString());
        if ( sum * coefficient > 0 && numMessage > 0 && ( numBorder - numMessage < sum * coefficient) ) {
            countBorderVal += coefficient < 0 ? -1 : 1;
            return true;
        }
        return false;
    }

    private static void summOverflow (Object message, Object BORDER_VALUE) {
        int numMessage = Integer.parseInt(message.toString());
        int numBorder = Integer.parseInt(BORDER_VALUE.toString());
        int coefficient = numBorder < 0 ? -1 : 1;
        if(checkOverflow(message, BORDER_VALUE, coefficient)) {
            sum = sum * coefficient < numMessage * coefficient ? numMessage - numBorder + sum  : sum - numBorder + numMessage ;
        }
        else {
            if ((sum + numMessage > 0) && countBorderVal < 0) {
                sum = sum + numBorder - numMessage;
                countBorderVal++;
            } else if ((sum + numMessage < 0) && countBorderVal > 0) {
                sum = sum + numBorder - numMessage;
                countBorderVal--;
            }
            else  sum = sum + numMessage;
        }
    }

    private static void print(int message) {
        Printer.printToConsole(primitiveType + message);
    }

    public static void log(int message) {
        summOverflow(message, message < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE);
        CheckChangeState(LoggerState.intState);
        print(message);
        state = LoggerState.intState;
    }

    public static void log(byte message) {              //Также можно просто снести этот
        summOverflow(message, message < 0 ? Byte.MIN_VALUE : Byte.MAX_VALUE);
        CheckChangeState(LoggerState.byteState);
        print(message);
        state = LoggerState.byteState;
    }

    public static void log(boolean message)
    {
        Printer.printToConsole(message ? primitiveType + "true" : primitiveType + "false");
        CheckChangeState(LoggerState.booleanState);
        state = LoggerState.booleanState;
    }

    public static void log(char message){
        Printer.printToConsole(charType + message);
        CheckChangeState(LoggerState.charState);
        state = LoggerState.charState;
    }

    public static void log(String message){
        if(!message.equals(prevMessage)) {
            FlushBuffer();
            countRepeatString = 0;
        }
        countRepeatString++;
        prevMessage = message;
        CheckChangeState(LoggerState.stringState);
        state = LoggerState.stringState;
    }

    public static void log(int [] message)
    {
        System.out.print(arrayType + "{");
        for (int i = 0; i < message.length - 1; i++) {
            System.out.print(message[i] + ", ");
        }
        Printer.printToConsole(message[message.length - 1] + "}");
    }

    private static void logString(String message){
        Printer.printToConsole(message);
    }

    public static void main(String[] args) {
    }
}
