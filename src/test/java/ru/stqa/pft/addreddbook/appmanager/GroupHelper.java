package ru.stqa.pft.addreddbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addreddbook.model.GroupData;
import ru.stqa.pft.addreddbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {

        super(driver);
    }

    public void returnToGroupPage(String s) {
        click(By.linkText(s));
    }

    public void submitGroupCreation(String submit) {
        click(By.name(submit));
    }

    public void fillGroupForm(GroupData groupData) {
        type(groupData.getName(), By.name("group_name"));
        type(groupData.getHeader(), By.name("group_header"));
        type(groupData.getFooter(), By.name("group_footer"));
       /* driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
       /* driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());*/

    }


    public void initGroupCreation(String s) {
        click(By.name(s));
    }

    public void delete(String delete) {
        click(By.name(delete));
    }

  /* public void selectGroup(String s) {
        click(By.name(s));
    }*/

    public void select(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectGroupById(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }


    public void initGroupEdit(String edit) {
        click(By.name(edit));
    }

    public void submitGroupEdit(String update) {
        click(By.name(update));
    }

    public void create(GroupData group) {
        initGroupCreation("new");
        fillGroupForm(group);
        submitGroupCreation("submit");
        groupCache = null;
        returnToGroupPage("group page");
    }

   /* private void create(GroupData group) {
        app.group().initGroupCreation("new");
        app.group().fillGroupForm(group);
        app.group().submitGroupCreation("submit");
        app.group().returnToGroupPage("group page");
    }*/

    public void modifyGroup(GroupData group) {
        selectGroupById(group.getId());
        initGroupEdit("edit"); // надо написать метод для отчистки поля
        fillGroupForm(group);
        submitGroupEdit("update");
        groupCache = null;
        returnToGroupPage("group page");
    }

    public void delete(int index) {
        select(index);
        delete("delete");
        returnToGroupPage("group page");
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        delete("delete");
        groupCache = null;  // сброс кэша
        returnToGroupPage("group page");
    }


    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> list() {                  // получение списка
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            // GroupData group = new GroupData().withId(id).withName(name);
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }

    private Groups groupCache = null;  // кэширование, для ускорения работы

    public Groups all() {                  // получение списка
        if (groupCache != null){
            return new Groups(groupCache);
        }

        groupCache = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            // GroupData group = new GroupData().withId(id).withName(name);
            groupCache.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCache);
    }


}


