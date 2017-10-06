package com.acme.edu;

import java.io.IOException;

/**
 * Класс Logger призван логгировать сообщения, при этом он должен выполнять следующие оперкации:
 *      в случае с численными типами - подаем на принтер, в добавок складываем, при смене типа, выводим результат, если
 * число выходило за границу значения своего типа, необходимо вывести количество выходов за границу + остаток без потери
 * значения суммы, вывод граничных значений произовдить построчно.
 *      в случае строк - он подсчитывает количество одинаковых строк, при смене типа, если строки были одинаковыми,
 * выставляет эту строку в единственном экземпляре с указанием количества, сколько раз встречалась эта строка.
 *      в случае булевых типов - просто выводит значение, поданое на вход с казанием префикса - примитив.
 *      в случае чаров - просто выводит значение, с указанием того, что поданое значение является char.
 *      в случае, если подан целочисленный массив - выводит массив в виде {n1, n2, ...., nk} с указанием префикса - примитив.
 */
public class Logger {
    private static LoggerController controller = new LoggerController();

    public static void log(int message) throws PrintException, NullMessageException {
        controller.processMessage(new IntMessage(message));
    }

    public static void log(byte message) throws PrintException, NullMessageException {
        controller.processMessage(new ByteMessage(message));
    }

    public static void log(char message) throws PrintException, NullMessageException {
        controller.processMessage(new CharMessage(message));
    }

    public static void log(String message) throws PrintException, NullMessageException {
        controller.processMessage(new StringMessage(message));
    }

    public static void log(Boolean message) throws PrintException, NullMessageException {
        controller.processMessage(new BooleanMessage(message));
    }

    public static void log(int[] message) throws PrintException, NullMessageException {
        controller.processMessage(new IntArrayMessage(message));
    }

//    public static void log() throws PrintException, NullMessageException {
//            throw new NullMessageException("Illegal argument: message", new IllegalArgumentException());
//    }

    public static void close() throws PrintException, IOException {
        controller.flushBuffer();
    }
}
