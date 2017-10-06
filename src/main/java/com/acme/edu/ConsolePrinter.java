package com.acme.edu;

import java.io.IOException;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String message) throws PrintException {
        throw new PrintException(new IOException("NO!"));
        //    System.out.println(message);
    }
}
