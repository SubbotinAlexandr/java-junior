package com.acme.edu;

import static com.acme.edu.Logger.logString;

public class Logger {
    /*
    Пишем свой логгер
     */
    private final static String primitive = "primitive: ";

    public static void log(int message) {
        print(message);
    }

    private static void print(int message) {
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
    }

    public static void logString(String message){
        System.out.println(message);
    }

    public static void main(String[] args) {
        System.out.println("Hello!!!");
        logString("Hw!!!!!");
    }
}
