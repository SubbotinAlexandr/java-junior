package com.acme.edu;

/**
 * Класс Logger призван логгировать сообщения, при этом он должен суммировать одинаковые типы данных,
 *      в случае с численными типами - подаем на принтер, в добавок складываем, при смене типа, выводим результат, если
 * число выходило за границу значения своего типа, необходимо вывести количество выходов за границу + остаток без потери
 * значения суммы, вывод граничных значений произовдить построчно.
 *      в случае строк - он подсчитывает количество одинаковых строк, при смене типа, если строки были одинаковыми,
 * выставляет эту строку в единственном экземпляре с указанием количества, сколько раз встречалась эта строка.
 */
public class Logger {
    private static LoggerController loggerController;
    private static MetaMessage extendMessage;
//    public static <T> void log(T message) {               //Незбывшаяся мечта
//        loggerController = new LoggerController(message);
//    }
    public static void log(int message) {
        extendMessage = new MetaMessage(message);
    }
    public static void log(byte message) {
        extendMessage = new MetaMessage(message);
    }
    public static void log(char message) {
        extendMessage = new MetaMessage(message);
    }
    public static void log(boolean message) {
        extendMessage = new MetaMessage(message);
    }
    public static void log(String message) {
        extendMessage = new MetaMessage(message);
    }
    public static void log(int [] message) {
        extendMessage = new MetaMessage(message);
    }
        //
    public static void main(String[] args) {
        Logger.log(3);
        Logger.log((byte)3);
        Logger.log("str");
        Logger.log('c');
        int test[] = {1,2,3};
        Logger.log(test);
    }

}
