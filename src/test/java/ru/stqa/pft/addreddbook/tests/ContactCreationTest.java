package ru.stqa.pft.addreddbook.tests;

import org.junit.Assert;
import org.junit.Test;

import ru.stqa.pft.addreddbook.model.ContactData;


public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreate() {
        int before = app.getContactHelper().getContactCount();
        app.goTo().contactPage("ADD_NEW");
        app.getContactHelper().fillContactForm(
                new ContactData()
                        .withFirstname("new test").withLastname("test").withMiddlename("test")
                        .withPhone_home("123").withPhone_mobile("6564035").withPhone_work("999"));
        app.getContactHelper().submitContactCreation("submit");
        app.goTo().homePage("home page");
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before + 1);
        // app.getGroupHelper().returnToGroupPage("group page");
        // app.logout("LOGOUT");*/

    }

}

