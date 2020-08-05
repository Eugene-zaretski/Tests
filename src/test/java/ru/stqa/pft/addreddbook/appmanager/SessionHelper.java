package ru.stqa.pft.addreddbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver driver) {
        super(driver);

    }

    public void login(/*CharSequence*/ String username, String password) {

        type(username, By.name("user"));
        type(password, By.name("pass"));
        click(By.cssSelector("input:nth-child(7)"));

    }
}
