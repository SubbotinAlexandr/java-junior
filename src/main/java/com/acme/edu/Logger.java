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
    public static MetaMessage message;
    public static LoggerController controller;
    public static void log(int message) {
        Logger.message = new IntMessage(message);
        controller = new LoggerController(Logger.message);
        controller.getBuff();
        //System.out.println("Ok" + Logger.message.getContent());
    }

    public static void main(String[] args) {
        MetaMessage msg;
        Logger.log(3);
        Logger.log(5);
        Logger.log(6);
    }
}
