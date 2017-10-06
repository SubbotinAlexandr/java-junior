package com.acme.edu;

public class PrintException  extends Exception {

    public PrintException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrintException(Throwable cause) {
        super(cause);
    }
}
