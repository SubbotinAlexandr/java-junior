package com.acme.edu;

public class LoggerController {
    private static LoggerState currenStateLogger = LoggerState.noneState;
   // private final Accumulator byteAccumulator;
   // private final Accumulator charAccumulator;
    private Accumulator intAccumulator;
   // private final Accumulator stringAccumulator;
   // private final Accumulator arrayAccumulator;
   // private final Accumulator booleanAccumulator;
    public LoggerController(int message) {
        System.out.println(message);
        if (currenStateLogger.equals(LoggerState.intState)) {
            System.out.println("Предыдущее значение было интом: " + message);
        }
        currenStateLogger = LoggerState.intState;
    }
}
