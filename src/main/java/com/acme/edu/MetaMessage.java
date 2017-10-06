package com.acme.edu;

import java.io.IOException;

/**
 * Интерфейс для сущности сообщения, которая выполняет 2 операции:
 *  1. Фильтрация самого себя, на основе своего типа, количества повторений сообщений такого типа и т.д.
 *  2. Сброс буфера сообщения, в случае если это необходимо(смена типа, вызов процедуры закрытия и т.д.)
 */
public interface MetaMessage {
    Printer printer = new ConsolePrinter();
    void filter(MetaMessage message) throws PrintException;
    void flushBuffer() throws PrintException;
}
