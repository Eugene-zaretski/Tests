package ru.stqa.pft.addreddbook.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.stqa.pft.addreddbook.model.GroupData;


public class EditGroupTest extends TestBase {

    @Test
    public void testEditGroup() {
        app.getNavigationHelper().gotoGroupPage("GROUPS");
        int before = app.getGroupHelper().getGroupCount();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test", null, null));
        }
        app.getGroupHelper().selectGroup("selected[]");
        app.getGroupHelper().initGroupEdit("edit"); // надо написать метод для отчистки поля
        app.getGroupHelper().fillGroupForm(new GroupData("new", "xer-tam", "test-tutut"));
        app.getGroupHelper().submitGroupEdit("update");
        app.getGroupHelper().returnToGroupPage("group page");
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before);


    }
}
