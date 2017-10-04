package com.acme.edu;

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
    public static void log(int message) {
        controller.setController(new IntMessage(message));
    }
    public static void log(byte message) {
        controller.setController(new ByteMessage(message));
    }

    public static void log(char message) {
        controller.setController(new CharMessage(message));
    }

    public static void log(String message) {
        controller.setController(new StringMessage(message));
    }

    public static void log(Boolean message) {
        controller.setController(new BooleanMessage(message));
    }

    public static void log(int[] message) {
        controller.setController(new IntArrayMessage(message));
    }

    public static void close() {
        controller.flushBuffer();
    }
}
