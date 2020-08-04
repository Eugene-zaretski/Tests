package ru.stqa.pft.addreddbook.tests;

import org.junit.After;
import org.junit.Before;
import ru.stqa.pft.addreddbook.appmanager.ApplicationManager;


public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @Before
    public void setUp() {
        app.init();

    }

    @After
    public void tearDown() {
        app.stop();
    }

}
