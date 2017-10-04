package com.acme.edu;

public class Formatter {
    private static String PRIMITIVE = "primitive: ";
    private static String CHAR = "char: ";
    private static String STRING = "string: ";
    private static String PRIMITIVES_ARRAY = "primitives array: ";

    public static String getFormatMessage(MetaMessage message) {
        if (message instanceof IntMessage) {
            return Formatter.PRIMITIVE + ((IntMessage) message).content;
        } else if (message instanceof ByteMessage) {
            return Formatter.PRIMITIVE + ((ByteMessage) message).content;
        } else if (message instanceof CharMessage) {
            return (Formatter.CHAR + ((CharMessage) message).content);
        } else if (message instanceof StringMessage) {
            if(((StringMessage) message).countRepeat > 1) {
                return (Formatter.STRING + ((StringMessage) message).content + " (x" + (((StringMessage) message).countRepeat) + ")");
            } else if(((StringMessage) message).countRepeat == 1){
                return (Formatter.STRING + ((StringMessage) message).content);
            }
        } else if (message instanceof BooleanMessage) {
            return (Formatter.PRIMITIVE + ((BooleanMessage) message).content);
        } else if (message instanceof IntArrayMessage) {
            return FormatIntArray(((IntArrayMessage) message).content);
        }
        return "";
    }

    private static String FormatIntArray(int [] array) {
        String result = Formatter.PRIMITIVES_ARRAY + "{";
        for (int i = 0; i < array.length - 1; i++) {
            result += array[i] + ", ";
        }
        return result + array[array.length-1] + "}";
    }
}
