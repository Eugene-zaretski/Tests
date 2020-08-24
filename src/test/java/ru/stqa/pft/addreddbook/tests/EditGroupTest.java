package ru.stqa.pft.addreddbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import ru.stqa.pft.addreddbook.model.GroupData;
import ru.stqa.pft.addreddbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;


public class EditGroupTest extends TestBase {

    /*@BeforeMethod                     //  подумать как это сделать чтобы работало?????
    public void ensurePrecondition(){
        app.getNavigationHelper().gotoGroupPage("GROUPS");
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test", null, null));
        }
    }*/

    @Test
    public void testEditGroup() {
        app.goTo().groupPage("GROUPS");
        if (app.group().list().size() == 0){
            app.group().create(new GroupData().withName("test"));
        }
        List<GroupData> before = app.group().list();
       int index = before.size() - 1;
        GroupData group = new GroupData()
                .withId(before.get(index).getId()).withName("test_old").withHeader("test2_old").withFooter("test3_old");
       // app.group().modifyGroup(before.size() - 1, new GroupData("new", "xer-tam", "test-tutut"));
        app.group().modifyGroup(group);
        List<GroupData> after = app.group().list();
        assertEquals(after.size(), before.size());




    }
    @Test   // верный тест
    public void testEditGroup1() {
       app.goTo().groupPage("GROUPS");
        if (app.group().list().size() == 0){
            app.group().create(new GroupData().withName("test"));
        }
        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("test").withHeader("test2").withFooter("test3");
        app.group().modifyGroup(group);
        Groups after = app.group().all();
        assertEquals(after.size(), before.size());

       /* before.remove(modifiedGroup);
        before.add(group);
       /* Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId()); // сортировка
        before.sort(byId);
        after.sort(byId);
        assertEquals(before,after);*/
        assertThat(after, CoreMatchers.equalTo(before.without(modifiedGroup).withAdded(group)));

    }


}
