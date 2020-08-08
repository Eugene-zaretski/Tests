package ru.stqa.pft.addreddbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);

    }

    public void gotoGroupPage(String groups) {
        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new")))
        {
            return;
        }
        click(By.linkText(groups));
    }
    public void gotoHomePage(){
        if (isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));
    }

   public void gotoContactPage(String groups) {
        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("EDIT_ADD_ENTRY"))
               // && isElementPresent(By.name("new")))
        {
            return;
        }
        click(By.linkText(groups));
    }


}


  /*  public void gotoGroupPage(String groups) {
        click(By.linkText(groups));
        //driver.findElement(By.linkText(groups)).click();

        isElementPresent(ByTagName("h1"))
                && driver.findElement(By.tagName("h1").getText
                && isElementPresent(By.name("new")));
        {

    } */

