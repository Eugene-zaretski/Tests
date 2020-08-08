package ru.stqa.pft.addreddbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addreddbook.model.ContactData;


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

