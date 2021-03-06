package ru.stqa.pft.addreddbook.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addreddbook.appmanager.ApplicationManager;


public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @Before
    public void setUp() throws Exception {
        app.init();

    }

    @After
    public void tearDown() {
        app.stop();
    }

}
