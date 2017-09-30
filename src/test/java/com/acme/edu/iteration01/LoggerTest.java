package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import com.acme.edu.ProcedureLogger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

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
    @Test
    public void test() throws IOException {
        //region when
       /* ProcedureLogger.log('a');
        Logger.log('b');
        Logger.log('c');
        Logger.log('d');
        Logger.log((int) 4);
        Logger.log((int) 5);
        Logger.log((int) 6);*/
        //endregion

        //region then
        //assertSysoutEquals("7");
        //assertSysoutContains("a");
        //assertSysoutContains("b");
        //endregion
    }
/*
    @Test
    public void shouldLogInteger() throws IOException {
        //region when
        Logger.log(1);
        Logger.log(0);
        Logger.log(-1);
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("primitive: 1" + System.lineSeparator());
        assertSysoutContains("primitive: 0" + System.lineSeparator());
        assertSysoutContains("primitive: -1" + System.lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        Logger.log((byte)1);
        Logger.log((byte)0);
        Logger.log((byte)-1);
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }

    /*
    TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogChar() throws IOException {
        //region when
        Logger.log('a');
        Logger.log('b');
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        //region when
        Logger.log("test string 1");
        Logger.log("other str");
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        Logger.log(true);
        Logger.log(false);
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        //region when
        Logger.log(new Object());
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }

    */
@Test
public void shouldProcedureLogInteger() throws IOException {
    //region when
    ProcedureLogger.log(1);
    ProcedureLogger.log(0);
    ProcedureLogger.log(-1);
    //endregion

    //region then
    assertSysoutContains("primitive: ");
    assertSysoutContains("primitive: 1" + System.lineSeparator());
    assertSysoutContains("primitive: 0" + System.lineSeparator());
    assertSysoutContains("primitive: -1" + System.lineSeparator());
    //endregion
}

    @Test
    public void shouldProcedureLogByte() throws IOException {
        //region when
        ProcedureLogger.log((byte)1);
        ProcedureLogger.log((byte)0);
        ProcedureLogger.log((byte)-1);
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }

    /*
    TODO: implement ProcedureLogger solution to match specification as tests
    */
    @Test
    public void shouldProcedureLogChar() throws IOException {
        //region when
        ProcedureLogger.log('a');
        ProcedureLogger.log('b');
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldProcedureLogString() throws IOException {
        //region when
        ProcedureLogger.log("test string 1");
        ProcedureLogger.log("other str");
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }

    @Test
    public void shouldProcedureLogBoolean() throws IOException {
        //region when
        ProcedureLogger.log(true);
        ProcedureLogger.log(false);
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }
/*
    @Test
    public void shouldProcedureLogReference() throws IOException {
        //region when
        ProcedureLogger.log(new Object());
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }
*/
}