package ru.stqa.pft.addreddbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addreddbook.model.ContactData;
import ru.stqa.pft.addreddbook.model.GroupData;
import ru.stqa.pft.addreddbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
        type(contactData.getPhone_home(), By.name("home"));
        type(contactData.getPhone_mobile(), By.name("mobile"));
        type(contactData.getPhone_work(), By.name("work"));

    }


    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

  /*  public void modifyContact(ContactData contact) {           // баг в приложении , не работает модификация в приложении
        selectContactById(contact.getId());
        //initGroupEdit("edit"); // надо написать метод для отчистки поля
        fillContactForm(contact);
        submitModifiedContact("update");
        //groupCache = null;
        // returnToGroupPage("group page");
    }*/

    private void submitModifiedContact(String update) {
        click(By.name(update));

    }

    public void selectContactById(int id) {
        driver.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();

    }

    public Set<ContactData> all() {                  // получение списка
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> rows = driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cell = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cell.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cell.get(1).getText();
            String firstname = cell.get(2).getText();
           String allPhones = cell.get(5).getText();
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withAllPhones(allPhones));
          /* String[] phones = cell.get(5).getText().split("\n");  // один из вариантов, когда не склеиваем строку; 5- т.к. нумерация начинается с 0 в таблице -
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
            .withPhone_home(phones[0]).withPhone_mobile(phones[1]).withPhone_work(phones[2]));*/
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        selectContactById(contact.getId());
        String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
        String home = driver.findElement(By.name("home")).getAttribute("value");
        String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
        String work = driver.findElement(By.name("work")).getAttribute("value");
        driver.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withPhone_home(home).withPhone_mobile(mobile).withPhone_work(work);
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

