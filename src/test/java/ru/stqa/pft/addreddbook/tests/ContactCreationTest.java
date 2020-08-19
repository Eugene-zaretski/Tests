package ru.stqa.pft.addreddbook.tests;

import org.junit.Assert;
import org.junit.Test;

import ru.stqa.pft.addreddbook.model.ContactData;


public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreate() {
        int before = app.getContactHelper().getContactCount();
        app.getNavigationHelper().gotoContactPage("ADD_NEW");
        app.getContactHelper().fillContactForm(new ContactData("test", "test", "test"));
        app.getContactHelper().submitContactCreation("submit");
        app.getNavigationHelper().gotoHomePage("home page");
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before + 1);
        // app.getGroupHelper().returnToGroupPage("group page");
        // app.logout("LOGOUT");*/

    }

}

