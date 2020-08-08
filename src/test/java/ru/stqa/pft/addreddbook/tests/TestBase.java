package ru.stqa.pft.addreddbook.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.BrowserType;
import ru.stqa.pft.addreddbook.appmanager.ApplicationManager;


public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @Before
    public void setUp() {
        app.init();

    }

    @After
    public void tearDown() {
        app.stop();
    }

}
