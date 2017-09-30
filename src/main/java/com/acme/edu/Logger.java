package com.acme.edu;

public class Logger {
    private static int sum;
    private static int countMaxVal;
    private static int countMinVal;
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
                    System.out.println(prevMessage + " (x" + countRepeatString + ")");
                    countRepeatString = 0;
                    break;
            }
        }
    }

    private final static String primitive = "primitive: ";

    private static void print(int message) {
        if(sum > 0 && message > 0 && (Integer.MAX_VALUE - message < sum) ) {
            if(countMinVal > 0) {
                countMinVal--;
            } else {
                countMaxVal++;
            }
            if(sum < message){
                sum = message - sum;
            } else {
                sum = sum - message;
            }
        }
        if( sum < 0 && message < 0 && (Integer.MIN_VALUE - message > sum)) {
            if(countMaxVal > 0)
            {
                countMaxVal--;
            }  else {
                countMinVal++;
            }
            if(sum > message){
                sum = sum - message;
            } else {
                sum = message - sum;
            }
        }
        else
            sum = sum + message;
        System.out.println(primitive + message);
    }

    public static void log(int message) {
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
        System.out.println(message ? primitive + "true" : primitive + "false");
        CheckChangeState(6);
        state = 6;
    }

    public static void log(char message){
        System.out.println("char: " + message);
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
        System.out.println("string: " + message);
        System.out.println(sum);
        sum = 0;
    }

    public static void log(int [] message)
    {
        System.out.print("primitives array: {");
        for (int i = 0; i < message.length - 1; i++) {
            System.out.print(message[i] + ", ");
        }
        System.out.println(message[message.length - 1] + "}");
    }

    private static void logString(String message){
        System.out.println(message);
    }

    public static void main(String[] args) {
    }
}
