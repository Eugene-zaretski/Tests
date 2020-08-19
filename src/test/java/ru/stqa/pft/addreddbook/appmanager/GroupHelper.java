package ru.stqa.pft.addreddbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addreddbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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

    public void deleteGroup(String delete) {
        click(By.name(delete));
    }

  /* public void selectGroup(String s) {
        click(By.name(s));
    }*/

    public void selectGroup(int index){
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void initGroupEdit(String edit) {
        click(By.name(edit));
    }

    public void submitGroupEdit(String update) {
        click(By.name(update));
    }

    public void createGroup(GroupData group) {
        initGroupCreation("new");
        fillGroupForm(group);
        submitGroupCreation("submit");
        returnToGroupPage("group page");
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }
    public List<GroupData> getGroupList() {                  // получение списка
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
             int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData(id, name, null, null);
            groups.add(group);
        }
        return groups;
    }

}

