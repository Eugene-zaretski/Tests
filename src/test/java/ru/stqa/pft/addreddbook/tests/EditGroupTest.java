package ru.stqa.pft.addreddbook.tests;

import org.junit.Test;
import ru.stqa.pft.addreddbook.model.GroupData;


public class EditGroupTest extends TestBase {

    @Test
    public void testEditGroup() {
        app.getNavigationHelper().gotoGroupPage("GROUPS");
        app.getGroupHelper().selectGroup("selected[]");
        app.getGroupHelper().initGroupEdit("edit"); // надо написать метод для отчистки поля
        app.getGroupHelper().fillGroupForm(new GroupData("new name", "qwerty-test", "asd-test"));
        app.getGroupHelper().submitGroupEdit("update");
        app.getGroupHelper().returnToGroupPage("group page");


    }
}
