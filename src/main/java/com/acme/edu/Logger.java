package com.acme.edu;

import static com.acme.edu.Logger.logString;

public class Logger {
    public static int sum;
    public static int countMaxVal;
    public static int countMinVal;
    /*
    Пишем свой логгер
     */
    private final static String primitive = "primitive: ";

    public static void log(int message) {
        print(message);
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
    }

    public static void log(byte message) {              //Также можно просто снести этот
        print(message);
    }

    public static void log(boolean message)
    {
        System.out.println(message ? primitive + "true" : primitive + "false");
    }

    public static void log(char message){
        System.out.println("char: " + message);
    }

    public static void log(String message){
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
