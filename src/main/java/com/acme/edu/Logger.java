package com.acme.edu;

import static com.acme.edu.Logger.logString;

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
    private final static String primitive = "primitive: ";

    public static void log(int message) {
        print(message);
        state = 3;
    }

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
        if(state == 1)
        {
            System.out.println(prevMessage + " (x" + countRepeatString + ")");
            countRepeatString = 0;
        }
    }

    public static void log(byte message) {              //Также можно просто снести этот
        print(message);
        if(state == 1)
        {
            System.out.println(prevMessage + "(x" + countRepeatString + ")");
            countRepeatString = 0;
        }
        state = 2;
    }

    public static void log(boolean message)
    {
        System.out.println(message ? primitive + "true" : primitive + "false");
        state = 6;
    }

    public static void log(char message){
        System.out.println("char: " + message);
        state = 5;
    }

    public static void log(String message){
        if(message != prevMessage) {
            countRepeatString = 0;
        }
        countRepeatString++;
        prevMessage = message;
        state = 1;
        System.out.println("string: " + message);
        System.out.println(sum);
        sum = 0;
    }

    public static void logString(String message){
        System.out.println(message);
    }

    public static void main(String[] args) {
        String i1 = new String("2");
        String i2 = null;
        //i2.equals("2");
        switch (i1) {
            case "2":
                System.out.println("a");
                break;
            case "b":
                System.out.println("a");
                break;
        }
        if(1+Integer.MAX_VALUE > Integer.MAX_VALUE ){
            System.out.println("shlyapa");
        } else {
            System.out.println("all ok!");
        }
        System.out.println("Hello!!!");
        logString("Hw!!!!!");
        System.out.println(Integer.MAX_VALUE + Integer.MIN_VALUE);
    }
}
