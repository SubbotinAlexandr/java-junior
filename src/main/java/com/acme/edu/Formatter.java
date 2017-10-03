package com.acme.edu;

public class Formatter {
    private static String PRIMITIVE = "primitive: ";
    private static String CHAR = "char: ";
    public static String getFormatMessage(MetaMessage message) {
        if (message instanceof IntMessage) {
            return Formatter.PRIMITIVE + ((IntMessage) message).content;
        } else if (message instanceof ByteMessage) {
            return Formatter.PRIMITIVE + ((ByteMessage) message).content;
        } else if (message instanceof CharMessage) {
            return (Formatter.CHAR + ((CharMessage) message).content);
        }

        return "";
    }
}
