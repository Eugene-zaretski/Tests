package ru.stqa.pft.addreddbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(locator).sendKeys(name);
    }

    /*public boolean isAlertPresent(){
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e){
            return false;
        }
    }*/
}
