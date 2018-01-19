package br.com.santander.devguide.rdbms;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyAppTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public final void testMain() throws IOException {
        MyApp.main(new String[0]);
    }
}
