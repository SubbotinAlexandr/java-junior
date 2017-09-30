package com.acme.edu;


public class ProcedureLogger {
    private static int sum;
    private static int countMaxVal;
    private static int countMinVal;
    private static int countBorderVal;
    private static int countRepeatString;
    private static String prevMessage;
    private static byte state; // 0 - none, 1 - string, 2 - byte, 3 - int, 4 - array, 5 - char, 6 - boolean
    /*
    Пишем свой логгер
     */
    public static void FlushBuffer()
    {
        CheckChangeState(0);
    }

    private static void CheckChangeState(int currentState) {
        if(currentState != state) {
            switch (state) {
                case 1:
                    Printer.printToConsole(prevMessage + " (x" + countRepeatString + ")");
                    countRepeatString = 0;
                    break;
                case 2:
                    break;
            }
        }
    }

    private final static String primitive = "primitive: ";

    private static boolean checkOverflow (Object message, Object BORDER_VALUE) {
        long numBorder = Long.parseLong(BORDER_VALUE.toString());
        int coefficient = numBorder < 0 ? -1 : 1;
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
        if(checkOverflow(message, BORDER_VALUE))
            sum = sum < numMessage ? numMessage - sum : sum - numMessage;
        else sum = sum + numMessage;
    }

    private static void print(int message) {
        Printer.printToConsole(primitive + message);
    }

    public static void log(int message) {
        summOverflow(message, message < 0 ? Integer.MIN_VALUE : Integer.MIN_VALUE);
        print(message);
        CheckChangeState(3);
        state = 3;
    }

    public static void log(byte message) {              //Также можно просто снести этот
        print(message);
        CheckChangeState(2);
        state = 2;
    }

    public static void log(boolean message)
    {
        Printer.printToConsole(message ? primitive + "true" : primitive + "false");
        CheckChangeState(6);
        state = 6;
    }

    public static void log(char message){
        Printer.printToConsole("char: " + message);
        CheckChangeState(5);
        state = 5;
    }

    public static void log(String message){
        if(!message.equals(prevMessage)) {
            countRepeatString = 0;
        }
        countRepeatString++;
        prevMessage = message;
        CheckChangeState(1);
        state = 1;
        Printer.printToConsole("string: " + message);
        System.out.println(sum);
        sum = 0;
    }

    public static void log(int [] message)
    {
        System.out.print("primitives array: {");
        for (int i = 0; i < message.length - 1; i++) {
            System.out.print(message[i] + ", ");
        }
        Printer.printToConsole(message[message.length - 1] + "}");
    }

    private static void logString(String message){
        Printer.printToConsole(message);
    }

    public static void main(String[] args) {
        ProcedureLogger.log(1);
        ProcedureLogger.log(2);
        ProcedureLogger.log("str");
        ProcedureLogger.log(2);
        ProcedureLogger.log(2);
        ProcedureLogger.FlushBuffer();
    }
}
