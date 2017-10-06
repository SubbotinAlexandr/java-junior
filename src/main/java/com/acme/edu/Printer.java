package com.acme.edu;

import java.io.IOException;

/**
 * Класс Printer призван производить вывод, куда - не важно, пока сделали функцию printToConsole для вывода в консоль.
 */
public interface Printer {
   void print(String message) throws PrintException;
}
