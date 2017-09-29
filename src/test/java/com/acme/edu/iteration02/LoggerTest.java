package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion


    /*
    TODO: implement Logger solution to match specification as tests
    */
    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        //endregion

        //region then
        assertSysoutContains("str 1" + System.lineSeparator());
        assertSysoutContains("3" + System.lineSeparator());
        assertSysoutContains("str 2" + System.lineSeparator());
        assertSysoutContains("0" + System.lineSeparator());
        //endregion
    }//Суммируем числа, которые идут после подачи строки, содержащей str
    //Должны ли работать старые тесты? Да, но надо их подправить, чтобы по ним проходила
    //программа
    //0 должен арифмитически суммироваться, т.е. не влиять на результат
    //последний вывод нуля показывает то, что раньше использовался другой тип
/**/
    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        //endregion

        //region then
        assertSysoutContains("str 1" + System.lineSeparator());
        assertSysoutContains("10" + System.lineSeparator());
        assertSysoutContains(Integer.MAX_VALUE  + "" + System.lineSeparator());
        assertSysoutContains("str 2" + System.lineSeparator());
        assertSysoutContains("0" + System.lineSeparator());
        //endregion
    }//Суммируем числа, как в прошлом тесте, но перед этим проверяем, не выходит ли за границы
    //Если не влезает, тогда надо вывести, что числа не влезает, что у нас нет переполнения
    //
/*
    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log((byte)Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        //endregion

        //region then
        assertSysoutEquals(
            "str 1" + System.lineSeparator() +
            "10" + System.lineSeparator() +
            Byte.MAX_VALUE + "" + System.lineSeparator() +
            "str 2" + System.lineSeparator() +
            "0" + System.lineSeparator()
        );// тоже самое что прошлый тест, только с байтами
        //endregion
    }//накидываем интеджеры и начинаем выходить за границы, не хотим терять интеджеры
    //наш логгер не должен терять ничего, выводить остаток и количество, сколько раз у нас
    //вывелось макс числа + остаток
*/
    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log(0);
        //endregion

        //region then
        assertSysoutContains("str 1" + System.lineSeparator());
        assertSysoutContains("str 2 (x2)" + System.lineSeparator());
        assertSysoutContains("0" + System.lineSeparator());
        assertSysoutContains("str 2" + System.lineSeparator());
        assertSysoutContains("str 3 (x3)" + System.lineSeparator());
        //Надо выводить строку без повторений, но выводить множитель встречи этой подстроки
        //в строке(сколько раз встречается) при встрече 0 обнулять полученную строку.
        //endregion
    }

    /**/
}