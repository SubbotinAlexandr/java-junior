package com.acme.edu;

public class LoggerController {
    private static LoggerState currenStateLogger = LoggerState.noneState;
    private MetaMessage message;
   // private final Accumulator byteAccumulator;
   // private final Accumulator charAccumulator;
    private Accumulator intAccumulator;
   // private final Accumulator stringAccumulator;
   // private final Accumulator arrayAccumulator;
   // private final Accumulator booleanAccumulator;
    public LoggerController(Object arg) {
        message = new MetaMessage(arg);
        System.out.println("test");
        if (arg instanceof Integer)
        {
            System.out.println("int: " + arg);
        }
//        System.out.println("arg: " + arg.getClass() );
        //System.out.println("TypeMsg: " + message.getTypeMessage(message) + System.lineSeparator() + "ContentMsg: " + message.getMessage(message));
//        System.out.println(message);
//        if (currenStateLogger.equals(LoggerState.intState)) {
//            System.out.println("Предыдущее значение было интом: " + message);
//        }
//        currenStateLogger = LoggerState.intState;
    }
}
