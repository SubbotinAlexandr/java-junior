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
    public static LoggerController controller = new LoggerController();
    public static void log(int message) {
        controller.setController(new IntMessage(message));
        controller.getBuff();
        //System.out.println("Ok" + Logger.message.getContent());
    }
    public static void log(byte message) {
        controller.setController(new ByteMessage(message));
        controller.getBuff();
        //System.out.println("Ok" + Logger.message.getContent());
    }
    public static void log(char message) {
        controller.setController(new CharMessage(message));
        controller.getBuff();
        //System.out.println("Ok" + Logger.message.getContent());
    }
    public static void log(String message) {
        controller.setController(new StringMessage(message));
        controller.getBuff();
        //System.out.println("Ok" + Logger.message.getContent());
    }
    public static void close() {
        controller.flushBuffer();
    }

    void getBuff() {

    }
    public static void main(String[] args) {
        MetaMessage msg;
        Logger.log((byte)2);
        Logger.log((byte)3);
        Logger.log((byte)4);
        Logger.log((byte)1);
        Logger.log(5);
        Logger.log(6);
        Logger.close();
        //Logger.close();
        //Logger.log(1);
        //Logger.log('c');
        //Logger.log(-1);
        //Logger.log(Integer.MIN_VALUE);
        //Logger.log(Integer.MIN_VALUE);
    }
}
