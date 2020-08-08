package ru.stqa.pft.addreddbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    protected WebDriver driver;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private String browser;
    //JavascriptExecutor js;

    public ApplicationManager(String browser) {
        this.browser = browser;

    }

    public void init() {
        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
        //String browser = BrowserType.FIREFOX;
        if (browser == BrowserType.FIREFOX) {
            driver = new FirefoxDriver();
        } else if (browser == BrowserType.CHROME) {
            driver = new ChromeDriver();
        }
        //js = (JavascriptExecutor) driver;
        //Map<String, Object> vars = new HashMap<String, Object>();
        driver.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin", "secret");

    }


    public void stop() {
        driver.quit();
    }

    public void logout(String logout) {
        driver.findElement(By.linkText(logout)).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
