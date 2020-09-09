package ru.stqa.pft.addreddbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class HelperBase {
    protected WebDriver driver;

    public HelperBase(WebDriver driver) {

        this.driver = driver;
    }

    protected void click(By name) {
        driver.findElement(name).click();
    }

    protected void type(String name, By locator) {
        click(locator);
        if (name != null) {
            String existingName = driver.findElement(locator).getAttribute("value"); // если поля одинаковые
            if (!name.equals(existingName)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(name);

            }
        }
      /*  driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(name);*/
    }

    protected void attach(By locator, File file) {

        if (file != null) {

                driver.findElement(locator).sendKeys(file.getAbsolutePath());


        }

    }

    public boolean isAlertPresent() { // для перехвата исключений
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
