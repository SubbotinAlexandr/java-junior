package com.acme.edu;

import java.io.IOException;

/**
 * Класс LoggerController выполняет функцию контроллера, его задача сводится к функции processMessage - к проверке:
 *  Если сообщение появилось первый раз и до него не было никаких сообщений, тогда мы запускаем фильтрацию сообщения самому от себя
 *  Если пришедшее сообщение не перове, тогда мы подаем на фильтр предыдущего сообщения наге текущее сообщение
 * Далее просто переставляем ссылку с предыдущего сообщения на текущее.
 *  Функция flushBuffer предназначена для сброса буфера при смене типа, при вызове функции close и т.д.
 */
public class LoggerController {
    private MetaMessage message;

    public void processMessage(MetaMessage message) throws PrintException, NullMessageException {
        try {
            if(this.message == null && message != null) {
                    message.filter(message);
            }
            if (message != null && this.message != null) {
                this.message.filter(message);
            }
        } catch (Exception e) {
            throw new PrintException("Не удалось вывести сообщение, посколько возникла ошибка при выводе!", e);
        }
        this.message = message;
    }

    public void flushBuffer () throws PrintException, IOException {
        //try {
            this.message.flushBuffer();
        //} catch (Exception e) {
        //    throw new PrintException("Не удалось вывести сообщение", e);
        //}
    }
}
