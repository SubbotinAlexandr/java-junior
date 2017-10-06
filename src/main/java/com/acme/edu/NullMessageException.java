package com.acme.edu;

public class NullMessageException extends Exception {

    public NullMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullMessageException(Throwable cause) {
        super(cause);
    }
}
