package ru.stqa.pft.addreddbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addreddbook.model.ContactData;
import ru.stqa.pft.addreddbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver driver) {

        super(driver);
    }

    /*public void returnToContactPage(String s) {
        click(By.linkText(s));
    }*/

    public void submitContactCreation(String submit) {

        click(By.name(submit));
    }

    public void fillContactForm(ContactData contactData) {
        type(contactData.getFirstname(), By.name("firstname"));
        type(contactData.getMiddlename(), By.name("middlename"));
        type(contactData.getLastname(), By.name("lastname"));


    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

   /*public List<GroupData> getGroupList() {                  // получение списка
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            GroupData group = new GroupData(name, null, null);
            groups.add(group);
        }
        return groups;
    }

/*
    public void initContactCreation(String s) {
        click(By.name(s));
    }

    public void deleteGroup(String delete) {
        click(By.name(delete));
    }

    public void selectGroup(String s) {
        click(By.name(s));
    }


    public void initGroupEdit(String edit) {
        click(By.name(edit));
    }

    public void submitGroupEdit(String update) {
        click(By.name(update));
    }

    /*public void createGroup(GroupData group) {
        initGroupCreation("new");
        fillGroupForm(group);
        submitGroupCreation("submit");
        returnToGroupPage("group page");
    }*/

  /*  public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }*/
}

