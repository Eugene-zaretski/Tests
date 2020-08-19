package ru.stqa.pft.addreddbook.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.stqa.pft.addreddbook.model.GroupData;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class EditGroupTest extends TestBase {

    @Test
    public void testEditGroup() {
        app.getNavigationHelper().gotoGroupPage("GROUPS");
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test", null, null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupEdit("edit"); // надо написать метод для отчистки поля
        app.getGroupHelper().fillGroupForm(new GroupData("new", "xer-tam", "test-tutut"));
        app.getGroupHelper().submitGroupEdit("update");
        app.getGroupHelper().returnToGroupPage("group page");
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());




    }
    @Test
    public void testEditGroup1() {
        app.getNavigationHelper().gotoGroupPage("GROUPS");
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test", null, null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupEdit("edit"); // надо написать метод для отчистки поля
        GroupData group = new GroupData(before.get(before.size() - 1).getId(),"test", "test2", "test3");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupEdit("update");
        app.getGroupHelper().returnToGroupPage("group page");
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() -1);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);

    }
}
